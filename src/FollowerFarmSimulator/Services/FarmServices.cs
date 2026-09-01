using FollowerFarmSimulator.Domain;
using FollowerFarmSimulator.Infrastructure;
using FollowerFarmSimulator.Providers;

namespace FollowerFarmSimulator.Services;

public sealed class AccountFactory(FarmState state)
{
    public IReadOnlyList<SimAccount> Generate(int count)
    {
        if (count < 1 || count > 100_000) throw new ArgumentOutOfRangeException(nameof(count));

        var created = new List<SimAccount>(count);
        for (var i = 0; i < count; i++)
        {
            var account = new SimAccount
            {
                Username = $"sim_{Guid.NewGuid():N}"[..16],
                HealthScore = Random.Shared.Next(75, 101),
                RiskScore = Random.Shared.Next(0, 11),
                Status = AccountStatus.Active
            };
            state.Accounts[account.Id] = account;
            created.Add(account);
        }
        return created;
    }
}

public sealed class RiskEngine
{
    public void Apply(SimAccount account, SimulatedActionResult result)
    {
        account.ActionsToday++;
        account.LastActionAt = DateTimeOffset.UtcNow;
        account.RiskScore = Math.Clamp(account.RiskScore + result.RiskDelta, 0, 100);
        account.HealthScore = Math.Clamp(account.HealthScore + result.HealthDelta, 0, 100);

        account.Status = result.Code switch
        {
            "COOLDOWN" => AccountStatus.Cooldown,
            "LIMITED" => AccountStatus.Limited,
            "DISABLED" => AccountStatus.Disabled,
            _ when account.HealthScore < 20 => AccountStatus.Disabled,
            _ => AccountStatus.Active
        };

        if (result.Cooldown is { } cooldown)
            account.CooldownUntil = DateTimeOffset.UtcNow.Add(cooldown);
    }
}

public sealed class CampaignService(FarmState state, ProviderRouter providers)
{
    public async Task<Campaign> CreateAsync(
        string target,
        int quantity,
        long startingFollowers,
        string providerKey,
        CancellationToken ct)
    {
        if (quantity < 1 || quantity > 100_000) throw new ArgumentOutOfRangeException(nameof(quantity));

        var provider = providers.GetRequired(providerKey);
        var descriptor = provider.NormalizeTarget(target);
        var targetKey = TargetKey(provider.Key, descriptor.Username);

        state.Targets.TryAdd(targetKey, new TargetProfile
        {
            Platform = descriptor.Platform,
            Username = descriptor.Username,
            CanonicalTarget = descriptor.CanonicalTarget,
            Followers = startingFollowers
        });

        var campaign = new Campaign
        {
            ProviderKey = provider.Key,
            Platform = descriptor.Platform,
            TargetUsername = descriptor.Username,
            CanonicalTarget = descriptor.CanonicalTarget,
            Quantity = quantity,
            Status = CampaignStatus.Queued
        };
        state.Campaigns[campaign.Id] = campaign;

        if (!provider.SupportsMutatingEngagement)
        {
            campaign.Status = CampaignStatus.Blocked;
            campaign.BlockReason = $"Provider '{provider.Key}' is {provider.Mode} and does not allow mutating engagement actions.";
            return campaign;
        }

        var available = state.Accounts.Values
            .Where(IsEligible)
            .OrderByDescending(x => x.HealthScore)
            .ThenBy(x => x.RiskScore)
            .Take(quantity)
            .ToArray();

        if (available.Length == 0)
        {
            state.Campaigns.TryRemove(campaign.Id, out _);
            throw new InvalidOperationException("No eligible synthetic accounts. Generate accounts first.");
        }

        campaign.Status = CampaignStatus.Running;
        foreach (var account in available)
        {
            var job = new FollowJob
            {
                CampaignId = campaign.Id,
                AccountId = account.Id,
                TargetUsername = descriptor.Username,
                ProviderKey = provider.Key
            };
            state.Jobs[job.Id] = job;
            await state.Queue.Writer.WriteAsync(job, ct);
        }

        if (available.Length < quantity)
            campaign.Failed += quantity - available.Length;

        return campaign;
    }

    public async Task<int> RefillAsync(Guid campaignId, CancellationToken ct)
    {
        if (!state.Campaigns.TryGetValue(campaignId, out var campaign)) throw new KeyNotFoundException("Campaign not found.");

        var provider = providers.GetRequired(campaign.ProviderKey);
        if (!provider.SupportsMutatingEngagement)
            throw new InvalidOperationException($"Provider '{provider.Key}' does not allow refill/mutating engagement actions.");

        var missing = Math.Max(0, campaign.Quantity - campaign.Delivered);
        if (missing == 0) return 0;

        var usedAccounts = state.Jobs.Values.Where(x => x.CampaignId == campaignId).Select(x => x.AccountId).ToHashSet();
        var replacements = state.Accounts.Values.Where(x => !usedAccounts.Contains(x.Id) && IsEligible(x)).Take(missing).ToArray();

        foreach (var account in replacements)
        {
            var job = new FollowJob
            {
                CampaignId = campaign.Id,
                AccountId = account.Id,
                TargetUsername = campaign.TargetUsername,
                ProviderKey = campaign.ProviderKey
            };
            state.Jobs[job.Id] = job;
            await state.Queue.Writer.WriteAsync(job, ct);
        }

        campaign.RefillJobsCreated += replacements.Length;
        campaign.Status = CampaignStatus.Running;
        return replacements.Length;
    }

    public static string TargetKey(string providerKey, string username) => $"{providerKey}:{username}";

    private static bool IsEligible(SimAccount account)
    {
        if (account.Status == AccountStatus.Cooldown && account.CooldownUntil <= DateTimeOffset.UtcNow)
            account.Status = AccountStatus.Active;

        return account.Status == AccountStatus.Active && account.HealthScore >= 40 && account.RiskScore < 80;
    }
}
