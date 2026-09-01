using FollowerFarmSimulator.Domain;
using FollowerFarmSimulator.Infrastructure;
using FollowerFarmSimulator.Providers;

namespace FollowerFarmSimulator.Services;

public sealed class IdentityFactory
{
    public RegistrationIdentity Create(string region)
    {
        region = NormalizeRegion(region);
        var month = Random.Shared.Next(1, 13);
        var year = Random.Shared.Next(1990, 2004);
        var day = Random.Shared.Next(1, DateTime.DaysInMonth(year, month) + 1);
        var suffix = Guid.NewGuid().ToString("N")[..10];

        return new RegistrationIdentity
        {
            UsernameSeed = $"sim_{suffix}",
            DisplayName = $"Research User {suffix[..4].ToUpperInvariant()}",
            Region = region,
            BirthDate = new DateOnly(year, month, day),
            PasswordReference = $"secret://synthetic/{Guid.NewGuid():N}"
        };
    }

    private static string NormalizeRegion(string region)
    {
        if (string.IsNullOrWhiteSpace(region)) return "LAB";
        var normalized = region.Trim().ToUpperInvariant();
        if (normalized.Length is < 2 or > 12 || normalized.Any(x => !char.IsLetterOrDigit(x) && x != '-'))
            throw new ArgumentException("Region must be 2-12 alphanumeric/hyphen characters.");
        return normalized;
    }
}

public sealed class AccountCreationService(
    FarmState state,
    IdentityFactory identities,
    RegistrationProviderRouter registrationProviders,
    EmailProviderRouter emailProviders)
{
    public async Task<AccountCreationCampaign> CreateAsync(
        int quantity,
        string region,
        string providerKey,
        string emailProviderKey,
        CancellationToken ct)
    {
        if (quantity < 1 || quantity > 100_000) throw new ArgumentOutOfRangeException(nameof(quantity));

        var provider = registrationProviders.GetRequired(providerKey);
        var emailProvider = emailProviders.GetRequired(emailProviderKey);

        // Normalize/validate region before committing the campaign.
        var firstIdentity = identities.Create(region);
        var campaign = new AccountCreationCampaign
        {
            ProviderKey = provider.Key,
            EmailProviderKey = emailProvider.Key,
            Platform = provider.Platform,
            Region = firstIdentity.Region,
            Quantity = quantity,
            Status = CreationCampaignStatus.Queued
        };
        state.CreationCampaigns[campaign.Id] = campaign;

        if (!provider.SupportsAccountCreation)
        {
            campaign.Status = CreationCampaignStatus.Blocked;
            campaign.BlockReason = $"Provider '{provider.Key}' is {provider.Mode} and does not allow account creation.";
            return campaign;
        }

        campaign.Status = CreationCampaignStatus.Running;
        for (var i = 0; i < quantity; i++)
        {
            var identity = i == 0 ? firstIdentity : identities.Create(campaign.Region);
            state.Identities[identity.Id] = identity;

            var job = new AccountCreationJob
            {
                CampaignId = campaign.Id,
                IdentityId = identity.Id,
                ProviderKey = provider.Key,
                EmailProviderKey = emailProvider.Key,
                State = RegistrationState.IdentityReady
            };
            state.CreationJobs[job.Id] = job;
            await state.CreationQueue.Writer.WriteAsync(job, ct);
        }

        return campaign;
    }
}

public sealed class ReplenishmentService(FarmState state, AccountCreationService accountCreation)
{
    public async Task<ReplenishmentOutcome> EnsureMinimumAsync(
        int minimumActive,
        int batchSize,
        string region,
        string providerKey,
        string emailProviderKey,
        CancellationToken ct)
    {
        if (minimumActive < 1 || minimumActive > 1_000_000)
            throw new ArgumentOutOfRangeException(nameof(minimumActive));
        if (batchSize < 1 || batchSize > 100_000)
            throw new ArgumentOutOfRangeException(nameof(batchSize));

        var activeBefore = state.Accounts.Values.Count(x => x.Status == AccountStatus.Active);
        var missing = Math.Max(0, minimumActive - activeBefore);
        if (missing == 0)
            return new ReplenishmentOutcome(activeBefore, 0, null);

        var requested = Math.Min(missing, batchSize);
        var campaign = await accountCreation.CreateAsync(
            requested,
            region,
            providerKey,
            emailProviderKey,
            ct);

        return new ReplenishmentOutcome(activeBefore, requested, campaign);
    }
}
