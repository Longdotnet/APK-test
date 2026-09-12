using System.Diagnostics;

namespace RobloxPiano.Audio;

public sealed record NativeSeparatorProcessOptions(
    long AddedBundleBytes,
    TimeSpan Timeout,
    long MaxInputBytes = 512L * 1024 * 1024,
    long MaxOutputBytes = 512L * 1024 * 1024,
    int MaxArguments = 128,
    int MaxArgumentLength = 4096)
{
    public static NativeSeparatorProcessOptions EngineeringDefault(long addedBundleBytes) =>
        new(addedBundleBytes, TimeSpan.FromMinutes(10));
}

public sealed record NativeSeparatorProcessRequest(
    string ExecutablePath,
    string InputAudioPath,
    IReadOnlyList<string> Arguments,
    string? ExpectedOutputRelativePath = null);

/// <summary>
/// Engineering-only adapter for benchmarking a portable/native source separator without putting
/// that separator in the production RobloxPiano client. The process is launched directly (never
/// through a shell), gets an isolated temporary workspace, must write one bounded selected WAV stem,
/// and is killed as a process tree on cancellation/timeout. Separators that accept an output
/// directory (for example demucs.cpp) may name a safe relative stem through
/// <see cref="NativeSeparatorProcessRequest.ExpectedOutputRelativePath"/>; legacy exact-file
/// adapters keep using the default separated-stem.wav contract. The selected stem is consumed before
/// workspace cleanup and the resulting notes/resource evidence are returned to the Phase 27 runner.
/// </summary>
public sealed class NativeSeparatorProcessAdapter
{
    public const string InputToken = "{input}";
    public const string OutputToken = "{output}";
    public const string WorkspaceToken = "{workspace}";

    public async ValueTask<AudioSourceSeparationCandidateRun> RunAsync(
        NativeSeparatorProcessRequest request,
        NativeSeparatorProcessOptions options,
        Func<string, CancellationToken, ValueTask<IReadOnlyList<BasicPitchTranscribedNote>>> stemTranscriber,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(request);
        ArgumentNullException.ThrowIfNull(options);
        ArgumentNullException.ThrowIfNull(stemTranscriber);
        ValidateOptions(options);
        cancellationToken.ThrowIfCancellationRequested();

        var executablePath = RequireExistingAbsoluteFile(request.ExecutablePath, nameof(request.ExecutablePath));
        var inputAudioPath = RequireExistingAbsoluteFile(request.InputAudioPath, nameof(request.InputAudioPath));
        var inputLength = new FileInfo(inputAudioPath).Length;
        if (inputLength <= 0 || inputLength > options.MaxInputBytes)
            throw new ArgumentOutOfRangeException(nameof(request), $"Separator input must be between 1 and {options.MaxInputBytes} bytes.");

        ArgumentNullException.ThrowIfNull(request.Arguments);
        if (request.Arguments.Count == 0 || request.Arguments.Count > options.MaxArguments)
            throw new ArgumentException($"Separator requires 1..{options.MaxArguments} arguments.", nameof(request));
        if (request.Arguments.Any(argument => argument is null || argument.Length > options.MaxArgumentLength))
            throw new ArgumentException($"Separator arguments must be non-null and at most {options.MaxArgumentLength} characters.", nameof(request));
        if (!request.Arguments.Any(argument => argument.Contains(OutputToken, StringComparison.Ordinal)))
            throw new ArgumentException($"Separator arguments must contain the {OutputToken} token.", nameof(request));

        ValidateExpectedOutputRelativePath(request.ExpectedOutputRelativePath);

        var workspace = Path.Combine(Path.GetTempPath(), "RobloxPiano", "separator-bench", Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(workspace);
        var directoryOutputMode = !string.IsNullOrWhiteSpace(request.ExpectedOutputRelativePath);
        var outputStemPath = directoryOutputMode
            ? ResolveContainedRelativePath(workspace, request.ExpectedOutputRelativePath!)
            : Path.Combine(workspace, "separated-stem.wav");
        var outputTokenPath = directoryOutputMode ? workspace : outputStemPath;

        try
        {
            var startInfo = new ProcessStartInfo
            {
                FileName = executablePath,
                WorkingDirectory = workspace,
                UseShellExecute = false,
                CreateNoWindow = true,
                RedirectStandardInput = false,
                RedirectStandardOutput = false,
                RedirectStandardError = false
            };

            foreach (var template in request.Arguments)
            {
                startInfo.ArgumentList.Add(template
                    .Replace(InputToken, inputAudioPath, StringComparison.Ordinal)
                    .Replace(OutputToken, outputTokenPath, StringComparison.Ordinal)
                    .Replace(WorkspaceToken, workspace, StringComparison.Ordinal));
            }

            using var process = new Process { StartInfo = startInfo, EnableRaisingEvents = true };
            var stopwatch = Stopwatch.StartNew();
            long peakWorkingSetBytes = 0;

            if (!process.Start())
                throw new InvalidOperationException("Native separator process did not start.");

            try
            {
                while (!process.HasExited)
                {
                    cancellationToken.ThrowIfCancellationRequested();
                    if (stopwatch.Elapsed > options.Timeout)
                        throw new TimeoutException($"Native separator exceeded the {options.Timeout} engineering timeout.");

                    TryUpdatePeakWorkingSet(process, ref peakWorkingSetBytes);
                    await Task.Delay(TimeSpan.FromMilliseconds(50), cancellationToken).ConfigureAwait(false);
                }

                TryUpdatePeakWorkingSet(process, ref peakWorkingSetBytes);
            }
            catch
            {
                KillProcessTreeBestEffort(process);
                throw;
            }
            finally
            {
                stopwatch.Stop();
            }

            if (process.ExitCode != 0)
                throw new InvalidOperationException($"Native separator exited with code {process.ExitCode}.");

            var output = new FileInfo(outputStemPath);
            if (!output.Exists)
                throw new InvalidDataException($"Native separator completed without producing the expected WAV stem '{Path.GetFileName(outputStemPath)}'.");
            if (output.Length <= 0 || output.Length > options.MaxOutputBytes)
                throw new InvalidDataException($"Native separator output must be between 1 and {options.MaxOutputBytes} bytes.");

            cancellationToken.ThrowIfCancellationRequested();
            var notes = await stemTranscriber(outputStemPath, cancellationToken).ConfigureAwait(false);
            ArgumentNullException.ThrowIfNull(notes);

            return new AudioSourceSeparationCandidateRun(
                notes,
                stopwatch.Elapsed,
                peakWorkingSetBytes,
                options.AddedBundleBytes);
        }
        finally
        {
            DeleteWorkspaceBestEffort(workspace);
        }
    }

    private static void ValidateOptions(NativeSeparatorProcessOptions options)
    {
        if (options.AddedBundleBytes < 0)
            throw new ArgumentOutOfRangeException(nameof(options), "Added bundle size cannot be negative.");
        if (options.Timeout <= TimeSpan.Zero || options.Timeout > TimeSpan.FromHours(1))
            throw new ArgumentOutOfRangeException(nameof(options), "Separator timeout must be positive and no more than one hour.");
        if (options.MaxInputBytes <= 0 || options.MaxOutputBytes <= 0)
            throw new ArgumentOutOfRangeException(nameof(options), "Separator byte limits must be positive.");
        if (options.MaxArguments is <= 0 or > 512)
            throw new ArgumentOutOfRangeException(nameof(options), "Separator argument limit must be between 1 and 512.");
        if (options.MaxArgumentLength is <= 0 or > 32768)
            throw new ArgumentOutOfRangeException(nameof(options), "Separator argument-length limit must be between 1 and 32768.");
    }

    private static void ValidateExpectedOutputRelativePath(string? path)
    {
        if (path is null)
            return;
        if (string.IsNullOrWhiteSpace(path))
            throw new ArgumentException("Expected separator output path cannot be blank.", nameof(NativeSeparatorProcessRequest.ExpectedOutputRelativePath));
        if (path.Length > 1024)
            throw new ArgumentException("Expected separator output path cannot exceed 1024 characters.", nameof(NativeSeparatorProcessRequest.ExpectedOutputRelativePath));
        if (Path.IsPathFullyQualified(path))
            throw new ArgumentException("Expected separator output path must be relative to the isolated workspace.", nameof(NativeSeparatorProcessRequest.ExpectedOutputRelativePath));
        if (!string.Equals(Path.GetExtension(path), ".wav", StringComparison.OrdinalIgnoreCase))
            throw new ArgumentException("Expected separator output must select a WAV stem.", nameof(NativeSeparatorProcessRequest.ExpectedOutputRelativePath));
    }

    private static string ResolveContainedRelativePath(string workspace, string relativePath)
    {
        var workspaceRoot = Path.GetFullPath(workspace);
        var candidate = Path.GetFullPath(Path.Combine(workspaceRoot, relativePath));
        var comparison = OperatingSystem.IsWindows() ? StringComparison.OrdinalIgnoreCase : StringComparison.Ordinal;
        var prefix = Path.TrimEndingDirectorySeparator(workspaceRoot) + Path.DirectorySeparatorChar;
        if (!candidate.StartsWith(prefix, comparison))
            throw new ArgumentException("Expected separator output path must stay inside the isolated workspace.", nameof(NativeSeparatorProcessRequest.ExpectedOutputRelativePath));
        return candidate;
    }

    private static string RequireExistingAbsoluteFile(string path, string parameterName)
    {
        if (string.IsNullOrWhiteSpace(path) || !Path.IsPathFullyQualified(path))
            throw new ArgumentException("Path must be absolute.", parameterName);

        var fullPath = Path.GetFullPath(path);
        if (!File.Exists(fullPath))
            throw new FileNotFoundException("Required separator file does not exist.", fullPath);
        return fullPath;
    }

    private static void TryUpdatePeakWorkingSet(Process process, ref long peakWorkingSetBytes)
    {
        try
        {
            process.Refresh();
            peakWorkingSetBytes = Math.Max(peakWorkingSetBytes, process.PeakWorkingSet64);
        }
        catch (InvalidOperationException)
        {
            // Process may have exited between the HasExited check and Refresh.
        }
    }

    private static void KillProcessTreeBestEffort(Process process)
    {
        try
        {
            if (!process.HasExited)
                process.Kill(entireProcessTree: true);
        }
        catch (InvalidOperationException)
        {
        }
    }

    private static void DeleteWorkspaceBestEffort(string workspace)
    {
        try
        {
            if (Directory.Exists(workspace))
                Directory.Delete(workspace, recursive: true);
        }
        catch (IOException)
        {
        }
        catch (UnauthorizedAccessException)
        {
        }
    }
}
