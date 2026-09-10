namespace RobloxPiano.App;

/// <summary>
/// Durable, privacy-safe archive for completed verified Legacy A/B experiment manifests.
/// Archive evidence is diagnostics-only and never participates in playback truth, input
/// authorization, transport state, or baseline promotion decisions.
/// </summary>
internal static class PlaybackBaselineExperimentArchive
{
    internal const int MaxArchivedExperiments = 50;
    private const string ArchiveDirectoryName = "legacy-ab-experiments";
    private static readonly object Gate = new();

    internal static string ArchiveDirectoryPath => Path.Combine(
        ClientDiagnostics.DirectoryPath,
        ArchiveDirectoryName);

    internal static string? CaptureCompletedIfAvailable(
        string diagnosticsDirectory,
        DateTimeOffset nowUtc)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(diagnosticsDirectory);

        var manifest = PlaybackBaselineExperimentManifestStore.TryCreateCompleted(
            diagnosticsDirectory,
            nowUtc);
        if (manifest is null)
        {
            return null;
        }

        return PersistVerified(ArchiveDirectoryPath, manifest);
    }

    internal static string PersistVerified(
        string archiveDirectory,
        PlaybackBaselineExperimentManifest manifest)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(archiveDirectory);
        ArgumentNullException.ThrowIfNull(manifest);

        if (!PlaybackBaselineExperimentManifestStore.Verify(manifest, out var verificationError))
        {
            throw new InvalidDataException(
                $"Legacy A/B experiment cannot enter the durable archive. {verificationError}");
        }

        lock (Gate)
        {
            Directory.CreateDirectory(archiveDirectory);
            var path = GetArchivePath(archiveDirectory, manifest);
            if (File.Exists(path))
            {
                var existing = PlaybackBaselineExperimentManifestStore.ReadAndVerify(path);
                if (!string.Equals(
                        existing.EvidenceSha256,
                        manifest.EvidenceSha256,
                        StringComparison.OrdinalIgnoreCase))
                {
                    throw new InvalidDataException(
                        "A durable Legacy A/B archive entry already exists for this campaign with different evidence.");
                }

                return path;
            }

            PlaybackBaselineExperimentManifestStore.WriteVerifiedAtomic(path, manifest);
            TrimArchive(archiveDirectory);
            return path;
        }
    }

    internal static IReadOnlyList<PlaybackBaselineExperimentManifest> ReadVerified(
        string archiveDirectory,
        int maxResults = MaxArchivedExperiments)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(archiveDirectory);
        if (maxResults <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(maxResults));
        }

        if (!Directory.Exists(archiveDirectory))
        {
            return Array.Empty<PlaybackBaselineExperimentManifest>();
        }

        var verified = new List<PlaybackBaselineExperimentManifest>();
        foreach (var path in Directory
                     .EnumerateFiles(archiveDirectory, "*.legacy-ab.json", SearchOption.TopDirectoryOnly)
                     .OrderByDescending(Path.GetFileName, StringComparer.OrdinalIgnoreCase))
        {
            try
            {
                verified.Add(PlaybackBaselineExperimentManifestStore.ReadAndVerify(path));
            }
            catch (Exception exception) when (
                exception is IOException
                or UnauthorizedAccessException
                or ArgumentException
                or System.Text.Json.JsonException
                or NotSupportedException)
            {
                ClientDiagnostics.Log(
                    $"Archived Legacy A/B experiment was ignored because verification failed: {exception.Message}");
            }
        }

        return verified
            .OrderByDescending(manifest => manifest.CompletedAtUtc)
            .ThenByDescending(manifest => manifest.CampaignId, StringComparer.Ordinal)
            .Take(maxResults)
            .ToArray();
    }

    internal static void ExportVerified(
        PlaybackBaselineExperimentManifest manifest,
        string destinationPath)
    {
        ArgumentNullException.ThrowIfNull(manifest);
        ArgumentException.ThrowIfNullOrWhiteSpace(destinationPath);
        PlaybackBaselineExperimentManifestStore.WriteVerifiedAtomic(destinationPath, manifest);
    }

    private static string GetArchivePath(
        string archiveDirectory,
        PlaybackBaselineExperimentManifest manifest)
        => Path.Combine(
            archiveDirectory,
            $"{manifest.CompletedAtUtc.UtcDateTime:yyyyMMddTHHmmssfffZ}-{manifest.CampaignId}.legacy-ab.json");

    private static void TrimArchive(string archiveDirectory)
    {
        var entries = new List<(string Path, PlaybackBaselineExperimentManifest Manifest)>();
        foreach (var path in Directory.EnumerateFiles(
                     archiveDirectory,
                     "*.legacy-ab.json",
                     SearchOption.TopDirectoryOnly))
        {
            try
            {
                entries.Add((path, PlaybackBaselineExperimentManifestStore.ReadAndVerify(path)));
            }
            catch (Exception exception) when (
                exception is IOException
                or UnauthorizedAccessException
                or ArgumentException
                or System.Text.Json.JsonException
                or NotSupportedException)
            {
                ClientDiagnostics.Log(
                    $"Unverifiable Legacy A/B archive entry was retained for manual inspection: {exception.Message}");
            }
        }

        foreach (var entry in entries
                     .OrderByDescending(item => item.Manifest.CompletedAtUtc)
                     .ThenByDescending(item => item.Manifest.CampaignId, StringComparer.Ordinal)
                     .Skip(MaxArchivedExperiments))
        {
            try
            {
                File.Delete(entry.Path);
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
            {
                ClientDiagnostics.Log($"Old Legacy A/B archive entry could not be removed: {exception.Message}");
            }
        }
    }
}
