using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class LowLevelKeyboardProvenanceRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        Equal(
            WindowsLowLevelKeyboardProvenanceKind.NotInjected,
            WindowsLowLevelKeyboardProvenance.Classify(0),
            "unmarked low-level keyboard event must remain non-injected");

        Equal(
            WindowsLowLevelKeyboardProvenanceKind.Injected,
            WindowsLowLevelKeyboardProvenance.Classify(WindowsLowLevelKeyboardProvenance.LlkhfInjected),
            "LLKHF_INJECTED must classify as injected");

        Equal(
            WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected,
            WindowsLowLevelKeyboardProvenance.Classify(
                WindowsLowLevelKeyboardProvenance.LlkhfInjected
                | WindowsLowLevelKeyboardProvenance.LlkhfLowerIlInjected),
            "lower-integrity injected flag must take precedence over generic injected provenance");

        var targetDown = WindowsLowLevelKeyboardProvenance.ClassifyEvent(
            0x57,
            0x57,
            0x11,
            WindowsLowLevelKeyboardProvenance.LlkhfInjected,
            0x0100);
        True(targetDown.IsTargetVirtualKey, "target W must be recognized");
        True(targetDown.IsDown && !targetDown.IsUp, "WM_KEYDOWN must classify as down only");
        Equal(WindowsLowLevelKeyboardProvenanceKind.Injected, targetDown.Provenance, "target injected W provenance");

        var unrelated = WindowsLowLevelKeyboardProvenance.ClassifyEvent(
            0x57,
            0x41,
            0x1E,
            WindowsLowLevelKeyboardProvenance.LlkhfInjected,
            0x0100);
        True(!unrelated.IsTargetVirtualKey, "observer must ignore unrelated keyboard keys");

        var targetUp = WindowsLowLevelKeyboardProvenance.ClassifyEvent(
            0x57,
            0x57,
            0x11,
            WindowsLowLevelKeyboardProvenance.LlkhfInjected,
            0x0101);
        True(targetUp.IsTargetVirtualKey, "target W key-up must be recognized");
        True(!targetUp.IsDown && targetUp.IsUp, "WM_KEYUP must classify as up only");

        var cleanSnapshot = WindowsLowLevelKeyboardProvenance.BuildSnapshotForDiagnostics(
            hookArmed: true,
            new[] { targetDown, targetUp });
        True(cleanSnapshot.InjectedPairObserved, "complete injected W pair must be recognized");
        True(cleanSnapshot.UncontaminatedInjectedPairObserved, "exact injected down/up pair must be uncontaminated");
        Equal(2, cleanSnapshot.TargetEventCount, "clean pair target-event count");
        Equal(0, cleanSnapshot.NotInjectedTargetEventCount, "clean pair must contain no physical target-key event");
        True(!cleanSnapshot.UnexpectedTargetTransitionObserved, "clean pair must preserve DOWN->UP transition order");

        var physicalDown = WindowsLowLevelKeyboardProvenance.ClassifyEvent(
            0x57,
            0x57,
            0x11,
            0,
            0x0100);
        var contaminated = WindowsLowLevelKeyboardProvenance.BuildSnapshotForDiagnostics(
            hookArmed: true,
            new[] { targetDown, physicalDown, targetUp });
        True(contaminated.InjectedPairObserved, "legacy first-pair evidence remains visible under contamination");
        True(contaminated.PhysicalTargetContaminationObserved, "physical W during synthetic attempt must be explicit contamination");
        True(contaminated.UnexpectedTargetTransitionObserved, "duplicate DOWN must invalidate transition cleanliness");
        True(!contaminated.UncontaminatedInjectedPairObserved, "contaminated target-key evidence must never be called a clean injected pair");
        Equal(3, contaminated.TargetEventCount, "contaminated target-event count");
        Equal(1, contaminated.NotInjectedTargetEventCount, "physical target-key event count");

        var upBeforeDown = WindowsLowLevelKeyboardProvenance.BuildSnapshotForDiagnostics(
            hookArmed: true,
            new[] { targetUp, targetDown });
        True(upBeforeDown.UnexpectedTargetTransitionObserved, "UP before DOWN must be flagged");
        True(!upBeforeDown.UncontaminatedInjectedPairObserved, "reversed injected events are not a trustworthy pair");

        var keybdScan = new RobloxPhysicalKeyProbeResult(
            "probe-scan",
            true,
            true,
            WindowsInputDesktopParity.Same,
            true,
            true,
            0x57,
            0x11,
            TimeSpan.FromMilliseconds(80))
        {
            LowLevelProvenance = cleanSnapshot
        };
        Equal(cleanSnapshot, keybdScan.LowLevelProvenance!.Value, "keybd_event scan result must retain low-level provenance");

        var sendInputVk = new RobloxSendInputVirtualKeyProbeResult(
            "probe-sendinput-vk",
            true,
            true,
            WindowsInputDesktopParity.Same,
            true,
            true,
            0x57,
            TimeSpan.FromMilliseconds(80))
        {
            LowLevelProvenance = cleanSnapshot
        };
        Equal(cleanSnapshot, sendInputVk.LowLevelProvenance!.Value, "SendInput VK result must retain low-level provenance");

        var sendInputScan = new RobloxSendInputScanProbeResult(
            "probe-sendinput-scan",
            true,
            true,
            WindowsInputDesktopParity.Same,
            true,
            true,
            0x57,
            0x11,
            TimeSpan.FromMilliseconds(80))
        {
            LowLevelProvenance = cleanSnapshot
        };
        Equal(cleanSnapshot, sendInputScan.LowLevelProvenance!.Value, "SendInput scan result must retain low-level provenance");
    }

    private static void True(bool value, string message)
    {
        if (!value)
        {
            throw new InvalidOperationException(message);
        }
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected={expected}, actual={actual}");
        }
    }
}
