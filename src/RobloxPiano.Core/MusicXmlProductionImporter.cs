using System.Xml;
using System.Xml.Linq;

namespace RobloxPiano.Core;

/// <summary>
/// Production MusicXML boundary. Supported structural playback controls are normalized into a linear score,
/// then the existing fail-closed conformance gate and canonical importer run on the normalized form.
/// </summary>
public static class MusicXmlProductionImporter
{
    public static PerformanceTrack Import(string xml, MusicXmlImportOptions? options = null)
    {
        ArgumentNullException.ThrowIfNull(xml);

        XDocument document;
        try
        {
            document = XDocument.Parse(xml, LoadOptions.None);
        }
        catch (XmlException exception)
        {
            throw new FormatException("MusicXML is malformed.", exception);
        }

        var expanded = MusicXmlRepeatExpansion.Expand(document);
        var normalized = expanded.ToString(SaveOptions.DisableFormatting);
        MusicXmlConformance.ValidateForProductionImport(normalized);
        return MusicXmlImporter.Import(normalized, options);
    }
}
