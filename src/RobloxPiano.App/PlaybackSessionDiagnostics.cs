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

internal static class PlaybackSessionDiagnostics
{
    internal const string SchemaVersion = "1";
    private const int MaxSessionFiles = 30;
    private static readonly object Gate = new();
    private static readonly JsonSerializerOptions JsonOptions = new()
    {
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
        WriteIndented = false
    };

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
