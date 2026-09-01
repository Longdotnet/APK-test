using FollowerFarmSimulator.Domain;
using FollowerFarmSimulator.Infrastructure;

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

public sealed class SimulatedProvider
{
    public SimulatedActionResult Follow(SimAccount account, TargetProfile target)
    {
        // Deliberately local-only: no network, browser automation, credentials, or platform API calls.
        var roll = Random.Shared.NextDouble();
        if (roll < 0.93) return new(true, "SUCCESS", Random.Shared.Next(1, 4), -Random.Shared.Next(0, 2));
        if (roll < 0.96) return new(false, "COOLDOWN", 5, -3, TimeSpan.FromSeconds(Random.Shared.Next(10, 31)));
        if (roll < 0.985) return new(false, "LIMITED", 12, -12);
        return new(false, "DISABLED", 25, -30);
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

public sealed class CampaignService(FarmState state)
{
    public async Task<Campaign> CreateAsync(string targetUsername, int quantity, long startingFollowers, CancellationToken ct)
    {
        if (string.IsNullOrWhiteSpace(targetUsername)) throw new ArgumentException("Target is required.");
        if (quantity < 1 || quantity > 100_000) throw new ArgumentOutOfRangeException(nameof(quantity));

        targetUsername = targetUsername.Trim().TrimStart('@');
        state.Targets.TryAdd(targetUsername, new TargetProfile { Username = targetUsername, Followers = startingFollowers });

        var available = state.Accounts.Values
            .Where(IsEligible)
            .OrderByDescending(x => x.HealthScore)
            .ThenBy(x => x.RiskScore)
            .Take(quantity)
            .ToArray();

        if (available.Length == 0) throw new InvalidOperationException("No eligible synthetic accounts. Generate accounts first.");

        var campaign = new Campaign { TargetUsername = targetUsername, Quantity = quantity, Status = CampaignStatus.Running };
        state.Campaigns[campaign.Id] = campaign;

        foreach (var account in available)
        {
            var job = new FollowJob { CampaignId = campaign.Id, AccountId = account.Id, TargetUsername = targetUsername };
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

        var missing = Math.Max(0, campaign.Quantity - campaign.Delivered);
        if (missing == 0) return 0;

        var usedAccounts = state.Jobs.Values.Where(x => x.CampaignId == campaignId).Select(x => x.AccountId).ToHashSet();
        var replacements = state.Accounts.Values.Where(x => !usedAccounts.Contains(x.Id) && IsEligible(x)).Take(missing).ToArray();

        foreach (var account in replacements)
        {
            var job = new FollowJob { CampaignId = campaign.Id, AccountId = account.Id, TargetUsername = campaign.TargetUsername };
            state.Jobs[job.Id] = job;
            await state.Queue.Writer.WriteAsync(job, ct);
        }

        campaign.RefillJobsCreated += replacements.Length;
        campaign.Status = CampaignStatus.Running;
        return replacements.Length;
    }

    private static bool IsEligible(SimAccount account)
    {
        if (account.Status == AccountStatus.Cooldown && account.CooldownUntil <= DateTimeOffset.UtcNow)
            account.Status = AccountStatus.Active;

        return account.Status == AccountStatus.Active && account.HealthScore >= 40 && account.RiskScore < 80;
    }
}
