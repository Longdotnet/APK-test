using System.Runtime.CompilerServices;
using System.Security.Cryptography;
using System.Text;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class PlaybackBaselineExperimentArchiveRegression
{
    [ModuleInitializer]
    internal static void VerifyDurableArchiveContract()
    {
        var directory = Path.Combine(Path.GetTempPath(), "roblox-piano-archive-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(directory);
        try
        {
            var first = CreateManifest(
                "55555555555555555555555555555555",
                DateTimeOffset.UnixEpoch.AddMinutes(1),
                "1111111111111111111111111111111111111111111111111111111111111111");
            var second = CreateManifest(
                "66666666666666666666666666666666",
                DateTimeOffset.UnixEpoch.AddMinutes(2),
                "2222222222222222222222222222222222222222222222222222222222222222");

            var firstPath = PlaybackBaselineExperimentArchive.PersistVerified(directory, first);
            var duplicatePath = PlaybackBaselineExperimentArchive.PersistVerified(directory, first);
            True(firstPath == duplicatePath, "re-archiving identical campaign evidence must be idempotent");
            True(Directory.GetFiles(directory, "*.legacy-ab.json").Length == 1, "idempotent archive must not create duplicate files");

            _ = PlaybackBaselineExperimentArchive.PersistVerified(directory, second);
            var archived = PlaybackBaselineExperimentArchive.ReadVerified(directory);
            True(archived.Count == 2, "two verified completed experiments must remain independently readable");
            True(archived[0].CampaignId == second.CampaignId, "archive must return newest completed experiment first");
            True(archived[1].CampaignId == first.CampaignId, "older completed experiment must remain durable after a newer campaign");

            File.WriteAllText(Path.Combine(directory, "corrupt.legacy-ab.json"), "{not-json");
            archived = PlaybackBaselineExperimentArchive.ReadVerified(directory);
            True(archived.Count == 2, "corrupt archive entries must fail closed without hiding valid experiments");

            var conflict = first with { RuntimeVerdict = PlaybackLegacyBaselineComparisonVerdict.LegacyX2Improved.ToString() };
            conflict = conflict with { EvidenceSha256 = EvidenceHash(conflict with { EvidenceSha256 = string.Empty }) };
            Throws<InvalidDataException>(
                () => PlaybackBaselineExperimentArchive.PersistVerified(directory, conflict),
                "same campaign/archive identity must never overwrite different verified evidence");

            var exportPath = Path.Combine(directory, "selected-export.legacy-ab.json");
            PlaybackBaselineExperimentArchive.ExportVerified(second, exportPath);
            var exported = PlaybackBaselineExperimentManifestStore.ReadAndVerify(exportPath);
            True(exported.CampaignId == second.CampaignId, "selected archive export must preserve exact campaign identity");
            True(exported.EvidenceSha256 == second.EvidenceSha256, "selected archive export must preserve exact immutable evidence hash");

            var tampered = second with { RuntimeVerdict = "tampered" };
            Throws<InvalidDataException>(
                () => PlaybackBaselineExperimentArchive.ExportVerified(tampered, Path.Combine(directory, "tampered-export.legacy-ab.json")),
                "archive export must reject a manifest whose immutable evidence no longer verifies");

            Console.WriteLine("PASS  durable Legacy A/B experiment archive (7 cases)");
        }
        finally
        {
            try { Directory.Delete(directory, recursive: true); } catch { }
        }
    }

    private static PlaybackBaselineExperimentManifest CreateManifest(
        string campaignId,
        DateTimeOffset completedAtUtc,
        string fingerprint)
    {
        var unsigned = new PlaybackBaselineExperimentManifest(
            PlaybackBaselineExperimentManifestStore.SchemaVersion,
            campaignId,
            completedAtUtc.AddMinutes(-1),
            completedAtUtc,
            fingerprint,
            "TXT",
            0,
            PlaybackRuntimeIdentity.Engine,
            PlaybackRuntimeIdentity.InputProfile,
            $"baseline-{campaignId}-11111111111111111111111111111111",
            $"baseline-{campaignId}-22222222222222222222222222222222",
            PlaybackLegacyBaselineComparisonVerdict.StableHealthy.ToString(),
            0.1d,
            0.05d,
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
            string.Empty);
        return unsigned with { EvidenceSha256 = EvidenceHash(unsigned) };
    }

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
        if (!condition) throw new InvalidOperationException(message);
    }

    private static void Throws<T>(Action action, string message) where T : Exception
    {
        try { action(); }
        catch (T) { return; }
        throw new InvalidOperationException(message);
    }
}
