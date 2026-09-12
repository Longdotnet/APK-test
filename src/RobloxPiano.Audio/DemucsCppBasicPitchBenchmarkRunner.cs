using System.Security.Cryptography;
using System.Text;
using System.Text.Json;

namespace RobloxPiano.Audio;

public sealed record BasicPitchBenchmarkModelPin(
    string ModelPath,
    string ModelSha256,
    string UpstreamCommitSha);

public sealed record BasicPitchBenchmarkVerifiedProvenance(
    string UpstreamCommitSha,
    string ModelSha256,
    long ModelBytes);

public sealed record DemucsCppBasicPitchBenchmarkRunResult(
    DemucsCppBenchmarkManifestRunResult Benchmark,
    BasicPitchBenchmarkVerifiedProvenance BasicPitch,
    string EvidencePath,
    string EvidenceSha256Path,
    string EvidenceSha256);

/// <summary>
/// Engineering-only one-command benchmark boundary that pins the exact Spotify Basic Pitch model used
/// for both the direct-mixture baseline and separated-piano candidate. One InferenceSession is reused for
/// the whole paired run. The model is verified before and after measurement so transcriber drift cannot be
/// attached to otherwise-valid demucs.cpp evidence. No model, separator, or media is downloaded here.
/// </summary>
public sealed class DemucsCppBasicPitchBenchmarkRunner
{
    public const string EvidenceSchemaVersion = "roblox-piano.audio.separation-benchmark-evidence.v1";

    private readonly DemucsCppBenchmarkManifestRunner manifestRunner = new();

    public async Task<DemucsCppBasicPitchBenchmarkRunResult> RunNativeAsync(
        string manifestPath,
        string reportPath,
        BasicPitchBenchmarkModelPin basicPitch,
        BasicPitchInferenceOptions? inferenceOptions = null,
        BasicPitchNoteDecoderOptions? decoderOptions = null,
        AudioSourceSeparationAdoptionOptions? adoptionOptions = null,
        AudioTranscriptionEvaluationOptions? evaluationOptions = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(basicPitch);
        cancellationToken.ThrowIfCancellationRequested();

        var before = VerifyBasicPitch(basicPitch, cancellationToken);
        var ingest = new AudioIngestService();
        var decoder = new BasicPitchNoteDecoder();
        using var inference = new BasicPitchInferenceService(Path.GetFullPath(basicPitch.ModelPath), inferenceOptions);

        ValueTask<IReadOnlyList<BasicPitchTranscribedNote>> Transcribe(
            string audioPath,
            CancellationToken token)
        {
            token.ThrowIfCancellationRequested();
            var audio = ingest.DecodeFile(
                audioPath,
                new AudioIngestOptions(
                    TargetSampleRate: BasicPitchInferenceService.RequiredSampleRate,
                    MaxDuration: TimeSpan.FromMinutes(15)),
                token);
            var raw = inference.Infer(audio, token);
            IReadOnlyList<BasicPitchTranscribedNote> notes = decoder.Decode(raw, decoderOptions, token);
            return ValueTask.FromResult(notes);
        }

        var benchmark = await manifestRunner.RunNativeAsync(
            manifestPath,
            reportPath,
            Transcribe,
            Transcribe,
            adoptionOptions,
            evaluationOptions,
            cancellationToken).ConfigureAwait(false);

        cancellationToken.ThrowIfCancellationRequested();
        var after = VerifyBasicPitch(basicPitch, cancellationToken);
        if (!Equals(before, after))
            throw new InvalidDataException("Pinned Basic Pitch model provenance changed during benchmark measurement; evidence is rejected.");

        var evidence = WriteEvidence(benchmark, after);
        return new DemucsCppBasicPitchBenchmarkRunResult(
            benchmark,
            after,
            evidence.Path,
            evidence.Sha256Path,
            evidence.Sha256);
    }

    public static BasicPitchBenchmarkVerifiedProvenance VerifyBasicPitch(
        BasicPitchBenchmarkModelPin pin,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(pin);
        cancellationToken.ThrowIfCancellationRequested();
        if (string.IsNullOrWhiteSpace(pin.ModelPath) || !Path.IsPathFullyQualified(pin.ModelPath))
            throw new ArgumentException("Basic Pitch benchmark model path must be an explicit absolute path.", nameof(pin));
        if (pin.ModelSha256.Length != 64 || pin.ModelSha256.Any(ch => !Uri.IsHexDigit(ch)))
            throw new ArgumentException("Basic Pitch benchmark model SHA-256 must be 64 hexadecimal characters.", nameof(pin));
        if (pin.UpstreamCommitSha.Length != 40 || pin.UpstreamCommitSha.Any(ch => !Uri.IsHexDigit(ch)))
            throw new ArgumentException("Basic Pitch upstream commit must be a full 40-character hexadecimal SHA.", nameof(pin));

        var path = Path.GetFullPath(pin.ModelPath);
        if (!File.Exists(path))
            throw new FileNotFoundException("Pinned Basic Pitch benchmark model does not exist.", path);

        using var stream = new FileStream(path, FileMode.Open, FileAccess.Read, FileShare.Read);
        var digest = Convert.ToHexString(SHA256.HashData(stream)).ToLowerInvariant();
        var expected = pin.ModelSha256.ToLowerInvariant();
        if (!string.Equals(digest, expected, StringComparison.Ordinal))
            throw new InvalidDataException($"Pinned Basic Pitch benchmark model SHA-256 mismatch. Expected {expected}, got {digest}.");

        return new BasicPitchBenchmarkVerifiedProvenance(
            pin.UpstreamCommitSha.ToLowerInvariant(),
            digest,
            stream.Length);
    }

    private static (string Path, string Sha256Path, string Sha256) WriteEvidence(
        DemucsCppBenchmarkManifestRunResult benchmark,
        BasicPitchBenchmarkVerifiedProvenance basicPitch)
    {
        var evidencePath = benchmark.ReportPath + ".evidence.json";
        var payload = new EvidenceDto
        {
            SchemaVersion = EvidenceSchemaVersion,
            BenchmarkReportSha256 = benchmark.Report.ReportSha256,
            SeparationProvenanceSha256 = benchmark.Run.Provenance.IdentitySha256,
            BasicPitchUpstreamCommitSha = basicPitch.UpstreamCommitSha,
            BasicPitchModelSha256 = basicPitch.ModelSha256,
            BasicPitchModelBytes = basicPitch.ModelBytes,
            AdoptionDecision = benchmark.Run.Benchmark.Assessment.Decision.ToString()
        };
        var json = JsonSerializer.Serialize(payload, JsonOptions) + "\n";
        var bytes = Encoding.UTF8.GetBytes(json);
        var sha = Convert.ToHexString(SHA256.HashData(bytes)).ToLowerInvariant();
        var shaPath = evidencePath + ".sha256";
        var jsonTemp = evidencePath + ".tmp";
        var shaTemp = shaPath + ".tmp";
        try
        {
            File.WriteAllBytes(jsonTemp, bytes);
            File.WriteAllText(shaTemp, $"{sha}  {Path.GetFileName(evidencePath)}\n", new UTF8Encoding(false));
            File.Move(jsonTemp, evidencePath, overwrite: true);
            File.Move(shaTemp, shaPath, overwrite: true);
        }
        finally
        {
            TryDelete(jsonTemp);
            TryDelete(shaTemp);
        }

        return (evidencePath, shaPath, sha);
    }

    private static void TryDelete(string path)
    {
        try
        {
            if (File.Exists(path)) File.Delete(path);
        }
        catch
        {
            // Best-effort cleanup only; never obscure benchmark/evidence failures.
        }
    }

    private static readonly JsonSerializerOptions JsonOptions = new()
    {
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
        WriteIndented = false
    };

    private sealed class EvidenceDto
    {
        public required string SchemaVersion { get; init; }
        public required string BenchmarkReportSha256 { get; init; }
        public required string SeparationProvenanceSha256 { get; init; }
        public required string BasicPitchUpstreamCommitSha { get; init; }
        public required string BasicPitchModelSha256 { get; init; }
        public long BasicPitchModelBytes { get; init; }
        public required string AdoptionDecision { get; init; }
    }
}
