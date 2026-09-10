namespace RobloxPiano.App;

internal enum PlaybackLegacyBaselineVariant
{
    None = 0,
    Legacy = 1,
    LegacyX2 = 2
}

internal enum PlaybackLegacyBaselineComparisonVerdict
{
    NotComparable = 0,
    StableHealthy = 1,
    LegacyX2Improved = 2,
    LegacyX2Regressed = 3,
    StableDegraded = 4,
    Interfered = 5
}

internal sealed record PlaybackLegacyBaselineComparisonAssessment(
    PlaybackLegacyBaselineComparisonVerdict Verdict,
    PlaybackLegacyBaselineVariant CurrentVariant,
    PlaybackLegacyBaselineVariant? CounterpartVariant,
    string Summary,
    string Guidance,
    string? CounterpartSessionId,
    double? LegacyX2P95TimingDeltaMilliseconds,
    double? LegacyX2MaxInputCallDeltaMilliseconds)
{
    public bool HasCounterpart => !string.IsNullOrWhiteSpace(CounterpartSessionId);
}

/// <summary>
/// Controlled runtime-quality comparison for the preserved Legacy and Legacy x2 playback
/// configurations. Explicit reproduction campaigns are authoritative when present; older
/// unscoped sessions retain the strict-adjacency heuristic only for backward-compatible
/// diagnostics. Runtime evidence never owns perceptual promotion truth.
/// </summary>
internal static class PlaybackLegacyBaselineComparisonPolicy
{
    internal const double SpeedTolerance = PlaybackSessionComparisonPolicy.SpeedTolerance;
    internal const double PositionToleranceSeconds = PlaybackSessionComparisonPolicy.PositionToleranceSeconds;
    internal const double MaterialDeltaMilliseconds = 3d;
    internal static readonly TimeSpan MaxCounterpartAge = TimeSpan.FromMinutes(30);

    public static PlaybackLegacyBaselineVariant Classify(PlaybackSupportSession session)
    {
        ArgumentNullException.ThrowIfNull(session);

        if (session.Quality is null
            || session.Quality.ControlEvents is null
            || session.Quality.ControlEvents.Count == 0
            || !IsLegacySourceType(session.SourceType))
        {
            return PlaybackLegacyBaselineVariant.None;
        }

        var start = session.Quality.ControlEvents[0];
        if (start.Sequence != 0
            || start.Kind != RobloxPiano.Core.PlaybackTransportControlKind.SessionStarted
            || Math.Abs(start.PositionSeconds) > PositionToleranceSeconds
            || !start.Speed.HasValue
            || !double.IsFinite(start.Speed.Value))
        {
            return PlaybackLegacyBaselineVariant.None;
        }

        if (Near(session.PreferredSpeed, 1d) && Near(start.Speed.Value, 1d))
        {
            return PlaybackLegacyBaselineVariant.Legacy;
        }

        if (Near(session.PreferredSpeed, 2d) && Near(start.Speed.Value, 2d))
        {
            return PlaybackLegacyBaselineVariant.LegacyX2;
        }

        return PlaybackLegacyBaselineVariant.None;
    }

    public static PlaybackLegacyBaselineComparisonAssessment CompareWithMostRecentCounterpart(
        PlaybackSupportSession current,
        IReadOnlyList<PlaybackSupportSession> sessions)
    {
        ArgumentNullException.ThrowIfNull(current);
        ArgumentNullException.ThrowIfNull(sessions);

        var currentVariant = Classify(current);
        if (currentVariant == PlaybackLegacyBaselineVariant.None)
        {
            return NotComparable(currentVariant,
                "This session is not a controlled Legacy or Legacy x2 baseline run.",
                "Use an unchanged TXT/VPS canonical performance starting at exactly 1.0x for Legacy or 2.0x for Legacy x2. MIDI/MusicXML and arbitrary speeds are intentionally outside this baseline comparison.");
        }

        var counterpartVariant = currentVariant == PlaybackLegacyBaselineVariant.Legacy
            ? PlaybackLegacyBaselineVariant.LegacyX2
            : PlaybackLegacyBaselineVariant.Legacy;
        var campaignId = PlaybackBaselineCampaignStore.TryGetCampaignId(current.SessionId);

        PlaybackSupportSession? priorBaseline;
        if (campaignId is not null)
        {
            // Explicit provenance is stronger than temporal adjacency. Only sessions tagged by
            // the same deliberately started campaign may participate; unrelated sessions between
            // the pair are irrelevant and historical sessions can never be cherry-picked in.
            priorBaseline = sessions
                .Where(candidate => !ReferenceEquals(candidate, current))
                .Where(candidate => candidate.EndedAtUtc < current.EndedAtUtc)
                .Where(candidate => string.Equals(
                    PlaybackBaselineCampaignStore.TryGetCampaignId(candidate.SessionId),
                    campaignId,
                    StringComparison.Ordinal))
                .OrderByDescending(candidate => candidate.EndedAtUtc)
                .ThenByDescending(candidate => candidate.SessionId, StringComparer.Ordinal)
                .FirstOrDefault();

            if (priorBaseline is null)
            {
                return NotComparable(currentVariant,
                    "This explicit Legacy reproduction campaign does not yet contain a prior baseline run.",
                    $"Continue campaign {ShortCampaignId(campaignId)} by running {counterpartVariant} next on the unchanged song/settings. The comparator will not fall back to unrelated historical evidence.");
            }
        }
        else
        {
            // Backward compatibility for sessions recorded before explicit campaign provenance:
            // the immediately previous protected baseline globally remains the sole candidate.
            priorBaseline = sessions
                .Where(candidate => !ReferenceEquals(candidate, current))
                .Where(candidate => candidate.EndedAtUtc < current.EndedAtUtc)
                .Where(candidate => current.EndedAtUtc - candidate.EndedAtUtc <= MaxCounterpartAge)
                .Where(candidate => Classify(candidate) != PlaybackLegacyBaselineVariant.None)
                .OrderByDescending(candidate => candidate.EndedAtUtc)
                .ThenByDescending(candidate => candidate.SessionId, StringComparer.Ordinal)
                .FirstOrDefault();

            if (priorBaseline is null)
            {
                return NotComparable(currentVariant,
                    $"No recent protected baseline run exists within {MaxCounterpartAge.TotalMinutes:0} minutes.",
                    "Start an explicit Legacy A/B campaign in Support Center, then run Legacy 1x and Legacy x2 2x on the same unchanged TXT/VPS song. Old historical sessions are intentionally not reused as experimental evidence.");
            }
        }

        if (!HasSameCampaignIdentity(current, priorBaseline))
        {
            return NotComparable(currentVariant,
                campaignId is null
                    ? "The immediately previous protected baseline belongs to a different canonical performance/runtime identity."
                    : "A session tagged with this campaign no longer matches the campaign's canonical/runtime identity.",
                campaignId is null
                    ? "Repeat Legacy 1x then Legacy x2 2x back-to-back on the same unchanged TXT/VPS song, or start an explicit campaign in Support Center."
                    : "Cancel this campaign and start a new one from the intended unchanged TXT/VPS song/settings. Campaign identity mismatches fail closed.");
        }

        if (Classify(priorBaseline) != counterpartVariant)
        {
            return NotComparable(currentVariant,
                $"The latest session in this {(campaignId is null ? "reproduction sequence" : "explicit campaign")} is another {currentVariant} run, not {counterpartVariant}.",
                $"Run {counterpartVariant} next. The comparator will not skip over the newer run to reuse older evidence.");
        }

        if (!AreControlledCounterparts(current, priorBaseline))
        {
            return NotComparable(currentVariant,
                $"The latest {counterpartVariant} run changed controlled transport conditions and cannot be paired.",
                "Repeat the pair with identical seek targets and exactly proportional 2x speed transitions. The comparator fails closed instead of falling back to older evidence.");
        }

        var counterpart = priorBaseline;
        var legacy = currentVariant == PlaybackLegacyBaselineVariant.Legacy ? current : counterpart;
        var legacyX2 = currentVariant == PlaybackLegacyBaselineVariant.LegacyX2 ? current : counterpart;
        var legacyQuality = legacy.Quality!;
        var legacyX2Quality = legacyX2.Quality!;
        var timingDelta = legacyX2Quality.P95AbsoluteTimingErrorMilliseconds
                          - legacyQuality.P95AbsoluteTimingErrorMilliseconds;
        var inputDelta = legacyX2Quality.MaxInputCallMilliseconds
                         - legacyQuality.MaxInputCallMilliseconds;

        if (IsInterfered(legacyQuality) || IsInterfered(legacyX2Quality))
        {
            return new PlaybackLegacyBaselineComparisonAssessment(
                PlaybackLegacyBaselineComparisonVerdict.Interfered,
                currentVariant,
                counterpartVariant,
                $"Legacy/Legacy x2 comparison is blocked by focus, dispatch or playback interference. Legacy x2 p95 delta {timingDelta:+0.###;-0.###;0} ms.",
                "Repeat both baseline runs with Roblox continuously focused and no unexpected dispatch loss. Interfered evidence must never promote or condemn Legacy x2.",
                counterpart.SessionId,
                timingDelta,
                inputDelta);
        }

        var legacyAssessment = PlaybackSessionQualityAssessmentPolicy.Assess(legacyQuality);
        var legacyX2Assessment = PlaybackSessionQualityAssessmentPolicy.Assess(legacyX2Quality);
        var legacyHealthy = legacyAssessment.Verdict == PlaybackSessionQualityVerdict.Healthy;
        var legacyX2Healthy = legacyX2Assessment.Verdict == PlaybackSessionQualityVerdict.Healthy;

        if (legacyHealthy && legacyX2Healthy)
        {
            return Assessment(
                PlaybackLegacyBaselineComparisonVerdict.StableHealthy,
                currentVariant,
                counterpartVariant,
                counterpart.SessionId,
                timingDelta,
                inputDelta,
                campaignId is null
                    ? "Both controlled Legacy baselines are runtime-healthy."
                    : $"Explicit campaign {ShortCampaignId(campaignId)} is runtime-healthy across both Legacy baselines.",
                "Runtime evidence is stable across Legacy and Legacy x2. Perceptual quality still requires the protected listening/reference baseline before any playback behavior is promoted.");
        }

        if (!legacyHealthy && legacyX2Healthy)
        {
            return Assessment(
                PlaybackLegacyBaselineComparisonVerdict.LegacyX2Improved,
                currentVariant,
                counterpartVariant,
                counterpart.SessionId,
                timingDelta,
                inputDelta,
                "Legacy x2 is runtime-healthier than Legacy.",
                "Repeat the controlled pair before treating the runtime improvement as durable. This does not override perceptual Legacy x2 regression protection.");
        }

        if (legacyHealthy && !legacyX2Healthy)
        {
            return Assessment(
                PlaybackLegacyBaselineComparisonVerdict.LegacyX2Regressed,
                currentVariant,
                counterpartVariant,
                counterpart.SessionId,
                timingDelta,
                inputDelta,
                $"Legacy x2 runtime quality regressed from Healthy to {legacyX2Assessment.Verdict}.",
                "Do not promote changes that depend on the x2 configuration until the controlled runtime regression is explained and the protected Legacy x2 perceptual baseline remains intact.");
        }

        var materiallyWorse = timingDelta > MaterialDeltaMilliseconds || inputDelta > MaterialDeltaMilliseconds;
        var materiallyBetter = timingDelta < -MaterialDeltaMilliseconds || inputDelta < -MaterialDeltaMilliseconds;
        var verdict = materiallyWorse
            ? PlaybackLegacyBaselineComparisonVerdict.LegacyX2Regressed
            : materiallyBetter
                ? PlaybackLegacyBaselineComparisonVerdict.LegacyX2Improved
                : PlaybackLegacyBaselineComparisonVerdict.StableDegraded;

        return Assessment(
            verdict,
            currentVariant,
            counterpartVariant,
            counterpart.SessionId,
            timingDelta,
            inputDelta,
            materiallyWorse
                ? "Both baseline runs are degraded and Legacy x2 is measurably worse at runtime."
                : materiallyBetter
                    ? "Both baseline runs are degraded but Legacy x2 is measurably better at runtime."
                    : "Both baseline runs remain degraded without a material runtime delta.",
            "Keep this evidence with the verified Support Bundle and repeat the controlled pair. Runtime timing/input evidence is diagnostic only and cannot replace perceptual baseline acceptance.");
    }

    internal static bool AreControlledCounterparts(PlaybackSupportSession left, PlaybackSupportSession right)
    {
        ArgumentNullException.ThrowIfNull(left);
        ArgumentNullException.ThrowIfNull(right);

        var leftVariant = Classify(left);
        var rightVariant = Classify(right);
        if (leftVariant == PlaybackLegacyBaselineVariant.None
            || rightVariant == PlaybackLegacyBaselineVariant.None
            || leftVariant == rightVariant
            || left.Quality is null
            || right.Quality is null
            || !HasSameCampaignIdentity(left, right))
        {
            return false;
        }

        return HaveEquivalentScaledTransportHistory(left, right);
    }

    internal static bool HasSameCampaignIdentity(PlaybackSupportSession left, PlaybackSupportSession right)
    {
        ArgumentNullException.ThrowIfNull(left);
        ArgumentNullException.ThrowIfNull(right);

        if (string.IsNullOrWhiteSpace(left.CanonicalSourceFingerprint)
            || string.IsNullOrWhiteSpace(right.CanonicalSourceFingerprint)
            || string.IsNullOrWhiteSpace(left.PlaybackEngine)
            || string.IsNullOrWhiteSpace(right.PlaybackEngine)
            || string.IsNullOrWhiteSpace(left.InputProfile)
            || string.IsNullOrWhiteSpace(right.InputProfile))
        {
            return false;
        }

        return string.Equals(left.CanonicalSourceFingerprint, right.CanonicalSourceFingerprint, StringComparison.OrdinalIgnoreCase)
               && string.Equals(left.SourceType, right.SourceType, StringComparison.OrdinalIgnoreCase)
               && string.Equals(left.PlaybackEngine, right.PlaybackEngine, StringComparison.Ordinal)
               && string.Equals(left.InputProfile, right.InputProfile, StringComparison.Ordinal)
               && left.InputLatencyMs == right.InputLatencyMs;
    }

    internal static bool HaveEquivalentScaledTransportHistory(PlaybackSupportSession left, PlaybackSupportSession right)
    {
        var leftEvents = left.Quality?.ControlEvents;
        var rightEvents = right.Quality?.ControlEvents;
        if (leftEvents is null || rightEvents is null
            || leftEvents.Count == 0 || rightEvents.Count == 0
            || leftEvents.Count != rightEvents.Count)
        {
            return false;
        }

        var leftVariant = Classify(left);
        var rightVariant = Classify(right);
        var expectedRatio = leftVariant == PlaybackLegacyBaselineVariant.LegacyX2 ? 2d : 0.5d;

        for (var index = 0; index < leftEvents.Count; index++)
        {
            var leftEvent = leftEvents[index];
            var rightEvent = rightEvents[index];
            if (leftEvent.Sequence != rightEvent.Sequence
                || leftEvent.Kind != rightEvent.Kind
                || Math.Abs(leftEvent.PositionSeconds - rightEvent.PositionSeconds) > PositionToleranceSeconds
                || !ScaledSpeedsEquivalent(leftEvent.Speed, rightEvent.Speed, expectedRatio))
            {
                return false;
            }
        }

        return true;
    }

    private static bool ScaledSpeedsEquivalent(double? left, double? right, double expectedRatio)
    {
        if (!left.HasValue || !right.HasValue)
        {
            return left.HasValue == right.HasValue;
        }

        return double.IsFinite(left.Value)
               && double.IsFinite(right.Value)
               && Math.Abs(left.Value - (right.Value * expectedRatio)) <= SpeedTolerance;
    }

    private static bool IsLegacySourceType(string sourceType)
        => sourceType.Equals("TXT", StringComparison.OrdinalIgnoreCase)
           || sourceType.Equals("VPS", StringComparison.OrdinalIgnoreCase);

    private static bool Near(double value, double expected)
        => double.IsFinite(value) && Math.Abs(value - expected) <= SpeedTolerance;

    private static bool IsInterfered(PlaybackSessionQualityDiagnostic quality)
        => quality.FocusPauseCount > 0
           || quality.UnexpectedMissingEdgeCount > 0
           || quality.FailureCount > 0;

    private static string ShortCampaignId(string campaignId)
        => campaignId.Length <= 8 ? campaignId : campaignId[..8];

    private static PlaybackLegacyBaselineComparisonAssessment NotComparable(
        PlaybackLegacyBaselineVariant currentVariant,
        string summary,
        string guidance)
        => new(
            PlaybackLegacyBaselineComparisonVerdict.NotComparable,
            currentVariant,
            null,
            summary,
            guidance,
            null,
            null,
            null);

    private static PlaybackLegacyBaselineComparisonAssessment Assessment(
        PlaybackLegacyBaselineComparisonVerdict verdict,
        PlaybackLegacyBaselineVariant currentVariant,
        PlaybackLegacyBaselineVariant counterpartVariant,
        string counterpartSessionId,
        double timingDelta,
        double inputDelta,
        string summary,
        string guidance)
        => new(
            verdict,
            currentVariant,
            counterpartVariant,
            $"{summary} Legacy x2 vs Legacy: p95 {timingDelta:+0.###;-0.###;0} ms; max input-call {inputDelta:+0.###;-0.###;0} ms.",
            guidance,
            counterpartSessionId,
            timingDelta,
            inputDelta);
}
