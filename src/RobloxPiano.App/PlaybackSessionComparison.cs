namespace RobloxPiano.App;

internal enum PlaybackSessionComparisonVerdict
{
    NotComparable = 0,
    StableHealthy = 1,
    Improved = 2,
    Regressed = 3,
    StableDegraded = 4,
    Interfered = 5
}

internal sealed record PlaybackSessionComparisonAssessment(
    PlaybackSessionComparisonVerdict Verdict,
    string Summary,
    string Guidance,
    string? BaselineSessionId,
    double? P95TimingDeltaMilliseconds,
    double? MaxInputCallDeltaMilliseconds)
{
    public bool HasBaseline => !string.IsNullOrWhiteSpace(BaselineSessionId);
}

internal static class PlaybackSessionComparisonPolicy
{
    internal const double SpeedTolerance = 0.0005d;
    internal const double PositionToleranceSeconds = 0.0005d;
    internal const double TimingRegressionDeltaMilliseconds = 3d;
    internal const double InputRegressionDeltaMilliseconds = 3d;

    public static PlaybackSessionComparisonAssessment CompareWithMostRecentCompatible(
        PlaybackSupportSession current,
        IReadOnlyList<PlaybackSupportSession> sessions)
    {
        ArgumentNullException.ThrowIfNull(current);
        ArgumentNullException.ThrowIfNull(sessions);

        var baseline = sessions
            .Where(candidate => !ReferenceEquals(candidate, current))
            .Where(candidate => candidate.EndedAtUtc < current.EndedAtUtc)
            .Where(candidate => AreSettingsComparable(current, candidate))
            .OrderByDescending(candidate => candidate.EndedAtUtc)
            .ThenByDescending(candidate => candidate.SessionId, StringComparer.Ordinal)
            .FirstOrDefault();

        if (baseline is null)
        {
            return new PlaybackSessionComparisonAssessment(
                PlaybackSessionComparisonVerdict.NotComparable,
                "No prior controlled run with the same canonical performance/runtime identity, playback settings and transport history.",
                "Reproduce the same canonical song without changing playback engine, input profile, speed, input-latency compensation, seek targets or runtime speed transitions. Older sessions without a persisted transport ledger intentionally cannot become A/B baselines.",
                null,
                null,
                null);
        }

        var currentQuality = current.Quality!;
        var baselineQuality = baseline.Quality!;
        var timingDelta = currentQuality.P95AbsoluteTimingErrorMilliseconds
                          - baselineQuality.P95AbsoluteTimingErrorMilliseconds;
        var inputDelta = currentQuality.MaxInputCallMilliseconds
                         - baselineQuality.MaxInputCallMilliseconds;

        var currentAssessment = PlaybackSessionQualityAssessmentPolicy.Assess(currentQuality);
        var baselineAssessment = PlaybackSessionQualityAssessmentPolicy.Assess(baselineQuality);

        if (IsInterfered(currentQuality) || IsInterfered(baselineQuality))
        {
            return new PlaybackSessionComparisonAssessment(
                PlaybackSessionComparisonVerdict.Interfered,
                $"Controlled comparison is blocked by focus/dispatch interference. p95 delta {timingDelta:+0.###;-0.###;0} ms.",
                "Repeat both runs with Roblox continuously focused and no unexpected dispatch loss. Interfered runs must not promote or condemn a playback engine.",
                baseline.SessionId,
                timingDelta,
                inputDelta);
        }

        var currentHealthy = currentAssessment.Verdict == PlaybackSessionQualityVerdict.Healthy;
        var baselineHealthy = baselineAssessment.Verdict == PlaybackSessionQualityVerdict.Healthy;

        if (currentHealthy && baselineHealthy)
        {
            return new PlaybackSessionComparisonAssessment(
                PlaybackSessionComparisonVerdict.StableHealthy,
                $"Both controlled runs are healthy. p95 delta {timingDelta:+0.###;-0.###;0} ms; max input-call delta {inputDelta:+0.###;-0.###;0} ms.",
                "No actionable runtime regression is visible between these controlled runs. Preserve Legacy/Legacy x2 as the separate perceptual promotion baseline.",
                baseline.SessionId,
                timingDelta,
                inputDelta);
        }

        if (currentHealthy && !baselineHealthy)
        {
            return new PlaybackSessionComparisonAssessment(
                PlaybackSessionComparisonVerdict.Improved,
                $"Current controlled run improved from {baselineAssessment.Verdict} to Healthy. p95 delta {timingDelta:+0.###;-0.###;0} ms.",
                "Repeat once more before treating this as durable improvement. This support comparison does not by itself promote a new playback engine over Legacy/Legacy x2.",
                baseline.SessionId,
                timingDelta,
                inputDelta);
        }

        if (!currentHealthy && baselineHealthy)
        {
            return new PlaybackSessionComparisonAssessment(
                PlaybackSessionComparisonVerdict.Regressed,
                $"Current controlled run regressed from Healthy to {currentAssessment.Verdict}. p95 delta {timingDelta:+0.###;-0.###;0} ms; max input-call delta {inputDelta:+0.###;-0.###;0} ms.",
                BuildRegressionGuidance(timingDelta, inputDelta),
                baseline.SessionId,
                timingDelta,
                inputDelta);
        }

        var materiallyWorse = timingDelta > TimingRegressionDeltaMilliseconds
                              || inputDelta > InputRegressionDeltaMilliseconds;
        return new PlaybackSessionComparisonAssessment(
            materiallyWorse ? PlaybackSessionComparisonVerdict.Regressed : PlaybackSessionComparisonVerdict.StableDegraded,
            materiallyWorse
                ? $"Both runs are degraded and the current run is measurably worse. p95 delta {timingDelta:+0.###;-0.###;0} ms; max input-call delta {inputDelta:+0.###;-0.###;0} ms."
                : $"Both controlled runs remain degraded without a material delta. p95 delta {timingDelta:+0.###;-0.###;0} ms; max input-call delta {inputDelta:+0.###;-0.###;0} ms.",
            materiallyWorse
                ? BuildRegressionGuidance(timingDelta, inputDelta)
                : "The issue reproduced under equivalent canonical/runtime identity, settings and transport history. Save a verified Support Bundle; repeated stable degradation is stronger evidence than a one-off slow run.",
            baseline.SessionId,
            timingDelta,
            inputDelta);
    }

    internal static bool AreSettingsComparable(PlaybackSupportSession current, PlaybackSupportSession candidate)
    {
        ArgumentNullException.ThrowIfNull(current);
        ArgumentNullException.ThrowIfNull(candidate);

        if (current.Quality is null || candidate.Quality is null)
        {
            return false;
        }

        if (string.IsNullOrWhiteSpace(current.CanonicalSourceFingerprint)
            || string.IsNullOrWhiteSpace(candidate.CanonicalSourceFingerprint)
            || string.IsNullOrWhiteSpace(current.PlaybackEngine)
            || string.IsNullOrWhiteSpace(candidate.PlaybackEngine)
            || string.IsNullOrWhiteSpace(current.InputProfile)
            || string.IsNullOrWhiteSpace(candidate.InputProfile))
        {
            return false;
        }

        return string.Equals(current.CanonicalSourceFingerprint, candidate.CanonicalSourceFingerprint, StringComparison.OrdinalIgnoreCase)
               && string.Equals(current.SourceType, candidate.SourceType, StringComparison.OrdinalIgnoreCase)
               && string.Equals(current.PlaybackEngine, candidate.PlaybackEngine, StringComparison.Ordinal)
               && string.Equals(current.InputProfile, candidate.InputProfile, StringComparison.Ordinal)
               && Math.Abs(current.PreferredSpeed - candidate.PreferredSpeed) <= SpeedTolerance
               && current.InputLatencyMs == candidate.InputLatencyMs
               && HaveEquivalentTransportHistory(current.Quality, candidate.Quality);
    }

    internal static bool HaveEquivalentTransportHistory(
        PlaybackSessionQualityDiagnostic current,
        PlaybackSessionQualityDiagnostic candidate)
    {
        ArgumentNullException.ThrowIfNull(current);
        ArgumentNullException.ThrowIfNull(candidate);

        if (current.ControlEvents is null || candidate.ControlEvents is null
            || current.ControlEvents.Count == 0 || candidate.ControlEvents.Count == 0
            || current.ControlEvents.Count != candidate.ControlEvents.Count)
        {
            return false;
        }

        for (var index = 0; index < current.ControlEvents.Count; index++)
        {
            var left = current.ControlEvents[index];
            var right = candidate.ControlEvents[index];
            if (left.Sequence != right.Sequence
                || left.Kind != right.Kind
                || Math.Abs(left.PositionSeconds - right.PositionSeconds) > PositionToleranceSeconds
                || !SpeedsEquivalent(left.Speed, right.Speed))
            {
                return false;
            }
        }

        return true;
    }

    private static bool SpeedsEquivalent(double? left, double? right)
    {
        if (!left.HasValue || !right.HasValue)
        {
            return left.HasValue == right.HasValue;
        }

        return double.IsFinite(left.Value)
               && double.IsFinite(right.Value)
               && Math.Abs(left.Value - right.Value) <= SpeedTolerance;
    }

    private static bool IsInterfered(PlaybackSessionQualityDiagnostic quality)
        => quality.FocusPauseCount > 0
           || quality.UnexpectedMissingEdgeCount > 0
           || quality.FailureCount > 0;

    private static string BuildRegressionGuidance(double timingDelta, double inputDelta)
    {
        if (inputDelta > InputRegressionDeltaMilliseconds && timingDelta <= TimingRegressionDeltaMilliseconds)
        {
            return "Windows input delivery became slower while scheduler timing stayed comparatively stable. Close heavy background workloads, rerun Test Roblox Input, then reproduce before blaming the playback engine.";
        }

        if (timingDelta > TimingRegressionDeltaMilliseconds && inputDelta <= InputRegressionDeltaMilliseconds)
        {
            return "Scheduler timing became worse while Windows input-call latency stayed comparatively stable. Reproduce once more and retain the verified Support Bundle for Legacy/Legacy x2 A/B investigation.";
        }

        return "Both scheduler timing and Windows input delivery worsened. Reduce system load, keep Roblox focused, rerun input verification, and reproduce before attributing the change to the playback engine.";
    }
}
