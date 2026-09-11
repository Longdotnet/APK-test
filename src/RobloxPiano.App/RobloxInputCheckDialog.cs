using System.Diagnostics;

namespace RobloxPiano.App;

internal sealed class RobloxInputCheckDialog : Form
{
    private readonly Label _status = new()
    {
        AutoSize = true,
        MaximumSize = new Size(600, 0)
    };
    private readonly Button _run = new() { Text = "Run Input Check", AutoSize = true };
    private readonly Button _physical = new() { Text = "Run Physical-Key Diagnostic", AutoSize = true };
    private readonly Button _sendInput = new() { Text = "Run SendInput Diagnostic", AutoSize = true };
    private readonly Button _diagnostics = new() { Text = "Open Diagnostics", AutoSize = true };
    private readonly Button _close = new() { Text = "Close", AutoSize = true, DialogResult = DialogResult.Cancel };

    public RobloxInputCheckDialog()
    {
        Text = "Roblox Input Check";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(680, 360);
        Size = new Size(760, 430);
        MaximizeBox = false;
        MinimizeBox = false;
        ShowInTaskbar = false;

        var explanation = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(640, 0),
            Text = "Use this when Play appears to run but Roblox produces no notes. Run Input Check first for the exact PowerShell-oracle virtual-key path. If Roblox still does not react, Physical-Key Diagnostic keeps keybd_event but adds a real scan code. If that also fails, SendInput Diagnostic emits the same physical scan code through the modern Windows SendInput API. Both variants are diagnostic-only and can never authorize or silently change normal playback."
        };
        var observation = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(640, 0),
            Text = "For every check, watch Roblox. Outside a piano, W should move your character. Inside a piano, it should trigger the W-bound note."
        };
        var buttons = new FlowLayoutPanel { AutoSize = true, Dock = DockStyle.Fill, WrapContents = true };
        buttons.Controls.AddRange([_run, _physical, _sendInput, _diagnostics, _close]);

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

        _run.Click += async (_, _) => await RunCheckAsync().ConfigureAwait(true);
        _physical.Click += async (_, _) => await RunPhysicalDiagnosticAsync().ConfigureAwait(true);
        _sendInput.Click += async (_, _) => await RunSendInputDiagnosticAsync().ConfigureAwait(true);
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
            RobloxInputHealthState.Confirmed =>
                $"✓ Input confirmed for Roblox PID {target.ProcessId}. This confirmation is discarded automatically when the Roblox process changes.",
            RobloxInputHealthState.Blocked =>
                $"⚠ Input is blocked for Roblox PID {target.ProcessId}: {health.Summary}\n\nNext: {health.NextAction}",
            _ =>
                $"○ Input readiness is unknown for Roblox PID {target.ProcessId}. Run the check before trusting playback in this Roblox session."
        };
    }

    private async Task RunCheckAsync()
    {
        if (!_run.Enabled)
        {
            return;
        }

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

        var consent = MessageBox.Show(
            this,
            $"Roblox Piano will focus Roblox and hold '{char.ToUpperInvariant(RobloxFieldInputPolicy.ProbeKey)}' for about {RobloxFieldInputPolicy.ProbeHoldDuration.TotalMilliseconds:0} ms using the exact PowerShell-oracle virtual-key path.\n\nWatch Roblox for movement or the W-bound piano note. Continue?",
            "Run Roblox Input Check",
            MessageBoxButtons.OKCancel,
            MessageBoxIcon.Information);
        if (consent != DialogResult.OK)
        {
            return;
        }

        SetBusy(true);
        _status.Text = "Running PowerShell-oracle check… Roblox must remain foreground until the test key is released.";

        try
        {
            var result = await RobloxFieldInputProbe.RunAsync(target).ConfigureAwait(true);
            var nativeAssessment = result.Assess(null);
            ClientDiagnostics.Log(
                $"GUI input check native verdict={nativeAssessment.Verdict}; probe={result.ProbeId}; nativeDelivery={result.NativeDeliveryObserved}; " +
                $"activation={result.ActivationConfirmed}; stableFocus={result.StableForegroundConfirmed}; desktopParity={result.DesktopParity}; " +
                $"keyDown={result.WindowsReportedKeyDown}; foregroundHeld={result.ForegroundHeldDuringProbe}; " +
                $"vk=0x{result.VirtualKey:X2}; heldMs={result.HoldDuration.TotalMilliseconds:0}.");

            Activate();
            if (!result.NativeDeliveryObserved)
            {
                RobloxInputHealthSession.Record(target, nativeAssessment);
                ApplyAssessment(nativeAssessment);
                return;
            }

            var observed = MessageBox.Show(
                this,
                "Did Roblox visibly react to the PowerShell-oracle W test?\n\nChoose Yes only if you saw movement or heard/saw the W-bound piano note.",
                "Confirm Roblox Reaction",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Question) == DialogResult.Yes;

            var assessment = result.Assess(observed);
            RobloxInputForensics.LogVerdict(result.ProbeId, assessment, observed);
            ClientDiagnostics.Log(
                $"GUI input check final verdict={assessment.Verdict}; probe={result.ProbeId}; robloxReacted={observed}; success={assessment.IsSuccess}.");
            RobloxInputHealthSession.Record(target, assessment);
            ApplyAssessment(assessment);

            if (!observed)
            {
                _status.Text += "\n\nA/B next step: run Physical-Key Diagnostic. It tests the same W with a non-zero hardware scan code without changing production playback.";
            }
        }
        catch (OperationCanceledException)
        {
            var assessment = new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.FocusUnstable,
                "The input check was cancelled safely.",
                "No keys remain held. Run the check again when Roblox is ready.",
                false);
            RobloxInputHealthSession.Record(target, assessment);
            ApplyAssessment(assessment);
        }
        catch (Exception exception) when (
            exception is InvalidOperationException
            or ArgumentException
            or System.ComponentModel.Win32Exception)
        {
            ClientDiagnostics.Log($"GUI input check failed: {exception}");
            var assessment = new RobloxInputCheckAssessment(
                RobloxInputCheckVerdict.WindowsKeyStateNotObserved,
                $"Input check failed: {exception.Message}",
                "Open Diagnostics, resolve the Windows/input blocker, then rerun Test Roblox Input.",
                false);
            RobloxInputHealthSession.Record(target, assessment);
            ApplyAssessment(assessment);
        }
        finally
        {
            SetBusy(false);
        }
    }

    private async Task RunPhysicalDiagnosticAsync()
    {
        if (!_physical.Enabled)
        {
            return;
        }

        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _status.Text = "⚠ Roblox Player was not found. Open Roblox before running the physical-key diagnostic.";
            return;
        }

        var consent = MessageBox.Show(
            this,
            $"This diagnostic will focus Roblox and hold '{char.ToUpperInvariant(RobloxFieldInputPolicy.ProbeKey)}' for about {RobloxFieldInputPolicy.ProbeHoldDuration.TotalMilliseconds:0} ms using the same keybd_event API but with the real non-zero keyboard scan code.\n\nThis is diagnostic-only. It cannot confirm or modify normal playback. Continue?",
            "Run Physical-Key Diagnostic",
            MessageBoxButtons.OKCancel,
            MessageBoxIcon.Warning);
        if (consent != DialogResult.OK)
        {
            return;
        }

        SetBusy(true);
        _status.Text = "Running physical-key diagnostic… Roblox must remain foreground until W is released.";

        try
        {
            var result = await RobloxPhysicalKeyDiagnosticProbe.RunAsync(target).ConfigureAwait(true);
            ClientDiagnostics.Log(
                $"GUI physical-key diagnostic probe={result.ProbeId}; nativeDelivery={result.NativeDeliveryObserved}; " +
                $"activation={result.ActivationConfirmed}; stableFocus={result.StableForegroundConfirmed}; desktopParity={result.DesktopParity}; " +
                $"keyDown={result.WindowsReportedKeyDown}; foregroundHeld={result.ForegroundHeldDuringProbe}; " +
                $"vk=0x{result.VirtualKey:X2}; scanCode=0x{result.ScanCode:X2}; heldMs={result.HoldDuration.TotalMilliseconds:0}.");

            Activate();
            if (!result.NativeDeliveryObserved)
            {
                _status.Text = "⚠ The physical-key diagnostic did not establish a safe Windows delivery boundary. Open Diagnostics and inspect the matching PHYSICAL_* INPUT_FORENSIC lines. Production playback was not changed.";
                return;
            }

            var observed = MessageBox.Show(
                this,
                "Did Roblox visibly react to the physical-key W diagnostic?\n\nChoose Yes only if you saw movement or heard/saw the W-bound piano note.",
                "Confirm Physical-Key Reaction",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Question) == DialogResult.Yes;

            RobloxPhysicalKeyDiagnosticProbe.LogHumanVerdict(result, observed);
            ClientDiagnostics.Log(
                $"GUI physical-key diagnostic final probe={result.ProbeId}; robloxReacted={observed}; productionChanged=false.");

            if (observed)
            {
                _status.Text =
                    "⚠ Roblox reacted to the non-zero scan-code diagnostic. This isolates a physical-key/scan-code acceptance difference, but normal playback remains deliberately gated and unchanged.\n\n" +
                    "Next: Open Diagnostics and preserve both the PowerShell-oracle probe and PHYSICAL_* probe IDs. Production must only adopt a new emission semantic after this A/B evidence is reviewed and regression-protected.";
            }
            else
            {
                _status.Text =
                    "⚠ Roblox did not react to the physical-key diagnostic either. Character mapping and simple scan-code presence are now weaker suspects.\n\n" +
                    "Next: run SendInput Diagnostic. It keeps the same physical scan code but changes only the Windows injection API from keybd_event to SendInput. Production playback remains unchanged.";
            }
        }
        catch (OperationCanceledException)
        {
            _status.Text = "⚠ Physical-key diagnostic cancelled safely. A best-effort key-up was sent and production playback was not changed.";
        }
        catch (Exception exception) when (
            exception is InvalidOperationException
            or ArgumentException
            or System.ComponentModel.Win32Exception)
        {
            ClientDiagnostics.Log($"GUI physical-key diagnostic failed: {exception}");
            _status.Text = $"⚠ Physical-key diagnostic failed: {exception.Message}\n\nOpen Diagnostics for the correlated INPUT_FORENSIC evidence. Production playback was not changed.";
        }
        finally
        {
            SetBusy(false);
        }
    }

    private async Task RunSendInputDiagnosticAsync()
    {
        if (!_sendInput.Enabled)
        {
            return;
        }

        var target = RobloxProcessLocator.FindPreferred();
        if (target is null)
        {
            _status.Text = "⚠ Roblox Player was not found. Open Roblox before running the SendInput diagnostic.";
            return;
        }

        var consent = MessageBox.Show(
            this,
            $"This diagnostic will focus Roblox and hold '{char.ToUpperInvariant(RobloxFieldInputPolicy.ProbeKey)}' for about {RobloxFieldInputPolicy.ProbeHoldDuration.TotalMilliseconds:0} ms using Windows SendInput with scan-code semantics.\n\nRun this only after the normal and Physical-Key checks fail. It is diagnostic-only and can never confirm or modify normal playback. Continue?",
            "Run SendInput Diagnostic",
            MessageBoxButtons.OKCancel,
            MessageBoxIcon.Warning);
        if (consent != DialogResult.OK)
        {
            return;
        }

        SetBusy(true);
        _status.Text = "Running SendInput scan-code diagnostic… Roblox must remain foreground until W is released.";

        try
        {
            var result = await RobloxSendInputScanDiagnosticProbe.RunAsync(target).ConfigureAwait(true);
            ClientDiagnostics.Log(
                $"GUI SendInput diagnostic probe={result.ProbeId}; nativeDelivery={result.NativeDeliveryObserved}; " +
                $"activation={result.ActivationConfirmed}; stableFocus={result.StableForegroundConfirmed}; desktopParity={result.DesktopParity}; " +
                $"keyDown={result.WindowsReportedKeyDown}; foregroundHeld={result.ForegroundHeldDuringProbe}; " +
                $"vk=0x{result.VirtualKey:X2}; scanCode=0x{result.ScanCode:X2}; heldMs={result.HoldDuration.TotalMilliseconds:0}.");

            Activate();
            if (!result.NativeDeliveryObserved)
            {
                _status.Text = "⚠ The SendInput diagnostic did not establish a safe Windows delivery boundary. Open Diagnostics and inspect the matching SENDINPUT_* INPUT_FORENSIC lines. Production playback was not changed.";
                return;
            }

            var observed = MessageBox.Show(
                this,
                "Did Roblox visibly react to the SendInput W diagnostic?\n\nChoose Yes only if you saw movement or heard/saw the W-bound piano note.",
                "Confirm SendInput Reaction",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Question) == DialogResult.Yes;

            RobloxSendInputScanDiagnosticProbe.LogHumanVerdict(result, observed);
            ClientDiagnostics.Log(
                $"GUI SendInput diagnostic final probe={result.ProbeId}; robloxReacted={observed}; productionChanged=false.");

            _status.Text = observed
                ? "⚠ Roblox reacted only when the scan code was emitted through SendInput. This isolates an injection-API semantic difference, but normal playback remains deliberately gated and unchanged.\n\nNext: Open Diagnostics and preserve the oracle, PHYSICAL_* and SENDINPUT_* probe IDs before any production backend decision."
                : "⚠ Roblox did not react to the SendInput scan-code diagnostic either. The tested synthetic virtual-key, physical-scan keybd_event and SendInput scan-code paths all failed to produce visible Roblox behavior.\n\nNext: Open Diagnostics and preserve all probe IDs; the remaining boundary is Roblox/game input consumption, environment, overlays/session/security policy, or a requirement not represented by these supported Windows synthetic-input APIs. Production playback remains unchanged.";
        }
        catch (OperationCanceledException)
        {
            _status.Text = "⚠ SendInput diagnostic cancelled safely. A best-effort key-up was sent and production playback was not changed.";
        }
        catch (Exception exception) when (
            exception is InvalidOperationException
            or ArgumentException
            or System.ComponentModel.Win32Exception)
        {
            ClientDiagnostics.Log($"GUI SendInput diagnostic failed: {exception}");
            _status.Text = $"⚠ SendInput diagnostic failed: {exception.Message}\n\nOpen Diagnostics for the correlated INPUT_FORENSIC evidence. Production playback was not changed.";
        }
        finally
        {
            SetBusy(false);
        }
    }

    private void SetBusy(bool busy)
    {
        _run.Enabled = !busy;
        _physical.Enabled = !busy;
        _sendInput.Enabled = !busy;
    }

    private void ApplyAssessment(RobloxInputCheckAssessment assessment)
    {
        var prefix = assessment.IsSuccess ? "✓" : "⚠";
        _status.Text = $"{prefix} {assessment.Summary}\n\nNext: {assessment.NextAction}";
    }

    private static void OpenDiagnostics()
    {
        try
        {
            Directory.CreateDirectory(ClientDiagnostics.DirectoryPath);
            Process.Start(new ProcessStartInfo
            {
                FileName = ClientDiagnostics.DirectoryPath,
                UseShellExecute = true
            });
        }
        catch (Exception exception) when (
            exception is InvalidOperationException
            or System.ComponentModel.Win32Exception
            or IOException
            or UnauthorizedAccessException)
        {
            ClientDiagnostics.Log($"Could not open diagnostics directory: {exception}");
        }
    }
}
