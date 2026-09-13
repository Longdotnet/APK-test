namespace RobloxPiano.Audio;

/// <summary>
/// Side-effect-free quality evidence for one deterministic review repair candidate.
/// The candidate remains derived state only; this record does not authorize Apply, Library persistence,
/// or Roblox playback.
/// </summary>
public sealed record AudioTranscriptionReviewRepairCandidateQuality(
    AudioTranscriptionReviewRepairCandidate Candidate,
    AudioTranscriptionQualityAssessment Quality,
    AudioTranscriptionQualityDelta DeltaFromCurrent,
    IReadOnlyList<AudioTranscriptionReviewRegion> RemainingReviewRegions,
    bool SelectedRegionResolved,
    long SessionRevision);

/// <summary>
/// Deterministic presentation-only recommendation across the candidates available for one current review region.
/// Recommendation never mutates the repair session. Explicit Apply remains the only canonical mutation path.
/// </summary>
public sealed record AudioTranscriptionReviewRepairRecommendation(
    AudioTranscriptionReviewRepairCandidateQuality Recommended,
    IReadOnlyList<AudioTranscriptionReviewRepairCandidateQuality> Candidates,
    long SessionRevision);

public static class AudioTranscriptionReviewRepairRecommendationEvaluator
{
    public static AudioTranscriptionReviewRepairRecommendation Recommend(
        IReadOnlyList<AudioTranscriptionReviewRepairCandidateQuality> candidates,
        long sessionRevision)
    {
        ArgumentNullException.ThrowIfNull(candidates);
        if (candidates.Count == 0)
            throw new ArgumentException("At least one repair candidate quality assessment is required.", nameof(candidates));
        if (candidates.Any(candidate => candidate.SessionRevision != sessionRevision))
            throw new InvalidOperationException("Repair candidate quality evidence belongs to a stale session revision.");

        var ordered = candidates
            .OrderBy(candidate => ReadinessRank(candidate.Quality.Readiness))
            .ThenByDescending(candidate => candidate.SelectedRegionResolved)
            .ThenBy(candidate => candidate.RemainingReviewRegions.Count)
            .ThenBy(candidate => candidate.DeltaFromCurrent.IntroducedReasons.Count)
            .ThenByDescending(candidate => candidate.DeltaFromCurrent.ResolvedReasons.Count)
            .ThenByDescending(candidate => candidate.Quality.RetentionRatio)
            .ThenBy(candidate => candidate.Quality.TransformLossRatio)
            .ThenByDescending(candidate => candidate.Quality.TimelineCoverage)
            .ThenBy(candidate => candidate.Candidate.PeakSimultaneousNotes)
            .ThenBy(candidate => candidate.Candidate.Kind)
            .ToArray();

        return new AudioTranscriptionReviewRepairRecommendation(
            ordered[0],
            Array.AsReadOnly(ordered),
            sessionRevision);
    }

    private static int ReadinessRank(AudioTranscriptionReadiness readiness) => readiness switch
    {
        AudioTranscriptionReadiness.Ready => 0,
        AudioTranscriptionReadiness.NeedsReview => 1,
        AudioTranscriptionReadiness.Rejected => 2,
        _ => throw new ArgumentOutOfRangeException(nameof(readiness), readiness, null)
    };
}
