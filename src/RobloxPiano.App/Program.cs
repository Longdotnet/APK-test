using System.Globalization;
using RobloxPiano.Core;

namespace RobloxPiano.App;

internal static class Program
{
    public static async Task<int> Main(string[] args)
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

        try
        {
            var sheetText = await File.ReadAllTextAsync(settings.SheetPath).ConfigureAwait(false);
            var track = LegacySheetParser.Parse(sheetText);
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
            IInputSink input;
            IFocusGate focus;

            if (settings.DryRun)
            {
                input = new TraceInputSink(() => clock.Elapsed);
                focus = new AlwaysFocusedGate();
                Console.WriteLine("DRY RUN: keyboard injection is disabled.");
            }
            else
            {
                input = new WindowsKeyboardInputSink();
                focus = new RobloxForegroundFocusGate();
                Console.WriteLine("Safety guard enabled: playback waits whenever Roblox is not the foreground process.");
                Console.WriteLine("Press Ctrl+C to stop; all injected keys are released in the playback safety-finally path.");
            }

            var playback = new PlaybackKernel(clock, input, focus);
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

            Console.WriteLine("Playback complete.");
            return 0;
        }
        catch (OperationCanceledException)
        {
            Console.WriteLine("Playback stopped safely.");
            return 130;
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or FormatException
            or InvalidOperationException
            or ArgumentException)
        {
            Console.Error.WriteLine($"Playback failed: {exception.Message}");
            return 1;
        }
    }

    private static bool TryParseArguments(
        string[] args,
        out ClientSettings settings,
        out string? error)
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

        settings = new ClientSettings(sheetPath, speed, startDelayOverride, dryRun, validateOnly);
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

    private static void PrintUsage()
    {
        Console.WriteLine("Usage:");
        Console.WriteLine("  RobloxPiano.exe <sheet.txt> [--speed N] [--start-delay S] [--dry-run] [--validate-only]");
        Console.WriteLine();
        Console.WriteLine("Examples:");
        Console.WriteLine("  RobloxPiano.exe song.txt");
        Console.WriteLine("  RobloxPiano.exe song.txt --speed 2");
        Console.WriteLine("  RobloxPiano.exe song.txt --validate-only");
        Console.WriteLine();
        Console.WriteLine("Legacy x2 is intentionally preserved as a regression baseline via --speed 2.");
    }

    private readonly record struct ClientSettings(
        string SheetPath,
        double Speed,
        double? StartDelayOverride,
        bool DryRun,
        bool ValidateOnly);
}
