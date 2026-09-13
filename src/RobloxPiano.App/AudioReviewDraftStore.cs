using System.Globalization;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using RobloxPiano.Audio;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal sealed record AudioReviewDraftNote(
    long StartTicks,
    long EndTicks,
    int MidiNote,
    float Amplitude,
    int[] PitchBendsThirdSemitones);

internal sealed record AudioReviewDraftEvent(
    long StartTicks,
    long DurationTicks,
    string Keys);

internal sealed record AudioReviewDraftTrack(
    string Title,
    double Bpm,
    int Subdivision,
    long StartDelayTicks,
    long TimelineDurationTicks,
    AudioReviewDraftEvent[] Events);

internal sealed record AudioReviewDraftDocument(
    int SchemaVersion,
    string SourcePath,
    string SourceSha256,
    string EvidenceSha256,
    long SourceDurationTicks,
    AudioReviewDraftNote[] Notes,
    AudioReviewDraftTrack OriginalTrack,
    AudioTranscriptionQualityAssessment BaseQuality,
    AudioReviewQueuePersistedState Queue,
    string CurrentTrackSha256,
    string? SelectedRegionKey,
    DateTimeOffset SavedAtUtc);

internal sealed record AudioReviewDraftRestoreResult(
    AudioTranscriptionReviewRepairSession RepairSession,
    AudioReviewQueue ReviewQueue,
    int SelectedRegionIndex,
    string SourcePath,
    DateTimeOffset SavedAtUtc,
    TimeSpan SourceDuration,
    IReadOnlyList<BasicPitchTranscribedNote> SourceNotes,
    PerformanceTrack OriginalTrack,
    AudioTranscriptionQualityAssessment BaseQuality,
    string DraftPath);

internal sealed record AudioReviewSourceIdentity(
    string Path,
    long Length,
    long LastWriteTimeUtcTicks,
    string Sha256);

/// <summary>
/// Durable, local-only checkpoint for Audio-to-Piano review work. The checkpoint deliberately does not deserialize
/// a repaired PerformanceTrack as playback truth. Restore rebuilds a fresh repair session from immutable Basic Pitch
/// note evidence plus the original canonical track, replays explicit repair decisions deterministically, then requires
/// the rebuilt current-track SHA-256 to equal the saved fingerprint before exposing the draft.
/// </summary>
internal sealed class AudioReviewDraftStore
{
    public const int SchemaVersion = 1;
    private const long MaximumDraftBytes = 32L * 1024L * 1024L;
    private const int MaximumNotes = 250_000;
    private const int MaximumEvents = 500_000;
    private const int MaximumDiscoveryCandidates = 256;
    private static readonly JsonSerializerOptions JsonOptions = new(JsonSerializerDefaults.Web)
    {
        WriteIndented = false
    };

    private readonly string rootDirectory;
    private readonly object sourceIdentityGate = new();
    private readonly Dictionary<string, AudioReviewSourceIdentity> sourceIdentities = new(StringComparer.OrdinalIgnoreCase);
    private long sourceHashComputationCount;

    public AudioReviewDraftStore(string rootDirectory)
    {
        if (string.IsNullOrWhiteSpace(rootDirectory))
            throw new ArgumentException("Draft root directory is required.", nameof(rootDirectory));
        this.rootDirectory = Path.GetFullPath(rootDirectory);
    }

    internal long SourceHashComputationCount => Interlocked.Read(ref sourceHashComputationCount);

    public async Task<string> SaveAsync(
        string sourcePath,
        TimeSpan sourceDuration,
        IReadOnlyList<BasicPitchTranscribedNote> sourceNotes,
        PerformanceTrack originalTrack,
        AudioTranscriptionQualityAssessment baseQuality,
        AudioTranscriptionReviewRepairSession repairSession,
        AudioReviewQueue reviewQueue,
        AudioTranscriptionReviewRegion? selectedRegion = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        if (sourceDuration <= TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(sourceDuration));
        ArgumentNullException.ThrowIfNull(sourceNotes);
        ArgumentNullException.ThrowIfNull(originalTrack);
        ArgumentNullException.ThrowIfNull(baseQuality);
        ArgumentNullException.ThrowIfNull(repairSession);
        ArgumentNullException.ThrowIfNull(reviewQueue);
        if (sourceNotes.Count == 0 || sourceNotes.Count > MaximumNotes)
            throw new InvalidDataException($"Review draft note evidence must contain between 1 and {MaximumNotes} notes.");
        if (originalTrack.Events.Count > MaximumEvents)
            throw new InvalidDataException($"Review draft original track exceeds the {MaximumEvents}-event safety bound.");

        var normalizedSourcePath = Path.GetFullPath(sourcePath);
        var sourceIdentity = await ResolveSourceIdentityAsync(
            normalizedSourcePath,
            forceFullHash: false,
            requireCachedContentMatch: true,
            cancellationToken).ConfigureAwait(false);
        var sourceSha256 = sourceIdentity.Sha256;
        var evidenceSha256 = ComputeEvidenceSha256(sourceDuration, sourceNotes, originalTrack, baseQuality);
        var currentTrackSha256 = PerformanceTrackFingerprint.ComputeSha256(repairSession.CurrentTrack);
        var document = new AudioReviewDraftDocument(
            SchemaVersion,
            normalizedSourcePath,
            sourceSha256,
            evidenceSha256,
            sourceDuration.Ticks,
            sourceNotes.Select(ToDraftNote).ToArray(),
            ToDraftTrack(originalTrack),
            baseQuality,
            reviewQueue.ExportState(),
            currentTrackSha256,
            selectedRegion is null ? null : AudioReviewQueue.GetRegionKey(selectedRegion),
            DateTimeOffset.UtcNow);

        Directory.CreateDirectory(rootDirectory);
        var draftPath = GetDraftPath(sourceSha256);
        var tempPath = draftPath + ".tmp-" + Guid.NewGuid().ToString("N", CultureInfo.InvariantCulture);
        try
        {
            await using (var stream = new FileStream(
                tempPath,
                FileMode.CreateNew,
                FileAccess.Write,
                FileShare.None,
                bufferSize: 64 * 1024,
                options: FileOptions.Asynchronous | FileOptions.WriteThrough))
            {
                await JsonSerializer.SerializeAsync(stream, document, JsonOptions, cancellationToken).ConfigureAwait(false);
                await stream.FlushAsync(cancellationToken).ConfigureAwait(false);
                stream.Flush(flushToDisk: true);
            }

            var writtenLength = new FileInfo(tempPath).Length;
            if (writtenLength <= 0 || writtenLength > MaximumDraftBytes)
                throw new InvalidDataException($"Review draft size {writtenLength} bytes is outside the allowed bound.");
            File.Move(tempPath, draftPath, overwrite: true);
            return draftPath;
        }
        finally
        {
            TryDelete(tempPath);
        }
    }

    /// <summary>
    /// Locates the most relevant draft for an owned/local source without trusting it. The exact current source hash is
    /// the fast path. If the source bytes changed in-place, a bounded metadata scan can still surface the older draft so
    /// RestoreAsync can reject it with an explicit source-changed error instead of silently pretending no draft exists.
    /// </summary>
    public async Task<string?> FindForSourceAsync(
        string sourcePath,
        CancellationToken cancellationToken = default)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        var normalizedSourcePath = Path.GetFullPath(sourcePath);
        if (!File.Exists(normalizedSourcePath) || !Directory.Exists(rootDirectory))
            return null;

        var currentSourceIdentity = await ResolveSourceIdentityAsync(
            normalizedSourcePath,
            forceFullHash: false,
            requireCachedContentMatch: false,
            cancellationToken).ConfigureAwait(false);
        var exactPath = GetDraftPath(currentSourceIdentity.Sha256);
        if (File.Exists(exactPath))
            return exactPath;

        var candidates = new DirectoryInfo(rootDirectory)
            .EnumerateFiles("*.review.json", SearchOption.TopDirectoryOnly)
            .Where(file => file.Length > 0 && file.Length <= MaximumDraftBytes)
            .OrderByDescending(file => file.LastWriteTimeUtc)
            .Take(MaximumDiscoveryCandidates)
            .ToArray();

        foreach (var candidate in candidates)
        {
            cancellationToken.ThrowIfCancellationRequested();
            try
            {
                var document = await ReadDocumentAsync(candidate.FullName, cancellationToken).ConfigureAwait(false);
                if (document is not null
                    && !string.IsNullOrWhiteSpace(document.SourcePath)
                    && string.Equals(Path.GetFullPath(document.SourcePath), normalizedSourcePath, StringComparison.OrdinalIgnoreCase))
                {
                    return candidate.FullName;
                }
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException or JsonException or ArgumentException)
            {
                // Discovery never trusts malformed checkpoints. Restore remains the authority for a selected candidate.
            }
        }

        return null;
    }

    public async Task<AudioReviewDraftRestoreResult> RestoreAsync(
        string draftPath,
        CancellationToken cancellationToken = default)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(draftPath);
        var normalizedDraftPath = NormalizeOwnedDraftPath(draftPath);
        var fileInfo = new FileInfo(normalizedDraftPath);
        if (!fileInfo.Exists)
            throw new FileNotFoundException("Audio review draft was not found.", normalizedDraftPath);
        if (fileInfo.Length <= 0 || fileInfo.Length > MaximumDraftBytes)
            throw new InvalidDataException("Audio review draft is empty or exceeds the safety bound.");

        var document = await ReadDocumentAsync(normalizedDraftPath, cancellationToken).ConfigureAwait(false);
        if (document is null)
            throw new InvalidDataException("Audio review draft could not be decoded.");
        ValidateDocument(document);

        var sourcePath = Path.GetFullPath(document.SourcePath);
        var actualSourceIdentity = await ResolveSourceIdentityAsync(
            sourcePath,
            forceFullHash: true,
            requireCachedContentMatch: false,
            cancellationToken).ConfigureAwait(false);
        if (!string.Equals(actualSourceIdentity.Sha256, document.SourceSha256, StringComparison.OrdinalIgnoreCase))
            throw new InvalidDataException("Owned/local source audio changed after this review draft was saved. Regenerate instead of restoring stale review state.");

        var sourceDuration = TimeSpan.FromTicks(document.SourceDurationTicks);
        var notes = document.Notes.Select(FromDraftNote).ToArray();
        var originalTrack = FromDraftTrack(document.OriginalTrack);
        var evidenceSha256 = ComputeEvidenceSha256(sourceDuration, notes, originalTrack, document.BaseQuality);
        if (!string.Equals(evidenceSha256, document.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
            throw new InvalidDataException("Audio review draft evidence fingerprint does not match its persisted evidence.");

        var repairSession = new AudioTranscriptionReviewRepairSession(
            sourceDuration,
            notes,
            originalTrack,
            baseQuality: document.BaseQuality,
            cancellationToken: cancellationToken);

        foreach (var decision in document.Queue.AppliedDecisions)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var region = repairSession.ReviewRegions.SingleOrDefault(candidate =>
                string.Equals(AudioReviewQueue.GetRegionKey(candidate), decision.RegionKey, StringComparison.Ordinal));
            if (region is null)
                throw new InvalidDataException("A saved repair decision is stale under the current deterministic repair contract. Regenerate instead of guessing.");
            repairSession.Apply(region, decision.Kind, cancellationToken);
        }

        var rebuiltTrackSha256 = PerformanceTrackFingerprint.ComputeSha256(repairSession.CurrentTrack);
        if (!string.Equals(rebuiltTrackSha256, document.CurrentTrackSha256, StringComparison.OrdinalIgnoreCase))
            throw new InvalidDataException("Replayed review decisions did not reproduce the saved canonical track fingerprint. Regenerate instead of restoring divergent playback truth.");

        var reviewQueue = new AudioReviewQueue();
        reviewQueue.RestoreState(repairSession.ReviewRegions, document.Queue);
        var selectedIndex = ResolveSelectedRegionIndex(repairSession.ReviewRegions, document.SelectedRegionKey, reviewQueue);
        return new AudioReviewDraftRestoreResult(
            repairSession,
            reviewQueue,
            selectedIndex,
            sourcePath,
            document.SavedAtUtc,
            sourceDuration,
            notes,
            originalTrack,
            document.BaseQuality,
            normalizedDraftPath);
    }

    public bool Delete(string draftPath)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(draftPath);
        var normalizedDraftPath = NormalizeOwnedDraftPath(draftPath);
        if (!File.Exists(normalizedDraftPath))
            return false;
        File.Delete(normalizedDraftPath);
        return true;
    }

    public string GetDraftPath(string sourceSha256)
    {
        if (!IsSha256(sourceSha256))
            throw new ArgumentException("Expected a lowercase or uppercase SHA-256 hex digest.", nameof(sourceSha256));
        return Path.Combine(rootDirectory, sourceSha256.ToLowerInvariant() + ".review.json");
    }

    internal static string ComputeEvidenceSha256(
        TimeSpan sourceDuration,
        IReadOnlyList<BasicPitchTranscribedNote> sourceNotes,
        PerformanceTrack originalTrack,
        AudioTranscriptionQualityAssessment baseQuality)
    {
        ArgumentNullException.ThrowIfNull(sourceNotes);
        ArgumentNullException.ThrowIfNull(originalTrack);
        ArgumentNullException.ThrowIfNull(baseQuality);
        using var hash = IncrementalHash.CreateHash(HashAlgorithmName.SHA256);
        Append(hash, "audio-review-evidence-v1\n");
        Append(hash, $"sourceTicks={sourceDuration.Ticks.ToString(CultureInfo.InvariantCulture)}\n");
        Append(hash, $"track={PerformanceTrackFingerprint.ComputeSha256(originalTrack)}\n");
        Append(hash, $"quality={baseQuality.Readiness}|{R(baseQuality.RetentionRatio)}|{R(baseQuality.TransformLossRatio)}|{R(baseQuality.LowActivationRatio)}|{R(baseQuality.OctaveFoldRatio)}|{R(baseQuality.TimelineCoverage)}|{R(baseQuality.EventsPerSecond)}|{R(baseQuality.HarmonicSuppressionRatio)}|{baseQuality.MeanActivation.ToString("R", CultureInfo.InvariantCulture)}\n");
        foreach (var reason in baseQuality.Reasons.Where(value => !string.IsNullOrWhiteSpace(value)).Distinct(StringComparer.Ordinal).OrderBy(value => value, StringComparer.Ordinal))
            Append(hash, $"reason={reason}\n");
        foreach (var note in sourceNotes.OrderBy(value => value.Start).ThenBy(value => value.MidiNote).ThenBy(value => value.End).ThenByDescending(value => value.Amplitude))
        {
            Append(hash, $"note={note.Start.Ticks}:{note.End.Ticks}:{note.MidiNote}:{note.Amplitude.ToString("R", CultureInfo.InvariantCulture)}:");
            foreach (var bend in note.PitchBendsThirdSemitones)
                Append(hash, bend.ToString(CultureInfo.InvariantCulture) + ",");
            Append(hash, "\n");
        }
        return Convert.ToHexString(hash.GetHashAndReset()).ToLowerInvariant();
    }

    private async Task<AudioReviewSourceIdentity> ResolveSourceIdentityAsync(
        string path,
        bool forceFullHash,
        bool requireCachedContentMatch,
        CancellationToken cancellationToken)
    {
        var normalizedPath = Path.GetFullPath(path);
        var currentInfo = GetRequiredFileInfo(normalizedPath);
        AudioReviewSourceIdentity? cached;
        lock (sourceIdentityGate)
            sourceIdentities.TryGetValue(normalizedPath, out cached);

        if (!forceFullHash
            && cached is not null
            && cached.Length == currentInfo.Length
            && cached.LastWriteTimeUtcTicks == currentInfo.LastWriteTimeUtc.Ticks)
        {
            return cached;
        }

        var verified = await ComputeStableSourceIdentityAsync(normalizedPath, cancellationToken).ConfigureAwait(false);
        if (requireCachedContentMatch
            && cached is not null
            && !string.Equals(cached.Sha256, verified.Sha256, StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidDataException("Owned/local source audio changed during this review session. Regenerate instead of checkpointing stale review state.");
        }

        lock (sourceIdentityGate)
            sourceIdentities[normalizedPath] = verified;
        return verified;
    }

    private async Task<AudioReviewSourceIdentity> ComputeStableSourceIdentityAsync(
        string path,
        CancellationToken cancellationToken)
    {
        for (var attempt = 0; attempt < 2; attempt++)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var before = GetRequiredFileInfo(path);
            var sha256 = await ComputeFileSha256Async(path, cancellationToken).ConfigureAwait(false);
            var after = GetRequiredFileInfo(path);
            if (before.Length == after.Length && before.LastWriteTimeUtc.Ticks == after.LastWriteTimeUtc.Ticks)
                return new AudioReviewSourceIdentity(path, after.Length, after.LastWriteTimeUtc.Ticks, sha256);
        }

        throw new IOException("Owned/local source audio changed while its identity was being verified. Retry or regenerate before checkpointing review state.");
    }

    private static FileInfo GetRequiredFileInfo(string path)
    {
        var fileInfo = new FileInfo(path);
        if (!fileInfo.Exists)
            throw new FileNotFoundException("Owned/local source audio was not found.", path);
        return fileInfo;
    }

    private async Task<AudioReviewDraftDocument?> ReadDocumentAsync(string path, CancellationToken cancellationToken)
    {
        var fileInfo = new FileInfo(path);
        if (!fileInfo.Exists || fileInfo.Length <= 0 || fileInfo.Length > MaximumDraftBytes)
            throw new InvalidDataException("Audio review draft is empty or exceeds the safety bound.");
        await using var stream = new FileStream(
            path,
            FileMode.Open,
            FileAccess.Read,
            FileShare.Read,
            bufferSize: 64 * 1024,
            options: FileOptions.Asynchronous | FileOptions.SequentialScan);
        return await JsonSerializer.DeserializeAsync<AudioReviewDraftDocument>(stream, JsonOptions, cancellationToken)
            .ConfigureAwait(false);
    }

    private string NormalizeOwnedDraftPath(string draftPath)
    {
        var normalized = Path.GetFullPath(draftPath);
        var root = rootDirectory.TrimEnd(Path.DirectorySeparatorChar, Path.AltDirectorySeparatorChar) + Path.DirectorySeparatorChar;
        if (!normalized.StartsWith(root, StringComparison.OrdinalIgnoreCase)
            || !normalized.EndsWith(".review.json", StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidDataException("Audio review draft path is outside the managed local draft directory.");
        }
        return normalized;
    }

    private async Task<string> ComputeFileSha256Async(string path, CancellationToken cancellationToken)
    {
        Interlocked.Increment(ref sourceHashComputationCount);
        await using var stream = new FileStream(
            path,
            FileMode.Open,
            FileAccess.Read,
            FileShare.Read,
            bufferSize: 128 * 1024,
            options: FileOptions.Asynchronous | FileOptions.SequentialScan);
        using var hash = IncrementalHash.CreateHash(HashAlgorithmName.SHA256);
        var buffer = new byte[128 * 1024];
        while (true)
        {
            var read = await stream.ReadAsync(buffer, cancellationToken).ConfigureAwait(false);
            if (read == 0)
                break;
            hash.AppendData(buffer, 0, read);
        }
        return Convert.ToHexString(hash.GetHashAndReset()).ToLowerInvariant();
    }

    private static void ValidateDocument(AudioReviewDraftDocument document)
    {
        if (document.SchemaVersion != SchemaVersion)
            throw new InvalidDataException($"Unsupported audio review draft schema {document.SchemaVersion}.");
        if (string.IsNullOrWhiteSpace(document.SourcePath) || !IsSha256(document.SourceSha256) || !IsSha256(document.EvidenceSha256) || !IsSha256(document.CurrentTrackSha256))
            throw new InvalidDataException("Audio review draft identity fields are malformed.");
        if (document.SourceDurationTicks <= 0)
            throw new InvalidDataException("Audio review draft source duration is invalid.");
        if (document.Notes is null || document.Notes.Length == 0 || document.Notes.Length > MaximumNotes)
            throw new InvalidDataException("Audio review draft note evidence is missing or exceeds the safety bound.");
        if (document.OriginalTrack is null || document.OriginalTrack.Events is null || document.OriginalTrack.Events.Length > MaximumEvents)
            throw new InvalidDataException("Audio review draft original track is missing or exceeds the safety bound.");
        ArgumentNullException.ThrowIfNull(document.BaseQuality);
        ArgumentNullException.ThrowIfNull(document.Queue);
        ArgumentNullException.ThrowIfNull(document.Queue.AppliedDecisions);
        ArgumentNullException.ThrowIfNull(document.Queue.DeferredRegionKeys);
    }

    private static int ResolveSelectedRegionIndex(
        IReadOnlyList<AudioTranscriptionReviewRegion> regions,
        string? selectedRegionKey,
        AudioReviewQueue queue)
    {
        if (!string.IsNullOrWhiteSpace(selectedRegionKey))
        {
            for (var index = 0; index < regions.Count; index++)
            {
                if (string.Equals(AudioReviewQueue.GetRegionKey(regions[index]), selectedRegionKey, StringComparison.Ordinal))
                    return index;
            }
        }
        return queue.FindNextPendingIndex(regions, 0) ?? 0;
    }

    private static AudioReviewDraftNote ToDraftNote(BasicPitchTranscribedNote note)
        => new(note.Start.Ticks, note.End.Ticks, note.MidiNote, note.Amplitude, note.PitchBendsThirdSemitones.ToArray());

    private static BasicPitchTranscribedNote FromDraftNote(AudioReviewDraftNote note)
        => new(TimeSpan.FromTicks(note.StartTicks), TimeSpan.FromTicks(note.EndTicks), note.MidiNote, note.Amplitude, note.PitchBendsThirdSemitones ?? []);

    private static AudioReviewDraftTrack ToDraftTrack(PerformanceTrack track)
        => new(
            track.Title,
            track.Bpm,
            track.Subdivision,
            track.StartDelay.Ticks,
            track.TimelineDuration.Ticks,
            track.Events.Select(value => new AudioReviewDraftEvent(value.Start.Ticks, value.Duration.Ticks, new string(value.Keys.ToArray()))).ToArray());

    private static PerformanceTrack FromDraftTrack(AudioReviewDraftTrack track)
    {
        if (string.IsNullOrWhiteSpace(track.Title) || !double.IsFinite(track.Bpm) || track.Bpm <= 0d || track.Subdivision <= 0 || track.StartDelayTicks < 0 || track.TimelineDurationTicks < 0)
            throw new InvalidDataException("Audio review draft original track metadata is invalid.");
        var events = track.Events.Select(value =>
        {
            if (value.StartTicks < 0 || value.DurationTicks <= 0 || string.IsNullOrEmpty(value.Keys))
                throw new InvalidDataException("Audio review draft contains an invalid performance event.");
            return new PerformanceEvent(TimeSpan.FromTicks(value.StartTicks), TimeSpan.FromTicks(value.DurationTicks), value.Keys.ToCharArray());
        }).ToArray();
        return new PerformanceTrack(track.Title, track.Bpm, track.Subdivision, TimeSpan.FromTicks(track.StartDelayTicks), events, TimeSpan.FromTicks(track.TimelineDurationTicks));
    }

    private static bool IsSha256(string value)
        => value.Length == 64 && value.All(Uri.IsHexDigit);

    private static string R(double value) => value.ToString("R", CultureInfo.InvariantCulture);

    private static void Append(IncrementalHash hash, string value)
        => hash.AppendData(Encoding.UTF8.GetBytes(value));

    private static void TryDelete(string path)
    {
        try
        {
            if (File.Exists(path))
                File.Delete(path);
        }
        catch (IOException)
        {
        }
        catch (UnauthorizedAccessException)
        {
        }
    }
}