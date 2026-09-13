using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class RobloxPianoArrangerRegression
{
    public static void OctaveFoldingKeepsPitchClassInsideClassic61()
    {
        var notes = new[]
        {
            Note(0, 500, 24, 0.8f),
            Note(600, 1100, 108, 0.9f)
        };

        var result = new RobloxPianoArranger().Arrange("fold", notes);

        Equal(2, result.Track.Events.Count);
        Equal(MidiKeyboardProfile.RobloxClassic61.Map(36), result.Track.Events[0].Keys.Single());
        Equal(MidiKeyboardProfile.RobloxClassic61.Map(96), result.Track.Events[1].Keys.Single());
        Equal(2, result.Diagnostics.OctaveFoldedNotes);
        Equal(0, result.Diagnostics.OutOfRangeDrops);
    }

    // Kept under the original harness entrypoint name so the Phase-06 regression runner remains stable.
    // The contract is intentionally stronger now: skyline pitch is protected only when it is credible,
    // and adjacent clusters may protect a near-contour melody instead of an unrelated higher voice.
    public static void DensityLimitAlwaysKeepsHighestMelodyPitch()
    {
        DensityLimitRejectsWeakSkylineOvertone();
        DensityLimitUsesMelodyContinuityAcrossClusters();
        MelodyPolicyFailsClosedOnInvalidThresholds();
    }

    public static void DensityLimitRejectsWeakSkylineOvertone()
    {
        var notes = new[]
        {
            Note(0, 500, 60, 0.95f),
            Note(0, 500, 64, 0.90f),
            Note(0, 500, 67, 0.85f),
            Note(0, 500, 84, 0.10f)
        };
        var options = new RobloxPianoArrangementOptions(MaxSimultaneousNotes: 3);

        var result = new RobloxPianoArranger().Arrange("weak-skyline", notes, options);
        var keys = result.Track.Events.Select(item => item.Keys.Single()).ToHashSet();

        Equal(3, result.Track.Events.Count);
        True(!keys.Contains(MidiKeyboardProfile.RobloxClassic61.Map(84)), "Weak high overtone must not be protected as melody solely because it is the highest pitch.");
        True(keys.Contains(MidiKeyboardProfile.RobloxClassic61.Map(67)), "Credible upper voice should survive density reduction.");
        Equal(1, result.Diagnostics.DensityDrops);
        Equal(1, result.Diagnostics.WeakSkylineRejects);
    }

    public static void DensityLimitUsesMelodyContinuityAcrossClusters()
    {
        var notes = new[]
        {
            Note(0, 450, 60, 0.90f),
            Note(0, 450, 64, 0.82f),
            Note(0, 450, 72, 0.76f),
            Note(500, 950, 60, 0.95f),
            Note(500, 950, 64, 0.90f),
            Note(500, 950, 74, 0.65f),
            Note(500, 950, 84, 0.70f)
        };
        var options = new RobloxPianoArrangementOptions(MaxSimultaneousNotes: 3);

        var result = new RobloxPianoArranger().Arrange("continuity", notes, options);
        var secondCluster = result.Track.Events
            .Where(item => item.Start == TimeSpan.FromMilliseconds(500))
            .Select(item => item.Keys.Single())
            .ToHashSet();

        Equal(3, secondCluster.Count);
        True(secondCluster.Contains(MidiKeyboardProfile.RobloxClassic61.Map(74)), "Near-contour melody should be protected across adjacent dense clusters.");
        True(!secondCluster.Contains(MidiKeyboardProfile.RobloxClassic61.Map(84)), "A higher competing voice must not displace a credible continuous melody solely through skyline pitch.");
        Equal(1, result.Diagnostics.DensityDrops);
        Equal(1, result.Diagnostics.MelodyContinuitySelections);
    }

    public static void FoldedDuplicatePitchIsMergedDeterministically()
    {
        var notes = new[]
        {
            Note(0, 400, 24, 0.4f),
            Note(0, 700, 36, 0.9f)
        };

        var result = new RobloxPianoArranger().Arrange("duplicate", notes);

        Equal(1, result.Track.Events.Count);
        Equal(TimeSpan.FromMilliseconds(700), result.Track.Events[0].Duration);
        Equal(1, result.Diagnostics.DuplicatePitchMerges);
    }

    public static void SameKeyOverlapIsTrimmedBeforeCanonicalPlayback()
    {
        var notes = new[]
        {
            Note(0, 1000, 60, 0.8f),
            Note(500, 1500, 60, 0.9f)
        };

        var result = new RobloxPianoArranger().Arrange("overlap", notes);
        var ordered = result.Track.Events.OrderBy(item => item.Start).ToArray();

        Equal(2, ordered.Length);
        Equal(TimeSpan.FromMilliseconds(500), ordered[0].Duration);
        Equal(TimeSpan.FromMilliseconds(500), ordered[1].Start);
        True(ordered[0].Start + ordered[0].Duration <= ordered[1].Start, "Same Roblox key must never remain held across its next KeyDown.");
        Equal(1, result.Diagnostics.SameKeyOverlapTrims);
    }

    public static void ShortAndLowActivationNotesProduceReviewDiagnostics()
    {
        var notes = new[]
        {
            Note(0, 20, 60, 0.9f),
            Note(100, 600, 64, 0.2f)
        };

        var result = new RobloxPianoArranger().Arrange("review", notes);

        Equal(1, result.Track.Events.Count);
        Equal(1, result.Diagnostics.TooShortDrops);
        Equal(1, result.Diagnostics.LowActivationEvents);
        True(result.Diagnostics.RequiresReview, "Low-activation arrangement must surface review need rather than silently claiming high confidence.");
    }

    public static void MelodyPolicyFailsClosedOnInvalidThresholds()
    {
        var notes = new[] { Note(0, 500, 60, 0.8f) };
        Throws<ArgumentOutOfRangeException>(() => new RobloxPianoArranger().Arrange(
            "invalid-melody-floor",
            notes,
            new RobloxPianoArrangementOptions(MelodyActivationFloor: 1.1f)));
        Throws<ArgumentOutOfRangeException>(() => new RobloxPianoArranger().Arrange(
            "invalid-relative-floor",
            notes,
            new RobloxPianoArrangementOptions(MelodyRelativeActivationFloor: 0f)));
        Throws<ArgumentOutOfRangeException>(() => new RobloxPianoArranger().Arrange(
            "invalid-leap",
            notes,
            new RobloxPianoArrangementOptions(MelodyContinuityMaxLeapSemitones: 0)));
    }

    public static void PreCancelledArrangementStopsBeforeMutation()
    {
        using var cts = new CancellationTokenSource();
        cts.Cancel();
        Throws<OperationCanceledException>(() => new RobloxPianoArranger().Arrange("cancel", new[] { Note(0, 500, 60, 0.8f) }, cancellationToken: cts.Token));
    }

    private static BasicPitchTranscribedNote Note(int startMs, int endMs, int midi, float amplitude)
        => new(TimeSpan.FromMilliseconds(startMs), TimeSpan.FromMilliseconds(endMs), midi, amplitude);

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
    }

    private static void True(bool condition, string? message = null)
    {
        if (!condition)
            throw new InvalidOperationException(message ?? "Expected condition to be true.");
    }

    private static void Throws<TException>(Action action) where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }

        throw new InvalidOperationException($"Expected {typeof(TException).Name}.");
    }
}
