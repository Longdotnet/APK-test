using System.Globalization;
using System.Xml;
using System.Xml.Linq;

namespace RobloxPiano.Core;

public sealed record MusicXmlImportOptions(
    MidiKeyboardProfile? KeyboardProfile = null,
    int TransposeSemitones = 0)
{
    public MidiKeyboardProfile EffectiveKeyboardProfile => KeyboardProfile ?? MidiKeyboardProfile.RobloxClassic61;
}

public static class MusicXmlImporter
{
    private const double DefaultBpm = 120d;

    public static PerformanceTrack Import(string xml, MusicXmlImportOptions? options = null)
    {
        ArgumentNullException.ThrowIfNull(xml);
        options ??= new MusicXmlImportOptions();
        if (options.TransposeSemitones is < -48 or > 48)
        {
            throw new ArgumentOutOfRangeException(nameof(options), "MusicXML transpose must be between -48 and +48 semitones.");
        }

        XDocument document;
        try
        {
            document = XDocument.Parse(xml, LoadOptions.None);
        }
        catch (XmlException exception)
        {
            throw new FormatException("MusicXML is malformed.", exception);
        }

        var root = document.Root ?? throw new FormatException("MusicXML document has no root element.");
        if (!root.Name.LocalName.Equals("score-partwise", StringComparison.Ordinal))
        {
            throw new FormatException("Only MusicXML score-partwise documents are supported.");
        }

        var title = ReadTitle(root);
        var parts = root.Elements().Where(element => element.Name.LocalName == "part").ToArray();
        if (parts.Length == 0)
        {
            throw new FormatException("MusicXML contains no parts.");
        }

        var notes = new List<ParsedNote>();
        var initialBpm = DefaultBpm;
        var sawTempo = false;
        var globalEnd = 0d;

        foreach (var part in parts)
        {
            var divisions = 1d;
            var bpm = DefaultBpm;
            var cursorSeconds = 0d;
            var measureStartSeconds = 0d;
            var previousNoteStartSeconds = 0d;
            var tieStarts = new Dictionary<int, Queue<double>>();

            foreach (var measure in part.Elements().Where(element => element.Name.LocalName == "measure"))
            {
                measureStartSeconds = cursorSeconds;
                foreach (var child in measure.Elements())
                {
                    switch (child.Name.LocalName)
                    {
                        case "attributes":
                        {
                            var divisionsElement = Child(child, "divisions");
                            if (divisionsElement is not null)
                            {
                                divisions = ParsePositiveDouble(divisionsElement.Value, "MusicXML divisions");
                            }
                            break;
                        }
                        case "direction":
                        {
                            var tempo = ReadTempo(child);
                            if (tempo is not null)
                            {
                                bpm = tempo.Value;
                                if (!sawTempo)
                                {
                                    initialBpm = bpm;
                                    sawTempo = true;
                                }
                            }
                            break;
                        }
                        case "sound":
                        {
                            var tempoText = child.Attribute("tempo")?.Value;
                            if (!string.IsNullOrWhiteSpace(tempoText))
                            {
                                bpm = ParsePositiveDouble(tempoText, "MusicXML tempo");
                                if (!sawTempo)
                                {
                                    initialBpm = bpm;
                                    sawTempo = true;
                                }
                            }
                            break;
                        }
                        case "backup":
                        {
                            var duration = ReadDurationDivisions(child);
                            cursorSeconds -= DivisionsToSeconds(duration, divisions, bpm);
                            if (cursorSeconds < measureStartSeconds - 0.000001d)
                            {
                                throw new FormatException("MusicXML backup moves before the start of its measure.");
                            }
                            break;
                        }
                        case "forward":
                        {
                            var duration = ReadDurationDivisions(child);
                            cursorSeconds += DivisionsToSeconds(duration, divisions, bpm);
                            break;
                        }
                        case "note":
                        {
                            if (Child(child, "grace") is not null)
                            {
                                throw new FormatException("Grace notes are not supported yet; export them as measured notes before import.");
                            }

                            var isChord = Child(child, "chord") is not null;
                            var durationDivisions = ReadDurationDivisions(child);
                            var durationSeconds = DivisionsToSeconds(durationDivisions, divisions, bpm);
                            if (durationSeconds <= 0d)
                            {
                                throw new FormatException("MusicXML note duration must be positive.");
                            }

                            var startSeconds = isChord ? previousNoteStartSeconds : cursorSeconds;
                            if (!isChord)
                            {
                                previousNoteStartSeconds = startSeconds;
                            }

                            if (Child(child, "rest") is null)
                            {
                                var midiPitch = ReadMidiPitch(child) + options.TransposeSemitones;
                                var mappedKey = options.EffectiveKeyboardProfile.Map(midiPitch);
                                var tieTypes = child.Elements()
                                    .Where(element => element.Name.LocalName == "tie")
                                    .Select(element => element.Attribute("type")?.Value)
                                    .Where(value => !string.IsNullOrWhiteSpace(value))
                                    .ToHashSet(StringComparer.OrdinalIgnoreCase);
                                var stopTie = tieTypes.Contains("stop");
                                var startTie = tieTypes.Contains("start");

                                if (stopTie)
                                {
                                    if (!tieStarts.TryGetValue(midiPitch, out var queue) || queue.Count == 0)
                                    {
                                        throw new FormatException($"MusicXML tie stop for MIDI note {midiPitch} has no matching tie start.");
                                    }
                                    var tiedStart = queue.Dequeue();
                                    if (startTie)
                                    {
                                        queue.Enqueue(tiedStart);
                                    }
                                    else
                                    {
                                        notes.Add(new ParsedNote(tiedStart, startSeconds + durationSeconds, midiPitch, mappedKey));
                                    }
                                }
                                else if (startTie)
                                {
                                    if (!tieStarts.TryGetValue(midiPitch, out var queue))
                                    {
                                        queue = new Queue<double>();
                                        tieStarts.Add(midiPitch, queue);
                                    }
                                    queue.Enqueue(startSeconds);
                                }
                                else
                                {
                                    notes.Add(new ParsedNote(startSeconds, startSeconds + durationSeconds, midiPitch, mappedKey));
                                }
                            }

                            if (!isChord)
                            {
                                cursorSeconds += durationSeconds;
                            }
                            break;
                        }
                    }
                }
            }

            if (tieStarts.Any(pair => pair.Value.Count > 0))
            {
                throw new FormatException("MusicXML ended with an unterminated tied note.");
            }

            globalEnd = Math.Max(globalEnd, cursorSeconds);
        }

        if (notes.Count == 0)
        {
            throw new FormatException("MusicXML contains no playable notes in the active Roblox keyboard range.");
        }

        var grouped = notes
            .OrderBy(note => note.StartSeconds)
            .ThenBy(note => note.MidiPitch)
            .GroupBy(note => (StartTicks: ToTicks(note.StartSeconds), EndTicks: ToTicks(note.EndSeconds)))
            .Select(group => new PerformanceEvent(
                TimeSpan.FromTicks(group.Key.StartTicks),
                TimeSpan.FromTicks(group.Key.EndTicks - group.Key.StartTicks),
                group.Select(note => note.Key).Distinct().ToArray()))
            .ToArray();

        var eventEnd = grouped.Max(item => item.Start + item.Duration);
        var timeline = TimeSpan.FromTicks(Math.Max(ToTicks(globalEnd), eventEnd.Ticks));
        return new PerformanceTrack(
            title,
            initialBpm,
            1,
            TimeSpan.Zero,
            grouped,
            timeline);
    }

    private static string ReadTitle(XElement root)
    {
        var movement = Child(root, "movement-title")?.Value.Trim();
        if (!string.IsNullOrWhiteSpace(movement))
        {
            return movement;
        }

        var work = Child(Child(root, "work"), "work-title")?.Value.Trim();
        return string.IsNullOrWhiteSpace(work) ? "MusicXML performance" : work;
    }

    private static double? ReadTempo(XElement direction)
    {
        var soundTempo = direction.Descendants().FirstOrDefault(element => element.Name.LocalName == "sound")?.Attribute("tempo")?.Value;
        if (!string.IsNullOrWhiteSpace(soundTempo))
        {
            return ParsePositiveDouble(soundTempo, "MusicXML tempo");
        }

        var perMinute = direction.Descendants().FirstOrDefault(element => element.Name.LocalName == "per-minute")?.Value;
        return string.IsNullOrWhiteSpace(perMinute) ? null : ParsePositiveDouble(perMinute, "MusicXML metronome tempo");
    }

    private static double ReadDurationDivisions(XElement parent)
    {
        var duration = Child(parent, "duration")?.Value
            ?? throw new FormatException($"MusicXML {parent.Name.LocalName} is missing duration.");
        return ParsePositiveDouble(duration, "MusicXML duration");
    }

    private static int ReadMidiPitch(XElement note)
    {
        var pitch = Child(note, "pitch") ?? throw new FormatException("MusicXML pitched note is missing pitch.");
        var stepText = Child(pitch, "step")?.Value.Trim().ToUpperInvariant()
            ?? throw new FormatException("MusicXML pitch is missing step.");
        var semitone = stepText switch
        {
            "C" => 0,
            "D" => 2,
            "E" => 4,
            "F" => 5,
            "G" => 7,
            "A" => 9,
            "B" => 11,
            _ => throw new FormatException($"MusicXML pitch step '{stepText}' is invalid.")
        };
        var alter = 0;
        var alterElement = Child(pitch, "alter");
        if (alterElement is not null)
        {
            if (!int.TryParse(alterElement.Value, NumberStyles.Integer, CultureInfo.InvariantCulture, out alter) || alter is < -2 or > 2)
            {
                throw new FormatException("MusicXML pitch alter must be an integer between -2 and +2 semitones.");
            }
        }
        var octaveText = Child(pitch, "octave")?.Value
            ?? throw new FormatException("MusicXML pitch is missing octave.");
        if (!int.TryParse(octaveText, NumberStyles.Integer, CultureInfo.InvariantCulture, out var octave) || octave is < -1 or > 9)
        {
            throw new FormatException("MusicXML octave is outside the supported notation range.");
        }
        return checked((octave + 1) * 12 + semitone + alter);
    }

    private static double ParsePositiveDouble(string value, string label)
    {
        if (!double.TryParse(value, NumberStyles.Float, CultureInfo.InvariantCulture, out var parsed)
            || !double.IsFinite(parsed)
            || parsed <= 0d)
        {
            throw new FormatException($"{label} must be a finite number greater than zero.");
        }
        return parsed;
    }

    private static double DivisionsToSeconds(double duration, double divisions, double bpm)
        => duration / divisions * 60d / bpm;

    private static long ToTicks(double seconds)
    {
        var ticks = seconds * TimeSpan.TicksPerSecond;
        if (!double.IsFinite(ticks) || ticks < 0d || ticks > long.MaxValue)
        {
            throw new FormatException("MusicXML timing exceeds the supported timeline range.");
        }
        return (long)Math.Round(ticks, MidpointRounding.AwayFromZero);
    }

    private static XElement? Child(XElement? parent, string localName)
        => parent?.Elements().FirstOrDefault(element => element.Name.LocalName == localName);

    private sealed record ParsedNote(double StartSeconds, double EndSeconds, int MidiPitch, char Key);
}
