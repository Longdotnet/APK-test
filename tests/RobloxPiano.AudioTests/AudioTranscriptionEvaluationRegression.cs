using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class AudioTranscriptionEvaluationRegression
{
    [ModuleInitializer]
    internal static void RunPhase07CorpusRegressions()
    {
        Run("evaluation exact notes score perfect precision recall", ExactNotesScorePerfectly);
        Run("evaluation accepts mir_eval 50 ms onset boundary", FiftyMillisecondOnsetBoundaryMatches);
        Run("evaluation enforces one-to-one note matching", DuplicateEstimateCannotMatchTwice);
        Run("evaluation uses maximum matching instead of greedy pairing", MaximumMatchingAvoidsGreedyUndercount);
        Run("evaluation applies duration-relative offset tolerance", RelativeOffsetToleranceMatchesLongNotes);
        Run("evaluation rejects wrong pitch and late onset", WrongPitchAndLateOnsetRemainErrors);
        Run("evaluation corpus exposes clean versus degraded cases", CorpusAggregatePreservesPerCaseQuality);
        Run("evaluation honors cancellation before corpus mutation", CancellationFailsClosed);
    }

    private static void ExactNotesScorePerfectly()
    {
        var reference = new[]
        {
            Ref(0.00, 0.50, 60),
            Ref(0.50, 1.00, 64),
            Ref(1.00, 1.50, 67)
        };
        var estimated = new[]
        {
            Est(0.00, 0.50, 60),
            Est(0.50, 1.00, 64),
            Est(1.00, 1.50, 67)
        };
        var result = new AudioTranscriptionEvaluator().Evaluate(reference, estimated);
        Equal(3, result.MatchedNotes);
        Nearly(1d, result.Precision);
        Nearly(1d, result.Recall);
        Nearly(1d, result.F1);
        Nearly(0d, result.MeanAbsoluteOnsetErrorMilliseconds);
        Nearly(0d, result.MeanAbsoluteOffsetErrorMilliseconds);
    }

    private static void FiftyMillisecondOnsetBoundaryMatches()
    {
        var result = new AudioTranscriptionEvaluator().Evaluate(
            new[] { Ref(1.000, 1.500, 69) },
            new[] { Est(1.050, 1.550, 69) });
        Equal(1, result.MatchedNotes);
        Nearly(50d, result.MeanAbsoluteOnsetErrorMilliseconds, 0.001);
    }

    private static void DuplicateEstimateCannotMatchTwice()
    {
        var result = new AudioTranscriptionEvaluator().Evaluate(
            new[] { Ref(0.000, 0.500, 60), Ref(0.020, 0.520, 60) },
            new[] { Est(0.010, 0.510, 60) });
        Equal(1, result.MatchedNotes);
        Nearly(1d, result.Precision);
        Nearly(0.5d, result.Recall);
        Equal(1, result.FalseNegatives);
    }

    private static void MaximumMatchingAvoidsGreedyUndercount()
    {
        // Shared estimate at 20 ms can match both references. Estimate at 0 ms can only match the first.
        // A closest-first greedy pass can consume the shared edge first and score 1/2; maximum matching scores 2/2.
        var result = new AudioTranscriptionEvaluator().Evaluate(
            new[] { Ref(0.000, 0.500, 60), Ref(0.070, 0.570, 60) },
            new[] { Est(0.020, 0.520, 60), Est(0.000, 0.500, 60) });
        Equal(2, result.MatchedNotes);
        Nearly(1d, result.Precision);
        Nearly(1d, result.Recall);
        Nearly(1d, result.F1);
    }

    private static void RelativeOffsetToleranceMatchesLongNotes()
    {
        var evaluator = new AudioTranscriptionEvaluator();
        var withinTwentyPercent = evaluator.Evaluate(
            new[] { Ref(0.0, 2.0, 72) },
            new[] { Est(0.0, 2.4, 72) });
        var outsideTwentyPercent = evaluator.Evaluate(
            new[] { Ref(0.0, 2.0, 72) },
            new[] { Est(0.0, 2.401, 72) });
        Equal(1, withinTwentyPercent.MatchedNotes);
        Equal(0, outsideTwentyPercent.MatchedNotes);
    }

    private static void WrongPitchAndLateOnsetRemainErrors()
    {
        var result = new AudioTranscriptionEvaluator().Evaluate(
            new[] { Ref(0.0, 0.5, 60), Ref(1.0, 1.5, 64) },
            new[] { Est(0.0, 0.5, 61), Est(1.051, 1.5, 64) });
        Equal(0, result.MatchedNotes);
        Nearly(0d, result.Precision);
        Nearly(0d, result.Recall);
        Equal(2, result.FalsePositives);
        Equal(2, result.FalseNegatives);
    }

    private static void CorpusAggregatePreservesPerCaseQuality()
    {
        var cases = new[]
        {
            new AudioTranscriptionEvaluationCase(
                "synthetic-clean-triad",
                new[] { Ref(0.0, 0.5, 60), Ref(0.0, 0.5, 64), Ref(0.0, 0.5, 67) },
                new[] { Est(0.0, 0.5, 60), Est(0.0, 0.5, 64), Est(0.0, 0.5, 67) }),
            new AudioTranscriptionEvaluationCase(
                "synthetic-degraded-melody",
                new[] { Ref(0.0, 0.4, 72), Ref(0.5, 0.9, 74), Ref(1.0, 1.4, 76) },
                new[] { Est(0.0, 0.4, 72), Est(0.7, 1.1, 74), Est(1.0, 1.4, 77) })
        };
        var corpus = new AudioTranscriptionCorpusEvaluator().Evaluate(cases);
        Equal(2, corpus.Cases);
        Equal(6, corpus.ReferenceNotes);
        Equal(6, corpus.EstimatedNotes);
        Equal(4, corpus.MatchedNotes);
        Nearly(2d / 3d, corpus.MicroPrecision);
        Nearly(2d / 3d, corpus.MicroRecall);
        Nearly(2d / 3d, corpus.MicroF1);
        Nearly((1d + (1d / 3d)) / 2d, corpus.MacroF1);
        Nearly(1d, corpus.Results["synthetic-clean-triad"].F1);
        Nearly(1d / 3d, corpus.Results["synthetic-degraded-melody"].F1);
    }

    private static void CancellationFailsClosed()
    {
        using var cts = new CancellationTokenSource();
        cts.Cancel();
        Throws<OperationCanceledException>(() => new AudioTranscriptionCorpusEvaluator().Evaluate(
            new[]
            {
                new AudioTranscriptionEvaluationCase(
                    "cancelled",
                    new[] { Ref(0, 0.5, 60) },
                    new[] { Est(0, 0.5, 60) })
            },
            cancellationToken: cts.Token));
    }

    private static AudioTranscriptionReferenceNote Ref(double start, double end, int midi) =>
        new(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(end), midi);

    private static BasicPitchTranscribedNote Est(double start, double end, int midi) =>
        new(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(end), midi, 0.8f);

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
