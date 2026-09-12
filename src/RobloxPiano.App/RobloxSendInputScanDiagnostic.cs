using System.Diagnostics;
using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal readonly record struct SendInputScanDiagnosticEvent(
    ushort VirtualKey,
    ushort ScanCode,
    uint Flags);

internal sealed record RobloxSendInputScanProbeResult(
    string ProbeId,
    bool ActivationConfirmed,
    bool StableForegroundConfirmed,
    WindowsInputDesktopParity DesktopParity,
    bool WindowsReportedKeyDown,
    bool ForegroundHeldDuringProbe,
    ushort VirtualKey,
    ushort ScanCode,
    TimeSpan HoldDuration)
{
    public bool NativeDeliveryObserved => ActivationConfirmed
        && StableForegroundConfirmed
        && DesktopParity != WindowsInputDesktopParity.Different
        && WindowsReportedKeyDown
        && ForegroundHeldDuringProbe;
}

/// <summary>
/// Diagnostic-only SendInput scan-code experiment. This intentionally cannot authorize
/// normal playback; it exists to isolate an injection-API semantic difference after the
/// PowerShell-oracle and keybd_event physical-scan probes have failed in field testing.
/// </summary>
internal static class RobloxSendInputScanDiagnosticProbe
{
    private const uint MapVirtualKeyVkToVscEx = 4;
    internal const uint KeyEventFExtendedKey = 0x0001;
    internal const uint KeyEventFKeyUp = 0x0002;
    internal const uint KeyEventFScanCode = 0x0008;
    private const uint InputKeyboard = 1;

    internal static int NativeInputSize => Marshal.SizeOf<Input>();
    internal static int ExpectedNativeInputSize => IntPtr.Size == 8 ? 40 : 28;

    public static async Task<RobloxSendInputScanProbeResult> RunAsync(
        RobloxWindowTarget target,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(target);
        cancellationToken.ThrowIfCancellationRequested();

        var probeId = RobloxInputForensics.NewProbeId();
        RobloxInputForensics.LogEnvironment(probeId, target, RobloxFieldInputPolicy.ProbeKey);

        var activated = target.TryActivate();
        if (!activated)
        {
            var failed = new RobloxSendInputScanProbeResult(
                probeId, false, false, WindowsInputDesktopParity.Unknown, false, false, 0, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        var stable = await WaitForStableForegroundAsync(target, cancellationToken).ConfigureAwait(false);
        if (!stable)
        {
            var failed = new RobloxSendInputScanProbeResult(
                probeId, true, false, WindowsInputDesktopParity.Unknown, false, false, 0, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        var desktop = WindowsInputDesktop.Capture();
        RobloxInputForensics.LogDesktopSnapshot(probeId, "SENDINPUT_PRE_INJECTION", desktop, target);
        if (desktop.IsKnownMismatch)
        {
            var failed = new RobloxSendInputScanProbeResult(
                probeId, true, true, desktop.Parity, false, target.IsForeground, 0, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        if (NativeInputSize != ExpectedNativeInputSize)
        {
            throw new WindowsInputInjectionException(
                $"SendInput ABI mismatch: managed INPUT size={NativeInputSize}, expected={ExpectedNativeInputSize} for pointer size {IntPtr.Size}.");
        }

        var oracle = WindowsKeyboardInputSink.ResolvePowerShellOracleStrokeForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        if (oracle.Modifiers != 0)
        {
            throw new WindowsInputInjectionException(
                "The SendInput scan-code diagnostic only supports an unmodified probe key.");
        }

        var mappedScanCode = MapVirtualKeyExW(oracle.VirtualKey, MapVirtualKeyVkToVscEx, oracle.KeyboardLayout);
        var scanCode = NormalizeScanCode(mappedScanCode, out var extended);
        var downEvent = BuildEvent(oracle.VirtualKey, scanCode, extended, keyUp: false);
        var upEvent = BuildEvent(oracle.VirtualKey, scanCode, extended, keyUp: true);

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=SENDINPUT_MAPPING backend=SendInput " +
            $"vk=0x{oracle.VirtualKey:X2} scanCode=0x{scanCode:X2} extended={extended} layout=0x{oracle.KeyboardLayout.ToInt64():X} " +
            $"inputSize={NativeInputSize} semantics=DIAGNOSTIC_SCANCODE_ONLY productionChanged=false.");

        var continuity = new RobloxProbeFocusContinuity();
        using var eventContinuity = new RobloxSyntheticProbeForegroundContinuity(target, probeId, "SendInputScanCodeDiagnostic");
        eventContinuity.Start();
        var started = Stopwatch.GetTimestamp();
        try
        {
            LogKeyState(probeId, "SENDINPUT_BEFORE_DOWN", target, oracle.VirtualKey, scanCode);
            eventContinuity.BeginHold();
            Emit(downEvent);

            var sampleIndex = 0;
            while (true)
            {
                cancellationToken.ThrowIfCancellationRequested();
                var elapsed = Stopwatch.GetElapsedTime(started);
                var foregroundNow = target.IsForeground;
                var keyDownNow = WindowsKeyboardInputSink.IsVirtualKeyDown(oracle.VirtualKey);
                var held = continuity.Observe(foregroundNow, keyDownNow, elapsed);
                var eventHeld = eventContinuity.ObservePollingFallback();
                LogKeyState(
                    probeId,
                    $"SENDINPUT_HOLD_SAMPLE_{sampleIndex:000}",
                    target,
                    oracle.VirtualKey,
                    scanCode,
                    elapsed);

                if (!held || !eventHeld)
                {
                    ClientDiagnostics.Log(
                        $"INPUT_FORENSIC probe={probeId} stage=SENDINPUT_FOCUS_LOST_DURING_HOLD verdict=FOCUS_LOST_BEFORE_UP " +
                        $"firstLossMs={(eventContinuity.FirstContinuityLossAt ?? continuity.FirstFocusLossAt)?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na"} " +
                        $"source={eventContinuity.FirstContinuityLossSource ?? "POLL"} samples={continuity.SamplesObserved} " +
                        "foregroundEvents=true action=RELEASE_IMMEDIATELY productionChanged=false.");
                    break;
                }

                if (elapsed >= RobloxFieldInputPolicy.ProbeHoldDuration)
                {
                    break;
                }

                var remaining = RobloxFieldInputPolicy.ProbeHoldDuration - elapsed;
                var delay = remaining < RobloxFieldInputPolicy.ProbeContinuitySampleInterval
                    ? remaining
                    : RobloxFieldInputPolicy.ProbeContinuitySampleInterval;
                if (delay > TimeSpan.Zero
                    && !await eventContinuity.WaitForDelayOrLossAsync(delay, cancellationToken).ConfigureAwait(false))
                {
                    continue;
                }

                sampleIndex++;
            }

            LogKeyState(probeId, "SENDINPUT_BEFORE_UP", target, oracle.VirtualKey, scanCode, Stopwatch.GetElapsedTime(started));
            Emit(upEvent);
            eventContinuity.EndHold();
            var heldDuration = Stopwatch.GetElapsedTime(started);
            LogKeyState(probeId, "SENDINPUT_AFTER_UP", target, oracle.VirtualKey, scanCode, heldDuration);

            var result = new RobloxSendInputScanProbeResult(
                probeId,
                true,
                true,
                desktop.Parity,
                continuity.WindowsKeyDownObserved,
                continuity.ForegroundHeldContinuously && eventContinuity.ContinuityPreserved,
                oracle.VirtualKey,
                scanCode,
                heldDuration);
            LogVerdict(result, null);
            return result;
        }
        finally
        {
            eventContinuity.EndHold();
            try
            {
                Emit(upEvent);
            }
            catch (WindowsInputInjectionException)
            {
                // Best-effort release for a diagnostic path. Preserve the original failure.
            }
        }
    }

    internal static ushort NormalizeScanCode(uint mappedScanCode, out bool extended)
    {
        if (mappedScanCode == 0)
        {
            throw new WindowsInputInjectionException(
                "Windows could not resolve a physical scan code for the SendInput diagnostic.");
        }

        extended = (mappedScanCode & 0xFF00u) is 0xE000u or 0xE100u;
        var normalized = mappedScanCode & 0xFFu;
        if (normalized == 0)
        {
            throw new WindowsInputInjectionException(
                $"Windows returned unsupported scan-code value 0x{mappedScanCode:X}.");
        }

        return checked((ushort)normalized);
    }

    internal static SendInputScanDiagnosticEvent BuildEvent(
        ushort virtualKey,
        ushort scanCode,
        bool extended,
        bool keyUp)
    {
        if (virtualKey == 0)
        {
            throw new WindowsInputInjectionException("The SendInput diagnostic requires a non-zero reference virtual key.");
        }

        if (scanCode == 0)
        {
            throw new WindowsInputInjectionException(
                "The SendInput scan-code diagnostic must use a non-zero scan code.");
        }

        var flags = KeyEventFScanCode;
        if (extended)
        {
            flags |= KeyEventFExtendedKey;
        }

        if (keyUp)
        {
            flags |= KeyEventFKeyUp;
        }

        return new SendInputScanDiagnosticEvent(virtualKey, scanCode, flags);
    }

    internal static void LogHumanVerdict(RobloxSendInputScanProbeResult result, bool reacted)
        => LogVerdict(result, reacted);

    private static void Emit(SendInputScanDiagnosticEvent keyEvent)
    {
        var input = new Input
        {
            Type = InputKeyboard,
            Data = new InputUnion
            {
                Keyboard = new KeyboardInput
                {
                    VirtualKey = 0,
                    ScanCode = keyEvent.ScanCode,
                    Flags = keyEvent.Flags,
                    Time = 0,
                    ExtraInfo = UIntPtr.Zero
                }
            }
        };

        var inserted = SendInput(1, [input], NativeInputSize);
        if (inserted != 1)
        {
            var error = Marshal.GetLastWin32Error();
            throw new WindowsInputInjectionException(
                $"SendInput inserted {inserted}/1 keyboard events (Win32={error}). A privilege/integrity boundary may have blocked injection.");
        }
    }

    private static void LogKeyState(
        string probeId,
        string stage,
        RobloxWindowTarget target,
        ushort virtualKey,
        ushort scanCode,
        TimeSpan? elapsed = null)
    {
        var foreground = NativeMethods.GetForegroundWindow();
        var foregroundThreadId = NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        var down = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage={stage} backend=SendInput probePath=SendInputScanCodeDiagnostic " +
            $"vk=0x{virtualKey:X2} scanCode=0x{scanCode:X2} keyState={(down ? "DOWN" : "UP")} " +
            $"targetForeground={target.IsForeground} targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} foregroundTid={foregroundThreadId} " +
            $"elapsedMs={(elapsed?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na")}.");
    }

    private static void LogVerdict(RobloxSendInputScanProbeResult result, bool? reacted)
    {
        var native = result.NativeDeliveryObserved ? "OBSERVED" : "NOT_CONFIRMED";
        var reaction = reacted is null ? "UNKNOWN" : reacted.Value ? "YES" : "NO";
        var verdict = reacted switch
        {
            true => "SENDINPUT_SCAN_REACTED_PRODUCTION_UNCHANGED",
            false => "SENDINPUT_SCAN_NO_REACTION",
            null when result.NativeDeliveryObserved => "SENDINPUT_SCAN_AWAITING_OBSERVATION",
            _ => "SENDINPUT_SCAN_NATIVE_BOUNDARY_NOT_CONFIRMED"
        };
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={result.ProbeId} stage=SENDINPUT_VERDICT verdict={verdict} " +
            $"windowsPath={native} robloxReaction={reaction} vk=0x{result.VirtualKey:X2} scanCode=0x{result.ScanCode:X2} " +
            $"continuousFocus={result.ForegroundHeldDuringProbe} foregroundEvents=true productionChanged=false success=false.");
    }

    private static async Task<bool> WaitForStableForegroundAsync(
        RobloxWindowTarget target,
        CancellationToken cancellationToken)
    {
        var timeoutStarted = Stopwatch.GetTimestamp();
        long? stableSince = null;

        while (Stopwatch.GetElapsedTime(timeoutStarted) < RobloxFieldInputPolicy.ProbeFocusTimeout)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var identity = WindowsRobloxWindowIdentity.Capture(target);
            if (target.IsForeground && identity.IsTrustedProbeSurface)
            {
                stableSince ??= Stopwatch.GetTimestamp();
                if (Stopwatch.GetElapsedTime(stableSince.Value) >= RobloxFieldInputPolicy.StableFocusDuration)
                {
                    return true;
                }
            }
            else
            {
                stableSince = null;
            }

            await Task.Delay(25, cancellationToken).ConfigureAwait(false);
        }

        return false;
    }

    [StructLayout(LayoutKind.Sequential)]
    private struct Input
    {
        public uint Type;
        public InputUnion Data;
    }

    [StructLayout(LayoutKind.Explicit)]
    private struct InputUnion
    {
        [FieldOffset(0)]
        public MouseInput Mouse;

        [FieldOffset(0)]
        public KeyboardInput Keyboard;
    }

    [StructLayout(LayoutKind.Sequential)]
    private struct MouseInput
    {
        public int Dx;
        public int Dy;
        public uint MouseData;
        public uint Flags;
        public uint Time;
        public UIntPtr ExtraInfo;
    }

    [StructLayout(LayoutKind.Sequential)]
    private struct KeyboardInput
    {
        public ushort VirtualKey;
        public ushort ScanCode;
        public uint Flags;
        public uint Time;
        public UIntPtr ExtraInfo;
    }

    [DllImport("user32.dll", CharSet = CharSet.Unicode)]
    private static extern uint MapVirtualKeyExW(uint code, uint mapType, IntPtr keyboardLayout);

    [DllImport("user32.dll", SetLastError = true)]
    private static extern uint SendInput(uint inputCount, Input[] inputs, int inputSize);
}
