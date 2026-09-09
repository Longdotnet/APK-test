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

internal static class RobloxPlaybackLaunchAuthorization
{
    private static readonly object Gate = new();
    private static int? _authorizedProcessId;
    private static DateTimeOffset? _authorizedAt;

    public static void Synchronize(RobloxWindowTarget? target, RobloxInputHealthSnapshot health)
    {
        ArgumentNullException.ThrowIfNull(health);

        lock (Gate)
        {
            if (target is null)
            {
                _authorizedProcessId = null;
                _authorizedAt = null;
                return;
            }

            if (health.AppliesTo(target.ProcessId) && health.State == RobloxInputHealthState.Confirmed)
            {
                if (_authorizedProcessId != target.ProcessId)
                {
                    ClientDiagnostics.Log($"Playback launch authorization armed for confirmed Roblox PID {target.ProcessId}.");
                }

                _authorizedProcessId = target.ProcessId;
                _authorizedAt = DateTimeOffset.UtcNow;
                return;
            }

            if (_authorizedProcessId == target.ProcessId)
            {
                ClientDiagnostics.Log($"Playback launch authorization revoked for Roblox PID {target.ProcessId}; input readiness is {health.State}.");
                _authorizedProcessId = null;
                _authorizedAt = null;
            }
        }
    }

    public static bool IsAuthorized(RobloxWindowTarget target)
    {
        ArgumentNullException.ThrowIfNull(target);
        var health = RobloxInputHealthSession.GetFor(target);

        lock (Gate)
        {
            return _authorizedProcessId == target.ProcessId
                && _authorizedAt.HasValue
                && health.AppliesTo(target.ProcessId)
                && health.State == RobloxInputHealthState.Confirmed;
        }
    }

    internal static int? AuthorizedProcessIdForTests
    {
        get
        {
            lock (Gate)
            {
                return _authorizedProcessId;
            }
        }
    }

    internal static void ResetForTests()
    {
        lock (Gate)
        {
            _authorizedProcessId = null;
            _authorizedAt = null;
        }
    }
}

internal static class RobloxPlaybackPreflight
{
    public static RobloxPlaybackPreflightDecision Evaluate(
        RobloxWindowTarget? target,
        RobloxInputHealthSnapshot health)
    {
        ArgumentNullException.ThrowIfNull(health);
        RobloxPlaybackLaunchAuthorization.Synchronize(target, health);

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
