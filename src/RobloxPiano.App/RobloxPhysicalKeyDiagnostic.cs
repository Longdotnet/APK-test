using System.Diagnostics;
using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal readonly record struct PhysicalKeyDiagnosticEvent(
    byte VirtualKey,
    byte ScanCode,
    uint Flags);

internal sealed record RobloxPhysicalKeyProbeResult(
    string ProbeId,
    bool ActivationConfirmed,
    bool StableForegroundConfirmed,
    WindowsInputDesktopParity DesktopParity,
    bool WindowsReportedKeyDown,
    bool ForegroundHeldDuringProbe,
    ushort VirtualKey,
    byte ScanCode,
    TimeSpan HoldDuration)
{
    public bool NativeDeliveryObserved => ActivationConfirmed
        && StableForegroundConfirmed
        && DesktopParity != WindowsInputDesktopParity.Different
        && WindowsReportedKeyDown
        && ForegroundHeldDuringProbe;
}

/// <summary>
/// Diagnostic-only physical-key experiment. Normal playback intentionally remains on the
/// field-proven virtual-key keybd_event path until real Roblox evidence justifies any change.
/// </summary>
internal static class RobloxPhysicalKeyDiagnosticProbe
{
    private const uint MapVirtualKeyVkToVscEx = 4;

    public static async Task<RobloxPhysicalKeyProbeResult> RunAsync(
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
            var failed = new RobloxPhysicalKeyProbeResult(
                probeId, false, false, WindowsInputDesktopParity.Unknown, false, false, 0, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        var stable = await WaitForStableForegroundAsync(target, cancellationToken).ConfigureAwait(false);
        if (!stable)
        {
            var failed = new RobloxPhysicalKeyProbeResult(
                probeId, true, false, WindowsInputDesktopParity.Unknown, false, false, 0, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        var desktop = WindowsInputDesktop.Capture();
        RobloxInputForensics.LogDesktopSnapshot(probeId, "PHYSICAL_PRE_INJECTION", desktop, target);
        if (desktop.IsKnownMismatch)
        {
            var failed = new RobloxPhysicalKeyProbeResult(
                probeId, true, true, desktop.Parity, false, target.IsForeground, 0, 0, TimeSpan.Zero);
            LogVerdict(failed, null);
            return failed;
        }

        var oracle = WindowsKeyboardInputSink.ResolvePowerShellOracleStrokeForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        if (oracle.Modifiers != 0)
        {
            throw new WindowsInputInjectionException(
                "The diagnostic physical-key probe only supports an unmodified probe key.");
        }

        var scanCodeValue = MapVirtualKeyExW(oracle.VirtualKey, MapVirtualKeyVkToVscEx, oracle.KeyboardLayout);
        if (scanCodeValue == 0 || scanCodeValue > byte.MaxValue)
        {
            throw new WindowsInputInjectionException(
                $"Windows could not resolve a one-byte physical scan code for VK 0x{oracle.VirtualKey:X2}.");
        }

        var scanCode = checked((byte)scanCodeValue);
        var downEvent = BuildEvent(oracle.VirtualKey, scanCode, keyUp: false);
        var upEvent = BuildEvent(oracle.VirtualKey, scanCode, keyUp: true);
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=PHYSICAL_MAPPING backend=keybd_event " +
            $"vk=0x{oracle.VirtualKey:X2} scanCode=0x{scanCode:X2} layout=0x{oracle.KeyboardLayout.ToInt64():X} " +
            "semantics=DIAGNOSTIC_NONZERO_SCAN productionChanged=false.");

        var continuity = new RobloxProbeFocusContinuity();
        using var eventContinuity = new RobloxSyntheticProbeForegroundContinuity(target, probeId, "KeybdEventScanDiagnostic");
        eventContinuity.Start();
        var started = Stopwatch.GetTimestamp();
        try
        {
            LogKeyState(probeId, "PHYSICAL_BEFORE_DOWN", target, oracle.VirtualKey, scanCode);
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
                    $"PHYSICAL_HOLD_SAMPLE_{sampleIndex:000}",
                    target,
                    oracle.VirtualKey,
                    scanCode,
                    elapsed);

                if (!held || !eventHeld)
                {
                    ClientDiagnostics.Log(
                        $"INPUT_FORENSIC probe={probeId} stage=PHYSICAL_FOCUS_LOST_DURING_HOLD verdict=FOCUS_LOST_BEFORE_UP " +
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

            LogKeyState(probeId, "PHYSICAL_BEFORE_UP", target, oracle.VirtualKey, scanCode, Stopwatch.GetElapsedTime(started));
            Emit(upEvent);
            eventContinuity.EndHold();
            var heldDuration = Stopwatch.GetElapsedTime(started);
            LogKeyState(probeId, "PHYSICAL_AFTER_UP", target, oracle.VirtualKey, scanCode, heldDuration);

            var result = new RobloxPhysicalKeyProbeResult(
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

    internal static PhysicalKeyDiagnosticEvent BuildEvent(ushort virtualKey, byte scanCode, bool keyUp)
    {
        if (virtualKey > byte.MaxValue)
        {
            throw new WindowsInputInjectionException(
                $"Virtual key 0x{virtualKey:X4} cannot be emitted by keybd_event.");
        }

        if (scanCode == 0)
        {
            throw new WindowsInputInjectionException(
                "The physical-key diagnostic must use a non-zero scan code; scan code 0 is the existing PowerShell oracle path.");
        }

        return new PhysicalKeyDiagnosticEvent(
            checked((byte)virtualKey),
            scanCode,
            keyUp ? NativeMethods.KeyEventKeyUp : 0u);
    }

    internal static void LogHumanVerdict(RobloxPhysicalKeyProbeResult result, bool reacted)
        => LogVerdict(result, reacted);

    private static void Emit(PhysicalKeyDiagnosticEvent keyEvent)
        => KeybdEvent(keyEvent.VirtualKey, keyEvent.ScanCode, keyEvent.Flags, UIntPtr.Zero);

    private static void LogKeyState(
        string probeId,
        string stage,
        RobloxWindowTarget target,
        ushort virtualKey,
        byte scanCode,
        TimeSpan? elapsed = null)
    {
        var foreground = NativeMethods.GetForegroundWindow();
        var foregroundThreadId = NativeMethods.GetWindowThreadProcessId(foreground, out var foregroundPid);
        var down = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage={stage} backend=keybd_event probePath=PhysicalScanCodeDiagnostic " +
            $"vk=0x{virtualKey:X2} scanCode=0x{scanCode:X2} keyState={(down ? "DOWN" : "UP")} " +
            $"targetForeground={target.IsForeground} targetPid={target.ProcessId} targetHwnd=0x{target.WindowHandle.ToInt64():X} " +
            $"foregroundPid={foregroundPid} foregroundHwnd=0x{foreground.ToInt64():X} foregroundTid={foregroundThreadId} " +
            $"elapsedMs={(elapsed?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na")}.");
    }

    private static void LogVerdict(RobloxPhysicalKeyProbeResult result, bool? reacted)
    {
        var native = result.NativeDeliveryObserved ? "OBSERVED" : "NOT_CONFIRMED";
        var reaction = reacted is null ? "UNKNOWN" : reacted.Value ? "YES" : "NO";
        var verdict = reacted switch
        {
            true => "PHYSICAL_SCAN_REACTED_PRODUCTION_UNCHANGED",
            false => "PHYSICAL_SCAN_NO_REACTION",
            null when result.NativeDeliveryObserved => "PHYSICAL_SCAN_AWAITING_OBSERVATION",
            _ => "PHYSICAL_SCAN_NATIVE_BOUNDARY_NOT_CONFIRMED"
        };
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={result.ProbeId} stage=PHYSICAL_VERDICT verdict={verdict} " +
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

    [DllImport("user32.dll", CharSet = CharSet.Unicode)]
    private static extern uint MapVirtualKeyExW(uint code, uint mapType, IntPtr keyboardLayout);

    [DllImport("user32.dll", EntryPoint = "keybd_event")]
    private static extern void KeybdEvent(byte virtualKey, byte scanCode, uint flags, UIntPtr extraInfo);
}
