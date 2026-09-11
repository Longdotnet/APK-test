using System.Diagnostics;
using System.Runtime.InteropServices;

namespace RobloxPiano.App;

internal enum ProcessElevationState
{
    Unknown = 0,
    Standard = 1,
    Elevated = 2
}

internal enum ProcessElevationParity
{
    Unknown = 0,
    Same = 1,
    TargetHigher = 2,
    AppHigher = 3
}

internal readonly record struct ProcessPrivilegeSnapshot(
    ProcessElevationState AppElevation,
    ProcessElevationState TargetElevation,
    ProcessElevationParity Parity)
{
    internal bool IsTargetHigher => Parity == ProcessElevationParity.TargetHigher;
}

internal static class WindowsProcessPrivilege
{
    private const uint TokenQuery = 0x0008;
    private const int TokenElevationInformationClass = 20;

    internal static ProcessPrivilegeSnapshot Capture(int targetProcessId)
    {
        var app = TryGetElevation(Environment.ProcessId);
        var target = TryGetElevation(targetProcessId);
        return new ProcessPrivilegeSnapshot(app, target, Classify(app, target));
    }

    internal static ProcessElevationParity Classify(
        ProcessElevationState app,
        ProcessElevationState target)
    {
        if (app == ProcessElevationState.Unknown || target == ProcessElevationState.Unknown)
        {
            return ProcessElevationParity.Unknown;
        }

        if (app == target)
        {
            return ProcessElevationParity.Same;
        }

        return target == ProcessElevationState.Elevated
            ? ProcessElevationParity.TargetHigher
            : ProcessElevationParity.AppHigher;
    }

    private static ProcessElevationState TryGetElevation(int processId)
    {
        try
        {
            using var process = Process.GetProcessById(processId);
            if (!OpenProcessToken(process.Handle, TokenQuery, out var tokenHandle))
            {
                return ProcessElevationState.Unknown;
            }

            try
            {
                var size = Marshal.SizeOf<TokenElevation>();
                var buffer = Marshal.AllocHGlobal(size);
                try
                {
                    if (!GetTokenInformation(
                            tokenHandle,
                            TokenElevationInformationClass,
                            buffer,
                            size,
                            out _))
                    {
                        return ProcessElevationState.Unknown;
                    }

                    var elevation = Marshal.PtrToStructure<TokenElevation>(buffer);
                    return elevation.TokenIsElevated != 0
                        ? ProcessElevationState.Elevated
                        : ProcessElevationState.Standard;
                }
                finally
                {
                    Marshal.FreeHGlobal(buffer);
                }
            }
            finally
            {
                CloseHandle(tokenHandle);
            }
        }
        catch (ArgumentException)
        {
            return ProcessElevationState.Unknown;
        }
        catch (InvalidOperationException)
        {
            return ProcessElevationState.Unknown;
        }
        catch (SystemException)
        {
            return ProcessElevationState.Unknown;
        }
    }

    [StructLayout(LayoutKind.Sequential)]
    private readonly struct TokenElevation
    {
        internal readonly uint TokenIsElevated;
    }

    [DllImport("advapi32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool OpenProcessToken(IntPtr processHandle, uint desiredAccess, out IntPtr tokenHandle);

    [DllImport("advapi32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool GetTokenInformation(
        IntPtr tokenHandle,
        int tokenInformationClass,
        IntPtr tokenInformation,
        int tokenInformationLength,
        out int returnLength);

    [DllImport("kernel32.dll", SetLastError = true)]
    [return: MarshalAs(UnmanagedType.Bool)]
    private static extern bool CloseHandle(IntPtr handle);
}
