using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed class SheetLibraryForm : Form
{
    private readonly SheetLibraryService _library;
    private readonly OnlineSongDiscoveryController _onlineDiscovery;
    private readonly TextBox _search = new() { PlaceholderText = "Search songs...", Dock = DockStyle.Fill };
    private readonly DataGridView _grid = new()
    {
        Dock = DockStyle.Fill,
        ReadOnly = true,
        MultiSelect = false,
        SelectionMode = DataGridViewSelectionMode.FullRowSelect,
        AutoGenerateColumns = false,
        AllowUserToAddRows = false,
        AllowUserToDeleteRows = false,
        RowHeadersVisible = false
    };
    private readonly Label _robloxStatus = new() { AutoSize = true, Padding = new Padding(0, 6, 0, 6) };
    private readonly Label _status = new() { AutoSize = true, Padding = new Padding(0, 6, 0, 6) };
    private readonly Button _playButton = new()
    {
        Text = "Play",
        AutoSize = true,
        Enabled = false,
        Font = new Font(SystemFonts.DefaultFont.FontFamily, 11f, FontStyle.Bold),
        Padding = new Padding(14, 5, 14, 5)
    };
    private readonly Button _inputCheckButton = new() { Text = "Test Roblox Input", AutoSize = true };
    private readonly Button _importMidiButton = new() { Text = "Import MIDI...", AutoSize = true };
    private readonly Button _importMidiFolderButton = new() { Text = "Import MIDI Folder...", AutoSize = true };
    private readonly Button _importButton = new() { Text = "Import Other...", AutoSize = true };
    private readonly Button _refreshButton = new() { Text = "Refresh", AutoSize = true };
    private readonly System.Windows.Forms.Timer _robloxTimer = new() { Interval = 1000 };
    private IReadOnlyList<SheetLibraryEntry> _entries = Array.Empty<SheetLibraryEntry>();
    private bool _robloxReady;
    private bool _dragDropAvailable;

    public SheetLibraryForm()
    {
        Text = "Roblox Piano";
        StartPosition = FormStartPosition.CenterScreen;
        MinimumSize = new Size(860, 580);
        Size = new Size(1080, 740);

        var localRoot = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "sheets");
        var portable = Path.Combine(AppContext.BaseDirectory, "sheets");
        _library = new SheetLibraryService(localRoot, portable);
        _onlineDiscovery = new OnlineSongDiscoveryController(_search, _library, path => RefreshLibrary(path));

        BuildLayout();
        BootstrapFirstRunLibrary();
        RefreshLibrary();
        RefreshRobloxStatus();

        _search.TextChanged += (_, _) => ApplyFilter();
        _refreshButton.Click += (_, _) => RefreshLibrary();
        _inputCheckButton.Click += (_, _) => ShowInputCheck();
        _importMidiButton.Click += (_, _) => ImportMidiWithPicker();
        _importMidiFolderButton.Click += (_, _) => ImportMidiFolder();
        _importButton.Click += (_, _) => ImportOtherWithPicker();
        _playButton.Click += (_, _) => PlaySelected();
        _grid.CellDoubleClick += (_, _) => PlaySelected();
        _grid.SelectionChanged += (_, _) => UpdatePrimaryAction();
        _robloxTimer.Tick += (_, _) => RefreshRobloxStatus();
        _robloxTimer.Start();
        Shown += (_, _) => TryEnableDragDrop();
        FormClosed += (_, _) =>
        {
            _robloxTimer.Stop();
            _onlineDiscovery.Dispose();
        };
    }

    private void BuildLayout()
    {
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Song", DataPropertyName = nameof(SheetLibraryEntry.Title), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill, FillWeight = 44 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Type", DataPropertyName = nameof(SheetLibraryEntry.Format), Width = 80 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Import compatibility", DataPropertyName = nameof(SheetLibraryEntry.Compatibility), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill, FillWeight = 30 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "BPM", DataPropertyName = nameof(SheetLibraryEntry.Bpm), Width = 70 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Duration", Name = "Duration", Width = 90 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Status", DataPropertyName = nameof(SheetLibraryEntry.Status), Width = 90 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "File", DataPropertyName = nameof(SheetLibraryEntry.FileName), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill, FillWeight = 26 });
        _grid.CellFormatting += (_, e) =>
        {
            if (e.RowIndex < 0 || _grid.Rows[e.RowIndex].DataBoundItem is not SheetLibraryEntry entry)
            {
                return;
            }

            if (_grid.Columns[e.ColumnIndex].Name == "Duration")
            {
                e.Value = entry.Duration.HasValue ? FormatTime(entry.Duration.Value) : "—";
                e.FormattingApplied = true;
            }
        };

        var title = new Label { Text = "Roblox Piano", AutoSize = true, Font = new Font(Font.FontFamily, 20f, FontStyle.Bold) };
        var subtitle = new Label
        {
            Text = "Import MIDI collections into the Library. If Roblox does not react during playback, Test Roblox Input isolates focus, Windows delivery and Roblox consumption without involving MIDI or AI.",
            AutoSize = true,
            Padding = new Padding(0, 0, 0, 4)
        };
        var buttons = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        buttons.Controls.AddRange([_playButton, _inputCheckButton, _importMidiButton, _importMidiFolderButton, _importButton, _refreshButton]);

        var root = new TableLayoutPanel { Dock = DockStyle.Fill, Padding = new Padding(18), ColumnCount = 1, RowCount = 8 };
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.Percent, 100));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.Controls.Add(title, 0, 0);
        root.Controls.Add(subtitle, 0, 1);
        root.Controls.Add(_robloxStatus, 0, 2);
        root.Controls.Add(_search, 0, 3);
        root.Controls.Add(_onlineDiscovery.View, 0, 4);
        root.Controls.Add(_grid, 0, 5);
        root.Controls.Add(buttons, 0, 6);
        root.Controls.Add(_status, 0, 7);
        Controls.Add(root);
    }

    private void BootstrapFirstRunLibrary()
    {
        try
        {
            var entries = _library.EnsureStarterLibrary();
            ClientDiagnostics.Log($"Sheet library startup: {entries.Count} managed/portable song(s) available. Managed root='{_library.ManagedDirectory}'.");
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidOperationException or ArgumentException)
        {
            ClientDiagnostics.Log($"Starter library bootstrap failed without blocking the client: {exception}");
        }
    }

    private void TryEnableDragDrop()
    {
        try
        {
            AllowDrop = true;
            DragEnter += HandleDragEnter;
            DragDrop += HandleDragDrop;
            _dragDropAvailable = true;
            ClientDiagnostics.Log("Shell drag/drop registration succeeded.");
        }
        catch (InvalidOperationException exception)
        {
            _dragDropAvailable = false;
            ClientDiagnostics.Log($"Shell drag/drop unavailable; import buttons remain available: {exception}");
        }
        catch (System.ComponentModel.Win32Exception exception)
        {
            _dragDropAvailable = false;
            ClientDiagnostics.Log($"Shell drag/drop unavailable; import buttons remain available: {exception}");
        }

        RefreshLibrary();
    }

    private void RefreshLibrary(string? selectPath = null, string? statusOverride = null)
    {
        try
        {
            _entries = _library.Scan();
            ApplyFilter(selectPath);
            var valid = _entries.Count(entry => entry.Status == SheetValidationStatus.Valid);
            var invalid = _entries.Count - valid;
            var adjusted = _entries.Count(entry => entry.HasCompatibilityAdjustment);
            var importHint = _dragDropAvailable
                ? "Drop MIDI files/folders here or use Import MIDI."
                : "Use Import MIDI or Import MIDI Folder to add songs.";
            var adjustmentHint = adjusted > 0 ? $" {adjusted} MIDI song(s) use visible compatibility adjustments." : string.Empty;
            _status.Text = statusOverride ?? (invalid == 0
                ? $"{valid} playable song(s). {importHint}{adjustmentHint}"
                : $"{valid} playable, {invalid} need repair. Broken files stay visible instead of failing silently.{adjustmentHint}");
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or ArgumentException)
        {
            ClientDiagnostics.Log($"Song library scan failed: {exception}");
            _status.Text = $"Library error: {exception.Message}";
        }

        UpdatePrimaryAction();
    }

    private void RefreshRobloxStatus()
    {
        var target = RobloxProcessLocator.FindPreferred();
        _robloxReady = target is not null;
        _robloxStatus.Text = target is null
            ? "○ Roblox not detected — open Roblox and enter the piano game."
            : "● Roblox ready — select a song and press Play, or run Test Roblox Input if Roblox is not reacting.";
        _inputCheckButton.Enabled = target is not null;
        UpdatePrimaryAction();
    }

    private void ApplyFilter(string? selectPath = null)
    {
        var query = _search.Text.Trim();
        var filtered = string.IsNullOrWhiteSpace(query)
            ? _entries
            : _entries.Where(entry =>
                entry.Title.Contains(query, StringComparison.CurrentCultureIgnoreCase)
                || entry.FileName.Contains(query, StringComparison.CurrentCultureIgnoreCase)
                || entry.Format.Contains(query, StringComparison.CurrentCultureIgnoreCase)
                || entry.Compatibility.Contains(query, StringComparison.CurrentCultureIgnoreCase)).ToArray();

        _grid.DataSource = filtered.ToList();
        if (selectPath is not null)
        {
            foreach (DataGridViewRow row in _grid.Rows)
            {
                if (row.DataBoundItem is SheetLibraryEntry entry && entry.Path.Equals(selectPath, StringComparison.OrdinalIgnoreCase))
                {
                    row.Selected = true;
                    _grid.CurrentCell = row.Cells[0];
                    break;
                }
            }
        }

        UpdatePrimaryAction();
    }

    private void UpdatePrimaryAction()
    {
        var selected = _grid.CurrentRow?.DataBoundItem as SheetLibraryEntry;
        var playable = selected?.Status == SheetValidationStatus.Valid;
        _playButton.Enabled = playable && _robloxReady;
        _playButton.Text = !playable ? "Select a Song" : _robloxReady ? "Play" : "Open Roblox to Play";

        if (selected?.HasCompatibilityAdjustment == true)
        {
            _status.Text = $"Compatibility adjustment for {selected.Title}: {selected.Compatibility}. Playback uses this deterministic imported interpretation.";
        }
    }

    private void ShowInputCheck()
    {
        using var dialog = new RobloxInputCheckDialog();
        dialog.ShowDialog(this);
        RefreshRobloxStatus();
    }

    private void ImportMidiWithPicker()
    {
        using var dialog = new OpenFileDialog
        {
            Title = "Import MIDI into Library",
            Filter = "MIDI songs (*.mid;*.midi)|*.mid;*.midi|All files (*.*)|*.*",
            CheckFileExists = true,
            Multiselect = true
        };
        if (dialog.ShowDialog(this) == DialogResult.OK)
        {
            ImportPaths(dialog.FileNames);
        }
    }

    private void ImportMidiFolder()
    {
        using var dialog = new FolderBrowserDialog
        {
            Description = "Choose a folder. MIDI files inside it and its subfolders will be imported into the Library list.",
            ShowNewFolderButton = false
        };
        if (dialog.ShowDialog(this) != DialogResult.OK)
        {
            return;
        }

        try
        {
            var midiFiles = Directory
                .EnumerateFiles(dialog.SelectedPath, "*", SearchOption.AllDirectories)
                .Where(SheetLibraryService.IsMidiPath)
                .Take(2001)
                .ToArray();

            if (midiFiles.Length == 0)
            {
                RefreshLibrary(statusOverride: "No .mid or .midi files were found in that folder.");
                return;
            }

            ImportPaths(midiFiles);
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or ArgumentException)
        {
            ClientDiagnostics.Log($"MIDI folder discovery failed: {exception}");
            MessageBox.Show(this, exception.Message, "MIDI folder could not be read", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }
    }

    private void ImportOtherWithPicker()
    {
        using var dialog = new OpenFileDialog
        {
            Title = "Import song into Library",
            Filter = "Supported songs (*.txt;*.vps;*.mid;*.midi;*.musicxml;*.xml)|*.txt;*.vps;*.mid;*.midi;*.musicxml;*.xml|All files (*.*)|*.*",
            CheckFileExists = true,
            Multiselect = true
        };
        if (dialog.ShowDialog(this) == DialogResult.OK)
        {
            ImportPaths(dialog.FileNames);
        }
    }

    private void ImportPaths(IEnumerable<string> paths)
    {
        try
        {
            var result = _library.ImportBatch(paths);
            foreach (var entry in result.Imported)
            {
                ClientDiagnostics.Log($"Song imported into Library: managed='{entry.Path}', type={entry.Format}, compatibility='{entry.Compatibility}'.");
            }
            foreach (var duplicate in result.Existing)
            {
                ClientDiagnostics.Log($"Song import skipped duplicate content: managed='{duplicate.Path}', compatibility='{duplicate.Compatibility}'.");
            }
            foreach (var failure in result.Failed)
            {
                ClientDiagnostics.Log($"Song import failed: source='{failure.SourcePath}', error='{failure.Error}'.");
            }

            var selectPath = result.Imported.LastOrDefault()?.Path ?? result.Existing.LastOrDefault()?.Path;
            var summary = $"Imported {result.Imported.Count} new song(s) into the Library";
            if (result.AdjustedCount > 0)
            {
                summary += $", {result.AdjustedCount} with visible compatibility adjustment(s)";
            }
            if (result.Existing.Count > 0)
            {
                summary += $", skipped {result.Existing.Count} duplicate(s)";
            }
            if (result.Failed.Count > 0)
            {
                summary += $", {result.Failed.Count} failed";
            }
            summary += ".";

            RefreshLibrary(selectPath, summary);

            if (result.Failed.Count > 0)
            {
                var details = string.Join(
                    Environment.NewLine,
                    result.Failed.Take(6).Select(failure => $"• {Path.GetFileName(failure.SourcePath)} — {failure.Error}"));
                if (result.Failed.Count > 6)
                {
                    details += $"{Environment.NewLine}…and {result.Failed.Count - 6} more. See diagnostics for details.";
                }

                MessageBox.Show(
                    this,
                    $"Some files were not added to the Library:{Environment.NewLine}{Environment.NewLine}{details}",
                    "Import completed with warnings",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Warning);
            }
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidOperationException or ArgumentException)
        {
            ClientDiagnostics.Log($"Batch song import failed: {exception}");
            MessageBox.Show(this, exception.Message, "Import could not complete", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }
    }

    private void PlaySelected()
    {
        if (_grid.CurrentRow?.DataBoundItem is not SheetLibraryEntry entry)
        {
            return;
        }
        if (entry.Status != SheetValidationStatus.Valid)
        {
            _status.Text = entry.Error ?? "This song needs repair before it can play.";
            return;
        }
        if (!_robloxReady)
        {
            _robloxStatus.Text = "○ Open Roblox and enter the piano game; Play becomes available automatically.";
            return;
        }

        var state = ClientStateStore.Load();
        ClientStateStore.Save(state with { LastSheetPath = entry.Path });
        using var player = new ClientMainForm(autoStart: true);
        Hide();
        try
        {
            player.ShowDialog(this);
        }
        finally
        {
            Show();
            Activate();
            RefreshRobloxStatus();
            RefreshLibrary(entry.Path);
        }
    }

    private void HandleDragEnter(object? sender, DragEventArgs eventArgs)
    {
        if (eventArgs.Data?.GetData(DataFormats.FileDrop) is string[] paths
            && paths.Length > 0
            && paths.All(path => Directory.Exists(path) || (File.Exists(path) && SheetLibraryService.IsSupportedPath(path))))
        {
            eventArgs.Effect = DragDropEffects.Copy;
            return;
        }
        eventArgs.Effect = DragDropEffects.None;
    }

    private void HandleDragDrop(object? sender, DragEventArgs eventArgs)
    {
        if (eventArgs.Data?.GetData(DataFormats.FileDrop) is string[] paths)
        {
            ImportPaths(paths);
        }
    }

    private static string FormatTime(TimeSpan value)
        => value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");
}
