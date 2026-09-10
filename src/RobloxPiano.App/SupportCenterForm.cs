namespace RobloxPiano.App;

internal sealed class SupportCenterForm : Form
{
    private readonly DataGridView _sessions = new()
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
    private readonly Label _status = new() { AutoSize = true, Padding = new Padding(0, 6, 0, 6) };
    private readonly Button _refreshButton = new() { Text = "Refresh", AutoSize = true };
    private readonly Button _saveBundleButton = new() { Text = "Save Support Bundle...", AutoSize = true };
    private IReadOnlyList<PlaybackSupportSession> _records = Array.Empty<PlaybackSupportSession>();

    public SupportCenterForm()
    {
        Text = "Roblox Piano Support Center";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(940, 600);
        Size = new Size(1200, 740);

        BuildLayout();
        _refreshButton.Click += (_, _) => RefreshSessions();
        _saveBundleButton.Click += (_, _) => SaveSupportBundle();
        _sessions.SelectionChanged += (_, _) => ShowSelectedDetails();
        Shown += (_, _) => RefreshSessions();
    }

    private void BuildLayout()
    {
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "When", DataPropertyName = nameof(SessionRow.When), Width = 145 });
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Outcome", DataPropertyName = nameof(SessionRow.Outcome), Width = 115 });
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Quality", DataPropertyName = nameof(SessionRow.QualityVerdict), Width = 110 });
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "A/B", DataPropertyName = nameof(SessionRow.Comparison), Width = 105 });
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Song", DataPropertyName = nameof(SessionRow.Song), AutoSizeMode = DataGridViewAutoSizeColumnMode.Fill, FillWeight = 34 });
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Type", DataPropertyName = nameof(SessionRow.SourceType), Width = 75 });
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Position", DataPropertyName = nameof(SessionRow.Position), Width = 75 });
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "P95", DataPropertyName = nameof(SessionRow.P95Timing), Width = 75 });
        _sessions.Columns.Add(new DataGridViewTextBoxColumn { HeaderText = "Roblox PID", DataPropertyName = nameof(SessionRow.RobloxPid), Width = 85 });

        var title = new Label { Text = "Session Diagnostics", AutoSize = true, Font = new Font(Font.FontFamily, 18f, FontStyle.Bold) };
        var subtitle = new Label
        {
            Text = "Recent playback outcomes, deterministic quality verdicts and canonical-identity-controlled A/B evidence. Full sheet paths, source bytes, raw logs and raw key-by-key samples are excluded from the support bundle.",
            AutoSize = true,
            MaximumSize = new Size(1130, 0),
            Padding = new Padding(0, 0, 0, 4)
        };
        var buttons = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        buttons.Controls.AddRange([_refreshButton, _saveBundleButton]);

        var split = new SplitContainer { Dock = DockStyle.Fill, Orientation = Orientation.Horizontal, SplitterDistance = 340 };
        split.Panel1.Controls.Add(_sessions);
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

    private void RefreshSessions()
    {
        try
        {
            var diagnostics = PlaybackSessionDiagnostics.ReadRecentRecords(ClientDiagnostics.DirectoryPath);
            var document = PlaybackSessionDiagnostics.CreateSupportDocument(diagnostics, DateTimeOffset.UtcNow);
            _records = document.Sessions;
            _sessions.DataSource = _records.Select(record => new SessionRow(record, _records)).ToList();
            _status.Text = _records.Count == 0
                ? "No playback sessions have been recorded yet. Play a song, then return here."
                : $"Showing {_records.Count} recent session(s). A/B requires the same canonical performance, source type, playback engine, input profile, speed and input-latency settings. Latest support bundle: {PlaybackSessionDiagnostics.SupportBundlePath}";
            ShowSelectedDetails();
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or ArgumentException or System.Text.Json.JsonException)
        {
            ClientDiagnostics.Log($"Support Center could not load session history: {exception}");
            _status.Text = $"Could not load session diagnostics: {exception.Message}";
            _records = Array.Empty<PlaybackSupportSession>();
            _sessions.DataSource = null;
            _details.Clear();
        }
    }

    private void ShowSelectedDetails()
    {
        if (_sessions.CurrentRow?.DataBoundItem is not SessionRow row)
        {
            _details.Text = "Select a session to inspect its deterministic support evidence.";
            return;
        }

        var record = row.Record;
        var quality = record.Quality;
        var assessment = PlaybackSessionQualityAssessmentPolicy.Assess(quality);
        var comparison = PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(record, _records);
        var lines = new[]
        {
            $"Outcome: {record.ResultKind}",
            $"Quality verdict: {assessment.Verdict}",
            $"Quality summary: {assessment.Summary}",
            $"Client guidance: {assessment.Guidance}",
            "",
            $"Controlled A/B verdict: {comparison.Verdict}",
            $"A/B summary: {comparison.Summary}",
            $"A/B guidance: {comparison.Guidance}",
            $"Baseline session: {comparison.BaselineSessionId ?? "(none)"}",
            comparison.P95TimingDeltaMilliseconds is null ? string.Empty : $"P95 timing delta vs baseline: {comparison.P95TimingDeltaMilliseconds:+0.###;-0.###;0} ms",
            comparison.MaxInputCallDeltaMilliseconds is null ? string.Empty : $"Max input-call delta vs baseline: {comparison.MaxInputCallDeltaMilliseconds:+0.###;-0.###;0} ms",
            "",
            $"Started (UTC): {record.StartedAtUtc:O}",
            $"Ended (UTC): {record.EndedAtUtc:O}",
            $"Song: {record.SourceFileName ?? "(unknown)"}",
            $"Source type: {record.SourceType}",
            $"Canonical performance fingerprint: {DisplayFingerprint(record.CanonicalSourceFingerprint)}",
            $"Playback engine: {record.PlaybackEngine}",
            $"Input profile: {record.InputProfile}",
            $"Final position: {TimeSpan.FromSeconds(Math.Max(0d, record.PositionSeconds)):mm\\:ss\\.fff}",
            $"Preferred speed at session end: {record.PreferredSpeed:0.###}x",
            $"Input latency compensation: {record.InputLatencyMs} ms",
            $"Roblox PID: {(record.RobloxProcessId?.ToString() ?? "(none)")}",
            $"Roblox process start ticks: {(record.RobloxProcessStartTimeUtcTicks?.ToString() ?? "(none)")}",
            $"Authorization failure: {record.AuthorizationFailure ?? "(none)"}",
            "",
            "Playback quality:",
            quality is null ? "  Not captured by this client version/session." : $"  Segments: {quality.SegmentCount} (seeks: {quality.SeekCount})",
            quality is null ? string.Empty : $"  Dispatched edges: {quality.DispatchedEdgeCount}",
            quality is null ? string.Empty : $"  Unexpected missing edges: {quality.UnexpectedMissingEdgeCount}",
            quality is null ? string.Empty : $"  Interrupted edges (seek/stop/failure boundary): {quality.InterruptedEdgeCount}",
            quality is null ? string.Empty : $"  Playback failures: {quality.FailureCount}",
            quality is null ? string.Empty : $"  Focus pauses: {quality.FocusPauseCount} / {quality.FocusPausedMilliseconds:0.###} ms",
            quality is null ? string.Empty : $"  Timing error mean abs / p95 / max: {quality.MeanAbsoluteTimingErrorMilliseconds:0.###} / {quality.P95AbsoluteTimingErrorMilliseconds:0.###} / {quality.MaxAbsoluteTimingErrorMilliseconds:0.###} ms",
            quality is null ? string.Empty : $"  Input call mean / max: {quality.MeanInputCallMilliseconds:0.###} / {quality.MaxInputCallMilliseconds:0.###} ms",
            quality is null ? string.Empty : $"  Release-all count: {quality.ReleaseAllCount}",
            "",
            $"Exception type: {record.ExceptionType ?? "(none)"}",
            $"Exception: {record.ExceptionMessage ?? "(none)"}"
        };
        _details.Text = string.Join(Environment.NewLine, lines.Where(line => line.Length > 0));
    }

    private void SaveSupportBundle()
    {
        try
        {
            using var dialog = new SaveFileDialog
            {
                Title = "Save Roblox Piano support bundle",
                Filter = "ZIP archive (*.zip)|*.zip",
                FileName = "RobloxPiano-support.zip",
                AddExtension = true,
                DefaultExt = "zip"
            };
            if (dialog.ShowDialog(this) != DialogResult.OK)
            {
                return;
            }

            SupportBundleExport.CreateAndExportVerified(
                ClientDiagnostics.DirectoryPath,
                PlaybackSessionDiagnostics.SupportBundlePath,
                dialog.FileName,
                DateTimeOffset.UtcNow);

            _status.Text = $"Verified support bundle saved: {dialog.FileName}";
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or ArgumentException or System.Text.Json.JsonException or NotSupportedException)
        {
            ClientDiagnostics.Log($"Support Center could not save support bundle: {exception}");
            MessageBox.Show(this, exception.Message, "Support bundle could not be saved", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }
    }

    private static string DisplayFingerprint(string? fingerprint)
        => string.IsNullOrWhiteSpace(fingerprint)
            ? "(not captured; older/unavailable session is not A/B comparable)"
            : fingerprint.Length <= 16 ? fingerprint : fingerprint[..16] + "…";

    private sealed record SessionRow(
        PlaybackSupportSession Record,
        string When,
        string Outcome,
        string QualityVerdict,
        string Comparison,
        string Song,
        string SourceType,
        string Position,
        string P95Timing,
        string RobloxPid)
    {
        public SessionRow(PlaybackSupportSession record, IReadOnlyList<PlaybackSupportSession> sessions)
            : this(
                record,
                record.EndedAtUtc.ToLocalTime().ToString("yyyy-MM-dd HH:mm"),
                record.ResultKind,
                PlaybackSessionQualityAssessmentPolicy.Assess(record.Quality).Verdict.ToString(),
                PlaybackSessionComparisonPolicy.CompareWithMostRecentCompatible(record, sessions).Verdict.ToString(),
                record.SourceFileName ?? "(unknown)",
                record.SourceType,
                TimeSpan.FromSeconds(Math.Max(0d, record.PositionSeconds)).ToString(@"mm\:ss"),
                record.Quality is null ? "—" : $"{record.Quality.P95AbsoluteTimingErrorMilliseconds:0.#} ms",
                record.RobloxProcessId?.ToString() ?? "—")
        {
        }
    }
}
