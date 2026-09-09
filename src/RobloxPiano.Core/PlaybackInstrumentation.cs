namespace RobloxPiano.Core;

public sealed record InstrumentedPlayback(IInputSink Input, IFocusGate Focus);

public static class PlaybackInstrumentation
{
    public static InstrumentedPlayback Create(
        PerformanceTrack track,
        double speed,
        IMonotonicClock clock,
        IInputSink input,
        IFocusGate focus,
        IPlaybackObserver observer)
    {
        ArgumentNullException.ThrowIfNull(track);
        ArgumentNullException.ThrowIfNull(clock);
        ArgumentNullException.ThrowIfNull(input);
        ArgumentNullException.ThrowIfNull(focus);
        ArgumentNullException.ThrowIfNull(observer);

        if (!double.IsFinite(speed) || speed <= 0d)
        {
            throw new ArgumentOutOfRangeException(nameof(speed));
        }

        var observedFocus = new ObservedFocusGate(clock, focus, observer);
        var observedInput = new ObservedInputSink(
            PlaybackPlanner.BuildEdges(track),
            speed,
            clock,
            input,
            observedFocus,
            observer);

        return new InstrumentedPlayback(observedInput, observedFocus);
    }

    private sealed class ObservedFocusGate(
        IMonotonicClock clock,
        IFocusGate inner,
        IPlaybackObserver observer) : IFocusGate
    {
        private readonly object _gate = new();
        private bool? _lastFocused;
        private TimeSpan? _lostAt;
        private TimeSpan _pausedDuration;

        public TimeSpan PausedDuration
        {
            get
            {
                lock (_gate)
                {
                    return _pausedDuration;
                }
            }
        }

        public bool IsTargetFocused
        {
            get
            {
                var focused = inner.IsTargetFocused;
                var now = clock.Elapsed;

                lock (_gate)
                {
                    if (_lastFocused is null)
                    {
                        _lastFocused = focused;
                        if (!focused)
                        {
                            _lostAt = now;
                            SafeObserve(observer, new PlaybackObservation(
                                PlaybackObservationKind.FocusLost,
                                now));
                        }

                        return focused;
                    }

                    if (_lastFocused.Value == focused)
                    {
                        return focused;
                    }

                    _lastFocused = focused;
                    if (!focused)
                    {
                        _lostAt = now;
                        SafeObserve(observer, new PlaybackObservation(
                            PlaybackObservationKind.FocusLost,
                            now));
                        return false;
                    }

                    var duration = _lostAt.HasValue ? now - _lostAt.Value : TimeSpan.Zero;
                    if (duration < TimeSpan.Zero)
                    {
                        duration = TimeSpan.Zero;
                    }

                    _pausedDuration += duration;
                    _lostAt = null;
                    SafeObserve(observer, new PlaybackObservation(
                        PlaybackObservationKind.FocusResumed,
                        now,
                        PauseDuration: duration));
                    return true;
                }
            }
        }
    }

    private sealed class ObservedInputSink(
        IReadOnlyList<PlaybackEdge> plannedEdges,
        double speed,
        IMonotonicClock clock,
        IInputSink inner,
        ObservedFocusGate focus,
        IPlaybackObserver observer) : IInputSink
    {
        private int _edgeIndex;
        private TimeSpan? _firstDispatchAt;
        private TimeSpan _pausedAtFirstDispatch;
        private bool _started;
        private bool _completed;

        public async ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            await DispatchAsync(PlaybackEdgeKind.KeyDown, keys, cancellationToken).ConfigureAwait(false);
        }

        public async ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            await DispatchAsync(PlaybackEdgeKind.KeyUp, keys, cancellationToken).ConfigureAwait(false);
        }

        public async ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
        {
            try
            {
                await inner.ReleaseAllAsync(cancellationToken).ConfigureAwait(false);
                SafeObserve(observer, new PlaybackObservation(
                    PlaybackObservationKind.ReleaseAll,
                    clock.Elapsed));

                if (!_completed && _edgeIndex >= plannedEdges.Count)
                {
                    _completed = true;
                    SafeObserve(observer, new PlaybackObservation(
                        PlaybackObservationKind.PlaybackCompleted,
                        clock.Elapsed));
                }
            }
            catch (Exception exception)
            {
                SafeObserve(observer, new PlaybackObservation(
                    PlaybackObservationKind.PlaybackFailed,
                    clock.Elapsed,
                    Detail: $"ReleaseAll failed: {exception.GetType().Name}: {exception.Message}"));
                throw;
            }
        }

        private async ValueTask DispatchAsync(
            PlaybackEdgeKind kind,
            IReadOnlyList<char> keys,
            CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();

            var rawStart = clock.Elapsed;
            if (!_started)
            {
                _started = true;
                _firstDispatchAt = rawStart;
                _pausedAtFirstDispatch = focus.PausedDuration;
                SafeObserve(observer, new PlaybackObservation(
                    PlaybackObservationKind.PlaybackStarted,
                    rawStart));
            }

            var normalizedStart = Normalize(rawStart);
            var edgeIndex = _edgeIndex;
            PlaybackEdge? expectedEdge = edgeIndex < plannedEdges.Count ? plannedEdges[edgeIndex] : null;

            if (expectedEdge is null)
            {
                SafeObserve(observer, new PlaybackObservation(
                    PlaybackObservationKind.PlaybackFailed,
                    normalizedStart,
                    EdgeIndex: edgeIndex,
                    EdgeKind: kind,
                    Keys: new string(keys.ToArray()),
                    Detail: "Input sink received more edge dispatches than the canonical plan contains."));
            }
            else if (expectedEdge.Kind != kind || !expectedEdge.Keys.SequenceEqual(keys))
            {
                SafeObserve(observer, new PlaybackObservation(
                    PlaybackObservationKind.PlaybackFailed,
                    normalizedStart,
                    EdgeIndex: edgeIndex,
                    EdgeKind: kind,
                    Keys: new string(keys.ToArray()),
                    PlannedTrackTime: expectedEdge.At,
                    Detail: "Observed dispatch order no longer matches the canonical playback plan."));
            }

            try
            {
                if (kind == PlaybackEdgeKind.KeyDown)
                {
                    await inner.KeyDownAsync(keys, cancellationToken).ConfigureAwait(false);
                }
                else
                {
                    await inner.KeyUpAsync(keys, cancellationToken).ConfigureAwait(false);
                }
            }
            catch (Exception exception)
            {
                SafeObserve(observer, new PlaybackObservation(
                    PlaybackObservationKind.PlaybackFailed,
                    normalizedStart,
                    EdgeIndex: edgeIndex,
                    EdgeKind: kind,
                    Keys: new string(keys.ToArray()),
                    PlannedTrackTime: expectedEdge?.At,
                    Detail: $"Input dispatch failed: {exception.GetType().Name}: {exception.Message}"));
                throw;
            }

            var rawCompleted = clock.Elapsed;
            var normalizedCompleted = Normalize(rawCompleted);

            if (expectedEdge is not null)
            {
                var firstTrackTime = plannedEdges.Count == 0 ? TimeSpan.Zero : plannedEdges[0].At;
                var expectedRelative = Scale(expectedEdge.At - firstTrackTime, speed);

                SafeObserve(observer, new PlaybackObservation(
                    PlaybackObservationKind.EdgeDispatched,
                    normalizedStart,
                    EdgeIndex: edgeIndex,
                    EdgeKind: kind,
                    Keys: new string(keys.ToArray()),
                    PlannedTrackTime: expectedEdge.At,
                    ExpectedClockTime: expectedRelative,
                    DispatchCompletedClockTime: normalizedCompleted));
            }

            _edgeIndex++;
        }

        private TimeSpan Normalize(TimeSpan raw)
        {
            if (!_firstDispatchAt.HasValue)
            {
                return TimeSpan.Zero;
            }

            var pausedSinceStart = focus.PausedDuration - _pausedAtFirstDispatch;
            var normalized = raw - _firstDispatchAt.Value - pausedSinceStart;
            return normalized < TimeSpan.Zero ? TimeSpan.Zero : normalized;
        }

        private static TimeSpan Scale(TimeSpan value, double speed)
        {
            var ticks = value.Ticks / speed;
            if (ticks > long.MaxValue || ticks < long.MinValue)
            {
                throw new OverflowException("Scaled playback time exceeded TimeSpan range.");
            }

            return TimeSpan.FromTicks((long)Math.Round(ticks, MidpointRounding.AwayFromZero));
        }
    }

    private static void SafeObserve(IPlaybackObserver observer, PlaybackObservation observation)
    {
        try
        {
            observer.Observe(observation);
        }
        catch
        {
            // Diagnostics must never be able to interrupt live playback.
        }
    }
}
