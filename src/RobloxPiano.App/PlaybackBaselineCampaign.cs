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

internal enum PlaybackBaselineCampaignProgressState
{
    AwaitLegacy = 0,
    AwaitLegacyX2 = 1,
    Completed = 2,
    Invalidated = 3
}

internal sealed record PlaybackBaselineCampaignProgress(
    PlaybackBaselineCampaignProgressState State,
    string Summary,
    string NextAction,
    string? LegacySessionId = null,
    string? LegacyX2SessionId = null)
{
    public bool AcceptsNewEvidence => State is PlaybackBaselineCampaignProgressState.AwaitLegacy
        or PlaybackBaselineCampaignProgressState.AwaitLegacyX2;
}

/// <summary>
/// Persists an explicit, privacy-safe Legacy ↔ Legacy x2 reproduction campaign.
/// The campaign never owns playback truth or mutates transport state. It only tags
/// sessions that exactly match the immutable canonical/runtime conditions captured
/// when the client deliberately starts a reproduction from Support Center.
///
/// Phase 47 adds a deterministic campaign state machine. Admission is ordered and
/// fail-closed: a campaign accepts Legacy 1.00x first, then Legacy x2 2.00x. Once a
/// pair completes (or campaign evidence becomes invalid), later playback remains
/// normal but is deliberately left unscoped until the user starts a new campaign.
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
                "Campaign started. Step 1/2: run this unchanged TXT/VPS song at Legacy 1.00x. After that session is recorded, the campaign will accept only Legacy x2 2.00x as Step 2/2. Wrong-order or changed-condition playback remains usable but is not admitted to campaign evidence.",
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

        // Campaign evidence is diagnostics-only and must never be able to break playback.
        // If history/progress cannot be proven, fail closed for campaign membership while
        // returning an ordinary session ID so the deterministic playback path continues.
        var sessions = TryReadSupportSessions(nowUtc);
        if (sessions is null)
        {
            return Guid.NewGuid().ToString("N");
        }

        var progress = EvaluateProgress(campaign, sessions, nowUtc);
        if (!ShouldAdmitSnapshot(progress, snapshot))
        {
            return Guid.NewGuid().ToString("N");
        }

        return $"{SessionIdPrefix}{campaign.CampaignId}-{Guid.NewGuid():N}";
    }

    internal static PlaybackBaselineCampaignProgress EvaluateProgress(
        PlaybackBaselineCampaign campaign,
        IReadOnlyList<PlaybackSupportSession> sessions,
        DateTimeOffset nowUtc)
    {
        ArgumentNullException.ThrowIfNull(campaign);
        ArgumentNullException.ThrowIfNull(sessions);

        if (campaign.IsExpired(nowUtc))
        {
            return Invalidated(
                "This Legacy A/B campaign expired before the two controlled runs were completed.",
                "Start a new campaign from the intended unchanged TXT/VPS song and run Step 1 at Legacy 1.00x.");
        }

        var campaignSessions = sessions
            .Where(session => string.Equals(TryGetCampaignId(session.SessionId), campaign.CampaignId, StringComparison.Ordinal))
            .OrderBy(session => session.EndedAtUtc)
            .ThenBy(session => session.SessionId, StringComparer.Ordinal)
            .ToArray();

        if (campaignSessions.Length == 0)
        {
            return new(
                PlaybackBaselineCampaignProgressState.AwaitLegacy,
                "Step 1/2 is waiting for the Legacy baseline run.",
                "Run the unchanged campaign song from the beginning at exactly Legacy 1.00x. Keep the captured input-latency setting unchanged.");
        }

        var legacy = campaignSessions[0];
        if (!MatchesCampaignIdentity(campaign, legacy)
            || PlaybackLegacyBaselineComparisonPolicy.Classify(legacy) != PlaybackLegacyBaselineVariant.Legacy)
        {
            return Invalidated(
                "The first admitted campaign session is not a valid Legacy 1.00x run with the campaign's immutable canonical/runtime identity.",
                "Cancel this campaign and start a new one. Step 1 must be Legacy 1.00x; wrong-order evidence is never reinterpreted later.");
        }

        if (campaignSessions.Length == 1)
        {
            return new(
                PlaybackBaselineCampaignProgressState.AwaitLegacyX2,
                "Step 1/2 complete: Legacy 1.00x evidence is locked for this campaign.",
                "Run Step 2/2 at Legacy x2 2.00x on the same unchanged song/settings, preserving the same seek positions and exactly proportional 2x speed transitions.",
                legacy.SessionId);
        }

        var legacyX2 = campaignSessions[1];
        if (!MatchesCampaignIdentity(campaign, legacyX2)
            || PlaybackLegacyBaselineComparisonPolicy.Classify(legacyX2) != PlaybackLegacyBaselineVariant.LegacyX2)
        {
            return Invalidated(
                "The second admitted campaign session is not a valid Legacy x2 2.00x run with the campaign's immutable canonical/runtime identity.",
                "Cancel this campaign and start a new one. Duplicate Legacy 1.00x or changed-condition runs are not allowed to replace Step 2 evidence.",
                legacy.SessionId);
        }

        if (!PlaybackLegacyBaselineComparisonPolicy.AreControlledCounterparts(legacyX2, legacy))
        {
            return Invalidated(
                "Legacy x2 Step 2 changed controlled transport history relative to Step 1, so this campaign cannot produce valid A/B evidence.",
                "Start a new campaign and repeat both runs with identical seek positions and exactly proportional 2x speed transitions.",
                legacy.SessionId,
                legacyX2.SessionId);
        }

        if (campaignSessions.Length > 2)
        {
            return Invalidated(
                "This campaign contains more than the two allowed controlled sessions and is ambiguous for guided reproduction.",
                "Start a new campaign. Phase 47 admits exactly one Legacy 1.00x session followed by exactly one Legacy x2 2.00x session.",
                legacy.SessionId,
                legacyX2.SessionId);
        }

        return new(
            PlaybackBaselineCampaignProgressState.Completed,
            "Step 2/2 complete: this Legacy ↔ Legacy x2 campaign has a controlled pair.",
            "Inspect the Legacy A/B runtime verdict and export a verified Support Bundle if needed. Start a new campaign for another reproduction; completed campaigns do not accept more evidence.",
            legacy.SessionId,
            legacyX2.SessionId);
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

    internal static bool MatchesCampaignIdentity(PlaybackBaselineCampaign campaign, PlaybackSupportSession session)
    {
        ArgumentNullException.ThrowIfNull(campaign);
        ArgumentNullException.ThrowIfNull(session);

        return string.Equals(session.CanonicalSourceFingerprint, campaign.CanonicalSourceFingerprint, StringComparison.OrdinalIgnoreCase)
               && string.Equals(session.SourceType, campaign.SourceType, StringComparison.OrdinalIgnoreCase)
               && session.InputLatencyMs == campaign.InputLatencyMs
               && string.Equals(session.PlaybackEngine, campaign.PlaybackEngine, StringComparison.Ordinal)
               && string.Equals(session.InputProfile, campaign.InputProfile, StringComparison.Ordinal);
    }

    internal static bool ShouldAdmitSnapshot(
        PlaybackBaselineCampaignProgress progress,
        PlaybackSessionProvenanceSnapshot snapshot)
    {
        ArgumentNullException.ThrowIfNull(progress);
        ArgumentNullException.ThrowIfNull(snapshot);

        var speed = snapshot.ClientState.PreferredSpeed;
        return progress.State switch
        {
            PlaybackBaselineCampaignProgressState.AwaitLegacy => Near(speed, 1d),
            PlaybackBaselineCampaignProgressState.AwaitLegacyX2 => Near(speed, 2d),
            _ => false
        };
    }

    private static IReadOnlyList<PlaybackSupportSession>? TryReadSupportSessions(DateTimeOffset nowUtc)
    {
        try
        {
            var records = PlaybackSessionDiagnostics.ReadRecentRecords(ClientDiagnostics.DirectoryPath);
            return PlaybackSessionDiagnostics.CreateSupportDocument(records, nowUtc).Sessions;
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or JsonException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Legacy baseline campaign progress could not be proven; session remains unscoped: {exception.Message}");
            return null;
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
        => Near(speed, 1d) || Near(speed, 2d);

    private static bool Near(double value, double expected)
        => double.IsFinite(value)
           && Math.Abs(value - expected) <= PlaybackSessionComparisonPolicy.SpeedTolerance;

    private static string? GetSourceType(string path)
        => Path.GetExtension(path).ToLowerInvariant() switch
        {
            ".txt" => "TXT",
            ".vps" => "VPS",
            _ => null
        };

    private static PlaybackBaselineCampaignProgress Invalidated(
        string summary,
        string nextAction,
        string? legacySessionId = null,
        string? legacyX2SessionId = null)
        => new(
            PlaybackBaselineCampaignProgressState.Invalidated,
            summary,
            nextAction,
            legacySessionId,
            legacyX2SessionId);
}
