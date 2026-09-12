using RobloxPiano.Core;

namespace RobloxPiano.Library;

public sealed record OnlineSongReferenceVerificationResult(
    SongDiscoveryCandidate Candidate,
    ReferenceAudioTimelineAlignment Alignment,
    ReferenceCandidateAssessment Assessment,
    string? ImportCompatibilitySummary);

public sealed record OnlineSongReferenceVerificationFailure(
    SongDiscoveryCandidate Candidate,
    string Error);

public sealed record OnlineSongReferenceVerificationBatchResult(
    IReadOnlyList<ReferenceVerifiedSongCandidate> RankedVerifiedCandidates,
    IReadOnlyList<OnlineSongReferenceVerificationFailure> Failures,
    int AttemptedCount);

/// <summary>
/// Downloads discovery candidates into isolated temporary directories, parses them through
/// the production canonical song loader, and scores them against immutable reference-audio
/// evidence without adding anything to the Library.
/// </summary>
public sealed class OnlineSongReferenceVerificationService
{
    private readonly HttpClient _httpClient;
    private readonly string _temporaryDirectory;

    public OnlineSongReferenceVerificationService(
        HttpClient httpClient,
        string? temporaryDirectory = null)
    {
        _httpClient = httpClient ?? throw new ArgumentNullException(nameof(httpClient));
        _temporaryDirectory = Path.GetFullPath(
            temporaryDirectory ?? Path.Combine(Path.GetTempPath(), "RobloxPiano", "reference-verification"));
    }

    public async Task<OnlineSongReferenceVerificationBatchResult> VerifyBatchAsync(
        IEnumerable<SongDiscoveryCandidate> candidates,
        ReferenceAudioAnalysis reference,
        int maxCandidates = 5,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(candidates);
        ArgumentNullException.ThrowIfNull(reference);
        if (maxCandidates is <= 0 or > 10)
            throw new ArgumentOutOfRangeException(nameof(maxCandidates), "Batch verification supports between 1 and 10 candidates.");

        cancellationToken.ThrowIfCancellationRequested();
        var bounded = candidates
            .Where(candidate => candidate is not null)
            .GroupBy(CandidateIdentity, StringComparer.Ordinal)
            .Select(group => group.First())
            .Take(maxCandidates)
            .ToArray();

        var verified = new List<ReferenceVerifiedSongCandidate>(bounded.Length);
        var failures = new List<OnlineSongReferenceVerificationFailure>();
        foreach (var candidate in bounded)
        {
            cancellationToken.ThrowIfCancellationRequested();
            try
            {
                var result = await VerifyAsync(candidate, reference, cancellationToken).ConfigureAwait(false);
                verified.Add(new ReferenceVerifiedSongCandidate(result.Candidate, result.Assessment));
            }
            catch (OperationCanceledException) when (cancellationToken.IsCancellationRequested)
            {
                throw;
            }
            catch (Exception exception) when (IsCandidateFailure(exception))
            {
                failures.Add(new OnlineSongReferenceVerificationFailure(candidate, exception.Message));
            }
        }

        var ranked = verified.Count == 0
            ? Array.Empty<ReferenceVerifiedSongCandidate>()
            : ReferenceVerifiedSongRanker.Rank(verified, verified.Count);
        return new OnlineSongReferenceVerificationBatchResult(ranked, failures, bounded.Length);
    }

    public async Task<OnlineSongReferenceVerificationResult> VerifyAsync(
        SongDiscoveryCandidate candidate,
        ReferenceAudioAnalysis reference,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(candidate);
        ArgumentNullException.ThrowIfNull(reference);
        OnlineSongImportService.ValidateDownloadUri(candidate.ProviderId, candidate.DownloadUri);
        cancellationToken.ThrowIfCancellationRequested();

        Directory.CreateDirectory(_temporaryDirectory);
        var operationDirectory = Path.Combine(_temporaryDirectory, Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(operationDirectory);
        var extension = candidate.DownloadUri.AbsolutePath.EndsWith(".midi", StringComparison.OrdinalIgnoreCase)
            ? ".midi"
            : ".mid";
        var temporary = Path.Combine(operationDirectory, "candidate" + extension);

        try
        {
            using var request = SongDiscoveryHttp.CreateGet(candidate.DownloadUri);
            using var response = await _httpClient.SendAsync(
                request,
                HttpCompletionOption.ResponseHeadersRead,
                cancellationToken).ConfigureAwait(false);
            response.EnsureSuccessStatusCode();

            var finalUri = response.RequestMessage?.RequestUri ?? candidate.DownloadUri;
            OnlineSongImportService.ValidateDownloadUri(candidate.ProviderId, finalUri);
            if (response.Content.Headers.ContentLength is > OnlineSongImportService.MaximumDownloadBytes)
                throw new FormatException("This online MIDI is too large to verify safely.");

            await DownloadBoundedAsync(response.Content, temporary, cancellationToken).ConfigureAwait(false);
            var loaded = await SongSourceLoader.LoadAsync(temporary, cancellationToken).ConfigureAwait(false);
            if (loaded.SourceKind != SongSourceKind.Midi)
                throw new InvalidDataException("Reference verification requires a MIDI discovery candidate.");

            var alignment = ReferenceAudioTimelineAligner.Align(reference, loaded.Track, playbackSpeed: 1d);
            var assessment = ReferenceCandidateConfidencePolicy.Assess(alignment);
            return new OnlineSongReferenceVerificationResult(
                candidate,
                alignment,
                assessment,
                loaded.Metadata?.Summary);
        }
        finally
        {
            TryDeleteDirectory(operationDirectory);
        }
    }

    private static string CandidateIdentity(SongDiscoveryCandidate candidate)
        => string.Join("|", candidate.ProviderId, candidate.ContentIdentity ?? string.Empty, candidate.DownloadUri.AbsoluteUri);

    private static bool IsCandidateFailure(Exception exception)
        => exception is HttpRequestException
            or IOException
            or UnauthorizedAccessException
            or FormatException
            or InvalidDataException
            or InvalidOperationException
            or NotSupportedException
            or OverflowException;

    private static async Task DownloadBoundedAsync(
        HttpContent content,
        string destinationPath,
        CancellationToken cancellationToken)
    {
        await using var source = await content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false);
        await using var destination = new FileStream(
            destinationPath,
            FileMode.CreateNew,
            FileAccess.Write,
            FileShare.None,
            81920,
            useAsync: true);

        var buffer = new byte[81920];
        long total = 0;
        while (true)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var read = await source.ReadAsync(buffer, cancellationToken).ConfigureAwait(false);
            if (read == 0)
                break;

            total = checked(total + read);
            if (total > OnlineSongImportService.MaximumDownloadBytes)
                throw new FormatException("This online MIDI is too large to verify safely.");

            await destination.WriteAsync(buffer.AsMemory(0, read), cancellationToken).ConfigureAwait(false);
        }

        if (total == 0)
            throw new FormatException("The online MIDI download was empty.");
    }

    private static void TryDeleteDirectory(string path)
    {
        try
        {
            if (Directory.Exists(path))
                Directory.Delete(path, recursive: true);
        }
        catch
        {
            // Temporary cleanup is best-effort and must not hide the verification result/error.
        }
    }
}
