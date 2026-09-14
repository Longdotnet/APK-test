using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class AudioToPianoDiagnosticsRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        Run("Create Piano diagnostics preserve stage evidence without full local paths", WritesPrivacyAwareCrashEvidence);
        Run("Create Piano unhandled diagnostics append to the active attempt", UnhandledFailureUsesActiveAttemptLog);
    }

    private static void WritesPrivacyAwareCrashEvidence()
    {
        var root = Path.Combine(Path.GetTempPath(), "RobloxPiano-AudioDiagnosticsTests", Guid.NewGuid().ToString("N"));
        var sourceDirectory = Path.Combine(root, "private-source-folder");
        var diagnosticsDirectory = Path.Combine(root, "diagnostics");
        Directory.CreateDirectory(sourceDirectory);
        var sourcePath = Path.Combine(sourceDirectory, "fixture-secret-name.mp3");
        File.WriteAllBytes(sourcePath, [0x49, 0x44, 0x33, 0x04]);

        string logPath;
        try
        {
            using (var session = AudioToPianoDiagnostics.Start(sourcePath, "Fixture title", diagnosticsDirectory))
            {
                logPath = session.LogPath;
                var snapshot = new AudioToPianoClientJobSnapshot(
                    AudioToPianoClientJobState.Running,
                    AudioToPianoTranscriptionStage.Inference,
                    0.42d,
                    "Listening for notes with Basic Pitch...",
                    sourcePath,
                    null);
                session.WriteProgress(snapshot);
                session.WriteFailure(new InvalidDataException("synthetic decoder failure"), snapshot);

                Equal(logPath, AudioToPianoDiagnostics.CurrentLogPath);
            }

            True(AudioToPianoDiagnostics.CurrentLogPath is null, "Disposed diagnostic sessions must release the active-log pointer.");
            True(File.Exists(logPath), "Diagnostic log must be materialized immediately for crash resilience.");
            var text = File.ReadAllText(logPath);
            Contains(text, "event=session-start");
            Contains(text, "sourceFile=fixture-secret-name.mp3");
            Contains(text, "event=progress");
            Contains(text, "stage=Inference");
            Contains(text, "fraction=0.4200");
            Contains(text, "event=failure");
            Contains(text, "InvalidDataException");
            Contains(text, "managedMB=");
            Contains(text, "workingSetMB=");
            Contains(text, "pathHash=");
            False(text.Contains(sourceDirectory, StringComparison.OrdinalIgnoreCase), "Diagnostics must not expose the full local source directory.");
            False(text.Contains(Convert.ToHexString(File.ReadAllBytes(sourcePath)), StringComparison.OrdinalIgnoreCase), "Diagnostics must not copy source audio bytes.");
        }
        finally
        {
            TryDelete(root);
        }
    }

    private static void UnhandledFailureUsesActiveAttemptLog()
    {
        var root = Path.Combine(Path.GetTempPath(), "RobloxPiano-AudioDiagnosticsTests", Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(root);
        var sourcePath = Path.Combine(root, "fixture.wav");
        File.WriteAllBytes(sourcePath, [0x52, 0x49, 0x46, 0x46]);
        var diagnosticsDirectory = Path.Combine(root, "diagnostics");

        try
        {
            string logPath;
            using (var session = AudioToPianoDiagnostics.Start(sourcePath, null, diagnosticsDirectory))
            {
                logPath = session.LogPath;
                AudioToPianoDiagnostics.LogUnhandled(
                    "regression-test",
                    new InvalidOperationException("synthetic unhandled failure"));
                var text = File.ReadAllText(logPath);
                Contains(text, "event=unhandled");
                Contains(text, "scope=regression-test");
                Contains(text, "synthetic unhandled failure");
            }

            True(File.Exists(logPath), "Unhandled evidence must remain readable after session disposal.");
        }
        finally
        {
            TryDelete(root);
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

    private static void Contains(string text, string expected)
    {
        if (!text.Contains(expected, StringComparison.Ordinal))
            throw new InvalidOperationException($"Expected diagnostic text to contain '{expected}'.");
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

    private static void False(bool condition, string message)
    {
        if (condition)
            throw new InvalidOperationException(message);
    }

    private static void TryDelete(string directory)
    {
        try
        {
            if (Directory.Exists(directory))
                Directory.Delete(directory, recursive: true);
        }
        catch (IOException)
        {
        }
        catch (UnauthorizedAccessException)
        {
        }
    }
}
