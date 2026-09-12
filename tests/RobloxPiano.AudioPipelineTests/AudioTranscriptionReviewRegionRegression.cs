using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class AudioTranscriptionReviewRegionRegression
{
    [ModuleInitializer]
    internal static void RunPhase35Regressions()
    {
        Run("low activation is localized to fixed review window", LowActivationIsLocalized);
        Run("local arrangement loss is surfaced", LocalRetentionLossIsSurfaced);
        Run("clean windows are not flagged", CleanWindowsAreNotFlagged);
        Run("review-region map is deterministic across note ordering", MapIsOrderIndependent);
    }

    private static void LowActivationIsLocalized()
    {
        var notes = new[]
        {
            Note(0.5, 1.0, 60, 0.25f),
            Note(2.0, 2.5, 64, 0.30f),
            Note(6.0, 6.5, 67, 0.90f)
        };
        var track = Track(
            Event(0.5, 0.5, 'a'),
            Event(2.0, 0.5, 's'),
            Event(6.0, 0.5, 'd'));

        var regions = new AudioTranscriptionReviewRegionAnalyzer().Analyze(TimeSpan.FromSeconds(10), notes, track);
        Equal(1, regions.Count);
        Equal(TimeSpan.Zero, regions[0].Start);
        Equal(TimeSpan.FromSeconds(5), regions[0].End);
        True(regions[0].Reasons.Contains("LOW_ACTIVATION_REGION"));
    }

    private static void LocalRetentionLossIsSurfaced()
    {
        var notes = Enumerable.Range(0, 6)
            .Select(index => Note(0.25 + index * 0.5, 0.45 + index * 0.5, 60 + index, 0.8f))
            .ToArray();
        var track = Track(Event(0.25, 0.2, 'a'));

        var regions = new AudioTranscriptionReviewRegionAnalyzer().Analyze(TimeSpan.FromSeconds(5), notes, track);
        Equal(1, regions.Count);
        True(regions[0].Reasons.Contains("LOCAL_RETENTION_LOW"));
        True(regions[0].RetentionRatio < 0.45d);
    }

    private static void CleanWindowsAreNotFlagged()
    {
        var notes = new[]
        {
            Note(0.5, 1.0, 60, 0.8f),
            Note(2.0, 2.5, 64, 0.75f),
            Note(6.0, 6.5, 67, 0.9f)
        };
        var track = Track(
            Event(0.5, 0.5, 'a'),
            Event(2.0, 0.5, 's'),
            Event(6.0, 0.5, 'd'));

        var regions = new AudioTranscriptionReviewRegionAnalyzer().Analyze(TimeSpan.FromSeconds(10), notes, track);
        Equal(0, regions.Count);
    }

    private static void MapIsOrderIndependent()
    {
        var notes = new[]
        {
            Note(0.5, 1.0, 60, 0.2f),
            Note(1.5, 2.0, 64, 0.3f),
            Note(6.0, 6.5, 67, 0.85f)
        };
        var track = Track(
            Event(0.5, 0.5, 'a'),
            Event(1.5, 0.5, 's'),
            Event(6.0, 0.5, 'd'));
        var analyzer = new AudioTranscriptionReviewRegionAnalyzer();

        var forward = analyzer.Analyze(TimeSpan.FromSeconds(10), notes, track);
        var reverse = analyzer.Analyze(TimeSpan.FromSeconds(10), notes.Reverse().ToArray(), track);
        Equal(forward.Count, reverse.Count);
        for (var index = 0; index < forward.Count; index++)
        {
            Equal(forward[index].Start, reverse[index].Start);
            Equal(forward[index].End, reverse[index].End);
            Equal(string.Join(',', forward[index].Reasons), string.Join(',', reverse[index].Reasons));
        }
    }

    private static BasicPitchTranscribedNote Note(double startSeconds, double endSeconds, int midi, float amplitude) =>
        new(TimeSpan.FromSeconds(startSeconds), TimeSpan.FromSeconds(endSeconds), midi, amplitude);

    private static PerformanceEvent Event(double startSeconds, double durationSeconds, char key) =>
        new(TimeSpan.FromSeconds(startSeconds), TimeSpan.FromSeconds(durationSeconds), new[] { key });

    private static PerformanceTrack Track(params PerformanceEvent[] events) =>
        new("review-regions", 120d, 480, TimeSpan.Zero, events, events.Max(evt => evt.Start + evt.Duration));

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

    private static void True(bool value)
    {
        if (!value)
            throw new InvalidOperationException("Expected condition to be true.");
    }
}
