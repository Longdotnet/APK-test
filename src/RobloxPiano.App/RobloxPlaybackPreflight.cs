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

internal sealed record RobloxPlaybackAuthorizationRecovery(
    string PlayerStatusText,
    string DialogTitle,
    string DialogMessage);

internal static class RobloxPlaybackAuthorizationRecoveryPolicy
{
    public static RobloxPlaybackAuthorizationRecovery Describe(RobloxPlaybackAuthorizationFailure failure)
        => failure switch
        {
            RobloxPlaybackAuthorizationFailure.ProcessEnded => new RobloxPlaybackAuthorizationRecovery(
                "Roblox closed before input could continue. Returning to the Sheet Library safely.",
                "Roblox closed",
                "The Roblox process that passed input verification has closed. No further piano input was sent. Roblox Piano will return to the Sheet Library; reopen Roblox and use Verify Input & Play for the new process."),

            RobloxPlaybackAuthorizationFailure.ProcessReplaced => new RobloxPlaybackAuthorizationRecovery(
                "Roblox restarted or changed process lifetime. Returning to the Sheet Library for fresh input verification.",
                "Roblox restarted",
                "Roblox restarted or Windows reused the verified process ID. Playback was blocked before input could continue. Roblox Piano will return to the Sheet Library, where the current Roblox process must pass Verify Input & Play."),

            _ => new RobloxPlaybackAuthorizationRecovery(
                "Roblox input verification is no longer valid. Returning to the Sheet Library for verification.",
                "Input verification required",
                "The current Roblox process is no longer covered by the input verification used to start this playback. No unverified input will be sent. Roblox Piano will return to the Sheet Library so you can run Verify Input & Play again.")
        };
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
        DateTimeOffset? authorizedAt;
        lock (Gate)
        {
            authorizedIdentity = _authorizedIdentity;
            authorizedAt = _authorizedAt;
        }

        if (!RobloxProcessIdentity.TryCapture(target.ProcessId, out var currentIdentity))
        {
            ThrowAuthorizationFailure(
                CompareIdentity(authorizedIdentity, null, authorizedAt, target.ProcessId),
                target.ProcessId,
                authorizedIdentity,
                null);
        }

        var failure = CompareIdentity(authorizedIdentity, currentIdentity, authorizedAt, target.ProcessId);
        if (failure.HasValue)
        {
            ThrowAuthorizationFailure(failure, target.ProcessId, authorizedIdentity, currentIdentity);
        }

        var health = RobloxInputHealthSession.GetFor(target);
        if (health.State != RobloxInputHealthState.Confirmed
            || !health.AppliesTo(target)
            || health.ProcessStartTimeUtcTicks != authorizedIdentity!.Value.StartTimeUtcTicks)
        {
            throw new RobloxPlaybackAuthorizationException(
                RobloxPlaybackAuthorizationFailure.VerificationRequired,
                "Roblox input readiness changed before playback. Return to the Sheet Library and verify input for the current Roblox process.");
        }

        return true;
    }

    internal static RobloxPlaybackAuthorizationFailure? CompareIdentity(
        RobloxProcessIdentity? authorizedIdentity,
        RobloxProcessIdentity? currentIdentity,
        DateTimeOffset? authorizedAt,
        int targetProcessId)
    {
        if (!authorizedIdentity.HasValue
            || !authorizedAt.HasValue
            || authorizedIdentity.Value.ProcessId != targetProcessId)
        {
            return RobloxPlaybackAuthorizationFailure.VerificationRequired;
        }

        if (!currentIdentity.HasValue)
        {
            return RobloxPlaybackAuthorizationFailure.ProcessEnded;
        }

        return currentIdentity.Value == authorizedIdentity.Value
            ? null
            : RobloxPlaybackAuthorizationFailure.ProcessReplaced;
    }

    private static void ThrowAuthorizationFailure(
        RobloxPlaybackAuthorizationFailure? failure,
        int targetProcessId,
        RobloxProcessIdentity? authorizedIdentity,
        RobloxProcessIdentity? currentIdentity)
    {
        if (!failure.HasValue)
        {
            return;
        }

        switch (failure.Value)
        {
            case RobloxPlaybackAuthorizationFailure.ProcessEnded:
                throw new RobloxPlaybackAuthorizationException(
                    failure.Value,
                    "The verified Roblox process ended before playback input could be dispatched. Return to the Sheet Library and verify the current Roblox process.");

            case RobloxPlaybackAuthorizationFailure.ProcessReplaced:
                ClientDiagnostics.Log(
                    $"Roblox process lifetime mismatch at runtime dispatch: authorized={authorizedIdentity}; current={currentIdentity}.");
                throw new RobloxPlaybackAuthorizationException(
                    failure.Value,
                    $"Roblox restarted or Windows reused PID {targetProcessId} after input verification. Playback was blocked before input dispatch; verify input for the current Roblox process.");

            default:
                throw new RobloxPlaybackAuthorizationException(
                    failure.Value,
                    $"Roblox input verification is no longer valid for PID {targetProcessId}. Return to the Sheet Library and verify input again.");
        }
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
