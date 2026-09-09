using System.Security.Cryptography;
using RobloxPiano.Core;

namespace RobloxPiano.Library;

public enum SheetValidationStatus
{
    Valid = 0,
    Invalid = 1
}

public sealed record SheetLibraryEntry(
    string Path,
    string FileName,
    string Title,
    double? Bpm,
    int? EventCount,
    TimeSpan? Duration,
    SheetValidationStatus Status,
    string? Error,
    bool IsManaged)
{
    public string Format => Path.GetExtension(Path).ToLowerInvariant() switch
    {
        ".mid" or ".midi" => "MIDI",
        ".musicxml" or ".xml" => "MusicXML",
        ".vps" => "VPS",
        ".txt" => "TXT",
        _ => Path.GetExtension(Path).TrimStart('.').ToUpperInvariant()
    };
}

public sealed record SheetImportFailure(string SourcePath, string Error);

public sealed record SheetImportBatchResult(
    IReadOnlyList<SheetLibraryEntry> Imported,
    IReadOnlyList<SheetLibraryEntry> Existing,
    IReadOnlyList<SheetImportFailure> Failed)
{
    public int TotalCandidates => Imported.Count + Existing.Count + Failed.Count;
}

public sealed class SheetLibraryService
{
    private const int MaxBatchCandidates = 2000;

    private static readonly (string FileName, string Content)[] StarterSongs =
    [
        ("starter-melody.txt", """
            TITLE=Starter Melody
            BPM=120
            SUBDIV=4
            START_DELAY=0
            CHORD_HOLD=0.5
            LOOPS=1

            t r y u i u y r
            t . r . [ty] . [ru] .
            """),
        ("starter-chords.txt", """
            TITLE=Starter Chords
            BPM=96
            SUBDIV=4
            START_DELAY=0
            CHORD_HOLD=0.7
            LOOPS=1

            [ad] . [sf] . [dg] . [fh] .
            [ad] [sf] [dg] [fh]
            """),
        ("starter-warmup.txt", """
            TITLE=Starter Warmup
            BPM=132
            SUBDIV=4
            START_DELAY=0
            CHORD_HOLD=0.45
            LOOPS=1

            a s d f g h j h g f d s a
            """)
    ];

    public SheetLibraryService(string managedDirectory, string? portableDirectory = null)
    {
        ManagedDirectory = Path.GetFullPath(managedDirectory ?? throw new ArgumentNullException(nameof(managedDirectory)));
        PortableDirectory = string.IsNullOrWhiteSpace(portableDirectory)
            ? null
            : Path.GetFullPath(portableDirectory);
    }

    public string ManagedDirectory { get; }
    public string? PortableDirectory { get; }

    public IReadOnlyList<SheetLibraryEntry> Scan()
    {
        Directory.CreateDirectory(ManagedDirectory);

        var seen = new HashSet<string>(StringComparer.OrdinalIgnoreCase);
        var entries = new List<SheetLibraryEntry>();
        AddDirectory(entries, seen, ManagedDirectory, isManaged: true);
        if (PortableDirectory is not null && Directory.Exists(PortableDirectory))
        {
            AddDirectory(entries, seen, PortableDirectory, isManaged: false);
        }

        return entries
            .OrderBy(entry => entry.Status)
            .ThenBy(entry => entry.Title, StringComparer.CurrentCultureIgnoreCase)
            .ThenBy(entry => entry.FileName, StringComparer.CurrentCultureIgnoreCase)
            .ToArray();
    }

    public IReadOnlyList<SheetLibraryEntry> EnsureStarterLibrary()
    {
        Directory.CreateDirectory(ManagedDirectory);
        if (Directory.EnumerateFiles(ManagedDirectory, "*", SearchOption.TopDirectoryOnly).Any(IsSupportedPath))
        {
            return Scan();
        }

        foreach (var starter in StarterSongs)
        {
            var path = Path.Combine(ManagedDirectory, starter.FileName);
            if (!File.Exists(path))
            {
                File.WriteAllText(path, starter.Content.Replace("\r\n", "\n", StringComparison.Ordinal));
            }
        }

        var entries = Scan();
        if (entries.Count == 0 || entries.Any(entry => entry.Status != SheetValidationStatus.Valid))
        {
            throw new InvalidOperationException("Built-in starter songs failed deterministic library validation.");
        }

        return entries;
    }

    public SheetLibraryEntry Import(string sourcePath)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        var source = Path.GetFullPath(sourcePath);
        if (!File.Exists(source))
        {
            throw new FileNotFoundException("Song file does not exist.", source);
        }

        EnsureSupported(source);
        var validated = ReadEntry(source, isManaged: false);
        if (validated.Status != SheetValidationStatus.Valid)
        {
            throw new FormatException(validated.Error ?? "Song is invalid.");
        }

        Directory.CreateDirectory(ManagedDirectory);
        var target = CreateCollisionSafeDestination(Path.GetFileName(source));
        if (!source.Equals(target, StringComparison.OrdinalIgnoreCase))
        {
            File.Copy(source, target, overwrite: false);
        }

        return ReadEntry(target, isManaged: true);
    }

    public SheetImportBatchResult ImportBatch(IEnumerable<string> sourcePaths)
    {
        ArgumentNullException.ThrowIfNull(sourcePaths);
        Directory.CreateDirectory(ManagedDirectory);

        var failures = new List<SheetImportFailure>();
        var candidates = ExpandImportCandidates(sourcePaths, failures);
        if (candidates.Count > MaxBatchCandidates)
        {
            throw new InvalidOperationException(
                $"Import contains {candidates.Count} supported song files. The safety limit is {MaxBatchCandidates} files per batch.");
        }

        var imported = new List<SheetLibraryEntry>();
        var existing = new List<SheetLibraryEntry>();
        var managedByHash = BuildManagedHashIndex();

        foreach (var source in candidates)
        {
            try
            {
                var validated = ReadEntry(source, isManaged: false);
                if (validated.Status != SheetValidationStatus.Valid)
                {
                    failures.Add(new SheetImportFailure(source, validated.Error ?? "Song is invalid."));
                    continue;
                }

                var hash = ComputeContentHash(source);
                if (managedByHash.TryGetValue(hash, out var duplicate))
                {
                    existing.Add(duplicate);
                    continue;
                }

                var entry = Import(source);
                imported.Add(entry);
                managedByHash[hash] = entry;
            }
            catch (Exception exception) when (
                exception is IOException
                or UnauthorizedAccessException
                or FormatException
                or ArgumentException
                or OverflowException
                or InvalidOperationException)
            {
                failures.Add(new SheetImportFailure(source, exception.Message));
            }
        }

        return new SheetImportBatchResult(imported, existing, failures);
    }

    public static bool IsSupportedPath(string path) => SongSourceLoader.IsSupportedPath(path);

    public static bool IsMidiPath(string path)
    {
        var extension = Path.GetExtension(path);
        return extension.Equals(".mid", StringComparison.OrdinalIgnoreCase)
            || extension.Equals(".midi", StringComparison.OrdinalIgnoreCase);
    }

    private IReadOnlyList<string> ExpandImportCandidates(
        IEnumerable<string> sourcePaths,
        ICollection<SheetImportFailure> failures)
    {
        var candidates = new HashSet<string>(StringComparer.OrdinalIgnoreCase);
        foreach (var rawPath in sourcePaths)
        {
            if (string.IsNullOrWhiteSpace(rawPath))
            {
                continue;
            }

            string fullPath;
            try
            {
                fullPath = Path.GetFullPath(rawPath);
            }
            catch (Exception exception) when (exception is ArgumentException or NotSupportedException or PathTooLongException)
            {
                failures.Add(new SheetImportFailure(rawPath, exception.Message));
                continue;
            }

            if (File.Exists(fullPath))
            {
                if (IsSupportedPath(fullPath))
                {
                    candidates.Add(fullPath);
                }
                else
                {
                    failures.Add(new SheetImportFailure(fullPath, "Unsupported song type."));
                }
                continue;
            }

            if (Directory.Exists(fullPath))
            {
                try
                {
                    foreach (var file in Directory.EnumerateFiles(fullPath, "*", SearchOption.AllDirectories)
                                 .Where(IsSupportedPath))
                    {
                        candidates.Add(Path.GetFullPath(file));
                        if (candidates.Count > MaxBatchCandidates)
                        {
                            break;
                        }
                    }
                }
                catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
                {
                    failures.Add(new SheetImportFailure(fullPath, exception.Message));
                }
                continue;
            }

            failures.Add(new SheetImportFailure(fullPath, "File or folder does not exist."));
        }

        return candidates.OrderBy(path => path, StringComparer.OrdinalIgnoreCase).ToArray();
    }

    private Dictionary<string, SheetLibraryEntry> BuildManagedHashIndex()
    {
        var result = new Dictionary<string, SheetLibraryEntry>(StringComparer.Ordinal);
        foreach (var path in Directory.EnumerateFiles(ManagedDirectory, "*", SearchOption.TopDirectoryOnly)
                     .Where(IsSupportedPath))
        {
            try
            {
                var entry = ReadEntry(path, isManaged: true);
                if (entry.Status != SheetValidationStatus.Valid)
                {
                    continue;
                }

                result.TryAdd(ComputeContentHash(path), entry);
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
            {
                // A transiently unreadable existing file must not block importing other songs.
            }
        }

        return result;
    }

    private static string ComputeContentHash(string path)
    {
        using var stream = File.OpenRead(path);
        return Convert.ToHexString(SHA256.HashData(stream));
    }

    private void AddDirectory(
        ICollection<SheetLibraryEntry> entries,
        ISet<string> seen,
        string directory,
        bool isManaged)
    {
        foreach (var path in Directory.EnumerateFiles(directory, "*", SearchOption.TopDirectoryOnly))
        {
            if (!IsSupportedPath(path))
            {
                continue;
            }

            var fullPath = Path.GetFullPath(path);
            if (!seen.Add(fullPath))
            {
                continue;
            }

            entries.Add(ReadEntry(fullPath, isManaged));
        }
    }

    private static SheetLibraryEntry ReadEntry(string path, bool isManaged)
    {
        try
        {
            var loaded = SongSourceLoader.Load(path);
            var track = loaded.Track;
            return new SheetLibraryEntry(
                path,
                Path.GetFileName(path),
                string.IsNullOrWhiteSpace(track.Title) ? Path.GetFileNameWithoutExtension(path) : track.Title,
                track.Bpm,
                track.Events.Count,
                track.TimelineDuration,
                SheetValidationStatus.Valid,
                null,
                isManaged);
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or FormatException
            or ArgumentException
            or OverflowException)
        {
            return new SheetLibraryEntry(
                path,
                Path.GetFileName(path),
                Path.GetFileNameWithoutExtension(path),
                null,
                null,
                null,
                SheetValidationStatus.Invalid,
                exception.Message,
                isManaged);
        }
    }

    private string CreateCollisionSafeDestination(string fileName)
    {
        var safeName = Path.GetFileName(fileName);
        var candidate = Path.Combine(ManagedDirectory, safeName);
        if (!File.Exists(candidate))
        {
            return candidate;
        }

        var stem = Path.GetFileNameWithoutExtension(safeName);
        var extension = Path.GetExtension(safeName);
        for (var suffix = 2; suffix < 10000; suffix++)
        {
            candidate = Path.Combine(ManagedDirectory, $"{stem} ({suffix}){extension}");
            if (!File.Exists(candidate))
            {
                return candidate;
            }
        }

        throw new IOException("Could not allocate a unique managed song filename.");
    }

    private static void EnsureSupported(string path)
    {
        if (!IsSupportedPath(path))
        {
            throw new FormatException("Choose a supported song: .txt, .vps, .mid, .midi, .musicxml, or .xml.");
        }
    }
}
