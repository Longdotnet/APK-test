using FollowerFarmSimulator.Domain;
using FollowerFarmSimulator.Infrastructure;
using FollowerFarmSimulator.Providers;

namespace FollowerFarmSimulator.Workers;

public sealed class AccountCreationWorker(
    FarmState state,
    RegistrationProviderRouter registrationProviders,
    EmailProviderRouter emailProviders,
    IConfiguration configuration,
    ILogger<AccountCreationWorker> logger) : BackgroundService
{
    protected override Task ExecuteAsync(CancellationToken stoppingToken)
    {
        var configured = configuration["AccountFactory:Workers"];
        var workerCount = int.TryParse(configured, out var parsed) ? Math.Clamp(parsed, 1, 128) : 8;
        return Task.WhenAll(Enumerable.Range(1, workerCount).Select(id => RunWorkerAsync(id, stoppingToken)));
    }

    private async Task RunWorkerAsync(int workerId, CancellationToken ct)
    {
        await foreach (var job in state.CreationQueue.Reader.ReadAllAsync(ct))
        {
            if (!state.CreationCampaigns.TryGetValue(job.CampaignId, out var campaign) ||
                !state.Identities.TryGetValue(job.IdentityId, out var identity))
            {
                job.Status = JobStatus.Failed;
                job.State = RegistrationState.Failed;
                job.ResultCode = "CREATION_STATE_NOT_FOUND";
                job.CompletedAt = DateTimeOffset.UtcNow;
                continue;
            }

            job.Status = JobStatus.Running;
            job.Attempt++;

            IRegistrationProvider provider;
            IEmailProvider emailProvider;
            try
            {
                provider = registrationProviders.GetRequired(job.ProviderKey);
                emailProvider = emailProviders.GetRequired(job.EmailProviderKey);
            }
            catch (KeyNotFoundException)
            {
                Fail(job, campaign, "CREATION_PROVIDER_NOT_FOUND");
                continue;
            }

            if (!provider.SupportsAccountCreation)
            {
                job.State = RegistrationState.Blocked;
                job.Status = JobStatus.Failed;
                job.ResultCode = "PROVIDER_READ_ONLY";
                job.CompletedAt = DateTimeOffset.UtcNow;
                lock (campaign)
                {
                    campaign.Status = CreationCampaignStatus.Blocked;
                    campaign.BlockReason = $"Provider '{provider.Key}' is read-only.";
                }
                continue;
            }

            try
            {
                var mailbox = await emailProvider.CreateMailboxAsync(identity, ct);

                job.State = RegistrationState.RegistrationStarted;
                var start = await provider.BeginAsync(identity, mailbox, ct);
                if (!start.Accepted)
                {
                    Fail(job, campaign, start.Code);
                    continue;
                }

                VerificationArtifact verification;
                if (start.RequiresVerification)
                {
                    job.State = RegistrationState.WaitingVerification;
                    verification = await emailProvider.WaitForVerificationAsync(mailbox, ct);
                    if (!verification.Delivered)
                    {
                        Fail(job, campaign, verification.Code);
                        continue;
                    }
                    job.State = RegistrationState.VerificationReceived;
                }
                else
                {
                    verification = new VerificationArtifact(true, null, "NOT_REQUIRED");
                }

                var result = await provider.CompleteAsync(identity, mailbox, verification, ct);
                if (!result.Success)
                {
                    Fail(job, campaign, result.Code);
                    continue;
                }

                var now = DateTimeOffset.UtcNow;
                var account = new SimAccount
                {
                    Username = result.ExternalUsername ?? identity.UsernameSeed,
                    ProviderKey = provider.Key,
                    ExternalUsername = result.ExternalUsername,
                    Region = identity.Region,
                    PasswordReference = identity.PasswordReference,
                    SessionState = result.SessionState,
                    Status = AccountStatus.Active,
                    HealthScore = Math.Clamp(result.HealthScore, 0, 100),
                    RiskScore = Math.Clamp(result.RiskScore, 0, 100),
                    CreatedAt = now,
                    VerifiedAt = verification.Delivered ? now : null,
                    ActivatedAt = now,
                    LastHealthCheck = now
                };
                state.Accounts[account.Id] = account;

                job.AccountId = account.Id;
                job.State = RegistrationState.Registered;
                job.Status = JobStatus.Succeeded;
                job.ResultCode = result.Code;
                job.CompletedAt = now;

                lock (campaign)
                {
                    campaign.Created++;
                    UpdateCampaignStatus(campaign);
                }

                logger.LogDebug(
                    "AccountFactory worker {WorkerId}: provider={Provider} identity={IdentityId} result={Code}",
                    workerId,
                    provider.Key,
                    identity.Id,
                    result.Code);
            }
            catch (OperationCanceledException) when (ct.IsCancellationRequested)
            {
                throw;
            }
            catch (Exception ex)
            {
                logger.LogWarning(ex, "AccountFactory worker {WorkerId} failed job {JobId}", workerId, job.Id);
                Fail(job, campaign, "CREATION_PIPELINE_ERROR");
            }
        }
    }

    private void Fail(AccountCreationJob job, AccountCreationCampaign campaign, string code)
    {
        job.Status = JobStatus.Failed;
        job.State = RegistrationState.Failed;
        job.ResultCode = code;
        job.CompletedAt = DateTimeOffset.UtcNow;

        lock (campaign)
        {
            campaign.Failed++;
            UpdateCampaignStatus(campaign);
        }
    }

    private void UpdateCampaignStatus(AccountCreationCampaign campaign)
    {
        if (campaign.Status == CreationCampaignStatus.Blocked) return;
        if (campaign.Created >= campaign.Quantity)
        {
            campaign.Status = CreationCampaignStatus.Completed;
            return;
        }

        var outstanding = state.CreationJobs.Values.Any(x =>
            x.CampaignId == campaign.Id && x.Status is JobStatus.Queued or JobStatus.Running);
        campaign.Status = outstanding ? CreationCampaignStatus.Running : CreationCampaignStatus.Partial;
    }
}
