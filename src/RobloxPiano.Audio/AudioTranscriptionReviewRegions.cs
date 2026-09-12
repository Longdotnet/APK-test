using RobloxPiano.Core;

namespace RobloxPiano.Audio;

public sealed record AudioTranscriptionReviewRegionOptions(
    TimeSpan? WindowDuration = null,
    float LowActivationThreshold = 0.40f,
    double LowRetentionRatio = 0.45,
    double HighEventsPerSecond = 12.0,
    int HighSimultaneousNotes = 6)
{
    public TimeSpan EffectiveWindowDuration => WindowDuration ?? TimeSpan.FromSeconds(5);

    internal void Validate()
    {
        if (EffectiveWindowDuration < TimeSpan.FromSeconds(1) || EffectiveWindowDuration > TimeSpan.FromSeconds(30))
            throw new ArgumentOutOfRangeException(nameof(WindowDuration));
        if (!float.IsFinite(LowActivationThreshold) || LowActivationThreshold is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(LowActivationThreshold));
        if (!double.IsFinite(LowRetentionRatio) || LowRetentionRatio is < 0d or > 1d)
            throw new ArgumentOutOfRangeException(nameof(LowRetentionRatio));
        if (!double.IsFinite(HighEventsPerSecond) || HighEventsPerSecond <= 0d)
            throw new ArgumentOutOfRangeException(nameof(HighEventsPerSecond));
        if (HighSimultaneousNotes is < 1 or > 16)
            throw new ArgumentOutOfRangeException(nameof(HighSimultaneousNotes));
    }
}

public sealed record AudioTranscriptionReviewRegion(
    TimeSpan Start,
    TimeSpan End,
    int SourceNotes,
    int ArrangedEvents,
    float MeanActivation,
    double RetentionRatio,
    double EventsPerSecond,
    int PeakSimultaneousNotes,
    IReadOnlyList<string> Reasons)
{
    public TimeSpan Duration => End - Start;
}

/// <summary>
/// Deterministically surfaces local regions that deserve human review after transcription/arrangement.
/// This analyzer never mutates notes, canonical PerformanceTrack state, or playback truth. It compares
/// decoded/suppressed Basic Pitch note evidence with the already-produced canonical track in fixed windows.
/// </summary>
public sealed class AudioTranscriptionReviewRegionAnalyzer
{
    public IReadOnlyList<AudioTranscriptionReviewRegion> Analyze(
        TimeSpan sourceDuration,
        IReadOnlyList<BasicPitchTranscribedNote> sourceNotes,
        PerformanceTrack track,
        AudioTranscriptionReviewRegionOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        if (sourceDuration <= TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(sourceDuration));
        ArgumentNullException.ThrowIfNull(sourceNotes);
        ArgumentNullException.ThrowIfNull(track);
        if (sourceNotes.Count == 0)
            throw new ArgumentException("Review-region analysis requires at least one decoded note.", nameof(sourceNotes));

        options ??= new AudioTranscriptionReviewRegionOptions();
        options.Validate();
        cancellationToken.ThrowIfCancellationRequested();

        var window = options.EffectiveWindowDuration;
        var regions = new List<AudioTranscriptionReviewRegion>();
        for (var start = TimeSpan.Zero; start < sourceDuration; start += window)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var end = start + window;
            if (end > sourceDuration)
                end = sourceDuration;
            var seconds = Math.Max((end - start).TotalSeconds, 0.001d);

            var localSource = sourceNotes
                .Where(note => note.Start < end && note.End > start)
                .ToArray();
            if (localSource.Length == 0)
                continue;

            var localEvents = track.Events
                .Where(evt => evt.Start < end && evt.Start + evt.Duration > start)
                .ToArray();
            var meanActivation = (float)localSource.Average(note => note.Amplitude);
            var retention = Math.Clamp(localEvents.Length / (double)localSource.Length, 0d, 1d);
            var eventsPerSecond = localEvents.Length / seconds;
            var peakSimultaneous = ComputePeakSimultaneousNotes(localEvents, start, end);

            var reasons = new List<string>();
            if (meanActivation < options.LowActivationThreshold)
                reasons.Add("LOW_ACTIVATION_REGION");
            if (retention < options.LowRetentionRatio)
                reasons.Add("LOCAL_RETENTION_LOW");
            if (eventsPerSecond > options.HighEventsPerSecond)
                reasons.Add("LOCAL_EVENT_DENSITY_HIGH");
            if (peakSimultaneous > options.HighSimultaneousNotes)
                reasons.Add("LOCAL_POLYPHONY_HIGH");

            if (reasons.Count == 0)
                continue;

            regions.Add(new AudioTranscriptionReviewRegion(
                start,
                end,
                localSource.Length,
                localEvents.Length,
                meanActivation,
                retention,
                eventsPerSecond,
                peakSimultaneous,
                reasons.AsReadOnly()));
        }

        return regions.AsReadOnly();
    }

    private static int ComputePeakSimultaneousNotes(
        IReadOnlyList<PerformanceEvent> events,
        TimeSpan start,
        TimeSpan end)
    {
        if (events.Count == 0)
            return 0;

        var edges = new List<(TimeSpan Time, int Delta)>(events.Count * 2);
        foreach (var evt in events)
        {
            var eventStart = evt.Start < start ? start : evt.Start;
            var rawEnd = evt.Start + evt.Duration;
            var eventEnd = rawEnd > end ? end : rawEnd;
            if (eventEnd <= eventStart)
                continue;
            var voices = evt.Keys.Distinct().Count();
            if (voices <= 0)
                continue;
            edges.Add((eventStart, voices));
            edges.Add((eventEnd, -voices));
        }

        var active = 0;
        var peak = 0;
        foreach (var edge in edges
                     .OrderBy(edge => edge.Time)
                     .ThenBy(edge => edge.Delta))
        {
            active += edge.Delta;
            if (active > peak)
                peak = active;
        }
        return peak;
    }
}
