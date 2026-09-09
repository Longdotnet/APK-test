using RobloxPiano.Core;

namespace RobloxPiano.TimingTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var tests = new (string Name, Func<Task> Run)[]
        {
            ("dispatch lead advances physical edge dispatch", TestDispatchLeadAsync),
            ("neutral profile preserves legacy timing", TestNeutralTimingAsync),
            ("timing profile rejects unsafe values", TestProfileBoundsAsync)
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
        Console.WriteLine($"Timing tests: {tests.Length - failures.Count} passed, {failures.Count} failed.");
        return failures.Count == 0 ? 0 : 1;
    }

    private static async Task TestDispatchLeadAsync()
    {
        var clock = new ManualClock();
        var input = new RecordingInputSink(clock);
        var track = CreateTrack();
        var kernel = new PlaybackKernel(clock, input, new AlwaysFocused());

        await kernel.PlayAsync(
            track,
            new PlaybackOptions(
                Speed: 1d,
                InitialDelay: TimeSpan.Zero,
                FocusPollInterval: TimeSpan.FromMilliseconds(500),
                DispatchLead: TimeSpan.FromMilliseconds(30)));

        Equal(TimeSpan.FromMilliseconds(70), input.DownAt, "key-down dispatch");
        Equal(TimeSpan.FromMilliseconds(120), input.UpAt, "key-up dispatch");
    }

    private static async Task TestNeutralTimingAsync()
    {
        var clock = new ManualClock();
        var input = new RecordingInputSink(clock);
        var kernel = new PlaybackKernel(clock, input, new AlwaysFocused());

        await kernel.PlayAsync(
            CreateTrack(),
            new PlaybackOptions(
                Speed: 1d,
                InitialDelay: TimeSpan.Zero,
                FocusPollInterval: TimeSpan.FromMilliseconds(500),
                DispatchLead: PlaybackTimingProfile.Neutral.DispatchLead));

        Equal(TimeSpan.FromMilliseconds(100), input.DownAt, "neutral key-down timing");
        Equal(TimeSpan.FromMilliseconds(150), input.UpAt, "neutral key-up timing");
    }

    private static Task TestProfileBoundsAsync()
    {
        _ = PlaybackTimingProfile.FromMilliseconds(0);
        _ = PlaybackTimingProfile.FromMilliseconds(250);

        AssertThrows<ArgumentOutOfRangeException>(() => PlaybackTimingProfile.FromMilliseconds(-1));
        AssertThrows<ArgumentOutOfRangeException>(() => PlaybackTimingProfile.FromMilliseconds(251));
        return Task.CompletedTask;
    }

    private static PerformanceTrack CreateTrack()
    {
        return new PerformanceTrack(
            "timing",
            120,
            4,
            TimeSpan.Zero,
            new[] { new PerformanceEvent(TimeSpan.FromMilliseconds(100), TimeSpan.FromMilliseconds(50), new[] { 'a' }) },
            TimeSpan.FromMilliseconds(150));
    }

    private static void Equal<T>(T expected, T actual, string message)
        where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void AssertThrows<T>(Action action)
        where T : Exception
    {
        try
        {
            action();
        }
        catch (T)
        {
            return;
        }

        throw new InvalidOperationException($"Expected {typeof(T).Name}.");
    }

    private sealed class ManualClock : IMonotonicClock
    {
        public TimeSpan Elapsed { get; private set; }

        public ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            if (target > Elapsed)
            {
                Elapsed = target;
            }

            return ValueTask.CompletedTask;
        }
    }

    private sealed class RecordingInputSink(ManualClock clock) : IInputSink
    {
        public TimeSpan DownAt { get; private set; }
        public TimeSpan UpAt { get; private set; }

        public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            DownAt = clock.Elapsed;
            return ValueTask.CompletedTask;
        }

        public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            UpAt = clock.Elapsed;
            return ValueTask.CompletedTask;
        }

        public ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
            => ValueTask.CompletedTask;
    }

    private sealed class AlwaysFocused : IFocusGate
    {
        public bool IsTargetFocused => true;
    }
}
