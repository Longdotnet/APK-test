using System.Reflection;
using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Audio;

/// <summary>
/// Provides the pinned Spotify Basic Pitch ONNX model when it was embedded at build time.
/// The release/CI pipeline supplies the model through BASIC_PITCH_MODEL_PATH after verifying
/// its immutable upstream Git blob identity. Runtime extraction re-verifies that identity before use.
/// </summary>
public static class BasicPitchBundledModel
{
    public const string ResourceName = "RobloxPiano.Audio.Models.nmp.onnx";
    public const int ExpectedLength = 230_444;
    public const string ExpectedGitBlobSha1 = "c30e5f9438e798604b7177aa26be1fe64482f767";

    public static bool IsAvailable => typeof(BasicPitchBundledModel).Assembly.GetManifestResourceInfo(ResourceName) is not null;

    public static string MaterializeTo(string directory)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(directory);
        Directory.CreateDirectory(directory);

        var finalPath = Path.Combine(directory, "spotify-basic-pitch-fa5997af-nmp.onnx");
        if (File.Exists(finalPath) && HasExpectedIdentity(finalPath))
            return finalPath;

        var tempPath = Path.Combine(directory, $".{Path.GetFileName(finalPath)}.{Guid.NewGuid():N}.tmp");
        try
        {
            using var resource = OpenRequiredResource();
            using (var output = new FileStream(tempPath, FileMode.CreateNew, FileAccess.Write, FileShare.None))
            {
                resource.CopyTo(output);
                output.Flush(flushToDisk: true);
            }

            if (!HasExpectedIdentity(tempPath))
                throw new InvalidDataException("Bundled Basic Pitch model failed its pinned provenance check after extraction.");

            File.Move(tempPath, finalPath, overwrite: true);
            return finalPath;
        }
        finally
        {
            try
            {
                if (File.Exists(tempPath))
                    File.Delete(tempPath);
            }
            catch
            {
                // Best-effort cleanup only; provenance validation above remains authoritative.
            }
        }
    }

    public static string MaterializeToDefaultCache()
    {
        var root = Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData);
        if (string.IsNullOrWhiteSpace(root))
            root = Path.GetTempPath();
        return MaterializeTo(Path.Combine(root, "RobloxPiano", "models"));
    }

    public static bool HasExpectedIdentity(string path)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        var info = new FileInfo(path);
        if (!info.Exists || info.Length != ExpectedLength)
            return false;

        using var stream = info.OpenRead();
        using var sha1 = SHA1.Create();
        var header = Encoding.ASCII.GetBytes($"blob {info.Length}\0");
        sha1.TransformBlock(header, 0, header.Length, null, 0);
        var buffer = new byte[64 * 1024];
        int read;
        while ((read = stream.Read(buffer, 0, buffer.Length)) > 0)
            sha1.TransformBlock(buffer, 0, read, null, 0);
        sha1.TransformFinalBlock(Array.Empty<byte>(), 0, 0);
        var actual = Convert.ToHexString(sha1.Hash!).ToLowerInvariant();
        return actual == ExpectedGitBlobSha1;
    }

    private static Stream OpenRequiredResource()
    {
        var assembly = typeof(BasicPitchBundledModel).Assembly;
        var stream = assembly.GetManifestResourceStream(ResourceName);
        return stream ?? throw new FileNotFoundException(
            "The pinned Spotify Basic Pitch model is not embedded in this build. Production builds must supply BASIC_PITCH_MODEL_PATH during compilation.",
            ResourceName);
    }
}
