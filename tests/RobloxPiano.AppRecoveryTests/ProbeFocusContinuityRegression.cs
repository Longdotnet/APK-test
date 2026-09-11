using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class ProbeFocusContinuityRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        var healthy = new RobloxProbeFocusContinuity();
        if (!healthy.Observe(true, false, TimeSpan.Zero))
        {
            throw new InvalidOperationException("A foreground sample must initially preserve probe continuity.");
        }

        if (!healthy.Observe(true, true, TimeSpan.FromMilliseconds(25)))
        {
            throw new InvalidOperationException("Foreground continuity must remain healthy while Roblox stays focused.");
        }

        if (!healthy.WindowsKeyDownObserved || !healthy.ForegroundHeldContinuously || healthy.SamplesObserved != 2)
        {
            throw new InvalidOperationException("Healthy continuity evidence did not retain key-down and sample count correctly.");
        }

        var transientLoss = new RobloxProbeFocusContinuity();
        transientLoss.Observe(true, true, TimeSpan.Zero);
        if (transientLoss.Observe(false, true, TimeSpan.FromMilliseconds(75)))
        {
            throw new InvalidOperationException("A sampled Roblox focus loss must stop the held-input probe immediately.");
        }

        if (transientLoss.FirstFocusLossAt != TimeSpan.FromMilliseconds(75))
        {
            throw new InvalidOperationException("The first focus-loss boundary must be retained exactly.");
        }

        if (transientLoss.Observe(true, true, TimeSpan.FromMilliseconds(100)))
        {
            throw new InvalidOperationException("Later focus recovery must never erase an earlier focus loss.");
        }

        if (transientLoss.ForegroundHeldContinuously)
        {
            throw new InvalidOperationException("Transient focus loss must permanently invalidate native-delivery confirmation for that probe.");
        }

        var threw = false;
        try
        {
            transientLoss.Observe(true, false, TimeSpan.FromMilliseconds(-1));
        }
        catch (ArgumentOutOfRangeException)
        {
            threw = true;
        }

        if (!threw)
        {
            throw new InvalidOperationException("Negative elapsed probe samples must fail closed.");
        }
    }
}
