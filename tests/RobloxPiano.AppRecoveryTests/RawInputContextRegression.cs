using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class RawInputContextRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        Equal(
            WindowsRawInputInventoryAssessment.NoKeyboardDeviceObserved,
            WindowsRawInputContext.Assess(0),
            "zero keyboard-class Raw Input devices must remain explicit");

        Equal(
            WindowsRawInputInventoryAssessment.PhysicalKeyboardDeviceObserved,
            WindowsRawInputContext.Assess(1),
            "one keyboard-class Raw Input device should be observable inventory evidence");

        Equal(
            WindowsRawInputInventoryAssessment.PhysicalKeyboardDeviceObserved,
            WindowsRawInputContext.Assess(8),
            "multiple keyboard-class devices should not change the assessment semantics");

        Equal(
            "UNOBSERVABLE_CROSS_PROCESS",
            WindowsRawInputContextSnapshot.TargetRegistrationVisibility,
            "diagnostics must never imply that another process's RegisterRawInputDevices state is observable");
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }
}
