using System.ComponentModel;
using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal enum WindowsGuiThreadFocusAssessment
{
    Unknown = 0,
    NoFocusedWindow = 1,
    TrustedTargetSurface = 2,
    SameProcessAlternateRoot = 3,
    DifferentProcess = 4
}

internal readonly record struct WindowsGuiThreadInputContextSnapshot(
    bool CaptureSucceeded,
    int Win32Error,
    uint ForegroundThreadId,
    IntPtr ActiveWindowHandle,
    IntPtr FocusWindowHandle,
    IntPtr CaptureWindowHandle,
    IntPtr MenuOwnerWindowHandle,
    IntPtr MoveSizeWindowHandle,
    IntPtr CaretWindowHandle,
    WindowsRobloxWindowRelation ActiveRelation,
    WindowsRobloxWindowRelation FocusRelation,
    WindowsRobloxWindowRelation CaptureRelation,
    WindowsGuiThreadFocusAssessment FocusAssessment)
{
    public bool HasKnownForeignFocus =>
        FocusAssessment is WindowsGuiThreadFocusAssessment.SameProcessAlternateRoot
            or WindowsGuiThreadFocusAssessment.DifferentProcess;
}

internal static class WindowsGuiThreadInputContext
{
    private const uint GaRoot = 2;
    private const uint GaRootOwner = 3;

    internal static WindowsGuiThreadInputContextSnapshot Capture(RobloxWindowTarget target)
    {
        ArgumentNullException.ThrowIfNull(target);

        var foreground = GetForegroundWindow();
        var foregroundThreadId = foreground == IntPtr.Zero
            ? 0
            : GetWindowThreadProcessId(foreground, out _);

        if (foregroundThreadId == 0)
        {
            return Unknown(foregroundThreadId, 0);
        }

        var info = new GuiThreadInfo
        {
            cbSize = (uint)Marshal.SizeOf<GuiThreadInfo>()
        };

        if (!GetGUIThreadInfo(foregroundThreadId, ref info))
        {
            return Unknown(foregroundThreadId, Marshal.GetLastWin32Error());
        }

        var activeRelation = ClassifySurface(target, info.hwndActive);
        var focusRelation = ClassifySurface(target, info.hwndFocus);
        var captureRelation = ClassifySurface(target, info.hwndCapture);

        return new WindowsGuiThreadInputContextSnapshot(
            true,
            0,
            foregroundThreadId,
            info.hwndActive,
            info.hwndFocus,
            info.hwndCapture,
            info.hwndMenuOwner,
            info.hwndMoveSize,
            info.hwndCaret,
            activeRelation,
            focusRelation,
            captureRelation,
            AssessFocus(info.hwndFocus, focusRelation));
    }

    internal static WindowsGuiThreadFocusAssessment AssessFocus(
        IntPtr focusWindow,
        WindowsRobloxWindowRelation focusRelation)
    {
        if (focusWindow == IntPtr.Zero)
        {
            return WindowsGuiThreadFocusAssessment.NoFocusedWindow;
        }

        return focusRelation switch
        {
            WindowsRobloxWindowRelation.ExactTarget or WindowsRobloxWindowRelation.TargetWindowTree
                => WindowsGuiThreadFocusAssessment.TrustedTargetSurface,
            WindowsRobloxWindowRelation.SameProcessAlternateRoot
                => WindowsGuiThreadFocusAssessment.SameProcessAlternateRoot,
            WindowsRobloxWindowRelation.DifferentProcess
                => WindowsGuiThreadFocusAssessment.DifferentProcess,
            _ => WindowsGuiThreadFocusAssessment.Unknown
        };
    }

    private static WindowsGuiThreadInputContextSnapshot Unknown(uint foregroundThreadId, int error)
        => new(
            false,
            error,
            foregroundThreadId,
            IntPtr.Zero,
            IntPtr.Zero,
            IntPtr.Zero,
            IntPtr.Zero,
            IntPtr.Zero,
            IntPtr.Zero,
            WindowsRobloxWindowRelation.Unknown,
            WindowsRobloxWindowRelation.Unknown,
            WindowsRobloxWindowRelation.Unknown,
            WindowsGuiThreadFocusAssessment.Unknown);

    private static WindowsRobloxWindowRelation ClassifySurface(RobloxWindowTarget target, IntPtr window)
    {
        if (window == IntPtr.Zero)
        {
            return WindowsRobloxWindowRelation.Unknown;
        }

        _ = GetWindowThreadProcessId(window, out var processId);
        var root = GetAncestor(window, GaRoot);
        var rootOwner = GetAncestor(window, GaRootOwner);
        var rootPid = GetProcessId(root);
        var rootOwnerPid = GetProcessId(rootOwner);

        return WindowsRobloxWindowIdentity.Classify(
            target.WindowHandle,
            target.ProcessId,
            window,
            processId,
            root,
            rootPid,
            rootOwner,
            rootOwnerPid);
    }

    private static uint GetProcessId(IntPtr window)
    {
        if (window == IntPtr.Zero)
        {
            return 0;
        }

        _ = GetWindowThreadProcessId(window, out var processId);
        return processId;
    }

    [StructLayout(LayoutKind.Sequential)]
    private struct GuiThreadInfo
    {
        public uint cbSize;
        public uint flags;
        public IntPtr hwndActive;
        public IntPtr hwndFocus;
        public IntPtr hwndCapture;
        public IntPtr hwndMenuOwner;
        public IntPtr hwndMoveSize;
        public IntPtr hwndCaret;
        public Rect rcCaret;
    }

    [StructLayout(LayoutKind.Sequential)]
    private struct Rect
    {
        public int Left;
        public int Top;
        public int Right;
        public int Bottom;
    }

    [DllImport("user32.dll")]
    private static extern IntPtr GetForegroundWindow();

    [DllImport("user32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool GetGUIThreadInfo(uint idThread, ref GuiThreadInfo pgui);

    [DllImport("user32.dll")]
    private static extern uint GetWindowThreadProcessId(IntPtr hWnd, out uint lpdwProcessId);

    [DllImport("user32.dll")]
    private static extern IntPtr GetAncestor(IntPtr hWnd, uint gaFlags);
}