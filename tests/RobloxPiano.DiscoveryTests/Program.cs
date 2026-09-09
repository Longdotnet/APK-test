using System.Net;
using System.Text;
using RobloxPiano.Library;

namespace RobloxPiano.DiscoveryTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var tests = new (string Name, Func<Task> Run)[]
        {
            ("aggregator ranks, deduplicates, limits to ten, and isolates provider failure", TestRankingAndFailureIsolationAsync),
            ("provider outage falls back to cached discovery results", TestCacheFallbackAsync),
            ("Wikimedia Commons provider parses direct MIDI results", TestWikimediaProviderAsync),
            ("Internet Archive provider resolves item metadata to MIDI downloads", TestInternetArchiveProviderAsync),
            ("online import validates content and deduplicates identical local bytes", TestOnlineImportAndDedupAsync),
            ("oversized online download is rejected before entering the library", TestOversizedDownloadAsync),
            ("malformed online MIDI never enters the library", TestMalformedDownloadAsync),
            ("JSON discovery cache round-trips candidates", TestJsonCacheRoundTripAsync)
        };

        var failures = new List<string>();
        foreach (var test in tests)
        {
            try
            {
                await test.Run().ConfigureAwait(false);
                Console.WriteLine($"PASS  {test.Name}");
            }
            catch (Exception exception)
            {
                failures.Add($"{test.Name}: {exception.Message}");
                Console.Error.WriteLine($"FAIL  {test.Name}\n      {exception}");
            }
        }

        Console.WriteLine();
        Console.WriteLine($"Online discovery tests: {tests.Length - failures.Count} passed, {failures.Count} failed.");
        return failures.Count == 0 ? 0 : 1;
    }

    private static async Task TestRankingAndFailureIsolationAsync()
    {
        var candidates = Enumerable.Range(0, 16)
            .Select(index => Candidate(
                title: index == 0 ? "Chắc Ai Đó Sẽ Về" : $"Chắc Ai Đó Sẽ Về piano version {index}",
                identity: index is 14 or 15 ? "sha1:duplicate" : $"sha1:{index}"))
            .ToArray();

        var service = new SongDiscoveryService(
            [new FakeProvider("ok", candidates), new ThrowingProvider()],
            providerTimeout: TimeSpan.FromSeconds(1));
        var result = await service.SearchAsync("chac ai do se ve", 10);

        Equal(10, result.Candidates.Count, "top-ten result cap");
        Equal("Chắc Ai Đó Sẽ Về", result.Candidates[0].Title, "accent-insensitive exact match should rank first");
        Equal(1, result.ProviderErrors.Count, "one provider failure should be surfaced without killing healthy results");
        Equal(1, result.Candidates.Count(candidate => candidate.ContentIdentity == "sha1:duplicate"), "content identity should deduplicate reuploads");
    }

    private static async Task TestCacheFallbackAsync()
    {
        var cache = new MemoryCache();
        var warm = new SongDiscoveryService([new FakeProvider("warm", [Candidate("See Tình", "sha1:see-tinh")])], cache);
        var first = await warm.SearchAsync("see tinh", 10);
        True(!first.UsedCache, "healthy provider result should not be marked cached");

        var offline = new SongDiscoveryService([new ThrowingProvider()], cache, TimeSpan.FromMilliseconds(50));
        var fallback = await offline.SearchAsync("see tinh", 10);
        True(fallback.UsedCache, "provider outage should use recent cache");
        Equal(1, fallback.Candidates.Count, "cached result count");
        True(fallback.Candidates[0].IsCached, "cached candidate should be marked for UI transparency");
    }

    private static async Task TestWikimediaProviderAsync()
    {
        string? requested = null;
        using var http = new HttpClient(new DelegateHandler(request =>
        {
            requested = request.RequestUri?.AbsoluteUri;
            return JsonResponse("""
                {
                  "query": {
                    "pages": [
                      {
                        "title": "File:Fur Elise piano.mid",
                        "imageinfo": [
                          {
                            "url": "https://upload.wikimedia.org/example/Fur_Elise.mid",
                            "descriptionurl": "https://commons.wikimedia.org/wiki/File:Fur_Elise_piano.mid",
                            "size": 2048,
                            "sha1": "abc123",
                            "mime": "audio/midi"
                          }
                        ]
                      }
                    ]
                  }
                }
                """ );
        }));

        var provider = new WikimediaCommonsMidiProvider(http);
        var results = await provider.SearchAsync("fur elise", 10, CancellationToken.None);
        Equal(1, results.Count, "Commons MIDI result count");
        Equal("Fur Elise piano", results[0].Title, "clean Commons title");
        Equal("sha1:abc123", results[0].ContentIdentity, "Commons content identity");
        True(requested?.Contains("gsrsearch=", StringComparison.OrdinalIgnoreCase) == true, "Commons request should use API search");
        True(requested?.Contains("filemime", StringComparison.OrdinalIgnoreCase) == true, "Commons request should constrain MIDI MIME search");
    }

    private static async Task TestInternetArchiveProviderAsync()
    {
        using var http = new HttpClient(new DelegateHandler(request =>
        {
            var uri = request.RequestUri ?? throw new InvalidOperationException("missing request URI");
            if (uri.AbsolutePath.EndsWith("/advancedsearch.php", StringComparison.Ordinal))
            {
                return JsonResponse("""
                    {
                      "response": {
                        "docs": [
                          { "identifier": "item1", "title": "Moonlight Sonata", "creator": "Beethoven" }
                        ]
                      }
                    }
                    """);
            }
            if (uri.AbsolutePath == "/metadata/item1")
            {
                return JsonResponse("""
                    {
                      "files": [
                        { "name": "metadata.xml", "source": "original", "size": "200" },
                        { "name": "moonlight.mid", "source": "original", "size": "4096", "sha1": "deadbeef" }
                      ]
                    }
                    """);
            }
            throw new InvalidOperationException("unexpected request: " + uri);
        }));

        var provider = new InternetArchiveMidiProvider(http);
        var results = await provider.SearchAsync("moonlight sonata", 10, CancellationToken.None);
        Equal(1, results.Count, "Archive MIDI result count");
        Equal("Moonlight Sonata — moonlight", results[0].Title, "Archive item/file title");
        Equal("Beethoven", results[0].Artist, "Archive creator");
        Equal("sha1:deadbeef", results[0].ContentIdentity, "Archive hash identity");
        True(results[0].DownloadUri.AbsoluteUri.Contains("/download/item1/moonlight.mid", StringComparison.Ordinal), "Archive direct download URL");
    }

    private static async Task TestOnlineImportAndDedupAsync()
    {
        using var temp = new TempTree();
        var midi = ValidMidi("Online Song");
        using var http = new HttpClient(new DelegateHandler(_ => BinaryResponse(midi)));
        var library = new SheetLibraryService(temp.Managed);
        var importer = new OnlineSongImportService(http, library, temp.Downloads);
        var candidate = Candidate("Online Song", "sha1:online");

        var first = await importer.ImportAsync(candidate);
        var second = await importer.ImportAsync(candidate);

        True(!first.AlreadyPresent, "first online import should create library entry");
        True(second.AlreadyPresent, "identical downloaded bytes should reuse local library entry");
        Equal(first.Entry.Path, second.Entry.Path, "dedupe should resolve to same managed path");
        Equal(1, library.Scan().Count(entry => entry.Status == SheetValidationStatus.Valid), "only one managed song should exist");
        True(!Path.GetFileName(first.Entry.Path).Contains("-", StringComparison.Ordinal), "managed client filename should not expose temporary GUIDs");
    }

    private static async Task TestOversizedDownloadAsync()
    {
        using var temp = new TempTree();
        using var http = new HttpClient(new DelegateHandler(_ =>
        {
            var response = BinaryResponse([0x01]);
            response.Content.Headers.ContentLength = OnlineSongImportService.MaximumDownloadBytes + 1;
            return response;
        }));
        var importer = new OnlineSongImportService(http, new SheetLibraryService(temp.Managed), temp.Downloads);

        await ThrowsAsync<FormatException>(() => importer.ImportAsync(Candidate("Huge", "sha1:huge")), "oversized remote file");
        Equal(0, Directory.EnumerateFiles(temp.Managed).Count(), "oversized file must not enter managed library");
    }

    private static async Task TestMalformedDownloadAsync()
    {
        using var temp = new TempTree();
        using var http = new HttpClient(new DelegateHandler(_ => BinaryResponse([0x00, 0x01, 0x02, 0x03])));
        var importer = new OnlineSongImportService(http, new SheetLibraryService(temp.Managed), temp.Downloads);

        await ThrowsAsync<FormatException>(() => importer.ImportAsync(Candidate("Broken", "sha1:broken")), "malformed MIDI");
        Equal(0, Directory.EnumerateFiles(temp.Managed).Count(), "malformed remote file must not enter managed library");
    }

    private static async Task TestJsonCacheRoundTripAsync()
    {
        using var temp = new TempTree();
        var cache = new JsonSongDiscoveryCache(temp.Cache);
        var source = new[] { Candidate("Cached Song", "sha1:cache") };
        await cache.SaveAsync("cached song", source, CancellationToken.None);
        var loaded = await cache.TryLoadAsync("cached song", TimeSpan.FromHours(1), CancellationToken.None);

        Equal(1, loaded.Count, "cache candidate count");
        Equal("Cached Song", loaded[0].Title, "cache title");
        True(loaded[0].IsCached, "cache round-trip should mark result cached");
    }

    private static SongDiscoveryCandidate Candidate(string title, string identity)
        => new(
            "wikimedia-commons",
            "Wikimedia Commons",
            title,
            null,
            DiscoveredSongFormat.Midi,
            new Uri("https://upload.wikimedia.org/test/song.mid"),
            new Uri("https://commons.wikimedia.org/wiki/File:Song.mid"),
            identity,
            4096);

    private static HttpResponseMessage JsonResponse(string json)
        => new(HttpStatusCode.OK)
        {
            Content = new StringContent(json, Encoding.UTF8, "application/json")
        };

    private static HttpResponseMessage BinaryResponse(byte[] bytes)
        => new(HttpStatusCode.OK)
        {
            Content = new ByteArrayContent(bytes),
            RequestMessage = new HttpRequestMessage(HttpMethod.Get, "https://upload.wikimedia.org/test/song.mid")
        };

    private static byte[] ValidMidi(string title)
    {
        var track = new List<byte>();
        track.AddRange([0x00, 0xFF, 0x03, (byte)title.Length]);
        track.AddRange(Encoding.ASCII.GetBytes(title));
        track.AddRange([0x00, 0x90, 60, 100]);
        track.AddRange([0x83, 0x60, 0x80, 60, 0]);
        track.AddRange([0x00, 0xFF, 0x2F, 0x00]);

        var bytes = new List<byte>();
        bytes.AddRange("MThd"u8.ToArray());
        bytes.AddRange([0x00, 0x00, 0x00, 0x06, 0x00, 0x00, 0x00, 0x01, 0x01, 0xE0]);
        bytes.AddRange("MTrk"u8.ToArray());
        bytes.AddRange([(byte)(track.Count >> 24), (byte)(track.Count >> 16), (byte)(track.Count >> 8), (byte)track.Count]);
        bytes.AddRange(track);
        return bytes.ToArray();
    }

    private static async Task ThrowsAsync<T>(Func<Task> action, string message) where T : Exception
    {
        try
        {
            await action().ConfigureAwait(false);
        }
        catch (T)
        {
            return;
        }
        throw new InvalidOperationException($"{message}: expected {typeof(T).Name}.");
    }

    private static void Equal<T>(T expected, T actual, string message)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }

    private sealed class FakeProvider : ISongDiscoveryProvider
    {
        private readonly IReadOnlyList<SongDiscoveryCandidate> _candidates;

        public FakeProvider(string id, IReadOnlyList<SongDiscoveryCandidate> candidates)
        {
            Id = id;
            _candidates = candidates;
        }

        public string Id { get; }
        public string DisplayName => Id;

        public Task<IReadOnlyList<SongDiscoveryCandidate>> SearchAsync(string query, int maxResults, CancellationToken cancellationToken)
            => Task.FromResult<IReadOnlyList<SongDiscoveryCandidate>>(_candidates.Take(maxResults).ToArray());
    }

    private sealed class ThrowingProvider : ISongDiscoveryProvider
    {
        public string Id => "failing";
        public string DisplayName => "Failing provider";

        public Task<IReadOnlyList<SongDiscoveryCandidate>> SearchAsync(string query, int maxResults, CancellationToken cancellationToken)
            => throw new HttpRequestException("offline");
    }

    private sealed class MemoryCache : ISongDiscoveryCache
    {
        private readonly Dictionary<string, IReadOnlyList<SongDiscoveryCandidate>> _values = new(StringComparer.OrdinalIgnoreCase);

        public ValueTask SaveAsync(string query, IReadOnlyList<SongDiscoveryCandidate> candidates, CancellationToken cancellationToken)
        {
            _values[query] = candidates.ToArray();
            return ValueTask.CompletedTask;
        }

        public ValueTask<IReadOnlyList<SongDiscoveryCandidate>> TryLoadAsync(string query, TimeSpan maxAge, CancellationToken cancellationToken)
            => ValueTask.FromResult(_values.TryGetValue(query, out var values) ? values : Array.Empty<SongDiscoveryCandidate>());
    }

    private sealed class DelegateHandler : HttpMessageHandler
    {
        private readonly Func<HttpRequestMessage, HttpResponseMessage> _handler;

        public DelegateHandler(Func<HttpRequestMessage, HttpResponseMessage> handler)
        {
            _handler = handler;
        }

        protected override Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)
        {
            var response = _handler(request);
            response.RequestMessage ??= request;
            return Task.FromResult(response);
        }
    }

    private sealed class TempTree : IDisposable
    {
        public TempTree()
        {
            Root = Path.Combine(Path.GetTempPath(), "RobloxPiano.DiscoveryTests", Guid.NewGuid().ToString("N"));
            Managed = Path.Combine(Root, "managed");
            Downloads = Path.Combine(Root, "downloads");
            Cache = Path.Combine(Root, "cache");
            Directory.CreateDirectory(Managed);
            Directory.CreateDirectory(Downloads);
        }

        public string Root { get; }
        public string Managed { get; }
        public string Downloads { get; }
        public string Cache { get; }

        public void Dispose()
        {
            try
            {
                Directory.Delete(Root, recursive: true);
            }
            catch
            {
            }
        }
    }
}
