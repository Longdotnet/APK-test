namespace RobloxPiano.App;

/// <summary>
/// Durable diagnostics-only archive for verified reference-audio evidence bound to completed
/// Legacy A/B experiments. Playback, engine selection, Roblox authorization and input dispatch
/// never consult this archive.
/// </summary>
internal static class PlaybackReferenceAudioExperimentArchive
{
    internal const int MaxArchivedEvidence = 100;
    private const string ArchiveDirectoryName = "legacy-ab-reference-evidence";
    private static readonly object Gate = new();

    internal static string ArchiveDirectoryPath => Path.Combine(
        ClientDiagnostics.DirectoryPath,
        ArchiveDirectoryName);

    internal static string PersistVerified(
        string archiveDirectory,
        PlaybackReferenceAudioExperimentEvidence evidence)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(archiveDirectory);
        ArgumentNullException.ThrowIfNull(evidence);

        if (!PlaybackReferenceAudioExperimentEvidenceStore.Verify(evidence, out var verificationError))
        {
            throw new InvalidDataException(
                $"Reference-audio experiment evidence cannot enter the durable archive. {verificationError}");
        }

        lock (Gate)
        {
            Directory.CreateDirectory(archiveDirectory);
            var path = GetArchivePath(archiveDirectory, evidence);
            if (File.Exists(path))
            {
                var existing = PlaybackReferenceAudioExperimentEvidenceStore.ReadAndVerify(path);
                if (!string.Equals(existing.EvidenceSha256, evidence.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
                {
                    throw new InvalidDataException(
                        "Reference evidence already exists for this experiment/reference identity with different verified contents.");
                }

                return path;
            }

            PlaybackReferenceAudioExperimentEvidenceStore.WriteVerifiedAtomic(path, evidence);
            TrimArchive(archiveDirectory);
            return path;
        }
    }

    internal static IReadOnlyList<PlaybackReferenceAudioExperimentEvidence> ReadVerifiedForExperiment(
        string archiveDirectory,
        string experimentEvidenceSha256,
        int maxResults = MaxArchivedEvidence)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(archiveDirectory);
        ArgumentException.ThrowIfNullOrWhiteSpace(experimentEvidenceSha256);
        if (maxResults <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(maxResults));
        }

        if (!Directory.Exists(archiveDirectory))
        {
            return Array.Empty<PlaybackReferenceAudioExperimentEvidence>();
        }

        var verified = new List<(PlaybackReferenceAudioExperimentEvidence Evidence, DateTime LastWriteUtc)>();
        foreach (var path in Directory.EnumerateFiles(
                     archiveDirectory,
                     "*.legacy-ab-reference.json",
                     SearchOption.TopDirectoryOnly))
        {
            try
            {
                var evidence = PlaybackReferenceAudioExperimentEvidenceStore.ReadAndVerify(path);
                if (string.Equals(
                        evidence.ExperimentEvidenceSha256,
                        experimentEvidenceSha256,
                        StringComparison.OrdinalIgnoreCase))
                {
                    verified.Add((evidence, File.GetLastWriteTimeUtc(path)));
                }
            }
            catch (Exception exception) when (
                exception is IOException
                or InvalidDataException
                or UnauthorizedAccessException
                or ArgumentException
                or System.Text.Json.JsonException
                or NotSupportedException)
            {
                ClientDiagnostics.Log(
                    $"Archived reference-audio experiment evidence was ignored because verification failed: {exception.Message}");
            }
        }

        return verified
            .OrderByDescending(item => item.LastWriteUtc)
            .ThenBy(item => item.Evidence.ReferenceContentSha256, StringComparer.OrdinalIgnoreCase)
            .Take(maxResults)
            .Select(item => item.Evidence)
            .ToArray();
    }

    internal static void ExportVerified(
        PlaybackReferenceAudioExperimentEvidence evidence,
        string destinationPath)
    {
        ArgumentNullException.ThrowIfNull(evidence);
        ArgumentException.ThrowIfNullOrWhiteSpace(destinationPath);
        PlaybackReferenceAudioExperimentEvidenceStore.WriteVerifiedAtomic(destinationPath, evidence);
    }

    private static string GetArchivePath(
        string archiveDirectory,
        PlaybackReferenceAudioExperimentEvidence evidence)
        => Path.Combine(
            archiveDirectory,
            $"v{evidence.SchemaVersion}-{evidence.ExperimentEvidenceSha256}-{evidence.ReferenceContentSha256}.legacy-ab-reference.json");

    private static void TrimArchive(string archiveDirectory)
    {
        var verifiedEntries = new List<(string Path, DateTime LastWriteUtc)>();
        foreach (var path in Directory.EnumerateFiles(
                     archiveDirectory,
                     "*.legacy-ab-reference.json",
                     SearchOption.TopDirectoryOnly))
        {
            try
            {
                _ = PlaybackReferenceAudioExperimentEvidenceStore.ReadAndVerify(path);
                verifiedEntries.Add((path, File.GetLastWriteTimeUtc(path)));
            }
            catch (Exception exception) when (
                exception is IOException
                or InvalidDataException
                or UnauthorizedAccessException
                or ArgumentException
                or System.Text.Json.JsonException
                or NotSupportedException)
            {
                ClientDiagnostics.Log(
                    $"Unverifiable reference evidence was retained for manual inspection: {exception.Message}");
            }
        }

        foreach (var entry in verifiedEntries
                     .OrderByDescending(item => item.LastWriteUtc)
                     .ThenByDescending(item => item.Path, StringComparer.OrdinalIgnoreCase)
                     .Skip(MaxArchivedEvidence))
        {
            try
            {
                File.Delete(entry.Path);
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException)
            {
                ClientDiagnostics.Log($"Old reference evidence could not be removed: {exception.Message}");
            }
        }
    }
}
