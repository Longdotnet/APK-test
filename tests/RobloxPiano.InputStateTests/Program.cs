using RobloxPiano.Core;

namespace RobloxPiano.InputStateTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var tests = new (string Name, Func<Task> Run)[]
        {
            ("overlapping same-key notes keep physical key held until final owner releases", TestOverlappingSameKeyAsync),
            ("mixed chord overlap releases only keys whose final hold ended", TestMixedChordOverlapAsync),
            ("release-all clears logical ownership and stale key-up becomes harmless", TestReleaseAllInvalidatesOldEdgesAsync),
            ("failed physical transition does not commit logical ownership", TestFailureDoesNotCommitOwnershipAsync)
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
        Console.WriteLine($"Input-state tests: {tests.Length - failures.Count} passed, {failures.Count} failed.");
        return failures.Count == 0 ? 0 : 1;
    }

    private static async Task TestOverlappingSameKeyAsync()
    {
        var physical = new RecordingInputSink();
        var state = new ReferenceCountedInputSink(physical);

        await state.KeyDownAsync(new[] { 'a' }, CancellationToken.None);
        await state.KeyDownAsync(new[] { 'a' }, CancellationToken.None);
        Equal(2, state.LogicalHoldCount, "logical overlap count");
        SequenceEqual(new[] { "down:a" }, physical.Operations, "second logical hold must not repeat physical key-down");

        await state.KeyUpAsync(new[] { 'a' }, CancellationToken.None);
        Equal(1, state.LogicalHoldCount, "first note end must preserve later owner");
        SequenceEqual(new[] { "down:a" }, physical.Operations, "first logical release must not release physical key");

        await state.KeyUpAsync(new[] { 'a' }, CancellationToken.None);
        Equal(0, state.LogicalHoldCount, "final owner ended");
        SequenceEqual(new[] { "down:a", "up:a" }, physical.Operations, "physical key-up occurs only after final owner");
    }

    private static async Task TestMixedChordOverlapAsync()
    {
        var physical = new RecordingInputSink();
        var state = new ReferenceCountedInputSink(physical);

        await state.KeyDownAsync(new[] { 'a', 'b' }, CancellationToken.None);
        await state.KeyDownAsync(new[] { 'b', 'c' }, CancellationToken.None);
        await state.KeyUpAsync(new[] { 'a', 'b' }, CancellationToken.None);

        SequenceEqual(
            new[] { "down:ab", "down:c", "up:a" },
            physical.Operations,
            "shared b must remain held while independent a is released");
        Equal(2, state.LogicalHoldCount, "b and c remain logically held");

        await state.KeyUpAsync(new[] { 'b', 'c' }, CancellationToken.None);
        SequenceEqual(
            new[] { "down:ab", "down:c", "up:a", "up:bc" },
            physical.Operations,
            "final overlapping chord must release b and c together");
        Equal(0, state.LogicalHoldCount, "all holds released");
    }

    private static async Task TestReleaseAllInvalidatesOldEdgesAsync()
    {
        var physical = new RecordingInputSink();
        var state = new ReferenceCountedInputSink(physical);

        await state.KeyDownAsync(new[] { 'x' }, CancellationToken.None);
        await state.ReleaseAllAsync(CancellationToken.None);
        Equal(0, state.LogicalHoldCount, "release-all clears logical state");

        await state.KeyUpAsync(new[] { 'x' }, CancellationToken.None);
        SequenceEqual(
            new[] { "down:x", "release-all" },
            physical.Operations,
            "stale key-up from pre-focus-loss or pre-seek slice must be ignored");
    }

    private static async Task TestFailureDoesNotCommitOwnershipAsync()
    {
        var physical = new RecordingInputSink { FailNextDown = true };
        var state = new ReferenceCountedInputSink(physical);

        try
        {
            await state.KeyDownAsync(new[] { 'z' }, CancellationToken.None);
            throw new InvalidOperationException("expected injected input failure");
        }
        catch (InjectedInputException)
        {
        }

        Equal(0, state.LogicalHoldCount, "failed physical key-down must not create phantom logical hold");
        await state.KeyDownAsync(new[] { 'z' }, CancellationToken.None);
        await state.KeyUpAsync(new[] { 'z' }, CancellationToken.None);
        SequenceEqual(new[] { "down:z", "up:z" }, physical.Operations, "retry after physical failure remains consistent");
    }

    private static void Equal<T>(T expected, T actual, string message)
        where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void SequenceEqual(IReadOnlyList<string> expected, IReadOnlyList<string> actual, string message)
    {
        if (!expected.SequenceEqual(actual, StringComparer.Ordinal))
        {
            throw new InvalidOperationException(
                $"{message}: expected [{string.Join(", ", expected)}], actual [{string.Join(", ", actual)}].");
        }
    }

    private sealed class RecordingInputSink : IInputSink
    {
        public List<string> Operations { get; } = new();
        public bool FailNextDown { get; set; }

        public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            if (FailNextDown)
            {
                FailNextDown = false;
                throw new InjectedInputException();
            }

            Operations.Add($"down:{new string(keys.ToArray())}");
            return ValueTask.CompletedTask;
        }

        public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            Operations.Add($"up:{new string(keys.ToArray())}");
            return ValueTask.CompletedTask;
        }

        public ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
        {
            Operations.Add("release-all");
            return ValueTask.CompletedTask;
        }
    }

    private sealed class InjectedInputException : Exception
    {
    }
}
