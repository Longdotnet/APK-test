using System.Diagnostics;

namespace RobloxPiano.App;

internal sealed class RobloxInputCheckDialog : Form
{
    private readonly Label _status = new() { AutoSize = true, MaximumSize = new Size(650, 0) };
    private readonly Button _run = new() { Text = "Run Input Check", AutoSize = true };
    private readonly Button _physical = new() { Text = "Run Physical-Key Diagnostic", AutoSize = true };
    private readonly Button _sendInputVk = new() { Text = "Run SendInput VK Diagnostic", AutoSize = true };
    private readonly Button _sendInputScan = new() { Text = "Run SendInput Scan Diagnostic", AutoSize = true };
    private readonly Button _diagnostics = new() { Text = "Open Diagnostics", AutoSize = true };
    private readonly Button _close = new() { Text = "Close", AutoSize = true, DialogResult = DialogResult.Cancel };

    public RobloxInputCheckDialog()
    {
        Text = "Roblox Input Check";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(720, 390);
        Size = new Size(820, 480);
        MaximizeBox = false;
        MinimizeBox = false;
        ShowInTaskbar = false;

        var explanation = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(690, 0),
            Text = "Run the PowerShell-oracle check first. If Roblox does not react, the diagnostics complete a controlled input matrix without changing production playback: keybd_event with physical scan code, SendInput with the same virtual-key semantics as the oracle, then SendInput with physical scan-code semantics."
        };
        var observation = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(690, 0),
            Text = "Watch Roblox during each W probe. Outside a piano, W should move your character. Inside a piano, it should trigger the W-bound note. A Windows API success alone is not a field PASS."
        };
        var buttons = new FlowLayoutPanel { AutoSize = true, Dock = DockStyle.Fill, WrapContents = true };
        buttons.Controls.AddRange([_run, _physical, _sendInputVk, _sendInputScan, _diagnostics, _close]);

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
        root.Controls.Add(_status);
        root.Controls.Add(buttons);
        Controls.Add(root);

        _run.Click += async (_, _) => await RunOracleAsync().ConfigureAwait(true);
        _physical.Click += async (_, _) => await RunPhysicalAsync().ConfigureAwait(true);
        _sendInputVk.Click += async (_, _) => await RunSendInputVirtualKeyAsync().ConfigureAwait(true);
        _sendInputScan.Click += async (_, _) => await RunSendInputScanAsync().ConfigureAwait(true);
        _diagnostics.Click += (_, _) => OpenDiagnostics();
        AcceptButton = _run;
        CancelButton = _close;
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
            _ => $"○ Input readiness is unknown for Roblox PID {target.ProcessId}. Run the PowerShell-oracle check before trusting playback."
        };
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

        if (!Confirm($"Roblox Piano will focus Roblox and hold W for about {RobloxFieldInputPolicy.ProbeHoldDuration.TotalMilliseconds:0} ms using the exact PowerShell-oracle virtual-key path.\n\nContinue?", "Run Roblox Input Check"))
        {
            return;
        }

        SetBusy(true);
        _status.Text = "Running PowerShell-oracle check… keep Roblox foreground until W is released.";
        try
        {
            var result = await RobloxFieldInputProbe.RunAsync(target).ConfigureAwait(true);
            var nativeAssessment = result.Assess(null);
            ClientDiagnostics.Log($"GUI input check native verdict={nativeAssessment.Verdict}; probe={result.ProbeId}; nativeDelivery={result.NativeDeliveryObserved}; activation={result.ActivationConfirmed}; stableFocus={result.StableForegroundConfirmed}; desktopParity={result.DesktopParity}; keyDown={result.WindowsReportedKeyDown}; foregroundHeld={result.ForegroundHeldDuringProbe}; vk=0x{result.VirtualKey:X2}; heldMs={result.HoldDuration.TotalMilliseconds:0}.");

            Activate();
            if (!result.NativeDeliveryObserved)
            {
                RobloxInputHealthSession.Record(target, nativeAssessment);
                ApplyAssessment(nativeAssessment);
                return;
            }

            var observed = AskReaction("PowerShell-oracle W test", "Confirm Roblox Reaction");
            var assessment = result.Assess(observed);
            RobloxInputForensics.LogVerdict(result.ProbeId, assessment, observed);
            RobloxInputHealthSession.Record(target, assessment);
            ApplyAssessment(assessment);
            if (!observed)
            {
                _status.Text += "\n\nNext matrix cell: Physical-Key Diagnostic (keybd_event + physical scan code).";
            }
        }
        catch (OperationCanceledException)
        {
            ApplyAssessment(new RobloxInputCheckAssessment(RobloxInputCheckVerdict.FocusUnstable, "The input check was cancelled safely.", "No keys remain held. Retry when Roblox is ready.", false));
        }
        catch (Exception exception) when (IsExpectedInputException(exception))
        {
            ClientDiagnostics.Log($"GUI input check failed: {exception}");
            ApplyAssessment(new RobloxInputCheckAssessment(RobloxInputCheckVerdict.WindowsKeyStateNotObserved, $"Input check failed: {exception.Message}", "Open Diagnostics, resolve the Windows/input blocker, then retry.", false));
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
            _status.Text = "⚠ Roblox Player was not found. Open Roblox before running the physical-key diagnostic.";
            return;
        }

        if (!Confirm("This diagnostic keeps keybd_event but emits W with a real non-zero physical scan code. It is diagnostic-only and cannot authorize or modify normal playback. Continue?", "Run Physical-Key Diagnostic"))
        {
            return;
        }

        SetBusy(true);
        _status.Text = "Running physical-key diagnostic… keep Roblox foreground until W is released.";
        try
        {
            var result = await RobloxPhysicalKeyDiagnosticProbe.RunAsync(target).ConfigureAwait(true);
            Activate();
            if (!result.NativeDeliveryObserved)
            {
                _status.Text = "⚠ Physical-key diagnostic did not establish safe Windows delivery. Inspect matching PHYSICAL_* INPUT_FORENSIC lines.";
                return;
            }

            var observed = AskReaction("physical-key W diagnostic", "Confirm Physical-Key Reaction");
            RobloxPhysicalKeyDiagnosticProbe.LogHumanVerdict(result, observed);
            _status.Text = observed
                ? "⚠ Roblox reacted to keybd_event with a physical scan code. Scan-code semantics are now the leading input difference; production remains unchanged."
                : "⚠ No reaction. Next matrix cell: SendInput VK Diagnostic. This changes only the injection API while keeping the oracle's virtual-key semantics.";
        }
        catch (OperationCanceledException)
        {
            _status.Text = "⚠ Physical-key diagnostic cancelled safely; best-effort KeyUp was sent.";
        }
        catch (Exception exception) when (IsExpectedInputException(exception))
        {
            ClientDiagnostics.Log($"GUI physical-key diagnostic failed: {exception}");
            _status.Text = $"⚠ Physical-key diagnostic failed: {exception.Message}\n\nOpen Diagnostics for correlated evidence.";
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

        SetBusy(true);
        _status.Text = "Running SendInput virtual-key diagnostic… keep Roblox foreground until W is released.";
        try
        {
            var result = await RobloxSendInputVirtualKeyDiagnosticProbe.RunAsync(target).ConfigureAwait(true);
            Activate();
            if (!result.NativeDeliveryObserved)
            {
                _status.Text = "⚠ SendInput VK diagnostic did not establish safe Windows delivery. Inspect matching SENDINPUT_VK_* INPUT_FORENSIC lines.";
                return;
            }

            var observed = AskReaction("SendInput virtual-key W diagnostic", "Confirm SendInput VK Reaction");
            RobloxSendInputVirtualKeyDiagnosticProbe.LogHumanVerdict(result, observed);
            _status.Text = observed
                ? "⚠ Roblox reacted to SendInput virtual-key semantics. This isolates the injection API from scan-code semantics: SendInput itself may matter while physical-scan conversion is unnecessary. Production remains unchanged."
                : "⚠ No reaction. Next matrix cell: SendInput Scan Diagnostic. It keeps SendInput but changes only from virtual-key to physical scan-code semantics.";
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

        SetBusy(true);
        _status.Text = "Running SendInput scan-code diagnostic… keep Roblox foreground until W is released.";
        try
        {
            var result = await RobloxSendInputScanDiagnosticProbe.RunAsync(target).ConfigureAwait(true);
            Activate();
            if (!result.NativeDeliveryObserved)
            {
                _status.Text = "⚠ SendInput scan diagnostic did not establish safe Windows delivery. Inspect matching SENDINPUT_* INPUT_FORENSIC lines.";
                return;
            }

            var observed = AskReaction("SendInput scan-code W diagnostic", "Confirm SendInput Scan Reaction");
            RobloxSendInputScanDiagnosticProbe.LogHumanVerdict(result, observed);
            _status.Text = observed
                ? "⚠ Roblox reacted to SendInput physical scan-code semantics. Preserve all four probe IDs; production remains unchanged until field evidence is reviewed and regression-protected."
                : "⚠ No reaction. All four supported matrix paths have now failed visible Roblox consumption. Preserve all probe IDs; remaining suspects are Roblox/game input consumption or environment/session/overlay/security boundaries rather than scheduler or basic VK/scan/API choice.";
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

    private bool Confirm(string text, string caption)
        => MessageBox.Show(this, text, caption, MessageBoxButtons.OKCancel, MessageBoxIcon.Warning) == DialogResult.OK;

    private bool AskReaction(string testName, string caption)
        => MessageBox.Show(this, $"Did Roblox visibly react to the {testName}?\n\nChoose Yes only if you saw movement or heard/saw the W-bound piano note.", caption, MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes;

    private void SetBusy(bool busy)
    {
        _run.Enabled = !busy;
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
