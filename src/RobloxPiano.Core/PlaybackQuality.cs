using System.Globalization;
using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Core;

public enum PlaybackObservationKind
{
    PlaybackStarted,
    EdgeDispatched,
    FocusLost,
    FocusResumed,
    ReleaseAll,
    PlaybackCompleted,
    PlaybackFailed
}

public sealed record PlaybackObservation(
    PlaybackObservationKind Kind,
    TimeSpan ClockTime,
    int? EdgeIndex = null,
    PlaybackEdgeKind? EdgeKind = null,
    string Keys = "",
    TimeSpan? PlannedTrackTime = null,
    TimeSpan? ExpectedClockTime = null,
    TimeSpan? DispatchCompletedClockTime = null,
    TimeSpan? PauseDuration = null,
    string? Detail = null);

public interface IPlaybackObserver
{
    void Observe(PlaybackObservation observation);
}

public static class PlaybackPlanFingerprint
{
    public static string Compute(PerformanceTrack track, double speed)
    {
        ArgumentNullException.ThrowIfNull(track);
        if (!double.IsFinite(speed) || speed <= 0d)
        {
            throw new ArgumentOutOfRangeException(nameof(speed));
        }

        var builder = new StringBuilder();
        builder.Append("speed=")
            .Append(speed.ToString("R", CultureInfo.InvariantCulture))
            .Append('\n');

        foreach (var edge in PlaybackPlanner.BuildEdges(track))
        {
            builder.Append(edge.At.Ticks)
                .Append('|')
                .Append((int)edge.Kind)
                .Append('|')
                .Append(edge.Keys.Count)
                .Append('|');

            foreach (var key in edge.Keys)
            {
                builder.Append((int)key).Append(',');
            }

            builder.Append('\n');
        }

        var hash = SHA256.HashData(Encoding.UTF8.GetBytes(builder.ToString()));
        return Convert.ToHexString(hash).ToLowerInvariant();
    }
}

public sealed record PlaybackTimingSample(
    int EdgeIndex,
    PlaybackEdgeKind EdgeKind,
    string Keys,
    double PlannedTrackMilliseconds,
    double ExpectedClockMilliseconds,
    double DispatchClockMilliseconds,
    double TimingErrorMilliseconds,
    double InputCallMilliseconds);

public sealed record PlaybackQualityReport(
    int SchemaVersion,
    string TrackTitle,
    string PlanFingerprint,
    double Speed,
    int PlannedEdgeCount,
    int DispatchedEdgeCount,
    int MissingEdgeCount,
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
    IReadOnlyList<PlaybackTimingSample> WorstTimingSamples)
{
    public const int CurrentSchemaVersion = 1;

    public bool CompletedAllEdges => FailureCount == 0 && MissingEdgeCount == 0;
}

public sealed class PlaybackQualityCollector : IPlaybackObserver
{
    private readonly object _gate = new();
    private readonly List<PlaybackObservation> _observations = new();

    public void Observe(PlaybackObservation observation)
    {
        ArgumentNullException.ThrowIfNull(observation);
        lock (_gate)
        {
            _observations.Add(observation);
        }
    }

    public PlaybackQualityReport BuildReport(PerformanceTrack track, double speed, int worstSampleLimit = 20)
    {
        ArgumentNullException.ThrowIfNull(track);
        if (worstSampleLimit < 0 || worstSampleLimit > 1000)
        {
            throw new ArgumentOutOfRangeException(nameof(worstSampleLimit));
        }

        PlaybackObservation[] snapshot;
        lock (_gate)
        {
            snapshot = _observations.ToArray();
        }

        var plannedEdges = PlaybackPlanner.BuildEdges(track);
        var dispatches = snapshot
            .Where(item => item.Kind == PlaybackObservationKind.EdgeDispatched)
            .ToArray();

        var timingSamples = dispatches
            .Where(item => item.EdgeIndex.HasValue
                && item.EdgeKind.HasValue
                && item.PlannedTrackTime.HasValue
                && item.ExpectedClockTime.HasValue)
            .Select(item =>
            {
                var dispatchCompleted = item.DispatchCompletedClockTime ?? item.ClockTime;
                return new PlaybackTimingSample(
                    item.EdgeIndex!.Value,
                    item.EdgeKind!.Value,
                    item.Keys,
                    item.PlannedTrackTime!.Value.TotalMilliseconds,
                    item.ExpectedClockTime!.Value.TotalMilliseconds,
                    item.ClockTime.TotalMilliseconds,
                    (item.ClockTime - item.ExpectedClockTime.Value).TotalMilliseconds,
                    Math.Max(0d, (dispatchCompleted - item.ClockTime).TotalMilliseconds));
            })
            .ToArray();

        var signedErrors = timingSamples.Select(sample => sample.TimingErrorMilliseconds).ToArray();
        var absoluteErrors = signedErrors.Select(Math.Abs).ToArray();
        var inputCalls = timingSamples.Select(sample => sample.InputCallMilliseconds).ToArray();

        var focusPaused = snapshot
            .Where(item => item.Kind == PlaybackObservationKind.FocusResumed && item.PauseDuration.HasValue)
            .Sum(item => item.PauseDuration!.Value.TotalMilliseconds);

        var worst = timingSamples
            .OrderByDescending(sample => Math.Abs(sample.TimingErrorMilliseconds))
            .ThenBy(sample => sample.EdgeIndex)
            .Take(worstSampleLimit)
            .ToArray();

        return new PlaybackQualityReport(
            PlaybackQualityReport.CurrentSchemaVersion,
            track.Title,
            PlaybackPlanFingerprint.Compute(track, speed),
            speed,
            plannedEdges.Count,
            dispatches.Length,
            Math.Max(0, plannedEdges.Count - dispatches.Length),
            snapshot.Count(item => item.Kind == PlaybackObservationKind.PlaybackFailed),
            snapshot.Count(item => item.Kind == PlaybackObservationKind.FocusResumed),
            focusPaused,
            snapshot.Count(item => item.Kind == PlaybackObservationKind.ReleaseAll),
            Mean(signedErrors),
            Mean(absoluteErrors),
            Percentile95(absoluteErrors),
            Max(absoluteErrors),
            Mean(inputCalls),
            Max(inputCalls),
            worst);
    }

    private static double Mean(double[] values) => values.Length == 0 ? 0d : values.Average();

    private static double Max(double[] values) => values.Length == 0 ? 0d : values.Max();

    private static double Percentile95(double[] values)
    {
        if (values.Length == 0)
        {
            return 0d;
        }

        var sorted = values.OrderBy(value => value).ToArray();
        var index = Math.Max(0, (int)Math.Ceiling(sorted.Length * 0.95d) - 1);
        return sorted[index];
    }
}

public enum PlaybackComparisonVerdict
{
    Better,
    Equivalent,
    Worse,
    Inconclusive,
    Incomparable
}

public sealed record PlaybackQualityComparison(
    PlaybackComparisonVerdict Verdict,
    string Reason,
    double P95DeltaMilliseconds,
    double MaxErrorDeltaMilliseconds,
    int MissingEdgeDelta,
    int FailureDelta);

public static class PlaybackQualityComparator
{
    public static PlaybackQualityComparison Compare(
        PlaybackQualityReport baseline,
        PlaybackQualityReport candidate)
    {
        ArgumentNullException.ThrowIfNull(baseline);
        ArgumentNullException.ThrowIfNull(candidate);

        if (baseline.SchemaVersion != PlaybackQualityReport.CurrentSchemaVersion
            || candidate.SchemaVersion != PlaybackQualityReport.CurrentSchemaVersion)
        {
            return Result(PlaybackComparisonVerdict.Incomparable, "Unsupported report schema.", baseline, candidate);
        }

        if (!string.Equals(baseline.PlanFingerprint, candidate.PlanFingerprint, StringComparison.Ordinal))
        {
            return Result(
                PlaybackComparisonVerdict.Incomparable,
                "Playback plans differ. Timing A/B comparisons require the same canonical plan and speed.",
                baseline,
                candidate);
        }

        if (candidate.FailureCount > baseline.FailureCount || candidate.MissingEdgeCount > baseline.MissingEdgeCount)
        {
            return Result(
                PlaybackComparisonVerdict.Worse,
                "Candidate introduced additional playback failures or missing dispatches.",
                baseline,
                candidate);
        }

        if (candidate.FailureCount < baseline.FailureCount || candidate.MissingEdgeCount < baseline.MissingEdgeCount)
        {
            return Result(
                PlaybackComparisonVerdict.Better,
                "Candidate completed more of the deterministic playback plan.",
                baseline,
                candidate);
        }

        if (baseline.FocusPauseCount != 0 || candidate.FocusPauseCount != 0)
        {
            return Result(
                PlaybackComparisonVerdict.Inconclusive,
                "At least one run lost foreground focus; repeat both runs without focus interruptions before promoting a scheduler change.",
                baseline,
                candidate);
        }

        var p95Tolerance = Math.Max(1d, baseline.P95AbsoluteTimingErrorMilliseconds * 0.20d);
        var maxTolerance = Math.Max(2d, baseline.MaxAbsoluteTimingErrorMilliseconds * 0.20d);

        var p95Delta = candidate.P95AbsoluteTimingErrorMilliseconds - baseline.P95AbsoluteTimingErrorMilliseconds;
        var maxDelta = candidate.MaxAbsoluteTimingErrorMilliseconds - baseline.MaxAbsoluteTimingErrorMilliseconds;

        if (p95Delta < -p95Tolerance && maxDelta <= maxTolerance)
        {
            return Result(
                PlaybackComparisonVerdict.Better,
                "Candidate materially reduced p95 scheduler error without materially worsening the worst edge.",
                baseline,
                candidate);
        }

        if (p95Delta > p95Tolerance || maxDelta > maxTolerance)
        {
            return Result(
                PlaybackComparisonVerdict.Worse,
                "Candidate materially increased scheduler timing error.",
                baseline,
                candidate);
        }

        return Result(
            PlaybackComparisonVerdict.Equivalent,
            "Scheduler timing differences are within the production comparison tolerance.",
            baseline,
            candidate);
    }

    private static PlaybackQualityComparison Result(
        PlaybackComparisonVerdict verdict,
        string reason,
        PlaybackQualityReport baseline,
        PlaybackQualityReport candidate)
    {
        return new PlaybackQualityComparison(
            verdict,
            reason,
            candidate.P95AbsoluteTimingErrorMilliseconds - baseline.P95AbsoluteTimingErrorMilliseconds,
            candidate.MaxAbsoluteTimingErrorMilliseconds - baseline.MaxAbsoluteTimingErrorMilliseconds,
            candidate.MissingEdgeCount - baseline.MissingEdgeCount,
            candidate.FailureCount - baseline.FailureCount);
    }
}
