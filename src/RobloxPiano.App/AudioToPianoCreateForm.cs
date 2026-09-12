using RobloxPiano.Audio;
using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed class AudioToPianoCreateForm : Form
{
    private readonly AudioToPianoClientJob _job = new();
    private readonly GeneratedPianoPreviewPlayer _previewPlayer = new();
    private readonly GeneratedTrackLibraryWriter _libraryWriter;
    private readonly TextBox _path = new() { ReadOnly = true, Dock = DockStyle.Fill, PlaceholderText = "Choose an owned/local audio file..." };
    private readonly Button _choose = new() { Text = "Choose Audio...", AutoSize = true };
    private readonly Button _create = new() { Text = "Create Piano Version", AutoSize = true, Enabled = false };
    private readonly Button _cancel = new() { Text = "Cancel", AutoSize = true, Enabled = false };
    private readonly Button _preview = new() { Text = "Preview", AutoSize = true, Enabled = false };
    private readonly Button _stopPreview = new() { Text = "Stop Preview", AutoSize = true, Enabled = false };
    private readonly Button _addToLibrary = new() { Text = "Add to Library", AutoSize = true, Enabled = false };
    private readonly ProgressBar _progress = new() { Dock = DockStyle.Fill, Minimum = 0, Maximum = 100 };
    private readonly Label _status = CreateLabel("Choose an owned/local audio file. Nothing is uploaded.");
    private readonly Label _result = CreateLabel(string.Empty);
    private CancellationTokenSource? _runCancellation;
    private PerformanceTrack? _generatedTrack;
    private AudioTranscriptionReadiness? _generatedReadiness;
    private bool _addedToLibrary;

    public AudioToPianoCreateForm()
    {
        Text = "Create Piano Version";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(680, 360);
        Size = new Size(780, 450);

        var managedRoot = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "sheets");
        _libraryWriter = new GeneratedTrackLibraryWriter(managedRoot);

        BuildLayout();
        _choose.Click += (_, _) => ChooseAudio();
        _create.Click += async (_, _) => await CreateAsync().ConfigureAwait(true);
        _cancel.Click += (_, _) => CancelCreation();
        _preview.Click += (_, _) => StartPreview();
        _stopPreview.Click += (_, _) => StopPreview();
        _addToLibrary.Click += (_, _) => AddToLibrary();
        FormClosing += (_, _) =>
        {
            CancelCreation();
            StopPreview();
        };
    }

    private void BuildLayout()
    {
        var intro = CreateLabel(
            "Create a deterministic Roblox piano arrangement from audio you are authorized to use. " +
            "Basic Pitch runs locally; low-confidence output is surfaced for review instead of silently guessed.");

        var sourceRow = new TableLayoutPanel { Dock = DockStyle.Fill, ColumnCount = 2, AutoSize = true };
        sourceRow.ColumnStyles.Add(new ColumnStyle(SizeType.Percent, 100f));
        sourceRow.ColumnStyles.Add(new ColumnStyle(SizeType.AutoSize));
        sourceRow.Controls.Add(_path, 0, 0);
        sourceRow.Controls.Add(_choose, 1, 0);

        var actions = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        actions.Controls.AddRange([_create, _cancel, _preview, _stopPreview, _addToLibrary]);

        var root = new TableLayoutPanel
        {
            Dock = DockStyle.Fill,
            Padding = new Padding(18),
            ColumnCount = 1,
            RowCount = 7
        };
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.AutoSize));
        root.RowStyles.Add(new RowStyle(SizeType.Percent, 100f));
        root.Controls.Add(new Label { Text = "Create Piano Version", AutoSize = true, Font = new Font(Font.FontFamily, 18f, FontStyle.Bold) }, 0, 0);
        root.Controls.Add(intro, 0, 1);
        root.Controls.Add(sourceRow, 0, 2);
        root.Controls.Add(actions, 0, 3);
        root.Controls.Add(_progress, 0, 4);
        root.Controls.Add(_status, 0, 5);
        root.Controls.Add(_result, 0, 6);
        Controls.Add(root);
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

        try
        {
            var jobResult = await _job.RunAsync(
                _path.Text,
                Path.GetFileNameWithoutExtension(_path.Text),
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
            var quality = transcription.Diagnostics.Quality;
            _generatedTrack = track;
            _generatedReadiness = quality.Readiness;
            var reasons = quality.Reasons.Count == 0 ? "none" : string.Join(", ", quality.Reasons);
            _status.Text = quality.Readiness switch
            {
                AudioTranscriptionReadiness.Ready => "Ready — deterministic quality checks passed. Preview locally, then Add to Library.",
                AudioTranscriptionReadiness.NeedsReview => "Needs review — warnings must stay visible. Preview before deciding whether to Add to Library.",
                _ => "Rejected — preview is available for diagnosis, but this result cannot be added to the Library until repaired."
            };
            _result.Text =
                $"{track.Title} • {track.Events.Count} events • {track.Bpm:0.###} BPM • {FormatTime(track.TimelineDuration)}{Environment.NewLine}" +
                $"Readiness: {quality.Readiness} • reasons: {reasons}{Environment.NewLine}" +
                $"Decoded notes: {transcription.Diagnostics.DecodedNotes}; retained after suppression: {transcription.Diagnostics.NotesAfterSuppression}; " +
                $"elapsed: {transcription.Diagnostics.TotalElapsed.TotalSeconds:0.0}s.{Environment.NewLine}{Environment.NewLine}" +
                "Preview synthesizes the canonical generated piano locally and never sends Roblox keys. Add to Library writes a standards-compliant MIDI, then re-imports it through the production MIDI parser and refuses the commit if note/timing parity fails. Roblox playback still requires the separate Runtime Input field gate.";
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
                ? $"Previewing the first {FormatTime(info.PreviewDuration)} locally ({info.NoteVoices} note voices). The full generated track is {FormatTime(info.SourceDuration)}."
                : $"Previewing {FormatTime(info.PreviewDuration)} locally ({info.NoteVoices} note voices). No Roblox input is sent.";
            ClientDiagnostics.Log($"Generated piano local preview started: duration={info.PreviewDuration.TotalSeconds:0.###}s, sourceDuration={info.SourceDuration.TotalSeconds:0.###}s, voices={info.NoteVoices}, truncated={info.IsTruncated}.");
        }
        catch (Exception exception) when (exception is InvalidDataException or InvalidOperationException or ArgumentException or OverflowException or NAudio.MmException)
        {
            ClientDiagnostics.Log($"Generated piano local preview failed safely: {exception}");
            _status.Text = $"Could not preview this piano version on the current Windows audio device: {exception.Message}";
            _preview.Enabled = _generatedTrack is not null;
            _stopPreview.Enabled = false;
        }
    }

    private void StopPreview()
    {
        if (_previewPlayer.IsPlaying)
            ClientDiagnostics.Log("Generated piano local preview stopped.");
        _previewPlayer.Stop();
        _stopPreview.Enabled = false;
        _preview.Enabled = !_job.IsRunning && _generatedTrack is not null;
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
            _addToLibrary.Enabled = false;
            _status.Text = $"Added to Library as {Path.GetFileName(saved.Path)} — {saved.NoteCount} notes, {saved.ByteCount:N0} bytes, production MIDI round-trip verified.";
            ClientDiagnostics.Log($"Generated piano version committed to Library after MIDI round-trip verification: file='{Path.GetFileName(saved.Path)}', notes={saved.NoteCount}, bytes={saved.ByteCount}.");
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
        _addedToLibrary = false;
        _preview.Enabled = false;
        _stopPreview.Enabled = false;
        _addToLibrary.Enabled = false;
    }

    private void SetRunning(bool running)
    {
        _choose.Enabled = !running;
        _create.Enabled = !running && !string.IsNullOrWhiteSpace(_path.Text);
        _cancel.Enabled = running;
        _preview.Enabled = !running && _generatedTrack is not null && !_previewPlayer.IsPlaying;
        _stopPreview.Enabled = !running && _previewPlayer.IsPlaying;
        _addToLibrary.Enabled = !running
            && !_addedToLibrary
            && _generatedTrack is not null
            && _generatedReadiness is not null
            && _generatedReadiness != AudioTranscriptionReadiness.Rejected;
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
        MaximumSize = new Size(720, 0),
        Padding = new Padding(0, 5, 0, 5)
    };

    private static string FormatTime(TimeSpan value)
        => value.TotalHours >= 1d ? value.ToString(@"hh\:mm\:ss") : value.ToString(@"mm\:ss");
}
