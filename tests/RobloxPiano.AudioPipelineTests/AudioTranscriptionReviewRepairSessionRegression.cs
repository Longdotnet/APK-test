using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class AudioTranscriptionReviewRepairSessionRegression
{
    [ModuleInitializer]
    internal static void RunPhase39Regressions()
    {
        Run("repair preview never mutates canonical session state", PreviewIsSideEffectFree);
        Run("explicit apply re-analyzes review regions and advances revision", ExplicitApplyReanalyzes);
        Run("stale review region cannot rewrite newer canonical state", StaleRegionFailsClosed);
        Run("revert restores exact original performance and review evidence", RevertRestoresOriginal);
        Run("cancelled repair operation leaves canonical state unchanged", CancellationIsAtomic);
    }

    private static void PreviewIsSideEffectFree()
    {
        var session = CreateSession();
        var original = Signature(session.CurrentTrack);
        var region = session.ReviewRegions.Single();

        var candidate = session.PreviewCandidate(region, AudioTranscriptionReviewRepairKind.MelodyPriority);

        True(Signature(candidate.Track) != original);
        Equal(original, Signature(session.CurrentTrack));
        Equal(0L, session.Revision);
        True(!session.IsModified);
        True(!session.CanRevert);
    }

    private static void ExplicitApplyReanalyzes()
    {
        var session = CreateSession();
        var region = session.ReviewRegions.Single();
        var original = Signature(session.CurrentTrack);

        var result = session.Apply(region, AudioTranscriptionReviewRepairKind.MelodyPriority);

        Equal(1L, session.Revision);
        Equal(1L, result.Revision);
        True(session.IsModified);
        True(session.CanRevert);
        True(Signature(session.CurrentTrack) != original);
        True(Signature(result.PreviousTrack) == original);
        Equal(Signature(session.CurrentTrack), Signature(result.CurrentTrack));
        Equal(0, session.ReviewRegions.Count);
        Equal(0, result.ReviewRegions.Count);
    }

    private static void StaleRegionFailsClosed()
    {
        var session = CreateSession();
        var stale = session.ReviewRegions.Single();
        session.Apply(stale, AudioTranscriptionReviewRepairKind.MelodyPriority);
        var applied = Signature(session.CurrentTrack);

        Throws<InvalidOperationException>(() => session.PreviewCandidate(stale, AudioTranscriptionReviewRepairKind.MelodyPriority));
        Throws<InvalidOperationException>(() => session.Apply(stale, AudioTranscriptionReviewRepairKind.SimplifiedHarmony));

        Equal(applied, Signature(session.CurrentTrack));
        Equal(1L, session.Revision);
    }

    private static void RevertRestoresOriginal()
    {
        var session = CreateSession();
        var original = Signature(session.OriginalTrack);
        var originalRegion = session.ReviewRegions.Single();
        session.Apply(originalRegion, AudioTranscriptionReviewRepairKind.MelodyPriority);

        True(session.Revert());

        Equal(original, Signature(session.CurrentTrack));
        Equal(original, Signature(session.OriginalTrack));
        Equal(2L, session.Revision);
        True(!session.IsModified);
        True(!session.CanRevert);
        Equal(1, session.ReviewRegions.Count);
        Equal(originalRegion.Start, session.ReviewRegions[0].Start);
        Equal(originalRegion.End, session.ReviewRegions[0].End);
        Equal(string.Join('|', originalRegion.Reasons), string.Join('|', session.ReviewRegions[0].Reasons));
        True(!session.Revert());
        Equal(2L, session.Revision);
    }

    private static void CancellationIsAtomic()
    {
        var session = CreateSession();
        var region = session.ReviewRegions.Single();
        var before = Signature(session.CurrentTrack);
        using var cancellation = new CancellationTokenSource();
        cancellation.Cancel();

        Throws<OperationCanceledException>(() => session.Apply(
            region,
            AudioTranscriptionReviewRepairKind.MelodyPriority,
            cancellation.Token));

        Equal(before, Signature(session.CurrentTrack));
        Equal(0L, session.Revision);
        True(!session.IsModified);
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
            "phase39",
            notes,
            new RobloxPianoArrangementOptions(MaxSimultaneousNotes: 4)).Track;
        return new AudioTranscriptionReviewRepairSession(
            TimeSpan.FromSeconds(5),
            notes,
            canonical,
            new AudioTranscriptionReviewRepairSessionOptions(
                ReviewRegions: new AudioTranscriptionReviewRegionOptions(
                    HighSimultaneousNotes: 3),
                Repair: new AudioTranscriptionReviewRepairOptions(
                    SimplifiedHarmonyMaxSimultaneousNotes: 3)));
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
