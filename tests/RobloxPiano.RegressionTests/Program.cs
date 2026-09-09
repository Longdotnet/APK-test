using RobloxPiano.Core;

namespace RobloxPiano.RegressionTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var tests = new (string Name, Func<Task> Run)[]
        {
            ("legacy parser preserves timing and shifted keys", TestLegacyParserTimingAsync),
            ("planner releases before retrigger at equal timestamp", TestPlannerEdgeOrderingAsync),
            ("legacy x2 scales the absolute timeline", TestPlaybackSpeedAsync),
            ("playback always releases held keys on failure", TestReleaseAllOnFailureAsync),
            ("invalid and experimental metadata cannot silently corrupt baseline", TestValidationAsync)
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
        Console.WriteLine($"Regression tests: {tests.Length - failures.Count} passed, {failures.Count} failed.");
        return failures.Count == 0 ? 0 : 1;
    }

    private static Task TestLegacyParserTimingAsync()
    {
        const string sheet = """
            TITLE=Baseline
            BPM=120
            SUBDIV=4
            START_DELAY=0
            CHORD_HOLD=0.5
            LOOPS=1

            [aD] t . r
            """;

        var track = LegacySheetParser.Parse(sheet);
        Equal("Baseline", track.Title, "title");
        Equal(3, track.Events.Count, "event count");
        Equal(TimeSpan.Zero, track.Events[0].Start, "chord start");
        Equal("aD", new string(track.Events[0].Keys.ToArray()), "uppercase chord mapping");
        Equal(TimeSpan.FromMilliseconds(125), track.Events[1].Start, "second note start");
        Equal(TimeSpan.FromMilliseconds(375), track.Events[2].Start, "post-rest note start");
        Equal(TimeSpan.FromTicks(TimeSpan.FromMilliseconds(125).Ticks / 2), track.Events[0].Duration, "legacy hold duration");
        Equal(TimeSpan.FromMilliseconds(500), track.TimelineDuration, "timeline includes rest and note steps");
        return Task.CompletedTask;
    }

    private static Task TestPlannerEdgeOrderingAsync()
    {
        var track = new PerformanceTrack(
            "edge-order",
            120,
            4,
            TimeSpan.Zero,
            new[]
            {
                new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), new[] { 't' }),
                new PerformanceEvent(TimeSpan.FromMilliseconds(100), TimeSpan.FromMilliseconds(100), new[] { 't' })
            },
            TimeSpan.FromMilliseconds(200));

        var edges = PlaybackPlanner.BuildEdges(track);
        Equal(4, edges.Count, "edge count");
        Equal(PlaybackEdgeKind.KeyUp, edges[1].Kind, "same-time first edge must be KeyUp");
        Equal(PlaybackEdgeKind.KeyDown, edges[2].Kind, "same-time second edge must be KeyDown");
        Equal(TimeSpan.FromMilliseconds(100), edges[1].At, "release timestamp");
        Equal(TimeSpan.FromMilliseconds(100), edges[2].At, "retrigger timestamp");
        return Task.CompletedTask;
    }

    private static async Task TestPlaybackSpeedAsync()
    {
        var track = new PerformanceTrack(
            "speed",
            120,
            4,
            TimeSpan.Zero,
            new[]
            {
                new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), new[] { 't' }),
                new PerformanceEvent(TimeSpan.FromMilliseconds(200), TimeSpan.FromMilliseconds(100), new[] { 'r' })
            },
            TimeSpan.FromMilliseconds(300));

        var clock = new FakeClock();
        var input = new RecordingInput(clock);
        var kernel = new PlaybackKernel(clock, input, new AlwaysFocused());

        await kernel.PlayAsync(
            track,
            new PlaybackOptions(Speed: 2d, InitialDelay: TimeSpan.Zero, FocusPollInterval: TimeSpan.FromMilliseconds(10)));

        var edgeOperations = input.Operations.Where(operation => operation.Kind is "down" or "up").ToArray();
        Equal(4, edgeOperations.Length, "edge operation count");
        Equal(TimeSpan.Zero, edgeOperations[0].At, "first keydown");
        Equal(TimeSpan.FromMilliseconds(50), edgeOperations[1].At, "first keyup at x2");
        Equal(TimeSpan.FromMilliseconds(100), edgeOperations[2].At, "second keydown at x2");
        Equal(TimeSpan.FromMilliseconds(150), edgeOperations[3].At, "second keyup at x2");
    }

    private static async Task TestReleaseAllOnFailureAsync()
    {
        var track = new PerformanceTrack(
            "failure-safety",
            120,
            4,
            TimeSpan.Zero,
            new[]
            {
                new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), new[] { 't' })
            },
            TimeSpan.FromMilliseconds(100));

        var clock = new FakeClock();
        var input = new ThrowingInput(clock);
        var kernel = new PlaybackKernel(clock, input, new AlwaysFocused());

        var threw = false;
        try
        {
            await kernel.PlayAsync(
                track,
                new PlaybackOptions(Speed: 1d, InitialDelay: TimeSpan.Zero, FocusPollInterval: TimeSpan.FromMilliseconds(10)));
        }
        catch (SyntheticInputException)
        {
            threw = true;
        }

        True(threw, "synthetic input failure should escape the kernel");
        True(input.ReleaseAllCalls > 0, "release-all must run from finally after input failure");
    }

    private static Task TestValidationAsync()
    {
        Throws<FormatException>(() => LegacySheetParser.Parse("BPM=0\nt"), "zero BPM");
        Throws<FormatException>(() => LegacySheetParser.Parse("SUBDIV=0\nt"), "zero subdivision");
        Throws<FormatException>(() => LegacySheetParser.Parse("CHORD_HOLD=1.2\nt"), "hold greater than one");
        Throws<FormatException>(() => LegacySheetParser.Parse("u{2}"), "experimental V5 duration syntax");
        Throws<FormatException>(() => LegacySheetParser.Parse("[ad"), "unclosed chord");
        return Task.CompletedTask;
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

    private sealed class FakeClock : IMonotonicClock
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

    private sealed class AlwaysFocused : IFocusGate
    {
        public bool IsTargetFocused => true;
    }

    private sealed class RecordingInput(FakeClock clock) : IInputSink
    {
        public List<InputOperation> Operations { get; } = new();

        public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            Operations.Add(new InputOperation("down", clock.Elapsed, new string(keys.ToArray())));
            return ValueTask.CompletedTask;
        }

        public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            Operations.Add(new InputOperation("up", clock.Elapsed, new string(keys.ToArray())));
            return ValueTask.CompletedTask;
        }

        public ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
        {
            Operations.Add(new InputOperation("release-all", clock.Elapsed, string.Empty));
            return ValueTask.CompletedTask;
        }
    }

    private sealed class ThrowingInput(FakeClock clock) : IInputSink
    {
        public int ReleaseAllCalls { get; private set; }

        public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            throw new SyntheticInputException($"Synthetic key failure at {clock.Elapsed}.");
        }

        public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            throw new InvalidOperationException("KeyUp should not be reached after synthetic KeyDown failure.");
        }

        public ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
        {
            ReleaseAllCalls++;
            return ValueTask.CompletedTask;
        }
    }

    private sealed record InputOperation(string Kind, TimeSpan At, string Keys);

    private sealed class SyntheticInputException(string message) : Exception(message);
}
