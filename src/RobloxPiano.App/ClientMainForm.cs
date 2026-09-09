using System.Diagnostics;
using System.Globalization;
using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed class ClientMainForm : Form
{
    private const int HotkeyF6 = 1006;
    private const int HotkeyF7 = 1007;
    private const int HotkeyF8 = 1008;
    private const int HotkeyF9 = 1009;
    private const uint VirtualKeyF6 = 0x75;
    private const uint VirtualKeyF7 = 0x76;
    private const uint VirtualKeyF8 = 0x77;
    private const uint VirtualKeyF9 = 0x78;
    private const int PositionScale = 1000;

    private readonly bool _autoStart;
    private readonly Label _songTitle = CreateStatusLabel("No song selected.");
    private readonly Label _songInfo = CreateStatusLabel(string.Empty);
    private readonly Label _robloxInfo = CreateStatusLabel("Searching for Roblox...");
    private readonly Label _playbackInfo = CreateStatusLabel("Ready.");
    private readonly Label _speedInfo = CreateStatusLabel("1.00x");
    private readonly Label _positionInfo = CreateStatusLabel("00:00 / 00:00");
    private readonly Label _hotkeyInfo = CreateStatusLabel("Hotkeys: registering...");
    private readonly Label _pathInfo = CreateStatusLabel(string.Empty);
    private readonly Button _playButton = new()
    {
        Text = "Play",
        AutoSize = true,
        Font = new Font(SystemFonts.DefaultFont.FontFamily, 12f, FontStyle.Bold),
        Padding = new Padding(18, 7, 18, 7)
    };
    private readonly Button _pauseButton = new() { Text = "Pause", AutoSize = true, Enabled = false, Padding = new Padding(8, 4, 8, 4) };
    private readonly Button _stopButton = new() { Text = "Stop", AutoSize = true, Enabled = false, Padding = new Padding(8, 4, 8, 4) };
    private readonly Button _backButton = new() { Text = "-10s", AutoSize = true, Enabled = false };
    private readonly Button _forwardButton = new() { Text = "+10s", AutoSize = true, Enabled = false };
    private readonly Button _advancedButton = new() { Text = "Advanced ▾", AutoSize = true };
    private readonly Button _browseButton = new() { Text = "Choose another song...", AutoSize = true };
    private readonly Button _slowerButton = new() { Text = "Slower (F6)", AutoSize = true };
    private readonly Button _fasterButton = new() { Text = "Faster (F7)", AutoSize = true };
    private readonly Button _logsButton = new() { Text = "Open Diagnostics", AutoSize = true };
    private readonly NumericUpDown _latencyMs = new()
    {
        Minimum = 0,
        Maximum = (decimal)PlaybackTimingProfile.MaximumDispatchLead.TotalMilliseconds,
        Increment = 5,
        DecimalPlaces = 0,
        Width = 80
    };
    private readonly TrackBar _positionBar = new()
    {
        Dock = DockStyle.Fill,
        Minimum = 0,
        Maximum = PositionScale,
        TickStyle = TickStyle.None,
        Enabled = false
    };
    private readonly TableLayoutPanel _advancedPanel = new()
    {
        Dock = DockStyle.Fill,
        ColumnCount = 1,
        AutoSize = true,
        Visible = false
    };
    private readonly System.Windows.Forms.Timer _robloxTimer = new() { Interval = 1000 };
    private readonly System.Windows.Forms.Timer _positionTimer = new() { Interval = 100 };

    private string? _selectedSongPath;
    private double _preferredSpeed = 1d;
    private TimeSpan _loadedDuration;
    private PlaybackSessionClock? _sessionClock;
    private PlaybackTransportSession? _transportSession;
    private CancellationTokenSource? _playbackCancellation;
    private Task? _playbackTask;
    private RobloxWindowTarget? _activeTarget;
    private bool _positionDragging;
    private bool _allowClose;
    private bool _autoStartAttempted;
    private RobloxPlaybackAuthorizationFailure? _authorizationRecoveryFailure;

    public ClientMainForm(bool autoStart = false)
    {
        _autoStart = autoStart;
        Text = "Roblox Piano";
        StartPosition = FormStartPosition.CenterScreen;
        MinimumSize = new Size(700, 430);
        Size = new Size(820, 540);
        AllowDrop = true;

        BuildLayout();
        LoadClientState();
        RefreshRobloxStatus();

        _playButton.Click += async (_, _) => await StartPlaybackAsync().ConfigureAwait(true);
        _pauseButton.Click += (_, _) => TogglePause();
        _stopButton.Click += (_, _) => StopPlayback();
        _backButton.Click += (_, _) => SeekRelative(TimeSpan.FromSeconds(-10));
        _forwardButton.Click += (_, _) => SeekRelative(TimeSpan.FromSeconds(10));
        _advancedButton.Click += (_, _) => ToggleAdvanced();
        _browseButton.Click += (_, _) => BrowseSong();
        _slowerButton.Click += (_, _) => AdjustSpeed(-0.10d);
        _fasterButton.Click += (_, _) => AdjustSpeed(0.10d);
        _logsButton.Click += (_, _) => OpenDiagnosticsDirectory();
        _latencyMs.ValueChanged += (_, _) =>
        {
            SaveClientState();
            if (_playbackTask is null || _playbackTask.IsCompleted)
            {
                _playbackInfo.Text = "Advanced timing preference saved for the next playback.";
            }
        };
        _positionBar.MouseDown += (_, _) => _positionDragging = true;
        _positionBar.MouseUp += (_, _) => CommitPositionBarSeek();
        _robloxTimer.Tick += (_, _) => RefreshRobloxStatus();
        _positionTimer.Tick += (_, _) => RefreshPlaybackPosition();
        _robloxTimer.Start();
        _positionTimer.Start();

        DragEnter += HandleDragEnter;
        DragDrop += HandleDragDrop;
        FormClosing += HandleFormClosingAsync;
        Shown += HandleShownAsync;
    }

    protected override void OnHandleCreated(EventArgs e)
    {
        base.OnHandleCreated(e);
        RegisterGlobalHotkeys();
    }

    protected override void OnHandleDestroyed(EventArgs e)
    {
        UnregisterGlobalHotkeys();
        base.OnHandleDestroyed(e);
    }

    protected override void WndProc(ref Message message)
    {
        if (message.Msg == ClientNativeMethods.WmHotkey)
        {
            switch (message.WParam.ToInt32())
            {
                case HotkeyF6:
                    AdjustSpeed(-0.10d);
                    return;
                case HotkeyF7:
                    AdjustSpeed(0.10d);
                    return;
                case HotkeyF8:
                    TogglePause();
                    return;
                case HotkeyF9:
                    StopPlayback();
                    return;
            }
        }

        base.WndProc(ref message);
    }

    private void BuildLayout()
    {
        var root = new TableLayoutPanel
        {
            Dock = DockStyle.Fill,
            Padding = new Padding(20),
            ColumnCount = 1,
            AutoScroll = true,
            AutoSize = true
        };
        root.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100f));

        var title = new Label
        {
            Text = "Roblox Piano",
            AutoSize = true,
            Font = new Font(Font.FontFamily, 20f, FontStyle.Bold),
            Margin = new Padding(0, 0, 0, 4)
        };
        var subtitle = new Label
        {
            Text = "Your song is ready. Roblox detection, file handling, timing safety and diagnostics run automatically.",
            AutoSize = true,
            MaximumSize = new Size(760, 0),
            Margin = new Padding(0, 0, 0, 12)
        };

        var songPanel = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 1, RowCount = 2, AutoSize = true };
        songPanel.Controls.Add(_songTitle, 0, 0);
        songPanel.Controls.Add(_songInfo, 0, 1);

        var primaryControls = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true, WrapContents = true };
        primaryControls.Controls.AddRange([_playButton, _pauseButton, _stopButton, _backButton, _forwardButton]);

        var seekPanel = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 1, RowCount = 2, AutoSize = true };
        seekPanel.Controls.Add(_positionBar, 0, 0);
        seekPanel.Controls.Add(_positionInfo, 0, 1);

        var playbackPanel = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 1, RowCount = 3, AutoSize = true };
        playbackPanel.Controls.Add(primaryControls, 0, 0);
        playbackPanel.Controls.Add(seekPanel, 0, 1);
        playbackPanel.Controls.Add(_playbackInfo, 0, 2);

        var speedRow = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        speedRow.Controls.Add(new Label { Text = "Speed:", AutoSize = true, Padding = new Padding(0, 4, 0, 0) });
        speedRow.Controls.Add(_speedInfo);
        speedRow.Controls.Add(_slowerButton);
        speedRow.Controls.Add(_fasterButton);

        var latencyRow = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        latencyRow.Controls.Add(new Label { Text = "Input timing override:", AutoSize = true, Padding = new Padding(0, 4, 0, 0) });
        latencyRow.Controls.Add(_latencyMs);
        latencyRow.Controls.Add(new Label { Text = "ms (0 = default)", AutoSize = true, Padding = new Padding(0, 4, 0, 0) });

        var advancedButtons = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        advancedButtons.Controls.AddRange([_browseButton, _logsButton]);
        _advancedPanel.Controls.Add(speedRow);
        _advancedPanel.Controls.Add(latencyRow);
        _advancedPanel.Controls.Add(advancedButtons);
        _advancedPanel.Controls.Add(_pathInfo);
        _advancedPanel.Controls.Add(_hotkeyInfo);

        var safety = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(760, 0),
            Text = "Playback automatically pauses and releases held input whenever Roblox loses focus, playback stops, or an input error occurs."
        };

        root.Controls.Add(title);
        root.Controls.Add(subtitle);
        root.Controls.Add(CreateGroup("Roblox", _robloxInfo));
        root.Controls.Add(CreateGroup("Song", songPanel));
        root.Controls.Add(CreateGroup("Playback", playbackPanel));
        root.Controls.Add(_advancedButton);
        root.Controls.Add(_advancedPanel);
        root.Controls.Add(safety);
        Controls.Add(root);
    }

    private static GroupBox CreateGroup(string title, Control content)
    {
        var group = new GroupBox
        {
            Text = title,
            Dock = DockStyle.Fill,
            AutoSize = true,
            Padding = new Padding(12),
            Margin = new Padding(0, 4, 0, 8)
        };
        content.Dock = DockStyle.Fill;
        group.Controls.Add(content);
        return group;
    }

    private static Label CreateStatusLabel(string text) => new()
    {
        Text = text,
        AutoSize = true,
        Padding = new Padding(0, 4, 0, 4),
        MaximumSize = new Size(760, 0)
    };

    private async void HandleShownAsync(object? sender, EventArgs eventArgs)
    {
        if (!_autoStart || _autoStartAttempted)
        {
            return;
        }

        _autoStartAttempted = true;
        await StartPlaybackAsync().ConfigureAwait(true);
    }

    private void ToggleAdvanced()
    {
        _advancedPanel.Visible = !_advancedPanel.Visible;
        _advancedButton.Text = _advancedPanel.Visible ? "Advanced ▴" : "Advanced ▾";
    }

    private void LoadClientState()
    {
        var state = ClientStateStore.Load();
        _preferredSpeed = state.PreferredSpeed;
        _latencyMs.Value = Math.Clamp(state.InputLatencyMs, (int)_latencyMs.Minimum, (int)_latencyMs.Maximum);
        UpdateSpeedLabel();

        if (!string.IsNullOrWhiteSpace(state.LastSheetPath) && File.Exists(state.LastSheetPath))
        {
            TrySelectSong(state.LastSheetPath, showDialogOnError: false);
        }
    }

    private void SaveClientState()
    {
        ClientStateStore.Save(new ClientState(_selectedSongPath, _preferredSpeed, (int)_latencyMs.Value));
    }

    private void BrowseSong()
    {
        using var dialog = new OpenFileDialog
        {
            Title = "Choose song",
            Filter = "Supported songs (*.txt;*.vps;*.mid;*.midi)|*.txt;*.vps;*.mid;*.midi|All files (*.*)|*.*",
            CheckFileExists = true,
            Multiselect = false
        };

        if (!string.IsNullOrWhiteSpace(_selectedSongPath))
        {
            dialog.InitialDirectory = Path.GetDirectoryName(_selectedSongPath);
            dialog.FileName = Path.GetFileName(_selectedSongPath);
        }

        if (dialog.ShowDialog(this) == DialogResult.OK)
        {
            TrySelectSong(dialog.FileName, showDialogOnError: true);
        }
    }

    private bool TrySelectSong(string path, bool showDialogOnError)
    {
        try
        {
            var fullPath = Path.GetFullPath(path);
            var loaded = SongSourceLoader.Load(fullPath);
            var track = loaded.Track;
            _selectedSongPath = fullPath;
            _loadedDuration = track.TimelineDuration;
            _songTitle.Text = track.Title;
            _songInfo.Text = $"{track.Events.Count} notes/events • " +
                             $"{track.Bpm.ToString("0.###", CultureInfo.InvariantCulture)} BPM • " +
                             FormatTime(track.TimelineDuration);
            _pathInfo.Text = fullPath;
            _positionBar.Value = 0;
            _positionBar.Enabled = true;
            _backButton.Enabled = true;
            _forwardButton.Enabled = true;
            UpdatePositionLabel(TimeSpan.Zero);
            _playbackInfo.Text = "Ready to play.";
            SaveClientState();
            RefreshRobloxStatus();
            return true;
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or FormatException
            or ArgumentException
            or OverflowException)
        {
            ClientDiagnostics.Log($"Song selection failed for '{path}': {exception}");
            _playbackInfo.Text = $"This song could not be loaded: {exception.Message}";
            if (showDialogOnError)
            {
                MessageBox.Show(this, exception.Message, "Song could not be loaded", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }

            return false;
        }
    }

    private async Task StartPlaybackAsync()
    {
        if (_playbackTask is not null && !_playbackTask.IsCompleted)
        {
            return;
        }

        _authorizationRecoveryFailure = null;

        if (string.IsNullOrWhiteSpace(_selectedSongPath)
            || !TrySelectSongPreservingPosition(_selectedSongPath))
        {
            _playbackInfo.Text = "Choose a playable song first.";
            return;
        }

        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _robloxInfo.Text = "○ Roblox not detected — open Roblox and enter the piano game.";
            _playbackInfo.Text = "Play becomes available automatically when Roblox is ready.";
            UpdatePrimaryAction();
            return;
        }

        PerformanceTrack track;
        try
        {
            track = (await SongSourceLoader.LoadAsync(_selectedSongPath).ConfigureAwait(true)).Track;
        }
        catch (Exception exception) when (
            exception is IOException or UnauthorizedAccessException or FormatException or ArgumentException or OverflowException)
        {
            _playbackInfo.Text = $"This song could not be loaded: {exception.Message}";
            ClientDiagnostics.Log($"Playback source load failed: {exception}");
            return;
        }

        var initialPosition = PositionFromBar(track.TimelineDuration);
        var timingProfile = PlaybackTimingProfile.FromMilliseconds(_latencyMs.Value);
        _activeTarget = target;
        _playbackCancellation = new CancellationTokenSource();
        var cancellation = _playbackCancellation;
        var wallClock = new StopwatchClock();
        _sessionClock = new PlaybackSessionClock(wallClock, _preferredSpeed);
        var sessionClock = _sessionClock;
        var input = new WindowsKeyboardInputSink();
        var focus = new PlaybackSessionFocusGate(new RobloxTargetFocusGate(target), sessionClock);
        _transportSession = new PlaybackTransportSession(track, sessionClock, input, focus, timingProfile);
        var transport = _transportSession;

        SetPlaybackActive(true);
        var activated = target.TryActivate();
        _robloxInfo.Text = "● Roblox connected";
        _playbackInfo.Text = activated
            ? $"Starting {track.Title}..."
            : "Roblox is ready. Playback waits safely until its window has focus.";

        ClientDiagnostics.Log(
            $"Playback start: song='{_selectedSongPath}', title='{track.Title}', targetPid={target.ProcessId}, " +
            $"speed={sessionClock.Speed:0.00}x, position={initialPosition.TotalSeconds:0.###}s, " +
            $"dispatchLeadMs={timingProfile.DispatchLead.TotalMilliseconds:0}, activation={activated}.");

        var task = RunPlaybackSessionAsync(track, transport, initialPosition, cancellation.Token);
        _playbackTask = task;
        var returnToLibraryForAuthorization = false;

        try
        {
            await task.ConfigureAwait(true);
            SetPositionBar(track.TimelineDuration);
            _playbackInfo.Text = "Playback complete.";
            ClientDiagnostics.Log($"Playback completed: title='{track.Title}'.");
        }
        catch (OperationCanceledException)
        {
            _playbackInfo.Text = "Playback stopped safely.";
            ClientDiagnostics.Log($"Playback cancelled: title='{track.Title}', position={transport.Position.TotalSeconds:0.###}s.");
        }
        catch (RobloxPlaybackAuthorizationException exception)
        {
            _authorizationRecoveryFailure = exception.Failure;
            var recovery = RobloxPlaybackAuthorizationRecoveryPolicy.Describe(exception.Failure);
            _playbackInfo.Text = recovery.PlayerStatusText;
            ClientDiagnostics.Log(
                $"Playback authorization recovery requested: failure={exception.Failure}, targetPid={target.ProcessId}, " +
                $"position={transport.Position.TotalSeconds:0.###}s, detail='{exception.Message}'.");
            MessageBox.Show(
                this,
                recovery.DialogMessage,
                recovery.DialogTitle,
                MessageBoxButtons.OK,
                MessageBoxIcon.Warning);
            returnToLibraryForAuthorization = true;
        }
        catch (Exception exception) when (
            exception is IOException or UnauthorizedAccessException or InvalidOperationException or ArgumentException or OverflowException)
        {
            _playbackInfo.Text = "Playback had a problem. Diagnostics were saved automatically.";
            ClientDiagnostics.Log($"Playback failed: {exception}");
            MessageBox.Show(
                this,
                "Playback stopped safely. Try Play again. Technical details were saved automatically in Diagnostics.",
                "Playback stopped",
                MessageBoxButtons.OK,
                MessageBoxIcon.Warning);
        }
        finally
        {
            if (ReferenceEquals(_playbackCancellation, cancellation))
            {
                _playbackCancellation.Dispose();
                _playbackCancellation = null;
            }

            transport.Dispose();
            _transportSession = null;
            _sessionClock = null;
            _activeTarget = null;
            _playbackTask = null;
            SetPlaybackActive(false);
            RefreshRobloxStatus();

            if (returnToLibraryForAuthorization && !IsDisposed)
            {
                ClientDiagnostics.Log(
                    $"Returning player to Sheet Library after runtime authorization failure={_authorizationRecoveryFailure}.");
                _allowClose = true;
                Close();
            }
        }
    }

    private bool TrySelectSongPreservingPosition(string path)
    {
        var oldValue = _positionBar.Value;
        if (!TrySelectSong(path, showDialogOnError: true))
        {
            return false;
        }

        _positionBar.Value = Math.Clamp(oldValue, _positionBar.Minimum, _positionBar.Maximum);
        UpdatePositionLabel(PositionFromBar(_loadedDuration));
        return true;
    }

    private async Task RunPlaybackSessionAsync(
        PerformanceTrack track,
        PlaybackTransportSession transport,
        TimeSpan initialPosition,
        CancellationToken cancellationToken)
    {
        if (track.StartDelay > TimeSpan.Zero)
        {
            await RunCountdownAsync(track.StartDelay, cancellationToken).ConfigureAwait(true);
        }

        cancellationToken.ThrowIfCancellationRequested();
        _playbackInfo.Text = _sessionClock?.IsUserPaused == true
            ? "Paused."
            : "Playing — playback pauses automatically if Roblox loses focus.";

        await transport.PlayAsync(initialPosition, cancellationToken).ConfigureAwait(true);
    }

    private async Task RunCountdownAsync(TimeSpan delay, CancellationToken cancellationToken)
    {
        var remaining = delay;
        while (remaining > TimeSpan.Zero)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var seconds = Math.Max(1, (int)Math.Ceiling(remaining.TotalSeconds));
            _playbackInfo.Text = $"Starting in {seconds}s...";
            var slice = remaining < TimeSpan.FromMilliseconds(250) ? remaining : TimeSpan.FromMilliseconds(250);
            await Task.Delay(slice, cancellationToken).ConfigureAwait(true);
            remaining -= slice;
        }
    }

    private void AdjustSpeed(double delta)
    {
        double speed;
        if (_sessionClock is not null)
        {
            speed = _sessionClock.AdjustSpeed(delta);
        }
        else
        {
            speed = Math.Clamp(_preferredSpeed + delta, PlaybackSessionClock.MinimumSpeed, PlaybackSessionClock.MaximumSpeed);
        }

        _preferredSpeed = Math.Round(speed, 2, MidpointRounding.AwayFromZero);
        if (_sessionClock is not null && Math.Abs(_sessionClock.Speed - _preferredSpeed) > 0.0001d)
        {
            _sessionClock.SetSpeed(_preferredSpeed);
        }

        UpdateSpeedLabel();
        SaveClientState();
        _playbackInfo.Text = _playbackTask is not null && !_playbackTask.IsCompleted
            ? $"Speed {_preferredSpeed:0.00}x."
            : "Advanced speed preference saved.";
        ClientDiagnostics.Log($"Speed changed to {_preferredSpeed:0.00}x.");
    }

    private void TogglePause()
    {
        if (_sessionClock is null || _playbackTask is null || _playbackTask.IsCompleted)
        {
            return;
        }

        var paused = _sessionClock.ToggleUserPause();
        _pauseButton.Text = paused ? "Resume" : "Pause";
        _playbackInfo.Text = paused
            ? "Paused safely."
            : "Playing — playback pauses automatically if Roblox loses focus.";
        ClientDiagnostics.Log(paused ? "User paused playback." : "User resumed playback.");
    }

    private void StopPlayback()
    {
        var cancellation = _playbackCancellation;
        if (cancellation is null || cancellation.IsCancellationRequested)
        {
            return;
        }

        _playbackInfo.Text = "Stopping safely...";
        cancellation.Cancel();
    }

    private void SeekRelative(TimeSpan delta)
    {
        if (_loadedDuration <= TimeSpan.Zero)
        {
            return;
        }

        var current = _transportSession?.Position ?? PositionFromBar(_loadedDuration);
        CommitSeek(current + delta);
    }

    private void CommitPositionBarSeek()
    {
        _positionDragging = false;
        CommitSeek(PositionFromBar(_loadedDuration));
    }

    private void CommitSeek(TimeSpan position)
    {
        if (_loadedDuration <= TimeSpan.Zero)
        {
            return;
        }

        var clamped = position < TimeSpan.Zero
            ? TimeSpan.Zero
            : position > _loadedDuration ? _loadedDuration : position;
        SetPositionBar(clamped);

        if (_transportSession is not null)
        {
            _transportSession.Seek(clamped);
            _playbackInfo.Text = $"Moving to {FormatTime(clamped)}...";
            ClientDiagnostics.Log($"Seek requested: {clamped.TotalSeconds:0.###}s.");
        }
        else
        {
            _playbackInfo.Text = $"Start at {FormatTime(clamped)}.";
        }
    }

    private void RefreshPlaybackPosition()
    {
        if (_positionDragging || _loadedDuration <= TimeSpan.Zero)
        {
            return;
        }

        if (_transportSession is not null)
        {
            SetPositionBar(_transportSession.Position);
        }
        else
        {
            UpdatePositionLabel(PositionFromBar(_loadedDuration));
        }
    }

    private void SetPositionBar(TimeSpan position)
    {
        if (_loadedDuration <= TimeSpan.Zero)
        {
            _positionBar.Value = 0;
            UpdatePositionLabel(TimeSpan.Zero);
            return;
        }

        var ratio = Math.Clamp(position.TotalMilliseconds / _loadedDuration.TotalMilliseconds, 0d, 1d);
        _positionBar.Value = Math.Clamp(
            (int)Math.Round(ratio * PositionScale, MidpointRounding.AwayFromZero),
            _positionBar.Minimum,
            _positionBar.Maximum);
        UpdatePositionLabel(position);
    }

    private TimeSpan PositionFromBar(TimeSpan duration)
    {
        if (duration <= TimeSpan.Zero)
        {
            return TimeSpan.Zero;
        }

        var ratio = _positionBar.Value / (double)PositionScale;
        return TimeSpan.FromTicks((long)Math.Round(duration.Ticks * ratio, MidpointRounding.AwayFromZero));
    }

    private void UpdatePositionLabel(TimeSpan position)
    {
        _positionInfo.Text = $"{FormatTime(position)} / {FormatTime(_loadedDuration)}";
    }

    private static string FormatTime(TimeSpan value)
        => value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");

    private void SetPlaybackActive(bool active)
    {
        _pauseButton.Enabled = active;
        _stopButton.Enabled = active;
        _pauseButton.Text = "Pause";
        _browseButton.Enabled = !active;
        _latencyMs.Enabled = !active;
        _positionBar.Enabled = _loadedDuration > TimeSpan.Zero;
        _backButton.Enabled = _loadedDuration > TimeSpan.Zero;
        _forwardButton.Enabled = _loadedDuration > TimeSpan.Zero;
        UpdatePrimaryAction();
    }

    private void UpdatePrimaryAction()
    {
        var active = _playbackTask is not null && !_playbackTask.IsCompleted;
        var robloxReady = _activeTarget?.IsAlive == true || RobloxProcessLocator.FindPreferred() is not null;
        _playButton.Enabled = !active && !string.IsNullOrWhiteSpace(_selectedSongPath) && robloxReady;
        _playButton.Text = active ? "Playing" : robloxReady ? "Play" : "Waiting for Roblox";
    }

    private void UpdateSpeedLabel()
    {
        _speedInfo.Text = $"{_preferredSpeed:0.00}x";
    }

    private void RefreshRobloxStatus()
    {
        if (_activeTarget is not null)
        {
            _robloxInfo.Text = _activeTarget.IsAlive
                ? "● Roblox connected"
                : "○ Roblox closed — playback is safety-paused.";
            UpdatePrimaryAction();
            return;
        }

        var target = RobloxProcessLocator.FindPreferred();
        _robloxInfo.Text = target is null
            ? "○ Roblox not detected — open Roblox and enter the piano game."
            : "● Roblox ready";
        UpdatePrimaryAction();
    }

    private void RegisterGlobalHotkeys()
    {
        var failures = new List<string>();
        RegisterHotkey(HotkeyF6, VirtualKeyF6, "F6", failures);
        RegisterHotkey(HotkeyF7, VirtualKeyF7, "F7", failures);
        RegisterHotkey(HotkeyF8, VirtualKeyF8, "F8", failures);
        RegisterHotkey(HotkeyF9, VirtualKeyF9, "F9", failures);
        _hotkeyInfo.Text = failures.Count == 0
            ? "Hotkeys: F6 slower • F7 faster • F8 pause/resume • F9 stop"
            : $"Unavailable hotkeys: {string.Join(", ", failures)}. On-screen controls still work.";
    }

    private void RegisterHotkey(int id, uint virtualKey, string name, ICollection<string> failures)
    {
        if (!ClientNativeMethods.RegisterHotKey(Handle, id, ClientNativeMethods.ModNoRepeat, virtualKey))
        {
            failures.Add(name);
        }
    }

    private void UnregisterGlobalHotkeys()
    {
        _ = ClientNativeMethods.UnregisterHotKey(Handle, HotkeyF6);
        _ = ClientNativeMethods.UnregisterHotKey(Handle, HotkeyF7);
        _ = ClientNativeMethods.UnregisterHotKey(Handle, HotkeyF8);
        _ = ClientNativeMethods.UnregisterHotKey(Handle, HotkeyF9);
    }

    private void HandleDragEnter(object? sender, DragEventArgs eventArgs)
    {
        if (eventArgs.Data?.GetDataPresent(DataFormats.FileDrop) == true)
        {
            var files = eventArgs.Data.GetData(DataFormats.FileDrop) as string[];
            if (files?.Length == 1 && SongSourceLoader.IsSupportedPath(files[0]))
            {
                eventArgs.Effect = DragDropEffects.Copy;
                return;
            }
        }

        eventArgs.Effect = DragDropEffects.None;
    }

    private void HandleDragDrop(object? sender, DragEventArgs eventArgs)
    {
        var files = eventArgs.Data?.GetData(DataFormats.FileDrop) as string[];
        if (files?.Length == 1)
        {
            TrySelectSong(files[0], showDialogOnError: true);
        }
    }

    private void OpenDiagnosticsDirectory()
    {
        try
        {
            Directory.CreateDirectory(ClientDiagnostics.DirectoryPath);
            Process.Start(new ProcessStartInfo { FileName = ClientDiagnostics.DirectoryPath, UseShellExecute = true });
        }
        catch (Exception exception) when (
            exception is InvalidOperationException or IOException or UnauthorizedAccessException or System.ComponentModel.Win32Exception)
        {
            _playbackInfo.Text = "Diagnostics could not be opened.";
            ClientDiagnostics.Log($"Open diagnostics failed: {exception}");
        }
    }

    private async void HandleFormClosingAsync(object? sender, FormClosingEventArgs eventArgs)
    {
        _robloxTimer.Stop();
        _positionTimer.Stop();
        if (_allowClose || _playbackTask is null || _playbackTask.IsCompleted)
        {
            return;
        }

        eventArgs.Cancel = true;
        var task = _playbackTask;
        StopPlayback();

        try
        {
            await task.ConfigureAwait(true);
        }
        catch
        {
        }

        _allowClose = true;
        Close();
    }
}
