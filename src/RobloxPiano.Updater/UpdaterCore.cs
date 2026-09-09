using System.Diagnostics;
using System.Globalization;
using System.Net;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;

namespace RobloxPiano.Updater;

public readonly record struct ReleaseVersion(int Major, int Minor, int Patch) : IComparable<ReleaseVersion>
{
    public static ReleaseVersion ParseCore(string value)
        => TryParseCore(value, out var version)
            ? version
            : throw new FormatException($"Invalid release version '{value}'. Expected strict x.y.z.");

    public static ReleaseVersion ParseTag(string value)
        => TryParseTag(value, out var version)
            ? version
            : throw new FormatException($"Invalid release tag '{value}'. Expected strict vX.Y.Z.");

    public static bool TryParseCore(string? value, out ReleaseVersion version)
    {
        version = default;
        if (string.IsNullOrWhiteSpace(value))
        {
            return false;
        }

        var parts = value.Split('.', StringSplitOptions.None);
        if (parts.Length != 3
            || !TryParseComponent(parts[0], out var major)
            || !TryParseComponent(parts[1], out var minor)
            || !TryParseComponent(parts[2], out var patch))
        {
            return false;
        }

        version = new ReleaseVersion(major, minor, patch);
        return true;
    }

    public static bool TryParseTag(string? value, out ReleaseVersion version)
    {
        version = default;
        return !string.IsNullOrWhiteSpace(value)
               && value.Length > 1
               && value[0] == 'v'
               && TryParseCore(value[1..], out version);
    }

    public int CompareTo(ReleaseVersion other)
    {
        var major = Major.CompareTo(other.Major);
        if (major != 0)
        {
            return major;
        }

        var minor = Minor.CompareTo(other.Minor);
        return minor != 0 ? minor : Patch.CompareTo(other.Patch);
    }

    public override string ToString() => $"{Major}.{Minor}.{Patch}";

    public string ToTag() => $"v{this}";

    public static bool operator >(ReleaseVersion left, ReleaseVersion right) => left.CompareTo(right) > 0;
    public static bool operator <(ReleaseVersion left, ReleaseVersion right) => left.CompareTo(right) < 0;
    public static bool operator >=(ReleaseVersion left, ReleaseVersion right) => left.CompareTo(right) >= 0;
    public static bool operator <=(ReleaseVersion left, ReleaseVersion right) => left.CompareTo(right) <= 0;

    private static bool TryParseComponent(string value, out int component)
    {
        component = default;
        if (value.Length == 0 || (value.Length > 1 && value[0] == '0'))
        {
            return false;
        }

        return value.All(char.IsAsciiDigit)
               && int.TryParse(value, NumberStyles.None, CultureInfo.InvariantCulture, out component);
    }
}

public sealed record UpdateRelease(
    ReleaseVersion Version,
    string Tag,
    string TargetCommit,
    Uri ExecutableUri,
    Uri ChecksumUri,
    long ExecutableSize,
    string? ExecutableDigestSha256);

public sealed class GitHubReleaseClient
{
    public const string RepositoryOwner = "Longdotnet";
    public const string RepositoryName = "APK-test";

    private static readonly Uri LatestReleaseUri = new(
        $"https://api.github.com/repos/{RepositoryOwner}/{RepositoryName}/releases/latest");

    private readonly HttpClient _httpClient;

    public GitHubReleaseClient(HttpClient httpClient)
    {
        _httpClient = httpClient ?? throw new ArgumentNullException(nameof(httpClient));
    }

    public async Task<UpdateRelease?> FindUpdateAsync(
        ReleaseVersion currentVersion,
        CancellationToken cancellationToken = default)
    {
        using var request = new HttpRequestMessage(HttpMethod.Get, LatestReleaseUri);
        request.Headers.UserAgent.ParseAdd($"RobloxPiano/{currentVersion}");
        request.Headers.Accept.ParseAdd("application/vnd.github+json");
        request.Headers.Add("X-GitHub-Api-Version", "2022-11-28");

        using var response = await _httpClient.SendAsync(
            request,
            HttpCompletionOption.ResponseHeadersRead,
            cancellationToken).ConfigureAwait(false);
        response.EnsureSuccessStatusCode();

        await using var stream = await response.Content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false);
        using var document = await JsonDocument.ParseAsync(stream, cancellationToken: cancellationToken).ConfigureAwait(false);
        var release = ParseRelease(document.RootElement);
        return release.Version > currentVersion ? release : null;
    }

    public static UpdateRelease ParseRelease(JsonElement root)
    {
        if (root.ValueKind != JsonValueKind.Object)
        {
            throw new FormatException("GitHub latest release response must be an object.");
        }

        if (TryGetBoolean(root, "draft") || TryGetBoolean(root, "prerelease"))
        {
            throw new FormatException("Latest release must be a published stable release.");
        }

        var tag = RequiredString(root, "tag_name");
        var version = ReleaseVersion.ParseTag(tag);
        var targetCommit = RequiredString(root, "target_commitish");
        if (!IsSha40(targetCommit))
        {
            throw new FormatException("Release target must be an immutable 40-character commit SHA.");
        }

        if (!root.TryGetProperty("assets", out var assets) || assets.ValueKind != JsonValueKind.Array)
        {
            throw new FormatException("Release assets are missing.");
        }

        JsonElement? executable = null;
        JsonElement? checksum = null;
        foreach (var asset in assets.EnumerateArray())
        {
            var name = OptionalString(asset, "name");
            if (name == "RobloxPiano.exe")
            {
                if (executable is not null)
                {
                    throw new FormatException("Release contains duplicate RobloxPiano.exe assets.");
                }
                executable = asset;
            }
            else if (name == "RobloxPiano.exe.sha256")
            {
                if (checksum is not null)
                {
                    throw new FormatException("Release contains duplicate checksum assets.");
                }
                checksum = asset;
            }
        }

        if (executable is null || checksum is null)
        {
            throw new FormatException("Release must contain RobloxPiano.exe and RobloxPiano.exe.sha256.");
        }

        var executableUri = RequiredHttpsUri(executable.Value, "browser_download_url");
        var checksumUri = RequiredHttpsUri(checksum.Value, "browser_download_url");
        if (!TrustedGitHubAssetDownloader.IsTrustedInitialUri(executableUri)
            || !TrustedGitHubAssetDownloader.IsTrustedInitialUri(checksumUri))
        {
            throw new FormatException("Release asset URL is outside the trusted GitHub release origin.");
        }

        var executableSize = RequiredInt64(executable.Value, "size");
        if (executableSize <= 0 || executableSize > UpdatePackageStager.MaximumExecutableBytes)
        {
            throw new FormatException("Release executable size is outside the safe update limit.");
        }

        var digest = OptionalString(executable.Value, "digest");
        string? digestHash = null;
        if (!string.IsNullOrWhiteSpace(digest))
        {
            const string prefix = "sha256:";
            if (!digest.StartsWith(prefix, StringComparison.OrdinalIgnoreCase)
                || !UpdateHash.IsSha256(digest[prefix.Length..]))
            {
                throw new FormatException("Release executable digest is not a valid SHA-256 digest.");
            }
            digestHash = digest[prefix.Length..].ToLowerInvariant();
        }

        return new UpdateRelease(
            version,
            tag,
            targetCommit.ToLowerInvariant(),
            executableUri,
            checksumUri,
            executableSize,
            digestHash);
    }

    private static bool TryGetBoolean(JsonElement element, string name)
        => element.TryGetProperty(name, out var property)
           && property.ValueKind == JsonValueKind.True;

    private static string RequiredString(JsonElement element, string name)
        => OptionalString(element, name) is { Length: > 0 } value
            ? value
            : throw new FormatException($"Release field '{name}' is missing.");

    private static string? OptionalString(JsonElement element, string name)
        => element.TryGetProperty(name, out var property) && property.ValueKind == JsonValueKind.String
            ? property.GetString()
            : null;

    private static long RequiredInt64(JsonElement element, string name)
        => element.TryGetProperty(name, out var property) && property.TryGetInt64(out var value)
            ? value
            : throw new FormatException($"Release field '{name}' is missing or invalid.");

    private static Uri RequiredHttpsUri(JsonElement element, string name)
    {
        var value = RequiredString(element, name);
        if (!Uri.TryCreate(value, UriKind.Absolute, out var uri)
            || !uri.Scheme.Equals(Uri.UriSchemeHttps, StringComparison.OrdinalIgnoreCase))
        {
            throw new FormatException($"Release field '{name}' must be an absolute HTTPS URL.");
        }
        return uri;
    }

    private static bool IsSha40(string value)
        => value.Length == 40 && value.All(Uri.IsHexDigit);
}

public sealed class TrustedGitHubAssetDownloader
{
    private const int MaximumRedirects = 5;
    private readonly HttpClient _httpClient;

    public TrustedGitHubAssetDownloader(HttpClient httpClient)
    {
        _httpClient = httpClient ?? throw new ArgumentNullException(nameof(httpClient));
    }

    public async Task<byte[]> DownloadBytesAsync(
        Uri initialUri,
        long maximumBytes,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(initialUri);
        if (maximumBytes <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(maximumBytes));
        }
        if (!IsTrustedInitialUri(initialUri))
        {
            throw new FormatException("Update download must begin at the trusted GitHub release origin.");
        }

        var current = initialUri;
        for (var redirect = 0; redirect <= MaximumRedirects; redirect++)
        {
            using var request = new HttpRequestMessage(HttpMethod.Get, current);
            request.Headers.UserAgent.ParseAdd("RobloxPiano-Updater/1.0");
            using var response = await _httpClient.SendAsync(
                request,
                HttpCompletionOption.ResponseHeadersRead,
                cancellationToken).ConfigureAwait(false);

            if (IsRedirect(response.StatusCode))
            {
                if (redirect == MaximumRedirects)
                {
                    throw new HttpRequestException("Update download exceeded the redirect limit.");
                }

                var location = response.Headers.Location
                    ?? throw new HttpRequestException("Update redirect did not include a Location header.");
                current = location.IsAbsoluteUri ? location : new Uri(current, location);
                if (!IsTrustedRedirectUri(current))
                {
                    throw new FormatException($"Update redirect host '{current.Host}' is not trusted.");
                }
                continue;
            }

            response.EnsureSuccessStatusCode();
            if (!IsTrustedRedirectUri(current))
            {
                throw new FormatException($"Update download host '{current.Host}' is not trusted.");
            }

            if (response.Content.Headers.ContentLength is long declared && declared > maximumBytes)
            {
                throw new FormatException("Update asset exceeds the safe download size limit.");
            }

            await using var source = await response.Content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false);
            using var buffer = new MemoryStream();
            var chunk = new byte[64 * 1024];
            while (true)
            {
                var read = await source.ReadAsync(chunk, cancellationToken).ConfigureAwait(false);
                if (read == 0)
                {
                    break;
                }
                if (buffer.Length + read > maximumBytes)
                {
                    throw new FormatException("Update asset exceeds the safe download size limit.");
                }
                buffer.Write(chunk, 0, read);
            }
            return buffer.ToArray();
        }

        throw new HttpRequestException("Update download did not resolve to a final response.");
    }

    public static bool IsTrustedInitialUri(Uri uri)
        => IsHttps(uri) && uri.Host.Equals("github.com", StringComparison.OrdinalIgnoreCase);

    public static bool IsTrustedRedirectUri(Uri uri)
    {
        if (!IsHttps(uri))
        {
            return false;
        }

        return uri.Host.Equals("github.com", StringComparison.OrdinalIgnoreCase)
               || uri.Host.Equals("release-assets.githubusercontent.com", StringComparison.OrdinalIgnoreCase)
               || uri.Host.Equals("objects.githubusercontent.com", StringComparison.OrdinalIgnoreCase)
               || uri.Host.Equals("github-releases.githubusercontent.com", StringComparison.OrdinalIgnoreCase);
    }

    private static bool IsHttps(Uri uri)
        => uri.IsAbsoluteUri && uri.Scheme.Equals(Uri.UriSchemeHttps, StringComparison.OrdinalIgnoreCase);

    private static bool IsRedirect(HttpStatusCode statusCode)
        => statusCode is HttpStatusCode.Moved
            or HttpStatusCode.Redirect
            or HttpStatusCode.RedirectMethod
            or HttpStatusCode.TemporaryRedirect
            or HttpStatusCode.PermanentRedirect;
}

public sealed record StagedUpdate(
    UpdateRelease Release,
    string ExecutablePath,
    string Sha256);

public sealed class UpdatePackageStager
{
    public const long MaximumExecutableBytes = 160L * 1024 * 1024;
    private const long MaximumChecksumBytes = 4096;

    private readonly TrustedGitHubAssetDownloader _downloader;

    public UpdatePackageStager(TrustedGitHubAssetDownloader downloader)
    {
        _downloader = downloader ?? throw new ArgumentNullException(nameof(downloader));
    }

    public async Task<StagedUpdate> StageAsync(
        UpdateRelease release,
        string stagingRoot,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(release);
        ArgumentException.ThrowIfNullOrWhiteSpace(stagingRoot);

        var checksumBytes = await _downloader.DownloadBytesAsync(
            release.ChecksumUri,
            MaximumChecksumBytes,
            cancellationToken).ConfigureAwait(false);
        var checksumText = Encoding.UTF8.GetString(checksumBytes);
        var expectedHash = ParseChecksum(checksumText);

        if (release.ExecutableDigestSha256 is not null
            && !expectedHash.Equals(release.ExecutableDigestSha256, StringComparison.OrdinalIgnoreCase))
        {
            throw new FormatException("Release checksum and GitHub asset digest disagree.");
        }

        var executableBytes = await _downloader.DownloadBytesAsync(
            release.ExecutableUri,
            MaximumExecutableBytes,
            cancellationToken).ConfigureAwait(false);
        if (executableBytes.LongLength != release.ExecutableSize)
        {
            throw new FormatException(
                $"Downloaded update size {executableBytes.LongLength} does not match release metadata {release.ExecutableSize}.");
        }

        var actualHash = UpdateHash.Compute(executableBytes);
        if (!actualHash.Equals(expectedHash, StringComparison.OrdinalIgnoreCase))
        {
            throw new FormatException("Downloaded update failed SHA-256 verification.");
        }

        var root = Path.GetFullPath(stagingRoot);
        var versionDirectory = Path.Combine(root, release.Tag);
        Directory.CreateDirectory(versionDirectory);
        var finalPath = Path.Combine(versionDirectory, "RobloxPiano.exe");
        var temporaryPath = finalPath + "." + Guid.NewGuid().ToString("N") + ".tmp";

        try
        {
            await File.WriteAllBytesAsync(temporaryPath, executableBytes, cancellationToken).ConfigureAwait(false);
            var diskHash = await UpdateHash.ComputeFileAsync(temporaryPath, cancellationToken).ConfigureAwait(false);
            if (!diskHash.Equals(expectedHash, StringComparison.OrdinalIgnoreCase))
            {
                throw new IOException("Staged update hash changed while writing to disk.");
            }
            File.Move(temporaryPath, finalPath, overwrite: true);
        }
        finally
        {
            TryDelete(temporaryPath);
        }

        return new StagedUpdate(release, finalPath, expectedHash);
    }

    public static string ParseChecksum(string text)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(text);
        var lines = text
            .Split(['\r', '\n'], StringSplitOptions.RemoveEmptyEntries | StringSplitOptions.TrimEntries);
        if (lines.Length != 1)
        {
            throw new FormatException("Release checksum file must contain exactly one checksum line.");
        }

        var parts = lines[0].Split([' ', '\t'], StringSplitOptions.RemoveEmptyEntries | StringSplitOptions.TrimEntries);
        if (parts.Length != 2 || !UpdateHash.IsSha256(parts[0]))
        {
            throw new FormatException("Release checksum line is malformed.");
        }

        var fileName = parts[1].TrimStart('*');
        if (!fileName.Equals("RobloxPiano.exe", StringComparison.Ordinal))
        {
            throw new FormatException("Release checksum must identify RobloxPiano.exe exactly.");
        }

        return parts[0].ToLowerInvariant();
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

public static class AtomicUpdateApplier
{
    public static async Task ReplaceVerifiedFileAsync(
        string stagedPath,
        string targetPath,
        string expectedSha256,
        CancellationToken cancellationToken = default)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(stagedPath);
        ArgumentException.ThrowIfNullOrWhiteSpace(targetPath);
        if (!UpdateHash.IsSha256(expectedSha256))
        {
            throw new ArgumentException("Expected update hash is not a valid SHA-256 value.", nameof(expectedSha256));
        }

        var staged = Path.GetFullPath(stagedPath);
        var target = Path.GetFullPath(targetPath);
        if (!File.Exists(staged))
        {
            throw new FileNotFoundException("Staged update executable does not exist.", staged);
        }

        var stagedHash = await UpdateHash.ComputeFileAsync(staged, cancellationToken).ConfigureAwait(false);
        if (!stagedHash.Equals(expectedSha256, StringComparison.OrdinalIgnoreCase))
        {
            throw new FormatException("Staged updater executable failed SHA-256 verification.");
        }

        var directory = Path.GetDirectoryName(target)
            ?? throw new IOException("Target executable does not have a parent directory.");
        Directory.CreateDirectory(directory);
        var newPath = target + ".update.new";
        var backupPath = target + ".update.previous";
        TryDelete(newPath);
        TryDelete(backupPath);

        try
        {
            await CopyFileAsync(staged, newPath, cancellationToken).ConfigureAwait(false);
            var newHash = await UpdateHash.ComputeFileAsync(newPath, cancellationToken).ConfigureAwait(false);
            if (!newHash.Equals(expectedSha256, StringComparison.OrdinalIgnoreCase))
            {
                throw new IOException("Update copy failed verification before atomic replacement.");
            }

            if (File.Exists(target))
            {
                File.Replace(newPath, target, backupPath, ignoreMetadataErrors: true);
            }
            else
            {
                File.Move(newPath, target);
            }

            var finalHash = await UpdateHash.ComputeFileAsync(target, cancellationToken).ConfigureAwait(false);
            if (!finalHash.Equals(expectedSha256, StringComparison.OrdinalIgnoreCase))
            {
                TryRestoreBackup(target, backupPath);
                throw new IOException("Updated executable failed verification after replacement.");
            }

            TryDelete(backupPath);
        }
        finally
        {
            TryDelete(newPath);
        }
    }

    public static async Task WaitForProcessExitAsync(
        int processId,
        TimeSpan timeout,
        CancellationToken cancellationToken = default)
    {
        if (processId <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(processId));
        }
        if (timeout <= TimeSpan.Zero)
        {
            throw new ArgumentOutOfRangeException(nameof(timeout));
        }

        Process? process;
        try
        {
            process = Process.GetProcessById(processId);
        }
        catch (ArgumentException)
        {
            return;
        }

        using (process)
        using (var timeoutSource = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken))
        {
            timeoutSource.CancelAfter(timeout);
            try
            {
                await process.WaitForExitAsync(timeoutSource.Token).ConfigureAwait(false);
            }
            catch (OperationCanceledException) when (!cancellationToken.IsCancellationRequested)
            {
                throw new TimeoutException("The running Roblox Piano process did not exit before the update timeout.");
            }
        }
    }

    private static async Task CopyFileAsync(string sourcePath, string destinationPath, CancellationToken cancellationToken)
    {
        await using var source = new FileStream(
            sourcePath,
            FileMode.Open,
            FileAccess.Read,
            FileShare.Read,
            bufferSize: 128 * 1024,
            FileOptions.Asynchronous | FileOptions.SequentialScan);
        await using var destination = new FileStream(
            destinationPath,
            FileMode.CreateNew,
            FileAccess.Write,
            FileShare.None,
            bufferSize: 128 * 1024,
            FileOptions.Asynchronous | FileOptions.SequentialScan);
        await source.CopyToAsync(destination, cancellationToken).ConfigureAwait(false);
        await destination.FlushAsync(cancellationToken).ConfigureAwait(false);
    }

    private static void TryRestoreBackup(string targetPath, string backupPath)
    {
        try
        {
            if (File.Exists(backupPath))
            {
                File.Replace(backupPath, targetPath, null, ignoreMetadataErrors: true);
            }
        }
        catch
        {
        }
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

public static class UpdateHash
{
    public static string Compute(ReadOnlySpan<byte> bytes)
        => Convert.ToHexString(SHA256.HashData(bytes)).ToLowerInvariant();

    public static async Task<string> ComputeFileAsync(
        string path,
        CancellationToken cancellationToken = default)
    {
        await using var stream = new FileStream(
            path,
            FileMode.Open,
            FileAccess.Read,
            FileShare.Read,
            bufferSize: 128 * 1024,
            FileOptions.Asynchronous | FileOptions.SequentialScan);
        var hash = await SHA256.HashDataAsync(stream, cancellationToken).ConfigureAwait(false);
        return Convert.ToHexString(hash).ToLowerInvariant();
    }

    public static bool IsSha256(string? value)
        => value is { Length: 64 } && value.All(Uri.IsHexDigit);
}
