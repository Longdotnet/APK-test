using System.IO.Compression;
using System.Runtime.CompilerServices;
using System.Text;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class VerifiedSupportExportRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        TestVerifiedCopyProducesValidDestinationAndCleansTemporaryFile();
        TestTamperedSourceIsRejectedWithoutReplacingExistingDestination();
        Console.WriteLine("PASS  verified support export regressions (2)");
    }

    private static void TestVerifiedCopyProducesValidDestinationAndCleansTemporaryFile()
    {
        var directory = CreateTemporaryDirectory();
        try
        {
            var source = Path.Combine(directory, "source.zip");
            var destination = Path.Combine(directory, "exported.zip");
            PlaybackSessionDiagnostics.CreateSupportBundle(
                directory,
                source,
                DateTimeOffset.UnixEpoch.AddMinutes(20));

            SupportBundleExport.CopyVerified(source, destination);

            True(File.Exists(destination), "verified export must create the chosen destination");
            True(
                PlaybackSessionDiagnostics.VerifySupportBundle(destination, out var error),
                $"exported support bundle must verify after copy: {error}");
            Equal(
                File.ReadAllBytes(source),
                File.ReadAllBytes(destination),
                "verified export must preserve exact bundle bytes");
            False(
                Directory.EnumerateFiles(directory, "exported.zip.tmp-*", SearchOption.TopDirectoryOnly).Any(),
                "verified export must not leave temporary files behind");
        }
        finally
        {
            Directory.Delete(directory, recursive: true);
        }
    }

    private static void TestTamperedSourceIsRejectedWithoutReplacingExistingDestination()
    {
        var directory = CreateTemporaryDirectory();
        try
        {
            var original = Path.Combine(directory, "original.zip");
            var tampered = Path.Combine(directory, "tampered.zip");
            var destination = Path.Combine(directory, "existing.zip");
            PlaybackSessionDiagnostics.CreateSupportBundle(
                directory,
                original,
                DateTimeOffset.UnixEpoch.AddMinutes(21));
            CreateTamperedBundle(original, tampered);
            File.WriteAllText(destination, "keep-existing-destination", Encoding.UTF8);
            var expected = File.ReadAllBytes(destination);

            var rejected = false;
            try
            {
                SupportBundleExport.CopyVerified(tampered, destination);
            }
            catch (InvalidDataException exception)
            {
                rejected = true;
                True(
                    exception.Message.Contains("integrity verification", StringComparison.OrdinalIgnoreCase),
                    "rejection should explain that integrity verification failed");
            }

            True(rejected, "tampered source must be rejected before export");
            Equal(
                expected,
                File.ReadAllBytes(destination),
                "failed verification must preserve an existing destination unchanged");
            False(
                Directory.EnumerateFiles(directory, "existing.zip.tmp-*", SearchOption.TopDirectoryOnly).Any(),
                "failed export must not leave temporary files behind");
        }
        finally
        {
            Directory.Delete(directory, recursive: true);
        }
    }

    private static void CreateTamperedBundle(string originalPath, string destinationPath)
    {
        using var original = ZipFile.OpenRead(originalPath);
        using var destination = ZipFile.Open(destinationPath, ZipArchiveMode.Create);

        foreach (var entry in original.Entries)
        {
            var copy = destination.CreateEntry(entry.FullName, CompressionLevel.Optimal);
            using var input = entry.Open();
            using var output = copy.Open();
            input.CopyTo(output);
            if (entry.FullName.Equals("support.json", StringComparison.Ordinal))
            {
                output.WriteByte((byte)' ');
            }
        }
    }

    private static string CreateTemporaryDirectory()
    {
        var path = Path.Combine(
            Path.GetTempPath(),
            "RobloxPiano-AppRecoveryTests",
            "verified-export-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(path);
        return path;
    }

    private static void Equal(byte[] expected, byte[] actual, string message)
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

    private static void False(bool condition, string message) => True(!condition, message);
}
