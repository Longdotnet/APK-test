namespace RobloxPiano.App;

internal enum PlaybackSessionQualityVerdict
{
    Healthy = 0,
    FocusInterrupted = 1,
    TimingDegraded = 2,
    InputLatencyHigh = 3,
    DispatchLoss = 4,
    Unavailable = 5
}

internal sealed record PlaybackSessionQualityAssessment(
    PlaybackSessionQualityVerdict Verdict,
    string Summary,
    string Guidance)
{
    public bool NeedsAttention => Verdict is not PlaybackSessionQualityVerdict.Healthy
        and not PlaybackSessionQualityVerdict.Unavailable;
}

internal static class PlaybackSessionQualityAssessmentPolicy
{
    // These are conservative client-support thresholds, not scheduler promotion gates.
    // They intentionally classify only clearly actionable field evidence.
    internal const double P95TimingWarningMilliseconds = 12d;
    internal const double MaxTimingWarningMilliseconds = 30d;
    internal const double MeanInputCallWarningMilliseconds = 4d;
    internal const double MaxInputCallWarningMilliseconds = 15d;

    public static PlaybackSessionQualityAssessment Assess(PlaybackSessionQualityDiagnostic? quality)
    {
        if (quality is null)
        {
            return new PlaybackSessionQualityAssessment(
                PlaybackSessionQualityVerdict.Unavailable,
                "Quality evidence unavailable",
                "This session was recorded without transport-aware quality evidence. Reproduce the issue on the current client before comparing timing quality.");
        }

        if (quality.UnexpectedMissingEdgeCount > 0 || quality.FailureCount > 0)
        {
            return new PlaybackSessionQualityAssessment(
                PlaybackSessionQualityVerdict.DispatchLoss,
                $"Unexpected dispatch loss ({quality.UnexpectedMissingEdgeCount} missing, {quality.FailureCount} failure(s))",
                "Playback did not complete the deterministic dispatch plan. Re-run Test Roblox Input, keep Roblox focused, then reproduce and save a Support Bundle if loss remains.");
        }

        if (quality.FocusPauseCount > 0)
        {
            return new PlaybackSessionQualityAssessment(
                PlaybackSessionQualityVerdict.FocusInterrupted,
                $"Roblox focus interrupted {quality.FocusPauseCount} time(s) for {quality.FocusPausedMilliseconds:0.#} ms",
                "Keep Roblox as the foreground window during playback. Focus loss intentionally stops input and can make a song sound paused or discontinuous.");
        }

        if (quality.MeanInputCallMilliseconds > MeanInputCallWarningMilliseconds
            || quality.MaxInputCallMilliseconds > MaxInputCallWarningMilliseconds)
        {
            return new PlaybackSessionQualityAssessment(
                PlaybackSessionQualityVerdict.InputLatencyHigh,
                $"Windows input delivery is slow ({quality.MeanInputCallMilliseconds:0.#} ms mean, {quality.MaxInputCallMilliseconds:0.#} ms max)",
                "Close heavy background workloads, retest Roblox input, and reproduce. High input-call latency can make correct scheduler timing arrive late at Roblox.");
        }

        if (quality.P95AbsoluteTimingErrorMilliseconds > P95TimingWarningMilliseconds
            || quality.MaxAbsoluteTimingErrorMilliseconds > MaxTimingWarningMilliseconds)
        {
            return new PlaybackSessionQualityAssessment(
                PlaybackSessionQualityVerdict.TimingDegraded,
                $"Scheduler timing degraded ({quality.P95AbsoluteTimingErrorMilliseconds:0.#} ms p95, {quality.MaxAbsoluteTimingErrorMilliseconds:0.#} ms max)",
                "Reproduce with Roblox focused and minimal system load. If the verdict repeats, save a Support Bundle so the timing evidence can be compared against the Legacy/Legacy x2 baseline.");
        }

        return new PlaybackSessionQualityAssessment(
            PlaybackSessionQualityVerdict.Healthy,
            $"Healthy timing ({quality.P95AbsoluteTimingErrorMilliseconds:0.#} ms p95)",
            "No actionable transport-quality degradation was detected in this session.");
    }
}
