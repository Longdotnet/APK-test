using System.IO.Compression;
using System.Text;
using System.Text.Json;

namespace RobloxPiano.App;

internal sealed record PlaybackSessionDiagnosticRecord(
    string SchemaVersion,
    string SessionId,
    DateTimeOffset StartedAtUtc,
    DateTimeOffset EndedAtUtc,
    string ResultKind,
    double PositionSeconds,
    string? AuthorizationFailure,
    string? SourcePath,
    string SourceType,
    double PreferredSpeed,
    int InputLatencyMs,
    int? RobloxProcessId,
    long? RobloxProcessStartTimeUtcTicks,
    string? ExceptionType,
    string? ExceptionMessage,
    string ClientVersion);

internal sealed record PlaybackSupportSession(
    string SessionId,
    DateTimeOffset StartedAtUtc,
    DateTimeOffset EndedAtUtc,
    string ResultKind,
    double PositionSeconds,
    string? AuthorizationFailure,
    string? SourceFileName,
    string SourceType,
    double PreferredSpeed,
    int InputLatencyMs,
    int? RobloxProcessId,
    long? RobloxProcessStartTimeUtcTicks,
    string? ExceptionType,
    string? ExceptionMessage);

internal sealed record PlaybackSupportBundleDocument(
    string SchemaVersion,
    DateTimeOffset GeneratedAtUtc,
    string ClientVersion,
    int SessionCount,
    IReadOnlyList<PlaybackSupportSession> Sessions);

internal static class PlaybackSessionDiagnostics
{
    internal const string SchemaVersion = "1";
    internal const string SupportBundleSchemaVersion = "1";
    internal const int MaxSupportSessions = 20;
    private const int MaxSessionFiles = 30;
    private const int MaxSupportExceptionMessageLength = 500;
    private static readonly object Gate = new();
    private static readonly JsonSerializerOptions JsonOptions = new()
    {
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
        WriteIndented = false
    };
    private static readonly JsonSerializerOptions SupportJsonOptions = new(JsonOptions)
    {
        WriteIndented = true
    };

    public static string SupportBundlePath => Path.Combine(
        ClientDiagnostics.DirectoryPath,
        "RobloxPiano-support-latest.zip");

    public static void Persist(
        PlaybackSessionResult result,
        DateTimeOffset startedAtUtc,
        DateTimeOffset endedAtUtc)
    {
        ArgumentNullException.ThrowIfNull(result);

        try
        {
            var state = ClientStateStore.Load();
            var record = CreateRecord(
                result,
                state,
                RobloxPlaybackLaunchAuthorization.AuthorizedProcessIdForTests,
                RobloxPlaybackLaunchAuthorization.AuthorizedProcessStartTimeUtcTicksForTests,
                startedAtUtc,
                endedAtUtc,
                Guid.NewGuid().ToString("N"));

            lock (Gate)
            {
                Directory.CreateDirectory(ClientDiagnostics.DirectoryPath);
                var path = Path.Combine(
                    ClientDiagnostics.DirectoryPath,
                    $"sessions-{endedAtUtc.UtcDateTime:yyyyMMdd}.jsonl");
                AppendRecord(path, record);
                TrimOldSessionFiles(ClientDiagnostics.DirectoryPath);
                TryRefreshSupportBundle(ClientDiagnostics.DirectoryPath, SupportBundlePath, endedAtUtc);
            }
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or JsonException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Structured session diagnostics could not be persisted: {exception.Message}");
        }
    }

    internal static PlaybackSessionDiagnosticRecord CreateRecord(
        PlaybackSessionResult result,
        ClientState state,
        int? robloxProcessId,
        long? robloxProcessStartTimeUtcTicks,
        DateTimeOffset startedAtUtc,
        DateTimeOffset endedAtUtc,
        string sessionId)
    {
        ArgumentNullException.ThrowIfNull(result);
        ArgumentNullException.ThrowIfNull(state);
        ArgumentException.ThrowIfNullOrWhiteSpace(sessionId);

        if (endedAtUtc < startedAtUtc)
        {
            throw new ArgumentException("Playback session end time cannot precede its start time.", nameof(endedAtUtc));
        }

        var sourcePath = string.IsNullOrWhiteSpace(state.LastSheetPath)
            ? null
            : Path.GetFullPath(state.LastSheetPath);

        return new PlaybackSessionDiagnosticRecord(
            SchemaVersion,
            sessionId,
            startedAtUtc.ToUniversalTime(),
            endedAtUtc.ToUniversalTime(),
            result.Kind.ToString(),
            Math.Max(0d, result.Position.TotalSeconds),
            result.AuthorizationFailure?.ToString(),
            sourcePath,
            GetSourceType(sourcePath),
            state.PreferredSpeed,
            state.InputLatencyMs,
            robloxProcessId,
            robloxProcessStartTimeUtcTicks,
            result.Exception?.GetType().FullName,
            result.Exception?.Message,
            typeof(PlaybackSessionDiagnostics).Assembly.GetName().Version?.ToString() ?? "unknown");
    }

    internal static void AppendRecord(string path, PlaybackSessionDiagnosticRecord record)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        ArgumentNullException.ThrowIfNull(record);

        var directory = Path.GetDirectoryName(path);
        if (!string.IsNullOrWhiteSpace(directory))
        {
            Directory.CreateDirectory(directory);
        }

        var json = JsonSerializer.Serialize(record, JsonOptions);
        File.AppendAllText(path, json + Environment.NewLine);
    }

    internal static PlaybackSessionDiagnosticRecord DeserializeRecord(string json)
        => JsonSerializer.Deserialize<PlaybackSessionDiagnosticRecord>(json, JsonOptions)
           ?? throw new JsonException("Structured playback-session diagnostic record is empty.");

    internal static IReadOnlyList<PlaybackSessionDiagnosticRecord> ReadRecentRecords(
        string directory,
        int maxRecords = MaxSupportSessions)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(directory);
        if (maxRecords <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(maxRecords));
        }

        if (!Directory.Exists(directory))
        {
            return Array.Empty<PlaybackSessionDiagnosticRecord>();
        }

        var recent = new List<PlaybackSessionDiagnosticRecord>(maxRecords * 2);
        var files = Directory
            .EnumerateFiles(directory, "sessions-*.jsonl", SearchOption.TopDirectoryOnly)
            .OrderByDescending(Path.GetFileName, StringComparer.OrdinalIgnoreCase);

        foreach (var file in files)
        {
            var newestInFile = new Queue<PlaybackSessionDiagnosticRecord>(maxRecords);
            try
            {
                foreach (var line in File.ReadLines(file))
                {
                    if (string.IsNullOrWhiteSpace(line))
                    {
                        continue;
                    }

                    try
                    {
                        newestInFile.Enqueue(DeserializeRecord(line));
                        if (newestInFile.Count > maxRecords)
                        {
                            _ = newestInFile.Dequeue();
                        }
                    }
                    catch (JsonException)
                    {
                        // Power loss or an interrupted append may leave one malformed JSONL line.
                        // Support collection must preserve the remaining valid evidence.
                    }
                }
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
            {
                ClientDiagnostics.Log($"Session diagnostic file could not be read for support bundle: {exception.Message}");
                continue;
            }

            recent.AddRange(newestInFile);
            if (recent.Count >= maxRecords)
            {
                break;
            }
        }

        return recent
            .OrderByDescending(record => record.EndedAtUtc)
            .ThenByDescending(record => record.SessionId, StringComparer.Ordinal)
            .Take(maxRecords)
            .ToArray();
    }

    internal static PlaybackSupportBundleDocument CreateSupportDocument(
        IReadOnlyList<PlaybackSessionDiagnosticRecord> records,
        DateTimeOffset generatedAtUtc)
    {
        ArgumentNullException.ThrowIfNull(records);

        var sessions = records
            .OrderByDescending(record => record.EndedAtUtc)
            .Take(MaxSupportSessions)
            .Select(record => new PlaybackSupportSession(
                record.SessionId,
                record.StartedAtUtc,
                record.EndedAtUtc,
                record.ResultKind,
                record.PositionSeconds,
                record.AuthorizationFailure,
                GetSupportSourceFileName(record.SourcePath),
                record.SourceType,
                record.PreferredSpeed,
                record.InputLatencyMs,
                record.RobloxProcessId,
                record.RobloxProcessStartTimeUtcTicks,
                record.ExceptionType,
                SanitizeExceptionMessage(record.ExceptionMessage, record.SourcePath)))
            .ToArray();

        return new PlaybackSupportBundleDocument(
            SupportBundleSchemaVersion,
            generatedAtUtc.ToUniversalTime(),
            typeof(PlaybackSessionDiagnostics).Assembly.GetName().Version?.ToString() ?? "unknown",
            sessions.Length,
            sessions);
    }

    internal static void CreateSupportBundle(
        string diagnosticsDirectory,
        string destinationPath,
        DateTimeOffset generatedAtUtc)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(diagnosticsDirectory);
        ArgumentException.ThrowIfNullOrWhiteSpace(destinationPath);

        var records = ReadRecentRecords(diagnosticsDirectory, MaxSupportSessions);
        var document = CreateSupportDocument(records, generatedAtUtc);
        var destinationDirectory = Path.GetDirectoryName(destinationPath);
        if (!string.IsNullOrWhiteSpace(destinationDirectory))
        {
            Directory.CreateDirectory(destinationDirectory);
        }

        var temporaryPath = destinationPath + ".tmp-" + Guid.NewGuid().ToString("N");
        try
        {
            using (var stream = new FileStream(temporaryPath, FileMode.CreateNew, FileAccess.ReadWrite, FileShare.None))
            using (var archive = new ZipArchive(stream, ZipArchiveMode.Create, leaveOpen: false))
            {
                var supportEntry = archive.CreateEntry("support.json", CompressionLevel.Optimal);
                using (var writer = new StreamWriter(supportEntry.Open(), new UTF8Encoding(encoderShouldEmitUTF8Identifier: false)))
                {
                    writer.Write(JsonSerializer.Serialize(document, SupportJsonOptions));
                }

                var readmeEntry = archive.CreateEntry("README.txt", CompressionLevel.Optimal);
                using var readme = new StreamWriter(readmeEntry.Open(), new UTF8Encoding(encoderShouldEmitUTF8Identifier: false));
                readme.WriteLine("Roblox Piano support bundle");
                readme.WriteLine("Generated automatically from recent local playback-session diagnostics.");
                readme.WriteLine("The bundle intentionally excludes full local sheet paths and raw log files.");
                readme.WriteLine($"Sessions included: {document.SessionCount}");
            }

            File.Move(temporaryPath, destinationPath, overwrite: true);
        }
        finally
        {
            if (File.Exists(temporaryPath))
            {
                File.Delete(temporaryPath);
            }
        }
    }

    private static void TryRefreshSupportBundle(
        string diagnosticsDirectory,
        string destinationPath,
        DateTimeOffset generatedAtUtc)
    {
        try
        {
            CreateSupportBundle(diagnosticsDirectory, destinationPath, generatedAtUtc);
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or JsonException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Latest support bundle could not be refreshed: {exception.Message}");
        }
    }

    private static string? GetSupportSourceFileName(string? sourcePath)
    {
        if (string.IsNullOrWhiteSpace(sourcePath))
        {
            return null;
        }

        try
        {
            return Path.GetFileName(sourcePath);
        }
        catch (ArgumentException)
        {
            return null;
        }
    }

    private static string? SanitizeExceptionMessage(string? message, string? sourcePath)
    {
        if (string.IsNullOrWhiteSpace(message))
        {
            return null;
        }

        var sanitized = message;
        if (!string.IsNullOrWhiteSpace(sourcePath))
        {
            sanitized = sanitized.Replace(sourcePath, GetSupportSourceFileName(sourcePath) ?? "<sheet>", StringComparison.OrdinalIgnoreCase);
        }

        var userProfile = Environment.GetFolderPath(Environment.SpecialFolder.UserProfile);
        if (!string.IsNullOrWhiteSpace(userProfile))
        {
            sanitized = sanitized.Replace(userProfile, "%USERPROFILE%", StringComparison.OrdinalIgnoreCase);
        }

        sanitized = sanitized.Replace('\r', ' ').Replace('\n', ' ').Trim();
        return sanitized.Length <= MaxSupportExceptionMessageLength
            ? sanitized
            : sanitized[..MaxSupportExceptionMessageLength] + "…";
    }

    private static string GetSourceType(string? sourcePath)
    {
        if (string.IsNullOrWhiteSpace(sourcePath))
        {
            return "Unknown";
        }

        return Path.GetExtension(sourcePath).ToLowerInvariant() switch
        {
            ".mid" or ".midi" => "MIDI",
            ".musicxml" or ".xml" => "MusicXML",
            ".vps" => "VPS",
            ".txt" => "TXT",
            _ => "Unknown"
        };
    }

    private static void TrimOldSessionFiles(string directory)
    {
        var files = Directory
            .EnumerateFiles(directory, "sessions-*.jsonl", SearchOption.TopDirectoryOnly)
            .OrderByDescending(File.GetLastWriteTimeUtc)
            .Skip(MaxSessionFiles)
            .ToArray();

        foreach (var file in files)
        {
            try
            {
                File.Delete(file);
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
            {
                ClientDiagnostics.Log($"Old session diagnostic file could not be removed: {exception.Message}");
            }
        }
    }
}
