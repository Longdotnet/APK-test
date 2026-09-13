using RobloxPiano.App;

namespace RobloxPiano.AudioUxTests;

internal static class AudioReviewDraftStorageLeaseRegression
{
    public static void Run()
    {
        var root = Path.Combine(Path.GetTempPath(), "roblox-piano-audio-lease-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(root);
        try
        {
            if (!AudioReviewDraftStorageLease.TryAcquire(root, TimeSpan.Zero, out var writerLease) || writerLease is null)
                throw new InvalidOperationException("first writer lease was not acquired");

            using (writerLease)
            {
                if (AudioReviewDraftStorageLease.TryAcquire(root, TimeSpan.FromMilliseconds(50), out var competingLease))
                {
                    competingLease?.Dispose();
                    throw new InvalidOperationException("competing process-style lease acquired while writer owned storage");
                }

                var evidencePath = Path.Combine(root, new string('a', 64) + ".evidence.json");
                File.WriteAllText(evidencePath, "{}");
                File.SetLastWriteTimeUtc(evidencePath, DateTime.UtcNow - AudioReviewDraftStorageMaintenance.OrphanEvidenceGrace - TimeSpan.FromHours(1));

                var blocked = AudioReviewDraftStorageMaintenance.RunBestEffort(root, DateTimeOffset.UtcNow);
                if (!blocked.EvidenceGcSkipped)
                    throw new InvalidOperationException("destructive GC did not fail safe while writer lease was owned");
                if (blocked.DeletedOrphanEvidenceCount != 0 || !File.Exists(evidencePath))
                    throw new InvalidOperationException("destructive GC deleted evidence while writer lease was owned");
            }

            if (!AudioReviewDraftStorageLease.TryAcquire(root, TimeSpan.FromMilliseconds(250), out var recoveredLease) || recoveredLease is null)
                throw new InvalidOperationException("lease did not recover after owner handle release");
            recoveredLease.Dispose();

            var stable = AudioReviewDraftStorageMaintenance.RunBestEffort(root, DateTimeOffset.UtcNow);
            if (stable.EvidenceGcSkipped)
                throw new InvalidOperationException("stable destructive GC remained blocked after lease release");
            if (stable.DeletedOrphanEvidenceCount != 1)
                throw new InvalidOperationException($"expected one orphan evidence deletion after lease release, got {stable.DeletedOrphanEvidenceCount}");

            var oldEvidence = Directory.EnumerateFiles(root, "*.evidence.json", SearchOption.TopDirectoryOnly).SingleOrDefault();
            if (oldEvidence is not null)
                throw new InvalidOperationException("orphan evidence survived stable leased cleanup");

            var sentinel = Path.Combine(root, AudioReviewDraftStorageLease.FileName);
            if (!File.Exists(sentinel))
                throw new InvalidOperationException("lease sentinel should remain as stateless coordination artifact");
        }
        finally
        {
            try { Directory.Delete(root, recursive: true); } catch { }
        }
    }
}
