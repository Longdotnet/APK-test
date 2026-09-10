namespace RobloxPiano.App;

internal static class SupportBundleExport
{
    public static void CreateAndExportVerified(
        string diagnosticsDirectory,
        string generatedBundlePath,
        string destinationPath,
        DateTimeOffset generatedAtUtc)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(diagnosticsDirectory);
        ArgumentException.ThrowIfNullOrWhiteSpace(generatedBundlePath);
        ArgumentException.ThrowIfNullOrWhiteSpace(destinationPath);

        PlaybackSessionDiagnostics.CreateSupportBundle(
            diagnosticsDirectory,
            generatedBundlePath,
            generatedAtUtc);

        CopyVerified(generatedBundlePath, destinationPath);

        // Completed explicit Legacy A/B campaigns get a separate privacy-safe,
        // cryptographically verifiable experiment manifest next to the support ZIP.
        // The sidecar is diagnostics evidence only; failure to produce it must not
        // mutate playback/session truth or weaken verification of the primary bundle.
        try
        {
            _ = PlaybackBaselineExperimentManifestStore.ExportCompletedIfAvailable(
                diagnosticsDirectory,
                destinationPath,
                generatedAtUtc);
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or InvalidDataException
            or System.Text.Json.JsonException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Legacy A/B experiment sidecar could not be exported: {exception.Message}");
        }
    }

    internal static void CopyVerified(string sourcePath, string destinationPath)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        ArgumentException.ThrowIfNullOrWhiteSpace(destinationPath);

        if (!PlaybackSessionDiagnostics.VerifySupportBundle(sourcePath, out var sourceError))
        {
            throw new InvalidDataException(
                $"The generated support bundle failed integrity verification and was not exported. {sourceError}");
        }

        var destinationDirectory = Path.GetDirectoryName(destinationPath);
        if (!string.IsNullOrWhiteSpace(destinationDirectory))
        {
            Directory.CreateDirectory(destinationDirectory);
        }

        var temporaryPath = destinationPath + ".tmp-" + Guid.NewGuid().ToString("N");
        try
        {
            File.Copy(sourcePath, temporaryPath, overwrite: false);

            if (!PlaybackSessionDiagnostics.VerifySupportBundle(temporaryPath, out var copiedError))
            {
                throw new InvalidDataException(
                    $"The copied support bundle failed integrity verification and was not committed to the destination. {copiedError}");
            }

            File.Move(temporaryPath, destinationPath, overwrite: true);
        }
        finally
        {
            if (File.Exists(temporaryPath))
            {
                File.Delete(temporaryPath);
            }
        }
    }
}
