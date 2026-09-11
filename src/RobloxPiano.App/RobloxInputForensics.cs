using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal static class RobloxInputForensics
{
    internal static string NewProbeId() => Guid.NewGuid().ToString("N")[..12];

    internal static WindowsRobloxWindowIdentitySnapshot LogEnvironment(string probeId, RobloxWindowTarget target, char character)
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
        var window = WindowsRobloxWindowIdentity.Capture(target);
        var gui = WindowsGuiThreadInputContext.Capture(target);

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
            $"windowRelation={window.Relation} targetClass='{window.TargetWindowClass}' foregroundClass='{window.ForegroundWindowClass}' foregroundRootClass='{window.ForegroundRootClass}' " +
            $"targetMainHwnd=0x{window.CurrentMainWindowHandle.ToInt64():X} targetMainReplaced={window.TargetMainWindowReplaced} " +
            $"foregroundRootHwnd=0x{window.ForegroundRootHandle.ToInt64():X} foregroundRootPid={window.ForegroundRootProcessId} " +
            $"foregroundRootOwnerHwnd=0x{window.ForegroundRootOwnerHandle.ToInt64():X} foregroundRootOwnerPid={window.ForegroundRootOwnerProcessId} " +
            $"guiInfoOk={gui.CaptureSucceeded} guiInfoError={gui.Win32Error} guiTid={gui.ForegroundThreadId} " +
            $"guiActiveHwnd=0x{gui.ActiveWindowHandle.ToInt64():X} guiActiveRelation={gui.ActiveRelation} " +
            $"guiFocusHwnd=0x{gui.FocusWindowHandle.ToInt64():X} guiFocusRelation={gui.FocusRelation} guiFocusAssessment={gui.FocusAssessment} " +
            $"guiCaptureHwnd=0x{gui.CaptureWindowHandle.ToInt64():X} guiCaptureRelation={gui.CaptureRelation} " +
            $"guiMenuOwnerHwnd=0x{gui.MenuOwnerWindowHandle.ToInt64():X} guiMoveSizeHwnd=0x{gui.MoveSizeWindowHandle.ToInt64():X} guiCaretHwnd=0x{gui.CaretWindowHandle.ToInt64():X} " +
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

        if (window.IsKnownTargetWindowReplacement)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=WINDOW_BLOCKER verdict=TARGET_WINDOW_REPLACED " +
                $"targetHwnd=0x{window.TargetWindowHandle.ToInt64():X} currentMainHwnd=0x{window.CurrentMainWindowHandle.ToInt64():X} " +
                "guidance='The selected Roblox process is still alive but its main window changed. Re-run Test Roblox Input so activation and observation bind to the current Roblox window before judging input consumption.'.");
        }
        else if (window.Relation == WindowsRobloxWindowRelation.SameProcessAlternateRoot)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=WINDOW_CONTEXT verdict=SAME_PROCESS_ALTERNATE_ROOT " +
                $"targetHwnd=0x{window.TargetWindowHandle.ToInt64():X} foregroundHwnd=0x{window.ForegroundWindowHandle.ToInt64():X} " +
                $"foregroundRootHwnd=0x{window.ForegroundRootHandle.ToInt64():X} foregroundRootOwnerHwnd=0x{window.ForegroundRootOwnerHandle.ToInt64():X} " +
                "guidance='Foreground belongs to the Roblox PID but is not the originally selected root window. Preserve this evidence when comparing game, overlay, splash, or replacement-window behavior.'.");
        }

        LogGuiThreadContext(probeId, "GUI_CONTEXT", gui);
        return window;
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
        var window = WindowsRobloxWindowIdentity.Capture(target);
        var gui = WindowsGuiThreadInputContext.Capture(target);
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage={stage} backend={WindowsKeyboardInputSink.BackendName} " +
            $"probeMapping={KeyboardMappingStrategy.PowerShellOracle} vk=0x{virtualKey:X2} keyState={(down ? "DOWN" : "UP")} targetForeground={target.IsForeground} " +
            $"windowRelation={window.Relation} targetMainReplaced={window.TargetMainWindowReplaced} " +
            $"guiInfoOk={gui.CaptureSucceeded} guiInfoError={gui.Win32Error} guiFocusHwnd=0x{gui.FocusWindowHandle.ToInt64():X} " +
            $"guiFocusRelation={gui.FocusRelation} guiFocusAssessment={gui.FocusAssessment} guiCaptureHwnd=0x{gui.CaptureWindowHandle.ToInt64():X} guiCaptureRelation={gui.CaptureRelation} " +
            $"targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} foregroundTid={foregroundThreadId} " +
            $"foregroundRootHwnd=0x{window.ForegroundRootHandle.ToInt64():X} foregroundRootOwnerHwnd=0x{window.ForegroundRootOwnerHandle.ToInt64():X} " +
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

    private static void LogGuiThreadContext(
        string probeId,
        string stage,
        WindowsGuiThreadInputContextSnapshot gui)
    {
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage={stage} guiInfoOk={gui.CaptureSucceeded} guiInfoError={gui.Win32Error} guiTid={gui.ForegroundThreadId} " +
            $"activeHwnd=0x{gui.ActiveWindowHandle.ToInt64():X} activeRelation={gui.ActiveRelation} " +
            $"focusHwnd=0x{gui.FocusWindowHandle.ToInt64():X} focusRelation={gui.FocusRelation} focusAssessment={gui.FocusAssessment} " +
            $"captureHwnd=0x{gui.CaptureWindowHandle.ToInt64():X} captureRelation={gui.CaptureRelation} " +
            $"menuOwnerHwnd=0x{gui.MenuOwnerWindowHandle.ToInt64():X} moveSizeHwnd=0x{gui.MoveSizeWindowHandle.ToInt64():X} caretHwnd=0x{gui.CaretWindowHandle.ToInt64():X}.");

        if (!gui.CaptureSucceeded)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=GUI_CONTEXT_UNAVAILABLE verdict=GUI_THREAD_INFO_UNAVAILABLE win32Error={gui.Win32Error} " +
                "guidance='The foreground GUI thread changed or GetGUIThreadInfo was unavailable. Preserve this evidence and do not infer Roblox focus/capture state from foreground HWND alone.'.");
        }
        else if (gui.FocusAssessment == WindowsGuiThreadFocusAssessment.SameProcessAlternateRoot)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=GUI_FOCUS_CONTEXT verdict=GUI_FOCUS_SAME_PROCESS_ALTERNATE_ROOT " +
                $"focusHwnd=0x{gui.FocusWindowHandle.ToInt64():X} focusRelation={gui.FocusRelation} " +
                "guidance='Foreground is Roblox, but the foreground GUI thread focus is on another root in the same Roblox process. Preserve this as input-consumption context.'.");
        }
        else if (gui.FocusAssessment == WindowsGuiThreadFocusAssessment.DifferentProcess)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=GUI_FOCUS_CONTEXT verdict=GUI_FOCUS_OUTSIDE_ROBLOX " +
                $"focusHwnd=0x{gui.FocusWindowHandle.ToInt64():X} focusRelation={gui.FocusRelation} " +
                "guidance='Foreground/root identity alone is insufficient here because the foreground GUI thread reports focus outside the selected Roblox surface.'.");
        }
        else if (gui.FocusAssessment == WindowsGuiThreadFocusAssessment.NoFocusedWindow)
        {
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=GUI_FOCUS_CONTEXT verdict=GUI_FOCUS_NONE " +
                "guidance='The foreground GUI thread reports no focus HWND. Preserve this evidence when comparing Roblox experiences and overlays; do not treat it as field PASS or FAIL by itself.'.");
        }
    }

    [DllImport("kernel32.dll")]
    private static extern uint GetCurrentThreadId();
}
