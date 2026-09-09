namespace RobloxPiano.App;

internal enum RobloxPlaybackPreflightAction
{
    OpenRoblox = 0,
    VerifyInput = 1,
    RetestInput = 2,
    Proceed = 3
}

internal sealed record RobloxPlaybackPreflightDecision(
    RobloxPlaybackPreflightAction Action,
    bool CanLaunchPlayback,
    string PrimaryActionText,
    string StatusText);

internal static class RobloxPlaybackPreflight
{
    public static RobloxPlaybackPreflightDecision Evaluate(
        RobloxWindowTarget? target,
        RobloxInputHealthSnapshot health)
    {
        ArgumentNullException.ThrowIfNull(health);

        if (target is null)
        {
            return new RobloxPlaybackPreflightDecision(
                RobloxPlaybackPreflightAction.OpenRoblox,
                false,
                "Open Roblox to Play",
                "Open Roblox and enter the piano game before playback.");
        }

        var effectiveHealth = health.AppliesTo(target.ProcessId)
            ? health
            : RobloxInputHealthSnapshot.Unknown;

        return effectiveHealth.State switch
        {
            RobloxInputHealthState.Confirmed => new RobloxPlaybackPreflightDecision(
                RobloxPlaybackPreflightAction.Proceed,
                true,
                "Play",
                $"Input confirmed for Roblox PID {target.ProcessId}. Playback can start without repeating the input check for this process."),

            RobloxInputHealthState.Blocked => new RobloxPlaybackPreflightDecision(
                RobloxPlaybackPreflightAction.RetestInput,
                false,
                "Retest Input to Play",
                $"Playback is blocked for Roblox PID {target.ProcessId}: {effectiveHealth.Summary} Next: {effectiveHealth.NextAction}"),

            _ => new RobloxPlaybackPreflightDecision(
                RobloxPlaybackPreflightAction.VerifyInput,
                false,
                "Verify Input & Play",
                $"Input readiness is unknown for Roblox PID {target.ProcessId}. Run the production input check once before playback.")
        };
    }
}
