using Smm.Application;
using Smm.Infrastructure;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddSingleton<IServiceRepository, InMemoryServiceRepository>();
builder.Services.AddSingleton<IOrderRepository, InMemoryOrderRepository>();
builder.Services.AddScoped<OrderService>();

var targetServiceBaseUrl = builder.Configuration["TargetService:BaseUrl"] ?? "http://localhost:5081";
if (!Uri.TryCreate(targetServiceBaseUrl, UriKind.Absolute, out var targetServiceUri))
{
    throw new InvalidOperationException("TargetService:BaseUrl must be an absolute URL.");
}

builder.Services.AddHttpClient<ITargetServiceClient, TargetServiceClient>(client =>
{
    client.BaseAddress = targetServiceUri;
    client.Timeout = TimeSpan.FromSeconds(10);
});

var app = builder.Build();

app.MapGet("/", () => Results.Ok(new
{
    name = "SMM Panel Simulator API",
    mode = "simulation",
    targetService = targetServiceUri.ToString(),
    note = "Profile URLs are parsed as labels. Delivery calls only the configured TargetService simulation contract."
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
