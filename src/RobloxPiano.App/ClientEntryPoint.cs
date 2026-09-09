namespace RobloxPiano.App;

/// <summary>
/// Synchronous Windows entrypoint that guarantees WinForms starts on an STA thread before any
/// async command-line path can participate. WinForms OLE drag/drop registration depends on STA.
/// </summary>
internal static class ClientEntryPoint
{
    [STAThread]
    public static int Main(string[] args)
    {
        if (args.Length == 1 && args[0].Equals("--ui-smoke", StringComparison.OrdinalIgnoreCase))
        {
            return RunUiStartupSmoke();
        }

        if (args.Length == 1 && args[0].Equals("--input-abi-smoke", StringComparison.OrdinalIgnoreCase))
        {
            return RunInputAbiSmoke();
        }

        return Program.Main(args).GetAwaiter().GetResult();
    }

    private static int RunUiStartupSmoke()
    {
        if (Thread.CurrentThread.GetApartmentState() != ApartmentState.STA)
        {
            Console.Error.WriteLine($"UI startup thread is {Thread.CurrentThread.GetApartmentState()}, expected STA.");
            return 5;
        }

        try
        {
            ApplicationConfiguration.Initialize();

            using var library = new SheetLibraryForm();
            _ = library.Handle;

            // The playback form historically registered OLE drag/drop too. Creating its native
            // handle here catches the exact production regression where Library opened but the
            // player later raised "DragDrop registration did not succeed".
            using var player = new ClientMainForm();
            _ = player.Handle;

            Console.WriteLine(
                $"UI startup smoke passed. apartment={Thread.CurrentThread.GetApartmentState()}; " +
                $"libraryDragDrop={library.AllowDrop}; playerDragDrop={player.AllowDrop}.");
            return 0;
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"UI startup smoke failed: {exception}");
            return 6;
        }
    }

    private static int RunInputAbiSmoke()
    {
        try
        {
            NativeMethods.ValidateInputAbi();
            Console.WriteLine(
                $"Windows INPUT ABI smoke passed. actual={NativeMethods.InputStructureSize}; " +
                $"expected={NativeMethods.ExpectedInputStructureSize}; pointerSize={IntPtr.Size}.");
            return 0;
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"Windows INPUT ABI smoke failed: {exception}");
            return 7;
        }
    }
}
