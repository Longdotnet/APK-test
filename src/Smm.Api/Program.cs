using Smm.Application;
using Smm.Infrastructure;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddSingleton<IServiceRepository, InMemoryServiceRepository>();
builder.Services.AddSingleton<IOrderRepository, InMemoryOrderRepository>();
builder.Services.AddScoped<OrderService>();

var fakeTikTokBaseUrl = builder.Configuration["FakeTikTok:BaseUrl"] ?? "http://localhost:5081";
builder.Services.AddHttpClient<IFakeTikTokClient, FakeTikTokClient>(client =>
{
    client.BaseAddress = new Uri(fakeTikTokBaseUrl);
    client.Timeout = TimeSpan.FromSeconds(10);
});

var app = builder.Build();

app.MapGet("/", () => Results.Ok(new
{
    name = "SMM Panel Simulator API",
    mode = "sandbox-only",
    warning = "This API never sends follower actions to TikTok. Targets are parsed as labels and delivered only to FakeTikTok.Api."
}));

app.MapGet("/health", () => Results.Ok(new { status = "ok" }));

app.MapGet("/api/services", (OrderService service) => Results.Ok(service.GetServices()));
app.MapGet("/api/orders", (OrderService service) => Results.Ok(service.GetOrders()));

app.MapGet("/api/orders/{id:guid}", (Guid id, OrderService service) =>
{
    var order = service.GetOrder(id);
    return order is null ? Results.NotFound() : Results.Ok(order);
});

app.MapPost("/api/orders", async (
    CreateOrderRequest request,
    OrderService service,
    CancellationToken cancellationToken) =>
{
    try
    {
        var order = await service.CreateAsync(request, cancellationToken);
        return Results.Created($"/api/orders/{order.Id}", order);
    }
    catch (Exception ex) when (ex is ArgumentException or InvalidOperationException)
    {
        return Results.BadRequest(new { error = ex.Message });
    }
});

app.MapPost("/api/orders/{id:guid}/deliver", async (
    Guid id,
    DeliverOrderRequest request,
    OrderService service,
    CancellationToken cancellationToken) =>
{
    try
    {
        var order = await service.DeliverAsync(id, request, cancellationToken);
        return Results.Ok(order);
    }
    catch (KeyNotFoundException)
    {
        return Results.NotFound();
    }
    catch (Exception ex) when (ex is ArgumentException or InvalidOperationException)
    {
        return Results.BadRequest(new { error = ex.Message });
    }
});

app.Run();
