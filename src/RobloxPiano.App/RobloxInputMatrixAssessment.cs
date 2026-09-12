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
    RobloxInputMatrixSessionIdentity? SessionIdentity,
    RobloxInputMatrixSyntheticProvenanceAssessment? BoundSyntheticProvenance)
{
    public RobloxInputMatrixCellEvidence(
        string cell,
        string probeId,
        string verdict,
        bool? robloxReaction,
        RobloxInputMatrixSessionIdentity? sessionIdentity)
        : this(
            cell,
            probeId,
            verdict,
            robloxReaction,
            sessionIdentity,
            CaptureSyntheticProvenance(cell, probeId))
    {
    }

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

    public RobloxInputMatrixSyntheticProvenanceTrust SyntheticProvenanceTrust => IsRealKey
        ? RobloxInputMatrixSyntheticProvenanceTrust.Clean
        : BoundSyntheticProvenance?.Trust ?? RobloxInputMatrixSyntheticProvenanceTrust.Missing;

    public RobloxInputMatrixSyntheticProvenanceReason SyntheticProvenanceReason => IsRealKey
        ? RobloxInputMatrixSyntheticProvenanceReason.CleanInjectedPair
        : BoundSyntheticProvenance?.Reason ?? RobloxInputMatrixSyntheticProvenanceReason.MissingSnapshot;

    public bool SyntheticProvenanceTrusted => !IsSynthetic
        || SyntheticProvenanceTrust == RobloxInputMatrixSyntheticProvenanceTrust.Clean;

    public bool WindowsBoundaryConfirmed => Verdict is "ROBLOX_REACTED" or "ROBLOX_NO_REACTION"
        && SyntheticProvenanceTrusted;

    public bool Reacted => WindowsBoundaryConfirmed
        && RobloxReaction == true
        && Verdict == "ROBLOX_REACTED";

    public bool ExplicitNoReaction => WindowsBoundaryConfirmed
        && RobloxReaction == false
        && Verdict == "ROBLOX_NO_REACTION";

    private static RobloxInputMatrixSyntheticProvenanceAssessment? CaptureSyntheticProvenance(
        string cell,
        string probeId)
        => cell.Equals("REAL_KEY", StringComparison.Ordinal)
            ? null
            : RobloxInputMatrixProbeEvidenceRegistry.GetAssessment(probeId);
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

        var currentSession = CaptureCurrentSessionIdentity();
        return Assess(evidence, currentSession);
    }

    internal static RobloxInputMatrixAssessment Assess(
        IEnumerable<RobloxInputMatrixCellEvidence> evidence,
        RobloxInputMatrixSessionIdentity? currentSessionIdentity)
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
        var contaminated = synthetic
            .Where(item => item is not null
                && item.SyntheticProvenanceTrust == RobloxInputMatrixSyntheticProvenanceTrust.Contaminated)
            .Select(item => item!.Cell)
            .ToArray();
        var missingProvenance = synthetic
            .Where(item => item is not null
                && item.SyntheticProvenanceTrust == RobloxInputMatrixSyntheticProvenanceTrust.Missing)
            .Select(item => item!.Cell)
            .ToArray();

        var continuity = AssessSessionContinuity(cells.Values, currentSessionIdentity);
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
                $"Roblox visibly reacted to provenance-clean synthetic variant(s): {string.Join(",", winners)}.",
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

        if (contaminated.Length > 0)
        {
            var reasons = synthetic
                .Where(item => item is not null
                    && item.SyntheticProvenanceTrust == RobloxInputMatrixSyntheticProvenanceTrust.Contaminated)
                .Select(item => $"{item!.Cell}:{item.SyntheticProvenanceReason}")
                .ToArray();
            return Incomplete(
                $"Rerun contaminated synthetic cell(s): {string.Join(",", reasons)}. The reaction-bound provenance for those exact attempts is not safe to attribute to synthetic input.",
                failures,
                pending);
        }

        if (missingProvenance.Length > 0)
        {
            return Incomplete(
                $"Rerun synthetic cell(s) without reaction-bound low-level provenance: {string.Join(",", missingProvenance)}. A Roblox reaction answer cannot become matrix evidence unless that exact cell captured a clean target-W provenance assessment when the result was retained.",
                failures,
                pending);
        }

        if (pending.Length > 0)
        {
            return Incomplete(
                "Real W visibly reached Roblox. Complete every synthetic cell with confirmed Windows delivery and clean reaction-bound low-level provenance on the same Roblox process lifetime and selected window.",
                failures,
                pending);
        }

        if (failures.Length == SyntheticCells.Length)
        {
            return new RobloxInputMatrixAssessment(
                RobloxInputMatrixVerdict.RealKeyWorksSyntheticFails,
                "POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION",
                "Real W visibly reached Roblox while every provenance-clean synthetic variant reached the Windows boundary but produced no visible Roblox reaction in one trusted Roblox process/window session.",
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

    private static RobloxInputMatrixSessionIdentity? CaptureCurrentSessionIdentity()
    {
        var target = RobloxProcessLocator.FindPreferred();
        if (target is null || !RobloxInputMatrixSessionIdentity.TryCapture(target, out var identity))
        {
            ClientDiagnostics.Log(
                "INPUT_MATRIX_REACTION_CONTEXT stage=ASSESS_CURRENT identity=UNAVAILABLE reactionContextTrusted=false authorizesPlayback=false.");
            return null;
        }

        ClientDiagnostics.Log(
            $"INPUT_MATRIX_REACTION_CONTEXT stage=ASSESS_CURRENT identity={identity.ToLogToken()} reactionContextTrusted=true authorizesPlayback=false.");
        return identity;
    }

    private static (string Boundary, string Summary, string NextAction)? AssessSessionContinuity(
        IEnumerable<RobloxInputMatrixCellEvidence> evidence,
        RobloxInputMatrixSessionIdentity? currentSessionIdentity)
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

        if (currentSessionIdentity is null)
        {
            return (
                "REACTION_CONTEXT_IDENTITY_UNAVAILABLE",
                "The current Roblox process/window identity could not be re-established when the field reaction was assessed, so the human Yes/No observation cannot be safely attributed to retained probe evidence.",
                "Keep Roblox open and stable, then retry the current matrix cell. Do not use the previous reaction answer as field evidence.");
        }

        if (sessions[0] != currentSessionIdentity.Value)
        {
            return (
                "REACTION_CONTEXT_CHANGED",
                "Roblox changed process lifetime or selected HWND before the retained field reaction could be assessed. The human Yes/No response is stale relative to the probe-bound session.",
                "Discard this reaction attribution, keep Roblox on one stable surface, then retry the current matrix cell. Do not combine the stale response with the new Roblox session.");
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
