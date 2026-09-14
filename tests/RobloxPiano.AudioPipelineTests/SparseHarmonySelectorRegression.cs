using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class SparseHarmonySelectorRegression
{
    [ModuleInitializer]
    internal static void RunSparseHarmonySelectorRegressions()
    {
        Run("sparse harmony stays below protected lead", HarmonyCannotBecomeLead);
        Run("sparse harmony caps density and pitch-class duplicates", HarmonyDensityIsBounded);
        Run("sparse harmony ignores unrelated accompaniment timing", HarmonyMustFollowLeadTiming);
    }

    private static void HarmonyCannotBecomeLead()
    {
        var lead = new[]
        {
            Note(1.00, 1.55, 72, 0.82f)
        };
        var accompaniment = new[]
        {
            Note(0.98, 1.60, 60, 0.88f),
            Note(1.01, 1.58, 64, 0.78f),
            Note(1.00, 1.60, 67, 0.70f),
            Note(1.00, 1.60, 76, 0.96f),
            Note(1.00, 1.60, 47, 0.96f)
        };

        var result = new SparseHarmonySelector().Select(lead, accompaniment);

        True(result.Notes.Count is > 0 and <= 2,
            $"Expected one or two restrained harmony notes, got {result.Notes.Count}.");
        True(result.Notes.All(note => note.MidiNote <= 69),
            "Harmony must remain at least three semitones below the protected lead.");
        True(result.Notes.All(note => note.MidiNote >= 48),
            "Very-low accompaniment outside the two-octave support window must not be admitted.");
        True(result.Notes.All(note => note.Amplitude < lead[0].Amplitude),
            "Harmony activation must remain below the lead activation.");
        True(result.Diagnostics.RejectedAboveLead >= 2,
            "High accompaniment and over-distant bass must be rejected before arrangement.");
    }

    private static void HarmonyDensityIsBounded()
    {
        var lead = new[]
        {
            Note(0.50, 1.10, 76, 0.90f)
        };
        var accompaniment = new[]
        {
            Note(0.49, 1.20, 52, 0.80f),
            Note(0.50, 1.20, 64, 0.79f), // same pitch class as 52
            Note(0.50, 1.20, 55, 0.77f),
            Note(0.50, 1.20, 59, 0.75f),
            Note(0.50, 1.20, 62, 0.73f)
        };

        var result = new SparseHarmonySelector().Select(
            lead,
            accompaniment,
            new SparseHarmonySelectionOptions(MaxHarmonyNotesPerLeadOnset: 2));

        Equal(2, result.Notes.Count);
        Equal(2, result.Notes.Select(note => PitchClass(note.MidiNote)).Distinct().Count());
        True(result.Diagnostics.DuplicatePitchClassDrops > 0,
            "Octave-equivalent accompaniment must not spend multiple Roblox density slots.");
        Equal(1, result.Diagnostics.LeadOnsetsWithHarmony);
    }

    private static void HarmonyMustFollowLeadTiming()
    {
        var lead = new[]
        {
            Note(2.00, 2.60, 72, 0.85f)
        };
        var accompaniment = new[]
        {
            Note(0.20, 0.80, 60, 0.95f),
            Note(1.99, 2.70, 64, 0.70f)
        };

        var result = new SparseHarmonySelector().Select(lead, accompaniment);

        Equal(1, result.Notes.Count);
        Equal(64, result.Notes[0].MidiNote);
        Equal(lead[0].Start, result.Notes[0].Start);
        True(result.Diagnostics.RejectedOutsideLeadWindow > 0,
            "Unrelated accompaniment timing must be observable as rejected evidence.");
    }

    private static BasicPitchTranscribedNote Note(double startSeconds, double endSeconds, int midi, float amplitude) =>
        new(TimeSpan.FromSeconds(startSeconds), TimeSpan.FromSeconds(endSeconds), midi, amplitude);

    private static int PitchClass(int midi) => ((midi % 12) + 12) % 12;

    private static void Run(string name, Action action)
    {
        try
        {
            action();
            Console.WriteLine($"PASS {name}");
        }
        catch (Exception exception)
        {
            Environment.ExitCode = 1;
            Console.Error.WriteLine($"FAIL {name}: {exception}");
        }
    }

    private static void True(bool condition, string? message = null)
    {
        if (!condition)
            throw new InvalidOperationException(message ?? "Expected condition to be true.");
    }

    private static void Equal<T>(T expected, T actual) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected '{expected}', got '{actual}'.");
    }
}
