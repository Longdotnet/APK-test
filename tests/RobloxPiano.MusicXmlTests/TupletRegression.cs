using System.Runtime.CompilerServices;
using RobloxPiano.Core;

internal static class TupletRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        TripletDurationsCompileFromMeasuredTime();
        TupletsCrossTempoBoundariesDeterministically();
        MalformedTupletMetadataFailsClosed();
        Console.WriteLine("PASS measured MusicXML tuplets compile deterministically");
    }

    private static void TripletDurationsCompileFromMeasuredTime()
    {
        var xml = """
            <score-partwise version="4.0">
              <part-list><score-part id="P1"><part-name>Piano</part-name></score-part></part-list>
              <part id="P1"><measure number="1">
                <attributes><divisions>6</divisions></attributes>
                <direction><sound tempo="120"/></direction>
                <note>
                  <pitch><step>C</step><octave>4</octave></pitch><duration>2</duration>
                  <time-modification><actual-notes>3</actual-notes><normal-notes>2</normal-notes></time-modification>
                  <notations><tuplet type="start"/></notations>
                </note>
                <note>
                  <pitch><step>D</step><octave>4</octave></pitch><duration>2</duration>
                  <time-modification><actual-notes>3</actual-notes><normal-notes>2</normal-notes></time-modification>
                </note>
                <note>
                  <pitch><step>E</step><octave>4</octave></pitch><duration>2</duration>
                  <time-modification><actual-notes>3</actual-notes><normal-notes>2</normal-notes></time-modification>
                  <notations><tuplet type="stop"/></notations>
                </note>
              </measure></part>
            </score-partwise>
            """;

        MusicXmlConformance.ValidateForProductionImport(xml);
        var track = MusicXmlImporter.Import(xml);
        Require(track.Events.Count == 3, "triplet should produce three canonical events");
        Require(track.Events[0].Start == TimeSpan.Zero, "first triplet start mismatch");
        Require(Approximately(track.Events[0].Duration, TimeSpan.FromSeconds(1d / 6d)), "triplet duration mismatch");
        Require(Approximately(track.Events[1].Start, TimeSpan.FromSeconds(1d / 6d)), "second triplet start mismatch");
        Require(Approximately(track.Events[2].Start, TimeSpan.FromSeconds(1d / 3d)), "third triplet start mismatch");
        Require(Approximately(track.TimelineDuration, TimeSpan.FromMilliseconds(500)), "triplet group must occupy one quarter note");
    }

    private static void TupletsCrossTempoBoundariesDeterministically()
    {
        var xml = """
            <score-partwise version="4.0">
              <part-list><score-part id="P1"><part-name>Piano</part-name></score-part></part-list>
              <part id="P1"><measure number="1">
                <attributes><divisions>6</divisions></attributes>
                <direction><sound tempo="120"/></direction>
                <note><pitch><step>C</step><octave>4</octave></pitch><duration>2</duration><time-modification><actual-notes>3</actual-notes><normal-notes>2</normal-notes></time-modification></note>
                <direction><sound tempo="60"/></direction>
                <note><pitch><step>D</step><octave>4</octave></pitch><duration>2</duration><time-modification><actual-notes>3</actual-notes><normal-notes>2</normal-notes></time-modification></note>
                <note><pitch><step>E</step><octave>4</octave></pitch><duration>2</duration><time-modification><actual-notes>3</actual-notes><normal-notes>2</normal-notes></time-modification></note>
              </measure></part>
            </score-partwise>
            """;

        MusicXmlConformance.ValidateForProductionImport(xml);
        var track = MusicXmlImporter.Import(xml);
        Require(Approximately(track.Events[0].Duration, TimeSpan.FromSeconds(1d / 6d)), "first tuplet must use 120 BPM");
        Require(Approximately(track.Events[1].Start, TimeSpan.FromSeconds(1d / 6d)), "tempo-change tuplet start mismatch");
        Require(Approximately(track.Events[1].Duration, TimeSpan.FromSeconds(1d / 3d)), "second tuplet must use 60 BPM");
        Require(Approximately(track.TimelineDuration, TimeSpan.FromSeconds(5d / 6d)), "tempo-change tuplet timeline mismatch");
    }

    private static void MalformedTupletMetadataFailsClosed()
    {
        var badRatio = """
            <score-partwise><part-list/><part id="P1"><measure number="9"><attributes><divisions>6</divisions></attributes>
              <note><pitch><step>C</step><octave>4</octave></pitch><duration>2</duration><time-modification><actual-notes>0</actual-notes><normal-notes>2</normal-notes></time-modification></note>
            </measure></part></score-partwise>
            """;
        var ratioReport = MusicXmlConformance.Analyze(badRatio);
        Require(ratioReport.Errors.Any(item => item.Code == "MXML103" && item.Measure == "9"), "invalid tuplet ratio must be localized and rejected");

        var badNotation = """
            <score-partwise><part-list/><part id="P1"><measure number="10"><attributes><divisions>6</divisions></attributes>
              <note><pitch><step>C</step><octave>4</octave></pitch><duration>2</duration><notations><tuplet type="continue"/></notations></note>
            </measure></part></score-partwise>
            """;
        var notationReport = MusicXmlConformance.Analyze(badNotation);
        Require(notationReport.Errors.Any(item => item.Code == "MXML104" && item.Measure == "10"), "invalid tuplet notation must be localized and rejected");
    }

    private static bool Approximately(TimeSpan actual, TimeSpan expected)
        => Math.Abs((actual - expected).Ticks) <= 2;

    private static void Require(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }
}
