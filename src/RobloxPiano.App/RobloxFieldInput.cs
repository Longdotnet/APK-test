using System.Diagnostics;

namespace RobloxPiano.App;

internal static class RobloxFieldInputPolicy
{
    internal static readonly TimeSpan StableFocusDuration = TimeSpan.FromMilliseconds(750);
    internal static readonly TimeSpan ProbeHoldDuration = TimeSpan.FromMilliseconds(650);
    internal static readonly TimeSpan ProbeFocusTimeout = TimeSpan.FromSeconds(3);
    internal const char ProbeKey = 'w';
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
/// Real-machine field probe that bypasses MIDI and the playback scheduler. It uses the
/// exact production WindowsKeyboardInputSink to hold W long enough for a human to see
/// Roblox move or hear the W-bound piano note, while diagnostics capture OS-level state.
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
            $"targetHwnd=0x{target.WindowHandle.ToInt64():X}, key='{RobloxFieldInputPolicy.ProbeKey}'.");

        var activated = target.TryActivate();
        if (!activated)
        {
            ClientDiagnostics.Log("Field input probe stopped: Roblox activation was not confirmed.");
            return new RobloxFieldInputProbeResult(false, false, false, false, 0, TimeSpan.Zero);
        }

        var stable = await WaitForStableForegroundAsync(target, cancellationToken).ConfigureAwait(false);
        if (!stable)
        {
            ClientDiagnostics.Log("Field input probe stopped: selected Roblox PID did not remain foreground long enough.");
            return new RobloxFieldInputProbeResult(true, false, false, false, 0, TimeSpan.Zero);
        }

        var input = new WindowsKeyboardInputSink();
        var keys = new[] { RobloxFieldInputPolicy.ProbeKey };
        var virtualKey = WindowsKeyboardInputSink.ResolveVirtualKeyForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        var keyDownObserved = false;
        var foregroundHeld = false;
        var started = Stopwatch.GetTimestamp();

        try
        {
            await input.KeyDownAsync(keys, cancellationToken).ConfigureAwait(false);
            keyDownObserved = WindowsKeyboardInputSink.IsVirtualKeyDown(virtualKey);
            ClientDiagnostics.Log(
                $"Field input probe DOWN: key='{RobloxFieldInputPolicy.ProbeKey}', vk=0x{virtualKey:X2}, " +
                $"asyncKeyStateDown={keyDownObserved}, targetForeground={target.IsForeground}, " +
                $"thread={Environment.CurrentManagedThreadId}.");

            await Task.Delay(RobloxFieldInputPolicy.ProbeHoldDuration, cancellationToken).ConfigureAwait(false);
            foregroundHeld = target.IsForeground;
            await input.KeyUpAsync(keys, CancellationToken.None).ConfigureAwait(false);

            var held = Stopwatch.GetElapsedTime(started);
            ClientDiagnostics.Log(
                $"Field input probe UP: key='{RobloxFieldInputPolicy.ProbeKey}', vk=0x{virtualKey:X2}, " +
                $"heldMs={held.TotalMilliseconds:0}, targetForegroundHeld={foregroundHeld}, " +
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
