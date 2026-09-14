using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class MelodicFallbackGateRegression
{
    [ModuleInitializer]
    internal static void RunMelodicFallbackGateRegressions()
    {
        Run("melodic fallback gate admits a sustained pitched hook", SustainedPitchedHookIsAdmitted);
        Run("melodic fallback gate rejects sustained broadband percussion-like energy", SustainedNoiseIsRejected);
        Run("melodic fallback gate reports rejected non-melodic windows", RejectionIsObservable);
    }

    private static void SustainedPitchedHookIsAdmitted()
    {
        const int sampleRate = 4000;
        var vocal = new float[sampleRate * 2];
        var accompaniment = new float[vocal.Length];
        AddTone(accompaniment, sampleRate, 64, 0.05d, 1.95d, 0.25f);

        var result = new SectionAwareStemComposer().Compose(
            new NormalizedAudio(vocal, sampleRate),
            new NormalizedAudio(accompaniment, sampleRate),
            Options());

        True(result.Diagnostics.EnergyEligibleWindows >= 4,
            $"Expected pitched hook energy to be eligible; got {result.Diagnostics.EnergyEligibleWindows} windows.");
        Equal(0, result.Diagnostics.RejectedNonMelodicWindows);
        True(result.Diagnostics.FallbackWindows >= 4,
            $"A sustained pitched hook should survive the melodic gate; got {result.Diagnostics.FallbackWindows} fallback windows.");
    }

    private static void SustainedNoiseIsRejected()
    {
        const int sampleRate = 4000;
        var vocal = new float[sampleRate * 2];
        var accompaniment = DeterministicNoise(vocal.Length, 0.24f);

        var result = new SectionAwareStemComposer().Compose(
            new NormalizedAudio(vocal, sampleRate),
            new NormalizedAudio(accompaniment, sampleRate),
            Options());

        True(result.Diagnostics.EnergyEligibleWindows >= 4,
            "Broadband energy must reach the melodic gate so the test proves tonal rejection rather than RMS rejection.");
        Equal(result.Diagnostics.EnergyEligibleWindows, result.Diagnostics.RejectedNonMelodicWindows);
        Equal(0, result.Diagnostics.FallbackWindows);
        True(result.Audio.Samples.All(sample => Math.Abs(sample) < 0.0001f),
            "Sustained percussion-like broadband energy must not become melody truth.");
    }

    private static void RejectionIsObservable()
    {
        const int sampleRate = 4000;
        var samples = DeterministicNoise(sampleRate, 0.20f);
        var result = new SectionAwareStemComposer().Compose(
            new NormalizedAudio(new float[samples.Length], sampleRate),
            new NormalizedAudio(samples, sampleRate),
            Options() with { MinimumConsecutiveFallbackWindows = 1 });

        True(result.Diagnostics.EnergyEligibleWindows > 0);
        True(result.Diagnostics.RejectedNonMelodicWindows > 0);
        Equal(0, result.Diagnostics.FallbackWindows);
    }

    private static SectionAwareStemCompositionOptions Options() => new(
        WindowDuration: TimeSpan.FromMilliseconds(400),
        MinimumConsecutiveFallbackWindows: 2,
        MaximumVocalRms: 0.02f,
        MinimumAccompanimentRms: 0.01f,
        MinimumAccompanimentToVocalRatio: 1.4d,
        AccompanimentGain: 0.24f,
        MaximumPeak: 0.98f,
        Attack: TimeSpan.Zero,
        Release: TimeSpan.Zero,
        RequireMelodicFallback: true,
        MinimumMelodicAutocorrelation: 0.28f,
        MinimumLeadFrequencyHz: 110f,
        MaximumLeadFrequencyHz: 1200f,
        MelodicAnalysisTargetSampleRate: 4000);

    private static float[] DeterministicNoise(int length, float amplitude)
    {
        var samples = new float[length];
        uint state = 0x9E3779B9u;
        for (var index = 0; index < samples.Length; index++)
        {
            state = unchecked((state * 1664525u) + 1013904223u);
            var normalized = ((state >> 8) & 0x00FFFFFFu) / 8388607.5f - 1f;
            samples[index] = normalized * amplitude;
        }
        return samples;
    }

    private static void AddTone(
        float[] samples,
        int sampleRate,
        int midi,
        double startSeconds,
        double endSeconds,
        float amplitude)
    {
        var start = Math.Max(0, checked((int)Math.Round(startSeconds * sampleRate)));
        var end = Math.Min(samples.Length, checked((int)Math.Round(endSeconds * sampleRate)));
        var frequency = 440d * Math.Pow(2d, (midi - 69) / 12d);
        var ramp = Math.Max(1, sampleRate / 100);
        for (var index = start; index < end; index++)
        {
            var local = index - start;
            var remaining = end - index - 1;
            var envelope = Math.Min(1d, Math.Min(local / (double)ramp, remaining / (double)ramp));
            samples[index] += (float)(Math.Sin(2d * Math.PI * frequency * index / sampleRate) * amplitude * Math.Max(0d, envelope));
        }
    }

    private static void Run(string name, Action action)
    {
        try
        {
            action();
            Console.WriteLine($"PASS {name}");
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"FAIL {name}: {exception}");
            Environment.ExitCode = 1;
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, got {actual}.");
    }

    private static void True(bool value, string? message = null)
    {
        if (!value)
            throw new InvalidOperationException(message ?? "Expected condition to be true.");
    }
}
