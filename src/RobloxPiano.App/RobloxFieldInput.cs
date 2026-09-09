using System.Diagnostics;
using RobloxPiano.Core;

namespace RobloxPiano.App;

/// <summary>
/// Field policy derived from the PowerShell baseline that is known to produce visible
/// Roblox keyboard behavior. Programmatic focus is not considered input-ready until it
/// has remained on the exact Roblox HWND for a short settle interval, and the manual
/// field probe keeps W physically down long enough to make the result visible.
/// </summary>
internal static class RobloxFieldInputPolicy
{
    internal static readonly TimeSpan StableFocusDuration = TimeSpan.FromMilliseconds(750);
    internal static readonly TimeSpan ProbeHoldDuration = TimeSpan.FromMilliseconds(650);
    internal static readonly TimeSpan ProbeFocusTimeout = TimeSpan.FromSeconds(3);
    internal const char ProbeKey = 'w';
}

/// <summary>
/// Requires continuous exact-HWND foreground ownership before playback can dispatch.
/// This closes the gap between SetForegroundWindow succeeding and the Roblox client
/// actually being ready to consume ordinary keyboard input.
/// </summary>
internal sealed class StableRobloxTargetFocusGate : IFocusGate
{
    private readonly object _gate = new();
    private readonly RobloxWindowTarget _target;
    private readonly TimeSpan _stableDuration;
    private long? _focusedSince;

    public StableRobloxTargetFocusGate(RobloxWindowTarget target, TimeSpan stableDuration)
    {
        _target = target ?? throw new ArgumentNullException(nameof(target));
        if (stableDuration < TimeSpan.Zero)
        {
            throw new ArgumentOutOfRangeException(nameof(stableDuration));
        }

        _stableDuration = stableDuration;
    }

    public bool IsTargetFocused
    {
        get
        {
            lock (_gate)
            {
                if (!_target.IsForeground)
                {
                    _focusedSince = null;
                    return false;
                }

                if (_stableDuration == TimeSpan.Zero)
                {
                    return true;
                }

                _focusedSince ??= Stopwatch.GetTimestamp();
                return Stopwatch.GetElapsedTime(_focusedSince.Value) >= _stableDuration;
            }
        }
    }
}

internal sealed record RobloxFieldInputProbeResult(
    bool ActivationConfirmed,
    bool StableForegroundConfirmed,
    bool WindowsReportedKeyDown,
    bool ForegroundHeldDuringProbe,
    ushort VirtualKey,
    TimeSpan HoldDuration)
{
    public bool NativeDeliveryObserved => ActivationConfirmed
        && StableForegroundConfirmed
        && WindowsReportedKeyDown
        && ForegroundHeldDuringProbe;
}

/// <summary>
/// Sends one deliberately visible W pulse through the exact production input backend.
/// It is a field diagnostic, not a synthetic CI claim: a real client can immediately
/// observe whether Roblox moves the character or plays the W-bound piano note.
/// </summary>
internal static class RobloxFieldInputProbe
{
    public static async Task<RobloxFieldInputProbeResult> RunAsync(
        RobloxWindowTarget target,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(target);
        cancellationToken.ThrowIfCancellationRequested();

        ClientDiagnostics.Log(
            $"Field input probe requested: targetPid={target.ProcessId}, " +
            $"hwnd=0x{target.WindowHandle.ToInt64():X}, key='{RobloxFieldInputPolicy.ProbeKey}'.");

        var activated = target.TryActivate();
        if (!activated)
        {
            ClientDiagnostics.Log("Field input probe stopped: Roblox activation was not confirmed.");
            return new RobloxFieldInputProbeResult(false, false, false, false, 0, TimeSpan.Zero);
        }

        var stable = await WaitForStableForegroundAsync(target, cancellationToken).ConfigureAwait(false);
        if (!stable)
        {
            ClientDiagnostics.Log("Field input probe stopped: exact Roblox foreground did not remain stable long enough.");
            return new RobloxFieldInputProbeResult(true, false, false, false, 0, TimeSpan.Zero);
        }

        var input = new WindowsKeyboardInputSink();
        var key = new[] { RobloxFieldInputPolicy.ProbeKey };
        var virtualKey = WindowsKeyboardInputSink.ResolveVirtualKeyForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        var keyDownObserved = false;
        var foregroundHeld = false;
        var started = Stopwatch.GetTimestamp();

        try
        {
            await input.KeyDownAsync(key, cancellationToken).ConfigureAwait(false);
            keyDownObserved = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
            ClientDiagnostics.Log(
                $"Field input probe DOWN: key='{RobloxFieldInputPolicy.ProbeKey}', vk=0x{virtualKey:X2}, " +
                $"asyncKeyStateDown={keyDownObserved}, foreground={target.IsForeground}, " +
                $"thread={Environment.CurrentManagedThreadId}.");

            await Task.Delay(RobloxFieldInputPolicy.ProbeHoldDuration, cancellationToken).ConfigureAwait(false);
            foregroundHeld = target.IsForeground;
            await input.KeyUpAsync(key, CancellationToken.None).ConfigureAwait(false);

            var held = Stopwatch.GetElapsedTime(started);
            ClientDiagnostics.Log(
                $"Field input probe UP: key='{RobloxFieldInputPolicy.ProbeKey}', vk=0x{virtualKey:X2}, " +
                $"heldMs={held.TotalMilliseconds:0}, foregroundHeld={foregroundHeld}, " +
                $"asyncKeyStateAfterUp={WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey)}.");

            return new RobloxFieldInputProbeResult(
                true,
                true,
                keyDownObserved,
                foregroundHeld,
                virtualKey,
                held);
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
