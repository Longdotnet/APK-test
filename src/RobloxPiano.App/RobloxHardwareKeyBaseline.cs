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
    ushort VirtualKey,
    TimeSpan ObservationDuration)
{
    public bool PhysicalBaselineObserved => ActivationConfirmed
        && StableForegroundConfirmed
        && NonInjectedKeyDownObserved
        && NonInjectedKeyUpObserved
        && ForegroundHeldAtDown
        && ForegroundHeldAtUp;
}

/// <summary>
/// Diagnostic-only baseline that waits for the user to physically press and release W while
/// Roblox owns the foreground. It never injects input and never authorizes production playback.
/// Windows LLKHF_INJECTED is used only to reject OS-marked injected events; an unmarked event is
/// treated as a physical-baseline candidate, not as cryptographic proof of hardware provenance.
/// </summary>
internal static class RobloxHardwareKeyBaselineProbe
{
    private const int WhKeyboardLl = 13;
    private const int WmKeyDown = 0x0100;
    private const int WmKeyUp = 0x0101;
    private const int WmSysKeyDown = 0x0104;
    private const int WmSysKeyUp = 0x0105;
    private const uint LlkhfInjected = 0x10;
    private static readonly TimeSpan ObservationTimeout = TimeSpan.FromSeconds(10);

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
            "injection=false provenance=LLKHF_INJECTED_FILTER privacy=TARGET_KEY_ONLY productionChanged=false.");

        var started = Stopwatch.GetTimestamp();
        using var listener = new LowLevelKeyboardListener(target, probeId, oracle.VirtualKey);
        listener.Start();

        using var timeout = CancellationTokenSource.CreateLinkedTokenSource(cancellationToken);
        timeout.CancelAfter(ObservationTimeout);
        try
        {
            await listener.Completion.Task.WaitAsync(timeout.Token).ConfigureAwait(true);
        }
        catch (OperationCanceledException) when (!cancellationToken.IsCancellationRequested)
        {
            // Bounded field observation timeout is a diagnostic result, not an application failure.
        }

        cancellationToken.ThrowIfCancellationRequested();
        var result = new RobloxHardwareKeyBaselineResult(
            probeId,
            true,
            true,
            listener.NonInjectedDownObserved,
            listener.NonInjectedUpObserved,
            listener.ForegroundAtDown,
            listener.ForegroundAtUp,
            oracle.VirtualKey,
            Stopwatch.GetElapsedTime(started));
        LogVerdict(result, null, result.PhysicalBaselineObserved ? "AWAITING_ROBLOX_OBSERVATION" : "REAL_KEY_NOT_CONFIRMED");
        return result;
    }

    internal static bool IsPhysicalBaselineCandidate(uint flags, bool isTargetVirtualKey, bool targetForeground)
        => isTargetVirtualKey && targetForeground && (flags & LlkhfInjected) == 0;

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
            0,
            TimeSpan.Zero);

    private static void LogVerdict(RobloxHardwareKeyBaselineResult result, bool? reacted, string verdict)
    {
        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={result.ProbeId} stage=REAL_KEY_VERDICT verdict={verdict} " +
            $"vk=0x{result.VirtualKey:X2} nonInjectedDown={result.NonInjectedKeyDownObserved} " +
            $"nonInjectedUp={result.NonInjectedKeyUpObserved} foregroundAtDown={result.ForegroundHeldAtDown} " +
            $"foregroundAtUp={result.ForegroundHeldAtUp} baselineObserved={result.PhysicalBaselineObserved} " +
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
            if (target.IsForeground)
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
        private readonly HookProc callback;
        private IntPtr hook;

        public LowLevelKeyboardListener(RobloxWindowTarget target, string probeId, ushort virtualKey)
        {
            this.target = target;
            this.probeId = probeId;
            this.virtualKey = virtualKey;
            callback = OnKeyboard;
        }

        public TaskCompletionSource<bool> Completion { get; } = new(TaskCreationOptions.RunContinuationsAsynchronously);
        public bool NonInjectedDownObserved { get; private set; }
        public bool NonInjectedUpObserved { get; private set; }
        public bool ForegroundAtDown { get; private set; }
        public bool ForegroundAtUp { get; private set; }

        public void Start()
        {
            var module = GetModuleHandleW(null);
            hook = SetWindowsHookExW(WhKeyboardLl, callback, module, 0);
            if (hook == IntPtr.Zero)
            {
                throw new Win32Exception(Marshal.GetLastWin32Error(), "Could not arm bounded real-key baseline hook.");
            }
        }

        public void Dispose()
        {
            if (hook != IntPtr.Zero)
            {
                _ = UnhookWindowsHookEx(hook);
                hook = IntPtr.Zero;
            }
        }

        private IntPtr OnKeyboard(int code, IntPtr wParam, IntPtr lParam)
        {
            if (code >= 0)
            {
                var data = Marshal.PtrToStructure<KbdLlHookStruct>(lParam);
                var isTarget = data.VirtualKey == virtualKey;
                var targetForeground = target.IsForeground;
                var candidate = IsPhysicalBaselineCandidate(data.Flags, isTarget, targetForeground);
                if (isTarget)
                {
                    var injected = (data.Flags & LlkhfInjected) != 0;
                    var isDown = wParam == (IntPtr)WmKeyDown || wParam == (IntPtr)WmSysKeyDown;
                    var isUp = wParam == (IntPtr)WmKeyUp || wParam == (IntPtr)WmSysKeyUp;
                    ClientDiagnostics.Log(
                        $"INPUT_FORENSIC probe={probeId} stage=REAL_KEY_EVENT vk=0x{data.VirtualKey:X2} scanCode=0x{data.ScanCode:X2} " +
                        $"event={(isDown ? "DOWN" : isUp ? "UP" : "OTHER")} osMarkedInjected={injected} " +
                        $"targetForeground={targetForeground} acceptedPhysicalCandidate={candidate} productionChanged=false.");

                    if (candidate && isDown)
                    {
                        NonInjectedDownObserved = true;
                        ForegroundAtDown = true;
                    }
                    else if (candidate && isUp && NonInjectedDownObserved)
                    {
                        NonInjectedUpObserved = true;
                        ForegroundAtUp = true;
                        Completion.TrySetResult(true);
                    }
                }
            }

            return CallNextHookEx(hook, code, wParam, lParam);
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

    [DllImport("user32.dll", SetLastError = true, CharSet = CharSet.Unicode)]
    private static extern IntPtr SetWindowsHookExW(int hookId, HookProc callback, IntPtr module, uint threadId);

    [DllImport("user32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool UnhookWindowsHookEx(IntPtr hook);

    [DllImport("user32.dll")]
    private static extern IntPtr CallNextHookEx(IntPtr hook, int code, IntPtr wParam, IntPtr lParam);

    [DllImport("kernel32.dll", CharSet = CharSet.Unicode)]
    private static extern IntPtr GetModuleHandleW(string? moduleName);
}
