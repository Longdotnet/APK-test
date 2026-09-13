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
            Require(result.CheckpointsParsed == 2 && result.ManifestEntriesReused == 0, "destructive cold maintenance must parse once for discovery and once while binding GC to checkpoint content fingerprints");
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
            Require(second.CheckpointsParsed == 0 && second.ManifestEntriesReused == 1, "unchanged warm maintenance must reuse manifest metadata without reopening checkpoint JSON when no destructive candidate exists");
            Require(second.ReviewIndexEntriesRebuilt == 1 && index.TryResolve(sourcePath) == managedDraftPath, "warm maintenance must preserve direct lookup behavior");
            Require(indexBytes.SequenceEqual(File.ReadAllBytes(index.IndexPath)) && File.GetLastWriteTimeUtc(index.IndexPath) == indexWriteTime, "unchanged startup must perform zero committed index rewrites");
            Require(manifestBytes.SequenceEqual(File.ReadAllBytes(manifestPath)) && File.GetLastWriteTimeUtc(manifestPath) == manifestWriteTime, "unchanged startup must perform zero committed manifest rewrites");

            File.AppendAllText(managedDraftPath, " ");
            var changed = AudioReviewDraftStorageMaintenance.RunBestEffort(root, now + TimeSpan.FromMinutes(2));
            Require(changed.CheckpointsParsed == 1 && changed.ManifestEntriesReused == 0, "checkpoint identity change without a destructive candidate must invalidate manifest metadata and force authoritative reparse");

            var tamperRoot = Path.Combine(root, "same-metadata-tamper");
            Directory.CreateDirectory(tamperRoot);
            var oldEvidence = new string('2', 64);
            var newlyReferencedEvidence = new string('3', 64);
            var tamperSourceSha = new string('4', 64);
            var tamperSourcePath = Path.Combine(tamperRoot, "owned.wav");
            File.WriteAllText(tamperSourcePath, "owned-audio-fixture");
            var tamperDraftPath = Path.Combine(tamperRoot, tamperSourceSha + ".review.json");
            string CreateTamperCheckpoint(string evidenceSha) => JsonSerializer.Serialize(new
            {
                schemaVersion = AudioReviewDraftStore.SchemaVersion,
                sourcePath = tamperSourcePath,
                sourceSha256 = tamperSourceSha,
                evidenceSha256 = evidenceSha,
                currentTrackSha256 = new string('5', 64),
                queue = new { deferredRegionKeys = Array.Empty<string>(), appliedDecisions = Array.Empty<object>() },
                savedAtUtc = now
            });

            var initialCheckpoint = CreateTamperCheckpoint(oldEvidence);
            var tamperedCheckpoint = CreateTamperCheckpoint(newlyReferencedEvidence);
            Require(initialCheckpoint.Length == tamperedCheckpoint.Length, "tamper fixture must preserve checkpoint byte length");
            File.WriteAllText(tamperDraftPath, initialCheckpoint);
            var originalCheckpointWriteTime = File.GetLastWriteTimeUtc(tamperDraftPath);
            var oldEvidencePath = Path.Combine(tamperRoot, oldEvidence + ".evidence.json");
            var newlyReferencedEvidencePath = Path.Combine(tamperRoot, newlyReferencedEvidence + ".evidence.json");
            File.WriteAllText(oldEvidencePath, "{}");
            File.WriteAllText(newlyReferencedEvidencePath, "{}");
            File.SetLastWriteTimeUtc(oldEvidencePath, now.UtcDateTime - TimeSpan.FromDays(3));
            File.SetLastWriteTimeUtc(newlyReferencedEvidencePath, now.UtcDateTime - TimeSpan.FromHours(2));

            var tamperCold = AudioReviewDraftStorageMaintenance.RunBestEffort(tamperRoot, now);
            Require(tamperCold.CheckpointsParsed == 1 && File.Exists(oldEvidencePath) && File.Exists(newlyReferencedEvidencePath),
                "cold tamper fixture with no destructive candidate must preserve the no-extra-hash path");

            File.WriteAllText(tamperDraftPath, tamperedCheckpoint);
            File.SetLastWriteTimeUtc(tamperDraftPath, originalCheckpointWriteTime);
            File.SetLastWriteTimeUtc(newlyReferencedEvidencePath, now.UtcDateTime - TimeSpan.FromDays(3));
            Require(new FileInfo(tamperDraftPath).Length == initialCheckpoint.Length && File.GetLastWriteTimeUtc(tamperDraftPath) == originalCheckpointWriteTime,
                "tamper fixture must preserve cached length and last-write identity");

            var tamperWarm = AudioReviewDraftStorageMaintenance.RunBestEffort(tamperRoot, now + TimeSpan.FromMinutes(1));
            Require(tamperWarm.ManifestEntriesReused == 1 && tamperWarm.CheckpointsParsed == 1,
                "destructive GC opportunity must rebuild an authoritative fingerprinted snapshot even when cheap manifest identity still matches");
            Require(File.Exists(newlyReferencedEvidencePath),
                "evidence newly referenced by same-length/same-mtime checkpoint bytes must survive fail-safe GC revalidation");
            Require(!File.Exists(oldEvidencePath) && tamperWarm.DeletedOrphanEvidenceCount == 1,
                "after authoritative fingerprinted revalidation only the truly unreferenced old evidence may be collected");

            var raceRoot = Path.Combine(root, "destructive-race");
            Directory.CreateDirectory(raceRoot);
            var raceInitialEvidence = new string('6', 64);
            var raceCandidateEvidence = new string('7', 64);
            var raceSourceSha = new string('8', 64);
            var raceSourcePath = Path.Combine(raceRoot, "owned.wav");
            File.WriteAllText(raceSourcePath, "owned-audio-fixture");
            var raceDraftPath = Path.Combine(raceRoot, raceSourceSha + ".review.json");
            string CreateRaceCheckpoint(string evidenceSha) => JsonSerializer.Serialize(new
            {
                schemaVersion = AudioReviewDraftStore.SchemaVersion,
                sourcePath = raceSourcePath,
                sourceSha256 = raceSourceSha,
                evidenceSha256 = evidenceSha,
                currentTrackSha256 = new string('9', 64),
                queue = new { deferredRegionKeys = Array.Empty<string>(), appliedDecisions = Array.Empty<object>() },
                savedAtUtc = now
            });
            var raceInitialCheckpoint = CreateRaceCheckpoint(raceInitialEvidence);
            var raceChangedCheckpoint = CreateRaceCheckpoint(raceCandidateEvidence);
            Require(raceInitialCheckpoint.Length == raceChangedCheckpoint.Length, "race fixture must preserve checkpoint byte length");
            File.WriteAllText(raceDraftPath, raceInitialCheckpoint);
            var raceOriginalWriteTime = File.GetLastWriteTimeUtc(raceDraftPath);
            var raceInitialEvidencePath = Path.Combine(raceRoot, raceInitialEvidence + ".evidence.json");
            var raceCandidateEvidencePath = Path.Combine(raceRoot, raceCandidateEvidence + ".evidence.json");
            File.WriteAllText(raceInitialEvidencePath, "{}");
            File.WriteAllText(raceCandidateEvidencePath, "{}");
            File.SetLastWriteTimeUtc(raceInitialEvidencePath, now.UtcDateTime - TimeSpan.FromDays(3));
            File.SetLastWriteTimeUtc(raceCandidateEvidencePath, now.UtcDateTime - TimeSpan.FromDays(3));

            var hookInvoked = false;
            var raced = AudioReviewDraftStorageMaintenance.RunBestEffortForTests(raceRoot, now, () =>
            {
                hookInvoked = true;
                File.WriteAllText(raceDraftPath, raceChangedCheckpoint);
                File.SetLastWriteTimeUtc(raceDraftPath, raceOriginalWriteTime);
            });
            Require(hookInvoked, "race regression must mutate the checkpoint after the authoritative destructive snapshot and before final revalidation");
            Require(raced.EvidenceGcSkipped && raced.DeletedOrphanEvidenceCount == 0 && raced.ReviewIndexRebuildSkipped,
                "checkpoint mutation in the destructive window must abort evidence GC and stale cache rebuilds fail-safe");
            Require(File.Exists(raceInitialEvidencePath) && File.Exists(raceCandidateEvidencePath),
                "TOCTOU abort must preserve both the previously referenced evidence and the evidence concurrently made authoritative");

            var raceRecovery = AudioReviewDraftStorageMaintenance.RunBestEffort(raceRoot, now + TimeSpan.FromMinutes(1));
            Require(!raceRecovery.EvidenceGcSkipped && raceRecovery.DeletedOrphanEvidenceCount == 1,
                "the next stable maintenance pass should safely reclaim only the evidence that is now truly orphaned");
            Require(!File.Exists(raceInitialEvidencePath) && File.Exists(raceCandidateEvidencePath),
                "stable recovery must retain the concurrently selected evidence and reclaim only the old reference");

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
