using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal enum WindowsSessionParity
{
    Unknown = 0,
    Same = 1,
    Different = 2
}

internal readonly record struct WindowsInteractiveSessionSnapshot(
    uint? AppSessionId,
    uint? TargetSessionId,
    uint ActiveConsoleSessionId,
    WindowsSessionParity Parity,
    int AppSessionError,
    int TargetSessionError)
{
    public bool IsKnownMismatch => Parity == WindowsSessionParity.Different;
    public bool AppIsActiveConsole => AppSessionId is not null && AppSessionId.Value == ActiveConsoleSessionId;
    public bool TargetIsActiveConsole => TargetSessionId is not null && TargetSessionId.Value == ActiveConsoleSessionId;
}

internal static class WindowsInteractiveSession
{
    private const uint InvalidSessionId = 0xFFFFFFFF;

    internal static WindowsInteractiveSessionSnapshot Capture(int targetProcessId)
    {
        var appKnown = TryGetSessionId(Environment.ProcessId, out var appSessionId, out var appError);
        var targetKnown = TryGetSessionId(targetProcessId, out var targetSessionId, out var targetError);
        var activeConsole = WTSGetActiveConsoleSessionId();

        return new WindowsInteractiveSessionSnapshot(
            appKnown ? appSessionId : null,
            targetKnown ? targetSessionId : null,
            activeConsole,
            Classify(appKnown ? appSessionId : null, targetKnown ? targetSessionId : null),
            appError,
            targetError);
    }

    internal static WindowsSessionParity Classify(uint? appSessionId, uint? targetSessionId)
    {
        if (appSessionId is null || targetSessionId is null)
        {
            return WindowsSessionParity.Unknown;
        }

        return appSessionId.Value == targetSessionId.Value
            ? WindowsSessionParity.Same
            : WindowsSessionParity.Different;
    }

    internal static string FormatConsoleSession(uint sessionId)
        => sessionId == InvalidSessionId ? "NONE" : sessionId.ToString(System.Globalization.CultureInfo.InvariantCulture);

    private static bool TryGetSessionId(int processId, out uint sessionId, out int error)
    {
        if (processId <= 0)
        {
            sessionId = 0;
            error = 87;
            return false;
        }

        if (ProcessIdToSessionId((uint)processId, out sessionId))
        {
            error = 0;
            return true;
        }

        error = Marshal.GetLastWin32Error();
        return false;
    }

    [DllImport("kernel32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool ProcessIdToSessionId(uint dwProcessId, out uint pSessionId);

    [DllImport("kernel32.dll")]
    private static extern uint WTSGetActiveConsoleSessionId();
}
