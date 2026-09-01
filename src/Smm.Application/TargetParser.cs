namespace Smm.Application;

public static class TargetParser
{
    public static string ParseTikTokHandle(string target)
    {
        if (string.IsNullOrWhiteSpace(target))
        {
            throw new ArgumentException("Target is required.", nameof(target));
        }

        var value = target.Trim();
        if (value.StartsWith('@'))
        {
            return ValidateHandle(value[1..]);
        }

        if (!Uri.TryCreate(value, UriKind.Absolute, out var uri))
        {
            throw new ArgumentException("Target must be a TikTok profile URL or @handle.", nameof(target));
        }

        if (!uri.Host.Equals("www.tiktok.com", StringComparison.OrdinalIgnoreCase)
            && !uri.Host.Equals("tiktok.com", StringComparison.OrdinalIgnoreCase))
        {
            throw new ArgumentException("Only TikTok profile URLs are accepted as simulator targets.", nameof(target));
        }

        var segment = uri.AbsolutePath
            .Split('/', StringSplitOptions.RemoveEmptyEntries)
            .FirstOrDefault(x => x.StartsWith('@'));

        if (segment is null)
        {
            throw new ArgumentException("TikTok profile URL must contain an @handle.", nameof(target));
        }

        return ValidateHandle(segment[1..]);
    }

    private static string ValidateHandle(string handle)
    {
        var normalized = handle.Trim();
        if (normalized.Length is < 2 or > 24)
        {
            throw new ArgumentException("TikTok handle length must be between 2 and 24 characters.");
        }

        if (normalized.Any(c => !(char.IsLetterOrDigit(c) || c is '.' or '_')))
        {
            throw new ArgumentException("TikTok handle contains unsupported characters.");
        }

        return normalized;
    }
}
