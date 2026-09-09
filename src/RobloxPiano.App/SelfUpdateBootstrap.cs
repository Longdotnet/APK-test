using System.Diagnostics;
using System.Runtime.CompilerServices;
using RobloxPiano.Updater;

namespace RobloxPiano.App;

internal static class SelfUpdateBootstrap
{
    private const string ApplyCommand = "--apply-update";
    private const string ExecutableName = "RobloxPiano.exe";
    private const string CiNoRestartArgument = "--ci-no-restart";
    private const string CiUpdateTestVariable = "ROBLOXPIANO_UPDATE_TEST";

    [ModuleInitializer]
    internal static void Initialize()
    {
        var commandLine = Environment.GetCommandLineArgs();
        if (commandLine.Length < 2 || !commandLine[1].Equals(ApplyCommand, StringComparison.OrdinalIgnoreCase))
        {
            return;
        }

        ClientConsoleWindow.Hide();
        try
        {
            var exitCode = RunApplyCommandAsync(commandLine[2..]).GetAwaiter().GetResult();
            Environment.Exit(exitCode);
        }
        catch (Exception exception)
        {
            ClientDiagnostics.Log($"Self-update bootstrap failed: {exception}");
            if (!IsCiUpdateSmoke())
            {
                try
                {
                    MessageBox.Show(
                        "The update could not be installed. Your current Roblox Piano executable was left unchanged.\n\n" + exception.Message,
                        "Roblox Piano update",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Warning);
                }
                catch
                {
                }
            }
            Environment.Exit(71);
        }
    }

    public static ReleaseVersion CurrentVersion
    {
        get
        {
            var version = typeof(SelfUpdateBootstrap).Assembly.GetName().Version
                ?? throw new InvalidOperationException("Application version metadata is missing.");
            if (version.Major < 0 || version.Minor < 0 || version.Build < 0)
            {
                throw new InvalidOperationException("Application version metadata is invalid.");
            }
            return new ReleaseVersion(version.Major, version.Minor, version.Build);
        }
    }

    public static string UpdateRoot => Path.Combine(
        Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
        "RobloxPiano",
        "updates");

    public static bool TryGetInstalledExecutable(out string executablePath)
    {
        executablePath = string.Empty;
        var processPath = Environment.ProcessPath;
        if (string.IsNullOrWhiteSpace(processPath))
        {
            return false;
        }

        var fullPath = Path.GetFullPath(processPath);
        if (!Path.GetFileName(fullPath).Equals(ExecutableName, StringComparison.OrdinalIgnoreCase)
            || !File.Exists(fullPath)
            || IsPathUnderRoot(fullPath, UpdateRoot))
        {
            return false;
        }

        executablePath = fullPath;
        return true;
    }

    public static bool LaunchStagedUpdater(StagedUpdate stagedUpdate, string installedExecutable)
    {
        ArgumentNullException.ThrowIfNull(stagedUpdate);
        ArgumentException.ThrowIfNullOrWhiteSpace(installedExecutable);

        var stagedPath = Path.GetFullPath(stagedUpdate.ExecutablePath);
        var targetPath = Path.GetFullPath(installedExecutable);
        if (!File.Exists(stagedPath)
            || !Path.GetFileName(stagedPath).Equals(ExecutableName, StringComparison.OrdinalIgnoreCase)
            || !Path.GetFileName(targetPath).Equals(ExecutableName, StringComparison.OrdinalIgnoreCase)
            || !IsPathUnderRoot(stagedPath, UpdateRoot)
            || IsPathUnderRoot(targetPath, UpdateRoot)
            || !UpdateHash.IsSha256(stagedUpdate.Sha256))
        {
            return false;
        }

        var start = new ProcessStartInfo
        {
            FileName = stagedPath,
            UseShellExecute = false,
            CreateNoWindow = true
        };
        start.ArgumentList.Add(ApplyCommand);
        start.ArgumentList.Add("--target");
        start.ArgumentList.Add(targetPath);
        start.ArgumentList.Add("--parent-pid");
        start.ArgumentList.Add(Environment.ProcessId.ToString(System.Globalization.CultureInfo.InvariantCulture));
        start.ArgumentList.Add("--expected-sha256");
        start.ArgumentList.Add(stagedUpdate.Sha256);

        return Process.Start(start) is not null;
    }

    public static void CleanupOldStagingBestEffort()
    {
        try
        {
            if (!Directory.Exists(UpdateRoot))
            {
                return;
            }

            foreach (var directory in Directory.EnumerateDirectories(UpdateRoot))
            {
                try
                {
                    var lastWrite = Directory.GetLastWriteTimeUtc(directory);
                    if (DateTime.UtcNow - lastWrite > TimeSpan.FromHours(12))
                    {
                        Directory.Delete(directory, recursive: true);
                    }
                }
                catch
                {
                }
            }
        }
        catch
        {
        }
    }

    private static async Task<int> RunApplyCommandAsync(string[] args)
    {
        if (!TryParseApplyArguments(
                args,
                out var targetPath,
                out var parentProcessId,
                out var expectedSha256,
                out var suppressRestart,
                out var error))
        {
            throw new ArgumentException(error ?? "Invalid self-update command.");
        }

        if (suppressRestart && !IsCiUpdateSmoke())
        {
            throw new InvalidOperationException("The no-restart updater mode is reserved for the production CI smoke test.");
        }

        var stagedPath = Environment.ProcessPath;
        if (string.IsNullOrWhiteSpace(stagedPath))
        {
            throw new InvalidOperationException("Updater process path is unavailable.");
        }

        stagedPath = Path.GetFullPath(stagedPath);
        targetPath = Path.GetFullPath(targetPath);
        if (!Path.GetFileName(stagedPath).Equals(ExecutableName, StringComparison.OrdinalIgnoreCase)
            || !Path.GetFileName(targetPath).Equals(ExecutableName, StringComparison.OrdinalIgnoreCase)
            || !IsPathUnderRoot(stagedPath, UpdateRoot)
            || IsPathUnderRoot(targetPath, UpdateRoot))
        {
            throw new InvalidOperationException("Self-update paths do not match the Roblox Piano update contract.");
        }

        var stagedHash = await UpdateHash.ComputeFileAsync(stagedPath).ConfigureAwait(false);
        if (!stagedHash.Equals(expectedSha256, StringComparison.OrdinalIgnoreCase))
        {
            throw new FormatException("Updater executable failed SHA-256 verification before replacement.");
        }

        ClientDiagnostics.Log(
            $"Self-update apply starting: parent={parentProcessId}, staged='{stagedPath}', target='{targetPath}', sha256={expectedSha256}.");
        await AtomicUpdateApplier.WaitForProcessExitAsync(parentProcessId, TimeSpan.FromSeconds(90)).ConfigureAwait(false);
        await AtomicUpdateApplier.ReplaceVerifiedFileAsync(stagedPath, targetPath, expectedSha256).ConfigureAwait(false);

        if (suppressRestart)
        {
            ClientDiagnostics.Log("Self-update replacement verified in CI smoke mode; restart intentionally suppressed.");
            return 0;
        }

        ClientDiagnostics.Log("Self-update replacement verified; restarting installed client.");
        var restart = new ProcessStartInfo
        {
            FileName = targetPath,
            Arguments = "--ui",
            UseShellExecute = true
        };
        if (Process.Start(restart) is null)
        {
            throw new InvalidOperationException("Updated executable was installed but could not be restarted automatically.");
        }

        return 0;
    }

    private static bool TryParseApplyArguments(
        string[] args,
        out string targetPath,
        out int parentProcessId,
        out string expectedSha256,
        out bool suppressRestart,
        out string? error)
    {
        targetPath = string.Empty;
        parentProcessId = 0;
        expectedSha256 = string.Empty;
        suppressRestart = false;
        error = null;

        for (var index = 0; index < args.Length; index++)
        {
            if (args[index].Equals("--target", StringComparison.OrdinalIgnoreCase))
            {
                if (!TryReadValue(args, ref index, out targetPath))
                {
                    error = "--target requires an executable path.";
                    return false;
                }
            }
            else if (args[index].Equals("--parent-pid", StringComparison.OrdinalIgnoreCase))
            {
                if (!TryReadValue(args, ref index, out var value)
                    || !int.TryParse(value, System.Globalization.NumberStyles.None, System.Globalization.CultureInfo.InvariantCulture, out parentProcessId)
                    || parentProcessId <= 0
                    || parentProcessId == Environment.ProcessId)
                {
                    error = "--parent-pid requires the positive process ID of the client being replaced.";
                    return false;
                }
            }
            else if (args[index].Equals("--expected-sha256", StringComparison.OrdinalIgnoreCase))
            {
                if (!TryReadValue(args, ref index, out expectedSha256) || !UpdateHash.IsSha256(expectedSha256))
                {
                    error = "--expected-sha256 requires a 64-character SHA-256 value.";
                    return false;
                }
                expectedSha256 = expectedSha256.ToLowerInvariant();
            }
            else if (args[index].Equals(CiNoRestartArgument, StringComparison.OrdinalIgnoreCase))
            {
                suppressRestart = true;
            }
            else
            {
                error = $"Unknown self-update argument '{args[index]}'.";
                return false;
            }
        }

        if (string.IsNullOrWhiteSpace(targetPath) || parentProcessId <= 0 || !UpdateHash.IsSha256(expectedSha256))
        {
            error = "Self-update requires --target, --parent-pid and --expected-sha256.";
            return false;
        }
        return true;
    }

    private static bool TryReadValue(string[] args, ref int index, out string value)
    {
        value = string.Empty;
        if (index + 1 >= args.Length || string.IsNullOrWhiteSpace(args[index + 1]))
        {
            return false;
        }
        index++;
        value = args[index];
        return true;
    }

    private static bool IsCiUpdateSmoke()
        => Environment.GetEnvironmentVariable(CiUpdateTestVariable).Equals("1", StringComparison.Ordinal);

    private static bool IsPathUnderRoot(string path, string root)
    {
        var fullPath = Path.GetFullPath(path);
        var fullRoot = Path.GetFullPath(root);
        var relative = Path.GetRelativePath(fullRoot, fullPath);
        return !relative.Equals("..", StringComparison.Ordinal)
               && !relative.StartsWith(".." + Path.DirectorySeparatorChar, StringComparison.Ordinal)
               && !Path.IsPathRooted(relative);
    }
}
