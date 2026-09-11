using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class WindowIdentityProbeAuthorizationRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var identityLost = new RobloxFieldInputProbeResult(
            "window-identity-lost",
            true,
            true,
            WindowsInputDesktopParity.Same,
            true,
            true,
            false,
            0x57,
            TimeSpan.FromMilliseconds(125));

        False(identityLost.NativeDeliveryObserved, "window identity loss must invalidate native-delivery authorization evidence");
        Equal(
            RobloxInputCheckVerdict.WindowIdentityLostDuringProbe,
            identityLost.Assess(null).Verdict,
            "window identity loss must have a distinct fail-closed verdict");

        var trusted = identityLost with { WindowIdentityHeldDuringProbe = true };
        True(trusted.NativeDeliveryObserved, "trusted window identity plus existing native evidence should remain observable");
        Equal(
            RobloxInputCheckVerdict.NativeDeliveryAwaitingObservation,
            trusted.Assess(null).Verdict,
            "trusted native evidence still requires explicit Roblox field observation");
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void True(bool value, string message)
    {
        if (!value) throw new InvalidOperationException(message);
    }

    private static void False(bool value, string message) => True(!value, message);
}
