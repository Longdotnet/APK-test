using RobloxPiano.Core;

var cases = new (string Name, Action Run)[]
{
    ("chords rests tempo and backup compile deterministically", ChordsRestsTempoAndBackup),
    ("ties compile to one canonical duration", TiesCompile),
    ("out of range notes fail closed", OutOfRangeFails),
    ("malformed and unsupported notation fail controlled", MalformedFails),
    ("conformance rejects silent semantic loss", ConformanceRejectsUnsupportedSemantics),
    ("conformance detects tempo backup ambiguity", ConformanceDetectsTempoBackupAmbiguity),
    ("conformance diagnostics are stable and localized", ConformanceDiagnosticsAreStable)
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

static void ChordsRestsTempoAndBackup()
{
    var track = MusicXmlImporter.Import("""
        <?xml version="1.0" encoding="UTF-8"?>
        <score-partwise version="4.0">
          <movement-title>Phase 13 Fixture</movement-title>
          <part-list><score-part id="P1"><part-name>Piano</part-name></score-part></part-list>
          <part id="P1">
            <measure number="1">
              <attributes><divisions>4</divisions></attributes>
              <direction><sound tempo="120"/></direction>
              <note><pitch><step>C</step><octave>4</octave></pitch><duration>4</duration></note>
              <note><chord/><pitch><step>E</step><octave>4</octave></pitch><duration>4</duration></note>
              <note><rest/><duration>4</duration></note>
              <backup><duration>8</duration></backup>
              <note><pitch><step>G</step><octave>4</octave></pitch><duration>8</duration></note>
            </measure>
          </part>
        </score-partwise>
        """);

    Require(track.Title == "Phase 13 Fixture", "title mismatch");
    Require(Math.Abs(track.Bpm - 120d) < 0.001d, "tempo mismatch");
    Require(track.Events.Count == 2, $"expected 2 grouped events, actual {track.Events.Count}");
    Require(track.Events[0].Keys.Count == 2, "C/E chord was not grouped");
    Require(track.Events[0].Start == TimeSpan.Zero, "first chord must start at zero");
    Require(track.Events[0].Duration == TimeSpan.FromMilliseconds(500), "quarter duration mismatch");
    Require(track.Events[1].Start == TimeSpan.Zero, "backup voice must return to measure start");
    Require(track.Events[1].Duration == TimeSpan.FromSeconds(1), "half-note duration mismatch");
    Require(track.TimelineDuration == TimeSpan.FromSeconds(1), "timeline mismatch");
}

static void TiesCompile()
{
    var track = MusicXmlImporter.Import("""
        <score-partwise version="4.0">
          <part-list><score-part id="P1"><part-name>Piano</part-name></score-part></part-list>
          <part id="P1">
            <measure number="1">
              <attributes><divisions>1</divisions></attributes>
              <direction><direction-type><metronome><beat-unit>quarter</beat-unit><per-minute>60</per-minute></metronome></direction-type></direction>
              <note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration><tie type="start"/></note>
            </measure>
            <measure number="2">
              <note><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration><tie type="stop"/></note>
            </measure>
          </part>
        </score-partwise>
        """);

    Require(track.Events.Count == 1, "tie must produce one canonical event");
    Require(track.Events[0].Duration == TimeSpan.FromSeconds(2), "tie duration mismatch");
}

static void OutOfRangeFails()
{
    ExpectFormat(() => MusicXmlImporter.Import("""
        <score-partwise><part-list/><part id="P1"><measure><attributes><divisions>1</divisions></attributes>
        <note><pitch><step>C</step><octave>8</octave></pitch><duration>1</duration></note>
        </measure></part></score-partwise>
        """), "outside the active Roblox keyboard range");
}

static void MalformedFails()
{
    ExpectFormat(() => MusicXmlImporter.Import("<score-partwise><broken>"), "malformed");
    ExpectFormat(() => MusicXmlImporter.Import("<score-timewise/>"), "score-partwise");
    ExpectFormat(() => MusicXmlImporter.Import("""
        <score-partwise><part-list/><part id="P1"><measure><attributes><divisions>1</divisions></attributes>
        <note><grace/><pitch><step>C</step><octave>4</octave></pitch><duration>1</duration></note>
        </measure></part></score-partwise>
        """), "Grace notes");
}

static void ConformanceRejectsUnsupportedSemantics()
{
    var xml = """
        <score-partwise version="4.0">
          <part-list><score-part id="P1"><part-name>Piano</part-name></score-part></part-list>
          <part id="P1"><measure number="7">
            <attributes><divisions>4</divisions></attributes>
            <note>
              <pitch><step>C</step><octave>4</octave></pitch><duration>4</duration>
              <notations><ornaments><trill-mark/></ornaments></notations>
            </note>
            <barline><repeat direction="backward"/></barline>
          </measure></part>
        </score-partwise>
        """;

    var report = MusicXmlConformance.Analyze(xml);
    Require(!report.CanImport, "ornament/repeat score must fail production conformance");
    Require(report.Errors.Any(item => item.Code == "MXML101"), "repeat diagnostic missing");
    Require(report.Errors.Any(item => item.Code == "MXML105"), "ornament diagnostic missing");
    ExpectFormat(() => MusicXmlConformance.ValidateForProductionImport(xml), "MXML101");
}

static void ConformanceDetectsTempoBackupAmbiguity()
{
    var xml = """
        <score-partwise version="4.0">
          <part-list><score-part id="P1"><part-name>Piano</part-name></score-part></part-list>
          <part id="P1"><measure number="3">
            <attributes><divisions>4</divisions></attributes>
            <direction><sound tempo="120"/></direction>
            <note><pitch><step>C</step><octave>4</octave></pitch><duration>4</duration></note>
            <direction><sound tempo="90"/></direction>
            <backup><duration>4</duration></backup>
            <note><pitch><step>E</step><octave>4</octave></pitch><duration>4</duration></note>
          </measure></part>
        </score-partwise>
        """;

    var report = MusicXmlConformance.Analyze(xml);
    Require(report.Errors.Any(item => item.Code == "MXML111"), "tempo/backup ambiguity must be rejected");
}

static void ConformanceDiagnosticsAreStable()
{
    var xml = """
        <score-partwise version="4.0">
          <part-list><score-part id="Piano"><part-name>Piano</part-name></score-part></part-list>
          <part id="Piano"><measure number="12">
            <attributes><divisions>4</divisions><transpose><chromatic>2</chromatic></transpose></attributes>
            <direction><offset>2</offset><sound tempo="100"/></direction>
            <note><grace/><pitch><step>D</step><octave>4</octave></pitch><duration>1</duration></note>
          </measure></part>
        </score-partwise>
        """;

    var report = MusicXmlConformance.Analyze(xml);
    Require(report.Errors.Select(item => item.Code).SequenceEqual(["MXML107", "MXML110", "MXML112"]), "diagnostic order changed");
    Require(report.Errors.All(item => item.Part == "Piano" && item.Measure == "12"), "diagnostic location missing");
    ExpectFormat(() => MusicXmlConformance.ValidateForProductionImport(xml), "measure 12");
}

static void ExpectFormat(Action action, string expected)
{
    try
    {
        action();
    }
    catch (FormatException exception) when (exception.Message.Contains(expected, StringComparison.OrdinalIgnoreCase))
    {
        return;
    }
    throw new InvalidOperationException($"Expected controlled FormatException containing '{expected}'.");
}

static void Require(bool condition, string message)
{
    if (!condition)
    {
        throw new InvalidOperationException(message);
    }
}
