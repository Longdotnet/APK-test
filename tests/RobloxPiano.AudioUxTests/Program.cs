using RobloxPiano.App;

namespace RobloxPiano.AudioUxTests;

internal static class Program
{
    public static int Main()
    {
        var failures = new List<string>();
        Run("search identity wins over audio filename", SearchIdentityWins, failures);
        Run("blank identity falls back to audio filename", FilenameFallback, failures);
        Run("identity whitespace and controls normalize deterministically", WhitespaceNormalizes, failures);
        Run("empty identity and path get safe generated title", EmptyFallback, failures);
        Run("long identity is bounded deterministically", LongIdentityBounded, failures);
        Run("verified reference handoff preserves search identity", VerifiedReferencePreservesSearchIdentity, failures);
        Run("verified reference handoff falls back to reference filename", VerifiedReferenceFallsBackToFilename, failures);
        Run("verified reference handoff rejects blank path", VerifiedReferenceRejectsBlankPath, failures);

        Console.WriteLine($"Audio UX regressions: {8 - failures.Count} passed, {failures.Count} failed.");
        foreach (var failure in failures)
            Console.Error.WriteLine(failure);
        return failures.Count == 0 ? 0 : 1;
    }

    private static void SearchIdentityWins()
        => Equal("Popular Song 2026", AudioToPianoSongIdentity.Normalize(" Popular Song 2026 ", @"C:\owned\random-capture.wav"));

    private static void FilenameFallback()
        => Equal("reference mix", AudioToPianoSongIdentity.Normalize("  ", @"C:\owned\reference mix.wav"));

    private static void WhitespaceNormalizes()
        => Equal("Popular Song Name", AudioToPianoSongIdentity.Normalize("  Popular\n Song\tName\r\n ", @"C:\owned\ignored.wav"));

    private static void EmptyFallback()
        => Equal("Generated Piano", AudioToPianoSongIdentity.Normalize(null, string.Empty));

    private static void LongIdentityBounded()
    {
        var title = new string('A', AudioToPianoSongIdentity.MaxTitleLength + 40);
        var normalized = AudioToPianoSongIdentity.Normalize(title, @"C:\owned\ignored.wav");
        Equal(AudioToPianoSongIdentity.MaxTitleLength, normalized.Length);
        Equal(new string('A', AudioToPianoSongIdentity.MaxTitleLength), normalized);
    }

    private static void VerifiedReferencePreservesSearchIdentity()
    {
        var handoff = AudioToPianoCreatePrefill.From(" Popular Song 2026 ", @"C:\owned\reference mix.wav");
        Equal("Popular Song 2026", handoff.SongIdentity);
        Equal(Path.GetFullPath(@"C:\owned\reference mix.wav"), handoff.AudioPath);
    }

    private static void VerifiedReferenceFallsBackToFilename()
    {
        var handoff = AudioToPianoCreatePrefill.From("  ", @"C:\owned\reference mix.wav");
        Equal("reference mix", handoff.SongIdentity);
        Equal(Path.GetFullPath(@"C:\owned\reference mix.wav"), handoff.AudioPath);
    }

    private static void VerifiedReferenceRejectsBlankPath()
    {
        try
        {
            _ = AudioToPianoCreatePrefill.From("Song", "  ");
            throw new InvalidOperationException("blank path was accepted");
        }
        catch (ArgumentException)
        {
        }
    }

    private static void Run(string name, Action test, ICollection<string> failures)
    {
        try
        {
            test();
        }
        catch (Exception exception)
        {
            failures.Add($"FAIL {name}: {exception.Message}");
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"expected '{expected}', got '{actual}'");
    }
}
