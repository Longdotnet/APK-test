using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class PowerShellOracleMappingRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        var productionSameSemantics = new KeyboardStrokeMapping(
            VirtualKey: 0x57,
            Modifiers: 0,
            KeyboardLayout: (IntPtr)0x1111,
            KeyboardThreadId: 42);
        var oracleSameSemantics = new KeyboardStrokeMapping(
            VirtualKey: 0x57,
            Modifiers: 0,
            KeyboardLayout: (IntPtr)0x2222,
            KeyboardThreadId: 0);
        if (!WindowsKeyboardInputSink.HasSameKeySemantics(productionSameSemantics, oracleSameSemantics))
        {
            throw new InvalidOperationException("Keyboard mapping parity must compare emitted VK/modifier semantics rather than HKL or thread identity.");
        }

        var productionDifferentSemantics = productionSameSemantics with { Modifiers = 0x01 };
        if (WindowsKeyboardInputSink.HasSameKeySemantics(productionDifferentSemantics, oracleSameSemantics))
        {
            throw new InvalidOperationException("A modifier difference must be treated as a production/oracle mapping mismatch.");
        }

        var oracleDeliveredButProductionDiffers = new RobloxFieldInputProbeResult(
            "oracle-regression",
            activationConfirmed: true,
            stableForegroundConfirmed: true,
            WindowsInputDesktopParity.Same,
            windowsReportedKeyDown: true,
            foregroundHeldDuringProbe: true,
            virtualKey: 0x57,
            holdDuration: TimeSpan.FromMilliseconds(650))
        {
            ProductionMappingEquivalentToOracle = false
        };

        var assessment = oracleDeliveredButProductionDiffers.Assess(robloxReacted: true);
        if (assessment.Verdict != RobloxInputCheckVerdict.PowerShellOracleConfirmedProductionMappingDiffers)
        {
            throw new InvalidOperationException(
                $"Expected mapping-difference verdict after field-confirmed oracle delivery, got {assessment.Verdict}.");
        }

        if (assessment.IsSuccess)
        {
            throw new InvalidOperationException("Oracle success must not authorize normal playback when production mapping differs.");
        }

        if (!assessment.NextAction.Contains("mapping", StringComparison.OrdinalIgnoreCase))
        {
            throw new InvalidOperationException("Mapping-difference recovery must identify the production mapping boundary.");
        }

        var equivalentResult = oracleDeliveredButProductionDiffers with
        {
            ProductionMappingEquivalentToOracle = true
        };
        var equivalentAssessment = equivalentResult.Assess(robloxReacted: true);
        if (equivalentAssessment.Verdict != RobloxInputCheckVerdict.Confirmed || !equivalentAssessment.IsSuccess)
        {
            throw new InvalidOperationException("Field-confirmed oracle delivery may authorize playback only when production mapping semantics are equivalent.");
        }
    }
}
