using System.Collections.ObjectModel;

namespace RobloxPiano.Audio;

public sealed record BasicPitchHarmonicSuppressionOptions(
    bool Enabled = true,
    int MinimumHarmonic = 3,
    int MaximumHarmonic = 6,
    TimeSpan? OnsetTolerance = null,
    double MinimumCandidateOverlapRatio = 0.80,
    float MaximumCandidateToAnchorAmplitudeRatio = 0.50f,
    double MaximumHarmonicPitchErrorSemitones = 0.20,
    bool ProtectPowerOfTwoHarmonics = true)
{
    public TimeSpan EffectiveOnsetTolerance => OnsetTolerance ?? TimeSpan.FromMilliseconds(45);

    internal void Validate()
    {
        if (MinimumHarmonic < 2)
            throw new ArgumentOutOfRangeException(nameof(MinimumHarmonic));
        if (MaximumHarmonic < MinimumHarmonic)
            throw new ArgumentOutOfRangeException(nameof(MaximumHarmonic));
        if (EffectiveOnsetTolerance < TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(OnsetTolerance));
        if (!double.IsFinite(MinimumCandidateOverlapRatio) || MinimumCandidateOverlapRatio is < 0 or > 1)
            throw new ArgumentOutOfRangeException(nameof(MinimumCandidateOverlapRatio));
        if (!float.IsFinite(MaximumCandidateToAnchorAmplitudeRatio) || MaximumCandidateToAnchorAmplitudeRatio is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MaximumCandidateToAnchorAmplitudeRatio));
        if (!double.IsFinite(MaximumHarmonicPitchErrorSemitones) || MaximumHarmonicPitchErrorSemitones is < 0 or > 0.5)
            throw new ArgumentOutOfRangeException(nameof(MaximumHarmonicPitchErrorSemitones));
    }
}

public sealed record BasicPitchSuppressedHarmonic(
    BasicPitchTranscribedNote Candidate,
    BasicPitchTranscribedNote Anchor,
    int Harmonic,
    double HarmonicPitchErrorSemitones,
    double CandidateOverlapRatio,
    double CandidateToAnchorAmplitudeRatio);

public sealed record BasicPitchHarmonicSuppressionDiagnostics(
    int InputNotes,
    int RetainedNotes,
    ReadOnlyCollection<BasicPitchSuppressedHarmonic> Suppressed)
{
    public int SuppressedNotes => Suppressed.Count;
    public bool Changed => SuppressedNotes != 0;

    public static BasicPitchHarmonicSuppressionDiagnostics None(int count) =>
        new(count, count, Array.AsReadOnly(Array.Empty<BasicPitchSuppressedHarmonic>()));
}

public sealed record BasicPitchHarmonicSuppressionResult(
    ReadOnlyCollection<BasicPitchTranscribedNote> Notes,
    BasicPitchHarmonicSuppressionDiagnostics Diagnostics);

/// <summary>
/// Conservative deterministic post-processing for Basic Pitch output.
/// It removes only weak, simultaneous, strongly-overlapping non-octave harmonic duplicates of an already retained
/// lower note. Power-of-two harmonics are protected by default because octave doubling is common musical intent.
/// This layer never creates notes and exposes every suppression decision in diagnostics.
/// </summary>
public sealed class BasicPitchHarmonicSuppressor
{
    public BasicPitchHarmonicSuppressionResult Suppress(
        IReadOnlyList<BasicPitchTranscribedNote> notes,
        BasicPitchHarmonicSuppressionOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(notes);
        options ??= new BasicPitchHarmonicSuppressionOptions();
        options.Validate();
        cancellationToken.ThrowIfCancellationRequested();

        if (notes.Count == 0 || !options.Enabled)
        {
            var unchanged = notes.ToArray();
            return new BasicPitchHarmonicSuppressionResult(
                Array.AsReadOnly(unchanged),
                BasicPitchHarmonicSuppressionDiagnostics.None(unchanged.Length));
        }

        var retained = new List<BasicPitchTranscribedNote>(notes.Count);
        var suppressed = new List<BasicPitchSuppressedHarmonic>();

        // Strongest candidates establish anchors first. A note that was itself classified as a weak harmonic
        // can therefore never become an anchor for another suppression decision.
        foreach (var candidate in notes
                     .OrderByDescending(note => note.Amplitude)
                     .ThenBy(note => note.Start)
                     .ThenBy(note => note.MidiNote))
        {
            cancellationToken.ThrowIfCancellationRequested();
            var match = FindSuppressingAnchor(candidate, retained, options);
            if (match is null)
            {
                retained.Add(candidate);
                continue;
            }

            suppressed.Add(match);
        }

        var ordered = retained
            .OrderBy(note => note.Start)
            .ThenBy(note => note.MidiNote)
            .ThenBy(note => note.End)
            .ToArray();
        var diagnostics = new BasicPitchHarmonicSuppressionDiagnostics(
            notes.Count,
            ordered.Length,
            Array.AsReadOnly(suppressed
                .OrderBy(item => item.Candidate.Start)
                .ThenBy(item => item.Candidate.MidiNote)
                .ToArray()));
        return new BasicPitchHarmonicSuppressionResult(Array.AsReadOnly(ordered), diagnostics);
    }

    private static BasicPitchSuppressedHarmonic? FindSuppressingAnchor(
        BasicPitchTranscribedNote candidate,
        IReadOnlyList<BasicPitchTranscribedNote> retained,
        BasicPitchHarmonicSuppressionOptions options)
    {
        BasicPitchSuppressedHarmonic? best = null;

        foreach (var anchor in retained)
        {
            if (anchor.MidiNote >= candidate.MidiNote || anchor.Amplitude <= 0f)
                continue;

            var onsetDelta = (candidate.Start - anchor.Start).Duration();
            if (onsetDelta > options.EffectiveOnsetTolerance)
                continue;

            var overlap = Overlap(candidate, anchor);
            if (overlap <= TimeSpan.Zero)
                continue;
            var overlapRatio = overlap.TotalSeconds / candidate.Duration.TotalSeconds;
            if (overlapRatio < options.MinimumCandidateOverlapRatio)
                continue;

            var amplitudeRatio = candidate.Amplitude / anchor.Amplitude;
            if (amplitudeRatio > options.MaximumCandidateToAnchorAmplitudeRatio)
                continue;

            var harmonic = FindHarmonic(candidate.MidiNote - anchor.MidiNote, options, out var pitchError);
            if (harmonic == 0)
                continue;

            var current = new BasicPitchSuppressedHarmonic(
                candidate,
                anchor,
                harmonic,
                pitchError,
                overlapRatio,
                amplitudeRatio);

            if (best is null
                || current.HarmonicPitchErrorSemitones < best.HarmonicPitchErrorSemitones
                || (Math.Abs(current.HarmonicPitchErrorSemitones - best.HarmonicPitchErrorSemitones) < 1e-9
                    && current.CandidateToAnchorAmplitudeRatio < best.CandidateToAnchorAmplitudeRatio))
            {
                best = current;
            }
        }

        return best;
    }

    private static int FindHarmonic(
        int semitoneInterval,
        BasicPitchHarmonicSuppressionOptions options,
        out double pitchError)
    {
        var bestHarmonic = 0;
        pitchError = double.PositiveInfinity;
        for (var harmonic = options.MinimumHarmonic; harmonic <= options.MaximumHarmonic; harmonic++)
        {
            if (options.ProtectPowerOfTwoHarmonics && IsPowerOfTwo(harmonic))
                continue;

            var expected = 12.0 * Math.Log2(harmonic);
            var error = Math.Abs(semitoneInterval - expected);
            if (error <= options.MaximumHarmonicPitchErrorSemitones && error < pitchError)
            {
                bestHarmonic = harmonic;
                pitchError = error;
            }
        }
        return bestHarmonic;
    }

    private static bool IsPowerOfTwo(int value) => value > 0 && (value & (value - 1)) == 0;

    private static TimeSpan Overlap(BasicPitchTranscribedNote first, BasicPitchTranscribedNote second)
    {
        var start = first.Start > second.Start ? first.Start : second.Start;
        var end = first.End < second.End ? first.End : second.End;
        return end <= start ? TimeSpan.Zero : end - start;
    }
}
