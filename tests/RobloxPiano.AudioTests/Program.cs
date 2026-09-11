using System.Buffers.Binary;
using RobloxPiano.Audio;

var tests = new (string Name, Action Run)[]
{
    ("stereo PCM is averaged to deterministic mono", StereoDownmix),
    ("44.1 kHz PCM is resampled to Basic Pitch rate", ResamplesToBasicPitchRate),
    ("duration bound fails closed instead of truncating", DurationBoundFailsClosed),
    ("empty decoded audio fails closed", EmptyAudioFailsClosed),
    ("pre-cancelled ingest exits deterministically", CancellationIsHonored)
};

var failed = 0;
foreach (var test in tests)
{
    try
    {
        test.Run();
        Console.WriteLine($"PASS {test.Name}");
    }
    catch (Exception exception)
    {
        failed++;
        Console.Error.WriteLine($"FAIL {test.Name}: {exception}");
    }
}

if (failed != 0)
{
    Console.Error.WriteLine($"Audio ingest regression harness failed: {failed}/{tests.Length} tests failed.");
    return 1;
}

Console.WriteLine($"Audio ingest regression harness passed: {tests.Length}/{tests.Length}.");
return 0;

static void StereoDownmix()
{
    var frames = new (short Left, short Right)[]
    {
        (short.MaxValue, short.MaxValue),
        (short.MaxValue, short.MinValue),
        (0, 0),
        (16384, 16384)
    };
    using var stream = new MemoryStream(BuildPcm16Wave(22_050, frames));

    var audio = new AudioIngestService().DecodeStream(stream);

    Equal(22_050, audio.SampleRate);
    Equal(1, audio.Channels);
    Equal(frames.Length, audio.Samples.Length);
    Nearly(0.999969f, audio.Samples[0], 0.0001f);
    Nearly(-0.000015f, audio.Samples[1], 0.0001f);
    Nearly(0f, audio.Samples[2], 0.0001f);
    Nearly(0.5f, audio.Samples[3], 0.0001f);
}

static void ResamplesToBasicPitchRate()
{
    const int sourceRate = 44_100;
    const int sourceFrames = sourceRate / 4;
    var frames = Enumerable.Range(0, sourceFrames)
        .Select(i =>
        {
            var sample = (short)(Math.Sin(2 * Math.PI * 440 * i / sourceRate) * 12_000);
            return (sample, sample);
        })
        .ToArray();
    using var stream = new MemoryStream(BuildPcm16Wave(sourceRate, frames));

    var audio = new AudioIngestService().DecodeStream(stream);

    Equal(22_050, audio.SampleRate);
    True(Math.Abs(audio.Samples.Length - 5_513) <= 4, $"Unexpected resampled sample count {audio.Samples.Length}.");
    True(Math.Abs(audio.Duration.TotalSeconds - 0.25) < 0.002, $"Unexpected duration {audio.Duration}.");
    True(audio.Samples.All(float.IsFinite), "Resampled output must contain only finite samples.");
}

static void DurationBoundFailsClosed()
{
    var frames = Enumerable.Repeat(((short)1000, (short)1000), 300).ToArray();
    using var stream = new MemoryStream(BuildPcm16Wave(1_000, frames));
    var options = new AudioIngestOptions(TargetSampleRate: 8_000, MaxDuration: TimeSpan.FromMilliseconds(100));

    Throws<InvalidDataException>(() => new AudioIngestService().DecodeStream(stream, options));
}

static void EmptyAudioFailsClosed()
{
    using var stream = new MemoryStream(BuildPcm16Wave(22_050, []));
    Throws<InvalidDataException>(() => new AudioIngestService().DecodeStream(stream));
}

static void CancellationIsHonored()
{
    var frames = Enumerable.Repeat(((short)1000, (short)1000), 100).ToArray();
    using var stream = new MemoryStream(BuildPcm16Wave(22_050, frames));
    using var cts = new CancellationTokenSource();
    cts.Cancel();

    Throws<OperationCanceledException>(() => new AudioIngestService().DecodeStream(stream, cancellationToken: cts.Token));
}

static byte[] BuildPcm16Wave(int sampleRate, IReadOnlyList<(short Left, short Right)> frames)
{
    const short channels = 2;
    const short bits = 16;
    const short blockAlign = channels * (bits / 8);
    var dataLength = checked(frames.Count * blockAlign);
    var bytes = new byte[44 + dataLength];
    "RIFF"u8.CopyTo(bytes.AsSpan(0, 4));
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(4, 4), 36 + dataLength);
    "WAVE"u8.CopyTo(bytes.AsSpan(8, 4));
    "fmt "u8.CopyTo(bytes.AsSpan(12, 4));
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(16, 4), 16);
    BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(20, 2), 1);
    BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(22, 2), channels);
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(24, 4), sampleRate);
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(28, 4), sampleRate * blockAlign);
    BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(32, 2), blockAlign);
    BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(34, 2), bits);
    "data"u8.CopyTo(bytes.AsSpan(36, 4));
    BinaryPrimitives.WriteInt32LittleEndian(bytes.AsSpan(40, 4), dataLength);

    var offset = 44;
    foreach (var frame in frames)
    {
        BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(offset, 2), frame.Left);
        BinaryPrimitives.WriteInt16LittleEndian(bytes.AsSpan(offset + 2, 2), frame.Right);
        offset += blockAlign;
    }

    return bytes;
}

static void Equal<T>(T expected, T actual)
{
    if (!EqualityComparer<T>.Default.Equals(expected, actual))
        throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
}

static void Nearly(float expected, float actual, float tolerance)
{
    if (Math.Abs(expected - actual) > tolerance)
        throw new InvalidOperationException($"Expected approximately {expected}, actual {actual}.");
}

static void True(bool condition, string? message = null)
{
    if (!condition)
        throw new InvalidOperationException(message ?? "Expected condition to be true.");
}

static void Throws<TException>(Action action) where TException : Exception
{
    try
    {
        action();
    }
    catch (TException)
    {
        return;
    }

    throw new InvalidOperationException($"Expected {typeof(TException).Name}.");
}
