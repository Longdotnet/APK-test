namespace RobloxPiano.Audio;

/// <summary>
/// Deterministic before/current quality comparison for an explicit transcription repair session.
/// This is presentation evidence only: it never mutates the canonical PerformanceTrack or changes readiness.
/// The current assessment remains authoritative and source/model reasons remain visible when they persist.
/// </summary>
public sealed record AudioTranscriptionQualityDelta(
    AudioTranscriptionQualityAssessment Before,
    AudioTranscriptionQualityAssessment Current,
    IReadOnlyList<string> ResolvedReasons,
    IReadOnlyList<string> PersistentReasons,
    IReadOnlyList<string> IntroducedReasons)
{
    public double RetentionDelta => Current.RetentionRatio - Before.RetentionRatio;
    public double TransformLossDelta => Current.TransformLossRatio - Before.TransformLossRatio;
    public double TimelineCoverageDelta => Current.TimelineCoverage - Before.TimelineCoverage;
    public double EventsPerSecondDelta => Current.EventsPerSecond - Before.EventsPerSecond;
    public bool ReadinessChanged => Before.Readiness != Current.Readiness;
    public bool ImprovedReadiness => Rank(Current.Readiness) < Rank(Before.Readiness);
    public bool RegressedReadiness => Rank(Current.Readiness) > Rank(Before.Readiness);

    private static int Rank(AudioTranscriptionReadiness readiness) => readiness switch
    {
        AudioTranscriptionReadiness.Ready => 0,
        AudioTranscriptionReadiness.NeedsReview => 1,
        AudioTranscriptionReadiness.Rejected => 2,
        _ => throw new ArgumentOutOfRangeException(nameof(readiness), readiness, null)
    };
}

/// <summary>
/// Produces a stable quality delta from immutable assessments. Reason transitions are set-based and sorted
/// ordinally so UI/log presentation cannot depend on upstream collection ordering.
/// </summary>
public static class AudioTranscriptionQualityDeltaEvaluator
{
    public static AudioTranscriptionQualityDelta Compare(
        AudioTranscriptionQualityAssessment before,
        AudioTranscriptionQualityAssessment current)
    {
        ArgumentNullException.ThrowIfNull(before);
        ArgumentNullException.ThrowIfNull(current);

        var beforeReasons = Normalize(before.Reasons);
        var currentReasons = Normalize(current.Reasons);
        var beforeSet = beforeReasons.ToHashSet(StringComparer.Ordinal);
        var currentSet = currentReasons.ToHashSet(StringComparer.Ordinal);

        var resolved = beforeReasons.Where(reason => !currentSet.Contains(reason)).ToArray();
        var persistent = beforeReasons.Where(currentSet.Contains).ToArray();
        var introduced = currentReasons.Where(reason => !beforeSet.Contains(reason)).ToArray();

        return new AudioTranscriptionQualityDelta(
            before,
            current,
            Array.AsReadOnly(resolved),
            Array.AsReadOnly(persistent),
            Array.AsReadOnly(introduced));
    }

    public static AudioTranscriptionQualityDelta? CompareCurrent(
        this AudioTranscriptionReviewRepairSession session)
    {
        ArgumentNullException.ThrowIfNull(session);
        return session.BaseQuality is null || session.CurrentQuality is null
            ? null
            : Compare(session.BaseQuality, session.CurrentQuality);
    }

    private static string[] Normalize(IReadOnlyList<string> reasons)
    {
        ArgumentNullException.ThrowIfNull(reasons);
        if (reasons.Any(string.IsNullOrWhiteSpace))
            throw new ArgumentException("Quality reasons cannot contain blank values.", nameof(reasons));

        return reasons
            .Distinct(StringComparer.Ordinal)
            .Order(StringComparer.Ordinal)
            .ToArray();
    }
}
