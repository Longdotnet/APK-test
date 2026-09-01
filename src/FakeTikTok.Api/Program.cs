using System.Collections.Concurrent;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddSingleton<FakeTikTokStore>();

var app = builder.Build();

app.MapGet("/", () => Results.Ok(new
{
    name = "FakeTikTok Sandbox API",
    mode = "local-simulation",
    externalNetworkActions = false
}));

app.MapGet("/health", () => Results.Ok(new { status = "ok" }));

app.MapGet("/api/profiles", (FakeTikTokStore store) => Results.Ok(store.GetAll()));

app.MapGet("/api/profiles/{username}", (string username, FakeTikTokStore store) =>
{
    var profile = store.Get(username);
    return profile is null ? Results.NotFound() : Results.Ok(profile);
});

app.MapPost("/api/profiles", (CreateProfileRequest request, FakeTikTokStore store) =>
{
    try
    {
        return Results.Created($"/api/profiles/{request.Username}", store.Create(request.Username, request.FollowerCount));
    }
    catch (InvalidOperationException ex)
    {
        return Results.Conflict(new { error = ex.Message });
    }
});

app.MapPost("/api/profiles/{username}/followers/simulate", (
    string username,
    SimulateFollowersRequest request,
    FakeTikTokStore store) =>
{
    if (request.Quantity <= 0)
    {
        return Results.BadRequest(new { error = "Quantity must be positive." });
    }

    if (string.IsNullOrWhiteSpace(request.OperationId))
    {
        return Results.BadRequest(new { error = "OperationId is required for idempotency." });
    }

    var profile = store.AddFollowers(username, request.Quantity, request.OperationId);
    return profile is null ? Results.NotFound() : Results.Ok(profile);
});

app.Run();

internal sealed class FakeTikTokStore
{
    private readonly ConcurrentDictionary<string, long> _followers = new(StringComparer.OrdinalIgnoreCase);
    private readonly ConcurrentDictionary<string, byte> _operations = new(StringComparer.Ordinal);

    public FakeTikTokStore()
    {
        _followers["longgmilk"] = 0;
    }

    public IReadOnlyCollection<FakeProfileSnapshot> GetAll() => _followers
        .OrderBy(x => x.Key)
        .Select(x => new FakeProfileSnapshot(x.Key, x.Value))
        .ToArray();

    public FakeProfileSnapshot? Get(string username)
    {
        var handle = Normalize(username);
        return _followers.TryGetValue(handle, out var count)
            ? new FakeProfileSnapshot(handle, count)
            : null;
    }

    public FakeProfileSnapshot Create(string username, long followerCount)
    {
        var handle = Normalize(username);
        if (!_followers.TryAdd(handle, Math.Max(0, followerCount)))
        {
            throw new InvalidOperationException($"Profile @{handle} already exists.");
        }

        return new FakeProfileSnapshot(handle, _followers[handle]);
    }

    public FakeProfileSnapshot? AddFollowers(string username, int quantity, string operationId)
    {
        var handle = Normalize(username);
        if (!_followers.ContainsKey(handle))
        {
            return null;
        }

        if (_operations.TryAdd(operationId, 0))
        {
            _followers.AddOrUpdate(handle, quantity, (_, current) => checked(current + quantity));
        }

        return new FakeProfileSnapshot(handle, _followers[handle]);
    }

    private static string Normalize(string username) => username.Trim().TrimStart('@');
}

internal sealed record CreateProfileRequest(string Username, long FollowerCount = 0);
internal sealed record SimulateFollowersRequest(int Quantity, string OperationId);
internal sealed record FakeProfileSnapshot(string Username, long FollowerCount);
