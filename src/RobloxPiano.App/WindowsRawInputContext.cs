using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal enum WindowsRawInputInventoryAssessment
{
    Unknown = 0,
    NoKeyboardDeviceObserved = 1,
    PhysicalKeyboardDeviceObserved = 2
}

internal readonly record struct WindowsRawInputContextSnapshot(
    bool CaptureSucceeded,
    int Win32Error,
    uint KeyboardDeviceCount,
    uint MouseDeviceCount,
    uint HidDeviceCount,
    WindowsRawInputInventoryAssessment Assessment)
{
    internal const string TargetRegistrationVisibility = "UNOBSERVABLE_CROSS_PROCESS";
}

internal static class WindowsRawInputContext
{
    private const uint RidTypeMouse = 0;
    private const uint RidTypeKeyboard = 1;
    private const uint RidTypeHid = 2;

    internal static WindowsRawInputContextSnapshot Capture()
    {
        uint deviceCount = 0;
        var entrySize = (uint)Marshal.SizeOf<RawInputDeviceList>();

        var countResult = GetRawInputDeviceList(IntPtr.Zero, ref deviceCount, entrySize);
        if (countResult == uint.MaxValue)
        {
            return Unknown(Marshal.GetLastWin32Error());
        }

        if (deviceCount == 0)
        {
            return Create(0, 0, 0);
        }

        var bytes = checked((int)(deviceCount * entrySize));
        var buffer = Marshal.AllocHGlobal(bytes);
        try
        {
            var actualCount = deviceCount;
            var result = GetRawInputDeviceList(buffer, ref actualCount, entrySize);
            if (result == uint.MaxValue)
            {
                return Unknown(Marshal.GetLastWin32Error());
            }

            uint keyboards = 0;
            uint mice = 0;
            uint hid = 0;

            for (var index = 0u; index < actualCount; index++)
            {
                var itemPointer = IntPtr.Add(buffer, checked((int)(index * entrySize)));
                var item = Marshal.PtrToStructure<RawInputDeviceList>(itemPointer);
                switch (item.dwType)
                {
                    case RidTypeKeyboard:
                        keyboards++;
                        break;
                    case RidTypeMouse:
                        mice++;
                        break;
                    case RidTypeHid:
                        hid++;
                        break;
                }
            }

            return Create(keyboards, mice, hid);
        }
        finally
        {
            Marshal.FreeHGlobal(buffer);
        }
    }

    internal static WindowsRawInputInventoryAssessment Assess(uint keyboardDeviceCount)
        => keyboardDeviceCount > 0
            ? WindowsRawInputInventoryAssessment.PhysicalKeyboardDeviceObserved
            : WindowsRawInputInventoryAssessment.NoKeyboardDeviceObserved;

    private static WindowsRawInputContextSnapshot Create(uint keyboards, uint mice, uint hid)
        => new(
            true,
            0,
            keyboards,
            mice,
            hid,
            Assess(keyboards));

    private static WindowsRawInputContextSnapshot Unknown(int error)
        => new(
            false,
            error,
            0,
            0,
            0,
            WindowsRawInputInventoryAssessment.Unknown);

    [StructLayout(LayoutKind.Sequential)]
    private struct RawInputDeviceList
    {
        public IntPtr hDevice;
        public uint dwType;
    }

    [DllImport("user32.dll", SetLastError = true)]
    private static extern uint GetRawInputDeviceList(
        IntPtr pRawInputDeviceList,
        ref uint puiNumDevices,
        uint cbSize);
}
