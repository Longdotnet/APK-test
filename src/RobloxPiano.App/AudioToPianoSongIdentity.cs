namespace RobloxPiano.App;

internal static class AudioToPianoSongIdentity
{
    internal const int MaxTitleLength = 120;

    public static string Normalize(string? suggestedTitle, string audioPath)
    {
        var candidate = NormalizeText(suggestedTitle);
        if (candidate.Length == 0)
        {
            candidate = NormalizeText(Path.GetFileNameWithoutExtension(audioPath));
        }
        if (candidate.Length == 0)
        {
            candidate = "Generated Piano";
        }

        return candidate.Length <= MaxTitleLength
            ? candidate
            : candidate[..MaxTitleLength].TrimEnd();
    }

    private static string NormalizeText(string? value)
    {
        if (string.IsNullOrWhiteSpace(value))
        {
            return string.Empty;
        }

        var buffer = new char[value.Length];
        var count = 0;
        var previousWhitespace = false;
        foreach (var ch in value)
        {
            var whitespace = char.IsWhiteSpace(ch) || char.IsControl(ch);
            if (whitespace)
            {
                if (!previousWhitespace && count > 0)
                {
                    buffer[count++] = ' ';
                }
                previousWhitespace = true;
                continue;
            }

            buffer[count++] = ch;
            previousWhitespace = false;
        }

        return new string(buffer, 0, count).Trim();
    }
}
