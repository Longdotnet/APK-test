namespace RobloxPiano.Core;

public enum PerformanceControlKind
{
    SustainDown = 0,
    SustainUp = 1
}

public sealed record PerformanceControlEvent(
    TimeSpan At,
    PerformanceControlKind Kind);

/// <summary>
/// Canonical expressive score state before platform-specific playback. Importers such as
/// MIDI may populate control events here without teaching the playback kernel where they
/// came from. The compiler deterministically lowers sustain semantics into ordinary
/// duration-aware PerformanceEvents so the existing kernel, transport, quality tooling,
/// and Windows input backend remain source-agnostic.
/// </summary>
public sealed record ExpressivePerformanceTrack(
    PerformanceTrack Notes,
    IReadOnlyList<PerformanceControlEvent> Controls);

public static class ExpressivePerformanceCompiler
{
    public static PerformanceTrack Compile(ExpressivePerformanceTrack expressive)
    {
        ArgumentNullException.ThrowIfNull(expressive);
        ArgumentNullException.ThrowIfNull(expressive.Notes);
        ArgumentNullException.ThrowIfNull(expressive.Controls);

        var track = expressive.Notes;
        if (expressive.Controls.Count == 0)
        {
            // Preserve exact Legacy representation and fingerprints when no expressive
            // controls exist. This is an important A/B baseline invariant.
            return track;
        }

        var controls = ValidateAndOrderControls(track, expressive.Controls);
        ValidateNoteEvents(track);

        var flattened = track.Events
            .SelectMany((performanceEvent, eventIndex) => performanceEvent.Keys.Select((key, keyIndex) => new NoteInstance(
                key,
                performanceEvent.Start,
                performanceEvent.Start + performanceEvent.Duration,
                eventIndex,
                keyIndex)))
            .OrderBy(note => note.Start)
            .ThenBy(note => note.EventIndex)
            .ThenBy(note => note.KeyIndex)
            .ToArray();

        var startsByKey = flattened
            .GroupBy(note => note.Key)
            .ToDictionary(
                group => group.Key,
                group => group.Select(note => note.Start).OrderBy(value => value).ToArray());

        var compiled = new List<PerformanceEvent>(flattened.Length);
        foreach (var note in flattened)
        {
            var effectiveEnd = note.End;
            if (IsSustainDownAt(controls, note.End))
            {
                effectiveEnd = FindNextSustainUp(controls, note.End) ?? track.TimelineDuration;
                if (effectiveEnd < note.End)
                {
                    effectiveEnd = note.End;
                }
            }

            // A repeated pitch must be physically re-triggerable even while sustain is
            // down. Clamp the prior logical hold to the next same-key NoteOn so the
            // existing KeyUp-before-KeyDown ordering can re-articulate that pitch.
            var nextSameKeyStart = FindNextStart(startsByKey[note.Key], note.Start);
            if (nextSameKeyStart.HasValue && nextSameKeyStart.Value < effectiveEnd)
            {
                effectiveEnd = nextSameKeyStart.Value;
            }

            if (effectiveEnd <= note.Start)
            {
                throw new InvalidOperationException(
                    $"Expressive compilation produced a non-positive duration for key '{note.Key}' at {note.Start}.");
            }

            compiled.Add(new PerformanceEvent(
                note.Start,
                effectiveEnd - note.Start,
                new[] { note.Key }));
        }

        return track with
        {
            Events = compiled
                .OrderBy(performanceEvent => performanceEvent.Start)
                .ThenBy(performanceEvent => performanceEvent.Keys[0])
                .ToArray()
        };
    }

    private static IReadOnlyList<PerformanceControlEvent> ValidateAndOrderControls(
        PerformanceTrack track,
        IReadOnlyList<PerformanceControlEvent> controls)
    {
        var ordered = controls
            .Select((control, index) => (Control: control, Index: index))
            .OrderBy(item => item.Control.At)
            .ThenBy(item => item.Index)
            .ToArray();

        var sustainDown = false;
        TimeSpan? previousAt = null;
        foreach (var item in ordered)
        {
            var control = item.Control;
            if (control.At < TimeSpan.Zero || control.At > track.TimelineDuration)
            {
                throw new FormatException(
                    $"Control event at {control.At} is outside the track timeline 0..{track.TimelineDuration}.");
            }

            if (previousAt == control.At)
            {
                throw new FormatException(
                    $"Multiple sustain control transitions at {control.At} are ambiguous without source event ordering.");
            }

            previousAt = control.At;
            switch (control.Kind)
            {
                case PerformanceControlKind.SustainDown when sustainDown:
                    throw new FormatException($"Duplicate SustainDown at {control.At}.");
                case PerformanceControlKind.SustainDown:
                    sustainDown = true;
                    break;
                case PerformanceControlKind.SustainUp when !sustainDown:
                    throw new FormatException($"SustainUp at {control.At} has no matching SustainDown.");
                case PerformanceControlKind.SustainUp:
                    sustainDown = false;
                    break;
                default:
                    throw new FormatException($"Unsupported performance control kind: {control.Kind}.");
            }
        }

        // A score that ends with sustain down is repaired deterministically by treating
        // the timeline end as the safety release point. PlaybackKernel.ReleaseAll remains
        // the final platform-level safety net.
        if (sustainDown && (ordered.Length == 0 || ordered[^1].Control.At < track.TimelineDuration))
        {
            return ordered
                .Select(item => item.Control)
                .Append(new PerformanceControlEvent(track.TimelineDuration, PerformanceControlKind.SustainUp))
                .ToArray();
        }

        return ordered.Select(item => item.Control).ToArray();
    }

    private static void ValidateNoteEvents(PerformanceTrack track)
    {
        foreach (var performanceEvent in track.Events)
        {
            if (performanceEvent.Start < TimeSpan.Zero)
            {
                throw new FormatException("Performance event start cannot be negative.");
            }

            if (performanceEvent.Duration <= TimeSpan.Zero)
            {
                throw new FormatException("Performance event duration must be positive.");
            }

            if (performanceEvent.Start + performanceEvent.Duration > track.TimelineDuration)
            {
                throw new FormatException("Performance event extends beyond TimelineDuration.");
            }

            if (performanceEvent.Keys.Count == 0)
            {
                throw new FormatException("Performance event must contain at least one key.");
            }
        }
    }

    private static bool IsSustainDownAt(IReadOnlyList<PerformanceControlEvent> controls, TimeSpan at)
    {
        var down = false;
        foreach (var control in controls)
        {
            if (control.At > at)
            {
                break;
            }

            down = control.Kind == PerformanceControlKind.SustainDown;
        }

        return down;
    }

    private static TimeSpan? FindNextSustainUp(IReadOnlyList<PerformanceControlEvent> controls, TimeSpan after)
    {
        foreach (var control in controls)
        {
            if (control.At >= after && control.Kind == PerformanceControlKind.SustainUp)
            {
                return control.At;
            }
        }

        return null;
    }

    private static TimeSpan? FindNextStart(IReadOnlyList<TimeSpan> starts, TimeSpan current)
    {
        foreach (var start in starts)
        {
            if (start > current)
            {
                return start;
            }
        }

        return null;
    }

    private sealed record NoteInstance(
        char Key,
        TimeSpan Start,
        TimeSpan End,
        int EventIndex,
        int KeyIndex);
}
