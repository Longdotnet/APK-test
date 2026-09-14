using System.Diagnostics;
using System.Security.Cryptography;
using NAudio.Wave;
using NAudio.Wave.SampleProviders;

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

/// <summary>
/// Compatibility-named production adapter for the fast source-separation path.
/// The implementation deliberately uses sherpa-onnx Spleeter 2-stem FP16 instead of HTDemucs:
/// the client needs a clean lead-vocal stem quickly, not studio-grade four-stem separation.
/// </summary>
internal static class DemucsRsStemSeparator
{
    internal const string EngineVersion = "sherpa-onnx-1.13.8";
    internal const string ModelId = "spleeter-2stems-fp16-vocals-only";

    private const string EngineArchiveName = "sherpa-onnx-v1.13.8-win-x64-shared-MD-Release-no-tts.tar.bz2";
    private const string EngineArchiveUrl =
        "https://github.com/k2-fsa/sherpa-onnx/releases/download/v1.13.8/" + EngineArchiveName;
    private const long EngineArchiveBytes = 19_164_933;
    private const string EngineArchiveSha256 =
        "876E6B89B8CF84A3A1B375A397507F2CFE9C227C2A945411A11A668475FCB5D3";

    private const string ModelArchiveName = "sherpa-onnx-spleeter-2stems-fp16.tar.bz2";
    private const string ModelArchiveUrl =
        "https://github.com/k2-fsa/sherpa-onnx/releases/download/source-separation-models/" + ModelArchiveName;
    private const long ModelArchiveBytes = 35_271_738;
    // GitHub release asset 257363398 currently serves these exact bytes; the upstream checksum.txt is stale.
    private const string ModelArchiveSha256 = "D54561979BD2E08A51E7DBD99AC36BB47564E089EEFD403636DBCA93E811BBA2";

    private const int SeparatorSampleRate = 44_100;
    private const double TargetRealTimeFactor = 0.09d;
    private static readonly TimeSpan MaximumSeparationRuntime = TimeSpan.FromSeconds(45);
    private static readonly HttpClient Http = new() { Timeout = TimeSpan.FromMinutes(3) };
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
        if (!OperatingSystem.IsWindows() || !Environment.Is64BitProcess)
            throw new PlatformNotSupportedException("Fast source separation requires Windows x64.");

        status?.Invoke("Preparing fast Spleeter vocal separation...");
        var runtime = await EnsureRuntimeAsync(status, cancellationToken).ConfigureAwait(false);

        var work = Path.Combine(
            Path.GetTempPath(),
            "RobloxPiano",
            "spleeter-fast",
            Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(work);

        var inputWav = Path.Combine(work, "input.wav");
        var vocalsWav = Path.Combine(work, "vocals.wav");
        var accompanimentWav = Path.Combine(work, "accompaniment.wav");
        var silentOtherWav = Path.Combine(work, "silent-other.wav");

        try
        {
            status?.Invoke("Decoding MP3 to 44.1 kHz stereo for fast separation...");
            var sourceDuration = WriteInputWav(fullPath, inputWav, cancellationToken);

            var threadCount = ResolveThreadCount();
            status?.Invoke(
                $"Fast Spleeter separation started on CPU ({threadCount} thread(s)); target is about 20 seconds for a 4-minute song...");

            var start = new ProcessStartInfo(runtime.ExecutablePath)
            {
                UseShellExecute = false,
                RedirectStandardOutput = true,
                RedirectStandardError = true,
                CreateNoWindow = true,
                WorkingDirectory = Path.GetDirectoryName(runtime.ExecutablePath)!
            };
            start.ArgumentList.Add($"--spleeter-vocals={runtime.VocalsModelPath}");
            start.ArgumentList.Add($"--spleeter-accompaniment={runtime.AccompanimentModelPath}");
            start.ArgumentList.Add($"--num-threads={threadCount}");
            start.ArgumentList.Add("--provider=cpu");
            start.ArgumentList.Add($"--input-wav={inputWav}");
            start.ArgumentList.Add($"--output-vocals-wav={vocalsWav}");
            start.ArgumentList.Add($"--output-accompaniment-wav={accompanimentWav}");

            using var process = Process.Start(start)
                ?? throw new InvalidOperationException("Could not start the fast Spleeter separator process.");
            using var registration = cancellationToken.Register(() => KillProcessTreeBestEffort(process));

            var stdoutTask = process.StandardOutput.ReadToEndAsync(cancellationToken);
            var stderrTask = process.StandardError.ReadToEndAsync(cancellationToken);
            var stopwatch = Stopwatch.StartNew();
            var expected = TimeSpan.FromSeconds(
                Math.Max(2d, sourceDuration.TotalSeconds * TargetRealTimeFactor));

            while (!process.HasExited)
            {
                cancellationToken.ThrowIfCancellationRequested();
                if (stopwatch.Elapsed >= MaximumSeparationRuntime)
                {
                    KillProcessTreeBestEffort(process);
                    throw new TimeoutException(
                        $"Fast vocal separation exceeded {MaximumSeparationRuntime.TotalSeconds:0} seconds and was stopped because it missed the Create Piano performance budget.");
                }

                await Task.Delay(TimeSpan.FromSeconds(1), cancellationToken).ConfigureAwait(false);
                if (process.HasExited)
                    break;

                var estimated = Math.Min(95d, 100d * stopwatch.Elapsed.TotalSeconds / expected.TotalSeconds);
                status?.Invoke(
                    $"Fast vocal separation ~{estimated:0}% (estimate) - elapsed {stopwatch.Elapsed.TotalSeconds:0}s...");
            }

            await process.WaitForExitAsync(cancellationToken).ConfigureAwait(false);
            var stdout = await stdoutTask.ConfigureAwait(false);
            var stderr = await stderrTask.ConfigureAwait(false);
            cancellationToken.ThrowIfCancellationRequested();

            if (process.ExitCode != 0)
            {
                var detail = Tail(string.IsNullOrWhiteSpace(stderr) ? stdout : stderr, 6000);
                throw new InvalidOperationException(
                    $"Spleeter source separation failed with exit code {process.ExitCode}. {detail}".Trim());
            }

            ValidateSeparatedVocals(inputWav, vocalsWav);
            CreateMinimalSilentOther(silentOtherWav);

            status?.Invoke(
                $"Fast vocal stem ready in {stopwatch.Elapsed.TotalSeconds:0.0}s. Building the piano melody...");
            return new DemucsSeparatedStems(work, vocalsWav, silentOtherWav);
        }
        catch
        {
            TryDeleteDirectory(work);
            throw;
        }
    }

    private static TimeSpan WriteInputWav(
        string sourcePath,
        string targetPath,
        CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        using var reader = new AudioFileReader(sourcePath);
        if (reader.WaveFormat.Channels is < 1 or > 2)
            throw new InvalidDataException(
                $"Fast source separation supports mono/stereo audio; source reports {reader.WaveFormat.Channels} channels.");

        ISampleProvider samples = reader;
        if (samples.WaveFormat.Channels == 1)
            samples = new MonoToStereoSampleProvider(samples);
        if (samples.WaveFormat.SampleRate != SeparatorSampleRate)
            samples = new WdlResamplingSampleProvider(samples, SeparatorSampleRate);

        WaveFileWriter.CreateWaveFile16(targetPath, samples);
        cancellationToken.ThrowIfCancellationRequested();
        return reader.TotalTime;
    }

    private static async Task<RuntimeFiles> EnsureRuntimeAsync(
        Action<string>? status,
        CancellationToken cancellationToken)
    {
        var root = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "tools",
            "sherpa-onnx",
            "v1.13.8");
        var modelRoot = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "models",
            "spleeter-2stems-fp16");

        var existing = TryResolveRuntime(root, modelRoot);
        if (existing is not null)
            return existing;

        await InstallGate.WaitAsync(cancellationToken).ConfigureAwait(false);
        try
        {
            existing = TryResolveRuntime(root, modelRoot);
            if (existing is not null)
                return existing;

            Directory.CreateDirectory(root);
            Directory.CreateDirectory(modelRoot);

            status?.Invoke("Downloading fast sherpa-onnx Windows runtime (one-time setup)...");
            await InstallEngineAsync(root, cancellationToken).ConfigureAwait(false);

            status?.Invoke("Downloading Spleeter FP16 vocal model (one-time setup)...");
            await InstallModelsAsync(modelRoot, cancellationToken).ConfigureAwait(false);

            return TryResolveRuntime(root, modelRoot)
                ?? throw new InvalidDataException(
                    "Fast source-separation runtime installed without the expected executable/models.");
        }
        finally
        {
            InstallGate.Release();
        }
    }

    private static RuntimeFiles? TryResolveRuntime(string engineRoot, string modelRoot)
    {
        var executable = Directory.Exists(engineRoot)
            ? Directory.EnumerateFiles(
                    engineRoot,
                    "sherpa-onnx-offline-source-separation.exe",
                    SearchOption.AllDirectories)
                .FirstOrDefault()
            : null;
        var vocals = Directory.Exists(modelRoot)
            ? Directory.EnumerateFiles(
                    modelRoot,
                    "vocals.fp16.onnx",
                    SearchOption.AllDirectories)
                .FirstOrDefault()
            : null;
        var accompaniment = Directory.Exists(modelRoot)
            ? Directory.EnumerateFiles(
                    modelRoot,
                    "accompaniment.fp16.onnx",
                    SearchOption.AllDirectories)
                .FirstOrDefault()
            : null;

        if (executable is null || vocals is null || accompaniment is null)
            return null;

        if (new FileInfo(vocals).Length < 15_000_000
            || new FileInfo(accompaniment).Length < 15_000_000)
        {
            return null;
        }

        return new RuntimeFiles(executable, vocals, accompaniment);
    }

    private static async Task InstallEngineAsync(
        string root,
        CancellationToken cancellationToken)
    {
        var archivePath = Path.Combine(
            Path.GetDirectoryName(root)!,
            $"{EngineArchiveName}.{Guid.NewGuid():N}.tmp");
        try
        {
            await DownloadToFileAsync(
                EngineArchiveUrl,
                archivePath,
                EngineArchiveBytes,
                EngineArchiveSha256,
                cancellationToken).ConfigureAwait(false);

            TryDeleteDirectory(root);
            Directory.CreateDirectory(root);
            await ExtractTarBz2Async(archivePath, root, cancellationToken).ConfigureAwait(false);

            if (!Directory.EnumerateFiles(
                    root,
                    "sherpa-onnx-offline-source-separation.exe",
                    SearchOption.AllDirectories).Any())
            {
                throw new InvalidDataException(
                    "Pinned sherpa-onnx archive does not contain sherpa-onnx-offline-source-separation.exe.");
            }
        }
        finally
        {
            TryDelete(archivePath);
        }
    }

    private static async Task InstallModelsAsync(
        string root,
        CancellationToken cancellationToken)
    {
        var archivePath = Path.Combine(
            Path.GetDirectoryName(root)!,
            $"{ModelArchiveName}.{Guid.NewGuid():N}.tmp");
        try
        {
            await DownloadToFileAsync(
                ModelArchiveUrl,
                archivePath,
                ModelArchiveBytes,
                ModelArchiveSha256,
                cancellationToken).ConfigureAwait(false);

            TryDeleteDirectory(root);
            Directory.CreateDirectory(root);
            await ExtractTarBz2Async(archivePath, root, cancellationToken).ConfigureAwait(false);

            if (TryResolveRuntime(
                    Path.Combine(
                        Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
                        "RobloxPiano",
                        "tools",
                        "sherpa-onnx",
                        "v1.13.8"),
                    root) is null)
            {
                throw new InvalidDataException(
                    "Spleeter model archive does not contain valid FP16 vocals/accompaniment models.");
            }
        }
        finally
        {
            TryDelete(archivePath);
        }
    }

    private static async Task DownloadToFileAsync(
        string url,
        string destination,
        long expectedBytes,
        string? expectedSha256,
        CancellationToken cancellationToken)
    {
        await using (var source = await Http.GetStreamAsync(url, cancellationToken)
            .ConfigureAwait(false))
        await using (var target = new FileStream(
            destination,
            FileMode.CreateNew,
            FileAccess.Write,
            FileShare.None,
            128 * 1024,
            useAsync: true))
        {
            await source.CopyToAsync(target, cancellationToken).ConfigureAwait(false);
        }

        var info = new FileInfo(destination);
        if (info.Length != expectedBytes)
        {
            throw new InvalidDataException(
                $"Downloaded asset has {info.Length} bytes; expected {expectedBytes}.");
        }

        if (string.IsNullOrWhiteSpace(expectedSha256))
            return;

        await using var stream = File.OpenRead(destination);
        var actual = Convert.ToHexString(await SHA256.HashDataAsync(stream, cancellationToken)
            .ConfigureAwait(false));
        if (!actual.Equals(expectedSha256, StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidDataException(
                $"Downloaded asset SHA-256 mismatch. Expected {expectedSha256}, got {actual}.");
        }
    }

    private static async Task ExtractTarBz2Async(
        string archivePath,
        string destination,
        CancellationToken cancellationToken)
    {
        var systemTar = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.System),
            "tar.exe");
        var tar = File.Exists(systemTar) ? systemTar : "tar.exe";

        var start = new ProcessStartInfo(tar)
        {
            UseShellExecute = false,
            RedirectStandardOutput = true,
            RedirectStandardError = true,
            CreateNoWindow = true
        };
        start.ArgumentList.Add("-xf");
        start.ArgumentList.Add(archivePath);
        start.ArgumentList.Add("-C");
        start.ArgumentList.Add(destination);

        using var process = Process.Start(start)
            ?? throw new InvalidOperationException("Could not start Windows tar.exe.");
        using var registration = cancellationToken.Register(() => KillProcessTreeBestEffort(process));
        var stdoutTask = process.StandardOutput.ReadToEndAsync(cancellationToken);
        var stderrTask = process.StandardError.ReadToEndAsync(cancellationToken);

        using var extractionTimeout = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken);
        extractionTimeout.CancelAfter(TimeSpan.FromMinutes(1));
        try
        {
            await process.WaitForExitAsync(extractionTimeout.Token).ConfigureAwait(false);
        }
        catch (OperationCanceledException) when (!cancellationToken.IsCancellationRequested)
        {
            KillProcessTreeBestEffort(process);
            throw new TimeoutException("Windows tar.exe exceeded one minute while extracting the separator package.");
        }

        var stdout = await stdoutTask.ConfigureAwait(false);
        var stderr = await stderrTask.ConfigureAwait(false);
        if (process.ExitCode != 0)
        {
            var detail = Tail(string.IsNullOrWhiteSpace(stderr) ? stdout : stderr, 3000);
            throw new InvalidOperationException(
                $"Could not extract fast separator package with Windows tar.exe. {detail}".Trim());
        }
    }

    private static int ResolveThreadCount()
    {
        var configured = Environment.GetEnvironmentVariable("ROBLOXPIANO_SPLEETER_THREADS");
        if (int.TryParse(configured, out var requested) && requested is >= 1 and <= 8)
            return requested;

        return Math.Clamp(Environment.ProcessorCount / 2, 1, 4);
    }

    private static void ValidateSeparatedVocals(string inputWav, string vocalsWav)
    {
        if (!File.Exists(vocalsWav))
            throw new InvalidDataException("Spleeter completed without producing vocals.wav.");

        using var input = new WaveFileReader(inputWav);
        using var vocals = new WaveFileReader(vocalsWav);
        if (vocals.Length <= 44)
            throw new InvalidDataException("Spleeter produced an empty vocal stem.");

        if (Math.Abs((vocals.TotalTime - input.TotalTime).TotalSeconds) > 2d)
        {
            throw new InvalidDataException(
                $"Spleeter vocal duration {vocals.TotalTime} does not match source duration {input.TotalTime}.");
        }
    }

    private static void CreateMinimalSilentOther(string path)
    {
        using var writer = new WaveFileWriter(
            path,
            new WaveFormat(SeparatorSampleRate, 16, 2));
        writer.Write(new byte[4], 0, 4);
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

    private static void TryDeleteDirectory(string path)
    {
        try
        {
            if (Directory.Exists(path))
                Directory.Delete(path, recursive: true);
        }
        catch
        {
        }
    }

    private sealed record RuntimeFiles(
        string ExecutablePath,
        string VocalsModelPath,
        string AccompanimentModelPath);
}
