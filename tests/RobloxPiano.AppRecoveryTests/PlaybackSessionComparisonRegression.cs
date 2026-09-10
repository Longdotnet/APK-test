using System.Runtime.CompilerServices;
using RobloxPiano.App;
using RobloxPiano.Core;

namespace RobloxPiano.AppRecoveryTests;

internal static class PlaybackSessionComparisonRegression
{
    private const string FingerprintA = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private const string FingerprintB = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

    [ModuleInitializer]
    internal static void VerifyControlledComparisonPolicy()
    {
        TestNoCompatibleBaseline();
        TestHealthyToTimingRegression();
        TestInputLatencyRegressionExplainsEnvironment();
        TestInterferenceBlocksPromotion();
        TestDifferentSettingsAreNotCompared();
        TestSameFilenameDifferentCanonicalPerformanceIsNotCompared();
        TestRenamedCanonicalPerformanceIsCompared();
        TestDifferentRuntimeIdentityIsNotCompared();
        TestDifferentTransportHistoryIsNotCompared();
        TestMissingTransportLedgerIsNotCompared();
        Console.WriteLine("PASS  controlled canonical session A/B comparison policy (10 cases)");
    }

    private static void TestNoCompatibleBaseline()
    {
        var current = Session("current", 20, Quality());
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(current, [current]);
        Equal(PlaybackSessionComparisonVerdict.NotComparable, assessment.Verdict, "no-baseline verdict");
        Contains(assessment.Guidance, "transport", "no-baseline transport reproduction guidance");
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

    private static void TestSameFilenameDifferentCanonicalPerformanceIsNotCompared()
    {
        var baseline = Session("baseline", 10, Quality(), fingerprint: FingerprintA);
        var current = Session("current", 20, Quality(), fingerprint: FingerprintB);
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(current, [current, baseline]);

        Equal(PlaybackSessionComparisonVerdict.NotComparable, assessment.Verdict, "same filename with changed canonical performance must not compare");
    }

    private static void TestRenamedCanonicalPerformanceIsCompared()
    {
        var baseline = Session("baseline", 10, Quality(), fileName: "old-name.mid", fingerprint: FingerprintA);
        var current = Session("current", 20, Quality(), fileName: "renamed.mid", fingerprint: FingerprintA);
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(current, [current, baseline]);

        Equal(PlaybackSessionComparisonVerdict.StableHealthy, assessment.Verdict, "renaming the same canonical performance must not break A/B identity");
        Equal("baseline", assessment.BaselineSessionId!, "renamed canonical baseline");
    }

    private static void TestDifferentRuntimeIdentityIsNotCompared()
    {
        var baseline = Session("baseline", 10, Quality());
        var differentEngine = Session("engine", 20, Quality(), engine: "experimental-transport-v2");
        var engineAssessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(differentEngine, [differentEngine, baseline]);
        Equal(PlaybackSessionComparisonVerdict.NotComparable, engineAssessment.Verdict, "engine mismatch must prevent comparison");

        var differentProfile = Session("profile", 30, Quality(), inputProfile: "other-input-profile");
        var profileAssessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(differentProfile, [differentProfile, baseline]);
        Equal(PlaybackSessionComparisonVerdict.NotComparable, profileAssessment.Verdict, "input-profile mismatch must prevent comparison");
    }

    private static void TestDifferentTransportHistoryIsNotCompared()
    {
        var baseline = Session("baseline", 10, Quality());
        var changedSpeed = Session("changed-speed", 20, Quality(controlEvents:
        [
            Start(1d),
            new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SpeedChanged, 1.5d, 1.25d)
        ]));
        var speedAssessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(changedSpeed, [changedSpeed, baseline]);
        Equal(PlaybackSessionComparisonVerdict.NotComparable, speedAssessment.Verdict, "runtime speed history mismatch must prevent comparison");

        var seeked = Session("seeked", 30, Quality(controlEvents:
        [
            Start(1d),
            new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SeekRequested, 2d, null)
        ]));
        var seekAssessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(seeked, [seeked, baseline]);
        Equal(PlaybackSessionComparisonVerdict.NotComparable, seekAssessment.Verdict, "seek history mismatch must prevent comparison");
    }

    private static void TestMissingTransportLedgerIsNotCompared()
    {
        var baseline = Session("baseline", 10, Quality());
        var oldSession = Session("old", 20, Quality(controlEvents: null));
        var assessment = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(oldSession, [oldSession, baseline]);

        Equal(PlaybackSessionComparisonVerdict.NotComparable, assessment.Verdict, "sessions without persisted transport history must fail closed");
        Contains(assessment.Guidance, "Older sessions", "legacy diagnostic fail-closed guidance");
    }

    private static PlaybackSupportSession Session(
        string id,
        int endedSecond,
        PlaybackSessionQualityDiagnostic quality,
        double speed = 1d,
        int inputLatencyMs = 0,
        string fileName = "song.mid",
        string fingerprint = FingerprintA,
        string engine = PlaybackRuntimeIdentity.Engine,
        string inputProfile = PlaybackRuntimeIdentity.InputProfile)
        => new(
            id,
            DateTimeOffset.UnixEpoch.AddSeconds(endedSecond - 5),
            DateTimeOffset.UnixEpoch.AddSeconds(endedSecond),
            "Completed",
            5d,
            null,
            fileName,
            "MIDI",
            speed,
            inputLatencyMs,
            42,
            1234L,
            null,
            null,
            quality,
            fingerprint,
            engine,
            inputProfile);

    private static PlaybackSessionQualityDiagnostic Quality(
        int missing = 0,
        int failures = 0,
        int focusPauses = 0,
        double focusMs = 0,
        double p95 = 2,
        double maxTiming = 4,
        double meanInput = 0.2,
        double maxInput = 0.5,
        IReadOnlyList<PlaybackTransportControlEvent>? controlEvents = default)
        => new(
            2,
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
            maxInput,
            controlEvents ?? [Start(1d)]);

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
