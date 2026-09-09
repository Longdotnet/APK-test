namespace RobloxPiano.App;

/// <summary>
/// Synchronous Windows entrypoint that guarantees WinForms starts on an STA thread before any
/// async command-line path can participate. WinForms OLE drag/drop registration depends on STA.
/// </summary>
internal static class ClientEntryPoint
{
    [STAThread]
    public static int Main(string[] args)
    {
        if (args.Length == 1 && args[0].Equals("--ui-smoke", StringComparison.OrdinalIgnoreCase))
        {
            return RunUiStartupSmoke();
        }

        if (args.Length == 1 && args[0].Equals("--input-abi-smoke", StringComparison.OrdinalIgnoreCase))
        {
            return RunInputCompatibilitySmoke();
        }

        if (args.Length == 1 && args[0].Equals("--roblox-input-field-test", StringComparison.OrdinalIgnoreCase))
        {
            return RunRobloxInputFieldTestAsync().GetAwaiter().GetResult();
        }

        return Program.Main(args).GetAwaiter().GetResult();
    }

    private static int RunUiStartupSmoke()
    {
        if (Thread.CurrentThread.GetApartmentState() != ApartmentState.STA)
        {
            Console.Error.WriteLine($"UI startup thread is {Thread.CurrentThread.GetApartmentState()}, expected STA.");
            return 5;
        }

        try
        {
            ApplicationConfiguration.Initialize();

            using var library = new SheetLibraryForm();
            _ = library.Handle;

            using var player = new ClientMainForm();
            _ = player.Handle;

            using var inputCheck = new RobloxInputCheckDialog();
            _ = inputCheck.Handle;

            Console.WriteLine(
                $"UI startup smoke passed. apartment={Thread.CurrentThread.GetApartmentState()}; " +
                $"libraryDragDrop={library.AllowDrop}; playerDragDrop={player.AllowDrop}; inputCheckReady=true.");
            return 0;
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"UI startup smoke failed: {exception}");
            return 6;
        }
    }

    private static int RunInputCompatibilitySmoke()
    {
        try
        {
            const ushort virtualKeyA = 0x41;
            var down = WindowsKeyboardInputSink.BuildFieldBaselineKeyEvent(virtualKeyA, keyUp: false);
            var up = WindowsKeyboardInputSink.BuildFieldBaselineKeyEvent(virtualKeyA, keyUp: true);

            if (down.VirtualKey != virtualKeyA || down.Flags != 0)
            {
                throw new InvalidOperationException("Roblox field-baseline key-down event is invalid.");
            }

            if (up.VirtualKey != virtualKeyA || up.Flags != NativeMethods.KeyEventKeyUp)
            {
                throw new InvalidOperationException("Roblox field-baseline key-up event is invalid.");
            }

            if (WindowsKeyboardInputSink.MinimumPhysicalKeyHold < TimeSpan.FromMilliseconds(30))
            {
                throw new InvalidOperationException("Roblox physical key hold floor is too short for field parity.");
            }

            if (WindowsKeyboardInputSink.RemainingMinimumPhysicalHold(TimeSpan.FromMilliseconds(5)) <= TimeSpan.Zero)
            {
                throw new InvalidOperationException("Short physical key pulses must be extended before key-up.");
            }

            if (WindowsKeyboardInputSink.RemainingMinimumPhysicalHold(TimeSpan.FromMilliseconds(500)) != TimeSpan.Zero)
            {
                throw new InvalidOperationException("Normal long key holds must not be extended.");
            }

            if (RobloxFieldInputPolicy.StableFocusDuration <= TimeSpan.Zero
                || RobloxFieldInputPolicy.ProbeHoldDuration <= WindowsKeyboardInputSink.MinimumPhysicalKeyHold)
            {
                throw new InvalidOperationException("Roblox field-input readiness policy is invalid.");
            }

            AssertInputVerdict(
                new RobloxFieldInputProbeResult(false, false, false, false, 0, TimeSpan.Zero),
                null,
                RobloxInputCheckVerdict.ActivationFailed,
                expectedSuccess: false);
            AssertInputVerdict(
                new RobloxFieldInputProbeResult(true, false, false, false, 0, TimeSpan.Zero),
                null,
                RobloxInputCheckVerdict.FocusUnstable,
                expectedSuccess: false);
            AssertInputVerdict(
                new RobloxFieldInputProbeResult(true, true, false, true, 0x57, TimeSpan.FromMilliseconds(650)),
                null,
                RobloxInputCheckVerdict.WindowsKeyStateNotObserved,
                expectedSuccess: false);
            AssertInputVerdict(
                new RobloxFieldInputProbeResult(true, true, true, false, 0x57, TimeSpan.FromMilliseconds(650)),
                null,
                RobloxInputCheckVerdict.FocusLostDuringProbe,
                expectedSuccess: false);
            AssertInputVerdict(
                new RobloxFieldInputProbeResult(true, true, true, true, 0x57, TimeSpan.FromMilliseconds(650)),
                null,
                RobloxInputCheckVerdict.NativeDeliveryAwaitingObservation,
                expectedSuccess: false);
            AssertInputVerdict(
                new RobloxFieldInputProbeResult(true, true, true, true, 0x57, TimeSpan.FromMilliseconds(650)),
                false,
                RobloxInputCheckVerdict.RobloxDidNotReact,
                expectedSuccess: false);
            AssertInputVerdict(
                new RobloxFieldInputProbeResult(true, true, true, true, 0x57, TimeSpan.FromMilliseconds(650)),
                true,
                RobloxInputCheckVerdict.Confirmed,
                expectedSuccess: true);

            AssertInputHealthSessionSemantics();
            AssertPlaybackPreflightSemantics();

            if (RobloxProcessLocator.IsRobloxPlayerProcess("RobloxPiano"))
            {
                throw new InvalidOperationException("RobloxPiano client must never be classified as the Roblox player target.");
            }

            if (!RobloxProcessLocator.IsRobloxPlayerProcess("RobloxPlayerBeta")
                || !RobloxProcessLocator.IsRobloxPlayerProcess("RobloxPlayer"))
            {
                throw new InvalidOperationException("Known Roblox player process names must remain targetable.");
            }

            if (RobloxProcessLocator.IsRobloxPlayerProcess("RobloxStudioBeta"))
            {
                throw new InvalidOperationException("Roblox Studio must not be classified as a player target.");
            }

            Console.WriteLine(
                $"Windows input compatibility smoke passed. backend={WindowsKeyboardInputSink.BackendName}; " +
                $"vk=0x41; scanCode=0; downFlags=0; upFlags=KEYEVENTF_KEYUP; " +
                $"minimumPhysicalHoldMs={WindowsKeyboardInputSink.MinimumPhysicalKeyHold.TotalMilliseconds:0}; " +
                $"stableFocusMs={RobloxFieldInputPolicy.StableFocusDuration.TotalMilliseconds:0}; " +
                $"guiVerdicts=7; sessionHealth=pid-scoped; playbackPreflight=pid-scoped; targetSelfExcluded=true.");
            return 0;
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"Windows input compatibility smoke failed: {exception}");
            return 7;
        }
    }

    private static void AssertInputHealthSessionSemantics()
    {
        RobloxInputHealthSession.ResetForTests();
        var first = new RobloxWindowTarget(1001, IntPtr.Zero, "Roblox A");
        var second = new RobloxWindowTarget(1002, IntPtr.Zero, "Roblox B");

        if (RobloxInputHealthSession.GetFor(first).State != RobloxInputHealthState.Unknown)
        {
            throw new InvalidOperationException("New Roblox sessions must start with unknown input readiness.");
        }

        var confirmed = new RobloxInputCheckAssessment(
            RobloxInputCheckVerdict.Confirmed,
            "Roblox reacted to the production input probe.",
            "Playback may proceed.",
            true);
        RobloxInputHealthSession.Record(first, confirmed, DateTimeOffset.UnixEpoch);

        var firstHealth = RobloxInputHealthSession.GetFor(first);
        if (firstHealth.State != RobloxInputHealthState.Confirmed
            || firstHealth.ProcessId != first.ProcessId
            || firstHealth.Verdict != RobloxInputCheckVerdict.Confirmed)
        {
            throw new InvalidOperationException("Confirmed input readiness must remain attached to the tested Roblox PID.");
        }

        if (RobloxInputHealthSession.GetFor(second).State != RobloxInputHealthState.Unknown)
        {
            throw new InvalidOperationException("Input readiness must not leak to a different Roblox PID.");
        }

        var blocked = new RobloxInputCheckAssessment(
            RobloxInputCheckVerdict.RobloxDidNotReact,
            "Windows delivered input but Roblox did not react.",
            "Resolve the Roblox/client input blocker and rerun the check.",
            false);
        RobloxInputHealthSession.Record(first, blocked, DateTimeOffset.UnixEpoch.AddSeconds(1));
        if (RobloxInputHealthSession.GetFor(first).State != RobloxInputHealthState.Blocked)
        {
            throw new InvalidOperationException("A failed field observation must replace stale confirmed readiness for the same PID.");
        }

        RobloxInputHealthSession.ResetForTests();
    }

    private static void AssertPlaybackPreflightSemantics()
    {
        var target = new RobloxWindowTarget(2001, IntPtr.Zero, "Roblox preflight");

        var noRoblox = RobloxPlaybackPreflight.Evaluate(null, RobloxInputHealthSnapshot.Unknown);
        if (noRoblox.Action != RobloxPlaybackPreflightAction.OpenRoblox || noRoblox.CanLaunchPlayback)
        {
            throw new InvalidOperationException("Playback preflight must not launch without Roblox.");
        }

        var unknown = RobloxPlaybackPreflight.Evaluate(target, RobloxInputHealthSnapshot.Unknown);
        if (unknown.Action != RobloxPlaybackPreflightAction.VerifyInput || unknown.CanLaunchPlayback)
        {
            throw new InvalidOperationException("Unknown input readiness must require verification before playback.");
        }

        var confirmedHealth = new RobloxInputHealthSnapshot(
            RobloxInputHealthState.Confirmed,
            target.ProcessId,
            RobloxInputCheckVerdict.Confirmed,
            DateTimeOffset.UnixEpoch,
            "confirmed",
            "proceed");
        var confirmed = RobloxPlaybackPreflight.Evaluate(target, confirmedHealth);
        if (confirmed.Action != RobloxPlaybackPreflightAction.Proceed || !confirmed.CanLaunchPlayback)
        {
            throw new InvalidOperationException("Confirmed input readiness must allow playback for the same Roblox PID.");
        }

        var blockedHealth = new RobloxInputHealthSnapshot(
            RobloxInputHealthState.Blocked,
            target.ProcessId,
            RobloxInputCheckVerdict.RobloxDidNotReact,
            DateTimeOffset.UnixEpoch,
            "blocked",
            "retest");
        var blocked = RobloxPlaybackPreflight.Evaluate(target, blockedHealth);
        if (blocked.Action != RobloxPlaybackPreflightAction.RetestInput || blocked.CanLaunchPlayback)
        {
            throw new InvalidOperationException("Blocked input readiness must require retest before playback.");
        }

        var staleConfirmed = confirmedHealth with { ProcessId = target.ProcessId + 1 };
        var stale = RobloxPlaybackPreflight.Evaluate(target, staleConfirmed);
        if (stale.Action != RobloxPlaybackPreflightAction.VerifyInput || stale.CanLaunchPlayback)
        {
            throw new InvalidOperationException("Confirmed readiness from another Roblox PID must never authorize playback.");
        }
    }

    private static void AssertInputVerdict(
        RobloxFieldInputProbeResult result,
        bool? robloxReacted,
        RobloxInputCheckVerdict expected,
        bool expectedSuccess)
    {
        var assessment = result.Assess(robloxReacted);
        if (assessment.Verdict != expected || assessment.IsSuccess != expectedSuccess)
        {
            throw new InvalidOperationException(
                $"Input verdict mismatch. expected={expected}/{expectedSuccess}, actual={assessment.Verdict}/{assessment.IsSuccess}.");
        }

        if (string.IsNullOrWhiteSpace(assessment.Summary) || string.IsNullOrWhiteSpace(assessment.NextAction))
        {
            throw new InvalidOperationException($"Input verdict {assessment.Verdict} must include client guidance.");
        }
    }

    private static async Task<int> RunRobloxInputFieldTestAsync()
    {
        try
        {
            var target = RobloxProcessLocator.FindPreferred();
            if (target is null)
            {
                Console.Error.WriteLine("Roblox was not found. Open Roblox first, then rerun --roblox-input-field-test.");
                return 8;
            }

            Console.WriteLine($"Target: {target} | hwnd=0x{target.WindowHandle.ToInt64():X}");
            Console.WriteLine(
                $"Field test: focus Roblox, wait {RobloxFieldInputPolicy.StableFocusDuration.TotalMilliseconds:0} ms, " +
                $"then hold '{RobloxFieldInputPolicy.ProbeKey}' for {RobloxFieldInputPolicy.ProbeHoldDuration.TotalMilliseconds:0} ms.");
            Console.WriteLine("Observe Roblox: outside a piano this should visibly act like W; inside a piano it should trigger the W-bound note.");

            var result = await RobloxFieldInputProbe.RunAsync(target).ConfigureAwait(false);
            var assessment = result.Assess(null);
            Console.WriteLine(
                $"Result: activation={result.ActivationConfirmed}; stableForeground={result.StableForegroundConfirmed}; " +
                $"windowsKeyDownObserved={result.WindowsReportedKeyDown}; foregroundHeld={result.ForegroundHeldDuringProbe}; " +
                $"vk=0x{result.VirtualKey:X2}; heldMs={result.HoldDuration.TotalMilliseconds:0}.");
            Console.WriteLine($"Verdict: {assessment.Verdict} — {assessment.Summary}");
            Console.WriteLine($"Next: {assessment.NextAction}");
            Console.WriteLine($"Diagnostics: {ClientDiagnostics.DirectoryPath}");

            return result.NativeDeliveryObserved ? 0 : 9;
        }
        catch (Exception exception) when (
            exception is InvalidOperationException
            or ArgumentException
            or System.ComponentModel.Win32Exception)
        {
            ClientDiagnostics.Log($"Field input probe failed: {exception}");
            Console.Error.WriteLine($"Field input probe failed: {exception.Message}");
            Console.Error.WriteLine($"Diagnostics: {ClientDiagnostics.DirectoryPath}");
            return 10;
        }
    }
}
