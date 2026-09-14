using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class BassDominanceFallbackRegression
{
    [ModuleInitializer]
    internal static void RunBassDominanceFallbackRegressions()
    {
        Run("bass-dominated instrumental fallback is rejected", BassOnlyFallbackIsRejected);
        Run("lead melody remains eligible over restrained bass", LeadOverBassIsAdmitted);
        Run("bass rejection is observable", BassRejectionIsObservable);
    }

    private static void BassOnlyFallbackIsRejected()
    {
        const int sampleRate = 4000;
        var vocals = new float[sampleRate * 2];
        var accompaniment = new float[vocals.Length];
        AddTone(accompaniment, sampleRate, 40, 0.05d, 1.95d, 0.28f);

        var result = Compose(vocals, accompaniment, sampleRate);

        True(result.Diagnostics.EnergyEligibleWindows >= 4,
            "Bass fixture must reach source selection so this proves bass rejection rather than RMS rejection.");
        True(result.Diagnostics.RejectedBassDominatedWindows >= 4,
            $"Expected bass-dominated windows to be rejected; got {result.Diagnostics.RejectedBassDominatedWindows}.");
        Equal(0, result.Diagnostics.FallbackWindows);
        True(result.Audio.Samples.All(sample => Math.Abs(sample) < 0.0001f),
            "Bass-only accompaniment must not become Create Piano melody truth.");
    }

    private static void LeadOverBassIsAdmitted()
    {
        const int sampleRate = 4000;
        var vocals = new float[sampleRate * 2];
        var accompaniment = new float[vocals.Length];
        AddTone(accompaniment, sampleRate, 64, 0.05d, 1.95d, 0.26f);
        AddTone(accompaniment, sampleRate, 40, 0.05d, 1.95d, 0.06f);

        var result = Compose(vocals, accompaniment, sampleRate);

        True(result.Diagnostics.FallbackWindows >= 4,
            $"A clear lead hook over restrained bass must remain eligible; got {result.Diagnostics.FallbackWindows} fallback windows.");
        True(result.Audio.Samples.Any(sample => Math.Abs(sample) > 0.005f),
            "Lead-bearing accompaniment should reach the one-pass Basic Pitch source.");
    }

    private static void BassRejectionIsObservable()
    {
        const int sampleRate = 4000;
        var vocals = new float[sampleRate];
        var accompaniment = new float[vocals.Length];
        AddTone(accompaniment, sampleRate, 43, 0d, 1d, 0.24f);

        var result = new SectionAwareStemComposer().Compose(
            new NormalizedAudio(vocals, sampleRate),
            new NormalizedAudio(accompaniment, sampleRate),
            Options() with { MinimumConsecutiveFallbackWindows = 1 });

        True(result.Diagnostics.RejectedBassDominatedWindows > 0);
        Equal(0, result.Diagnostics.FallbackWindows);
    }

    private static SectionAwareStemCompositionResult Compose(float[] vocals, float[] accompaniment, int sampleRate) =>
        new SectionAwareStemComposer().Compose(new NormalizedAudio(vocals, sampleRate), new NormalizedAudio(accompaniment, sampleRate), Options());

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
        MelodicAnalysisTargetSampleRate: 4000,
        RejectBassDominatedFallback: true,
        BassBandMinimumFrequencyHz: 55f,
        BassBandMaximumFrequencyHz: 146.83f,
        MinimumLeadBandFrequencyHz: 146.83f,
        MinimumLeadToBassCorrelationRatio: 0.80f,
        MaximumLeadBoundaryLagSlack: 1);

    private static void AddTone(float[] samples, int sampleRate, int midi, double startSeconds, double endSeconds, float amplitude)
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
        try { action(); Console.WriteLine($"PASS {name}"); }
        catch (Exception exception) { Console.Error.WriteLine($"FAIL {name}: {exception}"); Environment.ExitCode = 1; }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual)) throw new InvalidOperationException($"Expected {expected}, got {actual}.");
    }

    private static void True(bool value, string? message = null)
    {
        if (!value) throw new InvalidOperationException(message ?? "Expected condition to be true.");
    }
}
