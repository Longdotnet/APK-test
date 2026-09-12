using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class HardwareKeyBaselineRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        if (!RobloxHardwareKeyBaselineProbe.IsPhysicalBaselineCandidate(
                flags: 0,
                isTargetVirtualKey: true,
                trustedTargetSurface: true))
        {
            throw new InvalidOperationException("An unmarked target-key event on the trusted selected Roblox window tree must remain eligible as a physical-baseline candidate.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsPhysicalBaselineCandidate(
                flags: 0x10,
                isTargetVirtualKey: true,
                trustedTargetSurface: true))
        {
            throw new InvalidOperationException("LLKHF_INJECTED events must never count as a physical-baseline candidate.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsPhysicalBaselineCandidate(
                flags: 0,
                isTargetVirtualKey: false,
                trustedTargetSurface: true))
        {
            throw new InvalidOperationException("Unrelated keys must never enter the real-key baseline evidence stream.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsPhysicalBaselineCandidate(
                flags: 0,
                isTargetVirtualKey: true,
                trustedTargetSurface: false))
        {
            throw new InvalidOperationException("A W event observed on an untrusted/alternate Roblox window must not qualify as the real-key baseline.");
        }

        if (!RobloxHardwareKeyBaselineProbe.IsTrustedBaselineSurface(Snapshot(
                WindowsRobloxWindowRelation.ExactTarget,
                mainReplaced: false)))
        {
            throw new InvalidOperationException("The exact selected Roblox HWND must remain trusted for the real-key baseline.");
        }

        if (!RobloxHardwareKeyBaselineProbe.IsTrustedBaselineSurface(Snapshot(
                WindowsRobloxWindowRelation.TargetWindowTree,
                mainReplaced: false)))
        {
            throw new InvalidOperationException("A foreground child/root-owner belonging to the selected Roblox tree must remain trusted.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsTrustedBaselineSurface(Snapshot(
                WindowsRobloxWindowRelation.SameProcessAlternateRoot,
                mainReplaced: false)))
        {
            throw new InvalidOperationException("Same-PID alternate Roblox roots must fail closed for the real-key baseline, matching synthetic probe authorization semantics.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsTrustedBaselineSurface(Snapshot(
                WindowsRobloxWindowRelation.ExactTarget,
                mainReplaced: true)))
        {
            throw new InvalidOperationException("A live Roblox MainWindowHandle replacement must invalidate the real-key baseline surface.");
        }

        if (!RobloxHardwareKeyBaselineProbe.IsHoldContinuityTrusted(
                keyDownObserved: true,
                keyUpObserved: true,
                continuityPreserved: true))
        {
            throw new InvalidOperationException("A continuously trusted real-key hold must remain eligible for baseline evidence.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsHoldContinuityTrusted(
                keyDownObserved: true,
                keyUpObserved: true,
                continuityPreserved: false))
        {
            throw new InvalidOperationException("Focus/window loss between real W down and up must permanently invalidate that baseline attempt even if Roblox is trusted again at key-up.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsHoldContinuityTrusted(
                keyDownObserved: true,
                keyUpObserved: false,
                continuityPreserved: true))
        {
            throw new InvalidOperationException("A real-key baseline cannot be trusted before the matching non-injected key-up is observed.");
        }

        if (!RobloxHardwareKeyBaselineProbe.ShouldPreserveHoldContinuityAfterForegroundEvent(
                keyDownObserved: false,
                keyUpObserved: false,
                continuityPreserved: false,
                trustedTargetSurface: false,
                targetForeground: false))
        {
            throw new InvalidOperationException("Foreground changes before the accepted physical W-down must not create a false hold-continuity failure.");
        }

        if (!RobloxHardwareKeyBaselineProbe.ShouldPreserveHoldContinuityAfterForegroundEvent(
                keyDownObserved: true,
                keyUpObserved: false,
                continuityPreserved: true,
                trustedTargetSurface: true,
                targetForeground: true))
        {
            throw new InvalidOperationException("Foreground events that remain on the trusted selected Roblox tree must preserve an active real-key hold.");
        }

        if (RobloxHardwareKeyBaselineProbe.ShouldPreserveHoldContinuityAfterForegroundEvent(
                keyDownObserved: true,
                keyUpObserved: false,
                continuityPreserved: true,
                trustedTargetSurface: false,
                targetForeground: false))
        {
            throw new InvalidOperationException("An event-driven foreground hop away from Roblox during an active W hold must fail closed even when the hop could be shorter than the polling interval.");
        }

        if (RobloxHardwareKeyBaselineProbe.ShouldPreserveHoldContinuityAfterForegroundEvent(
                keyDownObserved: true,
                keyUpObserved: false,
                continuityPreserved: true,
                trustedTargetSurface: true,
                targetForeground: false))
        {
            throw new InvalidOperationException("The hold must fail closed when target.IsForeground is false even if a stale identity snapshot still appears trusted.");
        }

        if (!RobloxHardwareKeyBaselineProbe.ShouldPreserveHoldContinuityAfterForegroundEvent(
                keyDownObserved: true,
                keyUpObserved: true,
                continuityPreserved: true,
                trustedTargetSurface: false,
                targetForeground: false))
        {
            throw new InvalidOperationException("Foreground events after the accepted W-up must not retroactively alter the completed hold result.");
        }

        var complete = new RobloxHardwareKeyBaselineResult(
            "test",
            ActivationConfirmed: true,
            StableForegroundConfirmed: true,
            NonInjectedKeyDownObserved: true,
            NonInjectedKeyUpObserved: true,
            ForegroundHeldAtDown: true,
            ForegroundHeldAtUp: true,
            TrustedWindowSurfaceAtDown: true,
            TrustedWindowSurfaceAtUp: true,
            VirtualKey: 0x57,
            ObservationDuration: TimeSpan.FromMilliseconds(250))
        {
            HoldContinuityPreserved = true
        };
        if (!complete.PhysicalBaselineObserved)
        {
            throw new InvalidOperationException("A complete non-injected W down/up pair continuously held on the trusted selected Roblox surface must establish baseline observation.");
        }

        if ((complete with { NonInjectedKeyUpObserved = false }).PhysicalBaselineObserved
            || (complete with { ForegroundHeldAtUp = false }).PhysicalBaselineObserved
            || (complete with { TrustedWindowSurfaceAtDown = false }).PhysicalBaselineObserved
            || (complete with { TrustedWindowSurfaceAtUp = false }).PhysicalBaselineObserved
            || (complete with { HoldContinuityPreserved = false, FirstHoldContinuityLossAt = TimeSpan.FromMilliseconds(5) }).PhysicalBaselineObserved
            || (complete with { StableForegroundConfirmed = false }).PhysicalBaselineObserved)
        {
            throw new InvalidOperationException("Real-key baseline assessment must fail closed when release, continuous foreground/window ownership, selected-window identity, or stable activation evidence is incomplete.");
        }

        if (RobloxHardwareKeyBaselineProbe.HoldContinuitySampleInterval > TimeSpan.FromMilliseconds(25))
        {
            throw new InvalidOperationException("Polling must remain as a bounded fallback even though foreground ownership is now monitored event-by-event.");
        }
    }

    private static WindowsRobloxWindowIdentitySnapshot Snapshot(
        WindowsRobloxWindowRelation relation,
        bool mainReplaced)
        => new(
            TargetWindowHandle: (IntPtr)0x100,
            CurrentMainWindowHandle: mainReplaced ? (IntPtr)0x200 : (IntPtr)0x100,
            ForegroundWindowHandle: (IntPtr)0x100,
            ForegroundProcessId: 123,
            ForegroundThreadId: 456,
            ForegroundRootHandle: (IntPtr)0x100,
            ForegroundRootProcessId: 123,
            ForegroundRootOwnerHandle: (IntPtr)0x100,
            ForegroundRootOwnerProcessId: 123,
            TargetWindowClass: "RobloxWindow",
            ForegroundWindowClass: "RobloxWindow",
            ForegroundRootClass: "RobloxWindow",
            Relation: relation,
            TargetProcessAlive: true,
            TargetMainWindowReplaced: mainReplaced);
}
