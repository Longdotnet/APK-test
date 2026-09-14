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
    TimeSpan? Release = null,
    bool RequireMelodicFallback = true,
    float MinimumMelodicAutocorrelation = 0.28f,
    float MinimumLeadFrequencyHz = 110f,
    float MaximumLeadFrequencyHz = 1760f,
    int MelodicAnalysisTargetSampleRate = 4000)
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
        if (!float.IsFinite(MinimumMelodicAutocorrelation) || MinimumMelodicAutocorrelation is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MinimumMelodicAutocorrelation));
        if (!float.IsFinite(MinimumLeadFrequencyHz) || MinimumLeadFrequencyHz <= 20f)
            throw new ArgumentOutOfRangeException(nameof(MinimumLeadFrequencyHz));
        if (!float.IsFinite(MaximumLeadFrequencyHz) || MaximumLeadFrequencyHz <= MinimumLeadFrequencyHz)
            throw new ArgumentOutOfRangeException(nameof(MaximumLeadFrequencyHz));
        if (MelodicAnalysisTargetSampleRate is < 1000 or > 12000)
            throw new ArgumentOutOfRangeException(nameof(MelodicAnalysisTargetSampleRate));
    }
}

public sealed record SectionAwareStemCompositionDiagnostics(
    int Windows,
    int EnergyEligibleWindows,
    int RejectedNonMelodicWindows,
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
/// accompaniment only across sustained vocal-weak regions. Energy alone is not enough: accompaniment
/// must also contain stable periodic energy in a lead-like frequency band, which keeps sustained drums,
/// low bass and broadband noise from becoming melody truth. This remains a source-selection layer;
/// Spleeter owns separation and Basic Pitch owns pitch transcription.
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
        var energyEligibleWindows = 0;
        var rejectedNonMelodicWindows = 0;

        for (var window = 0; window < windowCount; window++)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var start = window * windowSamples;
            var end = Math.Min(vocals.Samples.Length, start + windowSamples);
            var accompanimentEnd = Math.Min(accompaniment.Samples.Length, end);
            var vocalRms = RootMeanSquare(vocals.Samples, start, end);
            var accompanimentRms = RootMeanSquare(accompaniment.Samples, start, accompanimentEnd);
            var ratio = accompanimentRms / Math.Max(0.000_001f, vocalRms);
            var energyEligible = vocalRms <= options.MaximumVocalRms
                && accompanimentRms >= options.MinimumAccompanimentRms
                && ratio >= options.MinimumAccompanimentToVocalRatio;

            if (!energyEligible)
                continue;

            energyEligibleWindows++;
            if (!options.RequireMelodicFallback || LooksMelodic(
                    accompaniment.Samples,
                    start,
                    accompanimentEnd,
                    sampleRate,
                    options,
                    cancellationToken))
            {
                eligible[window] = true;
            }
            else
            {
                rejectedNonMelodicWindows++;
            }
        }

        var active = RequireSustainedRuns(eligible, options.MinimumConsecutiveFallbackWindows);
        var fallbackWindows = active.Count(value => value);
        if (fallbackWindows == 0 || options.AccompanimentGain == 0f)
        {
            return new SectionAwareStemCompositionResult(
                vocals,
                new SectionAwareStemCompositionDiagnostics(
                    windowCount,
                    energyEligibleWindows,
                    rejectedNonMelodicWindows,
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
                energyEligibleWindows,
                rejectedNonMelodicWindows,
                fallbackWindows,
                TimeSpan.FromSeconds(fallbackWindows * options.EffectiveWindowDuration.TotalSeconds),
                options.AccompanimentGain,
                peak,
                normalizationGain,
                vocals.Samples.Length,
                accompaniment.Samples.Length,
                output.Length));
    }

    private static bool LooksMelodic(
        float[] samples,
        int start,
        int end,
        int sampleRate,
        SectionAwareStemCompositionOptions options,
        CancellationToken cancellationToken)
    {
        if (end - start < 8)
            return false;

        // Analyze a bounded, decimated view of the window. We only need a conservative periodicity gate,
        // not another pitch transcriber; Basic Pitch remains the authoritative transcription model.
        var stride = Math.Max(1, sampleRate / options.MelodicAnalysisTargetSampleRate);
        var effectiveRate = sampleRate / (double)stride;
        var nyquistSafeMaximum = Math.Min(options.MaximumLeadFrequencyHz, (float)(effectiveRate * 0.45d));
        if (nyquistSafeMaximum <= options.MinimumLeadFrequencyHz)
            return false;

        var minimumLag = Math.Max(1, (int)Math.Floor(effectiveRate / nyquistSafeMaximum));
        var maximumLag = Math.Max(minimumLag, (int)Math.Ceiling(effectiveRate / options.MinimumLeadFrequencyHz));
        var decimatedCount = Math.Max(0, (end - start + stride - 1) / stride);
        maximumLag = Math.Min(maximumLag, Math.Max(1, decimatedCount / 2));
        if (maximumLag < minimumLag)
            return false;

        var bestCorrelation = double.NegativeInfinity;
        for (var lag = minimumLag; lag <= maximumLag; lag++)
        {
            cancellationToken.ThrowIfCancellationRequested();
            double cross = 0d;
            double leftEnergy = 0d;
            double rightEnergy = 0d;
            var offset = lag * stride;
            for (var index = start + offset; index < end; index += stride)
            {
                var left = samples[index];
                var right = samples[index - offset];
                cross += left * right;
                leftEnergy += left * left;
                rightEnergy += right * right;
            }

            var denominator = Math.Sqrt(leftEnergy * rightEnergy);
            if (denominator <= 1e-12d)
                continue;

            var correlation = cross / denominator;
            if (correlation > bestCorrelation)
                bestCorrelation = correlation;
        }

        return bestCorrelation >= options.MinimumMelodicAutocorrelation;
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
