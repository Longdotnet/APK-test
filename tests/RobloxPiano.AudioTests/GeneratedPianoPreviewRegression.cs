using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class GeneratedPianoPreviewRegression
{
    public static void CanonicalTrackRendersDeterministically()
    {
        var track = new PerformanceTrack(
            "preview",
            120d,
            480,
            TimeSpan.Zero,
            [
                new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(250), ['q']),
                new PerformanceEvent(TimeSpan.FromMilliseconds(125), TimeSpan.FromMilliseconds(250), ['Q', 'w'])
            ],
            TimeSpan.FromMilliseconds(500));
        var options = new GeneratedPianoPreviewOptions(
            SampleRate: 8_000,
            MaximumPreviewDuration: TimeSpan.FromSeconds(1),
            MasterGain: 0.2f,
            Attack: TimeSpan.FromMilliseconds(2),
            Release: TimeSpan.FromMilliseconds(8));

        var first = Render(track, options, 257);
        var second = Render(track, options, 113);

        Equal(4_000, first.Length);
        Equal(first.Length, second.Length);
        for (var index = 0; index < first.Length; index++)
            Nearly(first[index], second[index], 0.000001f);
        True(first.Any(sample => Math.Abs(sample) > 0.0001f), "Preview must contain audible samples.");
        True(first.All(float.IsFinite), "Preview must contain only finite samples.");
        True(first.All(sample => sample is >= -1f and <= 1f), "Preview samples must remain bounded.");
    }

    public static void LongTrackPreviewIsBoundedAndStreaming()
    {
        var track = new PerformanceTrack(
            "long preview",
            120d,
            480,
            TimeSpan.Zero,
            [new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMinutes(3), ['q'])],
            TimeSpan.FromMinutes(3));
        var provider = new GeneratedPianoPreviewSampleProvider(
            track,
            new GeneratedPianoPreviewOptions(
                SampleRate: 8_000,
                MaximumPreviewDuration: TimeSpan.FromSeconds(2)));

        True(provider.Info.IsTruncated, "Long previews must surface truncation.");
        Equal(TimeSpan.FromMinutes(3), provider.Info.SourceDuration);
        Equal(TimeSpan.FromSeconds(2), provider.Info.PreviewDuration);
        Equal(1, provider.Info.NoteVoices);

        var buffer = new float[64];
        var total = 0;
        int read;
        while ((read = provider.Read(buffer.AsSpan())) > 0)
            total += read;
        Equal(16_000, total);
        Equal(0, provider.Read(buffer.AsSpan()));
    }

    public static void InvalidCanonicalKeyFailsClosed()
    {
        var track = new PerformanceTrack(
            "invalid",
            120d,
            480,
            TimeSpan.Zero,
            [new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), ['?'])],
            TimeSpan.FromMilliseconds(100));

        Throws<InvalidDataException>(() => new GeneratedPianoPreviewSampleProvider(track));
    }

    private static float[] Render(PerformanceTrack track, GeneratedPianoPreviewOptions options, int chunkSize)
    {
        var provider = new GeneratedPianoPreviewSampleProvider(track, options);
        var result = new List<float>();
        var buffer = new float[chunkSize];
        int read;
        while ((read = provider.Read(buffer.AsSpan())) > 0)
            result.AddRange(buffer.AsSpan(0, read).ToArray());
        return result.ToArray();
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
    }

    private static void Nearly(float expected, float actual, float tolerance)
    {
        if (Math.Abs(expected - actual) > tolerance)
            throw new InvalidOperationException($"Expected approximately {expected}, actual {actual}.");
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
    }

    private static void Throws<TException>(Action action) where TException : Exception
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
}
