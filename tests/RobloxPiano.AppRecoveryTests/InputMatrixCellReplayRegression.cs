using System.Reflection;
using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class InputMatrixCellReplayRegression
{
    private static readonly RobloxInputMatrixSessionIdentity Session = new(
        new RobloxProcessIdentity(880, 88_000),
        0x8800);

    [ModuleInitializer]
    internal static void Verify()
    {
        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        try
        {
            ClientDialogRetainsAttemptHistory();
            SyntheticNoThenYesCannotBecomeWinner();
            SyntheticYesThenNoCannotBecomeAllSyntheticFailure();
            DuplicateRealKeyCannotRewriteControl();
            IncompleteThenConfirmedRetryStillWorks();
        }
        finally
        {
            RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        }
    }

    private static void ClientDialogRetainsAttemptHistory()
    {
        var field = typeof(RobloxInputCheckDialog).GetField("_matrixCells", BindingFlags.Instance | BindingFlags.NonPublic);
        if (field is null)
        {
            throw new InvalidOperationException("client matrix retention field was not found.");
        }

        Equal(
            typeof(List<RobloxInputMatrixCellEvidence>),
            field.FieldType,
            "client matrix retention must preserve repeated attempts instead of overwriting by cell");
    }

    private static void SyntheticNoThenYesCannotBecomeWinner()
    {
        const string first = "phase89-sendinput-vk-no";
        const string second = "phase89-sendinput-vk-yes";
        RecordClean(first);
        RecordClean(second);

        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            PassingRealKey(),
            new RobloxInputMatrixCellEvidence("SENDINPUT_VK", first, "ROBLOX_NO_REACTION", false, Session),
            new RobloxInputMatrixCellEvidence("SENDINPUT_VK", second, "ROBLOX_REACTED", true, Session)
        ],
        Session);

        Replay(assessment, "SENDINPUT_VK", "synthetic no->yes replay");
    }

    private static void SyntheticYesThenNoCannotBecomeAllSyntheticFailure()
    {
        const string first = "phase89-sendinput-scan-yes";
        const string second = "phase89-sendinput-scan-no";
        RecordClean(first);
        RecordClean(second);

        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            PassingRealKey(),
            new RobloxInputMatrixCellEvidence("SENDINPUT_SCAN", first, "ROBLOX_REACTED", true, Session),
            new RobloxInputMatrixCellEvidence("SENDINPUT_SCAN", second, "ROBLOX_NO_REACTION", false, Session)
        ],
        Session);

        Replay(assessment, "SENDINPUT_SCAN", "synthetic yes->no replay");
    }

    private static void DuplicateRealKeyCannotRewriteControl()
    {
        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            new RobloxInputMatrixCellEvidence("REAL_KEY", "phase89-real-no", "ROBLOX_NO_REACTION", false, Session),
            new RobloxInputMatrixCellEvidence("REAL_KEY", "phase89-real-yes", "ROBLOX_REACTED", true, Session)
        ],
        Session);

        Replay(assessment, "REAL_KEY", "real-key replay");
    }

    private static void IncompleteThenConfirmedRetryStillWorks()
    {
        const string confirmed = "phase89-retry-confirmed";
        RecordClean(confirmed);

        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            PassingRealKey(),
            new RobloxInputMatrixCellEvidence("SENDINPUT_VK", "phase89-retry-incomplete", "WINDOWS_BOUNDARY_NOT_CONFIRMED", null, Session),
            new RobloxInputMatrixCellEvidence("SENDINPUT_VK", confirmed, "ROBLOX_NO_REACTION", false, Session)
        ],
        Session);

        if (assessment.FailureBoundary == "MATRIX_CELL_REPLAY")
        {
            throw new InvalidOperationException("incomplete-to-first-confirmed retry must remain valid after client history retention.");
        }
    }

    private static RobloxInputMatrixCellEvidence PassingRealKey()
        => new("REAL_KEY", "phase89-real-control", "ROBLOX_REACTED", true, Session);

    private static void Replay(RobloxInputMatrixAssessment assessment, string cell, string name)
    {
        Equal(RobloxInputMatrixVerdict.InsufficientEvidence, assessment.Verdict, $"{name} verdict");
        Equal("MATRIX_CELL_REPLAY", assessment.FailureBoundary, $"{name} boundary");
        Contains(assessment.PendingCells, cell, $"{name} pending cell");
        if (assessment.IsConclusive || assessment.WinningCells.Count != 0 || assessment.FailingCells.Count != 0)
        {
            throw new InvalidOperationException($"{name}: repeated cell evidence must not produce a winner or failure boundary.");
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
