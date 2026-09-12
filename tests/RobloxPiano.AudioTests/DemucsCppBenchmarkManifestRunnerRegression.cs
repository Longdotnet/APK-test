using System.Runtime.CompilerServices;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using RobloxPiano.Audio;

internal static class DemucsCppBenchmarkManifestRunnerRegression
{
    [ModuleInitializer]
    internal static void RunPhase33Regressions()
    {
        Run("demucs manifest maps pinned paths hashes corpus and ground truth", ManifestMapsPinnedRequest);
        Run("demucs manifest rejects relative artifact paths", RelativeArtifactPathFailsClosed);
        Run("demucs manifest rejects abbreviated or malformed hashes", InvalidHashesFailClosed);
        Run("demucs manifest rejects duplicate corpus identities", DuplicateCorpusIdentityFailsClosed);
        Run("demucs manifest report emits matching sha256 sidecar", ReportWritesVerifiedSidecar);
    }

    private static void ManifestMapsPinnedRequest()
    {
        using var fixture = new Fixture();
        var request = DemucsCppBenchmarkManifestRunner.LoadRequest(fixture.ManifestPath);

        Equal(Fixture.CommitSha, request.UpstreamCommitSha);
        Equal(fixture.ExecutableHash, request.ExecutableSha256);
        Equal(fixture.ModelHash, request.ModelSha256);
        Equal(Path.GetFullPath(fixture.ExecutablePath), request.Profile.ExecutablePath);
        Equal(Path.GetFullPath(fixture.ModelPath), request.Profile.ModelPath);
        Equal(1234L, request.Profile.AdditionalRuntimeBytes);
        Equal(TimeSpan.FromSeconds(90), request.Profile.Timeout);
        Equal(1, request.Cases.Count);
        Equal("owned-song-a", request.Cases[0].Name);
        Equal(fixture.InputHash, request.Cases[0].Sha256);
        Equal(TimeSpan.FromSeconds(12), request.Cases[0].AudioDuration);
        Equal(2, request.Cases[0].Reference.Count);
        Equal(60, request.Cases[0].Reference[0].MidiNote);
        Equal(TimeSpan.FromMilliseconds(100), request.Cases[0].Reference[0].Start);
        Equal(TimeSpan.FromMilliseconds(800), request.Cases[0].Reference[0].End);
    }

    private static void RelativeArtifactPathFailsClosed()
    {
        using var fixture = new Fixture(executablePathOverride: "demucs.exe");
        Throws<InvalidDataException>(() => DemucsCppBenchmarkManifestRunner.LoadRequest(fixture.ManifestPath));
    }

    private static void InvalidHashesFailClosed()
    {
        using var shortCommit = new Fixture(commitOverride: "0123456");
        Throws<InvalidDataException>(() => DemucsCppBenchmarkManifestRunner.LoadRequest(shortCommit.ManifestPath));

        using var badSha = new Fixture(executableHashOverride: new string('z', 64));
        Throws<InvalidDataException>(() => DemucsCppBenchmarkManifestRunner.LoadRequest(badSha.ManifestPath));
    }

    private static void DuplicateCorpusIdentityFailsClosed()
    {
        using var fixture = new Fixture(duplicateCase: true);
        Throws<InvalidDataException>(() => DemucsCppBenchmarkManifestRunner.LoadRequest(fixture.ManifestPath));
    }

    private static void ReportWritesVerifiedSidecar()
    {
        using var fixture = new Fixture();
        var request = DemucsCppBenchmarkManifestRunner.LoadRequest(fixture.ManifestPath);
        var provenance = DemucsCppBenchmarkProvenance.Verify(
            request.Profile,
            request.UpstreamCommitSha,
            request.ExecutableSha256,
            request.ModelSha256,
            request.Cases.Select(item => new DemucsCppBenchmarkCorpusPin(item.Name, item.InputAudioPath, item.Sha256)).ToArray());

        var direct = Evaluation(2, 2);
        var candidate = Evaluation(2, 2);
        var resources = new AudioSourceSeparationResourceMeasurement(1234, 4096, 0.5);
        var caseResult = new AudioSourceSeparationBenchmarkCaseResult(
            "owned-song-a",
            TimeSpan.FromSeconds(12),
            direct,
            candidate,
            TimeSpan.FromSeconds(6),
            4096,
            1234);
        var assessment = new AudioSourceSeparationAdoptionAssessment(
            AudioSourceSeparationAdoptionDecision.Review,
            1,
            1,
            1,
            0,
            0,
            0,
            0,
            resources,
            new Dictionary<string, double>(StringComparer.Ordinal) { ["owned-song-a"] = 0 },
            new[] { "fixture" });
        var run = new DemucsCppVerifiedBenchmarkRun(
            provenance,
            new AudioSourceSeparationBenchmarkRun(new[] { caseResult }, resources, assessment));

        var reportPath = Path.Combine(fixture.Root, "evidence", "benchmark.json");
        var result = DemucsCppBenchmarkManifestRunner.WriteArtifacts(run, reportPath);
        True(File.Exists(result.ReportPath), "Benchmark report must be written.");
        True(File.Exists(result.Sha256Path), "Benchmark SHA-256 sidecar must be written.");
        Equal(result.Report.Json, File.ReadAllText(result.ReportPath, Encoding.UTF8));
        var sidecar = File.ReadAllText(result.Sha256Path, Encoding.UTF8).Trim();
        Equal($"{result.Report.ReportSha256}  benchmark.json", sidecar);
        var diskHash = Convert.ToHexString(SHA256.HashData(File.ReadAllBytes(result.ReportPath))).ToLowerInvariant();
        Equal(result.Report.ReportSha256, diskHash);
    }

    private static AudioTranscriptionEvaluationResult Evaluation(int referenceNotes, int matchedNotes)
    {
        var precision = matchedNotes / (double)referenceNotes;
        return new AudioTranscriptionEvaluationResult(
            referenceNotes,
            referenceNotes,
            matchedNotes,
            precision,
            precision,
            precision,
            0,
            0,
            Array.Empty<AudioTranscriptionNoteMatch>());
    }

    private sealed class Fixture : IDisposable
    {
        internal const string CommitSha = "0123456789abcdef0123456789abcdef01234567";

        internal Fixture(
            string? executablePathOverride = null,
            string? commitOverride = null,
            string? executableHashOverride = null,
            bool duplicateCase = false)
        {
            Root = Path.Combine(Path.GetTempPath(), "roblox-piano-phase33", Guid.NewGuid().ToString("N"));
            Directory.CreateDirectory(Root);
            ExecutablePath = Path.Combine(Root, "demucs.exe");
            ModelPath = Path.Combine(Root, "demucs-6s.bin");
            InputPath = Path.Combine(Root, "owned-song-a.wav");
            File.WriteAllBytes(ExecutablePath, new byte[] { 1, 2, 3 });
            File.WriteAllBytes(ModelPath, new byte[] { 4, 5, 6, 7 });
            File.WriteAllBytes(InputPath, new byte[] { 8, 9, 10, 11, 12 });
            ExecutableHash = Hash(ExecutablePath);
            ModelHash = Hash(ModelPath);
            InputHash = Hash(InputPath);
            ManifestPath = Path.Combine(Root, "benchmark-manifest.json");

            var cases = new List<object>
            {
                CorpusCase("owned-song-a")
            };
            if (duplicateCase)
                cases.Add(CorpusCase("owned-song-a"));

            var manifest = new
            {
                SchemaVersion = DemucsCppBenchmarkManifestRunner.CurrentSchemaVersion,
                UpstreamCommitSha = commitOverride ?? CommitSha,
                ExecutablePath = executablePathOverride ?? ExecutablePath,
                ExecutableSha256 = executableHashOverride ?? ExecutableHash,
                ModelPath,
                ModelSha256 = ModelHash,
                AdditionalRuntimeBytes = 1234,
                TimeoutSeconds = 90,
                MaxInputBytes = 1024L * 1024,
                MaxOutputBytes = 1024L * 1024,
                Corpus = cases
            };
            File.WriteAllText(ManifestPath, JsonSerializer.Serialize(manifest), new UTF8Encoding(false));
        }

        internal string Root { get; }
        internal string ManifestPath { get; }
        internal string ExecutablePath { get; }
        internal string ModelPath { get; }
        internal string InputPath { get; }
        internal string ExecutableHash { get; }
        internal string ModelHash { get; }
        internal string InputHash { get; }

        private object CorpusCase(string name) => new
        {
            Name = name,
            InputAudioPath = InputPath,
            Sha256 = InputHash,
            DurationMilliseconds = 12000,
            ReferenceNotes = new[]
            {
                new { StartMilliseconds = 100, EndMilliseconds = 800, MidiNote = 60 },
                new { StartMilliseconds = 1000, EndMilliseconds = 1500, MidiNote = 64 }
            }
        };

        public void Dispose()
        {
            try { Directory.Delete(Root, recursive: true); } catch { }
        }

        private static string Hash(string path) =>
            Convert.ToHexString(SHA256.HashData(File.ReadAllBytes(path))).ToLowerInvariant();
    }

    private static void Run(string name, Action action)
    {
        try { action(); }
        catch (Exception ex) { throw new InvalidOperationException($"Phase 33 regression failed: {name}", ex); }
    }

    private static void True(bool condition, string message)
    {
        if (!condition) throw new InvalidOperationException(message);
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected '{expected}', got '{actual}'.");
    }

    private static void Throws<T>(Action action) where T : Exception
    {
        try { action(); }
        catch (T) { return; }
        throw new InvalidOperationException($"Expected {typeof(T).Name}.");
    }
}