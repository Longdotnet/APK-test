using RobloxPiano.Library;

namespace RobloxPiano.LibraryTests;

internal static class Program
{
    public static int Main()
    {
        var failures = new List<string>();
        Run("scan surfaces valid and invalid songs", TestScan, failures);
        Run("portable and managed catalogs include deterministic MIDI", TestPortableScan, failures);
        Run("import validates and allocates collision-safe names", TestImport, failures);
        Run("batch MIDI folder import becomes persistent list rows", TestBatchMidiFolderImport, failures);
        Run("batch import skips duplicate content deterministically", TestBatchDuplicateSuppression, failures);
        Run("MIDI compatibility adjustments remain visible in Library", TestMidiCompatibilityVisibility, failures);
        Run("source-neutral loader routes text and MIDI deterministically", TestSourceNeutralLoader, failures);
        Run("unsupported extension is rejected", TestUnsupportedExtension, failures);
        Run("empty first-run library receives playable starter songs", TestStarterBootstrap, failures);
        Run("starter bootstrap never pollutes an existing library", TestStarterPreservesExistingLibrary, failures);

        Console.WriteLine($"Song library regressions: {10 - failures.Count} passed, {failures.Count} failed.");
        foreach (var failure in failures)
        {
            Console.Error.WriteLine(failure);
        }
        return failures.Count == 0 ? 0 : 1;
    }

    private static void TestScan()
    {
        using var temp = new TempTree();
        File.WriteAllText(Path.Combine(temp.Managed, "valid.txt"), ValidSheet("Valid Song"));
        File.WriteAllText(Path.Combine(temp.Managed, "broken.txt"), "BPM=0\nt");

        var entries = new SheetLibraryService(temp.Managed).Scan();
        Equal(2, entries.Count, "entry count");
        var valid = entries.Single(entry => entry.FileName == "valid.txt");
        Equal(SheetValidationStatus.Valid, valid.Status, "valid status");
        Equal("Valid Song", valid.Title, "metadata title");
        Equal("TXT", valid.Format, "format label");
        True(valid.Duration > TimeSpan.Zero, "duration should be parsed");

        var broken = entries.Single(entry => entry.FileName == "broken.txt");
        Equal(SheetValidationStatus.Invalid, broken.Status, "broken status");
        True(!string.IsNullOrWhiteSpace(broken.Error), "invalid reason should be surfaced");
    }

    private static void TestPortableScan()
    {
        using var temp = new TempTree();
        File.WriteAllText(Path.Combine(temp.Managed, "managed.txt"), ValidSheet("Managed"));
        File.WriteAllText(Path.Combine(temp.Portable, "portable.vps"), ValidSheet("Portable"));
        File.WriteAllBytes(Path.Combine(temp.Portable, "midi.mid"), ValidMidi("Portable MIDI"));

        var entries = new SheetLibraryService(temp.Managed, temp.Portable).Scan();
        Equal(3, entries.Count, "managed + portable count");
        True(entries.Any(entry => entry.Title == "Managed" && entry.IsManaged), "managed flag");
        True(entries.Any(entry => entry.Title == "Portable" && !entry.IsManaged), "portable flag");
        True(entries.Any(entry => entry.Title == "Portable MIDI" && !entry.IsManaged && entry.Format == "MIDI"), "MIDI should be a normal portable library song");
    }

    private static void TestImport()
    {
        using var temp = new TempTree();
        var source = Path.Combine(temp.Root, "song.mid");
        File.WriteAllBytes(source, ValidMidi("Imported MIDI"));

        var library = new SheetLibraryService(temp.Managed);
        var first = library.Import(source);
        var second = library.Import(source);

        True(first.Path.EndsWith("song.mid", StringComparison.OrdinalIgnoreCase), "first import name");
        True(second.Path.EndsWith("song (2).mid", StringComparison.OrdinalIgnoreCase), "collision suffix");
        True(File.Exists(first.Path) && File.Exists(second.Path), "both imports persisted");
        Equal(SheetValidationStatus.Valid, first.Status, "imported MIDI remains valid");

        var invalid = Path.Combine(temp.Root, "invalid.mid");
        File.WriteAllBytes(invalid, [0x00, 0x01, 0x02]);
        Throws<FormatException>(() => library.Import(invalid), "invalid import");
        True(!File.Exists(Path.Combine(temp.Managed, "invalid.mid")), "invalid import must not enter library");
    }

    private static void TestBatchMidiFolderImport()
    {
        using var temp = new TempTree();
        var collection = Path.Combine(temp.Root, "collection");
        var nested = Path.Combine(collection, "nested");
        Directory.CreateDirectory(nested);
        File.WriteAllBytes(Path.Combine(collection, "alpha.mid"), ValidMidi("Alpha"));
        File.WriteAllBytes(Path.Combine(nested, "beta.midi"), ValidMidi("Beta"));
        File.WriteAllText(Path.Combine(collection, "ignore.mp3"), "not a supported source");

        var library = new SheetLibraryService(temp.Managed);
        var result = library.ImportBatch([collection]);

        Equal(2, result.Imported.Count, "two supported MIDI files should import recursively");
        Equal(0, result.Existing.Count, "first batch has no duplicates");
        Equal(0, result.Failed.Count, "unsupported files inside a folder are ignored, not treated as failed song candidates");

        var rows = library.Scan();
        Equal(2, rows.Count, "imported MIDI collection must become two persistent Library rows");
        True(rows.All(entry => entry.Format == "MIDI" && entry.Status == SheetValidationStatus.Valid), "every imported MIDI row should be playable");
        True(rows.Any(entry => entry.Title == "Alpha") && rows.Any(entry => entry.Title == "Beta"), "MIDI titles should survive lowering into the list");
    }

    private static void TestBatchDuplicateSuppression()
    {
        using var temp = new TempTree();
        var firstSource = Path.Combine(temp.Root, "first.mid");
        var duplicateSource = Path.Combine(temp.Root, "different-name.mid");
        var bytes = ValidMidi("Same Song");
        File.WriteAllBytes(firstSource, bytes);
        File.WriteAllBytes(duplicateSource, bytes);

        var library = new SheetLibraryService(temp.Managed);
        var first = library.ImportBatch([firstSource]);
        var second = library.ImportBatch([duplicateSource, firstSource]);

        Equal(1, first.Imported.Count, "first batch should import one song");
        Equal(0, second.Imported.Count, "same content must never create numbered duplicate rows in batch mode");
        Equal(1, second.Existing.Count, "duplicate candidates collapse to one deterministic source candidate then resolve to the existing row");
        Equal(1, library.Scan().Count, "Library should still contain only one row for identical MIDI content");
    }

    private static void TestMidiCompatibilityVisibility()
    {
        using var temp = new TempTree();
        var source = Path.Combine(temp.Root, "compat.mid");
        File.WriteAllBytes(source, CompatibilityMidi());

        var library = new SheetLibraryService(temp.Managed);
        var result = library.ImportBatch([source]);
        Equal(1, result.Imported.Count, "compatibility MIDI should still import");
        Equal(1, result.AdjustedCount, "batch should count compatibility-adjusted imports");

        var row = library.Scan().Single();
        Equal("MIDI", row.Format, "compatibility metadata must not replace source type");
        True(row.HasCompatibilityAdjustment, "Library row should mark compatibility adjustment");
        True(row.Compatibility.Contains("range auto-fit +1 st", StringComparison.Ordinal), "auto-fit should be visible to the client");
        True(row.Compatibility.Contains("ignored 1 drum note", StringComparison.Ordinal), "percussion filtering should be visible to the client");

        var loaded = SongSourceLoader.Load(row.Path);
        True(loaded.Metadata?.HasCompatibilityAdjustment == true, "source-neutral load metadata should preserve compatibility visibility");
        Equal(1, loaded.Metadata!.EffectiveTransposeSemitones!.Value, "effective transpose metadata");
        Equal(1, loaded.Metadata.IgnoredPercussionNoteOns, "ignored percussion metadata");
    }

    private static void TestSourceNeutralLoader()
    {
        using var temp = new TempTree();
        var textPath = Path.Combine(temp.Root, "legacy.vps");
        var midiPath = Path.Combine(temp.Root, "song.midi");
        File.WriteAllText(textPath, ValidSheet("Legacy"));
        File.WriteAllBytes(midiPath, ValidMidi("MIDI"));

        var text = SongSourceLoader.Load(textPath);
        var midi = SongSourceLoader.Load(midiPath);
        Equal(SongSourceKind.LegacyText, text.SourceKind, "legacy source kind");
        Equal(SongSourceKind.Midi, midi.SourceKind, "MIDI source kind");
        Equal("Legacy", text.Track.Title, "legacy title");
        Equal("MIDI", midi.Track.Title, "MIDI title");
        True(text.Track.Events.Count > 0 && midi.Track.Events.Count > 0, "both source types lower to canonical playback events");
        True(text.Metadata is null, "legacy load should not invent MIDI compatibility metadata");
        Equal("source preserved", midi.Metadata?.Summary ?? string.Empty, "in-range MIDI should explicitly report source preservation");
    }

    private static void TestUnsupportedExtension()
    {
        using var temp = new TempTree();
        var source = Path.Combine(temp.Root, "song.pdf");
        File.WriteAllText(source, "not supported");
        Throws<FormatException>(() => new SheetLibraryService(temp.Managed).Import(source), "unsupported extension");
    }

    private static void TestStarterBootstrap()
    {
        using var temp = new TempTree();
        var library = new SheetLibraryService(temp.Managed);
        var entries = library.EnsureStarterLibrary();

        Equal(3, entries.Count, "starter song count");
        True(entries.All(entry => entry.Status == SheetValidationStatus.Valid), "every starter song must pass deterministic validation");
        True(entries.All(entry => entry.IsManaged), "starter songs belong to the managed client library");
        True(entries.Any(entry => entry.Title == "Starter Melody"), "starter melody missing");
        True(entries.Any(entry => entry.Title == "Starter Chords"), "starter chords missing");
        True(entries.Any(entry => entry.Title == "Starter Warmup"), "starter warmup missing");

        var second = library.EnsureStarterLibrary();
        Equal(3, second.Count, "starter bootstrap must be idempotent");
        Equal(3, Directory.EnumerateFiles(temp.Managed).Count(), "bootstrap must not duplicate starter files");
    }

    private static void TestStarterPreservesExistingLibrary()
    {
        using var temp = new TempTree();
        File.WriteAllText(Path.Combine(temp.Managed, "mine.txt"), ValidSheet("My Existing Song"));
        var library = new SheetLibraryService(temp.Managed);

        var entries = library.EnsureStarterLibrary();
        Equal(1, entries.Count, "existing library must not receive unsolicited starter songs");
        Equal("My Existing Song", entries[0].Title, "existing song must remain untouched");
        True(!Directory.EnumerateFiles(temp.Managed).Any(path => Path.GetFileName(path).StartsWith("starter-", StringComparison.OrdinalIgnoreCase)), "starter files should not be written into a non-empty library");
    }

    private static string ValidSheet(string title) => $"""
        TITLE={title}
        BPM=120
        SUBDIV=4
        START_DELAY=0
        CHORD_HOLD=0.5
        t r [ad] . w
        """;

    private static byte[] ValidMidi(string title)
    {
        var track = new List<byte>();
        track.AddRange([0x00, 0xFF, 0x03, (byte)title.Length]);
        track.AddRange(System.Text.Encoding.ASCII.GetBytes(title));
        track.AddRange([0x00, 0x90, 60, 100]);
        track.AddRange([0x83, 0x60, 0x80, 60, 0]);
        track.AddRange([0x00, 0xFF, 0x2F, 0x00]);
        return BuildMidi(track);
    }

    private static byte[] CompatibilityMidi()
    {
        var track = new List<byte>();
        track.AddRange([0x00, 0xFF, 0x03, 0x06]);
        track.AddRange("Compat"u8.ToArray());
        track.AddRange([0x00, 0x99, 38, 100]);
        track.AddRange([0x00, 0x90, 35, 100]);
        track.AddRange([0x78, 0x89, 38, 0]);
        track.AddRange([0x00, 0x80, 35, 0]);
        track.AddRange([0x00, 0xFF, 0x2F, 0x00]);
        return BuildMidi(track);
    }

    private static byte[] BuildMidi(IReadOnlyCollection<byte> track)
    {
        var bytes = new List<byte>();
        bytes.AddRange("MThd"u8.ToArray());
        bytes.AddRange([0x00, 0x00, 0x00, 0x06, 0x00, 0x00, 0x00, 0x01, 0x01, 0xE0]);
        bytes.AddRange("MTrk"u8.ToArray());
        bytes.AddRange([(byte)(track.Count >> 24), (byte)(track.Count >> 16), (byte)(track.Count >> 8), (byte)track.Count]);
        bytes.AddRange(track);
        return bytes.ToArray();
    }

    private static void Run(string name, Action test, ICollection<string> failures)
    {
        try
        {
            test();
            Console.WriteLine($"PASS  {name}");
        }
        catch (Exception exception)
        {
            failures.Add($"FAIL  {name}: {exception}");
        }
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }

    private static void Throws<T>(Action action, string message) where T : Exception
    {
        try
        {
            action();
        }
        catch (T)
        {
            return;
        }
        throw new InvalidOperationException($"{message}: expected {typeof(T).Name}.");
    }

    private sealed class TempTree : IDisposable
    {
        public TempTree()
        {
            Root = Path.Combine(Path.GetTempPath(), "RobloxPiano.LibraryTests", Guid.NewGuid().ToString("N"));
            Managed = Path.Combine(Root, "managed");
            Portable = Path.Combine(Root, "portable");
            Directory.CreateDirectory(Managed);
            Directory.CreateDirectory(Portable);
        }

        public string Root { get; }
        public string Managed { get; }
        public string Portable { get; }

        public void Dispose()
        {
            try
            {
                Directory.Delete(Root, recursive: true);
            }
            catch
            {
            }
        }
    }
}
