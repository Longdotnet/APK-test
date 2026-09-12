namespace RobloxPiano.Audio;

public enum AudioSourceSeparationAdoptionDecision
{
    Adopt,
    Review,
    Reject
}

public sealed record AudioSourceSeparationBenchmarkCase(
    string Name,
    AudioTranscriptionEvaluationResult Direct,
    AudioTranscriptionEvaluationResult Candidate);

public sealed record AudioSourceSeparationResourceMeasurement(
    long AddedBundleBytes,
    long PeakWorkingSetBytes,
    double ProcessingSecondsPerAudioSecond)
{
    internal void Validate()
    {
        if (AddedBundleBytes < 0)
            throw new ArgumentOutOfRangeException(nameof(AddedBundleBytes));
        if (PeakWorkingSetBytes < 0)
            throw new ArgumentOutOfRangeException(nameof(PeakWorkingSetBytes));
        if (!double.IsFinite(ProcessingSecondsPerAudioSecond) || ProcessingSecondsPerAudioSecond < 0d)
            throw new ArgumentOutOfRangeException(nameof(ProcessingSecondsPerAudioSecond));
    }
}

public sealed record AudioSourceSeparationAdoptionOptions(
    double MinimumMicroF1Gain = 0.05,
    double MinimumMedianCaseF1Gain = 0.03,
    double MinimumImprovedCaseRatio = 0.60,
    double MaximumAllowedCaseF1Regression = 0.05,
    long MaximumAddedBundleBytes = 268_435_456,
    long MaximumPeakWorkingSetBytes = 1_610_612_736,
    double MaximumProcessingSecondsPerAudioSecond = 4.0)
{
    internal void Validate()
    {
        ValidateRatio(MinimumMicroF1Gain, nameof(MinimumMicroF1Gain));
        ValidateRatio(MinimumMedianCaseF1Gain, nameof(MinimumMedianCaseF1Gain));
        ValidateRatio(MinimumImprovedCaseRatio, nameof(MinimumImprovedCaseRatio));
        ValidateRatio(MaximumAllowedCaseF1Regression, nameof(MaximumAllowedCaseF1Regression));
        if (MaximumAddedBundleBytes < 0)
            throw new ArgumentOutOfRangeException(nameof(MaximumAddedBundleBytes));
        if (MaximumPeakWorkingSetBytes < 0)
            throw new ArgumentOutOfRangeException(nameof(MaximumPeakWorkingSetBytes));
        if (!double.IsFinite(MaximumProcessingSecondsPerAudioSecond) || MaximumProcessingSecondsPerAudioSecond <= 0d)
            throw new ArgumentOutOfRangeException(nameof(MaximumProcessingSecondsPerAudioSecond));
    }

    private static void ValidateRatio(double value, string name)
    {
        if (!double.IsFinite(value) || value is < 0d or > 1d)
            throw new ArgumentOutOfRangeException(name);
    }
}

public sealed record AudioSourceSeparationAdoptionAssessment(
    AudioSourceSeparationAdoptionDecision Decision,
    int Cases,
    double DirectMicroF1,
    double CandidateMicroF1,
    double MicroF1Gain,
    double MedianCaseF1Gain,
    double WorstCaseF1Delta,
    double ImprovedCaseRatio,
    AudioSourceSeparationResourceMeasurement Resources,
    IReadOnlyDictionary<string, double> CaseF1Deltas,
    IReadOnlyList<string> Reasons);

/// <summary>
/// Evidence gate for deciding whether source separation is worth adding to the production Audio-to-Piano path.
/// It compares paired direct-vs-separated transcription results on the same ground-truth cases and combines
/// quality deltas with package, memory, and runtime budgets. It never mutates transcription or playback truth.
/// </summary>
public sealed class AudioSourceSeparationAdoptionEvaluator
{
    private const double MetricTolerance = 1e-9;
    private const double ImprovementEpsilon = 1e-6;

    public AudioSourceSeparationAdoptionAssessment Evaluate(
        IReadOnlyList<AudioSourceSeparationBenchmarkCase> cases,
        AudioSourceSeparationResourceMeasurement resources,
        AudioSourceSeparationAdoptionOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(cases);
        ArgumentNullException.ThrowIfNull(resources);
        if (cases.Count == 0)
            throw new ArgumentException("Source-separation benchmark requires at least one paired case.", nameof(cases));
        if (cases.Any(item => string.IsNullOrWhiteSpace(item.Name)))
            throw new ArgumentException("Every source-separation benchmark case requires a stable name.", nameof(cases));
        if (cases.Select(item => item.Name).Distinct(StringComparer.Ordinal).Count() != cases.Count)
            throw new ArgumentException("Source-separation benchmark case names must be unique.", nameof(cases));

        resources.Validate();
        options ??= new AudioSourceSeparationAdoptionOptions();
        options.Validate();
        cancellationToken.ThrowIfCancellationRequested();

        var deltas = new Dictionary<string, double>(StringComparer.Ordinal);
        long directReference = 0;
        long directEstimated = 0;
        long directMatched = 0;
        long candidateReference = 0;
        long candidateEstimated = 0;
        long candidateMatched = 0;

        foreach (var item in cases)
        {
            cancellationToken.ThrowIfCancellationRequested();
            ArgumentNullException.ThrowIfNull(item.Direct);
            ArgumentNullException.ThrowIfNull(item.Candidate);
            ValidateEvaluationResult(item.Direct, $"{item.Name}:direct");
            ValidateEvaluationResult(item.Candidate, $"{item.Name}:candidate");

            if (item.Direct.ReferenceNotes != item.Candidate.ReferenceNotes)
            {
                throw new ArgumentException(
                    $"Paired benchmark case '{item.Name}' must use the same ground-truth reference note count.",
                    nameof(cases));
            }

            checked
            {
                directReference += item.Direct.ReferenceNotes;
                directEstimated += item.Direct.EstimatedNotes;
                directMatched += item.Direct.MatchedNotes;
                candidateReference += item.Candidate.ReferenceNotes;
                candidateEstimated += item.Candidate.EstimatedNotes;
                candidateMatched += item.Candidate.MatchedNotes;
            }

            deltas.Add(item.Name, item.Candidate.F1 - item.Direct.F1);
        }

        var directMicroF1 = F1(directMatched, directReference, directEstimated);
        var candidateMicroF1 = F1(candidateMatched, candidateReference, candidateEstimated);
        var microGain = candidateMicroF1 - directMicroF1;
        var orderedDeltas = deltas.Values.OrderBy(value => value).ToArray();
        var medianGain = Median(orderedDeltas);
        var worstDelta = orderedDeltas[0];
        var improvedRatio = orderedDeltas.Count(delta => delta > ImprovementEpsilon) / (double)orderedDeltas.Length;

        var reasons = new List<string>();
        var rejected = false;

        if (microGain <= ImprovementEpsilon)
        {
            rejected = true;
            reasons.Add("MICRO_F1_NO_GAIN");
        }
        if (worstDelta < -options.MaximumAllowedCaseF1Regression - MetricTolerance)
        {
            rejected = true;
            reasons.Add("CASE_REGRESSION_CRITICAL");
        }

        if (!rejected)
        {
            if (microGain + MetricTolerance < options.MinimumMicroF1Gain)
                reasons.Add("MICRO_F1_GAIN_LOW");
            if (medianGain + MetricTolerance < options.MinimumMedianCaseF1Gain)
                reasons.Add("MEDIAN_F1_GAIN_LOW");
            if (improvedRatio + MetricTolerance < options.MinimumImprovedCaseRatio)
                reasons.Add("IMPROVED_CASE_RATIO_LOW");
            if (resources.AddedBundleBytes > options.MaximumAddedBundleBytes)
                reasons.Add("BUNDLE_BUDGET_EXCEEDED");
            if (resources.PeakWorkingSetBytes > options.MaximumPeakWorkingSetBytes)
                reasons.Add("MEMORY_BUDGET_EXCEEDED");
            if (resources.ProcessingSecondsPerAudioSecond > options.MaximumProcessingSecondsPerAudioSecond)
                reasons.Add("RUNTIME_BUDGET_EXCEEDED");
        }

        var decision = rejected
            ? AudioSourceSeparationAdoptionDecision.Reject
            : reasons.Count == 0
                ? AudioSourceSeparationAdoptionDecision.Adopt
                : AudioSourceSeparationAdoptionDecision.Review;

        return new AudioSourceSeparationAdoptionAssessment(
            decision,
            cases.Count,
            directMicroF1,
            candidateMicroF1,
            microGain,
            medianGain,
            worstDelta,
            improvedRatio,
            resources,
            new System.Collections.ObjectModel.ReadOnlyDictionary<string, double>(deltas),
            reasons.AsReadOnly());
    }

    private static void ValidateEvaluationResult(AudioTranscriptionEvaluationResult result, string label)
    {
        if (result.ReferenceNotes <= 0)
            throw new ArgumentException($"{label} requires at least one reference note.");
        if (result.EstimatedNotes < 0 || result.MatchedNotes < 0)
            throw new ArgumentException($"{label} contains negative note counts.");
        if (result.MatchedNotes > result.ReferenceNotes || result.MatchedNotes > result.EstimatedNotes)
            throw new ArgumentException($"{label} contains impossible matched-note counts.");

        var precision = result.EstimatedNotes == 0 ? 0d : result.MatchedNotes / (double)result.EstimatedNotes;
        var recall = result.MatchedNotes / (double)result.ReferenceNotes;
        var f1 = precision + recall == 0d ? 0d : 2d * precision * recall / (precision + recall);

        ValidateMetric(result.Precision, precision, $"{label}:precision");
        ValidateMetric(result.Recall, recall, $"{label}:recall");
        ValidateMetric(result.F1, f1, $"{label}:f1");
        if (!double.IsFinite(result.MeanAbsoluteOnsetErrorMilliseconds) || result.MeanAbsoluteOnsetErrorMilliseconds < 0d)
            throw new ArgumentException($"{label} contains invalid onset error.");
        if (!double.IsFinite(result.MeanAbsoluteOffsetErrorMilliseconds) || result.MeanAbsoluteOffsetErrorMilliseconds < 0d)
            throw new ArgumentException($"{label} contains invalid offset error.");
    }

    private static void ValidateMetric(double actual, double expected, string label)
    {
        if (!double.IsFinite(actual) || actual is < 0d or > 1d || Math.Abs(actual - expected) > MetricTolerance)
            throw new ArgumentException($"{label} is inconsistent with note counts.");
    }

    private static double F1(long matched, long reference, long estimated)
    {
        var precision = estimated == 0 ? 0d : matched / (double)estimated;
        var recall = reference == 0 ? 0d : matched / (double)reference;
        return precision + recall == 0d ? 0d : 2d * precision * recall / (precision + recall);
    }

    private static double Median(IReadOnlyList<double> sorted)
    {
        var middle = sorted.Count / 2;
        return sorted.Count % 2 == 1
            ? sorted[middle]
            : (sorted[middle - 1] + sorted[middle]) / 2d;
    }
}
