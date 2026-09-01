namespace Smm.Domain;

public sealed class SmmOrder
{
    public Guid Id { get; init; } = Guid.NewGuid();
    public required int ServiceId { get; init; }
    public required string Target { get; init; }
    public required string TargetHandle { get; init; }
    public required int Quantity { get; init; }
    public decimal Charge { get; init; }
    public int Delivered { get; private set; }
    public OrderStatus Status { get; private set; } = OrderStatus.Pending;
    public DateTimeOffset CreatedAt { get; init; } = DateTimeOffset.UtcNow;
    public DateTimeOffset? StartedAt { get; private set; }
    public DateTimeOffset? CompletedAt { get; private set; }

    public int Remaining => Math.Max(0, Quantity - Delivered);

    public void ApplyDelivery(int amount)
    {
        if (amount <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(amount));
        }

        if (Status is OrderStatus.Cancelled or OrderStatus.Failed or OrderStatus.Completed)
        {
            throw new InvalidOperationException($"Cannot deliver order in status {Status}.");
        }

        StartedAt ??= DateTimeOffset.UtcNow;
        Status = OrderStatus.Processing;
        Delivered = Math.Min(Quantity, Delivered + amount);

        if (Delivered >= Quantity)
        {
            Status = OrderStatus.Completed;
            CompletedAt = DateTimeOffset.UtcNow;
        }
    }
}
