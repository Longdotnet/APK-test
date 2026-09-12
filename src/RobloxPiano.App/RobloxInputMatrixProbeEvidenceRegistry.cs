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
            return RobloxInputMatrixSyntheticProvenanceTrust.Contaminated;
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
