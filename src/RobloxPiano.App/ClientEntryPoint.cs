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

            const ushort virtualKeyA = 0x41;
            var down = WindowsKeyboardInputSink.BuildVirtualKeyInput(virtualKeyA, keyUp: false);
            var up = WindowsKeyboardInputSink.BuildVirtualKeyInput(virtualKeyA, keyUp: true);

            if (down.Type != NativeMethods.InputKeyboard
                || down.Union.Keyboard.VirtualKey != virtualKeyA
                || down.Union.Keyboard.ScanCode != 0
                || down.Union.Keyboard.Flags != 0)
            {
                throw new InvalidOperationException("Roblox compatibility key-down packet is not virtual-key based.");
            }

            if (up.Type != NativeMethods.InputKeyboard
                || up.Union.Keyboard.VirtualKey != virtualKeyA
                || up.Union.Keyboard.ScanCode != 0
                || up.Union.Keyboard.Flags != NativeMethods.KeyEventKeyUp)
            {
                throw new InvalidOperationException("Roblox compatibility key-up packet is not virtual-key based.");
            }

            Console.WriteLine(
                $"Windows INPUT compatibility smoke passed. actual={NativeMethods.InputStructureSize}; " +
                $"expected={NativeMethods.ExpectedInputStructureSize}; pointerSize={IntPtr.Size}; " +
                "mode=virtual-key; scanCode=0.");
            return 0;
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"Windows INPUT compatibility smoke failed: {exception}");
            return 7;
        }
    }
}
