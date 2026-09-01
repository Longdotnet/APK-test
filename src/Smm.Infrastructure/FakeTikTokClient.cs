using System.Net;
using System.Net.Http.Json;
using Smm.Application;

namespace Smm.Infrastructure;

public sealed class FakeTikTokClient(HttpClient httpClient) : IFakeTikTokClient
{
    public async Task<FakeProfileSnapshot?> GetProfileAsync(
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
        return await response.Content.ReadFromJsonAsync<FakeProfileSnapshot>(cancellationToken)
            ?? throw new InvalidOperationException("FakeTikTok returned an empty profile response.");
    }

    public async Task<FakeProfileSnapshot> AddFollowersAsync(
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
        return await response.Content.ReadFromJsonAsync<FakeProfileSnapshot>(cancellationToken)
            ?? throw new InvalidOperationException("FakeTikTok returned an empty delivery response.");
    }
}
