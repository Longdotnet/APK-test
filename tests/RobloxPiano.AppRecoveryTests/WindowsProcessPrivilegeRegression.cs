using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class WindowsProcessPrivilegeRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        Equal(ProcessElevationParity.Same,
            WindowsProcessPrivilege.Classify(ProcessElevationState.Standard, ProcessElevationState.Standard),
            "standard/standard parity");
        Equal(ProcessElevationParity.Same,
            WindowsProcessPrivilege.Classify(ProcessElevationState.Elevated, ProcessElevationState.Elevated),
            "elevated/elevated parity");
        Equal(ProcessElevationParity.TargetHigher,
            WindowsProcessPrivilege.Classify(ProcessElevationState.Standard, ProcessElevationState.Elevated),
            "target-higher parity");
        Equal(ProcessElevationParity.AppHigher,
            WindowsProcessPrivilege.Classify(ProcessElevationState.Elevated, ProcessElevationState.Standard),
            "app-higher parity");
        Equal(ProcessElevationParity.Unknown,
            WindowsProcessPrivilege.Classify(ProcessElevationState.Unknown, ProcessElevationState.Standard),
            "unknown app parity");
        Equal(ProcessElevationParity.Unknown,
            WindowsProcessPrivilege.Classify(ProcessElevationState.Standard, ProcessElevationState.Unknown),
            "unknown target parity");
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }
}
