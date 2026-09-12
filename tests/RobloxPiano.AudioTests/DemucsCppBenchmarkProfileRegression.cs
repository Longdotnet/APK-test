using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class DemucsCppBenchmarkProfileRegression
{
    [ModuleInitializer]
    internal static void RunPhase29Regressions()
    {
        Run("demucs.cpp six-source profile selects piano stem", SixSourceProfileSelectsPianoStem);
        Run("demucs.cpp bundle measurement includes executable model and runtime", BundleMeasurementIsDeterministic);
        Run("native separator rejects workspace traversal stems", TraversalStemFailsClosed);
        Run("native separator rejects absolute selected stems", AbsoluteStemFailsClosed);
        Run("native separator requires selected WAV stem", NonWaveStemFailsClosed);
    }

    private static void SixSourceProfileSelectsPianoStem()
    {
        using var fixture = new Fixture();
        var profile = fixture.CreateProfile();

        var request = profile.BuildRequest(fixture.InputPath);

        Equal(fixture.ExecutablePath, request.ExecutablePath);
        Equal(fixture.InputPath, request.InputAudioPath);
        Equal(DemucsCppSixSourcePianoBenchmarkProfile.PianoStemRelativePath, request.ExpectedOutputRelativePath);
        Equal(3, request.Arguments.Count);
        Equal(fixture.ModelPath, request.Arguments[0]);
        Equal(NativeSeparatorProcessAdapter.InputToken, request.Arguments[1]);
        Equal(NativeSeparatorProcessAdapter.OutputToken, request.Arguments[2]);
    }

    private static void BundleMeasurementIsDeterministic()
    {
        using var fixture = new Fixture();
        const long runtimeBytes = 77;
        var profile = fixture.CreateProfile(runtimeBytes);

        var options = profile.BuildOptions();
        var expected = new FileInfo(fixture.ExecutablePath).Length + new FileInfo(fixture.ModelPath).Length + runtimeBytes;

        Equal(expected, options.AddedBundleBytes);
        Equal(TimeSpan.FromSeconds(12), options.Timeout);
    }

    private static void TraversalStemFailsClosed()
    {
        using var fixture = new Fixture();
        var request = new NativeSeparatorProcessRequest(
            fixture.ExecutablePath,
            fixture.InputPath,
            new[] { NativeSeparatorProcessAdapter.OutputToken },
            Path.Combine("..", "escape.wav"));

        Throws<ArgumentException>(() => fixture.Adapter.RunAsync(
            request,
            fixture.Options,
            EmptyTranscriber).AsTask().GetAwaiter().GetResult());
    }

    private static void AbsoluteStemFailsClosed()
    {
        using var fixture = new Fixture();
        var request = new NativeSeparatorProcessRequest(
            fixture.ExecutablePath,
            fixture.InputPath,
            new[] { NativeSeparatorProcessAdapter.OutputToken },
            Path.GetFullPath(Path.Combine(fixture.Directory, "absolute.wav")));

        Throws<ArgumentException>(() => fixture.Adapter.RunAsync(
            request,
            fixture.Options,
            EmptyTranscriber).AsTask().GetAwaiter().GetResult());
    }

    private static void NonWaveStemFailsClosed()
    {
        using var fixture = new Fixture();
        var request = new NativeSeparatorProcessRequest(
            fixture.ExecutablePath,
            fixture.InputPath,
            new[] { NativeSeparatorProcessAdapter.OutputToken },
            "target_5_piano.mid");

        Throws<ArgumentException>(() => fixture.Adapter.RunAsync(
            request,
            fixture.Options,
            EmptyTranscriber).AsTask().GetAwaiter().GetResult());
    }

    private static ValueTask<IReadOnlyList<BasicPitchTranscribedNote>> EmptyTranscriber(string _, CancellationToken __) =>
        ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Array.Empty<BasicPitchTranscribedNote>());

    private sealed class Fixture : IDisposable
    {
        public Fixture()
        {
            Directory = Path.Combine(Path.GetTempPath(), "RobloxPiano", "phase29-tests", Guid.NewGuid().ToString("N"));
            System.IO.Directory.CreateDirectory(Directory);
            ExecutablePath = Path.Combine(Directory, "demucs.cpp.main.exe");
            ModelPath = Path.Combine(Directory, "ggml-model-htdemucs-6s-f16.bin");
            InputPath = Path.Combine(Directory, "owned-audio.wav");
            File.WriteAllBytes(ExecutablePath, new byte[] { 1, 2, 3 });
            File.WriteAllBytes(ModelPath, new byte[] { 4, 5, 6, 7, 8 });
            File.WriteAllBytes(InputPath, new byte[] { 9, 10, 11, 12 });
        }

        public string Directory { get; }
        public string ExecutablePath { get; }
        public string ModelPath { get; }
        public string InputPath { get; }
        public NativeSeparatorProcessAdapter Adapter { get; } = new();
        public NativeSeparatorProcessOptions Options { get; } = new(8, TimeSpan.FromSeconds(1), 1024, 1024);

        public DemucsCppSixSourcePianoBenchmarkProfile CreateProfile(long runtimeBytes = 0) =>
            new(ExecutablePath, ModelPath, runtimeBytes, TimeSpan.FromSeconds(12), 1024, 1024);

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

    private static void Run(string name, Action test)
    {
        try
        {
            test();
        }
        catch (Exception exception)
        {
            throw new InvalidOperationException($"Phase 29 regression failed: {name}", exception);
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected '{expected}', got '{actual}'.");
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
