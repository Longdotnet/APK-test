namespace RobloxPiano.App;

/// <summary>
/// Synchronous Windows entrypoint that guarantees the UI starts on an STA thread before any
/// async command-line path can participate. WinForms OLE drag/drop registration depends on STA.
/// </summary>
internal static class ClientEntryPoint
{
    [STAThread]
    public static int Main(string[] args)
        => Program.Main(args).GetAwaiter().GetResult();
}
