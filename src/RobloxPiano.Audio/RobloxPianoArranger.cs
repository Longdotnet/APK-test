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
    float AccompanimentRelativeActivationFloor = 0.35f)
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
    int AdaptiveDensityDrops = 0)
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
        Candidate? previousMelody = null;
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
                out var continuitySelected);
            if (weakSkylineRejected)
                weakSkylineRejects++;
            if (continuitySelected)
                melodyContinuitySelections++;
            previousMelody = melody;

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
                    var strongestActivation = unique.Max(candidate => candidate.Amplitude);
                    var accompanimentThreshold = Math.Max(
                        options.AccompanimentActivationFloor,
                        strongestActivation * options.AccompanimentRelativeActivationFloor);
                    accompaniment = accompaniment
                        .Where(candidate => candidate.Amplitude >= accompanimentThreshold)
                        .ToList();
                }

                var keep = accompaniment
                    .Take(options.MaxSimultaneousNotes - 1)
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
                adaptiveDensityDrops));
    }

    private static Candidate SelectMelodyCandidate(
        IReadOnlyList<Candidate> candidates,
        Candidate? previousMelody,
        TimeSpan anchor,
        RobloxPianoArrangementOptions options,
        out bool weakSkylineRejected,
        out bool continuitySelected)
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
            return credibleSkyline;
        }

        var previousPitch = previousMelody!.MappedPitch;
        var selected = credible
            .OrderBy(candidate => Math.Abs(candidate.MappedPitch - previousPitch) > options.MelodyContinuityMaxLeapSemitones)
            .ThenBy(candidate => Math.Abs(candidate.MappedPitch - previousPitch))
            .ThenByDescending(candidate => candidate.Amplitude)
            .ThenByDescending(candidate => candidate.Duration)
            .ThenByDescending(candidate => candidate.MappedPitch)
            .First();
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
