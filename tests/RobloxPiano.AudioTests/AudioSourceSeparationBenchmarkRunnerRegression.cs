using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class AudioSourceSeparationBenchmarkRunnerRegression
{
    [ModuleInitializer]
    internal static void RunPhase27Regressions()
    {
        Run("paired separation runner derives quality and resource evidence", DerivesQualityAndResourceEvidence);
        Run("paired separation runner rejects drifting bundle measurement", BundleMeasurementDriftFailsClosed);
        Run("paired separation runner rejects duplicate corpus identity", DuplicateIdentityFailsClosed);
        Run("paired separation runner rejects empty ground truth", EmptyGroundTruthFailsClosed);
        Run("paired separation runner honors pre-cancellation before delegates", PreCancellationAvoidsDelegateWork);
    }

    private static void DerivesQualityAndResourceEvidence()
    {
        var cases = new[]
        {
            Input("mixture-a", 10, Reference(60, 62, 64, 65, 67)),
            Input("mixture-b", 20, Reference(60, 62, 64, 65, 67))
        };
        var direct = new Dictionary<string, IReadOnlyList<BasicPitchTranscribedNote>>(StringComparer.Ordinal)
        {
            ["mixture-a"] = Estimated((60, 0), (62, 1), (64, 2)),
            ["mixture-b"] = Estimated((60, 0), (62, 1), (64, 2))
        };
        var candidate = new Dictionary<string, IReadOnlyList<BasicPitchTranscribedNote>>(StringComparer.Ordinal)
        {
            ["mixture-a"] = Estimated((60, 0), (62, 1), (64, 2), (65, 3), (67, 4)),
            ["mixture-b"] = Estimated((60, 0), (62, 1), (64, 2), (65, 3), (67, 4))
        };

        var run = new AudioSourceSeparationBenchmarkRunner().RunAsync(
            cases,
            (item, _) => ValueTask.FromResult(direct[item.Name]),
            (item, _) => ValueTask.FromResult(new AudioSourceSeparationCandidateRun(
                candidate[item.Name],
                item.Name == "mixture-a" ? TimeSpan.FromSeconds(10) : TimeSpan.FromSeconds(20),
                item.Name == "mixture-a" ? 700L * 1024 * 1024 : 900L * 1024 * 1024,
                120L * 1024 * 1024)))
            .GetAwaiter().GetResult();

        Equal(2, run.Cases.Count);
        Equal(120L * 1024 * 1024, run.Resources.AddedBundleBytes);
        Equal(900L * 1024 * 1024, run.Resources.PeakWorkingSetBytes);
        Nearly(1d, run.Resources.ProcessingSecondsPerAudioSecond);
        Equal(AudioSourceSeparationAdoptionDecision.Adopt, run.Assessment.Decision);
        True(run.Assessment.CandidateMicroF1 > run.Assessment.DirectMicroF1, "Candidate path should improve measured corpus F1.");
    }

    private static void BundleMeasurementDriftFailsClosed()
    {
        var cases = new[]
        {
            Input("a", 10, Reference(60)),
            Input("b", 10, Reference(60))
        };

        Throws<ArgumentException>(() => new AudioSourceSeparationBenchmarkRunner().RunAsync(
            cases,
            (_, _) => ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Estimated((60, 0))),
            (item, _) => ValueTask.FromResult(new AudioSourceSeparationCandidateRun(
                Estimated((60, 0)),
                TimeSpan.FromSeconds(1),
                100,
                item.Name == "a" ? 1000 : 1001)))
            .GetAwaiter().GetResult());
    }

    private static void DuplicateIdentityFailsClosed()
    {
        var cases = new[]
        {
            Input("duplicate", 10, Reference(60)),
            Input("duplicate", 10, Reference(60))
        };

        Throws<ArgumentException>(() => new AudioSourceSeparationBenchmarkRunner().RunAsync(
            cases,
            (_, _) => throw new InvalidOperationException("delegate should not run"),
            (_, _) => throw new InvalidOperationException("delegate should not run"))
            .GetAwaiter().GetResult());
    }

    private static void EmptyGroundTruthFailsClosed()
    {
        var cases = new[]
        {
            new AudioSourceSeparationBenchmarkInputCase("empty", TimeSpan.FromSeconds(10), Array.Empty<AudioTranscriptionReferenceNote>())
        };

        Throws<ArgumentException>(() => new AudioSourceSeparationBenchmarkRunner().RunAsync(
            cases,
            (_, _) => throw new InvalidOperationException("delegate should not run"),
            (_, _) => throw new InvalidOperationException("delegate should not run"))
            .GetAwaiter().GetResult());
    }

    private static void PreCancellationAvoidsDelegateWork()
    {
        var called = false;
        using var cts = new CancellationTokenSource();
        cts.Cancel();

        Throws<OperationCanceledException>(() => new AudioSourceSeparationBenchmarkRunner().RunAsync(
            new[] { Input("cancel", 10, Reference(60)) },
            (_, _) =>
            {
                called = true;
                return ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Estimated((60, 0)));
            },
            (_, _) =>
            {
                called = true;
                return ValueTask.FromResult(new AudioSourceSeparationCandidateRun(Estimated((60, 0)), TimeSpan.Zero, 0, 0));
            },
            cancellationToken: cts.Token)
            .GetAwaiter().GetResult());

        True(!called, "Pre-cancelled benchmark must not invoke transcription delegates.");
    }

    private static AudioSourceSeparationBenchmarkInputCase Input(
        string name,
        int seconds,
        IReadOnlyList<AudioTranscriptionReferenceNote> reference) =>
        new(name, TimeSpan.FromSeconds(seconds), reference);

    private static IReadOnlyList<AudioTranscriptionReferenceNote> Reference(params int[] notes) =>
        notes.Select((note, index) => new AudioTranscriptionReferenceNote(
            TimeSpan.FromSeconds(index),
            TimeSpan.FromSeconds(index + 0.5),
            note)).ToArray();

    private static IReadOnlyList<BasicPitchTranscribedNote> Estimated(params (int Note, int Second)[] notes) =>
        notes.Select(item => new BasicPitchTranscribedNote(
            TimeSpan.FromSeconds(item.Second),
            TimeSpan.FromSeconds(item.Second + 0.5),
            item.Note,
            0.8f)).ToArray();

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
