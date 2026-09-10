using System.Text.Json;
using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed record PlaybackBaselineCampaign(
    string CampaignId,
    DateTimeOffset CreatedAtUtc,
    DateTimeOffset ExpiresAtUtc,
    string CanonicalSourceFingerprint,
    string SourceType,
    int InputLatencyMs,
    string PlaybackEngine,
    string InputProfile)
{
    public bool IsExpired(DateTimeOffset nowUtc) => nowUtc.ToUniversalTime() > ExpiresAtUtc;
}

internal sealed record PlaybackBaselineCampaignStartResult(
    bool Success,
    string Summary,
    PlaybackBaselineCampaign? Campaign = null);

/// <summary>
/// Persists an explicit, privacy-safe Legacy ↔ Legacy x2 reproduction campaign.
/// The campaign never owns playback truth or mutates transport state. It only tags
/// sessions that exactly match the immutable canonical/runtime conditions captured
/// when the client deliberately starts a reproduction from Support Center.
/// </summary>
internal static class PlaybackBaselineCampaignStore
{
    internal static readonly TimeSpan Lifetime = TimeSpan.FromMinutes(30);
    internal const string SessionIdPrefix = "baseline-";
    private const string StateFileName = "legacy-baseline-campaign.json";
    private static readonly object Gate = new();
    private static readonly JsonSerializerOptions JsonOptions = new()
    {
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
        WriteIndented = true
    };

    internal static string StatePath => Path.Combine(ClientDiagnostics.DirectoryPath, StateFileName);

    internal static PlaybackBaselineCampaignStartResult StartFromCurrentClientState(DateTimeOffset nowUtc)
    {
        try
        {
            var state = ClientStateStore.Load();
            if (string.IsNullOrWhiteSpace(state.LastSheetPath) || !File.Exists(state.LastSheetPath))
            {
                return new(false, "Choose a TXT/VPS song in the Sheet Library before starting a Legacy A/B campaign.");
            }

            var fullPath = Path.GetFullPath(state.LastSheetPath);
            var sourceType = GetSourceType(fullPath);
            if (sourceType is null)
            {
                return new(false, "Legacy reproduction campaigns intentionally support TXT/VPS only. MIDI and MusicXML are outside the protected Legacy baseline.");
            }

            var loaded = SongSourceLoader.Load(fullPath);
            var fingerprint = PerformanceTrackFingerprint.ComputeSha256(loaded.Track);
            var createdAt = nowUtc.ToUniversalTime();
            var campaign = new PlaybackBaselineCampaign(
                Guid.NewGuid().ToString("N"),
                createdAt,
                createdAt + Lifetime,
                fingerprint,
                sourceType,
                state.InputLatencyMs,
                PlaybackRuntimeIdentity.Engine,
                PlaybackRuntimeIdentity.InputProfile);

            Persist(campaign);
            return new(
                true,
                "Campaign started. Run this unchanged song at Legacy 1.00x, then Legacy x2 2.00x. Keep the same input-latency setting and do not change seek/speed history between the paired runs except for the exact 2x scaling.",
                campaign);
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or FormatException
            or ArgumentException
            or OverflowException
            or JsonException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Legacy baseline campaign could not be started: {exception.Message}");
            return new(false, $"Campaign could not be started: {exception.Message}");
        }
    }

    internal static PlaybackBaselineCampaign? LoadActive(DateTimeOffset nowUtc)
    {
        lock (Gate)
        {
            try
            {
                if (!File.Exists(StatePath))
                {
                    return null;
                }

                var json = File.ReadAllText(StatePath);
                var campaign = JsonSerializer.Deserialize<PlaybackBaselineCampaign>(json, JsonOptions);
                if (campaign is null || !IsValid(campaign) || campaign.IsExpired(nowUtc))
                {
                    TryDeleteStateFile();
                    return null;
                }

                return campaign;
            }
            catch (Exception exception) when (
                exception is IOException
                or UnauthorizedAccessException
                or ArgumentException
                or JsonException
                or NotSupportedException)
            {
                ClientDiagnostics.Log($"Legacy baseline campaign state could not be read: {exception.Message}");
                return null;
            }
        }
    }

    internal static void Cancel()
    {
        lock (Gate)
        {
            TryDeleteStateFile();
        }
    }

    internal static string CreateSessionIdForSnapshot(
        PlaybackSessionProvenanceSnapshot snapshot,
        DateTimeOffset nowUtc)
    {
        ArgumentNullException.ThrowIfNull(snapshot);

        var campaign = LoadActive(nowUtc);
        if (campaign is null || !MatchesSnapshot(campaign, snapshot))
        {
            return Guid.NewGuid().ToString("N");
        }

        return $"{SessionIdPrefix}{campaign.CampaignId}-{Guid.NewGuid():N}";
    }

    internal static string? TryGetCampaignId(string? sessionId)
    {
        if (string.IsNullOrWhiteSpace(sessionId)
            || !sessionId.StartsWith(SessionIdPrefix, StringComparison.Ordinal))
        {
            return null;
        }

        var start = SessionIdPrefix.Length;
        var separator = sessionId.IndexOf('-', start);
        if (separator <= start)
        {
            return null;
        }

        var campaignId = sessionId[start..separator];
        return campaignId.Length == 32 && Guid.TryParseExact(campaignId, "N", out _)
            ? campaignId
            : null;
    }

    internal static bool MatchesSnapshot(
        PlaybackBaselineCampaign campaign,
        PlaybackSessionProvenanceSnapshot snapshot)
    {
        ArgumentNullException.ThrowIfNull(campaign);
        ArgumentNullException.ThrowIfNull(snapshot);

        var state = snapshot.ClientState;
        if (string.IsNullOrWhiteSpace(state.LastSheetPath)
            || state.InputLatencyMs != campaign.InputLatencyMs
            || !string.Equals(snapshot.PlaybackEngine, campaign.PlaybackEngine, StringComparison.Ordinal)
            || !string.Equals(snapshot.InputProfile, campaign.InputProfile, StringComparison.Ordinal)
            || !IsProtectedBaselineSpeed(state.PreferredSpeed))
        {
            return false;
        }

        try
        {
            var fullPath = Path.GetFullPath(state.LastSheetPath);
            var sourceType = GetSourceType(fullPath);
            if (!string.Equals(sourceType, campaign.SourceType, StringComparison.OrdinalIgnoreCase))
            {
                return false;
            }

            var loaded = SongSourceLoader.Load(fullPath);
            var fingerprint = PerformanceTrackFingerprint.ComputeSha256(loaded.Track);
            return string.Equals(fingerprint, campaign.CanonicalSourceFingerprint, StringComparison.OrdinalIgnoreCase);
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or FormatException
            or ArgumentException
            or OverflowException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Legacy baseline campaign identity check failed closed: {exception.Message}");
            return false;
        }
    }

    private static void Persist(PlaybackBaselineCampaign campaign)
    {
        lock (Gate)
        {
            Directory.CreateDirectory(ClientDiagnostics.DirectoryPath);
            var temporaryPath = StatePath + ".tmp-" + Guid.NewGuid().ToString("N");
            try
            {
                File.WriteAllText(temporaryPath, JsonSerializer.Serialize(campaign, JsonOptions));
                File.Move(temporaryPath, StatePath, overwrite: true);
            }
            finally
            {
                if (File.Exists(temporaryPath))
                {
                    File.Delete(temporaryPath);
                }
            }
        }
    }

    private static void TryDeleteStateFile()
    {
        try
        {
            if (File.Exists(StatePath))
            {
                File.Delete(StatePath);
            }
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
        {
            ClientDiagnostics.Log($"Legacy baseline campaign state could not be removed: {exception.Message}");
        }
    }

    private static bool IsValid(PlaybackBaselineCampaign campaign)
        => Guid.TryParseExact(campaign.CampaignId, "N", out _)
           && campaign.ExpiresAtUtc > campaign.CreatedAtUtc
           && !string.IsNullOrWhiteSpace(campaign.CanonicalSourceFingerprint)
           && campaign.CanonicalSourceFingerprint.Length == 64
           && (campaign.SourceType.Equals("TXT", StringComparison.OrdinalIgnoreCase)
               || campaign.SourceType.Equals("VPS", StringComparison.OrdinalIgnoreCase))
           && !string.IsNullOrWhiteSpace(campaign.PlaybackEngine)
           && !string.IsNullOrWhiteSpace(campaign.InputProfile);

    private static bool IsProtectedBaselineSpeed(double speed)
        => double.IsFinite(speed)
           && (Math.Abs(speed - 1d) <= PlaybackSessionComparisonPolicy.SpeedTolerance
               || Math.Abs(speed - 2d) <= PlaybackSessionComparisonPolicy.SpeedTolerance);

    private static string? GetSourceType(string path)
        => Path.GetExtension(path).ToLowerInvariant() switch
        {
            ".txt" => "TXT",
            ".vps" => "VPS",
            _ => null
        };
}
