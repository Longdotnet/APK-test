namespace RobloxPiano.Core;

/// <summary>
/// Deterministic playback timing calibration. DispatchLead advances physical input
/// dispatch relative to canonical score time to compensate for measured client/game
/// input latency without changing the canonical timeline itself.
/// </summary>
public sealed record PlaybackTimingProfile
{
    public static readonly TimeSpan MaximumDispatchLead = TimeSpan.FromMilliseconds(250);
    public static PlaybackTimingProfile Neutral { get; } = new(TimeSpan.Zero);

    public PlaybackTimingProfile(TimeSpan dispatchLead)
    {
        if (dispatchLead < TimeSpan.Zero || dispatchLead > MaximumDispatchLead)
        {
            throw new ArgumentOutOfRangeException(
                nameof(dispatchLead),
                $"Dispatch lead must be between 0 and {MaximumDispatchLead.TotalMilliseconds:0} ms.");
        }

        DispatchLead = dispatchLead;
    }

    public TimeSpan DispatchLead { get; }

    public static PlaybackTimingProfile FromMilliseconds(decimal milliseconds)
    {
        if (milliseconds < 0m || milliseconds > (decimal)MaximumDispatchLead.TotalMilliseconds)
        {
            throw new ArgumentOutOfRangeException(nameof(milliseconds));
        }

        return new PlaybackTimingProfile(TimeSpan.FromMilliseconds((double)milliseconds));
    }
}
