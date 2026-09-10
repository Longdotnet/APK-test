using RobloxPiano.Core;

namespace RobloxPiano.App;

/// <summary>
/// Immutable diagnostics provenance captured before a live playback session starts.
/// Playback truth does not depend on this snapshot; it exists only so support/A-B
/// evidence cannot silently drift when client preferences or Roblox process state
/// changes while a song is running.
/// </summary>
internal sealed record PlaybackSessionProvenanceSnapshot(
    ClientState ClientState,
    int? RobloxProcessId,
    long? RobloxProcessStartTimeUtcTicks,
    string PlaybackEngine,
    string InputProfile);

internal static class PlaybackSessionProvenance
{
    private const int MaxSessionFiles = 30;
    private static readonly object Gate = new();

    internal static PlaybackSessionProvenanceSnapshot? TryCapture()
    {
        try
        {
            return new PlaybackSessionProvenanceSnapshot(
                ClientStateStore.Load(),
                RobloxPlaybackLaunchAuthorization.AuthorizedProcessIdForTests,
                RobloxPlaybackLaunchAuthorization.AuthorizedProcessStartTimeUtcTicksForTests,
                PlaybackRuntimeIdentity.Engine,
                PlaybackRuntimeIdentity.InputProfile);
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Playback session provenance could not be snapshotted: {exception.Message}");
            return null;
        }
    }

    internal static PlaybackSessionDiagnosticRecord CreateRecord(
        PlaybackSessionResult result,
        PlaybackSessionProvenanceSnapshot snapshot,
        DateTimeOffset startedAtUtc,
        DateTimeOffset endedAtUtc,
        string sessionId,
        PlaybackTransportQualityReport? quality)
    {
        ArgumentNullException.ThrowIfNull(result);
        ArgumentNullException.ThrowIfNull(snapshot);

        var record = PlaybackSessionDiagnostics.CreateRecord(
            result,
            snapshot.ClientState,
            snapshot.RobloxProcessId,
            snapshot.RobloxProcessStartTimeUtcTicks,
            startedAtUtc,
            endedAtUtc,
            sessionId,
            quality);

        // Engine/input profile are compile-time runtime identities today, but keep the
        // snapshot authoritative so a future selectable engine/profile cannot make old
        // session provenance depend on end-of-run global state.
        return record with
        {
            PlaybackEngine = snapshot.PlaybackEngine,
            InputProfile = snapshot.InputProfile
        };
    }

    internal static void Persist(
        PlaybackSessionResult result,
        PlaybackSessionProvenanceSnapshot? snapshot,
        DateTimeOffset startedAtUtc,
        DateTimeOffset endedAtUtc,
        PlaybackTransportQualityReport? quality)
    {
        ArgumentNullException.ThrowIfNull(result);

        if (snapshot is null)
        {
            PlaybackSessionDiagnostics.Persist(result, startedAtUtc, endedAtUtc, quality);
            return;
        }

        try
        {
            var record = CreateRecord(
                result,
                snapshot,
                startedAtUtc,
                endedAtUtc,
                Guid.NewGuid().ToString("N"),
                quality);

            lock (Gate)
            {
                Directory.CreateDirectory(ClientDiagnostics.DirectoryPath);
                var path = Path.Combine(
                    ClientDiagnostics.DirectoryPath,
                    $"sessions-{endedAtUtc.UtcDateTime:yyyyMMdd}.jsonl");
                PlaybackSessionDiagnostics.AppendRecord(path, record);
                TrimOldSessionFiles(ClientDiagnostics.DirectoryPath);

                PlaybackSessionDiagnostics.CreateSupportBundle(
                    ClientDiagnostics.DirectoryPath,
                    PlaybackSessionDiagnostics.SupportBundlePath,
                    endedAtUtc);

                if (!PlaybackSessionDiagnostics.VerifySupportBundle(
                        PlaybackSessionDiagnostics.SupportBundlePath,
                        out var verificationError))
                {
                    ClientDiagnostics.Log($"Latest support bundle failed post-write verification: {verificationError}");
                }
            }
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or System.Text.Json.JsonException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Captured playback session diagnostics could not be persisted: {exception.Message}");
        }
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
