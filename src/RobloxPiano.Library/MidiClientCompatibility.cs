using RobloxPiano.Core;

namespace RobloxPiano.Library;

/// <summary>
/// Client-only compatibility fallback for Standard MIDI files whose melodic span is
/// wider than the physical Roblox classic 61-key range. The production importer is
/// always attempted first. This profile is used only after that importer proves one
/// global transpose cannot fit the source.
///
/// The logical profile covers all MIDI pitches 0..127, while every logical pitch maps
/// to the same pitch class folded by whole octaves into the physical 36..96 Roblox
/// range. In-range pitches are unchanged. Source files are never rewritten.
/// </summary>
internal static class MidiClientCompatibility
{
    private static readonly MidiKeyboardProfile FoldedMidi128Profile = BuildFoldedProfile();

    public static MidiImportOptions WideRangeFallbackOptions { get; } = new(
        KeyboardProfile: FoldedMidi128Profile,
        TransposeSemitones: 0,
        AutoFitToKeyboardRange: false,
        IgnoreGeneralMidiPercussion: true);

    public static bool IsWideRangeFailure(FormatException exception)
    {
        ArgumentNullException.ThrowIfNull(exception);
        return exception.Message.StartsWith("MIDI melodic range ", StringComparison.Ordinal)
            && exception.Message.Contains("cannot fit the active Roblox keyboard range", StringComparison.Ordinal)
            && exception.Message.Contains("with one global transpose", StringComparison.Ordinal);
    }

    public static SongLoadMetadata BuildMetadata(ReadOnlySpan<byte> bytes)
    {
        var inspection = MidiImportInspector.TryInspect(bytes, WideRangeFallbackOptions);
        var classic = MidiKeyboardProfile.RobloxClassic61;
        var sourceRange = inspection is null
            ? "wide source range"
            : $"wide range {inspection.SourceLowestMidiNote}..{inspection.SourceHighestMidiNote}";

        var parts = new List<string>
        {
            $"octave-folded {sourceRange} into Roblox {classic.LowestMidiNote}..{classic.HighestMidiNote}"
        };

        var ignoredPercussion = inspection?.IgnoredPercussionNoteOnCount ?? 0;
        if (ignoredPercussion > 0)
        {
            parts.Add($"ignored {ignoredPercussion} drum note{(ignoredPercussion == 1 ? string.Empty : "s")}");
        }

        return new SongLoadMetadata(
            string.Join(", ", parts),
            EffectiveTransposeSemitones: 0,
            IgnoredPercussionNoteOns: ignoredPercussion,
            SourceLowestMidiNote: inspection?.SourceLowestMidiNote,
            SourceHighestMidiNote: inspection?.SourceHighestMidiNote,
            EffectiveLowestMidiNote: null,
            EffectiveHighestMidiNote: null,
            UsedOctaveFolding: true);
    }

    internal static int FoldPitchIntoClassicRange(int midiPitch)
    {
        var classic = MidiKeyboardProfile.RobloxClassic61;
        var folded = midiPitch;

        while (folded < classic.LowestMidiNote)
        {
            folded = checked(folded + 12);
        }

        while (folded > classic.HighestMidiNote)
        {
            folded = checked(folded - 12);
        }

        if (folded < classic.LowestMidiNote || folded > classic.HighestMidiNote)
        {
            throw new InvalidOperationException(
                $"MIDI pitch {midiPitch} cannot be octave-folded into Roblox range " +
                $"{classic.LowestMidiNote}..{classic.HighestMidiNote}.");
        }

        return folded;
    }

    private static MidiKeyboardProfile BuildFoldedProfile()
    {
        var classic = MidiKeyboardProfile.RobloxClassic61;
        var logicalKeys = new char[128];
        for (var pitch = 0; pitch < logicalKeys.Length; pitch++)
        {
            logicalKeys[pitch] = classic.Map(FoldPitchIntoClassicRange(pitch));
        }

        return new MidiKeyboardProfile(0, new string(logicalKeys));
    }
}
