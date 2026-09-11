using System.Reflection;

namespace RobloxPiano.App;

/// <summary>
/// Thin production entrypoint for distribution-level concerns that must apply before the existing
/// client/CLI router. Runtime input ownership remains in <see cref="ClientEntryPoint"/>.
/// </summary>
internal static class AudioAwareClientEntryPoint
{
    private const string NoticesResourceName = "RobloxPiano.App.THIRD-PARTY-NOTICES.txt";

    [STAThread]
    public static int Main(string[] args)
    {
        if (args.Length == 1 && args[0].Equals("--third-party-notices", StringComparison.OrdinalIgnoreCase))
        {
            return WriteThirdPartyNotices();
        }

        return ClientEntryPoint.Main(args);
    }

    private static int WriteThirdPartyNotices()
    {
        try
        {
            using var stream = Assembly.GetExecutingAssembly().GetManifestResourceStream(NoticesResourceName)
                ?? throw new InvalidOperationException($"Embedded notice resource '{NoticesResourceName}' is missing.");
            using var reader = new StreamReader(stream);
            Console.Write(reader.ReadToEnd());
            return 0;
        }
        catch (Exception exception) when (exception is IOException or InvalidOperationException)
        {
            Console.Error.WriteLine($"Could not read third-party notices: {exception.Message}");
            return 12;
        }
    }
}
