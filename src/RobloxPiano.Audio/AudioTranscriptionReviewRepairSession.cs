using RobloxPiano.Core;

namespace RobloxPiano.Audio;

public sealed record AudioTranscriptionReviewRepairSessionOptions(
    AudioTranscriptionReviewRegionOptions? ReviewRegions = null,
    AudioTranscriptionReviewRepairOptions? Repair = null,
    AudioTranscriptionQualityOptions? Quality = null);

public sealed record AudioTranscriptionReviewRepairApplyResult(
    AudioTranscriptionReviewRepairKind Kind,
    PerformanceTrack PreviousTrack,
    PerformanceTrack CurrentTrack,
    IReadOnlyList<AudioTranscriptionReviewRegion> ReviewRegions,
    long Revision)
{
    public AudioTranscriptionQualityAssessment? Quality { get; init; }
}

/// <summary>
/// Owns deterministic review-repair state for one generated piano result.
/// Candidate preview is side-effect free. Canonical session state changes only through an explicit Apply,
/// and Revert restores the exact original generated performance. When the original global quality assessment
/// is supplied, every successful Apply recomputes only canonical-track-dependent quality evidence while
/// preserving immutable source/model evidence. This boundary never persists to the library, schedules Roblox
/// playback, or authorizes input.
/// </summary>
public sealed class AudioTranscriptionReviewRepairSession
{
    private readonly TimeSpan sourceDuration;
    private readonly IReadOnlyList<BasicPitchTranscribedNote> sourceNotes;
    private readonly AudioTranscriptionReviewRepairSessionOptions options;
    private readonly AudioTranscriptionReviewRepairGenerator generator;
    private readonly AudioTranscriptionReviewRegionAnalyzer analyzer;
    private readonly AudioTranscriptionRepairAwareQualityEvaluator qualityEvaluator;
    private readonly AudioTranscriptionQualityAssessment? baseQuality;
    private readonly PerformanceTrack originalTrack;
    private PerformanceTrack currentTrack;
    private IReadOnlyList<AudioTranscriptionReviewRegion> reviewRegions;
    private AudioTranscriptionQualityAssessment? currentQuality;
    private long revision;

    public AudioTranscriptionReviewRepairSession(
        TimeSpan sourceDuration,
        IReadOnlyList<BasicPitchTranscribedNote> sourceNotes,
        PerformanceTrack canonicalTrack,
        AudioTranscriptionReviewRepairSessionOptions? options = null,
        AudioTranscriptionReviewRepairGenerator? generator = null,
        AudioTranscriptionReviewRegionAnalyzer? analyzer = null,
        AudioTranscriptionQualityAssessment? baseQuality = null,
        AudioTranscriptionRepairAwareQualityEvaluator? qualityEvaluator = null,
        CancellationToken cancellationToken = default)
    {
        if (sourceDuration <= TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(sourceDuration));
        ArgumentNullException.ThrowIfNull(sourceNotes);
        ArgumentNullException.ThrowIfNull(canonicalTrack);
        if (sourceNotes.Count == 0)
            throw new ArgumentException("Review repair requires decoded note evidence.", nameof(sourceNotes));
        cancellationToken.ThrowIfCancellationRequested();

        this.sourceDuration = sourceDuration;
        this.sourceNotes = sourceNotes
            .OrderBy(note => note.Start)
            .ThenBy(note => note.MidiNote)
            .ThenBy(note => note.End)
            .ThenByDescending(note => note.Amplitude)
            .ToArray();
        this.options = options ?? new AudioTranscriptionReviewRepairSessionOptions();
        this.generator = generator ?? new AudioTranscriptionReviewRepairGenerator();
        this.analyzer = analyzer ?? new AudioTranscriptionReviewRegionAnalyzer();
        this.baseQuality = baseQuality;
        this.qualityEvaluator = qualityEvaluator ?? new AudioTranscriptionRepairAwareQualityEvaluator();
        originalTrack = Snapshot(canonicalTrack);
        currentTrack = Snapshot(canonicalTrack);
        reviewRegions = Analyze(currentTrack, cancellationToken);
        currentQuality = baseQuality;
    }

    public PerformanceTrack OriginalTrack => originalTrack;
    public PerformanceTrack CurrentTrack => currentTrack;
    public IReadOnlyList<AudioTranscriptionReviewRegion> ReviewRegions => reviewRegions;
    public AudioTranscriptionQualityAssessment? BaseQuality => baseQuality;
    public AudioTranscriptionQualityAssessment? CurrentQuality => currentQuality;
    public bool IsModified => !TracksEquivalent(originalTrack, currentTrack);
    public bool CanRevert => IsModified;
    public long Revision => revision;

    public IReadOnlyList<AudioTranscriptionReviewRepairCandidate> GetCandidates(
        AudioTranscriptionReviewRegion region,
        CancellationToken cancellationToken = default)
    {
        var currentRegion = ResolveCurrentRegion(region);
        return generator.Generate(
            currentTrack,
            sourceNotes,
            currentRegion,
            options.Repair,
            cancellationToken);
    }

    public AudioTranscriptionReviewRepairCandidate PreviewCandidate(
        AudioTranscriptionReviewRegion region,
        AudioTranscriptionReviewRepairKind kind,
        CancellationToken cancellationToken = default)
    {
        var candidate = GetCandidates(region, cancellationToken)
            .SingleOrDefault(value => value.Kind == kind);
        return candidate ?? throw new InvalidOperationException(
            $"Repair kind {kind} does not produce a distinct deterministic candidate for the selected review region.");
    }

    public AudioTranscriptionReviewRepairApplyResult Apply(
        AudioTranscriptionReviewRegion region,
        AudioTranscriptionReviewRepairKind kind,
        CancellationToken cancellationToken = default)
    {
        cancellationToken.ThrowIfCancellationRequested();
        var candidate = PreviewCandidate(region, kind, cancellationToken);
        var previous = currentTrack;
        var next = Snapshot(candidate.Track);
        if (TracksEquivalent(previous, next))
            throw new InvalidOperationException("Explicit repair apply refused a no-op candidate.");

        // Compute every derived state before committing any session mutation so cancellation or malformed
        // candidate evidence leaves the previous canonical state intact.
        var nextRegions = Analyze(next, cancellationToken);
        var nextQuality = ReevaluateQuality(next, cancellationToken);
        cancellationToken.ThrowIfCancellationRequested();

        currentTrack = next;
        reviewRegions = nextRegions;
        currentQuality = nextQuality;
        revision = checked(revision + 1);
        return new AudioTranscriptionReviewRepairApplyResult(
            kind,
            previous,
            currentTrack,
            reviewRegions,
            revision)
        {
            Quality = currentQuality
        };
    }

    public bool Revert(CancellationToken cancellationToken = default)
    {
        cancellationToken.ThrowIfCancellationRequested();
        if (!IsModified)
            return false;

        var restored = Snapshot(originalTrack);
        var restoredRegions = Analyze(restored, cancellationToken);
        cancellationToken.ThrowIfCancellationRequested();
        currentTrack = restored;
        reviewRegions = restoredRegions;
        currentQuality = baseQuality;
        revision = checked(revision + 1);
        return true;
    }

    private AudioTranscriptionReviewRegion ResolveCurrentRegion(AudioTranscriptionReviewRegion region)
    {
        ArgumentNullException.ThrowIfNull(region);
        var current = reviewRegions.SingleOrDefault(candidate =>
            candidate.Start == region.Start
            && candidate.End == region.End
            && candidate.Reasons.SequenceEqual(region.Reasons));
        return current ?? throw new InvalidOperationException(
            "The selected review region is stale or no longer requires review on the current canonical session track.");
    }

    private IReadOnlyList<AudioTranscriptionReviewRegion> Analyze(
        PerformanceTrack track,
        CancellationToken cancellationToken) =>
        analyzer.Analyze(
            sourceDuration,
            sourceNotes,
            track,
            options.ReviewRegions,
            cancellationToken);

    private AudioTranscriptionQualityAssessment? ReevaluateQuality(
        PerformanceTrack track,
        CancellationToken cancellationToken)
    {
        if (baseQuality is null)
            return null;

        return qualityEvaluator.Evaluate(
            sourceDuration,
            sourceNotes.Count,
            track,
            baseQuality,
            options.Quality,
            cancellationToken);
    }

    private static PerformanceTrack Snapshot(PerformanceTrack track)
    {
        var events = track.Events
            .Select(evt => new PerformanceEvent(evt.Start, evt.Duration, evt.Keys.ToArray()))
            .ToArray();
        return track with { Events = events };
    }

    private static bool TracksEquivalent(PerformanceTrack left, PerformanceTrack right)
    {
        if (left.Title != right.Title
            || left.Bpm != right.Bpm
            || left.Subdivision != right.Subdivision
            || left.StartDelay != right.StartDelay
            || left.TimelineDuration != right.TimelineDuration
            || left.Events.Count != right.Events.Count)
        {
            return false;
        }

        for (var index = 0; index < left.Events.Count; index++)
        {
            var a = left.Events[index];
            var b = right.Events[index];
            if (a.Start != b.Start || a.Duration != b.Duration || !a.Keys.SequenceEqual(b.Keys))
                return false;
        }
        return true;
    }
}
