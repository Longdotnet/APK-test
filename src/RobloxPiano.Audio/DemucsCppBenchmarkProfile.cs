namespace RobloxPiano.Audio;

/// <summary>
/// Engineering-only request builder for benchmarking the upstream demucs.cpp six-source model's
/// piano stem. Nothing here downloads or redistributes demucs.cpp or a model; callers must supply
/// explicit absolute paths to their locally obtained executable/model.
/// </summary>
public sealed record DemucsCppSixSourcePianoBenchmarkProfile(
    string ExecutablePath,
    string ModelPath,
    long AdditionalRuntimeBytes = 0,
    TimeSpan? Timeout = null,
    long MaxInputBytes = 512L * 1024 * 1024,
    long MaxOutputBytes = 512L * 1024 * 1024)
{
    // demucs.cpp's six-source mapping is 0 drums, 1 bass, 2 other, 3 vocals, 4 guitar, 5 piano.
    public const string PianoStemRelativePath = "target_5_piano.wav";

    public NativeSeparatorProcessRequest BuildRequest(string inputAudioPath)
    {
        var executable = RequireExistingAbsoluteFile(ExecutablePath, nameof(ExecutablePath));
        var model = RequireExistingAbsoluteFile(ModelPath, nameof(ModelPath));
        var input = RequireExistingAbsoluteFile(inputAudioPath, nameof(inputAudioPath));

        return new NativeSeparatorProcessRequest(
            executable,
            input,
            new[]
            {
                model,
                NativeSeparatorProcessAdapter.InputToken,
                NativeSeparatorProcessAdapter.OutputToken
            },
            PianoStemRelativePath);
    }

    public NativeSeparatorProcessOptions BuildOptions()
    {
        var executable = RequireExistingAbsoluteFile(ExecutablePath, nameof(ExecutablePath));
        var model = RequireExistingAbsoluteFile(ModelPath, nameof(ModelPath));
        if (AdditionalRuntimeBytes < 0)
            throw new ArgumentOutOfRangeException(nameof(AdditionalRuntimeBytes), "Additional runtime bundle bytes cannot be negative.");

        var timeout = Timeout ?? TimeSpan.FromMinutes(10);
        var addedBundleBytes = checked(
            new FileInfo(executable).Length +
            new FileInfo(model).Length +
            AdditionalRuntimeBytes);

        return new NativeSeparatorProcessOptions(
            addedBundleBytes,
            timeout,
            MaxInputBytes,
            MaxOutputBytes);
    }

    private static string RequireExistingAbsoluteFile(string path, string parameterName)
    {
        if (string.IsNullOrWhiteSpace(path) || !Path.IsPathFullyQualified(path))
            throw new ArgumentException("Path must be absolute.", parameterName);

        var fullPath = Path.GetFullPath(path);
        if (!File.Exists(fullPath))
            throw new FileNotFoundException("Required demucs.cpp benchmark file does not exist.", fullPath);
        return fullPath;
    }
}
