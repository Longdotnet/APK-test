using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal static class RobloxInputForensics
{
    internal static string NewProbeId() => Guid.NewGuid().ToString("N")[..12];

    internal static void LogEnvironment(string probeId, RobloxWindowTarget target, char character)
    {
        var encoded = NativeMethods.VkKeyScanW(character);
        var virtualKey = encoded == -1 ? -1 : encoded & 0x00ff;
        var modifiers = encoded == -1 ? -1 : (encoded >> 8) & 0x00ff;
        var foreground = NativeMethods.GetForegroundWindow();
        NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        var keyboardLayout = GetKeyboardLayout(0);

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=ENV " +
            $"char='{character}' unicode=U+{(int)character:X4} vkKeyScanRaw=0x{unchecked((ushort)encoded):X4} " +
            $"resolvedVk={(virtualKey < 0 ? "UNMAPPED" : $"0x{virtualKey:X2}")} modifiers={(modifiers < 0 ? "UNMAPPED" : $"0x{modifiers:X2}")} " +
            $"keyboardLayout=0x{keyboardLayout.ToInt64():X} managedThread={Environment.CurrentManagedThreadId} nativeThread={GetCurrentThreadId()} " +
            $"appPid={Environment.ProcessId} targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} os='{Environment.OSVersion}' x64={Environment.Is64BitProcess}.");
    }

    internal static void LogKeyState(
        string probeId,
        string stage,
        RobloxWindowTarget target,
        ushort virtualKey,
        TimeSpan? elapsed = null)
    {
        var foreground = NativeMethods.GetForegroundWindow();
        NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        var down = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage={stage} backend={WindowsKeyboardInputSink.BackendName} " +
            $"vk=0x{virtualKey:X2} keyState={(down ? "DOWN" : "UP")} targetForeground={target.IsForeground} " +
            $"targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} " +
            $"elapsedMs={(elapsed?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na")}.");
    }

    internal static void LogVerdict(string probeId, RobloxInputCheckAssessment assessment, bool? robloxReacted)
    {
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=VERDICT verdict={assessment.Verdict} " +
            $"windowsPath={(assessment.Verdict is RobloxInputCheckVerdict.NativeDeliveryAwaitingObservation or RobloxInputCheckVerdict.Confirmed or RobloxInputCheckVerdict.RobloxDidNotReact ? "OBSERVED" : "NOT_CONFIRMED")} " +
            $"robloxReaction={(robloxReacted is null ? "UNKNOWN" : robloxReacted.Value ? "YES" : "NO")} success={assessment.IsSuccess}.");
    }

    [DllImport("user32.dll")]
    private static extern IntPtr GetKeyboardLayout(uint idThread);

    [DllImport("kernel32.dll")]
    private static extern uint GetCurrentThreadId();
}
