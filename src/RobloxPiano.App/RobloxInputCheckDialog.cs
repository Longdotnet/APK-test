using System.Diagnostics;

namespace RobloxPiano.App;

internal sealed class RobloxInputCheckDialog : Form
{
    private readonly Label _status = new()
    {
        AutoSize = true,
        MaximumSize = new Size(520, 0)
    };
    private readonly Button _run = new() { Text = "Run Input Check", AutoSize = true };
    private readonly Button _diagnostics = new() { Text = "Open Diagnostics", AutoSize = true };
    private readonly Button _close = new() { Text = "Close", AutoSize = true, DialogResult = DialogResult.Cancel };

    public RobloxInputCheckDialog()
    {
        Text = "Roblox Input Check";
        StartPosition = FormStartPosition.CenterParent;
        MinimumSize = new Size(600, 300);
        Size = new Size(640, 350);
        MaximizeBox = false;
        MinimizeBox = false;
        ShowInTaskbar = false;

        var explanation = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(540, 0),
            Text = "Use this when Play appears to run but Roblox produces no notes. The check separates Roblox activation, stable focus, Windows key delivery, and Roblox actually reacting. A confirmed result belongs only to the current Roblox process. No AI or network is used."
        };
        var observation = new Label
        {
            AutoSize = true,
            MaximumSize = new Size(540, 0),
            Text = "When the check starts, watch Roblox. Outside a piano, W should move your character. Inside a piano, it should trigger the W-bound note."
        };
        var buttons = new FlowLayoutPanel { AutoSize = true, Dock = DockStyle.Fill };
        buttons.Controls.AddRange([_run, _diagnostics, _close]);

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
            $"Roblox Piano will focus Roblox and hold '{char.ToUpperInvariant(RobloxFieldInputPolicy.ProbeKey)}' for about {RobloxFieldInputPolicy.ProbeHoldDuration.TotalMilliseconds:0} ms.\n\nWatch Roblox for movement or the W-bound piano note. Continue?",
            "Run Roblox Input Check",
            MessageBoxButtons.OKCancel,
            MessageBoxIcon.Information);
        if (consent != DialogResult.OK)
        {
            return;
        }

        _run.Enabled = false;
        _status.Text = "Running check… Roblox must remain foreground until the test key is released.";

        try
        {
            var result = await RobloxFieldInputProbe.RunAsync(target).ConfigureAwait(true);
            var nativeAssessment = result.Assess(null);
            ClientDiagnostics.Log(
                $"GUI input check native verdict={nativeAssessment.Verdict}; probe={result.ProbeId}; nativeDelivery={result.NativeDeliveryObserved}; " +
                $"activation={result.ActivationConfirmed}; stableFocus={result.StableForegroundConfirmed}; " +
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
                "Did Roblox visibly react to the W test?\n\nChoose Yes only if you saw movement or heard/saw the W-bound piano note.",
                "Confirm Roblox Reaction",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Question) == DialogResult.Yes;

            var assessment = result.Assess(observed);
            RobloxInputForensics.LogVerdict(result.ProbeId, assessment, observed);
            ClientDiagnostics.Log(
                $"GUI input check final verdict={assessment.Verdict}; probe={result.ProbeId}; robloxReacted={observed}; success={assessment.IsSuccess}.");
            RobloxInputHealthSession.Record(target, assessment);
            ApplyAssessment(assessment);
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
            _run.Enabled = true;
        }
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
