using System.Runtime.CompilerServices;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal static class ImmutableSessionIdentityRegression
{
    [ModuleInitializer]
    internal static void VerifyDiagnosticsPreferLiveTransportIdentity()
    {
        const string immutableFingerprint = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        var quality = BuildQuality(immutableFingerprint);
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

    [ModuleInitializer]
    internal static void VerifyStartProvenanceOwnsMutableClientSettings()
    {
        const string fingerprint = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        var startState = new ClientState(
            Path.Combine(Path.GetTempPath(), "session-start.mid"),
            1.15d,
            7);
        var snapshot = new PlaybackSessionProvenanceSnapshot(
            startState,
            321,
            654L,
            "engine-at-session-start",
            "input-profile-at-session-start");
        var now = DateTimeOffset.UtcNow;

        var record = PlaybackSessionProvenance.CreateRecord(
            new PlaybackSessionResult(PlaybackSessionResultKind.Completed, TimeSpan.FromSeconds(1)),
            snapshot,
            now,
            now.AddSeconds(1),
            "start-provenance-regression",
            BuildQuality(fingerprint));

        if (Math.Abs(record.PreferredSpeed - 1.15d) > 0.000001d
            || record.InputLatencyMs != 7
            || record.RobloxProcessId != 321
            || record.RobloxProcessStartTimeUtcTicks != 654L
            || !string.Equals(record.PlaybackEngine, snapshot.PlaybackEngine, StringComparison.Ordinal)
            || !string.Equals(record.InputProfile, snapshot.InputProfile, StringComparison.Ordinal)
            || !string.Equals(record.CanonicalSourceFingerprint, fingerprint, StringComparison.Ordinal))
        {
            throw new InvalidOperationException("Playback diagnostics did not preserve immutable session-start provenance.");
        }
    }

    private static PlaybackTransportQualityReport BuildQuality(string fingerprint)
        => new(
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
            fingerprint);
}
