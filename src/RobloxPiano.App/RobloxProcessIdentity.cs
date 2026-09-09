using System.Diagnostics;

namespace RobloxPiano.App;

internal readonly record struct RobloxProcessIdentity(int ProcessId, long StartTimeUtcTicks)
{
    public static bool TryCapture(int processId, out RobloxProcessIdentity identity)
    {
        identity = default;
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

            var startTimeUtc = process.StartTime.ToUniversalTime();
            identity = new RobloxProcessIdentity(process.Id, startTimeUtc.Ticks);
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

    public static RobloxProcessIdentity CaptureOrThrow(int processId)
        => TryCapture(processId, out var identity)
            ? identity
            : throw new InvalidOperationException($"Could not establish a stable lifetime identity for process {processId}.");

    public override string ToString() => $"PID {ProcessId} / startTicks {StartTimeUtcTicks}";
}
