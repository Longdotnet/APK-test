using System.Runtime.CompilerServices;
using RobloxPiano.App;
using RobloxPiano.Audio;
using RobloxPiano.Core;

namespace RobloxPiano.AudioUxTests;

internal static class AudioReviewDraftStoreRegression
{
    [ModuleInitializer]
    internal static void Run()
        => RunAsync().GetAwaiter().GetResult();

    private static async Task RunAsync()
    {
        var root = Path.Combine(Path.GetTempPath(), "roblox-piano-audio-review-draft-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(root);
        var sourcePath = Path.Combine(root, "owned-audio.wav");
        await File.WriteAllBytesAsync(sourcePath, Enumerable.Range(0, 4096).Select(index => (byte)(index % 251)).ToArray());

        try
        {
            var notes = Enumerable.Range(0, 12)
                .Select(index => new BasicPitchTranscribedNote(
                    TimeSpan.FromMilliseconds(index * 300),
                    TimeSpan.FromMilliseconds((index * 300) + 220),
                    60 + (index % 5),
                    0.80f))
                .ToArray();
            var originalTrack = new PerformanceTrack(
                "Draft regression",
                120d,
                4,
                TimeSpan.Zero,
                [new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(400), ['a'])],
                TimeSpan.FromSeconds(5));
            var baseQuality = new AudioTranscriptionQualityAssessment(
                AudioTranscriptionReadiness.NeedsReview,
                0.25,
                0.75,
                0.0,
                0.0,
                0.80,
                0.20,
                0.0,
                0.80f,
                ["RETENTION_LOW"]);
            var session = new AudioTranscriptionReviewRepairSession(
                TimeSpan.FromSeconds(5),
                notes,
                originalTrack,
                baseQuality: baseQuality);
            True(session.ReviewRegions.Count > 0, "fixture must expose a review region");

            var queue = new AudioReviewQueue();
            queue.Synchronize(session.ReviewRegions);
            var appliedRegion = session.ReviewRegions[0];
            var candidates = session.GetCandidates(appliedRegion);
            True(candidates.Count > 0, "fixture must expose a deterministic repair candidate");
            var applied = session.Apply(appliedRegion, candidates[0].Kind);
            queue.RecordApplied(appliedRegion, candidates[0].Kind, applied.Revision);
            queue.Synchronize(session.ReviewRegions);
            AudioTranscriptionReviewRegion? selected = null;
            if (session.ReviewRegions.Count > 0)
            {
                selected = session.ReviewRegions[0];
                queue.Defer(session.ReviewRegions, selected);
            }

            var expectedFingerprint = PerformanceTrackFingerprint.ComputeSha256(session.CurrentTrack);
            var store = new AudioReviewDraftStore(Path.Combine(root, "drafts"));
            var draftPath = await store.SaveAsync(
                sourcePath,
                TimeSpan.FromSeconds(5),
                notes,
                originalTrack,
                baseQuality,
                session,
                queue,
                selected);

            True(File.Exists(draftPath), "checkpoint must be committed to its final path");
            Equal(0, Directory.GetFiles(Path.GetDirectoryName(draftPath)!, "*.tmp-*", SearchOption.TopDirectoryOnly).Length, "atomic temp files must be cleaned");

            var restored = await store.RestoreAsync(draftPath);
            Equal(expectedFingerprint, PerformanceTrackFingerprint.ComputeSha256(restored.RepairSession.CurrentTrack), "restored canonical fingerprint");
            Equal(1, restored.ReviewQueue.AppliedDecisionCount, "applied decision history");
            Equal(Path.GetFullPath(sourcePath), restored.SourcePath, "source path");
            if (restored.RepairSession.ReviewRegions.Count > 0)
                True(restored.SelectedRegionIndex >= 0 && restored.SelectedRegionIndex < restored.RepairSession.ReviewRegions.Count, "selected region must be bounded");

            await File.AppendAllTextAsync(sourcePath, "changed");
            await ThrowsAsync<InvalidDataException>(
                () => store.RestoreAsync(draftPath),
                "changed source audio must fail closed");
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

    private static async Task ThrowsAsync<TException>(Func<Task> action, string label)
        where TException : Exception
    {
        try
        {
            await action();
        }
        catch (TException)
        {
            return;
        }
        throw new InvalidOperationException(label);
    }

    private static void Equal<T>(T expected, T actual, string label)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"{label}: expected '{expected}', actual '{actual}'");
    }

    private static void True(bool value, string label)
    {
        if (!value)
            throw new InvalidOperationException(label);
    }
}
