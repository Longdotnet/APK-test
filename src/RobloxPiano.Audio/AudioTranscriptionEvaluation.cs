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

/// <summary>
/// Ground-truth matching policy aligned with the mature mir_eval transcription convention:
/// same note pitch, onset within 50 ms by default, and offset within the greater of
/// 50 ms or 20% of the reference-note duration. Matching is one-to-one and deterministic.
/// </summary>
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
/// Deterministic note-level evaluator for Audio-to-Piano corpus calibration.
/// This is measurement only: it never changes decoded notes, arrangements or playback truth.
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

        var orderedReferences = reference
            .Select((note, index) => (Note: note, OriginalIndex: index))
            .OrderBy(item => item.Note.Start)
            .ThenBy(item => item.Note.MidiNote)
            .ThenBy(item => item.Note.End)
            .ToArray();
        var orderedEstimates = estimated
            .Select((note, index) => (Note: note, OriginalIndex: index))
            .OrderBy(item => item.Note.Start)
            .ThenBy(item => item.Note.MidiNote)
            .ThenBy(item => item.Note.End)
            .ToArray();
        var usedEstimates = new bool[orderedEstimates.Length];
        var matches = new List<AudioTranscriptionNoteMatch>(Math.Min(reference.Count, estimated.Count));

        foreach (var referenceItem in orderedReferences)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var referenceNote = referenceItem.Note;
            var offsetTolerance = TimeSpan.FromTicks(Math.Max(
                options.EffectiveMinimumOffsetTolerance.Ticks,
                referenceNote.Duration.Ticks * options.OffsetToleranceRatio));

            var bestIndex = -1;
            var bestOnsetError = TimeSpan.MaxValue;
            var bestOffsetError = TimeSpan.MaxValue;
            for (var estimatedIndex = 0; estimatedIndex < orderedEstimates.Length; estimatedIndex++)
            {
                if (usedEstimates[estimatedIndex])
                    continue;

                var estimate = orderedEstimates[estimatedIndex].Note;
                if (estimate.MidiNote != referenceNote.MidiNote)
                    continue;

                var onsetError = Abs(estimate.Start - referenceNote.Start);
                if (onsetError > options.EffectiveOnsetTolerance)
                    continue;

                var offsetError = Abs(estimate.End - referenceNote.End);
                if (options.RequireOffsetMatch && offsetError > offsetTolerance)
                    continue;

                if (onsetError < bestOnsetError ||
                    (onsetError == bestOnsetError && offsetError < bestOffsetError) ||
                    (onsetError == bestOnsetError && offsetError == bestOffsetError && estimatedIndex < bestIndex))
                {
                    bestIndex = estimatedIndex;
                    bestOnsetError = onsetError;
                    bestOffsetError = offsetError;
                }
            }

            if (bestIndex < 0)
                continue;

            usedEstimates[bestIndex] = true;
            var estimateItem = orderedEstimates[bestIndex];
            matches.Add(new AudioTranscriptionNoteMatch(
                referenceItem.OriginalIndex,
                estimateItem.OriginalIndex,
                referenceNote.MidiNote,
                bestOnsetError,
                bestOffsetError));
        }

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

    private static TimeSpan Abs(TimeSpan value) => value < TimeSpan.Zero ? value.Negate() : value;
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

/// <summary>
/// Aggregates individually named synthetic/licensed corpus cases without hiding weak examples behind a single score.
/// </summary>
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
        var microF1 = microPrecision + microRecall == 0d
            ? 0d
            : 2d * microPrecision * microRecall / (microPrecision + microRecall);
        var macroF1 = results.Values.Average(result => result.F1);
        var matchedResults = results.Values.Where(result => result.MatchedNotes > 0).ToArray();
        var totalMatched = matchedResults.Sum(result => result.MatchedNotes);
        var meanOnset = totalMatched == 0
            ? 0d
            : matchedResults.Sum(result => result.MeanAbsoluteOnsetErrorMilliseconds * result.MatchedNotes) / totalMatched;
        var meanOffset = totalMatched == 0
            ? 0d
            : matchedResults.Sum(result => result.MeanAbsoluteOffsetErrorMilliseconds * result.MatchedNotes) / totalMatched;

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
