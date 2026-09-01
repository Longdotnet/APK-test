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

/// <summary>
/// Contract implemented by a user-controlled simulation target service.
/// The SMM simulator never knows how the target stores data; it only calls
/// the explicit simulation endpoints below.
/// </summary>
public interface ITargetServiceClient
{
    Task<TargetProfileSnapshot?> GetProfileAsync(string handle, CancellationToken cancellationToken);
    Task<TargetProfileSnapshot> AddSimulatedFollowersAsync(
        string handle,
        int quantity,
        string operationId,
        CancellationToken cancellationToken);
}

public sealed record TargetProfileSnapshot(string Username, long FollowerCount);

public sealed record CreateOrderRequest(int ServiceId, string Target, int Quantity);

public sealed record DeliverOrderRequest(int Quantity);
