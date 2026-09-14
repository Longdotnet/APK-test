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
/// It owns job lifetime, progress, cancellation and per-attempt diagnostics only. The deterministic
/// transcription service remains authoritative for generated notes and the canonical PerformanceTrack.
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
        using var diagnostic = AudioToPianoDiagnostics.Start(fullPath, title);
        diagnostic.Write("job-created", $"diagnosticLog={diagnostic.LogPath}");

        if (!File.Exists(fullPath))
        {
            var missing = new FileNotFoundException("The selected audio file does not exist.", fullPath);
            diagnostic.WriteFailure(missing, Snapshot, "preflight-failure");
            var missingMessage = WithDiagnosticLog(missing.Message, diagnostic.LogPath);
            return new(AudioToPianoClientJobState.Failed, null, missingMessage);
        }

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
        diagnostic.WriteProgress(Snapshot);
        progress?.Report(Snapshot);

        try
        {
            linked.Token.ThrowIfCancellationRequested();
            if (!BasicPitchBundledModel.IsAvailable)
                throw new InvalidOperationException("This build does not contain the pinned Basic Pitch model required by Create Piano Version.");

            var loading = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Running,
                AudioToPianoTranscriptionStage.Ingest,
                0d,
                "Loading the local Basic Pitch model...",
                fullPath,
                null);
            diagnostic.WriteProgress(loading);
            PublishMonotonic(loading, progress);

            var modelPath = BasicPitchBundledModel.MaterializeToDefaultCache();
            diagnostic.Write(
                "model-ready",
                $"bytes={new FileInfo(modelPath).Length}; pinnedIdentity={BasicPitchBundledModel.HasExpectedIdentity(modelPath)}");
            using var service = new AudioToPianoTranscriptionService(modelPath);

            var decoding = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Running,
                AudioToPianoTranscriptionStage.Ingest,
                0d,
                "Local piano model ready. Decoding audio...",
                fullPath,
                null);
            diagnostic.WriteProgress(decoding);
            PublishMonotonic(decoding, progress);

            var bridge = new InlineProgress<AudioToPianoTranscriptionProgress>(value =>
            {
                var next = new AudioToPianoClientJobSnapshot(
                    AudioToPianoClientJobState.Running,
                    value.Stage,
                    value.Fraction,
                    value.Message,
                    fullPath,
                    null);
                diagnostic.WriteProgress(next);
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
            diagnostic.WriteCompleted(diagnostics);
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
            diagnostic.WriteProgress(completed);
            PublishTerminal(completed, progress);
            return new(AudioToPianoClientJobState.Completed, result, null);
        }
        catch (OperationCanceledException) when (linked.IsCancellationRequested)
        {
            diagnostic.Write("cancelled", $"stage={Snapshot.Stage}; fraction={Snapshot.Fraction:0.0000}");
            var cancelled = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Cancelled,
                Snapshot.Stage,
                Snapshot.Fraction,
                "Piano creation cancelled. No generated track was added or played.",
                fullPath,
                null);
            diagnostic.WriteProgress(cancelled);
            PublishTerminal(cancelled, progress);
            return new(AudioToPianoClientJobState.Cancelled, null, null);
        }
        catch (Exception exception) when (IsRecoverableClientFailure(exception))
        {
            diagnostic.WriteFailure(exception, Snapshot);
            var errorMessage = WithDiagnosticLog(FormatClientFailure(exception), diagnostic.LogPath);
            var failed = new AudioToPianoClientJobSnapshot(
                AudioToPianoClientJobState.Failed,
                Snapshot.Stage,
                Snapshot.Fraction,
                "Piano version could not be created. The application can continue safely.",
                fullPath,
                errorMessage);
            diagnostic.WriteProgress(failed);
            PublishTerminal(failed, progress);
            return new(AudioToPianoClientJobState.Failed, null, errorMessage);
        }
        catch (Exception exception)
        {
            // Do not disguise an unknown/corrupted-state failure as recoverable. Persist the last
            // managed evidence first, then let the process-level handler record the terminal crash.
            diagnostic.WriteFailure(exception, Snapshot, "unexpected-failure");
            throw;
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
        or System.ComponentModel.Win32Exception
        or System.Runtime.InteropServices.COMException
        or Microsoft.ML.OnnxRuntime.OnnxRuntimeException
        or NAudio.MmException;

    private static string FormatClientFailure(Exception exception) => exception switch
    {
        Microsoft.ML.OnnxRuntime.OnnxRuntimeException =>
            $"The local Basic Pitch model failed during inference: {exception.Message}",
        NAudio.MmException or System.Runtime.InteropServices.COMException =>
            $"The selected audio could not be decoded locally: {exception.Message}",
        DllNotFoundException or BadImageFormatException or TypeInitializationException =>
            $"The local audio/model runtime could not start correctly: {exception.Message}",
        _ => exception.Message
    };

    private static string WithDiagnosticLog(string message, string logPath)
        => $"{message} Diagnostic log: {logPath}";

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
