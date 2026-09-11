namespace RobloxPiano.App;

internal enum RobloxInputMatrixVerdict
{
    InsufficientEvidence,
    RealKeyBaselineInvalid,
    RealKeyWorksSyntheticFails,
    SyntheticVariantWorks
}

internal sealed record RobloxInputMatrixCellEvidence(
    string Cell,
    string ProbeId,
    string Verdict,
    bool? RobloxReaction)
{
    public bool IsRealKey => Cell.Equals("REAL_KEY", StringComparison.Ordinal);
    public bool IsSynthetic => !IsRealKey;
    public bool WindowsBoundaryConfirmed => IsRealKey
        ? Verdict is "ROBLOX_REACTED" or "ROBLOX_NO_REACTION"
        : Verdict is "ROBLOX_REACTED" or "ROBLOX_NO_REACTION";
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
                "Real W visibly reached Roblox. Complete every synthetic cell with confirmed Windows delivery on the same Roblox surface/session.",
                failures,
                pending);
        }

        if (failures.Length == SyntheticCells.Length)
        {
            return new RobloxInputMatrixAssessment(
                RobloxInputMatrixVerdict.RealKeyWorksSyntheticFails,
                "POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION",
                "Real W visibly reached Roblox while every synthetic variant reached the Windows boundary but produced no visible Roblox reaction.",
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
