using FollowerFarmSimulator.Domain;

namespace FollowerFarmSimulator.Providers;

public interface ISocialProvider
{
    string Key { get; }
    SocialPlatform Platform { get; }
    ProviderMode Mode { get; }
    bool SupportsMutatingEngagement { get; }

    TargetDescriptor NormalizeTarget(string rawTarget);
    ValueTask<SimulatedActionResult> FollowAsync(SimAccount account, TargetProfile target, CancellationToken ct);
}

public sealed class ProviderRouter(IEnumerable<ISocialProvider> providers)
{
    private readonly IReadOnlyDictionary<string, ISocialProvider> _providers = providers
        .ToDictionary(x => x.Key, StringComparer.OrdinalIgnoreCase);

    public IReadOnlyCollection<object> Describe() => _providers.Values
        .Select(x => (object)new
        {
            key = x.Key,
            platform = x.Platform.ToString(),
            mode = x.Mode.ToString(),
            supportsMutatingEngagement = x.SupportsMutatingEngagement
        })
        .ToArray();

    public ISocialProvider GetRequired(string key)
    {
        if (_providers.TryGetValue(key, out var provider)) return provider;
        throw new KeyNotFoundException($"Unknown provider '{key}'. Available: {string.Join(", ", _providers.Keys)}");
    }
}

public sealed class SimulatorProvider : ISocialProvider
{
    public string Key => "simulator";
    public SocialPlatform Platform => SocialPlatform.Simulator;
    public ProviderMode Mode => ProviderMode.Simulation;
    public bool SupportsMutatingEngagement => true;

    public TargetDescriptor NormalizeTarget(string rawTarget)
    {
        var username = TargetParsing.NormalizeUsername(rawTarget);
        return new TargetDescriptor(Platform, username, $"sim://@{username}");
    }

    public ValueTask<SimulatedActionResult> FollowAsync(SimAccount account, TargetProfile target, CancellationToken ct)
    {
        ct.ThrowIfCancellationRequested();
        var roll = Random.Shared.NextDouble();
        var result = roll switch
        {
            < 0.93 => new SimulatedActionResult(true, "SUCCESS", Random.Shared.Next(1, 4), -Random.Shared.Next(0, 2)),
            < 0.96 => new SimulatedActionResult(false, "COOLDOWN", 5, -3, TimeSpan.FromSeconds(Random.Shared.Next(10, 31))),
            < 0.985 => new SimulatedActionResult(false, "LIMITED", 12, -12),
            _ => new SimulatedActionResult(false, "DISABLED", 25, -30)
        };
        return ValueTask.FromResult(result);
    }
}

/// <summary>
/// TikTok integration boundary for research architecture. It intentionally supports only
/// target normalization/identification. Mutating engagement is blocked: no login,
/// private API, browser automation, credentials, CAPTCHA/OTP bypass or follow action.
/// </summary>
public sealed class TikTokProvider : ISocialProvider
{
    public string Key => "tiktok";
    public SocialPlatform Platform => SocialPlatform.TikTok;
    public ProviderMode Mode => ProviderMode.ReadOnly;
    public bool SupportsMutatingEngagement => false;

    public TargetDescriptor NormalizeTarget(string rawTarget)
    {
        if (string.IsNullOrWhiteSpace(rawTarget)) throw new ArgumentException("TikTok target is required.");

        var value = rawTarget.Trim();
        string username;

        if (Uri.TryCreate(value, UriKind.Absolute, out var uri))
        {
            if (!uri.Host.Equals("tiktok.com", StringComparison.OrdinalIgnoreCase) &&
                !uri.Host.EndsWith(".tiktok.com", StringComparison.OrdinalIgnoreCase))
                throw new ArgumentException("TikTok provider only accepts tiktok.com profile URLs or @username values.");

            var segment = uri.AbsolutePath.Split('/', StringSplitOptions.RemoveEmptyEntries)
                .FirstOrDefault(x => x.StartsWith('@'));
            if (segment is null) throw new ArgumentException("Expected a TikTok profile URL such as https://www.tiktok.com/@username.");
            username = segment.TrimStart('@');
        }
        else
        {
            username = TargetParsing.NormalizeUsername(value);
        }

        username = TargetParsing.ValidateUsername(username);
        return new TargetDescriptor(Platform, username, $"https://www.tiktok.com/@{username}");
    }

    public ValueTask<SimulatedActionResult> FollowAsync(SimAccount account, TargetProfile target, CancellationToken ct)
    {
        ct.ThrowIfCancellationRequested();
        return ValueTask.FromResult(new SimulatedActionResult(
            false,
            "PROVIDER_READ_ONLY",
            0,
            0));
    }
}

internal static class TargetParsing
{
    public static string NormalizeUsername(string rawTarget)
    {
        if (string.IsNullOrWhiteSpace(rawTarget)) throw new ArgumentException("Target is required.");
        return ValidateUsername(rawTarget.Trim().TrimStart('@'));
    }

    public static string ValidateUsername(string username)
    {
        if (username.Length is < 2 or > 64) throw new ArgumentException("Target username length is invalid.");
        if (username.Any(char.IsWhiteSpace)) throw new ArgumentException("Target username cannot contain whitespace.");
        if (username.Contains('/') || username.Contains('?') || username.Contains('#'))
            throw new ArgumentException("Target username contains invalid URL characters.");
        return username;
    }
}
