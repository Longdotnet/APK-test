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
        Equal(0d, assessment.HarmonicSuppressionRatio);
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

    public static void ElevatedSuppressionRequiresReview()
    {
        var assessment = Evaluate(
            sourceDurationSeconds: 10,
            arrangedTimelineSeconds: 9.5,
            Diagnostics(sourceNotes: 16, arrangedEvents: 15, meanActivation: 0.72f),
            Suppression(inputNotes: 20, suppressedNotes: 4));

        Equal(AudioTranscriptionReadiness.NeedsReview, assessment.Readiness);
        Nearly(0.20, assessment.HarmonicSuppressionRatio, 0.0001);
        True(assessment.Reasons.Contains("HARMONIC_ARTIFACTS_HIGH"));
    }

    public static void CriticalSuppressionIsRejected()
    {
        var assessment = Evaluate(
            sourceDurationSeconds: 10,
            arrangedTimelineSeconds: 9.5,
            Diagnostics(sourceNotes: 8, arrangedEvents: 8, meanActivation: 0.72f),
            Suppression(inputNotes: 20, suppressedNotes: 12));

        Equal(AudioTranscriptionReadiness.Rejected, assessment.Readiness);
        Nearly(0.60, assessment.HarmonicSuppressionRatio, 0.0001);
        True(assessment.Reasons.Contains("HARMONIC_ARTIFACTS_CRITICAL"));
    }

    public static void SuppressionAtReadyBoundaryRemainsReady()
    {
        var assessment = Evaluate(
            sourceDurationSeconds: 10,
            arrangedTimelineSeconds: 9.5,
            Diagnostics(sourceNotes: 17, arrangedEvents: 16, meanActivation: 0.72f),
            Suppression(inputNotes: 20, suppressedNotes: 3));

        Equal(AudioTranscriptionReadiness.Ready, assessment.Readiness);
        Nearly(0.15, assessment.HarmonicSuppressionRatio, 0.0001);
        True(!assessment.Reasons.Contains("HARMONIC_ARTIFACTS_HIGH"));
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

    public static void InvalidSuppressionThresholdsFailClosed()
    {
        var evaluator = new AudioTranscriptionQualityEvaluator();
        var options = new AudioTranscriptionQualityOptions(
            MaximumReadyHarmonicSuppressionRatio: 0.50,
            RejectAboveHarmonicSuppressionRatio: 0.40);

        Throws<ArgumentException>(() => evaluator.Evaluate(
            TimeSpan.FromSeconds(5),
            Diagnostics(sourceNotes: 10, arrangedEvents: 8, meanActivation: 0.7f),
            TimeSpan.FromSeconds(5),
            Suppression(inputNotes: 10, suppressedNotes: 2),
            options));
    }

    private static AudioTranscriptionQualityAssessment Evaluate(
        double sourceDurationSeconds,
        double arrangedTimelineSeconds,
        RobloxPianoArrangementDiagnostics diagnostics,
        BasicPitchHarmonicSuppressionDiagnostics? suppression = null)
    {
        var evaluator = new AudioTranscriptionQualityEvaluator();
        return suppression is null
            ? evaluator.Evaluate(
                TimeSpan.FromSeconds(sourceDurationSeconds),
                diagnostics,
                TimeSpan.FromSeconds(arrangedTimelineSeconds))
            : evaluator.Evaluate(
                TimeSpan.FromSeconds(sourceDurationSeconds),
                diagnostics,
                TimeSpan.FromSeconds(arrangedTimelineSeconds),
                suppression);
    }

    private static BasicPitchHarmonicSuppressionDiagnostics Suppression(int inputNotes, int suppressedNotes)
    {
        if (inputNotes <= 0 || suppressedNotes < 0 || suppressedNotes > inputNotes)
            throw new ArgumentOutOfRangeException();

        var candidate = new BasicPitchTranscribedNote(TimeSpan.Zero, TimeSpan.FromSeconds(1), 79, 0.2f);
        var anchor = new BasicPitchTranscribedNote(TimeSpan.Zero, TimeSpan.FromSeconds(1), 60, 0.8f);
        var suppressed = Enumerable.Range(0, suppressedNotes)
            .Select(_ => new BasicPitchSuppressedHarmonic(candidate, anchor, 3, 0.02, 0.95, 0.25))
            .ToArray();
        return new BasicPitchHarmonicSuppressionDiagnostics(
            inputNotes,
            inputNotes - suppressedNotes,
            Array.AsReadOnly(suppressed));
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

    private static void Nearly(double expected, double actual, double tolerance)
    {
        if (Math.Abs(expected - actual) > tolerance)
            throw new InvalidOperationException($"Expected approximately {expected}, actual {actual}.");
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
