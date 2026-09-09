using System.Diagnostics;
using System.Globalization;
using RobloxPiano.Core;

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

    private readonly TextBox _sheetPath = new() { Dock = DockStyle.Fill, ReadOnly = true };
    private readonly Label _sheetInfo = CreateStatusLabel("No sheet selected.");
    private readonly Label _robloxInfo = CreateStatusLabel("Searching for Roblox...");
    private readonly Label _playbackInfo = CreateStatusLabel("Ready.");
    private readonly Label _speedInfo = CreateStatusLabel("1.00x");
    private readonly Label _positionInfo = CreateStatusLabel("00:00 / 00:00");
    private readonly Label _hotkeyInfo = CreateStatusLabel("Hotkeys: registering...");
    private readonly Button _browseButton = new() { Text = "Browse sheet...", AutoSize = true };
    private readonly Button _playButton = new() { Text = "Play", AutoSize = true };
    private readonly Button _pauseButton = new() { Text = "Pause (F8)", AutoSize = true, Enabled = false };
    private readonly Button _stopButton = new() { Text = "Stop (F9)", AutoSize = true, Enabled = false };
    private readonly Button _slowerButton = new() { Text = "Slower (F6)", AutoSize = true };
    private readonly Button _fasterButton = new() { Text = "Faster (F7)", AutoSize = true };
    private readonly Button _backButton = new() { Text = "-10s", AutoSize = true, Enabled = false };
    private readonly Button _forwardButton = new() { Text = "+10s", AutoSize = true, Enabled = false };
    private readonly Button _logsButton = new() { Text = "Diagnostics", AutoSize = true };
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
    private readonly System.Windows.Forms.Timer _robloxTimer = new() { Interval = 1000 };
    private readonly System.Windows.Forms.Timer _positionTimer = new() { Interval = 100 };

    private string? _selectedSheetPath;
    private double _preferredSpeed = 1d;
    private TimeSpan _loadedDuration;
    private PlaybackSessionClock? _sessionClock;
    private PlaybackTransportSession? _transportSession;
    private CancellationTokenSource? _playbackCancellation;
    private Task? _playbackTask;
    private RobloxWindowTarget? _activeTarget;
    private bool _positionDragging;
    private bool _allowClose;

    public ClientMainForm()
    {
        Text = "Roblox Piano";
        StartPosition = FormStartPosition.CenterScreen;
        MinimumSize = new Size(720, 500);
        Size = new Size(840, 590);
        AllowDrop = true;

        BuildLayout();
        LoadClientState();
        RefreshRobloxStatus();

        _browseButton.Click += (_, _) => BrowseSheet();
        _playButton.Click += async (_, _) => await StartPlaybackAsync().ConfigureAwait(true);
        _pauseButton.Click += (_, _) => TogglePause();
        _stopButton.Click += (_, _) => StopPlayback();
        _slowerButton.Click += (_, _) => AdjustSpeed(-0.10d);
        _fasterButton.Click += (_, _) => AdjustSpeed(0.10d);
        _backButton.Click += (_, _) => SeekRelative(TimeSpan.FromSeconds(-10));
        _forwardButton.Click += (_, _) => SeekRelative(TimeSpan.FromSeconds(10));
        _logsButton.Click += (_, _) => OpenDiagnosticsDirectory();
        _latencyMs.ValueChanged += (_, _) =>
        {
            SaveClientState();
            _playbackInfo.Text = $"Input latency compensation set to {(int)_latencyMs.Value} ms for the next playback.";
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
            Text = "Drop a .txt/.vps sheet, press Play, then use F6/F7/F8/F9 while Roblox has focus.",
            AutoSize = true,
            Margin = new Padding(0, 0, 0, 16)
        };

        var sheetRow = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 2, AutoSize = true };
        sheetRow.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100f));
        sheetRow.ColumnStyles.Add(new ColumnStyle(SizeType.AutoSize));
        sheetRow.Controls.Add(_sheetPath, 0, 0);
        sheetRow.Controls.Add(_browseButton, 1, 0);

        var sheetPanel = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 1, RowCount = 2, AutoSize = true };
        sheetPanel.Controls.Add(sheetRow, 0, 0);
        sheetPanel.Controls.Add(_sheetInfo, 0, 1);

        var controls = new FlowLayoutPanel
        {
            Dock = DockStyle.Fill,
            AutoSize = true,
            WrapContents = true,
            FlowDirection = FlowDirection.LeftToRight
        };
        controls.Controls.AddRange([
            _playButton,
            _pauseButton,
            _stopButton,
            _slowerButton,
            _fasterButton,
            _backButton,
            _forwardButton,
            _logsButton
        ]);

        var speedRow = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true, FlowDirection = FlowDirection.LeftToRight };
        speedRow.Controls.Add(new Label { Text = "Speed:", AutoSize = true, Padding = new Padding(0, 4, 0, 0) });
        speedRow.Controls.Add(_speedInfo);

        var latencyRow = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true, FlowDirection = FlowDirection.LeftToRight };
        latencyRow.Controls.Add(new Label { Text = "Input latency compensation:", AutoSize = true, Padding = new Padding(0, 4, 0, 0) });
        latencyRow.Controls.Add(_latencyMs);
        latencyRow.Controls.Add(new Label { Text = "ms (0 = legacy timing)", AutoSize = true, Padding = new Padding(0, 4, 0, 0) });

        var seekPanel = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 1, RowCount = 2, AutoSize = true };
        seekPanel.Controls.Add(_positionBar, 0, 0);
        seekPanel.Controls.Add(_positionInfo, 0, 1);

        var playbackPanel = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 1, RowCount = 6, AutoSize = true };
        playbackPanel.Controls.Add(controls, 0, 0);
        playbackPanel.Controls.Add(speedRow, 0, 1);
        playbackPanel.Controls.Add(latencyRow, 0, 2);
        playbackPanel.Controls.Add(seekPanel, 0, 3);
        playbackPanel.Controls.Add(_playbackInfo, 0, 4);
        playbackPanel.Controls.Add(_hotkeyInfo, 0, 5);

        var safety = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(780, 0),
            Text = "Safety: input is sent only to the selected foreground Roblox process. Losing focus, pause, stop, " +
                   "seek, cancellation, or an input error releases held keys before playback can continue. Latency compensation only changes dispatch timing; it never changes score truth."
        };

        root.Controls.Add(title);
        root.Controls.Add(subtitle);
        root.Controls.Add(CreateGroup("Roblox", _robloxInfo));
        root.Controls.Add(CreateGroup("Sheet", sheetPanel));
        root.Controls.Add(CreateGroup("Playback / Seek / Calibration", playbackPanel));
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

    private static Label CreateStatusLabel(string text)
    {
        return new Label
        {
            Text = text,
            AutoSize = true,
            Padding = new Padding(0, 4, 0, 4),
            MaximumSize = new Size(780, 0)
        };
    }

    private void LoadClientState()
    {
        var state = ClientStateStore.Load();
        _preferredSpeed = state.PreferredSpeed;
        _latencyMs.Value = Math.Clamp(state.InputLatencyMs, (int)_latencyMs.Minimum, (int)_latencyMs.Maximum);
        UpdateSpeedLabel();

        if (!string.IsNullOrWhiteSpace(state.LastSheetPath) && File.Exists(state.LastSheetPath))
        {
            TrySelectSheet(state.LastSheetPath, showDialogOnError: false);
        }
    }

    private void SaveClientState()
    {
        ClientStateStore.Save(new ClientState(_selectedSheetPath, _preferredSpeed, (int)_latencyMs.Value));
    }

    private void BrowseSheet()
    {
        using var dialog = new OpenFileDialog
        {
            Title = "Choose Roblox Virtual Piano sheet",
            Filter = "Virtual Piano sheets (*.txt;*.vps)|*.txt;*.vps|Text files (*.txt)|*.txt|All files (*.*)|*.*",
            CheckFileExists = true,
            Multiselect = false
        };

        if (!string.IsNullOrWhiteSpace(_selectedSheetPath))
        {
            dialog.InitialDirectory = Path.GetDirectoryName(_selectedSheetPath);
            dialog.FileName = Path.GetFileName(_selectedSheetPath);
        }

        if (dialog.ShowDialog(this) == DialogResult.OK)
        {
            TrySelectSheet(dialog.FileName, showDialogOnError: true);
        }
    }

    private bool TrySelectSheet(string path, bool showDialogOnError)
    {
        try
        {
            var fullPath = Path.GetFullPath(path);
            if (!File.Exists(fullPath))
            {
                throw new FileNotFoundException("Sheet file does not exist.", fullPath);
            }

            if (!IsSupportedSheetPath(fullPath))
            {
                throw new FormatException("Choose a .txt or .vps Virtual Piano sheet.");
            }

            var track = LegacySheetParser.Parse(File.ReadAllText(fullPath));
            _selectedSheetPath = fullPath;
            _loadedDuration = track.TimelineDuration;
            _sheetPath.Text = fullPath;
            _sheetInfo.Text = $"{track.Title} — {track.Events.Count} events — " +
                              $"{track.Bpm.ToString("0.###", CultureInfo.InvariantCulture)} BPM / subdiv {track.Subdivision} — " +
                              $"{FormatTime(track.TimelineDuration)}";
            _positionBar.Value = 0;
            _positionBar.Enabled = true;
            _backButton.Enabled = true;
            _forwardButton.Enabled = true;
            UpdatePositionLabel(TimeSpan.Zero);
            _playbackInfo.Text = "Sheet validated. Ready to play from 00:00 or choose a start position.";
            SaveClientState();
            return true;
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or FormatException
            or ArgumentException)
        {
            ClientDiagnostics.Log($"Sheet selection failed for '{path}': {exception}");
            _playbackInfo.Text = $"Sheet error: {exception.Message}";
            if (showDialogOnError)
            {
                MessageBox.Show(this, exception.Message, "Sheet could not be loaded", MessageBoxButtons.OK, MessageBoxIcon.Warning);
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

        if (string.IsNullOrWhiteSpace(_selectedSheetPath)
            || !TrySelectSheetPreservingPosition(_selectedSheetPath))
        {
            return;
        }

        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _robloxInfo.Text = "Roblox player not found. Open the game first, then press Play.";
            MessageBox.Show(this,
                "RobloxPlayerBeta was not found. Open Roblox and enter the piano game, then press Play again.",
                "Roblox not found", MessageBoxButtons.OK, MessageBoxIcon.Information);
            return;
        }

        PerformanceTrack track;
        try
        {
            track = LegacySheetParser.Parse(await File.ReadAllTextAsync(_selectedSheetPath).ConfigureAwait(true));
        }
        catch (Exception exception) when (
            exception is IOException or UnauthorizedAccessException or FormatException or ArgumentException)
        {
            _playbackInfo.Text = $"Sheet error: {exception.Message}";
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
        _robloxInfo.Text = $"Target: {target}";
        var activated = target.TryActivate();
        _playbackInfo.Text = activated
            ? $"Roblox found. Starting from {FormatTime(initialPosition)} after countdown..."
            : "Roblox found. Click its window before the countdown finishes.";

        ClientDiagnostics.Log(
            $"Playback start: sheet='{_selectedSheetPath}', title='{track.Title}', targetPid={target.ProcessId}, " +
            $"speed={sessionClock.Speed:0.00}x, position={initialPosition.TotalSeconds:0.###}s, " +
            $"dispatchLeadMs={timingProfile.DispatchLead.TotalMilliseconds:0}, activation={activated}.");

        var task = RunPlaybackSessionAsync(track, transport, initialPosition, cancellation.Token);
        _playbackTask = task;

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
        catch (Exception exception) when (
            exception is IOException or UnauthorizedAccessException or InvalidOperationException or ArgumentException)
        {
            _playbackInfo.Text = $"Playback failed: {exception.Message}";
            ClientDiagnostics.Log($"Playback failed: {exception}");
            MessageBox.Show(this, exception.Message, "Playback failed", MessageBoxButtons.OK, MessageBoxIcon.Error);
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
        }
    }

    private bool TrySelectSheetPreservingPosition(string path)
    {
        var oldValue = _positionBar.Value;
        if (!TrySelectSheet(path, showDialogOnError: true))
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
            ? "Paused — press F8 to resume."
            : "Playing — drag timeline or use ±10s to seek. F6/F7 speed, F8 pause, F9 stop.";

        await transport.PlayAsync(initialPosition, cancellationToken).ConfigureAwait(true);
    }

    private async Task RunCountdownAsync(TimeSpan delay, CancellationToken cancellationToken)
    {
        var remaining = delay;
        while (remaining > TimeSpan.Zero)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var seconds = Math.Max(1, (int)Math.Ceiling(remaining.TotalSeconds));
            _playbackInfo.Text = $"Starting in {seconds}s — switch to Roblox. F9 cancels.";
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
            ? $"Speed changed live to {_preferredSpeed:0.00}x."
            : $"Ready at {_preferredSpeed:0.00}x.";
        ClientDiagnostics.Log($"Speed changed to {_preferredSpeed:0.00}x.");
    }

    private void TogglePause()
    {
        if (_sessionClock is null || _playbackTask is null || _playbackTask.IsCompleted)
        {
            return;
        }

        var paused = _sessionClock.ToggleUserPause();
        _pauseButton.Text = paused ? "Resume (F8)" : "Pause (F8)";
        _playbackInfo.Text = paused
            ? "Paused safely — held keys are released. Seek is still available."
            : "Resumed — playback continues from the current transport position.";
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
        CommitSeek(PlaybackTransport.ClampPosition(
            new PerformanceTrack("position", 1, 1, TimeSpan.Zero, Array.Empty<PerformanceEvent>(), _loadedDuration),
            current + delta));
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

        var transport = _transportSession;
        if (transport is not null)
        {
            transport.Seek(clamped);
            _playbackInfo.Text = $"Seeking safely to {FormatTime(clamped)} — releasing held keys before re-entry.";
            ClientDiagnostics.Log($"Seek requested: {clamped.TotalSeconds:0.###}s.");
        }
        else
        {
            _playbackInfo.Text = $"Start position set to {FormatTime(clamped)}.";
        }
    }

    private void RefreshPlaybackPosition()
    {
        if (_positionDragging || _loadedDuration <= TimeSpan.Zero)
        {
            return;
        }

        var transport = _transportSession;
        if (transport is not null)
        {
            SetPositionBar(transport.Position);
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
    {
        return value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");
    }

    private void SetPlaybackActive(bool active)
    {
        _playButton.Enabled = !active;
        _browseButton.Enabled = !active;
        _latencyMs.Enabled = !active;
        _pauseButton.Enabled = active;
        _stopButton.Enabled = active;
        _pauseButton.Text = "Pause (F8)";
        _positionBar.Enabled = _loadedDuration > TimeSpan.Zero;
        _backButton.Enabled = _loadedDuration > TimeSpan.Zero;
        _forwardButton.Enabled = _loadedDuration > TimeSpan.Zero;
    }

    private void UpdateSpeedLabel()
    {
        _speedInfo.Text = $"{_preferredSpeed:0.00}x  (range {PlaybackSessionClock.MinimumSpeed:0.##}x–{PlaybackSessionClock.MaximumSpeed:0.##}x)";
    }

    private void RefreshRobloxStatus()
    {
        if (_activeTarget is not null)
        {
            _robloxInfo.Text = _activeTarget.IsAlive
                ? $"Target: {_activeTarget}"
                : "Target Roblox process exited. Playback will remain safety-paused.";
            return;
        }

        var target = RobloxProcessLocator.FindPreferred();
        _robloxInfo.Text = target is null
            ? "Roblox player not found. Open Roblox before pressing Play."
            : $"Ready: {target}";
    }

    private void RegisterGlobalHotkeys()
    {
        var failures = new List<string>();
        RegisterHotkey(HotkeyF6, VirtualKeyF6, "F6", failures);
        RegisterHotkey(HotkeyF7, VirtualKeyF7, "F7", failures);
        RegisterHotkey(HotkeyF8, VirtualKeyF8, "F8", failures);
        RegisterHotkey(HotkeyF9, VirtualKeyF9, "F9", failures);
        _hotkeyInfo.Text = failures.Count == 0
            ? "Global hotkeys active: F6 slower • F7 faster • F8 pause/resume • F9 stop"
            : $"Hotkey warning: {string.Join(", ", failures)} unavailable. On-screen controls still work.";
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
            if (files?.Length == 1 && IsSupportedSheetPath(files[0]))
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
            TrySelectSheet(files[0], showDialogOnError: true);
        }
    }

    private static bool IsSupportedSheetPath(string path)
    {
        var extension = Path.GetExtension(path);
        return extension.Equals(".txt", StringComparison.OrdinalIgnoreCase)
            || extension.Equals(".vps", StringComparison.OrdinalIgnoreCase);
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
            _playbackInfo.Text = $"Could not open diagnostics: {exception.Message}";
        }
    }

    private async void HandleFormClosingAsync(object? sender, FormClosingEventArgs eventArgs)
    {
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
