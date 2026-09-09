using System.Net;
using System.Text.Json;
using RobloxPiano.Updater;

namespace RobloxPiano.App;

internal sealed class ClientUpdateController : IDisposable
{
    private readonly CancellationTokenSource _lifetime = new();
    private readonly HttpClient _httpClient;
    private readonly GitHubReleaseClient _releaseClient;
    private readonly UpdatePackageStager _stager;
    private readonly FlowLayoutPanel _view = new()
    {
        AutoSize = true,
        Dock = DockStyle.Fill,
        FlowDirection = FlowDirection.LeftToRight,
        WrapContents = false,
        Visible = false,
        Padding = new Padding(0, 3, 0, 3)
    };
    private readonly Label _message = new()
    {
        AutoSize = true,
        Padding = new Padding(0, 7, 8, 0)
    };
    private readonly Button _updateButton = new()
    {
        AutoSize = true,
        Text = "Update & Restart"
    };
    private readonly Button _laterButton = new()
    {
        AutoSize = true,
        Text = "Later"
    };

    private UpdateRelease? _availableRelease;
    private string? _installedExecutable;
    private bool _checking;
    private bool _installing;
    private bool _disposed;

    public ClientUpdateController()
    {
        var handler = new SocketsHttpHandler
        {
            AllowAutoRedirect = false,
            AutomaticDecompression = DecompressionMethods.All,
            ConnectTimeout = TimeSpan.FromSeconds(5)
        };
        _httpClient = new HttpClient(handler)
        {
            Timeout = TimeSpan.FromSeconds(15)
        };
        _releaseClient = new GitHubReleaseClient(_httpClient);
        _stager = new UpdatePackageStager(new TrustedGitHubAssetDownloader(_httpClient));

        _view.Controls.AddRange([_message, _updateButton, _laterButton]);
        _updateButton.Click += HandleUpdateClick;
        _laterButton.Click += (_, _) => _view.Visible = false;
    }

    public Control View => _view;

    public async Task CheckAsync(Form owner)
    {
        ArgumentNullException.ThrowIfNull(owner);
        if (_disposed || _checking || _installing)
        {
            return;
        }

        SelfUpdateBootstrap.CleanupOldStagingBestEffort();
        if (!SelfUpdateBootstrap.TryGetInstalledExecutable(out var installedExecutable))
        {
            ClientDiagnostics.Log("Self-update check skipped because this process is not the installed RobloxPiano.exe client.");
            return;
        }

        _checking = true;
        _installedExecutable = installedExecutable;
        try
        {
            var release = await _releaseClient.FindUpdateAsync(
                SelfUpdateBootstrap.CurrentVersion,
                _lifetime.Token);
            if (_disposed || owner.IsDisposed)
            {
                return;
            }

            _availableRelease = release;
            if (release is null)
            {
                _view.Visible = false;
                return;
            }

            _message.Text = $"Update {release.Tag} is available. It will be SHA-256 verified before install.";
            _updateButton.Text = "Update & Restart";
            _updateButton.Enabled = true;
            _laterButton.Enabled = true;
            _view.Visible = true;
            ClientDiagnostics.Log(
                $"Self-update available: current={SelfUpdateBootstrap.CurrentVersion}, latest={release.Version}, target={release.TargetCommit}.");
        }
        catch (OperationCanceledException) when (_lifetime.IsCancellationRequested)
        {
        }
        catch (Exception exception) when (IsNonFatalUpdateException(exception))
        {
            ClientDiagnostics.Log($"Self-update check failed without affecting client operation: {exception}");
            _view.Visible = false;
        }
        finally
        {
            _checking = false;
        }
    }

    private async void HandleUpdateClick(object? sender, EventArgs eventArgs)
    {
        if (_disposed
            || _installing
            || _availableRelease is null
            || string.IsNullOrWhiteSpace(_installedExecutable))
        {
            return;
        }

        _installing = true;
        _updateButton.Enabled = false;
        _laterButton.Enabled = false;
        _message.Text = $"Downloading and verifying {_availableRelease.Tag}...";
        try
        {
            var staged = await _stager.StageAsync(
                _availableRelease,
                SelfUpdateBootstrap.UpdateRoot,
                _lifetime.Token);
            if (_disposed)
            {
                return;
            }

            _message.Text = $"{_availableRelease.Tag} verified. Restarting...";
            ClientDiagnostics.Log(
                $"Self-update package verified: version={_availableRelease.Version}, sha256={staged.Sha256}, staged='{staged.ExecutablePath}'.");
            if (!SelfUpdateBootstrap.LaunchStagedUpdater(staged, _installedExecutable))
            {
                throw new InvalidOperationException("Verified update could not be launched for atomic replacement.");
            }

            Application.Exit();
        }
        catch (OperationCanceledException) when (_lifetime.IsCancellationRequested)
        {
        }
        catch (Exception exception) when (IsNonFatalUpdateException(exception))
        {
            ClientDiagnostics.Log($"Self-update install failed; current executable remains active: {exception}");
            if (!_disposed)
            {
                _message.Text = "Update failed; your current version is unchanged.";
                _updateButton.Text = "Retry Update";
                _updateButton.Enabled = true;
                _laterButton.Enabled = true;
                _view.Visible = true;
            }
        }
        finally
        {
            _installing = false;
        }
    }

    private static bool IsNonFatalUpdateException(Exception exception)
        => exception is HttpRequestException
            or IOException
            or UnauthorizedAccessException
            or JsonException
            or FormatException
            or InvalidOperationException
            or ArgumentException
            or TimeoutException
            or OperationCanceledException;

    public void Dispose()
    {
        if (_disposed)
        {
            return;
        }
        _disposed = true;
        _lifetime.Cancel();
        _updateButton.Click -= HandleUpdateClick;
        _lifetime.Dispose();
        _httpClient.Dispose();
    }
}
