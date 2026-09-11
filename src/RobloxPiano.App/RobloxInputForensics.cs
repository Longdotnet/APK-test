using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal static class RobloxInputForensics
{
    internal static string NewProbeId() => Guid.NewGuid().ToString("N")[..12];

    internal static void LogEnvironment(string probeId, RobloxWindowTarget target, char character)
    {
        var foreground = NativeMethods.GetForegroundWindow();
        var foregroundThreadId = NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        var appKeyboardLayout = NativeMethods.GetKeyboardLayout(0);
        var foregroundKeyboardLayout = NativeMethods.GetKeyboardLayout(foregroundThreadId);
        var mapping = WindowsKeyboardInputSink.ResolveStrokeForDiagnostics(character);
        var layoutParity = appKeyboardLayout == foregroundKeyboardLayout ? "SAME" : "DIFFERENT";

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=ENV " +
            $"char='{character}' unicode=U+{(int)character:X4} resolvedVk=0x{mapping.VirtualKey:X2} modifiers=0x{mapping.Modifiers:X2} " +
            $"mappingLayout=0x{mapping.KeyboardLayout.ToInt64():X} mappingThread={mapping.KeyboardThreadId} " +
            $"appKeyboardLayout=0x{appKeyboardLayout.ToInt64():X} foregroundKeyboardLayout=0x{foregroundKeyboardLayout.ToInt64():X} layoutParity={layoutParity} " +
            $"managedThread={Environment.CurrentManagedThreadId} nativeThread={GetCurrentThreadId()} " +
            $"appPid={Environment.ProcessId} targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} foregroundTid={foregroundThreadId} " +
            $"os='{Environment.OSVersion}' x64={Environment.Is64BitProcess}.");
    }

    internal static void LogKeyState(
        string probeId,
        string stage,
        RobloxWindowTarget target,
        ushort virtualKey,
        TimeSpan? elapsed = null)
    {
        var foreground = NativeMethods.GetForegroundWindow();
        var foregroundThreadId = NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        var foregroundKeyboardLayout = NativeMethods.GetKeyboardLayout(foregroundThreadId);
        var down = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage={stage} backend={WindowsKeyboardInputSink.BackendName} " +
            $"vk=0x{virtualKey:X2} keyState={(down ? "DOWN" : "UP")} targetForeground={target.IsForeground} " +
            $"targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} foregroundTid={foregroundThreadId} " +
            $"foregroundKeyboardLayout=0x{foregroundKeyboardLayout.ToInt64():X} " +
            $"elapsedMs={(elapsed?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na")}.");
    }

    internal static void LogVerdict(string probeId, RobloxInputCheckAssessment assessment, bool? robloxReacted)
    {
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=VERDICT verdict={assessment.Verdict} " +
            $"windowsPath={(assessment.Verdict is RobloxInputCheckVerdict.NativeDeliveryAwaitingObservation or RobloxInputCheckVerdict.Confirmed or RobloxInputCheckVerdict.RobloxDidNotReact ? "OBSERVED" : "NOT_CONFIRMED")} " +
            $"robloxReaction={(robloxReacted is null ? "UNKNOWN" : robloxReacted.Value ? "YES" : "NO")} success={assessment.IsSuccess}.");
    }

    [DllImport("kernel32.dll")]
    private static extern uint GetCurrentThreadId();
}
