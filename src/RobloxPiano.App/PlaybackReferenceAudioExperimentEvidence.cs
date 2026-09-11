using System.Globalization;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal sealed record PlaybackReferenceAudioExperimentEvidence(
    int SchemaVersion,
    string ExperimentEvidenceSha256,
    string ReferenceContentSha256,
    string ReferenceFeatureSha256,
    ReferenceAudioTimelineAlignment LegacyAlignment,
    ReferenceAudioTimelineAlignment LegacyX2Alignment,
    double LegacyX2CoverageDelta,
    double LegacyX2P95ResidualDeltaMilliseconds,
    double LegacyX2TempoDistanceDelta,
    string EvidenceSha256)
{
    internal const int CurrentSchemaVersion = 1;
}

/// <summary>
/// Binds deterministic reference-audio alignment evidence to one already-verified Legacy A/B experiment.
/// This is diagnostics evidence only. It never selects a playback engine, mutates transport state,
/// authorizes Roblox input, dispatches keys, or promotes Legacy x2.
/// </summary>
internal static class PlaybackReferenceAudioExperimentEvidenceStore
{
    internal const string ExportSuffix = ".legacy-ab-reference.json";

    private static readonly JsonSerializerOptions JsonOptions = new()
    {
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
        WriteIndented = true
    };

    internal static PlaybackReferenceAudioExperimentEvidence Create(
        PlaybackBaselineExperimentManifest experiment,
        ReferenceAudioAnalysis reference,
        PerformanceTrack canonicalTrack)
    {
        ArgumentNullException.ThrowIfNull(experiment);
        ArgumentNullException.ThrowIfNull(reference);
        ArgumentNullException.ThrowIfNull(canonicalTrack);

        if (!PlaybackBaselineExperimentManifestStore.Verify(experiment, out var experimentError))
        {
            throw new InvalidDataException($"Legacy A/B experiment manifest must verify before reference evidence can be created. {experimentError}");
        }

        if (!ReferenceAudioEvidenceVerification.VerifyFeatures(reference))
        {
            throw new InvalidDataException("Reference-audio normalized feature evidence must verify before experiment evidence can be created.");
        }

        var canonicalSha = PerformanceTrackFingerprint.ComputeSha256(canonicalTrack);
        if (!string.Equals(canonicalSha, experiment.CanonicalSourceFingerprint, StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidDataException("Reference-audio evidence track does not match the completed Legacy A/B experiment canonical fingerprint.");
        }

        var legacy = ReferenceAudioTimelineAligner.Align(reference, canonicalTrack, 1d);
        var legacyX2 = ReferenceAudioTimelineAligner.Align(reference, canonicalTrack, 2d);
        var unsigned = new PlaybackReferenceAudioExperimentEvidence(
            PlaybackReferenceAudioExperimentEvidence.CurrentSchemaVersion,
            experiment.EvidenceSha256.ToLowerInvariant(),
            reference.ContentSha256.ToLowerInvariant(),
            reference.FeatureSha256.ToLowerInvariant(),
            legacy,
            legacyX2,
            legacyX2.MatchCoverage - legacy.MatchCoverage,
            legacyX2.P95AbsoluteErrorMilliseconds - legacy.P95AbsoluteErrorMilliseconds,
            Math.Abs(legacyX2.TempoRatio - 1d) - Math.Abs(legacy.TempoRatio - 1d),
            string.Empty);

        return unsigned with { EvidenceSha256 = ComputeEvidenceSha256(unsigned) };
    }

    internal static void WriteVerifiedAtomic(
        string path,
        PlaybackReferenceAudioExperimentEvidence evidence)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        ArgumentNullException.ThrowIfNull(evidence);

        if (!Verify(evidence, out var error))
        {
            throw new InvalidDataException($"Reference-audio experiment evidence failed verification before export. {error}");
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
                JsonSerializer.Serialize(evidence, JsonOptions),
                new UTF8Encoding(encoderShouldEmitUTF8Identifier: false));

            var readBack = ReadAndVerify(temporaryPath);
            if (!string.Equals(readBack.EvidenceSha256, evidence.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException("Reference-audio experiment evidence changed during atomic export verification.");
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

    internal static PlaybackReferenceAudioExperimentEvidence ReadAndVerify(string path)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        var evidence = JsonSerializer.Deserialize<PlaybackReferenceAudioExperimentEvidence>(
            File.ReadAllText(path),
            JsonOptions)
            ?? throw new InvalidDataException("Reference-audio experiment evidence is empty.");

        if (!Verify(evidence, out var error))
        {
            throw new InvalidDataException($"Reference-audio experiment evidence is invalid. {error}");
        }

        return evidence;
    }

    internal static bool Verify(PlaybackReferenceAudioExperimentEvidence evidence, out string? error)
    {
        ArgumentNullException.ThrowIfNull(evidence);
        error = null;

        if (evidence.SchemaVersion != PlaybackReferenceAudioExperimentEvidence.CurrentSchemaVersion
            || !IsSha256(evidence.ExperimentEvidenceSha256)
            || !IsSha256(evidence.ReferenceContentSha256)
            || !IsSha256(evidence.ReferenceFeatureSha256)
            || !IsSha256(evidence.EvidenceSha256)
            || !ReferenceAudioTimelineAligner.Verify(evidence.LegacyAlignment)
            || !ReferenceAudioTimelineAligner.Verify(evidence.LegacyX2Alignment))
        {
            error = "Reference-audio experiment evidence identity or nested alignment evidence is malformed.";
            return false;
        }

        if (Math.Abs(evidence.LegacyAlignment.PlaybackSpeed - 1d) > 1e-12
            || Math.Abs(evidence.LegacyX2Alignment.PlaybackSpeed - 2d) > 1e-12
            || !string.Equals(evidence.LegacyAlignment.ReferenceContentSha256, evidence.ReferenceContentSha256, StringComparison.OrdinalIgnoreCase)
            || !string.Equals(evidence.LegacyX2Alignment.ReferenceContentSha256, evidence.ReferenceContentSha256, StringComparison.OrdinalIgnoreCase)
            || !string.Equals(evidence.LegacyAlignment.ReferenceFeatureSha256, evidence.ReferenceFeatureSha256, StringComparison.OrdinalIgnoreCase)
            || !string.Equals(evidence.LegacyX2Alignment.ReferenceFeatureSha256, evidence.ReferenceFeatureSha256, StringComparison.OrdinalIgnoreCase)
            || !string.Equals(evidence.LegacyAlignment.CanonicalTrackSha256, evidence.LegacyX2Alignment.CanonicalTrackSha256, StringComparison.OrdinalIgnoreCase))
        {
            error = "Reference-audio experiment evidence does not bind the same reference/canonical track to protected 1x and 2x baselines.";
            return false;
        }

        var expectedCoverageDelta = evidence.LegacyX2Alignment.MatchCoverage - evidence.LegacyAlignment.MatchCoverage;
        var expectedP95Delta = evidence.LegacyX2Alignment.P95AbsoluteErrorMilliseconds - evidence.LegacyAlignment.P95AbsoluteErrorMilliseconds;
        var expectedTempoDistanceDelta = Math.Abs(evidence.LegacyX2Alignment.TempoRatio - 1d) - Math.Abs(evidence.LegacyAlignment.TempoRatio - 1d);
        if (!NearlyEqual(evidence.LegacyX2CoverageDelta, expectedCoverageDelta)
            || !NearlyEqual(evidence.LegacyX2P95ResidualDeltaMilliseconds, expectedP95Delta)
            || !NearlyEqual(evidence.LegacyX2TempoDistanceDelta, expectedTempoDistanceDelta))
        {
            error = "Reference-audio experiment comparison deltas are inconsistent with nested alignment evidence.";
            return false;
        }

        var expectedHash = ComputeEvidenceSha256(evidence with { EvidenceSha256 = string.Empty });
        if (!string.Equals(expectedHash, evidence.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
        {
            error = "Reference-audio experiment evidence SHA-256 does not match its contents.";
            return false;
        }

        return true;
    }

    private static string ComputeEvidenceSha256(PlaybackReferenceAudioExperimentEvidence evidence)
    {
        var canonical = string.Join("\n",
            "legacy-ab-reference-audio-v1",
            evidence.SchemaVersion.ToString(CultureInfo.InvariantCulture),
            evidence.ExperimentEvidenceSha256.ToLowerInvariant(),
            evidence.ReferenceContentSha256.ToLowerInvariant(),
            evidence.ReferenceFeatureSha256.ToLowerInvariant(),
            evidence.LegacyAlignment.EvidenceSha256.ToLowerInvariant(),
            evidence.LegacyX2Alignment.EvidenceSha256.ToLowerInvariant(),
            evidence.LegacyX2CoverageDelta.ToString("R", CultureInfo.InvariantCulture),
            evidence.LegacyX2P95ResidualDeltaMilliseconds.ToString("R", CultureInfo.InvariantCulture),
            evidence.LegacyX2TempoDistanceDelta.ToString("R", CultureInfo.InvariantCulture));
        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(canonical))).ToLowerInvariant();
    }

    private static bool NearlyEqual(double left, double right)
        => double.IsFinite(left) && double.IsFinite(right) && Math.Abs(left - right) <= 1e-12;

    private static bool IsSha256(string value)
        => value.Length == 64 && value.All(character =>
            character is >= '0' and <= '9'
            or >= 'a' and <= 'f'
            or >= 'A' and <= 'F');
}
