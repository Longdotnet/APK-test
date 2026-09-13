using RobloxPiano.App;
using RobloxPiano.Audio;

namespace RobloxPiano.AudioUxTests;

internal static class Program
{
    public static int Main()
    {
        var failures = new List<string>();
        Run("search identity wins over audio filename", SearchIdentityWins, failures);
        Run("blank identity falls back to audio filename", FilenameFallback, failures);
        Run("identity whitespace and controls normalize deterministically", WhitespaceNormalizes, failures);
        Run("empty identity and path get safe generated title", EmptyFallback, failures);
        Run("long identity is bounded deterministically", LongIdentityBounded, failures);
        Run("verified reference handoff preserves search identity", VerifiedReferencePreservesSearchIdentity, failures);
        Run("verified reference handoff falls back to reference filename", VerifiedReferenceFallsBackToFilename, failures);
        Run("verified reference handoff rejects blank path", VerifiedReferenceRejectsBlankPath, failures);
        Run("find-or-create plan preserves one normalized reference", FindOrCreatePlanPreservesReference, failures);
        Run("find-or-create plan bounds candidate work", FindOrCreatePlanBoundsCandidates, failures);
        Run("find-or-create prefers verified existing source only with high confidence", FindOrCreateDecisionRequiresHighConfidence, failures);
        Run("find-or-create falls back to owned audio without high confidence", FindOrCreateDecisionFallsBack, failures);
        Run("repair quality presentation surfaces authoritative improvement", RepairQualityPresentationShowsImprovement, failures);
        Run("repair quality presentation keeps persistent source evidence visible", RepairQualityPresentationKeepsPersistentEvidence, failures);
        Run("repair quality presentation surfaces introduced regression", RepairQualityPresentationShowsRegression, failures);
        Run("resumable review draft replays deterministic canonical state", AudioReviewDraftStoreRegression.Run, failures);
        Run("long-song review drafts stay within write amplification budget", AudioReviewDraftWriteAmplificationRegression.Run, failures);
        Run("review draft lookup index is disposable and fail-safe", AudioReviewDraftLookupIndexRegression.Run, failures);
        Run("review draft discovery stays within read I/O budget", AudioReviewDraftDiscoveryReadBudgetRegression.Run, failures);
        Run("review writer and destructive GC share a crash-recoverable lease", AudioReviewDraftStorageLeaseRegression.Run, failures);

        Console.WriteLine($"Audio UX regressions: {20 - failures.Count} passed, {failures.Count} failed.");
        foreach (var failure in failures)
            Console.Error.WriteLine(failure);
        return failures.Count == 0 ? 0 : 1;
    }

    private static void SearchIdentityWins()
        => Equal("Popular Song 2026", AudioToPianoSongIdentity.Normalize(" Popular Song 2026 ", @"C:\owned\random-capture.wav"));

    private static void FilenameFallback()
        => Equal("reference mix", AudioToPianoSongIdentity.Normalize("  ", @"C:\owned\reference mix.wav"));

    private static void WhitespaceNormalizes()
        => Equal("Popular Song Name", AudioToPianoSongIdentity.Normalize("  Popular\n Song\tName\r\n ", @"C:\owned\ignored.wav"));

    private static void EmptyFallback()
        => Equal("Generated Piano", AudioToPianoSongIdentity.Normalize(null, string.Empty));

    private static void LongIdentityBounded()
    {
        var title = new string('A', AudioToPianoSongIdentity.MaxTitleLength + 40);
        var normalized = AudioToPianoSongIdentity.Normalize(title, @"C:\owned\ignored.wav");
        Equal(AudioToPianoSongIdentity.MaxTitleLength, normalized.Length);
        Equal(new string('A', AudioToPianoSongIdentity.MaxTitleLength), normalized);
    }

    private static void VerifiedReferencePreservesSearchIdentity()
    {
        var handoff = AudioToPianoCreatePrefill.From(" Popular Song 2026 ", @"C:\owned\reference mix.wav");
        Equal("Popular Song 2026", handoff.SongIdentity);
        Equal(Path.GetFullPath(@"C:\owned\reference mix.wav"), handoff.AudioPath);
    }

    private static void VerifiedReferenceFallsBackToFilename()
    {
        var handoff = AudioToPianoCreatePrefill.From("  ", @"C:\owned\reference mix.wav");
        Equal("reference mix", handoff.SongIdentity);
        Equal(Path.GetFullPath(@"C:\owned\reference mix.wav"), handoff.AudioPath);
    }

    private static void VerifiedReferenceRejectsBlankPath()
    {
        try
        {
            _ = AudioToPianoCreatePrefill.From("Song", "  ");
            throw new InvalidOperationException("blank path was accepted");
        }
        catch (ArgumentException)
        {
        }
    }

    private static void FindOrCreatePlanPreservesReference()
    {
        var plan = AudioFindOrCreatePlan.From("  Popular Song 2026  ", @"C:\owned\reference mix.wav", 5);
        Equal("Popular Song 2026", plan.SongIdentity);
        Equal(Path.GetFullPath(@"C:\owned\reference mix.wav"), plan.AudioPath);
        Equal(5, plan.CandidateLimit);
    }

    private static void FindOrCreatePlanBoundsCandidates()
    {
        try
        {
            _ = AudioFindOrCreatePlan.From("Song", @"C:\owned\song.wav", AudioFindOrCreatePlan.MaxCandidateLimit + 1);
            throw new InvalidOperationException("unbounded candidate count was accepted");
        }
        catch (ArgumentOutOfRangeException)
        {
        }
    }

    private static void FindOrCreateDecisionRequiresHighConfidence()
    {
        var plan = AudioFindOrCreatePlan.From("Song", @"C:\owned\song.wav", 5);
        Equal(AudioFindOrCreateOutcome.PreferVerifiedExistingSource, plan.Decide(1));
    }

    private static void FindOrCreateDecisionFallsBack()
    {
        var plan = AudioFindOrCreatePlan.From("Song", @"C:\owned\song.wav", 5);
        Equal(AudioFindOrCreateOutcome.CreateFromOwnedAudio, plan.Decide(0));
    }

    private static void RepairQualityPresentationShowsImprovement()
    {
        var before = Quality(AudioTranscriptionReadiness.NeedsReview, 0.45, 0.40, 0.60, 18.0, ["EVENT_DENSITY_HIGH", "MEAN_ACTIVATION_LOW"]);
        var current = Quality(AudioTranscriptionReadiness.Ready, 0.78, 0.18, 0.82, 8.0, []);
        var presentation = AudioRepairQualityPresenter.From(AudioTranscriptionQualityDeltaEvaluator.Compare(before, current));

        Equal(AudioTranscriptionReadiness.Ready, presentation.Readiness);
        Equal(true, presentation.Improved);
        Equal(false, presentation.Regressed);
        Contains("NeedsReview → Ready", presentation.Summary);
        Contains("density 18.0 → 8.0 events/s", presentation.Summary);
        Contains("Resolved: EVENT_DENSITY_HIGH, MEAN_ACTIVATION_LOW", presentation.Summary);
    }

    private static void RepairQualityPresentationKeepsPersistentEvidence()
    {
        var before = Quality(AudioTranscriptionReadiness.NeedsReview, 0.45, 0.40, 0.60, 18.0, ["EVENT_DENSITY_HIGH", "MEAN_ACTIVATION_LOW"]);
        var current = Quality(AudioTranscriptionReadiness.NeedsReview, 0.72, 0.20, 0.80, 8.0, ["MEAN_ACTIVATION_LOW"]);
        var presentation = AudioRepairQualityPresenter.From(AudioTranscriptionQualityDeltaEvaluator.Compare(before, current));

        Equal(AudioTranscriptionReadiness.NeedsReview, presentation.Readiness);
        Contains("Resolved: EVENT_DENSITY_HIGH", presentation.Summary);
        Contains("Persistent: MEAN_ACTIVATION_LOW", presentation.Summary);
    }

    private static void RepairQualityPresentationShowsRegression()
    {
        var before = Quality(AudioTranscriptionReadiness.Ready, 0.75, 0.15, 0.85, 7.0, []);
        var current = Quality(AudioTranscriptionReadiness.NeedsReview, 0.52, 0.31, 0.62, 17.0, ["EVENT_DENSITY_HIGH"]);
        var presentation = AudioRepairQualityPresenter.From(AudioTranscriptionQualityDeltaEvaluator.Compare(before, current));

        Equal(false, presentation.Improved);
        Equal(true, presentation.Regressed);
        Contains("Ready → NeedsReview", presentation.Summary);
        Contains("Introduced: EVENT_DENSITY_HIGH", presentation.Summary);
    }

    private static AudioTranscriptionQualityAssessment Quality(
        AudioTranscriptionReadiness readiness,
        double retention,
        double loss,
        double coverage,
        double density,
        IReadOnlyList<string> reasons)
        => new(
            readiness,
            retention,
            loss,
            LowActivationRatio: 0.10,
            OctaveFoldRatio: 0.05,
            coverage,
            density,
            HarmonicSuppressionRatio: 0.05,
            MeanActivation: 0.70f,
            reasons);

    private static void Run(string name, Action test, ICollection<string> failures)
    {
        try
        {
            test();
        }
        catch (Exception exception)
        {
            failures.Add($"FAIL {name}: {exception.Message}");
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"expected '{expected}', got '{actual}'");
    }

    private static void Contains(string expected, string actual)
    {
        if (!actual.Contains(expected, StringComparison.Ordinal))
            throw new InvalidOperationException($"expected '{expected}' in '{actual}'");
    }
}
