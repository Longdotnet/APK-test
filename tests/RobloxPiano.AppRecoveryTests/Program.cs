using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var failures = new List<string>();
        Run("verification-required recovery is actionable", TestVerificationRequired, failures);
        Run("process-ended recovery is actionable", TestProcessEnded, failures);
        Run("process-replaced recovery is actionable", TestProcessReplaced, failures);
        Run("authorization exception preserves deterministic failure kind", TestAuthorizationException, failures);
        await RunAsync("completed session becomes Completed result", TestCompletedResultAsync, failures);
        await RunAsync("cancellation becomes Cancelled result", TestCancelledResultAsync, failures);
        await RunAsync("authorization loss becomes AuthorizationLost result", TestAuthorizationLostResultAsync, failures);
        await RunAsync("input injection failure becomes InputFailed result", TestInputFailedResultAsync, failures);
        await RunAsync("runtime failure becomes RuntimeFailed result", TestRuntimeFailedResultAsync, failures);
        Run("source load failure has deterministic presentation", TestSourceFailedPresentation, failures);
        Run("authorization result preserves Library recovery", TestAuthorizationPresentation, failures);

        Console.WriteLine($"App recovery regressions: {11 - failures.Count} passed, {failures.Count} failed.");
        foreach (var failure in failures)
        {
            Console.Error.WriteLine(failure);
        }

        return failures.Count == 0 ? 0 : 1;
    }

    private static void TestVerificationRequired()
    {
        var recovery = RobloxPlaybackAuthorizationRecoveryPolicy.Describe(
            RobloxPlaybackAuthorizationFailure.VerificationRequired);

        Contains(recovery.PlayerStatusText, "Sheet Library", "player status should return client to Library");
        Contains(recovery.DialogMessage, "Verify Input & Play", "dialog should name the exact recovery action");
        Contains(recovery.DialogMessage, "No unverified input", "dialog should explain fail-closed behavior");
    }

    private static void TestProcessEnded()
    {
        var recovery = RobloxPlaybackAuthorizationRecoveryPolicy.Describe(
            RobloxPlaybackAuthorizationFailure.ProcessEnded);

        Contains(recovery.DialogTitle, "closed", "ended process title");
        Contains(recovery.DialogMessage, "reopen Roblox", "ended process should tell client to reopen Roblox");
        Contains(recovery.DialogMessage, "Verify Input & Play", "new process must require verification");
    }

    private static void TestProcessReplaced()
    {
        var recovery = RobloxPlaybackAuthorizationRecoveryPolicy.Describe(
            RobloxPlaybackAuthorizationFailure.ProcessReplaced);

        Contains(recovery.DialogTitle, "restarted", "replacement title");
        Contains(recovery.DialogMessage, "process ID", "replacement should explain process identity change");
        Contains(recovery.DialogMessage, "Verify Input & Play", "replacement must require fresh verification");
    }

    private static void TestAuthorizationException()
    {
        foreach (var failure in Enum.GetValues<RobloxPlaybackAuthorizationFailure>())
        {
            var exception = new RobloxPlaybackAuthorizationException(failure, $"test-{failure}");
            Equal(failure, exception.Failure, "exception failure kind");
            InvalidOperationException baseException = exception;
            Contains(baseException.Message, failure.ToString(), "authorization exception should remain a normal invalid-operation failure with its diagnostic detail");
        }
    }

    private static async Task TestCompletedResultAsync()
    {
        var result = await PlaybackSessionResultCapture.RunAsync(
            () => Task.CompletedTask,
            () => TimeSpan.FromSeconds(12));

        Equal(PlaybackSessionResultKind.Completed, result.Kind, "completed kind");
        Equal(TimeSpan.FromSeconds(12), result.Position, "completed position");
        True(!result.ShouldReturnToLibrary, "completed session should remain in player");
    }

    private static async Task TestCancelledResultAsync()
    {
        var result = await PlaybackSessionResultCapture.RunAsync(
            () => Task.FromCanceled(new CancellationToken(canceled: true)),
            () => TimeSpan.FromSeconds(3));

        Equal(PlaybackSessionResultKind.Cancelled, result.Kind, "cancelled kind");
        Equal(TimeSpan.FromSeconds(3), result.Position, "cancelled position");
    }

    private static async Task TestAuthorizationLostResultAsync()
    {
        var result = await PlaybackSessionResultCapture.RunAsync(
            () => Task.FromException(new RobloxPlaybackAuthorizationException(
                RobloxPlaybackAuthorizationFailure.ProcessReplaced,
                "process replaced")),
            () => TimeSpan.FromSeconds(8));

        Equal(PlaybackSessionResultKind.AuthorizationLost, result.Kind, "authorization kind");
        Equal(RobloxPlaybackAuthorizationFailure.ProcessReplaced, result.AuthorizationFailure!.Value, "authorization failure");
        True(result.ShouldReturnToLibrary, "authorization loss must return to Library");
    }

    private static async Task TestInputFailedResultAsync()
    {
        var result = await PlaybackSessionResultCapture.RunAsync(
            () => Task.FromException(new WindowsInputInjectionException("cannot map key")),
            () => TimeSpan.FromSeconds(5));

        Equal(PlaybackSessionResultKind.InputFailed, result.Kind, "input failure kind");
        var presentation = PlaybackSessionPresentationPolicy.Describe(result);
        Contains(presentation.DialogTitle ?? string.Empty, "Input", "input failure title");
        Contains(presentation.DialogMessage ?? string.Empty, "Test Roblox Input", "input failure recovery action");
    }

    private static async Task TestRuntimeFailedResultAsync()
    {
        var result = await PlaybackSessionResultCapture.RunAsync(
            () => Task.FromException(new InvalidOperationException("runtime broke")),
            () => TimeSpan.FromSeconds(9));

        Equal(PlaybackSessionResultKind.RuntimeFailed, result.Kind, "runtime failure kind");
        True(result.Exception is InvalidOperationException, "runtime diagnostic exception retained");
    }

    private static void TestSourceFailedPresentation()
    {
        var result = PlaybackSessionResult.SourceFailure(
            new FormatException("bad song"),
            TimeSpan.FromSeconds(2));
        Equal(PlaybackSessionResultKind.SourceFailed, result.Kind, "source failure kind");

        var presentation = PlaybackSessionPresentationPolicy.Describe(result);
        Contains(presentation.StatusText, "could not be loaded", "source status");
        Contains(presentation.DialogMessage ?? string.Empty, "bad song", "source diagnostic message");
        True(!presentation.ReturnToLibrary, "source failure should not force-close player");
    }

    private static void TestAuthorizationPresentation()
    {
        var result = new PlaybackSessionResult(
            PlaybackSessionResultKind.AuthorizationLost,
            TimeSpan.FromSeconds(4),
            RobloxPlaybackAuthorizationFailure.ProcessEnded);

        var presentation = PlaybackSessionPresentationPolicy.Describe(result);
        True(presentation.ReturnToLibrary, "authorization presentation must return to Library");
        Contains(presentation.DialogMessage ?? string.Empty, "Verify Input & Play", "authorization presentation recovery action");
    }

    private static void Run(string name, Action test, ICollection<string> failures)
    {
        try
        {
            test();
            Console.WriteLine($"PASS  {name}");
        }
        catch (Exception exception)
        {
            failures.Add($"FAIL  {name}: {exception}");
        }
    }

    private static async Task RunAsync(string name, Func<Task> test, ICollection<string> failures)
    {
        try
        {
            await test();
            Console.WriteLine($"PASS  {name}");
        }
        catch (Exception exception)
        {
            failures.Add($"FAIL  {name}: {exception}");
        }
    }

    private static void Contains(string actual, string expected, string message)
    {
        if (!actual.Contains(expected, StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}' in '{actual}'.");
        }
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
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
}
