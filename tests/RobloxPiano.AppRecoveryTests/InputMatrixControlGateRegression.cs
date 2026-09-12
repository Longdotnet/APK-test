using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class InputMatrixControlGateRegression
{
    private static readonly RobloxInputMatrixSessionIdentity Session = new(
        new RobloxProcessIdentity(870, 87_000),
        0x8700);

    [ModuleInitializer]
    internal static void Verify()
    {
        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        try
        {
            SyntheticWinnerWithoutRealControlIsNotConclusive();
            SyntheticWinnerWithFailedRealControlIsNotConclusive();
            SyntheticWinnerWithPassingRealControlRemainsConclusive();
        }
        finally
        {
            RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        }
    }

    private static void SyntheticWinnerWithoutRealControlIsNotConclusive()
    {
        const string probe = "phase87-no-real-control";
        RecordClean(probe);

        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            new RobloxInputMatrixCellEvidence(
                "SENDINPUT_VK",
                probe,
                "ROBLOX_REACTED",
                true,
                Session)
        ],
        Session);

        Equal(RobloxInputMatrixVerdict.InsufficientEvidence, assessment.Verdict, "winner without physical control verdict");
        Equal("MATRIX_INCOMPLETE", assessment.FailureBoundary, "winner without physical control boundary");
        Contains(assessment.PendingCells, "REAL_KEY", "winner without physical control must request REAL_KEY");
        if (assessment.IsConclusive || assessment.WinningCells.Count != 0)
        {
            throw new InvalidOperationException("A synthetic reaction cannot become a matrix winner before a same-session real-W control visibly reacts.");
        }
    }

    private static void SyntheticWinnerWithFailedRealControlIsNotConclusive()
    {
        const string probe = "phase87-failed-real-control";
        RecordClean(probe);

        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            new RobloxInputMatrixCellEvidence(
                "REAL_KEY",
                "phase87-real-no",
                "ROBLOX_NO_REACTION",
                false,
                Session),
            new RobloxInputMatrixCellEvidence(
                "SENDINPUT_SCAN",
                probe,
                "ROBLOX_REACTED",
                true,
                Session)
        ],
        Session);

        Equal(RobloxInputMatrixVerdict.RealKeyBaselineInvalid, assessment.Verdict, "winner with failed physical control verdict");
        Equal("REAL_KEY_BASELINE", assessment.FailureBoundary, "winner with failed physical control boundary");
        if (assessment.IsConclusive || assessment.WinningCells.Count != 0)
        {
            throw new InvalidOperationException("A synthetic Yes must not outrank a physical control that did not visibly react on the selected Roblox surface.");
        }
    }

    private static void SyntheticWinnerWithPassingRealControlRemainsConclusive()
    {
        const string probe = "phase87-passing-real-control";
        RecordClean(probe);

        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            new RobloxInputMatrixCellEvidence(
                "REAL_KEY",
                "phase87-real-yes",
                "ROBLOX_REACTED",
                true,
                Session),
            new RobloxInputMatrixCellEvidence(
                "KEYBD_EVENT_SCAN",
                probe,
                "ROBLOX_REACTED",
                true,
                Session)
        ],
        Session);

        Equal(RobloxInputMatrixVerdict.SyntheticVariantWorks, assessment.Verdict, "winner with physical control verdict");
        Equal("SYNTHETIC_VARIANT_REACHES_ROBLOX", assessment.FailureBoundary, "winner with physical control boundary");
        Contains(assessment.WinningCells, "KEYBD_EVENT_SCAN", "winner with passing control must preserve exact winning cell");
        if (!assessment.IsConclusive)
        {
            throw new InvalidOperationException("A same-session real-W control plus clean visible synthetic reaction must remain conclusive evidence for the winning synthetic semantics.");
        }
    }

    private static void RecordClean(string probe)
        => RobloxInputMatrixProbeEvidenceRegistry.Record(
            probe,
            new WindowsLowLevelKeyboardProvenanceSnapshot(
                true,
                true,
                true,
                WindowsLowLevelKeyboardProvenance.LlkhfInjected,
                WindowsLowLevelKeyboardProvenance.LlkhfInjected,
                0x11,
                0x11,
                WindowsLowLevelKeyboardProvenanceKind.Injected,
                WindowsLowLevelKeyboardProvenanceKind.Injected)
            {
                TargetEventCount = 2,
                InjectedTargetEventCount = 2,
                UnexpectedTargetTransitionObserved = false
            });

    private static void Equal<T>(T expected, T actual, string name)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{name}: expected '{expected}', got '{actual}'.");
        }
    }

    private static void Contains(IReadOnlyList<string> values, string expected, string name)
    {
        if (!values.Contains(expected, StringComparer.Ordinal))
        {
            throw new InvalidOperationException($"{name}: expected '{expected}' in [{string.Join(",", values)}].");
        }
    }
}
