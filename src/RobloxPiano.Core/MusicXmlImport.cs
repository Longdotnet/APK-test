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
    private const double PositionTolerance = 0.000000001d;

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
        var tempoMarkers = new List<TempoMarker>();
        var globalEndQuarter = 0d;

        foreach (var part in parts)
        {
            var divisions = 1d;
            var cursorQuarter = 0d;
            var previousNoteStartQuarter = 0d;
            var tieStarts = new Dictionary<int, Queue<double>>();

            foreach (var measure in part.Elements().Where(element => element.Name.LocalName == "measure"))
            {
                var measureStartQuarter = cursorQuarter;
                var measureEndQuarter = cursorQuarter;

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
                            var tempo = ReadTempoQuarterBpm(child);
                            if (tempo is not null)
                            {
                                var offset = ReadDirectionOffsetQuarter(child, divisions);
                                AddTempoMarker(tempoMarkers, cursorQuarter + offset, tempo.Value);
                            }
                            break;
                        }
                        case "sound":
                        {
                            var tempoText = child.Attribute("tempo")?.Value;
                            if (!string.IsNullOrWhiteSpace(tempoText))
                            {
                                AddTempoMarker(tempoMarkers, cursorQuarter, ParsePositiveDouble(tempoText, "MusicXML tempo"));
                            }
                            break;
                        }
                        case "backup":
                        {
                            var durationQuarter = DivisionsToQuarter(ReadDurationDivisions(child), divisions);
                            cursorQuarter -= durationQuarter;
                            if (cursorQuarter < measureStartQuarter - PositionTolerance)
                            {
                                throw new FormatException("MusicXML backup moves before the start of its measure.");
                            }
                            cursorQuarter = Math.Max(cursorQuarter, measureStartQuarter);
                            break;
                        }
                        case "forward":
                        {
                            var durationQuarter = DivisionsToQuarter(ReadDurationDivisions(child), divisions);
                            cursorQuarter += durationQuarter;
                            measureEndQuarter = Math.Max(measureEndQuarter, cursorQuarter);
                            break;
                        }
                        case "note":
                        {
                            if (Child(child, "grace") is not null)
                            {
                                throw new FormatException("Grace notes are not supported yet; export them as measured notes before import.");
                            }

                            var isChord = Child(child, "chord") is not null;
                            var durationQuarter = DivisionsToQuarter(ReadDurationDivisions(child), divisions);
                            if (durationQuarter <= 0d)
                            {
                                throw new FormatException("MusicXML note duration must be positive.");
                            }

                            var startQuarter = isChord ? previousNoteStartQuarter : cursorQuarter;
                            if (!isChord)
                            {
                                previousNoteStartQuarter = startQuarter;
                            }
                            var endQuarter = startQuarter + durationQuarter;
                            measureEndQuarter = Math.Max(measureEndQuarter, endQuarter);

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
                                        notes.Add(new ParsedNote(tiedStart, endQuarter, midiPitch, mappedKey));
                                    }
                                }
                                else if (startTie)
                                {
                                    if (!tieStarts.TryGetValue(midiPitch, out var queue))
                                    {
                                        queue = new Queue<double>();
                                        tieStarts.Add(midiPitch, queue);
                                    }
                                    queue.Enqueue(startQuarter);
                                }
                                else
                                {
                                    notes.Add(new ParsedNote(startQuarter, endQuarter, midiPitch, mappedKey));
                                }
                            }

                            if (!isChord)
                            {
                                cursorQuarter += durationQuarter;
                            }
                            break;
                        }
                    }
                }

                // MusicXML backup/forward is a voice cursor operation, not the measure's durable extent.
                // The next measure starts after the furthest event/forward reached by any voice.
                cursorQuarter = measureEndQuarter;
            }

            if (tieStarts.Any(pair => pair.Value.Count > 0))
            {
                throw new FormatException("MusicXML ended with an unterminated tied note.");
            }

            globalEndQuarter = Math.Max(globalEndQuarter, cursorQuarter);
        }

        if (notes.Count == 0)
        {
            throw new FormatException("MusicXML contains no playable notes in the active Roblox keyboard range.");
        }

        var tempoMap = BuildTempoMap(tempoMarkers);
        var initialBpm = tempoMap[0].Bpm;
        var timedNotes = notes
            .Select(note => new TimedNote(
                QuarterToSeconds(note.StartQuarter, tempoMap),
                QuarterToSeconds(note.EndQuarter, tempoMap),
                note.MidiPitch,
                note.Key))
            .ToArray();

        var grouped = timedNotes
            .OrderBy(note => note.StartSeconds)
            .ThenBy(note => note.MidiPitch)
            .GroupBy(note => (StartTicks: ToTicks(note.StartSeconds), EndTicks: ToTicks(note.EndSeconds)))
            .Select(group => new PerformanceEvent(
                TimeSpan.FromTicks(group.Key.StartTicks),
                TimeSpan.FromTicks(group.Key.EndTicks - group.Key.StartTicks),
                group.Select(note => note.Key).Distinct().ToArray()))
            .ToArray();

        var eventEnd = grouped.Max(item => item.Start + item.Duration);
        var timelineSeconds = QuarterToSeconds(globalEndQuarter, tempoMap);
        var timeline = TimeSpan.FromTicks(Math.Max(ToTicks(timelineSeconds), eventEnd.Ticks));
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

    private static double? ReadTempoQuarterBpm(XElement direction)
    {
        var soundTempo = direction.Descendants().FirstOrDefault(element => element.Name.LocalName == "sound")?.Attribute("tempo")?.Value;
        if (!string.IsNullOrWhiteSpace(soundTempo))
        {
            return ParsePositiveDouble(soundTempo, "MusicXML tempo");
        }

        var metronome = direction.Descendants().FirstOrDefault(element => element.Name.LocalName == "metronome");
        if (metronome is null)
        {
            return null;
        }

        var perMinuteText = Child(metronome, "per-minute")?.Value;
        if (string.IsNullOrWhiteSpace(perMinuteText))
        {
            return null;
        }

        var perMinute = ParsePositiveDouble(perMinuteText, "MusicXML metronome tempo");
        var beatUnit = Child(metronome, "beat-unit")?.Value.Trim().ToLowerInvariant() ?? "quarter";
        var quarterLength = beatUnit switch
        {
            "1024th" => 1d / 256d,
            "512th" => 1d / 128d,
            "256th" => 1d / 64d,
            "128th" => 1d / 32d,
            "64th" => 1d / 16d,
            "32nd" => 1d / 8d,
            "16th" => 1d / 4d,
            "eighth" => 1d / 2d,
            "quarter" => 1d,
            "half" => 2d,
            "whole" => 4d,
            "breve" => 8d,
            "long" => 16d,
            "maxima" => 32d,
            _ => throw new FormatException($"MusicXML metronome beat-unit '{beatUnit}' is not supported.")
        };

        var dotCount = metronome.Elements().Count(element => element.Name.LocalName == "beat-unit-dot");
        var dotAddition = quarterLength;
        for (var index = 0; index < dotCount; index++)
        {
            dotAddition /= 2d;
            quarterLength += dotAddition;
        }

        return perMinute * quarterLength;
    }

    private static double ReadDirectionOffsetQuarter(XElement direction, double divisions)
    {
        var offset = Child(direction, "offset");
        if (offset is null || string.IsNullOrWhiteSpace(offset.Value))
        {
            return 0d;
        }

        if (!double.TryParse(offset.Value, NumberStyles.Float, CultureInfo.InvariantCulture, out var parsed)
            || !double.IsFinite(parsed))
        {
            throw new FormatException("MusicXML direction offset must be a finite number.");
        }

        return parsed / divisions;
    }

    private static void AddTempoMarker(List<TempoMarker> markers, double quarter, double bpm)
    {
        if (!double.IsFinite(quarter) || quarter < -PositionTolerance)
        {
            throw new FormatException("MusicXML tempo marker resolves before the start of the score.");
        }
        markers.Add(new TempoMarker(Math.Max(0d, quarter), bpm));
    }

    private static IReadOnlyList<TempoMarker> BuildTempoMap(IEnumerable<TempoMarker> markers)
    {
        var ordered = markers
            .Append(new TempoMarker(0d, DefaultBpm))
            .OrderBy(item => item.Quarter)
            .ThenBy(item => item.Bpm)
            .ToArray();

        var result = new List<TempoMarker>();
        foreach (var marker in ordered)
        {
            if (result.Count > 0 && Math.Abs(result[^1].Quarter - marker.Quarter) <= PositionTolerance)
            {
                // An explicit tempo at score start overrides the synthetic 120 BPM default.
                if (Math.Abs(result[^1].Quarter) <= PositionTolerance && Math.Abs(result[^1].Bpm - DefaultBpm) <= PositionTolerance)
                {
                    result[^1] = marker;
                    continue;
                }
                if (Math.Abs(result[^1].Bpm - marker.Bpm) > PositionTolerance)
                {
                    throw new FormatException($"MusicXML contains conflicting tempo values at quarter position {marker.Quarter.ToString("0.########", CultureInfo.InvariantCulture)}.");
                }
                continue;
            }
            result.Add(marker);
        }

        if (result.Count == 0 || result[0].Quarter > PositionTolerance)
        {
            result.Insert(0, new TempoMarker(0d, DefaultBpm));
        }
        return result;
    }

    private static double QuarterToSeconds(double quarter, IReadOnlyList<TempoMarker> tempoMap)
    {
        if (!double.IsFinite(quarter) || quarter < 0d)
        {
            throw new FormatException("MusicXML timing resolves outside the supported score range.");
        }

        var seconds = 0d;
        var position = 0d;
        var bpm = tempoMap[0].Bpm;
        for (var index = 1; index < tempoMap.Count && tempoMap[index].Quarter < quarter - PositionTolerance; index++)
        {
            var marker = tempoMap[index];
            seconds += (marker.Quarter - position) * 60d / bpm;
            position = marker.Quarter;
            bpm = marker.Bpm;
        }

        if (tempoMap.Count > 1)
        {
            var exact = tempoMap.LastOrDefault(marker => Math.Abs(marker.Quarter - quarter) <= PositionTolerance);
            if (exact is not null && exact.Quarter > position + PositionTolerance)
            {
                seconds += (exact.Quarter - position) * 60d / bpm;
                position = exact.Quarter;
                bpm = exact.Bpm;
            }
        }

        seconds += (quarter - position) * 60d / bpm;
        return seconds;
    }

    private static double ReadDurationDivisions(XElement parent)
    {
        var duration = Child(parent, "duration")?.Value
            ?? throw new FormatException($"MusicXML {parent.Name.LocalName} is missing duration.");
        return ParsePositiveDouble(duration, "MusicXML duration");
    }

    private static double DivisionsToQuarter(double duration, double divisions)
        => duration / divisions;

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

    private sealed record ParsedNote(double StartQuarter, double EndQuarter, int MidiPitch, char Key);
    private sealed record TimedNote(double StartSeconds, double EndSeconds, int MidiPitch, char Key);
    private sealed record TempoMarker(double Quarter, double Bpm);
}
