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

        var candidates = outcomes.SelectMany(outcome => outcome.Candidates).ToArray();
        var errors = outcomes
            .Where(outcome => outcome.Error is not null)
            .Select(outcome => outcome.Error!)
            .ToArray();

        var ranked = SongDiscoveryRanker.Rank(query, candidates, maxResults);
        if (ranked.Count > 0)
        {
            if (_cache is not null)
            {
                try
                {
                    await _cache.SaveAsync(query, ranked, cancellationToken).ConfigureAwait(false);
                }
                catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
                {
                    errors = errors.Append($"Discovery cache write failed: {exception.Message}").ToArray();
                }
            }

            return new SongDiscoveryResult(ranked, errors, UsedCache: false);
        }

        if (_cache is not null)
        {
            var cached = await _cache.TryLoadAsync(query, CacheFallbackAge, cancellationToken).ConfigureAwait(false);
            if (cached.Count > 0)
            {
                var reranked = SongDiscoveryRanker.Rank(query, cached, maxResults)
                    .Select(candidate => candidate with { IsCached = true })
                    .ToArray();
                return new SongDiscoveryResult(reranked, errors, UsedCache: true);
            }
        }

        return new SongDiscoveryResult(Array.Empty<SongDiscoveryCandidate>(), errors, UsedCache: false);
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
            return new ProviderOutcome(
                Array.Empty<SongDiscoveryCandidate>(),
                $"{provider.DisplayName} timed out.");
        }
        catch (Exception exception) when (
            exception is HttpRequestException
            or IOException
            or JsonException
            or FormatException
            or InvalidOperationException)
        {
            return new ProviderOutcome(
                Array.Empty<SongDiscoveryCandidate>(),
                $"{provider.DisplayName}: {exception.Message}");
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
            .Select(candidate => candidate with { Score = checked(candidate.Score + Score(normalizedQuery, queryTokens, candidate)) })
            .OrderByDescending(candidate => candidate.Score)
            .ThenBy(candidate => candidate.Title, StringComparer.CurrentCultureIgnoreCase)
            .ToArray();

        var identities = new HashSet<string>(StringComparer.OrdinalIgnoreCase);
        var results = new List<SongDiscoveryCandidate>(Math.Min(maxResults, scored.Length));
        foreach (var candidate in scored)
        {
            var identity = BuildIdentity(candidate);
            if (!identities.Add(identity))
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

            if (char.IsLetterOrDigit(character))
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

    private static int Score(string normalizedQuery, IReadOnlyList<string> queryTokens, SongDiscoveryCandidate candidate)
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

public sealed class WikimediaCommonsMidiProvider : ISongDiscoveryProvider
{
    private const string Endpoint = "https://commons.wikimedia.org/w/api.php";
    private readonly HttpClient _httpClient;

    public WikimediaCommonsMidiProvider(HttpClient httpClient)
    {
        _httpClient = httpClient ?? throw new ArgumentNullException(nameof(httpClient));
    }

    public string Id => "wikimedia-commons";
    public string DisplayName => "Wikimedia Commons";

    public async Task<IReadOnlyList<SongDiscoveryCandidate>> SearchAsync(
        string query,
        int maxResults,
        CancellationToken cancellationToken)
    {
        var search = Uri.EscapeDataString(query + " filemime:midi");
        var limit = Math.Clamp(maxResults, 1, 40);
        var requestUri = new Uri(
            $"{Endpoint}?action=query&format=json&formatversion=2&generator=search&gsrnamespace=6&gsrlimit={limit}&gsrsearch={search}&prop=imageinfo&iiprop=url%7Csize%7Csha1%7Cmime");

        using var request = CreateGet(requestUri);
        using var response = await _httpClient.SendAsync(request, HttpCompletionOption.ResponseHeadersRead, cancellationToken).ConfigureAwait(false);
        response.EnsureSuccessStatusCode();
        await using var stream = await response.Content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false);
        using var document = await JsonDocument.ParseAsync(stream, cancellationToken: cancellationToken).ConfigureAwait(false);

        if (!document.RootElement.TryGetProperty("query", out var queryElement)
            || !queryElement.TryGetProperty("pages", out var pages)
            || pages.ValueKind != JsonValueKind.Array)
        {
            return Array.Empty<SongDiscoveryCandidate>();
        }

        var candidates = new List<SongDiscoveryCandidate>();
        foreach (var page in pages.EnumerateArray())
        {
            cancellationToken.ThrowIfCancellationRequested();
            if (!page.TryGetProperty("title", out var titleProperty)
                || !page.TryGetProperty("imageinfo", out var imageInfoArray)
                || imageInfoArray.ValueKind != JsonValueKind.Array
                || imageInfoArray.GetArrayLength() == 0)
            {
                continue;
            }

            var info = imageInfoArray[0];
            var urlText = GetString(info, "url");
            var sourceText = GetString(info, "descriptionurl");
            var mime = GetString(info, "mime") ?? string.Empty;
            if (!Uri.TryCreate(urlText, UriKind.Absolute, out var downloadUri)
                || !Uri.TryCreate(sourceText, UriKind.Absolute, out var sourceUri))
            {
                continue;
            }

            var rawTitle = titleProperty.GetString() ?? string.Empty;
            if (!LooksLikeMidi(rawTitle, downloadUri, mime))
            {
                continue;
            }

            var sha1 = GetString(info, "sha1");
            var size = TryGetInt64(info, "size");
            candidates.Add(new SongDiscoveryCandidate(
                Id,
                DisplayName,
                CleanTitle(rawTitle),
                null,
                DiscoveredSongFormat.Midi,
                downloadUri,
                sourceUri,
                string.IsNullOrWhiteSpace(sha1) ? null : "sha1:" + sha1,
                size,
                Score: 20));
        }
        return candidates;
    }

    private static bool LooksLikeMidi(string title, Uri uri, string mime)
        => mime.Contains("midi", StringComparison.OrdinalIgnoreCase)
           || title.EndsWith(".mid", StringComparison.OrdinalIgnoreCase)
           || title.EndsWith(".midi", StringComparison.OrdinalIgnoreCase)
           || uri.AbsolutePath.EndsWith(".mid", StringComparison.OrdinalIgnoreCase)
           || uri.AbsolutePath.EndsWith(".midi", StringComparison.OrdinalIgnoreCase);

    private static string CleanTitle(string value)
    {
        var title = value.StartsWith("File:", StringComparison.OrdinalIgnoreCase) ? value[5..] : value;
        title = Path.GetFileNameWithoutExtension(title.Replace('_', ' '));
        return string.IsNullOrWhiteSpace(title) ? "MIDI song" : title.Trim();
    }

    private static string? GetString(JsonElement element, string name)
        => element.TryGetProperty(name, out var property) && property.ValueKind == JsonValueKind.String
            ? property.GetString()
            : null;

    private static long? TryGetInt64(JsonElement element, string name)
        => element.TryGetProperty(name, out var property) && property.TryGetInt64(out var value) ? value : null;

    internal static HttpRequestMessage CreateGet(Uri uri)
    {
        var request = new HttpRequestMessage(HttpMethod.Get, uri);
        request.Headers.TryAddWithoutValidation("User-Agent", "RobloxPiano/0.10 (https://github.com/Longdotnet/APK-test)");
        request.Headers.TryAddWithoutValidation("Accept", "application/json");
        return request;
    }
}

public sealed class InternetArchiveMidiProvider : ISongDiscoveryProvider
{
    private readonly HttpClient _httpClient;

    public InternetArchiveMidiProvider(HttpClient httpClient)
    {
        _httpClient = httpClient ?? throw new ArgumentNullException(nameof(httpClient));
    }

    public string Id => "internet-archive";
    public string DisplayName => "Internet Archive";

    public async Task<IReadOnlyList<SongDiscoveryCandidate>> SearchAsync(
        string query,
        int maxResults,
        CancellationToken cancellationToken)
    {
        var limit = Math.Clamp(maxResults, 1, 24);
        var advancedQuery = Uri.EscapeDataString($"({query}) AND (format:MIDI OR subject:midi)");
        var uri = new Uri(
            $"https://archive.org/advancedsearch.php?q={advancedQuery}&fl%5B%5D=identifier&fl%5B%5D=title&fl%5B%5D=creator&rows={limit}&page=1&output=json");

        using var request = WikimediaCommonsMidiProvider.CreateGet(uri);
        using var response = await _httpClient.SendAsync(request, HttpCompletionOption.ResponseHeadersRead, cancellationToken).ConfigureAwait(false);
        response.EnsureSuccessStatusCode();
        await using var stream = await response.Content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false);
        using var document = await JsonDocument.ParseAsync(stream, cancellationToken: cancellationToken).ConfigureAwait(false);

        if (!document.RootElement.TryGetProperty("response", out var responseElement)
            || !responseElement.TryGetProperty("docs", out var docs)
            || docs.ValueKind != JsonValueKind.Array)
        {
            return Array.Empty<SongDiscoveryCandidate>();
        }

        var itemTasks = docs.EnumerateArray()
            .Take(limit)
            .Select(item => ResolveItemAsync(item.Clone(), cancellationToken))
            .ToArray();
        var itemResults = await Task.WhenAll(itemTasks).ConfigureAwait(false);
        return itemResults.SelectMany(result => result).Take(maxResults).ToArray();
    }

    private async Task<IReadOnlyList<SongDiscoveryCandidate>> ResolveItemAsync(
        JsonElement item,
        CancellationToken cancellationToken)
    {
        var identifier = ReadFlexibleString(item, "identifier");
        if (string.IsNullOrWhiteSpace(identifier))
        {
            return Array.Empty<SongDiscoveryCandidate>();
        }

        var itemTitle = ReadFlexibleString(item, "title") ?? identifier;
        var creator = ReadFlexibleString(item, "creator");
        var metadataUri = new Uri("https://archive.org/metadata/" + Uri.EscapeDataString(identifier));
        using var request = WikimediaCommonsMidiProvider.CreateGet(metadataUri);
        using var response = await _httpClient.SendAsync(request, HttpCompletionOption.ResponseHeadersRead, cancellationToken).ConfigureAwait(false);
        response.EnsureSuccessStatusCode();
        await using var stream = await response.Content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false);
        using var document = await JsonDocument.ParseAsync(stream, cancellationToken: cancellationToken).ConfigureAwait(false);

        if (!document.RootElement.TryGetProperty("files", out var files) || files.ValueKind != JsonValueKind.Array)
        {
            return Array.Empty<SongDiscoveryCandidate>();
        }

        var candidates = new List<SongDiscoveryCandidate>();
        foreach (var file in files.EnumerateArray()
                     .Where(file => IsMidiName(ReadFlexibleString(file, "name")))
                     .OrderBy(file => string.Equals(ReadFlexibleString(file, "source"), "original", StringComparison.OrdinalIgnoreCase) ? 0 : 1)
                     .Take(2))
        {
            var name = ReadFlexibleString(file, "name");
            if (string.IsNullOrWhiteSpace(name))
            {
                continue;
            }

            var size = TryParseInt64(ReadFlexibleString(file, "size"));
            if (size is > OnlineSongImportService.MaximumDownloadBytes)
            {
                continue;
            }

            var sha1 = ReadFlexibleString(file, "sha1");
            var md5 = ReadFlexibleString(file, "md5");
            var identity = !string.IsNullOrWhiteSpace(sha1)
                ? "sha1:" + sha1
                : !string.IsNullOrWhiteSpace(md5) ? "md5:" + md5 : null;
            var fileTitle = Path.GetFileNameWithoutExtension(name.Replace('_', ' '));
            var title = files.GetArrayLength() > 1 && !fileTitle.Contains(itemTitle, StringComparison.CurrentCultureIgnoreCase)
                ? $"{itemTitle} — {fileTitle}"
                : itemTitle;
            var download = new Uri($"https://archive.org/download/{Uri.EscapeDataString(identifier)}/{EscapePath(name)}");
            var source = new Uri("https://archive.org/details/" + Uri.EscapeDataString(identifier));

            candidates.Add(new SongDiscoveryCandidate(
                Id,
                DisplayName,
                title,
                creator,
                DiscoveredSongFormat.Midi,
                download,
                source,
                identity,
                size,
                Score: 15));
        }
        return candidates;
    }

    private static string EscapePath(string value)
        => string.Join("/", value.Split('/', StringSplitOptions.RemoveEmptyEntries).Select(Uri.EscapeDataString));

    private static bool IsMidiName(string? value)
        => !string.IsNullOrWhiteSpace(value)
           && (value.EndsWith(".mid", StringComparison.OrdinalIgnoreCase)
               || value.EndsWith(".midi", StringComparison.OrdinalIgnoreCase));

    private static string? ReadFlexibleString(JsonElement element, string name)
    {
        if (!element.TryGetProperty(name, out var property))
        {
            return null;
        }
        if (property.ValueKind == JsonValueKind.String)
        {
            return property.GetString();
        }
        if (property.ValueKind == JsonValueKind.Array)
        {
            return property.EnumerateArray().FirstOrDefault(value => value.ValueKind == JsonValueKind.String).GetString();
        }
        return null;
    }

    private static long? TryParseInt64(string? value)
        => long.TryParse(value, NumberStyles.Integer, CultureInfo.InvariantCulture, out var parsed) ? parsed : null;
}

public sealed record OnlineSongImportResult(SheetLibraryEntry Entry, bool AlreadyPresent);

public sealed class OnlineSongImportService
{
    public const long MaximumDownloadBytes = 5L * 1024L * 1024L;

    private readonly HttpClient _httpClient;
    private readonly SheetLibraryService _library;
    private readonly string _temporaryDirectory;

    public OnlineSongImportService(
        HttpClient httpClient,
        SheetLibraryService library,
        string? temporaryDirectory = null)
    {
        _httpClient = httpClient ?? throw new ArgumentNullException(nameof(httpClient));
        _library = library ?? throw new ArgumentNullException(nameof(library));
        _temporaryDirectory = Path.GetFullPath(temporaryDirectory ?? Path.Combine(Path.GetTempPath(), "RobloxPiano", "online-import"));
    }

    public async Task<OnlineSongImportResult> ImportAsync(
        SongDiscoveryCandidate candidate,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(candidate);
        ValidateDownloadUri(candidate.ProviderId, candidate.DownloadUri);
        Directory.CreateDirectory(_temporaryDirectory);

        var extension = candidate.DownloadUri.AbsolutePath.EndsWith(".midi", StringComparison.OrdinalIgnoreCase) ? ".midi" : ".mid";
        var temporary = Path.Combine(
            _temporaryDirectory,
            SanitizeFileName(candidate.Title) + "." + Guid.NewGuid().ToString("N") + extension);

        try
        {
            using var request = WikimediaCommonsMidiProvider.CreateGet(candidate.DownloadUri);
            using var response = await _httpClient.SendAsync(request, HttpCompletionOption.ResponseHeadersRead, cancellationToken).ConfigureAwait(false);
            response.EnsureSuccessStatusCode();

            var finalUri = response.RequestMessage?.RequestUri ?? candidate.DownloadUri;
            ValidateDownloadUri(candidate.ProviderId, finalUri);
            if (response.Content.Headers.ContentLength is > MaximumDownloadBytes)
            {
                throw new FormatException("This online MIDI is too large to import safely.");
            }

            await using (var source = await response.Content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false))
            await using (var destination = new FileStream(temporary, FileMode.CreateNew, FileAccess.Write, FileShare.None, 81920, useAsync: true))
            {
                var buffer = new byte[81920];
                long total = 0;
                while (true)
                {
                    var read = await source.ReadAsync(buffer, cancellationToken).ConfigureAwait(false);
                    if (read == 0)
                    {
                        break;
                    }
                    total = checked(total + read);
                    if (total > MaximumDownloadBytes)
                    {
                        throw new FormatException("This online MIDI is too large to import safely.");
                    }
                    await destination.WriteAsync(buffer.AsMemory(0, read), cancellationToken).ConfigureAwait(false);
                }
            }

            var existing = FindEquivalentManagedSong(temporary);
            if (existing is not null)
            {
                return new OnlineSongImportResult(existing, AlreadyPresent: true);
            }

            var imported = _library.Import(temporary);
            return new OnlineSongImportResult(imported, AlreadyPresent: false);
        }
        finally
        {
            TryDelete(temporary);
        }
    }

    private SheetLibraryEntry? FindEquivalentManagedSong(string downloadedPath)
    {
        if (!Directory.Exists(_library.ManagedDirectory))
        {
            return null;
        }

        var downloadedHash = HashFile(downloadedPath);
        foreach (var path in Directory.EnumerateFiles(_library.ManagedDirectory, "*", SearchOption.TopDirectoryOnly))
        {
            if (!SheetLibraryService.IsSupportedPath(path))
            {
                continue;
            }
            try
            {
                if (CryptographicOperations.FixedTimeEquals(downloadedHash, HashFile(path)))
                {
                    return _library.Scan().FirstOrDefault(entry => entry.Path.Equals(Path.GetFullPath(path), StringComparison.OrdinalIgnoreCase));
                }
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
            {
            }
        }
        return null;
    }

    private static byte[] HashFile(string path)
    {
        using var stream = File.OpenRead(path);
        using var sha = SHA256.Create();
        return sha.ComputeHash(stream);
    }

    private static void ValidateDownloadUri(string providerId, Uri uri)
    {
        if (!uri.IsAbsoluteUri || !uri.Scheme.Equals(Uri.UriSchemeHttps, StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidOperationException("Online song downloads must use HTTPS.");
        }

        var allowed = providerId switch
        {
            "wikimedia-commons" => uri.Host.Equals("upload.wikimedia.org", StringComparison.OrdinalIgnoreCase),
            "internet-archive" => uri.Host.Equals("archive.org", StringComparison.OrdinalIgnoreCase),
            _ => false
        };
        if (!allowed)
        {
            throw new InvalidOperationException("The selected online result redirected to an untrusted download host.");
        }
    }

    private static string SanitizeFileName(string title)
    {
        var invalid = Path.GetInvalidFileNameChars().ToHashSet();
        var cleaned = new string(title.Select(character => invalid.Contains(character) ? '_' : character).ToArray()).Trim();
        if (cleaned.Length > 80)
        {
            cleaned = cleaned[..80].Trim();
        }
        return string.IsNullOrWhiteSpace(cleaned) ? "online-song" : cleaned;
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
}
