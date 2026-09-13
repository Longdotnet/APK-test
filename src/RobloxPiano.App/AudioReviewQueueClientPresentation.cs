using RobloxPiano.Audio;

namespace RobloxPiano.App;

internal static class AudioReviewQueueClientPresentation
{
    public static string FormatRegionStatus(
        AudioReviewQueue queue,
        IReadOnlyList<AudioTranscriptionReviewRegion> regions,
        int selectedIndex,
        int candidateCount)
    {
        ArgumentNullException.ThrowIfNull(queue);
        ArgumentNullException.ThrowIfNull(regions);
        if (regions.Count == 0)
            return queue.FormatProgress(regions);
        if (selectedIndex < 0 || selectedIndex >= regions.Count)
            throw new ArgumentOutOfRangeException(nameof(selectedIndex));
        if (candidateCount < 0)
            throw new ArgumentOutOfRangeException(nameof(candidateCount));

        var region = regions[selectedIndex];
        var queueState = queue.IsDeferred(region) ? "deferred" : "pending";
        return
            $"{queue.FormatProgress(regions)}{Environment.NewLine}" +
            $"Flagged region {selectedIndex + 1}/{regions.Count}: {FormatTime(region.Start)}–{FormatTime(region.End)} • " +
            $"{string.Join(", ", region.Reasons)} • activation {region.MeanActivation:0.00} • retention {region.RetentionRatio:P0} • " +
            $"{candidateCount} deterministic repair candidate(s) • queue state: {queueState}. " +
            "Preview is side-effect free; Defer changes navigation only; Apply is explicit.";
    }

    public static string FormatPreLibraryPrompt(
        AudioReviewQueue queue,
        IReadOnlyList<AudioTranscriptionReviewRegion> regions,
        AudioTranscriptionReadiness readiness)
    {
        ArgumentNullException.ThrowIfNull(queue);
        ArgumentNullException.ThrowIfNull(regions);
        return
            $"{queue.FormatPreLibrarySummary(regions, readiness)}{Environment.NewLine}{Environment.NewLine}" +
            "Deferred regions remain unresolved review evidence and never count as repaired. " +
            "Add this explicitly reviewed result to your Library anyway?";
    }

    private static string FormatTime(TimeSpan value)
        => value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");
}
