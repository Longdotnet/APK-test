namespace RobloxPiano.App;

/// <summary>
/// Read-only Support Center surface over the durable verified Legacy A/B experiment archive.
/// This UI never reconstructs experiments from recent sessions and never participates in playback truth.
/// </summary>
internal sealed class ArchivedBaselineExperimentsForm : Form
{
    private readonly DataGridView _experiments = new()
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
    private readonly TextBox _details = new()
    {
        Dock = DockStyle.Fill,
        ReadOnly = true,
        Multiline = true,
        ScrollBars = ScrollBars.Vertical
    };
    private readonly Label _status = new()
    {
        AutoSize = true,
        Padding = new Padding(0, 6, 0, 0),
        MaximumSize = new Size(1050, 0)
    };
    private readonly Button _refreshButton = new() { Text = "Refresh", AutoSize = true };
    private readonly Button _exportButton = new() { Text = "Export Selected Manifest...", AutoSize = true, Enabled = false };
    private IReadOnlyList<PlaybackBaselineExperimentManifest> _records = Array.Empty<PlaybackBaselineExperimentManifest>();

    public ArchivedBaselineExperimentsForm()
    {
        Text = "Verified Legacy A/B Experiment Archive";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(860, 560);
        Size = new Size(1120, 700);

        BuildLayout();
        _refreshButton.Click += (_, _) => RefreshArchive();
        _exportButton.Click += (_, _) => ExportSelected();
        _experiments.SelectionChanged += (_, _) => ShowSelectedDetails();
        Shown += (_, _) => RefreshArchive();
    }

    private void BuildLayout()
    {
        _experiments.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Completed", DataPropertyName = nameof(ExperimentRow.Completed), Width = 145 });
        _experiments.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Verdict", DataPropertyName = nameof(ExperimentRow.Verdict), Width = 135 });
        _experiments.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "P95 Δ", DataPropertyName = nameof(ExperimentRow.P95Delta), Width = 85 });
        _experiments.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Input Δ", DataPropertyName = nameof(ExperimentRow.InputDelta), Width = 85 });
        _experiments.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Campaign", DataPropertyName = nameof(ExperimentRow.Campaign), Width = 90 });
        _experiments.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Type", DataPropertyName = nameof(ExperimentRow.SourceType), Width = 70 });
        _experiments.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Canonical fingerprint", DataPropertyName = nameof(ExperimentRow.Fingerprint), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill });

        var title = new Label
        {
            Text = "Verified Legacy A/B Experiments",
            AutoSize = true,
            Font = new Font(Font.FontFamily, 17f, FontStyle.Bold)
        };
        var subtitle = new Label
        {
            Text = "Completed guided Legacy 1.00x → Legacy x2 2.00x experiments retained independently of recent session history. Every displayed record is re-verified from its immutable manifest before it is shown or exported.",
            AutoSize = true,
            MaximumSize = new Size(1050, 0),
            Padding = new Padding(0, 0, 0, 4)
        };
        var buttons = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        buttons.Controls.AddRange([_refreshButton, _exportButton]);

        var split = new SplitContainer { Dock = DockStyle.Fill, Orientation = Orientation.Horizontal, SplitterDistance = 310 };
        split.Panel1.Controls.Add(_experiments);
        split.Panel2.Controls.Add(_details);

        var root = new TableLayoutPanel { Dock = DockStyle.Fill, Padding = new Padding(18), ColumnCount = 1, RowCount = 5 };
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.Percent, 100));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.Controls.Add(title, 0, 0);
        root.Controls.Add(subtitle, 0, 1);
        root.Controls.Add(split, 0, 2);
        root.Controls.Add(buttons, 0, 3);
        root.Controls.Add(_status, 0, 4);
        Controls.Add(root);
    }

    private void RefreshArchive()
    {
        try
        {
            _records = PlaybackBaselineExperimentArchive.ReadVerified(
                PlaybackBaselineExperimentArchive.ArchiveDirectoryPath);
            _experiments.DataSource = _records.Select(record => new ExperimentRow(record)).ToList();
            _status.Text = _records.Count == 0
                ? "No verified completed Legacy A/B experiments are archived yet. Complete a guided campaign from Support Center to create one."
                : $"Showing {_records.Count} verified completed experiment(s), newest first. Corrupt or unverifiable archive files are excluded without hiding valid evidence.";
            ShowSelectedDetails();
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or System.Text.Json.JsonException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Archived experiment browser could not load verified evidence: {exception}");
            _records = Array.Empty<PlaybackBaselineExperimentManifest>();
            _experiments.DataSource = null;
            _details.Clear();
            _exportButton.Enabled = false;
            _status.Text = $"Could not load verified experiment archive: {exception.Message}";
        }
    }

    private void ShowSelectedDetails()
    {
        if (_experiments.CurrentRow?.DataBoundItem is not ExperimentRow row)
        {
            _details.Text = "Select a verified experiment to inspect its immutable evidence.";
            _exportButton.Enabled = false;
            return;
        }

        var manifest = row.Manifest;
        _exportButton.Enabled = true;
        _details.Text = string.Join(Environment.NewLine,
        [
            $"Completed (UTC): {manifest.CompletedAtUtc:O}",
            $"Campaign created (UTC): {manifest.CampaignCreatedAtUtc:O}",
            $"Campaign ID: {manifest.CampaignId}",
            $"Runtime verdict: {manifest.RuntimeVerdict}",
            $"Legacy x2 minus Legacy P95 timing: {FormatDelta(manifest.LegacyX2P95TimingDeltaMilliseconds)}",
            $"Legacy x2 minus Legacy max input-call: {FormatDelta(manifest.LegacyX2MaxInputCallDeltaMilliseconds)}",
            "",
            $"Source type: {manifest.SourceType}",
            $"Canonical fingerprint: {manifest.CanonicalSourceFingerprint}",
            $"Playback engine: {manifest.PlaybackEngine}",
            $"Input profile: {manifest.InputProfile}",
            $"Input latency compensation: {manifest.InputLatencyMs} ms",
            "",
            $"Legacy session ID: {manifest.LegacySessionId}",
            $"Legacy x2 session ID: {manifest.LegacyX2SessionId}",
            $"Transport-equivalence SHA-256: {manifest.TransportEquivalenceSha256}",
            $"Evidence SHA-256: {manifest.EvidenceSha256}",
            "",
            "This manifest is diagnostics evidence only. It cannot change playback settings, promote Legacy x2, authorize Roblox, or inject input."
        ]);
    }

    private void ExportSelected()
    {
        if (_experiments.CurrentRow?.DataBoundItem is not ExperimentRow row)
        {
            return;
        }

        try
        {
            var manifest = row.Manifest;
            var suggested = $"RobloxPiano-LegacyAB-{manifest.CompletedAtUtc.UtcDateTime:yyyyMMdd-HHmmss}-{ShortId(manifest.CampaignId)}.legacy-ab.json";
            using var dialog = new SaveFileDialog
            {
                Title = "Export verified Legacy A/B experiment manifest",
                Filter = "Legacy A/B manifest (*.legacy-ab.json)|*.legacy-ab.json|JSON file (*.json)|*.json",
                FileName = suggested,
                AddExtension = true,
                DefaultExt = "legacy-ab.json"
            };
            if (dialog.ShowDialog(this) != DialogResult.OK)
            {
                return;
            }

            PlaybackBaselineExperimentArchive.ExportVerified(manifest, dialog.FileName);
            var readBack = PlaybackBaselineExperimentManifestStore.ReadAndVerify(dialog.FileName);
            if (!string.Equals(readBack.EvidenceSha256, manifest.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException("Exported Legacy A/B manifest did not preserve the selected archived evidence hash.");
            }

            _status.Text = $"Verified archived experiment exported: {dialog.FileName}";
        }
        catch (Exception exception) when (
            exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or System.Text.Json.JsonException
            or NotSupportedException)
        {
            ClientDiagnostics.Log($"Archived experiment export failed: {exception}");
            MessageBox.Show(this, exception.Message, "Experiment manifest could not be exported", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }
    }

    private static string FormatDelta(double? value)
        => value is null ? "(not measured)" : $"{value:+0.###;-0.###;0} ms";

    private static string ShortId(string value)
        => value.Length <= 8 ? value : value[..8];

    private sealed record ExperimentRow(
        PlaybackBaselineExperimentManifest Manifest,
        string Completed,
        string Verdict,
        string P95Delta,
        string InputDelta,
        string Campaign,
        string SourceType,
        string Fingerprint)
    {
        public ExperimentRow(PlaybackBaselineExperimentManifest manifest)
            : this(
                manifest,
                manifest.CompletedAtUtc.ToLocalTime().ToString("yyyy-MM-dd HH:mm"),
                manifest.RuntimeVerdict,
                FormatDelta(manifest.LegacyX2P95TimingDeltaMilliseconds),
                FormatDelta(manifest.LegacyX2MaxInputCallDeltaMilliseconds),
                ShortId(manifest.CampaignId),
                manifest.SourceType,
                manifest.CanonicalSourceFingerprint.Length <= 16
                    ? manifest.CanonicalSourceFingerprint
                    : manifest.CanonicalSourceFingerprint[..16] + "…")
        {
        }
    }
}
