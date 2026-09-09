using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed class SheetLibraryForm : Form
{
    private readonly SheetLibraryService _library;
    private readonly OnlineSongDiscoveryController _onlineDiscovery;
    private readonly ClientUpdateController _updates;
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
    private readonly Button _importButton = new() { Text = "Import Song...", AutoSize = true };
    private readonly Button _refreshButton = new() { Text = "Refresh", AutoSize = true };
    private readonly System.Windows.Forms.Timer _robloxTimer = new() { Interval = 1000 };
    private IReadOnlyList<SheetLibraryEntry> _entries = Array.Empty<SheetLibraryEntry>();
    private bool _robloxReady;

    public SheetLibraryForm()
    {
        Text = "Roblox Piano";
        StartPosition = FormStartPosition.CenterScreen;
        MinimumSize = new Size(760, 560);
        Size = new Size(920, 720);
        AllowDrop = true;

        var localRoot = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "sheets");
        var portable = Path.Combine(AppContext.BaseDirectory, "sheets");
        _library = new SheetLibraryService(localRoot, portable);
        _onlineDiscovery = new OnlineSongDiscoveryController(_search, _library, path => RefreshLibrary(path));
        _updates = new ClientUpdateController();

        BuildLayout();
        RefreshLibrary();
        RefreshRobloxStatus();

        _search.TextChanged += (_, _) => ApplyFilter();
        _refreshButton.Click += (_, _) => RefreshLibrary();
        _importButton.Click += (_, _) => ImportWithPicker();
        _playButton.Click += (_, _) => PlaySelected();
        _grid.CellDoubleClick += (_, _) => PlaySelected();
        _grid.SelectionChanged += (_, _) => UpdatePrimaryAction();
        _robloxTimer.Tick += (_, _) => RefreshRobloxStatus();
        _robloxTimer.Start();
        DragEnter += HandleDragEnter;
        DragDrop += HandleDragDrop;
        Shown += async (_, _) => await _updates.CheckAsync(this);
        FormClosed += (_, _) =>
        {
            _robloxTimer.Stop();
            _onlineDiscovery.Dispose();
            _updates.Dispose();
        };
    }

    private void BuildLayout()
    {
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Song", DataPropertyName = nameof(SheetLibraryEntry.Title), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill, FillWeight = 48 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "BPM", DataPropertyName = nameof(SheetLibraryEntry.Bpm), Width = 75 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Duration", Name = "Duration", Width = 90 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Status", DataPropertyName = nameof(SheetLibraryEntry.Status), Width = 90 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "File", DataPropertyName = nameof(SheetLibraryEntry.FileName), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill, FillWeight = 28 });
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
            Text = "Search your Library or the internet, choose a song, and press Play. File type, validation, timing safety and diagnostics stay automatic.",
            AutoSize = true,
            Padding = new Padding(0, 0, 0, 4)
        };
        var buttons = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        buttons.Controls.AddRange([_playButton, _importButton, _refreshButton]);

        var root = new TableLayoutPanel { Dock = DockStyle.Fill, Padding = new Padding(18), ColumnCount = 1, RowCount = 9 };
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
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
        root.Controls.Add(_updates.View, 0, 2);
        root.Controls.Add(_robloxStatus, 0, 3);
        root.Controls.Add(_search, 0, 4);
        root.Controls.Add(_onlineDiscovery.View, 0, 5);
        root.Controls.Add(_grid, 0, 6);
        root.Controls.Add(buttons, 0, 7);
        root.Controls.Add(_status, 0, 8);
        Controls.Add(root);
    }

    private void RefreshLibrary(string? selectPath = null)
    {
        try
        {
            _entries = _library.Scan();
            ApplyFilter(selectPath);
            var valid = _entries.Count(entry => entry.Status == SheetValidationStatus.Valid);
            var invalid = _entries.Count - valid;
            _status.Text = invalid == 0
                ? $"{valid} playable song(s). Search above, drop a file here, or use Import Song to add more."
                : $"{valid} playable, {invalid} need repair. Broken files stay visible instead of failing silently.";
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
            : "● Roblox ready — select a song and press Play.";
        UpdatePrimaryAction();
    }

    private void ApplyFilter(string? selectPath = null)
    {
        var query = _search.Text.Trim();
        var filtered = string.IsNullOrWhiteSpace(query)
            ? _entries
            : _entries.Where(entry =>
                entry.Title.Contains(query, StringComparison.CurrentCultureIgnoreCase)
                || entry.FileName.Contains(query, StringComparison.CurrentCultureIgnoreCase)).ToArray();

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
    }

    private void ImportWithPicker()
    {
        using var dialog = new OpenFileDialog
        {
            Title = "Import song",
            Filter = "Supported songs (*.txt;*.vps;*.mid;*.midi)|*.txt;*.vps;*.mid;*.midi|All files (*.*)|*.*",
            CheckFileExists = true,
            Multiselect = true
        };
        if (dialog.ShowDialog(this) == DialogResult.OK)
        {
            ImportFiles(dialog.FileNames);
        }
    }

    private void ImportFiles(IEnumerable<string> files)
    {
        string? lastImported = null;
        foreach (var file in files)
        {
            try
            {
                lastImported = _library.Import(file).Path;
                ClientDiagnostics.Log($"Song imported: source='{file}', managed='{lastImported}'.");
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or FormatException or ArgumentException or OverflowException)
            {
                ClientDiagnostics.Log($"Song import failed for '{file}': {exception}");
                MessageBox.Show(this, $"{Path.GetFileName(file)}\n\n{exception.Message}", "Song could not be imported", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }
        RefreshLibrary(lastImported);
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
        if (eventArgs.Data?.GetData(DataFormats.FileDrop) is string[] files
            && files.Length > 0
            && files.All(SheetLibraryService.IsSupportedPath))
        {
            eventArgs.Effect = DragDropEffects.Copy;
            return;
        }
        eventArgs.Effect = DragDropEffects.None;
    }

    private void HandleDragDrop(object? sender, DragEventArgs eventArgs)
    {
        if (eventArgs.Data?.GetData(DataFormats.FileDrop) is string[] files)
        {
            ImportFiles(files);
        }
    }

    private static string FormatTime(TimeSpan value)
        => value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");
}
