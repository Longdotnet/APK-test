using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class DemucsCppVerifiedBenchmarkRunnerRegression
{
    private const string CommitSha = "0123456789abcdef0123456789abcdef01234567";

    [ModuleInitializer]
    internal static void RunPhase31Regressions()
    {
        Run("verified demucs benchmark binds measured evidence to exact provenance", ExactProvenanceProducesMeasuredEvidence);
        Run("verified demucs benchmark rejects corpus drift during measurement", CorpusDriftDuringMeasurementFailsClosed);
        Run("verified demucs benchmark rejects model drift during measurement", ModelDriftDuringMeasurementFailsClosed);
        Run("verified demucs benchmark rejects unaccounted bundle evidence", BundleEvidenceMismatchFailsClosed);
        Run("verified demucs benchmark honors pre-cancellation before delegates", PreCancellationAvoidsDelegateWork);
    }

    private static void ExactProvenanceProducesMeasuredEvidence()
    {
        using var fixture = new Fixture("success");
        var run = Execute(
            fixture,
            (_, _) => ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Estimated((60, 0), (62, 1), (64, 2))),
            (_, _) => ValueTask.FromResult(new AudioSourceSeparationCandidateRun(
                Estimated((60, 0), (62, 1), (64, 2), (65, 3), (67, 4)),
                TimeSpan.FromSeconds(4),
                400L * 1024 * 1024,
                fixture.ExpectedBundleBytes)));

        Equal(fixture.ExecutableHash, run.Provenance.ExecutableSha256);
        Equal(fixture.ModelHash, run.Provenance.ModelSha256);
        Equal(fixture.InputHash, run.Provenance.Corpus.Single().Sha256);
        Equal(fixture.ExpectedBundleBytes, run.Benchmark.Resources.AddedBundleBytes);
        Equal(AudioSourceSeparationAdoptionDecision.Adopt, run.Benchmark.Assessment.Decision);
    }

    private static void CorpusDriftDuringMeasurementFailsClosed()
    {
        using var fixture = new Fixture("corpus-drift");

        Throws<InvalidDataException>(() => Execute(
            fixture,
            (_, _) => ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Estimated((60, 0))),
            (_, _) =>
            {
                AppendByte(fixture.InputPath, 99);
                return ValueTask.FromResult(new AudioSourceSeparationCandidateRun(
                    Estimated((60, 0)),
                    TimeSpan.FromSeconds(1),
                    100,
                    fixture.ExpectedBundleBytes));
            }));
    }

    private static void ModelDriftDuringMeasurementFailsClosed()
    {
        using var fixture = new Fixture("model-drift");

        Throws<InvalidDataException>(() => Execute(
            fixture,
            (_, _) => ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Estimated((60, 0))),
            (_, _) =>
            {
                AppendByte(fixture.ModelPath, 88);
                return ValueTask.FromResult(new AudioSourceSeparationCandidateRun(
                    Estimated((60, 0)),
                    TimeSpan.FromSeconds(1),
                    100,
                    fixture.ExpectedBundleBytes));
            }));
    }

    private static void BundleEvidenceMismatchFailsClosed()
    {
        using var fixture = new Fixture("bundle-mismatch");

        Throws<InvalidDataException>(() => Execute(
            fixture,
            (_, _) => ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Estimated((60, 0))),
            (_, _) => ValueTask.FromResult(new AudioSourceSeparationCandidateRun(
                Estimated((60, 0)),
                TimeSpan.FromSeconds(1),
                100,
                fixture.ExpectedBundleBytes + 1))));
    }

    private static void PreCancellationAvoidsDelegateWork()
    {
        using var fixture = new Fixture("cancel");
        using var cts = new CancellationTokenSource();
        cts.Cancel();
        var called = false;

        Throws<OperationCanceledException>(() => new DemucsCppVerifiedBenchmarkRunner().RunMeasuredAsync(
            fixture.Request,
            (_, _) =>
            {
                called = true;
                return ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Estimated((60, 0)));
            },
            (_, _) =>
            {
                called = true;
                return ValueTask.FromResult(new AudioSourceSeparationCandidateRun(Estimated((60, 0)), TimeSpan.Zero, 0, fixture.ExpectedBundleBytes));
            },
            cancellationToken: cts.Token).GetAwaiter().GetResult());

        True(!called, "Pre-cancelled verified benchmark must not invoke transcription delegates.");
    }

    private static DemucsCppVerifiedBenchmarkRun Execute(
        Fixture fixture,
        Func<string, CancellationToken, ValueTask<IReadOnlyList<BasicPitchTranscribedNote>>> direct,
        Func<DemucsCppVerifiedBenchmarkCase, CancellationToken, ValueTask<AudioSourceSeparationCandidateRun>> candidate) =>
        new DemucsCppVerifiedBenchmarkRunner().RunMeasuredAsync(
            fixture.Request,
            direct,
            candidate).GetAwaiter().GetResult();

    private static IReadOnlyList<AudioTranscriptionReferenceNote> Reference(params int[] notes) =>
        notes.Select((note, index) => new AudioTranscriptionReferenceNote(
            TimeSpan.FromSeconds(index),
            TimeSpan.FromSeconds(index + 0.5),
            note)).ToArray();

    private static IReadOnlyList<BasicPitchTranscribedNote> Estimated(params (int Note, int Second)[] notes) =>
        notes.Select(item => new BasicPitchTranscribedNote(
            TimeSpan.FromSeconds(item.Second),
            TimeSpan.FromSeconds(item.Second + 0.5),
            item.Note,
            0.8f)).ToArray();

    private static void AppendByte(string path, byte value)
    {
        using var stream = new FileStream(path, FileMode.Append, FileAccess.Write, FileShare.None);
        stream.WriteByte(value);
    }

    private sealed class Fixture : IDisposable
    {
        public Fixture(string name)
        {
            DirectoryPath = Path.Combine(Path.GetTempPath(), "RobloxPiano", "phase31-tests", name, Guid.NewGuid().ToString("N"));
            Directory.CreateDirectory(DirectoryPath);
            ExecutablePath = Path.Combine(DirectoryPath, "demucs.cpp.main.exe");
            ModelPath = Path.Combine(DirectoryPath, "ggml-model-htdemucs-6s-f16.bin");
            InputPath = Path.Combine(DirectoryPath, "owned-mixture.wav");
            File.WriteAllBytes(ExecutablePath, new byte[] { 1, 2, 3, 4 });
            File.WriteAllBytes(ModelPath, new byte[] { 5, 6, 7, 8, 9 });
            File.WriteAllBytes(InputPath, new byte[] { 10, 11, 12, 13 });

            ExecutableHash = DemucsCppBenchmarkProvenance.ComputeFileSha256(ExecutablePath);
            ModelHash = DemucsCppBenchmarkProvenance.ComputeFileSha256(ModelPath);
            InputHash = DemucsCppBenchmarkProvenance.ComputeFileSha256(InputPath);
            Profile = new DemucsCppSixSourcePianoBenchmarkProfile(ExecutablePath, ModelPath, AdditionalRuntimeBytes: 1234);
            ExpectedBundleBytes = new FileInfo(ExecutablePath).Length + new FileInfo(ModelPath).Length + 1234;
            Request = new DemucsCppVerifiedBenchmarkRequest(
                Profile,
                CommitSha,
                ExecutableHash,
                ModelHash,
                new[]
                {
                    new DemucsCppVerifiedBenchmarkCase(
                        "owned-mixture",
                        InputPath,
                        InputHash,
                        TimeSpan.FromSeconds(10),
                        Reference(60, 62, 64, 65, 67))
                });
        }

        public string DirectoryPath { get; }
        public string ExecutablePath { get; }
        public string ModelPath { get; }
        public string InputPath { get; }
        public string ExecutableHash { get; }
        public string ModelHash { get; }
        public string InputHash { get; }
        public DemucsCppSixSourcePianoBenchmarkProfile Profile { get; }
        public long ExpectedBundleBytes { get; }
        public DemucsCppVerifiedBenchmarkRequest Request { get; }

        public void Dispose()
        {
            try
            {
                if (Directory.Exists(DirectoryPath))
                    Directory.Delete(DirectoryPath, recursive: true);
            }
            catch (IOException)
            {
            }
            catch (UnauthorizedAccessException)
            {
            }
        }
    }

    private static void Run(string name, Action test)
    {
        try
        {
            test();
            Console.WriteLine($"PASS {name}");
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"FAIL {name}: {exception}");
            throw;
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
    }

    private static void Throws<TException>(Action action) where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }
        throw new InvalidOperationException($"Expected {typeof(TException).Name}.");
    }
}
