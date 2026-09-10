namespace RobloxPiano.Core;

/// <summary>
/// Builds a canonical track slice for transport seek without teaching the playback
/// kernel where the track came from. Events crossing the seek boundary are clipped
/// and re-entered at t=0 so a seek never leaves the output in an undefined held-key state.
/// </summary>
public static class PlaybackTransport
{
    public static PerformanceTrack Slice(PerformanceTrack track, TimeSpan startPosition)
    {
        ArgumentNullException.ThrowIfNull(track);
        ValidatePosition(track, startPosition);

        if (startPosition == TimeSpan.Zero)
        {
            return track with { StartDelay = TimeSpan.Zero };
        }

        var remainingEvents = new List<PerformanceEvent>();
        foreach (var performanceEvent in track.Events)
        {
            var eventEnd = performanceEvent.Start + performanceEvent.Duration;
            if (eventEnd <= startPosition)
            {
                continue;
            }

            if (performanceEvent.Start < startPosition)
            {
                remainingEvents.Add(performanceEvent with
                {
                    Start = TimeSpan.Zero,
                    Duration = eventEnd - startPosition
                });
                continue;
            }

            remainingEvents.Add(performanceEvent with
            {
                Start = performanceEvent.Start - startPosition
            });
        }

        return track with
        {
            StartDelay = TimeSpan.Zero,
            Events = remainingEvents,
            TimelineDuration = track.TimelineDuration - startPosition
        };
    }

    public static TimeSpan ClampPosition(PerformanceTrack track, TimeSpan position)
    {
        ArgumentNullException.ThrowIfNull(track);
        if (position < TimeSpan.Zero)
        {
            return TimeSpan.Zero;
        }

        return position > track.TimelineDuration ? track.TimelineDuration : position;
    }

    private static void ValidatePosition(PerformanceTrack track, TimeSpan position)
    {
        if (position < TimeSpan.Zero || position > track.TimelineDuration)
        {
            throw new ArgumentOutOfRangeException(
                nameof(position),
                $"Seek position must be between 00:00 and {track.TimelineDuration:mm\\:ss\\.fff}.");
        }
    }
}

/// <summary>
/// Interactive transport over the one canonical PlaybackKernel scheduler. Seek is
/// implemented by safely cancelling the current kernel slice (which releases all
/// held keys), rebuilding a canonical slice, and restarting from the requested
/// position. No second scheduler or UI-owned note state is introduced.
///
/// Quality instrumentation is slice-aware: each seek starts a fresh canonical
/// observation segment, while aggregate timing remains in the monotonic logical
/// playback clock domain. Therefore dynamic speed changes do not invalidate timing
/// evidence and intentionally skipped edges are not reported as playback loss.
/// </summary>
public sealed class PlaybackTransportSession : IDisposable
{
    private static readonly TimeSpan DefaultFocusPollInterval = TimeSpan.FromMilliseconds(10);

    private readonly object _gate = new();
    private readonly PerformanceTrack _track;
    private readonly IMonotonicClock _clock;
    private readonly IInputSink _input;
    private readonly ObservedTransportFocusGate _focus;
    private readonly PlaybackTimingProfile _timingProfile;
    private readonly PlaybackTransportQualityAccumulator _quality = new();
    private readonly string _canonicalTrackFingerprint;

    private CancellationTokenSource? _activeSliceCancellation;
    private TimeSpan? _pendingSeek;
    private TimeSpan _sliceStart;
    private TimeSpan _sliceClockOrigin;
    private TimeSpan _inactiveAtSliceStart;
    private TimeSpan _settledPosition;
    private bool _sliceRunning;
    private bool _disposed;

    public PlaybackTransportSession(
        PerformanceTrack track,
        IMonotonicClock clock,
        IInputSink input,
        IFocusGate focus,
        PlaybackTimingProfile? timingProfile = null)
    {
        _track = track ?? throw new ArgumentNullException(nameof(track));
        _canonicalTrackFingerprint = PerformanceTrackFingerprint.ComputeSha256(_track);
        _clock = clock ?? throw new ArgumentNullException(nameof(clock));
        ArgumentNullException.ThrowIfNull(input);
        _input = input is ReferenceCountedInputSink
            ? input
            : new ReferenceCountedInputSink(input);
        ArgumentNullException.ThrowIfNull(focus);
        _focus = new ObservedTransportFocusGate(clock, focus);
        _timingProfile = timingProfile ?? PlaybackTimingProfile.Neutral;
    }

    public TimeSpan Duration => _track.TimelineDuration;
    public PlaybackTimingProfile TimingProfile => _timingProfile;
    public PlaybackTransportQualityReport QualityReport => _quality.BuildReport() with
    {
        CanonicalTrackFingerprint = _canonicalTrackFingerprint
    };

    public TimeSpan Position
    {
        get
        {
            lock (_gate)
            {
                if (!_sliceRunning)
                {
                    return _settledPosition;
                }

                var elapsed = _clock.Elapsed - _sliceClockOrigin;
                var inactive = _focus.InactiveDuration - _inactiveAtSliceStart;
                var activeElapsed = elapsed - inactive;
                if (activeElapsed < TimeSpan.Zero)
                {
                    activeElapsed = TimeSpan.Zero;
                }

                return PlaybackTransport.ClampPosition(_track, _sliceStart + activeElapsed);
            }
        }
    }

    public void Seek(TimeSpan position)
    {
        ThrowIfDisposed();
        var clamped = PlaybackTransport.ClampPosition(_track, position);

        CancellationTokenSource? active;
        lock (_gate)
        {
            _pendingSeek = clamped;
            _settledPosition = clamped;
            active = _activeSliceCancellation;
        }

        active?.Cancel();
    }

    public async Task PlayAsync(
        TimeSpan startPosition,
        CancellationToken cancellationToken = default)
    {
        ThrowIfDisposed();
        var nextPosition = PlaybackTransport.ClampPosition(_track, startPosition);

        while (true)
        {
            cancellationToken.ThrowIfCancellationRequested();

            lock (_gate)
            {
                if (_pendingSeek.HasValue)
                {
                    nextPosition = _pendingSeek.Value;
                    _pendingSeek = null;
                }
            }

            if (nextPosition >= _track.TimelineDuration)
            {
                lock (_gate)
                {
                    _settledPosition = _track.TimelineDuration;
                    _sliceRunning = false;
                }

                await _input.ReleaseAllAsync(CancellationToken.None).ConfigureAwait(false);
                return;
            }

            var slice = PlaybackTransport.Slice(_track, nextPosition);
            using var sliceCancellation = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken);

            lock (_gate)
            {
                _activeSliceCancellation = sliceCancellation;
                _sliceStart = nextPosition;
                _sliceClockOrigin = _clock.Elapsed;
                _inactiveAtSliceStart = _focus.InactiveDuration;
                _settledPosition = nextPosition;
                _sliceRunning = true;
            }

            var segmentCollector = new PlaybackQualityCollector();
            var instrumented = PlaybackInstrumentation.Create(
                slice,
                1d,
                _clock,
                _input,
                _focus,
                _quality.CreateSegmentObserver(segmentCollector));
            var kernel = new PlaybackKernel(_clock, instrumented.Input, instrumented.Focus);

            try
            {
                await kernel.PlayAsync(
                    slice,
                    new PlaybackOptions(
                        Speed: 1d,
                        InitialDelay: TimeSpan.Zero,
                        FocusPollInterval: DefaultFocusPollInterval,
                        DispatchLead: _timingProfile.DispatchLead),
                    sliceCancellation.Token).ConfigureAwait(false);

                _quality.CompleteSegment(
                    nextPosition,
                    slice,
                    segmentCollector,
                    PlaybackTransportSegmentEndReason.Completed);

                lock (_gate)
                {
                    _settledPosition = _track.TimelineDuration;
                    _sliceRunning = false;
                    _activeSliceCancellation = null;
                }

                return;
            }
            catch (OperationCanceledException) when (!cancellationToken.IsCancellationRequested)
            {
                TimeSpan? seek;
                lock (_gate)
                {
                    seek = _pendingSeek;
                    _pendingSeek = null;
                    _activeSliceCancellation = null;
                    _sliceRunning = false;
                }

                _quality.CompleteSegment(
                    nextPosition,
                    slice,
                    segmentCollector,
                    seek.HasValue
                        ? PlaybackTransportSegmentEndReason.Seeked
                        : PlaybackTransportSegmentEndReason.Cancelled);

                if (!seek.HasValue)
                {
                    throw;
                }

                nextPosition = seek.Value;
            }
            catch (OperationCanceledException)
            {
                _quality.CompleteSegment(
                    nextPosition,
                    slice,
                    segmentCollector,
                    PlaybackTransportSegmentEndReason.Cancelled);
                throw;
            }
            catch
            {
                _quality.CompleteSegment(
                    nextPosition,
                    slice,
                    segmentCollector,
                    PlaybackTransportSegmentEndReason.Failed);
                throw;
            }
            finally
            {
                lock (_gate)
                {
                    if (ReferenceEquals(_activeSliceCancellation, sliceCancellation))
                    {
                        _activeSliceCancellation = null;
                    }
                }
            }
        }
    }

    public void Dispose()
    {
        CancellationTokenSource? active;
        lock (_gate)
        {
            if (_disposed)
            {
                return;
            }

            _disposed = true;
            active = _activeSliceCancellation;
            _activeSliceCancellation = null;
        }

        active?.Cancel();
    }

    private void ThrowIfDisposed()
    {
        ObjectDisposedException.ThrowIf(_disposed, this);
    }

    private sealed class ObservedTransportFocusGate : IFocusGate
    {
        private readonly object _gate = new();
        private readonly IMonotonicClock _clock;
        private readonly IFocusGate _inner;
        private bool? _lastFocused;
        private TimeSpan? _lostAt;
        private TimeSpan _inactiveDuration;

        public ObservedTransportFocusGate(IMonotonicClock clock, IFocusGate inner)
        {
            _clock = clock;
            _inner = inner;
        }

        public TimeSpan InactiveDuration
        {
            get
            {
                lock (_gate)
                {
                    var duration = _inactiveDuration;
                    if (_lostAt.HasValue)
                    {
                        var current = _clock.Elapsed - _lostAt.Value;
                        if (current > TimeSpan.Zero)
                        {
                            duration += current;
                        }
                    }

                    return duration;
                }
            }
        }

        public bool IsTargetFocused
        {
            get
            {
                var focused = _inner.IsTargetFocused;
                var now = _clock.Elapsed;

                lock (_gate)
                {
                    if (_lastFocused == focused)
                    {
                        return focused;
                    }

                    _lastFocused = focused;
                    if (!focused)
                    {
                        _lostAt ??= now;
                        return false;
                    }

                    if (_lostAt.HasValue)
                    {
                        var duration = now - _lostAt.Value;
                        if (duration > TimeSpan.Zero)
                        {
                            _inactiveDuration += duration;
                        }

                        _lostAt = null;
                    }

                    return true;
                }
            }
        }
    }
}
