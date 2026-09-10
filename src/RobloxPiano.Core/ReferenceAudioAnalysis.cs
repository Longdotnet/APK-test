using System.Buffers.Binary;
using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Core;

public sealed record ReferenceAudioAnalysis(
    int SchemaVersion,
    int SampleRate,
    int ChannelCount,
    int BitsPerSample,
    TimeSpan Duration,
    double RmsLevel,
    double PeakLevel,
    double EstimatedTempoBpm,
    IReadOnlyList<TimeSpan> Onsets,
    string ContentSha256,
    string FeatureSha256)
{
    public const int CurrentSchemaVersion = 1;
}

/// <summary>
/// Deterministic, dependency-free reference-audio analysis for production evidence.
/// The analyzer deliberately supports only uncompressed PCM WAV today. Unsupported or
/// malformed audio fails closed instead of being guessed or silently transcoded.
/// </summary>
public static class ReferenceAudioAnalyzer
{
    private const int MinTempoBpm = 60;
    private const int MaxTempoBpm = 200;
    private const int AnalysisFrameMilliseconds = 10;
    private const int RefractoryMilliseconds = 50;

    public static ReferenceAudioAnalysis AnalyzeWav(ReadOnlySpan<byte> wavBytes)
    {
        if (wavBytes.Length < 44)
        {
            throw new InvalidDataException("Reference audio is too small to be a WAV file.");
        }

        if (!wavBytes[..4].SequenceEqual("RIFF"u8) || !wavBytes.Slice(8, 4).SequenceEqual("WAVE"u8))
        {
            throw new InvalidDataException("Reference audio must be a RIFF/WAVE file.");
        }

        WavFormat? format = null;
        ReadOnlySpan<byte> pcm = default;
        var offset = 12;
        while (offset + 8 <= wavBytes.Length)
        {
            var chunkId = wavBytes.Slice(offset, 4);
            var chunkSize = checked((int)BinaryPrimitives.ReadUInt32LittleEndian(wavBytes.Slice(offset + 4, 4)));
            offset += 8;

            if (chunkSize < 0 || offset > wavBytes.Length - chunkSize)
            {
                throw new InvalidDataException("WAV chunk extends beyond the available data.");
            }

            var chunk = wavBytes.Slice(offset, chunkSize);
            if (chunkId.SequenceEqual("fmt "u8))
            {
                format = ParseFormat(chunk);
            }
            else if (chunkId.SequenceEqual("data"u8))
            {
                pcm = chunk;
            }

            offset += chunkSize;
            if ((chunkSize & 1) != 0 && offset < wavBytes.Length)
            {
                offset++;
            }
        }

        if (format is null)
        {
            throw new InvalidDataException("WAV file has no fmt chunk.");
        }

        if (pcm.IsEmpty)
        {
            throw new InvalidDataException("WAV file has no PCM data.");
        }

        var samples = DecodeMonoPcm16(pcm, format.Value);
        if (samples.Length == 0)
        {
            throw new InvalidDataException("WAV PCM data contains no complete samples.");
        }

        var frameSamples = Math.Max(1, format.Value.SampleRate * AnalysisFrameMilliseconds / 1000);
        var envelope = BuildRmsEnvelope(samples, frameSamples);
        var novelty = BuildNovelty(envelope);
        var onsets = DetectOnsets(novelty, AnalysisFrameMilliseconds);
        var tempo = EstimateTempo(novelty, AnalysisFrameMilliseconds);
        var (rms, peak) = MeasureLevels(samples);
        var duration = TimeSpan.FromSeconds((double)samples.Length / format.Value.SampleRate);
        var contentSha = Convert.ToHexString(SHA256.HashData(wavBytes)).ToLowerInvariant();
        var featureSha = ComputeFeatureSha(format.Value, duration, rms, peak, tempo, onsets);

        return new ReferenceAudioAnalysis(
            ReferenceAudioAnalysis.CurrentSchemaVersion,
            format.Value.SampleRate,
            format.Value.ChannelCount,
            format.Value.BitsPerSample,
            duration,
            rms,
            peak,
            tempo,
            onsets,
            contentSha,
            featureSha);
    }

    private static WavFormat ParseFormat(ReadOnlySpan<byte> chunk)
    {
        if (chunk.Length < 16)
        {
            throw new InvalidDataException("WAV fmt chunk is truncated.");
        }

        var audioFormat = BinaryPrimitives.ReadUInt16LittleEndian(chunk[..2]);
        var channels = BinaryPrimitives.ReadUInt16LittleEndian(chunk.Slice(2, 2));
        var sampleRate = checked((int)BinaryPrimitives.ReadUInt32LittleEndian(chunk.Slice(4, 4)));
        var blockAlign = BinaryPrimitives.ReadUInt16LittleEndian(chunk.Slice(12, 2));
        var bitsPerSample = BinaryPrimitives.ReadUInt16LittleEndian(chunk.Slice(14, 2));

        if (audioFormat != 1)
        {
            throw new NotSupportedException($"WAV format {audioFormat} is not supported. Use uncompressed PCM WAV.");
        }

        if (channels is < 1 or > 8)
        {
            throw new NotSupportedException($"WAV channel count {channels} is not supported.");
        }

        if (sampleRate is < 8000 or > 192000)
        {
            throw new NotSupportedException($"WAV sample rate {sampleRate} Hz is outside the supported range.");
        }

        if (bitsPerSample != 16)
        {
            throw new NotSupportedException($"WAV bit depth {bitsPerSample} is not supported. Use 16-bit PCM WAV.");
        }

        var expectedBlockAlign = channels * (bitsPerSample / 8);
        if (blockAlign != expectedBlockAlign)
        {
            throw new InvalidDataException("WAV block alignment does not match channel/bit-depth metadata.");
        }

        return new WavFormat(sampleRate, channels, bitsPerSample, blockAlign);
    }

    private static double[] DecodeMonoPcm16(ReadOnlySpan<byte> pcm, WavFormat format)
    {
        if (pcm.Length % format.BlockAlign != 0)
        {
            throw new InvalidDataException("WAV data is not aligned to complete sample frames.");
        }

        var frameCount = pcm.Length / format.BlockAlign;
        var result = new double[frameCount];
        var bytesPerChannel = 2;
        for (var frame = 0; frame < frameCount; frame++)
        {
            var frameOffset = frame * format.BlockAlign;
            double sum = 0;
            for (var channel = 0; channel < format.ChannelCount; channel++)
            {
                var sampleOffset = frameOffset + channel * bytesPerChannel;
                var value = BinaryPrimitives.ReadInt16LittleEndian(pcm.Slice(sampleOffset, 2));
                sum += value / 32768d;
            }

            result[frame] = sum / format.ChannelCount;
        }

        return result;
    }

    private static double[] BuildRmsEnvelope(IReadOnlyList<double> samples, int frameSamples)
    {
        var frameCount = (samples.Count + frameSamples - 1) / frameSamples;
        var result = new double[frameCount];
        for (var frame = 0; frame < frameCount; frame++)
        {
            var start = frame * frameSamples;
            var end = Math.Min(samples.Count, start + frameSamples);
            double sumSquares = 0;
            for (var i = start; i < end; i++)
            {
                sumSquares += samples[i] * samples[i];
            }

            result[frame] = Math.Sqrt(sumSquares / Math.Max(1, end - start));
        }

        return result;
    }

    private static double[] BuildNovelty(IReadOnlyList<double> envelope)
    {
        var result = new double[envelope.Count];
        for (var i = 1; i < envelope.Count; i++)
        {
            result[i] = Math.Max(0d, envelope[i] - envelope[i - 1]);
        }

        return result;
    }

    private static IReadOnlyList<TimeSpan> DetectOnsets(IReadOnlyList<double> novelty, int frameMilliseconds)
    {
        if (novelty.Count == 0)
        {
            return Array.Empty<TimeSpan>();
        }

        var mean = novelty.Average();
        var variance = novelty.Sum(value => (value - mean) * (value - mean)) / novelty.Count;
        var threshold = mean + Math.Sqrt(variance) * 1.5d;
        threshold = Math.Max(threshold, 0.01d);

        var refractoryFrames = Math.Max(1, RefractoryMilliseconds / frameMilliseconds);
        var onsets = new List<TimeSpan>();
        var last = -refractoryFrames;
        for (var i = 1; i < novelty.Count - 1; i++)
        {
            if (i - last < refractoryFrames)
            {
                continue;
            }

            if (novelty[i] >= threshold && novelty[i] >= novelty[i - 1] && novelty[i] >= novelty[i + 1])
            {
                onsets.Add(TimeSpan.FromMilliseconds((long)i * frameMilliseconds));
                last = i;
            }
        }

        return onsets;
    }

    private static double EstimateTempo(IReadOnlyList<double> novelty, int frameMilliseconds)
    {
        if (novelty.Count < 4)
        {
            return 0d;
        }

        var minLag = Math.Max(1, (int)Math.Round(60000d / MaxTempoBpm / frameMilliseconds));
        var maxLag = Math.Max(minLag, (int)Math.Round(60000d / MinTempoBpm / frameMilliseconds));
        maxLag = Math.Min(maxLag, novelty.Count - 1);

        var bestLag = 0;
        var bestScore = 0d;
        for (var lag = minLag; lag <= maxLag; lag++)
        {
            double score = 0;
            for (var i = lag; i < novelty.Count; i++)
            {
                score += novelty[i] * novelty[i - lag];
            }

            if (score > bestScore)
            {
                bestScore = score;
                bestLag = lag;
            }
        }

        return bestLag == 0 || bestScore <= 1e-12
            ? 0d
            : Math.Round(60000d / (bestLag * frameMilliseconds), 3, MidpointRounding.AwayFromZero);
    }

    private static (double Rms, double Peak) MeasureLevels(IReadOnlyList<double> samples)
    {
        double sumSquares = 0;
        double peak = 0;
        foreach (var sample in samples)
        {
            sumSquares += sample * sample;
            peak = Math.Max(peak, Math.Abs(sample));
        }

        return (Math.Sqrt(sumSquares / samples.Count), peak);
    }

    private static string ComputeFeatureSha(
        WavFormat format,
        TimeSpan duration,
        double rms,
        double peak,
        double tempo,
        IReadOnlyList<TimeSpan> onsets)
    {
        var builder = new StringBuilder();
        builder.Append(ReferenceAudioAnalysis.CurrentSchemaVersion).Append('|')
            .Append(format.SampleRate).Append('|')
            .Append(format.ChannelCount).Append('|')
            .Append(format.BitsPerSample).Append('|')
            .Append(duration.Ticks).Append('|')
            .Append(rms.ToString("R", System.Globalization.CultureInfo.InvariantCulture)).Append('|')
            .Append(peak.ToString("R", System.Globalization.CultureInfo.InvariantCulture)).Append('|')
            .Append(tempo.ToString("R", System.Globalization.CultureInfo.InvariantCulture));

        foreach (var onset in onsets)
        {
            builder.Append('|').Append(onset.Ticks);
        }

        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(builder.ToString()))).ToLowerInvariant();
    }

    private readonly record struct WavFormat(int SampleRate, int ChannelCount, int BitsPerSample, int BlockAlign);
}
