using RobloxPiano.Core;

namespace RobloxPiano.Audio;

public sealed record RobloxPianoArrangementOptions(
    MidiKeyboardProfile? KeyboardProfile = null,
    int TransposeSemitones = 0,
    int MaxSimultaneousNotes = 6,
    TimeSpan? OnsetClusterWindow = null,
    TimeSpan? MinimumDuration = null,
    float LowActivationThreshold = 0.45f,
    double MetadataBpm = 120d,
    bool FoldOctavesToRange = true,
    float MelodyActivationFloor = 0.25f,
    float MelodyRelativeActivationFloor = 0.55f,
    int MelodyContinuityMaxLeapSemitones = 12,
    TimeSpan? MelodyContinuityWindow = null,
    bool AdaptiveDensity = true,
    float AccompanimentActivationFloor = 0.18f,
    float AccompanimentRelativeActivationFloor = 0.35f,
    float MelodyContinuityRelativeActivationFloor = 0.80f,
    float HarmonyBassAnchorRelativeActivationFloor = 0.55f,
    float HarmonyOctaveRepresentativeRelativeActivationFloor = 0.85f,
    TimeSpan? HarmonyContinuityWindow = null,
    float HarmonyContinuityRelativeActivationFloor = 0.90f)
{
    public MidiKeyboardProfile EffectiveKeyboardProfile => KeyboardProfile ?? MidiKeyboardProfile.RobloxClassic61;

    internal void Validate()
    {
        if (TransposeSemitones is < -48 or > 48)
            throw new ArgumentOutOfRangeException(nameof(TransposeSemitones));
        if (MaxSimultaneousNotes is < 1 or > 16)
            throw new ArgumentOutOfRangeException(nameof(MaxSimultaneousNotes));
        if (OnsetClusterWindow is { } cluster && (cluster < TimeSpan.Zero || cluster > TimeSpan.FromMilliseconds(100)))
            throw new ArgumentOutOfRangeException(nameof(OnsetClusterWindow));
        if (MinimumDuration is { } minimum && (minimum <= TimeSpan.Zero || minimum > TimeSpan.FromSeconds(2)))
            throw new ArgumentOutOfRangeException(nameof(MinimumDuration));
        if (!float.IsFinite(LowActivationThreshold) || LowActivationThreshold is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(LowActivationThreshold));
        if (!double.IsFinite(MetadataBpm) || MetadataBpm is < 20d or > 400d)
            throw new ArgumentOutOfRangeException(nameof(MetadataBpm));
        if (!float.IsFinite(MelodyActivationFloor) || MelodyActivationFloor is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MelodyActivationFloor));
        if (!float.IsFinite(MelodyRelativeActivationFloor) || MelodyRelativeActivationFloor is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MelodyRelativeActivationFloor));
        if (MelodyContinuityMaxLeapSemitones is < 1 or > 36)
            throw new ArgumentOutOfRangeException(nameof(MelodyContinuityMaxLeapSemitones));
        if (MelodyContinuityWindow is { } continuity && (continuity <= TimeSpan.Zero || continuity > TimeSpan.FromSeconds(10)))
            throw new ArgumentOutOfRangeException(nameof(MelodyContinuityWindow));
        if (!float.IsFinite(AccompanimentActivationFloor) || AccompanimentActivationFloor is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(AccompanimentActivationFloor));
        if (!float.IsFinite(AccompanimentRelativeActivationFloor) || AccompanimentRelativeActivationFloor is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(AccompanimentRelativeActivationFloor));
        if (!float.IsFinite(MelodyContinuityRelativeActivationFloor) || MelodyContinuityRelativeActivationFloor is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(MelodyContinuityRelativeActivationFloor));
        if (!float.IsFinite(HarmonyBassAnchorRelativeActivationFloor) || HarmonyBassAnchorRelativeActivationFloor is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(HarmonyBassAnchorRelativeActivationFloor));
        if (!float.IsFinite(HarmonyOctaveRepresentativeRelativeActivationFloor) || HarmonyOctaveRepresentativeRelativeActivationFloor is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(HarmonyOctaveRepresentativeRelativeActivationFloor));
        if (HarmonyContinuityWindow is { } harmonyContinuity && (harmonyContinuity <= TimeSpan.Zero || harmonyContinuity > TimeSpan.FromSeconds(10)))
            throw new ArgumentOutOfRangeException(nameof(HarmonyContinuityWindow));
        if (!float.IsFinite(HarmonyContinuityRelativeActivationFloor) || HarmonyContinuityRelativeActivationFloor is <= 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(HarmonyContinuityRelativeActivationFloor));
        if (EffectiveKeyboardProfile.Keys.Length == 0)
            throw new ArgumentException("Roblox keyboard profile must contain at least one key.", nameof(KeyboardProfile));
    }
}

public sealed record RobloxPianoArrangementDiagnostics(
    int SourceNotes,
    int ArrangedEvents,
    int OctaveFoldedNotes,
    int DuplicatePitchMerges,
    int DensityDrops,
    int OutOfRangeDrops,
    int TooShortDrops,
    int SameKeyOverlapTrims,
    int SameKeyOverlapDrops,
    int LowActivationEvents,
    float MeanActivation,
    int WeakSkylineRejects = 0,
    int MelodyContinuitySelections = 0,
    int AdaptiveDensityDrops = 0,
    int MelodyContinuityConfidenceRejects = 0,
    int HarmonyVoicingSelections = 0,
    int HarmonyContinuitySelections = 0)
{
    public bool RequiresReview => DensityDrops > 0 || OutOfRangeDrops > 0 || LowActivationEvents > 0;
}

public sealed record RobloxPianoArrangementResult(
    PerformanceTrack Track,
    RobloxPianoArrangementDiagnostics Diagnostics);

/// <summary>
/// Deterministically adapts decoded Basic Pitch notes into the canonical Roblox playback model.
/// It owns arrangement policy only; it does not schedule or inject Windows input.
/// </summary>
public sealed class RobloxPianoArranger
{
    private static readonly TimeSpan DefaultClusterWindow = TimeSpan.FromMilliseconds(18);
    private static readonly TimeSpan DefaultMinimumDuration = TimeSpan.FromMilliseconds(35);
    private static readonly TimeSpan DefaultMelodyContinuityWindow = TimeSpan.FromMilliseconds(1500);
    private static readonly TimeSpan DefaultHarmonyContinuityWindow = TimeSpan.FromMilliseconds(1800);

    public RobloxPianoArrangementResult Arrange(
        string? title,
        IReadOnlyList<BasicPitchTranscribedNote> sourceNotes,
        RobloxPianoArrangementOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(sourceNotes);
        options ??= new RobloxPianoArrangementOptions();
        options.Validate();
        cancellationToken.ThrowIfCancellationRequested();

        if (sourceNotes.Count == 0)
            throw new InvalidDataException("Audio transcription contains no notes to arrange.");

        var profile = options.EffectiveKeyboardProfile;
        var clusterWindow = options.OnsetClusterWindow ?? DefaultClusterWindow;
        var minimumDuration = options.MinimumDuration ?? DefaultMinimumDuration;
        var normalized = new List<Candidate>(sourceNotes.Count);
        var octaveFolded = 0;
        var outOfRangeDrops = 0;
        var tooShortDrops = 0;

        foreach (var note in sourceNotes.OrderBy(note => note.Start).ThenBy(note => note.MidiNote))
        {
            cancellationToken.ThrowIfCancellationRequested();
            if (note.Duration < minimumDuration)
            {
                tooShortDrops++;
                continue;
            }

            var pitch = checked(note.MidiNote + options.TransposeSemitones);
            var folded = false;
            if (pitch < profile.LowestMidiNote || pitch > profile.HighestMidiNote)
            {
                if (!options.FoldOctavesToRange)
                {
                    outOfRangeDrops++;
                    continue;
                }

                var original = pitch;
                while (pitch < profile.LowestMidiNote)
                    pitch += 12;
                while (pitch > profile.HighestMidiNote)
                    pitch -= 12;

                if (pitch < profile.LowestMidiNote || pitch > profile.HighestMidiNote)
                {
                    outOfRangeDrops++;
                    continue;
                }

                folded = pitch != original;
                if (folded)
                    octaveFolded++;
            }

            normalized.Add(new Candidate(
                note.Start,
                note.End,
                pitch,
                profile.Map(pitch),
                note.Amplitude,
                note.MidiNote,
                folded));
        }

        if (normalized.Count == 0)
            throw new InvalidDataException("Audio transcription contains no playable notes after Roblox range/duration policy.");

        var selected = new List<Candidate>(normalized.Count);
        var duplicatePitchMerges = 0;
        var densityDrops = 0;
        var weakSkylineRejects = 0;
        var melodyContinuitySelections = 0;
        var adaptiveDensityDrops = 0;
        var melodyContinuityConfidenceRejects = 0;
        var harmonyVoicingSelections = 0;
        var harmonyContinuitySelections = 0;
        Candidate? previousMelody = null;
        IReadOnlyList<Candidate> previousHarmony = [];
        TimeSpan? previousHarmonyEnd = null;
        var harmonyContinuityWindow = options.HarmonyContinuityWindow ?? DefaultHarmonyContinuityWindow;
        var index = 0;
        while (index < normalized.Count)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var anchor = normalized[index].Start;
            var end = index + 1;
            while (end < normalized.Count && normalized[end].Start - anchor <= clusterWindow)
                end++;

            var cluster = normalized.GetRange(index, end - index);
            var unique = cluster
                .GroupBy(candidate => candidate.MappedPitch)
                .Select(group => group
                    .OrderByDescending(candidate => candidate.Amplitude)
                    .ThenByDescending(candidate => candidate.Duration)
                    .ThenBy(candidate => candidate.Start)
                    .First())
                .ToList();
            duplicatePitchMerges += cluster.Count - unique.Count;

            var melody = SelectMelodyCandidate(
                unique,
                previousMelody,
                anchor,
                options,
                out var weakSkylineRejected,
                out var continuitySelected,
                out var continuityConfidenceRejected);
            if (weakSkylineRejected)
                weakSkylineRejects++;
            if (continuitySelected)
                melodyContinuitySelections++;
            if (continuityConfidenceRejected)
                melodyContinuityConfidenceRejects++;
            previousMelody = melody;

            var harmonyContext = previousHarmonyEnd is { } priorEnd && anchor - priorEnd <= harmonyContinuityWindow
                ? previousHarmony
                : [];

            if (unique.Count > options.MaxSimultaneousNotes)
            {
                var accompaniment = unique
                    .Where(candidate => !ReferenceEquals(candidate, melody))
                    .OrderByDescending(candidate => candidate.Amplitude)
                    .ThenByDescending(candidate => candidate.Duration)
                    .ThenByDescending(candidate => candidate.MappedPitch)
                    .ToList();

                if (options.AdaptiveDensity)
                {
                    // Calibrate relative accompaniment confidence against accompaniment itself, not the protected
                    // melody. A dominant vocal/melody activation must not starve quieter but coherent harmony.
                    var strongestAccompanimentActivation = accompaniment.Max(candidate => candidate.Amplitude);
                    var accompanimentThreshold = Math.Max(
                        options.AccompanimentActivationFloor,
                        strongestAccompanimentActivation * options.AccompanimentRelativeActivationFloor);
                    accompaniment = accompaniment
                        .Where(candidate => candidate.Amplitude >= accompanimentThreshold)
                        .ToList();
                }

                var accompanimentSlots = options.MaxSimultaneousNotes - 1;
                var voicedAccompaniment = SelectAccompanimentVoicing(
                    accompaniment,
                    accompanimentSlots,
                    options,
                    harmonyContext,
                    out var harmonyVoicingSelected,
                    out var harmonyContinuitySelected);
                if (harmonyVoicingSelected)
                    harmonyVoicingSelections++;
                if (harmonyContinuitySelected)
                    harmonyContinuitySelections++;

                previousHarmony = voicedAccompaniment;
                previousHarmonyEnd = voicedAccompaniment.Count > 0
                    ? voicedAccompaniment.Max(candidate => candidate.End)
                    : null;

                var keep = voicedAccompaniment
                    .Append(melody)
                    .Distinct()
                    .OrderBy(candidate => candidate.Start)
                    .ThenBy(candidate => candidate.MappedPitch)
                    .ToList();
                var hardCapKeepCount = Math.Min(unique.Count, options.MaxSimultaneousNotes);
                densityDrops += unique.Count - keep.Count;
                adaptiveDensityDrops += Math.Max(0, hardCapKeepCount - keep.Count);
                unique = keep;
            }
            else
            {
                previousHarmony = unique
                    .Where(candidate => !ReferenceEquals(candidate, melody))
                    .ToArray();
                previousHarmonyEnd = previousHarmony.Count > 0
                    ? previousHarmony.Max(candidate => candidate.End)
                    : null;
            }

            selected.AddRange(unique);
            index = end;
        }

        selected = selected
            .OrderBy(candidate => candidate.Start)
            .ThenBy(candidate => candidate.MappedPitch)
            .ToList();

        var safe = new List<Candidate>(selected.Count);
        var lastByKey = new Dictionary<char, int>();
        var overlapTrims = 0;
        var overlapDrops = 0;
        foreach (var candidate in selected)
        {
            cancellationToken.ThrowIfCancellationRequested();
            if (lastByKey.TryGetValue(candidate.Key, out var previousIndex))
            {
                var previous = safe[previousIndex];
                if (previous.End > candidate.Start)
                {
                    var trimmedDuration = candidate.Start - previous.Start;
                    if (trimmedDuration >= minimumDuration)
                    {
                        safe[previousIndex] = previous with { End = candidate.Start };
                        overlapTrims++;
                    }
                    else
                    {
                        safe[previousIndex] = previous with { Suppressed = true };
                        overlapDrops++;
                    }
                }
            }

            lastByKey[candidate.Key] = safe.Count;
            safe.Add(candidate);
        }

        safe.RemoveAll(candidate => candidate.Suppressed);
        if (safe.Count == 0)
            throw new InvalidDataException("Arrangement policy removed every playable event.");

        var events = safe
            .Select(candidate => new PerformanceEvent(
                candidate.Start,
                candidate.Duration,
                new[] { candidate.Key }))
            .ToArray();
        var timeline = safe.Max(candidate => candidate.End);
        var meanActivation = safe.Average(candidate => candidate.Amplitude);
        var lowActivation = safe.Count(candidate => candidate.Amplitude < options.LowActivationThreshold);
        var track = new PerformanceTrack(
            string.IsNullOrWhiteSpace(title) ? "Audio transcription" : title.Trim(),
            options.MetadataBpm,
            480,
            TimeSpan.Zero,
            events,
            timeline);

        return new RobloxPianoArrangementResult(
            track,
            new RobloxPianoArrangementDiagnostics(
                sourceNotes.Count,
                events.Length,
                octaveFolded,
                duplicatePitchMerges,
                densityDrops,
                outOfRangeDrops,
                tooShortDrops,
                overlapTrims,
                overlapDrops,
                lowActivation,
                (float)meanActivation,
                weakSkylineRejects,
                melodyContinuitySelections,
                adaptiveDensityDrops,
                melodyContinuityConfidenceRejects,
                harmonyVoicingSelections,
                harmonyContinuitySelections));
    }

    private static IReadOnlyList<Candidate> SelectAccompanimentVoicing(
        IReadOnlyList<Candidate> accompaniment,
        int slots,
        RobloxPianoArrangementOptions options,
        IReadOnlyList<Candidate> previousHarmony,
        out bool harmonyVoicingSelected,
        out bool harmonyContinuitySelected)
    {
        if (slots <= 0 || accompaniment.Count == 0)
        {
            harmonyVoicingSelected = false;
            harmonyContinuitySelected = false;
            return [];
        }

        var confidenceOrder = accompaniment
            .OrderByDescending(candidate => candidate.Amplitude)
            .ThenByDescending(candidate => candidate.Duration)
            .ThenByDescending(candidate => candidate.MappedPitch)
            .ToArray();
        var baseline = confidenceOrder.Take(slots).ToArray();
        if (!options.AdaptiveDensity || accompaniment.Count <= slots)
        {
            harmonyVoicingSelected = false;
            harmonyContinuitySelected = false;
            return baseline;
        }

        var selected = new List<Candidate>(slots);
        var usedPitchClasses = new HashSet<int>();
        var strongestActivation = confidenceOrder[0].Amplitude;
        var bassAnchor = accompaniment
            .OrderBy(candidate => candidate.MappedPitch)
            .ThenByDescending(candidate => candidate.Amplitude)
            .First();
        if (bassAnchor.Amplitude >= strongestActivation * options.HarmonyBassAnchorRelativeActivationFloor)
        {
            selected.Add(bassAnchor);
            usedPitchClasses.Add(PitchClass(bassAnchor.MappedPitch));
        }

        // Diversity may replace a pure-confidence slot only when it remains close to the weakest confidence-ranked
        // baseline survivor. This prevents a weak transition voice from returning merely because it has a new pitch class.
        var coverageActivationFloor = baseline[^1].Amplitude * options.HarmonyOctaveRepresentativeRelativeActivationFloor;

        // When Basic Pitch sees a dense full-song mixture, octave/harmonic duplicates can outrank a useful chord tone
        // by a tiny confidence margin. For each pitch class prefer the lower representative whenever its activation is
        // still close to the strongest octave representative, then fill distinct pitch classes before redundant octaves.
        var representatives = accompaniment
            .GroupBy(candidate => PitchClass(candidate.MappedPitch))
            .Select(group =>
            {
                var strongest = group.Max(candidate => candidate.Amplitude);
                return group
                    .Where(candidate => candidate.Amplitude >= strongest * options.HarmonyOctaveRepresentativeRelativeActivationFloor)
                    .OrderBy(candidate => candidate.MappedPitch)
                    .ThenByDescending(candidate => candidate.Amplitude)
                    .ThenByDescending(candidate => candidate.Duration)
                    .First();
            })
            .Where(candidate => candidate.Amplitude >= coverageActivationFloor)
            .ToArray();

        var previousPitchClasses = previousHarmony
            .Select(candidate => PitchClass(candidate.MappedPitch))
            .ToHashSet();
        var strongestRepresentativeActivation = representatives.Length == 0
            ? 0f
            : representatives.Max(candidate => candidate.Amplitude);
        var continuityActivationFloor = strongestRepresentativeActivation * options.HarmonyContinuityRelativeActivationFloor;
        representatives = representatives
            .OrderByDescending(candidate =>
                previousPitchClasses.Contains(PitchClass(candidate.MappedPitch)) &&
                candidate.Amplitude >= continuityActivationFloor)
            .ThenByDescending(candidate => candidate.Amplitude)
            .ThenByDescending(candidate => candidate.Duration)
            .ThenBy(candidate => candidate.MappedPitch)
            .ToArray();

        foreach (var candidate in representatives)
        {
            if (selected.Count >= slots)
                break;
            var pitchClass = PitchClass(candidate.MappedPitch);
            if (!usedPitchClasses.Add(pitchClass) || selected.Contains(candidate))
                continue;
            selected.Add(candidate);
        }

        foreach (var candidate in confidenceOrder)
        {
            if (selected.Count >= slots)
                break;
            if (!selected.Contains(candidate))
                selected.Add(candidate);
        }

        var selectedSet = selected.ToHashSet();
        var baselineSet = baseline.ToHashSet();
        harmonyVoicingSelected = !selectedSet.SetEquals(baselineSet);
        harmonyContinuitySelected = previousPitchClasses.Count > 0 && selected.Any(candidate =>
            previousPitchClasses.Contains(PitchClass(candidate.MappedPitch)) &&
            !baselineSet.Contains(candidate));
        return selected;
    }

    private static int PitchClass(int midiNote) => ((midiNote % 12) + 12) % 12;

    private static Candidate SelectMelodyCandidate(
        IReadOnlyList<Candidate> candidates,
        Candidate? previousMelody,
        TimeSpan anchor,
        RobloxPianoArrangementOptions options,
        out bool weakSkylineRejected,
        out bool continuitySelected,
        out bool continuityConfidenceRejected)
    {
        var highest = candidates
            .OrderByDescending(candidate => candidate.MappedPitch)
            .ThenByDescending(candidate => candidate.Amplitude)
            .First();
        var maximumActivation = candidates.Max(candidate => candidate.Amplitude);
        var activationThreshold = Math.Max(
            options.MelodyActivationFloor,
            maximumActivation * options.MelodyRelativeActivationFloor);
        var credible = candidates
            .Where(candidate => candidate.Amplitude >= activationThreshold)
            .ToArray();

        if (credible.Length == 0)
        {
            credible =
            [
                candidates
                    .OrderByDescending(candidate => candidate.Amplitude)
                    .ThenByDescending(candidate => candidate.Duration)
                    .ThenByDescending(candidate => candidate.MappedPitch)
                    .First()
            ];
        }

        weakSkylineRejected = !credible.Contains(highest);
        var credibleSkyline = credible
            .OrderByDescending(candidate => candidate.MappedPitch)
            .ThenByDescending(candidate => candidate.Amplitude)
            .First();
        var continuityWindow = options.MelodyContinuityWindow ?? DefaultMelodyContinuityWindow;
        var canUseContinuity = previousMelody is not null &&
            anchor - previousMelody.End <= continuityWindow;

        if (!canUseContinuity)
        {
            continuitySelected = false;
            continuityConfidenceRejected = false;
            return credibleSkyline;
        }

        var previousPitch = previousMelody!.MappedPitch;
        static IOrderedEnumerable<Candidate> OrderForContinuity(IEnumerable<Candidate> source, int previousPitch, int maxLeap)
            => source
                .OrderBy(candidate => Math.Abs(candidate.MappedPitch - previousPitch) > maxLeap)
                .ThenBy(candidate => Math.Abs(candidate.MappedPitch - previousPitch))
                .ThenByDescending(candidate => candidate.Amplitude)
                .ThenByDescending(candidate => candidate.Duration)
                .ThenByDescending(candidate => candidate.MappedPitch);

        var continuityActivationThreshold = credibleSkyline.Amplitude * options.MelodyContinuityRelativeActivationFloor;
        var continuityCandidates = credible
            .Where(candidate => candidate.Amplitude >= continuityActivationThreshold)
            .ToArray();
        var selected = OrderForContinuity(continuityCandidates, previousPitch, options.MelodyContinuityMaxLeapSemitones).First();

        continuityConfidenceRejected = credible.Any(candidate =>
            !ReferenceEquals(candidate, selected) &&
            candidate.Amplitude < continuityActivationThreshold &&
            Math.Abs(candidate.MappedPitch - previousPitch) <= options.MelodyContinuityMaxLeapSemitones);
        continuitySelected = !ReferenceEquals(selected, credibleSkyline);
        return selected;
    }

    private sealed record Candidate(
        TimeSpan Start,
        TimeSpan End,
        int MappedPitch,
        char Key,
        float Amplitude,
        int SourcePitch,
        bool Folded,
        bool Suppressed = false)
    {
        public TimeSpan Duration => End - Start;
    }
}
