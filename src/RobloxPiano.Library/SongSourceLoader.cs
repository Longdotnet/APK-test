using RobloxPiano.Core;

namespace RobloxPiano.Library;

public enum SongSourceKind
{
    LegacyText = 0,
    Midi = 1
}

public sealed record LoadedSong(PerformanceTrack Track, SongSourceKind SourceKind);

/// <summary>
/// Source-neutral boundary used by the desktop product. UI and playback never choose
/// an importer/engine: the file extension selects a deterministic importer and the
/// result is always the canonical PerformanceTrack consumed by transport/playback.
/// </summary>
public static class SongSourceLoader
{
    private static readonly string[] SupportedExtensions = [".txt", ".vps", ".mid", ".midi"];

    public static bool IsSupportedPath(string path)
    {
        var extension = Path.GetExtension(path);
        return SupportedExtensions.Any(candidate => extension.Equals(candidate, StringComparison.OrdinalIgnoreCase));
    }

    public static LoadedSong Load(string path)
    {
        var fullPath = ValidatePath(path);
        var extension = Path.GetExtension(fullPath);
        if (IsMidi(extension))
        {
            return new LoadedSong(MidiFileImporter.ImportCompiled(File.ReadAllBytes(fullPath)), SongSourceKind.Midi);
        }

        return new LoadedSong(LegacySheetParser.Parse(File.ReadAllText(fullPath)), SongSourceKind.LegacyText);
    }

    public static async Task<LoadedSong> LoadAsync(string path, CancellationToken cancellationToken = default)
    {
        var fullPath = ValidatePath(path);
        var extension = Path.GetExtension(fullPath);
        if (IsMidi(extension))
        {
            var bytes = await File.ReadAllBytesAsync(fullPath, cancellationToken).ConfigureAwait(false);
            return new LoadedSong(MidiFileImporter.ImportCompiled(bytes), SongSourceKind.Midi);
        }

        var text = await File.ReadAllTextAsync(fullPath, cancellationToken).ConfigureAwait(false);
        return new LoadedSong(LegacySheetParser.Parse(text), SongSourceKind.LegacyText);
    }

    private static string ValidatePath(string path)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(path);
        var fullPath = Path.GetFullPath(path);
        if (!File.Exists(fullPath))
        {
            throw new FileNotFoundException("Song file does not exist.", fullPath);
        }

        if (!IsSupportedPath(fullPath))
        {
            throw new FormatException("Choose a supported song: .txt, .vps, .mid, or .midi.");
        }

        return fullPath;
    }

    private static bool IsMidi(string extension)
        => extension.Equals(".mid", StringComparison.OrdinalIgnoreCase)
           || extension.Equals(".midi", StringComparison.OrdinalIgnoreCase);
}
