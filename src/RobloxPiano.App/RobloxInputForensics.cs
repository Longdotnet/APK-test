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
        var oracleMapping = WindowsKeyboardInputSink.ResolvePowerShellOracleStrokeForDiagnostics(character);
        var semanticParity = WindowsKeyboardInputSink.HasSameKeySemantics(mapping, oracleMapping) ? "SAME" : "DIFFERENT";
        var layoutParity = appKeyboardLayout == foregroundKeyboardLayout ? "SAME" : "DIFFERENT";
        var privilege = WindowsProcessPrivilege.Capture(target.ProcessId);
        var desktop = WindowsInputDesktop.Capture();
        var session = WindowsInteractiveSession.Capture(target.ProcessId);

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=ENV " +
            $"char='{character}' unicode=U+{(int)character:X4} resolvedVk=0x{mapping.VirtualKey:X2} modifiers=0x{mapping.Modifiers:X2} " +
            $"mappingLayout=0x{mapping.KeyboardLayout.ToInt64():X} mappingThread={mapping.KeyboardThreadId} " +
            $"oracleVk=0x{oracleMapping.VirtualKey:X2} oracleModifiers=0x{oracleMapping.Modifiers:X2} " +
            $"oracleLayout=0x{oracleMapping.KeyboardLayout.ToInt64():X} mappingSemanticParity={semanticParity} " +
            $"appKeyboardLayout=0x{appKeyboardLayout.ToInt64():X} foregroundKeyboardLayout=0x{foregroundKeyboardLayout.ToInt64():X} layoutParity={layoutParity} " +
            $"appElevation={privilege.AppElevation} targetElevation={privilege.TargetElevation} elevationParity={privilege.Parity} " +
            $"appDesktop='{desktop.AppDesktopName ?? "UNKNOWN"}' inputDesktop='{desktop.InputDesktopName ?? "UNKNOWN"}' desktopParity={desktop.Parity} " +
            $"desktopAppError={desktop.AppDesktopError} desktopInputError={desktop.InputDesktopError} " +
            $"appSession={(session.AppSessionId?.ToString(System.Globalization.CultureInfo.InvariantCulture) ?? "UNKNOWN")} " +
            $"targetSession={(session.TargetSessionId?.ToString(System.Globalization.CultureInfo.InvariantCulture) ?? "UNKNOWN")} " +
            $"sessionParity={session.Parity} activeConsoleSession={WindowsInteractiveSession.FormatConsoleSession(session.ActiveConsoleSessionId)} " +
            $"appIsActiveConsole={session.AppIsActiveConsole} targetIsActiveConsole={session.TargetIsActiveConsole} " +
            $"sessionAppError={session.AppSessionError} sessionTargetError={session.TargetSessionError} " +
            $"managedThread={Environment.CurrentManagedThreadId} nativeThread={GetCurrentThreadId()} " +
            $"appPid={Environment.ProcessId} targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} foregroundTid={foregroundThreadId} " +
            $"os='{Environment.OSVersion}' x64={Environment.Is64BitProcess}.");

        if (privilege.IsTargetHigher)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=PRIVILEGE_BLOCKER verdict=TARGET_HIGHER_INTEGRITY " +
                "guidance='Roblox is elevated while RobloxPiano is not. Run both at the same privilege level before judging native input acceptance.'.");
        }

        if (desktop.IsKnownMismatch)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=DESKTOP_BLOCKER verdict=INPUT_DESKTOP_MISMATCH " +
                $"appDesktop='{desktop.AppDesktopName}' inputDesktop='{desktop.InputDesktopName}' " +
                "guidance='Return Roblox and RobloxPiano to the same normal interactive Windows desktop before judging native input acceptance.'.");
        }

        if (session.IsKnownMismatch)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=SESSION_BLOCKER verdict=WINDOWS_SESSION_MISMATCH " +
                $"appSession={session.AppSessionId} targetSession={session.TargetSessionId} " +
                $"activeConsoleSession={WindowsInteractiveSession.FormatConsoleSession(session.ActiveConsoleSessionId)} " +
                "guidance='Roblox and RobloxPiano are running in different Windows logon/RDP sessions. Run both in the same interactive session before judging Roblox input consumption.'.");
        }
        else if (session.Parity == WindowsSessionParity.Same
                 && (!session.AppIsActiveConsole || !session.TargetIsActiveConsole))
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=SESSION_CONTEXT verdict=NON_CONSOLE_INTERACTIVE_SESSION " +
                $"appSession={session.AppSessionId} targetSession={session.TargetSessionId} " +
                $"activeConsoleSession={WindowsInteractiveSession.FormatConsoleSession(session.ActiveConsoleSessionId)} " +
                "guidance='Both processes share one Windows session, but it is not the active console session. Preserve this evidence when comparing local-console versus RDP/remote field behavior.'.");
        }
    }

    internal static void LogMappingComparison(
        string probeId,
        KeyboardStrokeMapping productionMapping,
        KeyboardStrokeMapping oracleMapping,
        bool equivalent)
    {
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=MAPPING_PARITY " +
            $"productionStrategy={KeyboardMappingStrategy.ForegroundLayout} productionVk=0x{productionMapping.VirtualKey:X2} " +
            $"productionModifiers=0x{productionMapping.Modifiers:X2} productionLayout=0x{productionMapping.KeyboardLayout.ToInt64():X} productionTid={productionMapping.KeyboardThreadId} " +
            $"oracleStrategy={KeyboardMappingStrategy.PowerShellOracle} oracleVk=0x{oracleMapping.VirtualKey:X2} " +
            $"oracleModifiers=0x{oracleMapping.Modifiers:X2} oracleLayout=0x{oracleMapping.KeyboardLayout.ToInt64():X} " +
            $"semanticParity={(equivalent ? "SAME" : "DIFFERENT")}.");
    }

    internal static void LogDesktopSnapshot(
        string probeId,
        string stage,
        WindowsInputDesktopSnapshot snapshot,
        RobloxWindowTarget target)
    {
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage={stage} " +
            $"desktopParity={snapshot.Parity} appDesktop='{snapshot.AppDesktopName ?? "UNKNOWN"}' inputDesktop='{snapshot.InputDesktopName ?? "UNKNOWN"}' " +
            $"desktopThread={snapshot.CurrentThreadId} appDesktopError={snapshot.AppDesktopError} inputDesktopError={snapshot.InputDesktopError} " +
            $"targetForeground={target.IsForeground} targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X}.");
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
            $"probeMapping={KeyboardMappingStrategy.PowerShellOracle} vk=0x{virtualKey:X2} keyState={(down ? "DOWN" : "UP")} targetForeground={target.IsForeground} " +
            $"targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} foregroundTid={foregroundThreadId} " +
            $"foregroundKeyboardLayout=0x{foregroundKeyboardLayout.ToInt64():X} " +
            $"elapsedMs={(elapsed?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na")}.");
    }

    internal static void LogVerdict(string probeId, RobloxInputCheckAssessment assessment, bool? robloxReacted)
    {
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=VERDICT verdict={assessment.Verdict} " +
            $"windowsPath={(assessment.Verdict is RobloxInputCheckVerdict.NativeDeliveryAwaitingObservation or RobloxInputCheckVerdict.Confirmed or RobloxInputCheckVerdict.RobloxDidNotReact or RobloxInputCheckVerdict.PowerShellOracleConfirmedProductionMappingDiffers ? "OBSERVED" : "NOT_CONFIRMED")} " +
            $"robloxReaction={(robloxReacted is null ? "UNKNOWN" : robloxReacted.Value ? "YES" : "NO")} success={assessment.IsSuccess}.");
    }

    [DllImport("kernel32.dll")]
    private static extern uint GetCurrentThreadId();
}
