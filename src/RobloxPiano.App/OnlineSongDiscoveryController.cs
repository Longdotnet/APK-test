using System.Diagnostics;
using RobloxPiano.Audio;
using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.App;

internal sealed class OnlineSongDiscoveryController : IDisposable
{
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
    private readonly Button _verifyButton = new() { Text = "Verify with my audio...", AutoSize = true, Enabled = false };
    private readonly Button _sourceButton = new() { Text = "View Source", AutoSize = true, Enabled = false };

    private CancellationTokenSource? _searchCancellation;
    private CancellationTokenSource? _importCancellation;
    private CancellationTokenSource? _verificationCancellation;
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
        actions.Controls.AddRange([_addButton, _verifyButton, _sourceButton]);
        _panel.Controls.Add(_status, 0, 0);
        _panel.Controls.Add(_results, 0, 1);
        _panel.Controls.Add(actions, 0, 2);

        _searchBox.TextChanged += HandleSearchTextChanged;
        _searchBox.KeyDown += HandleSearchKeyDown;
        _debounce.Tick += HandleDebounceTick;
        _results.SelectedIndexChanged += (_, _) => UpdateActions();
        _results.DoubleClick += async (_, _) => await ImportSelectedAsync().ConfigureAwait(true);
        _addButton.Click += async (_, _) => await ImportSelectedAsync().ConfigureAwait(true);
        _verifyButton.Click += async (_, _) => await VerifySelectedAsync().ConfigureAwait(true);
        _sourceButton.Click += (_, _) => OpenSelectedSource();
    }

    public Control View => _panel;

    private void HandleSearchTextChanged(object? sender, EventArgs eventArgs)
    {
        _debounce.Stop();
        CancelSearch();
        CancelVerification();
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
                    ? $"Network unavailable — showing {result.Candidates.Count} recent cached match(es). Verify a candidate with owned/local audio before trusting recording equivalence."
                    : $"{result.Candidates.Count} online match(es). Metadata is not recording proof; use Verify with my audio for a deterministic High confidence / Review / Mismatch check.";
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

    private async Task VerifySelectedAsync()
    {
        if (_disposed || _results.SelectedItem is not SongDiscoveryCandidate candidate)
            return;

        using var dialog = new OpenFileDialog
        {
            Title = "Choose owned/local reference audio",
            Filter = "Audio files (*.wav;*.mp3;*.aiff;*.aif)|*.wav;*.mp3;*.aiff;*.aif|All files (*.*)|*.*",
            CheckFileExists = true,
            Multiselect = false
        };
        if (dialog.ShowDialog(_panel.FindForm()) != DialogResult.OK)
            return;

        CancelVerification();
        var cancellation = new CancellationTokenSource(TimeSpan.FromSeconds(45));
        _verificationCancellation = cancellation;
        UpdateActions();
        _status.Text = $"Analyzing your audio locally, then verifying “{candidate.Title}”… Nothing is uploaded.";

        try
        {
            var reference = await Task.Run(
                () => _referenceAnalyzer.AnalyzeFile(dialog.FileName, cancellation.Token),
                cancellation.Token).ConfigureAwait(true);
            var result = await _referenceVerifier.VerifyAsync(candidate, reference, cancellation.Token).ConfigureAwait(true);
            if (_disposed || cancellation.IsCancellationRequested)
                return;

            _referenceAssessments[CandidateKey(candidate)] = result.Assessment;
            var compatibility = string.IsNullOrWhiteSpace(result.ImportCompatibilitySummary)
                ? string.Empty
                : $" Import: {result.ImportCompatibilitySummary}.";
            _status.Text = result.Assessment.Verdict switch
            {
                ReferenceCandidateVerdict.HighConfidence =>
                    $"High confidence ({result.Assessment.ConfidenceScore}/100) — this candidate aligns with your reference audio. Add Verified Match is the recommended fast path.{compatibility}",
                ReferenceCandidateVerdict.Review =>
                    $"Review ({result.Assessment.ConfidenceScore}/100) — evidence is not strong enough to trust this as the same recording. Try another candidate or use Create Piano Version.{compatibility}",
                _ =>
                    $"Mismatch ({result.Assessment.ConfidenceScore}/100) — do not use this candidate as the recording match. Use Create Piano Version with your audio instead.{compatibility}"
            };
            ClientDiagnostics.Log(
                $"Reference candidate verification: provider='{candidate.ProviderId}', title='{candidate.Title}', verdict={result.Assessment.Verdict}, score={result.Assessment.ConfidenceScore}, reason={result.Assessment.ReasonCode}, coverage={result.Assessment.MatchCoverage:0.###}, meanMs={result.Assessment.MeanAbsoluteErrorMilliseconds:0.###}, p95Ms={result.Assessment.P95AbsoluteErrorMilliseconds:0.###}, evidence={result.Assessment.EvidenceSha256}.");
        }
        catch (OperationCanceledException) when (cancellation.IsCancellationRequested)
        {
            if (!_disposed)
                _status.Text = "Reference verification was cancelled or timed out. Nothing was added to your Library.";
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
            ClientDiagnostics.Log($"Reference candidate verification failed safely: provider='{candidate.ProviderId}', title='{candidate.Title}', error={exception}");
            if (!_disposed)
                _status.Text = $"Could not verify this candidate safely: {exception.Message} Nothing was added; try another source or Create Piano Version.";
        }
        finally
        {
            if (ReferenceEquals(_verificationCancellation, cancellation))
                _verificationCancellation = null;
            cancellation.Dispose();
            UpdateActions();
        }
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
                : "This candidate still needs review and is not promoted as the existing-source fast path. Verify another candidate or use Create Piano Version.";
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
        _verifyButton.Enabled = selected && _verificationCancellation is null && _importCancellation is null;
        _sourceButton.Enabled = selected;
    }

    private void ClearResults()
    {
        _panel.Visible = false;
        _results.DataSource = null;
        _status.Text = string.Empty;
        _referenceAssessments.Clear();
        UpdateActions();
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
