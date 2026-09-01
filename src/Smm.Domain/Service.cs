namespace Smm.Domain;

public sealed class Service
{
    public required int Id { get; init; }
    public required string Name { get; init; }
    public int MinQuantity { get; init; }
    public int MaxQuantity { get; init; }
    public decimal PricePerThousand { get; init; }
    public bool IsActive { get; init; } = true;
}
