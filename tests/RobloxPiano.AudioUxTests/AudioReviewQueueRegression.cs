using System.Runtime.CompilerServices;
using RobloxPiano.App;
using RobloxPiano.Audio;

namespace RobloxPiano.AudioUxTests;

internal static class AudioReviewQueueRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var queue = new AudioReviewQueue();
        var first = Region(10, 14, ["EVENT_DENSITY_HIGH", "LOW_RETENTION"]);
        var second = Region(20, 24, ["EVENT_DENSITY_HIGH"]);
        var third = Region(30, 34, ["LOW_ACTIVATION"]);
        IReadOnlyList<AudioTranscriptionReviewRegion> regions = [first, second, third];

        var initial = queue.Synchronize(regions);
        Equal(3, initial.PendingRegions, "initial pending");
        Equal(0, initial.DeferredRegions, "initial deferred");
        Equal(0, initial.AppliedDecisions, "initial applied");
        Equal(0, initial.NextPendingIndex, "initial next");

        queue.Defer(regions, first);
        var deferred = queue.Synchronize(regions);
        Equal(2, deferred.PendingRegions, "pending after defer");
        Equal(1, deferred.DeferredRegions, "deferred after defer");
        Equal(1, deferred.NextPendingIndex, "queue advances past deferred region");
        True(queue.IsDeferred(first), "defer state must remain explicit");

        queue.RecordApplied(second, AudioTranscriptionReviewRepairKind.MelodyPriority, repairRevision: 1);
        IReadOnlyList<AudioTranscriptionReviewRegion> recomputed = [
            Region(10, 14, ["LOW_RETENTION", "EVENT_DENSITY_HIGH"]),
            third];
        var afterApply = queue.Synchronize(recomputed);
        Equal(1, afterApply.AppliedDecisions, "applied decision history survives recomputation");
        Equal(1, afterApply.DeferredRegions, "equivalent deferred region survives reason reordering");
        Equal(1, afterApply.PendingRegions, "resolved applied region must not remain pending");
        Equal(1, afterApply.NextPendingIndex, "next pending skips preserved defer");

        var progress = queue.FormatProgress(recomputed);
        Contains("1 pending", progress);
        Contains("1 deferred", progress);
        Contains("1 repair decision(s) applied", progress);

        var final = queue.FormatPreLibrarySummary(recomputed, AudioTranscriptionReadiness.NeedsReview);
        Contains("1 repair decision(s) applied", final);
        Contains("1 deferred", final);
        Contains("2 unresolved local review region(s)", final);
        Contains("overall readiness NeedsReview", final);

        True(queue.Resume(recomputed[0]), "explicit resume must clear defer");
        var resumed = queue.Synchronize(recomputed);
        Equal(2, resumed.PendingRegions, "resumed region returns to pending queue");
        Equal(0, resumed.DeferredRegions, "resume clears defer state");

        var stale = Region(90, 95, ["EVENT_DENSITY_HIGH"]);
        Throws<InvalidOperationException>(() => queue.Defer(recomputed, stale), "stale region defer must fail closed");

        queue.Reset();
        var reset = queue.Synchronize(recomputed);
        Equal(0, reset.AppliedDecisions, "revert/reset clears applied review history");
        Equal(0, reset.DeferredRegions, "revert/reset clears deferred decisions");
        Equal(2, reset.PendingRegions, "revert/reset makes current regions pending again");
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

    private static void Equal<T>(T expected, T actual, string label)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"{label}: expected '{expected}', actual '{actual}'");
    }

    private static void True(bool value, string label)
    {
        if (!value)
            throw new InvalidOperationException(label);
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
