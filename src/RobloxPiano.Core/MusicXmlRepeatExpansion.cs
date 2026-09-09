using System.Globalization;
using System.Xml.Linq;

namespace RobloxPiano.Core;

/// <summary>
/// Expands the production-supported MusicXML repeat subset into a linear score before canonical timing compilation.
/// Supports deterministic two-pass forward/backward repeats with optional first/second endings. Sequential repeats are
/// supported; nested repeats, repeat counts other than two, malformed ending ranges, and ending numbers other than 1/2 fail closed.
/// </summary>
public static class MusicXmlRepeatExpansion
{
    public static XDocument Expand(XDocument document)
    {
        ArgumentNullException.ThrowIfNull(document);
        var clone = new XDocument(document);
        var root = clone.Root ?? throw new FormatException("MusicXML document has no root element.");

        foreach (var part in root.Elements().Where(element => element.Name.LocalName == "part"))
        {
            var measures = part.Elements().Where(element => element.Name.LocalName == "measure").ToArray();
            var expanded = ExpandPart(measures, part.Attribute("id")?.Value);
            foreach (var measure in measures)
            {
                measure.Remove();
            }
            foreach (var measure in expanded)
            {
                part.Add(measure);
            }
        }

        return clone;
    }

    public static void Validate(XDocument document)
    {
        ArgumentNullException.ThrowIfNull(document);
        var root = document.Root ?? throw new FormatException("MusicXML document has no root element.");
        foreach (var part in root.Elements().Where(element => element.Name.LocalName == "part"))
        {
            _ = ExpandPart(part.Elements().Where(element => element.Name.LocalName == "measure").ToArray(), part.Attribute("id")?.Value);
        }
    }

    private static IReadOnlyList<XElement> ExpandPart(IReadOnlyList<XElement> measures, string? partId)
    {
        if (measures.Count == 0)
        {
            return [];
        }

        var metadata = BuildMetadata(measures, partId);
        ValidateRepeatTopology(metadata, partId);

        var output = new List<XElement>();
        var index = 0;
        var repeatStart = 0;
        var repeatActive = false;
        var pass = 1;
        var guard = 0;
        var maxSteps = Math.Max(32, measures.Count * 8);

        while (index < measures.Count)
        {
            if (++guard > maxSteps)
            {
                throw Error(partId, index, "Repeat expansion exceeded the deterministic safety bound.");
            }

            var current = metadata[index];
            if (current.ForwardRepeat)
            {
                // On pass two we intentionally revisit the same forward marker. Do not reset the pass.
                if (!repeatActive)
                {
                    repeatStart = index;
                    repeatActive = true;
                    pass = 1;
                }
                else if (index != repeatStart)
                {
                    throw Error(partId, index, "Nested forward repeats are not supported.");
                }
            }

            if (current.EndingNumbers.Count == 0 || current.EndingNumbers.Contains(pass))
            {
                output.Add(StripControlMarkup(new XElement(measures[index])));
            }

            if (current.BackwardRepeat)
            {
                if (!repeatActive)
                {
                    // MusicXML permits a backward repeat without an explicit forward marker; it repeats from score start.
                    repeatStart = 0;
                    repeatActive = true;
                    pass = 1;
                }

                if (pass == 1)
                {
                    pass = 2;
                    index = repeatStart;
                    continue;
                }

                repeatActive = false;
                pass = 1;
            }

            index++;
        }

        return output;
    }

    private static MeasureMetadata[] BuildMetadata(IReadOnlyList<XElement> measures, string? partId)
    {
        var result = new MeasureMetadata[measures.Count];
        var activeEndings = new HashSet<int>();

        for (var index = 0; index < measures.Count; index++)
        {
            var measure = measures[index];
            var barlines = measure.Elements().Where(element => element.Name.LocalName == "barline").ToArray();

            foreach (var ending in barlines.SelectMany(barline => barline.Elements().Where(element => element.Name.LocalName == "ending")))
            {
                var type = ending.Attribute("type")?.Value?.Trim().ToLowerInvariant();
                var numbers = ParseEndingNumbers(ending.Attribute("number")?.Value, partId, index);
                if (type == "start")
                {
                    if (numbers.Count == 0)
                    {
                        throw Error(partId, index, "Ending start requires number 1 or 2.");
                    }
                    foreach (var number in numbers)
                    {
                        activeEndings.Add(number);
                    }
                }
                else if (type is not ("stop" or "discontinue"))
                {
                    throw Error(partId, index, $"Ending type '{type ?? "<missing>"}' is not supported.");
                }
            }

            var forward = false;
            var backward = false;
            foreach (var repeat in barlines.SelectMany(barline => barline.Elements().Where(element => element.Name.LocalName == "repeat")))
            {
                var direction = repeat.Attribute("direction")?.Value?.Trim().ToLowerInvariant();
                var timesText = repeat.Attribute("times")?.Value;
                if (!string.IsNullOrWhiteSpace(timesText)
                    && (!int.TryParse(timesText, NumberStyles.Integer, CultureInfo.InvariantCulture, out var times) || times != 2))
                {
                    throw Error(partId, index, "Only deterministic two-pass MusicXML repeats are supported; repeat times must be 2 when specified.");
                }

                switch (direction)
                {
                    case "forward": forward = true; break;
                    case "backward": backward = true; break;
                    default: throw Error(partId, index, $"Repeat direction '{direction ?? "<missing>"}' is invalid.");
                }
            }

            result[index] = new MeasureMetadata(forward, backward, activeEndings.ToHashSet());

            foreach (var ending in barlines.SelectMany(barline => barline.Elements().Where(element => element.Name.LocalName == "ending")))
            {
                var type = ending.Attribute("type")?.Value?.Trim().ToLowerInvariant();
                if (type is "stop" or "discontinue")
                {
                    var numbers = ParseEndingNumbers(ending.Attribute("number")?.Value, partId, index);
                    if (numbers.Count == 0)
                    {
                        activeEndings.Clear();
                    }
                    else
                    {
                        foreach (var number in numbers)
                        {
                            activeEndings.Remove(number);
                        }
                    }
                }
            }
        }

        if (activeEndings.Count > 0)
        {
            throw Error(partId, measures.Count - 1, "MusicXML ending range is not terminated.");
        }

        return result;
    }

    private static void ValidateRepeatTopology(IReadOnlyList<MeasureMetadata> metadata, string? partId)
    {
        var active = false;
        for (var index = 0; index < metadata.Count; index++)
        {
            if (metadata[index].ForwardRepeat)
            {
                if (active)
                {
                    throw Error(partId, index, "Nested forward repeats are not supported.");
                }
                active = true;
            }

            if (metadata[index].BackwardRepeat)
            {
                active = false;
            }
        }
    }

    private static HashSet<int> ParseEndingNumbers(string? value, string? partId, int measureIndex)
    {
        var result = new HashSet<int>();
        if (string.IsNullOrWhiteSpace(value))
        {
            return result;
        }

        foreach (var token in value.Split([',', ' '], StringSplitOptions.RemoveEmptyEntries | StringSplitOptions.TrimEntries))
        {
            if (!int.TryParse(token, NumberStyles.Integer, CultureInfo.InvariantCulture, out var number) || number is < 1 or > 2)
            {
                throw Error(partId, measureIndex, "Only first/second ending numbers 1 and 2 are supported.");
            }
            result.Add(number);
        }
        return result;
    }

    private static XElement StripControlMarkup(XElement measure)
    {
        foreach (var barline in measure.Elements().Where(element => element.Name.LocalName == "barline").ToArray())
        {
            foreach (var control in barline.Elements().Where(element => element.Name.LocalName is "repeat" or "ending").ToArray())
            {
                control.Remove();
            }
            if (!barline.HasElements && string.IsNullOrWhiteSpace(barline.Value))
            {
                barline.Remove();
            }
        }
        return measure;
    }

    private static FormatException Error(string? partId, int measureIndex, string message)
        => new($"MusicXML repeat expansion failed{(string.IsNullOrWhiteSpace(partId) ? string.Empty : $" in part {partId}")} at measure index {measureIndex + 1}: {message}");

    private sealed record MeasureMetadata(bool ForwardRepeat, bool BackwardRepeat, HashSet<int> EndingNumbers);
}
