using RobloxPiano.Core;

namespace RobloxPiano.QualityTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var tests = new (string Name, Func<Task> Run)[]
        {
            ("plan fingerprint is stable and speed-sensitive", TestFingerprintAsync),
            ("instrumentation measures scheduler drift relative to first dispatch", TestRelativeTimingAsync),
            ("focus pauses are measured and removed from scheduler error", TestFocusPauseAsync),
            ("observer failures never interrupt playback", TestObserverIsolationAsync),
            ("A/B comparator distinguishes better worse and incomparable", TestComparatorAsync),
            ("dispatch-plan mismatch is surfaced as a quality failure", TestPlanMismatchAsync)
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
        Console.WriteLine($"Quality tests: {tests.Length - failures.Count} passed, {failures.Count} failed.");
        return failures.Count == 0 ? 0 : 1;
    }

    private static Task TestFingerprintAsync()
    {
        var track = CreateTrack();
        var one = PlaybackPlanFingerprint.Compute(track, 1d);
        var oneAgain = PlaybackPlanFingerprint.Compute(track, 1d);
        var two = PlaybackPlanFingerprint.Compute(track, 2d);

        Equal(one, oneAgain, "same plan must have stable fingerprint");
        True(!string.Equals(one, two, StringComparison.Ordinal), "speed must participate in the fingerprint");
        return Task.CompletedTask;
    }

    private static async Task TestRelativeTimingAsync()
    {
        var track = CreateTrack();
        var clock = new FakeClock(TimeSpan.FromMilliseconds(5));
        var collector = new PlaybackQualityCollector();
        var instrumented = PlaybackInstrumentation.Create(
            track,
            1d,
            clock,
            new NoOpInput(),
            new AlwaysFocused(),
            collector);

        var kernel = new PlaybackKernel(clock, instrumented.Input, instrumented.Focus);
        await kernel.PlayAsync(
            track,
            new PlaybackOptions(1d, TimeSpan.Zero, TimeSpan.FromMilliseconds(10)));

        var report = collector.BuildReport(track, 1d);
        Equal(report.PlannedEdgeCount, report.DispatchedEdgeCount, "all edges dispatched");
        Equal(0, report.MissingEdgeCount, "no missing edges");
        Equal(0, report.FailureCount, "no quality failures");
        True(report.MaxAbsoluteTimingErrorMilliseconds >= 4.9d, "clock overshoot should be measurable");
        True(report.P95AbsoluteTimingErrorMilliseconds >= 4.9d, "p95 should expose repeated overshoot");
    }

    private static async Task TestFocusPauseAsync()
    {
        var track = new PerformanceTrack(
            "focus",
            120,
            4,
            TimeSpan.Zero,
            new[]
            {
                new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(20), new[] { 't' }),
                new PerformanceEvent(TimeSpan.FromMilliseconds(100), TimeSpan.FromMilliseconds(20), new[] { 'r' })
            },
            TimeSpan.FromMilliseconds(120));

        var clock = new FakeClock(TimeSpan.Zero);
        var collector = new PlaybackQualityCollector();
        var focus = new FocusWindow(clock, TimeSpan.FromMilliseconds(30), TimeSpan.FromMilliseconds(60));
        var instrumented = PlaybackInstrumentation.Create(track, 1d, clock, new NoOpInput(), focus, collector);
        var kernel = new PlaybackKernel(clock, instrumented.Input, instrumented.Focus);

        await kernel.PlayAsync(
            track,
            new PlaybackOptions(1d, TimeSpan.Zero, TimeSpan.FromMilliseconds(10)));

        var report = collector.BuildReport(track, 1d);
        Equal(1, report.FocusPauseCount, "one focus pause");
        Equal(30d, report.FocusPausedMilliseconds, "focus pause duration");
        Equal(0, report.MissingEdgeCount, "focus pause must not drop edges");
        True(report.MaxAbsoluteTimingErrorMilliseconds < 0.01d, "focus pause must be normalized out of scheduler error");
    }

    private static async Task TestObserverIsolationAsync()
    {
        var track = CreateTrack();
        var clock = new FakeClock(TimeSpan.Zero);
        var instrumented = PlaybackInstrumentation.Create(
            track,
            1d,
            clock,
            new NoOpInput(),
            new AlwaysFocused(),
            new ThrowingObserver());

        var kernel = new PlaybackKernel(clock, instrumented.Input, instrumented.Focus);
        await kernel.PlayAsync(
            track,
            new PlaybackOptions(1d, TimeSpan.Zero, TimeSpan.FromMilliseconds(10)));
    }

    private static Task TestComparatorAsync()
    {
        var baseline = CreateReport("same", 10d, 20d);
        var better = CreateReport("same", 5d, 20d);
        var worse = CreateReport("same", 15d, 30d);
        var mismatch = CreateReport("different", 1d, 1d);

        Equal(PlaybackComparisonVerdict.Better, PlaybackQualityComparator.Compare(baseline, better).Verdict, "better verdict");
        Equal(PlaybackComparisonVerdict.Worse, PlaybackQualityComparator.Compare(baseline, worse).Verdict, "worse verdict");
        Equal(PlaybackComparisonVerdict.Incomparable, PlaybackQualityComparator.Compare(baseline, mismatch).Verdict, "mismatched plans");
        return Task.CompletedTask;
    }

    private static async Task TestPlanMismatchAsync()
    {
        var track = CreateTrack();
        var clock = new FakeClock(TimeSpan.Zero);
        var collector = new PlaybackQualityCollector();
        var instrumentation = PlaybackInstrumentation.Create(
            track,
            1d,
            clock,
            new NoOpInput(),
            new AlwaysFocused(),
            collector);

        await instrumentation.Input.KeyUpAsync(new[] { 'X' }, CancellationToken.None);
        await instrumentation.Input.ReleaseAllAsync(CancellationToken.None);

        var report = collector.BuildReport(track, 1d);
        True(report.FailureCount > 0, "plan mismatch must be recorded");
    }

    private static PerformanceTrack CreateTrack()
    {
        return new PerformanceTrack(
            "quality",
            120,
            4,
            TimeSpan.Zero,
            new[]
            {
                new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(50), new[] { 't' }),
                new PerformanceEvent(TimeSpan.FromMilliseconds(100), TimeSpan.FromMilliseconds(50), new[] { 'r' })
            },
            TimeSpan.FromMilliseconds(150));
    }

    private static PlaybackQualityReport CreateReport(string fingerprint, double p95, double max)
    {
        return new PlaybackQualityReport(
            PlaybackQualityReport.CurrentSchemaVersion,
            "test",
            fingerprint,
            1d,
            4,
            4,
            0,
            0,
            0,
            0d,
            1,
            0d,
            p95,
            p95,
            max,
            0d,
            0d,
            Array.Empty<PlaybackTimingSample>());
    }

    private static void Equal<T>(T expected, T actual, string message)
        where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void True(bool value, string message)
    {
        if (!value)
        {
            throw new InvalidOperationException(message);
        }
    }

    private sealed class FakeClock(TimeSpan overshoot) : IMonotonicClock
    {
        public TimeSpan Elapsed { get; private set; }

        public ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            if (target > Elapsed)
            {
                Elapsed = target + overshoot;
            }

            return ValueTask.CompletedTask;
        }
    }

    private sealed class NoOpInput : IInputSink
    {
        public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            return ValueTask.CompletedTask;
        }

        public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            return ValueTask.CompletedTask;
        }

        public ValueTask ReleaseAllAsync(CancellationToken cancellationToken) => ValueTask.CompletedTask;
    }

    private sealed class AlwaysFocused : IFocusGate
    {
        public bool IsTargetFocused => true;
    }

    private sealed class FocusWindow(FakeClock clock, TimeSpan start, TimeSpan end) : IFocusGate
    {
        public bool IsTargetFocused => clock.Elapsed < start || clock.Elapsed >= end;
    }

    private sealed class ThrowingObserver : IPlaybackObserver
    {
        public void Observe(PlaybackObservation observation) => throw new InvalidOperationException("observer failure");
    }
}
