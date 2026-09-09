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
            return RunInputCompatibilitySmoke();
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

    private static int RunInputCompatibilitySmoke()
    {
        try
        {
            const ushort virtualKeyA = 0x41;
            var down = WindowsKeyboardInputSink.BuildFieldBaselineKeyEvent(virtualKeyA, keyUp: false);
            var up = WindowsKeyboardInputSink.BuildFieldBaselineKeyEvent(virtualKeyA, keyUp: true);

            if (down.VirtualKey != virtualKeyA || down.Flags != 0)
            {
                throw new InvalidOperationException("Roblox field-baseline key-down event is invalid.");
            }

            if (up.VirtualKey != virtualKeyA || up.Flags != NativeMethods.KeyEventKeyUp)
            {
                throw new InvalidOperationException("Roblox field-baseline key-up event is invalid.");
            }

            Console.WriteLine(
                $"Windows input compatibility smoke passed. backend={WindowsKeyboardInputSink.BackendName}; " +
                "vk=0x41; scanCode=0; downFlags=0; upFlags=KEYEVENTF_KEYUP.");
            return 0;
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"Windows input compatibility smoke failed: {exception}");
            return 7;
        }
    }
}
