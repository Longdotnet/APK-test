using RobloxPiano.Core;

namespace RobloxPiano.Audio;

public enum AudioTranscriptionReviewRepairKind
{
    MelodyPriority = 0,
    SimplifiedHarmony = 1
}

public sealed record AudioTranscriptionReviewRepairOptions(
    int SimplifiedHarmonyMaxSimultaneousNotes = 3,
    RobloxPianoArrangementOptions? ArrangementOptions = null)
{
    internal void Validate()
    {
        if (SimplifiedHarmonyMaxSimultaneousNotes is < 2 or > 6)
            throw new ArgumentOutOfRangeException(nameof(SimplifiedHarmonyMaxSimultaneousNotes));
        ArrangementOptions?.Validate();
    }
}

public sealed record AudioTranscriptionReviewRepairCandidate(
    AudioTranscriptionReviewRepairKind Kind,
    PerformanceTrack Track,
    int SourceNotes,
    int OriginalRegionEvents,
    int CandidateRegionEvents,
    int PeakSimultaneousNotes,
    IReadOnlyList<string> TargetReasons);

/// <summary>
/// Builds deterministic alternative PerformanceTrack candidates for one flagged review region.
/// Candidates are derived artifacts only: this service never mutates the supplied canonical track and
/// never authorizes playback/library persistence. A caller must explicitly select a candidate before it
/// can replace canonical state.
/// </summary>
public sealed class AudioTranscriptionReviewRepairGenerator
{
    private readonly RobloxPianoArranger _arranger;

    public AudioTranscriptionReviewRepairGenerator(RobloxPianoArranger? arranger = null)
    {
        _arranger = arranger ?? new RobloxPianoArranger();
    }

    public IReadOnlyList<AudioTranscriptionReviewRepairCandidate> Generate(
        PerformanceTrack canonicalTrack,
        IReadOnlyList<BasicPitchTranscribedNote> sourceNotes,
        AudioTranscriptionReviewRegion region,
        AudioTranscriptionReviewRepairOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(canonicalTrack);
        ArgumentNullException.ThrowIfNull(sourceNotes);
        ArgumentNullException.ThrowIfNull(region);
        options ??= new AudioTranscriptionReviewRepairOptions();
        options.Validate();
        cancellationToken.ThrowIfCancellationRequested();

        if (region.Start < TimeSpan.Zero || region.End <= region.Start)
            throw new ArgumentOutOfRangeException(nameof(region), "Review region must have a positive non-negative interval.");
        if (sourceNotes.Count == 0)
            throw new ArgumentException("Repair generation requires decoded note evidence.", nameof(sourceNotes));

        var localNotes = sourceNotes
            .Where(note => note.Start < region.End && note.End > region.Start)
            .Select(note => Clip(note, region.Start, region.End))
            .Where(note => note is not null)
            .Select(note => note!)
            .OrderBy(note => note.Start)
            .ThenBy(note => note.MidiNote)
            .ThenByDescending(note => note.Amplitude)
            .ToArray();
        if (localNotes.Length == 0)
            return Array.Empty<AudioTranscriptionReviewRepairCandidate>();

        var originalRegionEvents = canonicalTrack.Events.Count(evt => Overlaps(evt, region.Start, region.End));
        var candidates = new List<AudioTranscriptionReviewRepairCandidate>(2);
        TryAddCandidate(
            candidates,
            AudioTranscriptionReviewRepairKind.MelodyPriority,
            canonicalTrack,
            localNotes,
            region,
            options,
            1,
            originalRegionEvents,
            cancellationToken);
        TryAddCandidate(
            candidates,
            AudioTranscriptionReviewRepairKind.SimplifiedHarmony,
            canonicalTrack,
            localNotes,
            region,
            options,
            options.SimplifiedHarmonyMaxSimultaneousNotes,
            originalRegionEvents,
            cancellationToken);

        return candidates.AsReadOnly();
    }

    private void TryAddCandidate(
        List<AudioTranscriptionReviewRepairCandidate> candidates,
        AudioTranscriptionReviewRepairKind kind,
        PerformanceTrack canonicalTrack,
        IReadOnlyList<BasicPitchTranscribedNote> localNotes,
        AudioTranscriptionReviewRegion region,
        AudioTranscriptionReviewRepairOptions options,
        int maxSimultaneousNotes,
        int originalRegionEvents,
        CancellationToken cancellationToken)
    {
        cancellationToken.ThrowIfCancellationRequested();
        var arrangementOptions = (options.ArrangementOptions ?? new RobloxPianoArrangementOptions()) with
        {
            MaxSimultaneousNotes = maxSimultaneousNotes,
            MetadataBpm = canonicalTrack.Bpm
        };

        RobloxPianoArrangementResult arranged;
        try
        {
            arranged = _arranger.Arrange(canonicalTrack.Title, localNotes, arrangementOptions, cancellationToken);
        }
        catch (InvalidDataException)
        {
            return;
        }

        var replacement = arranged.Track.Events
            .Where(evt => Overlaps(evt, region.Start, region.End))
            .Select(evt => Clip(evt, region.Start, region.End))
            .Where(evt => evt is not null)
            .Select(evt => evt!)
            .ToArray();
        var candidateTrack = ReplaceRegion(canonicalTrack, region.Start, region.End, replacement);
        if (TracksEquivalent(canonicalTrack, candidateTrack)
            || candidates.Any(existing => TracksEquivalent(existing.Track, candidateTrack)))
        {
            return;
        }

        var candidateRegionEvents = candidateTrack.Events.Count(evt => Overlaps(evt, region.Start, region.End));
        candidates.Add(new AudioTranscriptionReviewRepairCandidate(
            kind,
            candidateTrack,
            localNotes.Count,
            originalRegionEvents,
            candidateRegionEvents,
            ComputePeakSimultaneousNotes(candidateTrack.Events, region.Start, region.End),
            TargetReasons(kind, region.Reasons)));
    }

    private static BasicPitchTranscribedNote? Clip(BasicPitchTranscribedNote note, TimeSpan start, TimeSpan end)
    {
        var clippedStart = note.Start < start ? start : note.Start;
        var clippedEnd = note.End > end ? end : note.End;
        if (clippedEnd <= clippedStart)
            return null;
        return new BasicPitchTranscribedNote(
            clippedStart,
            clippedEnd,
            note.MidiNote,
            note.Amplitude,
            note.PitchBendsThirdSemitones);
    }

    private static PerformanceEvent? Clip(PerformanceEvent evt, TimeSpan start, TimeSpan end)
    {
        var clippedStart = evt.Start < start ? start : evt.Start;
        var rawEnd = evt.Start + evt.Duration;
        var clippedEnd = rawEnd > end ? end : rawEnd;
        if (clippedEnd <= clippedStart)
            return null;
        return new PerformanceEvent(clippedStart, clippedEnd - clippedStart, evt.Keys.ToArray());
    }

    private static PerformanceTrack ReplaceRegion(
        PerformanceTrack canonicalTrack,
        TimeSpan start,
        TimeSpan end,
        IReadOnlyList<PerformanceEvent> replacement)
    {
        var events = new List<PerformanceEvent>(canonicalTrack.Events.Count + replacement.Count + 2);
        foreach (var evt in canonicalTrack.Events)
        {
            var eventEnd = evt.Start + evt.Duration;
            if (eventEnd <= start || evt.Start >= end)
            {
                events.Add(evt);
                continue;
            }

            if (evt.Start < start)
                events.Add(new PerformanceEvent(evt.Start, start - evt.Start, evt.Keys.ToArray()));
            if (eventEnd > end)
                events.Add(new PerformanceEvent(end, eventEnd - end, evt.Keys.ToArray()));
        }
        events.AddRange(replacement);

        var ordered = events
            .Where(evt => evt.Duration > TimeSpan.Zero && evt.Keys.Count > 0)
            .OrderBy(evt => evt.Start)
            .ThenBy(evt => string.Concat(evt.Keys))
            .ThenBy(evt => evt.Duration)
            .ToArray();
        var timeline = ordered.Length == 0
            ? canonicalTrack.TimelineDuration
            : Max(canonicalTrack.TimelineDuration, ordered.Max(evt => evt.Start + evt.Duration));
        return canonicalTrack with { Events = ordered, TimelineDuration = timeline };
    }

    private static IReadOnlyList<string> TargetReasons(
        AudioTranscriptionReviewRepairKind kind,
        IReadOnlyList<string> regionReasons)
    {
        var supported = kind switch
        {
            AudioTranscriptionReviewRepairKind.MelodyPriority => new[]
            {
                "LOCAL_EVENT_DENSITY_HIGH",
                "LOCAL_POLYPHONY_HIGH",
                "LOCAL_RETENTION_LOW"
            },
            AudioTranscriptionReviewRepairKind.SimplifiedHarmony => new[]
            {
                "LOCAL_EVENT_DENSITY_HIGH",
                "LOCAL_POLYPHONY_HIGH",
                "LOCAL_RETENTION_LOW"
            },
            _ => Array.Empty<string>()
        };
        return regionReasons.Where(supported.Contains).Distinct(StringComparer.Ordinal).ToArray();
    }

    private static bool TracksEquivalent(PerformanceTrack left, PerformanceTrack right)
    {
        if (left.Events.Count != right.Events.Count)
            return false;
        for (var index = 0; index < left.Events.Count; index++)
        {
            var a = left.Events[index];
            var b = right.Events[index];
            if (a.Start != b.Start || a.Duration != b.Duration || !a.Keys.SequenceEqual(b.Keys))
                return false;
        }
        return true;
    }

    private static int ComputePeakSimultaneousNotes(
        IReadOnlyList<PerformanceEvent> events,
        TimeSpan start,
        TimeSpan end)
    {
        var edges = new List<(TimeSpan At, int Delta)>();
        foreach (var evt in events.Where(evt => Overlaps(evt, start, end)))
        {
            var eventStart = evt.Start < start ? start : evt.Start;
            var eventEnd = evt.Start + evt.Duration;
            if (eventEnd > end)
                eventEnd = end;
            if (eventEnd <= eventStart)
                continue;
            var voices = evt.Keys.Distinct().Count();
            edges.Add((eventStart, voices));
            edges.Add((eventEnd, -voices));
        }

        var active = 0;
        var peak = 0;
        foreach (var edge in edges.OrderBy(edge => edge.At).ThenBy(edge => edge.Delta))
        {
            active += edge.Delta;
            peak = Math.Max(peak, active);
        }
        return peak;
    }

    private static bool Overlaps(PerformanceEvent evt, TimeSpan start, TimeSpan end) =>
        evt.Start < end && evt.Start + evt.Duration > start;

    private static TimeSpan Max(TimeSpan left, TimeSpan right) => left >= right ? left : right;
}
