using System.Globalization;
using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Core;

/// <summary>
/// Produces a privacy-safe identity for the canonical performance model rather than
/// hashing importer-specific source bytes. Equivalent canonical tracks therefore
/// compare across renamed files and harmless source-format differences.
/// </summary>
public static class PerformanceTrackFingerprint
{
    public const int SchemaVersion = 1;

    public static string ComputeSha256(PerformanceTrack track)
    {
        ArgumentNullException.ThrowIfNull(track);

        var builder = new StringBuilder(256 + (track.Events.Count * 48));
        builder.Append("roblox-piano-performance-fingerprint-v")
            .Append(SchemaVersion)
            .Append('\n');
        builder.Append("bpm=")
            .Append(track.Bpm.ToString("R", CultureInfo.InvariantCulture))
            .Append('\n');
        builder.Append("subdivision=")
            .Append(track.Subdivision.ToString(CultureInfo.InvariantCulture))
            .Append('\n');
        builder.Append("startDelayTicks=")
            .Append(track.StartDelay.Ticks.ToString(CultureInfo.InvariantCulture))
            .Append('\n');
        builder.Append("timelineTicks=")
            .Append(track.TimelineDuration.Ticks.ToString(CultureInfo.InvariantCulture))
            .Append('\n');

        foreach (var performanceEvent in track.Events
                     .OrderBy(item => item.Start)
                     .ThenBy(item => item.Duration)
                     .ThenBy(item => NormalizeKeys(item.Keys), StringComparer.Ordinal))
        {
            builder.Append(performanceEvent.Start.Ticks.ToString(CultureInfo.InvariantCulture))
                .Append('|')
                .Append(performanceEvent.Duration.Ticks.ToString(CultureInfo.InvariantCulture))
                .Append('|')
                .Append(NormalizeKeys(performanceEvent.Keys))
                .Append('\n');
        }

        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(builder.ToString())))
            .ToLowerInvariant();
    }

    private static string NormalizeKeys(IReadOnlyList<char> keys)
        => new(keys.OrderBy(key => key).ToArray());
}
