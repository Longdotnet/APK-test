namespace RobloxPiano.Core;

public enum PlaybackTransportSegmentEndReason
{
    Completed = 0,
    Seeked = 1,
    Cancelled = 2,
    Failed = 3
}

public sealed record PlaybackTransportSegmentQuality(
    int SegmentIndex,
    double StartPositionSeconds,
    PlaybackTransportSegmentEndReason EndReason,
    int PlannedEdgeCount,
    int DispatchedEdgeCount,
    int UnexpectedMissingEdgeCount,
    int InterruptedEdgeCount,
    int FailureCount,
    int FocusPauseCount,
    double FocusPausedMilliseconds,
    double P95AbsoluteTimingErrorMilliseconds,
    double MaxAbsoluteTimingErrorMilliseconds,
    double MeanInputCallMilliseconds,
    double MaxInputCallMilliseconds);

public sealed record PlaybackTransportQualityReport(
    int SchemaVersion,
    int SegmentCount,
    int SeekCount,
    int CompletedSegmentCount,
    int CancelledSegmentCount,
    int FailedSegmentCount,
    int DispatchedEdgeCount,
    int UnexpectedMissingEdgeCount,
    int InterruptedEdgeCount,
    int FailureCount,
    int FocusPauseCount,
    double FocusPausedMilliseconds,
    int ReleaseAllCount,
    double MeanSignedTimingErrorMilliseconds,
    double MeanAbsoluteTimingErrorMilliseconds,
    double P95AbsoluteTimingErrorMilliseconds,
    double MaxAbsoluteTimingErrorMilliseconds,
    double MeanInputCallMilliseconds,
    double MaxInputCallMilliseconds,
    IReadOnlyList<PlaybackTransportSegmentQuality> Segments,
    string? CanonicalTrackFingerprint = null)
{
    public const int CurrentSchemaVersion = 1;

    public bool HasUnexpectedPlaybackLoss => UnexpectedMissingEdgeCount > 0 || FailureCount > 0;
}

internal sealed class PlaybackTransportQualityAccumulator
{
    private readonly object _gate = new();
    private readonly PlaybackQualityCollector _aggregateCollector = new();
    private readonly List<PlaybackTransportSegmentQuality> _segments = new();

    public IPlaybackObserver CreateSegmentObserver(PlaybackQualityCollector segmentCollector)
    {
        ArgumentNullException.ThrowIfNull(segmentCollector);
        return new CompositePlaybackObserver(segmentCollector, _aggregateCollector);
    }

    public void CompleteSegment(
        TimeSpan startPosition,
        PerformanceTrack slice,
        PlaybackQualityCollector segmentCollector,
        PlaybackTransportSegmentEndReason endReason)
    {
        ArgumentNullException.ThrowIfNull(slice);
        ArgumentNullException.ThrowIfNull(segmentCollector);

        var report = segmentCollector.BuildReport(slice, 1d);
        var missing = Math.Max(0, report.MissingEdgeCount);
        var unexpectedMissing = endReason == PlaybackTransportSegmentEndReason.Completed ? missing : 0;
        var interrupted = endReason == PlaybackTransportSegmentEndReason.Completed ? 0 : missing;

        lock (_gate)
        {
            _segments.Add(new PlaybackTransportSegmentQuality(
                _segments.Count,
                Math.Max(0d, startPosition.TotalSeconds),
                endReason,
                report.PlannedEdgeCount,
                report.DispatchedEdgeCount,
                unexpectedMissing,
                interrupted,
                report.FailureCount,
                report.FocusPauseCount,
                report.FocusPausedMilliseconds,
                report.P95AbsoluteTimingErrorMilliseconds,
                report.MaxAbsoluteTimingErrorMilliseconds,
                report.MeanInputCallMilliseconds,
                report.MaxInputCallMilliseconds));
        }
    }

    public PlaybackTransportQualityReport BuildReport()
    {
        PlaybackTransportSegmentQuality[] segments;
        lock (_gate)
        {
            segments = _segments.ToArray();
        }

        var aggregate = _aggregateCollector.BuildSnapshot();
        return new PlaybackTransportQualityReport(
            PlaybackTransportQualityReport.CurrentSchemaVersion,
            segments.Length,
            segments.Count(segment => segment.EndReason == PlaybackTransportSegmentEndReason.Seeked),
            segments.Count(segment => segment.EndReason == PlaybackTransportSegmentEndReason.Completed),
            segments.Count(segment => segment.EndReason == PlaybackTransportSegmentEndReason.Cancelled),
            segments.Count(segment => segment.EndReason == PlaybackTransportSegmentEndReason.Failed),
            aggregate.DispatchedEdgeCount,
            segments.Sum(segment => segment.UnexpectedMissingEdgeCount),
            segments.Sum(segment => segment.InterruptedEdgeCount),
            aggregate.FailureCount,
            aggregate.FocusPauseCount,
            aggregate.FocusPausedMilliseconds,
            aggregate.ReleaseAllCount,
            aggregate.MeanSignedTimingErrorMilliseconds,
            aggregate.MeanAbsoluteTimingErrorMilliseconds,
            aggregate.P95AbsoluteTimingErrorMilliseconds,
            aggregate.MaxAbsoluteTimingErrorMilliseconds,
            aggregate.MeanInputCallMilliseconds,
            aggregate.MaxInputCallMilliseconds,
            segments);
    }

    private sealed class CompositePlaybackObserver(
        IPlaybackObserver first,
        IPlaybackObserver second) : IPlaybackObserver
    {
        public void Observe(PlaybackObservation observation)
        {
            first.Observe(observation);
            second.Observe(observation);
        }
    }
}
