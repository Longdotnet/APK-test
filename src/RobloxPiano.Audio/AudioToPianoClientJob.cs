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
/// Client-facing execution boundary for Create Piano Version.
///
/// The deterministic Audio-to-Piano service remains authoritative for transcription and canonical
/// PerformanceTrack creation. This class only owns UI-safe job lifetime: one active creation at a time,
/// monotonic progress snapshots, cooperative cancellation and fail-visible terminal state. It does not
/// schedule Roblox input and it never mutates a generated track after the transcription service returns.
/// </summary>
public sealed class AudioToPianoClientJob : IDisposable
{
    private readonly object gate = new();
    private readonly Func<AudioToPianoTranscriptionService> serviceFactory;
    private CancellationTokenSource? activeCancellation;
    private AudioToPianoClientJobSnapshot snapshot = new(
        AudioToPianoClientJobState.Idle,
        null,
        0d,
        "Choose an owned/local audio file to create a piano version.",
        null,
        null);
    private bool disposed;

    public AudioToPianoClientJob()
        : this(CreateBundledService)
    {
    }

    internal AudioToPianoClientJob(Func<AudioToPianoTranscriptionService> serviceFactory)
    {
        this.serviceFactory = serviceFactory ?? throw new ArgumentNullException(nameof(serviceFactory));
    }

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

        CancellationTokenSource linkedCancellation;
        lock (gate)
        {
            if (activeCancellation is not null)
                throw new InvalidOperationException("A piano creation job is already running.");

            linkedCancellation = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken);
            activeCancellation = linkedCancellation;
            snapshot = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Running,
                AudioToPianoTranscriptionStage.Ingest,
                0d,
                "Preparing audio...",
                fullPath,
                null);
        }
        progress?.Report(Snapshot);

        try
        {
            using var service = serviceFactory();
            var transcriptionProgress = new InlineProgress<AudioToPianoTranscriptionProgress>(value =>
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
                    transcriptionProgress,
                    linkedCancellation.Token),
                CancellationToken.None).ConfigureAwait(false);

            linkedCancellation.Token.ThrowIfCancellationRequested();
            var completed = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Completed,
                AudioToPianoTranscriptionStage.Completed,
                1d,
                BuildCompletionMessage(result),
                fullPath,
                null);
            PublishTerminal(completed, progress);
            return new AudioToPianoClientJobResult(AudioToPianoClientJobState.Completed, result, null);
        }
        catch (OperationCanceledException) when (linkedCancellation.IsCancellationRequested)
        {
            var cancelled = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Cancelled,
                Snapshot.Stage,
                Snapshot.Fraction,
                "Piano creation cancelled. No generated track was added or played.",
                fullPath,
                null);
            PublishTerminal(cancelled, progress);
            return new AudioToPianoClientJobResult(AudioToPianoClientJobState.Cancelled, null, null);
        }
        catch (Exception exception) when (exception is IOException
            or UnauthorizedAccessException
            or InvalidDataException
            or ArgumentException
            or InvalidOperationException)
        {
            var failed = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Failed,
                Snapshot.Stage,
                Snapshot.Fraction,
                "Piano version could not be created.",
                fullPath,
                exception.Message);
            PublishTerminal(failed, progress);
            return new AudioToPianoClientJobResult(AudioToPianoClientJobState.Failed, null, exception.Message);
        }
        finally
        {
            lock (gate)
            {
                if (ReferenceEquals(activeCancellation, linkedCancellation))
                    activeCancellation = null;
            }
            linkedCancellation.Dispose();
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
                throw new InvalidDataException(
                    $"Audio-to-Piano client progress regressed from {snapshot.Fraction:0.###} to {next.Fraction:0.###}.");
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
                throw new InvalidDataException("Completed Audio-to-Piano client jobs must report 100% progress.");
            snapshot = terminal;
        }
        progress?.Report(terminal);
    }

    private static string BuildCompletionMessage(AudioToPianoTranscriptionResult result)
    {
        var quality = result.Diagnostics.Quality;
        return quality.RequiresReview
            ? $"Piano version created — {quality.Classification}. Review flagged regions before adding it to your library."
            : "Piano version created — Ready for preview and library review.";
    }

    private static AudioToPianoTranscriptionService CreateBundledService()
    {
        if (!BasicPitchBundledModel.IsAvailable)
            throw new InvalidOperationException(
                "This build does not contain the pinned Basic Pitch model required by Create Piano Version.");
        var modelPath = BasicPitchBundledModel.MaterializeToDefaultCache();
        return new AudioToPianoTranscriptionService(modelPath);
    }

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
