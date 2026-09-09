using RobloxPiano.Library;

namespace RobloxPiano.LibraryTests;

internal static class Program
{
    public static int Main()
    {
        var failures = new List<string>();
        Run("scan surfaces valid and invalid sheets", TestScan, failures);
        Run("portable and managed catalogs deduplicate exact paths", TestPortableScan, failures);
        Run("import validates and allocates collision-safe names", TestImport, failures);
        Run("unsupported extension is rejected", TestUnsupportedExtension, failures);

        Console.WriteLine($"Sheet library regressions: {4 - failures.Count} passed, {failures.Count} failed.");
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
        File.WriteAllText(Path.Combine(temp.Portable, "ignore.mid"), "not-supported-yet");

        var entries = new SheetLibraryService(temp.Managed, temp.Portable).Scan();
        Equal(2, entries.Count, "managed + portable count");
        True(entries.Any(entry => entry.Title == "Managed" && entry.IsManaged), "managed flag");
        True(entries.Any(entry => entry.Title == "Portable" && !entry.IsManaged), "portable flag");
    }

    private static void TestImport()
    {
        using var temp = new TempTree();
        var source = Path.Combine(temp.Root, "song.txt");
        File.WriteAllText(source, ValidSheet("Imported"));

        var library = new SheetLibraryService(temp.Managed);
        var first = library.Import(source);
        var second = library.Import(source);

        True(first.Path.EndsWith("song.txt", StringComparison.OrdinalIgnoreCase), "first import name");
        True(second.Path.EndsWith("song (2).txt", StringComparison.OrdinalIgnoreCase), "collision suffix");
        True(File.Exists(first.Path) && File.Exists(second.Path), "both imports persisted");
        Equal(SheetValidationStatus.Valid, first.Status, "imported sheet remains valid");

        var invalid = Path.Combine(temp.Root, "invalid.txt");
        File.WriteAllText(invalid, "SUBDIV=0\nt");
        Throws<FormatException>(() => library.Import(invalid), "invalid import");
        True(!File.Exists(Path.Combine(temp.Managed, "invalid.txt")), "invalid import must not enter library");
    }

    private static void TestUnsupportedExtension()
    {
        using var temp = new TempTree();
        var source = Path.Combine(temp.Root, "song.mid");
        File.WriteAllText(source, ValidSheet("Wrong extension"));
        Throws<FormatException>(() => new SheetLibraryService(temp.Managed).Import(source), "unsupported extension");
    }

    private static string ValidSheet(string title) => $"""
        TITLE={title}
        BPM=120
        SUBDIV=4
        START_DELAY=0
        CHORD_HOLD=0.5
        t r [ad] . w
        """;

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
                // Best effort test cleanup.
            }
        }
    }
}
