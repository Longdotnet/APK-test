using RobloxPiano.Core;

var tests = new (string Name, Action Run)[]
{
    ("classic 61-key mapping spans C2-C7", ClassicMapping),
    ("format 0 note + tempo imports deterministically", BasicFormatZero),
    ("tempo changes preserve absolute timing", TempoChangeTiming),
    ("running status and velocity-zero note-off are supported", RunningStatus),
    ("single-channel CC64 compiles sustain", SustainCompilation),
    ("out-of-range melodic notes auto-fit deterministically", OutOfRangeAutoFits),
    ("General MIDI percussion channel is ignored", PercussionChannelIgnored),
    ("inspection reports auto-fit and ignored percussion", InspectionReportsCompatibilityAdjustments),
    ("inspection reports source-preserved MIDI", InspectionReportsSourcePreserved),
    ("best-effort inspection fails soft for malformed bytes", InspectionFailsSoft),
    ("strict range policy still fails closed", StrictOutOfRangeFails),
    ("melodic range wider than the Roblox profile fails closed", WideRangeFails),
    ("dangling notes fail closed", DanglingNoteFails),
    ("multi-channel sustain is channel-scoped", MultiChannelSustainIsChannelScoped),
    ("multi-channel sustain clips same-pitch retrigger", MultiChannelSustainRetriggerClips),
    ("invalid channel sustain sequence still fails closed", InvalidChannelSustainFails),
    ("SMPTE division is rejected", SmpteFails)
};

var failed = 0;
foreach (var test in tests)
{
    try
    {
        test.Run();
        Console.WriteLine($"PASS {test.Name}");
    }
    catch (Exception exception)
    {
        failed++;
        Console.Error.WriteLine($"FAIL {test.Name}: {exception}");
    }
}

if (failed != 0)
{
    Console.Error.WriteLine($"MIDI regression harness failed: {failed}/{tests.Length} tests failed.");
    return 1;
}

Console.WriteLine($"MIDI regression harness passed: {tests.Length}/{tests.Length}.");
return 0;

static void ClassicMapping()
{
    var profile = MidiKeyboardProfile.RobloxClassic61;
    Equal(36, profile.LowestMidiNote);
    Equal(96, profile.HighestMidiNote);
    Equal(61, profile.Keys.Length);
    Equal('1', profile.Map(36));
    Equal('t', profile.Map(60));
    Equal('m', profile.Map(96));
}

static void BasicFormatZero()
{
    var midi = BuildMidi(
        division: 480,
        [
            Meta(0, 0x03, "Unit Test"u8.ToArray()),
            Meta(0, 0x51, [0x07, 0xA1, 0x20]),
            Ch(0, 0x90, 60, 100),
            Ch(480, 0x80, 60, 0),
            End(0)
        ]);

    var expressive = MidiFileImporter.Import(midi);
    Equal("Unit Test", expressive.Notes.Title);
    Nearly(120d, expressive.Notes.Bpm);
    Equal(1, expressive.Notes.Events.Count);
    Equal('t', expressive.Notes.Events[0].Keys[0]);
    Equal(TimeSpan.Zero, expressive.Notes.Events[0].Start);
    Equal(TimeSpan.FromMilliseconds(500), expressive.Notes.Events[0].Duration);
    Equal(0, expressive.Controls.Count);
}

static void TempoChangeTiming()
{
    var midi = BuildMidi(
        480,
        [
            Meta(0, 0x51, [0x07, 0xA1, 0x20]),
            Ch(0, 0x90, 60, 100),
            Meta(480, 0x51, [0x0F, 0x42, 0x40]),
            Ch(480, 0x80, 60, 0),
            End(0)
        ]);

    var track = MidiFileImporter.ImportCompiled(midi);
    Equal(TimeSpan.FromMilliseconds(1500), track.Events.Single().Duration);
    Equal(TimeSpan.FromMilliseconds(1500), track.TimelineDuration);
}

static void RunningStatus()
{
    var track = new List<byte>();
    track.AddRange(Vlq(0));
    track.AddRange([0x90, 60, 100]);
    track.AddRange(Vlq(240));
    track.AddRange([60, 0]);
    track.AddRange(Vlq(0));
    track.AddRange([0xFF, 0x2F, 0]);

    var midi = BuildRawMidi(480, track.ToArray());
    var imported = MidiFileImporter.ImportCompiled(midi);
    Equal(1, imported.Events.Count);
    Equal(TimeSpan.FromMilliseconds(250), imported.Events[0].Duration);
}

static void SustainCompilation()
{
    var midi = BuildMidi(
        480,
        [
            Ch(0, 0xB0, 64, 127),
            Ch(0, 0x90, 60, 100),
            Ch(240, 0x80, 60, 0),
            Ch(240, 0xB0, 64, 0),
            End(0)
        ]);

    var expressive = MidiFileImporter.Import(midi);
    Equal(2, expressive.Controls.Count);
    var compiled = ExpressivePerformanceCompiler.Compile(expressive);
    Equal(TimeSpan.FromMilliseconds(500), compiled.Events.Single().Duration);
}

static void OutOfRangeAutoFits()
{
    var midi = BuildMidi(480, [Ch(0, 0x90, 35, 100), Ch(120, 0x80, 35, 0), End(0)]);
    var imported = MidiFileImporter.ImportCompiled(midi);
    Equal(1, imported.Events.Count);
    Equal('1', imported.Events[0].Keys.Single());
}

static void PercussionChannelIgnored()
{
    var midi = BuildMidi(
        480,
        [
            Ch(0, 0x99, 35, 100),
            Ch(0, 0x90, 60, 100),
            Ch(120, 0x89, 35, 0),
            Ch(0, 0x80, 60, 0),
            End(0)
        ]);

    var imported = MidiFileImporter.ImportCompiled(midi);
    Equal(1, imported.Events.Count);
    Equal('t', imported.Events[0].Keys.Single());
}

static void InspectionReportsCompatibilityAdjustments()
{
    var midi = BuildMidi(
        480,
        [
            Ch(0, 0x99, 38, 100),
            Ch(0, 0x90, 35, 100),
            Ch(120, 0x89, 38, 0),
            Ch(0, 0x80, 35, 0),
            End(0)
        ]);

    var inspection = MidiImportInspector.Inspect(midi);
    Equal(1, inspection.MelodicNoteOnCount);
    Equal(1, inspection.IgnoredPercussionNoteOnCount);
    Equal(35, inspection.SourceLowestMidiNote);
    Equal(35, inspection.SourceHighestMidiNote);
    Equal(1, inspection.AutomaticRangeAdjustmentSemitones);
    Equal(1, inspection.EffectiveTransposeSemitones);
    Equal(36, inspection.EffectiveLowestMidiNote);
    Equal(36, inspection.EffectiveHighestMidiNote);
    True(inspection.WasRangeAutoFitted);
    True(inspection.IgnoredPercussion);
    True(inspection.HasCompatibilityAdjustment);
    True(inspection.Summary.Contains("range auto-fit +1 st", StringComparison.Ordinal));
    True(inspection.Summary.Contains("ignored 1 drum note", StringComparison.Ordinal));
}

static void InspectionReportsSourcePreserved()
{
    var midi = BuildMidi(480, [Ch(0, 0x90, 60, 100), Ch(120, 0x80, 60, 0), End(0)]);
    var inspection = MidiImportInspector.Inspect(midi);
    Equal(0, inspection.EffectiveTransposeSemitones);
    Equal("source preserved", inspection.Summary);
    True(!inspection.HasCompatibilityAdjustment);
}

static void InspectionFailsSoft()
{
    var inspection = MidiImportInspector.TryInspect([0x00, 0x01, 0x02]);
    True(inspection is null);
}

static void StrictOutOfRangeFails()
{
    var midi = BuildMidi(480, [Ch(0, 0x90, 35, 100), Ch(120, 0x80, 35, 0), End(0)]);
    var options = new MidiImportOptions(AutoFitToKeyboardRange: false);
    Throws<FormatException>(() => MidiFileImporter.Import(midi, options));
}

static void WideRangeFails()
{
    var midi = BuildMidi(
        480,
        [
            Ch(0, 0x90, 20, 100),
            Ch(0, 0x90, 110, 100),
            Ch(120, 0x80, 20, 0),
            Ch(0, 0x80, 110, 0),
            End(0)
        ]);
    Throws<FormatException>(() => MidiFileImporter.Import(midi));
}

static void DanglingNoteFails()
{
    var midi = BuildMidi(480, [Ch(0, 0x90, 60, 100), End(480)]);
    Throws<FormatException>(() => MidiFileImporter.Import(midi));
}

static void MultiChannelSustainIsChannelScoped()
{
    var midi = BuildMidi(
        480,
        [
            Ch(0, 0xB0, 64, 127),
            Ch(0, 0x90, 60, 100),
            Ch(0, 0x91, 64, 100),
            Ch(240, 0x80, 60, 0),
            Ch(0, 0x81, 64, 0),
            Ch(240, 0xB0, 64, 0),
            End(0)
        ]);

    var expressive = MidiFileImporter.Import(midi);
    Equal(0, expressive.Controls.Count);
    var compiled = ExpressivePerformanceCompiler.Compile(expressive);
    Equal(2, compiled.Events.Count);

    var sustained = compiled.Events.Single(item => item.Keys.Single() == MidiKeyboardProfile.RobloxClassic61.Map(60));
    var unsustained = compiled.Events.Single(item => item.Keys.Single() == MidiKeyboardProfile.RobloxClassic61.Map(64));
    Equal(TimeSpan.FromMilliseconds(500), sustained.Duration);
    Equal(TimeSpan.FromMilliseconds(250), unsustained.Duration);
}

static void MultiChannelSustainRetriggerClips()
{
    var midi = BuildMidi(
        480,
        [
            Ch(0, 0xB0, 64, 127),
            Ch(0, 0x90, 60, 100),
            Ch(120, 0x80, 60, 0),
            Ch(0, 0x91, 60, 100),
            Ch(120, 0x81, 60, 0),
            Ch(240, 0xB0, 64, 0),
            End(0)
        ]);

    var compiled = MidiFileImporter.ImportCompiled(midi);
    Equal(2, compiled.Events.Count);
    Equal(TimeSpan.Zero, compiled.Events[0].Start);
    Equal(TimeSpan.FromMilliseconds(125), compiled.Events[0].Duration);
    Equal(TimeSpan.FromMilliseconds(125), compiled.Events[1].Start);
    Equal(TimeSpan.FromMilliseconds(125), compiled.Events[1].Duration);
}

static void InvalidChannelSustainFails()
{
    var midi = BuildMidi(
        480,
        [
            Ch(0, 0xB0, 64, 0),
            Ch(0, 0x90, 60, 100),
            Ch(0, 0x91, 64, 100),
            Ch(120, 0x80, 60, 0),
            Ch(0, 0x81, 64, 0),
            End(0)
        ]);
    Throws<FormatException>(() => MidiFileImporter.Import(midi));
}

static void SmpteFails()
{
    var midi = BuildRawMidi(0xE728, [0, 0xFF, 0x2F, 0]);
    Throws<FormatException>(() => MidiFileImporter.Import(midi));
}

static byte[] BuildMidi(ushort division, IReadOnlyList<byte[]> events)
{
    var track = events.SelectMany(item => item).ToArray();
    return BuildRawMidi(division, track);
}

static byte[] BuildRawMidi(ushort division, byte[] track)
{
    var bytes = new List<byte>();
    bytes.AddRange("MThd"u8.ToArray());
    bytes.AddRange(Be32(6));
    bytes.AddRange(Be16(0));
    bytes.AddRange(Be16(1));
    bytes.AddRange(Be16(division));
    bytes.AddRange("MTrk"u8.ToArray());
    bytes.AddRange(Be32(track.Length));
    bytes.AddRange(track);
    return bytes.ToArray();
}

static byte[] Ch(long delta, byte status, byte data1, byte data2)
    => [.. Vlq(delta), status, data1, data2];

static byte[] Meta(long delta, byte type, byte[] data)
    => [.. Vlq(delta), 0xFF, type, .. Vlq(data.Length), .. data];

static byte[] End(long delta) => [.. Vlq(delta), 0xFF, 0x2F, 0];

static byte[] Vlq(long value)
{
    if (value is < 0 or > 0x0FFFFFFF)
        throw new ArgumentOutOfRangeException(nameof(value));
    Span<byte> buffer = stackalloc byte[4];
    var index = 3;
    buffer[index] = (byte)(value & 0x7F);
    while ((value >>= 7) > 0)
        buffer[--index] = (byte)((value & 0x7F) | 0x80);
    return buffer[index..].ToArray();
}

static byte[] Be16(int value) => [(byte)(value >> 8), (byte)value];
static byte[] Be32(int value) => [(byte)(value >> 24), (byte)(value >> 16), (byte)(value >> 8), (byte)value];

static void Equal<T>(T expected, T actual)
{
    if (!EqualityComparer<T>.Default.Equals(expected, actual))
        throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
}

static void Nearly(double expected, double actual)
{
    if (Math.Abs(expected - actual) > 0.0001)
        throw new InvalidOperationException($"Expected approximately {expected}, actual {actual}.");
}

static void True(bool condition)
{
    if (!condition)
        throw new InvalidOperationException("Expected condition to be true.");
}

static void Throws<TException>(Action action) where TException : Exception
{
    try
    {
        action();
    }
    catch (TException)
    {
        return;
    }
    throw new InvalidOperationException($"Expected {typeof(TException).Name}.");
}
