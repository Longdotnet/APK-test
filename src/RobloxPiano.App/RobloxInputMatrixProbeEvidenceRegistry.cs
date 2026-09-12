using System.Collections.Concurrent;

namespace RobloxPiano.App;

internal enum RobloxInputMatrixSyntheticProvenanceTrust
{
    Missing = 0,
    Clean = 1,
    Contaminated = 2
}

/// <summary>
/// Process-local bridge between a bounded synthetic probe and the matrix verdict that consumes it.
/// Probe IDs are unique; retained snapshots contain only target-W forensic metadata and never authorize playback.
/// </summary>
internal static class RobloxInputMatrixProbeEvidenceRegistry
{
    private const int MaxRetainedSnapshots = 256;
    private static readonly ConcurrentDictionary<string, WindowsLowLevelKeyboardProvenanceSnapshot> Snapshots = new(StringComparer.Ordinal);
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

        Snapshots[probeId] = snapshot;
    }

    internal static RobloxInputMatrixSyntheticProvenanceTrust GetTrust(string probeId)
    {
        if (string.IsNullOrWhiteSpace(probeId) || !Snapshots.TryGetValue(probeId, out var snapshot))
        {
            return RobloxInputMatrixSyntheticProvenanceTrust.Missing;
        }

        return snapshot.UncontaminatedInjectedPairObserved
            ? RobloxInputMatrixSyntheticProvenanceTrust.Clean
            : RobloxInputMatrixSyntheticProvenanceTrust.Contaminated;
    }

    internal static bool TryGetSnapshot(string probeId, out WindowsLowLevelKeyboardProvenanceSnapshot snapshot)
        => Snapshots.TryGetValue(probeId, out snapshot);

    internal static void ResetForDiagnostics()
    {
        Snapshots.Clear();
        while (RetentionOrder.TryDequeue(out _))
        {
        }
    }

    private static void Trim()
    {
        while (Snapshots.Count > MaxRetainedSnapshots && RetentionOrder.TryDequeue(out var oldestProbeId))
        {
            Snapshots.TryRemove(oldestProbeId, out _);
        }
    }
}
