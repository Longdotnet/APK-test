using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class SyntheticProbeForegroundContinuityRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        PreKeyDownGateRequiresTrustedForeground();
        HoldContinuityRemainsSticky();
    }

    private static void PreKeyDownGateRequiresTrustedForeground()
    {
        if (!RobloxSyntheticProbeForegroundContinuity.CanBeginHold(
                continuityPreserved: true,
                trustedTargetSurface: true,
                targetForeground: true))
        {
            throw new InvalidOperationException(
                "A clean selected Roblox foreground surface must be allowed to cross the synthetic pre-keydown gate.");
        }

        if (RobloxSyntheticProbeForegroundContinuity.CanBeginHold(
                continuityPreserved: true,
                trustedTargetSurface: false,
                targetForeground: true))
        {
            throw new InvalidOperationException(
                "A same-process but untrusted Roblox surface must abort before synthetic key down.");
        }

        if (RobloxSyntheticProbeForegroundContinuity.CanBeginHold(
                continuityPreserved: true,
                trustedTargetSurface: true,
                targetForeground: false))
        {
            throw new InvalidOperationException(
                "A trusted selected HWND that is no longer foreground must abort before synthetic key down.");
        }

        if (RobloxSyntheticProbeForegroundContinuity.CanBeginHold(
                continuityPreserved: false,
                trustedTargetSurface: true,
                targetForeground: true))
        {
            throw new InvalidOperationException(
                "A continuity object already marked lost must never be re-armed at the pre-keydown boundary.");
        }
    }

    private static void HoldContinuityRemainsSticky()
    {
        if (!RobloxSyntheticProbeForegroundContinuity.ShouldPreserveAfterObservation(
                holdActive: false,
                continuityPreserved: true,
                trustedTargetSurface: false,
                targetForeground: false))
        {
            throw new InvalidOperationException(
                "Foreground events outside an active synthetic hold must not invalidate a future probe.");
        }

        if (!RobloxSyntheticProbeForegroundContinuity.ShouldPreserveAfterObservation(
                holdActive: true,
                continuityPreserved: true,
                trustedTargetSurface: true,
                targetForeground: true))
        {
            throw new InvalidOperationException(
                "A foreground event that remains on the trusted selected Roblox surface must preserve continuity.");
        }

        if (RobloxSyntheticProbeForegroundContinuity.ShouldPreserveAfterObservation(
                holdActive: true,
                continuityPreserved: true,
                trustedTargetSurface: false,
                targetForeground: false))
        {
            throw new InvalidOperationException(
                "A foreground hop outside the trusted selected Roblox surface during synthetic key hold must fail closed.");
        }

        if (RobloxSyntheticProbeForegroundContinuity.ShouldPreserveAfterObservation(
                holdActive: true,
                continuityPreserved: true,
                trustedTargetSurface: false,
                targetForeground: true))
        {
            throw new InvalidOperationException(
                "A same-process but untrusted Roblox surface must not preserve a synthetic field probe.");
        }

        if (RobloxSyntheticProbeForegroundContinuity.ShouldPreserveAfterObservation(
                holdActive: true,
                continuityPreserved: true,
                trustedTargetSurface: true,
                targetForeground: false))
        {
            throw new InvalidOperationException(
                "A selected-window identity match cannot preserve continuity when Roblox is not foreground.");
        }

        if (!RobloxSyntheticProbeForegroundContinuity.ShouldPreserveAfterObservation(
                holdActive: true,
                continuityPreserved: false,
                trustedTargetSurface: true,
                targetForeground: true))
        {
            throw new InvalidOperationException(
                "An already-invalid synthetic hold must remain terminal instead of being re-armed by focus recovery.");
        }
    }
}
