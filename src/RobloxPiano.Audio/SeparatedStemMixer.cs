namespace RobloxPiano.Audio;

public sealed record SeparatedStemMixOptions(
    float VocalGain = 1.0f,
    float OtherGain = 0.22f,
    float MaximumPeak = 0.98f)
{
    internal void Validate()
    {
        if (!float.IsFinite(VocalGain) || VocalGain is <= 0f or > 2f)
            throw new ArgumentOutOfRangeException(nameof(VocalGain));
        if (!float.IsFinite(OtherGain) || OtherGain is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(OtherGain));
        if (!float.IsFinite(MaximumPeak) || MaximumPeak is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MaximumPeak));
    }
}

public sealed record SeparatedStemMixDiagnostics(
    int VocalSamples,
    int OtherSamples,
    int OutputSamples,
    float VocalGain,
    float OtherGain,
    float PeakBeforeNormalization,
    float AppliedNormalizationGain);

public sealed record SeparatedStemMixResult(
    NormalizedAudio Audio,
    SeparatedStemMixDiagnostics Diagnostics);

/// <summary>
/// Deterministically combines a separated lead/vocal stem with a deliberately quiet non-drum accompaniment stem.
/// Bass and drums never enter this mix. The lead stem stays dominant so Basic Pitch can continue to establish
/// melody truth while restrained harmonic material remains available to the existing Roblox piano arranger.
/// </summary>
public sealed class SeparatedStemMixer
{
    public SeparatedStemMixResult Mix(
        NormalizedAudio vocals,
        NormalizedAudio other,
        SeparatedStemMixOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(vocals);
        ArgumentNullException.ThrowIfNull(other);
        options ??= new SeparatedStemMixOptions();
        options.Validate();

        if (vocals.SampleRate != other.SampleRate)
            throw new ArgumentException("Separated stems must share a normalized sample rate.", nameof(other));

        var count = Math.Max(vocals.Samples.Length, other.Samples.Length);
        if (count == 0)
            throw new InvalidDataException("Separated stems contain no audio samples.");

        var samples = new float[count];
        var peak = 0f;
        for (var i = 0; i < count; i++)
        {
            if ((i & 8191) == 0)
                cancellationToken.ThrowIfCancellationRequested();

            var vocal = i < vocals.Samples.Length ? vocals.Samples[i] : 0f;
            var accompaniment = i < other.Samples.Length ? other.Samples[i] : 0f;
            var mixed = (vocal * options.VocalGain) + (accompaniment * options.OtherGain);
            samples[i] = mixed;
            peak = Math.Max(peak, Math.Abs(mixed));
        }

        var normalizationGain = peak > options.MaximumPeak
            ? options.MaximumPeak / peak
            : 1f;
        if (normalizationGain < 1f)
        {
            for (var i = 0; i < samples.Length; i++)
            {
                if ((i & 8191) == 0)
                    cancellationToken.ThrowIfCancellationRequested();
                samples[i] *= normalizationGain;
            }
        }

        return new SeparatedStemMixResult(
            new NormalizedAudio(samples, vocals.SampleRate),
            new SeparatedStemMixDiagnostics(
                vocals.Samples.Length,
                other.Samples.Length,
                samples.Length,
                options.VocalGain,
                options.OtherGain,
                peak,
                normalizationGain));
    }
}
