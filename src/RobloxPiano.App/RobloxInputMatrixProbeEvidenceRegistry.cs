using System.Collections.Concurrent;

namespace RobloxPiano.App;

internal enum RobloxInputMatrixSyntheticProvenanceTrust
{
    Missing = 0,
    Clean = 1,
    Contaminated = 2
}

internal enum RobloxInputMatrixSyntheticProvenanceReason
{
    MissingSnapshot = 0,
    CleanInjectedPair = 1,
    DuplicateProbeId = 2,
    LowerIntegrityInjected = 3,
    PhysicalTargetContamination = 4,
    UnexpectedTargetTransition = 5,
    IncompleteInjectedPair = 6
}

internal readonly record struct RobloxInputMatrixSyntheticProvenanceAssessment(
    RobloxInputMatrixSyntheticProvenanceTrust Trust,
    RobloxInputMatrixSyntheticProvenanceReason Reason);

/// <summary>
/// Process-local bridge between a bounded synthetic probe and the matrix verdict that consumes it.
/// Probe IDs are unique; retained snapshots contain only target-W forensic metadata and never authorize playback.
/// </summary>
internal static class RobloxInputMatrixProbeEvidenceRegistry
{
    private const int MaxRetainedSnapshots = 256;
    private static readonly ConcurrentDictionary<string, WindowsLowLevelKeyboardProvenanceSnapshot> Snapshots = new(StringComparer.Ordinal);
    private static readonly ConcurrentDictionary<string, byte> DuplicateProbeIds = new(StringComparer.Ordinal);
    private static readonly ConcurrentQueue<string> RetentionOrder = new();

    internal static void Record(string probeId, WindowsLowLevelKeyboardProvenanceSnapshot snapshot)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(probeId);

        if (Snapshots.TryAdd(probeId, snapshot))
        {
            RetentionOrder.Enqueue(probeId);
            Trim();
            return;
        }

        // Probe IDs are intended to be unique and bind one human reaction to one bounded
        // low-level observation. Never overwrite the first retained snapshot: a replayed ID
        // could otherwise replace contaminated evidence with a later clean pair (or vice versa)
        // and silently change the matrix verdict after the fact. Keep the original evidence and
        // mark the ID permanently contaminated until the bounded registry entry is evicted/reset.
        DuplicateProbeIds.TryAdd(probeId, 0);
    }

    internal static RobloxInputMatrixSyntheticProvenanceTrust GetTrust(string probeId)
        => GetAssessment(probeId).Trust;

    internal static RobloxInputMatrixSyntheticProvenanceAssessment GetAssessment(string probeId)
    {
        if (string.IsNullOrWhiteSpace(probeId) || !Snapshots.TryGetValue(probeId, out var snapshot))
        {
            return new(
                RobloxInputMatrixSyntheticProvenanceTrust.Missing,
                RobloxInputMatrixSyntheticProvenanceReason.MissingSnapshot);
        }

        if (DuplicateProbeIds.ContainsKey(probeId))
        {
            return new(
                RobloxInputMatrixSyntheticProvenanceTrust.Contaminated,
                RobloxInputMatrixSyntheticProvenanceReason.DuplicateProbeId);
        }

        // LLKHF_LOWER_IL_INJECTED is useful forensic evidence, but it means Windows observed
        // the event as originating from a lower-integrity process. While Runtime Input P0 is
        // explicitly investigating UIPI/integrity boundaries, that event cannot safely prove
        // that a clean synthetic path reached the same trust boundary as Roblox. Fail closed
        // rather than allowing it to establish either a synthetic winner or an all-synthetic
        // Roblox-consumption failure.
        if (snapshot.LowerIntegrityInjectedTargetEventCount > 0
            || snapshot.DownProvenance == WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected
            || snapshot.UpProvenance == WindowsLowLevelKeyboardProvenanceKind.LowerIntegrityInjected)
        {
            return new(
                RobloxInputMatrixSyntheticProvenanceTrust.Contaminated,
                RobloxInputMatrixSyntheticProvenanceReason.LowerIntegrityInjected);
        }

        if (snapshot.PhysicalTargetContaminationObserved)
        {
            return new(
                RobloxInputMatrixSyntheticProvenanceTrust.Contaminated,
                RobloxInputMatrixSyntheticProvenanceReason.PhysicalTargetContamination);
        }

        if (snapshot.UnexpectedTargetTransitionObserved)
        {
            return new(
                RobloxInputMatrixSyntheticProvenanceTrust.Contaminated,
                RobloxInputMatrixSyntheticProvenanceReason.UnexpectedTargetTransition);
        }

        if (!snapshot.UncontaminatedInjectedPairObserved)
        {
            return new(
                RobloxInputMatrixSyntheticProvenanceTrust.Contaminated,
                RobloxInputMatrixSyntheticProvenanceReason.IncompleteInjectedPair);
        }

        return new(
            RobloxInputMatrixSyntheticProvenanceTrust.Clean,
            RobloxInputMatrixSyntheticProvenanceReason.CleanInjectedPair);
    }

    internal static bool TryGetSnapshot(string probeId, out WindowsLowLevelKeyboardProvenanceSnapshot snapshot)
        => Snapshots.TryGetValue(probeId, out snapshot);

    internal static void ResetForDiagnostics()
    {
        Snapshots.Clear();
        DuplicateProbeIds.Clear();
        while (RetentionOrder.TryDequeue(out _))
        {
        }
    }

    private static void Trim()
    {
        while (Snapshots.Count > MaxRetainedSnapshots && RetentionOrder.TryDequeue(out var oldestProbeId))
        {
            Snapshots.TryRemove(oldestProbeId, out _);
            DuplicateProbeIds.TryRemove(oldestProbeId, out _);
        }
    }
}
