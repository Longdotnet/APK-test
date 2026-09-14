using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class AudioArrangementQualityEvidenceRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        Run("arrangement evidence separates upstream recognition from arranger retention", MeasuresRecognizedRetentionAndClutterSuppression);
        Run("arrangement evidence honors cancellation before measurement", CancellationFailsClosed);
    }

    private static void MeasuresRecognizedRetentionAndClutterSuppression()
    {
        var source = new[]
        {
            Est(0.00, 0.55, 60, 0.70f),
            Est(0.00, 0.55, 72, 0.92f),
            Est(0.00, 0.55, 84, 0.10f),
            Est(1.00, 1.55, 62, 0.68f),
            Est(1.00, 1.55, 74, 0.90f),
            Est(1.00, 1.55, 86, 0.09f)
        };
        var reference = new[]
        {
            Label("verse", AudioArrangementReferenceRole.Harmony, 0.00, 0.55, 60),
            Label("verse", AudioArrangementReferenceRole.Melody, 0.00, 0.55, 72),
            Label("chorus", AudioArrangementReferenceRole.Harmony, 1.00, 1.55, 62),
            Label("chorus", AudioArrangementReferenceRole.Melody, 1.00, 1.55, 74)
        };
        var arrangement = new RobloxPianoArranger().Arrange(
            "evidence fixture",
            source,
            new RobloxPianoArrangementOptions(
                MaxSimultaneousNotes: 2,
                MinimumDuration: TimeSpan.FromMilliseconds(20),
                LowActivationThreshold: 0.15f));

        var evidence = new AudioArrangementQualityEvidenceEvaluator().Evaluate(
            reference,
            source,
            arrangement.Track,
            options: new AudioTranscriptionEvaluationOptions(
                OnsetTolerance: TimeSpan.FromMilliseconds(50),
                RequireOffsetMatch: false));

        Equal(4, evidence.ReferenceNotes);
        Equal(6, evidence.SourceNotes);
        Equal(4, evidence.ArrangedNotes);
        Equal(2, evidence.SourceFalsePositives);
        Equal(0, evidence.ArrangedFalsePositives);
        Equal(2, evidence.RecognizedMelodyNotes);
        Equal(2, evidence.RetainedMelodyNotes);
        Equal(2, evidence.RecognizedHarmonyNotes);
        Equal(2, evidence.RetainedHarmonyNotes);
        Nearly(1d, evidence.MelodyRetention);
        Nearly(1d, evidence.HarmonyRetention);
        Nearly(1d, evidence.ClutterSuppression);
        Nearly(4d / 6d, evidence.EventRetentionRatio);
        Nearly(1d, evidence.MinimumSectionMelodyRetention);
        False(evidence.ArrangementAddedFalsePositives);
        Equal(2, evidence.Sections.Count);
        Nearly(1d, evidence.Sections["verse"].MelodyRetention);
        Nearly(1d, evidence.Sections["chorus"].HarmonyRetention);
    }

    private static void CancellationFailsClosed()
    {
        var source = new[] { Est(0, 0.5, 72, 0.8f) };
        var arrangement = new RobloxPianoArranger().Arrange("cancelled", source);
        using var cts = new CancellationTokenSource();
        cts.Cancel();
        Throws<OperationCanceledException>(() => new AudioArrangementQualityEvidenceEvaluator().Evaluate(
            new[] { Label("verse", AudioArrangementReferenceRole.Melody, 0, 0.5, 72) },
            source,
            arrangement.Track,
            cancellationToken: cts.Token));
    }

    private static AudioArrangementReferenceNote Label(
        string section,
        AudioArrangementReferenceRole role,
        double start,
        double end,
        int midi) =>
        new(section, role, new AudioTranscriptionReferenceNote(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(end), midi));

    private static BasicPitchTranscribedNote Est(double start, double end, int midi, float amplitude) =>
        new(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(end), midi, amplitude);

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

    private static void False(bool condition)
    {
        if (condition)
            throw new InvalidOperationException("Expected condition to be false.");
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
