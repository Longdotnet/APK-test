using System.Runtime.CompilerServices;
using System.Text.Json;
using RobloxPiano.App;

internal static class AudioReviewDraftStorageMaintenanceRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var root = Path.Combine(Path.GetTempPath(), "RobloxPiano.AudioUxTests", "draft-gc-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(root);
        try
        {
            var now = new DateTimeOffset(2026, 9, 13, 12, 0, 0, TimeSpan.Zero);
            var referenced = new string('a', 64);
            var orphan = new string('b', 64);
            var youngOrphan = new string('c', 64);
            var sourceSha = new string('d', 64);
            var sourcePath = Path.Combine(root, "owned.wav");
            File.WriteAllText(sourcePath, "owned-audio-fixture");
            var managedDraftPath = Path.Combine(root, sourceSha + ".review.json");

            File.WriteAllText(managedDraftPath, JsonSerializer.Serialize(new
            {
                schemaVersion = AudioReviewDraftStore.SchemaVersion,
                sourcePath,
                sourceSha256 = sourceSha,
                evidenceSha256 = referenced,
                currentTrackSha256 = new string('e', 64),
                queue = new { deferredRegionKeys = Array.Empty<string>(), appliedDecisions = Array.Empty<object>() },
                savedAtUtc = now
            }));

            var referencedPath = Path.Combine(root, referenced + ".evidence.json");
            var orphanPath = Path.Combine(root, orphan + ".evidence.json");
            var youngOrphanPath = Path.Combine(root, youngOrphan + ".evidence.json");
            File.WriteAllText(referencedPath, "{}"); File.WriteAllText(orphanPath, "{}"); File.WriteAllText(youngOrphanPath, "{}");
            File.SetLastWriteTimeUtc(referencedPath, now.UtcDateTime - TimeSpan.FromDays(3));
            File.SetLastWriteTimeUtc(orphanPath, now.UtcDateTime - TimeSpan.FromDays(3));
            File.SetLastWriteTimeUtc(youngOrphanPath, now.UtcDateTime - TimeSpan.FromHours(2));

            var staleTemp = Path.Combine(root, orphan + ".evidence.json.tmp-deadbeef");
            File.WriteAllText(staleTemp, "partial"); File.SetLastWriteTimeUtc(staleTemp, now.UtcDateTime - TimeSpan.FromHours(12));
            var staleIndexTemp = Path.Combine(root, AudioReviewDraftLookupIndex.IndexFileName + ".tmp-deadbeef");
            File.WriteAllText(staleIndexTemp, "partial-index"); File.SetLastWriteTimeUtc(staleIndexTemp, now.UtcDateTime - TimeSpan.FromHours(12));
            var staleManifestTemp = Path.Combine(root, AudioReviewDraftMaintenanceManifest.FileName + ".tmp-deadbeef");
            File.WriteAllText(staleManifestTemp, "partial-manifest"); File.SetLastWriteTimeUtc(staleManifestTemp, now.UtcDateTime - TimeSpan.FromHours(12));

            var index = new AudioReviewDraftLookupIndex(new AudioReviewDraftStore(root));
            File.WriteAllText(index.IndexPath, "{broken-index");

            var result = AudioReviewDraftStorageMaintenance.RunBestEffort(root, now);
            Require(File.Exists(referencedPath), "referenced immutable evidence must never be garbage-collected");
            Require(!File.Exists(orphanPath), "unreferenced immutable evidence past the grace window should be collected");
            Require(File.Exists(youngOrphanPath), "recent orphan evidence must survive the safety grace window");
            Require(!File.Exists(staleTemp) && !File.Exists(staleIndexTemp) && !File.Exists(staleManifestTemp), "stale managed crash temp artifacts should be removed");
            Require(result.DeletedOrphanEvidenceCount == 1, "expected exactly one old orphan evidence deletion");
            Require(result.DeletedStaleTempCount == 3, "expected evidence, index and manifest stale temp deletion");
            Require(result.CheckpointsParsed == 1 && result.ManifestEntriesReused == 0, "cold maintenance should parse the checkpoint once while building metadata manifest");
            Require(!result.EvidenceGcSkipped && !result.ReviewIndexRebuildSkipped && result.ReviewIndexEntriesRebuilt == 1, "healthy bounded checkpoint should rebuild lookup and permit GC");
            Require(index.TryResolve(sourcePath) == managedDraftPath, "cold-start maintenance rebuild should make valid draft directly resolvable");

            var manifestPath = Path.Combine(root, AudioReviewDraftMaintenanceManifest.FileName);
            Require(File.Exists(manifestPath), "cold maintenance must persist rebuildable metadata manifest");
            var manifestText = File.ReadAllText(manifestPath);
            Require(!manifestText.Contains(Path.GetFullPath(sourcePath), StringComparison.OrdinalIgnoreCase), "maintenance manifest must not persist raw client audio path");
            var manifestBytes = File.ReadAllBytes(manifestPath);
            var manifestWriteTime = File.GetLastWriteTimeUtc(manifestPath);
            var indexBytes = File.ReadAllBytes(index.IndexPath);
            var indexWriteTime = File.GetLastWriteTimeUtc(index.IndexPath);

            var second = AudioReviewDraftStorageMaintenance.RunBestEffort(root, now + TimeSpan.FromMinutes(1));
            Require(second.CheckpointsParsed == 0 && second.ManifestEntriesReused == 1, "unchanged warm maintenance must reuse manifest metadata without reopening checkpoint JSON");
            Require(second.ReviewIndexEntriesRebuilt == 1 && index.TryResolve(sourcePath) == managedDraftPath, "warm maintenance must preserve direct lookup behavior");
            Require(indexBytes.SequenceEqual(File.ReadAllBytes(index.IndexPath)) && File.GetLastWriteTimeUtc(index.IndexPath) == indexWriteTime, "unchanged startup must perform zero committed index rewrites");
            Require(manifestBytes.SequenceEqual(File.ReadAllBytes(manifestPath)) && File.GetLastWriteTimeUtc(manifestPath) == manifestWriteTime, "unchanged startup must perform zero committed manifest rewrites");

            File.AppendAllText(managedDraftPath, " ");
            var changed = AudioReviewDraftStorageMaintenance.RunBestEffort(root, now + TimeSpan.FromMinutes(2));
            Require(changed.CheckpointsParsed == 1 && changed.ManifestEntriesReused == 0, "checkpoint identity change must invalidate manifest metadata and force authoritative reparse");

            var ambiguousRoot = Path.Combine(root, "ambiguous");
            Directory.CreateDirectory(ambiguousRoot);
            var ambiguousOrphan = Path.Combine(ambiguousRoot, new string('f', 64) + ".evidence.json");
            File.WriteAllText(ambiguousOrphan, "{}"); File.SetLastWriteTimeUtc(ambiguousOrphan, now.UtcDateTime - TimeSpan.FromDays(10));
            File.WriteAllText(Path.Combine(ambiguousRoot, new string('1', 64) + ".review.json"), "{not-json");
            var ambiguousResult = AudioReviewDraftStorageMaintenance.RunBestEffort(ambiguousRoot, now);
            Require(ambiguousResult.EvidenceGcSkipped && File.Exists(ambiguousOrphan), "malformed checkpoint must fail safe and preserve potentially-related evidence");
            var ambiguousWarm = AudioReviewDraftStorageMaintenance.RunBestEffort(ambiguousRoot, now + TimeSpan.FromMinutes(1));
            Require(ambiguousWarm.CheckpointsParsed == 0 && ambiguousWarm.ManifestEntriesReused == 1 && ambiguousWarm.EvidenceGcSkipped,
                "cached ambiguity may avoid repeat parse but must continue disabling evidence GC fail-safe");
        }
        finally { try { Directory.Delete(root, recursive: true); } catch { } }
    }

    private static void Require(bool condition, string message)
    {
        if (!condition) throw new InvalidOperationException("Audio review draft storage maintenance regression failed: " + message);
    }
}
