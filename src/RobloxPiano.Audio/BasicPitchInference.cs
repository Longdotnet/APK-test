using Microsoft.ML.OnnxRuntime;

namespace RobloxPiano.Audio;

public sealed record BasicPitchInferenceOptions(int MaxChunksPerBatch = 8)
{
    internal void Validate()
    {
        if (MaxChunksPerBatch is < 1 or > 64)
            throw new ArgumentOutOfRangeException(nameof(MaxChunksPerBatch), "Basic Pitch batch size must be between 1 and 64 chunks.");
    }
}

public sealed record BasicPitchTensor(float[] Values, int Frames, int Bins)
{
    public float this[int frame, int bin]
    {
        get
        {
            if ((uint)frame >= (uint)Frames || (uint)bin >= (uint)Bins)
                throw new ArgumentOutOfRangeException();
            return Values[checked(frame * Bins + bin)];
        }
    }
}

public sealed record BasicPitchRawOutput(
    BasicPitchTensor Notes,
    BasicPitchTensor Onsets,
    BasicPitchTensor Contours);

public readonly record struct BasicPitchChunkPlan(
    int OriginalSamples,
    int ChunkSamples,
    int OverlapSamples,
    int HopSamples,
    int PrefixPaddingSamples,
    int ChunkCount)
{
    public static BasicPitchChunkPlan Create(int originalSamples)
    {
        if (originalSamples <= 0)
            throw new ArgumentOutOfRangeException(nameof(originalSamples));

        var overlapSamples = checked(BasicPitchInferenceService.OverlappingFrames * BasicPitchInferenceService.FftHop);
        var hopSamples = checked(BasicPitchInferenceService.AudioWindowSamples - overlapSamples);
        var prefixPaddingSamples = overlapSamples / 2;
        var paddedLength = checked(originalSamples + prefixPaddingSamples);
        var chunkCount = checked((paddedLength + hopSamples - 1) / hopSamples);

        return new BasicPitchChunkPlan(
            originalSamples,
            BasicPitchInferenceService.AudioWindowSamples,
            overlapSamples,
            hopSamples,
            prefixPaddingSamples,
            chunkCount);
    }
}

/// <summary>
/// Executes Spotify Basic Pitch's ICASSP 2022 ONNX model over normalized mono 22.05 kHz audio.
/// This class owns ML inference only; note decoding/arrangement and Roblox playback remain separate layers.
/// </summary>
public sealed class BasicPitchInferenceService : IDisposable
{
    public const int RequiredSampleRate = 22_050;
    public const int FftHop = 256;
    public const int AnnotationFramesPerSecond = RequiredSampleRate / FftHop; // Spotify uses integer floor division.
    public const int AudioWindowSeconds = 2;
    public const int AudioWindowSamples = RequiredSampleRate * AudioWindowSeconds - FftHop; // 43,844.
    public const int OverlappingFrames = 30;
    public const int NoteBins = 88;
    public const int ContourBins = 264;

    public const string InputName = "serving_default_input_2:0";
    public const string NoteOutputName = "StatefulPartitionedCall:1";
    public const string OnsetOutputName = "StatefulPartitionedCall:2";
    public const string ContourOutputName = "StatefulPartitionedCall:0";

    private static readonly string[] InputNames = [InputName];
    private static readonly string[] OutputNames = [NoteOutputName, OnsetOutputName, ContourOutputName];

    private readonly InferenceSession session;
    private readonly BasicPitchInferenceOptions options;
    private bool disposed;

    public BasicPitchInferenceService(string modelPath, BasicPitchInferenceOptions? options = null)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(modelPath);
        if (!File.Exists(modelPath))
            throw new FileNotFoundException("Basic Pitch ONNX model was not found.", modelPath);

        this.options = options ?? new BasicPitchInferenceOptions();
        this.options.Validate();

        var sessionOptions = new SessionOptions
        {
            GraphOptimizationLevel = GraphOptimizationLevel.ORT_ENABLE_ALL,
            LogSeverityLevel = OrtLoggingLevel.ORT_LOGGING_LEVEL_WARNING
        };
        session = new InferenceSession(modelPath, sessionOptions);
        ValidateModelContract();
    }

    public BasicPitchRawOutput Infer(NormalizedAudio audio, CancellationToken cancellationToken = default)
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        ArgumentNullException.ThrowIfNull(audio);
        if (audio.SampleRate != RequiredSampleRate)
            throw new ArgumentException($"Basic Pitch requires normalized {RequiredSampleRate} Hz audio; received {audio.SampleRate} Hz.", nameof(audio));
        if (audio.Channels != 1 || audio.Samples.Length == 0)
            throw new ArgumentException("Basic Pitch requires non-empty mono normalized audio.", nameof(audio));
        if (audio.Samples.Any(sample => !float.IsFinite(sample)))
            throw new ArgumentException("Basic Pitch input must contain only finite samples.", nameof(audio));

        var plan = BasicPitchChunkPlan.Create(audio.Samples.Length);
        var notes = new List<float>();
        var onsets = new List<float>();
        var contours = new List<float>();

        for (var firstChunk = 0; firstChunk < plan.ChunkCount; firstChunk += options.MaxChunksPerBatch)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var batchSize = Math.Min(options.MaxChunksPerBatch, plan.ChunkCount - firstChunk);
            var input = BuildInputBatch(audio.Samples, plan, firstChunk, batchSize);
            using var inputValue = OrtValue.CreateTensorValueFromMemory(input, [batchSize, AudioWindowSamples, 1]);
            using var runOptions = new RunOptions();
            using var results = session.Run(runOptions, InputNames, [inputValue], OutputNames);
            var outputs = results.ToArray();
            if (outputs.Length != 3)
                throw new InvalidDataException($"Basic Pitch returned {outputs.Length} outputs; expected 3.");

            AppendUnwrapped(outputs[0], batchSize, NoteBins, notes);
            AppendUnwrapped(outputs[1], batchSize, NoteBins, onsets);
            AppendUnwrapped(outputs[2], batchSize, ContourBins, contours);
        }

        var expectedFrames = Math.Min(
            checked((int)Math.Floor(audio.Samples.LongLength * (AnnotationFramesPerSecond / (double)RequiredSampleRate))),
            notes.Count / NoteBins);
        if (expectedFrames <= 0)
            throw new InvalidDataException("Basic Pitch input is too short to produce an annotation frame.");

        return new BasicPitchRawOutput(
            Trim(notes, expectedFrames, NoteBins),
            Trim(onsets, expectedFrames, NoteBins),
            Trim(contours, expectedFrames, ContourBins));
    }

    private void ValidateModelContract()
    {
        if (!session.InputMetadata.ContainsKey(InputName))
            throw new InvalidDataException($"Basic Pitch model is missing input '{InputName}'.");
        foreach (var outputName in OutputNames)
        {
            if (!session.OutputMetadata.ContainsKey(outputName))
                throw new InvalidDataException($"Basic Pitch model is missing output '{outputName}'.");
        }
    }

    private static float[] BuildInputBatch(float[] source, BasicPitchChunkPlan plan, int firstChunk, int batchSize)
    {
        var input = new float[checked(batchSize * AudioWindowSamples)];
        for (var batch = 0; batch < batchSize; batch++)
        {
            var chunk = firstChunk + batch;
            var paddedStart = checked(chunk * plan.HopSamples);
            var destinationOffset = checked(batch * AudioWindowSamples);
            for (var i = 0; i < AudioWindowSamples; i++)
            {
                var sourceIndex = paddedStart + i - plan.PrefixPaddingSamples;
                if ((uint)sourceIndex < (uint)source.Length)
                    input[destinationOffset + i] = source[sourceIndex];
            }
        }
        return input;
    }

    private static void AppendUnwrapped(OrtValue value, int expectedBatch, int expectedBins, List<float> destination)
    {
        using var typeAndShape = value.GetTensorTypeAndShape();
        var shape = typeAndShape.Shape;
        if (shape.Length != 3 || shape[0] != expectedBatch || shape[2] != expectedBins)
            throw new InvalidDataException($"Unexpected Basic Pitch tensor shape [{string.Join(',', shape)}]; expected [{expectedBatch},time,{expectedBins}].");

        var shortFrames = checked((int)shape[1]);
        if (shortFrames <= OverlappingFrames || (OverlappingFrames & 1) != 0)
            throw new InvalidDataException($"Basic Pitch output has invalid time dimension {shortFrames}.");

        var trim = OverlappingFrames / 2;
        var usableFrames = shortFrames - OverlappingFrames;
        var source = value.GetTensorDataAsSpan<float>();
        var expectedElements = checked(expectedBatch * shortFrames * expectedBins);
        if (source.Length != expectedElements)
            throw new InvalidDataException($"Basic Pitch tensor contains {source.Length} values; expected {expectedElements}.");

        destination.EnsureCapacity(checked(destination.Count + expectedBatch * usableFrames * expectedBins));
        for (var batch = 0; batch < expectedBatch; batch++)
        {
            var batchOffset = checked(batch * shortFrames * expectedBins);
            for (var frame = trim; frame < shortFrames - trim; frame++)
            {
                var offset = checked(batchOffset + frame * expectedBins);
                for (var bin = 0; bin < expectedBins; bin++)
                    destination.Add(source[offset + bin]);
            }
        }
    }

    private static BasicPitchTensor Trim(List<float> source, int frames, int bins)
    {
        var count = checked(frames * bins);
        if (source.Count < count)
            throw new InvalidDataException($"Basic Pitch unwrapped output contains {source.Count} values; expected at least {count}.");
        var values = new float[count];
        source.CopyTo(0, values, 0, count);
        return new BasicPitchTensor(values, frames, bins);
    }

    public void Dispose()
    {
        if (disposed)
            return;
        disposed = true;
        session.Dispose();
    }
}
