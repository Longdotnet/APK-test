using System.Globalization;
using System.Text.Json;
using RobloxPiano.Audio;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal static class Program
{
    private static readonly JsonSerializerOptions QualityJsonOptions = new()
    {
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
        WriteIndented = true
    };

    [STAThread]
    public static async Task<int> Main(string[] args)
    {
        if (args.Length == 1 && args[0].Equals("--audio-model-smoke", StringComparison.OrdinalIgnoreCase))
        {
            return RunAudioModelSmoke();
        }

        if (args.Length == 0 || args[0].Equals("--ui", StringComparison.OrdinalIgnoreCase))
        {
            return RunInteractiveClient();
        }

        return await RunCommandLineAsync(args).ConfigureAwait(false);
    }

    private static int RunAudioModelSmoke()
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

            using var service = new AudioToPianoTranscriptionService(modelPath);
            Console.WriteLine(
                $"Audio model smoke passed. modelBytes={BasicPitchBundledModel.ExpectedLength}; " +
                $"gitBlob={BasicPitchBundledModel.ExpectedGitBlobSha1}; onnxRuntimeSession=ready.");
            return 0;
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or InvalidDataException
            or InvalidOperationException
            or ArgumentException)
        {
            Console.Error.WriteLine($"Audio model smoke failed: {exception.Message}");
            return 11;
        }
    }

    private static int RunInteractiveClient()
    {
        ClientConsoleWindow.Hide();
        ApplicationConfiguration.Initialize();

        using var singleInstance = new Mutex(
            initiallyOwned: true,
            name: @"Local\Longdotnet.RobloxPiano.Client",
            createdNew: out var createdNew);

        if (!createdNew)
        {
            MessageBox.Show(
                "Roblox Piano is already running.",
                "Roblox Piano",
                MessageBoxButtons.OK,
                MessageBoxIcon.Information);
            return 4;
        }

        Application.ThreadException += (_, eventArgs) =>
        {
            ClientDiagnostics.Log($"Unhandled UI exception: {eventArgs.Exception}");
            MessageBox.Show(
                eventArgs.Exception.Message,
                "Roblox Piano error",
                MessageBoxButtons.OK,
                MessageBoxIcon.Error);
        };
        AppDomain.CurrentDomain.UnhandledException += (_, eventArgs) =>
        {
            ClientDiagnostics.Log($"Unhandled process exception: {eventArgs.ExceptionObject}");
        };

        ClientDiagnostics.Log("Interactive client started.");
        Application.Run(new SheetLibraryForm());
        ClientDiagnostics.Log("Interactive client stopped.");
        GC.KeepAlive(singleInstance);
        return 0;
    }

    private static async Task<int> RunCommandLineAsync(string[] args)
    {
        if (!TryParseArguments(args, out var settings, out var error))
        {
            if (!string.IsNullOrWhiteSpace(error))
            {
                Console.Error.WriteLine($"Error: {error}");
            }

            PrintUsage();
            return string.IsNullOrWhiteSpace(error) ? 0 : 2;
        }

        PerformanceTrack? track = null;
        PlaybackQualityCollector? qualityCollector = null;

        try
        {
            var sheetText = await File.ReadAllTextAsync(settings.SheetPath).ConfigureAwait(false);
            track = LegacySheetParser.Parse(sheetText);
            var edges = PlaybackPlanner.BuildEdges(track);

            Console.WriteLine("Roblox Piano production playback kernel");
            Console.WriteLine($"Title        : {track.Title}");
            Console.WriteLine($"BPM/Subdiv   : {track.Bpm.ToString("0.###", CultureInfo.InvariantCulture)} / {track.Subdivision}");
            Console.WriteLine($"Events/Edges : {track.Events.Count} / {edges.Count}");
            Console.WriteLine($"Timeline     : {track.TimelineDuration:mm\\:ss\\.fff}");
            Console.WriteLine($"Speed        : {settings.Speed.ToString("0.###", CultureInfo.InvariantCulture)}x");

            if (settings.ValidateOnly)
            {
                Console.WriteLine("Validation passed. No keyboard input was sent.");
                return 0;
            }

            using var cancellation = new CancellationTokenSource();
            Console.CancelKeyPress += (_, eventArgs) =>
            {
                eventArgs.Cancel = true;
                cancellation.Cancel();
            };

            var clock = new StopwatchClock();
            IInputSink baseInput;
            IFocusGate baseFocus;

            if (settings.DryRun)
            {
                baseInput = new TraceInputSink(() => clock.Elapsed);
                baseFocus = new AlwaysFocusedGate();
                Console.WriteLine("DRY RUN: keyboard injection is disabled.");
            }
            else
            {
                baseInput = new WindowsKeyboardInputSink();
                baseFocus = new RobloxForegroundFocusGate();
                Console.WriteLine("Safety guard enabled: playback waits whenever Roblox is not the foreground process.");
                Console.WriteLine("Press Ctrl+C to stop; all injected keys are released in the playback safety-finally path.");
            }

            qualityCollector = new PlaybackQualityCollector();
            var instrumented = PlaybackInstrumentation.Create(
                track,
                settings.Speed,
                clock,
                baseInput,
                baseFocus,
                qualityCollector);

            var playback = new PlaybackKernel(clock, instrumented.Input, instrumented.Focus);
            var initialDelay = settings.StartDelayOverride is null
                ? track.StartDelay
                : TimeSpan.FromSeconds(settings.StartDelayOverride.Value);

            await playback.PlayAsync(
                track,
                new PlaybackOptions(
                    Speed: settings.Speed,
                    InitialDelay: initialDelay,
                    FocusPollInterval: TimeSpan.FromMilliseconds(10)),
                cancellation.Token).ConfigureAwait(false);

            var report = qualityCollector.BuildReport(track, settings.Speed);
            PrintQualitySummary(report);
            var qualityExitCode = await PersistAndCompareQualityAsync(report, settings).ConfigureAwait(false);
            if (qualityExitCode != 0)
            {
                return qualityExitCode;
            }

            Console.WriteLine("Playback complete.");
            return 0;
        }
        catch (OperationCanceledException)
        {
            await TryPersistFailureReportAsync(track, qualityCollector, settings).ConfigureAwait(false);
            Console.WriteLine("Playback stopped safely.");
            return 130;
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or FormatException
            or InvalidOperationException
            or ArgumentException
            or JsonException)
        {
            await TryPersistFailureReportAsync(track, qualityCollector, settings).ConfigureAwait(false);
            Console.Error.WriteLine($"Playback failed: {exception.Message}");
            return 1;
        }
    }

    private static async Task<int> PersistAndCompareQualityAsync(PlaybackQualityReport report, ClientSettings settings)
    {
        if (settings.QualityReportPath is not null)
        {
            await WriteQualityReportAsync(settings.QualityReportPath, report).ConfigureAwait(false);
            Console.WriteLine($"Quality report: {settings.QualityReportPath}");
        }

        if (settings.BaselineReportPath is null)
        {
            return 0;
        }

        var baselineJson = await File.ReadAllTextAsync(settings.BaselineReportPath).ConfigureAwait(false);
        var baseline = JsonSerializer.Deserialize<PlaybackQualityReport>(baselineJson, QualityJsonOptions)
            ?? throw new FormatException("Baseline quality report is empty or invalid.");
        var comparison = PlaybackQualityComparator.Compare(baseline, report);
        Console.WriteLine($"A/B verdict   : {comparison.Verdict}");
        Console.WriteLine($"A/B reason    : {comparison.Reason}");
        Console.WriteLine($"P95 delta     : {comparison.P95DeltaMilliseconds:+0.###;-0.###;0} ms");
        Console.WriteLine($"Max delta     : {comparison.MaxErrorDeltaMilliseconds:+0.###;-0.###;0} ms");
        if (!settings.QualityGate)
        {
            return 0;
        }

        return comparison.Verdict is PlaybackComparisonVerdict.Better or PlaybackComparisonVerdict.Equivalent ? 0 : 3;
    }

    private static async Task TryPersistFailureReportAsync(PerformanceTrack? track, PlaybackQualityCollector? collector, ClientSettings settings)
    {
        if (track is null || collector is null || settings.QualityReportPath is null)
        {
            return;
        }

        try
        {
            var report = collector.BuildReport(track, settings.Speed);
            await WriteQualityReportAsync(settings.QualityReportPath, report).ConfigureAwait(false);
            Console.Error.WriteLine($"Partial quality report: {settings.QualityReportPath}");
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or ArgumentException)
        {
            Console.Error.WriteLine($"Could not write partial quality report: {exception.Message}");
        }
    }

    private static async Task WriteQualityReportAsync(string path, PlaybackQualityReport report)
    {
        var directory = Path.GetDirectoryName(path);
        if (!string.IsNullOrWhiteSpace(directory))
        {
            Directory.CreateDirectory(directory);
        }

        var json = JsonSerializer.Serialize(report, QualityJsonOptions);
        await File.WriteAllTextAsync(path, json).ConfigureAwait(false);
    }

    private static void PrintQualitySummary(PlaybackQualityReport report)
    {
        Console.WriteLine("Playback quality telemetry");
        Console.WriteLine($"Edges        : {report.DispatchedEdgeCount}/{report.PlannedEdgeCount} dispatched");
        Console.WriteLine($"P95 error    : {report.P95AbsoluteTimingErrorMilliseconds:0.###} ms");
        Console.WriteLine($"Max error    : {report.MaxAbsoluteTimingErrorMilliseconds:0.###} ms");
        Console.WriteLine($"Input call   : mean {report.MeanInputCallMilliseconds:0.###} ms, max {report.MaxInputCallMilliseconds:0.###} ms");
        Console.WriteLine($"Focus pauses : {report.FocusPauseCount} ({report.FocusPausedMilliseconds:0.###} ms)");
        Console.WriteLine($"Failures     : {report.FailureCount}, missing edges: {report.MissingEdgeCount}");
    }

    private static bool TryParseArguments(string[] args, out ClientSettings settings, out string? error)
    {
        settings = default;
        error = null;
        if (args.Length == 0 || args[0] is "-h" or "--help")
        {
            return false;
        }

        var sheetPath = Path.GetFullPath(args[0]);
        var speed = 1d;
        double? startDelayOverride = null;
        var dryRun = false;
        var validateOnly = false;
        string? qualityReportPath = null;
        string? baselineReportPath = null;
        var qualityGate = false;

        for (var index = 1; index < args.Length; index++)
        {
            switch (args[index])
            {
                case "--speed":
                    if (!TryReadPositiveDouble(args, ref index, out speed))
                    {
                        error = "--speed requires a finite number greater than zero.";
                        return false;
                    }
                    break;
                case "--start-delay":
                    if (!TryReadNonNegativeDouble(args, ref index, out var delay))
                    {
                        error = "--start-delay requires a finite number greater than or equal to zero.";
                        return false;
                    }
                    startDelayOverride = delay;
                    break;
                case "--dry-run":
                    dryRun = true;
                    break;
                case "--validate-only":
                    validateOnly = true;
                    break;
                case "--quality-report":
                    if (!TryReadPath(args, ref index, out qualityReportPath))
                    {
                        error = "--quality-report requires an output JSON path.";
                        return false;
                    }
                    break;
                case "--baseline-report":
                    if (!TryReadPath(args, ref index, out baselineReportPath))
                    {
                        error = "--baseline-report requires a JSON report path.";
                        return false;
                    }
                    break;
                case "--quality-gate":
                    qualityGate = true;
                    break;
                default:
                    error = $"Unknown option '{args[index]}'.";
                    return false;
            }
        }

        if (!File.Exists(sheetPath))
        {
            error = $"Sheet file does not exist: {sheetPath}";
            return false;
        }
        if (baselineReportPath is not null && !File.Exists(baselineReportPath))
        {
            error = $"Baseline quality report does not exist: {baselineReportPath}";
            return false;
        }
        if (qualityGate && baselineReportPath is null)
        {
            error = "--quality-gate requires --baseline-report.";
            return false;
        }
        if (validateOnly && (qualityReportPath is not null || baselineReportPath is not null || qualityGate))
        {
            error = "Quality telemetry requires playback or --dry-run and cannot be combined with --validate-only.";
            return false;
        }

        settings = new ClientSettings(sheetPath, speed, startDelayOverride, dryRun, validateOnly, qualityReportPath, baselineReportPath, qualityGate);
        return true;
    }

    private static bool TryReadPositiveDouble(string[] args, ref int index, out double value)
    {
        if (!TryReadDouble(args, ref index, out value))
        {
            return false;
        }
        return double.IsFinite(value) && value > 0d;
    }

    private static bool TryReadNonNegativeDouble(string[] args, ref int index, out double value)
    {
        if (!TryReadDouble(args, ref index, out value))
        {
            return false;
        }
        return double.IsFinite(value) && value >= 0d;
    }

    private static bool TryReadDouble(string[] args, ref int index, out double value)
    {
        value = default;
        if (index + 1 >= args.Length)
        {
            return false;
        }
        index++;
        return double.TryParse(args[index], NumberStyles.Float, CultureInfo.InvariantCulture, out value);
    }

    private static bool TryReadPath(string[] args, ref int index, out string? value)
    {
        value = null;
        if (index + 1 >= args.Length || string.IsNullOrWhiteSpace(args[index + 1]))
        {
            return false;
        }
        index++;
        value = Path.GetFullPath(args[index]);
        return true;
    }

    private static void PrintUsage()
    {
        Console.WriteLine("Roblox Piano");
        Console.WriteLine();
        Console.WriteLine("Client mode:");
        Console.WriteLine("  Double-click RobloxPiano.exe (or run RobloxPiano.exe --ui)");
        Console.WriteLine("  Opens Sheet Library first; F6 slower | F7 faster | F8 pause/resume | F9 stop in player");
        Console.WriteLine();
        Console.WriteLine("Developer/CI mode:");
        Console.WriteLine("  RobloxPiano.exe <sheet.txt> [--speed N] [--start-delay S] [--dry-run] [--validate-only]");
        Console.WriteLine("      [--quality-report report.json] [--baseline-report baseline.json] [--quality-gate]");
        Console.WriteLine("  RobloxPiano.exe --audio-model-smoke");
        Console.WriteLine();
        Console.WriteLine("Legacy x2 is intentionally preserved as a regression baseline via --speed 2.");
        Console.WriteLine("Quality A/B compares scheduler execution only; it does not claim perceptual or musical similarity.");
    }

    private readonly record struct ClientSettings(
        string SheetPath,
        double Speed,
        double? StartDelayOverride,
        bool DryRun,
        bool ValidateOnly,
        string? QualityReportPath,
        string? BaselineReportPath,
        bool QualityGate);
}
