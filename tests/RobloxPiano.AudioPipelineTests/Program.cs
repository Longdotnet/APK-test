using RobloxPiano.Audio;

var tests = new (string Name, Action Run)[]
{
    ("real Basic Pitch model produces canonical arranged events", RealModelSineProducesCanonicalPerformance),
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
        new AudioToPianoTranscriptionOptions(
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
                LowActivationThreshold: 0.15f)));

    True(result.Diagnostics.SourceDuration > TimeSpan.FromSeconds(1.9));
    True(result.Diagnostics.SourceSamples == samples.Length);
    True(result.Diagnostics.InferenceFrames > 0);
    True(result.Diagnostics.DecodedNotes > 0);
    True(result.Arrangement.Diagnostics.ArrangedEvents > 0);
    True(result.Diagnostics.TotalElapsed > TimeSpan.Zero);
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

static void True(bool condition)
{
    if (!condition)
        throw new InvalidOperationException("Expected condition to be true.");
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
