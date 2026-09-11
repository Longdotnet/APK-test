using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class PhysicalKeyDiagnosticRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        var down = RobloxPhysicalKeyDiagnosticProbe.BuildEvent(0x57, 0x11, keyUp: false);
        if (down.VirtualKey != 0x57 || down.ScanCode != 0x11 || down.Flags != 0)
        {
            throw new InvalidOperationException("Physical-key diagnostic must preserve the requested VK/scan-code pair on key down.");
        }

        var up = RobloxPhysicalKeyDiagnosticProbe.BuildEvent(0x57, 0x11, keyUp: true);
        if (up.VirtualKey != 0x57 || up.ScanCode != 0x11 || up.Flags != NativeMethods.KeyEventKeyUp)
        {
            throw new InvalidOperationException("Physical-key diagnostic key up must preserve the same physical scan code and add only KEYEVENTF_KEYUP.");
        }

        var continuous = new RobloxPhysicalKeyProbeResult(
            "test", true, true, WindowsInputDesktopParity.Same, true, true, 0x57, 0x11, TimeSpan.FromMilliseconds(650));
        if (!continuous.NativeDeliveryObserved)
        {
            throw new InvalidOperationException("A fully observed physical diagnostic with continuous focus must remain eligible as native-delivery evidence.");
        }

        var transientFocusLoss = continuous with { ForegroundHeldDuringProbe = false };
        if (transientFocusLoss.NativeDeliveryObserved)
        {
            throw new InvalidOperationException("Physical-key diagnostic must fail closed when any sampled focus loss occurs during the held key.");
        }

        try
        {
            _ = RobloxPhysicalKeyDiagnosticProbe.BuildEvent(0x57, 0, keyUp: false);
            throw new InvalidOperationException("Diagnostic scan code 0 must be rejected because it would duplicate the existing PowerShell oracle path.");
        }
        catch (WindowsInputInjectionException exception) when (exception.Message.Contains("non-zero scan code", StringComparison.OrdinalIgnoreCase))
        {
            // Expected fail-closed behavior.
        }

        try
        {
            _ = RobloxPhysicalKeyDiagnosticProbe.BuildEvent(0x157, 0x11, keyUp: false);
            throw new InvalidOperationException("Virtual keys outside keybd_event's byte ABI must be rejected.");
        }
        catch (WindowsInputInjectionException)
        {
            // Expected fail-closed behavior.
        }
    }
}
