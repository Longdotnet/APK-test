namespace RobloxPiano.App;

internal enum RobloxInputHealthState
{
    Unknown = 0,
    Confirmed = 1,
    Blocked = 2
}

internal sealed record RobloxInputHealthSnapshot(
    RobloxInputHealthState State,
    int? ProcessId,
    RobloxInputCheckVerdict? Verdict,
    DateTimeOffset? CheckedAt,
    string Summary,
    string NextAction,
    long? ProcessStartTimeUtcTicks = null)
{
    public static RobloxInputHealthSnapshot Unknown { get; } = new(
        RobloxInputHealthState.Unknown,
        null,
        null,
        null,
        "Roblox input has not been verified for this Roblox session.",
        "Run Test Roblox Input before playback so the client can verify this Roblox process accepts the production input path.");

    public bool AppliesTo(int processId) => ProcessId == processId;

    public bool AppliesTo(RobloxWindowTarget target)
    {
        ArgumentNullException.ThrowIfNull(target);
        if (ProcessId != target.ProcessId || !ProcessStartTimeUtcTicks.HasValue)
        {
            return false;
        }

        return RobloxProcessIdentity.TryCapture(target.ProcessId, out var current)
            && current.StartTimeUtcTicks == ProcessStartTimeUtcTicks.Value;
    }
}

internal static class RobloxInputHealthSession
{
    private static readonly object Gate = new();
    private static RobloxInputHealthSnapshot _snapshot = RobloxInputHealthSnapshot.Unknown;

    public static RobloxInputHealthSnapshot GetFor(RobloxWindowTarget? target)
    {
        lock (Gate)
        {
            if (target is null || !_snapshot.AppliesTo(target))
            {
                return RobloxInputHealthSnapshot.Unknown;
            }

            return _snapshot;
        }
    }

    public static RobloxInputHealthSnapshot Record(
        RobloxWindowTarget target,
        RobloxInputCheckAssessment assessment,
        DateTimeOffset? checkedAt = null)
    {
        ArgumentNullException.ThrowIfNull(target);
        ArgumentNullException.ThrowIfNull(assessment);

        var processIdentity = RobloxProcessIdentity.CaptureOrThrow(target.ProcessId);
        var state = assessment.IsSuccess
            ? RobloxInputHealthState.Confirmed
            : RobloxInputHealthState.Blocked;
        var snapshot = new RobloxInputHealthSnapshot(
            state,
            target.ProcessId,
            assessment.Verdict,
            checkedAt ?? DateTimeOffset.Now,
            assessment.Summary,
            assessment.NextAction,
            processIdentity.StartTimeUtcTicks);

        lock (Gate)
        {
            _snapshot = snapshot;
        }

        ClientDiagnostics.Log(
            $"Roblox input health recorded: state={snapshot.State}; identity={processIdentity}; verdict={snapshot.Verdict}; checkedAt={snapshot.CheckedAt:O}.");
        return snapshot;
    }

    internal static void ResetForTests()
    {
        lock (Gate)
        {
            _snapshot = RobloxInputHealthSnapshot.Unknown;
        }
    }
}
