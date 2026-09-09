using RobloxPiano.Core;

namespace RobloxPiano.Library;

/// <summary>
/// Provides a tiny deterministic offline starter catalog so a clean client never opens to an
/// unexplained empty library. The starter material is original/product-owned test music rather
/// than network content, and it is only created when both managed and portable catalogs are empty.
/// </summary>
public static class StarterLibrarySeeder
{
    private static readonly StarterSong[] StarterSongs =
    [
        new(
            "starter-warmup.txt",
            """
            TITLE=Starter Warmup
            BPM=120
            SUBDIV=4
            START_DELAY=0
            CHORD_HOLD=0.5
            LOOPS=1

            t r . y u . i o . p a . s d . f
            """),
        new(
            "starter-chords.txt",
            """
            TITLE=Starter Chord Practice
            BPM=100
            SUBDIV=4
            START_DELAY=0
            CHORD_HOLD=0.65
            LOOPS=1

            [ad] . [sf] . [dg] . [fh] . [gj] . [hk]
            """)
    ];

    public static int EnsureSeeded(SheetLibraryService library)
    {
        ArgumentNullException.ThrowIfNull(library);

        if (library.Scan().Count != 0)
        {
            return 0;
        }

        // Validate product-owned starter data before touching the user's managed library.
        foreach (var starter in StarterSongs)
        {
            _ = LegacySheetParser.Parse(starter.Content);
        }

        Directory.CreateDirectory(library.ManagedDirectory);
        var created = 0;
        foreach (var starter in StarterSongs)
        {
            var target = Path.Combine(library.ManagedDirectory, starter.FileName);
            if (File.Exists(target))
            {
                continue;
            }

            File.WriteAllText(target, starter.Content);
            created++;
        }

        return created;
    }

    private sealed record StarterSong(string FileName, string Content);
}
