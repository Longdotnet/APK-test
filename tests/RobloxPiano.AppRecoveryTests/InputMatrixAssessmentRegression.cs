using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class InputMatrixAssessmentRegression
{
    private static readonly RobloxInputMatrixSessionIdentity SessionA = new(
        new RobloxProcessIdentity(100, 1_000),
        0x1111);

    [ModuleInitializer]
    internal static void Verify()
    {
        RobloxInputMatrixProbeEvidenceRegistry.ResetForDiagnostics();

        var noEvidence = Assess(Array.Empty<RobloxInputMatrixCellEvidence>());
        Equal(RobloxInputMatrixVerdict.InsufficientEvidence, noEvidence.Verdict, "empty matrix verdict");
        Contains(noEvidence.PendingCells, "REAL_KEY", "empty matrix must request real baseline");

        var invalidReal = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_NO_REACTION", false)
        ]);
        Equal(RobloxInputMatrixVerdict.RealKeyBaselineInvalid, invalidReal.Verdict, "real-key no-reaction verdict");
        Equal("REAL_KEY_BASELINE", invalidReal.FailureBoundary, "real-key failure boundary");

        var incompleteSynthetic = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("POWERSHELL_ORACLE", "ROBLOX_NO_REACTION", false),
            Cell("KEYBD_EVENT_SCAN", "WINDOWS_BOUNDARY_NOT_CONFIRMED", null)
        ]);
        Equal(RobloxInputMatrixVerdict.InsufficientEvidence, incompleteSynthetic.Verdict, "incomplete synthetic matrix verdict");
        Contains(incompleteSynthetic.PendingCells, "KEYBD_EVENT_SCAN", "Windows-boundary failure must remain pending");
        Contains(incompleteSynthetic.PendingCells, "SENDINPUT_VK", "unrun synthetic cell must remain pending");

        var winner = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("POWERSHELL_ORACLE", "ROBLOX_NO_REACTION", false),
            Cell("KEYBD_EVENT_SCAN", "ROBLOX_REACTED", true)
        ]);
        Equal(RobloxInputMatrixVerdict.SyntheticVariantWorks, winner.Verdict, "synthetic winner verdict");
        Equal("SYNTHETIC_VARIANT_REACHES_ROBLOX", winner.FailureBoundary, "synthetic winner boundary");
        Contains(winner.WinningCells, "KEYBD_EVENT_SCAN", "winning semantics must be explicit");
        if (!winner.IsConclusive)
        {
            throw new InvalidOperationException("A field-reacting provenance-clean synthetic variant must produce a conclusive matrix assessment.");
        }

        var allSyntheticFail = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("POWERSHELL_ORACLE", "ROBLOX_NO_REACTION", false),
            Cell("KEYBD_EVENT_SCAN", "ROBLOX_NO_REACTION", false),
            Cell("SENDINPUT_VK", "ROBLOX_NO_REACTION", false),
            Cell("SENDINPUT_SCAN", "ROBLOX_NO_REACTION", false)
        ]);
        Equal(RobloxInputMatrixVerdict.RealKeyWorksSyntheticFails, allSyntheticFail.Verdict, "real works / synthetic fails verdict");
        Equal("POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION", allSyntheticFail.FailureBoundary, "isolated failure boundary");
        Equal(4, allSyntheticFail.FailingCells.Count, "all synthetic failures must be retained");
        Equal(0, allSyntheticFail.PendingCells.Count, "conclusive matrix must have no pending cells");
        if (!allSyntheticFail.IsConclusive)
        {
            throw new InvalidOperationException("A complete real-works/all-provenance-clean-synthetic-fails matrix must be conclusive.");
        }

        const string contaminatedWinnerProbe = "contaminated-winner";
        RecordContaminated(contaminatedWinnerProbe);
        var contaminatedWinner = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            RawCell("KEYBD_EVENT_SCAN", "ROBLOX_REACTED", true, contaminatedWinnerProbe)
        ]);
        Equal(RobloxInputMatrixVerdict.InsufficientEvidence, contaminatedWinner.Verdict, "contaminated synthetic winner must fail closed");
        Contains(contaminatedWinner.PendingCells, "KEYBD_EVENT_SCAN", "contaminated winner must be pending");
        if (contaminatedWinner.IsConclusive || contaminatedWinner.WinningCells.Count != 0)
        {
            throw new InvalidOperationException("A physical-W-contaminated synthetic Yes answer must never prove a synthetic winner.");
        }

        const string contaminatedFailureProbe = "contaminated-failure";
        RecordContaminated(contaminatedFailureProbe);
        var contaminatedFailure = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("POWERSHELL_ORACLE", "ROBLOX_NO_REACTION", false),
            RawCell("KEYBD_EVENT_SCAN", "ROBLOX_NO_REACTION", false, contaminatedFailureProbe),
            Cell("SENDINPUT_VK", "ROBLOX_NO_REACTION", false),
            Cell("SENDINPUT_SCAN", "ROBLOX_NO_REACTION", false)
        ]);
        Equal(RobloxInputMatrixVerdict.InsufficientEvidence, contaminatedFailure.Verdict, "contaminated all-fail matrix must fail closed");
        Contains(contaminatedFailure.PendingCells, "KEYBD_EVENT_SCAN", "contaminated no-reaction must remain pending");
        if (contaminatedFailure.IsConclusive)
        {
            throw new InvalidOperationException("A contaminated synthetic No answer must never establish POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION.");
        }

        var missingProvenance = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            RawCell("SENDINPUT_SCAN", "ROBLOX_REACTED", true, "missing-provenance")
        ]);
        Equal(RobloxInputMatrixVerdict.InsufficientEvidence, missingProvenance.Verdict, "missing synthetic provenance must fail closed");
        Contains(missingProvenance.PendingCells, "SENDINPUT_SCAN", "missing provenance winner must be pending");
        if (missingProvenance.IsConclusive)
        {
            throw new InvalidOperationException("A synthetic reaction without retained target-key provenance must never be conclusive.");
        }

        var processRestart = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("POWERSHELL_ORACLE", "ROBLOX_NO_REACTION", false),
            Cell("KEYBD_EVENT_SCAN", "ROBLOX_NO_REACTION", false),
            Cell("SENDINPUT_VK", "ROBLOX_NO_REACTION", false),
            Cell("SENDINPUT_SCAN", "ROBLOX_NO_REACTION", false, session: new RobloxInputMatrixSessionIdentity(new RobloxProcessIdentity(100, 2_000), 0x1111))
        ]);
        Equal(RobloxInputMatrixVerdict.SessionContinuityInvalid, processRestart.Verdict, "process restart must invalidate matrix");
        Equal("ROBLOX_SESSION_CHANGED", processRestart.FailureBoundary, "process restart boundary");
        if (processRestart.IsConclusive)
        {
            throw new InvalidOperationException("Evidence spanning two Roblox process lifetimes must never be conclusive.");
        }

        var windowReplacement = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("POWERSHELL_ORACLE", "ROBLOX_NO_REACTION", false, session: new RobloxInputMatrixSessionIdentity(new RobloxProcessIdentity(100, 1_000), 0x2222))
        ]);
        Equal(RobloxInputMatrixVerdict.SessionContinuityInvalid, windowReplacement.Verdict, "selected HWND change must invalidate matrix");
        Equal("ROBLOX_SESSION_CHANGED", windowReplacement.FailureBoundary, "window replacement boundary");

        var missingIdentity = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            new RobloxInputMatrixCellEvidence("KEYBD_EVENT_SCAN", "missing", "ROBLOX_REACTED", true, null)
        ]);
        Equal(RobloxInputMatrixVerdict.SessionContinuityInvalid, missingIdentity.Verdict, "missing session identity must fail closed");
        Equal("MATRIX_SESSION_IDENTITY_UNAVAILABLE", missingIdentity.FailureBoundary, "missing session boundary");
        if (missingIdentity.IsConclusive)
        {
            throw new InvalidOperationException("A synthetic winner without stable session identity must not be conclusive.");
        }

        var unboundLegacyEvidence = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            new RobloxInputMatrixCellEvidence("SENDINPUT_VK", "unbound", "ROBLOX_REACTED", true)
        ]);
        Equal(RobloxInputMatrixVerdict.SessionContinuityInvalid, unboundLegacyEvidence.Verdict, "unbound evidence must never post-hoc capture the current Roblox target");
        Equal("MATRIX_SESSION_IDENTITY_UNAVAILABLE", unboundLegacyEvidence.FailureBoundary, "unbound evidence boundary");
        if (unboundLegacyEvidence.IsConclusive)
        {
            throw new InvalidOperationException("Evidence without a probe-start identity must fail closed even when Roblox visibly reacted.");
        }

        var currentIdentityUnavailable = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("KEYBD_EVENT_SCAN", "ROBLOX_REACTED", true)
        ],
        currentSessionIdentity: null);
        Equal(RobloxInputMatrixVerdict.SessionContinuityInvalid, currentIdentityUnavailable.Verdict, "missing current reaction context must fail closed");
        Equal("REACTION_CONTEXT_IDENTITY_UNAVAILABLE", currentIdentityUnavailable.FailureBoundary, "missing current reaction context boundary");
        if (currentIdentityUnavailable.IsConclusive)
        {
            throw new InvalidOperationException("A human reaction cannot become conclusive after the current Roblox identity becomes unavailable.");
        }

        var changedAfterProbe = RobloxInputMatrixAssessmentPolicy.Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("KEYBD_EVENT_SCAN", "ROBLOX_REACTED", true)
        ],
        new RobloxInputMatrixSessionIdentity(new RobloxProcessIdentity(100, 2_000), 0x2222));
        Equal(RobloxInputMatrixVerdict.SessionContinuityInvalid, changedAfterProbe.Verdict, "post-probe session change must invalidate reaction attribution");
        Equal("REACTION_CONTEXT_CHANGED", changedAfterProbe.FailureBoundary, "post-probe session change boundary");
        if (changedAfterProbe.IsConclusive)
        {
            throw new InvalidOperationException("A stale Yes/No answer must never prove a synthetic winner after Roblox changed session.");
        }

        var latestCellWins = Assess(
        [
            Cell("REAL_KEY", "ROBLOX_REACTED", true),
            Cell("SENDINPUT_VK", "WINDOWS_BOUNDARY_NOT_CONFIRMED", null, "old", new RobloxInputMatrixSessionIdentity(new RobloxProcessIdentity(100, 9_999), 0x9999)),
            Cell("SENDINPUT_VK", "ROBLOX_REACTED", true, "retry", SessionA)
        ]);
        Equal(RobloxInputMatrixVerdict.SyntheticVariantWorks, latestCellWins.Verdict, "latest retry must replace stale cross-session cell evidence");
        Contains(latestCellWins.WinningCells, "SENDINPUT_VK", "retry winner must be preserved");
    }

    private static RobloxInputMatrixAssessment Assess(RobloxInputMatrixCellEvidence[] evidence)
        => RobloxInputMatrixAssessmentPolicy.Assess(evidence, SessionA);

    private static RobloxInputMatrixCellEvidence Cell(
        string cell,
        string verdict,
        bool? reacted,
        string probe = "probe",
        RobloxInputMatrixSessionIdentity? session = null)
    {
        if (!cell.Equals("REAL_KEY", StringComparison.Ordinal))
        {
            RecordClean(probe);
        }

        return RawCell(cell, verdict, reacted, probe, session);
    }

    private static RobloxInputMatrixCellEvidence RawCell(
        string cell,
        string verdict,
        bool? reacted,
        string probe,
        RobloxInputMatrixSessionIdentity? session = null)
        => new(cell, probe, verdict, reacted, session ?? SessionA);

    private static void RecordClean(string probe)
        => RobloxInputMatrixProbeEvidenceRegistry.Record(
            probe,
            new WindowsLowLevelKeyboardProvenanceSnapshot(
                true,
                true,
                true,
                WindowsLowLevelKeyboardProvenance.LlkhfInjected,
                WindowsLowLevelKeyboardProvenance.LlkhfInjected,
                0x11,
                0x11,
                WindowsLowLevelKeyboardProvenanceKind.Injected,
                WindowsLowLevelKeyboardProvenanceKind.Injected)
            {
                TargetEventCount = 2,
                InjectedTargetEventCount = 2,
                UnexpectedTargetTransitionObserved = false
            });

    private static void RecordContaminated(string probe)
        => RobloxInputMatrixProbeEvidenceRegistry.Record(
            probe,
            new WindowsLowLevelKeyboardProvenanceSnapshot(
                true,
                true,
                true,
                WindowsLowLevelKeyboardProvenance.LlkhfInjected,
                WindowsLowLevelKeyboardProvenance.LlkhfInjected,
                0x11,
                0x11,
                WindowsLowLevelKeyboardProvenanceKind.Injected,
                WindowsLowLevelKeyboardProvenanceKind.Injected)
            {
                TargetEventCount = 3,
                NotInjectedTargetEventCount = 1,
                InjectedTargetEventCount = 2,
                UnexpectedTargetTransitionObserved = true
            });

    private static void Equal<T>(T expected, T actual, string name)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{name}: expected '{expected}', got '{actual}'.");
        }
    }

    private static void Contains(IReadOnlyList<string> values, string expected, string name)
    {
        if (!values.Contains(expected, StringComparer.Ordinal))
        {
            throw new InvalidOperationException($"{name}: expected '{expected}' in [{string.Join(",", values)}].");
        }
    }
}
