using System.Collections.Concurrent;
using Smm.Application;
using Smm.Domain;

namespace Smm.Infrastructure;

public sealed class InMemoryServiceRepository : IServiceRepository
{
    private readonly IReadOnlyDictionary<int, Service> _services = new Dictionary<int, Service>
    {
        [1] = new()
        {
            Id = 1,
            Name = "TikTok Followers - Sandbox Standard",
            MinQuantity = 100,
            MaxQuantity = 100_000,
            PricePerThousand = 1.20m
        }
    };

    public IReadOnlyCollection<Service> GetAll() => _services.Values.ToArray();

    public Service? Get(int id) => _services.GetValueOrDefault(id);
}

public sealed class InMemoryOrderRepository : IOrderRepository
{
    private readonly ConcurrentDictionary<Guid, SmmOrder> _orders = new();

    public IReadOnlyCollection<SmmOrder> GetAll() => _orders.Values
        .OrderByDescending(x => x.CreatedAt)
        .ToArray();

    public SmmOrder? Get(Guid id) => _orders.GetValueOrDefault(id);

    public void Add(SmmOrder order)
    {
        if (!_orders.TryAdd(order.Id, order))
        {
            throw new InvalidOperationException("Order already exists.");
        }
    }
}
