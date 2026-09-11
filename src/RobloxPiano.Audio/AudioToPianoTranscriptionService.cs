namespace RobloxPiano.Audio;

public sealed record AudioToPianoTranscriptionOptions(
    AudioIngestOptions? Ingest = null,
    BasicPitchNoteDecoderOptions? Decoder = null,
    RobloxPianoArrangementOptions? Arrangement = null);

public sealed record AudioToPianoTranscriptionDiagnostics(
    TimeSpan SourceDuration,
    int SourceSamples,
    int InferenceFrames,
    int DecodedNotes,
    RobloxPianoArrangementDiagnostics Arrangement,
    TimeSpan IngestElapsed,
    TimeSpan InferenceElapsed,
    TimeSpan DecodeElapsed,
    TimeSpan ArrangeElapsed)
{
    public bool RequiresReview => Arrangement.RequiresReview || DecodedNotes == 0;
    public TimeSpan TotalElapsed => IngestElapsed + InferenceElapsed + DecodeElapsed + ArrangeElapsed;
}

public sealed record AudioToPianoTranscriptionResult(
    RobloxPianoArrangementResult Arrangement,
    AudioToPianoTranscriptionDiagnostics Diagnostics);

/// <summary>
/// Production orchestration boundary for client-owned audio -> canonical Roblox piano PerformanceTrack.
/// The service composes existing deterministic ingest, Basic Pitch inference, note decoding and arranger layers;
/// it does not schedule input or mutate playback state.
/// </summary>
public sealed class AudioToPianoTranscriptionService : IDisposable
{
    private readonly BasicPitchInferenceService inference;
    private readonly AudioIngestService ingest = new();
    private readonly BasicPitchNoteDecoder decoder = new();
    private readonly RobloxPianoArranger arranger = new();
    private bool disposed;

    public AudioToPianoTranscriptionService(
        string basicPitchModelPath,
        BasicPitchInferenceOptions? inferenceOptions = null)
    {
        inference = new BasicPitchInferenceService(basicPitchModelPath, inferenceOptions);
    }

    public AudioToPianoTranscriptionResult TranscribeFile(
        string path,
        string? title = null,
        AudioToPianoTranscriptionOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        cancellationToken.ThrowIfCancellationRequested();
        options ??= new AudioToPianoTranscriptionOptions();

        var started = System.Diagnostics.Stopwatch.GetTimestamp();
        var audio = ingest.DecodeFile(path, NormalizeIngestOptions(options.Ingest), cancellationToken);
        var ingestElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
        return TranscribeNormalizedCore(audio, title ?? Path.GetFileNameWithoutExtension(path), options, ingestElapsed, cancellationToken);
    }

    public AudioToPianoTranscriptionResult TranscribeStream(
        Stream stream,
        string? title = null,
        AudioToPianoTranscriptionOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        ArgumentNullException.ThrowIfNull(stream);
        cancellationToken.ThrowIfCancellationRequested();
        options ??= new AudioToPianoTranscriptionOptions();

        var started = System.Diagnostics.Stopwatch.GetTimestamp();
        var audio = ingest.DecodeStream(stream, NormalizeIngestOptions(options.Ingest), cancellationToken);
        var ingestElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
        return TranscribeNormalizedCore(audio, title, options, ingestElapsed, cancellationToken);
    }

    public AudioToPianoTranscriptionResult TranscribeNormalized(
        NormalizedAudio audio,
        string? title = null,
        AudioToPianoTranscriptionOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        ArgumentNullException.ThrowIfNull(audio);
        cancellationToken.ThrowIfCancellationRequested();
        options ??= new AudioToPianoTranscriptionOptions();
        return TranscribeNormalizedCore(audio, title, options, TimeSpan.Zero, cancellationToken);
    }

    private AudioToPianoTranscriptionResult TranscribeNormalizedCore(
        NormalizedAudio audio,
        string? title,
        AudioToPianoTranscriptionOptions options,
        TimeSpan ingestElapsed,
        CancellationToken cancellationToken)
    {
        if (audio.SampleRate != BasicPitchInferenceService.RequiredSampleRate)
            throw new ArgumentException($"Audio-to-Piano requires {BasicPitchInferenceService.RequiredSampleRate} Hz normalized audio.", nameof(audio));

        cancellationToken.ThrowIfCancellationRequested();
        var started = System.Diagnostics.Stopwatch.GetTimestamp();
        var raw = inference.Infer(audio, cancellationToken);
        var inferenceElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);

        cancellationToken.ThrowIfCancellationRequested();
        started = System.Diagnostics.Stopwatch.GetTimestamp();
        var notes = decoder.Decode(raw, options.Decoder, cancellationToken);
        var decodeElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
        if (notes.Count == 0)
            throw new InvalidDataException("Basic Pitch produced no playable note events for this audio.");

        cancellationToken.ThrowIfCancellationRequested();
        started = System.Diagnostics.Stopwatch.GetTimestamp();
        var arrangement = arranger.Arrange(title, notes, options.Arrangement, cancellationToken);
        var arrangeElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);

        var diagnostics = new AudioToPianoTranscriptionDiagnostics(
            audio.Duration,
            audio.Samples.Length,
            raw.Notes.Frames,
            notes.Count,
            arrangement.Diagnostics,
            ingestElapsed,
            inferenceElapsed,
            decodeElapsed,
            arrangeElapsed);
        return new AudioToPianoTranscriptionResult(arrangement, diagnostics);
    }

    private static AudioIngestOptions NormalizeIngestOptions(AudioIngestOptions? options)
    {
        if (options is null)
            return new AudioIngestOptions(TargetSampleRate: BasicPitchInferenceService.RequiredSampleRate);
        if (options.TargetSampleRate != BasicPitchInferenceService.RequiredSampleRate)
            throw new ArgumentException($"Audio-to-Piano ingest target must be {BasicPitchInferenceService.RequiredSampleRate} Hz.", nameof(options));
        return options;
    }

    public void Dispose()
    {
        if (disposed)
            return;
        disposed = true;
        inference.Dispose();
    }
}
