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
            ObservationDuration: TimeSpan.FromMilliseconds(250));
        if (!complete.PhysicalBaselineObserved)
        {
            throw new InvalidOperationException("A complete non-injected W down/up pair on the trusted selected Roblox surface must establish baseline observation.");
        }

        if ((complete with { NonInjectedKeyUpObserved = false }).PhysicalBaselineObserved
            || (complete with { ForegroundHeldAtUp = false }).PhysicalBaselineObserved
            || (complete with { TrustedWindowSurfaceAtDown = false }).PhysicalBaselineObserved
            || (complete with { TrustedWindowSurfaceAtUp = false }).PhysicalBaselineObserved
            || (complete with { StableForegroundConfirmed = false }).PhysicalBaselineObserved)
        {
            throw new InvalidOperationException("Real-key baseline assessment must fail closed when release, foreground continuity, selected-window identity, or stable activation evidence is incomplete.");
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
