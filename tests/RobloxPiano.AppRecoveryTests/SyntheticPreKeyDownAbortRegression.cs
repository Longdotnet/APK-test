using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class SyntheticPreKeyDownAbortRegression
{
    [ModuleInitializer]
    internal static void Verify()
    {
        SendInputVirtualKeyReleaseRequiresUnreleasedDown();
        SendInputScanReleaseRequiresUnreleasedDown();
    }

    private static void SendInputVirtualKeyReleaseRequiresUnreleasedDown()
    {
        if (RobloxSendInputVirtualKeyDiagnosticProbe.ShouldEmitBestEffortRelease(
                keyDownEmitted: false,
                keyUpEmitted: false))
        {
            throw new InvalidOperationException(
                "A SendInput virtual-key probe aborted before KeyDown must emit zero cleanup events.");
        }

        if (!RobloxSendInputVirtualKeyDiagnosticProbe.ShouldEmitBestEffortRelease(
                keyDownEmitted: true,
                keyUpEmitted: false))
        {
            throw new InvalidOperationException(
                "A SendInput virtual-key probe with an unreleased KeyDown must retain best-effort KeyUp cleanup.");
        }

        if (RobloxSendInputVirtualKeyDiagnosticProbe.ShouldEmitBestEffortRelease(
                keyDownEmitted: true,
                keyUpEmitted: true))
        {
            throw new InvalidOperationException(
                "A successful SendInput virtual-key Down/Up pair must not emit a duplicate KeyUp from finally.");
        }
    }

    private static void SendInputScanReleaseRequiresUnreleasedDown()
    {
        if (RobloxSendInputScanDiagnosticProbe.ShouldEmitBestEffortRelease(
                keyDownEmitted: false,
                keyUpEmitted: false))
        {
            throw new InvalidOperationException(
                "A SendInput scan-code probe aborted before KeyDown must emit zero cleanup events.");
        }

        if (!RobloxSendInputScanDiagnosticProbe.ShouldEmitBestEffortRelease(
                keyDownEmitted: true,
                keyUpEmitted: false))
        {
            throw new InvalidOperationException(
                "A SendInput scan-code probe with an unreleased KeyDown must retain best-effort KeyUp cleanup.");
        }

        if (RobloxSendInputScanDiagnosticProbe.ShouldEmitBestEffortRelease(
                keyDownEmitted: true,
                keyUpEmitted: true))
        {
            throw new InvalidOperationException(
                "A successful SendInput scan-code Down/Up pair must not emit a duplicate KeyUp from finally.");
        }
    }
}
