namespace RobloxPiano.Audio;

public sealed record AudioSourceSeparationOptions(
    bool Enabled = true,
    SectionAwareStemCompositionOptions? SectionAwareComposition = null,
    SparseHarmonySelectionOptions? SparseHarmony = null);

public sealed record AudioToPianoTranscriptionOptions(
    AudioIngestOptions? Ingest = null,
    BasicPitchNoteDecoderOptions? Decoder = null,
    BasicPitchHarmonicSuppressionOptions? HarmonicSuppression = null,
    RobloxPianoArrangementOptions? Arrangement = null,
    AudioTranscriptionQualityOptions? Quality = null,
    AudioTranscriptionReviewRegionOptions? ReviewRegions = null,
    AudioSourceSeparationOptions? SourceSeparation = null);

public enum AudioToPianoTranscriptionStage
{
    SourceSeparation,
    Ingest,
    Inference,
    Decode,
    HarmonicSuppression,
    HarmonyExtraction,
    Arrange,
    Quality,
    Completed
}

public sealed record AudioToPianoTranscriptionProgress
{
    public AudioToPianoTranscriptionProgress(
        AudioToPianoTranscriptionStage stage,
        double fraction,
        string message)
    {
        if (!double.IsFinite(fraction) || fraction is < 0d or > 1d)
            throw new ArgumentOutOfRangeException(nameof(fraction));
        ArgumentException.ThrowIfNullOrWhiteSpace(message);

        Stage = stage;
        Fraction = fraction;
        Message = message;
    }

    public AudioToPianoTranscriptionStage Stage { get; }
    public double Fraction { get; }
    public string Message { get; }
}

public sealed record AudioToPianoTranscriptionDiagnostics(
    TimeSpan SourceDuration,
    int SourceSamples,
    int InferenceFrames,
    int DecodedNotes,
    BasicPitchHarmonicSuppressionDiagnostics HarmonicSuppression,
    RobloxPianoArrangementDiagnostics Arrangement,
    AudioTranscriptionQualityAssessment Quality,
    TimeSpan IngestElapsed,
    TimeSpan InferenceElapsed,
    TimeSpan DecodeElapsed,
    TimeSpan SuppressionElapsed,
    TimeSpan ArrangeElapsed,
    TimeSpan QualityElapsed)
{
    public AudioTranscriptionQualityAssessment BaseQuality { get; init; } = Quality;
    public IReadOnlyList<AudioTranscriptionReviewRegion> ReviewRegions { get; init; } = Array.Empty<AudioTranscriptionReviewRegion>();
    public TimeSpan ReviewElapsed { get; init; }
    public TimeSpan SeparationElapsed { get; init; }
    public string InputStrategy { get; init; } = "full-mix";
    public SectionAwareStemCompositionDiagnostics? StemComposition { get; init; }
    public SparseHarmonySelectionDiagnostics? SparseHarmony { get; init; }
    public int HarmonyDecodedNotes { get; init; }
    public TimeSpan HarmonyInferenceElapsed { get; init; }
    public TimeSpan HarmonyDecodeElapsed { get; init; }
    public TimeSpan HarmonySuppressionElapsed { get; init; }
    public TimeSpan HarmonySelectionElapsed { get; init; }
    public bool RequiresReview => Quality.RequiresReview || ReviewRegions.Count != 0;
    public int NotesAfterSuppression => HarmonicSuppression.RetainedNotes;
    public TimeSpan TotalElapsed => SeparationElapsed + IngestElapsed + InferenceElapsed + DecodeElapsed + SuppressionElapsed + HarmonyInferenceElapsed + HarmonyDecodeElapsed + HarmonySuppressionElapsed + HarmonySelectionElapsed + ArrangeElapsed + QualityElapsed + ReviewElapsed;
}

public sealed record AudioToPianoTranscriptionResult(
    RobloxPianoArrangementResult Arrangement,
    AudioToPianoTranscriptionDiagnostics Diagnostics)
{
    public IReadOnlyList<BasicPitchTranscribedNote> NoteEvidence { get; init; } = Array.Empty<BasicPitchTranscribedNote>();
}

/// <summary>
/// Production orchestration boundary for client-owned audio -> canonical Roblox piano PerformanceTrack.
/// Full-song MP3/WAV input is separated before pitch transcription by default. The vocal stem stays authoritative,
/// sustained vocal-weak sections may admit a pitch-guided instrumental lead, and the separated accompaniment is
/// transcribed independently into sparse lead-protected harmony. Third-party separation never owns playable truth.
/// </summary>
public sealed class AudioToPianoTranscriptionService : IDisposable
{
    private const double InferenceStartFraction = 0.15d;
    private const double InferenceEndFraction = 0.70d;

    private readonly BasicPitchInferenceService inference;
    private readonly AudioIngestService ingest = new();
    private readonly SectionAwareStemComposer sectionAwareStemComposer = new();
    private readonly BasicPitchNoteDecoder decoder = new();
    private readonly BasicPitchHarmonicSuppressor harmonicSuppressor = new();
    private readonly SparseHarmonySelector sparseHarmonySelector = new();
    private readonly RobloxPianoArranger arranger = new();
    private readonly AudioTranscriptionQualityEvaluator qualityEvaluator = new();
    private readonly AudioTranscriptionReviewRegionAnalyzer reviewRegionAnalyzer = new();
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
        CancellationToken cancellationToken = default) =>
        TranscribeFile(path, title, options, progress: null, cancellationToken);

    public AudioToPianoTranscriptionResult TranscribeFile(
        string path,
        string? title,
        AudioToPianoTranscriptionOptions? options,
        IProgress<AudioToPianoTranscriptionProgress>? progress,
        CancellationToken cancellationToken = default)
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        cancellationToken.ThrowIfCancellationRequested();
        options ??= new AudioToPianoTranscriptionOptions();

        DemucsSeparatedStems? separated = null;
        NormalizedAudio? separatedAccompaniment = null;
        var inputStrategy = "full-mix";
        var separationElapsed = TimeSpan.Zero;
        SectionAwareStemCompositionDiagnostics? stemComposition = null;
        try
        {
            if (ShouldUseSourceSeparation(path, options))
            {
                Report(progress, AudioToPianoTranscriptionStage.SourceSeparation, 0.01d,
                    "Preparing local source separation for the full song...");
                var separationStarted = System.Diagnostics.Stopwatch.GetTimestamp();
                separated = DemucsRsStemSeparator.Separate(
                    path,
                    message => Report(progress, AudioToPianoTranscriptionStage.SourceSeparation, 0.08d, message),
                    cancellationToken);
                separationElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(separationStarted);
                Report(progress, AudioToPianoTranscriptionStage.SourceSeparation, 0.10d,
                    "Separated vocal and accompaniment stems are ready. Recovering melody-bearing instrumental sections conservatively...");
            }

            Report(progress, AudioToPianoTranscriptionStage.Ingest, separated is null ? 0d : 0.10d,
                separated is null
                    ? "Decoding and normalizing audio..."
                    : "Decoding separated vocals and accompaniment for lead and harmony analysis...");
            var started = System.Diagnostics.Stopwatch.GetTimestamp();
            var ingestOptions = NormalizeIngestOptions(options.Ingest);
            NormalizedAudio audio;
            if (separated is null)
            {
                audio = ingest.DecodeFile(path, ingestOptions, cancellationToken);
            }
            else
            {
                var vocals = ingest.DecodeFile(separated.VocalsPath, ingestOptions, cancellationToken);
                var accompanimentPath = ResolveSeparatedAccompanimentPath(separated);
                var accompaniment = ingest.DecodeFile(accompanimentPath, ingestOptions, cancellationToken);
                separatedAccompaniment = accompaniment;
                var composition = sectionAwareStemComposer.Compose(
                    vocals,
                    accompaniment,
                    options.SourceSeparation?.SectionAwareComposition,
                    cancellationToken);
                audio = composition.Audio;
                stemComposition = composition.Diagnostics;
                inputStrategy =
                    $"spleeter/{DemucsRsStemSeparator.EngineVersion}:{DemucsRsStemSeparator.ModelId}:" +
                    $"vocal-priority+section-fallback@{composition.Diagnostics.AccompanimentGain:0.00}:" +
                    $"{composition.Diagnostics.FallbackWindows}/{composition.Diagnostics.Windows}-windows";
            }

            var ingestElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
            Report(progress, AudioToPianoTranscriptionStage.Ingest, InferenceStartFraction,
                separated is null
                    ? "Audio normalized for transcription."
                    : stemComposition?.UsedAccompanimentFallback == true
                        ? $"Lead source ready; recovered about {stemComposition.FallbackDuration.TotalSeconds:0.0}s of sustained instrumental sections."
                        : "Lead-vocal stem is strong across the song; instrumental lead fallback was not needed.");
            return TranscribeNormalizedCore(
                audio,
                title ?? Path.GetFileNameWithoutExtension(path),
                options,
                ingestElapsed,
                progress,
                cancellationToken,
                inputStrategy,
                separationElapsed,
                stemComposition,
                separatedAccompaniment);
        }
        finally
        {
            separated?.Dispose();
        }
    }

    public AudioToPianoTranscriptionResult TranscribeStream(
        Stream stream,
        string? title = null,
        AudioToPianoTranscriptionOptions? options = null,
        CancellationToken cancellationToken = default) =>
        TranscribeStream(stream, title, options, progress: null, cancellationToken);

    public AudioToPianoTranscriptionResult TranscribeStream(
        Stream stream,
        string? title,
        AudioToPianoTranscriptionOptions? options,
        IProgress<AudioToPianoTranscriptionProgress>? progress,
        CancellationToken cancellationToken = default)
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        ArgumentNullException.ThrowIfNull(stream);
        cancellationToken.ThrowIfCancellationRequested();
        options ??= new AudioToPianoTranscriptionOptions();

        Report(progress, AudioToPianoTranscriptionStage.Ingest, 0d, "Decoding and normalizing audio...");
        var started = System.Diagnostics.Stopwatch.GetTimestamp();
        var audio = ingest.DecodeStream(stream, NormalizeIngestOptions(options.Ingest), cancellationToken);
        var ingestElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
        Report(progress, AudioToPianoTranscriptionStage.Ingest, InferenceStartFraction, "Audio normalized for transcription.");
        return TranscribeNormalizedCore(
            audio,
            title,
            options,
            ingestElapsed,
            progress,
            cancellationToken,
            "stream",
            TimeSpan.Zero,
            stemComposition: null,
            separatedAccompaniment: null);
    }

    public AudioToPianoTranscriptionResult TranscribeNormalized(
        NormalizedAudio audio,
        string? title = null,
        AudioToPianoTranscriptionOptions? options = null,
        CancellationToken cancellationToken = default) =>
        TranscribeNormalized(audio, title, options, progress: null, cancellationToken);

    public AudioToPianoTranscriptionResult TranscribeNormalized(
        NormalizedAudio audio,
        string? title,
        AudioToPianoTranscriptionOptions? options,
        IProgress<AudioToPianoTranscriptionProgress>? progress,
        CancellationToken cancellationToken = default)
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        ArgumentNullException.ThrowIfNull(audio);
        cancellationToken.ThrowIfCancellationRequested();
        options ??= new AudioToPianoTranscriptionOptions();
        return TranscribeNormalizedCore(
            audio,
            title,
            options,
            TimeSpan.Zero,
            progress,
            cancellationToken,
            "normalized-input",
            TimeSpan.Zero,
            stemComposition: null,
            separatedAccompaniment: null);
    }

    private AudioToPianoTranscriptionResult TranscribeNormalizedCore(
        NormalizedAudio audio,
        string? title,
        AudioToPianoTranscriptionOptions options,
        TimeSpan ingestElapsed,
        IProgress<AudioToPianoTranscriptionProgress>? progress,
        CancellationToken cancellationToken,
        string inputStrategy,
        TimeSpan separationElapsed,
        SectionAwareStemCompositionDiagnostics? stemComposition,
        NormalizedAudio? separatedAccompaniment)
    {
        if (audio.SampleRate != BasicPitchInferenceService.RequiredSampleRate)
            throw new ArgumentException($"Audio-to-Piano requires {BasicPitchInferenceService.RequiredSampleRate} Hz normalized audio.", nameof(audio));
        if (separatedAccompaniment is not null && separatedAccompaniment.SampleRate != audio.SampleRate)
            throw new ArgumentException("Separated accompaniment must share the normalized Basic Pitch sample rate.", nameof(separatedAccompaniment));

        cancellationToken.ThrowIfCancellationRequested();
        Report(progress, AudioToPianoTranscriptionStage.Inference, InferenceStartFraction,
            inputStrategy.StartsWith("spleeter/", StringComparison.Ordinal)
                ? "Listening for the lead melody in the vocal-priority, section-aware source..."
                : "Listening for notes with Basic Pitch...");
        var inferenceProgress = progress is null
            ? null
            : new InlineProgress<BasicPitchInferenceProgress>(value => ReportInferenceProgress(progress, value));
        var started = System.Diagnostics.Stopwatch.GetTimestamp();
        var raw = inference.Infer(audio, inferenceProgress, cancellationToken);
        var inferenceElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);

        cancellationToken.ThrowIfCancellationRequested();
        Report(progress, AudioToPianoTranscriptionStage.Decode, InferenceEndFraction, "Turning model activations into lead-note events...");
        started = System.Diagnostics.Stopwatch.GetTimestamp();
        var decodedNotes = decoder.Decode(raw, options.Decoder, cancellationToken);
        var decodeElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
        if (decodedNotes.Count == 0)
            throw new InvalidDataException("Basic Pitch produced no playable note events for this audio.");

        cancellationToken.ThrowIfCancellationRequested();
        Report(progress, AudioToPianoTranscriptionStage.HarmonicSuppression, 0.76d, "Removing weak harmonic duplicates from the lead conservatively...");
        started = System.Diagnostics.Stopwatch.GetTimestamp();
        var suppression = harmonicSuppressor.Suppress(decodedNotes, options.HarmonicSuppression, cancellationToken);
        var suppressionElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
        if (suppression.Notes.Count == 0)
            throw new InvalidDataException("Basic Pitch harmonic suppression removed every decoded note; review the source or suppression policy.");

        IReadOnlyList<BasicPitchTranscribedNote> arrangementNotes = suppression.Notes;
        SparseHarmonySelectionDiagnostics? sparseHarmonyDiagnostics = null;
        var harmonyDecodedNotes = 0;
        var harmonyInferenceElapsed = TimeSpan.Zero;
        var harmonyDecodeElapsed = TimeSpan.Zero;
        var harmonySuppressionElapsed = TimeSpan.Zero;
        var harmonySelectionElapsed = TimeSpan.Zero;
        if (separatedAccompaniment is not null && (options.SourceSeparation?.SparseHarmony?.Enabled ?? true))
        {
            cancellationToken.ThrowIfCancellationRequested();
            Report(progress, AudioToPianoTranscriptionStage.HarmonyExtraction, 0.80d,
                "Listening to the separated accompaniment for sparse supporting harmony...");
            started = System.Diagnostics.Stopwatch.GetTimestamp();
            var harmonyRaw = inference.Infer(separatedAccompaniment, progress: null, cancellationToken);
            harmonyInferenceElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);

            cancellationToken.ThrowIfCancellationRequested();
            started = System.Diagnostics.Stopwatch.GetTimestamp();
            var harmonyDecoded = decoder.Decode(harmonyRaw, CreateHarmonyDecoderOptions(options.Decoder), cancellationToken);
            harmonyDecodeElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
            harmonyDecodedNotes = harmonyDecoded.Count;

            if (harmonyDecoded.Count != 0)
            {
                started = System.Diagnostics.Stopwatch.GetTimestamp();
                var harmonySuppression = harmonicSuppressor.Suppress(harmonyDecoded, options.HarmonicSuppression, cancellationToken);
                harmonySuppressionElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);

                started = System.Diagnostics.Stopwatch.GetTimestamp();
                var harmony = sparseHarmonySelector.Select(
                    suppression.Notes,
                    harmonySuppression.Notes,
                    options.SourceSeparation?.SparseHarmony,
                    cancellationToken);
                harmonySelectionElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);
                sparseHarmonyDiagnostics = harmony.Diagnostics;

                if (harmony.Notes.Count != 0)
                {
                    arrangementNotes = suppression.Notes
                        .Concat(harmony.Notes)
                        .OrderBy(note => note.Start)
                        .ThenBy(note => note.MidiNote)
                        .ThenBy(note => note.End)
                        .ThenByDescending(note => note.Amplitude)
                        .ToArray();
                    inputStrategy += $":sparse-harmony={harmony.Notes.Count}";
                }
                else
                {
                    inputStrategy += ":sparse-harmony=0";
                }
            }
        }

        cancellationToken.ThrowIfCancellationRequested();
        Report(progress, AudioToPianoTranscriptionStage.Arrange, 0.88d, "Arranging protected melody plus sparse harmony for the Roblox piano range...");
        started = System.Diagnostics.Stopwatch.GetTimestamp();
        var arrangement = arranger.Arrange(title, arrangementNotes, options.Arrangement, cancellationToken);
        var arrangeElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);

        cancellationToken.ThrowIfCancellationRequested();
        Report(progress, AudioToPianoTranscriptionStage.Quality, 0.95d, "Checking confidence and review regions...");
        started = System.Diagnostics.Stopwatch.GetTimestamp();
        var quality = qualityEvaluator.Evaluate(
            audio.Duration,
            arrangement.Diagnostics,
            arrangement.Track.TimelineDuration,
            suppression.Diagnostics,
            options.Quality);
        var baseQuality = quality;
        var qualityElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);

        cancellationToken.ThrowIfCancellationRequested();
        started = System.Diagnostics.Stopwatch.GetTimestamp();
        var reviewRegions = reviewRegionAnalyzer.Analyze(
            audio.Duration,
            arrangementNotes,
            arrangement.Track,
            options.ReviewRegions,
            cancellationToken);
        var reviewElapsed = System.Diagnostics.Stopwatch.GetElapsedTime(started);

        if (reviewRegions.Count != 0)
        {
            var localReasons = reviewRegions.Select(FormatReviewRegionReason);
            quality = quality with
            {
                Readiness = quality.Readiness == AudioTranscriptionReadiness.Ready
                    ? AudioTranscriptionReadiness.NeedsReview
                    : quality.Readiness,
                Reasons = quality.Reasons
                    .Concat(localReasons)
                    .Distinct(StringComparer.Ordinal)
                    .ToArray()
            };
        }

        var diagnostics = new AudioToPianoTranscriptionDiagnostics(
            audio.Duration,
            audio.Samples.Length,
            raw.Notes.Frames,
            decodedNotes.Count,
            suppression.Diagnostics,
            arrangement.Diagnostics,
            quality,
            ingestElapsed,
            inferenceElapsed,
            decodeElapsed,
            suppressionElapsed,
            arrangeElapsed,
            qualityElapsed)
        {
            BaseQuality = baseQuality,
            ReviewRegions = reviewRegions,
            ReviewElapsed = reviewElapsed,
            SeparationElapsed = separationElapsed,
            InputStrategy = inputStrategy,
            StemComposition = stemComposition,
            SparseHarmony = sparseHarmonyDiagnostics,
            HarmonyDecodedNotes = harmonyDecodedNotes,
            HarmonyInferenceElapsed = harmonyInferenceElapsed,
            HarmonyDecodeElapsed = harmonyDecodeElapsed,
            HarmonySuppressionElapsed = harmonySuppressionElapsed,
            HarmonySelectionElapsed = harmonySelectionElapsed
        };
        var result = new AudioToPianoTranscriptionResult(arrangement, diagnostics)
        {
            NoteEvidence = arrangementNotes
                .OrderBy(note => note.Start)
                .ThenBy(note => note.MidiNote)
                .ThenBy(note => note.End)
                .ThenByDescending(note => note.Amplitude)
                .ToArray()
        };
        Report(progress, AudioToPianoTranscriptionStage.Completed, 1d, "Piano version created.");
        return result;
    }

    private static BasicPitchNoteDecoderOptions CreateHarmonyDecoderOptions(BasicPitchNoteDecoderOptions? primary)
    {
        primary ??= new BasicPitchNoteDecoderOptions();
        return new BasicPitchNoteDecoderOptions(
            OnsetThreshold: Math.Max(0.56f, primary.OnsetThreshold),
            FrameThreshold: Math.Max(0.36f, primary.FrameThreshold),
            InferOnsets: primary.InferOnsets,
            MinimumNoteLengthFrames: Math.Max(7, primary.MinimumNoteLengthFrames),
            EnergyToleranceFrames: Math.Max(8, primary.EnergyToleranceFrames),
            UseMelodiaRecovery: false,
            IncludePitchBends: false,
            MinimumFrequencyHz: Math.Max(65.41d, primary.MinimumFrequencyHz ?? 0d),
            MaximumFrequencyHz: Math.Min(1046.50d, primary.MaximumFrequencyHz ?? double.MaxValue));
    }

    private static string ResolveSeparatedAccompanimentPath(DemucsSeparatedStems separated)
    {
        var path = Path.Combine(separated.WorkingDirectory, "accompaniment.wav");
        if (!File.Exists(path))
        {
            throw new InvalidDataException(
                "Spleeter completed without the expected accompaniment stem required for section-aware melody recovery and sparse harmony.");
        }

        return path;
    }

    private static bool ShouldUseSourceSeparation(string path, AudioToPianoTranscriptionOptions options)
    {
        if (options.SourceSeparation is not null)
            return options.SourceSeparation.Enabled;

        var disabled = Environment.GetEnvironmentVariable("ROBLOXPIANO_DISABLE_SOURCE_SEPARATION");
        if (disabled is not null && (disabled.Equals("1", StringComparison.OrdinalIgnoreCase)
            || disabled.Equals("true", StringComparison.OrdinalIgnoreCase)))
        {
            return false;
        }

        var forced = Environment.GetEnvironmentVariable("ROBLOXPIANO_ENABLE_SOURCE_SEPARATION");
        if (forced is not null && (forced.Equals("1", StringComparison.OrdinalIgnoreCase)
            || forced.Equals("true", StringComparison.OrdinalIgnoreCase)))
        {
            return true;
        }

        // Keep deterministic/offline CI fixtures unchanged. Normal desktop full-song MP3/WAV input is
        // separation-first so client behavior matches the Create Piano product contract.
        var isCi = Environment.GetEnvironmentVariable("CI")?.Equals("true", StringComparison.OrdinalIgnoreCase) == true;
        var extension = Path.GetExtension(path);
        return !isCi && (extension.Equals(".mp3", StringComparison.OrdinalIgnoreCase)
            || extension.Equals(".wav", StringComparison.OrdinalIgnoreCase));
    }

    private static string FormatReviewRegionReason(AudioTranscriptionReviewRegion region)
    {
        var range = $"{FormatReviewTime(region.Start)}-{FormatReviewTime(region.End)}";
        return $"REVIEW_REGION_{range}_{string.Join('+', region.Reasons)}";
    }

    private static string FormatReviewTime(TimeSpan value)
    {
        var totalMinutes = checked((int)Math.Floor(value.TotalMinutes));
        var seconds = value.Seconds;
        return $"{totalMinutes:00}:{seconds:00}";
    }

    private static void ReportInferenceProgress(
        IProgress<AudioToPianoTranscriptionProgress> progress,
        BasicPitchInferenceProgress value)
    {
        var fraction = InferenceStartFraction + ((InferenceEndFraction - InferenceStartFraction) * value.Fraction);
        var message = value.CompletedChunks == 0
            ? $"Basic Pitch prepared {value.TotalChunks} audio window(s)..."
            : $"Basic Pitch analyzed {value.CompletedChunks} of {value.TotalChunks} audio window(s)...";
        Report(progress, AudioToPianoTranscriptionStage.Inference, fraction, message);
    }

    private static void Report(
        IProgress<AudioToPianoTranscriptionProgress>? progress,
        AudioToPianoTranscriptionStage stage,
        double fraction,
        string message)
    {
        progress?.Report(new AudioToPianoTranscriptionProgress(stage, fraction, message));
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

    private sealed class InlineProgress<T>(Action<T> callback) : IProgress<T>
    {
        public void Report(T value) => callback(value);
    }
}
