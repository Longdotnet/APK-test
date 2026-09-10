using RobloxPiano.Core;

namespace RobloxPiano.TransportTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var tests = new (string Name, Func<Task> Run)[]
        {
            ("slice clips an active note at seek boundary", TestSliceClipsActiveNoteAsync),
            ("slice rejects impossible seek positions", TestInvalidSeekAsync),
            ("runtime seek releases old state and re-enters canonical note", TestRuntimeSeekSafetyAsync),
            ("transport position excludes target-focus downtime", TestPositionExcludesFocusDowntimeAsync),
            ("transport quality treats seek omissions as intentional", TestTransportQualitySeekSegmentationAsync),
            ("transport quality survives dynamic speed changes", TestTransportQualityDynamicSpeedAsync)
        };

        var failures = new List<string>();
        foreach (var test in tests)
        {
            try
            {
                await test.Run().ConfigureAwait(false);
                Console.WriteLine($"PASS  {test.Name}");
            }
            catch (Exception exception)
            {
                failures.Add($"{test.Name}: {exception.Message}");
                Console.Error.WriteLine($"FAIL  {test.Name}\n      {exception}");
            }
        }

        Console.WriteLine();
        Console.WriteLine($"Transport tests: {tests.Length - failures.Count} passed, {failures.Count} failed.");
        return failures.Count == 0 ? 0 : 1;
    }

    private static Task TestSliceClipsActiveNoteAsync()
    {
        var track = CreateTrack();
        var slice = PlaybackTransport.Slice(track, TimeSpan.FromMilliseconds(250));

        Equal(TimeSpan.FromMilliseconds(150), slice.TimelineDuration, "remaining timeline");
        Equal(TimeSpan.Zero, slice.StartDelay, "slice start delay");
        Equal(2, slice.Events.Count, "remaining event count");
        Equal(TimeSpan.Zero, slice.Events[0].Start, "crossing note must re-enter at slice zero");
        Equal(TimeSpan.FromMilliseconds(50), slice.Events[0].Duration, "crossing note remaining duration");
        Equal("b", new string(slice.Events[0].Keys.ToArray()), "crossing note key");
        Equal(TimeSpan.FromMilliseconds(100), slice.Events[1].Start, "future event offset");
        return Task.CompletedTask;
    }

    private static Task TestInvalidSeekAsync()
    {
        Throws<ArgumentOutOfRangeException>(
            () => PlaybackTransport.Slice(CreateTrack(), TimeSpan.FromMilliseconds(-1)),
            "negative seek");
        Throws<ArgumentOutOfRangeException>(
            () => PlaybackTransport.Slice(CreateTrack(), TimeSpan.FromSeconds(1)),
            "seek beyond duration");
        return Task.CompletedTask;
    }

    private static async Task TestRuntimeSeekSafetyAsync()
    {
        var clock = new HookClock();
        var input = new RecordingInput(clock);
        using var session = new PlaybackTransportSession(CreateTrack(), clock, input, new AlwaysFocused());

        var requested = false;
        clock.BeforeDelay = () =>
        {
            if (requested)
            {
                return;
            }

            requested = true;
            session.Seek(TimeSpan.FromMilliseconds(250));
        };

        await session.PlayAsync(TimeSpan.Zero).ConfigureAwait(false);

        var operations = input.Operations.ToArray();
        True(operations.Any(operation => operation == "down:a"), "first slice should begin note a");
        var firstRelease = Array.IndexOf(operations, "release-all");
        var reentry = Array.IndexOf(operations, "down:b");
        True(firstRelease >= 0, "seek cancellation must release held state");
        True(reentry > firstRelease, "new slice must re-enter only after release-all");
        True(operations.Contains("up:b"), "clipped crossing note must receive its matching key-up");
        Equal(TimeSpan.FromMilliseconds(400), session.Duration, "transport duration");
        Equal(TimeSpan.FromMilliseconds(400), session.Position, "completed position");
    }

    private static async Task TestPositionExcludesFocusDowntimeAsync()
    {
        var clock = new ManualClock();
        var focus = new MutableFocus();
        var input = new RecordingInput(clock);
        using var session = new PlaybackTransportSession(CreateTrack(), clock, input, focus);

        using var cancellation = new CancellationTokenSource();
        var playTask = session.PlayAsync(TimeSpan.Zero, cancellation.Token);

        await WaitUntilAsync(() => input.Operations.Contains("down:a")).ConfigureAwait(false);
        clock.Advance(TimeSpan.FromMilliseconds(40));
        var beforeLoss = session.Position;

        focus.Focused = false;
        clock.Advance(TimeSpan.FromMilliseconds(10));
        await WaitUntilAsync(() => input.Operations.Contains("release-all")).ConfigureAwait(false);
        clock.Advance(TimeSpan.FromMilliseconds(190));
        await Task.Yield();
        var duringLoss = session.Position;

        True(duringLoss - beforeLoss < TimeSpan.FromMilliseconds(30), "position must not consume focus-loss downtime");

        cancellation.Cancel();
        clock.Advance(TimeSpan.FromMilliseconds(20));
        try
        {
            await playTask.ConfigureAwait(false);
        }
        catch (OperationCanceledException)
        {
        }
    }

    private static async Task TestTransportQualitySeekSegmentationAsync()
    {
        var clock = new HookClock();
        var input = new RecordingInput(clock);
        using var session = new PlaybackTransportSession(CreateTrack(), clock, input, new AlwaysFocused());

        var requested = false;
        clock.BeforeDelay = () =>
        {
            if (requested)
            {
                return;
            }

            requested = true;
            session.Seek(TimeSpan.FromMilliseconds(250));
        };

        await session.PlayAsync(TimeSpan.Zero).ConfigureAwait(false);
        var quality = session.QualityReport;

        Equal(2, quality.SegmentCount, "seek should produce two quality segments");
        Equal(1, quality.SeekCount, "seek segment count");
        Equal(0, quality.UnexpectedMissingEdgeCount, "edges intentionally skipped by seek must not look lost");
        True(quality.InterruptedEdgeCount > 0, "seek should explain interrupted planned edges");
        Equal(0, quality.FailureCount, "seek must not be classified as playback failure");
        True(quality.DispatchedEdgeCount > 0, "quality must include actual dispatched edges");
        True(double.IsFinite(quality.P95AbsoluteTimingErrorMilliseconds), "p95 timing evidence must be finite");
    }

    private static async Task TestTransportQualityDynamicSpeedAsync()
    {
        var wallClock = new HookClock();
        var sessionClock = new PlaybackSessionClock(wallClock, 1d);
        var input = new RecordingInput(sessionClock);
        using var session = new PlaybackTransportSession(CreateTrack(), sessionClock, input, new AlwaysFocused());

        var changed = false;
        wallClock.BeforeDelay = () =>
        {
            if (changed)
            {
                return;
            }

            changed = true;
            sessionClock.SetSpeed(2d);
        };

        await session.PlayAsync(TimeSpan.Zero).ConfigureAwait(false);
        var quality = session.QualityReport;

        Equal(1, quality.SegmentCount, "speed change must not split canonical transport segment");
        Equal(0, quality.SeekCount, "speed change is not a seek");
        Equal(0, quality.UnexpectedMissingEdgeCount, "dynamic speed must not create false missing edges");
        Equal(0, quality.FailureCount, "dynamic speed must not create playback failures");
        Equal(PlaybackPlanner.BuildEdges(CreateTrack()).Count, quality.DispatchedEdgeCount, "all canonical edges must remain observed");
        True(double.IsFinite(quality.MeanAbsoluteTimingErrorMilliseconds), "mean timing evidence must remain finite");
        True(double.IsFinite(quality.MaxInputCallMilliseconds), "input-call evidence must remain finite");
    }

    private static PerformanceTrack CreateTrack()
    {
        return new PerformanceTrack(
            "transport",
            120,
            4,
            TimeSpan.FromSeconds(5),
            new[]
            {
                new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), new[] { 'a' }),
                new PerformanceEvent(TimeSpan.FromMilliseconds(200), TimeSpan.FromMilliseconds(100), new[] { 'b' }),
                new PerformanceEvent(TimeSpan.FromMilliseconds(350), TimeSpan.FromMilliseconds(40), new[] { 'c' })
            },
            TimeSpan.FromMilliseconds(400));
    }

    private static async Task WaitUntilAsync(Func<bool> predicate)
    {
        for (var attempt = 0; attempt < 1000; attempt++)
        {
            if (predicate())
            {
                return;
            }

            await Task.Yield();
        }

        throw new InvalidOperationException("Timed out waiting for deterministic test condition.");
    }

    private static void Equal<T>(T expected, T actual, string message)
        where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }

    private static void Throws<TException>(Action action, string message)
        where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }

        throw new InvalidOperationException($"{message}: expected {typeof(TException).Name}.");
    }

    private sealed class AlwaysFocused : IFocusGate
    {
        public bool IsTargetFocused => true;
    }

    private sealed class MutableFocus : IFocusGate
    {
        public bool Focused { get; set; } = true;
        public bool IsTargetFocused => Focused;
    }

    private sealed class RecordingInput(IMonotonicClock clock) : IInputSink
    {
        public List<string> Operations { get; } = new();

        public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            _ = clock.Elapsed;
            Operations.Add($"down:{new string(keys.ToArray())}");
            return ValueTask.CompletedTask;
        }

        public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            _ = clock.Elapsed;
            Operations.Add($"up:{new string(keys.ToArray())}");
            return ValueTask.CompletedTask;
        }

        public ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
        {
            _ = clock.Elapsed;
            Operations.Add("release-all");
            return ValueTask.CompletedTask;
        }
    }

    private sealed class HookClock : IMonotonicClock
    {
        public TimeSpan Elapsed { get; private set; }
        public Action? BeforeDelay { get; set; }

        public ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken)
        {
            BeforeDelay?.Invoke();
            cancellationToken.ThrowIfCancellationRequested();
            if (target > Elapsed)
            {
                Elapsed = target;
            }

            return ValueTask.CompletedTask;
        }
    }

    private sealed class ManualClock : IMonotonicClock
    {
        private readonly object _gate = new();
        private TaskCompletionSource _advanced = NewSignal();
        private TimeSpan _elapsed;

        public TimeSpan Elapsed
        {
            get
            {
                lock (_gate)
                {
                    return _elapsed;
                }
            }
        }

        public void Advance(TimeSpan duration)
        {
            TaskCompletionSource signal;
            lock (_gate)
            {
                _elapsed += duration;
                signal = _advanced;
                _advanced = NewSignal();
            }

            signal.TrySetResult();
        }

        public async ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken)
        {
            while (Elapsed < target)
            {
                Task wait;
                lock (_gate)
                {
                    wait = _advanced.Task;
                }

                await wait.WaitAsync(cancellationToken).ConfigureAwait(false);
            }
        }

        private static TaskCompletionSource NewSignal()
        {
            return new TaskCompletionSource(TaskCreationOptions.RunContinuationsAsynchronously);
        }
    }
}
