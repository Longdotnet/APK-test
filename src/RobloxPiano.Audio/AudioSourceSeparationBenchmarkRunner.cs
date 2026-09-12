namespace RobloxPiano.Audio;

public sealed record AudioSourceSeparationBenchmarkInputCase(
    string Name,
    TimeSpan AudioDuration,
    IReadOnlyList<AudioTranscriptionReferenceNote> Reference);

public sealed record AudioSourceSeparationCandidateRun(
    IReadOnlyList<BasicPitchTranscribedNote> EstimatedNotes,
    TimeSpan Elapsed,
    long PeakWorkingSetBytes,
    long AddedBundleBytes);

public sealed record AudioSourceSeparationBenchmarkCaseResult(
    string Name,
    TimeSpan AudioDuration,
    AudioTranscriptionEvaluationResult Direct,
    AudioTranscriptionEvaluationResult Candidate,
    TimeSpan CandidateElapsed,
    long CandidatePeakWorkingSetBytes,
    long CandidateAddedBundleBytes);

public sealed record AudioSourceSeparationBenchmarkRun(
    IReadOnlyList<AudioSourceSeparationBenchmarkCaseResult> Cases,
    AudioSourceSeparationResourceMeasurement Resources,
    AudioSourceSeparationAdoptionAssessment Assessment);

/// <summary>
/// Runs paired direct-vs-separated transcription benchmarks over the same ground-truth corpus,
/// derives resource measurements from the observed candidate runs, then feeds those measurements
/// into <see cref="AudioSourceSeparationAdoptionEvaluator"/>. This is engineering evaluation
/// infrastructure only; it does not choose or mutate production playback/transcription state.
/// </summary>
public sealed class AudioSourceSeparationBenchmarkRunner
{
    private readonly AudioTranscriptionEvaluator evaluator = new();
    private readonly AudioSourceSeparationAdoptionEvaluator adoptionEvaluator = new();

    public async Task<AudioSourceSeparationBenchmarkRun> RunAsync(
        IReadOnlyList<AudioSourceSeparationBenchmarkInputCase> cases,
        Func<AudioSourceSeparationBenchmarkInputCase, CancellationToken, ValueTask<IReadOnlyList<BasicPitchTranscribedNote>>> directTranscriber,
        Func<AudioSourceSeparationBenchmarkInputCase, CancellationToken, ValueTask<AudioSourceSeparationCandidateRun>> candidateTranscriber,
        AudioSourceSeparationAdoptionOptions? adoptionOptions = null,
        AudioTranscriptionEvaluationOptions? evaluationOptions = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(cases);
        ArgumentNullException.ThrowIfNull(directTranscriber);
        ArgumentNullException.ThrowIfNull(candidateTranscriber);
        ValidateCases(cases);
        cancellationToken.ThrowIfCancellationRequested();

        var results = new List<AudioSourceSeparationBenchmarkCaseResult>(cases.Count);
        long? expectedBundleBytes = null;
        long peakWorkingSetBytes = 0;
        double totalCandidateSeconds = 0d;
        double totalAudioSeconds = 0d;

        foreach (var item in cases)
        {
            cancellationToken.ThrowIfCancellationRequested();

            var directNotes = await directTranscriber(item, cancellationToken).ConfigureAwait(false);
            ArgumentNullException.ThrowIfNull(directNotes);
            cancellationToken.ThrowIfCancellationRequested();
            var candidateRun = await candidateTranscriber(item, cancellationToken).ConfigureAwait(false);
            ArgumentNullException.ThrowIfNull(candidateRun);
            ArgumentNullException.ThrowIfNull(candidateRun.EstimatedNotes);
            ValidateCandidateRun(item.Name, candidateRun);

            expectedBundleBytes ??= candidateRun.AddedBundleBytes;
            if (candidateRun.AddedBundleBytes != expectedBundleBytes.Value)
            {
                throw new ArgumentException(
                    $"Candidate added-bundle measurement must be stable across benchmark cases. '{item.Name}' reported {candidateRun.AddedBundleBytes} bytes after {expectedBundleBytes.Value} bytes was established.",
                    nameof(candidateTranscriber));
            }

            var direct = evaluator.Evaluate(item.Reference, directNotes, evaluationOptions, cancellationToken);
            var candidate = evaluator.Evaluate(item.Reference, candidateRun.EstimatedNotes, evaluationOptions, cancellationToken);
            results.Add(new AudioSourceSeparationBenchmarkCaseResult(
                item.Name,
                item.AudioDuration,
                direct,
                candidate,
                candidateRun.Elapsed,
                candidateRun.PeakWorkingSetBytes,
                candidateRun.AddedBundleBytes));

            peakWorkingSetBytes = Math.Max(peakWorkingSetBytes, candidateRun.PeakWorkingSetBytes);
            totalCandidateSeconds += candidateRun.Elapsed.TotalSeconds;
            totalAudioSeconds += item.AudioDuration.TotalSeconds;
        }

        var resources = new AudioSourceSeparationResourceMeasurement(
            expectedBundleBytes ?? 0L,
            peakWorkingSetBytes,
            totalAudioSeconds <= 0d ? 0d : totalCandidateSeconds / totalAudioSeconds);
        var pairedCases = results
            .Select(item => new AudioSourceSeparationBenchmarkCase(item.Name, item.Direct, item.Candidate))
            .ToArray();
        var assessment = adoptionEvaluator.Evaluate(pairedCases, resources, adoptionOptions, cancellationToken);

        return new AudioSourceSeparationBenchmarkRun(
            results.AsReadOnly(),
            resources,
            assessment);
    }

    private static void ValidateCases(IReadOnlyList<AudioSourceSeparationBenchmarkInputCase> cases)
    {
        if (cases.Count == 0)
            throw new ArgumentException("Source-separation benchmark runner requires at least one case.", nameof(cases));
        if (cases.Any(item => item is null))
            throw new ArgumentException("Source-separation benchmark cases cannot contain null entries.", nameof(cases));
        if (cases.Any(item => string.IsNullOrWhiteSpace(item.Name)))
            throw new ArgumentException("Every source-separation benchmark case requires a stable name.", nameof(cases));
        if (cases.Select(item => item.Name).Distinct(StringComparer.Ordinal).Count() != cases.Count)
            throw new ArgumentException("Source-separation benchmark case names must be unique.", nameof(cases));

        foreach (var item in cases)
        {
            if (item.AudioDuration <= TimeSpan.Zero || item.AudioDuration > TimeSpan.FromHours(2))
                throw new ArgumentOutOfRangeException(nameof(cases), $"Benchmark case '{item.Name}' has an invalid audio duration.");
            ArgumentNullException.ThrowIfNull(item.Reference);
            if (item.Reference.Count == 0)
                throw new ArgumentException($"Benchmark case '{item.Name}' requires ground-truth notes.", nameof(cases));
        }
    }

    private static void ValidateCandidateRun(string caseName, AudioSourceSeparationCandidateRun run)
    {
        if (run.Elapsed < TimeSpan.Zero || run.Elapsed > TimeSpan.FromDays(1))
            throw new ArgumentOutOfRangeException(nameof(run), $"Candidate run '{caseName}' has an invalid elapsed time.");
        if (run.PeakWorkingSetBytes < 0)
            throw new ArgumentOutOfRangeException(nameof(run), $"Candidate run '{caseName}' has a negative peak working set.");
        if (run.AddedBundleBytes < 0)
            throw new ArgumentOutOfRangeException(nameof(run), $"Candidate run '{caseName}' has a negative added bundle size.");
    }
}
