using RobloxPiano.Audio;

var tests = new (string Name, Action Run)[]
{
    ("real Basic Pitch model produces canonical arranged events", RealModelSineProducesCanonicalPerformance),
    ("review regions promote local warnings into client-visible readiness", ReviewRegionsPromoteClientVisibleReadiness),
    ("pinned Basic Pitch model meets redistributable audio corpus baseline", RealModelCorpusMeetsQualityBaseline),
    ("pipeline rejects wrong normalized sample rate before inference", WrongNormalizedRateFailsBeforeInference),
    ("pipeline honors pre-cancellation before inference", PreCancelledPipelineStopsBeforeInference)
};

var failed = 0;
foreach (var test in tests)
{
    try
    {
        test.Run();
        Console.WriteLine($"PASS {test.Name}");
    }
    catch (Exception exception)
    {
        failed++;
        Console.Error.WriteLine($"FAIL {test.Name}: {exception}");
    }
}

if (failed != 0)
{
    Console.Error.WriteLine($"Audio-to-Piano pipeline harness failed: {failed}/{tests.Length} tests failed.");
    return 1;
}

Console.WriteLine($"Audio-to-Piano pipeline harness passed: {tests.Length}/{tests.Length}.");
return 0;

static void RealModelSineProducesCanonicalPerformance()
{
    var modelPath = RequireModelPath();
    var samples = BuildReferenceTone(seconds: 2.0, frequencyHz: 440.0);
    using var service = new AudioToPianoTranscriptionService(
        modelPath,
        new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));

    var result = service.TranscribeNormalized(
        new NormalizedAudio(samples, BasicPitchInferenceService.RequiredSampleRate),
        "A4 reference tone",
        PipelineOptions());

    True(result.Diagnostics.SourceDuration > TimeSpan.FromSeconds(1.9));
    True(result.Diagnostics.SourceSamples == samples.Length);
    True(result.Diagnostics.InferenceFrames > 0);
    True(result.Diagnostics.DecodedNotes > 0);
    True(result.Arrangement.Diagnostics.ArrangedEvents > 0);
    True(result.Diagnostics.TotalElapsed > TimeSpan.Zero);
}

static void ReviewRegionsPromoteClientVisibleReadiness()
{
    var modelPath = RequireModelPath();
    var samples = BuildReferenceTone(seconds: 2.0, frequencyHz: 440.0);
    using var service = new AudioToPianoTranscriptionService(
        modelPath,
        new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));

    var options = PipelineOptions() with
    {
        ReviewRegions = new AudioTranscriptionReviewRegionOptions(
            WindowDuration: TimeSpan.FromSeconds(1),
            LowActivationThreshold: 1.0f,
            LowRetentionRatio: 0d,
            HighEventsPerSecond: 1000d,
            HighSimultaneousNotes: 16)
    };
    var result = service.TranscribeNormalized(
        new NormalizedAudio(samples, BasicPitchInferenceService.RequiredSampleRate),
        "Review region fixture",
        options);

    True(result.Diagnostics.ReviewRegions.Count > 0, "Forced low-activation fixture must surface at least one review region.");
    True(result.Diagnostics.RequiresReview, "Local review evidence must make diagnostics require review.");
    True(result.Diagnostics.Quality.Readiness != AudioTranscriptionReadiness.Ready, "Local review evidence must not remain client-visible Ready.");
    True(result.Diagnostics.Quality.Reasons.Any(reason => reason.StartsWith("REVIEW_REGION_", StringComparison.Ordinal)), "Quality reasons must expose a deterministic timestamped review-region reason.");
    True(result.Diagnostics.ReviewElapsed >= TimeSpan.Zero, "Review analysis duration must remain bounded and observable.");
}

static void RealModelCorpusMeetsQualityBaseline()
{
    var modelPath = RequireModelPath();
    using var inference = new BasicPitchInferenceService(modelPath, new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));
    var decoder = new BasicPitchNoteDecoder();
    var ingest = new AudioIngestService();
    var evaluator = new AudioTranscriptionCorpusEvaluator();
    var evaluationCases = new List<AudioTranscriptionEvaluationCase>();

    foreach (var fixture in BuildRedistributableCorpus())
    {
        using var wave = BuildMonoPcm16Wave(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate);
        var normalized = ingest.DecodeStream(
            wave,
            new AudioIngestOptions(
                TargetSampleRate: BasicPitchInferenceService.RequiredSampleRate,
                MaxDuration: TimeSpan.FromSeconds(10)));
        var raw = inference.Infer(normalized);
        var estimated = decoder.Decode(raw, PipelineOptions().Decoder);
        if (estimated.Count == 0)
            throw new InvalidOperationException($"Corpus fixture '{fixture.Name}' produced no decoded notes.");
        evaluationCases.Add(new AudioTranscriptionEvaluationCase(fixture.Name, fixture.Reference, estimated));
    }

    // This first real-model baseline gates recognizable pitch + onset recovery. Offset accuracy is still measured
    // and printed, but is not part of note matching yet: Basic Pitch note termination is materially timbre- and
    // envelope-sensitive, and treating a duration miss as a total note miss hides useful recognition evidence.
    var corpus = evaluator.Evaluate(
        evaluationCases,
        new AudioTranscriptionEvaluationOptions(
            OnsetTolerance: TimeSpan.FromMilliseconds(150),
            RequireOffsetMatch: false));

    foreach (var (name, result) in corpus.Results)
    {
        Console.WriteLine(
            $"CORPUS {name} reference={result.ReferenceNotes} estimated={result.EstimatedNotes} matched={result.MatchedNotes} " +
            $"precision={result.Precision:F3} recall={result.Recall:F3} f1={result.F1:F3} " +
            $"onsetMs={result.MeanAbsoluteOnsetErrorMilliseconds:F1} offsetMs={result.MeanAbsoluteOffsetErrorMilliseconds:F1}");
        True(result.MatchedNotes > 0, $"Corpus fixture '{name}' lost every ground-truth pitch/onset note.");
    }

    Console.WriteLine(
        $"CORPUS SUMMARY cases={corpus.Cases} reference={corpus.ReferenceNotes} estimated={corpus.EstimatedNotes} matched={corpus.MatchedNotes} " +
        $"microPrecision={corpus.MicroPrecision:F3} microRecall={corpus.MicroRecall:F3} microF1={corpus.MicroF1:F3} macroF1={corpus.MacroF1:F3} " +
        $"onsetMs={corpus.MeanAbsoluteOnsetErrorMilliseconds:F1} offsetMs={corpus.MeanAbsoluteOffsetErrorMilliseconds:F1}");

    // Calibrated from the pinned fa5997a nmp.onnx run: precision=.321, recall=1.000,
    // micro-F1=.486, macro-F1=.523, mean onset=17.7 ms. Floors keep meaningful headroom while
    // failing on substantial regression instead of pretending pure sine waves are piano timbres.
    Equal(4, corpus.Cases);
    True(corpus.MicroPrecision >= 0.28, $"Corpus micro precision regressed below 0.28: {corpus.MicroPrecision:F3}.");
    True(corpus.MicroRecall >= 0.90, $"Corpus micro recall regressed below 0.90: {corpus.MicroRecall:F3}.");
    True(corpus.MicroF1 >= 0.44, $"Corpus micro F1 regressed below 0.44: {corpus.MicroF1:F3}.");
    True(corpus.MacroF1 >= 0.47, $"Corpus macro F1 regressed below 0.47: {corpus.MacroF1:F3}.");
    True(corpus.MeanAbsoluteOnsetErrorMilliseconds <= 50.0, $"Corpus mean onset error exceeded 50 ms: {corpus.MeanAbsoluteOnsetErrorMilliseconds:F1} ms.");
}

static void WrongNormalizedRateFailsBeforeInference()
{
    var modelPath = RequireModelPath();
    using var service = new AudioToPianoTranscriptionService(modelPath);
    var audio = new NormalizedAudio(new float[44_100], 44_100);

    Throws<ArgumentException>(() => service.TranscribeNormalized(audio));
}

static void PreCancelledPipelineStopsBeforeInference()
{
    var modelPath = RequireModelPath();
    using var service = new AudioToPianoTranscriptionService(modelPath);
    using var cts = new CancellationTokenSource();
    cts.Cancel();
    var audio = new NormalizedAudio(BuildReferenceTone(0.5, 440.0), BasicPitchInferenceService.RequiredSampleRate);

    Throws<OperationCanceledException>(() => service.TranscribeNormalized(audio, cancellationToken: cts.Token));
}

static AudioToPianoTranscriptionOptions PipelineOptions() => new(
    Decoder: new BasicPitchNoteDecoderOptions(
        OnsetThreshold: 0.20f,
        FrameThreshold: 0.15f,
        MinimumNoteLengthFrames: 3,
        EnergyToleranceFrames: 8,
        UseMelodiaRecovery: true,
        IncludePitchBends: true),
    Arrangement: new RobloxPianoArrangementOptions(
        MaxSimultaneousNotes: 4,
        MinimumDuration: TimeSpan.FromMilliseconds(20),
        LowActivationThreshold: 0.15f));

static IReadOnlyList<CorpusFixture> BuildRedistributableCorpus()
{
    return
    [
        BuildFixture("single-a4", 1.8,
            new NoteSpec(69, 0.30, 1.30)),
        BuildFixture("c-major-fragment", 2.25,
            new NoteSpec(60, 0.25, 0.75),
            new NoteSpec(64, 0.85, 1.35),
            new NoteSpec(67, 1.45, 1.95)),
        BuildFixture("repeated-g4", 2.15,
            new NoteSpec(67, 0.25, 0.65),
            new NoteSpec(67, 0.85, 1.25),
            new NoteSpec(67, 1.45, 1.85)),
        BuildFixture("wide-register-pair", 2.10,
            new NoteSpec(48, 0.30, 0.95),
            new NoteSpec(84, 1.15, 1.80))
    ];
}

static CorpusFixture BuildFixture(string name, double durationSeconds, params NoteSpec[] notes)
{
    var rate = BasicPitchInferenceService.RequiredSampleRate;
    var samples = new float[checked((int)Math.Round(durationSeconds * rate))];
    const double attackSeconds = 0.015;
    const double releaseSeconds = 0.025;

    foreach (var note in notes)
    {
        var startSample = Math.Max(0, (int)Math.Round(note.StartSeconds * rate));
        var endSample = Math.Min(samples.Length, (int)Math.Round(note.EndSeconds * rate));
        var frequency = 440.0 * Math.Pow(2.0, (note.MidiNote - 69) / 12.0);
        for (var i = startSample; i < endSample; i++)
        {
            var localSeconds = (i - startSample) / (double)rate;
            var remainingSeconds = (endSample - i) / (double)rate;
            var attack = Math.Min(1.0, localSeconds / attackSeconds);
            var release = Math.Min(1.0, remainingSeconds / releaseSeconds);
            var envelope = Math.Min(attack, release);
            samples[i] += (float)(Math.Sin(2.0 * Math.PI * frequency * localSeconds) * 0.42 * envelope);
        }
    }

    for (var i = 0; i < samples.Length; i++)
        samples[i] = Math.Clamp(samples[i], -0.95f, 0.95f);

    var reference = notes
        .Select(note => new AudioTranscriptionReferenceNote(
            TimeSpan.FromSeconds(note.StartSeconds),
            TimeSpan.FromSeconds(note.EndSeconds),
            note.MidiNote))
        .ToArray();
    return new CorpusFixture(name, samples, reference);
}

static MemoryStream BuildMonoPcm16Wave(IReadOnlyList<float> samples, int sampleRate)
{
    var stream = new MemoryStream(44 + samples.Count * 2);
    using (var writer = new BinaryWriter(stream, System.Text.Encoding.ASCII, leaveOpen: true))
    {
        var dataBytes = checked(samples.Count * 2);
        writer.Write(System.Text.Encoding.ASCII.GetBytes("RIFF"));
        writer.Write(36 + dataBytes);
        writer.Write(System.Text.Encoding.ASCII.GetBytes("WAVE"));
        writer.Write(System.Text.Encoding.ASCII.GetBytes("fmt "));
        writer.Write(16);
        writer.Write((short)1);
        writer.Write((short)1);
        writer.Write(sampleRate);
        writer.Write(sampleRate * 2);
        writer.Write((short)2);
        writer.Write((short)16);
        writer.Write(System.Text.Encoding.ASCII.GetBytes("data"));
        writer.Write(dataBytes);
        foreach (var sample in samples)
        {
            var pcm = (short)Math.Round(Math.Clamp(sample, -1f, 1f) * short.MaxValue);
            writer.Write(pcm);
        }
    }
    stream.Position = 0;
    return stream;
}

static string RequireModelPath()
{
    var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
    if (string.IsNullOrWhiteSpace(modelPath))
        throw new InvalidOperationException("BASIC_PITCH_MODEL_PATH is required for Audio-to-Piano pipeline regression tests.");
    return modelPath;
}

static float[] BuildReferenceTone(double seconds, double frequencyHz)
{
    var rate = BasicPitchInferenceService.RequiredSampleRate;
    var length = checked((int)Math.Round(seconds * rate));
    var samples = new float[length];
    var attackSamples = Math.Max(1, rate / 50);
    var releaseSamples = Math.Max(1, rate / 25);
    for (var i = 0; i < samples.Length; i++)
    {
        var attack = Math.Min(1.0, i / (double)attackSamples);
        var release = Math.Min(1.0, (samples.Length - 1 - i) / (double)releaseSamples);
        var envelope = Math.Min(attack, release);
        samples[i] = (float)(Math.Sin(2 * Math.PI * frequencyHz * i / rate) * 0.45 * envelope);
    }
    return samples;
}

static void True(bool condition, string message = "Expected condition to be true.")
{
    if (!condition)
        throw new InvalidOperationException(message);
}

static void Equal<T>(T expected, T actual) where T : IEquatable<T>
{
    if (!expected.Equals(actual))
        throw new InvalidOperationException($"Expected {expected}, got {actual}.");
}

static void Throws<TException>(Action action) where TException : Exception
{
    try
    {
        action();
    }
    catch (TException)
    {
        return;
    }

    throw new InvalidOperationException($"Expected {typeof(TException).Name}.");
}

sealed record NoteSpec(int MidiNote, double StartSeconds, double EndSeconds);
sealed record CorpusFixture(string Name, float[] Samples, IReadOnlyList<AudioTranscriptionReferenceNote> Reference);
