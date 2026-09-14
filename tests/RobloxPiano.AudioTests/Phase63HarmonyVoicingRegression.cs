using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class Phase63HarmonyVoicingRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        DenseChorusPrefersHarmonicCoverageOverOctaveClutter();
        HarmonyVoicingThresholdsFailClosed();
    }

    private static void DenseChorusPrefersHarmonicCoverageOverOctaveClutter()
    {
        var notes = new[]
        {
            Note(0, 450, 60, 0.62f),
            Note(0, 450, 67, 0.66f),
            Note(0, 450, 72, 0.85f),

            Note(500, 1000, 48, 0.55f),
            Note(500, 1000, 60, 0.66f),
            Note(500, 1000, 64, 0.62f),
            Note(500, 1000, 67, 0.68f),
            Note(500, 1000, 74, 0.95f),
            // Mixed-song octave/harmonic clutter can edge out a real chord tone by amplitude alone.
            Note(500, 1000, 79, 0.70f),
            Note(500, 1000, 86, 0.16f)
        };

        var result = new RobloxPianoArranger().Arrange(
            "phase-63-dense-chorus",
            notes,
            new RobloxPianoArrangementOptions(MaxSimultaneousNotes: 4));
        var chorus = result.Track.Events
            .Where(item => item.Start == TimeSpan.FromMilliseconds(500))
            .Select(item => item.Keys.Single())
            .ToHashSet();
        var profile = MidiKeyboardProfile.RobloxClassic61;

        Equal(4, chorus.Count);
        True(chorus.Contains(profile.Map(74)), "Continuous chorus melody must remain protected.");
        Equal(3, new[] { 48, 60, 64, 67 }.Count(pitch => chorus.Contains(profile.Map(pitch))));
        True(!chorus.Contains(profile.Map(79)), "A near-confidence octave duplicate must not consume a scarce harmony slot when the lower chord tone preserves pitch-class coverage.");
        True(result.Diagnostics.HarmonyVoicingSelections >= 1, "Dense chorus must exercise deterministic harmony voicing selection.");
    }

    private static void HarmonyVoicingThresholdsFailClosed()
    {
        var notes = new[] { Note(0, 500, 60, 0.8f) };
        Throws<ArgumentOutOfRangeException>(() => new RobloxPianoArranger().Arrange(
            "invalid-bass-anchor",
            notes,
            new RobloxPianoArrangementOptions(HarmonyBassAnchorRelativeActivationFloor: 0f)));
        Throws<ArgumentOutOfRangeException>(() => new RobloxPianoArranger().Arrange(
            "invalid-octave-representative",
            notes,
            new RobloxPianoArrangementOptions(HarmonyOctaveRepresentativeRelativeActivationFloor: float.NaN)));
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
