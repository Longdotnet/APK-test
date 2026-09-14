using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class DominantMelodyContinuityRegression
{
    [ModuleInitializer]
    internal static void RunPhaseZeroDominantMelodyRegressions()
    {
        Run("dominant melody continuity preserves a plausible instrumental contour", PlausibleContourRemainsEligible);
        Run("dominant melody continuity rejects erratic tonal jumps", ErraticTonalJumpsDoNotBecomeLeadTruth);
        Run("dominant melody continuity resets after a phrase gap", PhraseGapResetsContinuity);
    }

    private static void PlausibleContourRemainsEligible()
    {
        const int sampleRate = 8000;
        var vocals = Silence(sampleRate, 1.6d);
        var accompaniment = PiecewiseTones(sampleRate, new[] { 64, 65, 67, 69 }, 0.4d, 0.30f);

        var result = new SectionAwareStemComposer().Compose(vocals, accompaniment, Options());

        Equal(0, result.Diagnostics.RejectedDiscontinuousLeadWindows);
        True(result.Diagnostics.FallbackWindows >= 4,
            $"Expected the E4-F4-G4-A4 contour to remain usable, got {result.Diagnostics.FallbackWindows} fallback windows.");
        True(result.Audio.Samples.Any(sample => Math.Abs(sample) > 0.01f),
            "A coherent instrumental hook should reach the melody-focused source.");
    }

    private static void ErraticTonalJumpsDoNotBecomeLeadTruth()
    {
        const int sampleRate = 8000;
        var vocals = Silence(sampleRate, 1.6d);
        var accompaniment = PiecewiseTones(sampleRate, new[] { 64, 84, 55, 79 }, 0.4d, 0.30f);

        var result = new SectionAwareStemComposer().Compose(vocals, accompaniment, Options());

        True(result.Diagnostics.EnergyEligibleWindows >= 4,
            "Fixture must reach source-selection rather than failing the energy gate.");
        True(result.Diagnostics.RejectedDiscontinuousLeadWindows >= 2,
            $"Expected discontinuous tonal candidates to be rejected, got {result.Diagnostics.RejectedDiscontinuousLeadWindows}.");
        Equal(0, result.Diagnostics.FallbackWindows);
        True(ReferenceEquals(vocals, result.Audio),
            "Erratic per-window tonal peaks must not allocate or contaminate melody truth.");
    }

    private static void PhraseGapResetsContinuity()
    {
        const int sampleRate = 8000;
        var totalSeconds = 2.0d;
        var samples = new float[checked((int)Math.Round(totalSeconds * sampleRate))];
        AddTone(samples, sampleRate, 64, 0.0d, 0.8d, 0.30f);
        AddTone(samples, sampleRate, 79, 1.2d, 2.0d, 0.30f);

        var vocals = Silence(sampleRate, totalSeconds);
        var accompaniment = new NormalizedAudio(samples, sampleRate);
        var result = new SectionAwareStemComposer().Compose(vocals, accompaniment, Options());

        Equal(0, result.Diagnostics.RejectedDiscontinuousLeadWindows);
        True(result.Diagnostics.FallbackWindows >= 4,
            $"Two separate melodic phrases should both survive despite a large pitch change across silence; fallback={result.Diagnostics.FallbackWindows}.");
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
        RejectBassDominatedFallback: true,
        RequireLeadPitchContinuity: true,
        MaximumAdjacentLeadJumpSemitones: 19f);

    private static NormalizedAudio Silence(int sampleRate, double seconds) =>
        new(new float[checked((int)Math.Round(sampleRate * seconds))], sampleRate);

    private static NormalizedAudio PiecewiseTones(int sampleRate, IReadOnlyList<int> midiNotes, double secondsPerNote, float amplitude)
    {
        var samples = new float[checked((int)Math.Round(sampleRate * midiNotes.Count * secondsPerNote))];
        for (var index = 0; index < midiNotes.Count; index++)
        {
            var start = index * secondsPerNote;
            AddTone(samples, sampleRate, midiNotes[index], start, start + secondsPerNote, amplitude);
        }
        return new NormalizedAudio(samples, sampleRate);
    }

    private static void AddTone(float[] samples, int sampleRate, int midi, double startSeconds, double endSeconds, float amplitude)
    {
        var start = Math.Max(0, checked((int)Math.Round(startSeconds * sampleRate)));
        var end = Math.Min(samples.Length, checked((int)Math.Round(endSeconds * sampleRate)));
        var frequency = 440d * Math.Pow(2d, (midi - 69) / 12d);
        var ramp = Math.Max(1, sampleRate / 200);
        for (var sample = start; sample < end; sample++)
        {
            var local = sample - start;
            var remaining = end - sample - 1;
            var envelope = Math.Min(1d, Math.Min(local / (double)ramp, remaining / (double)ramp));
            samples[sample] += (float)(Math.Sin(2d * Math.PI * frequency * sample / sampleRate) * amplitude * Math.Max(0d, envelope));
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
