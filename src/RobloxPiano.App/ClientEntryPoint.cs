namespace RobloxPiano.App;

/// <summary>
/// Synchronous Windows entrypoint that guarantees the UI starts on an STA thread before any
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
            using var form = new SheetLibraryForm();
            Console.WriteLine($"UI startup smoke passed. DragDrop={form.AllowDrop}; apartment={Thread.CurrentThread.GetApartmentState()}.");
            return 0;
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"UI startup smoke failed: {exception}");
            return 6;
        }
    }
}
