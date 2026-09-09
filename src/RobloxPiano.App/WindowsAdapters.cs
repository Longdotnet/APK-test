using System.ComponentModel;
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

internal sealed class WindowsKeyboardInputSink : IInputSink
{
    private const byte ShiftModifier = 0x01;
    private const byte ControlModifier = 0x02;
    private const byte AltModifier = 0x04;

    private const ushort VirtualKeyShift = 0x10;
    private const ushort VirtualKeyControl = 0x11;
    private const ushort VirtualKeyMenu = 0x12;

    private readonly object _gate = new();
    private readonly HashSet<ushort> _heldKeys = new();

    public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        ArgumentNullException.ThrowIfNull(keys);

        var strokes = keys.Select(ResolveStroke).ToArray();
        lock (_gate)
        {
            foreach (var group in strokes.GroupBy(stroke => stroke.Modifiers).OrderBy(group => group.Key))
            {
                PressModifiers(group.Key);
                try
                {
                    foreach (var stroke in group)
                    {
                        SendVirtualKey(stroke.VirtualKey, keyUp: false);
                        _heldKeys.Add(stroke.VirtualKey);
                    }
                }
                finally
                {
                    ReleaseModifiers(group.Key);
                }
            }
        }

        return ValueTask.CompletedTask;
    }

    public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        ArgumentNullException.ThrowIfNull(keys);

        var strokes = keys.Select(ResolveStroke).Reverse().ToArray();
        lock (_gate)
        {
            foreach (var stroke in strokes)
            {
                if (_heldKeys.Remove(stroke.VirtualKey))
                {
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
            foreach (var virtualKey in _heldKeys.ToArray().Reverse())
            {
                TrySendKeyUp(virtualKey);
            }

            _heldKeys.Clear();
            TrySendKeyUp(VirtualKeyShift);
            TrySendKeyUp(VirtualKeyControl);
            TrySendKeyUp(VirtualKeyMenu);
        }

        return ValueTask.CompletedTask;
    }

    private static KeyStroke ResolveStroke(char character)
    {
        var encoded = NativeMethods.VkKeyScanW(character);
        if (encoded == -1)
        {
            throw new WindowsInputInjectionException(
                $"Character U+{(int)character:X4} ('{character}') cannot be mapped by the active Windows keyboard layout.");
        }

        var virtualKey = (ushort)(encoded & 0x00ff);
        var modifiers = (byte)((encoded >> 8) & 0x00ff);
        if ((modifiers & ~(ShiftModifier | ControlModifier | AltModifier)) != 0)
        {
            throw new WindowsInputInjectionException($"Unsupported keyboard modifier state 0x{modifiers:X2} for '{character}'.");
        }

        return new KeyStroke(virtualKey, modifiers);
    }

    private static void PressModifiers(byte modifiers)
    {
        if ((modifiers & ControlModifier) != 0)
        {
            SendVirtualKey(VirtualKeyControl, keyUp: false);
        }

        if ((modifiers & AltModifier) != 0)
        {
            SendVirtualKey(VirtualKeyMenu, keyUp: false);
        }

        if ((modifiers & ShiftModifier) != 0)
        {
            SendVirtualKey(VirtualKeyShift, keyUp: false);
        }
    }

    private static void ReleaseModifiers(byte modifiers)
    {
        if ((modifiers & ShiftModifier) != 0)
        {
            TrySendKeyUp(VirtualKeyShift);
        }

        if ((modifiers & AltModifier) != 0)
        {
            TrySendKeyUp(VirtualKeyMenu);
        }

        if ((modifiers & ControlModifier) != 0)
        {
            TrySendKeyUp(VirtualKeyControl);
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
            // Release-all is a best-effort safety path. The original failure remains more useful to the caller.
        }
    }

    private static void SendVirtualKey(ushort virtualKey, bool keyUp)
    {
        NativeMethods.ValidateInputAbi();

        var scanCode = (ushort)NativeMethods.MapVirtualKeyW(virtualKey, NativeMethods.MapVkToVsc);
        if (scanCode == 0)
        {
            throw new WindowsInputInjectionException($"Unable to resolve scan code for virtual key 0x{virtualKey:X2}.");
        }

        var input = new NativeMethods.Input
        {
            Type = NativeMethods.InputKeyboard,
            Union = new NativeMethods.InputUnion
            {
                Keyboard = new NativeMethods.KeyboardInput
                {
                    VirtualKey = 0,
                    ScanCode = scanCode,
                    Flags = NativeMethods.KeyEventScanCode | (keyUp ? NativeMethods.KeyEventKeyUp : 0),
                    Time = 0,
                    ExtraInfo = UIntPtr.Zero
                }
            }
        };

        var size = NativeMethods.InputStructureSize;
        var sent = NativeMethods.SendInput(1, new[] { input }, size);
        if (sent == 1)
        {
            return;
        }

        var errorCode = Marshal.GetLastWin32Error();
        var nativeMessage = errorCode == 0
            ? "Windows returned no error code. This commonly occurs when UIPI blocks input across privilege levels."
            : new Win32Exception(errorCode).Message;
        var message =
            $"Windows keyboard input was rejected (SendInput=0, Win32={errorCode}, INPUT={size} bytes). " +
            $"{nativeMessage} Keep Roblox in the foreground and run Roblox and Roblox Piano at the same Windows privilege level.";

        ClientDiagnostics.Log(message);
        throw errorCode == 0
            ? new WindowsInputInjectionException(message)
            : new WindowsInputInjectionException(message, new Win32Exception(errorCode));
    }

    private readonly record struct KeyStroke(ushort VirtualKey, byte Modifiers);
}

internal static class NativeMethods
{
    internal const uint InputMouse = 0;
    internal const uint InputKeyboard = 1;
    internal const uint InputHardware = 2;
    internal const uint KeyEventKeyUp = 0x0002;
    internal const uint KeyEventScanCode = 0x0008;
    internal const uint MapVkToVsc = 0;

    internal static int InputStructureSize => Marshal.SizeOf<Input>();
    internal static int ExpectedInputStructureSize => IntPtr.Size == 8 ? 40 : 28;

    internal static void ValidateInputAbi()
    {
        var actual = InputStructureSize;
        var expected = ExpectedInputStructureSize;
        if (actual != expected)
        {
            throw new WindowsInputInjectionException(
                $"Windows INPUT ABI mismatch: managed size is {actual} bytes, expected {expected} bytes for a {IntPtr.Size * 8}-bit process.");
        }
    }

    [DllImport("user32.dll")]
    internal static extern IntPtr GetForegroundWindow();

    [DllImport("user32.dll")]
    internal static extern uint GetWindowThreadProcessId(IntPtr window, out uint processId);

    [DllImport("user32.dll", CharSet = CharSet.Unicode)]
    internal static extern short VkKeyScanW(char character);

    [DllImport("user32.dll")]
    internal static extern uint MapVirtualKeyW(uint code, uint mapType);

    [DllImport("user32.dll", SetLastError = true)]
    internal static extern uint SendInput(uint numberOfInputs, Input[] inputs, int sizeOfInputStructure);

    [StructLayout(LayoutKind.Sequential)]
    internal struct Input
    {
        internal uint Type;
        internal InputUnion Union;
    }

    [StructLayout(LayoutKind.Explicit)]
    internal struct InputUnion
    {
        [FieldOffset(0)]
        internal MouseInput Mouse;

        [FieldOffset(0)]
        internal KeyboardInput Keyboard;

        [FieldOffset(0)]
        internal HardwareInput Hardware;
    }

    [StructLayout(LayoutKind.Sequential)]
    internal struct MouseInput
    {
        internal int Dx;
        internal int Dy;
        internal uint MouseData;
        internal uint Flags;
        internal uint Time;
        internal UIntPtr ExtraInfo;
    }

    [StructLayout(LayoutKind.Sequential)]
    internal struct KeyboardInput
    {
        internal ushort VirtualKey;
        internal ushort ScanCode;
        internal uint Flags;
        internal uint Time;
        internal UIntPtr ExtraInfo;
    }

    [StructLayout(LayoutKind.Sequential)]
    internal struct HardwareInput
    {
        internal uint Message;
        internal ushort ParamL;
        internal ushort ParamH;
    }
}
