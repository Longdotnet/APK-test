using System.Security.Cryptography;
using System.Text;
using System.Text.Json;

namespace RobloxPiano.Audio;

public sealed record DemucsCppBenchmarkReport(
    string SchemaVersion,
    string ProvenanceIdentitySha256,
    string ReportSha256,
    string Json);

/// <summary>
/// Produces a deterministic, machine-readable engineering artifact for a verified demucs.cpp paired benchmark.
/// The report intentionally excludes machine-local paths and timestamps so identical verified bytes and measured
/// results produce identical UTF-8 JSON and SHA-256 across machines. It never mutates production transcription,
/// canonical PerformanceTrack state, or Roblox playback/input behavior.
/// </summary>
public static class DemucsCppBenchmarkReportWriter
{
    public const string CurrentSchemaVersion = "roblox-piano.audio.separation-benchmark.v1";

    public static DemucsCppBenchmarkReport Create(DemucsCppVerifiedBenchmarkRun run)
    {
        ArgumentNullException.ThrowIfNull(run);
        ArgumentNullException.ThrowIfNull(run.Provenance);
        ArgumentNullException.ThrowIfNull(run.Benchmark);
        Validate(run);

        using var stream = new MemoryStream();
        using (var writer = new Utf8JsonWriter(stream, new JsonWriterOptions { Indented = true }))
        {
            writer.WriteStartObject();
            writer.WriteString("schemaVersion", CurrentSchemaVersion);
            writer.WriteString("provenanceIdentitySha256", run.Provenance.IdentitySha256);
            writer.WriteString("upstreamCommitSha", run.Provenance.UpstreamCommitSha);
            writer.WriteString("executableSha256", run.Provenance.ExecutableSha256);
            writer.WriteString("modelSha256", run.Provenance.ModelSha256);

            writer.WritePropertyName("corpus");
            writer.WriteStartArray();
            foreach (var item in run.Provenance.Corpus.OrderBy(item => item.Name, StringComparer.Ordinal))
            {
                writer.WriteStartObject();
                writer.WriteString("name", item.Name);
                writer.WriteString("sha256", item.Sha256);
                writer.WriteEndObject();
            }
            writer.WriteEndArray();

            writer.WritePropertyName("cases");
            writer.WriteStartArray();
            foreach (var item in run.Benchmark.Cases.OrderBy(item => item.Name, StringComparer.Ordinal))
            {
                writer.WriteStartObject();
                writer.WriteString("name", item.Name);
                writer.WriteNumber("audioDurationMilliseconds", item.AudioDuration.TotalMilliseconds);
                WriteEvaluation(writer, "direct", item.Direct);
                WriteEvaluation(writer, "candidate", item.Candidate);
                writer.WriteNumber("f1Delta", item.Candidate.F1 - item.Direct.F1);
                writer.WriteNumber("candidateElapsedMilliseconds", item.CandidateElapsed.TotalMilliseconds);
                writer.WriteNumber("candidatePeakWorkingSetBytes", item.CandidatePeakWorkingSetBytes);
                writer.WriteNumber("candidateAddedBundleBytes", item.CandidateAddedBundleBytes);
                writer.WriteEndObject();
            }
            writer.WriteEndArray();

            writer.WritePropertyName("resources");
            writer.WriteStartObject();
            writer.WriteNumber("addedBundleBytes", run.Benchmark.Resources.AddedBundleBytes);
            writer.WriteNumber("peakWorkingSetBytes", run.Benchmark.Resources.PeakWorkingSetBytes);
            writer.WriteNumber("processingSecondsPerAudioSecond", run.Benchmark.Resources.ProcessingSecondsPerAudioSecond);
            writer.WriteEndObject();

            var assessment = run.Benchmark.Assessment;
            writer.WritePropertyName("assessment");
            writer.WriteStartObject();
            writer.WriteString("decision", assessment.Decision.ToString());
            writer.WriteNumber("cases", assessment.Cases);
            writer.WriteNumber("directMicroF1", assessment.DirectMicroF1);
            writer.WriteNumber("candidateMicroF1", assessment.CandidateMicroF1);
            writer.WriteNumber("microF1Gain", assessment.MicroF1Gain);
            writer.WriteNumber("medianCaseF1Gain", assessment.MedianCaseF1Gain);
            writer.WriteNumber("worstCaseF1Delta", assessment.WorstCaseF1Delta);
            writer.WriteNumber("improvedCaseRatio", assessment.ImprovedCaseRatio);
            writer.WritePropertyName("reasons");
            writer.WriteStartArray();
            foreach (var reason in assessment.Reasons.OrderBy(reason => reason, StringComparer.Ordinal))
                writer.WriteStringValue(reason);
            writer.WriteEndArray();
            writer.WriteEndObject();
            writer.WriteEndObject();
        }

        var bytes = stream.ToArray();
        var json = Encoding.UTF8.GetString(bytes);
        var hash = Convert.ToHexString(SHA256.HashData(bytes)).ToLowerInvariant();
        return new DemucsCppBenchmarkReport(CurrentSchemaVersion, run.Provenance.IdentitySha256, hash, json);
    }

    public static void WriteFile(DemucsCppVerifiedBenchmarkRun run, string outputPath)
    {
        if (string.IsNullOrWhiteSpace(outputPath))
            throw new ArgumentException("Benchmark report output path is required.", nameof(outputPath));
        var fullPath = Path.GetFullPath(outputPath);
        var directory = Path.GetDirectoryName(fullPath);
        if (string.IsNullOrWhiteSpace(directory))
            throw new ArgumentException("Benchmark report output path must include a directory.", nameof(outputPath));
        Directory.CreateDirectory(directory);
        var report = Create(run);
        File.WriteAllText(fullPath, report.Json, new UTF8Encoding(encoderShouldEmitUTF8Identifier: false));
    }

    private static void Validate(DemucsCppVerifiedBenchmarkRun run)
    {
        var provenanceNames = run.Provenance.Corpus.Select(item => item.Name).OrderBy(name => name, StringComparer.Ordinal).ToArray();
        var benchmarkNames = run.Benchmark.Cases.Select(item => item.Name).OrderBy(name => name, StringComparer.Ordinal).ToArray();
        if (!provenanceNames.SequenceEqual(benchmarkNames, StringComparer.Ordinal))
            throw new InvalidDataException("Benchmark report cases must exactly match verified provenance corpus identities.");
        if (run.Benchmark.Assessment.Cases != run.Benchmark.Cases.Count)
            throw new InvalidDataException("Benchmark assessment case count does not match measured case results.");
        if (run.Benchmark.Resources != run.Benchmark.Assessment.Resources)
            throw new InvalidDataException("Benchmark resources do not match adoption-assessment resources.");
    }

    private static void WriteEvaluation(Utf8JsonWriter writer, string propertyName, AudioTranscriptionEvaluationResult value)
    {
        ArgumentNullException.ThrowIfNull(value);
        writer.WritePropertyName(propertyName);
        writer.WriteStartObject();
        writer.WriteNumber("referenceNotes", value.ReferenceNotes);
        writer.WriteNumber("estimatedNotes", value.EstimatedNotes);
        writer.WriteNumber("matchedNotes", value.MatchedNotes);
        writer.WriteNumber("precision", value.Precision);
        writer.WriteNumber("recall", value.Recall);
        writer.WriteNumber("f1", value.F1);
        writer.WriteNumber("meanAbsoluteOnsetErrorMilliseconds", value.MeanAbsoluteOnsetErrorMilliseconds);
        writer.WriteNumber("meanAbsoluteOffsetErrorMilliseconds", value.MeanAbsoluteOffsetErrorMilliseconds);
        writer.WriteEndObject();
    }
}
