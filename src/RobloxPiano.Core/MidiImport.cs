using System.Buffers.Binary;
using System.Text;

namespace RobloxPiano.Core;

public sealed record MidiKeyboardProfile(int LowestMidiNote, string Keys)
{
    public static MidiKeyboardProfile RobloxClassic61 { get; } = new(
        36,
        "1!2@34$5%6^78*9(0qQwWeErtTyYuiIoOpPasSdDfgGhHjJklLzZxcCvVbBnm");

    public int HighestMidiNote => checked(LowestMidiNote + Keys.Length - 1);

    public char Map(int midiNote)
    {
        var index = midiNote - LowestMidiNote;
        if ((uint)index >= (uint)Keys.Length)
        {
            throw new FormatException(
                $"MIDI note {midiNote} is outside the active Roblox keyboard range " +
                $"{LowestMidiNote}..{HighestMidiNote} (C2..C7 for the classic 61-key profile). " +
                "Transpose the MIDI into range before playback.");
        }

        return Keys[index];
    }
}

public sealed record MidiImportOptions(
    MidiKeyboardProfile? KeyboardProfile = null,
    int TransposeSemitones = 0)
{
    public MidiKeyboardProfile EffectiveKeyboardProfile => KeyboardProfile ?? MidiKeyboardProfile.RobloxClassic61;
}

public static class MidiFileImporter
{
    private const int DefaultTempoMicrosecondsPerQuarter = 500_000;

    public static ExpressivePerformanceTrack Import(ReadOnlySpan<byte> bytes, MidiImportOptions? options = null)
    {
        options ??= new MidiImportOptions();
        if (options.TransposeSemitones is < -48 or > 48)
        {
            throw new ArgumentOutOfRangeException(nameof(options), "MIDI transpose must be between -48 and +48 semitones.");
        }

        var reader = new MidiReader(bytes);
        reader.ExpectAscii("MThd");
        var headerLength = reader.ReadUInt32BigEndian();
        if (headerLength < 6)
        {
            throw new FormatException("MIDI header chunk is shorter than 6 bytes.");
        }

        var format = reader.ReadUInt16BigEndian();
        var trackCount = reader.ReadUInt16BigEndian();
        var division = reader.ReadUInt16BigEndian();
        if (format is > 1)
        {
            throw new FormatException($"MIDI format {format} is not supported; use Standard MIDI format 0 or 1.");
        }

        if (trackCount == 0 || (format == 0 && trackCount != 1))
        {
            throw new FormatException("MIDI track count is invalid for the declared format.");
        }

        if ((division & 0x8000) != 0)
        {
            throw new FormatException("SMPTE-time MIDI files are not supported; use PPQ/ticks-per-quarter timing.");
        }

        var ppq = division;
        if (ppq == 0)
        {
            throw new FormatException("MIDI ticks-per-quarter must be greater than zero.");
        }

        reader.Skip(checked((int)headerLength - 6));
        var events = new List<RawEvent>();
        string? title = null;
        for (var trackIndex = 0; trackIndex < trackCount; trackIndex++)
        {
            reader.ExpectAscii("MTrk");
            var length = reader.ReadUInt32BigEndian();
            var trackBytes = reader.ReadSlice(checked((int)length));
            ParseTrack(trackBytes, trackIndex, events, ref title);
        }

        if (!reader.End)
        {
            throw new FormatException("Unexpected trailing bytes after declared MIDI tracks.");
        }

        var tempoChanges = BuildTempoMap(events);
        var firstTempo = tempoChanges.Count == 0
            ? DefaultTempoMicrosecondsPerQuarter
            : tempoChanges[0].MicrosecondsPerQuarter;
        var ordered = events
            .Where(item => item.Kind is RawEventKind.NoteOn or RawEventKind.NoteOff or RawEventKind.Sustain)
            .OrderBy(item => item.Tick)
            .ThenBy(item => item.TrackIndex)
            .ThenBy(item => item.Sequence)
            .ToArray();

        var active = new Dictionary<(int Channel, int Pitch), Queue<NoteStart>>();
        var notes = new List<MidiNote>();
        var sustainEventsByChannel = new Dictionary<int, List<(long Tick, bool Down)>>();
        var noteChannels = new HashSet<int>();
        long lastTick = 0;

        foreach (var item in ordered)
        {
            lastTick = Math.Max(lastTick, item.Tick);
            switch (item.Kind)
            {
                case RawEventKind.NoteOn:
                {
                    var pitch = checked(item.Data1 + options.TransposeSemitones);
                    _ = options.EffectiveKeyboardProfile.Map(pitch);
                    noteChannels.Add(item.Channel);
                    var key = (item.Channel, item.Data1);
                    if (!active.TryGetValue(key, out var queue))
                    {
                        queue = new Queue<NoteStart>();
                        active.Add(key, queue);
                    }

                    queue.Enqueue(new NoteStart(item.Tick, pitch));
                    break;
                }
                case RawEventKind.NoteOff:
                {
                    var key = (item.Channel, item.Data1);
                    if (!active.TryGetValue(key, out var queue) || queue.Count == 0)
                    {
                        throw new FormatException(
                            $"MIDI NoteOff for channel {item.Channel + 1}, note {item.Data1} has no matching NoteOn.");
                    }

                    var start = queue.Dequeue();
                    if (item.Tick <= start.Tick)
                    {
                        throw new FormatException("MIDI note duration must be positive after event ordering.");
                    }

                    notes.Add(new MidiNote(start.Tick, item.Tick, item.Channel, start.TransposedPitch));
                    break;
                }
                case RawEventKind.Sustain:
                {
                    if (!sustainEventsByChannel.TryGetValue(item.Channel, out var list))
                    {
                        list = new List<(long Tick, bool Down)>();
                        sustainEventsByChannel.Add(item.Channel, list);
                    }

                    list.Add((item.Tick, item.Data2 >= 64));
                    break;
                }
            }
        }

        var dangling = active.FirstOrDefault(pair => pair.Value.Count > 0);
        if (dangling.Value is not null && dangling.Value.Count > 0)
        {
            throw new FormatException(
                $"MIDI ended with an active note on channel {dangling.Key.Channel + 1}, note {dangling.Key.Pitch}.");
        }

        if (notes.Count == 0)
        {
            throw new FormatException("MIDI file contains no complete playable note events.");
        }

        var channelsWithSustain = sustainEventsByChannel
            .Where(pair => pair.Value.Count > 0 && noteChannels.Contains(pair.Key))
            .Select(pair => pair.Key)
            .Distinct()
            .ToArray();
        if (noteChannels.Count > 1 && channelsWithSustain.Length > 0)
        {
            throw new FormatException(
                "This MIDI uses sustain with multiple note-bearing channels. The current canonical sustain model is global, " +
                "so importing it would over-sustain other channels; split/flatten the piano performance to one channel first.");
        }

        var timelineTick = Math.Max(lastTick, notes.Max(note => note.EndTick));
        var timeline = TicksToTimeSpan(timelineTick, ppq, tempoChanges);
        var performanceEvents = notes
            .OrderBy(note => note.StartTick)
            .ThenBy(note => note.Channel)
            .ThenBy(note => note.Pitch)
            .Select(note =>
            {
                var start = TicksToTimeSpan(note.StartTick, ppq, tempoChanges);
                var end = TicksToTimeSpan(note.EndTick, ppq, tempoChanges);
                return new PerformanceEvent(
                    start,
                    end - start,
                    new[] { options.EffectiveKeyboardProfile.Map(note.Pitch) });
            })
            .ToArray();

        var controls = new List<PerformanceControlEvent>();
        if (channelsWithSustain.Length == 1)
        {
            var channel = channelsWithSustain[0];
            bool? previous = null;
            foreach (var sustain in sustainEventsByChannel[channel].OrderBy(item => item.Tick))
            {
                if (previous == sustain.Down)
                {
                    continue;
                }

                previous = sustain.Down;
                controls.Add(new PerformanceControlEvent(
                    TicksToTimeSpan(sustain.Tick, ppq, tempoChanges),
                    sustain.Down ? PerformanceControlKind.SustainDown : PerformanceControlKind.SustainUp));
            }
        }

        var track = new PerformanceTrack(
            string.IsNullOrWhiteSpace(title) ? "MIDI performance" : title.Trim(),
            60_000_000d / firstTempo,
            ppq,
            TimeSpan.Zero,
            performanceEvents,
            timeline);

        return new ExpressivePerformanceTrack(track, controls);
    }

    public static PerformanceTrack ImportCompiled(ReadOnlySpan<byte> bytes, MidiImportOptions? options = null)
        => ExpressivePerformanceCompiler.Compile(Import(bytes, options));

    private static IReadOnlyList<TempoChange> BuildTempoMap(IEnumerable<RawEvent> events)
    {
        var result = new List<TempoChange>();
        foreach (var group in events
                     .Where(item => item.Kind == RawEventKind.Tempo)
                     .OrderBy(item => item.Tick)
                     .ThenBy(item => item.TrackIndex)
                     .ThenBy(item => item.Sequence)
                     .GroupBy(item => item.Tick))
        {
            var values = group.Select(item => item.Data2).Distinct().ToArray();
            if (values.Length > 1)
            {
                throw new FormatException($"Conflicting MIDI tempo changes occur at tick {group.Key}.");
            }

            if (values[0] <= 0)
            {
                throw new FormatException("MIDI tempo must be greater than zero microseconds per quarter note.");
            }

            result.Add(new TempoChange(group.Key, values[0]));
        }

        return result;
    }

    private static TimeSpan TicksToTimeSpan(long tick, int ppq, IReadOnlyList<TempoChange> tempoChanges)
    {
        long previousTick = 0;
        var tempo = DefaultTempoMicrosecondsPerQuarter;
        decimal totalMicroseconds = 0m;
        foreach (var change in tempoChanges)
        {
            if (change.Tick > tick)
            {
                break;
            }

            if (change.Tick > previousTick)
            {
                totalMicroseconds += (decimal)(change.Tick - previousTick) * tempo / ppq;
            }

            previousTick = change.Tick;
            tempo = change.MicrosecondsPerQuarter;
        }

        if (tick > previousTick)
        {
            totalMicroseconds += (decimal)(tick - previousTick) * tempo / ppq;
        }

        var ticks100ns = decimal.Round(totalMicroseconds * 10m, 0, MidpointRounding.AwayFromZero);
        if (ticks100ns > long.MaxValue)
        {
            throw new OverflowException("MIDI timeline exceeds TimeSpan capacity.");
        }

        return TimeSpan.FromTicks((long)ticks100ns);
    }

    private static void ParseTrack(ReadOnlySpan<byte> bytes, int trackIndex, ICollection<RawEvent> target, ref string? title)
    {
        var reader = new MidiReader(bytes);
        long absoluteTick = 0;
        byte runningStatus = 0;
        var sequence = 0;
        while (!reader.End)
        {
            absoluteTick = checked(absoluteTick + reader.ReadVariableLength());
            var first = reader.PeekByte();
            byte status;
            if ((first & 0x80) != 0)
            {
                status = reader.ReadByte();
                if (status < 0xF0)
                {
                    runningStatus = status;
                }
            }
            else
            {
                if (runningStatus == 0)
                {
                    throw new FormatException("MIDI running status was used before a channel status byte.");
                }

                status = runningStatus;
            }

            if (status == 0xFF)
            {
                runningStatus = 0;
                var type = reader.ReadByte();
                var length = checked((int)reader.ReadVariableLength());
                var data = reader.ReadSlice(length);
                if (type == 0x2F)
                {
                    if (length != 0)
                    {
                        throw new FormatException("MIDI end-of-track meta event must have length 0.");
                    }
                    if (!reader.End)
                    {
                        throw new FormatException("MIDI track contains data after EndOfTrack.");
                    }
                    return;
                }

                if (type == 0x51)
                {
                    if (length != 3)
                    {
                        throw new FormatException("MIDI SetTempo meta event must contain exactly 3 bytes.");
                    }

                    var tempo = (data[0] << 16) | (data[1] << 8) | data[2];
                    target.Add(new RawEvent(absoluteTick, trackIndex, sequence++, RawEventKind.Tempo, 0, 0, tempo));
                }
                else if (type == 0x03 && string.IsNullOrWhiteSpace(title))
                {
                    title = Encoding.UTF8.GetString(data);
                }
                continue;
            }

            if (status is 0xF0 or 0xF7)
            {
                runningStatus = 0;
                reader.Skip(checked((int)reader.ReadVariableLength()));
                continue;
            }

            if (status >= 0xF0)
            {
                throw new FormatException($"Unsupported MIDI system event 0x{status:X2} inside track data.");
            }

            var command = status & 0xF0;
            var channel = status & 0x0F;
            var data1 = reader.ReadByte();
            if (data1 >= 0x80)
            {
                throw new FormatException("MIDI channel event data byte has the high bit set.");
            }

            var oneDataByte = command is 0xC0 or 0xD0;
            var data2 = oneDataByte ? 0 : reader.ReadByte();
            if (data2 >= 0x80)
            {
                throw new FormatException("MIDI channel event data byte has the high bit set.");
            }

            switch (command)
            {
                case 0x80:
                    target.Add(new RawEvent(absoluteTick, trackIndex, sequence++, RawEventKind.NoteOff, channel, data1, data2));
                    break;
                case 0x90:
                    target.Add(new RawEvent(
                        absoluteTick,
                        trackIndex,
                        sequence++,
                        data2 == 0 ? RawEventKind.NoteOff : RawEventKind.NoteOn,
                        channel,
                        data1,
                        data2));
                    break;
                case 0xB0 when data1 == 64:
                    target.Add(new RawEvent(absoluteTick, trackIndex, sequence++, RawEventKind.Sustain, channel, data1, data2));
                    break;
                default:
                    sequence++;
                    break;
            }
        }
    }

    private enum RawEventKind { NoteOn, NoteOff, Sustain, Tempo }
    private sealed record RawEvent(long Tick, int TrackIndex, int Sequence, RawEventKind Kind, int Channel, int Data1, int Data2);
    private sealed record NoteStart(long Tick, int TransposedPitch);
    private sealed record MidiNote(long StartTick, long EndTick, int Channel, int Pitch);
    private sealed record TempoChange(long Tick, int MicrosecondsPerQuarter);

    private ref struct MidiReader
    {
        private readonly ReadOnlySpan<byte> _bytes;
        private int _offset;

        public MidiReader(ReadOnlySpan<byte> bytes)
        {
            _bytes = bytes;
            _offset = 0;
        }

        public bool End => _offset == _bytes.Length;

        public byte PeekByte()
        {
            Ensure(1);
            return _bytes[_offset];
        }

        public byte ReadByte()
        {
            Ensure(1);
            return _bytes[_offset++];
        }

        public ushort ReadUInt16BigEndian()
        {
            Ensure(2);
            var value = BinaryPrimitives.ReadUInt16BigEndian(_bytes.Slice(_offset, 2));
            _offset += 2;
            return value;
        }

        public uint ReadUInt32BigEndian()
        {
            Ensure(4);
            var value = BinaryPrimitives.ReadUInt32BigEndian(_bytes.Slice(_offset, 4));
            _offset += 4;
            return value;
        }

        public long ReadVariableLength()
        {
            long value = 0;
            for (var index = 0; index < 4; index++)
            {
                var current = ReadByte();
                value = checked((value << 7) | (current & 0x7F));
                if ((current & 0x80) == 0)
                {
                    return value;
                }
            }

            throw new FormatException("MIDI variable-length quantity exceeds 4 bytes.");
        }

        public ReadOnlySpan<byte> ReadSlice(int length)
        {
            if (length < 0)
            {
                throw new FormatException("Negative MIDI chunk length.");
            }
            Ensure(length);
            var result = _bytes.Slice(_offset, length);
            _offset += length;
            return result;
        }

        public void Skip(int length) => _ = ReadSlice(length);

        public void ExpectAscii(string expected)
        {
            var expectedBytes = Encoding.ASCII.GetBytes(expected);
            var actual = ReadSlice(expectedBytes.Length);
            if (!actual.SequenceEqual(expectedBytes))
            {
                throw new FormatException($"Expected MIDI chunk '{expected}'.");
            }
        }

        private void Ensure(int length)
        {
            if (length < 0 || _offset > _bytes.Length - length)
            {
                throw new FormatException("Unexpected end of MIDI file.");
            }
        }
    }
}
