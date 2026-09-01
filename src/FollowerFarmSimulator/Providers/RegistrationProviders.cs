using FollowerFarmSimulator.Domain;

namespace FollowerFarmSimulator.Providers;

public interface IEmailProvider
{
    string Key { get; }
    ProviderMode Mode { get; }
    ValueTask<MailboxLease> CreateMailboxAsync(RegistrationIdentity identity, CancellationToken ct);
    ValueTask<VerificationArtifact> WaitForVerificationAsync(MailboxLease mailbox, CancellationToken ct);
}

public sealed class EmailProviderRouter(IEnumerable<IEmailProvider> providers)
{
    private readonly IReadOnlyDictionary<string, IEmailProvider> _providers = providers
        .ToDictionary(x => x.Key, StringComparer.OrdinalIgnoreCase);

    public IReadOnlyCollection<object> Describe() => _providers.Values
        .Select(x => (object)new { key = x.Key, mode = x.Mode.ToString() })
        .ToArray();

    public IEmailProvider GetRequired(string key)
    {
        if (_providers.TryGetValue(key, out var provider)) return provider;
        throw new KeyNotFoundException($"Unknown email provider '{key}'. Available: {string.Join(", ", _providers.Keys)}");
    }
}

public sealed class SimulatedEmailProvider : IEmailProvider
{
    public string Key => "simulator-mail";
    public ProviderMode Mode => ProviderMode.Simulation;

    public ValueTask<MailboxLease> CreateMailboxAsync(RegistrationIdentity identity, CancellationToken ct)
    {
        ct.ThrowIfCancellationRequested();
        var suffix = Guid.NewGuid().ToString("N")[..8];
        var mailbox = new MailboxLease(
            Key,
            $"{identity.UsernameSeed}.{suffix}@example.invalid",
            $"mail-{Guid.NewGuid():N}");
        return ValueTask.FromResult(mailbox);
    }

    public async ValueTask<VerificationArtifact> WaitForVerificationAsync(MailboxLease mailbox, CancellationToken ct)
    {
        await Task.Delay(Random.Shared.Next(25, 90), ct);
        if (Random.Shared.NextDouble() < 0.97)
            return new VerificationArtifact(true, $"sim-token-{Guid.NewGuid():N}", "SIM_VERIFICATION_DELIVERED");

        return new VerificationArtifact(false, null, "SIM_VERIFICATION_TIMEOUT");
    }
}

public interface IRegistrationProvider
{
    string Key { get; }
    SocialPlatform Platform { get; }
    ProviderMode Mode { get; }
    bool SupportsAccountCreation { get; }

    ValueTask<RegistrationStartResult> BeginAsync(
        RegistrationIdentity identity,
        MailboxLease mailbox,
        CancellationToken ct);

    ValueTask<RegistrationResult> CompleteAsync(
        RegistrationIdentity identity,
        MailboxLease mailbox,
        VerificationArtifact verification,
        CancellationToken ct);
}

public sealed class RegistrationProviderRouter(IEnumerable<IRegistrationProvider> providers)
{
    private readonly IReadOnlyDictionary<string, IRegistrationProvider> _providers = providers
        .ToDictionary(x => x.Key, StringComparer.OrdinalIgnoreCase);

    public IReadOnlyCollection<object> Describe() => _providers.Values
        .Select(x => (object)new
        {
            key = x.Key,
            platform = x.Platform.ToString(),
            mode = x.Mode.ToString(),
            supportsAccountCreation = x.SupportsAccountCreation
        })
        .ToArray();

    public IRegistrationProvider GetRequired(string key)
    {
        if (_providers.TryGetValue(key, out var provider)) return provider;
        throw new KeyNotFoundException($"Unknown registration provider '{key}'. Available: {string.Join(", ", _providers.Keys)}");
    }
}

public sealed class SimulatorRegistrationProvider : IRegistrationProvider
{
    public string Key => "simulator-registration";
    public SocialPlatform Platform => SocialPlatform.Simulator;
    public ProviderMode Mode => ProviderMode.Simulation;
    public bool SupportsAccountCreation => true;

    public async ValueTask<RegistrationStartResult> BeginAsync(
        RegistrationIdentity identity,
        MailboxLease mailbox,
        CancellationToken ct)
    {
        await Task.Delay(Random.Shared.Next(20, 70), ct);
        return Random.Shared.NextDouble() < 0.985
            ? new RegistrationStartResult(true, true, "SIM_VERIFICATION_REQUIRED")
            : new RegistrationStartResult(false, false, "SIM_REGISTRATION_REJECTED");
    }

    public async ValueTask<RegistrationResult> CompleteAsync(
        RegistrationIdentity identity,
        MailboxLease mailbox,
        VerificationArtifact verification,
        CancellationToken ct)
    {
        await Task.Delay(Random.Shared.Next(20, 70), ct);

        if (!verification.Delivered)
            return new RegistrationResult(false, verification.Code);

        var roll = Random.Shared.NextDouble();
        if (roll < 0.95)
        {
            return new RegistrationResult(
                true,
                "SIM_ACCOUNT_CREATED",
                identity.UsernameSeed,
                "SyntheticReady",
                Random.Shared.Next(78, 101),
                Random.Shared.Next(0, 9));
        }

        if (roll < 0.975) return new RegistrationResult(false, "SIM_VERIFICATION_REJECTED");
        if (roll < 0.992) return new RegistrationResult(false, "SIM_PROVIDER_ERROR");
        return new RegistrationResult(false, "SIM_CHALLENGE");
    }
}

/// <summary>
/// Architectural boundary for TikTok account creation research. This adapter intentionally
/// does not register accounts, open browsers, handle credentials, solve verification,
/// rotate proxies, emulate devices, or call private TikTok endpoints.
/// </summary>
public sealed class TikTokRegistrationProvider : IRegistrationProvider
{
    public string Key => "tiktok-registration";
    public SocialPlatform Platform => SocialPlatform.TikTok;
    public ProviderMode Mode => ProviderMode.ReadOnly;
    public bool SupportsAccountCreation => false;

    public ValueTask<RegistrationStartResult> BeginAsync(
        RegistrationIdentity identity,
        MailboxLease mailbox,
        CancellationToken ct)
    {
        ct.ThrowIfCancellationRequested();
        return ValueTask.FromResult(new RegistrationStartResult(false, false, "PROVIDER_READ_ONLY"));
    }

    public ValueTask<RegistrationResult> CompleteAsync(
        RegistrationIdentity identity,
        MailboxLease mailbox,
        VerificationArtifact verification,
        CancellationToken ct)
    {
        ct.ThrowIfCancellationRequested();
        return ValueTask.FromResult(new RegistrationResult(false, "PROVIDER_READ_ONLY"));
    }
}
