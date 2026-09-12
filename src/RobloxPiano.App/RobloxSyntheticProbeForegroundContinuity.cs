using System.ComponentModel;
using System.Diagnostics;
using System.Runtime.InteropServices;

namespace RobloxPiano.App;

/// <summary>
/// Event-driven foreground/window continuity evidence for explicit synthetic field probes.
/// The WinEvent hook closes focus hops shorter than the normal polling interval, while
/// callers retain polling to catch selected-window identity changes that may not emit a
/// foreground transition. This is diagnostic-only and never authorizes playback.
/// </summary>
internal sealed class RobloxSyntheticProbeForegroundContinuity : IDisposable
{
    private const uint EventSystemForeground = 0x0003;
    private const uint WinEventOutOfContext = 0x0000;

    private readonly RobloxWindowTarget target;
    private readonly string probeId;
    private readonly string probePath;
    private readonly WinEventProc foregroundCallback;
    private readonly object stateGate = new();
    private readonly TaskCompletionSource<bool> lossSignal = new(TaskCreationOptions.RunContinuationsAsynchronously);
    private IntPtr foregroundHook;
    private long? holdStartedAt;
    private bool holdActive;
    private bool disposed;

    internal RobloxSyntheticProbeForegroundContinuity(
        RobloxWindowTarget target,
        string probeId,
        string probePath)
    {
        this.target = target ?? throw new ArgumentNullException(nameof(target));
        this.probeId = string.IsNullOrWhiteSpace(probeId)
            ? throw new ArgumentException("Probe id is required.", nameof(probeId))
            : probeId;
        this.probePath = string.IsNullOrWhiteSpace(probePath)
            ? throw new ArgumentException("Probe path is required.", nameof(probePath))
            : probePath;
        foregroundCallback = OnForegroundChanged;
    }

    internal bool ContinuityPreserved { get; private set; } = true;
    internal TimeSpan? FirstContinuityLossAt { get; private set; }
    internal string? FirstContinuityLossSource { get; private set; }
    internal Task LossTask => lossSignal.Task;

    internal void Start()
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        if (foregroundHook != IntPtr.Zero)
        {
            throw new InvalidOperationException("Synthetic foreground continuity hook is already armed.");
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
            throw new Win32Exception(
                Marshal.GetLastWin32Error(),
                "Could not arm synthetic probe foreground continuity hook.");
        }

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=SYNTHETIC_CONTINUITY_ARMED probePath={probePath} " +
            "foregroundEvents=true pollingFallback=true authorizesPlayback=false productionChanged=false.");
    }

    internal void BeginHold()
    {
        ObjectDisposedException.ThrowIf(disposed, this);
        if (foregroundHook == IntPtr.Zero)
        {
            throw new InvalidOperationException("Synthetic foreground continuity hook must be armed before key down.");
        }

        lock (stateGate)
        {
            holdStartedAt = Stopwatch.GetTimestamp();
            holdActive = true;
        }
    }

    internal void EndHold()
    {
        lock (stateGate)
        {
            holdActive = false;
        }
    }

    internal bool ObservePollingFallback(string source = "POLL")
    {
        lock (stateGate)
        {
            if (!holdActive || !ContinuityPreserved)
            {
                return ContinuityPreserved;
            }

            var identity = WindowsRobloxWindowIdentity.Capture(target);
            var targetForeground = target.IsForeground;
            if (ShouldPreserveAfterObservation(
                    holdActive,
                    ContinuityPreserved,
                    identity.IsTrustedProbeSurface,
                    targetForeground))
            {
                return true;
            }

            Invalidate(identity, targetForeground, source);
            return false;
        }
    }

    internal async Task<bool> WaitForDelayOrLossAsync(TimeSpan delay, CancellationToken cancellationToken)
    {
        if (delay <= TimeSpan.Zero)
        {
            cancellationToken.ThrowIfCancellationRequested();
            return ContinuityPreserved;
        }

        var delayTask = Task.Delay(delay, cancellationToken);
        var completed = await Task.WhenAny(delayTask, LossTask).ConfigureAwait(false);
        if (completed == LossTask)
        {
            return false;
        }

        await delayTask.ConfigureAwait(false);
        return ContinuityPreserved;
    }

    internal static bool ShouldPreserveAfterObservation(
        bool holdActive,
        bool continuityPreserved,
        bool trustedTargetSurface,
        bool targetForeground)
        => !holdActive
            || !continuityPreserved
            || (trustedTargetSurface && targetForeground);

    public void Dispose()
    {
        lock (stateGate)
        {
            holdActive = false;
            disposed = true;
        }

        if (foregroundHook != IntPtr.Zero)
        {
            _ = UnhookWinEvent(foregroundHook);
            foregroundHook = IntPtr.Zero;
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
            if (!holdActive || !ContinuityPreserved)
            {
                return;
            }

            var identity = WindowsRobloxWindowIdentity.Capture(target);
            var targetForeground = target.IsForeground;
            if (ShouldPreserveAfterObservation(
                    holdActive,
                    ContinuityPreserved,
                    identity.IsTrustedProbeSurface,
                    targetForeground))
            {
                return;
            }

            ClientDiagnostics.Log(
                $"INPUT_FORENSIC probe={probeId} stage=SYNTHETIC_FOREGROUND_EVENT probePath={probePath} " +
                $"eventHwnd=0x{hwnd.ToInt64():X} targetForeground={targetForeground} " +
                $"trustedSurface={identity.IsTrustedProbeSurface} windowRelation={identity.Relation} " +
                "holdActive=true verdict=FOREGROUND_EVENT_OUTSIDE_TRUSTED_SURFACE productionChanged=false.");
            Invalidate(identity, targetForeground, "WINEVENT_FOREGROUND");
        }
    }

    private void Invalidate(
        WindowsRobloxWindowIdentitySnapshot identity,
        bool targetForeground,
        string source)
    {
        if (!ContinuityPreserved)
        {
            return;
        }

        ContinuityPreserved = false;
        FirstContinuityLossAt = holdStartedAt is null
            ? TimeSpan.Zero
            : Stopwatch.GetElapsedTime(holdStartedAt.Value);
        FirstContinuityLossSource = source;

        ClientDiagnostics.Log(
            $"INPUT_FORENSIC probe={probeId} stage=SYNTHETIC_HOLD_CONTINUITY_LOST probePath={probePath} " +
            $"source={source} firstLossMs={FirstContinuityLossAt.Value.TotalMilliseconds.ToString("0.###", System.Globalization.CultureInfo.InvariantCulture)} " +
            $"targetForeground={targetForeground} trustedSurface={identity.IsTrustedProbeSurface} " +
            $"windowRelation={identity.Relation} targetMainReplaced={identity.TargetMainWindowReplaced} " +
            $"targetHwnd=0x{identity.TargetWindowHandle.ToInt64():X} currentMainHwnd=0x{identity.CurrentMainWindowHandle.ToInt64():X} " +
            $"foregroundHwnd=0x{identity.ForegroundWindowHandle.ToInt64():X} foregroundRootHwnd=0x{identity.ForegroundRootHandle.ToInt64():X} " +
            "verdict=SYNTHETIC_FOCUS_CONTINUITY_LOST action=RELEASE_IMMEDIATELY authorizesPlayback=false productionChanged=false.");
        lossSignal.TrySetResult(true);
    }

    private delegate void WinEventProc(
        IntPtr winEventHook,
        uint eventType,
        IntPtr hwnd,
        int idObject,
        int idChild,
        uint eventThread,
        uint eventTime);

    [DllImport("user32.dll", SetLastError = true)]
    private static extern IntPtr SetWinEventHook(
        uint eventMin,
        uint eventMax,
        IntPtr hmodWinEventProc,
        WinEventProc lpfnWinEventProc,
        uint idProcess,
        uint idThread,
        uint flags);

    [DllImport("user32.dll")]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool UnhookWinEvent(IntPtr hWinEventHook);
}
