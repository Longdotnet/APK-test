using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class WindowsRobloxWindowIdentityRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var target = new IntPtr(0x100);
        var foreground = new IntPtr(0x200);
        var root = new IntPtr(0x300);
        var owner = new IntPtr(0x400);

        Equal(
            WindowsRobloxWindowRelation.ExactTarget,
            WindowsRobloxWindowIdentity.Classify(target, 10, target, 10, target, 10, target, 10),
            "exact selected Roblox HWND");

        Equal(
            WindowsRobloxWindowRelation.TargetWindowTree,
            WindowsRobloxWindowIdentity.Classify(target, 10, foreground, 20, target, 10, owner, 20),
            "foreground rooted at selected Roblox HWND");

        Equal(
            WindowsRobloxWindowRelation.TargetWindowTree,
            WindowsRobloxWindowIdentity.Classify(target, 10, foreground, 20, root, 20, target, 10),
            "foreground owned by selected Roblox HWND");

        Equal(
            WindowsRobloxWindowRelation.SameProcessAlternateRoot,
            WindowsRobloxWindowIdentity.Classify(target, 10, foreground, 10, root, 10, owner, 10),
            "same Roblox PID but alternate top-level root");

        Equal(
            WindowsRobloxWindowRelation.DifferentProcess,
            WindowsRobloxWindowIdentity.Classify(target, 10, foreground, 20, root, 20, owner, 20),
            "unrelated foreground process");

        Equal(
            WindowsRobloxWindowRelation.Unknown,
            WindowsRobloxWindowIdentity.Classify(IntPtr.Zero, 10, foreground, 10, root, 10, owner, 10),
            "missing selected HWND");

        var exact = Snapshot(WindowsRobloxWindowRelation.ExactTarget, target, target, targetMainWindowReplaced: false);
        True(exact.IsTrustedProbeSurface, "exact selected Roblox surface must be trusted for the authorizing probe");

        var tree = Snapshot(WindowsRobloxWindowRelation.TargetWindowTree, target, target, targetMainWindowReplaced: false);
        True(tree.IsTrustedProbeSurface, "selected Roblox window tree must be trusted for the authorizing probe");

        var alternate = Snapshot(WindowsRobloxWindowRelation.SameProcessAlternateRoot, target, target, targetMainWindowReplaced: false);
        False(alternate.IsTrustedProbeSurface, "same-PID alternate root must not authorize continued input");

        var replaced = Snapshot(WindowsRobloxWindowRelation.ExactTarget, target, new IntPtr(0x999), targetMainWindowReplaced: true);
        True(replaced.IsKnownTargetWindowReplacement, "live Roblox process with changed MainWindowHandle must be explicit");
        False(replaced.IsTrustedProbeSurface, "a replaced Roblox main window must fail closed even if the old HWND is foreground");

        var unknown = Snapshot(WindowsRobloxWindowRelation.Unknown, target, target, targetMainWindowReplaced: false);
        False(unknown.IsTrustedProbeSurface, "unknown window identity must fail closed for an authorizing probe");

        var processGone = replaced with { TargetProcessAlive = false };
        False(processGone.IsKnownTargetWindowReplacement, "dead process is not classified as a live-window replacement");
    }

    private static WindowsRobloxWindowIdentitySnapshot Snapshot(
        WindowsRobloxWindowRelation relation,
        IntPtr target,
        IntPtr currentMain,
        bool targetMainWindowReplaced)
        => new(
            target,
            currentMain,
            target,
            10,
            11,
            target,
            10,
            target,
            10,
            "WINDOWSCLIENT",
            "WINDOWSCLIENT",
            "WINDOWSCLIENT",
            relation,
            true,
            targetMainWindowReplaced);

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
