using System.Buffers.Binary;
using RobloxPiano.Audio;

var tests = new (string Name, Action Run)[]
{
    ("stereo PCM is averaged to deterministic mono", StereoDownmix),
    ("44.1 kHz PCM is resampled to Basic Pitch rate", ResamplesToBasicPitchRate),
    ("duration bound fails closed instead of truncating", DurationBoundFailsClosed),
    ("empty decoded audio fails closed", EmptyAudioFailsClosed),
    ("pre-cancelled ingest exits deterministically", CancellationIsHonored),
    ("Basic Pitch chunk plan matches Spotify overlap contract", BasicPitchChunkPlanMatchesReference),
    ("Basic Pitch ONNX inference returns bounded canonical raw tensors", BasicPitchOnnxInference),
    ("Basic Pitch onset and energy decoding matches reference semantics", BasicPitchDecoderRegression.OnsetEnergyParityFixture),
    ("Basic Pitch inferred onset recovers sharp attacks", BasicPitchDecoderRegression.InferredOnsetRecoversSharpAttack),
    ("Basic Pitch Melodia recovery extracts sustained energy", BasicPitchDecoderRegression.MelodiaRecoversSustainedEnergyWithoutOnset),
    ("Basic Pitch pitch bend keeps third-semitone contour units", BasicPitchDecoderRegression.PitchBendUsesSpotifyThirdSemitoneBins),
    ("Basic Pitch frequency constraint excludes out-of-band notes", BasicPitchDecoderRegression.FrequencyConstraintFailsClosedOutsideRequestedBand),
    ("Basic Pitch decoder rejects invalid activation tensors", BasicPitchDecoderRegression.InvalidTensorProbabilityIsRejected),
    ("Roblox arranger octave-folds into classic 61-key pitch classes", RobloxPianoArrangerRegression.OctaveFoldingKeepsPitchClassInsideClassic61),
    ("Roblox arranger density policy preserves melody priority", RobloxPianoArrangerRegression.DensityLimitAlwaysKeepsHighestMelodyPitch),
    ("Roblox arranger merges octave-folded duplicate pitches", RobloxPianoArrangerRegression.FoldedDuplicatePitchIsMergedDeterministically),
    ("Roblox arranger prevents overlapping ownership of one key", RobloxPianoArrangerRegression.SameKeyOverlapIsTrimmedBeforeCanonicalPlayback),
    ("Roblox arranger surfaces low-confidence review diagnostics", RobloxPianoArrangerRegression.ShortAndLowActivationNotesProduceReviewDiagnostics),
    ("Roblox arranger honors pre-cancellation", RobloxPianoArrangerRegression.PreCancelledArrangementStopsBeforeMutation),
    ("transcription quality marks clean arrangements Ready", AudioTranscriptionQualityRegression.CleanArrangementIsReady),
    ("transcription quality marks lossy arrangements NeedsReview", AudioTranscriptionQualityRegression.LossyArrangementRequiresReview),
    ("transcription quality rejects critically incomplete timelines", AudioTranscriptionQualityRegression.CriticalCoverageIsRejected),
    ("transcription quality rejects pathological event density", AudioTranscriptionQualityRegression.ExtremeEventDensityIsRejected),
    ("transcription quality thresholds fail closed", AudioTranscriptionQualityRegression.InvalidThresholdsFailClosed)
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
    Console.Error.WriteLine($"Audio OSS regression harness failed: {failed}/{tests.Length} tests failed.");
    return 1;
}

Console.WriteLine($"Audio OSS regression harness passed: {tests.Length}/{tests.Length}.");
return 0;

static void StereoDownmix()
{
    var frames = new (short Left, short Right)[]
    {
        (short.MaxValue, short.MaxValue),
        (short.MaxValue, short.MinValue),
        (0, 0),
        (16384, 16384)
    };
    using var stream = new MemoryStream(BuildPcm16Wave(22_050, frames));

    var audio = new AudioIngestService().DecodeStream(stream);

    Equal(22_050, audio.SampleRate);
    Equal(1, audio.Channels);
    Equal(frames.Length, audio.Samples.Length);
    Nearly(0.999969f, audio.Samples[0], 0.0001f);
    Nearly(-0.000015f, audio.Samples[1], 0.0001f);
    Nearly(0f, audio.Samples[2], 0.0001f);
    Nearly(0.5f, audio.Samples[3], 0.0001f);
}

static void ResamplesToBasicPitchRate()
{
    const int sourceRate = 44_100;
    const int sourceFrames = sourceRate / 4;
    var frames = Enumerable.Range(0, sourceFrames)
        .Select(i =>
        {
            var sample = (short)(Math.Sin(2 * Math.PI * 440 * i / sourceRate) * 12_000);
            return (sample, sample);
        })
        .ToArray();
    using var stream = new MemoryStream(BuildPcm16Wave(sourceRate, frames));

    var audio = new AudioIngestService().DecodeStream(stream);

    Equal(22_050, audio.SampleRate);
    Equal(1, audio.Channels);
    True(Math.Abs(audio.Samples.Length - 5_513) <= 4, $"Unexpected resampled sample count {audio.Samples.Length}.");
    True(Math.Abs(audio.Duration.TotalSeconds - 0.25) < 0.002, $"Unexpected duration {audio.Duration}.");
    True(audio.Samples.All(float.IsFinite), "Resampled output must contain only finite samples.");
}

static void DurationBoundFailsClosed()
{
    var frames = Enumerable.Repeat(((short)1000, (short)1000), 300).ToArray();
    using var stream = new MemoryStream(BuildPcm16Wave(1_000, frames));
    var options = new AudioIngestOptions(TargetSampleRate: 8_000, MaxDuration: TimeSpan.FromMilliseconds(100));

    Throws<InvalidDataException>(() => new AudioIngestService().DecodeStream(stream, options));
}

static void EmptyAudioFailsClosed()
{
    using var stream = new MemoryStream(BuildPcm16Wave(22_050, []));
    Throws<InvalidDataException>(() => new AudioIngestService().DecodeStream(stream));
}

static void CancellationIsHonored()
{
    var frames = Enumerable.Repeat(((short)1000, (short)1000), 100).ToArray();
    using var stream = new MemoryStream(BuildPcm16Wave(22_050, frames));
    using var cts = new CancellationTokenSource();
    cts.Cancel();

    Throws<OperationCanceledException>(() => new AudioIngestService().DecodeStream(stream, cancellationToken: cts.Token));
}

static void BasicPitchChunkPlanMatchesReference()
{
    var oneSecond = BasicPitchChunkPlan.Create(BasicPitchInferenceService.RequiredSampleRate);
    Equal(43_844, oneSecond.ChunkSamples);
    Equal(7_680, oneSecond.OverlapSamples);
    Equal(36_164, oneSecond.HopSamples);
    Equal(3_840, oneSecond.PrefixPaddingSamples);
    Equal(1, oneSecond.ChunkCount);

    var longAudio = BasicPitchChunkPlan.Create(BasicPitchInferenceService.RequiredSampleRate * 60);
    True(longAudio.ChunkCount > 1, "One minute of audio must be chunked.");
    True(longAudio.HopSamples == longAudio.ChunkSamples - longAudio.OverlapSamples, "Chunk hop must preserve the Spotify overlap contract.");
}

static void BasicPitchOnnxInference()
{
    var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
    if (string.IsNullOrWhiteSpace(modelPath))
        throw new InvalidOperationException("BASIC_PITCH_MODEL_PATH is required for the real-model regression test.");

    var samples = new float[BasicPitchInferenceService.RequiredSampleRate / 4];
    for (var i = 0; i < samples.Length; i++)
        samples[i] = (float)(Math.Sin(2 * Math.PI * 440 * i / BasicPitchInferenceService.RequiredSampleRate) * 0.15);

    using var inference = new BasicPitchInferenceService(modelPath, new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));
    var result = inference.Infer(new NormalizedAudio(samples, BasicPitchInferenceService.RequiredSampleRate));

    var expectedFrames = (int)Math.Floor(samples.Length * (BasicPitchInferenceService.AnnotationFramesPerSecond / (double)BasicPitchInferenceService.RequiredSampleRate));
    Equal(expectedFrames, result.Notes.Frames);
    Equal(expectedFrames, result.Onsets.Frames);
    Equal(expectedFrames, result.Contours.Frames);
    Equal(BasicPitchInferenceService.NoteBins, result.Notes.Bins);
    Equal(BasicPitchInferenceService.NoteBins, result.Onsets.Bins);
    Equal(BasicPitchInferenceService.ContourBins, result.Contours.Bins);
    True(result.Notes.Values.All(float.IsFinite), "Note activations must be finite.");
    True(result.Onsets.Values.All(float.IsFinite), "Onset activations must be finite.");
    True(result.Contours.Values.All(float.IsFinite), "Contour activations must be finite.");
    True(result.Notes.Values.All(value => value is >= 0f and <= 1f), "Note activations must be probabilities.");
    True(result.Onsets.Values.All(value => value is >= 0f and <= 1f), "Onset activations must be probabilities.");
    True(result.Contours.Values.All(value => value is >= 0f and <= 1f), "Contour activations must be probabilities.");
}

static byte[] BuildPcm16Wave(int sampleRate, IReadOnlyList<(short Left, short Right)> frames)
{
    const short channels = 2;
    const short bits = 16;
    const short blockAlign = channels * (bits / 8);
    var dataLength = checked(frames.Count * blockAlign);
    var bytes = new byte[44 + dataLength];
    "RIFF"u8.CopyTo(bytes.AsSpan(0, 4));
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(4, 4), 36 + dataLength);
    "WAVE"u8.CopyTo(bytes.AsSpan(8, 4));
    "fmt "u8.CopyTo(bytes.AsSpan(12, 4));
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(16, 4), 16);
    BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(20, 2), 1);
    BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(22, 2), channels);
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(24, 4), sampleRate);
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(28, 4), sampleRate * blockAlign);
    BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(32, 2), blockAlign);
    BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(34, 2), bits);
    "data"u8.CopyTo(bytes.AsSpan(36, 4));
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(40, 4), dataLength);

    var offset = 44;
    foreach (var frame in frames)
    {
        BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(offset, 2), frame.Left);
        BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(offset + 2, 2), frame.Right);
        offset += blockAlign;
    }

    return bytes;
}

static void Equal<T>(T expected, T actual)
{
    if (!EqualityComparer<T>.Default.Equals(expected, actual))
        throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
}

static void Nearly(float expected, float actual, float tolerance)
{
    if (Math.Abs(expected - actual) > tolerance)
        throw new InvalidOperationException($"Expected approximately {expected}, actual {actual}.");
}

static void True(bool condition, string? message = null)
{
    if (!condition)
        throw new InvalidOperationException(message ?? "Expected condition to be true.");
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
