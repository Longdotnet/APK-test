using System.Collections.Concurrent;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;

namespace RobloxPiano.App;

internal sealed record AudioReviewDraftLookupIndexDocument(
    int SchemaVersion,
    Dictionary<string, string> Entries);

/// <summary>
/// Local-only lookup accelerator for resumable Audio-to-Piano review drafts. The index stores only a SHA-256 of the
/// normalized source path and a managed draft filename; it never stores playback state, evidence or repaired tracks.
/// Missing/corrupt/stale index state is disposable: callers fall back to authoritative draft discovery and repopulate
/// the requested entry. Restore remains responsible for full source hashing, evidence validation, deterministic repair
/// replay and canonical PerformanceTrack fingerprint verification.
/// </summary>
internal sealed class AudioReviewDraftLookupIndex
{
    private const int SchemaVersion = 1;
    private const int MaximumEntries = 4096;
    private const long MaximumIndexBytes = 1024 * 1024;
    private const string IndexFileName = "review-index.json";
    private const string ZeroSha256 = "0000000000000000000000000000000000000000000000000000000000000000";
    private static readonly ConcurrentDictionary<string, object> RootGates = new(StringComparer.OrdinalIgnoreCase);
    private static readonly JsonSerializerOptions JsonOptions = new(JsonSerializerDefaults.Web) { WriteIndented = false };

    private readonly string rootDirectory;
    private readonly string indexPath;
    private readonly object rootGate;

    public AudioReviewDraftLookupIndex(AudioReviewDraftStore store)
    {
        ArgumentNullException.ThrowIfNull(store);
        rootDirectory = Path.GetDirectoryName(store.GetDraftPath(ZeroSha256))
            ?? throw new InvalidOperationException("Audio review draft root directory could not be resolved.");
        rootDirectory = Path.GetFullPath(rootDirectory);
        indexPath = Path.Combine(rootDirectory, IndexFileName);
        rootGate = RootGates.GetOrAdd(rootDirectory, static _ => new object());
    }

    internal string IndexPath => indexPath;

    public string? TryResolve(string sourcePath)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        lock (rootGate)
        {
            var document = TryReadDocument();
            if (document is null)
                return null;

            var sourceKey = ComputeSourcePathKey(sourcePath);
            if (!document.Entries.TryGetValue(sourceKey, out var draftFileName)
                || !TryResolveManagedDraftPath(draftFileName, out var draftPath))
                return null;

            if (File.Exists(draftPath))
                return draftPath;

            document.Entries.Remove(sourceKey);
            TryWriteDocument(document);
            return null;
        }
    }

    public void Upsert(string sourcePath, string draftPath)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        ArgumentException.ThrowIfNullOrWhiteSpace(draftPath);
        var draftFileName = GetManagedDraftFileName(draftPath);
        var sourceKey = ComputeSourcePathKey(sourcePath);

        lock (rootGate)
        {
            Directory.CreateDirectory(rootDirectory);
            var document = TryReadDocument() ?? new AudioReviewDraftLookupIndexDocument(
                SchemaVersion,
                new Dictionary<string, string>(StringComparer.Ordinal));

            document.Entries[sourceKey] = draftFileName;
            if (document.Entries.Count > MaximumEntries)
            {
                // The index is disposable acceleration state. Rather than inventing an eviction ordering that could
                // imply authority, keep the just-touched entry and let future authoritative discoveries repopulate.
                document = new AudioReviewDraftLookupIndexDocument(
                    SchemaVersion,
                    new Dictionary<string, string>(StringComparer.Ordinal)
                    {
                        [sourceKey] = draftFileName
                    });
            }

            WriteDocument(document);
        }
    }

    public void RemoveDraft(string draftPath)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(draftPath);
        var draftFileName = GetManagedDraftFileName(draftPath);
        lock (rootGate)
        {
            var document = TryReadDocument();
            if (document is null)
                return;

            var removed = false;
            foreach (var key in document.Entries
                         .Where(pair => string.Equals(pair.Value, draftFileName, StringComparison.OrdinalIgnoreCase))
                         .Select(pair => pair.Key)
                         .ToArray())
            {
                removed |= document.Entries.Remove(key);
            }

            if (!removed)
                return;
            if (document.Entries.Count == 0)
            {
                TryDeleteIndex();
                return;
            }
            WriteDocument(document);
        }
    }

    internal static string ComputeSourcePathKey(string sourcePath)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        var normalized = Path.GetFullPath(sourcePath)
            .TrimEnd(Path.DirectorySeparatorChar, Path.AltDirectorySeparatorChar)
            .ToUpperInvariant();
        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(normalized))).ToLowerInvariant();
    }

    private AudioReviewDraftLookupIndexDocument? TryReadDocument()
    {
        try
        {
            var fileInfo = new FileInfo(indexPath);
            if (!fileInfo.Exists || fileInfo.Length <= 0 || fileInfo.Length > MaximumIndexBytes)
                return null;

            using var stream = new FileStream(indexPath, FileMode.Open, FileAccess.Read, FileShare.Read);
            var document = JsonSerializer.Deserialize<AudioReviewDraftLookupIndexDocument>(stream, JsonOptions);
            if (document is null || document.SchemaVersion != SchemaVersion || document.Entries is null
                || document.Entries.Count > MaximumEntries)
                return null;

            var validated = new Dictionary<string, string>(StringComparer.Ordinal);
            foreach (var pair in document.Entries)
            {
                if (!IsSha256(pair.Key) || !IsManagedDraftFileName(pair.Value))
                    return null;
                validated[pair.Key.ToLowerInvariant()] = pair.Value.ToLowerInvariant();
            }
            return new AudioReviewDraftLookupIndexDocument(SchemaVersion, validated);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or JsonException or InvalidDataException)
        {
            return null;
        }
    }

    private void WriteDocument(AudioReviewDraftLookupIndexDocument document)
    {
        Directory.CreateDirectory(rootDirectory);
        var bytes = JsonSerializer.SerializeToUtf8Bytes(document, JsonOptions);
        if (bytes.LongLength <= 0 || bytes.LongLength > MaximumIndexBytes)
            throw new InvalidDataException("Audio review draft lookup index exceeds its safety bound.");

        var tempPath = indexPath + ".tmp-" + Guid.NewGuid().ToString("N");
        try
        {
            using (var stream = new FileStream(tempPath, FileMode.CreateNew, FileAccess.Write, FileShare.None, 16 * 1024, FileOptions.WriteThrough))
            {
                stream.Write(bytes);
                stream.Flush(flushToDisk: true);
            }
            File.Move(tempPath, indexPath, overwrite: true);
        }
        finally
        {
            try
            {
                if (File.Exists(tempPath))
                    File.Delete(tempPath);
            }
            catch (IOException)
            {
            }
            catch (UnauthorizedAccessException)
            {
            }
        }
    }

    private void TryWriteDocument(AudioReviewDraftLookupIndexDocument document)
    {
        try
        {
            if (document.Entries.Count == 0)
                TryDeleteIndex();
            else
                WriteDocument(document);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException)
        {
            // An accelerator must never make authoritative draft discovery or restore unavailable.
        }
    }

    private void TryDeleteIndex()
    {
        try
        {
            if (File.Exists(indexPath))
                File.Delete(indexPath);
        }
        catch (IOException)
        {
        }
        catch (UnauthorizedAccessException)
        {
        }
    }

    private string GetManagedDraftFileName(string draftPath)
    {
        var normalizedDraftPath = Path.GetFullPath(draftPath);
        var directory = Path.GetDirectoryName(normalizedDraftPath);
        var fileName = Path.GetFileName(normalizedDraftPath);
        if (!string.Equals(directory, rootDirectory, StringComparison.OrdinalIgnoreCase) || !IsManagedDraftFileName(fileName))
            throw new InvalidDataException("Audio review draft lookup index only accepts managed checkpoint paths.");
        return fileName.ToLowerInvariant();
    }

    private bool TryResolveManagedDraftPath(string draftFileName, out string draftPath)
    {
        draftPath = string.Empty;
        if (!IsManagedDraftFileName(draftFileName))
            return false;
        var candidate = Path.GetFullPath(Path.Combine(rootDirectory, draftFileName));
        if (!string.Equals(Path.GetDirectoryName(candidate), rootDirectory, StringComparison.OrdinalIgnoreCase))
            return false;
        draftPath = candidate;
        return true;
    }

    private static bool IsManagedDraftFileName(string? value)
    {
        if (string.IsNullOrWhiteSpace(value) || !value.EndsWith(".review.json", StringComparison.OrdinalIgnoreCase))
            return false;
        return IsSha256(value[..^".review.json".Length]);
    }

    private static bool IsSha256(string? value)
        => value is { Length: 64 } && value.All(static character =>
            character is >= '0' and <= '9' or >= 'a' and <= 'f' or >= 'A' and <= 'F');
}
