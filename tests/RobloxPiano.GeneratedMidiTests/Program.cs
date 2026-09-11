using RobloxPiano.Core;
using RobloxPiano.Library;

var failures = new List<string>();
Run("generated MIDI round-trips canonical notes and timing", TestRoundTrip, failures);
Run("generated track commit is collision-safe and library-readable", TestCommit, failures);
Run("invalid generated key is rejected before filesystem commit", TestInvalidKey, failures);
Run("large generated track stays deterministic", TestLargeTrack, failures);

Console.WriteLine($"Generated MIDI regressions: {4 - failures.Count} passed, {failures.Count} failed.");
foreach (var failure in failures)
    Console.Error.WriteLine(failure);
return failures.Count == 0 ? 0 : 1;

static void TestRoundTrip()
{
    var track = new PerformanceTrack(
        "Generated Round Trip",
        123d,
        480,
        TimeSpan.FromMilliseconds(37),
        [
            new PerformanceEvent(TimeSpan.FromMilliseconds(11), TimeSpan.FromMilliseconds(205), ['a', 's']),
            new PerformanceEvent(TimeSpan.FromMilliseconds(251), TimeSpan.FromMilliseconds(333), ['D']),
            new PerformanceEvent(TimeSpan.FromMilliseconds(777), TimeSpan.FromMilliseconds(129), ['m'])
        ],
        TimeSpan.FromMilliseconds(906));

    var bytes = PerformanceTrackMidiExporter.Export(track);
    True(bytes.Length > 40, "SMF should contain header, metadata and note events");
    True(bytes.AsSpan(0, 4).SequenceEqual("MThd"u8), "export must be a Standard MIDI File");

    var imported = MidiFileImporter.ImportCompiled(bytes);
    Equal("Generated Round Trip", imported.Title, "track title");
    Equal(4, imported.Events.Count, "chord should round-trip as four canonical note events");
    True(imported.Events.SelectMany(item => item.Keys).Order().SequenceEqual(new[] { 'D', 'a', 'm', 's' }.Order()), "Roblox key identity");

    var sourceNotes = Flatten(track);
    var importedNotes = Flatten(imported);
    var tolerance = PerformanceTrackMidiExporter.MaximumRoundTripTimingError(track.Bpm) + TimeSpan.FromTicks(2);
    Equal(sourceNotes.Count, importedNotes.Count, "flattened note count");
    for (var i = 0; i < sourceNotes.Count; i++)
    {
        Equal(sourceNotes[i].Key, importedNotes[i].Key, $"note {i} key");
        True((sourceNotes[i].Start - importedNotes[i].Start).Duration() <= tolerance, $"note {i} start drift");
        True((sourceNotes[i].End - importedNotes[i].End).Duration() <= tolerance, $"note {i} end drift");
    }
}

static void TestCommit()
{
    var root = Path.Combine(Path.GetTempPath(), "RobloxPiano-GeneratedMidiTests", Guid.NewGuid().ToString("N"));
    Directory.CreateDirectory(root);
    try
    {
        var writer = new GeneratedTrackLibraryWriter(root);
        var track = Track("My: Generated / Song", 120d, 12);
        var first = writer.Add(track);
        var second = writer.Add(track);

        True(File.Exists(first.Path) && File.Exists(second.Path), "both explicit commits should exist");
        True(!first.Path.Equals(second.Path, StringComparison.OrdinalIgnoreCase), "collision-safe filename required");
        True(!Directory.EnumerateFiles(root).Any(path => path.EndsWith(".tmp", StringComparison.OrdinalIgnoreCase)), "atomic temp files must not remain");
        Equal(12, first.NoteCount, "saved note count");
        True(first.ByteCount > 0, "saved byte count");

        var rows = new SheetLibraryService(root).Scan();
        Equal(2, rows.Count, "generated MIDI should appear in normal Library scan");
        True(rows.All(row => row.Status == SheetValidationStatus.Valid && row.Format == "MIDI"), "generated files must be normal playable MIDI rows");
    }
    finally
    {
        if (Directory.Exists(root))
            Directory.Delete(root, recursive: true);
    }
}

static void TestInvalidKey()
{
    var root = Path.Combine(Path.GetTempPath(), "RobloxPiano-GeneratedMidiTests", Guid.NewGuid().ToString("N"));
    Directory.CreateDirectory(root);
    try
    {
        var writer = new GeneratedTrackLibraryWriter(root);
        var invalid = new PerformanceTrack(
            "Invalid",
            120d,
            480,
            TimeSpan.Zero,
            [new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), ['?'])],
            TimeSpan.FromMilliseconds(100));
        Throws<InvalidDataException>(() => writer.Add(invalid), "unknown Roblox key must be rejected");
        Equal(0, Directory.EnumerateFiles(root).Count(), "rejected output must not leave a file");
    }
    finally
    {
        if (Directory.Exists(root))
            Directory.Delete(root, recursive: true);
    }
}

static void TestLargeTrack()
{
    const int noteCount = 20_000;
    var events = new PerformanceEvent[noteCount];
    for (var i = 0; i < noteCount; i++)
    {
        var key = MidiKeyboardProfile.RobloxClassic61.Keys[i % MidiKeyboardProfile.RobloxClassic61.Keys.Length];
        var start = TimeSpan.FromMilliseconds(i * 45L);
        events[i] = new PerformanceEvent(start, TimeSpan.FromMilliseconds(30), [key]);
    }
    var track = new PerformanceTrack("Large deterministic export", 140d, 480, TimeSpan.Zero, events, events[^1].Start + events[^1].Duration);

    var first = PerformanceTrackMidiExporter.Export(track);
    var second = PerformanceTrackMidiExporter.Export(track);
    True(first.SequenceEqual(second), "same canonical track must serialize byte-for-byte deterministically");
    var imported = MidiFileImporter.ImportCompiled(first);
    Equal(noteCount, imported.Events.Count, "large round-trip note count");
}

static PerformanceTrack Track(string title, double bpm, int notes)
{
    var events = Enumerable.Range(0, notes)
        .Select(i => new PerformanceEvent(
            TimeSpan.FromMilliseconds(i * 120),
            TimeSpan.FromMilliseconds(80),
            [MidiKeyboardProfile.RobloxClassic61.Keys[i % MidiKeyboardProfile.RobloxClassic61.Keys.Length]]))
        .ToArray();
    return new PerformanceTrack(title, bpm, 480, TimeSpan.Zero, events, events[^1].Start + events[^1].Duration);
}

static List<(char Key, TimeSpan Start, TimeSpan End)> Flatten(PerformanceTrack track)
    => track.Events
        .SelectMany(item => item.Keys.Select(key => (
            Key: key,
            Start: track.StartDelay + item.Start,
            End: track.StartDelay + item.Start + item.Duration)))
        .OrderBy(item => item.Start)
        .ThenBy(item => item.Key)
        .ThenBy(item => item.End)
        .ToList();

static void Run(string name, Action test, ICollection<string> failures)
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

static void True(bool condition, string message)
{
    if (!condition)
        throw new InvalidOperationException(message);
}

static void Equal<T>(T expected, T actual, string message)
{
    if (!EqualityComparer<T>.Default.Equals(expected, actual))
        throw new InvalidOperationException($"{message}: expected {expected}, actual {actual}");
}

static void Throws<TException>(Action action, string message) where TException : Exception
{
    try
    {
        action();
    }
    catch (TException)
    {
        return;
    }
    throw new InvalidOperationException(message);
}
