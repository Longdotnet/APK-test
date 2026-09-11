using System.Buffers;
using NAudio.Wave;
using NAudio.Wave.SampleProviders;

namespace RobloxPiano.Audio;

public sealed record AudioIngestOptions(
    int TargetSampleRate = 22_050,
    TimeSpan? MaxDuration = null)
{
    public TimeSpan EffectiveMaxDuration => MaxDuration ?? TimeSpan.FromMinutes(15);

    internal void Validate()
    {
        if (TargetSampleRate is < 8_000 or > 192_000)
            throw new ArgumentOutOfRangeException(nameof(TargetSampleRate), "Target sample rate must be between 8 kHz and 192 kHz.");
        if (EffectiveMaxDuration <= TimeSpan.Zero || EffectiveMaxDuration > TimeSpan.FromHours(2))
            throw new ArgumentOutOfRangeException(nameof(MaxDuration), "Maximum duration must be greater than zero and no more than two hours.");
    }
}

public sealed record NormalizedAudio(float[] Samples, int SampleRate)
{
    public int Channels => 1;
    public TimeSpan Duration => TimeSpan.FromSeconds((double)Samples.LongLength / SampleRate);
}

public sealed class AudioIngestService
{
    public NormalizedAudio DecodeFile(
        string path,
        AudioIngestOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        using var reader = new AudioFileReader(path);
        return Normalize(reader, options, cancellationToken);
    }

    public NormalizedAudio DecodeStream(
        Stream stream,
        AudioIngestOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(stream);
        if (!stream.CanRead || !stream.CanSeek)
            throw new ArgumentException("Audio stream must be readable and seekable.", nameof(stream));

        using var reader = new AudioFileReader(stream);
        return Normalize(reader, options, cancellationToken);
    }

    internal static NormalizedAudio Normalize(
        ISampleProvider source,
        AudioIngestOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(source);
        options ??= new AudioIngestOptions();
        options.Validate();

        if (source.WaveFormat.Channels <= 0)
            throw new InvalidDataException("Audio source reports no channels.");
        if (source.WaveFormat.SampleRate <= 0)
            throw new InvalidDataException("Audio source reports an invalid sample rate.");

        ISampleProvider mono = source.WaveFormat.Channels == 1
            ? source
            : new AveragingMonoSampleProvider(source);

        ISampleProvider normalized = mono.WaveFormat.SampleRate == options.TargetSampleRate
            ? mono
            : new WdlResamplingSampleProvider(mono, options.TargetSampleRate);

        var maxSamples = checked((long)Math.Ceiling(options.EffectiveMaxDuration.TotalSeconds * options.TargetSampleRate));
        var samples = new List<float>((int)Math.Min(maxSamples, options.TargetSampleRate * 30L));
        var buffer = new float[8192];

        while (true)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var read = normalized.Read(buffer);
            if (read == 0)
                break;

            if (samples.Count + (long)read > maxSamples)
                throw new InvalidDataException($"Audio exceeds the configured maximum duration of {options.EffectiveMaxDuration}.");

            for (var i = 0; i < read; i++)
                samples.Add(float.IsFinite(buffer[i]) ? Math.Clamp(buffer[i], -1f, 1f) : 0f);
        }

        if (samples.Count == 0)
            throw new InvalidDataException("Audio contains no decodable samples.");

        return new NormalizedAudio(samples.ToArray(), options.TargetSampleRate);
    }

    private sealed class AveragingMonoSampleProvider : ISampleProvider
    {
        private readonly ISampleProvider source;
        private readonly int channels;

        public AveragingMonoSampleProvider(ISampleProvider source)
        {
            this.source = source;
            channels = source.WaveFormat.Channels;
            WaveFormat = WaveFormat.CreateIeeeFloatWaveFormat(source.WaveFormat.SampleRate, 1);
        }

        public WaveFormat WaveFormat { get; }

        public int Read(Span<float> buffer)
        {
            if (buffer.IsEmpty)
                return 0;

            var requestedSourceSamples = checked(buffer.Length * channels);
            var rented = ArrayPool<float>.Shared.Rent(requestedSourceSamples);
            try
            {
                var read = source.Read(rented.AsSpan(0, requestedSourceSamples));
                if (read == 0)
                    return 0;
                if (read % channels != 0)
                    throw new InvalidDataException("Audio decoder returned a partial interleaved frame.");

                var frames = read / channels;
                for (var frame = 0; frame < frames; frame++)
                {
                    double sum = 0;
                    var offset = frame * channels;
                    for (var channel = 0; channel < channels; channel++)
                        sum += rented[offset + channel];
                    buffer[frame] = (float)(sum / channels);
                }

                return frames;
            }
            finally
            {
                ArrayPool<float>.Shared.Return(rented);
            }
        }
    }
}
