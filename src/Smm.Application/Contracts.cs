using Smm.Domain;

namespace Smm.Application;

public interface IServiceRepository
{
    IReadOnlyCollection<Service> GetAll();
    Service? Get(int id);
}

public interface IOrderRepository
{
    IReadOnlyCollection<SmmOrder> GetAll();
    SmmOrder? Get(Guid id);
    void Add(SmmOrder order);
}

public interface IFakeTikTokClient
{
    Task<FakeProfileSnapshot?> GetProfileAsync(string handle, CancellationToken cancellationToken);
    Task<FakeProfileSnapshot> AddFollowersAsync(
        string handle,
        int quantity,
        string operationId,
        CancellationToken cancellationToken);
}

public sealed record FakeProfileSnapshot(string Username, long FollowerCount);

public sealed record CreateOrderRequest(int ServiceId, string Target, int Quantity);

public sealed record DeliverOrderRequest(int Quantity);
