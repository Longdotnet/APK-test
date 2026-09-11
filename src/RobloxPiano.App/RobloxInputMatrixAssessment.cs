namespace RobloxPiano.App;

internal enum RobloxInputMatrixVerdict
{
    InsufficientEvidence,
    RealKeyBaselineInvalid,
    SessionContinuityInvalid,
    RealKeyWorksSyntheticFails,
    SyntheticVariantWorks
}

internal sealed record RobloxInputMatrixCellEvidence(
    string Cell,
    string ProbeId,
    string Verdict,
    bool? RobloxReaction,
    RobloxInputMatrixSessionIdentity? SessionIdentity)
{
    public RobloxInputMatrixCellEvidence(
        string cell,
        string probeId,
        string verdict,
        bool? robloxReaction)
        : this(cell, probeId, verdict, robloxReaction, null)
    {
    }

    public bool IsRealKey => Cell.Equals("REAL_KEY", StringComparison.Ordinal);
    public bool IsSynthetic => !IsRealKey;
    public bool WindowsBoundaryConfirmed => Verdict is "ROBLOX_REACTED" or "ROBLOX_NO_REACTION";
    public bool Reacted => RobloxReaction == true && Verdict == "ROBLOX_REACTED";
    public bool ExplicitNoReaction => RobloxReaction == false && Verdict == "ROBLOX_NO_REACTION";
}

internal sealed record RobloxInputMatrixAssessment(
    RobloxInputMatrixVerdict Verdict,
    string FailureBoundary,
    string Summary,
    string NextAction,
    IReadOnlyList<string> WinningCells,
    IReadOnlyList<string> FailingCells,
    IReadOnlyList<string> PendingCells)
{
    public bool IsConclusive => Verdict is RobloxInputMatrixVerdict.RealKeyWorksSyntheticFails
        or RobloxInputMatrixVerdict.SyntheticVariantWorks;
}

internal static class RobloxInputMatrixAssessmentPolicy
{
    internal static readonly string[] SyntheticCells =
    [
        "POWERSHELL_ORACLE",
        "KEYBD_EVENT_SCAN",
        "SENDINPUT_VK",
        "SENDINPUT_SCAN"
    ];

    public static RobloxInputMatrixAssessment Assess(IEnumerable<RobloxInputMatrixCellEvidence> evidence)
    {
        ArgumentNullException.ThrowIfNull(evidence);

        var cells = evidence
            .GroupBy(item => item.Cell, StringComparer.Ordinal)
            .ToDictionary(group => group.Key, group => group.Last(), StringComparer.Ordinal);

        cells.TryGetValue("REAL_KEY", out var realKey);
        var synthetic = SyntheticCells
            .Select(cell => cells.TryGetValue(cell, out var item) ? item : null)
            .ToArray();
        var winners = synthetic.Where(item => item?.Reacted == true).Select(item => item!.Cell).ToArray();
        var failures = synthetic.Where(item => item?.ExplicitNoReaction == true).Select(item => item!.Cell).ToArray();
        var pending = SyntheticCells
            .Where(cell => !cells.TryGetValue(cell, out var item) || !item.WindowsBoundaryConfirmed)
            .ToArray();

        var continuity = AssessSessionContinuity(cells.Values);
        if (continuity is not null)
        {
            return new RobloxInputMatrixAssessment(
                RobloxInputMatrixVerdict.SessionContinuityInvalid,
                continuity.Value.Boundary,
                continuity.Value.Summary,
                continuity.Value.NextAction,
                Array.Empty<string>(),
                failures,
                pending);
        }

        if (winners.Length > 0)
        {
            return new RobloxInputMatrixAssessment(
                RobloxInputMatrixVerdict.SyntheticVariantWorks,
                "SYNTHETIC_VARIANT_REACHES_ROBLOX",
                $"Roblox visibly reacted to synthetic variant(s): {string.Join(",", winners)}.",
                "Preserve this matrix ID and exact winning semantics. Do not change production playback until the winning path is regression-protected and reviewed against the PowerShell oracle and safety invariants.",
                winners,
                failures,
                pending);
        }

        if (realKey is null)
        {
            return Incomplete(
                "Run Real-Key Baseline first on the same selected Roblox surface.",
                failures,
                pending.Prepend("REAL_KEY").ToArray());
        }

        if (!realKey.WindowsBoundaryConfirmed || !realKey.Reacted)
        {
            return new RobloxInputMatrixAssessment(
                RobloxInputMatrixVerdict.RealKeyBaselineInvalid,
                "REAL_KEY_BASELINE",
                realKey.Verdict == "ROBLOX_NO_REACTION"
                    ? "Windows observed the real-key baseline, but Roblox did not visibly react."
                    : "The real-key baseline is incomplete or untrusted.",
                "Establish a trusted real W down/up on the selected Roblox surface and confirm visible Roblox reaction before comparing synthetic paths.",
                Array.Empty<string>(),
                failures,
                pending);
        }

        if (pending.Length > 0)
        {
            return Incomplete(
                "Real W visibly reached Roblox. Complete every synthetic cell with confirmed Windows delivery on the same Roblox process lifetime and selected window.",
                failures,
                pending);
        }

        if (failures.Length == SyntheticCells.Length)
        {
            return new RobloxInputMatrixAssessment(
                RobloxInputMatrixVerdict.RealKeyWorksSyntheticFails,
                "POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION",
                "Real W visibly reached Roblox while every synthetic variant reached the Windows boundary but produced no visible Roblox reaction in one trusted Roblox process/window session.",
                "Treat focus/basic target selection as a weak suspect. Preserve this matrix and investigate Roblox/device-origin consumption semantics before adding another synthetic backend.",
                Array.Empty<string>(),
                failures,
                Array.Empty<string>());
        }

        return Incomplete(
            "The matrix contains evidence that cannot yet produce a deterministic cross-cell verdict.",
            failures,
            pending);
    }

    private static (string Boundary, string Summary, string NextAction)? AssessSessionContinuity(
        IEnumerable<RobloxInputMatrixCellEvidence> evidence)
    {
        var items = evidence.ToArray();
        if (items.Length == 0)
        {
            return null;
        }

        if (items.Any(item => item.SessionIdentity is null))
        {
            return (
                "MATRIX_SESSION_IDENTITY_UNAVAILABLE",
                "At least one matrix cell could not establish a probe-bound Roblox PID/start-time/window identity, so cross-cell evidence is not comparable.",
                "Keep Roblox open, close and reopen Roblox Input Check, then rerun the matrix from Real-Key Baseline. Do not combine this evidence with a previous session.");
        }

        var sessions = items
            .Select(item => item.SessionIdentity!.Value)
            .Distinct()
            .ToArray();
        if (sessions.Length > 1)
        {
            return (
                "ROBLOX_SESSION_CHANGED",
                "Matrix cells belong to different Roblox process lifetimes or selected HWNDs. A cross-session result cannot establish an input boundary.",
                "Close and reopen Roblox Input Check after Roblox stabilizes, then rerun every cell on the same Roblox process/window. Evidence from the previous lifetime stays diagnostic-only.");
        }

        return null;
    }

    private static RobloxInputMatrixAssessment Incomplete(
        string nextAction,
        IReadOnlyList<string> failures,
        IReadOnlyList<string> pending)
        => new(
            RobloxInputMatrixVerdict.InsufficientEvidence,
            "MATRIX_INCOMPLETE",
            "The real-vs-synthetic field matrix is not complete enough to isolate the Roblox input boundary.",
            nextAction,
            Array.Empty<string>(),
            failures,
            pending);
}
