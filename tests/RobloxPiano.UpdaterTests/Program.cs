using System.Net;
using System.Text;
using System.Text.Json;
using RobloxPiano.Updater;

namespace RobloxPiano.UpdaterTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var tests = new (string Name, Func<Task> Run)[]
        {
            ("strict release versions compare without downgrade ambiguity", TestVersionsAsync),
            ("latest release parser requires immutable stable release assets", TestReleaseParserAsync),
            ("release client only returns strictly newer stable version", TestFindUpdateAsync),
            ("trusted GitHub redirects download successfully", TestTrustedRedirectAsync),
            ("untrusted update redirect is rejected", TestUntrustedRedirectAsync),
            ("stager verifies checksum, GitHub digest, size and disk bytes", TestStageSuccessAsync),
            ("checksum mismatch never leaves a staged executable", TestChecksumMismatchAsync),
            ("GitHub digest disagreement is rejected before executable download", TestDigestDisagreementAsync),
            ("atomic replacement installs verified bytes and removes backup", TestAtomicReplaceAsync),
            ("bad staged hash preserves the current executable", TestAtomicRejectAsync)
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
        Console.WriteLine($"Updater tests: {tests.Length - failures.Count} passed, {failures.Count} failed.");
        return failures.Count == 0 ? 0 : 1;
    }

    private static Task TestVersionsAsync()
    {
        Equal(new ReleaseVersion(0, 10, 0), ReleaseVersion.ParseCore("0.10.0"), "core version parse");
        Equal(new ReleaseVersion(1, 2, 3), ReleaseVersion.ParseTag("v1.2.3"), "tag version parse");
        True(ReleaseVersion.ParseCore("0.11.0") > ReleaseVersion.ParseCore("0.10.9"), "minor upgrade ordering");
        True(ReleaseVersion.ParseCore("1.0.0") > ReleaseVersion.ParseCore("0.99.99"), "major upgrade ordering");
        True(!ReleaseVersion.TryParseCore("0.010.0", out _), "leading-zero SemVer component should fail");
        True(!ReleaseVersion.TryParseCore("0.10", out _), "two-component version should fail");
        True(!ReleaseVersion.TryParseTag("0.10.0", out _), "release tag must retain v prefix");
        return Task.CompletedTask;
    }

    private static Task TestReleaseParserAsync()
    {
        var executable = Encoding.UTF8.GetBytes("candidate-v0.11.0");
        var hash = UpdateHash.Compute(executable);
        using var document = JsonDocument.Parse(ReleaseJson("v0.11.0", hash, executable.LongLength));
        var release = GitHubReleaseClient.ParseRelease(document.RootElement);

        Equal(new ReleaseVersion(0, 11, 0), release.Version, "release version");
        Equal(new string('a', 40), release.TargetCommit, "immutable target SHA");
        Equal(hash, release.ExecutableDigestSha256, "GitHub digest");
        Equal(executable.LongLength, release.ExecutableSize, "release executable size");

        using var movingTarget = JsonDocument.Parse(ReleaseJson("v0.11.0", hash, executable.LongLength, target: "main"));
        Throws<FormatException>(() => GitHubReleaseClient.ParseRelease(movingTarget.RootElement), "moving branch target");

        using var missingChecksum = JsonDocument.Parse(ReleaseJson("v0.11.0", hash, executable.LongLength, includeChecksum: false));
        Throws<FormatException>(() => GitHubReleaseClient.ParseRelease(missingChecksum.RootElement), "missing checksum asset");
        return Task.CompletedTask;
    }

    private static async Task TestFindUpdateAsync()
    {
        var executable = Encoding.UTF8.GetBytes("candidate");
        var hash = UpdateHash.Compute(executable);
        using var newerHttp = new HttpClient(new DelegateHandler(_ => JsonResponse(ReleaseJson("v0.11.0", hash, executable.LongLength))));
        var client = new GitHubReleaseClient(newerHttp);
        var newer = await client.FindUpdateAsync(new ReleaseVersion(0, 10, 0));
        True(newer is not null && newer.Version == new ReleaseVersion(0, 11, 0), "newer release should be returned");

        using var sameHttp = new HttpClient(new DelegateHandler(_ => JsonResponse(ReleaseJson("v0.10.0", hash, executable.LongLength))));
        var same = await new GitHubReleaseClient(sameHttp).FindUpdateAsync(new ReleaseVersion(0, 10, 0));
        True(same is null, "same version should not trigger update");

        using var olderHttp = new HttpClient(new DelegateHandler(_ => JsonResponse(ReleaseJson("v0.9.9", hash, executable.LongLength))));
        var older = await new GitHubReleaseClient(olderHttp).FindUpdateAsync(new ReleaseVersion(0, 10, 0));
        True(older is null, "downgrade should never be offered");
    }

    private static async Task TestTrustedRedirectAsync()
    {
        var bytes = Encoding.UTF8.GetBytes("verified release bytes");
        using var http = new HttpClient(new DelegateHandler(request =>
        {
            var uri = request.RequestUri ?? throw new InvalidOperationException("missing URI");
            if (uri.Host == "github.com")
            {
                return Redirect("https://release-assets.githubusercontent.com/roblox-piano/update.bin");
            }
            if (uri.Host == "release-assets.githubusercontent.com")
            {
                return BinaryResponse(bytes);
            }
            throw new InvalidOperationException("unexpected URI " + uri);
        }));

        var downloader = new TrustedGitHubAssetDownloader(http);
        var downloaded = await downloader.DownloadBytesAsync(
            new Uri("https://github.com/Longdotnet/APK-test/releases/download/v0.11.0/RobloxPiano.exe"),
            1024);
        SequenceEqual(bytes, downloaded, "trusted redirect bytes");
    }

    private static async Task TestUntrustedRedirectAsync()
    {
        using var http = new HttpClient(new DelegateHandler(_ => Redirect("https://evil.example/payload.exe")));
        var downloader = new TrustedGitHubAssetDownloader(http);
        await ThrowsAsync<FormatException>(
            () => downloader.DownloadBytesAsync(
                new Uri("https://github.com/Longdotnet/APK-test/releases/download/v0.11.0/RobloxPiano.exe"),
                1024),
            "untrusted redirect");
    }

    private static async Task TestStageSuccessAsync()
    {
        using var temp = new TempTree();
        var executable = Encoding.UTF8.GetBytes("self-contained executable bytes");
        var hash = UpdateHash.Compute(executable);
        var release = Release(hash, executable.LongLength);
        using var http = PackageHttp(executable, $"{hash}  RobloxPiano.exe\n");
        var stager = new UpdatePackageStager(new TrustedGitHubAssetDownloader(http));

        var staged = await stager.StageAsync(release, temp.Root);
        True(File.Exists(staged.ExecutablePath), "staged executable exists");
        Equal(hash, staged.Sha256, "staged hash");
        Equal(hash, await UpdateHash.ComputeFileAsync(staged.ExecutablePath), "staged disk hash");
        True(staged.ExecutablePath.EndsWith(Path.Combine("v0.11.0", "RobloxPiano.exe"), StringComparison.OrdinalIgnoreCase), "stable staging path");
    }

    private static async Task TestChecksumMismatchAsync()
    {
        using var temp = new TempTree();
        var executable = Encoding.UTF8.GetBytes("payload");
        var realHash = UpdateHash.Compute(executable);
        var wrongHash = new string(realHash[0] == '0' ? '1' : '0', 64);
        var release = Release(null, executable.LongLength);
        using var http = PackageHttp(executable, $"{wrongHash}  RobloxPiano.exe\n");
        var stager = new UpdatePackageStager(new TrustedGitHubAssetDownloader(http));

        await ThrowsAsync<FormatException>(() => stager.StageAsync(release, temp.Root), "checksum mismatch");
        True(!Directory.EnumerateFiles(temp.Root, "RobloxPiano.exe", SearchOption.AllDirectories).Any(), "failed package must not leave final executable");
    }

    private static async Task TestDigestDisagreementAsync()
    {
        using var temp = new TempTree();
        var executable = Encoding.UTF8.GetBytes("payload");
        var realHash = UpdateHash.Compute(executable);
        var metadataHash = new string(realHash[0] == '0' ? '1' : '0', 64);
        var executableRequests = 0;
        using var http = new HttpClient(new DelegateHandler(request =>
        {
            var path = request.RequestUri?.AbsolutePath ?? string.Empty;
            if (path.EndsWith(".sha256", StringComparison.Ordinal))
            {
                return BinaryResponse(Encoding.UTF8.GetBytes($"{realHash}  RobloxPiano.exe"));
            }
            executableRequests++;
            return BinaryResponse(executable);
        }));

        var stager = new UpdatePackageStager(new TrustedGitHubAssetDownloader(http));
        await ThrowsAsync<FormatException>(
            () => stager.StageAsync(Release(metadataHash, executable.LongLength), temp.Root),
            "metadata/checksum disagreement");
        Equal(0, executableRequests, "executable should not download when signed evidence disagrees early");
    }

    private static async Task TestAtomicReplaceAsync()
    {
        using var temp = new TempTree();
        var stagedPath = Path.Combine(temp.Root, "staged.exe");
        var targetPath = Path.Combine(temp.Root, "RobloxPiano.exe");
        await File.WriteAllBytesAsync(stagedPath, Encoding.UTF8.GetBytes("new version"));
        await File.WriteAllBytesAsync(targetPath, Encoding.UTF8.GetBytes("old version"));
        var expected = await UpdateHash.ComputeFileAsync(stagedPath);

        await AtomicUpdateApplier.ReplaceVerifiedFileAsync(stagedPath, targetPath, expected);
        Equal(expected, await UpdateHash.ComputeFileAsync(targetPath), "target replaced with verified bytes");
        True(!File.Exists(targetPath + ".update.previous"), "successful backup cleanup");
        True(!File.Exists(targetPath + ".update.new"), "successful temporary cleanup");
    }

    private static async Task TestAtomicRejectAsync()
    {
        using var temp = new TempTree();
        var stagedPath = Path.Combine(temp.Root, "staged.exe");
        var targetPath = Path.Combine(temp.Root, "RobloxPiano.exe");
        await File.WriteAllBytesAsync(stagedPath, Encoding.UTF8.GetBytes("tampered new version"));
        await File.WriteAllBytesAsync(targetPath, Encoding.UTF8.GetBytes("known good old version"));
        var before = await UpdateHash.ComputeFileAsync(targetPath);
        var wrongExpected = new string('0', 64);

        await ThrowsAsync<FormatException>(
            () => AtomicUpdateApplier.ReplaceVerifiedFileAsync(stagedPath, targetPath, wrongExpected),
            "tampered staged file");
        Equal(before, await UpdateHash.ComputeFileAsync(targetPath), "current executable preserved");
    }

    private static UpdateRelease Release(string? digest, long size)
        => new(
            new ReleaseVersion(0, 11, 0),
            "v0.11.0",
            new string('a', 40),
            new Uri("https://github.com/Longdotnet/APK-test/releases/download/v0.11.0/RobloxPiano.exe"),
            new Uri("https://github.com/Longdotnet/APK-test/releases/download/v0.11.0/RobloxPiano.exe.sha256"),
            size,
            digest);

    private static HttpClient PackageHttp(byte[] executable, string checksum)
        => new(new DelegateHandler(request =>
        {
            var path = request.RequestUri?.AbsolutePath ?? string.Empty;
            return path.EndsWith(".sha256", StringComparison.Ordinal)
                ? BinaryResponse(Encoding.UTF8.GetBytes(checksum))
                : BinaryResponse(executable);
        }));

    private static string ReleaseJson(
        string tag,
        string hash,
        long size,
        string? target = null,
        bool includeChecksum = true)
    {
        var checksumAsset = includeChecksum
            ? ", { \"name\": \"RobloxPiano.exe.sha256\", \"size\": 81, \"browser_download_url\": \"https://github.com/Longdotnet/APK-test/releases/download/" + tag + "/RobloxPiano.exe.sha256\" }"
            : string.Empty;
        return $$"""
        {
          "tag_name": "{{tag}}",
          "target_commitish": "{{target ?? new string('a', 40)}}",
          "draft": false,
          "prerelease": false,
          "assets": [
            {
              "name": "RobloxPiano.exe",
              "size": {{size}},
              "digest": "sha256:{{hash}}",
              "browser_download_url": "https://github.com/Longdotnet/APK-test/releases/download/{{tag}}/RobloxPiano.exe"
            }
            {{checksumAsset}}
          ]
        }
        """;
    }

    private static HttpResponseMessage JsonResponse(string json)
        => new(HttpStatusCode.OK)
        {
            Content = new StringContent(json, Encoding.UTF8, "application/json")
        };

    private static HttpResponseMessage BinaryResponse(byte[] bytes)
        => new(HttpStatusCode.OK)
        {
            Content = new ByteArrayContent(bytes)
        };

    private static HttpResponseMessage Redirect(string location)
    {
        var response = new HttpResponseMessage(HttpStatusCode.Redirect);
        response.Headers.Location = new Uri(location);
        return response;
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

    private static void Throws<T>(Action action, string message) where T : Exception
    {
        try
        {
            action();
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

    private static void SequenceEqual(byte[] expected, byte[] actual, string message)
    {
        if (!expected.AsSpan().SequenceEqual(actual))
        {
            throw new InvalidOperationException(message);
        }
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
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
            Root = Path.Combine(Path.GetTempPath(), "RobloxPiano.UpdaterTests", Guid.NewGuid().ToString("N"));
            Directory.CreateDirectory(Root);
        }

        public string Root { get; }

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
