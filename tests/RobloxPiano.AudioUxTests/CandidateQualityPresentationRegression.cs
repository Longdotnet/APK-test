using System.Runtime.CompilerServices;
using RobloxPiano.App;
using RobloxPiano.Audio;

namespace RobloxPiano.AudioUxTests;

internal static class CandidateQualityPresentationRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var before = Quality(AudioTranscriptionReadiness.NeedsReview, 0.58, 0.34, 0.74, 16.2, ["EVENT_DENSITY_HIGH"]);
        var melody = Quality(AudioTranscriptionReadiness.Ready, 0.76, 0.18, 0.84, 6.8, []);
        var harmony = Quality(AudioTranscriptionReadiness.NeedsReview, 0.83, 0.22, 0.82, 9.4, ["EVENT_DENSITY_HIGH"]);

        var melodyEvidence = Candidate(
            AudioTranscriptionReviewRepairKind.MelodyPriority,
            melody,
            AudioTranscriptionQualityDeltaEvaluator.Compare(before, melody),
            selectedRegionResolved: true,
            remainingRegions: 0);
        var harmonyEvidence = Candidate(
            AudioTranscriptionReviewRepairKind.SimplifiedHarmony,
            harmony,
            AudioTranscriptionQualityDeltaEvaluator.Compare(before, harmony),
            selectedRegionResolved: false,
            remainingRegions: 1);
        var recommendation = AudioTranscriptionReviewRepairRecommendationEvaluator.Recommend(
            [harmonyEvidence, melodyEvidence],
            sessionRevision: 4);
        var region = new AudioTranscriptionReviewRegion(
            TimeSpan.FromSeconds(12),
            TimeSpan.FromSeconds(17),
            SourceNotes: 24,
            ArrangedEvents: 18,
            MeanActivation: 0.66f,
            RetentionRatio: 0.58,
            EventsPerSecond: 16.2,
            PeakSimultaneousNotes: 7,
            Reasons: ["EVENT_DENSITY_HIGH"]);

        var text = AudioRepairQualityPresenter.FormatRecommendation(recommendation, region);
        Contains("Next flagged region 00:12–00:17", text);
        Contains("Recommended MelodyPriority: Ready", text);
        Contains("density 16.2 → 6.8 events/s", text);
        Contains("retention 58% → 76%", text);
        Contains("selected region resolved", text);
        Contains("SimplifiedHarmony: NeedsReview", text);
        Contains("selected region still flagged", text);
        Contains("Apply remains explicit", text);
    }

    private static AudioTranscriptionReviewRepairCandidateQuality Candidate(
        AudioTranscriptionReviewRepairKind kind,
        AudioTranscriptionQualityAssessment quality,
        AudioTranscriptionQualityDelta delta,
        bool selectedRegionResolved,
        int remainingRegions)
    {
        var candidate = new AudioTranscriptionReviewRepairCandidate(
            kind,
            Track: null!,
            SourceNotes: 12,
            OriginalRegionEvents: 10,
            CandidateRegionEvents: 6,
            PeakSimultaneousNotes: kind == AudioTranscriptionReviewRepairKind.MelodyPriority ? 1 : 3,
            TargetReasons: ["EVENT_DENSITY_HIGH"]);
        var regions = Enumerable.Range(0, remainingRegions)
            .Select(index => new AudioTranscriptionReviewRegion(
                TimeSpan.FromSeconds(20 + index * 5),
                TimeSpan.FromSeconds(25 + index * 5),
                SourceNotes: 8,
                ArrangedEvents: 6,
                MeanActivation: 0.7f,
                RetentionRatio: 0.7,
                EventsPerSecond: 8,
                PeakSimultaneousNotes: 3,
                Reasons: ["EVENT_DENSITY_HIGH"]))
            .ToArray();
        return new AudioTranscriptionReviewRepairCandidateQuality(
            candidate,
            quality,
            delta,
            regions,
            selectedRegionResolved,
            SessionRevision: 4);
    }

    private static AudioTranscriptionQualityAssessment Quality(
        AudioTranscriptionReadiness readiness,
        double retention,
        double loss,
        double coverage,
        double density,
        IReadOnlyList<string> reasons)
        => new(
            readiness,
            retention,
            loss,
            LowActivationRatio: 0.10,
            OctaveFoldRatio: 0.05,
            coverage,
            density,
            HarmonicSuppressionRatio: 0.05,
            MeanActivation: 0.70f,
            reasons);

    private static void Contains(string expected, string actual)
    {
        if (!actual.Contains(expected, StringComparison.Ordinal))
            throw new InvalidOperationException($"expected '{expected}' in '{actual}'");
    }
}
