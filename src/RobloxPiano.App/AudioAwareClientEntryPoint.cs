using System.Diagnostics;
using System.Reflection;
using RobloxPiano.Audio;

namespace RobloxPiano.App;

/// <summary>
/// Thin production entrypoint for distribution-level concerns that must apply before the existing
/// client/CLI router. Runtime input ownership remains in <see cref="ClientEntryPoint"/>.
/// </summary>
internal static class AudioAwareClientEntryPoint
{
    private static readonly string[] NoticeResourceNames =
    [
        "RobloxPiano.App.THIRD-PARTY-NOTICES.txt",
        "RobloxPiano.App.THIRD-PARTY-DryWetMIDI.txt"
    ];

    [STAThread]
    public static int Main(string[] args)
    {
        if (args.Length == 1 && args[0].Equals("--third-party-notices", StringComparison.OrdinalIgnoreCase))
        {
            return WriteThirdPartyNotices();
        }

        if (args.Length == 1 && args[0].Equals("--audio-model-smoke", StringComparison.OrdinalIgnoreCase))
        {
            var noticesExitCode = ValidateThirdPartyNotices();
            if (noticesExitCode != 0)
            {
                return noticesExitCode;
            }

            // Distribution smoke must execute a real ONNX Run from the published single EXE.
            // Merely constructing InferenceSession previously allowed native/model execution
            // regressions to escape the release gate.
            return RunPublishedAudioModelSmoke();
        }

        if (args.Length == 1 && args[0].Equals("--create-piano-version", StringComparison.OrdinalIgnoreCase))
        {
            return RunCreatePianoVersionClient();
        }

        if (args.Length == 1 && args[0].Equals("--create-piano-logs", StringComparison.OrdinalIgnoreCase))
        {
            return OpenCreatePianoDiagnostics();
        }

        return ClientEntryPoint.Main(args);
    }

    private static int RunCreatePianoVersionClient()
    {
        InstallCreatePianoExceptionHandlers();

        try
        {
            ClientConsoleWindow.Hide();
            ApplicationConfiguration.Initialize();
            var localRoot = Path.Combine(
                Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
                "RobloxPiano");
            var maintenance = AudioReviewDraftStorageMaintenance.RunBestEffort(
                Path.Combine(localRoot, "audio-review-drafts"));
            ClientDiagnostics.Log(
                $"Audio review draft maintenance: drafts={maintenance.DraftsScanned}, referencedEvidence={maintenance.ReferencedEvidenceCount}, " +
                $"deletedEvidence={maintenance.DeletedOrphanEvidenceCount}, deletedTemps={maintenance.DeletedStaleTempCount}, " +
                $"reclaimedBytes={maintenance.ReclaimedBytes}, totalBytes={maintenance.TotalBytesAfter}, " +
                $"evidenceGcSkipped={maintenance.EvidenceGcSkipped}, quotaExceeded={maintenance.QuotaStillExceeded}.");
            ClientDiagnostics.Log(
                $"Create Piano Version client surface opened. Feature diagnostics: {AudioToPianoDiagnostics.DirectoryPath}");
            Application.Run(new AudioToPianoCreateForm());
            ClientDiagnostics.Log("Create Piano Version client surface closed.");
            return 0;
        }
        catch (Exception exception) when (exception is InvalidOperationException
            or System.ComponentModel.Win32Exception
            or IOException
            or UnauthorizedAccessException
            or TypeInitializationException
            or DllNotFoundException
            or BadImageFormatException)
        {
            AudioToPianoDiagnostics.LogUnhandled("create-piano-startup", exception);
            ClientDiagnostics.Log($"Create Piano Version client surface failed to start: {exception}");
            MessageBox.Show(
                exception.Message + Environment.NewLine + Environment.NewLine +
                $"Diagnostic logs: {AudioToPianoDiagnostics.DirectoryPath}",
                "Create Piano Version could not start",
                MessageBoxButtons.OK,
                MessageBoxIcon.Error);
            return 13;
        }
    }

    private static void InstallCreatePianoExceptionHandlers()
    {
        Application.SetUnhandledExceptionMode(UnhandledExceptionMode.CatchException);
        Application.ThreadException += (_, eventArgs) =>
        {
            AudioToPianoDiagnostics.LogUnhandled("winforms-thread", eventArgs.Exception);
            ClientDiagnostics.Log($"Unhandled Create Piano Version UI exception: {eventArgs.Exception}");
            try
            {
                MessageBox.Show(
                    "Create Piano Version hit an unexpected UI error. The application will stay open where possible." +
                    Environment.NewLine + Environment.NewLine +
                    $"Please send the newest .log from:{Environment.NewLine}{AudioToPianoDiagnostics.DirectoryPath}",
                    "Create Piano Version error",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }
            catch
            {
                // The UI may already be failing. The append-only diagnostic is the authoritative fallback.
            }
        };

        AppDomain.CurrentDomain.UnhandledException += (_, eventArgs) =>
        {
            var exception = eventArgs.ExceptionObject as Exception;
            AudioToPianoDiagnostics.LogUnhandled("appdomain", exception, eventArgs.ExceptionObject);
            ClientDiagnostics.Log(
                $"Unhandled Create Piano Version process exception (terminating={eventArgs.IsTerminating}): {eventArgs.ExceptionObject}");
        };

        TaskScheduler.UnobservedTaskException += (_, eventArgs) =>
        {
            AudioToPianoDiagnostics.LogUnhandled("unobserved-task", eventArgs.Exception);
            ClientDiagnostics.Log($"Unobserved Create Piano Version task exception: {eventArgs.Exception}");
            eventArgs.SetObserved();
        };
    }

    private static int RunPublishedAudioModelSmoke()
    {
        try
        {
            if (!BasicPitchBundledModel.IsAvailable)
            {
                throw new InvalidOperationException(
                    "The pinned Spotify Basic Pitch model is not embedded in this client build.");
            }

            var modelPath = BasicPitchBundledModel.MaterializeToDefaultCache();
            if (!BasicPitchBundledModel.HasExpectedIdentity(modelPath))
            {
                throw new InvalidDataException(
                    "The materialized Spotify Basic Pitch model failed its pinned provenance check.");
            }

            var samples = BuildAudioSmokeTone(seconds: 4.0, frequencyHz: 440.0);
            var progressEvents = new List<BasicPitchInferenceProgress>();
            using var inference = new BasicPitchInferenceService(modelPath);
            var raw = inference.Infer(
                new NormalizedAudio(samples, BasicPitchInferenceService.RequiredSampleRate),
                new InlineProgress<BasicPitchInferenceProgress>(progressEvents.Add),
                CancellationToken.None);

            if (raw.Notes.Frames <= 0
                || raw.Onsets.Frames != raw.Notes.Frames
                || raw.Contours.Frames != raw.Notes.Frames
                || progressEvents.Count < 3
                || progressEvents[^1].Fraction != 1d
                || !raw.Notes.Values.All(float.IsFinite)
                || !raw.Onsets.Values.All(float.IsFinite)
                || !raw.Contours.Values.All(float.IsFinite))
            {
                throw new InvalidDataException("Published Basic Pitch inference smoke returned invalid tensors or progress.");
            }

            Console.WriteLine(
                $"Audio model smoke passed. modelBytes={BasicPitchBundledModel.ExpectedLength}; " +
                $"gitBlob={BasicPitchBundledModel.ExpectedGitBlobSha1}; onnxRun=executed; " +
                $"frames={raw.Notes.Frames}; progressEvents={progressEvents.Count}.");
            return 0;
        }
        catch (Exception exception) when (exception is IOException
            or UnauthorizedAccessException
            or InvalidDataException
            or InvalidOperationException
            or ArgumentException
            or OverflowException
            or TypeInitializationException
            or DllNotFoundException
            or BadImageFormatException
            or Microsoft.ML.OnnxRuntime.OnnxRuntimeException)
        {
            Console.Error.WriteLine($"Audio model smoke failed: {exception}");
            return 11;
        }
    }

    private static float[] BuildAudioSmokeTone(double seconds, double frequencyHz)
    {
        var sampleRate = BasicPitchInferenceService.RequiredSampleRate;
        var length = checked((int)Math.Round(seconds * sampleRate));
        var samples = new float[length];
        for (var index = 0; index < samples.Length; index++)
        {
            var time = index / (double)sampleRate;
            samples[index] = (float)(Math.Sin(2d * Math.PI * frequencyHz * time) * 0.15d);
        }
        return samples;
    }

    private static int OpenCreatePianoDiagnostics()
    {
        try
        {
            Directory.CreateDirectory(AudioToPianoDiagnostics.DirectoryPath);
            Process.Start(new ProcessStartInfo
            {
                FileName = AudioToPianoDiagnostics.DirectoryPath,
                UseShellExecute = true
            });
            return 0;
        }
        catch (Exception exception) when (exception is IOException
            or UnauthorizedAccessException
            or InvalidOperationException
            or System.ComponentModel.Win32Exception)
        {
            Console.Error.WriteLine($"Could not open Create Piano diagnostics: {exception.Message}");
            return 14;
        }
    }

    private static int WriteThirdPartyNotices()
    {
        try
        {
            Console.Write(ReadThirdPartyNotices());
            return 0;
        }
        catch (Exception exception) when (exception is IOException or InvalidOperationException)
        {
            Console.Error.WriteLine($"Could not read third-party notices: {exception.Message}");
            return 12;
        }
    }

    private static int ValidateThirdPartyNotices()
    {
        try
        {
            var notices = ReadThirdPartyNotices();
            foreach (var requiredToken in new[]
            {
                "Copyright 2022 Spotify AB",
                "Apache License",
                "Copyright (c) Microsoft Corporation",
                "Copyright 2008-2026 Mark Heath",
                "DryWetMIDI Nativeless 8.0.3",
                "Copyright (c) 2018 Maxim Dobroselsky"
            })
            {
                if (!notices.Contains(requiredToken, StringComparison.Ordinal))
                {
                    throw new InvalidDataException($"Third-party notices are missing required attribution '{requiredToken}'.");
                }
            }

            return 0;
        }
        catch (Exception exception) when (exception is IOException or InvalidDataException or InvalidOperationException)
        {
            Console.Error.WriteLine($"Audio distribution notice validation failed: {exception.Message}");
            return 12;
        }
    }

    private static string ReadThirdPartyNotices()
    {
        var assembly = Assembly.GetExecutingAssembly();
        var sections = new List<string>(NoticeResourceNames.Length);
        foreach (var resourceName in NoticeResourceNames)
        {
            using var stream = assembly.GetManifestResourceStream(resourceName)
                ?? throw new InvalidOperationException($"Embedded notice resource '{resourceName}' is missing.");
            using var reader = new StreamReader(stream);
            sections.Add(reader.ReadToEnd().TrimEnd());
        }
        return string.Join(Environment.NewLine + Environment.NewLine, sections) + Environment.NewLine;
    }

    private sealed class InlineProgress<T>(Action<T> callback) : IProgress<T>
    {
        public void Report(T value) => callback(value);
    }
}
