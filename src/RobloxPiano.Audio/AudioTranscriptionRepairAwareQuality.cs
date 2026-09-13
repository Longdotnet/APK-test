using RobloxPiano.Core;

namespace RobloxPiano.Audio;

/// <summary>
/// Re-evaluates only quality evidence that can legitimately change after an explicit review repair.
/// Source/model evidence such as activation confidence and harmonic-suppression pressure remains immutable,
/// while retention, canonical transform loss, timeline coverage and event density are derived from the
/// current canonical PerformanceTrack. Unknown original reasons fail closed instead of being silently erased.
/// </summary>
public sealed class AudioTranscriptionRepairAwareQualityEvaluator
{
    private static readonly HashSet<string> MutableReasonCodes = new(StringComparer.Ordinal)
    {
        "RETENTION_CRITICAL",
        "RETENTION_LOW",
        "ARRANGEMENT_LOSS_HIGH",
        "TIMELINE_COVERAGE_CRITICAL",
        "TIMELINE_COVERAGE_LOW",
        "EVENT_DENSITY_CRITICAL",
        "EVENT_DENSITY_SPARSE",
        "EVENT_DENSITY_HIGH"
    };

    private static readonly HashSet<string> ImmutableCriticalReasonCodes = new(StringComparer.Ordinal)
    {
        "ACTIVATION_CRITICAL",
        "HARMONIC_ARTIFACTS_CRITICAL"
    };

    public AudioTranscriptionQualityAssessment Evaluate(
        TimeSpan sourceDuration,
        int sourceNoteCount,
        PerformanceTrack canonicalTrack,
        AudioTranscriptionQualityAssessment baseQuality,
        AudioTranscriptionQualityOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        if (sourceDuration <= TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(sourceDuration));
        if (sourceNoteCount <= 0)
            throw new ArgumentOutOfRangeException(nameof(sourceNoteCount));
        ArgumentNullException.ThrowIfNull(canonicalTrack);
        ArgumentNullException.ThrowIfNull(baseQuality);
        if (canonicalTrack.Events.Count == 0)
            throw new ArgumentException("Repair-aware quality requires a non-empty canonical performance.", nameof(canonicalTrack));

        options ??= new AudioTranscriptionQualityOptions();
        options.Validate();
        cancellationToken.ThrowIfCancellationRequested();

        long voiceCount = 0;
        var actualTimeline = TimeSpan.Zero;
        foreach (var performanceEvent in canonicalTrack.Events)
        {
            cancellationToken.ThrowIfCancellationRequested();
            if (performanceEvent.Start < TimeSpan.Zero || performanceEvent.Duration <= TimeSpan.Zero)
                throw new InvalidDataException("Canonical performance contains an invalid event timeline.");
            if (performanceEvent.Keys.Count == 0)
                throw new InvalidDataException("Canonical performance contains an event with no piano keys.");

            voiceCount = checked(voiceCount + performanceEvent.Keys.Count);
            var end = performanceEvent.Start + performanceEvent.Duration;
            if (end > actualTimeline)
                actualTimeline = end;
        }

        if (voiceCount <= 0)
            throw new InvalidDataException("Canonical performance contains no playable note voices.");

        var retention = Math.Clamp(voiceCount / (double)sourceNoteCount, 0d, 1d);
        var transformLoss = Math.Clamp(1d - retention, 0d, 1d);
        var coverage = Math.Clamp(actualTimeline.TotalSeconds / sourceDuration.TotalSeconds, 0d, 1d);
        var eventsPerSecond = voiceCount / sourceDuration.TotalSeconds;

        var reasons = baseQuality.Reasons
            .Where(reason => !MutableReasonCodes.Contains(reason))
            .Distinct(StringComparer.Ordinal)
            .ToList();

        // An unrecognized rejected reason is intentionally sticky. New quality reasons may be added by
        // future phases; repair-aware evaluation must not accidentally promote them before they are classified.
        var unknownRejectedReason = baseQuality.Readiness == AudioTranscriptionReadiness.Rejected
            && baseQuality.Reasons.Any(reason =>
                !MutableReasonCodes.Contains(reason)
                && !ImmutableCriticalReasonCodes.Contains(reason));

        var rejected = unknownRejectedReason || reasons.Any(ImmutableCriticalReasonCodes.Contains);

        if (retention < options.RejectBelowRetentionRatio)
        {
            rejected = true;
            AddReason(reasons, "RETENTION_CRITICAL");
        }
        if (coverage < options.RejectBelowTimelineCoverage)
        {
            rejected = true;
            AddReason(reasons, "TIMELINE_COVERAGE_CRITICAL");
        }
        if (eventsPerSecond > options.RejectAboveEventsPerSecond)
        {
            rejected = true;
            AddReason(reasons, "EVENT_DENSITY_CRITICAL");
        }

        if (!rejected)
        {
            if (retention < options.MinimumReadyRetentionRatio)
                AddReason(reasons, "RETENTION_LOW");
            if (transformLoss > options.MaximumReadyLossRatio)
                AddReason(reasons, "ARRANGEMENT_LOSS_HIGH");
            if (coverage < options.MinimumReadyTimelineCoverage)
                AddReason(reasons, "TIMELINE_COVERAGE_LOW");
            if (eventsPerSecond < options.MinimumReadyEventsPerSecond)
                AddReason(reasons, "EVENT_DENSITY_SPARSE");
            if (eventsPerSecond > options.MaximumReadyEventsPerSecond)
                AddReason(reasons, "EVENT_DENSITY_HIGH");
        }

        var readiness = rejected
            ? AudioTranscriptionReadiness.Rejected
            : reasons.Count == 0
                ? AudioTranscriptionReadiness.Ready
                : AudioTranscriptionReadiness.NeedsReview;

        return new AudioTranscriptionQualityAssessment(
            readiness,
            retention,
            transformLoss,
            baseQuality.LowActivationRatio,
            baseQuality.OctaveFoldRatio,
            coverage,
            eventsPerSecond,
            baseQuality.HarmonicSuppressionRatio,
            baseQuality.MeanActivation,
            reasons.AsReadOnly());
    }

    private static void AddReason(List<string> reasons, string reason)
    {
        if (!reasons.Contains(reason, StringComparer.Ordinal))
            reasons.Add(reason);
    }
}
