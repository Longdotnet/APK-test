using System.Runtime.InteropServices;
using System.Text;

namespace RobloxPiano.App;

internal enum WindowsInputDesktopParity
{
    Unknown = 0,
    Same = 1,
    Different = 2
}

internal sealed record WindowsInputDesktopSnapshot(
    WindowsInputDesktopParity Parity,
    uint CurrentThreadId,
    string? AppDesktopName,
    string? InputDesktopName,
    int AppDesktopError,
    int InputDesktopError)
{
    internal bool IsKnownMismatch => Parity == WindowsInputDesktopParity.Different;
}

internal static class WindowsInputDesktop
{
    private const int UoiName = 2;
    private const uint DesktopReadObjects = 0x0001;

    internal static WindowsInputDesktopParity Classify(string? appDesktopName, string? inputDesktopName)
    {
        if (string.IsNullOrWhiteSpace(appDesktopName) || string.IsNullOrWhiteSpace(inputDesktopName))
        {
            return WindowsInputDesktopParity.Unknown;
        }

        return string.Equals(appDesktopName, inputDesktopName, StringComparison.OrdinalIgnoreCase)
            ? WindowsInputDesktopParity.Same
            : WindowsInputDesktopParity.Different;
    }

    internal static WindowsInputDesktopSnapshot Capture()
    {
        var currentThreadId = GetCurrentThreadId();
        var appDesktop = GetThreadDesktop(currentThreadId);
        var appDesktopError = appDesktop == IntPtr.Zero ? Marshal.GetLastWin32Error() : 0;
        var appDesktopName = appDesktop == IntPtr.Zero ? null : TryGetObjectName(appDesktop, out appDesktopError);

        var inputDesktop = OpenInputDesktop(0, inherit: false, DesktopReadObjects);
        var inputDesktopError = inputDesktop == IntPtr.Zero ? Marshal.GetLastWin32Error() : 0;
        string? inputDesktopName = null;
        if (inputDesktop != IntPtr.Zero)
        {
            try
            {
                inputDesktopName = TryGetObjectName(inputDesktop, out inputDesktopError);
            }
            finally
            {
                _ = CloseDesktop(inputDesktop);
            }
        }

        return new WindowsInputDesktopSnapshot(
            Classify(appDesktopName, inputDesktopName),
            currentThreadId,
            appDesktopName,
            inputDesktopName,
            appDesktopError,
            inputDesktopError);
    }

    private static string? TryGetObjectName(IntPtr handle, out int error)
    {
        error = 0;
        _ = GetUserObjectInformationW(handle, UoiName, null, 0, out var requiredBytes);
        if (requiredBytes == 0)
        {
            error = Marshal.GetLastWin32Error();
            return null;
        }

        var capacity = checked((int)(requiredBytes / sizeof(char)) + 1);
        var buffer = new StringBuilder(capacity);
        if (!GetUserObjectInformationW(handle, UoiName, buffer, checked((uint)(capacity * sizeof(char))), out _))
        {
            error = Marshal.GetLastWin32Error();
            return null;
        }

        return buffer.ToString();
    }

    [DllImport("kernel32.dll")]
    private static extern uint GetCurrentThreadId();

    [DllImport("user32.dll", SetLastError = true)]
    private static extern IntPtr GetThreadDesktop(uint threadId);

    [DllImport("user32.dll", SetLastError = true)]
    private static extern IntPtr OpenInputDesktop(uint flags, [MarshalAs(UnmanagedType.Bool)] bool inherit, uint desiredAccess);

    [DllImport("user32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool CloseDesktop(IntPtr desktop);

    [DllImport("user32.dll", CharSet = CharSet.Unicode, SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool GetUserObjectInformationW(
        IntPtr handle,
        int index,
        StringBuilder? information,
        uint length,
        out uint needed);
}
