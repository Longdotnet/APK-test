using FollowerFarmSimulator.Domain;
using FollowerFarmSimulator.Infrastructure;
using FollowerFarmSimulator.Providers;
using FollowerFarmSimulator.Services;
using FollowerFarmSimulator.Workers;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddSingleton<FarmState>();

builder.Services.AddSingleton<AccountFactory>();
builder.Services.AddSingleton<RiskEngine>();
builder.Services.AddSingleton<ISocialProvider, SimulatorProvider>();
builder.Services.AddSingleton<ISocialProvider, TikTokProvider>();
builder.Services.AddSingleton<ProviderRouter>();
builder.Services.AddSingleton<CampaignService>();

builder.Services.AddSingleton<IdentityFactory>();
builder.Services.AddSingleton<IEmailProvider, SimulatedEmailProvider>();
builder.Services.AddSingleton<EmailProviderRouter>();
builder.Services.AddSingleton<IRegistrationProvider, SimulatorRegistrationProvider>();
builder.Services.AddSingleton<IRegistrationProvider, TikTokRegistrationProvider>();
builder.Services.AddSingleton<RegistrationProviderRouter>();
builder.Services.AddSingleton<AccountCreationService>();
builder.Services.AddSingleton<ReplenishmentService>();

builder.Services.AddHostedService<FollowWorker>();
builder.Services.AddHostedService<AccountCreationWorker>();

var app = builder.Build();

app.MapGet("/", () => Results.Ok(new
{
    name = "Direct Follower Farm Research Simulator",
    mode = "PROVIDER_AWARE_RESEARCH_MODE",
    accountFactory = "SIMULATION_ONLY",
    warning = "TikTok adapters are read-only capability boundaries. No TikTok login, mass registration, private API, browser automation, fake-engagement mutation, proxy/fingerprint evasion, CAPTCHA or OTP bypass is implemented."
}));

app.MapGet("/api/providers", (ProviderRouter providers) => Results.Ok(providers.Describe()));

app.MapPost("/api/providers/{providerKey}/normalize-target", (string providerKey, NormalizeTargetRequest request, ProviderRouter providers) =>
{
    try
    {
        var provider = providers.GetRequired(providerKey);
        return Results.Ok(new
        {
            provider = provider.Key,
            platform = provider.Platform.ToString(),
            mode = provider.Mode.ToString(),
            supportsMutatingEngagement = provider.SupportsMutatingEngagement,
            target = provider.NormalizeTarget(request.Target)
        });
    }
    catch (Exception ex) when (ex is ArgumentException or KeyNotFoundException)
    {
        return Results.BadRequest(new { error = ex.Message });
    }
});

app.MapGet("/api/account-factory/providers", (
    RegistrationProviderRouter registrationProviders,
    EmailProviderRouter emailProviders) => Results.Ok(new
{
    registrationProviders = registrationProviders.Describe(),
    emailProviders = emailProviders.Describe()
}));

app.MapPost("/api/account-factory/campaigns", async (
    CreateAccountCreationCampaignRequest request,
    AccountCreationService service,
    CancellationToken ct) =>
{
    try
    {
        var campaign = await service.CreateAsync(
            request.Quantity,
            request.Region,
            request.Provider,
            request.EmailProvider,
            ct);

        if (campaign.Status == CreationCampaignStatus.Blocked)
            return Results.Ok(campaign);

        return Results.Accepted($"/api/account-factory/campaigns/{campaign.Id}", campaign);
    }
    catch (Exception ex) when (ex is ArgumentException or KeyNotFoundException)
    {
        return Results.BadRequest(new { error = ex.Message });
    }
});

app.MapGet("/api/account-factory/campaigns/{id:guid}", (Guid id, FarmState state) =>
    state.CreationCampaigns.TryGetValue(id, out var campaign)
        ? Results.Ok(new
        {
            campaign,
            jobStatus = state.CreationJobs.Values.Where(x => x.CampaignId == id)
                .GroupBy(x => x.Status)
                .ToDictionary(x => x.Key.ToString(), x => x.Count()),
            registrationState = state.CreationJobs.Values.Where(x => x.CampaignId == id)
                .GroupBy(x => x.State)
                .ToDictionary(x => x.Key.ToString(), x => x.Count())
        })
        : Results.NotFound());

app.MapGet("/api/account-factory/stats", (FarmState state) =>
{
    var accounts = state.Accounts.Values;
    var creationJobs = state.CreationJobs.Values;
    return Results.Ok(new
    {
        inventory = new
        {
            total = accounts.Count,
            active = accounts.Count(x => x.Status == AccountStatus.Active),
            cooldown = accounts.Count(x => x.Status == AccountStatus.Cooldown),
            limited = accounts.Count(x => x.Status == AccountStatus.Limited),
            disabled = accounts.Count(x => x.Status == AccountStatus.Disabled),
            byProvider = accounts.GroupBy(x => x.ProviderKey)
                .ToDictionary(x => x.Key, x => x.Count()),
            byRegion = accounts.GroupBy(x => x.Region)
                .ToDictionary(x => x.Key, x => x.Count())
        },
        factory = new
        {
            identities = state.Identities.Count,
            campaigns = state.CreationCampaigns.Count,
            jobs = creationJobs.Count,
            registered = creationJobs.Count(x => x.State == RegistrationState.Registered),
            failed = creationJobs.Count(x => x.State == RegistrationState.Failed),
            blocked = creationJobs.Count(x => x.State == RegistrationState.Blocked)
        }
    });
});

app.MapPost("/api/account-factory/replenish", async (
    ReplenishAccountsRequest request,
    ReplenishmentService service,
    CancellationToken ct) =>
{
    try
    {
        var result = await service.EnsureMinimumAsync(
            request.MinimumActive,
            request.BatchSize,
            request.Region,
            request.Provider,
            request.EmailProvider,
            ct);
        return Results.Ok(result);
    }
    catch (Exception ex) when (ex is ArgumentException or KeyNotFoundException)
    {
        return Results.BadRequest(new { error = ex.Message });
    }
});

app.MapGet("/api/account-factory/jobs/recent", (FarmState state, int? take) => Results.Ok(
    state.CreationJobs.Values
        .OrderByDescending(x => x.CompletedAt ?? DateTimeOffset.MinValue)
        .Take(Math.Clamp(take ?? 50, 1, 500))));

app.MapGet("/api/account-factory/identities/recent", (FarmState state, int? take) => Results.Ok(
    state.Identities.Values
        .OrderByDescending(x => x.CreatedAt)
        .Take(Math.Clamp(take ?? 50, 1, 500))));

app.MapPost("/api/accounts/generate", (GenerateAccountsRequest request, AccountFactory factory) =>
{
    try
    {
        var created = factory.Generate(request.Count);
        return Results.Ok(new { created = created.Count, sample = created.Take(5), mode = "DIRECT_SYNTHETIC_SEED" });
    }
    catch (ArgumentOutOfRangeException ex)
    {
        return Results.BadRequest(new { error = ex.Message });
    }
});

app.MapGet("/api/accounts/stats", (FarmState state) =>
{
    var accounts = state.Accounts.Values;
    return Results.Ok(new
    {
        total = accounts.Count,
        active = accounts.Count(x => x.Status == AccountStatus.Active),
        cooldown = accounts.Count(x => x.Status == AccountStatus.Cooldown),
        limited = accounts.Count(x => x.Status == AccountStatus.Limited),
        disabled = accounts.Count(x => x.Status == AccountStatus.Disabled),
        averageHealth = accounts.Count == 0 ? 0 : Math.Round(accounts.Average(x => x.HealthScore), 2),
        averageRisk = accounts.Count == 0 ? 0 : Math.Round(accounts.Average(x => x.RiskScore), 2),
        byProvider = accounts.GroupBy(x => x.ProviderKey).ToDictionary(x => x.Key, x => x.Count())
    });
});

app.MapPost("/api/campaigns", async (CreateCampaignRequest request, CampaignService service, CancellationToken ct) =>
{
    try
    {
        var campaign = await service.CreateAsync(
            request.Target,
            request.Quantity,
            request.StartingFollowers,
            request.Provider,
            ct);

        if (campaign.Status == CampaignStatus.Blocked)
            return Results.Ok(campaign);

        return Results.Accepted($"/api/campaigns/{campaign.Id}", campaign);
    }
    catch (Exception ex) when (ex is ArgumentException or InvalidOperationException or KeyNotFoundException)
    {
        return Results.BadRequest(new { error = ex.Message });
    }
});

app.MapGet("/api/campaigns/{id:guid}", (Guid id, FarmState state) =>
    state.Campaigns.TryGetValue(id, out var campaign)
        ? Results.Ok(new
        {
            campaign,
            jobs = state.Jobs.Values.Where(x => x.CampaignId == id)
                .GroupBy(x => x.Status)
                .ToDictionary(x => x.Key.ToString(), x => x.Count())
        })
        : Results.NotFound());

app.MapPost("/api/campaigns/{id:guid}/refill", async (Guid id, CampaignService service, CancellationToken ct) =>
{
    try
    {
        var created = await service.RefillAsync(id, ct);
        return Results.Ok(new { refillJobsCreated = created });
    }
    catch (KeyNotFoundException ex)
    {
        return Results.NotFound(new { error = ex.Message });
    }
    catch (InvalidOperationException ex)
    {
        return Results.BadRequest(new { error = ex.Message });
    }
});

app.MapGet("/api/targets/{providerKey}/{username}", (string providerKey, string username, FarmState state) =>
{
    username = username.TrimStart('@');
    var key = CampaignService.TargetKey(providerKey, username);
    return state.Targets.TryGetValue(key, out var target) ? Results.Ok(target) : Results.NotFound();
});

app.MapGet("/api/jobs/recent", (FarmState state, int? take) => Results.Ok(
    state.Jobs.Values.OrderByDescending(x => x.Id).Take(Math.Clamp(take ?? 50, 1, 500))));

app.Run();

public sealed record NormalizeTargetRequest(string Target);
