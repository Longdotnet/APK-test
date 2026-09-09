using System.Diagnostics;
using System.Runtime.InteropServices;
using System.Text.Json;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal sealed record RobloxWindowTarget(int ProcessId, IntPtr WindowHandle, string WindowTitle)
{
    public bool IsAlive
    {
        get
        {
            try
            {
                using var process = Process.GetProcessById(ProcessId);
                return !process.HasExited;
            }
            catch (ArgumentException)
            {
                return false;
            }
            catch (InvalidOperationException)
            {
                return false;
            }
            catch (SystemException)
            {
                return false;
            }
        }
    }

    public bool IsForeground
        => IsAlive
           && WindowHandle != IntPtr.Zero
           && ClientNativeMethods.GetForegroundWindow() == WindowHandle;

    public bool TryActivate()
    {
        if (!IsAlive || WindowHandle == IntPtr.Zero)
        {
            return false;
        }

        _ = ClientNativeMethods.ShowWindowAsync(WindowHandle, ClientNativeMethods.SwRestore);
        var requested = ClientNativeMethods.SetForegroundWindow(WindowHandle);
        if (!requested)
        {
            ClientDiagnostics.Log($"Roblox activation request was rejected: target={this}, hwnd=0x{WindowHandle.ToInt64():X}.");
            return false;
        }

        // Match the proven PowerShell client: let Windows finish foreground activation before the
        // first playback deadline can dispatch a key. This is intentionally small and bounded.
        Thread.Sleep(250);
        var focused = IsForeground;
        ClientDiagnostics.Log(
            $"Roblox activation {(focused ? "confirmed" : "requested but not foreground")}: " +
            $"target={this}, hwnd=0x{WindowHandle.ToInt64():X}.");
        return focused;
    }

    public override string ToString()
    {
        return string.IsNullOrWhiteSpace(WindowTitle)
            ? $"Roblox (PID {ProcessId})"
            : $"{WindowTitle} (PID {ProcessId})";
    }
}

internal static class RobloxProcessLocator
{
    public static RobloxWindowTarget? FindPreferred()
    {
        var foreground = TryGetForegroundRoblox();
        if (foreground is not null)
        {
            return foreground;
        }

        var candidates = new List<RobloxCandidate>();
        foreach (var process in Process.GetProcesses())
        {
            using (process)
            {
                try
                {
                    var processName = process.ProcessName;
                    if (!IsRobloxPlayerProcess(processName))
                    {
                        continue;
                    }

                    var handle = process.MainWindowHandle;
                    if (handle == IntPtr.Zero)
                    {
                        continue;
                    }

                    DateTime startTime;
                    try
                    {
                        startTime = process.StartTime;
                    }
                    catch (SystemException)
                    {
                        startTime = DateTime.MinValue;
                    }

                    candidates.Add(new RobloxCandidate(
                        process.Id,
                        handle,
                        process.MainWindowTitle,
                        startTime,
                        processName.Equals("RobloxPlayerBeta", StringComparison.OrdinalIgnoreCase)));
                }
                catch (InvalidOperationException)
                {
                }
                catch (SystemException)
                {
                }
            }
        }

        var best = candidates
            .OrderByDescending(candidate => candidate.IsExactPlayer)
            .ThenByDescending(candidate => candidate.StartTime)
            .FirstOrDefault();

        return best is null
            ? null
            : new RobloxWindowTarget(best.ProcessId, best.WindowHandle, best.WindowTitle);
    }

    private static RobloxWindowTarget? TryGetForegroundRoblox()
    {
        var foreground = ClientNativeMethods.GetForegroundWindow();
        if (foreground == IntPtr.Zero)
        {
            return null;
        }

        ClientNativeMethods.GetWindowThreadProcessId(foreground, out var rawProcessId);
        if (rawProcessId == 0 || rawProcessId > int.MaxValue)
        {
            return null;
        }

        try
        {
            using var process = Process.GetProcessById((int)rawProcessId);
            return IsRobloxPlayerProcess(process.ProcessName)
                ? new RobloxWindowTarget(process.Id, foreground, process.MainWindowTitle)
                : null;
        }
        catch (ArgumentException)
        {
            return null;
        }
        catch (InvalidOperationException)
        {
            return null;
        }
        catch (SystemException)
        {
            return null;
        }
    }

    private static bool IsRobloxPlayerProcess(string processName)
    {
        if (processName.Contains("Studio", StringComparison.OrdinalIgnoreCase))
        {
            return false;
        }

        return processName.Equals("RobloxPlayerBeta", StringComparison.OrdinalIgnoreCase)
            || processName.Equals("RobloxPlayer", StringComparison.OrdinalIgnoreCase)
            || processName.Contains("Roblox", StringComparison.OrdinalIgnoreCase);
    }

    private sealed record RobloxCandidate(
        int ProcessId,
        IntPtr WindowHandle,
        string WindowTitle,
        DateTime StartTime,
        bool IsExactPlayer);
}

internal sealed class RobloxTargetFocusGate(RobloxWindowTarget target) : IFocusGate
{
    public bool IsTargetFocused => target.IsForeground;
}

internal sealed record ClientState(string? LastSheetPath, double PreferredSpeed, int InputLatencyMs = 0)
{
    public static ClientState Default { get; } = new(null, 1d, 0);
}

internal static class ClientStateStore
{
    private static readonly JsonSerializerOptions JsonOptions = new()
    {
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
        WriteIndented = true
    };

    public static ClientState Load()
    {
        try
        {
            var path = GetStatePath();
            if (!File.Exists(path))
            {
                return ClientState.Default;
            }

            var json = File.ReadAllText(path);
            var state = JsonSerializer.Deserialize<ClientState>(json, JsonOptions);
            if (state is null || !double.IsFinite(state.PreferredSpeed))
            {
                return ClientState.Default;
            }

            return state with
            {
                PreferredSpeed = Math.Clamp(
                    state.PreferredSpeed,
                    PlaybackSessionClock.MinimumSpeed,
                    PlaybackSessionClock.MaximumSpeed),
                InputLatencyMs = Math.Clamp(
                    state.InputLatencyMs,
                    0,
                    (int)PlaybackTimingProfile.MaximumDispatchLead.TotalMilliseconds)
            };
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or JsonException
            or ArgumentException)
        {
            ClientDiagnostics.Log($"State load failed: {exception.Message}");
            return ClientState.Default;
        }
    }

    public static void Save(ClientState state)
    {
        try
        {
            var path = GetStatePath();
            var directory = Path.GetDirectoryName(path);
            if (!string.IsNullOrWhiteSpace(directory))
            {
                Directory.CreateDirectory(directory);
            }

            File.WriteAllText(path, JsonSerializer.Serialize(state, JsonOptions));
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException)
        {
            ClientDiagnostics.Log($"State save failed: {exception.Message}");
        }
    }

    private static string GetStatePath()
    {
        return Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "state.json");
    }
}

internal static class ClientDiagnostics
{
    private static readonly object Gate = new();

    public static string DirectoryPath => Path.Combine(
        Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
        "RobloxPiano",
        "logs");

    public static void Log(string message)
    {
        try
        {
            lock (Gate)
            {
                Directory.CreateDirectory(DirectoryPath);
                var path = Path.Combine(DirectoryPath, $"client-{DateTime.UtcNow:yyyyMMdd}.log");
                File.AppendAllText(
                    path,
                    $"{DateTimeOffset.Now:O} {message}{Environment.NewLine}");
            }
        }
        catch
        {
        }
    }
}

internal static class ClientConsoleWindow
{
    public static void Hide()
    {
        var handle = ClientNativeMethods.GetConsoleWindow();
        if (handle != IntPtr.Zero)
        {
            _ = ClientNativeMethods.ShowWindow(handle, ClientNativeMethods.SwHide);
        }
    }
}

internal static class ClientNativeMethods
{
    internal const int WmHotkey = 0x0312;
    internal const uint ModNoRepeat = 0x4000;
    internal const int SwHide = 0;
    internal const int SwRestore = 9;

    [DllImport("user32.dll")]
    [return: MarshalAs(UnmanagedType.Bool)]
    internal static extern bool RegisterHotKey(IntPtr windowHandle, int id, uint modifiers, uint virtualKey);

    [DllImport("user32.dll")]
    [return: MarshalAs(UnmanagedType.Bool)]
    internal static extern bool UnregisterHotKey(IntPtr windowHandle, int id);

    [DllImport("user32.dll")]
    internal static extern IntPtr GetForegroundWindow();

    [DllImport("user32.dll")]
    internal static extern uint GetWindowThreadProcessId(IntPtr window, out uint processId);

    [DllImport("user32.dll")]
    [return: MarshalAs(UnmanagedType.Bool)]
    internal static extern bool SetForegroundWindow(IntPtr windowHandle);

    [DllImport("user32.dll")]
    [return: MarshalAs(UnmanagedType.Bool)]
    internal static extern bool ShowWindowAsync(IntPtr windowHandle, int command);

    [DllImport("kernel32.dll")]
    internal static extern IntPtr GetConsoleWindow();

    [DllImport("user32.dll")]
    [return: MarshalAs(UnmanagedType.Bool)]
    internal static extern bool ShowWindow(IntPtr windowHandle, int command);
}
