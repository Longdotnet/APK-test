using Melanchall.DryWetMidi.Common;
using Melanchall.DryWetMidi.Core;
using RobloxPiano.Core;

namespace RobloxPiano.Library;

/// <summary>
/// Serializes the canonical playback model to a standards-compliant single-track SMF.
/// DryWetMIDI owns SMF writing only; PerformanceTrack remains product truth.
/// </summary>
public static class PerformanceTrackMidiExporter
{
    public const short TicksPerQuarterNote = 480;
    private const byte NoteOnVelocity = 96;

    public static byte[] Export(PerformanceTrack track)
    {
        ArgumentNullException.ThrowIfNull(track);
        if (!double.IsFinite(track.Bpm) || track.Bpm is < 20d or > 400d)
            throw new ArgumentOutOfRangeException(nameof(track), "Generated track BPM must be between 20 and 400.");
        if (track.StartDelay < TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(track), "Generated track start delay cannot be negative.");
        if (track.Events.Count == 0)
            throw new InvalidDataException("Generated track contains no playable events.");

        var keyToMidi = BuildKeyToMidiMap();
        var edges = new List<MidiEdge>(track.Events.Sum(item => item.Keys.Count) * 2);
        foreach (var performanceEvent in track.Events)
        {
            if (performanceEvent.Start < TimeSpan.Zero)
                throw new InvalidDataException("Generated track contains a negative event start time.");
            if (performanceEvent.Duration <= TimeSpan.Zero)
                throw new InvalidDataException("Generated track contains a non-positive event duration.");
            if (performanceEvent.Keys.Count == 0)
                throw new InvalidDataException("Generated track contains an event without keys.");

            var absoluteStart = checked(track.StartDelay + performanceEvent.Start);
            var absoluteEnd = checked(absoluteStart + performanceEvent.Duration);
            var startTick = ToMidiTick(absoluteStart, track.Bpm);
            var endTick = Math.Max(checked(startTick + 1), ToMidiTick(absoluteEnd, track.Bpm));
            var seenKeys = new HashSet<char>();
            foreach (var key in performanceEvent.Keys)
            {
                if (!seenKeys.Add(key))
                    throw new InvalidDataException($"Generated event contains duplicate Roblox key '{key}'.");
                if (!keyToMidi.TryGetValue(key, out var midiNote))
                    throw new InvalidDataException($"Generated track contains Roblox key '{key}' outside the classic 61-key profile.");

                edges.Add(new MidiEdge(startTick, isNoteOn: true, midiNote));
                edges.Add(new MidiEdge(endTick, isNoteOn: false, midiNote));
            }
        }

        var title = string.IsNullOrWhiteSpace(track.Title) ? "Audio transcription" : track.Title.Trim();
        var microsecondsPerQuarter = checked((long)Math.Round(60_000_000d / track.Bpm, MidpointRounding.AwayFromZero));
        var midiEvents = new List<MidiEvent>(edges.Count + 2)
        {
            new SequenceTrackNameEvent(title),
            new SetTempoEvent(microsecondsPerQuarter)
        };

        long previousTick = 0;
        foreach (var edge in edges
                     .OrderBy(item => item.Tick)
                     .ThenBy(item => item.IsNoteOn ? 1 : 0)
                     .ThenBy(item => item.MidiNote))
        {
            var midiEvent = edge.IsNoteOn
                ? (MidiEvent)new NoteOnEvent((SevenBitNumber)edge.MidiNote, (SevenBitNumber)NoteOnVelocity)
                : new NoteOffEvent((SevenBitNumber)edge.MidiNote, SevenBitNumber.MinValue);
            midiEvent.DeltaTime = checked(edge.Tick - previousTick);
            midiEvents.Add(midiEvent);
            previousTick = edge.Tick;
        }

        var midiFile = new MidiFile(new TrackChunk(midiEvents))
        {
            TimeDivision = new TicksPerQuarterNoteTimeDivision(TicksPerQuarterNote)
        };
        using var stream = new MemoryStream();
        midiFile.Write(stream, MidiFileFormat.SingleTrack);
        return stream.ToArray();
    }

    public static TimeSpan MaximumRoundTripTimingError(double bpm)
    {
        if (!double.IsFinite(bpm) || bpm <= 0d)
            throw new ArgumentOutOfRangeException(nameof(bpm));
        return TimeSpan.FromSeconds(60d / bpm / TicksPerQuarterNote);
    }

    private static Dictionary<char, byte> BuildKeyToMidiMap()
    {
        var profile = MidiKeyboardProfile.RobloxClassic61;
        var result = new Dictionary<char, byte>(profile.Keys.Length);
        for (var index = 0; index < profile.Keys.Length; index++)
        {
            var key = profile.Keys[index];
            if (!result.TryAdd(key, checked((byte)(profile.LowestMidiNote + index))))
                throw new InvalidOperationException($"Roblox keyboard profile contains duplicate key '{key}'.");
        }
        return result;
    }

    private static long ToMidiTick(TimeSpan time, double bpm)
    {
        var beats = (decimal)time.Ticks * (decimal)bpm / TimeSpan.TicksPerMinute;
        var ticks = decimal.Round(beats * TicksPerQuarterNote, 0, MidpointRounding.AwayFromZero);
        if (ticks < 0m || ticks > long.MaxValue)
            throw new OverflowException("Generated track timeline exceeds MIDI tick capacity.");
        return (long)ticks;
    }

    private readonly record struct MidiEdge(long Tick, bool IsNoteOn, byte MidiNote);
}
