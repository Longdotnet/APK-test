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
    bool ReviewIndexRebuildSkipped);

/// <summary>
/// Best-effort, fail-safe cleanup for local Audio-to-Piano review persistence. It never deletes review checkpoints.
/// Immutable evidence is eligible for GC only when every bounded checkpoint was readable, no checkpoint references it,
/// and the evidence has aged past the safety window. Crash-left temporary artifacts use a shorter grace period because
/// they are never authoritative persistence paths. Active/corrupt/ambiguous state always wins over reclaiming disk.
/// A disposable lookup index is rebuilt from authoritative readable checkpoints after a complete bounded scan.
/// </summary>
internal static class AudioReviewDraftStorageMaintenance
{
    internal static readonly TimeSpan OrphanEvidenceGrace = TimeSpan.FromHours(24);
    internal static readonly TimeSpan StaleTempGrace = TimeSpan.FromHours(6);
    internal const long MaximumManagedBytes = 512L * 1024L * 1024L;
    internal const long TargetManagedBytes = 384L * 1024L * 1024L;
    private const long MaximumCheckpointBytes = 32L * 1024L * 1024L;
    private const int MaximumManagedFiles = 4096;

    public static AudioReviewDraftStorageMaintenanceResult RunBestEffort(
        string rootDirectory,
        DateTimeOffset? nowUtc = null)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(rootDirectory);
        var root = Path.GetFullPath(rootDirectory);
        if (!Directory.Exists(root))
            return new(0, 0, 0, 0, 0, 0, false, false, 0, false);

        try
        {
            return Run(root, nowUtc ?? DateTimeOffset.UtcNow);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or JsonException or ArgumentException or InvalidDataException)
        {
            ClientDiagnostics.Log($"Audio review draft storage maintenance skipped: {exception.Message}");
            return new(0, 0, 0, 0, 0, SafeDirectoryBytes(root), true, false, 0, true);
        }
    }

    private static AudioReviewDraftStorageMaintenanceResult Run(string root, DateTimeOffset nowUtc)
    {
        var files = new DirectoryInfo(root)
            .EnumerateFiles("*", SearchOption.TopDirectoryOnly)
            .OrderBy(file => file.Name, StringComparer.OrdinalIgnoreCase)
            .Take(MaximumManagedFiles + 1)
            .ToArray();
        var scanTruncated = files.Length > MaximumManagedFiles;
        if (scanTruncated)
            files = files.Take(MaximumManagedFiles).ToArray();

        var reclaimedBytes = 0L;
        var deletedTemps = 0;
        foreach (var file in files.Where(IsManagedTempArtifact))
        {
            if (nowUtc - file.LastWriteTimeUtc < StaleTempGrace)
                continue;
            var length = SafeLength(file);
            if (TryDelete(file.FullName))
            {
                reclaimedBytes += length;
                deletedTemps++;
            }
        }

        var referencedEvidence = new HashSet<string>(StringComparer.OrdinalIgnoreCase);
        var indexCandidates = new List<KeyValuePair<string, string>>();
        var draftsScanned = 0;
        var ambiguousCheckpoint = false;
        foreach (var checkpoint in files.Where(file => file.Name.EndsWith(".review.json", StringComparison.OrdinalIgnoreCase)))
        {
            draftsScanned++;
            if (checkpoint.Length <= 0 || checkpoint.Length > MaximumCheckpointBytes)
            {
                ambiguousCheckpoint = true;
                continue;
            }

            try
            {
                using var stream = new FileStream(checkpoint.FullName, FileMode.Open, FileAccess.Read, FileShare.ReadWrite | FileShare.Delete);
                using var document = JsonDocument.Parse(stream);
                var rootElement = document.RootElement;
                if (!rootElement.TryGetProperty("schemaVersion", out var schemaElement)
                    || schemaElement.ValueKind != JsonValueKind.Number
                    || !schemaElement.TryGetInt32(out var schemaVersion))
                {
                    ambiguousCheckpoint = true;
                    continue;
                }

                if (TryGetSourcePath(rootElement, out var sourcePath)
                    && AudioReviewDraftLookupIndex.IsManagedDraftFileName(checkpoint.Name))
                {
                    indexCandidates.Add(new KeyValuePair<string, string>(sourcePath, checkpoint.FullName));
                }

                if (schemaVersion == AudioReviewDraftStore.LegacySchemaVersion)
                    continue;
                if (schemaVersion != AudioReviewDraftStore.SchemaVersion
                    || !rootElement.TryGetProperty("evidenceSha256", out var evidenceElement)
                    || evidenceElement.ValueKind != JsonValueKind.String)
                {
                    ambiguousCheckpoint = true;
                    continue;
                }

                var evidenceSha256 = evidenceElement.GetString();
                if (!IsSha256(evidenceSha256))
                {
                    ambiguousCheckpoint = true;
                    continue;
                }
                referencedEvidence.Add(evidenceSha256!.ToLowerInvariant());
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or JsonException)
            {
                ClientDiagnostics.Log($"Audio review draft maintenance kept evidence because checkpoint '{checkpoint.Name}' is unreadable: {exception.Message}");
                ambiguousCheckpoint = true;
            }
        }

        var indexRebuildSkipped = scanTruncated;
        var indexEntriesRebuilt = 0;
        if (!indexRebuildSkipped)
        {
            try
            {
                var lookupIndex = new AudioReviewDraftLookupIndex(new AudioReviewDraftStore(root));
                indexEntriesRebuilt = lookupIndex.ReplaceAll(indexCandidates);
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException or ArgumentException)
            {
                ClientDiagnostics.Log($"Audio review draft lookup index rebuild skipped: {exception.Message}");
                indexRebuildSkipped = true;
            }
        }

        var skipEvidenceGc = scanTruncated || ambiguousCheckpoint;
        var deletedEvidence = 0;
        if (!skipEvidenceGc)
        {
            var orphanCandidates = files
                .Where(file => file.Name.EndsWith(".evidence.json", StringComparison.OrdinalIgnoreCase))
                .Select(file => (File: file, Digest: Path.GetFileNameWithoutExtension(Path.GetFileNameWithoutExtension(file.Name))))
                .Where(candidate => IsSha256(candidate.Digest)
                    && !referencedEvidence.Contains(candidate.Digest)
                    && nowUtc - candidate.File.LastWriteTimeUtc >= OrphanEvidenceGrace)
                .OrderBy(candidate => candidate.File.LastWriteTimeUtc)
                .ThenBy(candidate => candidate.File.Name, StringComparer.OrdinalIgnoreCase)
                .ToArray();

            foreach (var candidate in orphanCandidates)
            {
                var length = SafeLength(candidate.File);
                if (TryDelete(candidate.File.FullName))
                {
                    reclaimedBytes += length;
                    deletedEvidence++;
                }
            }
        }

        var totalAfter = SafeDirectoryBytes(root);
        var quotaStillExceeded = totalAfter > MaximumManagedBytes;
        if (quotaStillExceeded)
        {
            ClientDiagnostics.Log(
                $"Audio review draft storage remains above the {MaximumManagedBytes} byte safety budget ({totalAfter} bytes). " +
                "Active/recent/ambiguous review state was preserved; no authoritative checkpoint was deleted.");
        }

        return new(
            draftsScanned,
            referencedEvidence.Count,
            deletedEvidence,
            deletedTemps,
            reclaimedBytes,
            totalAfter,
            skipEvidenceGc,
            quotaStillExceeded,
            indexEntriesRebuilt,
            indexRebuildSkipped);
    }

    private static bool TryGetSourcePath(JsonElement rootElement, out string sourcePath)
    {
        sourcePath = string.Empty;
        if (!rootElement.TryGetProperty("sourcePath", out var sourcePathElement)
            || sourcePathElement.ValueKind != JsonValueKind.String)
            return false;
        var candidate = sourcePathElement.GetString();
        if (string.IsNullOrWhiteSpace(candidate))
            return false;
        sourcePath = candidate;
        return true;
    }

    private static bool IsManagedTempArtifact(FileInfo file)
        => file.Name.Contains(".tmp-", StringComparison.OrdinalIgnoreCase)
            && !file.Name.StartsWith(".", StringComparison.Ordinal)
            && (file.Name.Contains(".review.json.tmp-", StringComparison.OrdinalIgnoreCase)
                || file.Name.Contains(".evidence.json.tmp-", StringComparison.OrdinalIgnoreCase)
                || file.Name.StartsWith(AudioReviewDraftLookupIndex.IndexFileName + ".tmp-", StringComparison.OrdinalIgnoreCase));

    private static bool IsSha256(string? value)
        => value is { Length: 64 } && value.All(Uri.IsHexDigit);

    private static long SafeDirectoryBytes(string root)
    {
        try
        {
            return new DirectoryInfo(root)
                .EnumerateFiles("*", SearchOption.TopDirectoryOnly)
                .Take(MaximumManagedFiles + 1)
                .Sum(SafeLength);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
        {
            return 0;
        }
    }

    private static long SafeLength(FileInfo file)
    {
        try
        {
            file.Refresh();
            return file.Exists ? file.Length : 0L;
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
        {
            return 0L;
        }
    }

    private static bool TryDelete(string path)
    {
        try
        {
            if (!File.Exists(path))
                return false;
            File.Delete(path);
            return true;
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
        {
            ClientDiagnostics.Log($"Audio review draft maintenance could not delete '{Path.GetFileName(path)}': {exception.Message}");
            return false;
        }
    }
}
