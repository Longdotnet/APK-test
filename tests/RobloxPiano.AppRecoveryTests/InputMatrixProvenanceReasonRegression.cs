using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class InputMatrixProvenanceReasonRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        try
        {
            AssertReason("missing", RobloxInputMatrixSyntheticProvenanceReason.MissingSnapshot);

            Record("clean", Snapshot(targetEvents: 2));
            AssertReason("clean", RobloxInputMatrixSyntheticProvenanceReason.CleanInjectedPair);

            Record("physical", Snapshot(targetEvents: 3, notInjectedEvents: 1));
            AssertReason("physical", RobloxInputMatrixSyntheticProvenanceReason.PhysicalTargetContamination);

            Record("transition", Snapshot(targetEvents: 3, unexpectedTransition: true));
            AssertReason("transition", RobloxInputMatrixSyntheticProvenanceReason.UnexpectedTargetTransition);

            Record("incomplete", Snapshot(targetEvents: 1, targetUpObserved: false));
            AssertReason("incomplete", RobloxInputMatrixSyntheticProvenanceReason.IncompleteInjectedPair);

            Record("lower", Snapshot(
                targetEvents: 2,
                lowerIntegrityEvents: 2,
                downProvenance: WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected,
                upProvenance: WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected));
            AssertReason("lower", RobloxInputMatrixSyntheticProvenanceReason.LowerIntegrityInjected);

            Record("duplicate", Snapshot(targetEvents: 2));
            Record("duplicate", Snapshot(targetEvents: 2));
            AssertReason("duplicate", RobloxInputMatrixSyntheticProvenanceReason.DuplicateProbeId);
        }
        finally
        {
            RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();
        }
    }

    private static void Record(string probeId, WindowsLowLevelKeyboardProvenanceSnapshot snapshot)
        => RobloxInputMatrixProbeEvidenceRegistry.Record(probeId, snapshot);

    private static void AssertReason(string probeId, RobloxInputMatrixSyntheticProvenanceReason expected)
    {
        var actual = RobloxInputMatrixProbeEvidenceRegistry.GetAssessment(probeId);
        if (actual.Reason != expected)
        {
            throw new InvalidOperationException(
                $"Probe '{probeId}' expected provenance reason {expected}, got {actual.Reason} ({actual.Trust}).");
        }
    }

    private static WindowsLowLevelKeyboardProvenanceSnapshot Snapshot(
        int targetEvents,
        int notInjectedEvents = 0,
        int lowerIntegrityEvents = 0,
        bool unexpectedTransition = false,
        bool targetUpObserved = true,
        WindowsLowLevelKeyboardProvenanceKind downProvenance = WindowsLowLevelKeyboardProvenanceKind.Injected,
        WindowsLowLevelKeyboardProvenanceKind upProvenance = WindowsLowLevelKeyboardProvenanceKind.Injected)
        => new(
            true,
            true,
            targetUpObserved,
            WindowsLowLevelKeyboardProvenance.LlkhfInjected,
            WindowsLowLevelKeyboardProvenance.LlkhfInjected,
            0x11,
            0x11,
            downProvenance,
            upProvenance)
        {
            TargetEventCount = targetEvents,
            NotInjectedTargetEventCount = notInjectedEvents,
            InjectedTargetEventCount = Math.Max(0, targetEvents - notInjectedEvents),
            LowerIntegrityInjectedTargetEventCount = lowerIntegrityEvents,
            UnexpectedTargetTransitionObserved = unexpectedTransition
        };
}
