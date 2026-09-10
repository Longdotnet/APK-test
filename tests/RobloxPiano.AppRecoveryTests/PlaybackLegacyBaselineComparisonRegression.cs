using System.Runtime.CompilerServices;
using RobloxPiano.App;
using RobloxPiano.Core;

namespace RobloxPiano.AppRecoveryTests;

internal static class PlaybackLegacyBaselineComparisonRegression
{
    private const string FingerprintA = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private const string FingerprintB = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

    [ModuleInitializer]
    internal static void VerifyLegacyBaselineComparisonPolicy()
    {
        TestClassifiesLegacyVariants();
        TestHealthyControlledPair();
        TestSameVariantIsNotCounterpart();
        TestDifferentCanonicalPerformanceIsRejected();
        TestProportionalRuntimeSpeedHistoryIsAccepted();
        TestNonProportionalRuntimeSpeedHistoryIsRejected();
        TestInterferenceBlocksConclusion();
        TestMidiIsNotBaselineComparable();
        Console.WriteLine("PASS  controlled Legacy/Legacy x2 baseline comparison policy (8 cases)");
    }

    private static void TestClassifiesLegacyVariants()
    {
        Equal(PlaybackLegacyBaselineVariant.Legacy, PlaybackLegacyBaselineComparisonPolicy.Classify(Session("legacy", 10, 1d, Quality(1d))), "legacy classification");
        Equal(PlaybackLegacyBaselineVariant.LegacyX2, PlaybackLegacyBaselineComparisonPolicy.Classify(Session("x2", 20, 2d, Quality(2d))), "legacy x2 classification");
        Equal(PlaybackLegacyBaselineVariant.None, PlaybackLegacyBaselineComparisonPolicy.Classify(Session("custom", 30, 1.5d, Quality(1.5d))), "arbitrary speed must not become a protected baseline");
    }

    private static void TestHealthyControlledPair()
    {
        var legacy = Session("legacy", 10, 1d, Quality(1d, p95: 2, maxInput: 0.5));
        var x2 = Session("x2", 20, 2d, Quality(2d, p95: 2.5, maxInput: 0.6));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(x2, [x2, legacy]);

        Equal(PlaybackLegacyBaselineComparisonVerdict.StableHealthy, assessment.Verdict, "healthy pair verdict");
        Equal("legacy", assessment.CounterpartSessionId!, "counterpart session");
        Contains(assessment.Guidance, "Perceptual", "runtime comparison must retain perceptual boundary");
    }

    private static void TestSameVariantIsNotCounterpart()
    {
        var first = Session("legacy-1", 10, 1d, Quality(1d));
        var second = Session("legacy-2", 20, 1d, Quality(1d));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(second, [second, first]);
        Equal(PlaybackLegacyBaselineComparisonVerdict.NotComparable, assessment.Verdict, "same baseline variant must not satisfy cross-variant comparison");
    }

    private static void TestDifferentCanonicalPerformanceIsRejected()
    {
        var legacy = Session("legacy", 10, 1d, Quality(1d), fingerprint: FingerprintA);
        var x2 = Session("x2", 20, 2d, Quality(2d), fingerprint: FingerprintB);
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(x2, [x2, legacy]);
        Equal(PlaybackLegacyBaselineComparisonVerdict.NotComparable, assessment.Verdict, "different canonical track must fail closed");
    }

    private static void TestProportionalRuntimeSpeedHistoryIsAccepted()
    {
        var legacy = Session("legacy", 10, 1d, Quality(1d, controls:
        [
            Start(1d),
            new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SpeedChanged, 1.5d, 1.2d),
            new PlaybackTransportControlEvent(2, PlaybackTransportControlKind.SeekRequested, 2.5d, null)
        ]));
        var x2 = Session("x2", 20, 2d, Quality(2d, controls:
        [
            Start(2d),
            new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SpeedChanged, 1.5d, 2.4d),
            new PlaybackTransportControlEvent(2, PlaybackTransportControlKind.SeekRequested, 2.5d, null)
        ]));

        True(PlaybackLegacyBaselineComparisonPolicy.AreControlledCounterparts(x2, legacy), "proportional speed transitions and equal seek targets must remain controlled counterparts");
    }

    private static void TestNonProportionalRuntimeSpeedHistoryIsRejected()
    {
        var legacy = Session("legacy", 10, 1d, Quality(1d, controls:
        [
            Start(1d),
            new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SpeedChanged, 1d, 1.2d)
        ]));
        var x2 = Session("x2", 20, 2d, Quality(2d, controls:
        [
            Start(2d),
            new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SpeedChanged, 1d, 2.2d)
        ]));

        True(!PlaybackLegacyBaselineComparisonPolicy.AreControlledCounterparts(x2, legacy), "non-proportional speed transitions must fail closed");
    }

    private static void TestInterferenceBlocksConclusion()
    {
        var legacy = Session("legacy", 10, 1d, Quality(1d));
        var x2 = Session("x2", 20, 2d, Quality(2d, focusPauses: 1));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(x2, [x2, legacy]);
        Equal(PlaybackLegacyBaselineComparisonVerdict.Interfered, assessment.Verdict, "focus interference must block baseline conclusion");
        Contains(assessment.Guidance, "must never promote", "interference promotion boundary");
    }

    private static void TestMidiIsNotBaselineComparable()
    {
        var midi = Session("midi", 20, 2d, Quality(2d), sourceType: "MIDI");
        Equal(PlaybackLegacyBaselineVariant.None, PlaybackLegacyBaselineComparisonPolicy.Classify(midi), "MIDI x2 must not be mislabeled Legacy x2");
    }

    private static PlaybackSupportSession Session(
        string id,
        int endedSecond,
        double speed,
        PlaybackSessionQualityDiagnostic quality,
        string fingerprint = FingerprintA,
        string sourceType = "TXT")
        => new(
            id,
            DateTimeOffset.UnixEpoch.AddSeconds(endedSecond - 5),
            DateTimeOffset.UnixEpoch.AddSeconds(endedSecond),
            "Completed",
            5d,
            null,
            "song.txt",
            sourceType,
            speed,
            0,
            42,
            1234L,
            null,
            null,
            quality,
            fingerprint,
            PlaybackRuntimeIdentity.Engine,
            PlaybackRuntimeIdentity.InputProfile);

    private static PlaybackSessionQualityDiagnostic Quality(
        double initialSpeed,
        double p95 = 2,
        double maxInput = 0.5,
        int focusPauses = 0,
        IReadOnlyList<PlaybackTransportControlEvent>? controls = null)
        => new(
            2,
            1,
            controls?.Count(control => control.Kind == PlaybackTransportControlKind.SeekRequested) ?? 0,
            20,
            0,
            0,
            0,
            focusPauses,
            focusPauses > 0 ? 250 : 0,
            1,
            1,
            p95,
            Math.Max(4, p95),
            0.2,
            maxInput,
            controls ?? [Start(initialSpeed)]);

    private static PlaybackTransportControlEvent Start(double speed)
        => new(0, PlaybackTransportControlKind.SessionStarted, 0d, speed);

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
