namespace RobloxPiano.Audio;

public sealed record AudioTranscriptionReferenceNote
{
    public AudioTranscriptionReferenceNote(TimeSpan start, TimeSpan end, int midiNote)
    {
        if (start < TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(start));
        if (end <= start)
            throw new ArgumentOutOfRangeException(nameof(end));
        if (midiNote is < 0 or > 127)
            throw new ArgumentOutOfRangeException(nameof(midiNote));
        Start = start;
        End = end;
        MidiNote = midiNote;
    }

    public TimeSpan Start { get; }
    public TimeSpan End { get; }
    public TimeSpan Duration => End - Start;
    public int MidiNote { get; }
}

public sealed record AudioTranscriptionEvaluationOptions(
    TimeSpan? OnsetTolerance = null,
    double OffsetToleranceRatio = 0.20,
    TimeSpan? MinimumOffsetTolerance = null,
    bool RequireOffsetMatch = true)
{
    public TimeSpan EffectiveOnsetTolerance => OnsetTolerance ?? TimeSpan.FromMilliseconds(50);
    public TimeSpan EffectiveMinimumOffsetTolerance => MinimumOffsetTolerance ?? TimeSpan.FromMilliseconds(50);

    internal void Validate()
    {
        if (EffectiveOnsetTolerance < TimeSpan.Zero || EffectiveOnsetTolerance > TimeSpan.FromSeconds(1))
            throw new ArgumentOutOfRangeException(nameof(OnsetTolerance));
        if (!double.IsFinite(OffsetToleranceRatio) || OffsetToleranceRatio < 0d || OffsetToleranceRatio > 2d)
            throw new ArgumentOutOfRangeException(nameof(OffsetToleranceRatio));
        if (EffectiveMinimumOffsetTolerance < TimeSpan.Zero || EffectiveMinimumOffsetTolerance > TimeSpan.FromSeconds(2))
            throw new ArgumentOutOfRangeException(nameof(MinimumOffsetTolerance));
    }
}

public sealed record AudioTranscriptionNoteMatch(
    int ReferenceIndex,
    int EstimatedIndex,
    int MidiNote,
    TimeSpan OnsetError,
    TimeSpan OffsetError);

public sealed record AudioTranscriptionEvaluationResult(
    int ReferenceNotes,
    int EstimatedNotes,
    int MatchedNotes,
    double Precision,
    double Recall,
    double F1,
    double MeanAbsoluteOnsetErrorMilliseconds,
    double MeanAbsoluteOffsetErrorMilliseconds,
    IReadOnlyList<AudioTranscriptionNoteMatch> Matches)
{
    public int FalsePositives => EstimatedNotes - MatchedNotes;
    public int FalseNegatives => ReferenceNotes - MatchedNotes;
}

/// <summary>
/// Deterministic ground-truth evaluator for Audio-to-Piano corpus calibration.
/// Defaults mirror mature mir_eval note-transcription semantics where they map to integer MIDI output:
/// same pitch, inclusive 50 ms onset tolerance, offset tolerance max(50 ms, 20% reference duration),
/// and maximum-cardinality one-to-one bipartite matching. Measurement never mutates playback truth.
/// </summary>
public sealed class AudioTranscriptionEvaluator
{
    public AudioTranscriptionEvaluationResult Evaluate(
        IReadOnlyList<AudioTranscriptionReferenceNote> reference,
        IReadOnlyList<BasicPitchTranscribedNote> estimated,
        AudioTranscriptionEvaluationOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(reference);
        ArgumentNullException.ThrowIfNull(estimated);
        options ??= new AudioTranscriptionEvaluationOptions();
        options.Validate();
        cancellationToken.ThrowIfCancellationRequested();

        var references = reference.Select((note, index) => new ReferenceItem(note, index)).ToArray();
        var estimates = estimated.Select((note, index) => new EstimateItem(note, index)).ToArray();
        var adjacency = new int[references.Length][];

        for (var r = 0; r < references.Length; r++)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var referenceNote = references[r].Note;
            var durationToleranceTicks = (long)Math.Ceiling(referenceNote.Duration.Ticks * options.OffsetToleranceRatio);
            var offsetTolerance = TimeSpan.FromTicks(Math.Max(options.EffectiveMinimumOffsetTolerance.Ticks, durationToleranceTicks));
            var candidates = new List<(int Index, TimeSpan OnsetError, TimeSpan OffsetError)>();

            for (var e = 0; e < estimates.Length; e++)
            {
                var estimate = estimates[e].Note;
                if (estimate.MidiNote != referenceNote.MidiNote)
                    continue;
                var onsetError = Abs(estimate.Start - referenceNote.Start);
                if (onsetError > options.EffectiveOnsetTolerance)
                    continue;
                var offsetError = Abs(estimate.End - referenceNote.End);
                if (options.RequireOffsetMatch && offsetError > offsetTolerance)
                    continue;
                candidates.Add((e, onsetError, offsetError));
            }

            adjacency[r] = candidates
                .OrderBy(candidate => candidate.OnsetError)
                .ThenBy(candidate => candidate.OffsetError)
                .ThenBy(candidate => estimates[candidate.Index].OriginalIndex)
                .Select(candidate => candidate.Index)
                .ToArray();
        }

        // Kuhn augmenting-path matching: deterministic candidate ordering above, maximum cardinality overall.
        var referenceForEstimate = Enumerable.Repeat(-1, estimates.Length).ToArray();
        var referenceOrder = Enumerable.Range(0, references.Length)
            .OrderBy(index => adjacency[index].Length)
            .ThenBy(index => references[index].Note.Start)
            .ThenBy(index => references[index].Note.MidiNote)
            .ThenBy(index => references[index].OriginalIndex)
            .ToArray();

        foreach (var referenceIndex in referenceOrder)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var seen = new bool[estimates.Length];
            TryAugment(referenceIndex, adjacency, referenceForEstimate, seen, cancellationToken);
        }

        var matches = new List<AudioTranscriptionNoteMatch>();
        for (var estimatedIndex = 0; estimatedIndex < referenceForEstimate.Length; estimatedIndex++)
        {
            var referenceIndex = referenceForEstimate[estimatedIndex];
            if (referenceIndex < 0)
                continue;
            var referenceItem = references[referenceIndex];
            var estimateItem = estimates[estimatedIndex];
            matches.Add(new AudioTranscriptionNoteMatch(
                referenceItem.OriginalIndex,
                estimateItem.OriginalIndex,
                referenceItem.Note.MidiNote,
                Abs(estimateItem.Note.Start - referenceItem.Note.Start),
                Abs(estimateItem.Note.End - referenceItem.Note.End)));
        }
        matches.Sort((left, right) =>
        {
            var byReference = left.ReferenceIndex.CompareTo(right.ReferenceIndex);
            return byReference != 0 ? byReference : left.EstimatedIndex.CompareTo(right.EstimatedIndex);
        });

        var matched = matches.Count;
        var precision = estimated.Count == 0 ? 0d : matched / (double)estimated.Count;
        var recall = reference.Count == 0 ? 0d : matched / (double)reference.Count;
        var f1 = precision + recall == 0d ? 0d : 2d * precision * recall / (precision + recall);
        var meanOnset = matched == 0 ? 0d : matches.Average(match => match.OnsetError.TotalMilliseconds);
        var meanOffset = matched == 0 ? 0d : matches.Average(match => match.OffsetError.TotalMilliseconds);

        return new AudioTranscriptionEvaluationResult(
            reference.Count,
            estimated.Count,
            matched,
            precision,
            recall,
            f1,
            meanOnset,
            meanOffset,
            matches.AsReadOnly());
    }

    private static bool TryAugment(
        int referenceIndex,
        IReadOnlyList<int[]> adjacency,
        int[] referenceForEstimate,
        bool[] seen,
        CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        foreach (var estimatedIndex in adjacency[referenceIndex])
        {
            if (seen[estimatedIndex])
                continue;
            seen[estimatedIndex] = true;
            var currentlyMatchedReference = referenceForEstimate[estimatedIndex];
            if (currentlyMatchedReference < 0 ||
                TryAugment(currentlyMatchedReference, adjacency, referenceForEstimate, seen, cancellationToken))
            {
                referenceForEstimate[estimatedIndex] = referenceIndex;
                return true;
            }
        }
        return false;
    }

    private static TimeSpan Abs(TimeSpan value) => value < TimeSpan.Zero ? value.Negate() : value;
    private sealed record ReferenceItem(AudioTranscriptionReferenceNote Note, int OriginalIndex);
    private sealed record EstimateItem(BasicPitchTranscribedNote Note, int OriginalIndex);
}

public sealed record AudioTranscriptionEvaluationCase(
    string Name,
    IReadOnlyList<AudioTranscriptionReferenceNote> Reference,
    IReadOnlyList<BasicPitchTranscribedNote> Estimated);

public sealed record AudioTranscriptionCorpusEvaluation(
    int Cases,
    int ReferenceNotes,
    int EstimatedNotes,
    int MatchedNotes,
    double MicroPrecision,
    double MicroRecall,
    double MicroF1,
    double MacroF1,
    double MeanAbsoluteOnsetErrorMilliseconds,
    double MeanAbsoluteOffsetErrorMilliseconds,
    IReadOnlyDictionary<string, AudioTranscriptionEvaluationResult> Results);

public sealed class AudioTranscriptionCorpusEvaluator
{
    private readonly AudioTranscriptionEvaluator evaluator = new();

    public AudioTranscriptionCorpusEvaluation Evaluate(
        IReadOnlyList<AudioTranscriptionEvaluationCase> cases,
        AudioTranscriptionEvaluationOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(cases);
        if (cases.Count == 0)
            throw new ArgumentException("Evaluation corpus must contain at least one case.", nameof(cases));
        if (cases.Any(item => string.IsNullOrWhiteSpace(item.Name)))
            throw new ArgumentException("Every evaluation corpus case requires a stable name.", nameof(cases));
        if (cases.Select(item => item.Name).Distinct(StringComparer.Ordinal).Count() != cases.Count)
            throw new ArgumentException("Evaluation corpus case names must be unique.", nameof(cases));

        var results = new Dictionary<string, AudioTranscriptionEvaluationResult>(StringComparer.Ordinal);
        foreach (var item in cases)
        {
            cancellationToken.ThrowIfCancellationRequested();
            results.Add(item.Name, evaluator.Evaluate(item.Reference, item.Estimated, options, cancellationToken));
        }

        var referenceNotes = results.Values.Sum(result => result.ReferenceNotes);
        var estimatedNotes = results.Values.Sum(result => result.EstimatedNotes);
        var matchedNotes = results.Values.Sum(result => result.MatchedNotes);
        var microPrecision = estimatedNotes == 0 ? 0d : matchedNotes / (double)estimatedNotes;
        var microRecall = referenceNotes == 0 ? 0d : matchedNotes / (double)referenceNotes;
        var microF1 = microPrecision + microRecall == 0d ? 0d : 2d * microPrecision * microRecall / (microPrecision + microRecall);
        var macroF1 = results.Values.Average(result => result.F1);
        var matchedResults = results.Values.Where(result => result.MatchedNotes > 0).ToArray();
        var totalMatched = matchedResults.Sum(result => result.MatchedNotes);
        var meanOnset = totalMatched == 0 ? 0d : matchedResults.Sum(result => result.MeanAbsoluteOnsetErrorMilliseconds * result.MatchedNotes) / totalMatched;
        var meanOffset = totalMatched == 0 ? 0d : matchedResults.Sum(result => result.MeanAbsoluteOffsetErrorMilliseconds * result.MatchedNotes) / totalMatched;

        return new AudioTranscriptionCorpusEvaluation(
            cases.Count,
            referenceNotes,
            estimatedNotes,
            matchedNotes,
            microPrecision,
            microRecall,
            microF1,
            macroF1,
            meanOnset,
            meanOffset,
            new System.Collections.ObjectModel.ReadOnlyDictionary<string, AudioTranscriptionEvaluationResult>(results));
    }
}
