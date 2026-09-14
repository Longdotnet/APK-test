using System.Diagnostics;
using System.IO.Compression;
using System.Security.Cryptography;

namespace RobloxPiano.Audio;

internal sealed class DemucsSeparatedStems : IDisposable
{
    private bool disposed;

    public DemucsSeparatedStems(string workingDirectory, string vocalsPath, string otherPath, string bassPath)
    {
        WorkingDirectory = workingDirectory;
        VocalsPath = vocalsPath;
        OtherPath = otherPath;
        BassPath = bassPath;
    }

    public string WorkingDirectory { get; }
    public string VocalsPath { get; }
    public string OtherPath { get; }
    public string BassPath { get; }

    public void Dispose()
    {
        if (disposed)
            return;
        disposed = true;
        try
        {
            if (Directory.Exists(WorkingDirectory))
                Directory.Delete(WorkingDirectory, recursive: true);
        }
        catch
        {
            // Best-effort cleanup. A locked temporary stem must never mask the transcription result.
        }
    }
}

/// <summary>
/// Production adapter around the official demucs-rs Windows CLI release.
/// RobloxPiano owns orchestration and canonical note truth; demucs-rs owns only source separation.
/// </summary>
internal static class DemucsRsStemSeparator
{
    internal const string EngineVersion = "0.3.4";
    internal const string ModelId = "htdemucs";
    internal const string EngineArchiveSha256 = "67E77186295A00758DF0B760F3345FD0B9081B328F923ECC35307F6190F472D1";
    private const string EngineArchiveUrl = "https://github.com/nikhilunni/demucs-rs/releases/download/v0.3.4/demucs-x86_64-pc-windows-msvc.zip";
    private static readonly HttpClient Http = new() { Timeout = TimeSpan.FromMinutes(5) };
    private static readonly SemaphoreSlim InstallGate = new(1, 1);

    public static DemucsSeparatedStems Separate(
        string sourcePath,
        Action<string>? status,
        CancellationToken cancellationToken)
        => SeparateAsync(sourcePath, status, cancellationToken).GetAwaiter().GetResult();

    private static async Task<DemucsSeparatedStems> SeparateAsync(
        string sourcePath,
        Action<string>? status,
        CancellationToken cancellationToken)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        var fullPath = Path.GetFullPath(sourcePath);
        if (!File.Exists(fullPath))
            throw new FileNotFoundException("Audio selected for source separation was not found.", fullPath);
        if (!OperatingSystem.IsWindows())
            throw new PlatformNotSupportedException("The current production source-separation adapter requires Windows x64.");

        status?.Invoke("Preparing the local Demucs stem separator...");
        var executable = await EnsureEngineAsync(status, cancellationToken).ConfigureAwait(false);
        var work = Path.Combine(Path.GetTempPath(), "RobloxPiano", "demucs", Guid.NewGuid().ToString("N"));
        var output = Path.Combine(work, "stems");
        Directory.CreateDirectory(output);

        try
        {
            status?.Invoke("Separating vocals, accompaniment and bass with Demucs...");
            var start = new ProcessStartInfo(executable)
            {
                UseShellExecute = false,
                RedirectStandardOutput = true,
                RedirectStandardError = true,
                CreateNoWindow = true,
                WorkingDirectory = work
            };
            start.ArgumentList.Add(fullPath);
            start.ArgumentList.Add("-m");
            start.ArgumentList.Add(ModelId);
            start.ArgumentList.Add("-s");
            start.ArgumentList.Add("vocals,other,bass");
            start.ArgumentList.Add("-o");
            start.ArgumentList.Add(output);

            using var process = Process.Start(start)
                ?? throw new InvalidOperationException("Could not start the local Demucs separator process.");
            var stdoutTask = process.StandardOutput.ReadToEndAsync();
            var stderrTask = process.StandardError.ReadToEndAsync();
            using var registration = cancellationToken.Register(() =>
            {
                try
                {
                    if (!process.HasExited)
                        process.Kill(entireProcessTree: true);
                }
                catch
                {
                    // Cancellation remains authoritative even if the process already ended.
                }
            });

            await process.WaitForExitAsync(cancellationToken).ConfigureAwait(false);
            var stdout = await stdoutTask.ConfigureAwait(false);
            var stderr = await stderrTask.ConfigureAwait(false);
            cancellationToken.ThrowIfCancellationRequested();

            if (process.ExitCode != 0)
            {
                var detail = Tail(string.IsNullOrWhiteSpace(stderr) ? stdout : stderr, 6000);
                throw new InvalidOperationException(
                    $"Demucs source separation failed with exit code {process.ExitCode}. {detail}".Trim());
            }

            var vocals = Path.Combine(output, "vocals.wav");
            var other = Path.Combine(output, "other.wav");
            var bass = Path.Combine(output, "bass.wav");
            if (!File.Exists(vocals) || !File.Exists(other) || !File.Exists(bass))
            {
                throw new InvalidDataException(
                    "Demucs completed without producing the expected vocals/other/bass stems.");
            }

            status?.Invoke("Demucs stems ready. Transcribing the separated lead melody...");
            return new DemucsSeparatedStems(work, vocals, other, bass);
        }
        catch
        {
            try
            {
                if (Directory.Exists(work))
                    Directory.Delete(work, recursive: true);
            }
            catch
            {
                // Preserve the original separation failure.
            }
            throw;
        }
    }

    private static async Task<string> EnsureEngineAsync(Action<string>? status, CancellationToken cancellationToken)
    {
        var overridePath = Environment.GetEnvironmentVariable("ROBLOXPIANO_DEMUCS_EXE");
        if (!string.IsNullOrWhiteSpace(overridePath))
        {
            var fullOverride = Path.GetFullPath(overridePath);
            if (!File.Exists(fullOverride))
                throw new FileNotFoundException("ROBLOXPIANO_DEMUCS_EXE points to a missing executable.", fullOverride);
            return fullOverride;
        }

        var root = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "tools",
            "demucs-rs",
            $"v{EngineVersion}");
        var executable = Path.Combine(root, "demucs.exe");
        if (File.Exists(executable))
            return executable;

        await InstallGate.WaitAsync(cancellationToken).ConfigureAwait(false);
        try
        {
            if (File.Exists(executable))
                return executable;

            Directory.CreateDirectory(root);
            status?.Invoke("Downloading the pinned Demucs Windows engine (one-time setup)...");
            var archiveBytes = await Http.GetByteArrayAsync(EngineArchiveUrl, cancellationToken).ConfigureAwait(false);
            var actualHash = Convert.ToHexString(SHA256.HashData(archiveBytes));
            if (!actualHash.Equals(EngineArchiveSha256, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException(
                    $"Demucs engine provenance check failed. Expected SHA-256 {EngineArchiveSha256}, got {actualHash}.");
            }

            var archivePath = Path.Combine(root, $"demucs-{Guid.NewGuid():N}.zip");
            var temporaryExe = Path.Combine(root, $"demucs-{Guid.NewGuid():N}.exe");
            try
            {
                await File.WriteAllBytesAsync(archivePath, archiveBytes, cancellationToken).ConfigureAwait(false);
                using var archive = ZipFile.OpenRead(archivePath);
                var entry = archive.Entries.SingleOrDefault(item =>
                    item.FullName.Equals("demucs.exe", StringComparison.OrdinalIgnoreCase))
                    ?? throw new InvalidDataException("Pinned Demucs archive does not contain demucs.exe.");
                entry.ExtractToFile(temporaryExe, overwrite: true);
                File.Move(temporaryExe, executable, overwrite: true);
            }
            finally
            {
                TryDelete(archivePath);
                TryDelete(temporaryExe);
            }

            return executable;
        }
        finally
        {
            InstallGate.Release();
        }
    }

    private static string Tail(string text, int maximumCharacters)
    {
        if (string.IsNullOrWhiteSpace(text))
            return string.Empty;
        var normalized = text.Trim();
        return normalized.Length <= maximumCharacters
            ? normalized
            : normalized[^maximumCharacters..];
    }

    private static void TryDelete(string path)
    {
        try
        {
            if (File.Exists(path))
                File.Delete(path);
        }
        catch
        {
            // Best effort; future setup can overwrite stale temporary files safely.
        }
    }
}
