using RobloxPiano.Audio;

namespace RobloxPiano.App;

internal sealed record AudioRepairQualityPresentation(
    string Summary,
    AudioTranscriptionReadiness Readiness,
    bool Improved,
    bool Regressed);

internal static class AudioRepairQualityPresenter
{
    public static AudioRepairQualityPresentation From(AudioTranscriptionReviewRepairSession session)
    {
        ArgumentNullException.ThrowIfNull(session);
        _ = session.CurrentQuality
            ?? throw new InvalidOperationException("Repair quality presentation requires authoritative current quality.");
        var delta = session.CompareCurrent()
            ?? throw new InvalidOperationException("Repair quality presentation requires an immutable base quality assessment.");
        var presentation = From(delta);

        if (session.ReviewRegions.Count == 0)
            return presentation;

        var nextRegion = session.ReviewRegions[0];
        var recommendation = session.RecommendCandidate(nextRegion);
        return presentation with
        {
            Summary = presentation.Summary + Environment.NewLine + FormatRecommendation(recommendation, nextRegion)
        };
    }

    internal static AudioRepairQualityPresentation From(AudioTranscriptionQualityDelta delta)
    {
        ArgumentNullException.ThrowIfNull(delta);
        var transition = delta.ReadinessChanged
            ? $"{delta.Before.Readiness} → {delta.Current.Readiness}"
            : delta.Current.Readiness.ToString();
        var resolved = FormatReasons(delta.ResolvedReasons, "none");
        var persistent = FormatReasons(delta.PersistentReasons, "none");
        var introduced = FormatReasons(delta.IntroducedReasons, "none");

        var summary =
            $"Quality: {transition} • retention {delta.Before.RetentionRatio:P0} → {delta.Current.RetentionRatio:P0} • " +
            $"loss {delta.Before.TransformLossRatio:P0} → {delta.Current.TransformLossRatio:P0} • " +
            $"coverage {delta.Before.TimelineCoverage:P0} → {delta.Current.TimelineCoverage:P0} • " +
            $"density {delta.Before.EventsPerSecond:0.0} → {delta.Current.EventsPerSecond:0.0} events/s{Environment.NewLine}" +
            $"Resolved: {resolved} • Persistent: {persistent} • Introduced: {introduced}";

        return new AudioRepairQualityPresentation(
            summary,
            delta.Current.Readiness,
            delta.ImprovedReadiness,
            delta.RegressedReadiness);
    }

    internal static string FormatRecommendation(
        AudioTranscriptionReviewRepairRecommendation recommendation,
        AudioTranscriptionReviewRegion region)
    {
        ArgumentNullException.ThrowIfNull(recommendation);
        ArgumentNullException.ThrowIfNull(region);
        if (recommendation.Candidates.Count == 0)
            throw new ArgumentException("Candidate recommendation must contain at least one candidate.", nameof(recommendation));

        var candidateSummaries = recommendation.Candidates
            .Select(candidate => FormatCandidate(candidate, ReferenceEquals(candidate, recommendation.Recommended)))
            .ToArray();
        return
            $"Next flagged region {FormatTime(region.Start)}–{FormatTime(region.End)} • " +
            $"deterministic recommendation only; Apply remains explicit.{Environment.NewLine}" +
            string.Join(Environment.NewLine, candidateSummaries);
    }

    private static string FormatCandidate(
        AudioTranscriptionReviewRepairCandidateQuality candidate,
        bool recommended)
    {
        var marker = recommended ? "Recommended " : string.Empty;
        var resolved = candidate.DeltaFromCurrent.ResolvedReasons.Count;
        var introduced = candidate.DeltaFromCurrent.IntroducedReasons.Count;
        var regionOutcome = candidate.SelectedRegionResolved ? "selected region resolved" : "selected region still flagged";
        return
            $"{marker}{candidate.Candidate.Kind}: {candidate.Quality.Readiness} • " +
            $"density {candidate.DeltaFromCurrent.Before.EventsPerSecond:0.0} → {candidate.Quality.EventsPerSecond:0.0} events/s • " +
            $"retention {candidate.DeltaFromCurrent.Before.RetentionRatio:P0} → {candidate.Quality.RetentionRatio:P0} • " +
            $"loss {candidate.DeltaFromCurrent.Before.TransformLossRatio:P0} → {candidate.Quality.TransformLossRatio:P0} • " +
            $"resolved {resolved} • introduced {introduced} • {regionOutcome} • " +
            $"{candidate.RemainingReviewRegions.Count} review region(s) would remain.";
    }

    private static string FormatReasons(IReadOnlyList<string> reasons, string empty)
        => reasons.Count == 0 ? empty : string.Join(", ", reasons);

    private static string FormatTime(TimeSpan value)
        => value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");
}
