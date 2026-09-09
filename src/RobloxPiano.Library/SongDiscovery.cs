using System.Globalization;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;

namespace RobloxPiano.Library;

public enum DiscoveredSongFormat
{
    Midi = 0
}

public sealed record SongDiscoveryCandidate(
    string ProviderId,
    string ProviderName,
    string Title,
    string? Artist,
    DiscoveredSongFormat Format,
    Uri DownloadUri,
    Uri SourcePageUri,
    string? ContentIdentity,
    long? ByteSize,
    int Score = 0,
    bool IsCached = false)
{
    public int StarRating => Score switch
    {
        >= 115 => 5,
        >= 90 => 4,
        >= 65 => 3,
        >= 40 => 2,
        _ => 1
    };

    public string DisplayText
    {
        get
        {
            var stars = new string('★', StarRating) + new string('☆', 5 - StarRating);
            var artist = string.IsNullOrWhiteSpace(Artist) ? string.Empty : $" — {Artist}";
            var cached = IsCached ? " · cached" : string.Empty;
            return $"{stars}  {Title}{artist} · MIDI · {ProviderName}{cached}";
        }
    }
}

public sealed record SongDiscoveryResult(
    IReadOnlyList<SongDiscoveryCandidate> Candidates,
    IReadOnlyList<string> ProviderErrors,
    bool UsedCache);

public interface ISongDiscoveryProvider
{
    string Id { get; }
    string DisplayName { get; }

    Task<IReadOnlyList<SongDiscoveryCandidate>> SearchAsync(
        string query,
        int maxResults,
        CancellationToken cancellationToken);
}

public interface ISongDiscoveryCache
{
    ValueTask SaveAsync(
        string query,
        IReadOnlyList<SongDiscoveryCandidate> candidates,
        CancellationToken cancellationToken);

    ValueTask<IReadOnlyList<SongDiscoveryCandidate>> TryLoadAsync(
        string query,
        TimeSpan maxAge,
        CancellationToken cancellationToken);
}

public sealed class JsonSongDiscoveryCache : ISongDiscoveryCache
{
    private readonly string _directory;
    private readonly TimeProvider _timeProvider;

    public JsonSongDiscoveryCache(string directory, TimeProvider? timeProvider = null)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(directory);
        _directory = Path.GetFullPath(directory);
        _timeProvider = timeProvider ?? TimeProvider.System;
    }

    public async ValueTask SaveAsync(
        string query,
        IReadOnlyList<SongDiscoveryCandidate> candidates,
        CancellationToken cancellationToken)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(query);
        ArgumentNullException.ThrowIfNull(candidates);
        Directory.CreateDirectory(_directory);

        var path = BuildPath(query);
        var temporary = path + "." + Guid.NewGuid().ToString("N") + ".tmp";
        var entry = new CacheEntry(_timeProvider.GetUtcNow(), candidates.ToArray());
        var json = JsonSerializer.Serialize(entry, JsonOptions);
        await File.WriteAllTextAsync(temporary, json, cancellationToken).ConfigureAwait(false);
        try
        {
            File.Move(temporary, path, overwrite: true);
        }
        finally
        {
            TryDelete(temporary);
        }
    }

    public async ValueTask<IReadOnlyList<SongDiscoveryCandidate>> TryLoadAsync(
        string query,
        TimeSpan maxAge,
        CancellationToken cancellationToken)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(query);
        if (maxAge < TimeSpan.Zero)
        {
            throw new ArgumentOutOfRangeException(nameof(maxAge));
        }

        var path = BuildPath(query);
        if (!File.Exists(path))
        {
            return Array.Empty<SongDiscoveryCandidate>();
        }

        try
        {
            var json = await File.ReadAllTextAsync(path, cancellationToken).ConfigureAwait(false);
            var entry = JsonSerializer.Deserialize<CacheEntry>(json, JsonOptions);
            if (entry is null || _timeProvider.GetUtcNow() - entry.SavedAt > maxAge)
            {
                return Array.Empty<SongDiscoveryCandidate>();
            }

            return entry.Candidates
                .Select(candidate => candidate with { IsCached = true })
                .ToArray();
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or JsonException
            or NotSupportedException)
        {
            return Array.Empty<SongDiscoveryCandidate>();
        }
    }

    private string BuildPath(string query)
    {
        var normalized = SongDiscoveryRanker.Normalize(query);
        var hash = Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(normalized))).ToLowerInvariant();
        return Path.Combine(_directory, hash + ".json");
    }

    private static void TryDelete(string path)
    {
        try
        {
            if (File.Exists(path))
            {
                File.Delete(path);
            }
        }
        catch
        {
        }
    }

    private sealed record CacheEntry(DateTimeOffset SavedAt, SongDiscoveryCandidate[] Candidates);

    private static JsonSerializerOptions JsonOptions { get; } = new(JsonSerializerDefaults.Web);
}

public sealed class SongDiscoveryService
{
    private static readonly TimeSpan DefaultProviderTimeout = TimeSpan.FromSeconds(7);
    private static readonly TimeSpan CacheFallbackAge = TimeSpan.FromDays(7);

    private readonly IReadOnlyList<ISongDiscoveryProvider> _providers;
    private readonly ISongDiscoveryCache? _cache;
    private readonly TimeSpan _providerTimeout;

    public SongDiscoveryService(
        IEnumerable<ISongDiscoveryProvider> providers,
        ISongDiscoveryCache? cache = null,
        TimeSpan? providerTimeout = null)
    {
        ArgumentNullException.ThrowIfNull(providers);
        _providers = providers.ToArray();
        if (_providers.Count == 0)
        {
            throw new ArgumentException("At least one online discovery provider is required.", nameof(providers));
        }

        if (_providers.Select(provider => provider.Id).Distinct(StringComparer.OrdinalIgnoreCase).Count() != _providers.Count)
        {
            throw new ArgumentException("Online discovery provider IDs must be unique.", nameof(providers));
        }

        _cache = cache;
        _providerTimeout = providerTimeout ?? DefaultProviderTimeout;
        if (_providerTimeout <= TimeSpan.Zero)
        {
            throw new ArgumentOutOfRangeException(nameof(providerTimeout));
        }
    }

    public async Task<SongDiscoveryResult> SearchAsync(
        string query,
        int maxResults = 10,
        CancellationToken cancellationToken = default)
    {
        query = ValidateQuery(query);
        if (maxResults is < 1 or > 25)
        {
            throw new ArgumentOutOfRangeException(nameof(maxResults), "Online search result count must be between 1 and 25.");
        }

        var perProvider = Math.Clamp(maxResults * 3, 10, 40);
        var tasks = _providers
            .Select(provider => SearchProviderSafeAsync(provider, query, perProvider, cancellationToken))
            .ToArray();
        var outcomes = await Task.WhenAll(tasks).ConfigureAwait(false);
        cancellationToken.ThrowIfCancellationRequested();

        var errors = outcomes
            .Where(outcome => outcome.Error is not null)
            .Select(outcome => outcome.Error!)
            .ToList();
        var ranked = SongDiscoveryRanker.Rank(query, outcomes.SelectMany(outcome => outcome.Candidates), maxResults);
        if (ranked.Count > 0)
        {
            if (_cache is not null)
            {
                try
                {
                    await _cache.SaveAsync(query, ranked, cancellationToken).ConfigureAwait(false);
                }
                catch (Exception exception) when (
                    exception is IOException
                    or UnauthorizedAccessException
                    or JsonException
                    or NotSupportedException)
                {
                    errors.Add($"Discovery cache write failed: {exception.Message}");
                }
            }

            return new SongDiscoveryResult(ranked, errors.ToArray(), UsedCache: false);
        }

        if (_cache is not null)
        {
            var cached = await _cache.TryLoadAsync(query, CacheFallbackAge, cancellationToken).ConfigureAwait(false);
            if (cached.Count > 0)
            {
                var reranked = SongDiscoveryRanker.Rank(
                        query,
                        cached.Select(candidate => candidate with { Score = 0 }),
                        maxResults)
                    .Select(candidate => candidate with { IsCached = true })
                    .ToArray();
                return new SongDiscoveryResult(reranked, errors.ToArray(), UsedCache: true);
            }
        }

        return new SongDiscoveryResult(Array.Empty<SongDiscoveryCandidate>(), errors.ToArray(), UsedCache: false);
    }

    private async Task<ProviderOutcome> SearchProviderSafeAsync(
        ISongDiscoveryProvider provider,
        string query,
        int maxResults,
        CancellationToken cancellationToken)
    {
        using var timeout = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken);
        timeout.CancelAfter(_providerTimeout);
        try
        {
            var candidates = await provider.SearchAsync(query, maxResults, timeout.Token).ConfigureAwait(false);
            return new ProviderOutcome(candidates, null);
        }
        catch (OperationCanceledException) when (!cancellationToken.IsCancellationRequested)
        {
            return new ProviderOutcome(Array.Empty<SongDiscoveryCandidate>(), $"{provider.DisplayName} timed out.");
        }
        catch (Exception exception) when (
            exception is HttpRequestException
            or IOException
            or JsonException
            or FormatException
            or InvalidOperationException)
        {
            return new ProviderOutcome(Array.Empty<SongDiscoveryCandidate>(), $"{provider.DisplayName}: {exception.Message}");
        }
    }

    private static string ValidateQuery(string query)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(query);
        var trimmed = query.Trim();
        if (trimmed.Length < 2)
        {
            throw new ArgumentException("Type at least 2 characters to search online.", nameof(query));
        }
        if (trimmed.Length > 120)
        {
            throw new ArgumentException("Online search is limited to 120 characters.", nameof(query));
        }
        return trimmed;
    }

    private sealed record ProviderOutcome(IReadOnlyList<SongDiscoveryCandidate> Candidates, string? Error);
}

public static class SongDiscoveryRanker
{
    public static IReadOnlyList<SongDiscoveryCandidate> Rank(
        string query,
        IEnumerable<SongDiscoveryCandidate> candidates,
        int maxResults)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(query);
        ArgumentNullException.ThrowIfNull(candidates);
        if (maxResults <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(maxResults));
        }

        var normalizedQuery = Normalize(query);
        var queryTokens = Tokens(normalizedQuery);
        var scored = candidates
            .Where(IsSafeCandidate)
            .Select(candidate => candidate with { Score = checked(candidate.Score + CalculateScore(normalizedQuery, queryTokens, candidate)) })
            .OrderByDescending(candidate => candidate.Score)
            .ThenBy(candidate => candidate.Title, StringComparer.CurrentCultureIgnoreCase)
            .ToArray();

        var identities = new HashSet<string>(StringComparer.OrdinalIgnoreCase);
        var results = new List<SongDiscoveryCandidate>(Math.Min(maxResults, scored.Length));
        foreach (var candidate in scored)
        {
            if (!identities.Add(BuildIdentity(candidate)))
            {
                continue;
            }

            results.Add(candidate);
            if (results.Count == maxResults)
            {
                break;
            }
        }
        return results;
    }

    public static string Normalize(string value)
    {
        ArgumentNullException.ThrowIfNull(value);
        var decomposed = value.Normalize(NormalizationForm.FormD);
        var builder = new StringBuilder(decomposed.Length);
        var previousSpace = true;
        foreach (var character in decomposed)
        {
            if (CharUnicodeInfo.GetUnicodeCategory(character) == UnicodeCategory.NonSpacingMark)
            {
                continue;
            }

            if (character is 'đ' or 'Đ')
            {
                builder.Append('d');
                previousSpace = false;
            }
            else if (char.IsLetterOrDigit(character))
            {
                builder.Append(char.ToLowerInvariant(character));
                previousSpace = false;
            }
            else if (!previousSpace)
            {
                builder.Append(' ');
                previousSpace = true;
            }
        }
        return builder.ToString().Trim();
    }

    private static int CalculateScore(
        string normalizedQuery,
        IReadOnlyList<string> queryTokens,
        SongDiscoveryCandidate candidate)
    {
        var title = Normalize(candidate.Title);
        var artist = Normalize(candidate.Artist ?? string.Empty);
        var score = 10;
        if (title == normalizedQuery)
        {
            score += 90;
        }
        else if (title.Contains(normalizedQuery, StringComparison.Ordinal))
        {
            score += 55;
        }

        var titleTokens = Tokens(title);
        var matched = queryTokens.Count(token => titleTokens.Contains(token, StringComparer.Ordinal));
        score += matched * 10;
        if (queryTokens.Count > 0 && matched == queryTokens.Count)
        {
            score += 25;
        }

        if (queryTokens.Any(token => artist.Contains(token, StringComparison.Ordinal)))
        {
            score += 8;
        }
        if (title.Contains("piano", StringComparison.Ordinal))
        {
            score += 12;
        }
        if (title.Contains("midi", StringComparison.Ordinal))
        {
            score += 4;
        }
        if (candidate.ByteSize is > 0 and <= OnlineSongImportService.MaximumDownloadBytes)
        {
            score += 4;
        }
        return score;
    }

    private static IReadOnlyList<string> Tokens(string normalized)
        => normalized.Split(' ', StringSplitOptions.RemoveEmptyEntries | StringSplitOptions.TrimEntries);

    private static bool IsSafeCandidate(SongDiscoveryCandidate candidate)
        => !string.IsNullOrWhiteSpace(candidate.Title)
           && candidate.DownloadUri.IsAbsoluteUri
           && candidate.DownloadUri.Scheme.Equals(Uri.UriSchemeHttps, StringComparison.OrdinalIgnoreCase)
           && candidate.SourcePageUri.IsAbsoluteUri
           && candidate.SourcePageUri.Scheme.Equals(Uri.UriSchemeHttps, StringComparison.OrdinalIgnoreCase);

    private static string BuildIdentity(SongDiscoveryCandidate candidate)
    {
        if (!string.IsNullOrWhiteSpace(candidate.ContentIdentity))
        {
            return "content:" + candidate.ContentIdentity.Trim();
        }
        return $"metadata:{Normalize(candidate.Title)}|{Normalize(candidate.Artist ?? string.Empty)}|{candidate.Format}";
    }
}
