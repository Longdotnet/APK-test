using RobloxPiano.Audio;

if (!BasicPitchBundledModel.IsAvailable)
{
    Console.Error.WriteLine("Bundled Basic Pitch model is unavailable. BASIC_PITCH_MODEL_PATH must be supplied during build.");
    return 1;
}

var tempRoot = Path.Combine(Path.GetTempPath(), "RobloxPiano-AudioBundleTests", Guid.NewGuid().ToString("N"));
Directory.CreateDirectory(tempRoot);
try
{
    var modelPath = BasicPitchBundledModel.MaterializeTo(tempRoot);
    if (!File.Exists(modelPath))
        throw new InvalidOperationException("Bundled model extraction did not produce a file.");
    if (!BasicPitchBundledModel.HasExpectedIdentity(modelPath))
        throw new InvalidDataException("Extracted bundled model does not match the pinned Spotify Basic Pitch blob.");

    using var inference = new BasicPitchInferenceService(modelPath);
    var samples = new float[BasicPitchInferenceService.RequiredSampleRate / 2];
    for (var i = 0; i < samples.Length; i++)
        samples[i] = (float)(Math.Sin(2 * Math.PI * 440 * i / BasicPitchInferenceService.RequiredSampleRate) * 0.2);

    var output = inference.Infer(new NormalizedAudio(samples, BasicPitchInferenceService.RequiredSampleRate));
    if (output.Notes.Frames <= 0 || output.Onsets.Frames != output.Notes.Frames || output.Contours.Frames != output.Notes.Frames)
        throw new InvalidDataException("Bundled model inference returned inconsistent tensor frames.");

    Console.WriteLine($"Bundled Basic Pitch model PASS. bytes={new FileInfo(modelPath).Length}; frames={output.Notes.Frames}; blob={BasicPitchBundledModel.ExpectedGitBlobSha1}.");
    return 0;
}
finally
{
    try { Directory.Delete(tempRoot, recursive: true); } catch { }
}
