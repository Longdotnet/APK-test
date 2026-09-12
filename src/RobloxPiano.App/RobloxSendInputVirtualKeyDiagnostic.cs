using System.Diagnostics;
using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal readonly record struct SendInputVirtualKeyDiagnosticEvent(
    ushort VirtualKey,
    ushort ScanCode,
    uint Flags);

internal sealed record RobloxSendInputVirtualKeyProbeResult(
    string ProbeId,
    bool ActivationConfirmed,
    bool StableForegroundConfirmed,
    WindowsInputDesktopParity DesktopParity,
    bool WindowsReportedKeyDown,
    bool ForegroundHeldDuringProbe,
    ushort VirtualKey,
    TimeSpan HoldDuration)
{
    public WindowsLowLevelKeyboardProvenanceSnapshot? LowLevelProvenance { get; init; }

    public bool NativeDeliveryObserved => ActivationConfirmed
        && StableForegroundConfirmed
        && DesktopParity != WindowsInputDesktopParity.Different
        && WindowsReportedKeyDown
        && ForegroundHeldDuringProbe;
}

/// <summary>
/// Diagnostic-only SendInput virtual-key experiment. It fills the remaining A/B matrix cell:
/// the PowerShell oracle's virtual-key semantics emitted through SendInput rather than keybd_event.
/// This path can never authorize or mutate normal playback.
/// </summary>
internal static class RobloxSendInputVirtualKeyDiagnosticProbe
{
    internal const uint KeyEventFKeyUp = 0x0002;
    private const uint InputKeyboard = 1;

    internal static int NativeInputSize => Marshal.SizeOf<Input>();
    internal static int ExpectedNativeInputSize => IntPtr.Size == 8 ? 40 : 28;

    public static async Task<RobloxSendInputVirtualKeyProbeResult> RunAsync(
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
            var failed = new RobloxSendInputVirtualKeyProbeResult(
                probeId, false, false, WindowsInputDesktopParity.Unknown, false, false, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        var stable = await WaitForStableForegroundAsync(target, cancellationToken).ConfigureAwait(false);
        if (!stable)
        {
            var failed = new RobloxSendInputVirtualKeyProbeResult(
                probeId, true, false, WindowsInputDesktopParity.Unknown, false, false, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        var desktop = WindowsInputDesktop.Capture();
        RobloxInputForensics.LogDesktopSnapshot(probeId, "SENDINPUT_VK_PRE_INJECTION", desktop, target);
        if (desktop.IsKnownMismatch)
        {
            var failed = new RobloxSendInputVirtualKeyProbeResult(
                probeId, true, true, desktop.Parity, false, target.IsForeground, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        if (NativeInputSize != ExpectedNativeInputSize)
        {
            throw new WindowsInputInjectionException(
                $"SendInput ABI mismatch: managed INPUT size={NativeInputSize}, expected={ExpectedNativeInputSize} for pointer size {IntPtr.Size}.");
        }

        var oracle = WindowsKeyboardInputSink.ResolvePowerShellOracleStrokeForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        if (oracle.VirtualKey == 0 || oracle.Modifiers != 0)
        {
            throw new WindowsInputInjectionException(
                "The SendInput virtual-key diagnostic requires one unmodified non-zero virtual key.");
        }

        var downEvent = BuildEvent(oracle.VirtualKey, keyUp: false);
        var upEvent = BuildEvent(oracle.VirtualKey, keyUp: true);

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=SENDINPUT_VK_MAPPING backend=SendInput " +
            $"vk=0x{oracle.VirtualKey:X2} scanCode=0x0000 flags=0x{downEvent.Flags:X} layout=0x{oracle.KeyboardLayout.ToInt64():X} " +
            $"inputSize={NativeInputSize} semantics=DIAGNOSTIC_VIRTUAL_KEY productionChanged=false.");

        var continuity = new RobloxProbeFocusContinuity();
        using var eventContinuity = new RobloxSyntheticProbeForegroundContinuity(target, probeId, "SendInputVirtualKeyDiagnostic");
        eventContinuity.Start();
        using var lowLevelProvenance = new WindowsLowLevelKeyboardProvenance(probeId, "SendInputVirtualKeyDiagnostic", oracle.VirtualKey);
        lowLevelProvenance.Start();
        var lowLevelObservationEnded = false;
        var downEmitted = false;
        var started = Stopwatch.GetTimestamp();
        try
        {
            LogKeyState(probeId, "SENDINPUT_VK_BEFORE_DOWN", target, oracle.VirtualKey);
            eventContinuity.BeginHold();
            lowLevelProvenance.BeginObservation();
            Emit(downEvent);
            downEmitted = true;

            var sampleIndex = 0;
            while (true)
            {
                cancellationToken.ThrowIfCancellationRequested();
                var elapsed = Stopwatch.GetElapsedTime(started);
                var foregroundNow = target.IsForeground;
                var keyDownNow = WindowsKeyboardInputSink.IsVirtualKeyDown(oracle.VirtualKey);
                var held = continuity.Observe(foregroundNow, keyDownNow, elapsed);
                var eventHeld = eventContinuity.ObservePollingFallback();
                LogKeyState(probeId, $"SENDINPUT_VK_HOLD_SAMPLE_{sampleIndex:000}", target, oracle.VirtualKey, elapsed);

                if (!held || !eventHeld)
                {
                    ClientDiagnostics.Log(
                        $"INPUT_FORENSIC probe={probeId} stage=SENDINPUT_VK_FOCUS_LOST_DURING_HOLD verdict=FOCUS_LOST_BEFORE_UP " +
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

            LogKeyState(probeId, "SENDINPUT_VK_BEFORE_UP", target, oracle.VirtualKey, Stopwatch.GetElapsedTime(started));
            Emit(upEvent);
            eventContinuity.EndHold();
            var heldDuration = Stopwatch.GetElapsedTime(started);
            LogKeyState(probeId, "SENDINPUT_VK_AFTER_UP", target, oracle.VirtualKey, heldDuration);
            var lowLevelSnapshot = lowLevelProvenance.EndObservation();
            lowLevelObservationEnded = true;

            var result = new RobloxSendInputVirtualKeyProbeResult(
                probeId,
                true,
                true,
                desktop.Parity,
                continuity.WindowsKeyDownObserved,
                continuity.ForegroundHeldContinuously && eventContinuity.ContinuityPreserved,
                oracle.VirtualKey,
                heldDuration)
            {
                LowLevelProvenance = lowLevelSnapshot
            };
            LogVerdict(result, null);
            return result;
        }
        finally
        {
            eventContinuity.EndHold();
            if (ShouldEmitBestEffortRelease(downEmitted))
            {
                try
                {
                    Emit(upEvent);
                }
                catch (WindowsInputInjectionException)
                {
                    // Best-effort release. Preserve the original diagnostic failure.
                }
            }
            else
            {
                ClientDiagnostics.Log(
                    $"INPUT_FORENSIC probe={probeId} stage=SENDINPUT_VK_RELEASE_SKIPPED backend=SendInput " +
                    "probePath=SendInputVirtualKeyDiagnostic keyDownEmitted=false nativeEventsAfterAbort=0 " +
                    "verdict=ABORT_BEFORE_DOWN authorizesPlayback=false productionChanged=false.");
            }

            if (!lowLevelObservationEnded)
            {
                _ = lowLevelProvenance.EndObservation();
            }
        }
    }

    internal static bool ShouldEmitBestEffortRelease(bool keyDownEmitted)
        => keyDownEmitted;

    internal static SendInputVirtualKeyDiagnosticEvent BuildEvent(ushort virtualKey, bool keyUp)
    {
        if (virtualKey == 0)
        {
            throw new WindowsInputInjectionException("The SendInput virtual-key diagnostic requires a non-zero virtual key.");
        }

        return new SendInputVirtualKeyDiagnosticEvent(
            virtualKey,
            0,
            keyUp ? KeyEventFKeyUp : 0);
    }

    internal static void LogHumanVerdict(RobloxSendInputVirtualKeyProbeResult result, bool reacted)
        => LogVerdict(result, reacted);

    private static void Emit(SendInputVirtualKeyDiagnosticEvent keyEvent)
    {
        var input = new Input
        {
            Type = InputKeyboard,
            Data = new InputUnion
            {
                Keyboard = new KeyboardInput
                {
                    VirtualKey = keyEvent.VirtualKey,
                    ScanCode = 0,
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
                $"SendInput virtual-key diagnostic inserted {inserted}/1 keyboard events (Win32={error}). A privilege/integrity boundary may have blocked injection.");
        }
    }

    private static void LogKeyState(
        string probeId,
        string stage,
        RobloxWindowTarget target,
        ushort virtualKey,
        TimeSpan? elapsed = null)
    {
        var foreground = NativeMethods.GetForegroundWindow();
        var foregroundThreadId = NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        var down = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage={stage} backend=SendInput probePath=SendInputVirtualKeyDiagnostic " +
            $"vk=0x{virtualKey:X2} scanCode=0x0000 flagsSemantic=VIRTUAL_KEY keyState={(down ? "DOWN" : "UP")} " +
            $"targetForeground={target.IsForeground} targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} foregroundTid={foregroundThreadId} " +
            $"elapsedMs={(elapsed?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na")}.");
    }

    private static void LogVerdict(RobloxSendInputVirtualKeyProbeResult result, bool? reacted)
    {
        var native = result.NativeDeliveryObserved ? "OBSERVED" : "NOT_CONFIRMED";
        var reaction = reacted is null ? "UNKNOWN" : reacted.Value ? "YES" : "NO";
        var verdict = reacted switch
        {
            true => "SENDINPUT_VK_REACTED_PRODUCTION_UNCHANGED",
            false => "SENDINPUT_VK_NO_REACTION",
            null when result.NativeDeliveryObserved => "SENDINPUT_VK_AWAITING_OBSERVATION",
            _ => "SENDINPUT_VK_NATIVE_BOUNDARY_NOT_CONFIRMED"
        };
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={result.ProbeId} stage=SENDINPUT_VK_VERDICT verdict={verdict} " +
            $"windowsPath={native} robloxReaction={reaction} vk=0x{result.VirtualKey:X2} scanCode=0x0000 " +
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
        [FieldOffset(0)] public MouseInput Mouse;
        [FieldOffset(0)] public KeyboardInput Keyboard;
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

    [DllImport("user32.dll", SetLastError = true)]
    private static extern uint SendInput(uint inputCount, Input[] inputs, int inputSize);
}
