using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.App;

/// <summary>
/// Read-only Support Center surface over the durable verified Legacy A/B experiment archive.
/// Reference-audio attachment is diagnostics-only: source and WAV are re-validated locally,
/// and no result can participate in playback truth or automatic engine selection.
/// </summary>
internal sealed class ArchivedBaselineExperimentsForm : Form
{
    private const long MaxReferenceWavBytes = 64L * 1024L * 1024L;

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
    private readonly Button _attachReferenceButton = new() { Text = "Attach Reference WAV...", AutoSize = true, Enabled = false };
    private readonly Button _exportReferenceButton = new() { Text = "Export Reference Evidence...", AutoSize = true, Enabled = false };
    private IReadOnlyList<PlaybackBaselineExperimentManifest> _records = Array.Empty<PlaybackBaselineExperimentManifest>();
    private PlaybackReferenceAudioExperimentEvidence? _selectedReferenceEvidence;

    public ArchivedBaselineExperimentsForm()
    {
        Text = "Verified Legacy A/B Experiment Archive";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(900, 580);
        Size = new Size(1180, 740);

        BuildLayout();
        _refreshButton.Click += (_, _) => RefreshArchive();
        _exportButton.Click += (_, _) => ExportSelected();
        _attachReferenceButton.Click += (_, _) => AttachReferenceAudio();
        _exportReferenceButton.Click += (_, _) => ExportSelectedReferenceEvidence();
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
            Text = "Completed guided Legacy 1.00x → Legacy x2 2.00x experiments retained independently of recent session history. Select an experiment to export its immutable manifest or attach a local 16-bit PCM WAV reference. Reference evidence is deterministic diagnostics only and never selects or promotes a playback engine.",
            AutoSize = true,
            MaximumSize = new Size(1100, 0),
            Padding = new Padding(0, 0, 0, 4)
        };
        var buttons = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        buttons.Controls.AddRange([_refreshButton, _exportButton, _attachReferenceButton, _exportReferenceButton]);

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
                : $"Showing {_records.Count} verified completed experiment(s), newest first. Corrupt or unverifiable archive/reference files are excluded without hiding valid evidence.";
            ShowSelectedDetails();
        }
        catch (Exception exception) when (IsDiagnosticsException(exception))
        {
            ClientDiagnostics.Log($"Archived experiment browser could not load verified evidence: {exception}");
            _records = Array.Empty<PlaybackBaselineExperimentManifest>();
            _experiments.DataSource = null;
            _details.Clear();
            _exportButton.Enabled = false;
            _attachReferenceButton.Enabled = false;
            _exportReferenceButton.Enabled = false;
            _selectedReferenceEvidence = null;
            _status.Text = $"Could not load verified experiment archive: {exception.Message}";
        }
    }

    private void ShowSelectedDetails()
    {
        if (_experiments.CurrentRow?.DataBoundItem is not ExperimentRow row)
        {
            _details.Text = "Select a verified experiment to inspect its immutable evidence.";
            _exportButton.Enabled = false;
            _attachReferenceButton.Enabled = false;
            _exportReferenceButton.Enabled = false;
            _selectedReferenceEvidence = null;
            return;
        }

        var manifest = row.Manifest;
        _exportButton.Enabled = true;
        _attachReferenceButton.Enabled = true;
        var references = PlaybackReferenceAudioExperimentArchive.ReadVerifiedForExperiment(
            PlaybackReferenceAudioExperimentArchive.ArchiveDirectoryPath,
            manifest.EvidenceSha256);
        _selectedReferenceEvidence = references.FirstOrDefault();
        _exportReferenceButton.Enabled = _selectedReferenceEvidence is not null;

        var lines = new List<string>
        {
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
            $"Verified reference evidence attached: {references.Count}"
        };

        if (_selectedReferenceEvidence is { } reference)
        {
            lines.AddRange(
            [
                $"Reference content SHA-256: {reference.ReferenceContentSha256}",
                $"Reference feature SHA-256: {reference.ReferenceFeatureSha256}",
                $"Legacy 1x coverage / P95 / tempo ratio: {reference.LegacyAlignment.MatchCoverage:P1} / {reference.LegacyAlignment.P95AbsoluteErrorMilliseconds:0.###} ms / {reference.LegacyAlignment.TempoRatio:0.###}",
                $"Legacy x2 coverage / P95 / tempo ratio: {reference.LegacyX2Alignment.MatchCoverage:P1} / {reference.LegacyX2Alignment.P95AbsoluteErrorMilliseconds:0.###} ms / {reference.LegacyX2Alignment.TempoRatio:0.###}",
                $"x2 minus Legacy coverage: {reference.LegacyX2CoverageDelta:+0.###;-0.###;0}",
                $"x2 minus Legacy P95 residual: {reference.LegacyX2P95ResidualDeltaMilliseconds:+0.###;-0.###;0} ms",
                $"x2 minus Legacy tempo-distance: {reference.LegacyX2TempoDistanceDelta:+0.###;-0.###;0}",
                $"Reference evidence SHA-256: {reference.EvidenceSha256}"
            ]);
        }

        lines.AddRange(
        [
            "",
            "Reference measurements are evidence only. They do not declare a winner, change playback settings, promote Legacy x2, authorize Roblox, or inject input."
        ]);
        _details.Text = string.Join(Environment.NewLine, lines);
    }

    private void AttachReferenceAudio()
    {
        if (_experiments.CurrentRow?.DataBoundItem is not ExperimentRow row)
        {
            return;
        }

        try
        {
            var manifest = row.Manifest;
            using var sourceDialog = new OpenFileDialog
            {
                Title = "Select the original Legacy sheet used by this experiment",
                Filter = "Legacy Roblox Piano sheets (*.txt;*.vps)|*.txt;*.vps",
                CheckFileExists = true,
                Multiselect = false
            };
            if (sourceDialog.ShowDialog(this) != DialogResult.OK)
            {
                return;
            }

            var expectedExtension = manifest.SourceType.Equals("VPS", StringComparison.OrdinalIgnoreCase) ? ".vps" : ".txt";
            if (!Path.GetExtension(sourceDialog.FileName).Equals(expectedExtension, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException($"This experiment expects a {expectedExtension} source. Select the exact original source type used for the campaign.");
            }

            var loaded = SongSourceLoader.Load(sourceDialog.FileName);
            if (loaded.SourceKind != SongSourceKind.LegacyText)
            {
                throw new InvalidDataException("Reference evidence for this protected Legacy experiment requires the original TXT/VPS source.");
            }

            var sourceFingerprint = PerformanceTrackFingerprint.ComputeSha256(loaded.Track);
            if (!string.Equals(sourceFingerprint, manifest.CanonicalSourceFingerprint, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException("Selected sheet does not match this archived experiment's canonical performance fingerprint.");
            }

            using var wavDialog = new OpenFileDialog
            {
                Title = "Select a 16-bit PCM WAV reference recording",
                Filter = "16-bit PCM WAV (*.wav)|*.wav",
                CheckFileExists = true,
                Multiselect = false
            };
            if (wavDialog.ShowDialog(this) != DialogResult.OK)
            {
                return;
            }

            var wavInfo = new FileInfo(wavDialog.FileName);
            if (wavInfo.Length <= 0 || wavInfo.Length > MaxReferenceWavBytes)
            {
                throw new InvalidDataException($"Reference WAV must be between 1 byte and {MaxReferenceWavBytes / 1024 / 1024} MB to keep analysis memory-bounded.");
            }

            var reference = ReferenceAudioAnalyzer.AnalyzeWav(File.ReadAllBytes(wavDialog.FileName));
            var evidence = PlaybackReferenceAudioExperimentEvidenceStore.Create(manifest, reference, loaded.Track);
            var archivedPath = PlaybackReferenceAudioExperimentArchive.PersistVerified(
                PlaybackReferenceAudioExperimentArchive.ArchiveDirectoryPath,
                evidence);
            var readBack = PlaybackReferenceAudioExperimentEvidenceStore.ReadAndVerify(archivedPath);
            if (!string.Equals(readBack.EvidenceSha256, evidence.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException("Archived reference evidence did not preserve the verified evidence hash.");
            }

            _selectedReferenceEvidence = readBack;
            _status.Text = $"Verified reference evidence attached. WAV bytes are not copied into diagnostics. Evidence SHA-256: {ShortId(readBack.EvidenceSha256)}…";
            ShowSelectedDetails();
        }
        catch (Exception exception) when (IsDiagnosticsException(exception))
        {
            ClientDiagnostics.Log($"Reference-audio experiment attachment failed: {exception}");
            MessageBox.Show(this, exception.Message, "Reference evidence could not be attached", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }
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
        catch (Exception exception) when (IsDiagnosticsException(exception))
        {
            ClientDiagnostics.Log($"Archived experiment export failed: {exception}");
            MessageBox.Show(this, exception.Message, "Experiment manifest could not be exported", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }
    }

    private void ExportSelectedReferenceEvidence()
    {
        if (_selectedReferenceEvidence is not { } evidence)
        {
            return;
        }

        try
        {
            using var dialog = new SaveFileDialog
            {
                Title = "Export verified reference-audio experiment evidence",
                Filter = "Reference evidence (*.legacy-ab-reference.json)|*.legacy-ab-reference.json|JSON file (*.json)|*.json",
                FileName = $"RobloxPiano-ReferenceAB-{ShortId(evidence.ExperimentEvidenceSha256)}-{ShortId(evidence.ReferenceContentSha256)}.legacy-ab-reference.json",
                AddExtension = true,
                DefaultExt = "legacy-ab-reference.json"
            };
            if (dialog.ShowDialog(this) != DialogResult.OK)
            {
                return;
            }

            PlaybackReferenceAudioExperimentArchive.ExportVerified(evidence, dialog.FileName);
            var readBack = PlaybackReferenceAudioExperimentEvidenceStore.ReadAndVerify(dialog.FileName);
            if (!string.Equals(readBack.EvidenceSha256, evidence.EvidenceSha256, StringComparison.OrdinalIgnoreCase))
            {
                throw new InvalidDataException("Exported reference evidence did not preserve the selected verified evidence hash.");
            }

            _status.Text = $"Verified reference evidence exported: {dialog.FileName}";
        }
        catch (Exception exception) when (IsDiagnosticsException(exception))
        {
            ClientDiagnostics.Log($"Reference-audio evidence export failed: {exception}");
            MessageBox.Show(this, exception.Message, "Reference evidence could not be exported", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }
    }

    private static bool IsDiagnosticsException(Exception exception)
        => exception is IOException
            or UnauthorizedAccessException
            or ArgumentException
            or FormatException
            or System.Text.Json.JsonException
            or NotSupportedException;

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
