using System.Globalization;
using System.Text;
using System.Text.Json;

namespace RobloxPiano.Audio;

public sealed record DemucsCppBenchmarkManifestRunResult(
    DemucsCppVerifiedBenchmarkRun Run,
    DemucsCppBenchmarkReport Report,
    string ReportPath,
    string Sha256Path);

/// <summary>
/// Engineering-only, manifest-driven entry point for a reproducible demucs.cpp benchmark run.
/// The manifest must explicitly pin every local executable/model/corpus path and SHA-256; this runner
/// performs no PATH discovery, downloads, media acquisition, or production state mutation.
/// </summary>
public sealed class DemucsCppBenchmarkManifestRunner
{
    public const string CurrentSchemaVersion = "roblox-piano.audio.separation-benchmark-manifest.v1";

    private readonly DemucsCppVerifiedBenchmarkRunner runner = new();

    public async Task<DemucsCppBenchmarkManifestRunResult> RunNativeAsync(
        string manifestPath,
        string reportPath,
        Func<string, CancellationToken, ValueTask<IReadOnlyList<BasicPitchTranscribedNote>>> directAudioTranscriber,
        Func<string, CancellationToken, ValueTask<IReadOnlyList<BasicPitchTranscribedNote>>> separatedStemTranscriber,
        AudioSourceSeparationAdoptionOptions? adoptionOptions = null,
        AudioTranscriptionEvaluationOptions? evaluationOptions = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(directAudioTranscriber);
        ArgumentNullException.ThrowIfNull(separatedStemTranscriber);
        cancellationToken.ThrowIfCancellationRequested();

        var request = LoadRequest(manifestPath);
        var measured = await runner.RunNativeAsync(
            request,
            directAudioTranscriber,
            separatedStemTranscriber,
            adoptionOptions,
            evaluationOptions,
            cancellationToken).ConfigureAwait(false);

        cancellationToken.ThrowIfCancellationRequested();
        return WriteArtifacts(measured, reportPath);
    }

    public static DemucsCppVerifiedBenchmarkRequest LoadRequest(string manifestPath)
    {
        if (string.IsNullOrWhiteSpace(manifestPath) || !Path.IsPathFullyQualified(manifestPath))
            throw new ArgumentException("Benchmark manifest path must be an explicit absolute path.", nameof(manifestPath));

        var fullManifestPath = Path.GetFullPath(manifestPath);
        if (!File.Exists(fullManifestPath))
            throw new FileNotFoundException("Benchmark manifest does not exist.", fullManifestPath);
        if (new FileInfo(fullManifestPath).Length > 4L * 1024 * 1024)
            throw new InvalidDataException("Benchmark manifest exceeds the 4 MiB engineering safety limit.");

        ManifestDto manifest;
        try
        {
            var json = File.ReadAllText(fullManifestPath, Encoding.UTF8);
            manifest = JsonSerializer.Deserialize<ManifestDto>(json, JsonOptions)
                ?? throw new InvalidDataException("Benchmark manifest is empty.");
        }
        catch (JsonException ex)
        {
            throw new InvalidDataException("Benchmark manifest is not valid JSON.", ex);
        }

        if (!string.Equals(manifest.SchemaVersion, CurrentSchemaVersion, StringComparison.Ordinal))
            throw new InvalidDataException($"Unsupported benchmark manifest schema '{manifest.SchemaVersion}'.");
        RequireFullSha1(manifest.UpstreamCommitSha, "upstreamCommitSha");
        RequireSha256(manifest.ExecutableSha256, "executableSha256");
        RequireSha256(manifest.ModelSha256, "modelSha256");

        if (manifest.Corpus is null || manifest.Corpus.Length == 0)
            throw new InvalidDataException("Benchmark manifest requires at least one corpus case.");
        if (manifest.Corpus.Length > 256)
            throw new InvalidDataException("Benchmark manifest supports at most 256 corpus cases per run.");
        if (manifest.AdditionalRuntimeBytes < 0)
            throw new InvalidDataException("additionalRuntimeBytes cannot be negative.");
        if (manifest.TimeoutSeconds is <= 0 or > 7200)
            throw new InvalidDataException("timeoutSeconds must be between 1 and 7200 seconds when supplied.");

        var profile = new DemucsCppSixSourcePianoBenchmarkProfile(
            RequireAbsolutePath(manifest.ExecutablePath, "executablePath"),
            RequireAbsolutePath(manifest.ModelPath, "modelPath"),
            manifest.AdditionalRuntimeBytes,
            manifest.TimeoutSeconds.HasValue ? TimeSpan.FromSeconds(manifest.TimeoutSeconds.Value) : null,
            manifest.MaxInputBytes ?? 512L * 1024 * 1024,
            manifest.MaxOutputBytes ?? 512L * 1024 * 1024);

        var seen = new HashSet<string>(StringComparer.Ordinal);
        var cases = new List<DemucsCppVerifiedBenchmarkCase>(manifest.Corpus.Length);
        foreach (var item in manifest.Corpus)
        {
            if (item is null)
                throw new InvalidDataException("Benchmark corpus cannot contain null cases.");
            if (string.IsNullOrWhiteSpace(item.Name) || item.Name.Length > 128)
                throw new InvalidDataException("Every corpus case requires a stable name no longer than 128 characters.");
            if (!seen.Add(item.Name))
                throw new InvalidDataException($"Duplicate corpus case name '{item.Name}'.");
            RequireSha256(item.Sha256, $"corpus[{item.Name}].sha256");
            if (!double.IsFinite(item.DurationMilliseconds) || item.DurationMilliseconds <= 0 || item.DurationMilliseconds > TimeSpan.FromHours(2).TotalMilliseconds)
                throw new InvalidDataException($"Corpus case '{item.Name}' has an invalid durationMilliseconds value.");
            if (item.ReferenceNotes is null || item.ReferenceNotes.Length == 0)
                throw new InvalidDataException($"Corpus case '{item.Name}' requires ground-truth referenceNotes.");
            if (item.ReferenceNotes.Length > 1_000_000)
                throw new InvalidDataException($"Corpus case '{item.Name}' has too many reference notes.");

            var reference = item.ReferenceNotes.Select((note, index) =>
            {
                if (note is null)
                    throw new InvalidDataException($"Corpus case '{item.Name}' contains a null reference note at index {index}.");
                if (!double.IsFinite(note.StartMilliseconds) || !double.IsFinite(note.EndMilliseconds))
                    throw new InvalidDataException($"Corpus case '{item.Name}' contains a non-finite reference-note timestamp.");
                try
                {
                    return new AudioTranscriptionReferenceNote(
                        TimeSpan.FromMilliseconds(note.StartMilliseconds),
                        TimeSpan.FromMilliseconds(note.EndMilliseconds),
                        note.MidiNote);
                }
                catch (ArgumentOutOfRangeException ex)
                {
                    throw new InvalidDataException($"Corpus case '{item.Name}' contains an invalid reference note at index {index}.", ex);
                }
            }).ToArray();

            cases.Add(new DemucsCppVerifiedBenchmarkCase(
                item.Name,
                RequireAbsolutePath(item.InputAudioPath, $"corpus[{item.Name}].inputAudioPath"),
                item.Sha256!.ToLowerInvariant(),
                TimeSpan.FromMilliseconds(item.DurationMilliseconds),
                reference));
        }

        return new DemucsCppVerifiedBenchmarkRequest(
            profile,
            manifest.UpstreamCommitSha!.ToLowerInvariant(),
            manifest.ExecutableSha256!.ToLowerInvariant(),
            manifest.ModelSha256!.ToLowerInvariant(),
            cases);
    }

    public static DemucsCppBenchmarkManifestRunResult WriteArtifacts(
        DemucsCppVerifiedBenchmarkRun run,
        string reportPath)
    {
        ArgumentNullException.ThrowIfNull(run);
        if (string.IsNullOrWhiteSpace(reportPath) || !Path.IsPathFullyQualified(reportPath))
            throw new ArgumentException("Benchmark report path must be an explicit absolute path.", nameof(reportPath));

        var fullReportPath = Path.GetFullPath(reportPath);
        if (!string.Equals(Path.GetExtension(fullReportPath), ".json", StringComparison.OrdinalIgnoreCase))
            throw new ArgumentException("Benchmark report path must use a .json extension.", nameof(reportPath));
        var directory = Path.GetDirectoryName(fullReportPath);
        if (string.IsNullOrWhiteSpace(directory))
            throw new ArgumentException("Benchmark report path must include a directory.", nameof(reportPath));
        Directory.CreateDirectory(directory);

        var report = DemucsCppBenchmarkReportWriter.Create(run);
        var shaPath = fullReportPath + ".sha256";
        var jsonTemp = fullReportPath + ".tmp";
        var shaTemp = shaPath + ".tmp";
        try
        {
            File.WriteAllText(jsonTemp, report.Json, new UTF8Encoding(false));
            File.WriteAllText(shaTemp, $"{report.ReportSha256}  {Path.GetFileName(fullReportPath)}\n", new UTF8Encoding(false));
            File.Move(jsonTemp, fullReportPath, overwrite: true);
            File.Move(shaTemp, shaPath, overwrite: true);
        }
        finally
        {
            TryDelete(jsonTemp);
            TryDelete(shaTemp);
        }

        return new DemucsCppBenchmarkManifestRunResult(run, report, fullReportPath, shaPath);
    }

    private static string RequireAbsolutePath(string? path, string field)
    {
        if (string.IsNullOrWhiteSpace(path) || !Path.IsPathFullyQualified(path))
            throw new InvalidDataException($"Manifest field '{field}' must be an explicit absolute path.");
        return Path.GetFullPath(path);
    }

    private static void RequireFullSha1(string? value, string field)
    {
        if (value is null || value.Length != 40 || value.Any(ch => !Uri.IsHexDigit(ch)))
            throw new InvalidDataException($"Manifest field '{field}' must be a full 40-character hexadecimal commit SHA.");
    }

    private static void RequireSha256(string? value, string field)
    {
        if (value is null || value.Length != 64 || value.Any(ch => !Uri.IsHexDigit(ch)))
            throw new InvalidDataException($"Manifest field '{field}' must be a 64-character hexadecimal SHA-256.");
    }

    private static void TryDelete(string path)
    {
        try
        {
            if (File.Exists(path)) File.Delete(path);
        }
        catch
        {
            // Best-effort cleanup only; never obscure benchmark/report failures.
        }
    }

    private static readonly JsonSerializerOptions JsonOptions = new()
    {
        PropertyNameCaseInsensitive = false,
        AllowTrailingCommas = false,
        ReadCommentHandling = JsonCommentHandling.Disallow
    };

    private sealed class ManifestDto
    {
        public string? SchemaVersion { get; init; }
        public string? UpstreamCommitSha { get; init; }
        public string? ExecutablePath { get; init; }
        public string? ExecutableSha256 { get; init; }
        public string? ModelPath { get; init; }
        public string? ModelSha256 { get; init; }
        public long AdditionalRuntimeBytes { get; init; }
        public double? TimeoutSeconds { get; init; }
        public long? MaxInputBytes { get; init; }
        public long? MaxOutputBytes { get; init; }
        public ManifestCaseDto?[]? Corpus { get; init; }
    }

    private sealed class ManifestCaseDto
    {
        public string? Name { get; init; }
        public string? InputAudioPath { get; init; }
        public string? Sha256 { get; init; }
        public double DurationMilliseconds { get; init; }
        public ManifestNoteDto?[]? ReferenceNotes { get; init; }
    }

    private sealed class ManifestNoteDto
    {
        public double StartMilliseconds { get; init; }
        public double EndMilliseconds { get; init; }
        public int MidiNote { get; init; }
    }
}