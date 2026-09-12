using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class InputMatrixProbeReplayRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();

        const string probeId = "phase84-replayed-probe";
        var contaminated = new WindowsLowLevelKeyboardProvenanceSnapshot(
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
            InjectedTargetEventCount = 3,
            UnexpectedTargetTransitionObserved = true
        };

        var clean = new WindowsLowLevelKeyboardProvenanceSnapshot(
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
        };

        RobloxInputMatrixProbeEvidenceRegistry.Record(probeId, contaminated);
        RobloxInputMatrixProbeEvidenceRegistry.Record(probeId, clean);

        if (RobloxInputMatrixProbeEvidenceRegistry.GetTrust(probeId) != RobloxInputMatrixSyntheticProvenanceTrust.Contaminated)
        {
            throw new InvalidOperationException("A replayed probe ID must fail closed even when a later snapshot is clean.");
        }

        if (!RobloxInputMatrixProbeEvidenceRegistry.TryGetSnapshot(probeId, out var retained)
            || retained.TargetEventCount != 3
            || !retained.UnexpectedTargetTransitionObserved)
        {
            throw new InvalidOperationException("The first retained probe snapshot must remain immutable after duplicate-ID replay.");
        }

        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        RobloxInputMatrixProbeEvidenceRegistry.Record(probeId, clean);
        RobloxInputMatrixProbeEvidenceRegistry.Record(probeId, contaminated);

        if (RobloxInputMatrixProbeEvidenceRegistry.GetTrust(probeId) != RobloxInputMatrixSyntheticProvenanceTrust.Contaminated)
        {
            throw new InvalidOperationException("A duplicate probe ID must contaminate an originally clean snapshot too.");
        }
    }
}
