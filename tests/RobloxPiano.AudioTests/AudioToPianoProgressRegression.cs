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
            TimeSpan.FromSeconds(1.2),
            midiPitch: 69);
        var audio = new NormalizedAudio(samples, BasicPitchInferenceService.RequiredSampleRate);
        var observed = new List<AudioToPianoTranscriptionProgress>();
        var progress = new InlineProgress<AudioToPianoTranscriptionProgress>(observed.Add);

        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));
        var result = service.TranscribeNormalized(
            audio,
            "Progress fixture",
            options: null,
            progress,
            CancellationToken.None);

        True(result.Arrangement.Track.Events.Count > 0, "The real-model progress fixture must create at least one canonical event.");
        True(observed.Count >= 6, $"Expected all post-ingest progress stages, observed {observed.Count}.");
        Equal(AudioToPianoTranscriptionStage.Inference, observed[0].Stage);
        Equal(AudioToPianoTranscriptionStage.Completed, observed[^1].Stage);
        Equal(1d, observed[^1].Fraction);
        True(observed.Count(item => item.Stage == AudioToPianoTranscriptionStage.Completed) == 1, "Completed must be emitted exactly once.");
        True(observed.All(item => item.Fraction is >= 0d and <= 1d), "Every progress fraction must be bounded.");
        True(observed.Zip(observed.Skip(1), (left, right) => right.Fraction >= left.Fraction).All(value => value), "Progress fractions must never move backwards.");
        True(observed.Select(item => item.Stage).SequenceEqual(new[]
        {
            AudioToPianoTranscriptionStage.Inference,
            AudioToPianoTranscriptionStage.Decode,
            AudioToPianoTranscriptionStage.HarmonicSuppression,
            AudioToPianoTranscriptionStage.Arrange,
            AudioToPianoTranscriptionStage.Quality,
            AudioToPianoTranscriptionStage.Completed
        }), "Normalized transcription must emit the deterministic production stage order.");

        var cancelledProgress = new List<AudioToPianoTranscriptionProgress>();
        using var cts = new CancellationTokenSource();
        cts.Cancel();
        Throws<OperationCanceledException>(() => service.TranscribeNormalized(
            audio,
            "Cancelled fixture",
            options: null,
            new InlineProgress<AudioToPianoTranscriptionProgress>(cancelledProgress.Add),
            cts.Token));
        True(cancelledProgress.Count == 0, "Pre-cancelled work must not emit misleading progress or Completed.");
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
