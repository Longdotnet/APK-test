using FollowerFarmSimulator.Domain;
using FollowerFarmSimulator.Infrastructure;
using FollowerFarmSimulator.Services;
using FollowerFarmSimulator.Workers;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddSingleton<FarmState>();
builder.Services.AddSingleton<AccountFactory>();
builder.Services.AddSingleton<CampaignService>();
builder.Services.AddSingleton<SimulatedProvider>();
builder.Services.AddSingleton<RiskEngine>();
builder.Services.AddHostedService<FollowWorker>();

var app = builder.Build();

app.MapGet("/", () => Results.Ok(new
{
    name = "Direct Follower Farm Simulator",
    mode = "LOCAL_SIMULATION_ONLY",
    warning = "No TikTok API, browser automation, credentials, proxy rotation, CAPTCHA or OTP bypass is implemented."
}));

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
        var campaign = await service.CreateAsync(request.Target, request.Quantity, request.StartingFollowers, ct);
        return Results.Accepted($"/api/campaigns/{campaign.Id}", campaign);
    }
    catch (Exception ex) when (ex is ArgumentException or InvalidOperationException)
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
});

app.MapGet("/api/targets/{username}", (string username, FarmState state) =>
{
    username = username.TrimStart('@');
    return state.Targets.TryGetValue(username, out var target) ? Results.Ok(target) : Results.NotFound();
});

app.MapGet("/api/jobs/recent", (FarmState state, int? take) => Results.Ok(
    state.Jobs.Values.OrderByDescending(x => x.Id).Take(Math.Clamp(take ?? 50, 1, 500))));

app.Run();
