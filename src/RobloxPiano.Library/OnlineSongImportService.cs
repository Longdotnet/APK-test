using System.Security.Cryptography;

namespace RobloxPiano.Library;

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
        _temporaryDirectory = Path.GetFullPath(
            temporaryDirectory ?? Path.Combine(Path.GetTempPath(), "RobloxPiano", "online-import"));
    }

    public async Task<OnlineSongImportResult> ImportAsync(
        SongDiscoveryCandidate candidate,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(candidate);
        ValidateDownloadUri(candidate.ProviderId, candidate.DownloadUri);
        Directory.CreateDirectory(_temporaryDirectory);

        var operationDirectory = Path.Combine(_temporaryDirectory, Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(operationDirectory);
        var extension = candidate.DownloadUri.AbsolutePath.EndsWith(".midi", StringComparison.OrdinalIgnoreCase)
            ? ".midi"
            : ".mid";
        var temporary = Path.Combine(operationDirectory, SanitizeFileName(candidate.Title) + extension);

        try
        {
            using var request = SongDiscoveryHttp.CreateGet(candidate.DownloadUri);
            using var response = await _httpClient.SendAsync(
                request,
                HttpCompletionOption.ResponseHeadersRead,
                cancellationToken).ConfigureAwait(false);
            response.EnsureSuccessStatusCode();

            var finalUri = response.RequestMessage?.RequestUri ?? candidate.DownloadUri;
            ValidateDownloadUri(candidate.ProviderId, finalUri);
            if (response.Content.Headers.ContentLength is > MaximumDownloadBytes)
            {
                throw new FormatException("This online MIDI is too large to import safely.");
            }

            await DownloadBoundedAsync(response.Content, temporary, cancellationToken).ConfigureAwait(false);

            // Never trust provider extension/metadata. The managed Library performs the
            // same deterministic MIDI parse/validation as a local client import.
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
            TryDeleteDirectory(operationDirectory);
        }
    }

    private static async Task DownloadBoundedAsync(
        HttpContent content,
        string destinationPath,
        CancellationToken cancellationToken)
    {
        await using var source = await content.ReadAsStreamAsync(cancellationToken).ConfigureAwait(false);
        await using var destination = new FileStream(
            destinationPath,
            FileMode.CreateNew,
            FileAccess.Write,
            FileShare.None,
            81920,
            useAsync: true);

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

        if (total == 0)
        {
            throw new FormatException("The online MIDI download was empty.");
        }
    }

    private SheetLibraryEntry? FindEquivalentManagedSong(string downloadedPath)
    {
        if (!Directory.Exists(_library.ManagedDirectory))
        {
            return null;
        }

        var downloadedHash = HashFile(downloadedPath);
        var catalog = _library.Scan();
        foreach (var entry in catalog.Where(entry => entry.IsManaged && entry.Status == SheetValidationStatus.Valid))
        {
            try
            {
                if (CryptographicOperations.FixedTimeEquals(downloadedHash, HashFile(entry.Path)))
                {
                    return entry;
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

    internal static void ValidateDownloadUri(string providerId, Uri uri)
    {
        if (!uri.IsAbsoluteUri || !uri.Scheme.Equals(Uri.UriSchemeHttps, StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidOperationException("Online song downloads must use HTTPS.");
        }

        var allowed = providerId switch
        {
            "wikimedia-commons" => uri.Host.Equals("upload.wikimedia.org", StringComparison.OrdinalIgnoreCase),
            "internet-archive" => IsInternetArchiveHost(uri.Host),
            _ => false
        };
        if (!allowed)
        {
            throw new InvalidOperationException("The selected online result redirected to an untrusted download host.");
        }
    }

    private static bool IsInternetArchiveHost(string host)
        => host.Equals("archive.org", StringComparison.OrdinalIgnoreCase)
           || host.EndsWith(".archive.org", StringComparison.OrdinalIgnoreCase);

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

    private static void TryDeleteDirectory(string path)
    {
        try
        {
            if (Directory.Exists(path))
            {
                Directory.Delete(path, recursive: true);
            }
        }
        catch
        {
        }
    }
}
