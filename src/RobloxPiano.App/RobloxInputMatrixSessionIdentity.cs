namespace RobloxPiano.App;

internal readonly record struct RobloxInputMatrixSessionIdentity(
    RobloxProcessIdentity ProcessIdentity,
    long SelectedWindowHandleValue)
{
    public int ProcessId => ProcessIdentity.ProcessId;
    public long StartTimeUtcTicks => ProcessIdentity.StartTimeUtcTicks;
    public IntPtr SelectedWindowHandle => new(SelectedWindowHandleValue);

    public static bool TryCapture(
        RobloxWindowTarget target,
        out RobloxInputMatrixSessionIdentity identity)
    {
        ArgumentNullException.ThrowIfNull(target);
        identity = default;

        if (target.WindowHandle == IntPtr.Zero)
        {
            return false;
        }

        if (!RobloxProcessIdentity.TryCapture(target.ProcessId, out var processIdentity))
        {
            return false;
        }

        identity = new RobloxInputMatrixSessionIdentity(processIdentity, target.WindowHandle.ToInt64());
        return true;
    }

    public string ToLogToken()
        => $"pid={ProcessId};startTicks={StartTimeUtcTicks};hwnd=0x{SelectedWindowHandleValue:X}";

    public override string ToString() => ToLogToken();
}
