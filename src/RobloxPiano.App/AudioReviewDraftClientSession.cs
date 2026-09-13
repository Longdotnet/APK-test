using RobloxPiano.Audio;
using RobloxPiano.Core;

namespace RobloxPiano.App;

/// <summary>
/// Keeps client-only review-draft persistence context separate from canonical repair/playback state. The coordinator
/// never mutates a PerformanceTrack. It only checkpoints an already-authoritative repair session or restores one
/// through AudioReviewDraftStore's deterministic replay/fingerprint gate. Draft discovery uses a disposable local
/// lookup index; a miss/corruption falls back to authoritative store discovery and repairs the requested index entry.
/// </summary>
internal sealed class AudioReviewDraftClientSession
{
    private readonly AudioReviewDraftStore store;
    private readonly AudioReviewDraftLookupIndex lookupIndex;
    private string? sourcePath;
    private TimeSpan sourceDuration;
    private IReadOnlyList<BasicPitchTranscribedNote> sourceNotes = Array.Empty<BasicPitchTranscribedNote>();
    private PerformanceTrack? originalTrack;
    private AudioTranscriptionQualityAssessment? baseQuality;

    public AudioReviewDraftClientSession(AudioReviewDraftStore store)
    {
        this.store = store ?? throw new ArgumentNullException(nameof(store));
        lookupIndex = new AudioReviewDraftLookupIndex(store);
    }

    public string? ActiveDraftPath { get; private set; }
    public bool CanCheckpoint => sourcePath is not null
        && sourceDuration > TimeSpan.Zero
        && sourceNotes.Count != 0
        && originalTrack is not null
        && baseQuality is not null;

    public void StartNew(
        string ownedSourcePath,
        TimeSpan duration,
        IReadOnlyList<BasicPitchTranscribedNote> notes,
        PerformanceTrack canonicalOriginalTrack,
        AudioTranscriptionQualityAssessment originalBaseQuality)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(ownedSourcePath);
        if (duration <= TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(duration));
        ArgumentNullException.ThrowIfNull(notes);
        ArgumentNullException.ThrowIfNull(canonicalOriginalTrack);
        ArgumentNullException.ThrowIfNull(originalBaseQuality);
        if (notes.Count == 0)
            throw new ArgumentException("Draft checkpointing requires immutable note evidence.", nameof(notes));

        sourcePath = Path.GetFullPath(ownedSourcePath);
        sourceDuration = duration;
        sourceNotes = notes.ToArray();
        originalTrack = canonicalOriginalTrack;
        baseQuality = originalBaseQuality;
        ActiveDraftPath = null;
    }

    public async Task<string?> FindAsync(string ownedSourcePath, CancellationToken cancellationToken = default)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(ownedSourcePath);
        var indexed = lookupIndex.TryResolve(ownedSourcePath);
        if (indexed is not null)
            return indexed;

        var discovered = await store.FindForSourceAsync(ownedSourcePath, cancellationToken).ConfigureAwait(false);
        if (discovered is not null)
        {
            try
            {
                lookupIndex.Upsert(ownedSourcePath, discovered);
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException)
            {
                // Index persistence is optional acceleration. Authoritative discovery already succeeded.
            }
        }
        return discovered;
    }

    public async Task<AudioReviewDraftRestoreResult> RestoreAsync(
        string draftPath,
        CancellationToken cancellationToken = default)
    {
        var restored = await store.RestoreAsync(draftPath, cancellationToken).ConfigureAwait(false);
        sourcePath = restored.SourcePath;
        sourceDuration = restored.SourceDuration;
        sourceNotes = restored.SourceNotes.ToArray();
        originalTrack = restored.OriginalTrack;
        baseQuality = restored.BaseQuality;
        ActiveDraftPath = restored.DraftPath;
        TryIndex(sourcePath, ActiveDraftPath);
        return restored;
    }

    public async Task<string> CheckpointAsync(
        AudioTranscriptionReviewRepairSession repairSession,
        AudioReviewQueue reviewQueue,
        AudioTranscriptionReviewRegion? selectedRegion,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(repairSession);
        ArgumentNullException.ThrowIfNull(reviewQueue);
        if (!CanCheckpoint || sourcePath is null || originalTrack is null || baseQuality is null)
            throw new InvalidOperationException("Review draft persistence context is not initialized.");

        ActiveDraftPath = await store.SaveAsync(
            sourcePath,
            sourceDuration,
            sourceNotes,
            originalTrack,
            baseQuality,
            repairSession,
            reviewQueue,
            selectedRegion,
            cancellationToken).ConfigureAwait(false);
        TryIndex(sourcePath, ActiveDraftPath);
        return ActiveDraftPath;
    }

    public bool DeleteActive()
    {
        if (ActiveDraftPath is null)
            return false;
        var path = ActiveDraftPath;
        ActiveDraftPath = null;
        var deleted = store.Delete(path);
        if (deleted)
            TryRemoveIndex(path);
        return deleted;
    }

    public bool Delete(string draftPath)
    {
        var deleted = store.Delete(draftPath);
        if (deleted)
            TryRemoveIndex(draftPath);
        if (string.Equals(Path.GetFullPath(draftPath), ActiveDraftPath, StringComparison.OrdinalIgnoreCase))
            ActiveDraftPath = null;
        return deleted;
    }

    public void ResetRuntimeContext()
    {
        sourcePath = null;
        sourceDuration = TimeSpan.Zero;
        sourceNotes = Array.Empty<BasicPitchTranscribedNote>();
        originalTrack = null;
        baseQuality = null;
        ActiveDraftPath = null;
    }

    private void TryIndex(string ownedSourcePath, string draftPath)
    {
        try
        {
            lookupIndex.Upsert(ownedSourcePath, draftPath);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException)
        {
            // The index is disposable acceleration state and must never block checkpoint/restore.
        }
    }

    private void TryRemoveIndex(string draftPath)
    {
        try
        {
            lookupIndex.RemoveDraft(draftPath);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException)
        {
            // A stale index entry self-heals on next lookup; draft deletion remains authoritative.
        }
    }
}
