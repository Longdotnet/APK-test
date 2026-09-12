using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class NativeSeparatorProcessAdapterRegression
{
    [ModuleInitializer]
    internal static void RunPhase28Regressions()
    {
        Run("native separator rejects relative executable paths", RelativeExecutableFailsClosed);
        Run("native separator requires explicit output token", MissingOutputTokenFailsClosed);
        Run("native separator rejects oversized input before process start", OversizedInputFailsClosed);
        Run("native separator cancellation prevents process start", PreCancellationFailsClosed);
        Run("native separator never accepts process run without expected stem", MissingStemFailsClosed);
    }

    private static void RelativeExecutableFailsClosed()
    {
        using var fixture = new Fixture();
        Throws<ArgumentException>(() => fixture.Adapter.RunAsync(
            new NativeSeparatorProcessRequest("separator.exe", fixture.InputPath, new[] { NativeSeparatorProcessAdapter.OutputToken }),
            fixture.Options,
            EmptyTranscriber).AsTask().GetAwaiter().GetResult());
    }

    private static void MissingOutputTokenFailsClosed()
    {
        using var fixture = new Fixture();
        Throws<ArgumentException>(() => fixture.Adapter.RunAsync(
            new NativeSeparatorProcessRequest(fixture.ExistingExecutable, fixture.InputPath, new[] { NativeSeparatorProcessAdapter.InputToken }),
            fixture.Options,
            EmptyTranscriber).AsTask().GetAwaiter().GetResult());
    }

    private static void OversizedInputFailsClosed()
    {
        using var fixture = new Fixture();
        var options = fixture.Options with { MaxInputBytes = 1 };
        Throws<ArgumentOutOfRangeException>(() => fixture.Adapter.RunAsync(
            new NativeSeparatorProcessRequest(fixture.ExistingExecutable, fixture.InputPath, new[] { NativeSeparatorProcessAdapter.OutputToken }),
            options,
            EmptyTranscriber).AsTask().GetAwaiter().GetResult());
    }

    private static void PreCancellationFailsClosed()
    {
        using var fixture = new Fixture();
        using var cts = new CancellationTokenSource();
        cts.Cancel();
        Throws<OperationCanceledException>(() => fixture.Adapter.RunAsync(
            new NativeSeparatorProcessRequest(fixture.ExistingExecutable, fixture.InputPath, new[] { NativeSeparatorProcessAdapter.OutputToken }),
            fixture.Options,
            EmptyTranscriber,
            cts.Token).AsTask().GetAwaiter().GetResult());
    }

    private static void MissingStemFailsClosed()
    {
        if (!OperatingSystem.IsWindows())
            return;

        using var fixture = new Fixture();
        var where = Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.System), "where.exe");
        if (!File.Exists(where))
            return;

        Throws<Exception>(() => fixture.Adapter.RunAsync(
            new NativeSeparatorProcessRequest(
                where,
                fixture.InputPath,
                new[] { "where.exe", NativeSeparatorProcessAdapter.OutputToken }),
            fixture.Options,
            EmptyTranscriber).AsTask().GetAwaiter().GetResult());
    }

    private static ValueTask<IReadOnlyList<BasicPitchTranscribedNote>> EmptyTranscriber(string _, CancellationToken __) =>
        ValueTask.FromResult<IReadOnlyList<BasicPitchTranscribedNote>>(Array.Empty<BasicPitchTranscribedNote>());

    private sealed class Fixture : IDisposable
    {
        private readonly string directory = Path.Combine(Path.GetTempPath(), "RobloxPiano", "phase28-tests", Guid.NewGuid().ToString("N"));

        public Fixture()
        {
            Directory.CreateDirectory(directory);
            InputPath = Path.Combine(directory, "input.wav");
            File.WriteAllBytes(InputPath, new byte[] { 1, 2, 3, 4 });
            ExistingExecutable = Environment.ProcessPath ?? InputPath;
        }

        public NativeSeparatorProcessAdapter Adapter { get; } = new();
        public NativeSeparatorProcessOptions Options { get; } = new(100, TimeSpan.FromSeconds(5), 1024, 1024);
        public string InputPath { get; }
        public string ExistingExecutable { get; }

        public void Dispose()
        {
            try
            {
                if (Directory.Exists(directory))
                    Directory.Delete(directory, recursive: true);
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
        catch (Exception ex)
        {
            throw new InvalidOperationException($"Phase 28 regression failed: {name}", ex);
        }
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
