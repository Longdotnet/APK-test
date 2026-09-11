using System.Diagnostics;

namespace RobloxPiano.App;

internal static class RobloxFieldInputPolicy
{
    internal static readonly TimeSpan StableFocusDuration = TimeSpan.FromMilliseconds(750);
    internal static readonly TimeSpan ProbeHoldDuration = TimeSpan.FromMilliseconds(650);
    internal static readonly TimeSpan ProbeFocusTimeout = TimeSpan.FromSeconds(3);
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
    NativeDeliveryAwaitingObservation = 6
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
    bool WindowsReportedKeyDown,
    bool ForegroundHeldDuringProbe,
    ushort VirtualKey,
    TimeSpan HoldDuration)
{
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
            windowsReportedKeyDown,
            foregroundHeldDuringProbe,
            virtualKey,
            holdDuration)
    {
    }

    public bool NativeDeliveryObserved => ActivationConfirmed
        && StableForegroundConfirmed
        && WindowsReportedKeyDown
        && ForegroundHeldDuringProbe;

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
                "Roblox did not stay foreground long enough to safely send the test key.",
                "Stop switching windows or overlays for a moment, keep the selected Roblox Player visible, then retry.",
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
                "Keep Roblox focused for the entire check and retry. Playback intentionally stops input under the same condition.",
                false);
        }

        if (robloxReacted is null)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.NativeDeliveryAwaitingObservation,
                "Windows delivered the W test while Roblox remained foreground.",
                "Confirm whether Roblox visibly moved or played the W-bound piano note; that observation separates Windows delivery from Roblox consumption.",
                false);
        }

        if (robloxReacted.Value)
        {
            return new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.Confirmed,
                "Roblox reacted to the production input path.",
                "Input acceptance is confirmed for this session. Select a Library song and press Play.",
                true);
        }

        return new RobloxInputCheckAssessment(
            RobloxInputCheckVerdict.RobloxDidNotReact,
            "Windows delivered the W test, but Roblox did not visibly react.",
            "The scheduler is not the current suspect. Check Roblox/game keyboard capture, privilege/integrity mismatch, overlays or anti-input behavior; Diagnostics contains the exact native evidence.",
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
            var result = new RobloxFieldInputProbeResult(probeId, false, false, false, false, 0, TimeSpan.Zero);
            RobloxInputForensics.LogVerdict(probeId, result.Assess(null), null);
            return result;
        }

        var stable = await WaitForStableForegroundAsync(target, cancellationToken).ConfigureAwait(false);
        if (!stable)
        {
            var result = new RobloxFieldInputProbeResult(probeId, true, false, false, false, 0, TimeSpan.Zero);
            RobloxInputForensics.LogVerdict(probeId, result.Assess(null), null);
            return result;
        }

        var input = new WindowsKeyboardInputSink();
        var keys = new[] { RobloxFieldInputPolicy.ProbeKey };
        var virtualKey = WindowsKeyboardInputSink.ResolveVirtualKeyForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        var keyDownObserved = false;
        var foregroundHeld = false;
        var started = Stopwatch.GetTimestamp();

        try
        {
            RobloxInputForensics.LogKeyState(probeId, "BEFORE_DOWN", target, virtualKey);
            await input.KeyDownAsync(keys, cancellationToken).ConfigureAwait(false);
            keyDownObserved = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
            RobloxInputForensics.LogKeyState(probeId, "AFTER_DOWN_0MS", target, virtualKey, Stopwatch.GetElapsedTime(started));

            await Task.Delay(25, cancellationToken).ConfigureAwait(false);
            keyDownObserved |= WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
            RobloxInputForensics.LogKeyState(probeId, "AFTER_DOWN_25MS", target, virtualKey, Stopwatch.GetElapsedTime(started));

            await Task.Delay(25, cancellationToken).ConfigureAwait(false);
            keyDownObserved |= WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
            RobloxInputForensics.LogKeyState(probeId, "AFTER_DOWN_50MS", target, virtualKey, Stopwatch.GetElapsedTime(started));

            var remaining = RobloxFieldInputPolicy.ProbeHoldDuration - Stopwatch.GetElapsedTime(started);
            if (remaining > TimeSpan.Zero)
            {
                await Task.Delay(remaining, cancellationToken).ConfigureAwait(false);
            }

            foregroundHeld = target.IsForeground;
            RobloxInputForensics.LogKeyState(probeId, "BEFORE_UP", target, virtualKey, Stopwatch.GetElapsedTime(started));
            await input.KeyUpAsync(keys, CancellationToken.None).ConfigureAwait(false);

            var held = Stopwatch.GetElapsedTime(started);
            RobloxInputForensics.LogKeyState(probeId, "AFTER_UP", target, virtualKey, held);

            var result = new RobloxFieldInputProbeResult(
                probeId,
                true,
                true,
                keyDownObserved,
                foregroundHeld,
                virtualKey,
                held);
            RobloxInputForensics.LogVerdict(probeId, result.Assess(null), null);
            return result;
        }
        finally
        {
            await input.ReleaseAllAsync(CancellationToken.None).ConfigureAwait(false);
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

            if (target.IsForeground)
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
