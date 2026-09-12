using System.Diagnostics;

namespace RobloxPiano.App;

internal sealed class RobloxInputCheckDialog : Form
{
    private readonly string _matrixId = RobloxInputForensics.NewProbeId();
    private readonly List<RobloxInputMatrixCellEvidence> _matrixCells = [];
    private readonly Label _status = new() { AutoSize = true, MaximumSize = new Size(650, 0) };
    private readonly Label _matrixStatus = new()
    {
        AutoSize = true,
        MaximumSize = new Size(760, 0),
        Text = "Matrix verdict: INSUFFICIENT_EVIDENCE — run the real-key baseline first."
    };
    private readonly Button _run = new() { Text = "Run PowerShell-Oracle Check", AutoSize = true };
    private readonly Button _realKey = new() { Text = "Run Real-Key Baseline", AutoSize = true };
    private readonly Button _physical = new() { Text = "Run keybd_event Scan Diagnostic", AutoSize = true };
    private readonly Button _sendInputVk = new() { Text = "Run SendInput VK Diagnostic", AutoSize = true };
    private readonly Button _sendInputScan = new() { Text = "Run SendInput Scan Diagnostic", AutoSize = true };
    private readonly Button _diagnostics = new() { Text = "Open Diagnostics", AutoSize = true };
    private readonly Button _close = new() { Text = "Close", AutoSize = true, DialogResult = DialogResult.Cancel };

    public RobloxInputCheckDialog()
    {
        Text = "Roblox Input Check";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(760, 430);
        Size = new Size(900, 560);
        MaximizeBox = false;
        MinimizeBox = false;
        ShowInTaskbar = false;

        var explanation = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(760, 0),
            Text = "Start with the real-key baseline: Roblox Piano focuses Roblox, then waits up to 10 seconds for you to physically press and release W. It injects nothing. After that, compare the same Roblox surface against the PowerShell-oracle and synthetic diagnostic matrix. All cells are correlated by one matrix ID in Diagnostics."
        };
        var observation = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(760, 0),
            Text = "Watch Roblox during every W test. Outside a piano, W should move your character. Inside a piano, it should trigger the W-bound note. Windows API success alone is never a field PASS."
        };
        var privacy = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(760, 0),
            Text = "Real-key baseline privacy: the bounded keyboard hook records only W events, rejects OS-marked injected events, and is removed immediately after W is released or the timeout expires. It does not log unrelated keys or authorize playback."
        };
        var buttons = new FlowLayoutPanel { AutoSize = true, Dock = DockStyle.Fill, WrapContents = true };
        buttons.Controls.AddRange([_realKey, _run, _physical, _sendInputVk, _sendInputScan, _diagnostics, _close]);

        var root = new TableLayoutPanel
        {
            Dock = DockStyle.Fill,
            Padding = new Padding(20),
            ColumnCount = 1,
            AutoSize = true
        };
        root.Controls.Add(new Label
        {
            Text = "Roblox Input Check",
            AutoSize = true,
            Font = new Font(Font.FontFamily, 17f, FontStyle.Bold)
        });
        root.Controls.Add(explanation);
        root.Controls.Add(observation);
        root.Controls.Add(privacy);
        root.Controls.Add(_status);
        root.Controls.Add(_matrixStatus);
        root.Controls.Add(buttons);
        Controls.Add(root);

        _realKey.Click += async (_, _) => await RunRealKeyAsync().ConfigureAwait(true);
        _run.Click += async (_, _) => await RunOracleAsync().ConfigureAwait(true);
        _physical.Click += async (_, _) => await RunPhysicalAsync().ConfigureAwait(true);
        _sendInputVk.Click += async (_, _) => await RunSendInputVirtualKeyAsync().ConfigureAwait(true);
        _sendInputScan.Click += async (_, _) => await RunSendInputScanAsync().ConfigureAwait(true);
        _diagnostics.Click += (_, _) => OpenDiagnostics();
        AcceptButton = _realKey;
        CancelButton = _close;
        ClientDiagnostics.Log($"INPUT_MATRIX matrix={_matrixId} stage=OPEN purpose=REAL_VS_SYNTHETIC_W authorizesPlayback=false.");
        RefreshSessionStatus();
    }

    private void RefreshSessionStatus()
    {
        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _status.Text = "○ Roblox Player is not currently available. Open Roblox to establish input readiness.";
            return;
        }

        var health = RobloxInputHealthSession.GetFor(target);
        _status.Text = health.State switch
        {
            RobloxInputHealthState.Confirmed => $"✓ Input confirmed for Roblox PID {target.ProcessId}. Confirmation is process-scoped.",
            RobloxInputHealthState.Blocked => $"⚠ Input is blocked for Roblox PID {target.ProcessId}: {health.Summary}\n\nNext: {health.NextAction}",
            _ => $"○ Input readiness is unknown for Roblox PID {target.ProcessId}. Run the real-key baseline, then the PowerShell-oracle check."
        };
    }

    private async Task RunRealKeyAsync()
    {
        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _status.Text = "⚠ Roblox Player was not found. Open Roblox before running the real-key baseline.";
            return;
        }

        if (!Confirm("Roblox Piano will focus Roblox and wait up to 10 seconds. Physically press and release W once while Roblox is foreground. This baseline injects no input and records only W events. Continue?", "Run Real-Key Baseline"))
        {
            return;
        }

        var matrixSession = CaptureProbeSession("REAL_KEY", target);
        SetBusy(true);
        _status.Text = "Real-key baseline armed… when Roblox is foreground, physically press and release W once.";
        try
        {
            var result = await RobloxHardwareKeyBaselineProbe.RunAsync(target).ConfigureAwait(true);
            Activate();
            if (!result.PhysicalBaselineObserved)
            {
                LogMatrixCell("REAL_KEY", result.ProbeId, "BASELINE_NOT_CONFIRMED", null, matrixSession);
                _status.Text = "⚠ A complete non-injected W down/up pair was not observed while Roblox stayed foreground. Retry and physically press W once within 10 seconds.";
                return;
            }

            var observed = AskReaction("real physical W baseline", "Confirm Real-Key Roblox Reaction");
            RobloxHardwareKeyBaselineProbe.LogHumanVerdict(result, observed);
            LogMatrixCell("REAL_KEY", result.ProbeId, observed ? "ROBLOX_REACTED" : "ROBLOX_NO_REACTION", observed, matrixSession);
            _status.Text = observed
                ? "✓ Real W reached Roblox visibly. Now run PowerShell-Oracle Check without changing the Roblox experience/session. If synthetic W fails, Diagnostics will contain a correlated real-vs-synthetic boundary."
                : "⚠ Real W was observed by Windows but Roblox did not visibly react. Synthetic-vs-physical comparison is not meaningful until the selected Roblox surface responds to a real W.";
        }
        catch (OperationCanceledException)
        {
            _status.Text = "⚠ Real-key baseline cancelled safely; the keyboard hook was removed.";
        }
        catch (Exception exception) when (IsExpectedInputException(exception))
        {
            ClientDiagnostics.Log($"GUI real-key baseline failed: {exception}");
            _status.Text = $"⚠ Real-key baseline failed: {exception.Message}\n\nOpen Diagnostics for correlated evidence.";
        }
        finally
        {
            SetBusy(false);
        }
    }

    private async Task RunOracleAsync()
    {
        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            ApplyAssessment(new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.ActivationFailed,
                "Roblox Player was not found.",
                "Open Roblox, enter the game you want to test, then run the check again.",
                false));
            return;
        }

        if (!Confirm($"Roblox Piano will focus Roblox and hold W for about {RobloxFieldInputPolicy.ProbeHoldDuration.TotalMilliseconds:0} ms using the exact PowerShell-oracle virtual-key path. Run this on the same Roblox surface as the real-key baseline. Continue?", "Run Roblox Input Check"))
        {
            return;
        }

        var matrixSession = CaptureProbeSession("POWERSHELL_ORACLE", target);
        SetBusy(true);
        _status.Text = "Running PowerShell-oracle check… keep Roblox foreground until W is released.";
        try
        {
            var result = await RobloxFieldInputProbe.RunAsync(target).ConfigureAwait(true);
            var nativeAssessment = result.Assess(null);
            ClientDiagnostics.Log($"GUI input check native verdict={nativeAssessment.Verdict}; probe={result.ProbeId}; matrix={_matrixId}; nativeDelivery={result.NativeDeliveryObserved}; activation={result.ActivationConfirmed}; stableFocus={result.StableForegroundConfirmed}; desktopParity={result.DesktopParity}; keyDown={result.WindowsReportedKeyDown}; foregroundHeld={result.ForegroundHeldDuringProbe}; vk=0x{result.VirtualKey:X2}; heldMs={result.HoldDuration.TotalMilliseconds:0}.");

            Activate();
            if (!result.NativeDeliveryObserved)
            {
                LogMatrixCell("POWERSHELL_ORACLE", result.ProbeId, "WINDOWS_BOUNDARY_NOT_CONFIRMED", null, matrixSession);
                RobloxInputHealthSession.Record(target, nativeAssessment);
                ApplyAssessment(nativeAssessment);
                return;
            }

            var observed = AskReaction("PowerShell-oracle W test", "Confirm Roblox Reaction");
            var assessment = result.Assess(observed);
            RobloxInputForensics.LogVerdict(result.ProbeId, assessment, observed);
            LogMatrixCell("POWERSHELL_ORACLE", result.ProbeId, observed ? "ROBLOX_REACTED" : "ROBLOX_NO_REACTION", observed, matrixSession);
            RobloxInputHealthSession.Record(target, assessment);
            ApplyAssessment(assessment);
            if (!observed)
            {
                _status.Text += "\n\nIf REAL_KEY=ROBLOX_REACTED in the same matrix, this is direct evidence that the failure boundary is synthetic delivery/Roblox consumption rather than basic game focus. Next: keybd_event Scan Diagnostic.";
            }
        }
        catch (OperationCanceledException)
        {
            var assessment = new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.FocusUnstable,
                "The input check was cancelled safely.",
                "No keys remain held. Retry when Roblox is ready.",
                false);
            RobloxInputHealthSession.Record(target, assessment);
            ApplyAssessment(assessment);
        }
        catch (Exception exception) when (IsExpectedInputException(exception))
        {
            ClientDiagnostics.Log($"GUI input check failed: {exception}");
            var assessment = new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.WindowsKeyStateNotObserved,
                $"Input check failed: {exception.Message}",
                "Open Diagnostics, resolve the Windows/input blocker, then retry.",
                false);
            RobloxInputHealthSession.Record(target, assessment);
            ApplyAssessment(assessment);
        }
        finally
        {
            SetBusy(false);
        }
    }

    private async Task RunPhysicalAsync()
    {
        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _status.Text = "⚠ Roblox Player was not found. Open Roblox before running the keybd_event scan diagnostic.";
            return;
        }

        if (!Confirm("This synthetic diagnostic keeps keybd_event but emits W with a non-zero physical scan code. It is not a real physical-key baseline, cannot authorize playback, and changes no production playback behavior. Continue?", "Run keybd_event Scan Diagnostic"))
        {
            return;
        }

        var matrixSession = CaptureProbeSession("KEYBD_EVENT_SCAN", target);
        SetBusy(true);
        _status.Text = "Running keybd_event scan diagnostic… keep Roblox foreground until W is released.";
        try
        {
            var result = await RobloxPhysicalKeyDiagnosticProbe.RunAsync(target).ConfigureAwait(true);
            Activate();
            if (!result.NativeDeliveryObserved)
            {
                LogMatrixCell("KEYBD_EVENT_SCAN", result.ProbeId, "WINDOWS_BOUNDARY_NOT_CONFIRMED", null, matrixSession);
                _status.Text = "⚠ keybd_event scan diagnostic did not establish safe Windows delivery. Inspect matching PHYSICAL_* INPUT_FORENSIC lines.";
                return;
            }

            var observed = AskReaction("keybd_event scan-code W diagnostic", "Confirm keybd_event Scan Reaction");
            RobloxPhysicalKeyDiagnosticProbe.LogHumanVerdict(result, observed);
            LogMatrixCell("KEYBD_EVENT_SCAN", result.ProbeId, observed ? "ROBLOX_REACTED" : "ROBLOX_NO_REACTION", observed, matrixSession);
            _status.Text = observed
                ? "⚠ Roblox reacted to synthetic keybd_event with a non-zero scan code. Scan-code semantics are now a leading input difference; production remains unchanged."
                : "⚠ No reaction. Next matrix cell: SendInput VK Diagnostic.";
        }
        catch (OperationCanceledException)
        {
            _status.Text = "⚠ keybd_event scan diagnostic cancelled safely; best-effort KeyUp was sent.";
        }
        catch (Exception exception) when (IsExpectedInputException(exception))
        {
            ClientDiagnostics.Log($"GUI keybd_event scan diagnostic failed: {exception}");
            _status.Text = $"⚠ keybd_event scan diagnostic failed: {exception.Message}\n\nOpen Diagnostics for correlated evidence.";
        }
        finally
        {
            SetBusy(false);
        }
    }

    private async Task RunSendInputVirtualKeyAsync()
    {
        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _status.Text = "⚠ Roblox Player was not found. Open Roblox before running the SendInput VK diagnostic.";
            return;
        }

        if (!Confirm("This diagnostic emits the exact oracle W virtual-key meaning through Windows SendInput: wVk is non-zero, wScan is 0, and KEYEVENTF_SCANCODE is not set. It is diagnostic-only and cannot authorize or change playback. Continue?", "Run SendInput VK Diagnostic"))
        {
            return;
        }

        var matrixSession = CaptureProbeSession("SENDINPUT_VK", target);
        SetBusy(true);
        _status.Text = "Running SendInput virtual-key diagnostic… keep Roblox foreground until W is released.";
        try
        {
            var result = await RobloxSendInputVirtualKeyDiagnosticProbe.RunAsync(target).ConfigureAwait(true);
            Activate();
            if (!result.NativeDeliveryObserved)
            {
                LogMatrixCell("SENDINPUT_VK", result.ProbeId, "WINDOWS_BOUNDARY_NOT_CONFIRMED", null, matrixSession);
                _status.Text = "⚠ SendInput VK diagnostic did not establish safe Windows delivery. Inspect matching SENDINPUT_VK_* INPUT_FORENSIC lines.";
                return;
            }

            var observed = AskReaction("SendInput virtual-key W diagnostic", "Confirm SendInput VK Reaction");
            RobloxSendInputVirtualKeyDiagnosticProbe.LogHumanVerdict(result, observed);
            LogMatrixCell("SENDINPUT_VK", result.ProbeId, observed ? "ROBLOX_REACTED" : "ROBLOX_NO_REACTION", observed, matrixSession);
            _status.Text = observed
                ? "⚠ Roblox reacted to SendInput virtual-key semantics. This isolates the injection API from scan-code semantics; production remains unchanged."
                : "⚠ No reaction. Next matrix cell: SendInput Scan Diagnostic.";
        }
        catch (OperationCanceledException)
        {
            _status.Text = "⚠ SendInput VK diagnostic cancelled safely; best-effort KeyUp was sent.";
        }
        catch (Exception exception) when (IsExpectedInputException(exception))
        {
            ClientDiagnostics.Log($"GUI SendInput VK diagnostic failed: {exception}");
            _status.Text = $"⚠ SendInput VK diagnostic failed: {exception.Message}\n\nOpen Diagnostics for correlated evidence.";
        }
        finally
        {
            SetBusy(false);
        }
    }

    private async Task RunSendInputScanAsync()
    {
        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _status.Text = "⚠ Roblox Player was not found. Open Roblox before running the SendInput scan diagnostic.";
            return;
        }

        if (!Confirm("This diagnostic emits W using Windows SendInput with physical scan-code semantics. Run it after the SendInput VK cell when possible. It is diagnostic-only and cannot authorize or modify normal playback. Continue?", "Run SendInput Scan Diagnostic"))
        {
            return;
        }

        var matrixSession = CaptureProbeSession("SENDINPUT_SCAN", target);
        SetBusy(true);
        _status.Text = "Running SendInput scan-code diagnostic… keep Roblox foreground until W is released.";
        try
        {
            var result = await RobloxSendInputScanDiagnosticProbe.RunAsync(target).ConfigureAwait(true);
            Activate();
            if (!result.NativeDeliveryObserved)
            {
                LogMatrixCell("SENDINPUT_SCAN", result.ProbeId, "WINDOWS_BOUNDARY_NOT_CONFIRMED", null, matrixSession);
                _status.Text = "⚠ SendInput scan diagnostic did not establish safe Windows delivery. Inspect matching SENDINPUT_* INPUT_FORENSIC lines.";
                return;
            }

            var observed = AskReaction("SendInput scan-code W diagnostic", "Confirm SendInput Scan Reaction");
            RobloxSendInputScanDiagnosticProbe.LogHumanVerdict(result, observed);
            LogMatrixCell("SENDINPUT_SCAN", result.ProbeId, observed ? "ROBLOX_REACTED" : "ROBLOX_NO_REACTION", observed, matrixSession);
            _status.Text = observed
                ? "⚠ Roblox reacted to SendInput physical scan-code semantics. Preserve this matrix ID; production remains unchanged until field evidence is reviewed and regression-protected."
                : "⚠ No reaction. If REAL_KEY reacted in this same matrix while all synthetic cells did not, the evidence now isolates the unresolved boundary after Windows synthetic injection and before Roblox game-input consumption.";
        }
        catch (OperationCanceledException)
        {
            _status.Text = "⚠ SendInput scan diagnostic cancelled safely; best-effort KeyUp was sent.";
        }
        catch (Exception exception) when (IsExpectedInputException(exception))
        {
            ClientDiagnostics.Log($"GUI SendInput scan diagnostic failed: {exception}");
            _status.Text = $"⚠ SendInput scan diagnostic failed: {exception.Message}\n\nOpen Diagnostics for correlated evidence.";
        }
        finally
        {
            SetBusy(false);
        }
    }

    private RobloxInputMatrixSessionIdentity? CaptureProbeSession(string cell, RobloxWindowTarget target)
    {
        if (!RobloxInputMatrixSessionIdentity.TryCapture(target, out var identity))
        {
            ClientDiagnostics.Log(
                $"INPUT_MATRIX_SESSION matrix={_matrixId} cell={cell} stage=PROBE_START identity=UNAVAILABLE source=SELECTED_TARGET continuityTrusted=false authorizesPlayback=false.");
            return null;
        }

        ClientDiagnostics.Log(
            $"INPUT_MATRIX_SESSION matrix={_matrixId} cell={cell} stage=PROBE_START identity={identity.ToLogToken()} source=SELECTED_TARGET continuityTrusted=true authorizesPlayback=false.");
        return identity;
    }

    private RobloxInputMatrixAssessment LogMatrixCell(
        string cell,
        string probeId,
        string verdict,
        bool? reacted,
        RobloxInputMatrixSessionIdentity? sessionIdentity)
    {
        var evidence = new RobloxInputMatrixCellEvidence(cell, probeId, verdict, reacted, sessionIdentity);
        _matrixCells.Add(evidence);
        ClientDiagnostics.Log(
            $"INPUT_MATRIX_SESSION matrix={_matrixId} probe={probeId} cell={cell} stage=RESULT_RETAINED " +
            $"identity={(sessionIdentity is null ? "UNAVAILABLE" : sessionIdentity.Value.ToLogToken())} " +
            $"source=PROBE_START continuityTrusted={sessionIdentity is not null} authorizesPlayback=false.");
        ClientDiagnostics.Log(
            $"INPUT_MATRIX matrix={_matrixId} probe={probeId} cell={cell} verdict={verdict} " +
            $"robloxReaction={(reacted is null ? "UNKNOWN" : reacted.Value ? "YES" : "NO")} authorizesPlayback=false.");

        var assessment = RobloxInputMatrixAssessmentPolicy.Assess(_matrixCells);
        var winners = assessment.WinningCells.Count == 0 ? "NONE" : string.Join(",", assessment.WinningCells);
        var failures = assessment.FailingCells.Count == 0 ? "NONE" : string.Join(",", assessment.FailingCells);
        var pending = assessment.PendingCells.Count == 0 ? "NONE" : string.Join(",", assessment.PendingCells);
        ClientDiagnostics.Log(
            $"INPUT_MATRIX_SUMMARY matrix={_matrixId} verdict={assessment.Verdict} boundary={assessment.FailureBoundary} " +
            $"winningCells={winners} failingCells={failures} pendingCells={pending} conclusive={assessment.IsConclusive} " +
            "fieldPass=false authorizesPlayback=false.");
        _matrixStatus.Text = $"Matrix verdict: {assessment.Verdict} — {assessment.Summary}\nNext: {assessment.NextAction}";
        return assessment;
    }

    private bool Confirm(string text, string caption)
        => MessageBox.Show(this, text, caption, MessageBoxButtons.OKCancel, MessageBoxIcon.Warning) == DialogResult.OK;

    private bool AskReaction(string testName, string caption)
        => MessageBox.Show(this, $"Did Roblox visibly react to the {testName}?\n\nChoose Yes only if you saw movement or heard/saw the W-bound piano note.", caption, MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes;

    private void SetBusy(bool busy)
    {
        _run.Enabled = !busy;
        _realKey.Enabled = !busy;
        _physical.Enabled = !busy;
        _sendInputVk.Enabled = !busy;
        _sendInputScan.Enabled = !busy;
    }

    private void ApplyAssessment(RobloxInputCheckAssessment assessment)
    {
        var prefix = assessment.IsSuccess ? "✓" : "⚠";
        _status.Text = $"{prefix} {assessment.Summary}\n\nNext: {assessment.NextAction}";
    }

    private static bool IsExpectedInputException(Exception exception)
        => exception is InvalidOperationException or ArgumentException or System.ComponentModel.Win32Exception;

    private static void OpenDiagnostics()
    {
        try
        {
            Directory.CreateDirectory(ClientDiagnostics.DirectoryPath);
            Process.Start(new ProcessStartInfo { FileName = ClientDiagnostics.DirectoryPath, UseShellExecute = true });
        }
        catch (Exception exception) when (exception is InvalidOperationException or System.ComponentModel.Win32Exception or IOException or UnauthorizedAccessException)
        {
            ClientDiagnostics.Log($"Could not open diagnostics directory: {exception}");
        }
    }
}
