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
        Run("structured diagnostic preserves client and Roblox session context", TestStructuredDiagnosticContext, failures);
        Run("structured diagnostic JSONL round-trips multiple sessions", TestStructuredDiagnosticJsonLines, failures);
        Run("structured diagnostic rejects impossible session time", TestStructuredDiagnosticRejectsImpossibleTime, failures);

        Console.WriteLine($"App recovery regressions: {14 - failures.Count} passed, {failures.Count} failed.");
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

    private static void TestStructuredDiagnosticContext()
    {
        var sourcePath = Path.Combine(Path.GetTempPath(), "wide-range.mid");
        var state = new ClientState(sourcePath, 1.25d, 17);
        var started = new DateTimeOffset(2026, 9, 10, 1, 2, 3, TimeSpan.FromHours(7));
        var ended = started.AddSeconds(12);
        var result = new PlaybackSessionResult(
            PlaybackSessionResultKind.AuthorizationLost,
            TimeSpan.FromSeconds(9.5),
            RobloxPlaybackAuthorizationFailure.ProcessReplaced,
            new RobloxPlaybackAuthorizationException(
                RobloxPlaybackAuthorizationFailure.ProcessReplaced,
                "PID lifetime changed"));

        var record = PlaybackSessionDiagnostics.CreateRecord(
            result,
            state,
            4242,
            638930000000000000L,
            started,
            ended,
            "session-1");

        Equal(PlaybackSessionDiagnostics.SchemaVersion, record.SchemaVersion, "diagnostic schema");
        Equal("session-1", record.SessionId, "session id");
        Equal("AuthorizationLost", record.ResultKind, "result kind");
        Equal("ProcessReplaced", record.AuthorizationFailure!, "authorization failure");
        Equal("MIDI", record.SourceType, "source type");
        Equal(Path.GetFullPath(sourcePath), record.SourcePath!, "source path");
        Equal(1.25d, record.PreferredSpeed, "speed");
        Equal(17, record.InputLatencyMs, "input latency");
        Equal(4242, record.RobloxProcessId!.Value, "Roblox PID");
        Equal(638930000000000000L, record.RobloxProcessStartTimeUtcTicks!.Value, "Roblox process lifetime");
        Equal(9.5d, record.PositionSeconds, "final position");
        Contains(record.ExceptionType ?? string.Empty, nameof(RobloxPlaybackAuthorizationException), "exception type");
        Contains(record.ExceptionMessage ?? string.Empty, "lifetime changed", "exception message");
        Equal(TimeSpan.Zero, record.StartedAtUtc.Offset, "start timestamp normalized to UTC");
        Equal(TimeSpan.Zero, record.EndedAtUtc.Offset, "end timestamp normalized to UTC");
    }

    private static void TestStructuredDiagnosticJsonLines()
    {
        var directory = Path.Combine(Path.GetTempPath(), "RobloxPiano-AppRecoveryTests", Guid.NewGuid().ToString("N"));
        var path = Path.Combine(directory, "sessions.jsonl");
        try
        {
            var state = new ClientState(Path.Combine(directory, "song.musicxml"), 1d, 0);
            var first = PlaybackSessionDiagnostics.CreateRecord(
                new PlaybackSessionResult(PlaybackSessionResultKind.Completed, TimeSpan.FromSeconds(15)),
                state,
                77,
                123456L,
                DateTimeOffset.UnixEpoch,
                DateTimeOffset.UnixEpoch.AddSeconds(15),
                "first");
            var second = PlaybackSessionDiagnostics.CreateRecord(
                new PlaybackSessionResult(PlaybackSessionResultKind.Cancelled, TimeSpan.FromSeconds(3)),
                state,
                77,
                123456L,
                DateTimeOffset.UnixEpoch.AddMinutes(1),
                DateTimeOffset.UnixEpoch.AddMinutes(1).AddSeconds(3),
                "second");

            PlaybackSessionDiagnostics.AppendRecord(path, first);
            PlaybackSessionDiagnostics.AppendRecord(path, second);

            var lines = File.ReadAllLines(path);
            Equal(2, lines.Length, "JSONL record count");
            var roundTrippedFirst = PlaybackSessionDiagnostics.DeserializeRecord(lines[0]);
            var roundTrippedSecond = PlaybackSessionDiagnostics.DeserializeRecord(lines[1]);
            Equal("first", roundTrippedFirst.SessionId, "first JSONL session");
            Equal("Completed", roundTrippedFirst.ResultKind, "first JSONL result");
            Equal("MusicXML", roundTrippedFirst.SourceType, "MusicXML source classification");
            Equal("second", roundTrippedSecond.SessionId, "second JSONL session");
            Equal("Cancelled", roundTrippedSecond.ResultKind, "second JSONL result");
        }
        finally
        {
            if (Directory.Exists(directory))
            {
                Directory.Delete(directory, recursive: true);
            }
        }
    }

    private static void TestStructuredDiagnosticRejectsImpossibleTime()
    {
        var result = new PlaybackSessionResult(PlaybackSessionResultKind.Completed, TimeSpan.Zero);
        var state = ClientState.Default;
        var threw = false;
        try
        {
            _ = PlaybackSessionDiagnostics.CreateRecord(
                result,
                state,
                null,
                null,
                DateTimeOffset.UnixEpoch.AddSeconds(2),
                DateTimeOffset.UnixEpoch,
                "bad-time");
        }
        catch (ArgumentException)
        {
            threw = true;
        }

        True(threw, "diagnostics must reject end timestamps before session start");
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
