using System.Collections.Concurrent;
using System.Globalization;
using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;

namespace FollowerFarmSimulator.Integrations;

public sealed record TikTokConnectionSummary(
    string OpenId,
    string Scope,
    DateTimeOffset AccessTokenExpiresAt,
    DateTimeOffset RefreshTokenExpiresAt);

public sealed record TikTokAuditResult(
    string OpenId,
    string? Username,
    string? DisplayName,
    long FollowerCount,
    long FollowingCount,
    long LikesCount,
    long VideoCount,
    int RecentVideosAnalyzed,
    double AverageViews,
    double MedianViews,
    double ViewToFollowerRatio,
    double RecentEngagementPerView,
    IReadOnlyList<string> Observations,
    JsonElement Profile,
    JsonElement Videos);

internal sealed record TikTokTokenBundle(
    string AccessToken,
    string RefreshToken,
    string OpenId,
    string Scope,
    DateTimeOffset AccessTokenExpiresAt,
    DateTimeOffset RefreshTokenExpiresAt);

public sealed class TikTokOfficialClient(
    IHttpClientFactory httpClientFactory,
    IConfiguration configuration)
{
    private const string AuthorizeEndpoint = "https://www.tiktok.com/v2/auth/authorize/";
    private const string TokenEndpoint = "https://open.tiktokapis.com/v2/oauth/token/";
    private const string UserInfoEndpoint = "https://open.tiktokapis.com/v2/user/info/";
    private const string VideoListEndpoint = "https://open.tiktokapis.com/v2/video/list/";

    private readonly ConcurrentDictionary<string, DateTimeOffset> _oauthStates = new(StringComparer.Ordinal);
    private readonly ConcurrentDictionary<string, TikTokTokenBundle> _tokens = new(StringComparer.Ordinal);

    private string ClientKey => configuration["TikTok:ClientKey"] ?? string.Empty;
    private string ClientSecret => configuration["TikTok:ClientSecret"] ?? string.Empty;
    private string RedirectUri => configuration["TikTok:RedirectUri"] ?? string.Empty;
    private string Scopes => configuration["TikTok:Scopes"] ?? "user.info.basic,user.info.profile,user.info.stats,video.list";
    private string ProfileFields => configuration["TikTok:ProfileFields"] ??
        "open_id,union_id,avatar_url,display_name,username,bio_description,profile_deep_link,is_verified,follower_count,following_count,likes_count,video_count";
    private string VideoFields => configuration["TikTok:VideoFields"] ??
        "id,create_time,title,video_description,share_url,duration,like_count,comment_count,share_count,view_count";

    public object GetConfigurationStatus() => new
    {
        configured = IsConfigured,
        clientKeyConfigured = !string.IsNullOrWhiteSpace(ClientKey),
        clientSecretConfigured = !string.IsNullOrWhiteSpace(ClientSecret),
        redirectUriConfigured = !string.IsNullOrWhiteSpace(RedirectUri),
        redirectUri = string.IsNullOrWhiteSpace(RedirectUri) ? null : RedirectUri,
        scopes = Scopes.Split(',', StringSplitOptions.RemoveEmptyEntries | StringSplitOptions.TrimEntries),
        note = "Client secret and refresh tokens stay server-side and are never returned by this API."
    };

    public bool IsConfigured =>
        !string.IsNullOrWhiteSpace(ClientKey) &&
        !string.IsNullOrWhiteSpace(ClientSecret) &&
        Uri.TryCreate(RedirectUri, UriKind.Absolute, out _);

    public (string Url, string State) CreateAuthorizationRequest()
    {
        EnsureConfigured();
        CleanupExpiredStates();

        var state = Convert.ToHexString(System.Security.Cryptography.RandomNumberGenerator.GetBytes(24)).ToLowerInvariant();
        _oauthStates[state] = DateTimeOffset.UtcNow.AddMinutes(10);

        var query = new Dictionary<string, string>
        {
            ["client_key"] = ClientKey,
            ["response_type"] = "code",
            ["scope"] = Scopes,
            ["redirect_uri"] = RedirectUri,
            ["state"] = state
        };

        return ($"{AuthorizeEndpoint}?{BuildQuery(query)}", state);
    }

    public async Task<TikTokConnectionSummary> CompleteAuthorizationAsync(
        string code,
        string state,
        CancellationToken ct)
    {
        EnsureConfigured();
        if (string.IsNullOrWhiteSpace(code)) throw new ArgumentException("TikTok authorization code is required.");
        if (string.IsNullOrWhiteSpace(state)) throw new ArgumentException("OAuth state is required.");

        if (!_oauthStates.TryRemove(state, out var expiresAt) || expiresAt <= DateTimeOffset.UtcNow)
            throw new InvalidOperationException("OAuth state is missing, expired, or already used.");

        using var request = new HttpRequestMessage(HttpMethod.Post, TokenEndpoint)
        {
            Content = new FormUrlEncodedContent(new Dictionary<string, string>
            {
                ["client_key"] = ClientKey,
                ["client_secret"] = ClientSecret,
                ["code"] = code,
                ["grant_type"] = "authorization_code",
                ["redirect_uri"] = RedirectUri
            })
        };

        var json = await SendForJsonAsync(request, ct);
        var now = DateTimeOffset.UtcNow;
        var token = new TikTokTokenBundle(
            RequiredString(json, "access_token"),
            RequiredString(json, "refresh_token"),
            RequiredString(json, "open_id"),
            OptionalString(json, "scope") ?? string.Empty,
            now.AddSeconds(RequiredInt64(json, "expires_in")),
            now.AddSeconds(RequiredInt64(json, "refresh_expires_in")));

        _tokens[token.OpenId] = token;
        return ToSummary(token);
    }

    public IReadOnlyList<TikTokConnectionSummary> ListConnections() => _tokens.Values
        .OrderBy(x => x.OpenId, StringComparer.Ordinal)
        .Select(ToSummary)
        .ToArray();

    public async Task<JsonElement> GetProfileAsync(string openId, CancellationToken ct)
    {
        var token = await GetFreshTokenAsync(openId, ct);
        using var request = new HttpRequestMessage(
            HttpMethod.Get,
            $"{UserInfoEndpoint}?fields={Uri.EscapeDataString(ProfileFields)}");
        request.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token.AccessToken);
        return await SendForJsonAsync(request, ct);
    }

    public async Task<JsonElement> GetVideosAsync(string openId, int maxCount, CancellationToken ct)
    {
        if (maxCount is < 1 or > 20) throw new ArgumentOutOfRangeException(nameof(maxCount), "TikTok video.list max_count must be 1-20.");

        var token = await GetFreshTokenAsync(openId, ct);
        using var request = new HttpRequestMessage(
            HttpMethod.Post,
            $"{VideoListEndpoint}?fields={Uri.EscapeDataString(VideoFields)}");
        request.Headers.Authorization = new AuthenticationHeaderValue("Bearer", token.AccessToken);
        request.Content = new StringContent(
            JsonSerializer.Serialize(new { max_count = maxCount }),
            Encoding.UTF8,
            "application/json");

        return await SendForJsonAsync(request, ct);
    }

    public async Task<TikTokAuditResult> AuditAsync(string openId, int maxCount, CancellationToken ct)
    {
        var profile = await GetProfileAsync(openId, ct);
        var videos = await GetVideosAsync(openId, maxCount, ct);

        var user = RequirePath(profile, "data", "user");
        var followerCount = ReadInt64(user, "follower_count");
        var followingCount = ReadInt64(user, "following_count");
        var likesCount = ReadInt64(user, "likes_count");
        var videoCount = ReadInt64(user, "video_count");

        var videoItems = new List<JsonElement>();
        if (TryPath(videos, out var data, "data") && data.TryGetProperty("videos", out var videoArray) && videoArray.ValueKind == JsonValueKind.Array)
            videoItems.AddRange(videoArray.EnumerateArray().Select(x => x.Clone()));

        var views = videoItems.Select(x => ReadInt64(x, "view_count")).Select(Convert.ToDouble).ToArray();
        var interactions = videoItems.Select(x =>
            ReadInt64(x, "like_count") + ReadInt64(x, "comment_count") + ReadInt64(x, "share_count")).Select(Convert.ToDouble).ToArray();

        var averageViews = views.Length == 0 ? 0 : views.Average();
        var medianViews = Median(views);
        var viewToFollower = followerCount <= 0 ? 0 : averageViews / followerCount;
        var totalViews = views.Sum();
        var engagementPerView = totalViews <= 0 ? 0 : interactions.Sum() / totalViews;

        var observations = new List<string>();
        if (followerCount >= 1_000 && videoItems.Count > 0 && viewToFollower < 0.10)
            observations.Add("Recent average views are below 10% of follower count. This is an audience-vs-reach mismatch signal, not proof of fake followers.");
        if (videoItems.Count > 0 && engagementPerView < 0.01)
            observations.Add("Recent like/comment/share interactions are below 1% of views; inspect content quality, audience fit, and distribution before drawing conclusions.");
        if (videoItems.Count == 0)
            observations.Add("No recent videos were returned, so reach and engagement ratios cannot be evaluated.");
        if (observations.Count == 0)
            observations.Add("No strong mismatch was detected by the current simple heuristic. Treat this as descriptive analytics, not an authenticity verdict.");

        return new TikTokAuditResult(
            openId,
            OptionalString(user, "username"),
            OptionalString(user, "display_name"),
            followerCount,
            followingCount,
            likesCount,
            videoCount,
            videoItems.Count,
            Math.Round(averageViews, 2),
            Math.Round(medianViews, 2),
            Math.Round(viewToFollower, 4),
            Math.Round(engagementPerView, 4),
            observations,
            profile,
            videos);
    }

    private async Task<TikTokTokenBundle> GetFreshTokenAsync(string openId, CancellationToken ct)
    {
        if (!_tokens.TryGetValue(openId, out var token))
            throw new KeyNotFoundException("TikTok connection not found. Complete OAuth first.");

        if (token.AccessTokenExpiresAt > DateTimeOffset.UtcNow.AddMinutes(5))
            return token;

        if (token.RefreshTokenExpiresAt <= DateTimeOffset.UtcNow)
            throw new InvalidOperationException("TikTok refresh token has expired. Reconnect the account.");

        using var request = new HttpRequestMessage(HttpMethod.Post, TokenEndpoint)
        {
            Content = new FormUrlEncodedContent(new Dictionary<string, string>
            {
                ["client_key"] = ClientKey,
                ["client_secret"] = ClientSecret,
                ["grant_type"] = "refresh_token",
                ["refresh_token"] = token.RefreshToken
            })
        };

        var json = await SendForJsonAsync(request, ct);
        var now = DateTimeOffset.UtcNow;
        var refreshed = token with
        {
            AccessToken = RequiredString(json, "access_token"),
            RefreshToken = OptionalString(json, "refresh_token") ?? token.RefreshToken,
            Scope = OptionalString(json, "scope") ?? token.Scope,
            AccessTokenExpiresAt = now.AddSeconds(RequiredInt64(json, "expires_in")),
            RefreshTokenExpiresAt = json.TryGetProperty("refresh_expires_in", out var refreshExpiry)
                ? now.AddSeconds(refreshExpiry.GetInt64())
                : token.RefreshTokenExpiresAt
        };

        _tokens[openId] = refreshed;
        return refreshed;
    }

    private async Task<JsonElement> SendForJsonAsync(HttpRequestMessage request, CancellationToken ct)
    {
        var client = httpClientFactory.CreateClient(nameof(TikTokOfficialClient));
        using var response = await client.SendAsync(request, ct);
        var body = await response.Content.ReadAsStringAsync(ct);

        JsonDocument document;
        try
        {
            document = JsonDocument.Parse(string.IsNullOrWhiteSpace(body) ? "{}" : body);
        }
        catch (JsonException)
        {
            throw new InvalidOperationException($"TikTok returned non-JSON HTTP {(int)response.StatusCode}.");
        }

        using (document)
        {
            if (!response.IsSuccessStatusCode)
            {
                var message = ExtractError(document.RootElement) ?? response.ReasonPhrase ?? "TikTok API request failed.";
                throw new InvalidOperationException($"TikTok API HTTP {(int)response.StatusCode}: {message}");
            }

            if (document.RootElement.TryGetProperty("error", out var error) &&
                error.ValueKind == JsonValueKind.Object &&
                error.TryGetProperty("code", out var code) &&
                code.ValueKind == JsonValueKind.String &&
                !string.Equals(code.GetString(), "ok", StringComparison.OrdinalIgnoreCase))
            {
                var message = OptionalString(error, "message") ?? code.GetString() ?? "TikTok API error";
                throw new InvalidOperationException($"TikTok API: {message}");
            }

            return document.RootElement.Clone();
        }
    }

    private void EnsureConfigured()
    {
        if (!IsConfigured)
            throw new InvalidOperationException(
                "TikTok official integration is not configured. Set TikTok:ClientKey, TikTok:ClientSecret, and TikTok:RedirectUri (or TikTok__... environment variables)."
            );
    }

    private void CleanupExpiredStates()
    {
        var now = DateTimeOffset.UtcNow;
        foreach (var item in _oauthStates.Where(x => x.Value <= now).ToArray())
            _oauthStates.TryRemove(item.Key, out _);
    }

    private static string BuildQuery(IReadOnlyDictionary<string, string> values) => string.Join("&",
        values.Select(x => $"{Uri.EscapeDataString(x.Key)}={Uri.EscapeDataString(x.Value)}"));

    private static TikTokConnectionSummary ToSummary(TikTokTokenBundle token) => new(
        token.OpenId,
        token.Scope,
        token.AccessTokenExpiresAt,
        token.RefreshTokenExpiresAt);

    private static string RequiredString(JsonElement element, string property)
    {
        var value = OptionalString(element, property);
        return string.IsNullOrWhiteSpace(value)
            ? throw new InvalidOperationException($"TikTok response is missing '{property}'.")
            : value;
    }

    private static string? OptionalString(JsonElement element, string property) =>
        element.TryGetProperty(property, out var value) && value.ValueKind == JsonValueKind.String
            ? value.GetString()
            : null;

    private static long RequiredInt64(JsonElement element, string property) =>
        element.TryGetProperty(property, out var value) && value.TryGetInt64(out var result)
            ? result
            : throw new InvalidOperationException($"TikTok response is missing numeric '{property}'.");

    private static long ReadInt64(JsonElement element, string property) =>
        element.TryGetProperty(property, out var value) && value.TryGetInt64(out var result) ? result : 0;

    private static JsonElement RequirePath(JsonElement root, params string[] path)
    {
        if (!TryPath(root, out var current, path))
            throw new InvalidOperationException($"TikTok response is missing '{string.Join('.', path)}'.");
        return current;
    }

    private static bool TryPath(JsonElement root, out JsonElement result, params string[] path)
    {
        result = root;
        foreach (var part in path)
        {
            if (result.ValueKind != JsonValueKind.Object || !result.TryGetProperty(part, out var next))
                return false;
            result = next;
        }
        return true;
    }

    private static double Median(double[] values)
    {
        if (values.Length == 0) return 0;
        var ordered = values.OrderBy(x => x).ToArray();
        var middle = ordered.Length / 2;
        return ordered.Length % 2 == 1
            ? ordered[middle]
            : (ordered[middle - 1] + ordered[middle]) / 2d;
    }

    private static string? ExtractError(JsonElement root)
    {
        if (root.TryGetProperty("error_description", out var description) && description.ValueKind == JsonValueKind.String)
            return description.GetString();
        if (root.TryGetProperty("error", out var error))
        {
            if (error.ValueKind == JsonValueKind.String) return error.GetString();
            if (error.ValueKind == JsonValueKind.Object)
                return OptionalString(error, "message") ?? OptionalString(error, "code");
        }
        return null;
    }
}
