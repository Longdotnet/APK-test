using System.Diagnostics;
using System.Runtime.InteropServices;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal sealed class RobloxForegroundFocusGate : IFocusGate
{
    public bool IsTargetFocused
    {
        get
        {
            var foregroundWindow = NativeMethods.GetForegroundWindow();
            if (foregroundWindow == IntPtr.Zero)
            {
                return false;
            }

            NativeMethods.GetWindowThreadProcessId(foregroundWindow, out var processId);
            if (processId == 0)
            {
                return false;
            }

            try
            {
                using var process = Process.GetProcessById(checked((int)processId));
                return process.ProcessName.Equals("RobloxPlayerBeta", StringComparison.OrdinalIgnoreCase)
                    || process.ProcessName.Contains("Roblox", StringComparison.OrdinalIgnoreCase);
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
}

internal sealed class AlwaysFocusedGate : IFocusGate
{
    public bool IsTargetFocused => true;
}

internal sealed class TraceInputSink(Func<TimeSpan> now) : IInputSink
{
    public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        Console.WriteLine($"{now(),10:mm\\:ss\\.fff} DOWN [{new string(keys.ToArray())}]");
        return ValueTask.CompletedTask;
    }

    public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        Console.WriteLine($"{now(),10:mm\\:ss\\.fff} UP   [{new string(keys.ToArray())}]");
        return ValueTask.CompletedTask;
    }

    public ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
    {
        Console.WriteLine($"{now(),10:mm\\:ss\\.fff} SAFE release-all");
        return ValueTask.CompletedTask;
    }
}

internal sealed class WindowsInputInjectionException : InvalidOperationException
{
    public WindowsInputInjectionException(string message)
        : base(message)
    {
    }

    public WindowsInputInjectionException(string message, Exception innerException)
        : base(message, innerException)
    {
    }
}

internal enum KeyboardMappingStrategy
{
    ForegroundLayout = 0,
    PowerShellOracle = 1
}

internal readonly record struct KeyboardStrokeMapping(
    ushort VirtualKey,
    byte Modifiers,
    IntPtr KeyboardLayout,
    uint KeyboardThreadId);

internal sealed class WindowsKeyboardInputSink : IInputSink
{
    internal const string BackendName = "keybd_event";
    internal static readonly TimeSpan MinimumPhysicalKeyHold = TimeSpan.FromMilliseconds(50);

    private const byte ShiftModifier = 0x01;
    private const byte ControlModifier = 0x02;
    private const byte AltModifier = 0x04;

    private const ushort VirtualKeyShift = 0x10;
    private const ushort VirtualKeyControl = 0x11;
    private const ushort VirtualKeyMenu = 0x12;

    private readonly object _gate = new();
    private readonly HashSet<ushort> _heldKeys = new();
    private readonly Dictionary<ushort, long> _pressedAt = new();
    private readonly KeyboardMappingStrategy _mappingStrategy;
    private long _dispatchSequence;

    public WindowsKeyboardInputSink(KeyboardMappingStrategy mappingStrategy = KeyboardMappingStrategy.ForegroundLayout)
    {
        _mappingStrategy = mappingStrategy;
        ClientDiagnostics.Log(
            $"Keyboard input backend initialized: {BackendName} (PowerShell field baseline), " +
            $"mappingStrategy={_mappingStrategy}, processPid={Environment.ProcessId}, thread={Environment.CurrentManagedThreadId}, " +
            $"minimumPhysicalHoldMs={MinimumPhysicalKeyHold.TotalMilliseconds:0}.");
    }

    public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        ArgumentNullException.ThrowIfNull(keys);

        var strokes = keys.Select(character => ResolveStroke(character, _mappingStrategy)).ToArray();
        lock (_gate)
        {
            LogDispatch("DOWN", keys, strokes);
            foreach (var stroke in strokes)
            {
                PressModifiers(stroke.Modifiers);
                try
                {
                    SendVirtualKey(stroke.VirtualKey, keyUp: false);
                    _heldKeys.Add(stroke.VirtualKey);
                    _pressedAt[stroke.VirtualKey] = Stopwatch.GetTimestamp();
                }
                finally
                {
                    ReleaseModifiers(stroke.Modifiers);
                }
            }
        }

        return ValueTask.CompletedTask;
    }

    public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        ArgumentNullException.ThrowIfNull(keys);

        var strokes = keys.Select(character => ResolveStroke(character, _mappingStrategy)).Reverse().ToArray();
        lock (_gate)
        {
            LogDispatch("UP", keys, strokes);
            foreach (var stroke in strokes)
            {
                if (_heldKeys.Remove(stroke.VirtualKey))
                {
                    if (_pressedAt.Remove(stroke.VirtualKey, out var pressedAt))
                    {
                        WaitForMinimumPhysicalHold(pressedAt);
                    }

                    SendVirtualKey(stroke.VirtualKey, keyUp: true);
                }
            }
        }

        return ValueTask.CompletedTask;
    }

    public ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
    {
        lock (_gate)
        {
            if (_heldKeys.Count > 0)
            {
                LogReleaseAll();
            }

            foreach (var virtualKey in _heldKeys.ToArray().Reverse())
            {
                TrySendKeyUp(virtualKey);
            }

            _heldKeys.Clear();
            _pressedAt.Clear();
            TrySendKeyUp(VirtualKeyShift);
            TrySendKeyUp(VirtualKeyControl);
            TrySendKeyUp(VirtualKeyMenu);
        }

        return ValueTask.CompletedTask;
    }

    internal static ushort ResolveVirtualKeyForDiagnostics(char character)
        => ResolveStroke(character, KeyboardMappingStrategy.ForegroundLayout).VirtualKey;

    internal static KeyboardStrokeMapping ResolveStrokeForDiagnostics(char character)
        => ResolveStroke(character, KeyboardMappingStrategy.ForegroundLayout);

    internal static KeyboardStrokeMapping ResolvePowerShellOracleStrokeForDiagnostics(char character)
        => ResolveStroke(character, KeyboardMappingStrategy.PowerShellOracle);

    internal static bool HasSameKeySemantics(KeyboardStrokeMapping first, KeyboardStrokeMapping second)
        => first.VirtualKey == second.VirtualKey && first.Modifiers == second.Modifiers;

    internal static bool IsVirtualKeyDown(ushort virtualKey)
    {
        if (virtualKey > byte.MaxValue)
        {
            return false;
        }

        return (NativeMethods.GetAsyncKeyState(checked((int)virtualKey)) & 0x8000) != 0;
    }

    internal static TimeSpan RemainingMinimumPhysicalHold(TimeSpan alreadyHeld)
    {
        if (alreadyHeld < TimeSpan.Zero)
        {
            throw new ArgumentOutOfRangeException(nameof(alreadyHeld));
        }

        var remaining = MinimumPhysicalKeyHold - alreadyHeld;
        return remaining > TimeSpan.Zero ? remaining : TimeSpan.Zero;
    }

    private void LogDispatch(string action, IReadOnlyList<char> keys, IReadOnlyList<KeyboardStrokeMapping> strokes)
    {
        var sequence = Interlocked.Increment(ref _dispatchSequence);
        if (sequence > 20 && sequence % 100 != 0)
        {
            return;
        }

        var foreground = NativeMethods.GetForegroundWindow();
        var foregroundThreadId = NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        var virtualKeys = string.Join(",", strokes.Select(stroke =>
            $"0x{stroke.VirtualKey:X2}/m{stroke.Modifiers:X2}/hkl0x{stroke.KeyboardLayout.ToInt64():X}/tid{stroke.KeyboardThreadId}"));
        ClientDiagnostics.Log(
            $"Input dispatch #{sequence} {action}: chars='{new string(keys.ToArray())}', vk=[{virtualKeys}], mappingStrategy={_mappingStrategy}, " +
            $"thread={Environment.CurrentManagedThreadId}, fgHwnd=0x{foreground.ToInt64():X}, fgPid={foregroundPid}, fgTid={foregroundThreadId}.");
    }

    private void LogReleaseAll()
    {
        var foreground = NativeMethods.GetForegroundWindow();
        NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        ClientDiagnostics.Log(
            $"Input release-all: held={_heldKeys.Count}, mappingStrategy={_mappingStrategy}, thread={Environment.CurrentManagedThreadId}, " +
            $"fgHwnd=0x{foreground.ToInt64():X}, fgPid={foregroundPid}.");
    }

    private static KeyboardStrokeMapping ResolveStroke(char character, KeyboardMappingStrategy mappingStrategy)
    {
        short encoded;
        IntPtr keyboardLayout;
        uint keyboardThreadId;

        if (mappingStrategy == KeyboardMappingStrategy.PowerShellOracle)
        {
            keyboardThreadId = 0;
            keyboardLayout = NativeMethods.GetKeyboardLayout(0);
            encoded = NativeMethods.VkKeyScanW(character);
        }
        else
        {
            var foreground = NativeMethods.GetForegroundWindow();
            keyboardThreadId = foreground == IntPtr.Zero
                ? 0u
                : NativeMethods.GetWindowThreadProcessId(foreground, out _);
            keyboardLayout = NativeMethods.GetKeyboardLayout(keyboardThreadId);
            if (keyboardLayout == IntPtr.Zero)
            {
                keyboardThreadId = 0;
                keyboardLayout = NativeMethods.GetKeyboardLayout(0);
            }

            encoded = keyboardLayout == IntPtr.Zero
                ? NativeMethods.VkKeyScanW(character)
                : NativeMethods.VkKeyScanExW(character, keyboardLayout);
        }

        if (encoded == -1)
        {
            var source = mappingStrategy == KeyboardMappingStrategy.PowerShellOracle
                ? "PowerShell-oracle Windows keyboard layout"
                : "foreground Windows keyboard layout";
            throw new WindowsInputInjectionException(
                $"Character U+{(int)character:X4} ('{character}') cannot be mapped by the {source}.");
        }

        var virtualKey = (ushort)(encoded & 0x00ff);
        var modifiers = (byte)((encoded >> 8) & 0x00ff);
        if ((modifiers & ~(ShiftModifier | ControlModifier | AltModifier)) != 0)
        {
            throw new WindowsInputInjectionException($"Unsupported keyboard modifier state 0x{modifiers:X2} for '{character}'.");
        }

        return new KeyboardStrokeMapping(virtualKey, modifiers, keyboardLayout, keyboardThreadId);
    }

    private static void WaitForMinimumPhysicalHold(long pressedAt)
    {
        var elapsed = Stopwatch.GetElapsedTime(pressedAt);
        var remaining = RemainingMinimumPhysicalHold(elapsed);
        if (remaining > TimeSpan.Zero)
        {
            Thread.Sleep(remaining);
        }
    }

    private static void PressModifiers(byte modifiers)
    {
        if ((modifiers & ShiftModifier) != 0)
        {
            SendVirtualKey(VirtualKeyShift, keyUp: false);
        }

        if ((modifiers & ControlModifier) != 0)
        {
            SendVirtualKey(VirtualKeyControl, keyUp: false);
        }

        if ((modifiers & AltModifier) != 0)
        {
            SendVirtualKey(VirtualKeyMenu, keyUp: false);
        }
    }

    private static void ReleaseModifiers(byte modifiers)
    {
        if ((modifiers & AltModifier) != 0)
        {
            TrySendKeyUp(VirtualKeyMenu);
        }

        if ((modifiers & ControlModifier) != 0)
        {
            TrySendKeyUp(VirtualKeyControl);
        }

        if ((modifiers & ShiftModifier) != 0)
        {
            TrySendKeyUp(VirtualKeyShift);
        }
    }

    private static void TrySendKeyUp(ushort virtualKey)
    {
        try
        {
            SendVirtualKey(virtualKey, keyUp: true);
        }
        catch (WindowsInputInjectionException)
        {
            // Best-effort safety release. Preserve the original input failure for diagnostics.
        }
    }

    private static void SendVirtualKey(ushort virtualKey, bool keyUp)
    {
        var keyEvent = BuildFieldBaselineKeyEvent(virtualKey, keyUp);
        NativeMethods.KeybdEvent(
            keyEvent.VirtualKey,
            scanCode: 0,
            keyEvent.Flags,
            UIntPtr.Zero);
    }

    internal static FieldBaselineKeyEvent BuildFieldBaselineKeyEvent(ushort virtualKey, bool keyUp)
    {
        if (virtualKey > byte.MaxValue)
        {
            throw new WindowsInputInjectionException(
                $"Virtual key 0x{virtualKey:X4} cannot be emitted by the field-proven keybd_event backend.");
        }

        return new FieldBaselineKeyEvent(
            checked((byte)virtualKey),
            keyUp ? NativeMethods.KeyEventKeyUp : 0u);
    }

    internal readonly record struct FieldBaselineKeyEvent(byte VirtualKey, uint Flags);
}

internal static class NativeMethods
{
    internal const uint KeyEventKeyUp = 0x0002;

    [DllImport("user32.dll")]
    internal static extern IntPtr GetForegroundWindow();

    [DllImport("user32.dll")]
    internal static extern uint GetWindowThreadProcessId(IntPtr window, out uint processId);

    [DllImport("user32.dll")]
    internal static extern IntPtr GetKeyboardLayout(uint idThread);

    [DllImport("user32.dll", CharSet = CharSet.Unicode)]
    internal static extern short VkKeyScanW(char character);

    [DllImport("user32.dll", CharSet = CharSet.Unicode)]
    internal static extern short VkKeyScanExW(char character, IntPtr keyboardLayout);

    [DllImport("user32.dll", EntryPoint = "keybd_event")]
    internal static extern void KeybdEvent(byte virtualKey, byte scanCode, uint flags, UIntPtr extraInfo);

    [DllImport("user32.dll")]
    internal static extern short GetAsyncKeyState(int virtualKey);
}
