using System.Diagnostics;
using System.IO.Compression;
using System.Security.Cryptography;
using NAudio.Wave;

namespace RobloxPiano.Audio;

internal sealed class DemucsSeparatedStems : IDisposable
{
    private bool disposed;

    public DemucsSeparatedStems(string workingDirectory, string vocalsPath, string otherPath)
    {
        WorkingDirectory = workingDirectory;
        VocalsPath = vocalsPath;
        OtherPath = otherPath;
    }

    public string WorkingDirectory { get; }
    public string VocalsPath { get; }
    public string OtherPath { get; }

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
            // Best-effort cleanup must never hide a completed transcription result.
        }
    }
}

internal sealed record DemucsSeparationStatus(double Fraction, string Message);

/// <summary>
/// Production CPU-only HTDemucs adapter for Windows x64.
/// It deliberately avoids the Vulkan backend used by demucs-rs after a real client run stalled
/// for more than 30 minutes without producing a stem. The third-party engine owns source separation;
/// RobloxPiano keeps canonical transcription/arrangement/playback truth.
/// </summary>
internal static class DemucsCpuStemSeparator
{
    internal const string EngineVersion = "0.1.0-rc3";
    internal const string ModelId = "htdemucs";
    internal const string EngineArchiveSha256 = "B7806BD39A9ABEB39E2F9254A91539B80EF9A0B148B95DE405ED6683E4A13394";
    internal const string ModelSha256 = "8193504CDFB3943ADAF039B8ACB524A46E87EBF232C383AC7A32C80A6578423E";
    internal const long ModelBytes = 84_030_696;

    private const string EngineArchiveUrl = "https://github.com/eclipse005/demucs-native-rs/releases/download/v0.1.0-rc3/demucs-native-v0.1.0-rc3-windows-x64-cpu.zip";
    private const string ModelUrl = "https://huggingface.co/set-soft/audio_separation/resolve/main/Demucs/htdemucs.safetensors";
    private static readonly HttpClient Http = new() { Timeout = TimeSpan.FromMinutes(5) };
    private static readonly SemaphoreSlim InstallGate = new(1, 1);
    private static readonly TimeSpan MaximumSeparationRuntime = TimeSpan.FromMinutes(10);
    private static readonly TimeSpan MaximumNoCpuProgress = TimeSpan.FromMinutes(2);

    public static DemucsSeparatedStems Separate(
        string sourcePath,
        Action<DemucsSeparationStatus>? status,
        CancellationToken cancellationToken)
        => SeparateAsync(sourcePath, status, cancellationToken).GetAwaiter().GetResult();

    private static async Task<DemucsSeparatedStems> SeparateAsync(
        string sourcePath,
        Action<DemucsSeparationStatus>? status,
        CancellationToken cancellationToken)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(sourcePath);
        var fullPath = Path.GetFullPath(sourcePath);
        if (!File.Exists(fullPath))
            throw new FileNotFoundException("Audio selected for source separation was not found.", fullPath);
        if (!OperatingSystem.IsWindows() || !Environment.Is64BitProcess)
            throw new PlatformNotSupportedException("CPU source separation requires Windows x64.");

        status?.Invoke(new DemucsSeparationStatus(0.02d, "Preparing the CPU-only Demucs separator..."));
        var executable = await EnsureEngineAsync(status, cancellationToken).ConfigureAwait(false);
        var modelPath = await EnsureModelAsync(status, cancellationToken).ConfigureAwait(false);

        var work = Path.Combine(Path.GetTempPath(), "RobloxPiano", "demucs-cpu", Guid.NewGuid().ToString("N"));
        var inputWav = Path.Combine(work, "input.wav");
        var output = Path.Combine(work, "stems");
        Directory.CreateDirectory(output);

        try
        {
            status?.Invoke(new DemucsSeparationStatus(0.045d, "Decoding the song to a local WAV for CPU separation..."));
            WriteInputWav(fullPath, inputWav, cancellationToken);

            status?.Invoke(new DemucsSeparationStatus(0.055d, "Loading HTDemucs on CPU..."));
            var start = new ProcessStartInfo(executable)
            {
                UseShellExecute = false,
                RedirectStandardOutput = true,
                RedirectStandardError = true,
                CreateNoWindow = true,
                WorkingDirectory = work
            };
            start.ArgumentList.Add("-i");
            start.ArgumentList.Add(inputWav);
            start.ArgumentList.Add("-o");
            start.ArgumentList.Add(output);
            start.ArgumentList.Add("-m");
            start.ArgumentList.Add(ModelId);
            start.ArgumentList.Add("--model-dir");
            start.ArgumentList.Add(Path.GetDirectoryName(modelPath)!);
            start.ArgumentList.Add("--device");
            start.ArgumentList.Add("cpu");
            start.ArgumentList.Add("-s");
            start.ArgumentList.Add("vocals,other");

            using var process = Process.Start(start)
                ?? throw new InvalidOperationException("Could not start the CPU Demucs separator process.");
            var stdoutTask = process.StandardOutput.ReadToEndAsync(cancellationToken);
            var stderrTask = process.StandardError.ReadToEndAsync(cancellationToken);
            using var registration = cancellationToken.Register(() => KillProcessTreeBestEffort(process));

            var stopwatch = Stopwatch.StartNew();
            var lastCpu = TryGetCpu(process);
            var lastCpuProgressAt = stopwatch.Elapsed;
            status?.Invoke(new DemucsSeparationStatus(0.08d, "CPU stem separation started..."));

            while (!process.HasExited)
            {
                cancellationToken.ThrowIfCancellationRequested();
                if (stopwatch.Elapsed >= MaximumSeparationRuntime)
                {
                    KillProcessTreeBestEffort(process);
                    throw new TimeoutException(
                        $"CPU source separation exceeded {MaximumSeparationRuntime.TotalMinutes:0} minutes and was stopped.");
                }

                await Task.Delay(TimeSpan.FromSeconds(5), cancellationToken).ConfigureAwait(false);
                if (process.HasExited)
                    break;

                var currentCpu = TryGetCpu(process);
                if (currentCpu > lastCpu + TimeSpan.FromMilliseconds(100))
                {
                    lastCpu = currentCpu;
                    lastCpuProgressAt = stopwatch.Elapsed;
                }
                else if (stopwatch.Elapsed - lastCpuProgressAt >= MaximumNoCpuProgress)
                {
                    KillProcessTreeBestEffort(process);
                    throw new TimeoutException(
                        "CPU source separation stopped consuming CPU for two minutes and was terminated as stalled.");
                }

                status?.Invoke(new DemucsSeparationStatus(
                    0.08d,
                    $"CPU stem separation is active - elapsed {FormatElapsed(stopwatch.Elapsed)}..."));
            }

            await process.WaitForExitAsync(cancellationToken).ConfigureAwait(false);
            var stdout = await stdoutTask.ConfigureAwait(false);
            var stderr = await stderrTask.ConfigureAwait(false);
            cancellationToken.ThrowIfCancellationRequested();

            if (process.ExitCode != 0)
            {
                var detail = Tail(string.IsNullOrWhiteSpace(stderr) ? stdout : stderr, 6000);
                throw new InvalidOperationException(
                    $"CPU Demucs source separation failed with exit code {process.ExitCode}. {detail}".Trim());
            }

            var vocals = Path.Combine(output, "vocals.wav");
            var other = Path.Combine(output, "other.wav");
            if (!File.Exists(vocals) || !File.Exists(other))
            {
                throw new InvalidDataException(
                    "CPU Demucs completed without producing the expected vocals/other stems.");
            }

            status?.Invoke(new DemucsSeparationStatus(0.10d, "CPU stems ready. Building the piano melody..."));
            return new DemucsSeparatedStems(work, vocals, other);
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

    private static void WriteInputWav(string sourcePath, string targetPath, CancellationToken cancellationToken)
    {
        using var reader = new AudioFileReader(sourcePath);
        using var writer = new WaveFileWriter(targetPath, reader.WaveFormat);
        var buffer = new byte[128 * 1024];
        while (true)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var read = reader.Read(buffer, 0, buffer.Length);
            if (read == 0)
                break;
            writer.Write(buffer, 0, read);
        }
    }

    private static async Task<string> EnsureEngineAsync(
        Action<DemucsSeparationStatus>? status,
        CancellationToken cancellationToken)
    {
        var overridePath = Environment.GetEnvironmentVariable("ROBLOXPIANO_DEMUCS_CPU_EXE");
        if (!string.IsNullOrWhiteSpace(overridePath))
        {
            var fullOverride = Path.GetFullPath(overridePath);
            if (!File.Exists(fullOverride))
                throw new FileNotFoundException("ROBLOXPIANO_DEMUCS_CPU_EXE points to a missing executable.", fullOverride);
            return fullOverride;
        }

        var root = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "tools",
            "demucs-native",
            $"v{EngineVersion}");
        var executable = Path.Combine(root, "demucs-native.exe");
        if (File.Exists(executable))
            return executable;

        await InstallGate.WaitAsync(cancellationToken).ConfigureAwait(false);
        try
        {
            if (File.Exists(executable))
                return executable;

            Directory.CreateDirectory(root);
            status?.Invoke(new DemucsSeparationStatus(0.025d, "Downloading the pinned CPU separator (one-time setup)..."));
            var archiveBytes = await Http.GetByteArrayAsync(EngineArchiveUrl, cancellationToken).ConfigureAwait(false);
            var actualHash = Convert.ToHexString(SHA256.HashData(archiveBytes));
            if (!actualHash.Equals(EngineArchiveSha256, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException(
                    $"CPU separator provenance check failed. Expected SHA-256 {EngineArchiveSha256}, got {actualHash}.");
            }

            var archivePath = Path.Combine(root, $"demucs-native-{Guid.NewGuid():N}.zip");
            var temporaryExe = Path.Combine(root, $"demucs-native-{Guid.NewGuid():N}.exe");
            try
            {
                await File.WriteAllBytesAsync(archivePath, archiveBytes, cancellationToken).ConfigureAwait(false);
                using var archive = ZipFile.OpenRead(archivePath);
                var entry = archive.Entries.SingleOrDefault(item =>
                    Path.GetFileName(item.FullName).Equals("demucs-native.exe", StringComparison.OrdinalIgnoreCase))
                    ?? throw new InvalidDataException("Pinned CPU separator archive does not contain demucs-native.exe.");
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

    private static async Task<string> EnsureModelAsync(
        Action<DemucsSeparationStatus>? status,
        CancellationToken cancellationToken)
    {
        var root = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "demucs-rs");
        Directory.CreateDirectory(root);
        var path = Path.Combine(root, "htdemucs.safetensors");
        if (HasExpectedModelIdentity(path))
            return path;

        TryDelete(path);
        var temporary = Path.Combine(root, $"htdemucs-{Guid.NewGuid():N}.tmp");
        status?.Invoke(new DemucsSeparationStatus(0.035d, "Downloading the pinned HTDemucs model (one-time setup)..."));
        try
        {
            await using (var source = await Http.GetStreamAsync(ModelUrl, cancellationToken).ConfigureAwait(false))
            await using (var destination = new FileStream(temporary, FileMode.CreateNew, FileAccess.Write, FileShare.None, 128 * 1024, useAsync: true))
            {
                await source.CopyToAsync(destination, cancellationToken).ConfigureAwait(false);
            }

            if (!HasExpectedModelIdentity(temporary))
            {
                throw new InvalidDataException(
                    $"HTDemucs model provenance check failed. Expected {ModelBytes} bytes / SHA-256 {ModelSha256}.");
            }

            File.Move(temporary, path, overwrite: true);
            return path;
        }
        finally
        {
            TryDelete(temporary);
        }
    }

    private static bool HasExpectedModelIdentity(string path)
    {
        try
        {
            var info = new FileInfo(path);
            if (!info.Exists || info.Length != ModelBytes)
                return false;
            using var stream = File.OpenRead(path);
            var actual = Convert.ToHexString(SHA256.HashData(stream));
            return actual.Equals(ModelSha256, StringComparison.OrdinalIgnoreCase);
        }
        catch
        {
            return false;
        }
    }

    private static TimeSpan TryGetCpu(Process process)
    {
        try
        {
            process.Refresh();
            return process.TotalProcessorTime;
        }
        catch
        {
            return TimeSpan.Zero;
        }
    }

    private static void KillProcessTreeBestEffort(Process process)
    {
        try
        {
            if (!process.HasExited)
                process.Kill(entireProcessTree: true);
        }
        catch
        {
        }
    }

    private static string FormatElapsed(TimeSpan elapsed) =>
        elapsed.TotalHours >= 1d
            ? elapsed.ToString(@"h\:mm\:ss")
            : elapsed.ToString(@"m\:ss");

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
        }
    }
}
