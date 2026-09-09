using System.Diagnostics;

namespace RobloxPiano.App;

/// <summary>
/// Field-only diagnostic that bypasses the playback scheduler and emits one ordinary
/// keyboard key through the exact native sequence used by the known-good PowerShell v2
/// baseline: VkKeyScanW -> keybd_event DOWN -> hold -> keybd_event UP.
/// </summary>
internal static class RobloxInputFieldProbe
{
    private const char ProbeCharacter = 'w';
    private static readonly TimeSpan FocusSettleDelay = TimeSpan.FromMilliseconds(350);
    private static readonly TimeSpan ProbeHold = TimeSpan.FromMilliseconds(700);

    public static int Run()
    {
        Console.WriteLine("Roblox Piano field input probe");
        Console.WriteLine("Open Roblox first and stand/sit where pressing W should visibly move or play a note.");

        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            const string message = "FIELD PROBE FAIL: Roblox player window was not found.";
            Console.Error.WriteLine(message);
            ClientDiagnostics.Log(message);
            return 21;
        }

        ClientDiagnostics.Log(
            $"FIELD PROBE target: pid={target.ProcessId}, hwnd=0x{target.WindowHandle.ToInt64():X}, title='{target.WindowTitle}', " +
            $"clientPid={Environment.ProcessId}, client64={Environment.Is64BitProcess}.");

        if (!target.TryActivate())
        {
            var foreground = NativeMethods.GetForegroundWindow();
            var message =
                $"FIELD PROBE FAIL: target activation was not confirmed. targetHwnd=0x{target.WindowHandle.ToInt64():X}, " +
                $"foregroundHwnd=0x{foreground.ToInt64():X}.";
            Console.Error.WriteLine(message);
            ClientDiagnostics.Log(message);
            return 22;
        }

        Thread.Sleep(FocusSettleDelay);
        var before = CaptureForeground();
        if (before.WindowHandle != target.WindowHandle)
        {
            var message =
                $"FIELD PROBE FAIL: Roblox lost foreground before dispatch. targetHwnd=0x{target.WindowHandle.ToInt64():X}, " +
                $"foregroundHwnd=0x{before.WindowHandle.ToInt64():X}, foregroundPid={before.ProcessId}.";
            Console.Error.WriteLine(message);
            ClientDiagnostics.Log(message);
            return 23;
        }

        var encoded = NativeMethods.VkKeyScanW(ProbeCharacter);
        if (encoded == -1)
        {
            var message = $"FIELD PROBE FAIL: VkKeyScanW could not map '{ProbeCharacter}'.";
            Console.Error.WriteLine(message);
            ClientDiagnostics.Log(message);
            return 24;
        }

        var virtualKey = checked((byte)(encoded & 0x00ff));
        var modifiers = (byte)((encoded >> 8) & 0x00ff);
        if (modifiers != 0)
        {
            var message =
                $"FIELD PROBE FAIL: lowercase '{ProbeCharacter}' unexpectedly requires modifiers 0x{modifiers:X2}.";
            Console.Error.WriteLine(message);
            ClientDiagnostics.Log(message);
            return 25;
        }

        var stopwatch = Stopwatch.StartNew();
        ClientDiagnostics.Log(
            $"FIELD PROBE DOWN: char='{ProbeCharacter}', vk=0x{virtualKey:X2}, scan=0, flags=0, " +
            $"fgHwnd=0x{before.WindowHandle.ToInt64():X}, fgPid={before.ProcessId}, tMs={stopwatch.Elapsed.TotalMilliseconds:0.###}.");
        NativeMethods.KeybdEvent(virtualKey, scanCode: 0, flags: 0, UIntPtr.Zero);

        Thread.Sleep(ProbeHold);
        var during = CaptureForeground();
        ClientDiagnostics.Log(
            $"FIELD PROBE HOLD: char='{ProbeCharacter}', elapsedMs={stopwatch.Elapsed.TotalMilliseconds:0.###}, " +
            $"fgHwnd=0x{during.WindowHandle.ToInt64():X}, fgPid={during.ProcessId}, stillTarget={during.WindowHandle == target.WindowHandle}.");

        NativeMethods.KeybdEvent(virtualKey, scanCode: 0, flags: NativeMethods.KeyEventKeyUp, UIntPtr.Zero);
        var after = CaptureForeground();
        ClientDiagnostics.Log(
            $"FIELD PROBE UP: char='{ProbeCharacter}', vk=0x{virtualKey:X2}, scan=0, flags=KEYEVENTF_KEYUP, " +
            $"elapsedMs={stopwatch.Elapsed.TotalMilliseconds:0.###}, fgHwnd=0x{after.WindowHandle.ToInt64():X}, " +
            $"fgPid={after.ProcessId}, stillTarget={after.WindowHandle == target.WindowHandle}.");

        Console.WriteLine();
        Console.WriteLine("FIELD PROBE SENT: held W for 700 ms using the PowerShell-v2 keybd_event sequence.");
        Console.WriteLine($"Target PID: {target.ProcessId}; HWND: 0x{target.WindowHandle.ToInt64():X}");
        Console.WriteLine($"Foreground stayed on target during hold: {during.WindowHandle == target.WindowHandle}");
        Console.WriteLine($"Diagnostics: {ClientDiagnostics.DirectoryPath}");
        Console.WriteLine("If Roblox visibly moved/played a note, native delivery works and the remaining bug is in playback scheduling.");
        Console.WriteLine("If Roblox did nothing, compare this probe with the working PS1 runtime/elevation context.");
        return during.WindowHandle == target.WindowHandle ? 0 : 26;
    }

    private static ForegroundSnapshot CaptureForeground()
    {
        var window = NativeMethods.GetForegroundWindow();
        NativeMethods.GetWindowThreadProcessId(window, out var processId);
        return new ForegroundSnapshot(window, processId);
    }

    private readonly record struct ForegroundSnapshot(IntPtr WindowHandle, uint ProcessId);
}
