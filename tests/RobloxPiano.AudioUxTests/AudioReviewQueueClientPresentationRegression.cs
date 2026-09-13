using System.Runtime.CompilerServices;
using RobloxPiano.App;
using RobloxPiano.Audio;

namespace RobloxPiano.AudioUxTests;

internal static class AudioReviewQueueClientPresentationRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var queue = new AudioReviewQueue();
        var first = Region(10, 14, ["EVENT_DENSITY_HIGH"]);
        var second = Region(20, 24, ["LOW_RETENTION"]);
        var third = Region(30, 34, ["MEAN_ACTIVATION_LOW"]);
        IReadOnlyList<AudioTranscriptionReviewRegion> regions = [first, second, third];

        queue.Defer(regions, first);
        queue.RecordApplied(second, AudioTranscriptionReviewRepairKind.MelodyPriority, repairRevision: 1);

        var regionText = AudioReviewQueueClientPresentation.FormatRegionStatus(queue, regions, 0, candidateCount: 2);
        Contains("2 pending", regionText);
        Contains("1 deferred", regionText);
        Contains("1 repair decision(s) applied", regionText);
        Contains("queue state: deferred", regionText);
        Contains("Defer changes navigation only", regionText);
        Contains("Apply is explicit", regionText);

        var finalText = AudioReviewQueueClientPresentation.FormatPreLibraryPrompt(
            queue,
            regions,
            AudioTranscriptionReadiness.NeedsReview);
        Contains("1 repair decision(s) applied", finalText);
        Contains("1 deferred", finalText);
        Contains("3 unresolved local review region(s)", finalText);
        Contains("overall readiness NeedsReview", finalText);
        Contains("Deferred regions remain unresolved review evidence", finalText);

        Throws<ArgumentOutOfRangeException>(
            () => AudioReviewQueueClientPresentation.FormatRegionStatus(queue, regions, 3, candidateCount: 2),
            "stale selected index must fail closed");
    }

    private static AudioTranscriptionReviewRegion Region(
        double startSeconds,
        double endSeconds,
        IReadOnlyList<string> reasons)
        => new(
            TimeSpan.FromSeconds(startSeconds),
            TimeSpan.FromSeconds(endSeconds),
            SourceNotes: 20,
            ArrangedEvents: 14,
            MeanActivation: 0.65f,
            RetentionRatio: 0.70,
            EventsPerSecond: 8.0,
            PeakSimultaneousNotes: 4,
            Reasons: reasons);

    private static void Contains(string expected, string actual)
    {
        if (!actual.Contains(expected, StringComparison.Ordinal))
            throw new InvalidOperationException($"expected '{expected}' in '{actual}'");
    }

    private static void Throws<TException>(Action action, string label)
        where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }
        throw new InvalidOperationException(label);
    }
}
