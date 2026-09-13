using System.Security.Cryptography;
using System.Text.Json;
using RobloxPiano.App;
using RobloxPiano.Audio;
using RobloxPiano.Core;

namespace RobloxPiano.AudioUxTests;

internal static class AudioReviewDraftStoreRegression
{
    internal static void Run()
        => RunAsync().GetAwaiter().GetResult();

    private static async Task RunAsync()
    {
        var root = Path.Combine(Path.GetTempPath(), "roblox-piano-audio-review-draft-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(root);
        var sourcePath = Path.Combine(root, "owned-audio.wav");
        var originalSourceBytes = Enumerable.Range(0, 4096).Select(index => (byte)(index % 251)).ToArray();
        await File.WriteAllBytesAsync(sourcePath, originalSourceBytes).ConfigureAwait(false);

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
            var evidenceSha256 = AudioReviewDraftStore.ComputeEvidenceSha256(
                TimeSpan.FromSeconds(5),
                notes,
                originalTrack,
                baseQuality);
            var evidencePath = store.GetEvidencePath(evidenceSha256);
            var draftPath = await store.SaveAsync(
                sourcePath,
                TimeSpan.FromSeconds(5),
                notes,
                originalTrack,
                baseQuality,
                session,
                queue,
                selected).ConfigureAwait(false);

            Equal(1L, store.SourceHashComputationCount, "first checkpoint must establish one verified source hash");
            Equal(1L, store.EvidenceSnapshotWriteCount, "first checkpoint must write immutable evidence exactly once");
            True(File.Exists(evidencePath), "content-addressed immutable evidence snapshot must exist");
            True(new FileInfo(draftPath).Length < new FileInfo(evidencePath).Length, "mutable checkpoint must be smaller than immutable evidence for the regression fixture");
            var evidenceWriteTime = File.GetLastWriteTimeUtc(evidencePath);

            var repeatedDraftPath = await store.SaveAsync(
                sourcePath,
                TimeSpan.FromSeconds(5),
                notes,
                originalTrack,
                baseQuality,
                session,
                queue,
                selected).ConfigureAwait(false);
            Equal(draftPath, repeatedDraftPath, "unchanged-source checkpoint path");
            Equal(1L, store.SourceHashComputationCount, "unchanged metadata must reuse the verified source identity without re-reading the full audio");
            Equal(1L, store.EvidenceSnapshotWriteCount, "repeated checkpoint must not rewrite immutable evidence");
            Equal(evidenceWriteTime, File.GetLastWriteTimeUtc(evidencePath), "immutable evidence write timestamp must remain stable across mutable checkpoints");

            var touchedTime = File.GetLastWriteTimeUtc(sourcePath).AddSeconds(2);
            File.SetLastWriteTimeUtc(sourcePath, touchedTime);
            var touchedDraftPath = await store.SaveAsync(
                sourcePath,
                TimeSpan.FromSeconds(5),
                notes,
                originalTrack,
                baseQuality,
                session,
                queue,
                selected).ConfigureAwait(false);
            Equal(draftPath, touchedDraftPath, "metadata-only source change with identical bytes must keep the content-addressed draft path");
            Equal(2L, store.SourceHashComputationCount, "metadata change must force one full source re-verification");
            Equal(1L, store.EvidenceSnapshotWriteCount, "source metadata change must not rewrite unchanged immutable evidence");

            await File.AppendAllTextAsync(sourcePath, "changed-before-checkpoint").ConfigureAwait(false);
            await ThrowsAsyncContaining<InvalidDataException>(
                () => store.SaveAsync(
                    sourcePath,
                    TimeSpan.FromSeconds(5),
                    notes,
                    originalTrack,
                    baseQuality,
                    session,
                    queue,
                    selected),
                "source audio changed",
                "checkpoint must fail closed when bytes changed after the cached identity was established").ConfigureAwait(false);
            Equal(3L, store.SourceHashComputationCount, "changed metadata must rehash before rejecting stale review state");
            await File.WriteAllBytesAsync(sourcePath, originalSourceBytes).ConfigureAwait(false);

            True(File.Exists(draftPath), "checkpoint must be committed to its final path");
            Equal(0, Directory.GetFiles(Path.GetDirectoryName(draftPath)!, "*.tmp-*", SearchOption.TopDirectoryOnly).Length, "atomic temp files must be cleaned");
            Equal(draftPath, await store.FindForSourceAsync(sourcePath).ConfigureAwait(false), "exact source lookup must find the saved draft");

            var evidenceBackupPath = evidencePath + ".backup";
            File.Move(evidencePath, evidenceBackupPath);
            await ThrowsAsyncContaining<InvalidDataException>(
                () => store.RestoreAsync(draftPath),
                "evidence snapshot is missing",
                "schema v2 restore must fail closed when immutable content-addressed evidence is missing").ConfigureAwait(false);
            File.Move(evidenceBackupPath, evidencePath);

            var hashCountBeforeRestore = store.SourceHashComputationCount;
            var restored = await store.RestoreAsync(draftPath).ConfigureAwait(false);
            Equal(hashCountBeforeRestore + 1, store.SourceHashComputationCount, "Resume must always full-hash the owned/local audio even when metadata matches the cache");
            Equal(expectedFingerprint, PerformanceTrackFingerprint.ComputeSha256(restored.RepairSession.CurrentTrack), "restored canonical fingerprint");
            Equal(1, restored.ReviewQueue.AppliedDecisionCount, "applied decision history");
            Equal(Path.GetFullPath(sourcePath), restored.SourcePath, "source path");
            Equal(TimeSpan.FromSeconds(5), restored.SourceDuration, "source duration persistence context");
            Equal(notes.Length, restored.SourceNotes.Count, "note evidence persistence context");
            Equal(PerformanceTrackFingerprint.ComputeSha256(originalTrack), PerformanceTrackFingerprint.ComputeSha256(restored.OriginalTrack), "original canonical track persistence context");
            Equal(baseQuality.Readiness, restored.BaseQuality.Readiness, "base quality persistence context");
            Equal(Path.GetFullPath(draftPath), restored.DraftPath, "managed draft path");
            if (restored.RepairSession.ReviewRegions.Count > 0)
                True(restored.SelectedRegionIndex >= 0 && restored.SelectedRegionIndex < restored.RepairSession.ReviewRegions.Count, "selected region must be bounded");

            var clientSession = new AudioReviewDraftClientSession(store);
            var clientRestored = await clientSession.RestoreAsync(draftPath).ConfigureAwait(false);
            True(clientSession.CanCheckpoint, "client session must recover immutable checkpoint context without inference");
            Equal(expectedFingerprint, PerformanceTrackFingerprint.ComputeSha256(clientRestored.RepairSession.CurrentTrack), "client restore canonical fingerprint");
            var hashesAfterClientRestore = store.SourceHashComputationCount;
            var checkpointAgain = await clientSession.CheckpointAsync(
                clientRestored.RepairSession,
                clientRestored.ReviewQueue,
                clientRestored.RepairSession.ReviewRegions.Count == 0 ? null : clientRestored.RepairSession.ReviewRegions[clientRestored.SelectedRegionIndex]).ConfigureAwait(false);
            Equal(draftPath, checkpointAgain, "client checkpoint must update the source-identity draft atomically");
            Equal(hashesAfterClientRestore, store.SourceHashComputationCount, "post-resume review decisions must reuse the freshly verified source identity");
            Equal(1L, store.EvidenceSnapshotWriteCount, "post-resume checkpoint must keep immutable evidence write-once");

            await File.AppendAllTextAsync(sourcePath, "changed").ConfigureAwait(false);
            Equal(draftPath, await store.FindForSourceAsync(sourcePath).ConfigureAwait(false), "changed in-place source must still surface its old draft for an explicit stale-source verdict");
            await ThrowsAsyncContaining<InvalidDataException>(
                () => store.RestoreAsync(draftPath),
                "source audio changed",
                "changed source audio must fail closed with a regenerate explanation").ConfigureAwait(false);

            await File.WriteAllBytesAsync(sourcePath, originalSourceBytes).ConfigureAwait(false);
            await ThrowsAsync<InvalidDataException>(
                () => Task.Run(() => store.Delete(Path.Combine(root, "outside.review.json"))),
                "draft cleanup must never delete outside its managed directory").ConfigureAwait(false);
            True(clientSession.Delete(draftPath), "explicit client draft cleanup");
            True(!File.Exists(draftPath), "explicit cleanup must remove only the managed checkpoint");
            True(!File.Exists(evidencePath), "unreferenced immutable evidence must be cleaned with its final managed checkpoint");
            Equal<string?>(null, await store.FindForSourceAsync(sourcePath).ConfigureAwait(false), "source lookup after cleanup");

            await VerifyLegacyV1RestoreAsync(
                root,
                store,
                originalSourceBytes,
                notes,
                originalTrack,
                baseQuality,
                session,
                queue,
                selected,
                expectedFingerprint).ConfigureAwait(false);
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

    private static async Task VerifyLegacyV1RestoreAsync(
        string root,
        AudioReviewDraftStore store,
        byte[] sourceBytes,
        IReadOnlyList<BasicPitchTranscribedNote> notes,
        PerformanceTrack originalTrack,
        AudioTranscriptionQualityAssessment baseQuality,
        AudioTranscriptionReviewRepairSession session,
        AudioReviewQueue queue,
        AudioTranscriptionReviewRegion? selected,
        string expectedFingerprint)
    {
        var legacySourcePath = Path.Combine(root, "legacy-owned-audio.wav");
        await File.WriteAllBytesAsync(legacySourcePath, sourceBytes).ConfigureAwait(false);
        var sourceSha256 = Convert.ToHexString(SHA256.HashData(sourceBytes)).ToLowerInvariant();
        var evidenceSha256 = AudioReviewDraftStore.ComputeEvidenceSha256(
            TimeSpan.FromSeconds(5),
            notes,
            originalTrack,
            baseQuality);
        var legacyDocument = new AudioReviewDraftDocument(
            AudioReviewDraftStore.LegacySchemaVersion,
            Path.GetFullPath(legacySourcePath),
            sourceSha256,
            evidenceSha256,
            TimeSpan.FromSeconds(5).Ticks,
            notes.Select(note => new AudioReviewDraftNote(
                note.Start.Ticks,
                note.End.Ticks,
                note.MidiNote,
                note.Amplitude,
                note.PitchBendsThirdSemitones.ToArray())).ToArray(),
            new AudioReviewDraftTrack(
                originalTrack.Title,
                originalTrack.Bpm,
                originalTrack.Subdivision,
                originalTrack.StartDelay.Ticks,
                originalTrack.TimelineDuration.Ticks,
                originalTrack.Events.Select(value => new AudioReviewDraftEvent(
                    value.Start.Ticks,
                    value.Duration.Ticks,
                    new string(value.Keys.ToArray()))).ToArray()),
            baseQuality,
            queue.ExportState(),
            expectedFingerprint,
            selected is null ? null : AudioReviewQueue.GetRegionKey(selected),
            DateTimeOffset.UtcNow);
        var legacyPath = store.GetDraftPath(sourceSha256);
        Directory.CreateDirectory(Path.GetDirectoryName(legacyPath)!);
        await using (var stream = new FileStream(legacyPath, FileMode.Create, FileAccess.Write, FileShare.None))
        {
            await JsonSerializer.SerializeAsync(
                stream,
                legacyDocument,
                new JsonSerializerOptions(JsonSerializerDefaults.Web)).ConfigureAwait(false);
        }

        var restored = await store.RestoreAsync(legacyPath).ConfigureAwait(false);
        Equal(expectedFingerprint, PerformanceTrackFingerprint.ComputeSha256(restored.RepairSession.CurrentTrack), "schema v1 draft must remain restorable after schema v2 ships");
        Equal(notes.Count, restored.SourceNotes.Count, "schema v1 note evidence compatibility");
        True(store.Delete(legacyPath), "legacy draft cleanup");
    }

    private static async Task ThrowsAsync<TException>(Func<Task> action, string label)
        where TException : Exception
    {
        try
        {
            await action().ConfigureAwait(false);
        }
        catch (TException)
        {
            return;
        }
        throw new InvalidOperationException(label);
    }

    private static async Task ThrowsAsyncContaining<TException>(Func<Task> action, string expectedText, string label)
        where TException : Exception
    {
        try
        {
            await action().ConfigureAwait(false);
        }
        catch (TException exception) when (exception.Message.Contains(expectedText, StringComparison.OrdinalIgnoreCase))
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