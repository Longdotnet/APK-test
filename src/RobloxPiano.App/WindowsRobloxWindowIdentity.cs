using System.Diagnostics;
using System.Runtime.InteropServices;
using System.Text;

namespace RobloxPiano.App;

internal enum WindowsRobloxWindowRelation
{
    Unknown = 0,
    ExactTarget = 1,
    TargetWindowTree = 2,
    SameProcessAlternateRoot = 3,
    DifferentProcess = 4
}

internal readonly record struct WindowsRobloxWindowIdentitySnapshot(
    IntPtr TargetWindowHandle,
    IntPtr CurrentMainWindowHandle,
    IntPtr ForegroundWindowHandle,
    uint ForegroundProcessId,
    uint ForegroundThreadId,
    IntPtr ForegroundRootHandle,
    uint ForegroundRootProcessId,
    IntPtr ForegroundRootOwnerHandle,
    uint ForegroundRootOwnerProcessId,
    string TargetWindowClass,
    string ForegroundWindowClass,
    string ForegroundRootClass,
    WindowsRobloxWindowRelation Relation,
    bool TargetProcessAlive,
    bool TargetMainWindowReplaced)
{
    public bool IsKnownTargetWindowReplacement => TargetProcessAlive && TargetMainWindowReplaced;
}

internal static class WindowsRobloxWindowIdentity
{
    private const uint GaRoot = 2;
    private const uint GaRootOwner = 3;

    internal static WindowsRobloxWindowIdentitySnapshot Capture(RobloxWindowTarget target)
    {
        ArgumentNullException.ThrowIfNull(target);

        var foreground = GetForegroundWindow();
        uint foregroundTid = 0;
        uint foregroundPid = 0;
        if (foreground != IntPtr.Zero)
        {
            foregroundTid = GetWindowThreadProcessId(foreground, out foregroundPid);
        }

        var foregroundRoot = foreground == IntPtr.Zero ? IntPtr.Zero : GetAncestor(foreground, GaRoot);
        var foregroundRootOwner = foreground == IntPtr.Zero ? IntPtr.Zero : GetAncestor(foreground, GaRootOwner);
        var foregroundRootPid = GetProcessId(foregroundRoot);
        var foregroundRootOwnerPid = GetProcessId(foregroundRootOwner);

        var targetProcessAlive = TryGetCurrentMainWindow(target.ProcessId, out var currentMainWindow);
        var targetMainWindowReplaced = targetProcessAlive
            && currentMainWindow != IntPtr.Zero
            && target.WindowHandle != IntPtr.Zero
            && currentMainWindow != target.WindowHandle;

        var relation = Classify(
            target.WindowHandle,
            target.ProcessId,
            foreground,
            foregroundPid,
            foregroundRoot,
            foregroundRootPid,
            foregroundRootOwner,
            foregroundRootOwnerPid);

        return new WindowsRobloxWindowIdentitySnapshot(
            target.WindowHandle,
            currentMainWindow,
            foreground,
            foregroundPid,
            foregroundTid,
            foregroundRoot,
            foregroundRootPid,
            foregroundRootOwner,
            foregroundRootOwnerPid,
            GetClassNameSafe(target.WindowHandle),
            GetClassNameSafe(foreground),
            GetClassNameSafe(foregroundRoot),
            relation,
            targetProcessAlive,
            targetMainWindowReplaced);
    }

    internal static WindowsRobloxWindowRelation Classify(
        IntPtr targetWindow,
        int targetProcessId,
        IntPtr foregroundWindow,
        uint foregroundProcessId,
        IntPtr foregroundRoot,
        uint foregroundRootProcessId,
        IntPtr foregroundRootOwner,
        uint foregroundRootOwnerProcessId)
    {
        if (targetWindow == IntPtr.Zero || targetProcessId <= 0 || foregroundWindow == IntPtr.Zero)
        {
            return WindowsRobloxWindowRelation.Unknown;
        }

        if (foregroundWindow == targetWindow)
        {
            return WindowsRobloxWindowRelation.ExactTarget;
        }

        if (foregroundRoot == targetWindow || foregroundRootOwner == targetWindow)
        {
            return WindowsRobloxWindowRelation.TargetWindowTree;
        }

        var targetPid = (uint)targetProcessId;
        if (foregroundProcessId == targetPid)
        {
            return WindowsRobloxWindowRelation.SameProcessAlternateRoot;
        }

        if (foregroundRootProcessId == targetPid || foregroundRootOwnerProcessId == targetPid)
        {
            return WindowsRobloxWindowRelation.TargetWindowTree;
        }

        return WindowsRobloxWindowRelation.DifferentProcess;
    }

    private static bool TryGetCurrentMainWindow(int processId, out IntPtr mainWindowHandle)
    {
        mainWindowHandle = IntPtr.Zero;
        if (processId <= 0)
        {
            return false;
        }

        try
        {
            using var process = Process.GetProcessById(processId);
            if (process.HasExited)
            {
                return false;
            }

            mainWindowHandle = process.MainWindowHandle;
            return true;
        }
        catch (Exception exception) when (
            exception is ArgumentException
            or InvalidOperationException
            or System.ComponentModel.Win32Exception
            or NotSupportedException)
        {
            return false;
        }
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

    private static string GetClassNameSafe(IntPtr window)
    {
        if (window == IntPtr.Zero)
        {
            return "NONE";
        }

        var buffer = new StringBuilder(256);
        var length = GetClassNameW(window, buffer, buffer.Capacity);
        return length > 0 ? buffer.ToString() : "UNKNOWN";
    }

    [DllImport("user32.dll")]
    private static extern IntPtr GetForegroundWindow();

    [DllImport("user32.dll")]
    private static extern uint GetWindowThreadProcessId(IntPtr hWnd, out uint lpdwProcessId);

    [DllImport("user32.dll")]
    private static extern IntPtr GetAncestor(IntPtr hWnd, uint gaFlags);

    [DllImport("user32.dll", CharSet = CharSet.Unicode)]
    private static extern int GetClassNameW(IntPtr hWnd, StringBuilder lpClassName, int nMaxCount);
}
