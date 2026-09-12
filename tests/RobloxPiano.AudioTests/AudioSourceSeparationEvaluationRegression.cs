using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class AudioSourceSeparationEvaluationRegression
{
    [ModuleInitializer]
    internal static void RunPhase26Regressions()
    {
        Run("separation gate adopts material consistent gains within budgets", MaterialGainWithinBudgetsAdopts);
        Run("separation gate rejects critical per-case regression", CriticalCaseRegressionRejects);
        Run("separation gate reviews quality gain that exceeds package budget", PackageBudgetExcessRequiresReview);
        Run("separation gate rejects no aggregate quality gain", NoAggregateGainRejects);
        Run("separation gate rejects mismatched ground truth", MismatchedGroundTruthFailsClosed);
        Run("separation gate rejects duplicate case identity", DuplicateCaseIdentityFailsClosed);
        Run("separation gate rejects inconsistent evaluation metrics", InconsistentMetricsFailClosed);
        Run("separation gate honors pre-cancellation", PreCancellationFailsClosed);
    }

    private static void MaterialGainWithinBudgetsAdopts()
    {
        var cases = new[]
        {
            Case("dense-pop-a", Eval(100, 120, 58), Eval(100, 108, 78)),
            Case("dense-pop-b", Eval(80, 96, 46), Eval(80, 84, 62)),
            Case("voice-plus-band", Eval(120, 150, 66), Eval(120, 128, 91))
        };

        var result = Evaluate(cases, new AudioSourceSeparationResourceMeasurement(
            AddedBundleBytes: 120 * 1024 * 1024,
            PeakWorkingSetBytes: 900 * 1024 * 1024,
            ProcessingSecondsPerAudioSecond: 2.25));

        Equal(AudioSourceSeparationAdoptionDecision.Adopt, result.Decision);
        True(result.MicroF1Gain >= 0.05, "Adoption requires a material aggregate gain.");
        True(result.MedianCaseF1Gain >= 0.03, "Adoption requires a material median case gain.");
        Nearly(1d, result.ImprovedCaseRatio);
        Equal(0, result.Reasons.Count);
    }

    private static void CriticalCaseRegressionRejects()
    {
        var cases = new[]
        {
            Case("large-gain", Eval(100, 130, 45), Eval(100, 100, 82)),
            Case("regressed-hook", Eval(100, 100, 85), Eval(100, 120, 70))
        };

        var result = Evaluate(cases, NormalResources());

        Equal(AudioSourceSeparationAdoptionDecision.Reject, result.Decision);
        True(result.Reasons.Contains("CASE_REGRESSION_CRITICAL"), "A large case regression must fail closed even if another case improves.");
    }

    private static void PackageBudgetExcessRequiresReview()
    {
        var cases = new[]
        {
            Case("mixture-a", Eval(100, 120, 55), Eval(100, 105, 78)),
            Case("mixture-b", Eval(100, 125, 52), Eval(100, 108, 76))
        };
        var resources = NormalResources() with { AddedBundleBytes = 300L * 1024 * 1024 };

        var result = Evaluate(cases, resources);

        Equal(AudioSourceSeparationAdoptionDecision.Review, result.Decision);
        True(result.Reasons.Contains("BUNDLE_BUDGET_EXCEEDED"), "Oversized candidate packaging must block automatic adoption.");
    }

    private static void NoAggregateGainRejects()
    {
        var cases = new[]
        {
            Case("flat-a", Eval(100, 100, 80), Eval(100, 100, 80)),
            Case("flat-b", Eval(100, 110, 75), Eval(100, 110, 74))
        };

        var result = Evaluate(cases, NormalResources());

        Equal(AudioSourceSeparationAdoptionDecision.Reject, result.Decision);
        True(result.Reasons.Contains("MICRO_F1_NO_GAIN"), "A heavier subsystem with no aggregate F1 gain must be rejected.");
    }

    private static void MismatchedGroundTruthFailsClosed()
    {
        Throws<ArgumentException>(() => Evaluate(
            new[] { Case("mismatch", Eval(100, 100, 70), Eval(101, 101, 80)) },
            NormalResources()));
    }

    private static void DuplicateCaseIdentityFailsClosed()
    {
        Throws<ArgumentException>(() => Evaluate(
            new[]
            {
                Case("duplicate", Eval(100, 100, 60), Eval(100, 100, 80)),
                Case("duplicate", Eval(80, 80, 50), Eval(80, 80, 70))
            },
            NormalResources()));
    }

    private static void InconsistentMetricsFailClosed()
    {
        var valid = Eval(100, 100, 70);
        var tampered = valid with { F1 = 0.99 };
        Throws<ArgumentException>(() => Evaluate(
            new[] { Case("tampered", valid, tampered) },
            NormalResources()));
    }

    private static void PreCancellationFailsClosed()
    {
        using var cts = new CancellationTokenSource();
        cts.Cancel();
        Throws<OperationCanceledException>(() => new AudioSourceSeparationAdoptionEvaluator().Evaluate(
            new[] { Case("cancelled", Eval(100, 110, 60), Eval(100, 105, 80)) },
            NormalResources(),
            cancellationToken: cts.Token));
    }

    private static AudioSourceSeparationAdoptionAssessment Evaluate(
        IReadOnlyList<AudioSourceSeparationBenchmarkCase> cases,
        AudioSourceSeparationResourceMeasurement resources) =>
        new AudioSourceSeparationAdoptionEvaluator().Evaluate(cases, resources);

    private static AudioSourceSeparationBenchmarkCase Case(
        string name,
        AudioTranscriptionEvaluationResult direct,
        AudioTranscriptionEvaluationResult candidate) => new(name, direct, candidate);

    private static AudioSourceSeparationResourceMeasurement NormalResources() => new(
        AddedBundleBytes: 120 * 1024 * 1024,
        PeakWorkingSetBytes: 900 * 1024 * 1024,
        ProcessingSecondsPerAudioSecond: 2.0);

    private static AudioTranscriptionEvaluationResult Eval(int reference, int estimated, int matched)
    {
        var precision = estimated == 0 ? 0d : matched / (double)estimated;
        var recall = matched / (double)reference;
        var f1 = precision + recall == 0d ? 0d : 2d * precision * recall / (precision + recall);
        return new AudioTranscriptionEvaluationResult(
            reference,
            estimated,
            matched,
            precision,
            recall,
            f1,
            20d,
            35d,
            Array.Empty<AudioTranscriptionNoteMatch>());
    }

    private static void Run(string name, Action test)
    {
        try
        {
            test();
            Console.WriteLine($"PASS {name}");
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"FAIL {name}: {exception}");
            throw;
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
    }

    private static void Nearly(double expected, double actual, double tolerance = 0.000001)
    {
        if (Math.Abs(expected - actual) > tolerance)
            throw new InvalidOperationException($"Expected approximately {expected}, actual {actual}.");
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
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
