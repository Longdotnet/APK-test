using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class DemucsCppBenchmarkProvenanceRegression
{
    private const string CommitSha = "0123456789abcdef0123456789abcdef01234567";

    [ModuleInitializer]
    internal static void RunPhase30Regressions()
    {
        Run("pinned demucs benchmark provenance verifies exact artifacts", ExactArtifactsVerify);
        Run("pinned demucs benchmark identity ignores local paths and corpus order", IdentityIsPortableAndOrderStable);
        Run("pinned demucs benchmark rejects separator binary drift", ExecutableDriftFailsClosed);
        Run("pinned demucs benchmark rejects model drift", ModelDriftFailsClosed);
        Run("pinned demucs benchmark rejects corpus drift", CorpusDriftFailsClosed);
        Run("pinned demucs benchmark requires full upstream commit identity", AbbreviatedCommitFailsClosed);
        Run("pinned demucs benchmark honors cancellation before hashing", PreCancellationFailsClosed);
    }

    private static void ExactArtifactsVerify()
    {
        using var fixture = new Fixture("a");
        var result = Verify(fixture, fixture.CorpusPins);

        Equal(CommitSha, result.UpstreamCommitSha);
        Equal(fixture.ExecutableHash, result.ExecutableSha256);
        Equal(fixture.ModelHash, result.ModelSha256);
        Equal(2, result.Corpus.Count);
        Equal(64, result.IdentitySha256.Length);
        True(result.IdentitySha256.All(IsLowerHex), "Benchmark identity must be normalized lowercase SHA-256.");
    }

    private static void IdentityIsPortableAndOrderStable()
    {
        using var first = new Fixture("first");
        using var second = new Fixture("second");

        var firstResult = Verify(first, first.CorpusPins);
        var reversedPins = second.CorpusPins.Reverse().ToArray();
        var secondResult = Verify(second, reversedPins);

        Equal(firstResult.IdentitySha256, secondResult.IdentitySha256);
    }

    private static void ExecutableDriftFailsClosed()
    {
        using var fixture = new Fixture("exe-drift");
        File.AppendAllBytes(fixture.ExecutablePath, new byte[] { 99 });

        Throws<InvalidDataException>(() => Verify(fixture, fixture.CorpusPins));
    }

    private static void ModelDriftFailsClosed()
    {
        using var fixture = new Fixture("model-drift");
        File.AppendAllBytes(fixture.ModelPath, new byte[] { 88 });

        Throws<InvalidDataException>(() => Verify(fixture, fixture.CorpusPins));
    }

    private static void CorpusDriftFailsClosed()
    {
        using var fixture = new Fixture("corpus-drift");
        File.AppendAllBytes(fixture.InputAPath, new byte[] { 77 });

        Throws<InvalidDataException>(() => Verify(fixture, fixture.CorpusPins));
    }

    private static void AbbreviatedCommitFailsClosed()
    {
        using var fixture = new Fixture("short-commit");

        Throws<ArgumentException>(() => DemucsCppBenchmarkProvenance.Verify(
            fixture.Profile,
            "01234567",
            fixture.ExecutableHash,
            fixture.ModelHash,
            fixture.CorpusPins));
    }

    private static void PreCancellationFailsClosed()
    {
        using var fixture = new Fixture("cancel");
        using var cts = new CancellationTokenSource();
        cts.Cancel();

        Throws<OperationCanceledException>(() => DemucsCppBenchmarkProvenance.Verify(
            fixture.Profile,
            CommitSha,
            fixture.ExecutableHash,
            fixture.ModelHash,
            fixture.CorpusPins,
            cts.Token));
    }

    private static DemucsCppBenchmarkVerifiedProvenance Verify(
        Fixture fixture,
        IReadOnlyList<DemucsCppBenchmarkCorpusPin> corpus) =>
        DemucsCppBenchmarkProvenance.Verify(
            fixture.Profile,
            CommitSha,
            fixture.ExecutableHash,
            fixture.ModelHash,
            corpus);

    private sealed class Fixture : IDisposable
    {
        public Fixture(string name)
        {
            Directory = Path.Combine(Path.GetTempPath(), "RobloxPiano", "phase30-tests", name, Guid.NewGuid().ToString("N"));
            System.IO.Directory.CreateDirectory(Directory);
            ExecutablePath = Path.Combine(Directory, "demucs.cpp.main.exe");
            ModelPath = Path.Combine(Directory, "ggml-model-htdemucs-6s-f16.bin");
            InputAPath = Path.Combine(Directory, "owned-mixture-a.wav");
            InputBPath = Path.Combine(Directory, "owned-mixture-b.wav");

            File.WriteAllBytes(ExecutablePath, new byte[] { 1, 2, 3, 4 });
            File.WriteAllBytes(ModelPath, new byte[] { 5, 6, 7, 8, 9 });
            File.WriteAllBytes(InputAPath, new byte[] { 10, 11, 12 });
            File.WriteAllBytes(InputBPath, new byte[] { 13, 14, 15, 16 });

            ExecutableHash = DemucsCppBenchmarkProvenance.ComputeFileSha256(ExecutablePath);
            ModelHash = DemucsCppBenchmarkProvenance.ComputeFileSha256(ModelPath);
            CorpusPins = new[]
            {
                new DemucsCppBenchmarkCorpusPin("mixture-a", InputAPath, DemucsCppBenchmarkProvenance.ComputeFileSha256(InputAPath)),
                new DemucsCppBenchmarkCorpusPin("mixture-b", InputBPath, DemucsCppBenchmarkProvenance.ComputeFileSha256(InputBPath))
            };
            Profile = new DemucsCppSixSourcePianoBenchmarkProfile(ExecutablePath, ModelPath);
        }

        public string Directory { get; }
        public string ExecutablePath { get; }
        public string ModelPath { get; }
        public string InputAPath { get; }
        public string InputBPath { get; }
        public string ExecutableHash { get; }
        public string ModelHash { get; }
        public IReadOnlyList<DemucsCppBenchmarkCorpusPin> CorpusPins { get; }
        public DemucsCppSixSourcePianoBenchmarkProfile Profile { get; }

        public void Dispose()
        {
            try
            {
                if (System.IO.Directory.Exists(Directory))
                    System.IO.Directory.Delete(Directory, recursive: true);
            }
            catch
            {
            }
        }
    }

    private static bool IsLowerHex(char value) => value is >= '0' and <= '9' or >= 'a' and <= 'f';

    private static void Run(string name, Action test)
    {
        try
        {
            test();
        }
        catch (Exception exception)
        {
            throw new InvalidOperationException($"Phase 30 regression failed: {name}", exception);
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected '{expected}', got '{actual}'.");
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
