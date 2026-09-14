namespace RobloxPiano.Audio;

public enum AudioToPianoClientJobState
{
    Idle,
    Running,
    Completed,
    Cancelled,
    Failed
}

public sealed record AudioToPianoClientJobSnapshot(
    AudioToPianoClientJobState State,
    AudioToPianoTranscriptionStage? Stage,
    double Fraction,
    string Message,
    string? SourcePath,
    string? ErrorMessage)
{
    public bool IsTerminal => State is AudioToPianoClientJobState.Completed
        or AudioToPianoClientJobState.Cancelled
        or AudioToPianoClientJobState.Failed;
}

public sealed record AudioToPianoClientJobResult(
    AudioToPianoClientJobState State,
    AudioToPianoTranscriptionResult? Transcription,
    string? ErrorMessage)
{
    public bool Succeeded => State == AudioToPianoClientJobState.Completed && Transcription is not null;
}

/// <summary>
/// Production boundary for a client-facing Create Piano Version operation.
/// It owns job lifetime, progress and cancellation only. The deterministic transcription service
/// remains authoritative for generated notes and the canonical PerformanceTrack.
/// </summary>
public sealed class AudioToPianoClientJob : IDisposable
{
    private readonly object gate = new();
    private CancellationTokenSource? activeCancellation;
    private AudioToPianoClientJobSnapshot snapshot = new(
        AudioToPianoClientJobState.Idle,
        null,
        0d,
        "Choose an owned/local audio file to create a piano version.",
        null,
        null);
    private bool disposed;

    public AudioToPianoClientJobSnapshot Snapshot
    {
        get
        {
            lock (gate)
                return snapshot;
        }
    }

    public bool IsRunning => Snapshot.State == AudioToPianoClientJobState.Running;

    public async Task<AudioToPianoClientJobResult> RunAsync(
        string sourcePath,
        string? title = null,
        AudioToPianoTranscriptionOptions? options = null,
        IProgress<AudioToPianoClientJobSnapshot>? progress = null,
        CancellationToken cancellationToken = default)
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);

        var fullPath = Path.GetFullPath(sourcePath);
        if (!File.Exists(fullPath))
            throw new FileNotFoundException("The selected audio file does not exist.", fullPath);

        CancellationTokenSource linked;
        lock (gate)
        {
            if (activeCancellation is not null)
                throw new InvalidOperationException("A piano creation job is already running.");

            linked = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken);
            activeCancellation = linked;
            snapshot = new(
                AudioToPianoClientJobState.Running,
                AudioToPianoTranscriptionStage.Ingest,
                0d,
                "Preparing audio locally...",
                fullPath,
                null);
        }
        progress?.Report(Snapshot);

        try
        {
            if (!BasicPitchBundledModel.IsAvailable)
                throw new InvalidOperationException("This build does not contain the pinned Basic Pitch model required by Create Piano Version.");

            PublishMonotonic(
                new AudioToPianoClientJobSnapshot(
                    AudioToPianoClientJobState.Running,
                    AudioToPianoTranscriptionStage.Ingest,
                    0d,
                    "Loading the local Basic Pitch model...",
                    fullPath,
                    null),
                progress);

            var modelPath = BasicPitchBundledModel.MaterializeToDefaultCache();
            using var service = new AudioToPianoTranscriptionService(modelPath);

            PublishMonotonic(
                new AudioToPianoClientJobSnapshot(
                    AudioToPianoClientJobState.Running,
                    AudioToPianoTranscriptionStage.Ingest,
                    0d,
                    "Local piano model ready. Decoding audio...",
                    fullPath,
                    null),
                progress);

            var bridge = new InlineProgress<AudioToPianoTranscriptionProgress>(value =>
            {
                var next = new AudioToPianoClientJobSnapshot(
                    AudioToPianoClientJobState.Running,
                    value.Stage,
                    value.Fraction,
                    value.Message,
                    fullPath,
                    null);
                PublishMonotonic(next, progress);
            });

            var result = await Task.Run(
                () => service.TranscribeFile(
                    fullPath,
                    title ?? Path.GetFileNameWithoutExtension(fullPath),
                    options,
                    bridge,
                    linked.Token),
                CancellationToken.None).ConfigureAwait(false);

            linked.Token.ThrowIfCancellationRequested();
            var diagnostics = result.Diagnostics;
            var quality = diagnostics.Quality;
            var reviewSummary = FormatReviewSummary(diagnostics.ReviewRegions);
            var completed = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Completed,
                AudioToPianoTranscriptionStage.Completed,
                1d,
                diagnostics.RequiresReview
                    ? $"Piano version created — {quality.Readiness}. {reviewSummary} Preview these regions before adding it to your library."
                    : "Piano version created — Ready for preview and library review.",
                fullPath,
                null);
            PublishTerminal(completed, progress);
            return new(AudioToPianoClientJobState.Completed, result, null);
        }
        catch (OperationCanceledException) when (linked.IsCancellationRequested)
        {
            var cancelled = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Cancelled,
                Snapshot.Stage,
                Snapshot.Fraction,
                "Piano creation cancelled. No generated track was added or played.",
                fullPath,
                null);
            PublishTerminal(cancelled, progress);
            return new(AudioToPianoClientJobState.Cancelled, null, null);
        }
        catch (Exception exception) when (IsRecoverableClientFailure(exception))
        {
            var errorMessage = FormatClientFailure(exception);
            var failed = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Failed,
                Snapshot.Stage,
                Snapshot.Fraction,
                "Piano version could not be created. The application can continue safely.",
                fullPath,
                errorMessage);
            PublishTerminal(failed, progress);
            return new(AudioToPianoClientJobState.Failed, null, errorMessage);
        }
        finally
        {
            lock (gate)
            {
                if (ReferenceEquals(activeCancellation, linked))
                    activeCancellation = null;
            }
            linked.Dispose();
        }
    }

    public bool Cancel()
    {
        lock (gate)
        {
            if (activeCancellation is null || activeCancellation.IsCancellationRequested)
                return false;
            activeCancellation.Cancel();
            return true;
        }
    }

    private void PublishMonotonic(
        AudioToPianoClientJobSnapshot next,
        IProgress<AudioToPianoClientJobSnapshot>? progress)
    {
        lock (gate)
        {
            if (snapshot.State != AudioToPianoClientJobState.Running)
                return;
            if (next.Fraction < snapshot.Fraction)
                throw new InvalidDataException($"Audio-to-Piano progress regressed from {snapshot.Fraction:0.###} to {next.Fraction:0.###}.");
            snapshot = next;
        }
        progress?.Report(next);
    }

    private void PublishTerminal(
        AudioToPianoClientJobSnapshot terminal,
        IProgress<AudioToPianoClientJobSnapshot>? progress)
    {
        lock (gate)
        {
            if (snapshot.State != AudioToPianoClientJobState.Running)
                return;
            if (terminal.State == AudioToPianoClientJobState.Completed && terminal.Fraction != 1d)
                throw new InvalidDataException("Completed Audio-to-Piano jobs must report 100% progress.");
            snapshot = terminal;
        }
        progress?.Report(terminal);
    }

    private static bool IsRecoverableClientFailure(Exception exception) => exception is
        IOException
        or UnauthorizedAccessException
        or InvalidDataException
        or ArgumentException
        or InvalidOperationException
        or OverflowException
        or NotSupportedException
        or TypeInitializationException
        or DllNotFoundException
        or BadImageFormatException
        or Microsoft.ML.OnnxRuntime.OnnxRuntimeException
        or NAudio.MmException;

    private static string FormatClientFailure(Exception exception) => exception switch
    {
        Microsoft.ML.OnnxRuntime.OnnxRuntimeException =>
            $"The local Basic Pitch model failed during inference: {exception.Message}",
        NAudio.MmException =>
            $"The selected audio could not be decoded locally: {exception.Message}",
        DllNotFoundException or BadImageFormatException or TypeInitializationException =>
            $"The local audio/model runtime could not start correctly: {exception.Message}",
        _ => exception.Message
    };

    private static string FormatReviewSummary(IReadOnlyList<AudioTranscriptionReviewRegion> regions)
    {
        if (regions.Count == 0)
            return "Deterministic quality checks require review.";

        const int maximumRanges = 3;
        var ranges = regions
            .Take(maximumRanges)
            .Select(region => $"{FormatTime(region.Start)}–{FormatTime(region.End)}")
            .ToArray();
        var remainder = regions.Count - ranges.Length;
        return remainder > 0
            ? $"Review {regions.Count} flagged regions: {string.Join(", ", ranges)} (+{remainder} more)."
            : $"Review {regions.Count} flagged region(s): {string.Join(", ", ranges)}.";
    }

    private static string FormatTime(TimeSpan value)
        => value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");

    public void Dispose()
    {
        if (disposed)
            return;
        disposed = true;
        Cancel();
    }

    private sealed class InlineProgress<T>(Action<T> callback) : IProgress<T>
    {
        public void Report(T value) => callback(value);
    }
}
