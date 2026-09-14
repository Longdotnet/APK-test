using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class SectionAwareStemComposerRegression
{
    [ModuleInitializer]
    internal static void RunPhaseZeroRegressions()
    {
        Run("section-aware stem composition keeps vocal-led sections clean", VocalSectionsRemainAuthoritative);
        Run("section-aware stem composition recovers sustained instrumental hooks", SustainedVocalGapAdmitsAccompaniment);
        Run("section-aware stem composition rejects isolated accompaniment bursts", IsolatedBurstDoesNotLeak);
        Run("section-aware stem composition peak protection is bounded", PeakProtectionIsBounded);
        Run("section-aware stem composition honors cancellation", CancellationStopsComposition);
    }

    private static void VocalSectionsRemainAuthoritative()
    {
        const int sampleRate = 1000;
        var vocals = Constant(sampleRate, seconds: 2, amplitude: 0.12f);
        var accompaniment = Constant(sampleRate, seconds: 2, amplitude: 0.20f);
        var result = new SectionAwareStemComposer().Compose(vocals, accompaniment, Options());

        Equal(0, result.Diagnostics.FallbackWindows);
        True(ReferenceEquals(vocals, result.Audio), "No-fallback path should avoid allocating another full-song buffer.");
    }

    private static void SustainedVocalGapAdmitsAccompaniment()
    {
        const int sampleRate = 1000;
        var vocalSamples = new float[sampleRate * 3];
        var accompanimentSamples = new float[vocalSamples.Length];
        Fill(vocalSamples, 0, sampleRate, 0.12f);
        Fill(vocalSamples, sampleRate * 2, sampleRate * 3, 0.12f);
        Fill(accompanimentSamples, sampleRate, sampleRate * 2, 0.20f);

        var result = new SectionAwareStemComposer().Compose(
            new NormalizedAudio(vocalSamples, sampleRate),
            new NormalizedAudio(accompanimentSamples, sampleRate),
            Options());

        True(result.Diagnostics.FallbackWindows >= 2, "A sustained one-second vocal gap should admit the separated accompaniment hook.");
        True(result.Diagnostics.FallbackDuration >= TimeSpan.FromMilliseconds(800));
        True(Math.Abs(result.Audio.Samples[1500]) > 0.02f, "Fallback audio should be audible inside the sustained vocal gap.");
        True(Math.Abs(result.Audio.Samples[500] - 0.12f) < 0.01f, "Lead-vocal region must remain essentially unchanged.");
    }

    private static void IsolatedBurstDoesNotLeak()
    {
        const int sampleRate = 1000;
        var vocalSamples = new float[sampleRate * 2];
        var accompanimentSamples = new float[vocalSamples.Length];
        Fill(accompanimentSamples, 400, 800, 0.20f);

        var options = Options() with
        {
            WindowDuration = TimeSpan.FromMilliseconds(400),
            MinimumConsecutiveFallbackWindows = 2
        };
        var result = new SectionAwareStemComposer().Compose(
            new NormalizedAudio(vocalSamples, sampleRate),
            new NormalizedAudio(accompanimentSamples, sampleRate),
            options);

        Equal(0, result.Diagnostics.FallbackWindows);
        True(result.Audio.Samples.All(sample => Math.Abs(sample) < 0.0001f),
            "A single short accompaniment burst should not become melody truth.");
    }

    private static void PeakProtectionIsBounded()
    {
        const int sampleRate = 1000;
        var vocals = Constant(sampleRate, seconds: 2, amplitude: 0.015f);
        var accompaniment = Constant(sampleRate, seconds: 2, amplitude: 1.0f);
        var result = new SectionAwareStemComposer().Compose(
            vocals,
            accompaniment,
            Options() with { MaximumPeak = 0.20f, AccompanimentGain = 0.40f });

        True(result.Diagnostics.UsedAccompanimentFallback);
        True(result.Diagnostics.AppliedNormalizationGain < 1f);
        True(result.Audio.Samples.Max(sample => Math.Abs(sample)) <= 0.2001f);
    }

    private static void CancellationStopsComposition()
    {
        const int sampleRate = 1000;
        using var cancellation = new CancellationTokenSource();
        cancellation.Cancel();
        try
        {
            new SectionAwareStemComposer().Compose(
                Constant(sampleRate, 2, 0f),
                Constant(sampleRate, 2, 0.2f),
                Options(),
                cancellation.Token);
            throw new InvalidOperationException("Expected cancellation.");
        }
        catch (OperationCanceledException)
        {
        }
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
        Release: TimeSpan.Zero);

    private static NormalizedAudio Constant(int sampleRate, int seconds, float amplitude)
    {
        var samples = Enumerable.Repeat(amplitude, sampleRate * seconds).ToArray();
        return new NormalizedAudio(samples, sampleRate);
    }

    private static void Fill(float[] samples, int start, int end, float value)
    {
        for (var index = start; index < end; index++)
            samples[index] = value;
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
