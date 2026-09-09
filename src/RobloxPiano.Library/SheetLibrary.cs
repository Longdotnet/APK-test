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
    bool IsManaged);

public sealed class SheetLibraryService
{
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

    public static bool IsSupportedPath(string path) => SongSourceLoader.IsSupportedPath(path);

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
