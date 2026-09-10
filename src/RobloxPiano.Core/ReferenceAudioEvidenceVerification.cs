using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Core;

/// <summary>
/// Verifies the normalized feature identity carried by a reference-audio analysis record.
/// ContentSha256 identifies original WAV bytes and therefore can only be re-derived while bytes are present;
/// FeatureSha256 is fully reproducible from the normalized analysis record and is verified here.
/// </summary>
public static class ReferenceAudioEvidenceVerification
{
    public static bool VerifyFeatures(ReferenceAudioAnalysis analysis)
    {
        ArgumentNullException.ThrowIfNull(analysis);
        if (analysis.SchemaVersion != ReferenceAudioAnalysis.CurrentSchemaVersion
            || analysis.SampleRate is < 8000 or > 192000
            || analysis.ChannelCount is < 1 or > 8
            || analysis.BitsPerSample != 16
            || analysis.Duration <= TimeSpan.Zero
            || !double.IsFinite(analysis.RmsLevel) || analysis.RmsLevel < 0d || analysis.RmsLevel > 1d
            || !double.IsFinite(analysis.PeakLevel) || analysis.PeakLevel < 0d || analysis.PeakLevel > 1d
            || !double.IsFinite(analysis.EstimatedTempoBpm) || analysis.EstimatedTempoBpm < 0d
            || !IsSha256(analysis.ContentSha256)
            || !IsSha256(analysis.FeatureSha256)
            || analysis.Onsets.Any(onset => onset < TimeSpan.Zero || onset > analysis.Duration)
            || !analysis.Onsets.SequenceEqual(analysis.Onsets.OrderBy(onset => onset)))
        {
            return false;
        }

        var expected = ComputeFeatureSha(analysis);
        return string.Equals(expected, analysis.FeatureSha256, StringComparison.OrdinalIgnoreCase);
    }

    private static string ComputeFeatureSha(ReferenceAudioAnalysis analysis)
    {
        var builder = new StringBuilder();
        builder.Append(ReferenceAudioAnalysis.CurrentSchemaVersion).Append('|')
            .Append(analysis.SampleRate).Append('|')
            .Append(analysis.ChannelCount).Append('|')
            .Append(analysis.BitsPerSample).Append('|')
            .Append(analysis.Duration.Ticks).Append('|')
            .Append(analysis.RmsLevel.ToString("R", System.Globalization.CultureInfo.InvariantCulture)).Append('|')
            .Append(analysis.PeakLevel.ToString("R", System.Globalization.CultureInfo.InvariantCulture)).Append('|')
            .Append(analysis.EstimatedTempoBpm.ToString("R", System.Globalization.CultureInfo.InvariantCulture));
        foreach (var onset in analysis.Onsets)
        {
            builder.Append('|').Append(onset.Ticks);
        }

        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(builder.ToString()))).ToLowerInvariant();
    }

    private static bool IsSha256(string value)
        => value.Length == 64 && value.All(character =>
            character is >= '0' and <= '9'
            or >= 'a' and <= 'f'
            or >= 'A' and <= 'F');
}
