using System.Text.Json;

namespace RobloxPiano.App;

internal sealed record AudioReviewDraftStorageMaintenanceResult(
    int DraftsScanned,
    int ReferencedEvidenceCount,
    int DeletedOrphanEvidenceCount,
    int DeletedStaleTempCount,
    long ReclaimedBytes,
    long TotalBytesAfter,
    bool EvidenceGcSkipped,
    bool QuotaStillExceeded,
    int ReviewIndexEntriesRebuilt,
    bool ReviewIndexRebuildSkipped,
    int CheckpointsParsed,
    int ManifestEntriesReused);

internal static class AudioReviewDraftStorageMaintenance
{
    internal static readonly TimeSpan OrphanEvidenceGrace = TimeSpan.FromHours(24);
    internal static readonly TimeSpan StaleTempGrace = TimeSpan.FromHours(6);
    internal const long MaximumManagedBytes = 512L * 1024L * 1024L;
    internal const long TargetManagedBytes = 384L * 1024L * 1024L;
    private const long MaximumCheckpointBytes = 32L * 1024L * 1024L;
    private const int MaximumManagedFiles = 4096;

    public static AudioReviewDraftStorageMaintenanceResult RunBestEffort(string rootDirectory, DateTimeOffset? nowUtc = null)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(rootDirectory);
        var root = Path.GetFullPath(rootDirectory);
        if (!Directory.Exists(root))
            return new(0,0,0,0,0,0,false,false,0,false,0,0);
        try { return Run(root, nowUtc ?? DateTimeOffset.UtcNow); }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or JsonException or ArgumentException or InvalidDataException)
        {
            ClientDiagnostics.Log($"Audio review draft storage maintenance skipped: {exception.Message}");
            return new(0,0,0,0,0,SafeDirectoryBytes(root),true,false,0,true,0,0);
        }
    }

    private static AudioReviewDraftStorageMaintenanceResult Run(string root, DateTimeOffset nowUtc)
    {
        var files = new DirectoryInfo(root).EnumerateFiles("*", SearchOption.TopDirectoryOnly)
            .OrderBy(file => file.Name, StringComparer.OrdinalIgnoreCase).Take(MaximumManagedFiles + 1).ToArray();
        var scanTruncated = files.Length > MaximumManagedFiles;
        if (scanTruncated) files = files.Take(MaximumManagedFiles).ToArray();

        var reclaimedBytes = 0L;
        var deletedTemps = 0;
        foreach (var file in files.Where(IsManagedTempArtifact))
        {
            if (nowUtc - file.LastWriteTimeUtc < StaleTempGrace) continue;
            var length = SafeLength(file);
            if (TryDelete(file.FullName)) { reclaimedBytes += length; deletedTemps++; }
        }

        var checkpoints = files.Where(file => file.Name.EndsWith(".review.json", StringComparison.OrdinalIgnoreCase)).ToArray();
        var manifest = AudioReviewDraftMaintenanceManifest.LoadBestEffort(root);
        var manifestEntries = new List<AudioReviewDraftMaintenanceManifestEntry>();
        var referencedEvidence = new HashSet<string>(StringComparer.OrdinalIgnoreCase);
        var indexCandidates = new List<(string SourcePathKey, string DraftPath, DateTime LastWriteTimeUtc)>();
        var draftsScanned = 0;
        var checkpointsParsed = 0;
        var manifestEntriesReused = 0;
        var ambiguousCheckpoint = false;

        foreach (var checkpoint in checkpoints)
        {
            draftsScanned++;
            if (manifest.TryGetReusable(checkpoint, out var cached))
            {
                manifestEntriesReused++;
                manifestEntries.Add(cached);
                ApplyMetadata(cached, checkpoint.FullName, checkpoint.LastWriteTimeUtc, referencedEvidence, indexCandidates, ref ambiguousCheckpoint);
                continue;
            }

            checkpointsParsed++;
            var entry = ParseCheckpoint(checkpoint);
            manifestEntries.Add(entry);
            ApplyMetadata(entry, checkpoint.FullName, checkpoint.LastWriteTimeUtc, referencedEvidence, indexCandidates, ref ambiguousCheckpoint);
        }

        // File length + last-write time is intentionally only a cheap warm-start identity. It must never authorize a
        // destructive evidence deletion because external tooling can rewrite checkpoint bytes while preserving both.
        // If cached metadata makes an old evidence file look collectible, re-read every bounded checkpoint first and
        // base GC, manifest refresh and index rebuild on that authoritative snapshot.
        var destructiveCandidatesExist = !scanTruncated
            && !ambiguousCheckpoint
            && FindOrphanEvidenceCandidates(files, referencedEvidence, nowUtc).Length > 0;
        if (destructiveCandidatesExist && manifestEntriesReused > 0)
        {
            manifestEntries.Clear();
            referencedEvidence.Clear();
            indexCandidates.Clear();
            ambiguousCheckpoint = false;

            foreach (var checkpoint in checkpoints)
            {
                checkpointsParsed++;
                var entry = ParseCheckpoint(checkpoint);
                manifestEntries.Add(entry);
                ApplyMetadata(entry, checkpoint.FullName, checkpoint.LastWriteTimeUtc, referencedEvidence, indexCandidates, ref ambiguousCheckpoint);
            }
        }

        if (!scanTruncated)
        {
            try { manifest.ReplaceAll(manifestEntries); }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException or ArgumentException)
            { ClientDiagnostics.Log($"Audio review maintenance manifest rebuild skipped: {exception.Message}"); }
        }

        var indexRebuildSkipped = scanTruncated;
        var indexEntriesRebuilt = 0;
        if (!indexRebuildSkipped)
        {
            try
            {
                var lookupIndex = new AudioReviewDraftLookupIndex(new AudioReviewDraftStore(root));
                var ordered = indexCandidates.OrderBy(candidate => candidate.LastWriteTimeUtc)
                    .ThenBy(candidate => candidate.DraftPath, StringComparer.OrdinalIgnoreCase)
                    .Select(candidate => new KeyValuePair<string,string>(candidate.SourcePathKey, candidate.DraftPath));
                indexEntriesRebuilt = lookupIndex.ReplaceAllSourceKeys(ordered);
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException or ArgumentException)
            { ClientDiagnostics.Log($"Audio review draft lookup index rebuild skipped: {exception.Message}"); indexRebuildSkipped = true; }
        }

        var skipEvidenceGc = scanTruncated || ambiguousCheckpoint;
        var deletedEvidence = 0;
        if (!skipEvidenceGc)
        {
            foreach (var candidate in FindOrphanEvidenceCandidates(files, referencedEvidence, nowUtc))
            {
                var length = SafeLength(candidate.File);
                if (TryDelete(candidate.File.FullName)) { reclaimedBytes += length; deletedEvidence++; }
            }
        }

        var totalAfter = SafeDirectoryBytes(root);
        var quotaStillExceeded = totalAfter > MaximumManagedBytes;
        if (quotaStillExceeded)
            ClientDiagnostics.Log($"Audio review draft storage remains above the {MaximumManagedBytes} byte safety budget ({totalAfter} bytes). Active/recent/ambiguous review state was preserved; no authoritative checkpoint was deleted.");

        return new(draftsScanned, referencedEvidence.Count, deletedEvidence, deletedTemps, reclaimedBytes, totalAfter,
            skipEvidenceGc, quotaStillExceeded, indexEntriesRebuilt, indexRebuildSkipped, checkpointsParsed, manifestEntriesReused);
    }

    private static (FileInfo File, string Digest)[] FindOrphanEvidenceCandidates(
        IEnumerable<FileInfo> files,
        HashSet<string> referencedEvidence,
        DateTimeOffset nowUtc)
        => files.Where(file => file.Name.EndsWith(".evidence.json", StringComparison.OrdinalIgnoreCase))
            .Select(file => (File:file, Digest:Path.GetFileNameWithoutExtension(Path.GetFileNameWithoutExtension(file.Name))))
            .Where(candidate => IsSha256(candidate.Digest)
                && !referencedEvidence.Contains(candidate.Digest)
                && nowUtc - candidate.File.LastWriteTimeUtc >= OrphanEvidenceGrace)
            .OrderBy(candidate => candidate.File.LastWriteTimeUtc)
            .ThenBy(candidate => candidate.File.Name, StringComparer.OrdinalIgnoreCase)
            .ToArray();

    private static AudioReviewDraftMaintenanceManifestEntry ParseCheckpoint(FileInfo checkpoint)
    {
        checkpoint.Refresh();
        var length = checkpoint.Exists ? checkpoint.Length : 0L;
        var ticks = checkpoint.LastWriteTimeUtc.Ticks;
        if (length <= 0 || length > MaximumCheckpointBytes)
            return new(checkpoint.Name, Math.Max(1,length), Math.Max(1,ticks), null, null, true);
        try
        {
            using var stream = new FileStream(checkpoint.FullName, FileMode.Open, FileAccess.Read, FileShare.ReadWrite | FileShare.Delete);
            using var document = JsonDocument.Parse(stream);
            var root = document.RootElement;
            if (!root.TryGetProperty("schemaVersion", out var schemaElement) || schemaElement.ValueKind != JsonValueKind.Number || !schemaElement.TryGetInt32(out var schemaVersion))
                return new(checkpoint.Name, length, ticks, null, null, true);

            string? sourceKey = null;
            if (root.TryGetProperty("sourcePath", out var sourceElement) && sourceElement.ValueKind == JsonValueKind.String)
            {
                var sourcePath = sourceElement.GetString();
                if (!string.IsNullOrWhiteSpace(sourcePath)) sourceKey = AudioReviewDraftLookupIndex.ComputeSourcePathKey(sourcePath);
            }

            if (schemaVersion == AudioReviewDraftStore.LegacySchemaVersion)
                return new(checkpoint.Name, length, ticks, sourceKey, null, false);
            if (schemaVersion != AudioReviewDraftStore.SchemaVersion || !root.TryGetProperty("evidenceSha256", out var evidenceElement) || evidenceElement.ValueKind != JsonValueKind.String)
                return new(checkpoint.Name, length, ticks, sourceKey, null, true);
            var evidence = evidenceElement.GetString();
            if (!IsSha256(evidence)) return new(checkpoint.Name, length, ticks, sourceKey, null, true);
            return new(checkpoint.Name, length, ticks, sourceKey, evidence!.ToLowerInvariant(), false);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or JsonException)
        {
            ClientDiagnostics.Log($"Audio review draft maintenance kept evidence because checkpoint '{checkpoint.Name}' is unreadable: {exception.Message}");
            return new(checkpoint.Name, Math.Max(1,length), Math.Max(1,ticks), null, null, true);
        }
    }

    private static void ApplyMetadata(AudioReviewDraftMaintenanceManifestEntry entry, string draftPath, DateTime lastWriteTimeUtc,
        HashSet<string> referencedEvidence, List<(string SourcePathKey,string DraftPath,DateTime LastWriteTimeUtc)> indexCandidates, ref bool ambiguousCheckpoint)
    {
        ambiguousCheckpoint |= entry.Ambiguous;
        if (entry.EvidenceSha256 is not null) referencedEvidence.Add(entry.EvidenceSha256);
        if (entry.SourcePathKey is not null && AudioReviewDraftLookupIndex.IsManagedDraftFileName(entry.DraftFileName))
            indexCandidates.Add((entry.SourcePathKey, draftPath, lastWriteTimeUtc));
    }

    private static bool IsManagedTempArtifact(FileInfo file)
        => file.Name.Contains(".tmp-", StringComparison.OrdinalIgnoreCase) && !file.Name.StartsWith(".", StringComparison.Ordinal)
            && (file.Name.Contains(".review.json.tmp-", StringComparison.OrdinalIgnoreCase)
                || file.Name.Contains(".evidence.json.tmp-", StringComparison.OrdinalIgnoreCase)
                || file.Name.StartsWith(AudioReviewDraftLookupIndex.IndexFileName + ".tmp-", StringComparison.OrdinalIgnoreCase)
                || file.Name.StartsWith(AudioReviewDraftMaintenanceManifest.FileName + ".tmp-", StringComparison.OrdinalIgnoreCase));

    private static bool IsSha256(string? value) => value is { Length:64 } && value.All(Uri.IsHexDigit);
    private static long SafeDirectoryBytes(string root) { try { return new DirectoryInfo(root).EnumerateFiles("*", SearchOption.TopDirectoryOnly).Take(MaximumManagedFiles + 1).Sum(SafeLength); } catch (Exception e) when (e is IOException or UnauthorizedAccessException) { return 0; } }
    private static long SafeLength(FileInfo file) { try { file.Refresh(); return file.Exists ? file.Length : 0; } catch (Exception e) when (e is IOException or UnauthorizedAccessException) { return 0; } }
    private static bool TryDelete(string path) { try { if (!File.Exists(path)) return false; File.Delete(path); return true; } catch (Exception e) when (e is IOException or UnauthorizedAccessException) { ClientDiagnostics.Log($"Audio review draft maintenance could not delete '{Path.GetFileName(path)}': {e.Message}"); return false; } }
}
