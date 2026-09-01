namespace FollowerFarmSimulator.Domain;

public enum AccountStatus { New, Active, Cooldown, Limited, Disabled }
public enum JobStatus { Queued, Running, Succeeded, Failed }
public enum CampaignStatus { Queued, Running, Completed, Partial, Blocked }
public enum CreationCampaignStatus { Queued, Running, Completed, Partial, Blocked }
public enum RegistrationState
{
    IdentityReady,
    RegistrationStarted,
    WaitingVerification,
    VerificationReceived,
    Registered,
    Failed,
    Blocked
}
public enum SocialPlatform { Simulator, TikTok }
public enum ProviderMode { Simulation, ReadOnly }

public sealed class SimAccount
{
    public Guid Id { get; init; } = Guid.NewGuid();
    public required string Username { get; init; }
    public string ProviderKey { get; init; } = "seed";
    public string? ExternalUsername { get; init; }
    public string Region { get; init; } = "LAB";
    public string? PasswordReference { get; init; }
    public string SessionState { get; init; } = "Synthetic";
    public AccountStatus Status { get; set; } = AccountStatus.Active;
    public int HealthScore { get; set; } = 100;
    public int RiskScore { get; set; }
    public int ActionsToday { get; set; }
    public DateTimeOffset CreatedAt { get; init; } = DateTimeOffset.UtcNow;
    public DateTimeOffset? VerifiedAt { get; init; }
    public DateTimeOffset? ActivatedAt { get; init; }
    public DateTimeOffset? LastActionAt { get; set; }
    public DateTimeOffset? LastHealthCheck { get; set; }
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

public sealed class RegistrationIdentity
{
    public Guid Id { get; init; } = Guid.NewGuid();
    public required string UsernameSeed { get; init; }
    public required string DisplayName { get; init; }
    public required string Region { get; init; }
    public required DateOnly BirthDate { get; init; }
    public required string PasswordReference { get; init; }
    public DateTimeOffset CreatedAt { get; init; } = DateTimeOffset.UtcNow;
}

public sealed record MailboxLease(string ProviderKey, string Address, string LeaseId);
public sealed record VerificationArtifact(bool Delivered, string? Token, string Code);
public sealed record RegistrationStartResult(bool Accepted, bool RequiresVerification, string Code);
public sealed record RegistrationResult(
    bool Success,
    string Code,
    string? ExternalUsername = null,
    string SessionState = "None",
    int HealthScore = 100,
    int RiskScore = 0);

public sealed class AccountCreationJob
{
    public Guid Id { get; init; } = Guid.NewGuid();
    public required Guid CampaignId { get; init; }
    public required Guid IdentityId { get; init; }
    public required string ProviderKey { get; init; }
    public required string EmailProviderKey { get; init; }
    public JobStatus Status { get; set; } = JobStatus.Queued;
    public RegistrationState State { get; set; } = RegistrationState.IdentityReady;
    public int Attempt { get; set; }
    public string? ResultCode { get; set; }
    public Guid? AccountId { get; set; }
    public DateTimeOffset? CompletedAt { get; set; }
}

public sealed class AccountCreationCampaign
{
    public Guid Id { get; init; } = Guid.NewGuid();
    public required string ProviderKey { get; init; }
    public required string EmailProviderKey { get; init; }
    public required SocialPlatform Platform { get; init; }
    public required string Region { get; init; }
    public required int Quantity { get; init; }
    public CreationCampaignStatus Status { get; set; } = CreationCampaignStatus.Queued;
    public int Created { get; set; }
    public int Failed { get; set; }
    public string? BlockReason { get; set; }
    public DateTimeOffset CreatedAt { get; init; } = DateTimeOffset.UtcNow;
}

public sealed record GenerateAccountsRequest(int Count);
public sealed record CreateCampaignRequest(string Target, int Quantity, long StartingFollowers = 0, string Provider = "simulator");
public sealed record CreateAccountCreationCampaignRequest(
    int Quantity,
    string Region = "VN",
    string Provider = "simulator-registration",
    string EmailProvider = "simulator-mail");
public sealed record ReplenishAccountsRequest(
    int MinimumActive,
    int BatchSize = 2_000,
    string Region = "VN",
    string Provider = "simulator-registration",
    string EmailProvider = "simulator-mail");
public sealed record ReplenishmentOutcome(int ActiveBefore, int Requested, AccountCreationCampaign? Campaign);
public sealed record SimulatedActionResult(bool Success, string Code, int RiskDelta, int HealthDelta, TimeSpan? Cooldown = null);
