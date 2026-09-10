using System.Runtime.CompilerServices;
using RobloxPiano.App;
using RobloxPiano.Core;

namespace RobloxPiano.AppRecoveryTests;

internal static class PlaybackLegacyBaselineComparisonRegression
{
    private const string FingerprintA = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private const string FingerprintB = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
    private const string CampaignA = "11111111111111111111111111111111";
    private const string CampaignB = "22222222222222222222222222222222";

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
        TestStaleHistoricalCounterpartIsRejected();
        TestNewerSameVariantBlocksHistoricalCherryPick();
        TestNewerMismatchedTransportBlocksHistoricalCherryPick();
        TestDifferentSongBaselineBreaksReproductionAdjacency();
        TestExplicitCampaignSurvivesUnrelatedInterveningSession();
        TestDifferentExplicitCampaignNeverPairs();
        TestExplicitCampaignDoesNotFallBackToUnscopedHistory();
        TestCampaignIdParsingFailsClosed();
        TestGuidedCampaignStartsAtLegacy();
        TestGuidedCampaignAdvancesToLegacyX2();
        TestGuidedCampaignCompletesControlledPair();
        TestGuidedCampaignRejectsWrongOrder();
        TestGuidedCampaignRejectsDuplicateLegacyStep();
        TestGuidedCampaignRejectsChangedTransportStep();
        Console.WriteLine("PASS  controlled Legacy/Legacy x2 baseline comparison + guided campaign state policy (22 cases)");
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
        Contains(assessment.Guidance, "will not skip", "same-variant run must block historical cherry-picking");
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

    private static void TestStaleHistoricalCounterpartIsRejected()
    {
        var legacy = Session("legacy-old", 10, 1d, Quality(1d));
        var x2 = Session("x2-now", 4000, 2d, Quality(2d));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(x2, [x2, legacy]);

        Equal(PlaybackLegacyBaselineComparisonVerdict.NotComparable, assessment.Verdict, "stale historical run must not be reused as reproduction evidence");
        Contains(assessment.Summary, "30", "bounded pairing window must be visible to support");
        True(!assessment.HasCounterpart, "stale historical run must not be attached as counterpart");
    }

    private static void TestNewerSameVariantBlocksHistoricalCherryPick()
    {
        var oldLegacy = Session("legacy-old", 10, 1d, Quality(1d));
        var newerX2 = Session("x2-newer", 20, 2d, Quality(2d));
        var currentX2 = Session("x2-current", 30, 2d, Quality(2d));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(currentX2, [currentX2, newerX2, oldLegacy]);

        Equal(PlaybackLegacyBaselineComparisonVerdict.NotComparable, assessment.Verdict, "newer same-variant baseline must block fallback to an older opposite variant");
        True(!assessment.HasCounterpart, "comparator must not cherry-pick the older legacy run");
    }

    private static void TestNewerMismatchedTransportBlocksHistoricalCherryPick()
    {
        var oldLegacy = Session("legacy-old", 10, 1d, Quality(1d));
        var changedLegacy = Session("legacy-changed", 20, 1d, Quality(1d, controls:
        [
            Start(1d),
            new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SeekRequested, 3d, null)
        ]));
        var currentX2 = Session("x2-current", 30, 2d, Quality(2d));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(currentX2, [currentX2, changedLegacy, oldLegacy]);

        Equal(PlaybackLegacyBaselineComparisonVerdict.NotComparable, assessment.Verdict, "newest opposite variant with mismatched transport must block fallback to older clean evidence");
        Contains(assessment.Guidance, "fails closed", "transport mismatch must explain fail-closed behavior");
        True(!assessment.HasCounterpart, "older clean run must not be selected after a newer mismatched reproduction attempt");
    }

    private static void TestDifferentSongBaselineBreaksReproductionAdjacency()
    {
        var oldLegacyA = Session("legacy-a", 10, 1d, Quality(1d), fingerprint: FingerprintA);
        var interveningLegacyB = Session("legacy-b", 20, 1d, Quality(1d), fingerprint: FingerprintB);
        var currentX2A = Session("x2-a", 30, 2d, Quality(2d), fingerprint: FingerprintA);
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(
            currentX2A,
            [currentX2A, interveningLegacyB, oldLegacyA]);

        Equal(PlaybackLegacyBaselineComparisonVerdict.NotComparable, assessment.Verdict, "an intervening protected baseline for another song must break the reproduction sequence");
        Contains(assessment.Summary, "immediately previous", "support guidance must explain strict baseline adjacency");
        True(!assessment.HasCounterpart, "comparator must not skip a different-song baseline to cherry-pick older matching evidence");
    }

    private static void TestExplicitCampaignSurvivesUnrelatedInterveningSession()
    {
        var legacy = Session(CampaignSessionId(CampaignA, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), 10, 1d, Quality(1d));
        var unrelated = Session("unscoped-other-song", 20, 1d, Quality(1d), fingerprint: FingerprintB);
        var x2 = Session(CampaignSessionId(CampaignA, "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"), 30, 2d, Quality(2d));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(x2, [x2, unrelated, legacy]);

        Equal(PlaybackLegacyBaselineComparisonVerdict.StableHealthy, assessment.Verdict, "explicit campaign provenance must survive unrelated untagged sessions");
        Equal(legacy.SessionId, assessment.CounterpartSessionId!, "explicit campaign counterpart");
        Contains(assessment.Summary, CampaignA[..8], "campaign provenance must be visible in runtime evidence");
    }

    private static void TestDifferentExplicitCampaignNeverPairs()
    {
        var legacyA = Session(CampaignSessionId(CampaignA, "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"), 10, 1d, Quality(1d));
        var x2B = Session(CampaignSessionId(CampaignB, "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"), 20, 2d, Quality(2d));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(x2B, [x2B, legacyA]);

        Equal(PlaybackLegacyBaselineComparisonVerdict.NotComparable, assessment.Verdict, "different explicit campaigns must never pair");
        True(!assessment.HasCounterpart, "different campaign must not be attached as counterpart");
        Contains(assessment.Guidance, "will not fall back", "explicit campaign must reject historical fallback");
    }

    private static void TestExplicitCampaignDoesNotFallBackToUnscopedHistory()
    {
        var oldLegacy = Session("legacy-unscoped", 10, 1d, Quality(1d));
        var currentX2 = Session(CampaignSessionId(CampaignA, "cccccccccccccccccccccccccccccccc"), 20, 2d, Quality(2d));
        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(currentX2, [currentX2, oldLegacy]);

        Equal(PlaybackLegacyBaselineComparisonVerdict.NotComparable, assessment.Verdict, "explicit campaign must not fall back to compatible unscoped history");
        True(!assessment.HasCounterpart, "unscoped history must never satisfy an explicit campaign");
    }

    private static void TestCampaignIdParsingFailsClosed()
    {
        Equal(CampaignA, PlaybackBaselineCampaignStore.TryGetCampaignId(CampaignSessionId(CampaignA, "dddddddddddddddddddddddddddddddd"))!, "valid campaign id parse");
        True(PlaybackBaselineCampaignStore.TryGetCampaignId("baseline-not-a-guid-session") is null, "malformed campaign prefix must fail closed");
        True(PlaybackBaselineCampaignStore.TryGetCampaignId("ordinary-session") is null, "ordinary session id must remain unscoped");
    }

    private static void TestGuidedCampaignStartsAtLegacy()
    {
        var campaign = Campaign();
        var progress = PlaybackBaselineCampaignStore.EvaluateProgress(campaign, [], DateTimeOffset.UnixEpoch.AddSeconds(1));
        Equal(PlaybackBaselineCampaignProgressState.AwaitLegacy, progress.State, "new campaign must start at Legacy step");
        Contains(progress.NextAction, "1.00x", "first guided action must name Legacy 1.00x");
    }

    private static void TestGuidedCampaignAdvancesToLegacyX2()
    {
        var campaign = Campaign();
        var legacy = Session(CampaignSessionId(CampaignA, "11111111111111111111111111111111"), 10, 1d, Quality(1d));
        var progress = PlaybackBaselineCampaignStore.EvaluateProgress(campaign, [legacy], DateTimeOffset.UnixEpoch.AddSeconds(11));
        Equal(PlaybackBaselineCampaignProgressState.AwaitLegacyX2, progress.State, "valid Legacy step must advance campaign");
        Equal(legacy.SessionId, progress.LegacySessionId!, "Legacy evidence must be locked into campaign progress");
        Contains(progress.NextAction, "2.00x", "second guided action must name Legacy x2 2.00x");
    }

    private static void TestGuidedCampaignCompletesControlledPair()
    {
        var campaign = Campaign();
        var legacy = Session(CampaignSessionId(CampaignA, "11111111111111111111111111111111"), 10, 1d, Quality(1d));
        var x2 = Session(CampaignSessionId(CampaignA, "22222222222222222222222222222222"), 20, 2d, Quality(2d));
        var progress = PlaybackBaselineCampaignStore.EvaluateProgress(campaign, [x2, legacy], DateTimeOffset.UnixEpoch.AddSeconds(21));
        Equal(PlaybackBaselineCampaignProgressState.Completed, progress.State, "controlled ordered pair must complete campaign");
        True(!progress.AcceptsNewEvidence, "completed campaign must stop accepting evidence");
        Equal(x2.SessionId, progress.LegacyX2SessionId!, "Legacy x2 evidence must be locked into completed progress");
    }

    private static void TestGuidedCampaignRejectsWrongOrder()
    {
        var campaign = Campaign();
        var x2 = Session(CampaignSessionId(CampaignA, "11111111111111111111111111111111"), 10, 2d, Quality(2d));
        var progress = PlaybackBaselineCampaignStore.EvaluateProgress(campaign, [x2], DateTimeOffset.UnixEpoch.AddSeconds(11));
        Equal(PlaybackBaselineCampaignProgressState.Invalidated, progress.State, "Legacy x2 cannot become Step 1");
        Contains(progress.NextAction, "Step 1", "wrong-order guidance must explain required first step");
    }

    private static void TestGuidedCampaignRejectsDuplicateLegacyStep()
    {
        var campaign = Campaign();
        var legacy1 = Session(CampaignSessionId(CampaignA, "11111111111111111111111111111111"), 10, 1d, Quality(1d));
        var legacy2 = Session(CampaignSessionId(CampaignA, "22222222222222222222222222222222"), 20, 1d, Quality(1d));
        var progress = PlaybackBaselineCampaignStore.EvaluateProgress(campaign, [legacy2, legacy1], DateTimeOffset.UnixEpoch.AddSeconds(21));
        Equal(PlaybackBaselineCampaignProgressState.Invalidated, progress.State, "duplicate Legacy cannot replace Legacy x2 Step 2");
        True(!progress.AcceptsNewEvidence, "invalid campaign must stop accepting evidence");
    }

    private static void TestGuidedCampaignRejectsChangedTransportStep()
    {
        var campaign = Campaign();
        var legacy = Session(CampaignSessionId(CampaignA, "11111111111111111111111111111111"), 10, 1d, Quality(1d, controls:
        [
            Start(1d),
            new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SeekRequested, 3d, null)
        ]));
        var x2 = Session(CampaignSessionId(CampaignA, "22222222222222222222222222222222"), 20, 2d, Quality(2d));
        var progress = PlaybackBaselineCampaignStore.EvaluateProgress(campaign, [x2, legacy], DateTimeOffset.UnixEpoch.AddSeconds(21));
        Equal(PlaybackBaselineCampaignProgressState.Invalidated, progress.State, "changed transport history must invalidate guided pair");
        Contains(progress.Summary, "transport", "invalid campaign must expose transport mismatch");
    }

    private static PlaybackBaselineCampaign Campaign()
        => new(
            CampaignA,
            DateTimeOffset.UnixEpoch,
            DateTimeOffset.UnixEpoch.AddMinutes(30),
            FingerprintA,
            "TXT",
            0,
            PlaybackRuntimeIdentity.Engine,
            PlaybackRuntimeIdentity.InputProfile);

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

    private static string CampaignSessionId(string campaignId, string sessionSuffix)
        => $"{PlaybackBaselineCampaignStore.SessionIdPrefix}{campaignId}-{sessionSuffix}";

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
