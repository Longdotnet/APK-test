using System.Buffers.Binary;
using RobloxPiano.Core;

namespace RobloxPiano.Audio;

/// <summary>
/// Decodes client-owned audio through the same bounded NAudio ingest boundary used by
/// Audio-to-Piano, then emits deterministic PCM evidence for reference-candidate verification.
/// No source is uploaded and no external decoder/runtime is required.
/// </summary>
public sealed class ReferenceAudioFileAnalysisService
{
    public static readonly TimeSpan MaximumReferenceDuration = TimeSpan.FromMinutes(5);
    public const int ReferenceSampleRate = 22_050;

    private readonly AudioIngestService _ingest;

    public ReferenceAudioFileAnalysisService(AudioIngestService? ingest = null)
    {
        _ingest = ingest ?? new AudioIngestService();
    }

    public ReferenceAudioAnalysis AnalyzeFile(
        string path,
        CancellationToken cancellationToken = default)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        cancellationToken.ThrowIfCancellationRequested();

        var normalized = _ingest.DecodeFile(
            path,
            new AudioIngestOptions(ReferenceSampleRate, MaximumReferenceDuration),
            cancellationToken);
        cancellationToken.ThrowIfCancellationRequested();

        // Keep the established ReferenceAudioAnalyzer evidence contract by encoding the
        // normalized mono float stream to deterministic 16-bit PCM WAV in memory. The
        // five-minute bound caps the resulting buffer at roughly 13 MiB.
        var wav = EncodePcm16Wave(normalized, cancellationToken);
        return ReferenceAudioAnalyzer.AnalyzeWav(wav);
    }

    internal static byte[] EncodePcm16Wave(
        NormalizedAudio audio,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(audio);
        if (audio.SampleRate is < 8_000 or > 192_000)
            throw new ArgumentOutOfRangeException(nameof(audio), "Reference sample rate is outside the supported range.");
        if (audio.Samples.Length == 0)
            throw new InvalidDataException("Reference audio contains no samples.");

        var dataBytes = checked(audio.Samples.Length * sizeof(short));
        var result = new byte[checked(44 + dataBytes)];
        "RIFF"u8.CopyTo(result.AsSpan(0, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(result.AsSpan(4, 4), checked((uint)(36 + dataBytes)));
        "WAVE"u8.CopyTo(result.AsSpan(8, 4));
        "fmt "u8.CopyTo(result.AsSpan(12, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(result.AsSpan(16, 4), 16);
        BinaryPrimitives.WriteUInt16LittleEndian(result.AsSpan(20, 2), 1); // PCM
        BinaryPrimitives.WriteUInt16LittleEndian(result.AsSpan(22, 2), 1); // mono
        BinaryPrimitives.WriteUInt32LittleEndian(result.AsSpan(24, 4), checked((uint)audio.SampleRate));
        BinaryPrimitives.WriteUInt32LittleEndian(result.AsSpan(28, 4), checked((uint)(audio.SampleRate * sizeof(short))));
        BinaryPrimitives.WriteUInt16LittleEndian(result.AsSpan(32, 2), sizeof(short));
        BinaryPrimitives.WriteUInt16LittleEndian(result.AsSpan(34, 2), 16);
        "data"u8.CopyTo(result.AsSpan(36, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(result.AsSpan(40, 4), checked((uint)dataBytes));

        var destination = result.AsSpan(44);
        for (var index = 0; index < audio.Samples.Length; index++)
        {
            if ((index & 0x3fff) == 0)
                cancellationToken.ThrowIfCancellationRequested();

            var sample = float.IsFinite(audio.Samples[index])
                ? Math.Clamp(audio.Samples[index], -1f, 1f)
                : 0f;
            var quantized = sample <= -1f
                ? short.MinValue
                : checked((short)Math.Round(sample * short.MaxValue, MidpointRounding.AwayFromZero));
            BinaryPrimitives.WriteInt16LittleEndian(destination.Slice(index * sizeof(short), sizeof(short)), quantized);
        }

        return result;
    }
}
