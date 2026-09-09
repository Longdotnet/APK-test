using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed class SheetLibraryForm : Form
{
    private readonly SheetLibraryService _library;
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
    private readonly Label _status = new() { AutoSize = true, Padding = new Padding(0, 6, 0, 6) };
    private readonly Button _openButton = new() { Text = "Open player", AutoSize = true };
    private readonly Button _importButton = new() { Text = "Add sheet...", AutoSize = true };
    private readonly Button _refreshButton = new() { Text = "Refresh", AutoSize = true };
    private IReadOnlyList<SheetLibraryEntry> _entries = Array.Empty<SheetLibraryEntry>();

    public SheetLibraryForm()
    {
        Text = "Roblox Piano — Sheet Library";
        StartPosition = FormStartPosition.CenterScreen;
        MinimumSize = new Size(760, 500);
        Size = new Size(900, 620);
        AllowDrop = true;

        var localRoot = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "sheets");
        var portable = Path.Combine(AppContext.BaseDirectory, "sheets");
        _library = new SheetLibraryService(localRoot, portable);

        BuildLayout();
        RefreshLibrary();

        _search.TextChanged += (_, _) => ApplyFilter();
        _refreshButton.Click += (_, _) => RefreshLibrary();
        _importButton.Click += (_, _) => ImportWithPicker();
        _openButton.Click += (_, _) => OpenSelectedPlayer();
        _grid.CellDoubleClick += (_, _) => OpenSelectedPlayer();
        DragEnter += HandleDragEnter;
        DragDrop += HandleDragDrop;
    }

    private void BuildLayout()
    {
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Song", DataPropertyName = nameof(SheetLibraryEntry.Title), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill, FillWeight = 45 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "BPM", DataPropertyName = nameof(SheetLibraryEntry.Bpm), Width = 75 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Duration", Name = "Duration", Width = 90 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Status", DataPropertyName = nameof(SheetLibraryEntry.Status), Width = 90 });
        _grid.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "File", DataPropertyName = nameof(SheetLibraryEntry.FileName), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill, FillWeight = 30 });
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

        var title = new Label { Text = "Sheet Library", AutoSize = true, Font = new Font(Font.FontFamily, 20f, FontStyle.Bold) };
        var subtitle = new Label
        {
            Text = "Choose a song from your library. Add sheet imports and validates it; drag-drop does the same.",
            AutoSize = true,
            Padding = new Padding(0, 0, 0, 10)
        };
        var buttons = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        buttons.Controls.AddRange([_openButton, _importButton, _refreshButton]);

        var root = new TableLayoutPanel { Dock = DockStyle.Fill, Padding = new Padding(18), ColumnCount = 1, RowCount = 6 };
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.Percent, 100));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.Controls.Add(title, 0, 0);
        root.Controls.Add(subtitle, 0, 1);
        root.Controls.Add(_search, 0, 2);
        root.Controls.Add(_grid, 0, 3);
        root.Controls.Add(buttons, 0, 4);
        root.Controls.Add(_status, 0, 5);
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
                ? $"{valid} playable sheet(s). Managed library: {_library.ManagedDirectory}"
                : $"{valid} playable, {invalid} invalid sheet(s). Invalid files stay visible for repair instead of being silently ignored.";
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or ArgumentException)
        {
            ClientDiagnostics.Log($"Sheet library scan failed: {exception}");
            _status.Text = $"Library error: {exception.Message}";
        }
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
    }

    private void ImportWithPicker()
    {
        using var dialog = new OpenFileDialog
        {
            Title = "Add Roblox Piano sheet",
            Filter = "Virtual Piano sheets (*.txt;*.vps)|*.txt;*.vps|All files (*.*)|*.*",
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
                ClientDiagnostics.Log($"Sheet imported: source='{file}', managed='{lastImported}'.");
            }
            catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or FormatException or ArgumentException)
            {
                ClientDiagnostics.Log($"Sheet import failed for '{file}': {exception}");
                MessageBox.Show(this, $"{Path.GetFileName(file)}\n\n{exception.Message}", "Sheet could not be imported", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }
        RefreshLibrary(lastImported);
    }

    private void OpenSelectedPlayer()
    {
        if (_grid.CurrentRow?.DataBoundItem is not SheetLibraryEntry entry)
        {
            return;
        }
        if (entry.Status != SheetValidationStatus.Valid)
        {
            MessageBox.Show(this, entry.Error ?? "This sheet is invalid.", "Sheet needs repair", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            return;
        }

        var state = ClientStateStore.Load();
        ClientStateStore.Save(state with { LastSheetPath = entry.Path });
        using var player = new ClientMainForm();
        Hide();
        try
        {
            player.ShowDialog(this);
        }
        finally
        {
            Show();
            Activate();
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
