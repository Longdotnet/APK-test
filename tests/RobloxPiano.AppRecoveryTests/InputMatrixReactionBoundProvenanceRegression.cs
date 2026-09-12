using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class InputMatrixReactionBoundProvenanceRegression
{
    private static readonly RobloxInputMatrixSessionIdentity Session = new(
        new RobloxProcessIdentity(700, 7_000),
        0x7777);

    [ModuleInitializer]
    internal static void Verify()
    {
        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        try
        {
            CleanEvidenceSurvivesRegistryReset();
            ContaminatedEvidenceCannotBeUpgradedAfterCapture();
            MissingEvidenceCannotBeUpgradedAfterCapture();
        }
        finally
        {
            RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        }
    }

    private static void CleanEvidenceSurvivesRegistryReset()
    {
        const string probe = "reaction-bound-clean";
        RecordClean(probe);
        var cell = new RobloxInputMatrixCellEvidence(
            "SENDINPUT_VK",
            probe,
            "ROBLOX_REACTED",
            true,
            Session);

        Equal(RobloxInputMatrixSyntheticProvenanceTrust.Clean, cell.SyntheticProvenanceTrust, "clean trust at retention");
        Equal(RobloxInputMatrixSyntheticProvenanceReason.CleanInjectedPair, cell.SyntheticProvenanceReason, "clean reason at retention");

        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();

        Equal(RobloxInputMatrixSyntheticProvenanceTrust.Clean, cell.SyntheticProvenanceTrust, "clean trust after registry reset");
        Equal(RobloxInputMatrixSyntheticProvenanceReason.CleanInjectedPair, cell.SyntheticProvenanceReason, "clean reason after registry reset");
        if (!cell.WindowsBoundaryConfirmed || !cell.Reacted)
        {
            throw new InvalidOperationException("A retained clean reaction must not become missing merely because the bounded process registry was reset or evicted later.");
        }
    }

    private static void ContaminatedEvidenceCannotBeUpgradedAfterCapture()
    {
        const string probe = "reaction-bound-contaminated";
        RecordContaminated(probe);
        var cell = new RobloxInputMatrixCellEvidence(
            "KEYBD_EVENT_SCAN",
            probe,
            "ROBLOX_REACTED",
            true,
            Session);

        Equal(RobloxInputMatrixSyntheticProvenanceTrust.Contaminated, cell.SyntheticProvenanceTrust, "contaminated trust at retention");
        Equal(RobloxInputMatrixSyntheticProvenanceReason.PhysicalTargetContamination, cell.SyntheticProvenanceReason, "contaminated reason at retention");

        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        RecordClean(probe);

        Equal(RobloxInputMatrixSyntheticProvenanceTrust.Contaminated, cell.SyntheticProvenanceTrust, "contaminated trust after later clean reuse");
        Equal(RobloxInputMatrixSyntheticProvenanceReason.PhysicalTargetContamination, cell.SyntheticProvenanceReason, "contaminated reason after later clean reuse");
        if (cell.WindowsBoundaryConfirmed || cell.Reacted)
        {
            throw new InvalidOperationException("A retained contaminated reaction must never be upgraded by later registry state using the same probe ID.");
        }
    }

    private static void MissingEvidenceCannotBeUpgradedAfterCapture()
    {
        const string probe = "reaction-bound-missing";
        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        var cell = new RobloxInputMatrixCellEvidence(
            "SENDINPUT_SCAN",
            probe,
            "ROBLOX_REACTED",
            true,
            Session);

        Equal(RobloxInputMatrixSyntheticProvenanceTrust.Missing, cell.SyntheticProvenanceTrust, "missing trust at retention");
        Equal(RobloxInputMatrixSyntheticProvenanceReason.MissingSnapshot, cell.SyntheticProvenanceReason, "missing reason at retention");

        RecordClean(probe);

        Equal(RobloxInputMatrixSyntheticProvenanceTrust.Missing, cell.SyntheticProvenanceTrust, "missing trust after late record");
        Equal(RobloxInputMatrixSyntheticProvenanceReason.MissingSnapshot, cell.SyntheticProvenanceReason, "missing reason after late record");
        if (cell.WindowsBoundaryConfirmed || cell.Reacted)
        {
            throw new InvalidOperationException("A reaction retained without provenance must remain fail-closed even if matching provenance appears later.");
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

    private static void RecordContaminated(string probe)
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
                TargetEventCount = 3,
                NotInjectedTargetEventCount = 1,
                InjectedTargetEventCount = 2,
                PhysicalTargetContaminationObserved = true,
                UnexpectedTargetTransitionObserved = false
            });

    private static void Equal<T>(T expected, T actual, string name)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{name}: expected '{expected}', got '{actual}'.");
        }
    }
}
