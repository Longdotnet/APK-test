namespace RobloxPiano.Audio;

public enum AudioTranscriptionReadiness
{
    Ready,
    NeedsReview,
    Rejected
}

public sealed record AudioTranscriptionQualityOptions(
    double MinimumReadyRetentionRatio = 0.55,
    double MaximumReadyLossRatio = 0.25,
    double MaximumReadyLowActivationRatio = 0.35,
    float MinimumReadyMeanActivation = 0.45f,
    double MinimumReadyTimelineCoverage = 0.50,
    double MinimumReadyEventsPerSecond = 0.50,
    double MaximumReadyEventsPerSecond = 16.0,
    double MaximumReadyHarmonicSuppressionRatio = 0.15,
    double RejectBelowRetentionRatio = 0.10,
    float RejectBelowMeanActivation = 0.15f,
    double RejectBelowTimelineCoverage = 0.10,
    double RejectAboveEventsPerSecond = 30.0,
    double RejectAboveHarmonicSuppressionRatio = 0.50)
{
    internal void Validate()
    {
        ValidateRatio(MinimumReadyRetentionRatio, nameof(MinimumReadyRetentionRatio));
        ValidateRatio(MaximumReadyLossRatio, nameof(MaximumReadyLossRatio));
        ValidateRatio(MaximumReadyLowActivationRatio, nameof(MaximumReadyLowActivationRatio));
        ValidateRatio(MinimumReadyTimelineCoverage, nameof(MinimumReadyTimelineCoverage));
        ValidateRatio(MaximumReadyHarmonicSuppressionRatio, nameof(MaximumReadyHarmonicSuppressionRatio));
        ValidateRatio(RejectBelowRetentionRatio, nameof(RejectBelowRetentionRatio));
        ValidateRatio(RejectBelowTimelineCoverage, nameof(RejectBelowTimelineCoverage));
        ValidateRatio(RejectAboveHarmonicSuppressionRatio, nameof(RejectAboveHarmonicSuppressionRatio));

        if (!float.IsFinite(MinimumReadyMeanActivation) || MinimumReadyMeanActivation is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MinimumReadyMeanActivation));
        if (!float.IsFinite(RejectBelowMeanActivation) || RejectBelowMeanActivation is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(RejectBelowMeanActivation));
        if (!double.IsFinite(MinimumReadyEventsPerSecond) || MinimumReadyEventsPerSecond < 0d)
            throw new ArgumentOutOfRangeException(nameof(MinimumReadyEventsPerSecond));
        if (!double.IsFinite(MaximumReadyEventsPerSecond) || MaximumReadyEventsPerSecond <= MinimumReadyEventsPerSecond)
            throw new ArgumentOutOfRangeException(nameof(MaximumReadyEventsPerSecond));
        if (!double.IsFinite(RejectAboveEventsPerSecond) || RejectAboveEventsPerSecond <= MaximumReadyEventsPerSecond)
            throw new ArgumentOutOfRangeException(nameof(RejectAboveEventsPerSecond));
        if (RejectBelowRetentionRatio > MinimumReadyRetentionRatio)
            throw new ArgumentException("Rejected retention threshold cannot exceed ready retention threshold.");
        if (RejectBelowMeanActivation > MinimumReadyMeanActivation)
            throw new ArgumentException("Rejected activation threshold cannot exceed ready activation threshold.");
        if (RejectBelowTimelineCoverage > MinimumReadyTimelineCoverage)
            throw new ArgumentException("Rejected coverage threshold cannot exceed ready coverage threshold.");
        if (RejectAboveHarmonicSuppressionRatio <= MaximumReadyHarmonicSuppressionRatio)
            throw new ArgumentException("Rejected suppression threshold must exceed ready suppression threshold.");
    }

    private static void ValidateRatio(double value, string name)
    {
        if (!double.IsFinite(value) || value is < 0d or > 1d)
            throw new ArgumentOutOfRangeException(name);
    }
}

public sealed record AudioTranscriptionQualityAssessment(
    AudioTranscriptionReadiness Readiness,
    double RetentionRatio,
    double TransformLossRatio,
    double LowActivationRatio,
    double OctaveFoldRatio,
    double TimelineCoverage,
    double EventsPerSecond,
    double HarmonicSuppressionRatio,
    float MeanActivation,
    IReadOnlyList<string> Reasons)
{
    public bool RequiresReview => Readiness != AudioTranscriptionReadiness.Ready;
}

/// <summary>
/// Deterministic quality/readiness policy for generated Audio-to-Piano arrangements.
/// It never mutates notes or playback truth: it only classifies already-produced canonical output.
/// Harmonic suppression pressure is treated as evidence that the source/model output required substantial repair,
/// not as permission to silently promote a cleaned track to Ready.
/// </summary>
public sealed class AudioTranscriptionQualityEvaluator
{
    public AudioTranscriptionQualityAssessment Evaluate(
        TimeSpan sourceDuration,
        RobloxPianoArrangementDiagnostics arrangement,
        TimeSpan arrangedTimeline,
        AudioTranscriptionQualityOptions? options = null) =>
        Evaluate(sourceDuration, arrangement, arrangedTimeline, null, options);

    public AudioTranscriptionQualityAssessment Evaluate(
        TimeSpan sourceDuration,
        RobloxPianoArrangementDiagnostics arrangement,
        TimeSpan arrangedTimeline,
        BasicPitchHarmonicSuppressionDiagnostics? harmonicSuppression,
        AudioTranscriptionQualityOptions? options = null)
    {
        if (sourceDuration <= TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(sourceDuration));
        if (arrangedTimeline < TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(arrangedTimeline));
        ArgumentNullException.ThrowIfNull(arrangement);
        if (arrangement.SourceNotes <= 0)
            throw new ArgumentException("Quality evaluation requires at least one decoded source note.", nameof(arrangement));
        if (arrangement.ArrangedEvents <= 0)
            throw new ArgumentException("Quality evaluation requires at least one arranged event.", nameof(arrangement));
        if (harmonicSuppression is { InputNotes: <= 0 })
            throw new ArgumentException("Suppression diagnostics must contain at least one input note.", nameof(harmonicSuppression));
        if (harmonicSuppression is not null
            && (harmonicSuppression.RetainedNotes < 0 || harmonicSuppression.RetainedNotes > harmonicSuppression.InputNotes))
            throw new ArgumentException("Suppression diagnostics contain an invalid retained-note count.", nameof(harmonicSuppression));

        options ??= new AudioTranscriptionQualityOptions();
        options.Validate();

        var sourceNotes = arrangement.SourceNotes;
        var retention = Math.Clamp(arrangement.ArrangedEvents / (double)sourceNotes, 0d, 1d);
        var hardLosses = arrangement.DensityDrops
            + arrangement.OutOfRangeDrops
            + arrangement.TooShortDrops
            + arrangement.SameKeyOverlapDrops;
        var lossRatio = Math.Clamp(hardLosses / (double)sourceNotes, 0d, 1d);
        var lowActivationRatio = Math.Clamp(arrangement.LowActivationEvents / (double)arrangement.ArrangedEvents, 0d, 1d);
        var octaveFoldRatio = Math.Clamp(arrangement.OctaveFoldedNotes / (double)sourceNotes, 0d, 1d);
        var coverage = Math.Clamp(arrangedTimeline.TotalSeconds / sourceDuration.TotalSeconds, 0d, 1d);
        var eventsPerSecond = arrangement.ArrangedEvents / sourceDuration.TotalSeconds;
        var suppressionRatio = harmonicSuppression is null
            ? 0d
            : Math.Clamp(harmonicSuppression.SuppressedNotes / (double)harmonicSuppression.InputNotes, 0d, 1d);

        var reasons = new List<string>();
        var rejected = false;

        if (retention < options.RejectBelowRetentionRatio)
        {
            rejected = true;
            reasons.Add("RETENTION_CRITICAL");
        }
        if (arrangement.MeanActivation < options.RejectBelowMeanActivation)
        {
            rejected = true;
            reasons.Add("ACTIVATION_CRITICAL");
        }
        if (coverage < options.RejectBelowTimelineCoverage)
        {
            rejected = true;
            reasons.Add("TIMELINE_COVERAGE_CRITICAL");
        }
        if (eventsPerSecond > options.RejectAboveEventsPerSecond)
        {
            rejected = true;
            reasons.Add("EVENT_DENSITY_CRITICAL");
        }
        if (suppressionRatio > options.RejectAboveHarmonicSuppressionRatio)
        {
            rejected = true;
            reasons.Add("HARMONIC_ARTIFACTS_CRITICAL");
        }

        if (!rejected)
        {
            if (retention < options.MinimumReadyRetentionRatio)
                reasons.Add("RETENTION_LOW");
            if (lossRatio > options.MaximumReadyLossRatio)
                reasons.Add("ARRANGEMENT_LOSS_HIGH");
            if (lowActivationRatio > options.MaximumReadyLowActivationRatio)
                reasons.Add("LOW_ACTIVATION_HIGH");
            if (arrangement.MeanActivation < options.MinimumReadyMeanActivation)
                reasons.Add("MEAN_ACTIVATION_LOW");
            if (coverage < options.MinimumReadyTimelineCoverage)
                reasons.Add("TIMELINE_COVERAGE_LOW");
            if (eventsPerSecond < options.MinimumReadyEventsPerSecond)
                reasons.Add("EVENT_DENSITY_SPARSE");
            if (eventsPerSecond > options.MaximumReadyEventsPerSecond)
                reasons.Add("EVENT_DENSITY_HIGH");
            if (suppressionRatio > options.MaximumReadyHarmonicSuppressionRatio)
                reasons.Add("HARMONIC_ARTIFACTS_HIGH");
        }

        var readiness = rejected
            ? AudioTranscriptionReadiness.Rejected
            : reasons.Count == 0
                ? AudioTranscriptionReadiness.Ready
                : AudioTranscriptionReadiness.NeedsReview;

        return new AudioTranscriptionQualityAssessment(
            readiness,
            retention,
            lossRatio,
            lowActivationRatio,
            octaveFoldRatio,
            coverage,
            eventsPerSecond,
            suppressionRatio,
            arrangement.MeanActivation,
            reasons.AsReadOnly());
    }
}
