using RobloxPiano.App;

namespace RobloxPiano.AudioUxTests;

internal static class AudioReviewDraftDiscoveryReadBudgetRegression
{
    private const int DiscoveryBudget = 256;

    internal static void Run()
        => RunAsync().GetAwaiter().GetResult();

    private static async Task RunAsync()
    {
        var root = Path.Combine(Path.GetTempPath(), "roblox-piano-audio-review-read-budget-" + Guid.NewGuid().ToString("N"));
        var drafts = Path.Combine(root, "drafts");
        Directory.CreateDirectory(drafts);
        var sourcePath = Path.Combine(root, "owned-audio.wav");
        await File.WriteAllBytesAsync(sourcePath, Enumerable.Range(0, 1024).Select(index => (byte)(index % 251)).ToArray()).ConfigureAwait(false);

        try
        {
            await VerifyIndexedLookupDoesNotNeedCheckpointJsonAsync(sourcePath, drafts).ConfigureAwait(false);
            ClearManagedDrafts(drafts);
            await VerifyFallbackIsBoundedAsync(sourcePath, drafts).ConfigureAwait(false);
            ClearManagedDrafts(drafts);
            await VerifyCorruptIndexFallsBackAndSelfHealsAsync(sourcePath, drafts).ConfigureAwait(false);
        }
        finally
        {
            try
            {
                Directory.Delete(root, recursive: true);
            }
            catch (IOException)
            {
            }
            catch (UnauthorizedAccessException)
            {
            }
        }
    }

    private static async Task VerifyIndexedLookupDoesNotNeedCheckpointJsonAsync(string sourcePath, string drafts)
    {
        var store = new AudioReviewDraftStore(drafts);
        var index = new AudioReviewDraftLookupIndex(store);
        var client = new AudioReviewDraftClientSession(store);
        var draftPath = store.GetDraftPath(new string('a', 64));
        await File.WriteAllTextAsync(draftPath, "{ definitely-not-a-review-document }").ConfigureAwait(false);
        index.Upsert(sourcePath, draftPath);

        Equal(
            Path.GetFullPath(draftPath),
            await client.FindAsync(sourcePath).ConfigureAwait(false),
            "indexed lookup must return a managed existing candidate without parsing checkpoint JSON");
    }

    private static async Task VerifyFallbackIsBoundedAsync(string sourcePath, string drafts)
    {
        var store = new AudioReviewDraftStore(drafts);
        var now = DateTime.UtcNow;

        for (var index = 0; index < DiscoveryBudget; index++)
        {
            var candidate = Path.Combine(drafts, $"{index:x64}.review.json");
            var unrelatedSource = Path.Combine(Path.GetDirectoryName(sourcePath)!, $"unrelated-{index}.wav");
            await File.WriteAllTextAsync(candidate, $"{{\"sourcePath\":{System.Text.Json.JsonSerializer.Serialize(unrelatedSource)}}}").ConfigureAwait(false);
            File.SetLastWriteTimeUtc(candidate, now.AddSeconds(-index));
        }

        var outsideBudget = Path.Combine(drafts, new string('f', 64) + ".review.json");
        await File.WriteAllTextAsync(outsideBudget, $"{{\"sourcePath\":{System.Text.Json.JsonSerializer.Serialize(Path.GetFullPath(sourcePath))}}}").ConfigureAwait(false);
        File.SetLastWriteTimeUtc(outsideBudget, now.AddHours(-2));

        Equal<string?>(
            null,
            await store.FindForSourceAsync(sourcePath).ConfigureAwait(false),
            "fallback discovery must not open a 257th checkpoint beyond the bounded 256-candidate budget");
    }

    private static async Task VerifyCorruptIndexFallsBackAndSelfHealsAsync(string sourcePath, string drafts)
    {
        var store = new AudioReviewDraftStore(drafts);
        var index = new AudioReviewDraftLookupIndex(store);
        var client = new AudioReviewDraftClientSession(store);
        var fallbackDraft = store.GetDraftPath(new string('b', 64));
        await File.WriteAllTextAsync(
            fallbackDraft,
            $"{{\"sourcePath\":{System.Text.Json.JsonSerializer.Serialize(Path.GetFullPath(sourcePath))}}}").ConfigureAwait(false);

        Directory.CreateDirectory(drafts);
        await File.WriteAllTextAsync(index.IndexPath, "{ corrupt-index }").ConfigureAwait(false);

        Equal(
            Path.GetFullPath(fallbackDraft),
            await client.FindAsync(sourcePath).ConfigureAwait(false),
            "corrupt disposable index must fall back to bounded authoritative discovery");

        await File.WriteAllTextAsync(fallbackDraft, "{ now-corrupt-checkpoint }").ConfigureAwait(false);
        Equal(
            Path.GetFullPath(fallbackDraft),
            await client.FindAsync(sourcePath).ConfigureAwait(false),
            "successful fallback must self-heal the index so the warm lookup no longer depends on checkpoint JSON parsing");
    }

    private static void ClearManagedDrafts(string drafts)
    {
        if (!Directory.Exists(drafts))
            return;
        foreach (var path in Directory.GetFiles(drafts, "*", SearchOption.TopDirectoryOnly))
            File.Delete(path);
    }

    private static void Equal<T>(T expected, T actual, string message)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"{message}: expected '{expected}', got '{actual}'");
    }
}
