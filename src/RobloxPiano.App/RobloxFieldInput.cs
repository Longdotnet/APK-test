using System.Diagnostics;

namespace RobloxPiano.App;

internal static class RobloxFieldInputPolicy
{
    internal static readonly TimeSpan StableFocusDuration = TimeSpan.FromMilliseconds(750);
    internal static readonly TimeSpan ProbeHoldDuration = TimeSpan.FromMilliseconds(650);
    internal static readonly TimeSpan ProbeFocusTimeout = TimeSpan.FromSeconds(3);
    internal static readonly TimeSpan ProbeContinuitySampleInterval = TimeSpan.FromMilliseconds(25);
    internal const char ProbeKey = 'w';
}

internal enum RobloxInputCheckVerdict
{
    Confirmed = 0,
    RobloxDidNotReact = 1,
    ActivationFailed = 2,
    FocusUnstable = 3,
    WindowsKeyStateNotObserved = 4,
    FocusLostDuringProbe = 5,
    NativeDeliveryAwaitingObservation = 6,
    InputDesktopMismatch = 7,
    PowerShellOracleConfirmedProductionMappingDiffers = 8,
    WindowIdentityLostDuringProbe = 9
}

internal sealed record RobloxInputCheckAssessment(
    RobloxInputCheckVerdict Verdict,
    string Summary,
    string NextAction,
    bool IsSuccess);

internal sealed record RobloxFieldInputProbeResult(
    string ProbeId,
    bool ActivationConfirmed,
    bool StableForegroundConfirmed,
    WindowsInputDesktopParity DesktopParity,
    bool WindowsReportedKeyDown,
    bool ForegroundHeldDuringProbe,
    bool WindowIdentityHeldDuringProbe,
    ushort VirtualKey,
    TimeSpan HoldDuration)
{
    public bool ProductionMappingEquivalentToOracle { get; init; } = true;
    public WindowsLowLevelKeyboardProvenanceSnapshot? LowLevelProvenance { get; init; }

    internal RobloxFieldInputProbeResult(
        string probeId,
        bool activationConfirmed,
        bool stableForegroundConfirmed,
        WindowsInputDesktopParity desktopParity,
        bool windowsReportedKeyDown,
        bool foregroundHeldDuringProbe,
        ushort virtualKey,
        TimeSpan holdDuration)
        : this(
            probeId,
            activationConfirmed,
            stableForegroundConfirmed,
            desktopParity,
            windowsReportedKeyDown,
            foregroundHeldDuringProbe,
            foregroundHeldDuringProbe,
            virtualKey,
            holdDuration)
    {
    }

    internal RobloxFieldInputProbeResult(
        bool activationConfirmed,
        bool stableForegroundConfirmed,
        bool windowsReportedKeyDown,
        bool foregroundHeldDuringProbe,
        ushort virtualKey,
        TimeSpan holdDuration)
        : this(
            "synthetic",
            activationConfirmed,
            stableForegroundConfirmed,
            WindowsInputDesktopParity.Same,
            windowsReportedKeyDown,
            foregroundHeldDuringProbe,
            foregroundHeldDuringProbe,
            virtualKey,
            holdDuration)
    {
    }

    public bool NativeDeliveryObserved => ActivationConfirmed
        && StableForegroundConfirmed
        && DesktopParity != WindowsInputDesktopParity.Different
        && WindowsReportedKeyDown
        && ForegroundHeldDuringProbe
        && WindowIdentityHeldDuringProbe;

    public RobloxInputCheckAssessment Assess(bool? robloxReacted)
    {
        if (!ActivationConfirmed)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.ActivationFailed,
                "Roblox could not be activated for the input check.",
                "Bring the Roblox Player window to the foreground, make sure Roblox Piano is not running at a different administrator level, then retry.",
                false);
        }

        if (!StableForegroundConfirmed)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.FocusUnstable,
                "Roblox did not stay on the selected game window long enough to safely send the test key.",
                "Stop switching windows or overlays for a moment, keep the selected Roblox Player visible, then retry.",
                false);
        }

        if (DesktopParity == WindowsInputDesktopParity.Different)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.InputDesktopMismatch,
                "Roblox Piano is attached to a different Windows desktop than the active input desktop.",
                "Return to the normal interactive desktop (for example, leave a secure/alternate desktop), keep Roblox and Roblox Piano on the same Windows session desktop, then rerun Test Roblox Input.",
                false);
        }

        if (!WindowsReportedKeyDown)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.WindowsKeyStateNotObserved,
                "Windows did not report the synthetic W key as down.",
                "Retry once. If it repeats, open Diagnostics; the Windows input boundary is the blocker before Roblox consumption is considered.",
                false);
        }

        if (!ForegroundHeldDuringProbe)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.FocusLostDuringProbe,
                "Roblox lost foreground while the W test key was held.",
                "Keep Roblox focused for the entire check and retry. The probe releases W immediately when a focus loss is observed.",
                false);
        }

        if (!WindowIdentityHeldDuringProbe)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.WindowIdentityLostDuringProbe,
                "The foreground stayed in Roblox, but it moved away from the selected game window/root while W was held.",
                "Re-run Test Roblox Input so it binds to the current Roblox game window. Close or avoid same-process splash/alternate surfaces during the probe.",
                false);
        }

        if (robloxReacted is null)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.NativeDeliveryAwaitingObservation,
                "Windows delivered the exact PowerShell-oracle W test while the selected Roblox game surface remained stable.",
                "Confirm whether Roblox visibly moved or played the W-bound piano note; that observation separates Windows delivery from Roblox consumption.",
                false);
        }

        if (robloxReacted.Value && !ProductionMappingEquivalentToOracle)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.PowerShellOracleConfirmedProductionMappingDiffers,
                "Roblox reacted to the exact PowerShell-oracle input, but normal playback currently resolves that key differently.",
                "Keep playback gated for now. Diagnostics proves the mapping boundary differs; the production mapping must be reconciled with the field-proven oracle before normal song playback is trusted.",
                false);
        }

        if (robloxReacted.Value)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.Confirmed,
                "Roblox reacted to the exact PowerShell-oracle input path, and normal playback resolves the test key equivalently.",
                "Input acceptance is confirmed for this session. Select a Library song and press Play.",
                true);
        }

        return new RobloxInputCheckAssessment(
            RobloxInputCheckVerdict.RobloxDidNotReact,
            "Windows delivered the exact PowerShell-oracle W test, but Roblox did not visibly react.",
            "The scheduler and keyboard mapping are not the current suspects. Check Roblox/game keyboard capture, privilege/integrity mismatch, input-desktop parity, overlays or anti-input behavior; Diagnostics contains the exact native evidence.",
            false);
    }
}

internal static class RobloxFieldInputProbe
{
    public static async Task<RobloxFieldInputProbeResult> RunAsync(
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
            var result = new RobloxFieldInputProbeResult(probeId, false, false, WindowsInputDesktopParity.Unknown, false, false, false, 0, TimeSpan.Zero);
            RobloxInputForensics.LogVerdict(probeId, result.Assess(null), null);
            return result;
        }

        var stable = await WaitForStableForegroundAsync(target, cancellationToken).ConfigureAwait(false);
        if (!stable)
        {
            var result = new RobloxFieldInputProbeResult(probeId, true, false, WindowsInputDesktopParity.Unknown, false, false, false, 0, TimeSpan.Zero);
            RobloxInputForensics.LogVerdict(probeId, result.Assess(null), null);
            return result;
        }

        var desktop = WindowsInputDesktop.Capture();
        RobloxInputForensics.LogDesktopSnapshot(probeId, "PRE_INJECTION", desktop, target);
        if (desktop.IsKnownMismatch)
        {
            var trustedWindow = WindowsRobloxWindowIdentity.Capture(target).IsTrustedProbeSurface;
            var result = new RobloxFieldInputProbeResult(
                probeId,
                true,
                true,
                desktop.Parity,
                false,
                target.IsForeground,
                trustedWindow,
                0,
                TimeSpan.Zero);
            RobloxInputForensics.LogVerdict(probeId, result.Assess(null), null);
            return result;
        }

        var productionMapping = WindowsKeyboardInputSink.ResolveStrokeForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        var oracleMapping = WindowsKeyboardInputSink.ResolvePowerShellOracleStrokeForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        var mappingEquivalent = WindowsKeyboardInputSink.HasSameKeySemantics(productionMapping, oracleMapping);
        RobloxInputForensics.LogMappingComparison(probeId, productionMapping, oracleMapping, mappingEquivalent);

        // The explicit field probe intentionally replays the exact known-good PowerShell mapping contract.
        // Normal playback remains on ForegroundLayout until field evidence proves a promotion is safe.
        var input = new WindowsKeyboardInputSink(KeyboardMappingStrategy.PowerShellOracle);
        var keys = new[] { RobloxFieldInputPolicy.ProbeKey };
        var virtualKey = oracleMapping.VirtualKey;
        var continuity = new RobloxProbeFocusContinuity();
        using var eventContinuity = new RobloxSyntheticProbeForegroundContinuity(target, probeId, "PowerShellOracleKeybdEvent");
        eventContinuity.Start();
        using var lowLevelProvenance = new WindowsLowLevelKeyboardProvenance(probeId, "PowerShellOracleKeybdEvent", virtualKey);
        lowLevelProvenance.Start();
        var lowLevelObservationEnded = false;
        var windowIdentityHeld = true;
        TimeSpan? firstWindowIdentityLossAt = null;
        var started = Stopwatch.GetTimestamp();

        try
        {
            RobloxInputForensics.LogKeyState(probeId, "BEFORE_DOWN", target, virtualKey);
            eventContinuity.BeginHold();
            lowLevelProvenance.BeginObservation();
            await input.KeyDownAsync(keys, cancellationToken).ConfigureAwait(false);

            var sampleIndex = 0;
            while (true)
            {
                cancellationToken.ThrowIfCancellationRequested();
                var elapsed = Stopwatch.GetElapsedTime(started);
                var foregroundNow = target.IsForeground;
                var keyDownNow = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
                var held = continuity.Observe(foregroundNow, keyDownNow, elapsed);
                var eventHeld = eventContinuity.ObservePollingFallback();
                var window = WindowsRobloxWindowIdentity.Capture(target);
                var trustedWindow = window.IsTrustedProbeSurface;
                if (!trustedWindow && windowIdentityHeld)
                {
                    windowIdentityHeld = false;
                    firstWindowIdentityLossAt = elapsed;
                }

                RobloxInputForensics.LogKeyState(
                    probeId,
                    $"HOLD_SAMPLE_{sampleIndex:000}",
                    target,
                    virtualKey,
                    elapsed);

                if (!held || !eventHeld)
                {
                    ClientDiagnostics.Log(
                        $"INPUT_FORENSIC probe={probeId} stage=FOCUS_LOST_DURING_HOLD verdict=FOCUS_LOST_BEFORE_UP " +
                        $"firstLossMs={(eventContinuity.FirstContinuityLossAt ?? continuity.FirstFocusLossAt)?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na"} " +
                        $"source={eventContinuity.FirstContinuityLossSource ?? "POLL"} samples={continuity.SamplesObserved} " +
                        "foregroundEvents=true action=RELEASE_IMMEDIATELY.");
                    break;
                }

                if (!trustedWindow)
                {
                    ClientDiagnostics.Log(
                        $"INPUT_FORENSIC probe={probeId} stage=WINDOW_IDENTITY_LOST_DURING_HOLD verdict=WINDOW_IDENTITY_LOST_BEFORE_UP " +
                        $"firstLossMs={firstWindowIdentityLossAt?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na"} " +
                        $"windowRelation={window.Relation} targetMainReplaced={window.TargetMainWindowReplaced} " +
                        $"targetHwnd=0x{window.TargetWindowHandle.ToInt64():X} currentMainHwnd=0x{window.CurrentMainWindowHandle.ToInt64():X} " +
                        $"foregroundHwnd=0x{window.ForegroundWindowHandle.ToInt64():X} foregroundRootHwnd=0x{window.ForegroundRootHandle.ToInt64():X} " +
                        $"samples={continuity.SamplesObserved} action=RELEASE_IMMEDIATELY.");
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

            RobloxInputForensics.LogKeyState(probeId, "BEFORE_UP", target, virtualKey, Stopwatch.GetElapsedTime(started));
            await input.KeyUpAsync(keys, CancellationToken.None).ConfigureAwait(false);
            eventContinuity.EndHold();

            var holdDuration = Stopwatch.GetElapsedTime(started);
            RobloxInputForensics.LogKeyState(probeId, "AFTER_UP", target, virtualKey, holdDuration);
            var lowLevelSnapshot = lowLevelProvenance.EndObservation();
            lowLevelObservationEnded = true;

            var eventContinuityHeld = eventContinuity.ContinuityPreserved;
            var result = new RobloxFieldInputProbeResult(
                probeId,
                true,
                true,
                desktop.Parity,
                continuity.WindowsKeyDownObserved,
                continuity.ForegroundHeldContinuously && eventContinuityHeld,
                windowIdentityHeld && eventContinuityHeld,
                virtualKey,
                holdDuration)
            {
                ProductionMappingEquivalentToOracle = mappingEquivalent,
                LowLevelProvenance = lowLevelSnapshot
            };
            RobloxInputForensics.LogVerdict(probeId, result.Assess(null), null);
            return result;
        }
        finally
        {
            eventContinuity.EndHold();
            await input.ReleaseAllAsync(CancellationToken.None).ConfigureAwait(false);
            if (!lowLevelObservationEnded)
            {
                _ = lowLevelProvenance.EndObservation();
            }
        }
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

            var trustedSurface = target.IsForeground
                && WindowsRobloxWindowIdentity.Capture(target).IsTrustedProbeSurface;
            if (trustedSurface)
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
}
