using System.Diagnostics;
using System.Runtime.InteropServices;
using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Audio;

/// <summary>
/// Crash-resilient, privacy-aware diagnostics for Create Piano Version.
/// Each creation attempt gets one append-only log file. Every line is flushed by the filesystem
/// append boundary so a native/process crash still leaves the last successfully observed stage.
/// Audio bytes are never copied into diagnostics and full local paths are never written.
/// </summary>
public static class AudioToPianoDiagnostics
{
    private const int MaxRetainedLogs = 30;
    private static readonly object Gate = new();
    private static string? currentLogPath;

    public static string DirectoryPath => Path.Combine(
        Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
        "RobloxPiano",
        "diagnostics",
        "create-piano");

    public static string? CurrentLogPath
    {
        get
        {
            lock (Gate)
                return currentLogPath;
        }
    }

    public static AudioToPianoDiagnosticSession Start(
        string sourcePath,
        string? title = null,
        string? directoryOverride = null)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        var directory = string.IsNullOrWhiteSpace(directoryOverride)
            ? DirectoryPath
            : Path.GetFullPath(directoryOverride);
        Directory.CreateDirectory(directory);
        TrimOldLogs(directory);

        var now = DateTimeOffset.UtcNow;
        var sessionId = Guid.NewGuid().ToString("N")[..12];
        var path = Path.Combine(
            directory,
            $"create-piano-{now:yyyyMMdd-HHmmss-fff}-{sessionId}.log");
        var session = new AudioToPianoDiagnosticSession(path, sessionId, sourcePath, title, now);
        lock (Gate)
            currentLogPath = path;
        return session;
    }

    /// <summary>
    /// Best-effort emergency append used by process/UI exception handlers. If a creation job is
    /// active, evidence is appended to that job's file; otherwise a standalone crash log is made.
    /// This method must never throw while the process is already failing.
    /// </summary>
    public static void LogUnhandled(string scope, Exception? exception, object? rawException = null)
    {
        try
        {
            string path;
            lock (Gate)
            {
                path = currentLogPath ?? Path.Combine(
                    DirectoryPath,
                    $"create-piano-process-{DateTimeOffset.UtcNow:yyyyMMdd-HHmmss-fff}-{Guid.NewGuid():N}.log");
            }

            Directory.CreateDirectory(Path.GetDirectoryName(path)!);
            var message = exception?.ToString() ?? rawException?.ToString() ?? "Unknown unhandled failure";
            AppendLine(path,
                $"{DateTimeOffset.UtcNow:O} | event=unhandled | scope={Escape(scope)} | " +
                $"exception={Escape(Sanitize(message))} | {MemoryFields()}");
        }
        catch
        {
            // Diagnostics must never become a second failure while the process is already failing.
        }
    }

    internal static void ClearCurrent(string path)
    {
        lock (Gate)
        {
            if (string.Equals(currentLogPath, path, StringComparison.OrdinalIgnoreCase))
                currentLogPath = null;
        }
    }

    internal static string Sanitize(string value)
    {
        if (string.IsNullOrEmpty(value))
            return value;

        var sanitized = value;
        var userProfile = Environment.GetFolderPath(Environment.SpecialFolder.UserProfile);
        if (!string.IsNullOrWhiteSpace(userProfile))
            sanitized = sanitized.Replace(userProfile, "%USERPROFILE%", StringComparison.OrdinalIgnoreCase);
        var localAppData = Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData);
        if (!string.IsNullOrWhiteSpace(localAppData))
            sanitized = sanitized.Replace(localAppData, "%LOCALAPPDATA%", StringComparison.OrdinalIgnoreCase);
        return sanitized;
    }

    internal static void AppendLine(string path, string line)
    {
        File.AppendAllText(path, line + Environment.NewLine, new UTF8Encoding(encoderShouldEmitUTF8Identifier: false));
    }

    internal static string Escape(string? value)
    {
        if (string.IsNullOrEmpty(value))
            return "-";
        return value
            .Replace("\\", "\\\\", StringComparison.Ordinal)
            .Replace("\r", "\\r", StringComparison.Ordinal)
            .Replace("\n", "\\n", StringComparison.Ordinal)
            .Replace("|", "\\|", StringComparison.Ordinal);
    }

    internal static string MemoryFields()
    {
        var managedMb = GC.GetTotalMemory(forceFullCollection: false) / 1024d / 1024d;
        double workingSetMb;
        try
        {
            workingSetMb = Environment.WorkingSet / 1024d / 1024d;
        }
        catch
        {
            workingSetMb = -1d;
        }
        return $"managedMB={managedMb:0.0} | workingSetMB={workingSetMb:0.0}";
    }

    private static void TrimOldLogs(string directory)
    {
        try
        {
            foreach (var old in Directory
                         .EnumerateFiles(directory, "create-piano-*.log", SearchOption.TopDirectoryOnly)
                         .OrderByDescending(File.GetLastWriteTimeUtc)
                         .Skip(MaxRetainedLogs - 1))
            {
                try
                {
                    File.Delete(old);
                }
                catch (IOException)
                {
                }
                catch (UnauthorizedAccessException)
                {
                }
            }
        }
        catch (IOException)
        {
        }
        catch (UnauthorizedAccessException)
        {
        }
    }
}

public sealed class AudioToPianoDiagnosticSession : IDisposable
{
    private readonly Stopwatch stopwatch = Stopwatch.StartNew();
    private readonly string sessionId;
    private bool disposed;

    internal AudioToPianoDiagnosticSession(
        string logPath,
        string sessionId,
        string sourcePath,
        string? title,
        DateTimeOffset startedAtUtc)
    {
        LogPath = Path.GetFullPath(logPath);
        this.sessionId = sessionId;

        var fullPath = Path.GetFullPath(sourcePath);
        var fileName = Path.GetFileName(fullPath);
        var extension = Path.GetExtension(fullPath);
        var pathHash = Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(fullPath))).ToLowerInvariant()[..16];
        long bytes = -1;
        DateTime lastWriteUtc = default;
        try
        {
            var info = new FileInfo(fullPath);
            if (info.Exists)
            {
                bytes = info.Length;
                lastWriteUtc = info.LastWriteTimeUtc;
            }
        }
        catch (IOException)
        {
        }
        catch (UnauthorizedAccessException)
        {
        }

        WriteRaw(
            $"{startedAtUtc:O} | event=session-start | session={sessionId} | " +
            $"clientVersion={Escape(typeof(AudioToPianoDiagnostics).Assembly.GetName().Version?.ToString())} | " +
            $"runtime={Escape(RuntimeInformation.FrameworkDescription)} | os={Escape(RuntimeInformation.OSDescription)} | " +
            $"osArch={RuntimeInformation.OSArchitecture} | processArch={RuntimeInformation.ProcessArchitecture} | " +
            $"processorCount={Environment.ProcessorCount} | serverGC={System.Runtime.GCSettings.IsServerGC} | " +
            $"sourceFile={Escape(fileName)} | extension={Escape(extension)} | sourceBytes={bytes} | " +
            $"sourceLastWriteUtc={(lastWriteUtc == default ? "-" : lastWriteUtc.ToString("O"))} | pathHash={pathHash} | " +
            $"title={Escape(title)} | {MemoryFields()}");
    }

    public string LogPath { get; }

    public void Write(string eventName, string? details = null)
    {
        if (disposed)
            return;
        WriteRaw(
            $"{DateTimeOffset.UtcNow:O} | event={Escape(eventName)} | session={sessionId} | " +
            $"elapsedMs={stopwatch.Elapsed.TotalMilliseconds:0} | details={Escape(Sanitize(details ?? string.Empty))} | {MemoryFields()}");
    }

    public void WriteProgress(AudioToPianoClientJobSnapshot snapshot)
    {
        ArgumentNullException.ThrowIfNull(snapshot);
        if (disposed)
            return;
        WriteRaw(
            $"{DateTimeOffset.UtcNow:O} | event=progress | session={sessionId} | elapsedMs={stopwatch.Elapsed.TotalMilliseconds:0} | " +
            $"state={snapshot.State} | stage={(snapshot.Stage?.ToString() ?? "-")} | fraction={snapshot.Fraction:0.0000} | " +
            $"message={Escape(Sanitize(snapshot.Message))} | {MemoryFields()}");
    }

    public void WriteFailure(Exception exception, AudioToPianoClientJobSnapshot? snapshot = null, string eventName = "failure")
    {
        ArgumentNullException.ThrowIfNull(exception);
        if (disposed)
            return;
        var state = snapshot?.State.ToString() ?? "-";
        var stage = snapshot?.Stage?.ToString() ?? "-";
        var fraction = snapshot?.Fraction ?? 0d;
        WriteRaw(
            $"{DateTimeOffset.UtcNow:O} | event={Escape(eventName)} | session={sessionId} | elapsedMs={stopwatch.Elapsed.TotalMilliseconds:0} | " +
            $"state={state} | stage={stage} | fraction={fraction:0.0000} | exceptionType={Escape(exception.GetType().FullName)} | " +
            $"exception={Escape(Sanitize(exception.ToString()))} | {MemoryFields()}");
    }

    public void WriteCompleted(AudioToPianoTranscriptionDiagnostics diagnostics)
    {
        ArgumentNullException.ThrowIfNull(diagnostics);
        Write(
            "completed",
            $"duration={diagnostics.SourceDuration}; sourceSamples={diagnostics.SourceSamples}; inferenceFrames={diagnostics.InferenceFrames}; " +
            $"decodedNotes={diagnostics.DecodedNotes}; retainedNotes={diagnostics.NotesAfterSuppression}; reviewRegions={diagnostics.ReviewRegions.Count}; " +
            $"readiness={diagnostics.Quality.Readiness}; totalElapsedMs={diagnostics.TotalElapsed.TotalMilliseconds:0}");
    }

    public void Dispose()
    {
        if (disposed)
            return;
        Write("session-end", $"totalElapsedMs={stopwatch.Elapsed.TotalMilliseconds:0}");
        disposed = true;
        AudioToPianoDiagnostics.ClearCurrent(LogPath);
    }

    private void WriteRaw(string line)
    {
        try
        {
            AudioToPianoDiagnostics.AppendLine(LogPath, line);
        }
        catch (IOException)
        {
        }
        catch (UnauthorizedAccessException)
        {
        }
        catch (NotSupportedException)
        {
        }
    }

    private static string Escape(string? value) => AudioToPianoDiagnostics.Escape(value);
    private static string Sanitize(string value) => AudioToPianoDiagnostics.Sanitize(value);
    private static string MemoryFields() => AudioToPianoDiagnostics.MemoryFields();
}
