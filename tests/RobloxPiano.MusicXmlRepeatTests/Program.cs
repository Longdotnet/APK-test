using RobloxPiano.Core;
using RobloxPiano.Library;

var cases = new (string Name, Action Run)[]
{
    ("simple repeat expands exactly twice", SimpleRepeat),
    ("first and second endings linearize correctly", FirstSecondEnding),
    ("sequential repeats remain independent", SequentialRepeats),
    ("implicit score-start repeat is supported", ImplicitStartRepeat),
    ("nested and unsupported repeats fail closed", UnsupportedRepeatsFail),
    ("client loader uses production repeat normalization", ClientLoaderUsesProductionBoundary)
};

var failures = 0;
foreach (var test in cases)
{
    try
    {
        test.Run();
        Console.WriteLine($"PASS {test.Name}");
    }
    catch (Exception exception)
    {
        failures++;
        Console.Error.WriteLine($"FAIL {test.Name}: {exception.Message}");
    }
}

return failures == 0 ? 0 : 1;

static void SimpleRepeat()
{
    var track = MusicXmlProductionImporter.Import(Score("""
        <measure number="1"><attributes><divisions>1</divisions></attributes><direction><sound tempo="60"/></direction><barline location="left"><repeat direction="forward"/></barline><note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration></note></measure>
        <measure number="2"><note><pitch><step>D</step><octave>4</octave></pitch><duration>1</duration></note><barline location="right"><repeat direction="backward"/></barline></measure>
        """));
    Require(track.Events.Count == 4, $"expected 4 events, actual {track.Events.Count}");
    Require(track.Events.Select(e => e.Start.TotalSeconds).SequenceEqual([0d, 1d, 2d, 3d]), "repeat timeline is not linear");
    Require(track.TimelineDuration == TimeSpan.FromSeconds(4), "repeat duration mismatch");
}

static void FirstSecondEnding()
{
    var track = MusicXmlProductionImporter.Import(Score("""
        <measure number="1"><attributes><divisions>1</divisions></attributes><direction><sound tempo="60"/></direction><barline location="left"><repeat direction="forward"/></barline><note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration></note></measure>
        <measure number="2"><barline location="left"><ending number="1" type="start"/></barline><note><pitch><step>D</step><octave>4</octave></pitch><duration>1</duration></note><barline location="right"><ending number="1" type="stop"/><repeat direction="backward"/></barline></measure>
        <measure number="3"><barline location="left"><ending number="2" type="start"/></barline><note><pitch><step>E</step><octave>4</octave></pitch><duration>1</duration></note><barline location="right"><ending number="2" type="stop"/></barline></measure>
        """));
    Require(track.Events.Count == 4, $"expected C,D,C,E; actual {track.Events.Count}");
    Require(track.TimelineDuration == TimeSpan.FromSeconds(4), "ending expansion duration mismatch");
}

static void SequentialRepeats()
{
    var track = MusicXmlProductionImporter.Import(Score("""
        <measure number="1"><attributes><divisions>1</divisions></attributes><direction><sound tempo="60"/></direction><barline location="left"><repeat direction="forward"/></barline><note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration></note><barline location="right"><repeat direction="backward"/></barline></measure>
        <measure number="2"><barline location="left"><repeat direction="forward"/></barline><note><pitch><step>D</step><octave>4</octave></pitch><duration>1</duration></note><barline location="right"><repeat direction="backward"/></barline></measure>
        """));
    Require(track.Events.Count == 4, "two sequential one-measure repeats must each play twice");
}

static void ImplicitStartRepeat()
{
    var track = MusicXmlProductionImporter.Import(Score("""
        <measure number="1"><attributes><divisions>1</divisions></attributes><direction><sound tempo="60"/></direction><note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration></note></measure>
        <measure number="2"><note><pitch><step>D</step><octave>4</octave></pitch><duration>1</duration></note><barline location="right"><repeat direction="backward"/></barline></measure>
        """));
    Require(track.Events.Count == 4, "implicit repeat-from-start must produce two passes");
}

static void UnsupportedRepeatsFail()
{
    ExpectFormat(() => MusicXmlProductionImporter.Import(Score("""
        <measure number="1"><attributes><divisions>1</divisions></attributes><barline><repeat direction="forward"/></barline><note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration></note></measure>
        <measure number="2"><barline><repeat direction="forward"/></barline><note><pitch><step>D</step><octave>4</octave></pitch><duration>1</duration></note><barline><repeat direction="backward"/></barline></measure>
        <measure number="3"><barline><repeat direction="backward"/></barline></measure>
        """)), "Nested");

    ExpectFormat(() => MusicXmlProductionImporter.Import(Score("""
        <measure number="1"><attributes><divisions>1</divisions></attributes><note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration></note><barline><repeat direction="backward" times="3"/></barline></measure>
        """)), "two-pass");
}

static void ClientLoaderUsesProductionBoundary()
{
    var directory = Path.Combine(Path.GetTempPath(), "roblox-piano-repeat-tests", Guid.NewGuid().ToString("N"));
    Directory.CreateDirectory(directory);
    try
    {
        var path = Path.Combine(directory, "repeat.musicxml");
        File.WriteAllText(path, Score("""
            <measure number="1"><attributes><divisions>1</divisions></attributes><direction><sound tempo="60"/></direction><barline><repeat direction="forward"/></barline><note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration></note><barline><repeat direction="backward"/></barline></measure>
            """));
        var loaded = SongSourceLoader.Load(path);
        Require(loaded.SourceKind == SongSourceKind.MusicXml, "loader source kind changed");
        Require(loaded.Track.Events.Count == 2, "desktop loader did not expand repeat");
    }
    finally
    {
        Directory.Delete(directory, recursive: true);
    }
}

static string Score(string measures) => $"""
    <score-partwise version="4.0">
      <part-list><score-part id="P1"><part-name>Piano</part-name></score-part></part-list>
      <part id="P1">{measures}</part>
    </score-partwise>
    """;

static void ExpectFormat(Action action, string expected)
{
    try { action(); }
    catch (FormatException exception) when (exception.Message.Contains(expected, StringComparison.OrdinalIgnoreCase)) { return; }
    throw new InvalidOperationException($"Expected controlled FormatException containing '{expected}'.");
}

static void Require(bool condition, string message)
{
    if (!condition) throw new InvalidOperationException(message);
}
