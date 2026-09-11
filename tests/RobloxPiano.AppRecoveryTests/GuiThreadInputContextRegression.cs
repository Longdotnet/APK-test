using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class GuiThreadInputContextRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        Equal(
            WindowsGuiThreadFocusAssessment.NoFocusedWindow,
            WindowsGuiThreadInputContext.AssessFocus(IntPtr.Zero, WindowsRobloxWindowRelation.Unknown),
            "zero focus HWND must remain explicit instead of being treated as trusted");

        Equal(
            WindowsGuiThreadFocusAssessment.TrustedTargetSurface,
            WindowsGuiThreadInputContext.AssessFocus(new IntPtr(0x1234), WindowsRobloxWindowRelation.ExactTarget),
            "exact target focus should be trusted evidence");

        Equal(
            WindowsGuiThreadFocusAssessment.TrustedTargetSurface,
            WindowsGuiThreadInputContext.AssessFocus(new IntPtr(0x1234), WindowsRobloxWindowRelation.TargetWindowTree),
            "child/root-owner focus inside the selected target tree should be trusted evidence");

        Equal(
            WindowsGuiThreadFocusAssessment.SameProcessAlternateRoot,
            WindowsGuiThreadInputContext.AssessFocus(new IntPtr(0x1234), WindowsRobloxWindowRelation.SameProcessAlternateRoot),
            "same-PID alternate-root focus must stay visible as suspicious context");

        Equal(
            WindowsGuiThreadFocusAssessment.DifferentProcess,
            WindowsGuiThreadInputContext.AssessFocus(new IntPtr(0x1234), WindowsRobloxWindowRelation.DifferentProcess),
            "foreign-process focus must stay visible as foreign context");

        Equal(
            WindowsGuiThreadFocusAssessment.Unknown,
            WindowsGuiThreadInputContext.AssessFocus(new IntPtr(0x1234), WindowsRobloxWindowRelation.Unknown),
            "unknown focus relation must fail visible instead of being promoted to trusted");
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }
}
