using RobloxPiano.App;
using RobloxPiano.Audio;
using RobloxPiano.Core;

namespace RobloxPiano.AudioUxTests;

internal static class AudioReviewDraftWriteAmplificationRegression
{
    private const int NoteCount = 12_000;
    private const int EventCount = 4_000;
    private const int RepeatedCheckpointCount = 24;
    private const long MaximumMutableCheckpointBytes = 16 * 1024;

    internal static void Run()
        => RunAsync().GetAwaiter().GetResult();

    private static async Task RunAsync()
    {
        var root = Path.Combine(Path.GetTempPath(), "roblox-piano-audio-review-write-budget-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(root);
        var sourcePath = Path.Combine(root, "long-owned-audio.wav");
        var sourceBytes = new byte[1024 * 1024];
        for (var index = 0; index < sourceBytes.Length; index++)
            sourceBytes[index] = (byte)(index % 251);
        await File.WriteAllBytesAsync(sourcePath, sourceBytes).ConfigureAwait(false);

        try
        {
            var duration = TimeSpan.FromMinutes(10);
            var notes = Enumerable.Range(0, NoteCount)
                .Select(index => new BasicPitchTranscribedNote(
                    TimeSpan.FromMilliseconds(index * 40),
                    TimeSpan.FromMilliseconds((index * 40) + 120),
                    48 + (index % 25),
                    0.72f + ((index % 5) * 0.02f)))
                .ToArray();
            var events = Enumerable.Range(0, EventCount)
                .Select(index => new PerformanceEvent(
                    TimeSpan.FromMilliseconds(index * 100),
                    TimeSpan.FromMilliseconds(80),
                    [(char)('a' + (index % 10))]))
                .ToArray();
            var originalTrack = new PerformanceTrack(
                "Long-song write budget",
                120d,
                4,
                TimeSpan.Zero,
                events,
                duration);
            var baseQuality = new AudioTranscriptionQualityAssessment(
                AudioTranscriptionReadiness.NeedsReview,
                0.42,
                0.31,
                0.03,
                0.04,
                0.88,
                20.0,
                0.06,
                0.74f,
                ["EVENT_DENSITY_HIGH"]);
            var session = new AudioTranscriptionReviewRepairSession(
                duration,
                notes,
                originalTrack,
                baseQuality: baseQuality);
            var queue = new AudioReviewQueue();
            queue.Synchronize(session.ReviewRegions);
            var store = new AudioReviewDraftStore(Path.Combine(root, "drafts"));
            var evidenceSha256 = AudioReviewDraftStore.ComputeEvidenceSha256(duration, notes, originalTrack, baseQuality);
            var evidencePath = store.GetEvidencePath(evidenceSha256);

            var draftPath = await store.SaveAsync(
                sourcePath,
                duration,
                notes,
                originalTrack,
                baseQuality,
                session,
                queue).ConfigureAwait(false);

            Equal(1L, store.EvidenceSnapshotWriteCount, "initial long-song checkpoint must write immutable evidence once");
            var evidenceBytes = new FileInfo(evidencePath).Length;
            var firstCheckpointBytes = new FileInfo(draftPath).Length;
            True(evidenceBytes > 512 * 1024, "fixture must exercise a materially large immutable evidence snapshot");
            True(firstCheckpointBytes <= MaximumMutableCheckpointBytes, "mutable checkpoint must remain compact for long-song evidence");
            True(firstCheckpointBytes * 32 < evidenceBytes, "mutable checkpoint must be at least 32x smaller than immutable evidence");
            var evidenceWriteTime = File.GetLastWriteTimeUtc(evidencePath);

            var logicalCheckpointBytesWritten = firstCheckpointBytes;
            var checkpointWrites = 1;

            if (session.ReviewRegions.Count > 0)
            {
                var firstRegion = session.ReviewRegions[0];
                var candidates = session.GetCandidates(firstRegion);
                if (candidates.Count > 0)
                {
                    var applied = session.Apply(firstRegion, candidates[0].Kind);
                    queue.RecordApplied(firstRegion, candidates[0].Kind, applied.Revision);
                    queue.Synchronize(session.ReviewRegions);
                    draftPath = await store.SaveAsync(
                        sourcePath,
                        duration,
                        notes,
                        originalTrack,
                        baseQuality,
                        session,
                        queue,
                        session.ReviewRegions.Count == 0 ? null : session.ReviewRegions[0]).ConfigureAwait(false);
                    logicalCheckpointBytesWritten += new FileInfo(draftPath).Length;
                    checkpointWrites++;
                }
            }

            for (var iteration = 0; iteration < RepeatedCheckpointCount; iteration++)
            {
                AudioTranscriptionReviewRegion? selected = null;
                if (session.ReviewRegions.Count > 0)
                {
                    selected = session.ReviewRegions[iteration % session.ReviewRegions.Count];
                    if ((iteration & 1) == 0)
                        queue.Defer(session.ReviewRegions, selected);
                    else
                        queue.Resume(selected);
                }

                draftPath = await store.SaveAsync(
                    sourcePath,
                    duration,
                    notes,
                    originalTrack,
                    baseQuality,
                    session,
                    queue,
                    selected).ConfigureAwait(false);
                var checkpointBytes = new FileInfo(draftPath).Length;
                True(checkpointBytes <= MaximumMutableCheckpointBytes, $"mutable checkpoint {iteration + 1} exceeded byte budget");
                logicalCheckpointBytesWritten += checkpointBytes;
                checkpointWrites++;
            }

            Equal(1L, store.EvidenceSnapshotWriteCount, "repeated long-song review decisions must never rewrite immutable evidence");
            Equal(evidenceWriteTime, File.GetLastWriteTimeUtc(evidencePath), "immutable evidence timestamp must remain stable across long-song review decisions");

            var inlineRewriteBaseline = evidenceBytes * checkpointWrites;
            True(
                logicalCheckpointBytesWritten * 8 < inlineRewriteBaseline,
                $"compact checkpoints must reduce logical persistence bytes by at least 8x; compact={logicalCheckpointBytesWritten}, inlineBaseline={inlineRewriteBaseline}");
            True(
                logicalCheckpointBytesWritten < evidenceBytes,
                $"all mutable checkpoints combined must write less than one immutable snapshot; checkpoints={logicalCheckpointBytesWritten}, evidence={evidenceBytes}");
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
