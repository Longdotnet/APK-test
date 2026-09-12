using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class SyntheticPreKeyDownAbortRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        SendInputVirtualKeyReleaseRequiresDownEmission();
        SendInputScanReleaseRequiresDownEmission();
    }

    private static void SendInputVirtualKeyReleaseRequiresDownEmission()
    {
        if (RobloxSendInputVirtualKeyDiagnosticProbe.ShouldEmitBestEffortRelease(keyDownEmitted: false))
        {
            throw new InvalidOperationException(
                "A SendInput virtual-key probe aborted before KeyDown must not emit an orphan KeyUp.");
        }

        if (!RobloxSendInputVirtualKeyDiagnosticProbe.ShouldEmitBestEffortRelease(keyDownEmitted: true))
        {
            throw new InvalidOperationException(
                "A SendInput virtual-key probe that emitted KeyDown must retain best-effort KeyUp cleanup.");
        }
    }

    private static void SendInputScanReleaseRequiresDownEmission()
    {
        if (RobloxSendInputScanDiagnosticProbe.ShouldEmitBestEffortRelease(keyDownEmitted: false))
        {
            throw new InvalidOperationException(
                "A SendInput scan-code probe aborted before KeyDown must not emit an orphan KeyUp.");
        }

        if (!RobloxSendInputScanDiagnosticProbe.ShouldEmitBestEffortRelease(keyDownEmitted: true))
        {
            throw new InvalidOperationException(
                "A SendInput scan-code probe that emitted KeyDown must retain best-effort KeyUp cleanup.");
        }
    }
}
