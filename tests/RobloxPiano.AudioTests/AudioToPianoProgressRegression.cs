using RobloxPiano.Audio;

internal static class AudioToPianoProgressRegression
{
    public static void ProgressIsMonotonicAndCancellationNeverCompletes()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            throw new InvalidOperationException("BASIC_PITCH_MODEL_PATH is required for Audio-to-Piano progress regression coverage.");

        var samples = PianoLikeTone(
            BasicPitchInferenceService.RequiredSampleRate,
            TimeSpan.FromSeconds(5.2),
            midiPitch: 69);
        var audio = new NormalizedAudio(samples, BasicPitchInferenceService.RequiredSampleRate);
        var observed = new List<AudioToPianoTranscriptionProgress>();
        var progress = new InlineProgress<AudioToPianoTranscriptionProgress>(observed.Add);

        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 1));
        var result = service.TranscribeNormalized(
            audio,
            "Progress fixture",
            options: null,
            progress,
            CancellationToken.None);

        True(result.Arrangement.Track.Events.Count > 0, "The real-model progress fixture must create at least one canonical event.");
        True(observed.Count >= 9, $"Expected chunk-level inference plus all post-inference stages, observed {observed.Count} events.");
        Equal(AudioToPianoTranscriptionStage.Inference, observed[0].Stage);
        Equal(AudioToPianoTranscriptionStage.Completed, observed[^1].Stage);
        Equal(1d, observed[^1].Fraction);
        True(observed.Count(item => item.Stage == AudioToPianoTranscriptionStage.Completed) == 1, "Completed must be emitted exactly once.");
        True(observed.All(item => item.Fraction is >= 0d and <= 1d), "Every progress fraction must be bounded.");
        True(observed.Zip(observed.Skip(1), (left, right) => right.Fraction >= left.Fraction).All(value => value), "Progress fractions must never move backwards.");

        var inferenceEvents = observed.Where(item => item.Stage == AudioToPianoTranscriptionStage.Inference).ToArray();
        True(inferenceEvents.Length >= 5, $"Long-song fixture must expose multiple inference updates; observed {inferenceEvents.Length}.");
        Equal(0.15d, inferenceEvents[0].Fraction);
        Equal(0.70d, inferenceEvents[^1].Fraction);
        True(inferenceEvents.Any(item => item.Fraction is > 0.15d and < 0.70d), "Inference progress must expose at least one intermediate fraction.");
        True(inferenceEvents.Any(item => item.Message.Contains("audio window", StringComparison.Ordinal)), "Inference progress must expose deterministic window counts.");
        True(observed.Take(inferenceEvents.Length).All(item => item.Stage == AudioToPianoTranscriptionStage.Inference), "No later stage may interleave before inference completes.");
        True(observed.Skip(inferenceEvents.Length).Select(item => item.Stage).SequenceEqual(new[]
        {
            AudioToPianoTranscriptionStage.Decode,
            AudioToPianoTranscriptionStage.HarmonicSuppression,
            AudioToPianoTranscriptionStage.Arrange,
            AudioToPianoTranscriptionStage.Quality,
            AudioToPianoTranscriptionStage.Completed
        }), "Post-inference transcription must retain the deterministic production stage order.");

        var cancelledProgress = new List<AudioToPianoTranscriptionProgress>();
        using var cts = new CancellationTokenSource();
        var cancellingProgress = new InlineProgress<AudioToPianoTranscriptionProgress>(value =>
        {
            cancelledProgress.Add(value);
            if (value.Stage == AudioToPianoTranscriptionStage.Inference && value.Fraction > 0.15d)
                cts.Cancel();
        });
        Throws<OperationCanceledException>(() => service.TranscribeNormalized(
            audio,
            "Cancelled during inference",
            options: null,
            cancellingProgress,
            cts.Token));
        True(cancelledProgress.Any(item => item.Stage == AudioToPianoTranscriptionStage.Inference && item.Fraction > 0.15d), "Cancellation fixture must prove at least one completed inference batch was surfaced.");
        True(cancelledProgress.All(item => item.Stage == AudioToPianoTranscriptionStage.Inference), "Cancellation during inference must not leak into decode or later stages.");
        True(cancelledProgress.All(item => item.Stage != AudioToPianoTranscriptionStage.Completed), "Cancelled work must never emit Completed.");

        var preCancelledProgress = new List<AudioToPianoTranscriptionProgress>();
        using var preCancelled = new CancellationTokenSource();
        preCancelled.Cancel();
        Throws<OperationCanceledException>(() => service.TranscribeNormalized(
            audio,
            "Pre-cancelled fixture",
            options: null,
            new InlineProgress<AudioToPianoTranscriptionProgress>(preCancelledProgress.Add),
            preCancelled.Token));
        True(preCancelledProgress.Count == 0, "Pre-cancelled work must not emit misleading progress or Completed.");
    }

    public static void ProgressContractFailsClosedOnInvalidValues()
    {
        Throws<ArgumentOutOfRangeException>(() => new AudioToPianoTranscriptionProgress(
            AudioToPianoTranscriptionStage.Inference,
            -0.01,
            "invalid"));
        Throws<ArgumentOutOfRangeException>(() => new AudioToPianoTranscriptionProgress(
            AudioToPianoTranscriptionStage.Inference,
            1.01,
            "invalid"));
        Throws<ArgumentException>(() => new AudioToPianoTranscriptionProgress(
            AudioToPianoTranscriptionStage.Inference,
            0.5,
            "   "));

        Throws<ArgumentOutOfRangeException>(() => new BasicPitchInferenceProgress(0, 0));
        Throws<ArgumentOutOfRangeException>(() => new BasicPitchInferenceProgress(-1, 4));
        Throws<ArgumentOutOfRangeException>(() => new BasicPitchInferenceProgress(5, 4));
        var midpoint = new BasicPitchInferenceProgress(2, 4);
        Equal(0.5d, midpoint.Fraction);
    }

    private static float[] PianoLikeTone(int sampleRate, TimeSpan duration, int midiPitch)
    {
        var sampleCount = checked((int)Math.Round(duration.TotalSeconds * sampleRate));
        var samples = new float[sampleCount];
        var fundamental = 440d * Math.Pow(2d, (midiPitch - 69) / 12d);

        for (var index = 0; index < samples.Length; index++)
        {
            var time = index / (double)sampleRate;
            var attack = Math.Min(1d, time / 0.015d);
            var decay = Math.Exp(-time / 0.75d);
            var envelope = attack * decay;
            var value = 0d;
            for (var harmonic = 1; harmonic <= 5; harmonic++)
            {
                value += Math.Sin(2d * Math.PI * fundamental * harmonic * time) / Math.Pow(harmonic, 1.55d);
            }

            samples[index] = (float)Math.Clamp(value * envelope * 0.18d, -0.95d, 0.95d);
        }

        return samples;
    }

    private sealed class InlineProgress<T>(Action<T> report) : IProgress<T>
    {
        public void Report(T value) => report(value);
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
    }

    private static void Throws<TException>(Action action) where TException : Exception
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
}