using System.Runtime.CompilerServices;
using RobloxPiano.Library;

namespace RobloxPiano.LibraryTests;

internal static class WideRangeMidiCompatibilityRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var root = Path.Combine(
            Path.GetTempPath(),
            "RobloxPiano.WideRangeMidiRegression",
            Guid.NewGuid().ToString("N"));
        var managed = Path.Combine(root, "managed");
        Directory.CreateDirectory(managed);

        try
        {
            var source = Path.Combine(root, "haha.mid");
            File.WriteAllBytes(source, BuildWideRangeMidi());

            var library = new SheetLibraryService(managed);
            var result = library.ImportBatch([source]);
            Assert(result.Imported.Count == 1, "32..107 MIDI should import instead of failing the batch.");
            Assert(result.Failed.Count == 0, "wide-range compatibility fallback must not leave an import warning.");
            Assert(result.AdjustedCount == 1, "octave-folded MIDI must be reported as compatibility-adjusted.");

            var row = library.Scan().Single();
            Assert(row.Status == SheetValidationStatus.Valid, "wide-range MIDI Library row must be playable.");
            Assert(row.HasCompatibilityAdjustment, "Library row must expose octave folding.");
            Assert(
                row.Compatibility.Contains("octave-folded wide range 32..107 into Roblox 36..96", StringComparison.Ordinal),
                $"unexpected compatibility summary: {row.Compatibility}");

            var loaded = SongSourceLoader.Load(row.Path);
            Assert(loaded.Metadata?.UsedOctaveFolding == true, "loader metadata must preserve octave-fold fallback visibility.");
            Assert(loaded.Track.Events.Count == 2, "both melodic notes should survive compatibility import.");

            Console.WriteLine("PASS  wide-range MIDI 32..107 octave-folds into the Roblox client range");
        }
        finally
        {
            try
            {
                Directory.Delete(root, recursive: true);
            }
            catch
            {
            }
        }
    }

    private static byte[] BuildWideRangeMidi()
    {
        byte[] track =
        [
            0x00, 0xFF, 0x03, 0x04, (byte)'h', (byte)'a', (byte)'h', (byte)'a',
            0x00, 0x90, 32, 100,
            0x00, 0x90, 107, 100,
            0x78, 0x80, 32, 0,
            0x00, 0x80, 107, 0,
            0x00, 0xFF, 0x2F, 0x00
        ];

        var bytes = new List<byte>();
        bytes.AddRange("MThd"u8.ToArray());
        bytes.AddRange([0x00, 0x00, 0x00, 0x06, 0x00, 0x00, 0x00, 0x01, 0x01, 0xE0]);
        bytes.AddRange("MTrk"u8.ToArray());
        bytes.AddRange([(byte)(track.Length >> 24), (byte)(track.Length >> 16), (byte)(track.Length >> 8), (byte)track.Length]);
        bytes.AddRange(track);
        return bytes.ToArray();
    }

    private static void Assert(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }
}
