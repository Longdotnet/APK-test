using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class Phase64HarmonyContinuityRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        DenseSectionKeepsCrediblePriorHarmonyWithoutResurrectingWeakNotes();
        HarmonyContinuityExpiresAcrossLongSectionGap();
        HarmonyContinuityThresholdsFailClosed();
    }

    private static void DenseSectionKeepsCrediblePriorHarmonyWithoutResurrectingWeakNotes()
    {
        var notes = new[]
        {
            // Sparse verse: this establishes a stable C/E harmony context without invoking the density policy.
            Note(0, 450, 48, 0.59f),
            Note(0, 450, 60, 0.66f),
            Note(0, 450, 64, 0.62f),
            Note(0, 450, 72, 0.90f),

            // Dense transition: G/A edge E by confidence, but E remains within the bounded continuity floor.
            // A very weak B must never return merely because it would add another pitch class.
            Note(500, 1050, 48, 0.58f),
            Note(500, 1050, 60, 0.67f),
            Note(500, 1050, 64, 0.61f),
            Note(500, 1050, 67, 0.64f),
            Note(500, 1050, 69, 0.63f),
            Note(500, 1050, 71, 0.18f),
            Note(500, 1050, 74, 0.95f)
        };

        var result = new RobloxPianoArranger().Arrange(
            "phase-64-cross-section-continuity",
            notes,
            new RobloxPianoArrangementOptions(MaxSimultaneousNotes: 4));
        var profile = MidiKeyboardProfile.RobloxClassic61;
        var dense = result.Track.Events
            .Where(item => item.Start == TimeSpan.FromMilliseconds(500))
            .Select(item => item.Keys.Single())
            .ToHashSet();

        Equal(4, dense.Count);
        True(dense.Contains(profile.Map(74)), "Melody must remain protected while harmony continuity is applied.");
        True(dense.Contains(profile.Map(48)), "Credible low bass/root evidence must remain reserved.");
        True(dense.Contains(profile.Map(64)), "A near-confidence prior harmony pitch class should survive the section transition.");
        True(!dense.Contains(profile.Map(71)), "Harmony continuity must never resurrect weak evidence below the existing confidence guards.");
        True(result.Diagnostics.HarmonyContinuitySelections >= 1, "Dense transition must report bounded cross-section harmony continuity.");
    }

    private static void HarmonyContinuityExpiresAcrossLongSectionGap()
    {
        var notes = new[]
        {
            Note(0, 450, 48, 0.59f),
            Note(0, 450, 60, 0.66f),
            Note(0, 450, 64, 0.62f),
            Note(0, 450, 72, 0.90f),

            // Same dense evidence after a long gap: stale verse harmony must no longer bias the new section.
            Note(3000, 3550, 48, 0.58f),
            Note(3000, 3550, 60, 0.67f),
            Note(3000, 3550, 64, 0.61f),
            Note(3000, 3550, 67, 0.64f),
            Note(3000, 3550, 69, 0.63f),
            Note(3000, 3550, 71, 0.18f),
            Note(3000, 3550, 74, 0.95f)
        };

        var result = new RobloxPianoArranger().Arrange(
            "phase-64-stale-continuity",
            notes,
            new RobloxPianoArrangementOptions(MaxSimultaneousNotes: 4));
        var profile = MidiKeyboardProfile.RobloxClassic61;
        var dense = result.Track.Events
            .Where(item => item.Start == TimeSpan.FromMilliseconds(3000))
            .Select(item => item.Keys.Single())
            .ToHashSet();

        Equal(4, dense.Count);
        True(dense.Contains(profile.Map(74)), "New-section melody must remain protected.");
        True(dense.Contains(profile.Map(48)), "New-section bass anchor must remain protected.");
        True(!dense.Contains(profile.Map(64)), "Expired harmony context must not bias a later unrelated section.");
        True(dense.Contains(profile.Map(67)) && dense.Contains(profile.Map(69)), "Without live continuity, current-section confidence must decide the remaining harmony slots.");
        Equal(0, result.Diagnostics.HarmonyContinuitySelections);
    }

    private static void HarmonyContinuityThresholdsFailClosed()
    {
        var notes = new[] { Note(0, 500, 60, 0.8f) };
        Throws<ArgumentOutOfRangeException>(() => new RobloxPianoArranger().Arrange(
            "invalid-harmony-window",
            notes,
            new RobloxPianoArrangementOptions(HarmonyContinuityWindow: TimeSpan.Zero)));
        Throws<ArgumentOutOfRangeException>(() => new RobloxPianoArranger().Arrange(
            "invalid-harmony-confidence",
            notes,
            new RobloxPianoArrangementOptions(HarmonyContinuityRelativeActivationFloor: float.NaN)));
    }

    private static BasicPitchTranscribedNote Note(int startMs, int endMs, int midiNote, float amplitude)
        => new(
            TimeSpan.FromMilliseconds(startMs),
            TimeSpan.FromMilliseconds(endMs),
            midiNote,
            amplitude,
            null);

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
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
