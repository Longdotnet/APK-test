using System.Xml;
using System.Xml.Linq;

namespace RobloxPiano.Core;

public enum MusicXmlDiagnosticSeverity
{
    Info = 0,
    Warning = 1,
    Error = 2
}

public sealed record MusicXmlDiagnostic(
    string Code,
    MusicXmlDiagnosticSeverity Severity,
    string Message,
    string? Measure = null,
    string? Part = null);

public sealed record MusicXmlConformanceReport(IReadOnlyList<MusicXmlDiagnostic> Diagnostics)
{
    public bool CanImport => Diagnostics.All(item => item.Severity != MusicXmlDiagnosticSeverity.Error);

    public IReadOnlyList<MusicXmlDiagnostic> Errors => Diagnostics
        .Where(item => item.Severity == MusicXmlDiagnosticSeverity.Error)
        .ToArray();
}

/// <summary>
/// Deterministic production gate for MusicXML constructs. Anything that could alter audible
/// pitch/order/expression but is not modeled by the canonical importer is rejected instead of
/// being silently ignored. Musical-time direction offsets, tempo+backup and measured tuplets are
/// supported because canonical timing is compiled from MusicXML duration values.
/// </summary>
public static class MusicXmlConformance
{
    public static MusicXmlConformanceReport Analyze(string xml)
    {
        ArgumentNullException.ThrowIfNull(xml);

        XDocument document;
        try
        {
            document = XDocument.Parse(xml, LoadOptions.None);
        }
        catch (XmlException exception)
        {
            return new MusicXmlConformanceReport([
                new MusicXmlDiagnostic("MXML001", MusicXmlDiagnosticSeverity.Error, $"MusicXML is malformed: {exception.Message}")
            ]);
        }

        var root = document.Root;
        if (root is null)
        {
            return new MusicXmlConformanceReport([
                new MusicXmlDiagnostic("MXML002", MusicXmlDiagnosticSeverity.Error, "MusicXML document has no root element.")
            ]);
        }

        if (!root.Name.LocalName.Equals("score-partwise", StringComparison.Ordinal))
        {
            return new MusicXmlConformanceReport([
                new MusicXmlDiagnostic("MXML003", MusicXmlDiagnosticSeverity.Error, "Only MusicXML score-partwise documents are supported for production playback.")
            ]);
        }

        var diagnostics = new List<MusicXmlDiagnostic>();
        foreach (var part in root.Elements().Where(element => element.Name.LocalName == "part"))
        {
            var partId = part.Attribute("id")?.Value;
            foreach (var measure in part.Elements().Where(element => element.Name.LocalName == "measure"))
            {
                var measureNumber = measure.Attribute("number")?.Value;
                AnalyzeMeasure(measure, partId, measureNumber, diagnostics);
            }
        }

        return new MusicXmlConformanceReport(diagnostics);
    }

    public static void ValidateForProductionImport(string xml)
    {
        var report = Analyze(xml);
        if (report.CanImport)
        {
            return;
        }

        var first = report.Errors[0];
        var location = BuildLocation(first);
        throw new FormatException($"{first.Code}: {first.Message}{location}");
    }

    private static void AnalyzeMeasure(
        XElement measure,
        string? partId,
        string? measureNumber,
        List<MusicXmlDiagnostic> diagnostics)
    {
        AddUnsupported(measure, "repeat", "MXML101", "Repeats are not expanded by the canonical importer yet.", partId, measureNumber, diagnostics);
        AddUnsupported(measure, "ending", "MXML102", "First/second endings are not expanded by the canonical importer yet.", partId, measureNumber, diagnostics);
        AnalyzeTuplets(measure, partId, measureNumber, diagnostics);
        AddUnsupported(measure, "ornaments", "MXML105", "Ornaments are not expanded into deterministic notes yet.", partId, measureNumber, diagnostics);
        AddUnsupported(measure, "pedal", "MXML106", "MusicXML pedal notation is not compiled to canonical sustain yet.", partId, measureNumber, diagnostics);
        AddUnsupported(measure, "grace", "MXML107", "Grace notes are not assigned deterministic measured timing yet.", partId, measureNumber, diagnostics);
        AddUnsupported(measure, "cue", "MXML108", "Cue notes are not part of the production playback subset.", partId, measureNumber, diagnostics);
        AddUnsupported(measure, "unpitched", "MXML109", "Unpitched notes cannot map to the Roblox piano keyboard.", partId, measureNumber, diagnostics);

        var transpose = measure.Descendants().FirstOrDefault(element => element.Name.LocalName == "transpose");
        if (transpose is not null)
        {
            diagnostics.Add(new MusicXmlDiagnostic(
                "MXML112",
                MusicXmlDiagnosticSeverity.Error,
                "Instrument transposition metadata is not applied by the canonical importer yet.",
                measureNumber,
                partId));
        }
    }

    private static void AnalyzeTuplets(
        XElement measure,
        string? partId,
        string? measureNumber,
        List<MusicXmlDiagnostic> diagnostics)
    {
        foreach (var timeModification in measure.Descendants().Where(element => element.Name.LocalName == "time-modification"))
        {
            var actualNotes = Child(timeModification, "actual-notes")?.Value;
            var normalNotes = Child(timeModification, "normal-notes")?.Value;
            if (!IsPositiveInteger(actualNotes) || !IsPositiveInteger(normalNotes))
            {
                diagnostics.Add(new MusicXmlDiagnostic(
                    "MXML103",
                    MusicXmlDiagnosticSeverity.Error,
                    "Tuplet time-modification must contain positive integer actual-notes and normal-notes values.",
                    measureNumber,
                    partId));
            }
        }

        foreach (var tuplet in measure.Descendants().Where(element => element.Name.LocalName == "tuplet"))
        {
            var type = tuplet.Attribute("type")?.Value;
            if (!string.Equals(type, "start", StringComparison.OrdinalIgnoreCase)
                && !string.Equals(type, "stop", StringComparison.OrdinalIgnoreCase))
            {
                diagnostics.Add(new MusicXmlDiagnostic(
                    "MXML104",
                    MusicXmlDiagnosticSeverity.Error,
                    "Tuplet notation type must be 'start' or 'stop'.",
                    measureNumber,
                    partId));
            }
        }
    }

    private static bool IsPositiveInteger(string? value)
        => int.TryParse(value, out var parsed) && parsed > 0;

    private static XElement? Child(XElement? parent, string localName)
        => parent?.Elements().FirstOrDefault(element => element.Name.LocalName == localName);

    private static void AddUnsupported(
        XElement measure,
        string localName,
        string code,
        string message,
        string? partId,
        string? measureNumber,
        List<MusicXmlDiagnostic> diagnostics)
    {
        if (!measure.Descendants().Any(element => element.Name.LocalName == localName))
        {
            return;
        }

        diagnostics.Add(new MusicXmlDiagnostic(code, MusicXmlDiagnosticSeverity.Error, message, measureNumber, partId));
    }

    private static string BuildLocation(MusicXmlDiagnostic diagnostic)
    {
        var parts = new List<string>();
        if (!string.IsNullOrWhiteSpace(diagnostic.Part))
        {
            parts.Add($"part {diagnostic.Part}");
        }
        if (!string.IsNullOrWhiteSpace(diagnostic.Measure))
        {
            parts.Add($"measure {diagnostic.Measure}");
        }

        return parts.Count == 0 ? string.Empty : $" ({string.Join(", ", parts)}).";
    }
}
