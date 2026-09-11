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
                targetForeground: true))
        {
            throw new InvalidOperationException("An unmarked target-key event while Roblox is foreground must remain eligible as a physical-baseline candidate.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsPhysicalBaselineCandidate(
                flags: 0x10,
                isTargetVirtualKey: true,
                targetForeground: true))
        {
            throw new InvalidOperationException("LLKHF_INJECTED events must never count as a physical-baseline candidate.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsPhysicalBaselineCandidate(
                flags: 0,
                isTargetVirtualKey: false,
                targetForeground: true))
        {
            throw new InvalidOperationException("Unrelated keys must never enter the real-key baseline evidence stream.");
        }

        if (RobloxHardwareKeyBaselineProbe.IsPhysicalBaselineCandidate(
                flags: 0,
                isTargetVirtualKey: true,
                targetForeground: false))
        {
            throw new InvalidOperationException("A W event observed after Roblox loses foreground must not qualify as the real-key baseline.");
        }

        var complete = new RobloxHardwareKeyBaselineResult(
            "test",
            ActivationConfirmed: true,
            StableForegroundConfirmed: true,
            NonInjectedKeyDownObserved: true,
            NonInjectedKeyUpObserved: true,
            ForegroundHeldAtDown: true,
            ForegroundHeldAtUp: true,
            VirtualKey: 0x57,
            ObservationDuration: TimeSpan.FromMilliseconds(250));
        if (!complete.PhysicalBaselineObserved)
        {
            throw new InvalidOperationException("A complete non-injected W down/up pair on the trusted Roblox foreground must establish baseline observation.");
        }

        if ((complete with { NonInjectedKeyUpObserved = false }).PhysicalBaselineObserved
            || (complete with { ForegroundHeldAtUp = false }).PhysicalBaselineObserved
            || (complete with { StableForegroundConfirmed = false }).PhysicalBaselineObserved)
        {
            throw new InvalidOperationException("Real-key baseline assessment must fail closed when release, foreground continuity, or stable activation evidence is incomplete.");
        }
    }
}
