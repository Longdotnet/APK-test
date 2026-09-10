namespace RobloxPiano.Core;

/// <summary>
/// A monotonic playback time-domain that can change speed without moving the
/// canonical score timeline. The underlying wall clock always continues to run;
/// user pause is exposed separately and is composed with IFocusGate so the
/// existing PlaybackKernel owns the same release-all/pause safety path.
/// </summary>
public sealed class PlaybackSessionClock : IMonotonicClock
{
    public const double MinimumSpeed = 0.25d;
    public const double MaximumSpeed = 4d;

    private static readonly TimeSpan ControlPollInterval = TimeSpan.FromMilliseconds(10);

    private readonly object _gate = new();
    private readonly IMonotonicClock _wallClock;
    private TimeSpan _wallAnchor;
    private TimeSpan _playbackAnchor;
    private double _speed;
    private bool _isUserPaused;

    public PlaybackSessionClock(IMonotonicClock wallClock, double initialSpeed = 1d)
    {
        _wallClock = wallClock ?? throw new ArgumentNullException(nameof(wallClock));
        ValidateSpeed(initialSpeed);
        _speed = Math.Clamp(initialSpeed, MinimumSpeed, MaximumSpeed);
        _wallAnchor = wallClock.Elapsed;
        _playbackAnchor = TimeSpan.Zero;
    }

    /// <summary>
    /// Raised after a validated speed transition has been committed. Subscribers
    /// are observational only; playback timing never depends on a subscriber.
    /// </summary>
    public event Action<double>? SpeedChanged;

    public double Speed
    {
        get
        {
            lock (_gate)
            {
                return _speed;
            }
        }
    }

    public bool IsUserPaused
    {
        get
        {
            lock (_gate)
            {
                return _isUserPaused;
            }
        }
    }

    public TimeSpan Elapsed
    {
        get
        {
            lock (_gate)
            {
                return GetPlaybackNowLocked(_wallClock.Elapsed);
            }
        }
    }

    public double SetSpeed(double speed)
    {
        ValidateSpeed(speed);
        var clamped = Math.Clamp(speed, MinimumSpeed, MaximumSpeed);
        bool changed;

        lock (_gate)
        {
            var wallNow = _wallClock.Elapsed;
            _playbackAnchor = GetPlaybackNowLocked(wallNow);
            _wallAnchor = wallNow;
            changed = Math.Abs(_speed - clamped) > 0.0000001d;
            _speed = clamped;
        }

        if (changed)
        {
            try
            {
                SpeedChanged?.Invoke(clamped);
            }
            catch
            {
                // Observability must never become part of playback truth.
            }
        }

        return clamped;
    }

    public double AdjustSpeed(double delta)
    {
        if (!double.IsFinite(delta))
        {
            throw new ArgumentOutOfRangeException(nameof(delta), "Speed delta must be finite.");
        }

        double current;
        lock (_gate)
        {
            current = _speed;
        }

        return SetSpeed(current + delta);
    }

    public bool ToggleUserPause()
    {
        lock (_gate)
        {
            _isUserPaused = !_isUserPaused;
            return _isUserPaused;
        }
    }

    public void Pause()
    {
        lock (_gate)
        {
            _isUserPaused = true;
        }
    }

    public void Resume()
    {
        lock (_gate)
        {
            _isUserPaused = false;
        }
    }

    public async ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken)
    {
        while (true)
        {
            cancellationToken.ThrowIfCancellationRequested();

            TimeSpan wallTarget;
            lock (_gate)
            {
                var wallNow = _wallClock.Elapsed;
                var playbackNow = GetPlaybackNowLocked(wallNow);
                var remaining = target - playbackNow;
                if (remaining <= TimeSpan.Zero)
                {
                    return;
                }

                var wallRemaining = Divide(remaining, _speed);
                var slice = wallRemaining < ControlPollInterval
                    ? wallRemaining
                    : ControlPollInterval;
                wallTarget = wallNow + slice;
            }

            await _wallClock.DelayUntilAsync(wallTarget, cancellationToken).ConfigureAwait(false);
        }
    }

    private TimeSpan GetPlaybackNowLocked(TimeSpan wallNow)
    {
        var wallElapsed = wallNow - _wallAnchor;
        if (wallElapsed < TimeSpan.Zero)
        {
            throw new InvalidOperationException("The underlying monotonic clock moved backwards.");
        }

        return _playbackAnchor + Multiply(wallElapsed, _speed);
    }

    private static TimeSpan Multiply(TimeSpan value, double factor)
    {
        var ticks = value.Ticks * factor;
        if (!double.IsFinite(ticks) || ticks > long.MaxValue || ticks < long.MinValue)
        {
            throw new OverflowException("Scaled playback time exceeded TimeSpan range.");
        }

        return TimeSpan.FromTicks((long)Math.Round(ticks, MidpointRounding.AwayFromZero));
    }

    private static TimeSpan Divide(TimeSpan value, double divisor)
    {
        var ticks = value.Ticks / divisor;
        if (!double.IsFinite(ticks) || ticks > long.MaxValue || ticks < long.MinValue)
        {
            throw new OverflowException("Scaled wall-clock delay exceeded TimeSpan range.");
        }

        return TimeSpan.FromTicks(Math.Max(1L, (long)Math.Ceiling(ticks)));
    }

    private static void ValidateSpeed(double speed)
    {
        if (!double.IsFinite(speed) || speed <= 0d)
        {
            throw new ArgumentOutOfRangeException(nameof(speed), "Playback speed must be finite and greater than zero.");
        }
    }
}

/// <summary>
/// Presents user pause as an unfocused state so PlaybackKernel uses the exact
/// same safety behavior as real Roblox focus loss: release all keys, freeze
/// logical song progress, and resume only when both conditions are healthy.
/// </summary>
public sealed class PlaybackSessionFocusGate : IFocusGate
{
    private readonly IFocusGate _targetFocus;
    private readonly PlaybackSessionClock _sessionClock;

    public PlaybackSessionFocusGate(IFocusGate targetFocus, PlaybackSessionClock sessionClock)
    {
        _targetFocus = targetFocus ?? throw new ArgumentNullException(nameof(targetFocus));
        _sessionClock = sessionClock ?? throw new ArgumentNullException(nameof(sessionClock));
    }

    public bool IsTargetFocused => !_sessionClock.IsUserPaused && _targetFocus.IsTargetFocused;
}
