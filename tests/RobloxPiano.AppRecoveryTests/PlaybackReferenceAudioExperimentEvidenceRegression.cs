using System.Buffers.Binary;
using System.Runtime.CompilerServices;
using System.Security.Cryptography;
using System.Text;
using RobloxPiano.App;
using RobloxPiano.Core;

namespace RobloxPiano.AppRecoveryTests;

internal static class PlaybackReferenceAudioExperimentEvidenceRegression
{
    private const string CampaignId = "77777777777777777777777777777777";

    [ModuleInitializer]
    internal static void Run()
    {
        CreatesVerifiedEvidenceForSameReferenceAndCanonicalTrack();
        TamperedComparisonDeltaFailsClosed();
        DifferentCanonicalTrackIsRejected();
        TamperedReferenceFeatureRecordIsRejected();
        Console.WriteLine("PASS  verified reference-audio Legacy A/B experiment evidence (4 cases)");
    }

    private static void CreatesVerifiedEvidenceForSameReferenceAndCanonicalTrack()
    {
        var track = CreatePulseTrack(500);
        var manifest = CreateManifest(track);
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 4, 500));
        var evidence = PlaybackReferenceAudioExperimentEvidenceStore.Create(manifest, reference, track);

        Require(PlaybackReferenceAudioExperimentEvidenceStore.Verify(evidence, out var error), $"valid evidence must verify: {error}");
        Require(evidence.ExperimentEvidenceSha256 == manifest.EvidenceSha256, "completed experiment evidence hash must be embedded");
        Require(evidence.ReferenceContentSha256 == reference.ContentSha256, "exact reference WAV identity must be embedded");
        Require(evidence.LegacyAlignment.PlaybackSpeed == 1d && evidence.LegacyX2Alignment.PlaybackSpeed == 2d,
            "protected Legacy 1x and Legacy x2 speeds must be explicit");
        Require(evidence.LegacyX2TempoDistanceDelta > 0d,
            "a 1x pulse reference should expose x2 as farther from the reference tempo without declaring a winner");
    }

    private static void TamperedComparisonDeltaFailsClosed()
    {
        var track = CreatePulseTrack(500);
        var evidence = PlaybackReferenceAudioExperimentEvidenceStore.Create(
            CreateManifest(track),
            ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 4, 500)),
            track);
        var tampered = evidence with { LegacyX2CoverageDelta = evidence.LegacyX2CoverageDelta + 0.1d };
        Require(!PlaybackReferenceAudioExperimentEvidenceStore.Verify(tampered, out _),
            "derived comparison deltas must not be editable independently of nested evidence");
    }

    private static void DifferentCanonicalTrackIsRejected()
    {
        var manifestTrack = CreatePulseTrack(500);
        var otherTrack = CreatePulseTrack(400);
        Throws<InvalidDataException>(() => PlaybackReferenceAudioExperimentEvidenceStore.Create(
            CreateManifest(manifestTrack),
            ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 4, 500)),
            otherTrack),
            "reference evidence must not be attached to a different canonical performance");
    }

    private static void TamperedReferenceFeatureRecordIsRejected()
    {
        var track = CreatePulseTrack(500);
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 4, 500));
        var tampered = reference with { EstimatedTempoBpm = reference.EstimatedTempoBpm + 1d };
        Throws<InvalidDataException>(() => PlaybackReferenceAudioExperimentEvidenceStore.Create(
            CreateManifest(track), tampered, track),
            "normalized reference features must verify before they can enter experiment evidence");
    }

    private static PlaybackBaselineExperimentManifest CreateManifest(PerformanceTrack track)
    {
        var unsigned = new PlaybackBaselineExperimentManifest(
            PlaybackBaselineExperimentManifestStore.SchemaVersion,
            CampaignId,
            DateTimeOffset.UnixEpoch,
            DateTimeOffset.UnixEpoch.AddSeconds(30),
            PerformanceTrackFingerprint.ComputeSha256(track),
            "TXT",
            0,
            PlaybackRuntimeIdentity.Engine,
            PlaybackRuntimeIdentity.InputProfile,
            $"baseline-{CampaignId}-11111111111111111111111111111111",
            $"baseline-{CampaignId}-22222222222222222222222222222222",
            PlaybackLegacyBaselineComparisonVerdict.StableHealthy.ToString(),
            0d,
            0d,
            new string('a', 64),
            string.Empty);
        return unsigned with { EvidenceSha256 = ManifestEvidenceHash(unsigned) };
    }

    private static PerformanceTrack CreatePulseTrack(int periodMilliseconds)
    {
        var events = Enumerable.Range(1, 7)
            .Select(index => new PerformanceEvent(
                TimeSpan.FromMilliseconds(periodMilliseconds * index),
                TimeSpan.FromMilliseconds(20),
                new[] { 't' }))
            .ToArray();
        return new PerformanceTrack("reference-experiment", 120d, 4, TimeSpan.Zero, events, events[^1].Start + events[^1].Duration);
    }

    private static byte[] CreatePulseWav(int sampleRate, int durationSeconds, int pulsePeriodMilliseconds)
    {
        var sampleCount = sampleRate * durationSeconds;
        var pcmBytes = sampleCount * 2;
        var wav = new byte[44 + pcmBytes];
        "RIFF"u8.CopyTo(wav.AsSpan(0, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(4, 4), (uint)(36 + pcmBytes));
        "WAVE"u8.CopyTo(wav.AsSpan(8, 4));
        "fmt "u8.CopyTo(wav.AsSpan(12, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(16, 4), 16);
        BinaryPrimitives.WriteUInt16LittleEndian(wav.AsSpan(20, 2), 1);
        BinaryPrimitives.WriteUInt16LittleEndian(wav.AsSpan(22, 2), 1);
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(24, 4), (uint)sampleRate);
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(28, 4), (uint)(sampleRate * 2));
        BinaryPrimitives.WriteUInt16LittleEndian(wav.AsSpan(32, 2), 2);
        BinaryPrimitives.WriteUInt16LittleEndian(wav.AsSpan(34, 2), 16);
        "data"u8.CopyTo(wav.AsSpan(36, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(40, 4), (uint)pcmBytes);
        var periodSamples = sampleRate * pulsePeriodMilliseconds / 1000;
        var pulseSamples = sampleRate * 20 / 1000;
        for (var i = 0; i < sampleCount; i++)
        {
            var value = i % periodSamples < pulseSamples ? (short)26214 : (short)0;
            BinaryPrimitives.WriteInt16LittleEndian(wav.AsSpan(44 + i * 2, 2), value);
        }
        return wav;
    }

    private static string ManifestEvidenceHash(PlaybackBaselineExperimentManifest manifest)
    {
        var canonical = string.Join("\n",
            "legacy-ab-experiment-v1", manifest.SchemaVersion, manifest.CampaignId,
            manifest.CampaignCreatedAtUtc.ToUniversalTime().ToString("O"),
            manifest.CompletedAtUtc.ToUniversalTime().ToString("O"),
            manifest.CanonicalSourceFingerprint.ToLowerInvariant(), manifest.SourceType.ToUpperInvariant(),
            manifest.InputLatencyMs.ToString(System.Globalization.CultureInfo.InvariantCulture),
            manifest.PlaybackEngine, manifest.InputProfile, manifest.LegacySessionId, manifest.LegacyX2SessionId,
            manifest.RuntimeVerdict,
            manifest.LegacyX2P95TimingDeltaMilliseconds?.ToString("R", System.Globalization.CultureInfo.InvariantCulture) ?? "-",
            manifest.LegacyX2MaxInputCallDeltaMilliseconds?.ToString("R", System.Globalization.CultureInfo.InvariantCulture) ?? "-",
            manifest.TransportEquivalenceSha256.ToLowerInvariant());
        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(canonical))).ToLowerInvariant();
    }

    private static void Require(bool condition, string message)
    {
        if (!condition) throw new InvalidOperationException($"Reference-audio experiment regression failed: {message}");
    }

    private static void Throws<T>(Action action, string message) where T : Exception
    {
        try { action(); }
        catch (T) { return; }
        throw new InvalidOperationException($"Reference-audio experiment regression failed: {message}");
    }
}
