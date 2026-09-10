using System.Runtime.CompilerServices;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal static class ImmutableSessionIdentityRegression
{
    [ModuleInitializer]
    internal static void VerifyDiagnosticsPreferLiveTransportIdentity()
    {
        const string immutableFingerprint = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        var quality = new PlaybackTransportQualityReport(
            PlaybackTransportQualityReport.CurrentSchemaVersion,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0d,
            0,
            0d,
            0d,
            0d,
            0d,
            0d,
            0d,
            Array.Empty<PlaybackTransportSegmentQuality>(),
            immutableFingerprint);
        var state = new ClientState(
            Path.Combine(Path.GetTempPath(), Guid.NewGuid().ToString("N"), "source.mid"),
            1d,
            0);
        var now = DateTimeOffset.UtcNow;
        var record = PlaybackSessionDiagnostics.CreateRecord(
            new PlaybackSessionResult(PlaybackSessionResultKind.Completed, TimeSpan.Zero),
            state,
            123,
            456L,
            now,
            now,
            "immutable-context-regression",
            quality);

        if (!string.Equals(record.CanonicalSourceFingerprint, immutableFingerprint, StringComparison.Ordinal))
        {
            throw new InvalidOperationException(
                $"Diagnostics ignored live transport identity. actual={record.CanonicalSourceFingerprint ?? "<null>"}.");
        }
    }
}
