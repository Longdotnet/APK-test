using System.Diagnostics;
using RobloxPiano.Audio;
using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed class OnlineSongDiscoveryController : IDisposable
{
    private const int ReferenceBatchSize = 5;

    private readonly TextBox _searchBox;
    private readonly Action<string> _onImported;
    private readonly HttpClient _httpClient = new() { Timeout = Timeout.InfiniteTimeSpan };
    private readonly SongDiscoveryService _discovery;
    private readonly OnlineSongImportService _importer;
    private readonly OnlineSongReferenceVerificationService _referenceVerifier;
    private readonly ReferenceAudioFileAnalysisService _referenceAnalyzer = new();
    private readonly Dictionary<string, ReferenceCandidateAssessment> _referenceAssessments = new(StringComparer.Ordinal);
    private readonly System.Windows.Forms.Timer _debounce = new() { Interval = 650 };
    private readonly TableLayoutPanel _panel = new()
    {
        Dock = DockStyle.Fill,
        AutoSize = true,
        ColumnCount = 1,
        RowCount = 3,
        Visible = false,
        Padding = new Padding(0, 4, 0, 6)
    };
    private readonly Label _status = new() { AutoSize = true, Padding = new Padding(0, 2, 0, 4) };
    private readonly ListBox _results = new()
    {
        Dock = DockStyle.Fill,
        Height = 155,
        IntegralHeight = false,
        DisplayMember = nameof(SongDiscoveryCandidate.DisplayText),
        HorizontalScrollbar = true
    };
    private readonly Button _addButton = new() { Text = "Add to Library", AutoSize = true, Enabled = false };
    private readonly Button _verifyButton = new() { Text = "Verify top matches with my audio...", AutoSize = true, Enabled = false };
    private readonly Button _createFromReferenceButton = new()
    {
        Text = "Create Piano Version from this audio",
        AutoSize = true,
        Enabled = false,
        Visible = false
    };
    private readonly Button _sourceButton = new() { Text = "View Source", AutoSize = true, Enabled = false };

    private CancellationTokenSource? _searchCancellation;
    private CancellationTokenSource? _importCancellation;
    private CancellationTokenSource? _verificationCancellation;
    private string? _verifiedReferenceAudioPath;
    private bool _referenceFallbackRecommended;
    private bool _disposed;

    public OnlineSongDiscoveryController(
        TextBox searchBox,
        SheetLibraryService library,
        Action<string> onImported)
    {
        _searchBox = searchBox ?? throw new ArgumentNullException(nameof(searchBox));
        ArgumentNullException.ThrowIfNull(library);
        _onImported = onImported ?? throw new ArgumentNullException(nameof(onImported));

        var cacheRoot = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData),
            "RobloxPiano",
            "discovery-cache");
        _discovery = new SongDiscoveryService(
            [new WikimediaCommonsMidiProvider(_httpClient), new InternetArchiveMidiProvider(_httpClient)],
            new JsonSongDiscoveryCache(cacheRoot));
        _importer = new OnlineSongImportService(_httpClient, library);
        _referenceVerifier = new OnlineSongReferenceVerificationService(_httpClient);

        var actions = new FlowLayoutPanel { Dock = DockStyle.Fill, AutoSize = true };
        actions.Controls.AddRange([_addButton, _verifyButton, _createFromReferenceButton, _sourceButton]);
        _panel.Controls.Add(_status, 0, 0);
        _panel.Controls.Add(_results, 0, 1);
        _panel.Controls.Add(actions, 0, 2);

        _searchBox.TextChanged += HandleSearchTextChanged;
        _searchBox.KeyDown += HandleSearchKeyDown;
        _debounce.Tick += HandleDebounceTick;
        _results.SelectedIndexChanged += (_, _) => UpdateActions();
        _results.DoubleClick += async (_, _) => await ImportSelectedAsync().ConfigureAwait(true);
        _addButton.Click += async (_, _) => await ImportSelectedAsync().ConfigureAwait(true);
        _verifyButton.Click += async (_, _) => await VerifyTopCandidatesAsync().ConfigureAwait(true);
        _createFromReferenceButton.Click += (_, _) => CreateFromVerifiedReference();
        _sourceButton.Click += (_, _) => OpenSelectedSource();
    }

    public Control View => _panel;

    private void HandleSearchTextChanged(object? sender, EventArgs eventArgs)
    {
        _debounce.Stop();
        CancelSearch();
        CancelVerification();
        ResetReferenceHandoff();
        _referenceAssessments.Clear();
        var query = _searchBox.Text.Trim();
        if (query.Length < 2)
        {
            ClearResults();
            return;
        }

        _panel.Visible = true;
        _status.Text = "Searching your library now; online matches will appear here automatically…";
        _results.DataSource = null;
        UpdateActions();
        _debounce.Start();
    }

    private void HandleSearchKeyDown(object? sender, KeyEventArgs eventArgs)
    {
        if (eventArgs.KeyCode != Keys.Enter || _searchBox.Text.Trim().Length < 2)
            return;

        eventArgs.SuppressKeyPress = true;
        _debounce.Stop();
        _ = SearchOnlineAsync();
    }

    private async void HandleDebounceTick(object? sender, EventArgs eventArgs)
    {
        _debounce.Stop();
        await SearchOnlineAsync().ConfigureAwait(true);
    }

    private async Task SearchOnlineAsync()
    {
        if (_disposed)
            return;

        var query = _searchBox.Text.Trim();
        if (query.Length < 2)
        {
            ClearResults();
            return;
        }

        CancelSearch();
        CancelVerification();
        ResetReferenceHandoff();
        _referenceAssessments.Clear();
        var cancellation = new CancellationTokenSource();
        _searchCancellation = cancellation;
        _panel.Visible = true;
        _status.Text = "Searching online…";
        _results.DataSource = null;
        UpdateActions();

        try
        {
            var result = await _discovery.SearchAsync(query, 10, cancellation.Token).ConfigureAwait(true);
            if (cancellation.IsCancellationRequested || _disposed || !query.Equals(_searchBox.Text.Trim(), StringComparison.Ordinal))
                return;

            _results.DataSource = result.Candidates.ToList();
            if (result.Candidates.Count > 0)
            {
                _status.Text = result.UsedCache
                    ? $"Network unavailable — showing {result.Candidates.Count} recent cached match(es). Verify top matches with one owned/local audio reference before trusting recording equivalence."
                    : $"{result.Candidates.Count} online match(es). Metadata is not recording proof; Verify top matches analyzes your audio once and deterministically reranks up to {ReferenceBatchSize} candidates.";
            }
            else if (result.ProviderErrors.Count > 0)
            {
                _status.Text = "Online search is unavailable right now. Your local Library and Create Piano Version still work normally.";
            }
            else
            {
                _status.Text = "No online MIDI match found. Use Create Piano Version with audio you are authorized to use.";
            }

            foreach (var error in result.ProviderErrors)
                ClientDiagnostics.Log("Online discovery provider: " + error);
            UpdateActions();
        }
        catch (OperationCanceledException) when (cancellation.IsCancellationRequested)
        {
        }
        catch (Exception exception) when (exception is ArgumentException or IOException or UnauthorizedAccessException)
        {
            ClientDiagnostics.Log($"Online discovery failed: {exception}");
            if (!_disposed)
                _status.Text = "Online search is unavailable right now. Your local Library and playback still work normally.";
        }
        finally
        {
            if (ReferenceEquals(_searchCancellation, cancellation))
                _searchCancellation = null;
            cancellation.Dispose();
        }
    }

    private async Task VerifyTopCandidatesAsync()
    {
        if (_disposed)
            return;

        var candidates = _results.Items
            .Cast<SongDiscoveryCandidate>()
            .Take(ReferenceBatchSize)
            .ToArray();
        if (candidates.Length == 0)
            return;

        using var dialog = new OpenFileDialog
        {
            Title = "Choose owned/local reference audio once for the top matches",
            Filter = "Audio files (*.wav;*.mp3;*.aiff;*.aif)|*.wav;*.mp3;*.aiff;*.aif|All files (*.*)|*.*",
            CheckFileExists = true,
            Multiselect = false
        };
        if (dialog.ShowDialog(_panel.FindForm()) != DialogResult.OK)
            return;

        var referenceAudioPath = Path.GetFullPath(dialog.FileName);
        CancelVerification();
        ResetReferenceHandoff();
        var cancellation = new CancellationTokenSource(TimeSpan.FromSeconds(90));
        _verificationCancellation = cancellation;
        _referenceAssessments.Clear();
        UpdateActions();
        _status.Text = $"Analyzing your audio locally once, then verifying up to {candidates.Length} top MIDI match(es)… Nothing is uploaded or added to Library.";

        try
        {
            var reference = await Task.Run(
                () => _referenceAnalyzer.AnalyzeFile(referenceAudioPath, cancellation.Token),
                cancellation.Token).ConfigureAwait(true);
            var batch = await _referenceVerifier.VerifyBatchAsync(
                candidates,
                reference,
                ReferenceBatchSize,
                cancellation.Token).ConfigureAwait(true);
            if (_disposed || cancellation.IsCancellationRequested)
                return;

            foreach (var verified in batch.RankedVerifiedCandidates)
            {
                _referenceAssessments[CandidateKey(verified.Candidate)] = verified.Assessment;
                ClientDiagnostics.Log(
                    $"Batch reference verification: provider='{verified.Candidate.ProviderId}', title='{verified.Candidate.Title}', verdict={verified.Assessment.Verdict}, score={verified.Assessment.ConfidenceScore}, reason={verified.Assessment.ReasonCode}, coverage={verified.Assessment.MatchCoverage:0.###}, meanMs={verified.Assessment.MeanAbsoluteErrorMilliseconds:0.###}, p95Ms={verified.Assessment.P95AbsoluteErrorMilliseconds:0.###}, evidence={verified.Assessment.EvidenceSha256}.");
            }
            foreach (var failure in batch.Failures)
            {
                ClientDiagnostics.Log(
                    $"Batch reference verification candidate failed safely: provider='{failure.Candidate.ProviderId}', title='{failure.Candidate.Title}', error='{failure.Error}'.");
            }

            var current = _results.Items.Cast<SongDiscoveryCandidate>().ToArray();
            var verifiedKeys = batch.RankedVerifiedCandidates
                .Select(item => CandidateKey(item.Candidate))
                .ToHashSet(StringComparer.Ordinal);
            var ordered = batch.RankedVerifiedCandidates
                .Select(item => item.Candidate)
                .Concat(current.Where(candidate => !verifiedKeys.Contains(CandidateKey(candidate))))
                .ToList();
            _results.DataSource = ordered;
            if (_results.Items.Count > 0)
                _results.SelectedIndex = 0;

            var high = batch.RankedVerifiedCandidates.Count(item => item.Assessment.Verdict == ReferenceCandidateVerdict.HighConfidence);
            var review = batch.RankedVerifiedCandidates.Count(item => item.Assessment.Verdict == ReferenceCandidateVerdict.Review);
            var mismatch = batch.RankedVerifiedCandidates.Count(item => item.Assessment.Verdict == ReferenceCandidateVerdict.Mismatch);
            _verifiedReferenceAudioPath = referenceAudioPath;
            _referenceFallbackRecommended = high == 0;
            _status.Text = high > 0
                ? $"Verified {batch.AttemptedCount} top match(es) from one local reference: {high} High confidence, {review} Review, {mismatch} Mismatch, {batch.Failures.Count} failed safely. Highest evidence-backed matches are now first; Add Verified Match is enabled only for High confidence."
                : $"Verified {batch.AttemptedCount} top match(es) from one local reference: no High-confidence source ({review} Review, {mismatch} Mismatch, {batch.Failures.Count} failed safely). Create Piano Version from this audio reuses the same local file without asking you to choose it again.";
            UpdateActions();
        }
        catch (OperationCanceledException) when (cancellation.IsCancellationRequested)
        {
            ResetReferenceHandoff();
            if (!_disposed)
                _status.Text = "Reference batch verification was cancelled or timed out. Nothing was added to your Library.";
        }
        catch (Exception exception) when (
            exception is HttpRequestException
            or IOException
            or UnauthorizedAccessException
            or FormatException
            or InvalidDataException
            or InvalidOperationException
            or NotSupportedException
            or OverflowException
            or NAudio.MmException)
        {
            ResetReferenceHandoff();
            ClientDiagnostics.Log($"Reference batch verification failed safely: {exception}");
            if (!_disposed)
                _status.Text = $"Could not verify the top matches safely: {exception.Message} Nothing was added; use Create Piano Version or try again.";
        }
        finally
        {
            if (ReferenceEquals(_verificationCancellation, cancellation))
                _verificationCancellation = null;
            cancellation.Dispose();
            UpdateActions();
        }
    }

    private void CreateFromVerifiedReference()
    {
        if (_disposed || !_referenceFallbackRecommended || string.IsNullOrWhiteSpace(_verifiedReferenceAudioPath))
            return;

        var audioPath = _verifiedReferenceAudioPath;
        if (!File.Exists(audioPath))
        {
            ResetReferenceHandoff();
            _status.Text = "The audio used for verification is no longer available. Verify again or use Create Piano Version to choose another local file.";
            UpdateActions();
            return;
        }

        var suggestedTitle = _searchBox.Text.Trim();
        using var create = new AudioToPianoCreateForm(suggestedTitle, audioPath);
        create.ShowDialog(_panel.FindForm());
        if (!string.IsNullOrWhiteSpace(create.AddedLibraryPath))
        {
            ClientDiagnostics.Log(
                $"Reference-to-create handoff committed generated piano without a second file picker: source='{Path.GetFileName(audioPath)}', managed='{create.AddedLibraryPath}'.");
            _status.Text = "Generated piano version added from the same owned/local audio used for candidate verification.";
            _onImported(create.AddedLibraryPath);
        }
        else
        {
            _status.Text = "Create Piano Version closed without changing the Library. The verified local reference remains available for this search.";
        }
        UpdateActions();
    }

    private async Task ImportSelectedAsync()
    {
        if (_disposed || _results.SelectedItem is not SongDiscoveryCandidate candidate)
            return;

        if (_referenceAssessments.TryGetValue(CandidateKey(candidate), out var assessment)
            && assessment.Verdict != ReferenceCandidateVerdict.HighConfidence)
        {
            _status.Text = assessment.Verdict == ReferenceCandidateVerdict.Mismatch
                ? "This candidate is a verified mismatch. Use Create Piano Version with your reference audio instead."
                : "This candidate still needs review and is not promoted as the existing-source fast path. Choose a High-confidence result or use Create Piano Version.";
            UpdateActions();
            return;
        }

        _importCancellation?.Cancel();
        _importCancellation?.Dispose();
        var cancellation = new CancellationTokenSource(TimeSpan.FromSeconds(20));
        _importCancellation = cancellation;
        _addButton.Enabled = false;
        _status.Text = $"Checking and adding “{candidate.Title}”…";

        try
        {
            var result = await _importer.ImportAsync(candidate, cancellation.Token).ConfigureAwait(true);
            if (_disposed)
                return;

            _status.Text = result.AlreadyPresent
                ? $"“{result.Entry.Title}” is already in your Library."
                : $"Added “{result.Entry.Title}” to your Library — ready to Play.";
            ClientDiagnostics.Log(
                $"Online song import: provider='{candidate.ProviderId}', title='{candidate.Title}', managed='{result.Entry.Path}', existing={result.AlreadyPresent}.");
            _onImported(result.Entry.Path);
        }
        catch (OperationCanceledException) when (cancellation.IsCancellationRequested)
        {
            if (!_disposed)
                _status.Text = "Online import took too long. Nothing was added; try again when the connection is stable.";
        }
        catch (Exception exception) when (
            exception is HttpRequestException
            or IOException
            or UnauthorizedAccessException
            or FormatException
            or InvalidOperationException
            or OverflowException)
        {
            ClientDiagnostics.Log($"Online song import failed: provider='{candidate.ProviderId}', title='{candidate.Title}', error={exception}");
            if (!_disposed)
                _status.Text = "That online result could not be added safely. Nothing was changed in your Library; choose another result.";
        }
        finally
        {
            if (ReferenceEquals(_importCancellation, cancellation))
                _importCancellation = null;
            cancellation.Dispose();
            UpdateActions();
        }
    }

    private void OpenSelectedSource()
    {
        if (_results.SelectedItem is not SongDiscoveryCandidate candidate)
            return;

        try
        {
            Process.Start(new ProcessStartInfo(candidate.SourcePageUri.AbsoluteUri) { UseShellExecute = true });
        }
        catch (Exception exception) when (exception is InvalidOperationException or System.ComponentModel.Win32Exception)
        {
            ClientDiagnostics.Log($"Could not open online source page: {exception}");
            _status.Text = "Could not open the source page in your browser.";
        }
    }

    private void UpdateActions()
    {
        var candidate = _results.SelectedItem as SongDiscoveryCandidate;
        var selected = candidate is not null;
        ReferenceCandidateAssessment? assessment = null;
        if (candidate is not null)
            _referenceAssessments.TryGetValue(CandidateKey(candidate), out assessment);

        var referenceAllowsFastPath = assessment is null || assessment.Verdict == ReferenceCandidateVerdict.HighConfidence;
        _addButton.Enabled = selected && _importCancellation is null && _verificationCancellation is null && referenceAllowsFastPath;
        _addButton.Text = assessment?.Verdict == ReferenceCandidateVerdict.HighConfidence ? "Add Verified Match" : "Add to Library";
        _verifyButton.Enabled = _results.Items.Count > 0 && _verificationCancellation is null && _importCancellation is null;
        _createFromReferenceButton.Visible = _referenceFallbackRecommended;
        _createFromReferenceButton.Enabled = _referenceFallbackRecommended
            && !string.IsNullOrWhiteSpace(_verifiedReferenceAudioPath)
            && _verificationCancellation is null
            && _importCancellation is null;
        _sourceButton.Enabled = selected;
    }

    private void ClearResults()
    {
        _panel.Visible = false;
        _results.DataSource = null;
        _status.Text = string.Empty;
        _referenceAssessments.Clear();
        ResetReferenceHandoff();
        UpdateActions();
    }

    private void ResetReferenceHandoff()
    {
        _verifiedReferenceAudioPath = null;
        _referenceFallbackRecommended = false;
        _createFromReferenceButton.Enabled = false;
        _createFromReferenceButton.Visible = false;
    }

    private void CancelSearch()
    {
        var cancellation = _searchCancellation;
        _searchCancellation = null;
        if (cancellation is null)
            return;
        cancellation.Cancel();
    }

    private void CancelVerification()
    {
        var cancellation = _verificationCancellation;
        _verificationCancellation = null;
        if (cancellation is null)
            return;
        cancellation.Cancel();
    }

    private static string CandidateKey(SongDiscoveryCandidate candidate)
        => string.Join("|", candidate.ProviderId, candidate.ContentIdentity ?? string.Empty, candidate.DownloadUri.AbsoluteUri);

    public void Dispose()
    {
        if (_disposed)
            return;
        _disposed = true;
        _debounce.Stop();
        _searchBox.TextChanged -= HandleSearchTextChanged;
        _searchBox.KeyDown -= HandleSearchKeyDown;
        _debounce.Tick -= HandleDebounceTick;
        CancelSearch();
        CancelVerification();
        _importCancellation?.Cancel();
        _importCancellation?.Dispose();
        _importCancellation = null;
        _debounce.Dispose();
        _httpClient.Dispose();
    }
}
