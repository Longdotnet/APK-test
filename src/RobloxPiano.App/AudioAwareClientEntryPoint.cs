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

        if (args.Length == 1 && args[0].Equals("--audio-model-smoke", StringComparison.OrdinalIgnoreCase))
        {
            var noticesExitCode = ValidateThirdPartyNotices();
            if (noticesExitCode != 0)
            {
                return noticesExitCode;
            }
        }

        return ClientEntryPoint.Main(args);
    }

    private static int WriteThirdPartyNotices()
    {
        try
        {
            Console.Write(ReadThirdPartyNotices());
            return 0;
        }
        catch (Exception exception) when (exception is IOException or InvalidOperationException)
        {
            Console.Error.WriteLine($"Could not read third-party notices: {exception.Message}");
            return 12;
        }
    }

    private static int ValidateThirdPartyNotices()
    {
        try
        {
            var notices = ReadThirdPartyNotices();
            foreach (var requiredToken in new[]
            {
                "Copyright 2022 Spotify AB",
                "Apache License",
                "Copyright (c) Microsoft Corporation",
                "Copyright 2008-2026 Mark Heath"
            })
            {
                if (!notices.Contains(requiredToken, StringComparison.Ordinal))
                {
                    throw new InvalidDataException($"Third-party notices are missing required attribution '{requiredToken}'.");
                }
            }

            return 0;
        }
        catch (Exception exception) when (exception is IOException or InvalidDataException or InvalidOperationException)
        {
            Console.Error.WriteLine($"Audio distribution notice validation failed: {exception.Message}");
            return 12;
        }
    }

    private static string ReadThirdPartyNotices()
    {
        using var stream = Assembly.GetExecutingAssembly().GetManifestResourceStream(NoticesResourceName)
            ?? throw new InvalidOperationException($"Embedded notice resource '{NoticesResourceName}' is missing.");
        using var reader = new StreamReader(stream);
        return reader.ReadToEnd();
    }
}
