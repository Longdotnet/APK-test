using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class WindowsInteractiveSessionRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        Equal(WindowsSessionParity.Same,
            WindowsInteractiveSession.Classify(1, 1),
            "same session parity");
        Equal(WindowsSessionParity.Different,
            WindowsInteractiveSession.Classify(1, 2),
            "different session parity");
        Equal(WindowsSessionParity.Unknown,
            WindowsInteractiveSession.Classify(null, 1),
            "unknown app session parity");
        Equal(WindowsSessionParity.Unknown,
            WindowsInteractiveSession.Classify(1, null),
            "unknown target session parity");
        Equal("NONE", WindowsInteractiveSession.FormatConsoleSession(0xFFFFFFFF),
            "invalid active-console session formatting");
        Equal("7", WindowsInteractiveSession.FormatConsoleSession(7),
            "active-console session formatting");

        var mismatch = new WindowsInteractiveSessionSnapshot(1, 2, 1, WindowsSessionParity.Different, 0, 0);
        True(mismatch.IsKnownMismatch, "known session mismatch must be explicit");
        True(mismatch.AppIsActiveConsole, "app active-console evidence");
        False(mismatch.TargetIsActiveConsole, "target active-console evidence");
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
