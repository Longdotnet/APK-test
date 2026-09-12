using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal sealed record RobloxHardwareKeyBaselineResult(
    string ProbeId,
    bool ActivationConfirmed,
    bool StableForegroundConfirmed,
    bool NonInjectedKeyDownObserved,
    bool NonInjectedKeyUpObserved,
    bool ForegroundHeldAtDown,
    bool ForegroundHeldAtUp,
    bool TrustedWindowSurfaceAtDown,
    bool TrustedWindowSurfaceAtUp,
    ushort VirtualKey,
    TimeSpan ObservationDuration)
{
    public bool HoldContinuityPreserved { get; init; }
    public TimeSpan? FirstHoldContinuityLossAt { get; init; }

    public bool PhysicalBaselineObserved => ActivationConfirmed
        && StableForegroundConfirmed
        && NonInjectedKeyDownObserved
        && NonInjectedKeyUpObserved
        && ForegroundHeldAtDown
        && ForegroundHeldAtUp
        && TrustedWindowSurfaceAtDown
        && TrustedWindowSurfaceAtUp
        && HoldContinuityPreserved;
}

/// <summary>
/// Diagnostic-only baseline that waits for the user to physically press and release W while
/// the exact selected Roblox window/tree owns the foreground. It never injects input and never
/// authorizes production playback. Windows LLKHF_INJECTED is used only to reject OS-marked
/// injected events; an unmarked event is treated as a physical-baseline candidate, not as
/// cryptographic proof of hardware provenance.
/// </summary>
internal static class RobloxHardwareKeyBaselineProbe
{
    private const int WhKeyboardLl = 13;
    private const int WmKeyDown = 0x0100;
    private const int WmKeyUp = 0x0101;
    private const int WmSysKeyDown = 0x0104;
    private const int WmSysKeyUp = 0x0105;
    private const uint LlkhfInjected = 0x10;
    private const uint EventSystemForeground = 0x0003;
    private const uint WinEventOutOfContext = 0x0000;
    private static readonly TimeSpan ObservationTimeout = TimeSpan.FromSeconds(10);
    internal static readonly TimeSpan HoldContinuitySampleInterval = TimeSpan.FromMilliseconds(25);

    public static async Task<RobloxHardwareKeyBaselineResult> RunAsync(
        RobloxWindowTarget target,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(target);
        cancellationToken.ThrowIfCancellationRequested();

        var probeId = RobloxInputForensics.NewProbeId();
        RobloxInputForensics.LogEnvironment(probeId, target, RobloxFieldInputPolicy.ProbeKey);

        if (!target.TryActivate())
        {
            var failed = Empty(probeId, activationConfirmed: false, stableForegroundConfirmed: false);
            LogVerdict(failed, null, "ACTIVATION_FAILED");
            return failed;
        }

        if (!await WaitForStableForegroundAsync(target, cancellationToken).ConfigureAwait(true))
        {
            var failed = Empty(probeId, activationConfirmed: true, stableForegroundConfirmed: false);
            LogVerdict(failed, null, "FOCUS_NOT_STABLE");
            return failed;
        }

        var oracle = WindowsKeyboardInputSink.ResolvePowerShellOracleStrokeForDiagnostics(RobloxFieldInputPolicy.ProbeKey);
        if (oracle.Modifiers != 0)
        {
            throw new WindowsInputInjectionException("The real-key baseline only supports an unmodified probe key.");
        }

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=REAL_KEY_ARMED backend=NONE " +
            $"vk=0x{oracle.VirtualKey:X2} timeoutMs={ObservationTimeout.TotalMilliseconds:0} " +
            $"holdContinuitySampleMs={HoldContinuitySampleInterval.TotalMilliseconds:0} " +
            "holdContinuityForegroundEvents=true injection=false provenance=LLKHF_INJECTED_FILTER " +
            "windowPolicy=TRUSTED_SELECTED_TREE privacy=TARGET_KEY_ONLY productionChanged=false.");

        var started = Stopwatch.GetTimestamp();
        using var listener = new LowLevelKeyboardListener(target, probeId, oracle.VirtualKey);
        listener.Start();

        using var timeout = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken);
        timeout.CancelAfter(ObservationTimeout);
        try
        {
            while (!listener.Completion.Task.IsCompleted)
            {
                timeout.Token.ThrowIfCancellationRequested();
                listener.ObserveHoldContinuity("POLL");
                await Task.Delay(HoldContinuitySampleInterval, timeout.Token).ConfigureAwait(true);
            }

            await listener.Completion.Task.ConfigureAwait(true);
        }
        catch (OperationCanceledException) when (!cancellationToken.IsCancellationRequested)
        {
            // Bounded field observation timeout is a diagnostic result, not an application failure.
        }

        cancellationToken.ThrowIfCancellationRequested();
        listener.ObserveHoldContinuity("FINAL");
        var result = new RobloxHardwareKeyBaselineResult(
            probeId,
            true,
            true,
            listener.NonInjectedDownObserved,
            listener.NonInjectedUpObserved,
            listener.ForegroundAtDown,
            listener.ForegroundAtUp,
            listener.TrustedWindowSurfaceAtDown,
            listener.TrustedWindowSurfaceAtUp,
            oracle.VirtualKey,
            Stopwatch.GetElapsedTime(started))
        {
            HoldContinuityPreserved = listener.HoldContinuityPreserved,
            FirstHoldContinuityLossAt = listener.FirstHoldContinuityLossAt
        };
        LogVerdict(result, null, result.PhysicalBaselineObserved ? "AWAITING_ROBLOX_OBSERVATION" : "REAL_KEY_NOT_CONFIRMED");
        return result;
    }

    internal static bool IsPhysicalBaselineCandidate(uint flags, bool isTargetVirtualKey, bool trustedTargetSurface)
        => isTargetVirtualKey && trustedTargetSurface && (flags & LlkhfInjected) == 0;

    internal static bool IsTrustedBaselineSurface(WindowsRobloxWindowIdentitySnapshot snapshot)
        => snapshot.IsTrustedProbeSurface;

    internal static bool IsHoldContinuityTrusted(
        bool keyDownObserved,
        bool keyUpObserved,
        bool continuityPreserved)
        => keyDownObserved && keyUpObserved && continuityPreserved;

    internal static bool ShouldPreserveHoldContinuityAfterForegroundEvent(
        bool keyDownObserved,
        bool keyUpObserved,
        bool continuityPreserved,
        bool trustedTargetSurface,
        bool targetForeground)
        => !keyDownObserved
            || keyUpObserved
            || !continuityPreserved
            || (trustedTargetSurface && targetForeground);

    internal static void LogHumanVerdict(RobloxHardwareKeyBaselineResult result, bool reacted)
        => LogVerdict(result, reacted, reacted ? "REAL_KEY_ROBLOX_REACTED" : "REAL_KEY_ROBLOX_NO_REACTION");

    private static RobloxHardwareKeyBaselineResult Empty(string probeId, bool activationConfirmed, bool stableForegroundConfirmed)
        => new(
            probeId,
            activationConfirmed,
            stableForegroundConfirmed,
            false,
            false,
            false,
            false,
            false,
            false,
            0,
            TimeSpan.Zero)
        {
            HoldContinuityPreserved = false
        };

    private static void LogVerdict(RobloxHardwareKeyBaselineResult result, bool? reacted, string verdict)
    {
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={result.ProbeId} stage=REAL_KEY_VERDICT verdict={verdict} " +
            $"vk=0x{result.VirtualKey:X2} nonInjectedDown={result.NonInjectedKeyDownObserved} " +
            $"nonInjectedUp={result.NonInjectedKeyUpObserved} foregroundAtDown={result.ForegroundHeldAtDown} " +
            $"foregroundAtUp={result.ForegroundHeldAtUp} trustedSurfaceAtDown={result.TrustedWindowSurfaceAtDown} " +
            $"trustedSurfaceAtUp={result.TrustedWindowSurfaceAtUp} holdContinuityPreserved={result.HoldContinuityPreserved} " +
            $"firstHoldContinuityLossMs={result.FirstHoldContinuityLossAt?.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture) ?? "na"} " +
            $"baselineObserved={result.PhysicalBaselineObserved} " +
            $"robloxReaction={(reacted is null ? "UNKNOWN" : reacted.Value ? "YES" : "NO")} " +
            "injection=false authorizesPlayback=false success=false.");
    }

    private static async Task<bool> WaitForStableForegroundAsync(RobloxWindowTarget target, CancellationToken cancellationToken)
    {
        var timeoutStarted = Stopwatch.GetTimestamp();
        long? stableSince = null;
        while (Stopwatch.GetElapsedTime(timeoutStarted) < RobloxFieldInputPolicy.ProbeFocusTimeout)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var identity = WindowsRobloxWindowIdentity.Capture(target);
            if (IsTrustedBaselineSurface(identity))
            {
                stableSince ??= Stopwatch.GetTimestamp();
                if (Stopwatch.GetElapsedTime(stableSince.Value) >= RobloxFieldInputPolicy.StableFocusDuration)
                {
                    return true;
                }
            }
            else
            {
                stableSince = null;
            }

            await Task.Delay(25, cancellationToken).ConfigureAwait(true);
        }

        return false;
    }

    private sealed class LowLevelKeyboardListener : IDisposable
    {
        private readonly RobloxWindowTarget target;
        private readonly string probeId;
        private readonly ushort virtualKey;
        private readonly HookProc keyboardCallback;
        private readonly WinEventProc foregroundCallback;
        private readonly object stateGate = new();
        private IntPtr keyboardHook;
        private IntPtr foregroundHook;
        private long? holdStartedAt;
        private bool holdContinuityLossLogged;

        public LowLevelKeyboardListener(RobloxWindowTarget target, string probeId, ushort virtualKey)
        {
            this.target = target;
            this.probeId = probeId;
            this.virtualKey = virtualKey;
            keyboardCallback = OnKeyboard;
            foregroundCallback = OnForegroundChanged;
        }

        public TaskCompletionSource<bool> Completion { get; } = new(TaskCreationOptions.RunContinuationsAsynchronously);
        public bool NonInjectedDownObserved { get; private set; }
        public bool NonInjectedUpObserved { get; private set; }
        public bool ForegroundAtDown { get; private set; }
        public bool ForegroundAtUp { get; private set; }
        public bool TrustedWindowSurfaceAtDown { get; private set; }
        public bool TrustedWindowSurfaceAtUp { get; private set; }
        public bool HoldContinuityPreserved { get; private set; }
        public TimeSpan? FirstHoldContinuityLossAt { get; private set; }

        public void Start()
        {
            var module = GetModuleHandleW(null);
            keyboardHook = SetWindowsHookExW(WhKeyboardLl, keyboardCallback, module, 0);
            if (keyboardHook == IntPtr.Zero)
            {
                throw new Win32Exception(Marshal.GetLastWin32Error(), "Could not arm bounded real-key baseline keyboard hook.");
            }

            foregroundHook = SetWinEventHook(
                EventSystemForeground,
                EventSystemForeground,
                IntPtr.Zero,
                foregroundCallback,
                0,
                0,
                WinEventOutOfContext);
            if (foregroundHook == IntPtr.Zero)
            {
                var error = Marshal.GetLastWin32Error();
                _ = UnhookWindowsHookEx(keyboardHook);
                keyboardHook = IntPtr.Zero;
                throw new Win32Exception(error, "Could not arm real-key foreground continuity hook.");
            }
        }

        public void ObserveHoldContinuity(string source)
        {
            lock (stateGate)
            {
                if (!NonInjectedDownObserved || NonInjectedUpObserved || !HoldContinuityPreserved)
                {
                    return;
                }

                var identity = WindowsRobloxWindowIdentity.Capture(target);
                var trustedSurface = IsTrustedBaselineSurface(identity);
                var targetForeground = target.IsForeground;
                if (trustedSurface && targetForeground)
                {
                    return;
                }

                InvalidateHoldContinuity(identity, targetForeground, trustedSurface, source);
            }
        }

        public void Dispose()
        {
            if (foregroundHook != IntPtr.Zero)
            {
                _ = UnhookWinEvent(foregroundHook);
                foregroundHook = IntPtr.Zero;
            }

            if (keyboardHook != IntPtr.Zero)
            {
                _ = UnhookWindowsHookEx(keyboardHook);
                keyboardHook = IntPtr.Zero;
            }
        }

        private void OnForegroundChanged(
            IntPtr winEventHook,
            uint eventType,
            IntPtr hwnd,
            int idObject,
            int idChild,
            uint eventThread,
            uint eventTime)
        {
            _ = winEventHook;
            _ = idObject;
            _ = idChild;
            _ = eventThread;
            _ = eventTime;

            if (eventType != EventSystemForeground)
            {
                return;
            }

            lock (stateGate)
            {
                if (!NonInjectedDownObserved || NonInjectedUpObserved || !HoldContinuityPreserved)
                {
                    return;
                }

                var identity = WindowsRobloxWindowIdentity.Capture(target);
                var trustedSurface = IsTrustedBaselineSurface(identity);
                var targetForeground = target.IsForeground;
                if (ShouldPreserveHoldContinuityAfterForegroundEvent(
                        NonInjectedDownObserved,
                        NonInjectedUpObserved,
                        HoldContinuityPreserved,
                        trustedSurface,
                        targetForeground))
                {
                    return;
                }

                ClientDiagnostics.Log(
                    $"INPUT_FORENSIC probe={probeId} stage=REAL_KEY_FOREGROUND_EVENT eventHwnd=0x{hwnd.ToInt64():X} " +
                    $"targetForeground={targetForeground} trustedSurface={trustedSurface} windowRelation={identity.Relation} " +
                    "holdActive=true verdict=FOREGROUND_EVENT_OUTSIDE_TRUSTED_SURFACE.");
                InvalidateHoldContinuity(identity, targetForeground, trustedSurface, "WINEVENT_FOREGROUND");
            }
        }

        private IntPtr OnKeyboard(int code, IntPtr wParam, IntPtr lParam)
        {
            if (code >= 0)
            {
                var data = Marshal.PtrToStructure<KbdLlHookStruct>(lParam);
                var isTarget = data.VirtualKey == virtualKey;
                if (isTarget)
                {
                    lock (stateGate)
                    {
                        var identity = WindowsRobloxWindowIdentity.Capture(target);
                        var trustedSurface = IsTrustedBaselineSurface(identity);
                        var targetForeground = target.IsForeground;
                        var candidate = IsPhysicalBaselineCandidate(data.Flags, true, trustedSurface);
                        var injected = (data.Flags & LlkhfInjected) != 0;
                        var isDown = wParam == (IntPtr)WmKeyDown || wParam == (IntPtr)WmSysKeyDown;
                        var isUp = wParam == (IntPtr)WmKeyUp || wParam == (IntPtr)WmSysKeyUp;
                        ClientDiagnostics.Log(
                            $"INPUT_FORENSIC probe={probeId} stage=REAL_KEY_EVENT vk=0x{data.VirtualKey:X2} scanCode=0x{data.ScanCode:X2} " +
                            $"event={(isDown ? "DOWN" : isUp ? "UP" : "OTHER")} osMarkedInjected={injected} " +
                            $"targetForeground={targetForeground} trustedSurface={trustedSurface} windowRelation={identity.Relation} " +
                            $"targetMainReplaced={identity.TargetMainWindowReplaced} foregroundHwnd=0x{identity.ForegroundWindowHandle.ToInt64():X} " +
                            $"acceptedPhysicalCandidate={candidate} holdContinuityPreserved={HoldContinuityPreserved} productionChanged=false.");

                        if (candidate && isDown && !NonInjectedDownObserved)
                        {
                            NonInjectedDownObserved = true;
                            ForegroundAtDown = targetForeground;
                            TrustedWindowSurfaceAtDown = true;
                            HoldContinuityPreserved = targetForeground;
                            holdStartedAt = Stopwatch.GetTimestamp();
                        }
                        else if (candidate && isUp && NonInjectedDownObserved)
                        {
                            if (!(trustedSurface && targetForeground) && HoldContinuityPreserved)
                            {
                                InvalidateHoldContinuity(identity, targetForeground, trustedSurface, "KEY_UP");
                            }

                            NonInjectedUpObserved = true;
                            ForegroundAtUp = targetForeground;
                            TrustedWindowSurfaceAtUp = true;
                            Completion.TrySetResult(true);
                        }
                    }
                }
            }

            return CallNextHookEx(keyboardHook, code, wParam, lParam);
        }

        private void InvalidateHoldContinuity(
            WindowsRobloxWindowIdentitySnapshot identity,
            bool targetForeground,
            bool trustedSurface,
            string source)
        {
            HoldContinuityPreserved = false;
            FirstHoldContinuityLossAt ??= holdStartedAt is null
                ? TimeSpan.Zero
                : Stopwatch.GetElapsedTime(holdStartedAt.Value);

            if (holdContinuityLossLogged)
            {
                return;
            }

            holdContinuityLossLogged = true;
            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=REAL_KEY_HOLD_CONTINUITY_LOST verdict=REAL_KEY_HOLD_NOT_CONTINUOUS " +
                $"source={source} lossMs={FirstHoldContinuityLossAt.Value.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture)} " +
                $"targetForeground={targetForeground} trustedSurface={trustedSurface} windowRelation={identity.Relation} " +
                $"targetMainReplaced={identity.TargetMainWindowReplaced} foregroundHwnd=0x{identity.ForegroundWindowHandle.ToInt64():X} " +
                "baselineTrusted=false authorizesPlayback=false.");
        }
    }

    [StructLayout(LayoutKind.Sequential)]
    private readonly struct KbdLlHookStruct
    {
        public readonly uint VirtualKey;
        public readonly uint ScanCode;
        public readonly uint Flags;
        public readonly uint Time;
        public readonly UIntPtr ExtraInfo;
    }

    private delegate IntPtr HookProc(int code, IntPtr wParam, IntPtr lParam);
    private delegate void WinEventProc(
        IntPtr winEventHook,
        uint eventType,
        IntPtr hwnd,
        int idObject,
        int idChild,
        uint eventThread,
        uint eventTime);

    [DllImport("user32.dll", SetLastError = true, CharSet = CharSet.Unicode)]
    private static extern IntPtr SetWindowsHookExW(int hookId, HookProc callback, IntPtr module, uint threadId);

    [DllImport("user32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool UnhookWindowsHookEx(IntPtr hook);

    [DllImport("user32.dll")]
    private static extern IntPtr CallNextHookEx(IntPtr hook, int code, IntPtr wParam, IntPtr lParam);

    [DllImport("user32.dll", SetLastError = true)]
    private static extern IntPtr SetWinEventHook(
        uint eventMin,
        uint eventMax,
        IntPtr module,
        WinEventProc callback,
        uint processId,
        uint threadId,
        uint flags);

    [DllImport("user32.dll")]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool UnhookWinEvent(IntPtr winEventHook);

    [DllImport("kernel32.dll", CharSet = CharSet.Unicode)]
    private static extern IntPtr GetModuleHandleW(string? moduleName);
}
