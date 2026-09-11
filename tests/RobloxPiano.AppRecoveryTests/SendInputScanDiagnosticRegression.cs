using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class SendInputScanDiagnosticRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        if (RobloxSendInputScanDiagnosticProbe.NativeInputSize != RobloxSendInputScanDiagnosticProbe.ExpectedNativeInputSize)
        {
            throw new InvalidOperationException(
                $"Managed SendInput INPUT ABI is wrong: actual={RobloxSendInputScanDiagnosticProbe.NativeInputSize}, expected={RobloxSendInputScanDiagnosticProbe.ExpectedNativeInputSize}.");
        }

        var normalized = RobloxSendInputScanDiagnosticProbe.NormalizeScanCode(0x11, out var extended);
        if (normalized != 0x11 || extended)
        {
            throw new InvalidOperationException("Ordinary scan codes must remain unchanged and non-extended.");
        }

        var extendedScan = RobloxSendInputScanDiagnosticProbe.NormalizeScanCode(0xE01D, out var isExtended);
        if (extendedScan != 0x1D || !isExtended)
        {
            throw new InvalidOperationException("Extended MapVirtualKey scan codes must preserve the low-byte scan code and KEYEVENTF_EXTENDEDKEY semantic.");
        }

        var down = RobloxSendInputScanDiagnosticProbe.BuildEvent(0x57, 0x11, extended: false, keyUp: false);
        if (down.VirtualKey != 0x57 || down.ScanCode != 0x11 || down.Flags != RobloxSendInputScanDiagnosticProbe.KeyEventFScanCode)
        {
            throw new InvalidOperationException("SendInput diagnostic key down must use scan-code semantics only.");
        }

        var up = RobloxSendInputScanDiagnosticProbe.BuildEvent(0x57, 0x11, extended: false, keyUp: true);
        var expectedUp = RobloxSendInputScanDiagnosticProbe.KeyEventFScanCode | RobloxSendInputScanDiagnosticProbe.KeyEventFKeyUp;
        if (up.VirtualKey != 0x57 || up.ScanCode != 0x11 || up.Flags != expectedUp)
        {
            throw new InvalidOperationException("SendInput diagnostic key up must preserve the scan code and add only KEYEVENTF_KEYUP.");
        }

        var continuous = new RobloxSendInputScanProbeResult(
            "test", true, true, WindowsInputDesktopParity.Same, true, true, 0x57, 0x11, TimeSpan.FromMilliseconds(650));
        if (!continuous.NativeDeliveryObserved)
        {
            throw new InvalidOperationException("A fully observed SendInput diagnostic with continuous focus must remain eligible as native-delivery evidence.");
        }

        var transientFocusLoss = continuous with { ForegroundHeldDuringProbe = false };
        if (transientFocusLoss.NativeDeliveryObserved)
        {
            throw new InvalidOperationException("SendInput diagnostic must fail closed when any sampled focus loss occurs during the held key.");
        }

        var extendedDown = RobloxSendInputScanDiagnosticProbe.BuildEvent(0x25, 0x4B, extended: true, keyUp: false);
        var expectedExtended = RobloxSendInputScanDiagnosticProbe.KeyEventFScanCode | RobloxSendInputScanDiagnosticProbe.KeyEventFExtendedKey;
        if (extendedDown.Flags != expectedExtended)
        {
            throw new InvalidOperationException("Extended keys must carry KEYEVENTF_EXTENDEDKEY with scan-code semantics.");
        }

        try
        {
            _ = RobloxSendInputScanDiagnosticProbe.NormalizeScanCode(0, out _);
            throw new InvalidOperationException("Scan code 0 must fail closed for the SendInput diagnostic.");
        }
        catch (WindowsInputInjectionException)
        {
            // Expected fail-closed behavior.
        }

        try
        {
            _ = RobloxSendInputScanDiagnosticProbe.BuildEvent(0x57, 0, extended: false, keyUp: false);
            throw new InvalidOperationException("BuildEvent must reject scan code 0.");
        }
        catch (WindowsInputInjectionException)
        {
            // Expected fail-closed behavior.
        }
    }
}
