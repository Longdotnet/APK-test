using System.Text.Json;

namespace RobloxPiano.App;

internal sealed record AudioReviewDraftMaintenanceManifestEntry(
    string DraftFileName,
    long Length,
    long LastWriteTimeUtcTicks,
    string? SourcePathKey,
    string? EvidenceSha256,
    bool Ambiguous);

internal sealed record AudioReviewDraftMaintenanceManifestDocument(
    int SchemaVersion,
    Dictionary<string, AudioReviewDraftMaintenanceManifestEntry> Entries);

/// <summary>
/// Disposable metadata accelerator for bounded review-storage maintenance. It stores only managed checkpoint file
/// identity plus source-path/evidence hashes and an ambiguity bit. It never stores raw source paths, repair decisions,
/// Basic Pitch notes or canonical PerformanceTrack state. Missing/corrupt/stale state is rebuilt from checkpoints.
/// </summary>
internal sealed class AudioReviewDraftMaintenanceManifest
{
    private const int SchemaVersion = 1;
    private const int MaximumEntries = 4096;
    private const long MaximumBytes = 1024 * 1024;
    internal const string FileName = "review-maintenance.json";
    private static readonly JsonSerializerOptions JsonOptions = new(JsonSerializerDefaults.Web) { WriteIndented = false };

    private readonly string rootDirectory;
    private readonly string path;
    private readonly Dictionary<string, AudioReviewDraftMaintenanceManifestEntry> entries;

    private AudioReviewDraftMaintenanceManifest(
        string rootDirectory,
        Dictionary<string, AudioReviewDraftMaintenanceManifestEntry>? entries = null)
    {
        this.rootDirectory = Path.GetFullPath(rootDirectory);
        path = Path.Combine(this.rootDirectory, FileName);
        this.entries = entries ?? new Dictionary<string, AudioReviewDraftMaintenanceManifestEntry>(StringComparer.OrdinalIgnoreCase);
    }

    internal string ManifestPath => path;

    internal static AudioReviewDraftMaintenanceManifest LoadBestEffort(string rootDirectory)
    {
        var root = Path.GetFullPath(rootDirectory);
        var manifestPath = Path.Combine(root, FileName);
        try
        {
            var info = new FileInfo(manifestPath);
            if (!info.Exists || info.Length <= 0 || info.Length > MaximumBytes)
                return new(root);

            using var stream = new FileStream(manifestPath, FileMode.Open, FileAccess.Read, FileShare.ReadWrite | FileShare.Delete);
            var document = JsonSerializer.Deserialize<AudioReviewDraftMaintenanceManifestDocument>(stream, JsonOptions);
            if (document is null || document.SchemaVersion != SchemaVersion || document.Entries is null || document.Entries.Count > MaximumEntries)
                return new(root);

            var validated = new Dictionary<string, AudioReviewDraftMaintenanceManifestEntry>(StringComparer.OrdinalIgnoreCase);
            foreach (var pair in document.Entries)
            {
                var entry = pair.Value;
                if (!AudioReviewDraftLookupIndex.IsManagedDraftFileName(pair.Key)
                    || !string.Equals(pair.Key, entry.DraftFileName, StringComparison.OrdinalIgnoreCase)
                    || entry.Length <= 0
                    || entry.LastWriteTimeUtcTicks <= 0
                    || (entry.SourcePathKey is not null && !IsSha256(entry.SourcePathKey))
                    || (entry.EvidenceSha256 is not null && !IsSha256(entry.EvidenceSha256)))
                    return new(root);
                validated[pair.Key.ToLowerInvariant()] = entry with
                {
                    DraftFileName = pair.Key.ToLowerInvariant(),
                    SourcePathKey = entry.SourcePathKey?.ToLowerInvariant(),
                    EvidenceSha256 = entry.EvidenceSha256?.ToLowerInvariant()
                };
            }
            return new(root, validated);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or JsonException or InvalidDataException)
        {
            return new(root);
        }
    }

    internal bool TryGetReusable(FileInfo checkpoint, out AudioReviewDraftMaintenanceManifestEntry entry)
    {
        entry = default!;
        checkpoint.Refresh();
        if (!checkpoint.Exists || !entries.TryGetValue(checkpoint.Name, out var candidate))
            return false;
        if (candidate.Length != checkpoint.Length || candidate.LastWriteTimeUtcTicks != checkpoint.LastWriteTimeUtc.Ticks)
            return false;
        entry = candidate;
        return true;
    }

    internal bool ReplaceAll(IEnumerable<AudioReviewDraftMaintenanceManifestEntry> replacement)
    {
        ArgumentNullException.ThrowIfNull(replacement);
        var normalized = replacement
            .Where(entry => AudioReviewDraftLookupIndex.IsManagedDraftFileName(entry.DraftFileName))
            .Take(MaximumEntries)
            .ToDictionary(
                entry => entry.DraftFileName.ToLowerInvariant(),
                entry => entry with
                {
                    DraftFileName = entry.DraftFileName.ToLowerInvariant(),
                    SourcePathKey = entry.SourcePathKey?.ToLowerInvariant(),
                    EvidenceSha256 = entry.EvidenceSha256?.ToLowerInvariant()
                },
                StringComparer.OrdinalIgnoreCase);

        Directory.CreateDirectory(rootDirectory);
        var ordered = normalized
            .OrderBy(pair => pair.Key, StringComparer.Ordinal)
            .ToDictionary(pair => pair.Key, pair => pair.Value, StringComparer.Ordinal);
        var bytes = JsonSerializer.SerializeToUtf8Bytes(
            new AudioReviewDraftMaintenanceManifestDocument(SchemaVersion, ordered),
            JsonOptions);
        if (bytes.LongLength <= 0 || bytes.LongLength > MaximumBytes)
            throw new InvalidDataException("Audio review maintenance manifest exceeds its safety bound.");

        if (ExistingBytesMatch(bytes))
            return false;

        var tempPath = path + ".tmp-" + Guid.NewGuid().ToString("N");
        try
        {
            using (var stream = new FileStream(tempPath, FileMode.CreateNew, FileAccess.Write, FileShare.None, 16 * 1024, FileOptions.WriteThrough))
            {
                stream.Write(bytes);
                stream.Flush(flushToDisk: true);
            }
            File.Move(tempPath, path, overwrite: true);
            return true;
        }
        finally
        {
            try { if (File.Exists(tempPath)) File.Delete(tempPath); } catch (IOException) { } catch (UnauthorizedAccessException) { }
        }
    }

    private bool ExistingBytesMatch(ReadOnlySpan<byte> expected)
    {
        try
        {
            var info = new FileInfo(path);
            if (!info.Exists || info.Length != expected.Length || info.Length <= 0 || info.Length > MaximumBytes)
                return false;
            return expected.SequenceEqual(File.ReadAllBytes(path));
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
        {
            return false;
        }
    }

    private static bool IsSha256(string? value)
        => value is { Length: 64 } && value.All(static character =>
            character is >= '0' and <= '9' or >= 'a' and <= 'f' or >= 'A' and <= 'F');
}
