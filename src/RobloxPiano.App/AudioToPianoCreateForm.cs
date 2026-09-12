using RobloxPiano.Audio;
using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed class AudioToPianoCreateForm : Form
{
    private readonly AudioToPianoClientJob _job = new();
    private readonly GeneratedPianoPreviewPlayer _previewPlayer = new();
    private readonly GeneratedTrackLibraryWriter _libraryWriter;
    private readonly TextBox _songIdentity = new() { Dock = DockStyle.Fill, PlaceholderText = "Song title / identity (optional)" };
    private readonly TextBox _path = new() { ReadOnly = true, Dock = DockStyle.Fill, PlaceholderText = "Choose an owned/local audio file..." };
    private readonly Button _choose = new() { Text = "Choose Audio...", AutoSize = true };
    private readonly Button _create = new() { Text = "Create Piano Version", AutoSize = true, Enabled = false };
    private readonly Button _cancel = new() { Text = "Cancel", AutoSize = true, Enabled = false };
    private readonly Button _preview = new() { Text = "Preview Full", AutoSize = true, Enabled = false };
    private readonly Button _stopPreview = new() { Text = "Stop Preview", AutoSize = true, Enabled = false };
    private readonly Button _previousReview = new() { Text = "Previous Review", AutoSize = true, Enabled = false };
    private readonly Button _previewReview = new() { Text = "Preview Original Region", AutoSize = true, Enabled = false };
    private readonly Button _nextReview = new() { Text = "Next Review", AutoSize = true, Enabled = false };
    private readonly ComboBox _repairKind = new() { DropDownStyle = ComboBoxStyle.DropDownList, Width = 175, Enabled = false };
    private readonly Button _previewRepair = new() { Text = "Preview Repair", AutoSize = true, Enabled = false };
    private readonly Button _applyRepair = new() { Text = "Apply Repair", AutoSize = true, Enabled = false };
    private readonly Button _revertRepair = new() { Text = "Revert Repair", AutoSize = true, Enabled = false };
    private readonly Button _addToLibrary = new() { Text = "Add to Library", AutoSize = true, Enabled = false };
    private readonly ProgressBar _progress = new() { Dock = DockStyle.Fill, Minimum = 0, Maximum = 100 };
    private readonly Label _status = CreateLabel("Choose an owned/local audio file. Nothing is uploaded.");
    private readonly Label _reviewStatus = CreateLabel(string.Empty);
    private readonly Label _result = CreateLabel(string.Empty);
    private CancellationTokenSource? _runCancellation;
    private PerformanceTrack? _generatedTrack;
    private AudioTranscriptionReadiness? _generatedReadiness;
    private AudioTranscriptionQualityAssessment? _baseQuality;
    private AudioTranscriptionReviewRepairSession? _repairSession;
    private IReadOnlyList<AudioTranscriptionReviewRegion> _reviewRegions = Array.Empty<AudioTranscriptionReviewRegion>();
    private int _reviewRegionIndex;
    private bool _addedToLibrary;

    public AudioToPianoCreateForm(string? suggestedTitle = null, string? preselectedAudioPath = null)
    {
        Text = "Create Piano Version";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(720, 430);
        Size = new Size(960, 600);

        var managedRoot = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "sheets");
        _libraryWriter = new GeneratedTrackLibraryWriter(managedRoot);

        AudioToPianoCreatePrefill? prefill = null;
        if (!string.IsNullOrWhiteSpace(preselectedAudioPath))
        {
            prefill = AudioToPianoCreatePrefill.From(suggestedTitle, preselectedAudioPath);
            _songIdentity.Text = prefill.SongIdentity;
        }
        else
        {
            _songIdentity.Text = AudioToPianoSongIdentity.Normalize(suggestedTitle, string.Empty);
            if (_songIdentity.Text == "Generated Piano" && string.IsNullOrWhiteSpace(suggestedTitle))
                _songIdentity.Clear();
        }

        _repairKind.Items.AddRange([
            AudioTranscriptionReviewRepairKind.MelodyPriority,
            AudioTranscriptionReviewRepairKind.SimplifiedHarmony]);
        _repairKind.SelectedIndex = 0;

        BuildLayout();
        _choose.Click += (_, _) => ChooseAudio();
        _create.Click += async (_, _) => await CreateAsync().ConfigureAwait(true);
        _cancel.Click += (_, _) => CancelCreation();
        _preview.Click += (_, _) => StartPreview();
        _stopPreview.Click += (_, _) => StopPreview();
        _previousReview.Click += (_, _) => SelectReviewRegion(-1);
        _previewReview.Click += (_, _) => StartReviewPreview();
        _nextReview.Click += (_, _) => SelectReviewRegion(1);
        _previewRepair.Click += (_, _) => StartRepairPreview();
        _applyRepair.Click += (_, _) => ApplyRepair();
        _revertRepair.Click += (_, _) => RevertRepair();
        _repairKind.SelectedIndexChanged += (_, _) => UpdateReviewControls();
        _addToLibrary.Click += (_, _) => AddToLibrary();
        FormClosing += (_, _) =>
        {
            CancelCreation();
            StopPreview();
        };

        if (prefill is not null)
            ApplyPreselectedAudio(prefill);
    }

    public string? AddedLibraryPath { get; private set; }

    private void BuildLayout()
    {
        var intro = CreateLabel(
            "Create a deterministic Roblox piano arrangement from audio you are authorized to use. " +
            "Basic Pitch runs locally; low-confidence output is surfaced for review instead of silently guessed.");

        var identityRow = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 2, AutoSize = true };
        identityRow.ColumnStyles.Add(new ColumnStyle(SizeType.AutoSize));
        identityRow.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100f));
        identityRow.Controls.Add(new Label { Text = "Song identity", AutoSize = true, Padding = new Padding(0, 6, 8, 0) }, 0, 0);
        identityRow.Controls.Add(_songIdentity, 1, 0);

        var sourceRow = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 2, AutoSize = true };
        sourceRow.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100f));
        sourceRow.ColumnStyles.Add(new ColumnStyle(SizeType.AutoSize));
        sourceRow.Controls.Add(_path, 0, 0);
        sourceRow.Controls.Add(_choose, 1, 0);

        var actions = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        actions.Controls.AddRange([_create, _cancel, _preview, _stopPreview, _addToLibrary]);

        var reviewActions = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true, WrapContents = true };
        reviewActions.Controls.AddRange([
            _previousReview,
            _previewReview,
            _nextReview,
            new Label { Text = "Repair", AutoSize = true, Padding = new Padding(8, 7, 0, 0) },
            _repairKind,
            _previewRepair,
            _applyRepair,
            _revertRepair]);

        var root = new TableLayoutPanel
        {
            Dock = DockStyle.Fill,
            Padding = new Padding(18),
            ColumnCount = 1,
            RowCount = 10
        };
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.Percent, 100f));
        root.Controls.Add(new Label { Text = "Create Piano Version", AutoSize = true, Font = new Font(Font.FontFamily, 18f, FontStyle.Bold) }, 0, 0);
        root.Controls.Add(intro, 0, 1);
        root.Controls.Add(identityRow, 0, 2);
        root.Controls.Add(sourceRow, 0, 3);
        root.Controls.Add(actions, 0, 4);
        root.Controls.Add(reviewActions, 0, 5);
        root.Controls.Add(_progress, 0, 6);
        root.Controls.Add(_status, 0, 7);
        root.Controls.Add(_reviewStatus, 0, 8);
        root.Controls.Add(_result, 0, 9);
        Controls.Add(root);
    }

    private void ApplyPreselectedAudio(AudioToPianoCreatePrefill prefill)
    {
        _path.Text = prefill.AudioPath;
        _songIdentity.Text = prefill.SongIdentity;
        ResetGeneratedResult();
        _progress.Value = 0;

        if (File.Exists(prefill.AudioPath))
        {
            _create.Enabled = true;
            _status.Text = "Ready to create from the same owned/local audio already used to verify online matches. No second file selection is required.";
        }
        else
        {
            _create.Enabled = false;
            _status.Text = "The previously selected reference audio is no longer available. Choose Audio to continue safely.";
        }
    }

    private void ChooseAudio()
    {
        using var dialog = new OpenFileDialog
        {
            Title = "Choose owned/local audio",
            Filter = "Audio files (*.wav;*.mp3;*.aiff;*.aif)|*.wav;*.mp3;*.aiff;*.aif|All files (*.*)|*.*",
            CheckFileExists = true,
            Multiselect = false
        };

        if (dialog.ShowDialog(this) != DialogResult.OK)
            return;

        StopPreview();
        _path.Text = Path.GetFullPath(dialog.FileName);
        if (string.IsNullOrWhiteSpace(_songIdentity.Text))
            _songIdentity.Text = AudioToPianoSongIdentity.Normalize(null, _path.Text);
        ResetGeneratedResult();
        _create.Enabled = true;
        _progress.Value = 0;
        _status.Text = "Ready to create a piano version locally.";
        _result.Text = string.Empty;
    }

    private async Task CreateAsync()
    {
        if (string.IsNullOrWhiteSpace(_path.Text) || _job.IsRunning)
            return;

        StopPreview();
        ResetGeneratedResult();
        _runCancellation = new CancellationTokenSource();
        SetRunning(true);
        _result.Text = string.Empty;
        var progress = new Progress<AudioToPianoClientJobSnapshot>(UpdateProgress);
        var normalizedTitle = AudioToPianoSongIdentity.Normalize(_songIdentity.Text, _path.Text);
        _songIdentity.Text = normalizedTitle;

        try
        {
            var jobResult = await _job.RunAsync(
                _path.Text,
                normalizedTitle,
                progress: progress,
                cancellationToken: _runCancellation.Token).ConfigureAwait(true);

            if (!jobResult.Succeeded || jobResult.Transcription is null)
            {
                _status.Text = jobResult.State == AudioToPianoClientJobState.Cancelled
                    ? "Creation cancelled safely. No piano version was committed."
                    : $"Creation did not complete: {jobResult.ErrorMessage ?? jobResult.State.ToString()}.";
                return;
            }

            var transcription = jobResult.Transcription;
            var track = transcription.Arrangement.Track;
            var diagnostics = transcription.Diagnostics;
            var quality = diagnostics.Quality;
            _generatedTrack = track;
            _baseQuality = diagnostics.BaseQuality;
            _generatedReadiness = quality.Readiness;
            _reviewRegions = diagnostics.ReviewRegions;
            _reviewRegionIndex = 0;

            if (_reviewRegions.Count != 0 && transcription.NoteEvidence.Count != 0)
            {
                _repairSession = new AudioTranscriptionReviewRepairSession(
                    diagnostics.SourceDuration,
                    transcription.NoteEvidence,
                    track);
                _generatedTrack = _repairSession.CurrentTrack;
                _reviewRegions = _repairSession.ReviewRegions;
                RefreshReadinessFromRepairState();
            }

            var reasons = quality.Reasons.Count == 0 ? "none" : string.Join(", ", quality.Reasons);
            _status.Text = _generatedReadiness switch
            {
                AudioTranscriptionReadiness.Ready => "Ready — deterministic quality checks passed. Preview locally, then Add to Library.",
                AudioTranscriptionReadiness.NeedsReview => "Needs review — compare the original flagged section with deterministic repair candidates, then explicitly Apply or keep the original before adding it to the Library.",
                _ => "Rejected — preview is available for diagnosis, but this result cannot be added to the Library until the global quality failure is resolved."
            };
            _result.Text =
                $"{track.Title} • {track.Events.Count} events • {track.Bpm:0.###} BPM • {FormatTime(track.TimelineDuration)}{Environment.NewLine}" +
                $"Readiness: {_generatedReadiness} • initial reasons: {reasons}{Environment.NewLine}" +
                $"Decoded notes: {diagnostics.DecodedNotes}; retained after suppression: {diagnostics.NotesAfterSuppression}; " +
                $"elapsed: {diagnostics.TotalElapsed.TotalSeconds:0.0}s.{Environment.NewLine}{Environment.NewLine}" +
                "Preview Original Region and Preview Repair are local A/B listening only and never mutate the canonical track. Only Apply Repair changes the current generated performance; Revert Repair restores the exact original. Add to Library writes only the current explicitly accepted canonical track after production MIDI round-trip verification. Roblox playback still requires the separate Runtime Input field gate.";
            UpdateReviewControls();
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException or InvalidOperationException or ArgumentException)
        {
            ClientDiagnostics.Log($"Create Piano Version failed for '{_path.Text}': {exception}");
            _status.Text = $"Could not create a piano version: {exception.Message}";
        }
        finally
        {
            _runCancellation?.Dispose();
            _runCancellation = null;
            SetRunning(false);
        }
    }

    private void StartPreview()
    {
        if (_generatedTrack is null || _job.IsRunning)
            return;

        try
        {
            var info = _previewPlayer.Play(_generatedTrack);
            _preview.Enabled = false;
            _stopPreview.Enabled = true;
            _status.Text = info.IsTruncated
                ? $"Previewing {FormatTime(info.PreviewStart)}–{FormatTime(info.PreviewEnd)} locally ({info.NoteVoices} note voices). The full generated track is {FormatTime(info.SourceDuration)}."
                : $"Previewing {FormatTime(info.PreviewStart)}–{FormatTime(info.PreviewEnd)} locally ({info.NoteVoices} note voices). No Roblox input is sent.";
            ClientDiagnostics.Log($"Generated piano local preview started: start={info.PreviewStart.TotalSeconds:0.###}s, duration={info.PreviewDuration.TotalSeconds:0.###}s, sourceDuration={info.SourceDuration.TotalSeconds:0.###}s, voices={info.NoteVoices}, truncated={info.IsTruncated}.");
            UpdateReviewControls();
        }
        catch (Exception exception) when (exception is InvalidDataException or InvalidOperationException or ArgumentException or OverflowException or NAudio.MmException)
        {
            HandlePreviewFailure(exception);
        }
    }

    private void StartReviewPreview()
    {
        if (_generatedTrack is null || _job.IsRunning || _reviewRegions.Count == 0)
            return;

        StartRegionPreview(_generatedTrack, _reviewRegions[_reviewRegionIndex], "original");
    }

    private void StartRepairPreview()
    {
        if (_repairSession is null || _job.IsRunning || _reviewRegions.Count == 0 || _repairKind.SelectedItem is not AudioTranscriptionReviewRepairKind kind)
            return;

        try
        {
            var region = _reviewRegions[_reviewRegionIndex];
            var candidate = _repairSession.PreviewCandidate(region, kind);
            StartRegionPreview(candidate.Track, region, $"repair {kind}");
        }
        catch (Exception exception) when (exception is InvalidDataException or InvalidOperationException or ArgumentException or OverflowException or NAudio.MmException)
        {
            HandlePreviewFailure(exception);
        }
    }

    private void StartRegionPreview(PerformanceTrack track, AudioTranscriptionReviewRegion region, string label)
    {
        try
        {
            var plan = GeneratedPianoReviewPreviewPlan.Create(track.TimelineDuration, region);
            var info = _previewPlayer.Play(
                track,
                new GeneratedPianoPreviewOptions(
                    MaximumPreviewDuration: plan.PreviewDuration,
                    StartOffset: plan.PreviewStart));
            _preview.Enabled = false;
            _stopPreview.Enabled = true;
            _status.Text =
                $"A/B preview ({label}) for review region {_reviewRegionIndex + 1}/{_reviewRegions.Count}: flagged {FormatTime(plan.RegionStart)}–{FormatTime(plan.RegionEnd)}; " +
                $"previewing {FormatTime(info.PreviewStart)}–{FormatTime(info.PreviewEnd)} locally with context. Preview never changes the canonical track and sends no Roblox input.";
            ClientDiagnostics.Log(
                $"Generated piano review A/B preview started: variant={label}, region={_reviewRegionIndex + 1}/{_reviewRegions.Count}, flaggedStart={plan.RegionStart.TotalSeconds:0.###}s, flaggedEnd={plan.RegionEnd.TotalSeconds:0.###}s, previewStart={info.PreviewStart.TotalSeconds:0.###}s, previewEnd={info.PreviewEnd.TotalSeconds:0.###}s, reasons={string.Join('|', region.Reasons)}.");
            UpdateReviewControls();
        }
        catch (Exception exception) when (exception is InvalidDataException or InvalidOperationException or ArgumentException or OverflowException or NAudio.MmException)
        {
            HandlePreviewFailure(exception);
        }
    }

    private void ApplyRepair()
    {
        if (_repairSession is null || _job.IsRunning || _previewPlayer.IsPlaying || _reviewRegions.Count == 0 || _repairKind.SelectedItem is not AudioTranscriptionReviewRepairKind kind)
            return;

        try
        {
            var region = _reviewRegions[_reviewRegionIndex];
            var result = _repairSession.Apply(region, kind);
            _generatedTrack = result.CurrentTrack;
            _reviewRegions = result.ReviewRegions;
            _reviewRegionIndex = _reviewRegions.Count == 0 ? 0 : Math.Min(_reviewRegionIndex, _reviewRegions.Count - 1);
            _addedToLibrary = false;
            AddedLibraryPath = null;
            RefreshReadinessFromRepairState();
            _status.Text = _reviewRegions.Count == 0
                ? $"Applied {kind} explicitly. No local review regions remain; readiness is now {_generatedReadiness}. Revert is available until you add the current track to the Library."
                : $"Applied {kind} explicitly. {_reviewRegions.Count} review region(s) remain; readiness is {_generatedReadiness}.";
            ClientDiagnostics.Log($"Generated piano repair applied explicitly: kind={kind}, revision={result.Revision}, remainingReviewRegions={result.ReviewRegions.Count}, readiness={_generatedReadiness}.");
            SetRunning(false);
        }
        catch (Exception exception) when (exception is InvalidDataException or InvalidOperationException or ArgumentException or OverflowException)
        {
            ClientDiagnostics.Log($"Generated piano repair apply failed safely: {exception}");
            _status.Text = $"Could not apply this deterministic repair: {exception.Message}";
            UpdateReviewControls();
        }
    }

    private void RevertRepair()
    {
        if (_repairSession is null || !_repairSession.CanRevert || _job.IsRunning || _previewPlayer.IsPlaying)
            return;

        try
        {
            if (!_repairSession.Revert())
                return;
            _generatedTrack = _repairSession.CurrentTrack;
            _reviewRegions = _repairSession.ReviewRegions;
            _reviewRegionIndex = 0;
            _addedToLibrary = false;
            AddedLibraryPath = null;
            RefreshReadinessFromRepairState();
            _status.Text = $"Reverted to the exact original generated performance. {_reviewRegions.Count} review region(s) are active; readiness is {_generatedReadiness}.";
            ClientDiagnostics.Log($"Generated piano repair reverted explicitly: revision={_repairSession.Revision}, reviewRegions={_reviewRegions.Count}, readiness={_generatedReadiness}.");
            SetRunning(false);
        }
        catch (Exception exception) when (exception is InvalidDataException or InvalidOperationException or ArgumentException or OverflowException)
        {
            ClientDiagnostics.Log($"Generated piano repair revert failed safely: {exception}");
            _status.Text = $"Could not revert this repair safely: {exception.Message}";
            UpdateReviewControls();
        }
    }

    private void RefreshReadinessFromRepairState()
    {
        if (_baseQuality is null)
            return;

        _generatedReadiness = _baseQuality.Readiness switch
        {
            AudioTranscriptionReadiness.Rejected => AudioTranscriptionReadiness.Rejected,
            AudioTranscriptionReadiness.NeedsReview => AudioTranscriptionReadiness.NeedsReview,
            _ => _reviewRegions.Count == 0
                ? AudioTranscriptionReadiness.Ready
                : AudioTranscriptionReadiness.NeedsReview
        };
    }

    private void SelectReviewRegion(int delta)
    {
        if (_reviewRegions.Count == 0 || _job.IsRunning || _previewPlayer.IsPlaying)
            return;

        _reviewRegionIndex = Math.Clamp(_reviewRegionIndex + delta, 0, _reviewRegions.Count - 1);
        UpdateReviewControls();
    }

    private void UpdateReviewControls()
    {
        var hasRegions = !_job.IsRunning && _generatedTrack is not null && _reviewRegions.Count != 0;
        var idle = hasRegions && !_previewPlayer.IsPlaying && !_addedToLibrary;
        _previousReview.Enabled = idle && _reviewRegionIndex > 0;
        _previewReview.Enabled = idle;
        _nextReview.Enabled = idle && _reviewRegionIndex < _reviewRegions.Count - 1;
        _repairKind.Enabled = idle && _repairSession is not null;
        _previewRepair.Enabled = idle && _repairSession is not null;
        _applyRepair.Enabled = idle && _repairSession is not null;
        _revertRepair.Enabled = !_job.IsRunning && !_previewPlayer.IsPlaying && !_addedToLibrary && _repairSession?.CanRevert == true;

        if (!hasRegions)
        {
            _reviewStatus.Text = _repairSession?.CanRevert == true
                ? $"No flagged local review regions remain after explicit repair. Current readiness: {_generatedReadiness}. Revert Repair restores the original generated performance."
                : string.Empty;
            return;
        }

        var region = _reviewRegions[_reviewRegionIndex];
        var candidates = _repairSession?.GetCandidates(region).Count ?? 0;
        _reviewStatus.Text =
            $"Flagged region {_reviewRegionIndex + 1}/{_reviewRegions.Count}: {FormatTime(region.Start)}–{FormatTime(region.End)} • " +
            $"{string.Join(", ", region.Reasons)} • activation {region.MeanActivation:0.00} • retention {region.RetentionRatio:P0} • " +
            $"{candidates} deterministic repair candidate(s). Preview is side-effect free; Apply is explicit.";
    }

    private void HandlePreviewFailure(Exception exception)
    {
        ClientDiagnostics.Log($"Generated piano local preview failed safely: {exception}");
        _status.Text = $"Could not preview this piano version on the current Windows audio device or selected timeline: {exception.Message}";
        _preview.Enabled = _generatedTrack is not null;
        _stopPreview.Enabled = false;
        UpdateReviewControls();
    }

    private void StopPreview()
    {
        if (_previewPlayer.IsPlaying)
            ClientDiagnostics.Log("Generated piano local preview stopped.");
        _previewPlayer.Stop();
        _stopPreview.Enabled = false;
        _preview.Enabled = !_job.IsRunning && _generatedTrack is not null;
        UpdateReviewControls();
    }

    private void AddToLibrary()
    {
        if (_generatedTrack is null || _generatedReadiness is null || _generatedReadiness == AudioTranscriptionReadiness.Rejected || _addedToLibrary)
            return;

        if (_generatedReadiness == AudioTranscriptionReadiness.NeedsReview)
        {
            var decision = MessageBox.Show(
                this,
                "This piano version still has deterministic quality warnings shown on this screen. Add this reviewed result to your Library anyway?",
                "Add reviewed piano version?",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning,
                MessageBoxDefaultButton.Button2);
            if (decision != DialogResult.Yes)
                return;
        }

        try
        {
            var saved = _libraryWriter.Add(_generatedTrack);
            _addedToLibrary = true;
            AddedLibraryPath = saved.Path;
            _addToLibrary.Enabled = false;
            _status.Text = $"Added to Library as {Path.GetFileName(saved.Path)} — {saved.NoteCount} notes, {saved.ByteCount:N0} bytes, production MIDI round-trip verified.";
            ClientDiagnostics.Log($"Generated piano version committed to Library after MIDI round-trip verification: file='{Path.GetFileName(saved.Path)}', notes={saved.NoteCount}, bytes={saved.ByteCount}, repairRevision={_repairSession?.Revision ?? 0}.");
            UpdateReviewControls();
        }
        catch (Exception exception) when (exception is IOException or UnauthorizedAccessException or InvalidDataException or InvalidOperationException or ArgumentException or OverflowException)
        {
            ClientDiagnostics.Log($"Generated piano Library commit failed safely: {exception}");
            _status.Text = $"Could not add this piano version to the Library: {exception.Message}";
        }
    }

    private void UpdateProgress(AudioToPianoClientJobSnapshot snapshot)
    {
        var percent = Math.Clamp((int)Math.Round(snapshot.Fraction * 100d), 0, 100);
        _progress.Value = percent;
        _status.Text = $"{snapshot.Message} ({percent}%)";
    }

    private void CancelCreation()
    {
        if (_runCancellation is { IsCancellationRequested: false })
        {
            _status.Text = "Cancelling safely...";
            _runCancellation.Cancel();
        }
        _job.Cancel();
    }

    private void ResetGeneratedResult()
    {
        _generatedTrack = null;
        _generatedReadiness = null;
        _baseQuality = null;
        _repairSession = null;
        _reviewRegions = Array.Empty<AudioTranscriptionReviewRegion>();
        _reviewRegionIndex = 0;
        _addedToLibrary = false;
        AddedLibraryPath = null;
        _preview.Enabled = false;
        _stopPreview.Enabled = false;
        _addToLibrary.Enabled = false;
        UpdateReviewControls();
    }

    private void SetRunning(bool running)
    {
        _choose.Enabled = !running;
        _songIdentity.Enabled = !running;
        _create.Enabled = !running && !string.IsNullOrWhiteSpace(_path.Text);
        _cancel.Enabled = running;
        _preview.Enabled = !running && _generatedTrack is not null && !_previewPlayer.IsPlaying;
        _stopPreview.Enabled = !running && _previewPlayer.IsPlaying;
        _addToLibrary.Enabled = !running
            && !_addedToLibrary
            && _generatedTrack is not null
            && _generatedReadiness is not null
            && _generatedReadiness != AudioTranscriptionReadiness.Rejected;
        UpdateReviewControls();
    }

    protected override void Dispose(bool disposing)
    {
        if (disposing)
        {
            _runCancellation?.Cancel();
            _runCancellation?.Dispose();
            _previewPlayer.Dispose();
            _job.Dispose();
        }
        base.Dispose(disposing);
    }

    private static Label CreateLabel(string text) => new()
    {
        Text = text,
        AutoSize = true,
        MaximumSize = new Size(900, 0),
        Padding = new Padding(0, 5, 0, 5)
    };

    private static string FormatTime(TimeSpan value)
        => value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");
}
