using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class InputMatrixLowerIntegrityRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();

        const string lowerIntegrityProbe = "lower-integrity-probe";
        RobloxInputMatrixProbeEvidenceRegistry.Record(
            lowerIntegrityProbe,
            new WindowsLowLevelKeyboardProvenanceSnapshot(
                true,
                true,
                true,
                WindowsLowLevelKeyboardProvenance.LlkhfInjected | WindowsLowLevelKeyboardProvenance.LlkhfLowerIlInjected,
                WindowsLowLevelKeyboardProvenance.LlkhfInjected | WindowsLowLevelKeyboardProvenance.LlkhfLowerIlInjected,
                0x11,
                0x11,
                WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected,
                WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected)
            {
                TargetEventCount = 2,
                LowerIntegrityInjectedTargetEventCount = 2,
                UnexpectedTargetTransitionObserved = false
            });

        var trust = RobloxInputMatrixProbeEvidenceRegistry.GetTrust(lowerIntegrityProbe);
        if (trust != RobloxInputMatrixSyntheticProvenanceTrust.Contaminated)
        {
            throw new InvalidOperationException(
                $"Lower-integrity injected provenance must fail closed; got {trust}.");
        }

        var session = new RobloxInputMatrixSessionIdentity(new RobloxProcessIdentity(100, 1_000), 0x1111);
        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            new RobloxInputMatrixCellEvidence("REAL_KEY", "physical", "ROBLOX_REACTED", true, session),
            new RobloxInputMatrixCellEvidence("POWERSHELL_ORACLE", lowerIntegrityProbe, "ROBLOX_NO_REACTION", false, session)
        ],
        session);

        if (assessment.IsConclusive
            || assessment.Verdict != RobloxInputMatrixVerdict.InsufficientEvidence
            || !assessment.PendingCells.Contains("POWERSHELL_ORACLE", StringComparer.Ordinal))
        {
            throw new InvalidOperationException(
                "A lower-integrity injected synthetic No must stay pending and must not establish a Roblox-consumption boundary.");
        }

        const string cleanProbe = "same-integrity-probe";
        RobloxInputMatrixProbeEvidenceRegistry.Record(
            cleanProbe,
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

        if (RobloxInputMatrixProbeEvidenceRegistry.GetTrust(cleanProbe) != RobloxInputMatrixSyntheticProvenanceTrust.Clean)
        {
            throw new InvalidOperationException("A same-integrity clean injected pair must remain eligible matrix provenance.");
        }
    }
}
