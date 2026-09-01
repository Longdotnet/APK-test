using Smm.Domain;

namespace Smm.Application;

public sealed class OrderService(
    IServiceRepository services,
    IOrderRepository orders,
    ITargetServiceClient targetService)
{
    public IReadOnlyCollection<Service> GetServices() => services.GetAll();

    public IReadOnlyCollection<SmmOrder> GetOrders() => orders.GetAll();

    public SmmOrder? GetOrder(Guid id) => orders.Get(id);

    public async Task<SmmOrder> CreateAsync(CreateOrderRequest request, CancellationToken cancellationToken)
    {
        var service = services.Get(request.ServiceId)
            ?? throw new InvalidOperationException("Service does not exist.");

        if (!service.IsActive)
        {
            throw new InvalidOperationException("Service is disabled.");
        }

        if (request.Quantity < service.MinQuantity || request.Quantity > service.MaxQuantity)
        {
            throw new ArgumentOutOfRangeException(nameof(request.Quantity),
                $"Quantity must be between {service.MinQuantity} and {service.MaxQuantity}.");
        }

        var handle = TargetParser.ParseTikTokHandle(request.Target);
        var profile = await targetService.GetProfileAsync(handle, cancellationToken);
        if (profile is null)
        {
            throw new InvalidOperationException(
                $"Target simulation profile @{handle} does not exist in the configured TargetService.");
        }

        var charge = Math.Round(request.Quantity / 1000m * service.PricePerThousand, 4);
        var order = new SmmOrder
        {
            ServiceId = service.Id,
            Target = request.Target.Trim(),
            TargetHandle = handle,
            Quantity = request.Quantity,
            Charge = charge
        };

        orders.Add(order);
        return order;
    }

    public async Task<SmmOrder> DeliverAsync(
        Guid id,
        DeliverOrderRequest request,
        CancellationToken cancellationToken)
    {
        var order = orders.Get(id) ?? throw new KeyNotFoundException("Order does not exist.");
        if (request.Quantity <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(request.Quantity), "Delivery quantity must be positive.");
        }

        var amount = Math.Min(request.Quantity, order.Remaining);
        if (amount == 0)
        {
            return order;
        }

        var operationId = $"order:{order.Id}:delivered:{order.Delivered}:amount:{amount}";
        await targetService.AddSimulatedFollowersAsync(
            order.TargetHandle,
            amount,
            operationId,
            cancellationToken);

        order.ApplyDelivery(amount);
        return order;
    }
}
