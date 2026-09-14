using System.Diagnostics;
using System.Runtime.InteropServices;
using System.Text;

namespace RobloxPiano.Audio;

/// <summary>
/// Crash-resilient, privacy-conscious diagnostics for Create Piano Version.
/// Every write opens and flushes the file so the last completed checkpoint normally survives
/// an abrupt native/runtime process termination. Diagnostics are evidence only and never affect
/// transcription truth, progress, or job state.
/// </summary>
internal sealed class AudioToPianoDiagnostics : IDisposable
{
    private const long MaximumLogBytes = 4 * 1024 * 1024;
    private static readonly object FileGate = new();
    private readonly Stopwatch elapsed = Stopwatch.StartNew();
    private readonly string operationId = Guid.NewGuid().ToString("N")[..12];
    private readonly string sourceFileName;
    private readonly long sourceBytes;
    private AudioToPianoTranscriptionStage? lastStage;
    private int lastProgressBucket = -1;
    private bool disposed;

    private AudioToPianoDiagnostics(string sourcePath)
    {
        sourceFileName = SafeFileName(sourcePath);
        sourceBytes = TryGetLength(sourcePath);
        Write(
            "operation-start",
            $"source={Quote(sourceFileName)} bytes={sourceBytes} " +
            $"clientAssembly={typeof(AudioToPianoDiagnostics).Assembly.GetName().Version?.ToString() ?? "unknown"} " +
            $"runtime={Quote(RuntimeInformation.FrameworkDescription)} os={Quote(RuntimeInformation.OSDescription)} " +
            $"osArch={RuntimeInformation.OSArchitecture} processArch={RuntimeInformation.ProcessArchitecture} " +
            $"pid={Environment.ProcessId} processors={Environment.ProcessorCount} is64Bit={Environment.Is64BitProcess}");
    }

    public static string LogPath => Path.Combine(
        Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
        "RobloxPiano",
        "diagnostics",
        "create-piano.log");

    public static AudioToPianoDiagnostics Start(string sourcePath) => new(sourcePath);

    public void Checkpoint(string eventName, string? details = null)
        => Write(eventName, details);

    public void Progress(AudioToPianoTranscriptionProgress value)
    {
        var bucket = Math.Clamp((int)Math.Floor(value.Fraction * 20d), 0, 20);
        if (value.Stage == lastStage && bucket == lastProgressBucket)
            return;

        lastStage = value.Stage;
        lastProgressBucket = bucket;
        Write(
            "progress",
            $"stage={value.Stage} fraction={value.Fraction:0.000} message={Quote(value.Message)}");
    }

    public void Completed(AudioToPianoTranscriptionResult result)
    {
        ArgumentNullException.ThrowIfNull(result);
        var diagnostics = result.Diagnostics;
        Write(
            "operation-complete",
            $"elapsedMs={elapsed.Elapsed.TotalMilliseconds:0} decodedNotes={diagnostics.DecodedNotes} " +
            $"retainedNotes={diagnostics.NotesAfterSuppression} reviewRegions={diagnostics.ReviewRegions.Count} " +
            $"readiness={diagnostics.Quality.Readiness} trackEvents={result.Arrangement.Track.Events.Count} " +
            $"trackDurationMs={result.Arrangement.Track.TimelineDuration.TotalMilliseconds:0}");
    }

    public void Cancelled(AudioToPianoTranscriptionStage? stage, double fraction)
        => Write(
            "operation-cancelled",
            $"elapsedMs={elapsed.Elapsed.TotalMilliseconds:0} stage={stage?.ToString() ?? "none"} fraction={fraction:0.000}");

    public void Failed(Exception exception, AudioToPianoTranscriptionStage? stage, double fraction)
    {
        ArgumentNullException.ThrowIfNull(exception);
        var text = exception.ToString();
        if (!string.IsNullOrWhiteSpace(sourceFileName))
        {
            // Exception messages from decoders commonly contain the full source path. Keep the
            // useful filename while preventing the user's profile/directory path from leaking.
            text = RedactLikelySourcePath(text, sourceFileName);
        }

        Write(
            "operation-failed",
            $"elapsedMs={elapsed.Elapsed.TotalMilliseconds:0} stage={stage?.ToString() ?? "none"} " +
            $"fraction={fraction:0.000} exception={Quote(text)}");
    }

    public void Dispose()
    {
        if (disposed)
            return;
        disposed = true;
        elapsed.Stop();
    }

    private void Write(string eventName, string? details)
    {
        try
        {
            var memory = CaptureMemory();
            var line =
                $"{DateTimeOffset.UtcNow:O} op={operationId} event={eventName} elapsedMs={elapsed.Elapsed.TotalMilliseconds:0} " +
                $"managedMiB={memory.ManagedMiB:0.0} workingSetMiB={memory.WorkingSetMiB:0.0} privateMiB={memory.PrivateMiB:0.0}" +
                (string.IsNullOrWhiteSpace(details) ? string.Empty : " " + details) + Environment.NewLine;

            lock (FileGate)
            {
                var path = LogPath;
                var directory = Path.GetDirectoryName(path)!;
                Directory.CreateDirectory(directory);
                RotateIfNeeded(path);

                var bytes = new UTF8Encoding(encoderShouldEmitUTF8Identifier: false).GetBytes(line);
                using var stream = new FileStream(
                    path,
                    FileMode.Append,
                    FileAccess.Write,
                    FileShare.ReadWrite | FileShare.Delete,
                    bufferSize: 4096,
                    FileOptions.WriteThrough);
                stream.Write(bytes, 0, bytes.Length);
                stream.Flush(flushToDisk: true);
            }
        }
        catch
        {
            // Diagnostics must never turn a recoverable audio problem into a client failure.
        }
    }

    private static void RotateIfNeeded(string path)
    {
        if (!File.Exists(path) || new FileInfo(path).Length < MaximumLogBytes)
            return;

        var previous = Path.Combine(Path.GetDirectoryName(path)!, "create-piano.previous.log");
        File.Move(path, previous, overwrite: true);
    }

    private static (double ManagedMiB, double WorkingSetMiB, double PrivateMiB) CaptureMemory()
    {
        const double divisor = 1024d * 1024d;
        try
        {
            using var process = Process.GetCurrentProcess();
            return (
                GC.GetTotalMemory(forceFullCollection: false) / divisor,
                process.WorkingSet64 / divisor,
                process.PrivateMemorySize64 / divisor);
        }
        catch
        {
            return (GC.GetTotalMemory(forceFullCollection: false) / divisor, -1d, -1d);
        }
    }

    private static long TryGetLength(string path)
    {
        try
        {
            return new FileInfo(path).Length;
        }
        catch
        {
            return -1;
        }
    }

    private static string SafeFileName(string path)
    {
        try
        {
            return Path.GetFileName(path);
        }
        catch
        {
            return "(invalid-path)";
        }
    }

    private static string RedactLikelySourcePath(string text, string fileName)
    {
        var index = text.IndexOf(fileName, StringComparison.OrdinalIgnoreCase);
        while (index > 0)
        {
            var start = index - 1;
            while (start >= 0 && text[start] is not '\r' and not '\n' and not '\'' and not '"' and not ' ')
                start--;
            var prefixLength = index - (start + 1);
            if (prefixLength > 0)
                text = text.Remove(start + 1, prefixLength);
            index = text.IndexOf(fileName, index + fileName.Length, StringComparison.OrdinalIgnoreCase);
        }
        return text;
    }

    private static string Quote(string? value)
    {
        if (value is null)
            return "\"\"";
        var normalized = value
            .Replace("\\", "\\\\", StringComparison.Ordinal)
            .Replace("\r", "\\r", StringComparison.Ordinal)
            .Replace("\n", "\\n", StringComparison.Ordinal)
            .Replace("\"", "\\\"", StringComparison.Ordinal);
        return $"\"{normalized}\"";
    }
}