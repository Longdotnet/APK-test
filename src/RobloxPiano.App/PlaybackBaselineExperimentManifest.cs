using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal sealed record PlaybackBaselineExperimentManifest(
    string SchemaVersion,
    string CampaignId,
    DateTimeOffset CampaignCreatedAtUtc,
    DateTimeOffset CompletedAtUtc,
    string CanonicalSourceFingerprint,
    string SourceType,
    int InputLatencyMs,
    string PlaybackEngine,
    string InputProfile,
    string LegacySessionId,
    string LegacyX2SessionId,
    string RuntimeVerdict,
    double? LegacyX2P95TimingDeltaMilliseconds,
    double? LegacyX2MaxInputCallDeltaMilliseconds,
    string TransportEquivalenceSha256,
    string EvidenceSha256);

/// <summary>
/// Produces a privacy-safe immutable manifest for a completed explicit Legacy A/B campaign.
/// The manifest is diagnostics evidence only: it never owns playback state, never changes
/// transport controls, and never promotes Legacy x2. Verification recomputes both the
/// normalized transport proof and the manifest evidence hash so accidental/manual edits fail closed.
/// </summary>
internal static class PlaybackBaselineExperimentManifestStore
{
    internal const string SchemaVersion = "1";
    internal const string ExportSuffix = ".legacy-ab.json";

    private static readonly JsonSerializerOptions JsonOptions = new()
    {
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
        WriteIndented = true
    };

    internal static PlaybackBaselineExperimentManifest? TryCreateCompleted(
        string diagnosticsDirectory,
        DateTimeOffset nowUtc)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(diagnosticsDirectory);

        var campaign = PlaybackBaselineCampaignStore.LoadActive(nowUtc);
        if (campaign is null)
        {
            return null;
        }

        var records = PlaybackSessionDiagnostics.ReadRecentRecords(
            diagnosticsDirectory,
            PlaybackSessionDiagnostics.MaxSupportSessions);
        var support = PlaybackSessionDiagnostics.CreateSupportDocument(records, nowUtc);
        var progress = PlaybackBaselineCampaignStore.EvaluateProgress(campaign, support.Sessions, nowUtc);
        if (progress.State != PlaybackBaselineCampaignProgressState.Completed
            || string.IsNullOrWhiteSpace(progress.LegacySessionId)
            || string.IsNullOrWhiteSpace(progress.LegacyX2SessionId))
        {
            return null;
        }

        var legacy = support.Sessions.SingleOrDefault(session =>
            string.Equals(session.SessionId, progress.LegacySessionId, StringComparison.Ordinal));
        var legacyX2 = support.Sessions.SingleOrDefault(session =>
            string.Equals(session.SessionId, progress.LegacyX2SessionId, StringComparison.Ordinal));
        if (legacy is null || legacyX2 is null)
        {
            return null;
        }

        if (!PlaybackBaselineCampaignStore.MatchesCampaignIdentity(campaign, legacy)
            || !PlaybackBaselineCampaignStore.MatchesCampaignIdentity(campaign, legacyX2)
            || !PlaybackLegacyBaselineComparisonPolicy.AreControlledCounterparts(legacyX2, legacy))
        {
            return null;
        }

        var assessment = PlaybackLegacyBaselineComparisonPolicy.CompareWithMostRecentCounterpart(
            legacyX2,
            support.Sessions);
        if (!assessment.HasCounterpart
            || !string.Equals(assessment.CounterpartSessionId, legacy.SessionId, StringComparison.Ordinal)
            || assessment.Verdict == PlaybackLegacyBaselineComparisonVerdict.NotComparable)
        {
            return null;
        }

        var transportProof = ComputeTransportEquivalenceSha256(legacy, legacyX2);
        var completedAtUtc = legacyX2.EndedAtUtc.ToUniversalTime();
        var unsigned = new PlaybackBaselineExperimentManifest(
            SchemaVersion,
            campaign.CampaignId,
            campaign.CreatedAtUtc.ToUniversalTime(),
            completedAtUtc,
            campaign.CanonicalSourceFingerprint.ToLowerInvariant(),
            campaign.SourceType.ToUpperInvariant(),
            campaign.InputLatencyMs,
            campaign.PlaybackEngine,
            campaign.InputProfile,
            legacy.SessionId,
            legacyX2.SessionId,
            assessment.Verdict.ToString(),
            assessment.LegacyX2P95TimingDeltaMilliseconds,
            assessment.LegacyX2MaxInputCallDeltaMilliseconds,
            transportProof,
            string.Empty);

        return unsigned with { EvidenceSha256 = ComputeEvidenceSha256(unsigned) };
    }

    internal static string ExportCompletedIfAvailable(
        string diagnosticsDirectory,
        string destinationBundlePath,
        DateTimeOffset nowUtc)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(diagnosticsDirectory);
        ArgumentException.ThrowIfNullOrWhiteSpace(destinationBundlePath);

        var destinationPath = destinationBundlePath + ExportSuffix;
        var manifest = TryCreateCompleted(diagnosticsDirectory, nowUtc);
        if (manifest is null)
        {
            TryDelete(destinationPath);
            return string.Empty;
        }

        WriteVerifiedAtomic(destinationPath, manifest);
        return destinationPath;
    }

    internal static void WriteVerifiedAtomic(string path, PlaybackBaselineExperimentManifest manifest)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        ArgumentNullException.ThrowIfNull(manifest);

        if (!Verify(manifest, out var error))
        {
            throw new InvalidDataException($"Legacy A/B experiment manifest failed verification before export. {error}");
        }

        var directory = Path.GetDirectoryName(path);
        if (!string.IsNullOrWhiteSpace(directory))
        {
            Directory.CreateDirectory(directory);
        }

        var temporaryPath = path + ".tmp-" + Guid.NewGuid().ToString("N");
        try
        {
            File.WriteAllText(
                temporaryPath,
                JsonSerializer.Serialize(manifest, JsonOptions),
                new UTF8Encoding(encoderShouldEmitUTF8Identifier: false));

            var readBack = ReadAndVerify(temporaryPath);
            if (!string.Equals(readBack.EvidenceSha256, manifest.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException("Legacy A/B experiment manifest changed during atomic export verification.");
            }

            File.Move(temporaryPath, path, overwrite: true);
        }
        finally
        {
            if (File.Exists(temporaryPath))
            {
                File.Delete(temporaryPath);
            }
        }
    }

    internal static PlaybackBaselineExperimentManifest ReadAndVerify(string path)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        var manifest = JsonSerializer.Deserialize<PlaybackBaselineExperimentManifest>(
            File.ReadAllText(path),
            JsonOptions)
            ?? throw new InvalidDataException("Legacy A/B experiment manifest is empty.");

        if (!Verify(manifest, out var error))
        {
            throw new InvalidDataException($"Legacy A/B experiment manifest is invalid. {error}");
        }

        return manifest;
    }

    internal static bool Verify(PlaybackBaselineExperimentManifest manifest, out string? error)
    {
        ArgumentNullException.ThrowIfNull(manifest);
        error = null;

        if (!string.Equals(manifest.SchemaVersion, SchemaVersion, StringComparison.Ordinal))
        {
            error = "Unsupported experiment manifest schema version.";
            return false;
        }

        if (!Guid.TryParseExact(manifest.CampaignId, "N", out _)
            || manifest.CampaignCreatedAtUtc > manifest.CompletedAtUtc
            || manifest.CanonicalSourceFingerprint.Length != 64
            || !IsSha256(manifest.CanonicalSourceFingerprint)
            || (manifest.SourceType != "TXT" && manifest.SourceType != "VPS")
            || string.IsNullOrWhiteSpace(manifest.PlaybackEngine)
            || string.IsNullOrWhiteSpace(manifest.InputProfile)
            || string.IsNullOrWhiteSpace(manifest.LegacySessionId)
            || string.IsNullOrWhiteSpace(manifest.LegacyX2SessionId)
            || string.Equals(manifest.LegacySessionId, manifest.LegacyX2SessionId, StringComparison.Ordinal)
            || !string.Equals(
                PlaybackBaselineCampaignStore.TryGetCampaignId(manifest.LegacySessionId),
                manifest.CampaignId,
                StringComparison.Ordinal)
            || !string.Equals(
                PlaybackBaselineCampaignStore.TryGetCampaignId(manifest.LegacyX2SessionId),
                manifest.CampaignId,
                StringComparison.Ordinal)
            || !Enum.TryParse<PlaybackLegacyBaselineComparisonVerdict>(manifest.RuntimeVerdict, out var verdict)
            || verdict == PlaybackLegacyBaselineComparisonVerdict.NotComparable
            || !IsSha256(manifest.TransportEquivalenceSha256)
            || !IsSha256(manifest.EvidenceSha256))
        {
            error = "Experiment manifest identity/provenance fields are malformed or incomplete.";
            return false;
        }

        var expectedEvidenceHash = ComputeEvidenceSha256(manifest with { EvidenceSha256 = string.Empty });
        if (!string.Equals(expectedEvidenceHash, manifest.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
        {
            error = "Experiment evidence SHA-256 does not match manifest contents.";
            return false;
        }

        return true;
    }

    internal static string ComputeTransportEquivalenceSha256(
        PlaybackSupportSession legacy,
        PlaybackSupportSession legacyX2)
    {
        ArgumentNullException.ThrowIfNull(legacy);
        ArgumentNullException.ThrowIfNull(legacyX2);

        if (!PlaybackLegacyBaselineComparisonPolicy.AreControlledCounterparts(legacyX2, legacy))
        {
            throw new InvalidDataException("Cannot create a transport-equivalence proof for uncontrolled Legacy A/B sessions.");
        }

        var legacyEvents = legacy.Quality?.TransportControlEvents
            ?? Array.Empty<PlaybackTransportControlEvent>();
        var x2Events = legacyX2.Quality?.TransportControlEvents
            ?? Array.Empty<PlaybackTransportControlEvent>();

        var builder = new StringBuilder();
        builder.Append("transport-proof-v1\n");
        for (var index = 0; index < legacyEvents.Count; index++)
        {
            var left = legacyEvents[index];
            var right = x2Events[index];
            builder.Append(index).Append('|')
                .Append((int)left.Kind).Append('|')
                .Append(left.PositionSeconds.ToString("R", System.Globalization.CultureInfo.InvariantCulture)).Append('|')
                .Append(left.Speed?.ToString("R", System.Globalization.CultureInfo.InvariantCulture) ?? "-").Append('|')
                .Append((int)right.Kind).Append('|')
                .Append(right.PositionSeconds.ToString("R", System.Globalization.CultureInfo.InvariantCulture)).Append('|')
                .Append(right.Speed?.ToString("R", System.Globalization.CultureInfo.InvariantCulture) ?? "-")
                .Append('\n');
        }

        return Sha256(builder.ToString());
    }

    private static string ComputeEvidenceSha256(PlaybackBaselineExperimentManifest manifest)
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
        return Sha256(canonical);
    }

    private static string Sha256(string value)
        => Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(value))).ToLowerInvariant();

    private static bool IsSha256(string value)
        => value.Length == 64 && value.All(character =>
            character is >= '0' and <= '9'
            or >= 'a' and <= 'f'
            or >= 'A' and <= 'F');

    private static void TryDelete(string path)
    {
        try
        {
            if (File.Exists(path))
            {
                File.Delete(path);
            }
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
        {
            ClientDiagnostics.Log($"Stale Legacy A/B experiment sidecar could not be removed: {exception.Message}");
        }
    }
}
