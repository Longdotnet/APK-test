using RobloxPiano.App;

namespace RobloxPiano.AudioUxTests;

internal static class AudioReviewDraftLookupIndexRegression
{
    internal static void Run()
    {
        var root = Path.Combine(Path.GetTempPath(), "roblox-piano-audio-review-index-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(root);
        try
        {
            var store = new AudioReviewDraftStore(Path.Combine(root, "drafts"));
            var index = new AudioReviewDraftLookupIndex(store);
            var sourcePath = Path.Combine(root, "owned-song.wav");
            File.WriteAllBytes(sourcePath, [1, 2, 3, 4]);

            var firstSha = new string('a', 64);
            var firstDraft = store.GetDraftPath(firstSha);
            Directory.CreateDirectory(Path.GetDirectoryName(firstDraft)!);
            File.WriteAllText(firstDraft, "{}");

            Equal<string?>(null, index.TryResolve(sourcePath), "empty index must miss");
            index.Upsert(sourcePath, firstDraft);
            Equal(Path.GetFullPath(firstDraft), index.TryResolve(sourcePath), "indexed source path must resolve in O(1) without reading checkpoint content");
            True(File.Exists(index.IndexPath), "lookup index must be persisted beside managed drafts");
            var persisted = File.ReadAllText(index.IndexPath);
            True(!persisted.Contains(Path.GetFullPath(sourcePath), StringComparison.OrdinalIgnoreCase), "lookup index must not persist raw client source paths");
            True(persisted.Contains(AudioReviewDraftLookupIndex.ComputeSourcePathKey(sourcePath), StringComparison.Ordinal), "lookup index must persist only a one-way source-path key");

            File.Delete(firstDraft);
            Equal<string?>(null, index.TryResolve(sourcePath), "missing managed draft must invalidate a stale index hit");

            var secondSha = new string('b', 64);
            var secondDraft = store.GetDraftPath(secondSha);
            File.WriteAllText(secondDraft, "{}");
            File.WriteAllText(index.IndexPath, "{ definitely-not-json");
            Equal<string?>(null, index.TryResolve(sourcePath), "corrupt index must be disposable rather than trusted");
            index.Upsert(sourcePath, secondDraft);
            Equal(Path.GetFullPath(secondDraft), index.TryResolve(sourcePath), "upsert after corruption must rebuild the requested authoritative mapping");

            var externalDraft = Path.Combine(root, new string('c', 64) + ".review.json");
            File.WriteAllText(externalDraft, "{}");
            Throws<InvalidDataException>(
                () => index.Upsert(sourcePath, externalDraft),
                "index must reject a checkpoint outside the managed review directory");

            index.RemoveDraft(secondDraft);
            Equal<string?>(null, index.TryResolve(sourcePath), "explicit draft deletion must remove the corresponding index entry");
            True(!File.Exists(index.IndexPath), "empty lookup index should be removed instead of leaving stale metadata");

            var client = new AudioReviewDraftClientSession(store);
            File.WriteAllText(secondDraft, "{}");
            index.Upsert(sourcePath, secondDraft);
            Equal(Path.GetFullPath(secondDraft), client.FindAsync(sourcePath).GetAwaiter().GetResult(), "client discovery must consume the persisted accelerator");
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

    private static void Equal<T>(T expected, T actual, string message)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"{message}: expected '{expected}', got '{actual}'");
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
    }

    private static void Throws<TException>(Action action, string message)
        where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }
        throw new InvalidOperationException(message);
    }
}
