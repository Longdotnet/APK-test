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

            File.WriteAllText(Path.Combine(root, "source.review.json"), JsonSerializer.Serialize(new
            {
                schemaVersion = AudioReviewDraftStore.SchemaVersion,
                sourcePath = "owned.wav",
                sourceSha256 = new string('d', 64),
                evidenceSha256 = referenced,
                currentTrackSha256 = new string('e', 64),
                queue = new { deferredRegionKeys = Array.Empty<string>(), appliedDecisions = Array.Empty<object>() },
                savedAtUtc = now
            }));

            var referencedPath = Path.Combine(root, referenced + ".evidence.json");
            var orphanPath = Path.Combine(root, orphan + ".evidence.json");
            var youngOrphanPath = Path.Combine(root, youngOrphan + ".evidence.json");
            File.WriteAllText(referencedPath, "{}");
            File.WriteAllText(orphanPath, "{}");
            File.WriteAllText(youngOrphanPath, "{}");
            File.SetLastWriteTimeUtc(referencedPath, now.UtcDateTime - TimeSpan.FromDays(3));
            File.SetLastWriteTimeUtc(orphanPath, now.UtcDateTime - TimeSpan.FromDays(3));
            File.SetLastWriteTimeUtc(youngOrphanPath, now.UtcDateTime - TimeSpan.FromHours(2));

            var staleTemp = Path.Combine(root, orphan + ".evidence.json.tmp-deadbeef");
            File.WriteAllText(staleTemp, "partial");
            File.SetLastWriteTimeUtc(staleTemp, now.UtcDateTime - TimeSpan.FromHours(12));

            var result = AudioReviewDraftStorageMaintenance.RunBestEffort(root, now);
            Require(File.Exists(referencedPath), "referenced immutable evidence must never be garbage-collected");
            Require(!File.Exists(orphanPath), "unreferenced immutable evidence past the grace window should be collected");
            Require(File.Exists(youngOrphanPath), "recent orphan evidence must survive the safety grace window");
            Require(!File.Exists(staleTemp), "crash-left managed temp artifact past its grace window should be removed");
            Require(result.DeletedOrphanEvidenceCount == 1, "expected exactly one old orphan evidence deletion");
            Require(result.DeletedStaleTempCount == 1, "expected exactly one stale temp deletion");
            Require(!result.EvidenceGcSkipped, "healthy bounded checkpoints should permit orphan evidence GC");

            var ambiguousRoot = Path.Combine(root, "ambiguous");
            Directory.CreateDirectory(ambiguousRoot);
            var ambiguousOrphan = Path.Combine(ambiguousRoot, new string('f', 64) + ".evidence.json");
            File.WriteAllText(ambiguousOrphan, "{}");
            File.SetLastWriteTimeUtc(ambiguousOrphan, now.UtcDateTime - TimeSpan.FromDays(10));
            File.WriteAllText(Path.Combine(ambiguousRoot, "broken.review.json"), "{not-json");

            var ambiguousResult = AudioReviewDraftStorageMaintenance.RunBestEffort(ambiguousRoot, now);
            Require(ambiguousResult.EvidenceGcSkipped, "malformed checkpoint must fail safe by disabling evidence GC");
            Require(File.Exists(ambiguousOrphan), "ambiguous review state must preserve potentially-related evidence");
        }
        finally
        {
            try { Directory.Delete(root, recursive: true); } catch { }
        }
    }

    private static void Require(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException("Audio review draft storage maintenance regression failed: " + message);
    }
}
