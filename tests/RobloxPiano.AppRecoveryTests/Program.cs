using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class Program
{
    public static int Main()
    {
        var failures = new List<string>();
        Run("verification-required recovery is actionable", TestVerificationRequired, failures);
        Run("process-ended recovery is actionable", TestProcessEnded, failures);
        Run("process-replaced recovery is actionable", TestProcessReplaced, failures);
        Run("authorization exception preserves deterministic failure kind", TestAuthorizationException, failures);

        Console.WriteLine($"App recovery regressions: {4 - failures.Count} passed, {failures.Count} failed.");
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
            True(exception is InvalidOperationException, "authorization exception should remain compatible with runtime invalid-operation handling");
        }
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
