using System.Globalization;
using System.Text.Json;

namespace RobloxPiano.Library;

internal static class SongDiscoveryHttp
{
    public static HttpRequestMessage CreateGet(Uri uri)
    {
        var request = new HttpRequestMessage(HttpMethod.Get, uri);
        request.Headers.TryAddWithoutValidation("User-Agent", "RobloxPiano/0.10 (https://github.com/Longdotnet/APK-test)");
        request.Headers.TryAddWithoutValidation("Accept", "application/json");
        return request;
    }

    public static string SearchPhrase(string value)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(value);
        var cleaned = new string(value
            .Where(character => !char.IsControl(character))
            .Select(character => character == '"' ? ' ' : character)
            .ToArray());
        cleaned = string.Join(' ', cleaned.Split((char[]?)null, StringSplitOptions.RemoveEmptyEntries | StringSplitOptions.TrimEntries));
        if (cleaned.Length == 0)
        {
            throw new ArgumentException("Search query does not contain searchable text.", nameof(value));
        }
        return cleaned;
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
        var phrase = SongDiscoveryHttp.SearchPhrase(query);
        var search = Uri.EscapeDataString($"\"{phrase}\" filemime:midi");
        var limit = Math.Clamp(maxResults, 1, 40);
        var requestUri = new Uri(
            $"{Endpoint}?action=query&format=json&formatversion=2&generator=search&gsrnamespace=6&gsrlimit={limit}&gsrsearch={search}&prop=imageinfo&iiprop=url%7Csize%7Csha1%7Cmime");

        using var request = SongDiscoveryHttp.CreateGet(requestUri);
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
            candidates.Add(new SongDiscoveryCandidate(
                Id,
                DisplayName,
                CleanTitle(rawTitle),
                null,
                DiscoveredSongFormat.Midi,
                downloadUri,
                sourceUri,
                string.IsNullOrWhiteSpace(sha1) ? null : "sha1:" + sha1,
                TryGetInt64(info, "size"),
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
        var phrase = SongDiscoveryHttp.SearchPhrase(query).Replace("\\", " ", StringComparison.Ordinal);
        var advancedQuery = Uri.EscapeDataString($"(title:\"{phrase}\" OR description:\"{phrase}\" OR subject:\"{phrase}\") AND (format:MIDI OR subject:midi)");
        var uri = new Uri(
            $"https://archive.org/advancedsearch.php?q={advancedQuery}&fl%5B%5D=identifier&fl%5B%5D=title&fl%5B%5D=creator&rows={limit}&page=1&output=json");

        using var request = SongDiscoveryHttp.CreateGet(uri);
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
        using var request = SongDiscoveryHttp.CreateGet(metadataUri);
        using var response = await _httpClient.SendAsync(request, HttpCompletionOption.ResponseHeadersRead, cancellationToken).ConfigureAwait(false);
        response.EnsureSuccessStatusCode();
        await using var stream = await response.Content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false);
        using var document = await JsonDocument.ParseAsync(stream, cancellationToken: cancellationToken).ConfigureAwait(false);

        if (!document.RootElement.TryGetProperty("files", out var files) || files.ValueKind != JsonValueKind.Array)
        {
            return Array.Empty<SongDiscoveryCandidate>();
        }

        var midiFiles = files.EnumerateArray()
            .Where(file => IsMidiName(ReadFlexibleString(file, "name")))
            .OrderBy(file => string.Equals(ReadFlexibleString(file, "source"), "original", StringComparison.OrdinalIgnoreCase) ? 0 : 1)
            .Take(2)
            .Select(file => file.Clone())
            .ToArray();

        var candidates = new List<SongDiscoveryCandidate>();
        foreach (var file in midiFiles)
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
            var title = midiFiles.Length > 1 && !fileTitle.Contains(itemTitle, StringComparison.CurrentCultureIgnoreCase)
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
            foreach (var value in property.EnumerateArray())
            {
                if (value.ValueKind == JsonValueKind.String)
                {
                    return value.GetString();
                }
            }
        }
        return null;
    }

    private static long? TryParseInt64(string? value)
        => long.TryParse(value, NumberStyles.Integer, CultureInfo.InvariantCulture, out var parsed) ? parsed : null;
}
