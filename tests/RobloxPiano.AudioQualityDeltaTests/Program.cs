using RobloxPiano.Audio;

namespace RobloxPiano.AudioQualityDeltaTests;

internal static class Program
{
    public static int Main()
    {
        var failures = new List<string>();
        Run("repair improvement exposes metric and reason deltas", RepairImprovement, failures);
        Run("immutable source warning stays persistent", ImmutableWarningPersists, failures);
        Run("new regression reason is introduced and readiness regresses", RegressionIsVisible, failures);
        Run("reason ordering is deterministic and duplicate safe", ReasonOrderingIsDeterministic, failures);
        Run("blank reason fails closed", BlankReasonRejected, failures);

        Console.WriteLine($"Audio quality delta regressions: {5 - failures.Count} passed, {failures.Count} failed.");
        foreach (var failure in failures)
            Console.Error.WriteLine(failure);
        return failures.Count == 0 ? 0 : 1;
    }

    private static void RepairImprovement()
    {
        var before = Assessment(
            AudioTranscriptionReadiness.NeedsReview,
            retention: 0.45,
            loss: 0.55,
            coverage: 0.80,
            density: 18.0,
            reasons: ["RETENTION_LOW", "ARRANGEMENT_LOSS_HIGH", "EVENT_DENSITY_HIGH"]);
        var current = Assessment(
            AudioTranscriptionReadiness.Ready,
            retention: 0.72,
            loss: 0.28,
            coverage: 0.92,
            density: 8.0,
            reasons: []);

        var delta = AudioTranscriptionQualityDeltaEvaluator.Compare(before, current);
        True(delta.ImprovedReadiness, "NeedsReview -> Ready should be an improvement");
        False(delta.RegressedReadiness, "improved repair was marked as regression");
        Near(0.27, delta.RetentionDelta);
        Near(-0.27, delta.TransformLossDelta);
        Near(0.12, delta.TimelineCoverageDelta);
        Near(-10.0, delta.EventsPerSecondDelta);
        SequenceEqual(
            ["ARRANGEMENT_LOSS_HIGH", "EVENT_DENSITY_HIGH", "RETENTION_LOW"],
            delta.ResolvedReasons);
        Equal(0, delta.PersistentReasons.Count);
        Equal(0, delta.IntroducedReasons.Count);
    }

    private static void ImmutableWarningPersists()
    {
        var before = Assessment(
            AudioTranscriptionReadiness.NeedsReview,
            retention: 0.42,
            loss: 0.58,
            coverage: 0.84,
            density: 17.0,
            reasons: ["MEAN_ACTIVATION_LOW", "EVENT_DENSITY_HIGH"]);
        var current = Assessment(
            AudioTranscriptionReadiness.NeedsReview,
            retention: 0.75,
            loss: 0.25,
            coverage: 0.94,
            density: 7.5,
            reasons: ["MEAN_ACTIVATION_LOW"]);

        var delta = AudioTranscriptionQualityDeltaEvaluator.Compare(before, current);
        SequenceEqual(["EVENT_DENSITY_HIGH"], delta.ResolvedReasons);
        SequenceEqual(["MEAN_ACTIVATION_LOW"], delta.PersistentReasons);
        False(delta.ImprovedReadiness, "readiness did not change while immutable warning remains");
    }

    private static void RegressionIsVisible()
    {
        var before = Assessment(AudioTranscriptionReadiness.Ready, 0.75, 0.25, 0.95, 8.0, []);
        var current = Assessment(
            AudioTranscriptionReadiness.NeedsReview,
            0.50,
            0.50,
            0.70,
            3.0,
            ["RETENTION_LOW"]);

        var delta = AudioTranscriptionQualityDeltaEvaluator.Compare(before, current);
        True(delta.RegressedReadiness, "Ready -> NeedsReview must be visible as regression");
        SequenceEqual(["RETENTION_LOW"], delta.IntroducedReasons);
    }

    private static void ReasonOrderingIsDeterministic()
    {
        var before = Assessment(
            AudioTranscriptionReadiness.NeedsReview,
            0.50,
            0.50,
            0.80,
            12.0,
            ["Z_REASON", "A_REASON", "Z_REASON", "M_REASON"]);
        var current = Assessment(
            AudioTranscriptionReadiness.NeedsReview,
            0.55,
            0.45,
            0.85,
            10.0,
            ["M_REASON", "B_REASON", "B_REASON"]);

        var delta = AudioTranscriptionQualityDeltaEvaluator.Compare(before, current);
        SequenceEqual(["A_REASON", "Z_REASON"], delta.ResolvedReasons);
        SequenceEqual(["M_REASON"], delta.PersistentReasons);
        SequenceEqual(["B_REASON"], delta.IntroducedReasons);
    }

    private static void BlankReasonRejected()
    {
        var before = Assessment(AudioTranscriptionReadiness.NeedsReview, 0.5, 0.5, 0.8, 8.0, [" "]);
        var current = Assessment(AudioTranscriptionReadiness.Ready, 0.7, 0.3, 0.9, 7.0, []);
        try
        {
            _ = AudioTranscriptionQualityDeltaEvaluator.Compare(before, current);
            throw new InvalidOperationException("blank reason was accepted");
        }
        catch (ArgumentException)
        {
        }
    }

    private static AudioTranscriptionQualityAssessment Assessment(
        AudioTranscriptionReadiness readiness,
        double retention,
        double loss,
        double coverage,
        double density,
        IReadOnlyList<string> reasons) =>
        new(
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

    private static void Run(string name, Action test, ICollection<string> failures)
    {
        try
        {
            test();
        }
        catch (Exception exception)
        {
            failures.Add($"FAIL {name}: {exception.Message}");
        }
    }

    private static void Near(double expected, double actual, double tolerance = 1e-9)
    {
        if (Math.Abs(expected - actual) > tolerance)
            throw new InvalidOperationException($"expected {expected}, got {actual}");
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"expected '{expected}', got '{actual}'");
    }

    private static void True(bool value, string message)
    {
        if (!value)
            throw new InvalidOperationException(message);
    }

    private static void False(bool value, string message)
        => True(!value, message);

    private static void SequenceEqual<T>(IReadOnlyList<T> expected, IReadOnlyList<T> actual)
    {
        if (!expected.SequenceEqual(actual))
            throw new InvalidOperationException(
                $"expected [{string.Join(", ", expected)}], got [{string.Join(", ", actual)}]");
    }
}
