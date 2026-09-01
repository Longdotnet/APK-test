using System.Collections.Concurrent;
using System.Threading.Channels;
using FollowerFarmSimulator.Domain;

namespace FollowerFarmSimulator.Infrastructure;

public sealed class FarmState
{
    public ConcurrentDictionary<Guid, SimAccount> Accounts { get; } = new();
    public ConcurrentDictionary<string, TargetProfile> Targets { get; } = new(StringComparer.OrdinalIgnoreCase);
    public ConcurrentDictionary<Guid, Campaign> Campaigns { get; } = new();
    public ConcurrentDictionary<Guid, FollowJob> Jobs { get; } = new();
    public Channel<FollowJob> Queue { get; } = Channel.CreateUnbounded<FollowJob>(new UnboundedChannelOptions
    {
        SingleReader = false,
        SingleWriter = false
    });
}
