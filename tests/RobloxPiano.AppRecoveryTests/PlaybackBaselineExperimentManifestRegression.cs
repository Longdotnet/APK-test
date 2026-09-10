using System.Runtime.CompilerServices;
using System.Security.Cryptography;
using System.Text;
using RobloxPiano.App;
using RobloxPiano.Core;

namespace RobloxPiano.AppRecoveryTests;

internal static class PlaybackBaselineExperimentManifestRegression
{
    private const string CampaignId = "33333333333333333333333333333333";
    private const string Fingerprint = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    [ModuleInitializer]
    internal static void VerifyCompletedExperimentManifestContract()
    {
        var legacy = Session(
            $"baseline-{CampaignId}-11111111111111111111111111111111",
            1d,
            [
                Start(1d),
                new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SpeedChanged, 1.5d, 1.2d),
                new PlaybackTransportControlEvent(2, PlaybackTransportControlKind.SeekRequested, 2.5d, null)
            ]);
        var x2 = Session(
            $"baseline-{CampaignId}-22222222222222222222222222222222",
            2d,
            [
                Start(2d),
                new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SpeedChanged, 1.5d, 2.4d),
                new PlaybackTransportControlEvent(2, PlaybackTransportControlKind.SeekRequested, 2.5d, null)
            ]);

        var proof = PlaybackBaselineExperimentManifestStore.ComputeTransportEquivalenceSha256(legacy, x2);
        True(proof.Length == 64, "transport proof must be SHA-256");

        var unsigned = new PlaybackBaselineExperimentManifest(
            PlaybackBaselineExperimentManifestStore.SchemaVersion,
            CampaignId,
            DateTimeOffset.UnixEpoch,
            DateTimeOffset.UnixEpoch.AddSeconds(20),
            Fingerprint,
            "TXT",
            0,
            PlaybackRuntimeIdentity.Engine,
            PlaybackRuntimeIdentity.InputProfile,
            legacy.SessionId,
            x2.SessionId,
            PlaybackLegacyBaselineComparisonVerdict.StableHealthy.ToString(),
            0.5d,
            0.1d,
            proof,
            string.Empty);
        var manifest = unsigned with { EvidenceSha256 = EvidenceHash(unsigned) };

        True(PlaybackBaselineExperimentManifestStore.Verify(manifest, out var validError), $"valid manifest must verify: {validError}");

        var tampered = manifest with { RuntimeVerdict = PlaybackLegacyBaselineComparisonVerdict.LegacyX2Improved.ToString() };
        True(!PlaybackBaselineExperimentManifestStore.Verify(tampered, out var tamperError), "tampered verdict must fail evidence hash verification");
        Contains(tamperError, "SHA-256", "tamper failure must identify evidence hash");

        var wrongCampaign = manifest with
        {
            CampaignId = "44444444444444444444444444444444",
            EvidenceSha256 = EvidenceHash(unsigned with { CampaignId = "44444444444444444444444444444444" })
        };
        True(!PlaybackBaselineExperimentManifestStore.Verify(wrongCampaign, out _), "session IDs from another campaign must fail closed even with a recomputed content hash");

        var changedTransport = Session(
            $"baseline-{CampaignId}-55555555555555555555555555555555",
            2d,
            [
                Start(2d),
                new PlaybackTransportControlEvent(1, PlaybackTransportControlKind.SeekRequested, 3.5d, null)
            ]);
        Throws<InvalidDataException>(
            () => PlaybackBaselineExperimentManifestStore.ComputeTransportEquivalenceSha256(legacy, changedTransport),
            "uncontrolled transport history must never receive an equivalence proof");

        Console.WriteLine("PASS  immutable Legacy A/B experiment manifest verification (4 cases)");
    }

    private static PlaybackSupportSession Session(
        string sessionId,
        double speed,
        IReadOnlyList<PlaybackTransportControlEvent> controls)
    {
        var started = DateTimeOffset.UnixEpoch.AddSeconds(speed * 10d);
        var quality = new PlaybackSessionQualityDiagnostic(
            2,
            1,
            controls.Count(control => control.Kind == PlaybackTransportControlKind.SeekRequested),
            4,
            0,
            0,
            0,
            0,
            0d,
            1,
            0.5d,
            speed == 1d ? 2d : 2.5d,
            3d,
            0.1d,
            speed == 1d ? 0.5d : 0.6d,
            controls);

        return new PlaybackSupportSession(
            sessionId,
            started,
            started.AddSeconds(5),
            PlaybackSessionResultKind.Completed.ToString(),
            5d,
            null,
            "song.txt",
            "TXT",
            speed,
            0,
            1234,
            5678,
            null,
            null,
            quality,
            Fingerprint,
            PlaybackRuntimeIdentity.Engine,
            PlaybackRuntimeIdentity.InputProfile);
    }

    private static PlaybackTransportControlEvent Start(double speed)
        => new(0, PlaybackTransportControlKind.SessionStarted, 0d, speed);

    private static string EvidenceHash(PlaybackBaselineExperimentManifest manifest)
    {
        var canonical = string.Join("\n",
            "legacy-ab-experiment-v1",
            manifest.SchemaVersion,
            manifest.CampaignId,
            manifest.CampaignCreatedAtUtc.ToUniversalTime().ToString("O"),
            manifest.CompletedAtUtc.ToUniversalTime().ToString("O"),
            manifest.CanonicalSourceFingerprint.ToLowerInvariant(),
            manifest.SourceType.ToUpperInvariant(),
            manifest.InputLatencyMs.ToString(System.Globalization.CultureInfo.InvariantCulture),
            manifest.PlaybackEngine,
            manifest.InputProfile,
            manifest.LegacySessionId,
            manifest.LegacyX2SessionId,
            manifest.RuntimeVerdict,
            manifest.LegacyX2P95TimingDeltaMilliseconds?.ToString("R", System.Globalization.CultureInfo.InvariantCulture) ?? "-",
            manifest.LegacyX2MaxInputCallDeltaMilliseconds?.ToString("R", System.Globalization.CultureInfo.InvariantCulture) ?? "-",
            manifest.TransportEquivalenceSha256.ToLowerInvariant());
        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(canonical))).ToLowerInvariant();
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }

    private static void Contains(string? actual, string expected, string message)
    {
        if (actual is null || !actual.Contains(expected, StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidOperationException($"{message}. Expected '{expected}' in '{actual ?? "<null>"}'.");
        }
    }

    private static void Throws<T>(Action action, string message) where T : Exception
    {
        try
        {
            action();
        }
        catch (T)
        {
            return;
        }

        throw new InvalidOperationException(message);
    }
}
