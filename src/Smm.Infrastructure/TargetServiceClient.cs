using System.Net;
using System.Net.Http.Json;
using Smm.Application;

namespace Smm.Infrastructure;

/// <summary>
/// HTTP adapter for a user-controlled simulation service.
/// Expected contract:
/// GET  /api/profiles/{handle}
/// POST /api/profiles/{handle}/followers/simulate
/// </summary>
public sealed class TargetServiceClient(HttpClient httpClient) : ITargetServiceClient
{
    public async Task<TargetProfileSnapshot?> GetProfileAsync(
        string handle,
        CancellationToken cancellationToken)
    {
        using var response = await httpClient.GetAsync(
            $"/api/profiles/{Uri.EscapeDataString(handle)}",
            cancellationToken);

        if (response.StatusCode == HttpStatusCode.NotFound)
        {
            return null;
        }

        response.EnsureSuccessStatusCode();
        return await response.Content.ReadFromJsonAsync<TargetProfileSnapshot>(cancellationToken)
            ?? throw new InvalidOperationException("TargetService returned an empty profile response.");
    }

    public async Task<TargetProfileSnapshot> AddSimulatedFollowersAsync(
        string handle,
        int quantity,
        string operationId,
        CancellationToken cancellationToken)
    {
        using var response = await httpClient.PostAsJsonAsync(
            $"/api/profiles/{Uri.EscapeDataString(handle)}/followers/simulate",
            new { quantity, operationId },
            cancellationToken);

        response.EnsureSuccessStatusCode();
        return await response.Content.ReadFromJsonAsync<TargetProfileSnapshot>(cancellationToken)
            ?? throw new InvalidOperationException("TargetService returned an empty delivery response.");
    }
}
