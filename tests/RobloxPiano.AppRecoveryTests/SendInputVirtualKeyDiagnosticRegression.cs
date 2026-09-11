using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class SendInputVirtualKeyDiagnosticRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        if (RobloxSendInputVirtualKeyDiagnosticProbe.NativeInputSize != RobloxSendInputVirtualKeyDiagnosticProbe.ExpectedNativeInputSize)
        {
            throw new InvalidOperationException(
                $"Managed SendInput INPUT ABI is wrong: actual={RobloxSendInputVirtualKeyDiagnosticProbe.NativeInputSize}, expected={RobloxSendInputVirtualKeyDiagnosticProbe.ExpectedNativeInputSize}.");
        }

        var down = RobloxSendInputVirtualKeyDiagnosticProbe.BuildEvent(0x57, keyUp: false);
        if (down.VirtualKey != 0x57 || down.ScanCode != 0 || down.Flags != 0)
        {
            throw new InvalidOperationException("SendInput virtual-key diagnostic key down must preserve VK, use scan 0, and avoid scan-code flags.");
        }

        var up = RobloxSendInputVirtualKeyDiagnosticProbe.BuildEvent(0x57, keyUp: true);
        if (up.VirtualKey != 0x57 || up.ScanCode != 0 || up.Flags != RobloxSendInputVirtualKeyDiagnosticProbe.KeyEventFKeyUp)
        {
            throw new InvalidOperationException("SendInput virtual-key diagnostic key up must add only KEYEVENTF_KEYUP.");
        }

        var continuous = new RobloxSendInputVirtualKeyProbeResult(
            "test", true, true, WindowsInputDesktopParity.Same, true, true, 0x57, TimeSpan.FromMilliseconds(650));
        if (!continuous.NativeDeliveryObserved)
        {
            throw new InvalidOperationException("A fully observed SendInput virtual-key diagnostic with continuous focus must remain native-delivery evidence.");
        }

        if ((continuous with { ForegroundHeldDuringProbe = false }).NativeDeliveryObserved)
        {
            throw new InvalidOperationException("SendInput virtual-key diagnostic must fail closed after any sampled focus loss.");
        }

        if ((continuous with { WindowsReportedKeyDown = false }).NativeDeliveryObserved)
        {
            throw new InvalidOperationException("SendInput virtual-key diagnostic must not claim native delivery without Windows-observed key-down state.");
        }

        try
        {
            _ = RobloxSendInputVirtualKeyDiagnosticProbe.BuildEvent(0, keyUp: false);
            throw new InvalidOperationException("Virtual key 0 must fail closed for the SendInput virtual-key diagnostic.");
        }
        catch (WindowsInputInjectionException)
        {
            // Expected fail-closed behavior.
        }
    }
}
