namespace RobloxPiano.Audio;

public sealed record SectionAwareStemCompositionOptions(
    TimeSpan? WindowDuration = null,
    int MinimumConsecutiveFallbackWindows = 2,
    float MaximumVocalRms = 0.018f,
    float MinimumAccompanimentRms = 0.008f,
    double MinimumAccompanimentToVocalRatio = 1.40d,
    float AccompanimentGain = 0.24f,
    float MaximumPeak = 0.98f,
    TimeSpan? Attack = null,
    TimeSpan? Release = null)
{
    public TimeSpan EffectiveWindowDuration => WindowDuration ?? TimeSpan.FromMilliseconds(400);
    public TimeSpan EffectiveAttack => Attack ?? TimeSpan.FromMilliseconds(80);
    public TimeSpan EffectiveRelease => Release ?? TimeSpan.FromMilliseconds(140);

    internal void Validate()
    {
        if (EffectiveWindowDuration <= TimeSpan.Zero || EffectiveWindowDuration > TimeSpan.FromSeconds(2))
            throw new ArgumentOutOfRangeException(nameof(WindowDuration));
        if (MinimumConsecutiveFallbackWindows < 1 || MinimumConsecutiveFallbackWindows > 8)
            throw new ArgumentOutOfRangeException(nameof(MinimumConsecutiveFallbackWindows));
        if (!float.IsFinite(MaximumVocalRms) || MaximumVocalRms is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MaximumVocalRms));
        if (!float.IsFinite(MinimumAccompanimentRms) || MinimumAccompanimentRms is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MinimumAccompanimentRms));
        if (!double.IsFinite(MinimumAccompanimentToVocalRatio) || MinimumAccompanimentToVocalRatio < 1d)
            throw new ArgumentOutOfRangeException(nameof(MinimumAccompanimentToVocalRatio));
        if (!float.IsFinite(AccompanimentGain) || AccompanimentGain is < 0f or > 0.5f)
            throw new ArgumentOutOfRangeException(nameof(AccompanimentGain));
        if (!float.IsFinite(MaximumPeak) || MaximumPeak is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MaximumPeak));
        if (EffectiveAttack < TimeSpan.Zero || EffectiveAttack > TimeSpan.FromSeconds(1))
            throw new ArgumentOutOfRangeException(nameof(Attack));
        if (EffectiveRelease < TimeSpan.Zero || EffectiveRelease > TimeSpan.FromSeconds(1))
            throw new ArgumentOutOfRangeException(nameof(Release));
    }
}

public sealed record SectionAwareStemCompositionDiagnostics(
    int Windows,
    int FallbackWindows,
    TimeSpan FallbackDuration,
    float AccompanimentGain,
    float PeakBeforeNormalization,
    float AppliedNormalizationGain,
    int VocalSamples,
    int AccompanimentSamples,
    int OutputSamples)
{
    public bool UsedAccompanimentFallback => FallbackWindows != 0;
}

public sealed record SectionAwareStemCompositionResult(
    NormalizedAudio Audio,
    SectionAwareStemCompositionDiagnostics Diagnostics);

/// <summary>
/// Keeps the Spleeter vocal stem authoritative while recovering instrumental hooks from the separated
/// accompaniment only across sustained vocal-weak regions. This is intentionally a source-selection layer,
/// not another separator: Spleeter owns stem separation and Basic Pitch still owns pitch transcription.
/// Short gaps are ignored so percussion fills and breaths do not repeatedly leak into melody truth.
/// </summary>
public sealed class SectionAwareStemComposer
{
    public SectionAwareStemCompositionResult Compose(
        NormalizedAudio vocals,
        NormalizedAudio accompaniment,
        SectionAwareStemCompositionOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(vocals);
        ArgumentNullException.ThrowIfNull(accompaniment);
        options ??= new SectionAwareStemCompositionOptions();
        options.Validate();

        if (vocals.SampleRate != accompaniment.SampleRate)
            throw new ArgumentException("Separated stems must share a normalized sample rate.", nameof(accompaniment));
        if (vocals.Samples.Length == 0)
            throw new InvalidDataException("Separated vocal stem contains no samples.");

        var sampleRate = vocals.SampleRate;
        var windowSamples = Math.Max(1, checked((int)Math.Round(options.EffectiveWindowDuration.TotalSeconds * sampleRate)));
        var windowCount = (vocals.Samples.Length + windowSamples - 1) / windowSamples;
        var eligible = new bool[windowCount];

        for (var window = 0; window < windowCount; window++)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var start = window * windowSamples;
            var end = Math.Min(vocals.Samples.Length, start + windowSamples);
            var vocalRms = RootMeanSquare(vocals.Samples, start, end);
            var accompanimentRms = RootMeanSquare(accompaniment.Samples, start, Math.Min(accompaniment.Samples.Length, end));
            var ratio = accompanimentRms / Math.Max(0.000_001f, vocalRms);
            eligible[window] = vocalRms <= options.MaximumVocalRms
                && accompanimentRms >= options.MinimumAccompanimentRms
                && ratio >= options.MinimumAccompanimentToVocalRatio;
        }

        var active = RequireSustainedRuns(eligible, options.MinimumConsecutiveFallbackWindows);
        var fallbackWindows = active.Count(value => value);
        if (fallbackWindows == 0 || options.AccompanimentGain == 0f)
        {
            return new SectionAwareStemCompositionResult(
                vocals,
                new SectionAwareStemCompositionDiagnostics(
                    windowCount,
                    0,
                    TimeSpan.Zero,
                    options.AccompanimentGain,
                    Peak(vocals.Samples),
                    1f,
                    vocals.Samples.Length,
                    accompaniment.Samples.Length,
                    vocals.Samples.Length));
        }

        var output = new float[vocals.Samples.Length];
        var attackAlpha = SmoothingAlpha(options.EffectiveAttack, sampleRate);
        var releaseAlpha = SmoothingAlpha(options.EffectiveRelease, sampleRate);
        var currentGain = 0f;
        var peak = 0f;

        for (var index = 0; index < output.Length; index++)
        {
            if ((index & 8191) == 0)
                cancellationToken.ThrowIfCancellationRequested();

            var window = Math.Min(active.Length - 1, index / windowSamples);
            var targetGain = active[window] ? options.AccompanimentGain : 0f;
            var alpha = targetGain > currentGain ? attackAlpha : releaseAlpha;
            currentGain += (targetGain - currentGain) * alpha;

            var vocal = vocals.Samples[index];
            var fallback = index < accompaniment.Samples.Length ? accompaniment.Samples[index] : 0f;
            var sample = vocal + (fallback * currentGain);
            output[index] = sample;
            peak = Math.Max(peak, Math.Abs(sample));
        }

        var normalizationGain = peak > options.MaximumPeak
            ? options.MaximumPeak / peak
            : 1f;
        if (normalizationGain < 1f)
        {
            for (var index = 0; index < output.Length; index++)
            {
                if ((index & 8191) == 0)
                    cancellationToken.ThrowIfCancellationRequested();
                output[index] *= normalizationGain;
            }
        }

        return new SectionAwareStemCompositionResult(
            new NormalizedAudio(output, sampleRate),
            new SectionAwareStemCompositionDiagnostics(
                windowCount,
                fallbackWindows,
                TimeSpan.FromSeconds(fallbackWindows * options.EffectiveWindowDuration.TotalSeconds),
                options.AccompanimentGain,
                peak,
                normalizationGain,
                vocals.Samples.Length,
                accompaniment.Samples.Length,
                output.Length));
    }

    private static float RootMeanSquare(float[] samples, int start, int end)
    {
        if (start >= samples.Length || end <= start)
            return 0f;
        end = Math.Min(samples.Length, end);
        double sum = 0d;
        var count = end - start;
        for (var index = start; index < end; index++)
        {
            var sample = samples[index];
            sum += sample * sample;
        }

        return (float)Math.Sqrt(sum / count);
    }

    private static bool[] RequireSustainedRuns(bool[] eligible, int minimumRunLength)
    {
        var result = new bool[eligible.Length];
        var runStart = -1;
        for (var index = 0; index <= eligible.Length; index++)
        {
            var isEligible = index < eligible.Length && eligible[index];
            if (isEligible && runStart < 0)
            {
                runStart = index;
                continue;
            }

            if (isEligible || runStart < 0)
                continue;

            var runLength = index - runStart;
            if (runLength >= minimumRunLength)
                Array.Fill(result, true, runStart, runLength);
            runStart = -1;
        }

        return result;
    }

    private static float SmoothingAlpha(TimeSpan duration, int sampleRate)
    {
        if (duration <= TimeSpan.Zero)
            return 1f;
        return (float)(1d - Math.Exp(-1d / (duration.TotalSeconds * sampleRate)));
    }

    private static float Peak(float[] samples)
    {
        var peak = 0f;
        foreach (var sample in samples)
            peak = Math.Max(peak, Math.Abs(sample));
        return peak;
    }
}
