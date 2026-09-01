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
builder.Services.AddHostedService<FollowWorker>();

var app = builder.Build();

app.MapGet("/", () => Results.Ok(new
{
    name = "Direct Follower Farm Research Simulator",
    mode = "PROVIDER_AWARE_RESEARCH_MODE",
    warning = "TikTok integration is target/read-only only. No TikTok login, account creation, private API, browser automation, fake-engagement mutation, proxy rotation, CAPTCHA or OTP bypass is implemented."
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

app.MapPost("/api/accounts/generate", (GenerateAccountsRequest request, AccountFactory factory) =>
{
    try
    {
        var created = factory.Generate(request.Count);
        return Results.Ok(new { created = created.Count, sample = created.Take(5) });
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
        averageRisk = accounts.Count == 0 ? 0 : Math.Round(accounts.Average(x => x.RiskScore), 2)
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
