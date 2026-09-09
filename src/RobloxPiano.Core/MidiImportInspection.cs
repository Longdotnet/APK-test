using System.Buffers.Binary;

namespace RobloxPiano.Core;

/// <summary>
/// Diagnostic view of the compatibility decisions made before a MIDI reaches the
/// canonical performance model. Playback truth remains owned by MidiFileImporter;
/// this inspector exists so range auto-fit and General MIDI percussion filtering
/// are visible to clients instead of becoming silent source mutations.
/// </summary>
public sealed record MidiImportInspection(
    int MelodicNoteOnCount,
    int IgnoredPercussionNoteOnCount,
    int SourceLowestMidiNote,
    int SourceHighestMidiNote,
    int RequestedTransposeSemitones,
    int AutomaticRangeAdjustmentSemitones,
    int EffectiveTransposeSemitones,
    int EffectiveLowestMidiNote,
    int EffectiveHighestMidiNote)
{
    public bool WasRangeAutoFitted => AutomaticRangeAdjustmentSemitones != 0;
    public bool IgnoredPercussion => IgnoredPercussionNoteOnCount > 0;
    public bool HasCompatibilityAdjustment => WasRangeAutoFitted || IgnoredPercussion;

    public string Summary
    {
        get
        {
            var parts = new List<string>();
            if (WasRangeAutoFitted)
            {
                parts.Add($"range auto-fit {FormatSigned(AutomaticRangeAdjustmentSemitones)} st");
            }
            if (IgnoredPercussion)
            {
                parts.Add($"ignored {IgnoredPercussionNoteOnCount} drum note{(IgnoredPercussionNoteOnCount == 1 ? string.Empty : "s")}");
            }
            return parts.Count == 0 ? "source preserved" : string.Join(", ", parts);
        }
    }

    private static string FormatSigned(int value) => value > 0 ? $"+{value}" : value.ToString();
}

public static class MidiImportInspector
{
    private const int GeneralMidiPercussionChannel = 9;

    /// <summary>
    /// Best-effort diagnostics only. A failure here never makes an otherwise valid
    /// MIDI unplayable; callers must continue to use MidiFileImporter for validation.
    /// </summary>
    public static MidiImportInspection? TryInspect(ReadOnlySpan<byte> bytes, MidiImportOptions? options = null)
    {
        try
        {
            return Inspect(bytes, options ?? new MidiImportOptions());
        }
        catch (Exception exception) when (
            exception is FormatException
            or ArgumentException
            or OverflowException
            or IndexOutOfRangeException)
        {
            return null;
        }
    }

    public static MidiImportInspection Inspect(ReadOnlySpan<byte> bytes, MidiImportOptions? options = null)
    {
        options ??= new MidiImportOptions();
        var reader = new InspectorReader(bytes);
        reader.ExpectAscii("MThd");
        var headerLength = reader.ReadUInt32BigEndian();
        if (headerLength < 6)
        {
            throw new FormatException("MIDI header chunk is shorter than 6 bytes.");
        }

        var format = reader.ReadUInt16BigEndian();
        var trackCount = reader.ReadUInt16BigEndian();
        _ = reader.ReadUInt16BigEndian(); // division is validated by the production importer.
        if (format is > 1 || trackCount == 0 || (format == 0 && trackCount != 1))
        {
            throw new FormatException("Unsupported MIDI structure for inspection.");
        }

        reader.Skip(checked((int)headerLength - 6));
        var melodicPitches = new List<int>();
        var melodicNoteOnCount = 0;
        var ignoredPercussionNoteOnCount = 0;

        for (var trackIndex = 0; trackIndex < trackCount; trackIndex++)
        {
            reader.ExpectAscii("MTrk");
            var trackLength = checked((int)reader.ReadUInt32BigEndian());
            InspectTrack(
                reader.ReadSlice(trackLength),
                options,
                melodicPitches,
                ref melodicNoteOnCount,
                ref ignoredPercussionNoteOnCount);
        }

        if (melodicPitches.Count == 0)
        {
            throw new FormatException("MIDI contains no melodic NoteOn events to inspect.");
        }

        var sourceMinimum = melodicPitches.Min();
        var sourceMaximum = melodicPitches.Max();
        var requestedMinimum = checked(sourceMinimum + options.TransposeSemitones);
        var requestedMaximum = checked(sourceMaximum + options.TransposeSemitones);
        var profile = options.EffectiveKeyboardProfile;
        var automaticAdjustment = ResolveAutomaticAdjustment(requestedMinimum, requestedMaximum, profile, options.AutoFitToKeyboardRange);
        var effectiveTranspose = checked(options.TransposeSemitones + automaticAdjustment);

        return new MidiImportInspection(
            melodicNoteOnCount,
            ignoredPercussionNoteOnCount,
            sourceMinimum,
            sourceMaximum,
            options.TransposeSemitones,
            automaticAdjustment,
            effectiveTranspose,
            checked(sourceMinimum + effectiveTranspose),
            checked(sourceMaximum + effectiveTranspose));
    }

    private static int ResolveAutomaticAdjustment(
        int minimum,
        int maximum,
        MidiKeyboardProfile profile,
        bool autoFit)
    {
        if (minimum >= profile.LowestMidiNote && maximum <= profile.HighestMidiNote)
        {
            return 0;
        }

        if (!autoFit)
        {
            return 0;
        }

        var minimumAdjustment = profile.LowestMidiNote - minimum;
        var maximumAdjustment = profile.HighestMidiNote - maximum;
        if (minimumAdjustment > maximumAdjustment)
        {
            throw new FormatException("MIDI range cannot fit the active keyboard profile.");
        }

        return minimumAdjustment > 0
            ? minimumAdjustment
            : maximumAdjustment < 0
                ? maximumAdjustment
                : 0;
    }

    private static void InspectTrack(
        ReadOnlySpan<byte> bytes,
        MidiImportOptions options,
        ICollection<int> melodicPitches,
        ref int melodicNoteOnCount,
        ref int ignoredPercussionNoteOnCount)
    {
        var reader = new InspectorReader(bytes);
        byte runningStatus = 0;
        while (!reader.End)
        {
            _ = reader.ReadVariableLength();
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
                    throw new FormatException("Invalid MIDI running status.");
                }
                status = runningStatus;
            }

            if (status == 0xFF)
            {
                runningStatus = 0;
                var metaType = reader.ReadByte();
                var length = checked((int)reader.ReadVariableLength());
                reader.Skip(length);
                if (metaType == 0x2F)
                {
                    return;
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
                throw new FormatException("Unsupported MIDI system event during inspection.");
            }

            var command = status & 0xF0;
            var channel = status & 0x0F;
            var data1 = reader.ReadByte();
            var oneDataByte = command is 0xC0 or 0xD0;
            var data2 = oneDataByte ? (byte)0 : reader.ReadByte();

            if (command == 0x90 && data2 != 0)
            {
                if (options.IgnoreGeneralMidiPercussion && channel == GeneralMidiPercussionChannel)
                {
                    ignoredPercussionNoteOnCount++;
                }
                else
                {
                    melodicNoteOnCount++;
                    melodicPitches.Add(data1);
                }
            }
        }
    }

    private ref struct InspectorReader
    {
        private readonly ReadOnlySpan<byte> _bytes;
        private int _offset;

        public InspectorReader(ReadOnlySpan<byte> bytes)
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
                value = checked((value << 7) | (long)(current & 0x7F));
                if ((current & 0x80) == 0)
                {
                    return value;
                }
            }
            throw new FormatException("MIDI variable-length value exceeds four bytes.");
        }

        public ReadOnlySpan<byte> ReadSlice(int length)
        {
            Ensure(length);
            var result = _bytes.Slice(_offset, length);
            _offset += length;
            return result;
        }

        public void Skip(int length)
        {
            Ensure(length);
            _offset += length;
        }

        public void ExpectAscii(string expected)
        {
            var bytes = System.Text.Encoding.ASCII.GetBytes(expected);
            if (!ReadSlice(bytes.Length).SequenceEqual(bytes))
            {
                throw new FormatException($"Expected MIDI chunk '{expected}'.");
            }
        }

        private void Ensure(int length)
        {
            if (length < 0 || _offset > _bytes.Length - length)
            {
                throw new FormatException("Unexpected end of MIDI data during inspection.");
            }
        }
    }
}
