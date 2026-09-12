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
    IReadOnlyList<string> Arguments);

/// <summary>
/// Engineering-only adapter for benchmarking a portable/native source separator without putting
/// that separator in the production RobloxPiano client. The process is launched directly (never
/// through a shell), gets an isolated temporary workspace, must write one bounded output stem,
/// and is killed as a process tree on cancellation/timeout. The stem is consumed before workspace
/// cleanup and the resulting notes/resource evidence are returned to the Phase 27 benchmark runner.
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

        var workspace = Path.Combine(Path.GetTempPath(), "RobloxPiano", "separator-bench", Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(workspace);
        var outputStemPath = Path.Combine(workspace, "separated-stem.wav");

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
                    .Replace(OutputToken, outputStemPath, StringComparison.Ordinal)
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
                throw new InvalidDataException("Native separator completed without producing the expected WAV stem.");
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
