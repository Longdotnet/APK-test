using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class AudioTranscriptionRepairCandidateQualityRegression
{
    [ModuleInitializer]
    internal static void RunPhase42Regressions()
    {
        Run("candidate quality preview is side-effect free", CandidateQualityPreviewIsSideEffectFree);
        Run("candidate recommendation is deterministic across candidate ordering", RecommendationIsDeterministic);
        Run("candidate quality retains authoritative source warning provenance", SourceWarningPersists);
        Run("cancelled candidate quality preview leaves session untouched", CancellationIsAtomic);
        Run("stale region cannot produce candidate recommendation", StaleRegionFailsClosed);
    }

    private static void CandidateQualityPreviewIsSideEffectFree()
    {
        var session = CreateSession();
        var region = session.ReviewRegions.Single();
        var trackBefore = Signature(session.CurrentTrack);
        var qualityBefore = session.CurrentQuality;

        var assessments = session.PreviewCandidateQualities(region);

        Equal(2, assessments.Count);
        Equal(trackBefore, Signature(session.CurrentTrack));
        Equal(0L, session.Revision);
        True(!session.IsModified);
        True(ReferenceEquals(qualityBefore, session.CurrentQuality));
        True(assessments.All(value => value.SessionRevision == 0));
        True(assessments.All(value => value.DeltaFromCurrent.Before == qualityBefore));
        True(assessments.All(value => value.Candidate.Kind is AudioTranscriptionReviewRepairKind.MelodyPriority or AudioTranscriptionReviewRepairKind.SimplifiedHarmony));
    }

    private static void RecommendationIsDeterministic()
    {
        var session = CreateSession();
        var region = session.ReviewRegions.Single();
        var assessments = session.PreviewCandidateQualities(region);
        var reversed = assessments.Reverse().ToArray();

        var first = AudioTranscriptionReviewRepairRecommendationEvaluator.Recommend(assessments, session.Revision);
        var second = AudioTranscriptionReviewRepairRecommendationEvaluator.Recommend(reversed, session.Revision);
        var fromSession = session.RecommendCandidate(region);

        Equal(first.Recommended.Candidate.Kind, second.Recommended.Candidate.Kind);
        Equal(first.Recommended.Candidate.Kind, fromSession.Recommended.Candidate.Kind);
        Equal(0L, fromSession.SessionRevision);
        Equal(Signature(session.OriginalTrack), Signature(session.CurrentTrack));
        Equal(0L, session.Revision);
    }

    private static void SourceWarningPersists()
    {
        var session = CreateSession();
        var region = session.ReviewRegions.Single();
        var assessments = session.PreviewCandidateQualities(region);

        True(assessments.All(value => value.Quality.Reasons.Contains("MEAN_ACTIVATION_LOW", StringComparer.Ordinal)));
        True(assessments.All(value => value.DeltaFromCurrent.PersistentReasons.Contains("MEAN_ACTIVATION_LOW", StringComparer.Ordinal)));
    }

    private static void CancellationIsAtomic()
    {
        var session = CreateSession();
        var region = session.ReviewRegions.Single();
        var before = Signature(session.CurrentTrack);
        using var cancellation = new CancellationTokenSource();
        cancellation.Cancel();

        Throws<OperationCanceledException>(() => session.PreviewCandidateQualities(region, cancellation.Token));
        Throws<OperationCanceledException>(() => session.RecommendCandidate(region, cancellation.Token));

        Equal(before, Signature(session.CurrentTrack));
        Equal(0L, session.Revision);
        True(!session.IsModified);
    }

    private static void StaleRegionFailsClosed()
    {
        var session = CreateSession();
        var stale = session.ReviewRegions.Single();
        session.Apply(stale, AudioTranscriptionReviewRepairKind.MelodyPriority);
        var afterApply = Signature(session.CurrentTrack);
        var revision = session.Revision;

        Throws<InvalidOperationException>(() => session.PreviewCandidateQualities(stale));
        Throws<InvalidOperationException>(() => session.RecommendCandidate(stale));

        Equal(afterApply, Signature(session.CurrentTrack));
        Equal(revision, session.Revision);
    }

    private static AudioTranscriptionReviewRepairSession CreateSession()
    {
        var notes = new[]
        {
            Note(1.00, 1.80, 60, 0.80f),
            Note(1.00, 1.80, 64, 0.85f),
            Note(1.00, 1.80, 67, 0.90f),
            Note(1.00, 1.80, 72, 0.95f)
        };
        var canonical = new RobloxPianoArranger().Arrange(
            "phase42",
            notes,
            new RobloxPianoArrangementOptions(MaxSimultaneousNotes: 4)).Track;
        var baseQuality = new AudioTranscriptionQualityAssessment(
            AudioTranscriptionReadiness.NeedsReview,
            RetentionRatio: 1.0,
            TransformLossRatio: 0.0,
            LowActivationRatio: 0.10,
            OctaveFoldRatio: 0.0,
            TimelineCoverage: 0.36,
            EventsPerSecond: 0.8,
            HarmonicSuppressionRatio: 0.0,
            MeanActivation: 0.30f,
            Reasons: ["MEAN_ACTIVATION_LOW"]);

        return new AudioTranscriptionReviewRepairSession(
            TimeSpan.FromSeconds(5),
            notes,
            canonical,
            new AudioTranscriptionReviewRepairSessionOptions(
                ReviewRegions: new AudioTranscriptionReviewRegionOptions(HighSimultaneousNotes: 3),
                Repair: new AudioTranscriptionReviewRepairOptions(SimplifiedHarmonyMaxSimultaneousNotes: 3)),
            baseQuality: baseQuality);
    }

    private static BasicPitchTranscribedNote Note(double start, double end, int midi, float amplitude) =>
        new(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(end), midi, amplitude);

    private static string Signature(PerformanceTrack track) =>
        $"{track.Title}|{track.Bpm:R}|{track.Subdivision}|{track.StartDelay.Ticks}|{track.TimelineDuration.Ticks}|" +
        string.Join("|", track.Events.Select(evt => $"{evt.Start.Ticks}:{evt.Duration.Ticks}:{string.Concat(evt.Keys)}"));

    private static void Run(string name, Action action)
    {
        try
        {
            action();
            Console.WriteLine($"PASS {name}");
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"FAIL {name}: {exception}");
            Environment.ExitCode = 1;
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, got {actual}.");
    }

    private static void True(bool value)
    {
        if (!value)
            throw new InvalidOperationException("Expected condition to be true.");
    }

    private static void Throws<TException>(Action action) where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }
        throw new InvalidOperationException($"Expected {typeof(TException).Name}.");
    }
}
