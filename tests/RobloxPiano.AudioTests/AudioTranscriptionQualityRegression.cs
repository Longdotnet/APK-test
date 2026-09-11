using RobloxPiano.Audio;

internal static class AudioTranscriptionQualityRegression
{
    public static void CleanArrangementIsReady()
    {
        var assessment = Evaluate(
            sourceDurationSeconds: 10,
            arrangedTimelineSeconds: 9.5,
            Diagnostics(sourceNotes: 20, arrangedEvents: 18, meanActivation: 0.72f));

        Equal(AudioTranscriptionReadiness.Ready, assessment.Readiness);
        True(!assessment.RequiresReview);
        True(assessment.RetentionRatio > 0.85);
        True(assessment.Reasons.Count == 0);
    }

    public static void LossyArrangementRequiresReview()
    {
        var assessment = Evaluate(
            sourceDurationSeconds: 10,
            arrangedTimelineSeconds: 8,
            Diagnostics(
                sourceNotes: 20,
                arrangedEvents: 11,
                densityDrops: 6,
                lowActivationEvents: 5,
                meanActivation: 0.40f));

        Equal(AudioTranscriptionReadiness.NeedsReview, assessment.Readiness);
        True(assessment.RequiresReview);
        True(assessment.Reasons.Contains("ARRANGEMENT_LOSS_HIGH"));
        True(assessment.Reasons.Contains("LOW_ACTIVATION_HIGH"));
        True(assessment.Reasons.Contains("MEAN_ACTIVATION_LOW"));
    }

    public static void CriticalCoverageIsRejected()
    {
        var assessment = Evaluate(
            sourceDurationSeconds: 30,
            arrangedTimelineSeconds: 1,
            Diagnostics(sourceNotes: 30, arrangedEvents: 20, meanActivation: 0.70f));

        Equal(AudioTranscriptionReadiness.Rejected, assessment.Readiness);
        True(assessment.Reasons.Contains("TIMELINE_COVERAGE_CRITICAL"));
    }

    public static void ExtremeEventDensityIsRejected()
    {
        var assessment = Evaluate(
            sourceDurationSeconds: 2,
            arrangedTimelineSeconds: 2,
            Diagnostics(sourceNotes: 80, arrangedEvents: 70, meanActivation: 0.75f));

        Equal(AudioTranscriptionReadiness.Rejected, assessment.Readiness);
        True(assessment.EventsPerSecond > 30);
        True(assessment.Reasons.Contains("EVENT_DENSITY_CRITICAL"));
    }

    public static void InvalidThresholdsFailClosed()
    {
        var evaluator = new AudioTranscriptionQualityEvaluator();
        var options = new AudioTranscriptionQualityOptions(
            MinimumReadyEventsPerSecond: 20,
            MaximumReadyEventsPerSecond: 10);

        Throws<ArgumentOutOfRangeException>(() => evaluator.Evaluate(
            TimeSpan.FromSeconds(5),
            Diagnostics(sourceNotes: 10, arrangedEvents: 8, meanActivation: 0.7f),
            TimeSpan.FromSeconds(5),
            options));
    }

    private static AudioTranscriptionQualityAssessment Evaluate(
        double sourceDurationSeconds,
        double arrangedTimelineSeconds,
        RobloxPianoArrangementDiagnostics diagnostics)
    {
        return new AudioTranscriptionQualityEvaluator().Evaluate(
            TimeSpan.FromSeconds(sourceDurationSeconds),
            diagnostics,
            TimeSpan.FromSeconds(arrangedTimelineSeconds));
    }

    private static RobloxPianoArrangementDiagnostics Diagnostics(
        int sourceNotes,
        int arrangedEvents,
        int octaveFoldedNotes = 0,
        int duplicatePitchMerges = 0,
        int densityDrops = 0,
        int outOfRangeDrops = 0,
        int tooShortDrops = 0,
        int sameKeyOverlapTrims = 0,
        int sameKeyOverlapDrops = 0,
        int lowActivationEvents = 0,
        float meanActivation = 0.7f)
    {
        return new RobloxPianoArrangementDiagnostics(
            sourceNotes,
            arrangedEvents,
            octaveFoldedNotes,
            duplicatePitchMerges,
            densityDrops,
            outOfRangeDrops,
            tooShortDrops,
            sameKeyOverlapTrims,
            sameKeyOverlapDrops,
            lowActivationEvents,
            meanActivation);
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
    }

    private static void True(bool condition)
    {
        if (!condition)
            throw new InvalidOperationException("Expected condition to be true.");
    }

    private static void Throws<TException>(Action action) where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }

        throw new InvalidOperationException($"Expected {typeof(TException).Name}.");
    }
}
