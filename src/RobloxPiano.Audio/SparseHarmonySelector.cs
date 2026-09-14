namespace RobloxPiano.Audio;

public sealed record SparseHarmonySelectionOptions(
    bool Enabled = true,
    int MaxHarmonyNotesPerLeadOnset = 2,
    TimeSpan? OnsetWindow = null,
    TimeSpan? MinimumDuration = null,
    int MinimumIntervalBelowLeadSemitones = 3,
    int MaximumIntervalBelowLeadSemitones = 24,
    float MinimumActivation = 0.24f,
    float RelativeActivationFloor = 0.58f,
    float OutputActivationScale = 0.55f,
    float MaximumLeadRelativeActivation = 0.72f)
{
    public TimeSpan EffectiveOnsetWindow => OnsetWindow ?? TimeSpan.FromMilliseconds(90);
    public TimeSpan EffectiveMinimumDuration => MinimumDuration ?? TimeSpan.FromMilliseconds(70);

    internal void Validate()
    {
        if (MaxHarmonyNotesPerLeadOnset is < 0 or > 4)
            throw new ArgumentOutOfRangeException(nameof(MaxHarmonyNotesPerLeadOnset));
        if (EffectiveOnsetWindow < TimeSpan.Zero || EffectiveOnsetWindow > TimeSpan.FromMilliseconds(250))
            throw new ArgumentOutOfRangeException(nameof(OnsetWindow));
        if (EffectiveMinimumDuration <= TimeSpan.Zero || EffectiveMinimumDuration > TimeSpan.FromSeconds(2))
            throw new ArgumentOutOfRangeException(nameof(MinimumDuration));
        if (MinimumIntervalBelowLeadSemitones is < 1 or > 24)
            throw new ArgumentOutOfRangeException(nameof(MinimumIntervalBelowLeadSemitones));
        if (MaximumIntervalBelowLeadSemitones < MinimumIntervalBelowLeadSemitones || MaximumIntervalBelowLeadSemitones > 48)
            throw new ArgumentOutOfRangeException(nameof(MaximumIntervalBelowLeadSemitones));
        if (!float.IsFinite(MinimumActivation) || MinimumActivation is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MinimumActivation));
        if (!float.IsFinite(RelativeActivationFloor) || RelativeActivationFloor is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(RelativeActivationFloor));
        if (!float.IsFinite(OutputActivationScale) || OutputActivationScale is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(OutputActivationScale));
        if (!float.IsFinite(MaximumLeadRelativeActivation) || MaximumLeadRelativeActivation is <= 0f or >= 1f)
            throw new ArgumentOutOfRangeException(nameof(MaximumLeadRelativeActivation));
    }
}

public sealed record SparseHarmonySelectionDiagnostics(
    int LeadNotes,
    int AccompanimentNotes,
    int CandidateNotes,
    int SelectedNotes,
    int RejectedAboveLead,
    int RejectedOutsideLeadWindow,
    int RejectedLowConfidence,
    int DuplicatePitchClassDrops,
    int LeadOnsetsWithHarmony);

public sealed record SparseHarmonySelectionResult(
    IReadOnlyList<BasicPitchTranscribedNote> Notes,
    SparseHarmonySelectionDiagnostics Diagnostics);

/// <summary>
/// Reduces separately transcribed accompaniment into a very small set of lead-protected piano support notes.
/// The lead transcription remains authoritative: harmony is admitted only around an existing lead onset, must
/// sit below that lead, is pitch-class deduplicated, and is amplitude-capped below the lead before arrangement.
/// This prevents accompaniment, bass and residual percussion from becoming melody truth while preserving useful
/// chord identity for recognizable full-song piano reductions.
/// </summary>
public sealed class SparseHarmonySelector
{
    public SparseHarmonySelectionResult Select(
        IReadOnlyList<BasicPitchTranscribedNote> leadNotes,
        IReadOnlyList<BasicPitchTranscribedNote> accompanimentNotes,
        SparseHarmonySelectionOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(leadNotes);
        ArgumentNullException.ThrowIfNull(accompanimentNotes);
        options ??= new SparseHarmonySelectionOptions();
        options.Validate();

        if (!options.Enabled || options.MaxHarmonyNotesPerLeadOnset == 0 || leadNotes.Count == 0 || accompanimentNotes.Count == 0)
        {
            return new SparseHarmonySelectionResult(
                Array.Empty<BasicPitchTranscribedNote>(),
                new SparseHarmonySelectionDiagnostics(
                    leadNotes.Count,
                    accompanimentNotes.Count,
                    0,
                    0,
                    0,
                    accompanimentNotes.Count,
                    0,
                    0,
                    0));
        }

        var onsetWindow = options.EffectiveOnsetWindow;
        var minimumDuration = options.EffectiveMinimumDuration;
        var selected = new List<BasicPitchTranscribedNote>();
        var emittedKeys = new HashSet<(long StartTicks, int MidiNote)>();
        var candidateNotes = 0;
        var rejectedAboveLead = 0;
        var rejectedOutsideLeadWindow = 0;
        var rejectedLowConfidence = 0;
        var duplicatePitchClassDrops = 0;
        var leadOnsetsWithHarmony = 0;

        foreach (var lead in leadNotes.OrderBy(note => note.Start).ThenByDescending(note => note.MidiNote))
        {
            cancellationToken.ThrowIfCancellationRequested();
            var windowStart = lead.Start - onsetWindow;
            if (windowStart < TimeSpan.Zero)
                windowStart = TimeSpan.Zero;
            var windowEnd = lead.Start + onsetWindow;

            var nearLead = new List<BasicPitchTranscribedNote>();
            foreach (var note in accompanimentNotes)
            {
                var reachesLead = note.Start <= lead.Start && note.End >= lead.Start + minimumDuration;
                var startsNearLead = note.Start >= windowStart && note.Start <= windowEnd;
                if (!reachesLead && !startsNearLead)
                {
                    rejectedOutsideLeadWindow++;
                    continue;
                }

                var interval = lead.MidiNote - note.MidiNote;
                if (interval < options.MinimumIntervalBelowLeadSemitones || interval > options.MaximumIntervalBelowLeadSemitones)
                {
                    rejectedAboveLead++;
                    continue;
                }
                if (note.Duration < minimumDuration || note.Amplitude < options.MinimumActivation)
                {
                    rejectedLowConfidence++;
                    continue;
                }

                nearLead.Add(note);
            }

            if (nearLead.Count == 0)
                continue;

            candidateNotes += nearLead.Count;
            var strongest = nearLead.Max(note => note.Amplitude);
            var activationFloor = Math.Max(options.MinimumActivation, strongest * options.RelativeActivationFloor);
            var credible = nearLead
                .Where(note => note.Amplitude >= activationFloor)
                .OrderByDescending(note => note.Amplitude)
                .ThenByDescending(note => note.Duration)
                .ThenBy(note => note.MidiNote)
                .ToList();
            rejectedLowConfidence += nearLead.Count - credible.Count;

            var distinctPitchClasses = new List<BasicPitchTranscribedNote>();
            var usedPitchClasses = new HashSet<int>();
            foreach (var note in credible)
            {
                var pitchClass = ((note.MidiNote % 12) + 12) % 12;
                if (!usedPitchClasses.Add(pitchClass))
                {
                    duplicatePitchClassDrops++;
                    continue;
                }
                distinctPitchClasses.Add(note);
            }

            var picked = distinctPitchClasses
                .Take(options.MaxHarmonyNotesPerLeadOnset)
                .ToArray();
            var emittedForLead = 0;
            foreach (var note in picked)
            {
                var start = lead.Start;
                var candidateEnd = note.End > start ? note.End : start + minimumDuration;
                var end = candidateEnd < lead.End ? candidateEnd : lead.End;
                if (end - start < minimumDuration)
                    end = start + minimumDuration;

                var key = (start.Ticks, note.MidiNote);
                if (!emittedKeys.Add(key))
                    continue;

                var amplitude = Math.Min(
                    note.Amplitude * options.OutputActivationScale,
                    lead.Amplitude * options.MaximumLeadRelativeActivation);
                if (amplitude <= 0f)
                    continue;

                selected.Add(new BasicPitchTranscribedNote(start, end, note.MidiNote, amplitude));
                emittedForLead++;
            }

            if (emittedForLead > 0)
                leadOnsetsWithHarmony++;
        }

        return new SparseHarmonySelectionResult(
            selected
                .OrderBy(note => note.Start)
                .ThenBy(note => note.MidiNote)
                .ThenBy(note => note.End)
                .ToArray(),
            new SparseHarmonySelectionDiagnostics(
                leadNotes.Count,
                accompanimentNotes.Count,
                candidateNotes,
                selected.Count,
                rejectedAboveLead,
                rejectedOutsideLeadWindow,
                rejectedLowConfidence,
                duplicatePitchClassDrops,
                leadOnsetsWithHarmony));
    }
}
