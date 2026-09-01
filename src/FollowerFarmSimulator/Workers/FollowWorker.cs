using FollowerFarmSimulator.Domain;
using FollowerFarmSimulator.Infrastructure;
using FollowerFarmSimulator.Providers;
using FollowerFarmSimulator.Services;

namespace FollowerFarmSimulator.Workers;

public sealed class FollowWorker(
    FarmState state,
    ProviderRouter providers,
    RiskEngine riskEngine,
    ILogger<FollowWorker> logger) : BackgroundService
{
    private const int WorkerCount = 8;

    protected override Task ExecuteAsync(CancellationToken stoppingToken) =>
        Task.WhenAll(Enumerable.Range(1, WorkerCount).Select(id => RunWorkerAsync(id, stoppingToken)));

    private async Task RunWorkerAsync(int workerId, CancellationToken ct)
    {
        await foreach (var job in state.Queue.Reader.ReadAllAsync(ct))
        {
            job.Status = JobStatus.Running;

            if (!state.Accounts.TryGetValue(job.AccountId, out var account) ||
                !state.Campaigns.TryGetValue(job.CampaignId, out var campaign) ||
                !state.Targets.TryGetValue(CampaignService.TargetKey(job.ProviderKey, job.TargetUsername), out var target))
            {
                job.Status = JobStatus.Failed;
                job.ResultCode = "STATE_NOT_FOUND";
                continue;
            }

            ISocialProvider provider;
            try
            {
                provider = providers.GetRequired(job.ProviderKey);
            }
            catch (KeyNotFoundException)
            {
                job.Status = JobStatus.Failed;
                job.ResultCode = "PROVIDER_NOT_FOUND";
                continue;
            }

            if (!provider.SupportsMutatingEngagement)
            {
                job.Status = JobStatus.Failed;
                job.ResultCode = "PROVIDER_READ_ONLY";
                campaign.Status = CampaignStatus.Blocked;
                campaign.BlockReason = $"Provider '{provider.Key}' is read-only.";
                continue;
            }

            await Task.Delay(Random.Shared.Next(20, 90), ct); // synthetic execution latency
            var result = await provider.FollowAsync(account, target, ct);
            riskEngine.Apply(account, result);
            job.ResultCode = result.Code;

            lock (campaign)
            {
                if (result.Success)
                {
                    job.Status = JobStatus.Succeeded;
                    campaign.Delivered++;
                    lock (target) target.Followers++;
                }
                else
                {
                    job.Status = JobStatus.Failed;
                    campaign.Failed++;
                }

                if (campaign.Delivered >= campaign.Quantity)
                    campaign.Status = CampaignStatus.Completed;
                else
                {
                    var outstanding = state.Jobs.Values.Any(x => x.CampaignId == campaign.Id && x.Status is JobStatus.Queued or JobStatus.Running);
                    campaign.Status = outstanding ? CampaignStatus.Running : CampaignStatus.Partial;
                }
            }

            logger.LogDebug(
                "Worker {WorkerId}: provider={Provider} account={Account} target={Target}: {Code}",
                workerId,
                provider.Key,
                account.Username,
                target.CanonicalTarget,
                result.Code);
        }
    }
}
