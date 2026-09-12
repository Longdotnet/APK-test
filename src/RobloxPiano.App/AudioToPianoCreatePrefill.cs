namespace RobloxPiano.App;

internal sealed record AudioToPianoCreatePrefill(string SongIdentity, string AudioPath)
{
    public static AudioToPianoCreatePrefill From(string? suggestedTitle, string audioPath)
    {
        if (string.IsNullOrWhiteSpace(audioPath))
            throw new ArgumentException("A local audio path is required for the verified-reference handoff.", nameof(audioPath));

        var fullPath = Path.GetFullPath(audioPath);
        return new AudioToPianoCreatePrefill(
            AudioToPianoSongIdentity.Normalize(suggestedTitle, fullPath),
            fullPath);
    }
}
