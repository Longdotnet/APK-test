using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class AudioTranscriptionRepairAwareQualityRegression
{
    [ModuleInitializer]
    internal static void RunPhase40Regressions()
    {
        Run("repair-aware quality recomputes mutable canonical metrics", MutableTrackEvidenceCanRecover);
        Run("repair-aware quality keeps immutable source warnings", ImmutableSourceWarningSurvives);
        Run("repair-aware quality keeps immutable source rejection", ImmutableSourceCriticalSurvives);
        Run("repair-aware quality fails closed on unknown rejected reasons", UnknownRejectedReasonIsSticky);
        Run("repair session publishes recomputed quality and revert restores base", SessionApplyAndRevertQuality);
    }

    private static void MutableTrackEvidenceCanRecover()
    {
        var quality = new AudioTranscriptionRepairAwareQualityEvaluator().Evaluate(
            TimeSpan.FromSeconds(2),
            4,
            TrackWithVoices(3),
            BaseQuality(AudioTranscriptionReadiness.NeedsReview, "EVENT_DENSITY_HIGH"),
            QualityOptions());

        Equal(AudioTranscriptionReadiness.Ready, quality.Readiness);
        Near(0.75d, quality.RetentionRatio);
        Near(0.25d, quality.TransformLossRatio);
        Near(0.90d, quality.TimelineCoverage);
        Near(1.50d, quality.EventsPerSecond);
        Equal(0, quality.Reasons.Count);
    }

    private static void ImmutableSourceWarningSurvives()
    {
        var quality = new AudioTranscriptionRepairAwareQualityEvaluator().Evaluate(
            TimeSpan.FromSeconds(2),
            4,
            TrackWithVoices(3),
            BaseQuality(AudioTranscriptionReadiness.NeedsReview, "MEAN_ACTIVATION_LOW"),
            QualityOptions());

        Equal(AudioTranscriptionReadiness.NeedsReview, quality.Readiness);
        True(quality.Reasons.SequenceEqual(["MEAN_ACTIVATION_LOW"]));
        Near(0.40d, quality.MeanActivation);
    }

    private static void ImmutableSourceCriticalSurvives()
    {
        var quality = new AudioTranscriptionRepairAwareQualityEvaluator().Evaluate(
            TimeSpan.FromSeconds(2),
            4,
            TrackWithVoices(3),
            BaseQuality(AudioTranscriptionReadiness.Rejected, "HARMONIC_ARTIFACTS_CRITICAL"),
            QualityOptions());

        Equal(AudioTranscriptionReadiness.Rejected, quality.Readiness);
        True(quality.Reasons.Contains("HARMONIC_ARTIFACTS_CRITICAL", StringComparer.Ordinal));
    }

    private static void UnknownRejectedReasonIsSticky()
    {
        var quality = new AudioTranscriptionRepairAwareQualityEvaluator().Evaluate(
            TimeSpan.FromSeconds(2),
            4,
            TrackWithVoices(3),
            BaseQuality(AudioTranscriptionReadiness.Rejected, "FUTURE_SOURCE_CRITICAL"),
            QualityOptions());

        Equal(AudioTranscriptionReadiness.Rejected, quality.Readiness);
        True(quality.Reasons.Contains("FUTURE_SOURCE_CRITICAL", StringComparer.Ordinal));
    }

    private static void SessionApplyAndRevertQuality()
    {
        var notes = new[]
        {
            Note(1.00, 1.80, 60, 0.80f),
            Note(1.00, 1.80, 64, 0.85f),
            Note(1.00, 1.80, 67, 0.90f),
            Note(1.00, 1.80, 72, 0.95f)
        };
        var canonical = new RobloxPianoArranger().Arrange(
            "phase40",
            notes,
            new RobloxPianoArrangementOptions(MaxSimultaneousNotes: 4)).Track;
        var baseQuality = BaseQuality(AudioTranscriptionReadiness.NeedsReview, "EVENT_DENSITY_HIGH");
        var session = new AudioTranscriptionReviewRepairSession(
            TimeSpan.FromSeconds(2),
            notes,
            canonical,
            new AudioTranscriptionReviewRepairSessionOptions(
                ReviewRegions: new AudioTranscriptionReviewRegionOptions(HighSimultaneousNotes: 3),
                Repair: new AudioTranscriptionReviewRepairOptions(SimplifiedHarmonyMaxSimultaneousNotes: 3),
                Quality: QualityOptions()),
            baseQuality: baseQuality);

        Equal(AudioTranscriptionReadiness.NeedsReview, session.CurrentQuality!.Readiness);
        var region = session.ReviewRegions.Single();
        var applied = session.Apply(region, AudioTranscriptionReviewRepairKind.SimplifiedHarmony);

        Equal(0, session.ReviewRegions.Count);
        Equal(AudioTranscriptionReadiness.Ready, session.CurrentQuality!.Readiness);
        Equal(AudioTranscriptionReadiness.Ready, applied.Quality!.Readiness);
        Near(0.75d, session.CurrentQuality.RetentionRatio);

        True(session.Revert());
        Equal(AudioTranscriptionReadiness.NeedsReview, session.CurrentQuality!.Readiness);
        True(session.CurrentQuality.Reasons.SequenceEqual(["EVENT_DENSITY_HIGH"]));
        Equal(1, session.ReviewRegions.Count);
    }

    private static AudioTranscriptionQualityOptions QualityOptions() => new(
        MinimumReadyRetentionRatio: 0.70,
        MaximumReadyLossRatio: 0.30,
        MinimumReadyTimelineCoverage: 0.50,
        MinimumReadyEventsPerSecond: 0.50,
        MaximumReadyEventsPerSecond: 1.60,
        RejectBelowRetentionRatio: 0.10,
        RejectBelowTimelineCoverage: 0.10,
        RejectAboveEventsPerSecond: 10.0);

    private static AudioTranscriptionQualityAssessment BaseQuality(
        AudioTranscriptionReadiness readiness,
        params string[] reasons) => new(
        readiness,
        RetentionRatio: 1d,
        TransformLossRatio: 0d,
        LowActivationRatio: 0.10d,
        OctaveFoldRatio: 0d,
        TimelineCoverage: 0.90d,
        EventsPerSecond: 2d,
        HarmonicSuppressionRatio: readiness == AudioTranscriptionReadiness.Rejected ? 0.60d : 0.05d,
        MeanActivation: 0.40f,
        Reasons: reasons);

    private static PerformanceTrack TrackWithVoices(int voices)
    {
        var keys = new[] { 'a', 's', 'd', 'f' };
        var events = Enumerable.Range(0, voices)
            .Select(index => new PerformanceEvent(
                TimeSpan.FromSeconds(1),
                TimeSpan.FromSeconds(0.8),
                new[] { keys[index] }))
            .ToArray();
        return new PerformanceTrack(
            "phase40-quality",
            120d,
            480,
            TimeSpan.Zero,
            events,
            TimeSpan.FromSeconds(1.8));
    }

    private static BasicPitchTranscribedNote Note(double start, double end, int midi, float amplitude) =>
        new(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(end), midi, amplitude);

    private static void Run(string name, Action action)
    {
        try
        {
            action();
            Console.WriteLine($"PASS {name}");
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"FAIL {name}: {exception}");
            Environment.ExitCode = 1;
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, got {actual}.");
    }

    private static void Near(double expected, double actual)
    {
        if (Math.Abs(expected - actual) > 0.000001d)
            throw new InvalidOperationException($"Expected {expected:R}, got {actual:R}.");
    }

    private static void True(bool value)
    {
        if (!value)
            throw new InvalidOperationException("Expected condition to be true.");
    }
}
