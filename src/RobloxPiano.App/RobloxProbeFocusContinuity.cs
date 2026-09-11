namespace RobloxPiano.App;

/// <summary>
/// Sticky focus/key-state evidence for explicit Roblox input probes. Once foreground is
/// observed lost during a held key, later focus recovery cannot rewrite history and the
/// probe must remain unconfirmed.
/// </summary>
internal sealed class RobloxProbeFocusContinuity
{
    public bool ForegroundHeldContinuously { get; private set; } = true;
    public bool WindowsKeyDownObserved { get; private set; }
    public int SamplesObserved { get; private set; }
    public TimeSpan? FirstFocusLossAt { get; private set; }

    /// <summary>
    /// Records one probe sample. Returns false as soon as a focus loss has ever been
    /// observed so callers can release held input immediately instead of waiting for the
    /// nominal hold duration.
    /// </summary>
    public bool Observe(bool targetIsForeground, bool windowsKeyDown, TimeSpan elapsed)
    {
        if (elapsed < TimeSpan.Zero)
        {
            throw new ArgumentOutOfRangeException(nameof(elapsed));
        }

        SamplesObserved++;
        WindowsKeyDownObserved |= windowsKeyDown;

        if (!targetIsForeground)
        {
            ForegroundHeldContinuously = false;
            FirstFocusLossAt ??= elapsed;
        }

        return ForegroundHeldContinuously;
    }
}
