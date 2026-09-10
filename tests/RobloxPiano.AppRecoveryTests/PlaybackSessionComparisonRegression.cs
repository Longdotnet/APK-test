using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class PlaybackSessionComparisonRegression
{
    [ModuleInitializer]
    internal static void VerifyControlledComparisonPolicy()
    {
        TestNoCompatibleBaseline();
        TestHealthyToTimingRegression();
        TestInputLatencyRegressionExplainsEnvironment();
        TestInterferenceBlocksPromotion();
        TestDifferentSettingsAreNotCompared();
        Console.WriteLine("PASS  controlled session A/B comparison policy (5 cases)");
    }

    private static void TestNoCompatibleBaseline()
    {
        var current = Session("current", 20, Quality());
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(current, [current]);
        Equal(PlaybackSessionComparisonVerdict.NotComparable, assessment.Verdict, "no-baseline verdict");
        Contains(assessment.Guidance, "same song", "no-baseline reproduction guidance");
    }

    private static void TestHealthyToTimingRegression()
    {
        var baseline = Session("baseline", 10, Quality(p95: 2, maxTiming: 4));
        var current = Session("current", 20, Quality(p95: 18, maxTiming: 35));
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(current, [current, baseline]);

        Equal(PlaybackSessionComparisonVerdict.Regressed, assessment.Verdict, "timing regression verdict");
        Equal("baseline", assessment.BaselineSessionId!, "selected baseline");
        True(assessment.P95TimingDeltaMilliseconds > 10, "timing regression delta");
        Contains(assessment.Guidance, "Scheduler timing", "timing-specific regression guidance");
        Contains(assessment.Guidance, "Legacy/Legacy x2", "baseline promotion boundary");
    }

    private static void TestInputLatencyRegressionExplainsEnvironment()
    {
        var baseline = Session("baseline", 10, Quality(maxInput: 0.5));
        var current = Session("current", 20, Quality(maxInput: 20));
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(current, [baseline, current]);

        Equal(PlaybackSessionComparisonVerdict.Regressed, assessment.Verdict, "input regression verdict");
        Contains(assessment.Guidance, "Windows input delivery", "input-specific regression guidance");
        Contains(assessment.Guidance, "background workloads", "environment recovery guidance");
    }

    private static void TestInterferenceBlocksPromotion()
    {
        var baseline = Session("baseline", 10, Quality());
        var current = Session("current", 20, Quality(focusPauses: 1, focusMs: 250));
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(current, [current, baseline]);

        Equal(PlaybackSessionComparisonVerdict.Interfered, assessment.Verdict, "interfered verdict");
        Contains(assessment.Guidance, "must not promote", "interference must block engine conclusions");
    }

    private static void TestDifferentSettingsAreNotCompared()
    {
        var baseline = Session("baseline", 10, Quality(), speed: 1d);
        var current = Session("current", 20, Quality(p95: 20), speed: 1.25d);
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(current, [current, baseline]);

        Equal(PlaybackSessionComparisonVerdict.NotComparable, assessment.Verdict, "speed mismatch must prevent comparison");
    }

    private static PlaybackSupportSession Session(
        string id,
        int endedSecond,
        PlaybackSessionQualityDiagnostic quality,
        double speed = 1d,
        int inputLatencyMs = 0)
        => new(
            id,
            DateTimeOffset.UnixEpoch.AddSeconds(endedSecond - 5),
            DateTimeOffset.UnixEpoch.AddSeconds(endedSecond),
            "Completed",
            5d,
            null,
            "song.mid",
            "MIDI",
            speed,
            inputLatencyMs,
            42,
            1234L,
            null,
            null,
            quality);

    private static PlaybackSessionQualityDiagnostic Quality(
        int missing = 0,
        int failures = 0,
        int focusPauses = 0,
        double focusMs = 0,
        double p95 = 2,
        double maxTiming = 4,
        double meanInput = 0.2,
        double maxInput = 0.5)
        => new(
            1,
            1,
            0,
            20,
            missing,
            0,
            failures,
            focusPauses,
            focusMs,
            1,
            1,
            p95,
            maxTiming,
            meanInput,
            maxInput);

    private static void Contains(string actual, string expected, string message)
    {
        if (!actual.Contains(expected, StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}' in '{actual}'.");
        }
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }
}
