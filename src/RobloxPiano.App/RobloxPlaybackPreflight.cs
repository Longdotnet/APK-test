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

internal enum RobloxPlaybackAuthorizationFailure
{
    VerificationRequired = 0,
    ProcessEnded = 1,
    ProcessReplaced = 2
}

internal sealed class RobloxPlaybackAuthorizationException : InvalidOperationException
{
    public RobloxPlaybackAuthorizationException(
        RobloxPlaybackAuthorizationFailure failure,
        string message)
        : base(message)
    {
        Failure = failure;
    }

    public RobloxPlaybackAuthorizationFailure Failure { get; }
}

internal static class RobloxPlaybackLaunchAuthorization
{
    private static readonly object Gate = new();
    private static RobloxProcessIdentity? _authorizedIdentity;
    private static DateTimeOffset? _authorizedAt;

    public static void Synchronize(RobloxWindowTarget? target, RobloxInputHealthSnapshot health)
    {
        ArgumentNullException.ThrowIfNull(health);

        lock (Gate)
        {
            if (target is null)
            {
                _authorizedIdentity = null;
                _authorizedAt = null;
                return;
            }

            if (health.AppliesTo(target)
                && health.State == RobloxInputHealthState.Confirmed
                && health.ProcessStartTimeUtcTicks.HasValue)
            {
                var identity = new RobloxProcessIdentity(target.ProcessId, health.ProcessStartTimeUtcTicks.Value);
                if (_authorizedIdentity != identity)
                {
                    ClientDiagnostics.Log($"Playback launch authorization armed for confirmed Roblox {identity}.");
                }

                _authorizedIdentity = identity;
                _authorizedAt = DateTimeOffset.UtcNow;
                return;
            }

            if (_authorizedIdentity?.ProcessId == target.ProcessId)
            {
                ClientDiagnostics.Log(
                    $"Playback launch authorization revoked for Roblox PID {target.ProcessId}; " +
                    $"input readiness is {health.State} or the process lifetime changed.");
                _authorizedIdentity = null;
                _authorizedAt = null;
            }
        }
    }

    public static bool IsAuthorized(RobloxWindowTarget target)
    {
        ArgumentNullException.ThrowIfNull(target);

        RobloxProcessIdentity? authorizedIdentity;
        lock (Gate)
        {
            authorizedIdentity = _authorizedIdentity;
        }

        if (!authorizedIdentity.HasValue
            || !_authorizedAt.HasValue
            || authorizedIdentity.Value.ProcessId != target.ProcessId)
        {
            throw new RobloxPlaybackAuthorizationException(
                RobloxPlaybackAuthorizationFailure.VerificationRequired,
                $"Roblox input verification is no longer valid for PID {target.ProcessId}. Return to the Sheet Library and verify input again.");
        }

        if (!RobloxProcessIdentity.TryCapture(target.ProcessId, out var currentIdentity))
        {
            throw new RobloxPlaybackAuthorizationException(
                RobloxPlaybackAuthorizationFailure.ProcessEnded,
                $"The verified Roblox process ended before playback input could be dispatched. Return to the Sheet Library and verify the current Roblox process.");
        }

        if (currentIdentity != authorizedIdentity.Value)
        {
            ClientDiagnostics.Log(
                $"Roblox process lifetime mismatch at runtime dispatch: authorized={authorizedIdentity.Value}; current={currentIdentity}.");
            throw new RobloxPlaybackAuthorizationException(
                RobloxPlaybackAuthorizationFailure.ProcessReplaced,
                $"Roblox restarted or Windows reused PID {target.ProcessId} after input verification. Playback was blocked before input dispatch; verify input for the current Roblox process.");
        }

        var health = RobloxInputHealthSession.GetFor(target);
        if (health.State != RobloxInputHealthState.Confirmed
            || !health.AppliesTo(target)
            || health.ProcessStartTimeUtcTicks != authorizedIdentity.Value.StartTimeUtcTicks)
        {
            throw new RobloxPlaybackAuthorizationException(
                RobloxPlaybackAuthorizationFailure.VerificationRequired,
                $"Roblox input readiness changed before playback. Return to the Sheet Library and verify input for the current Roblox process.");
        }

        return true;
    }

    internal static int? AuthorizedProcessIdForTests
    {
        get
        {
            lock (Gate)
            {
                return _authorizedIdentity?.ProcessId;
            }
        }
    }

    internal static long? AuthorizedProcessStartTimeUtcTicksForTests
    {
        get
        {
            lock (Gate)
            {
                return _authorizedIdentity?.StartTimeUtcTicks;
            }
        }
    }

    internal static void ResetForTests()
    {
        lock (Gate)
        {
            _authorizedIdentity = null;
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

        var effectiveHealth = health.AppliesTo(target)
            ? health
            : RobloxInputHealthSnapshot.Unknown;

        return effectiveHealth.State switch
        {
            RobloxInputHealthState.Confirmed => new RobloxPlaybackPreflightDecision(
                RobloxPlaybackPreflightAction.Proceed,
                true,
                "Play",
                $"Input confirmed for the current Roblox process lifetime (PID {target.ProcessId}). Playback can start without repeating the input check while this process instance remains active."),

            RobloxInputHealthState.Blocked => new RobloxPlaybackPreflightDecision(
                RobloxPlaybackPreflightAction.RetestInput,
                false,
                "Retest Input to Play",
                $"Playback is blocked for the current Roblox process (PID {target.ProcessId}): {effectiveHealth.Summary} Next: {effectiveHealth.NextAction}"),

            _ => new RobloxPlaybackPreflightDecision(
                RobloxPlaybackPreflightAction.VerifyInput,
                false,
                "Verify Input & Play",
                $"Input readiness is unknown for the current Roblox process lifetime (PID {target.ProcessId}). Run the production input check once before playback.")
        };
    }
}
