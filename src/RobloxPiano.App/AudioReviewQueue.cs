using RobloxPiano.Audio;

namespace RobloxPiano.App;

internal sealed record AudioReviewAppliedDecision(
    string RegionKey,
    AudioTranscriptionReviewRepairKind Kind,
    long RepairRevision);

internal sealed record AudioReviewQueuePersistedState(
    IReadOnlyList<string> DeferredRegionKeys,
    IReadOnlyList<AudioReviewAppliedDecision> AppliedDecisions);

internal sealed record AudioReviewQueueSnapshot(
    int TotalRegions,
    int PendingRegions,
    int DeferredRegions,
    int AppliedDecisions,
    int? NextPendingIndex,
    bool AllCurrentRegionsDeferred)
{
    public bool HasPending => PendingRegions > 0;
}

/// <summary>
/// Tracks client review-navigation decisions without owning or mutating canonical audio state.
/// Deferred regions remain unresolved quality evidence. Applied decisions are an audit trail only;
/// the authoritative PerformanceTrack, quality and review-region recomputation remain owned by
/// AudioTranscriptionReviewRepairSession.
/// </summary>
internal sealed class AudioReviewQueue
{
    private readonly HashSet<string> deferredRegionKeys = new(StringComparer.Ordinal);
    private readonly List<AudioReviewAppliedDecision> appliedDecisions = [];

    public int AppliedDecisionCount => appliedDecisions.Count;
    public IReadOnlyList<AudioReviewAppliedDecision> AppliedDecisions => appliedDecisions.AsReadOnly();

    public void Reset()
    {
        deferredRegionKeys.Clear();
        appliedDecisions.Clear();
    }

    public AudioReviewQueuePersistedState ExportState()
        => new(
            deferredRegionKeys.OrderBy(value => value, StringComparer.Ordinal).ToArray(),
            appliedDecisions.ToArray());

    public AudioReviewQueueSnapshot RestoreState(
        IReadOnlyList<AudioTranscriptionReviewRegion> currentRegions,
        AudioReviewQueuePersistedState state,
        int startIndex = 0)
    {
        ArgumentNullException.ThrowIfNull(currentRegions);
        ArgumentNullException.ThrowIfNull(state);
        ArgumentNullException.ThrowIfNull(state.DeferredRegionKeys);
        ArgumentNullException.ThrowIfNull(state.AppliedDecisions);

        var currentKeys = currentRegions.Select(GetRegionKey).ToHashSet(StringComparer.Ordinal);
        var restoredDeferred = state.DeferredRegionKeys
            .Where(value => !string.IsNullOrWhiteSpace(value))
            .Distinct(StringComparer.Ordinal)
            .ToArray();
        if (restoredDeferred.Length != state.DeferredRegionKeys.Count)
            throw new InvalidDataException("Review draft contains blank or duplicate deferred-region keys.");
        if (restoredDeferred.Any(key => !currentKeys.Contains(key)))
            throw new InvalidDataException("Review draft contains a deferred region that is stale for the restored canonical track.");

        long previousRevision = 0;
        foreach (var decision in state.AppliedDecisions)
        {
            if (decision is null || string.IsNullOrWhiteSpace(decision.RegionKey))
                throw new InvalidDataException("Review draft contains an invalid applied decision.");
            if (decision.RepairRevision <= previousRevision)
                throw new InvalidDataException("Review draft repair revisions must be strictly increasing.");
            previousRevision = decision.RepairRevision;
        }

        deferredRegionKeys.Clear();
        foreach (var key in restoredDeferred)
            deferredRegionKeys.Add(key);
        appliedDecisions.Clear();
        appliedDecisions.AddRange(state.AppliedDecisions);
        return Synchronize(currentRegions, startIndex);
    }

    public AudioReviewQueueSnapshot Synchronize(
        IReadOnlyList<AudioTranscriptionReviewRegion> regions,
        int startIndex = 0)
    {
        ArgumentNullException.ThrowIfNull(regions);
        var currentKeys = regions.Select(GetRegionKey).ToHashSet(StringComparer.Ordinal);
        deferredRegionKeys.RemoveWhere(key => !currentKeys.Contains(key));

        var deferred = regions.Count(IsDeferred);
        var pending = regions.Count - deferred;
        var next = FindNextPendingIndex(regions, startIndex);
        return new AudioReviewQueueSnapshot(
            regions.Count,
            pending,
            deferred,
            appliedDecisions.Count,
            next,
            regions.Count != 0 && pending == 0);
    }

    public void Defer(
        IReadOnlyList<AudioTranscriptionReviewRegion> currentRegions,
        AudioTranscriptionReviewRegion region)
    {
        RequireCurrent(currentRegions, region);
        deferredRegionKeys.Add(GetRegionKey(region));
    }

    public bool Resume(AudioTranscriptionReviewRegion region)
    {
        ArgumentNullException.ThrowIfNull(region);
        return deferredRegionKeys.Remove(GetRegionKey(region));
    }

    public bool IsDeferred(AudioTranscriptionReviewRegion region)
    {
        ArgumentNullException.ThrowIfNull(region);
        return deferredRegionKeys.Contains(GetRegionKey(region));
    }

    public void RecordApplied(
        AudioTranscriptionReviewRegion region,
        AudioTranscriptionReviewRepairKind kind,
        long repairRevision)
    {
        ArgumentNullException.ThrowIfNull(region);
        if (repairRevision <= 0)
            throw new ArgumentOutOfRangeException(nameof(repairRevision));
        if (appliedDecisions.Count != 0 && repairRevision <= appliedDecisions[^1].RepairRevision)
            throw new InvalidOperationException("Repair revisions must advance monotonically before recording a review decision.");

        var key = GetRegionKey(region);
        deferredRegionKeys.Remove(key);
        appliedDecisions.Add(new AudioReviewAppliedDecision(key, kind, repairRevision));
    }

    public int? FindNextPendingIndex(
        IReadOnlyList<AudioTranscriptionReviewRegion> regions,
        int startIndex)
    {
        ArgumentNullException.ThrowIfNull(regions);
        if (regions.Count == 0)
            return null;

        var normalizedStart = Math.Clamp(startIndex, 0, regions.Count - 1);
        for (var offset = 0; offset < regions.Count; offset++)
        {
            var index = (normalizedStart + offset) % regions.Count;
            if (!IsDeferred(regions[index]))
                return index;
        }
        return null;
    }

    public string FormatProgress(IReadOnlyList<AudioTranscriptionReviewRegion> regions)
    {
        var snapshot = Synchronize(regions);
        return $"Review queue: {snapshot.PendingRegions} pending • {snapshot.DeferredRegions} deferred • {snapshot.AppliedDecisions} repair decision(s) applied.";
    }

    public string FormatPreLibrarySummary(
        IReadOnlyList<AudioTranscriptionReviewRegion> regions,
        AudioTranscriptionReadiness readiness)
    {
        var snapshot = Synchronize(regions);
        var unresolved = snapshot.TotalRegions;
        return
            $"Final review summary: {snapshot.AppliedDecisions} repair decision(s) applied • " +
            $"{snapshot.DeferredRegions} deferred • {unresolved} unresolved local review region(s) • overall readiness {readiness}.";
    }

    internal static string GetRegionKey(AudioTranscriptionReviewRegion region)
    {
        ArgumentNullException.ThrowIfNull(region);
        var reasons = region.Reasons
            .Where(reason => !string.IsNullOrWhiteSpace(reason))
            .Distinct(StringComparer.Ordinal)
            .OrderBy(reason => reason, StringComparer.Ordinal);
        return $"{region.Start.Ticks}:{region.End.Ticks}:{string.Join('|', reasons)}";
    }

    private static void RequireCurrent(
        IReadOnlyList<AudioTranscriptionReviewRegion> currentRegions,
        AudioTranscriptionReviewRegion region)
    {
        ArgumentNullException.ThrowIfNull(currentRegions);
        ArgumentNullException.ThrowIfNull(region);
        var key = GetRegionKey(region);
        if (!currentRegions.Any(candidate => string.Equals(GetRegionKey(candidate), key, StringComparison.Ordinal)))
            throw new InvalidOperationException("The selected review region is stale and cannot be deferred.");
    }
}
