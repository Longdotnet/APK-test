namespace FollowerFarmSimulator.Domain;

public enum AccountStatus { New, Active, Cooldown, Limited, Disabled }
public enum JobStatus { Queued, Running, Succeeded, Failed }
public enum CampaignStatus { Queued, Running, Completed, Partial, Blocked }
public enum SocialPlatform { Simulator, TikTok }
public enum ProviderMode { Simulation, ReadOnly }

public sealed class SimAccount
{
    public Guid Id { get; init; } = Guid.NewGuid();
    public required string Username { get; init; }
    public AccountStatus Status { get; set; } = AccountStatus.Active;
    public int HealthScore { get; set; } = 100;
    public int RiskScore { get; set; }
    public int ActionsToday { get; set; }
    public DateTimeOffset? LastActionAt { get; set; }
    public DateTimeOffset? CooldownUntil { get; set; }
}

public sealed record TargetDescriptor(SocialPlatform Platform, string Username, string CanonicalTarget);

public sealed class TargetProfile
{
    public required SocialPlatform Platform { get; init; }
    public required string Username { get; init; }
    public required string CanonicalTarget { get; init; }
    public long Followers { get; set; }
}

public sealed class FollowJob
{
    public Guid Id { get; init; } = Guid.NewGuid();
    public required Guid CampaignId { get; init; }
    public required Guid AccountId { get; init; }
    public required string TargetUsername { get; init; }
    public required string ProviderKey { get; init; }
    public JobStatus Status { get; set; } = JobStatus.Queued;
    public string? ResultCode { get; set; }
}

public sealed class Campaign
{
    public Guid Id { get; init; } = Guid.NewGuid();
    public required string ProviderKey { get; init; }
    public required SocialPlatform Platform { get; init; }
    public required string TargetUsername { get; init; }
    public required string CanonicalTarget { get; init; }
    public required int Quantity { get; init; }
    public CampaignStatus Status { get; set; } = CampaignStatus.Queued;
    public int Delivered { get; set; }
    public int Failed { get; set; }
    public int RefillJobsCreated { get; set; }
    public string? BlockReason { get; set; }
    public DateTimeOffset CreatedAt { get; init; } = DateTimeOffset.UtcNow;
}

public sealed record GenerateAccountsRequest(int Count);
public sealed record CreateCampaignRequest(string Target, int Quantity, long StartingFollowers = 0, string Provider = "simulator");
public sealed record SimulatedActionResult(bool Success, string Code, int RiskDelta, int HealthDelta, TimeSpan? Cooldown = null);
