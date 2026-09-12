using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class AudioTranscriptionReviewRepairRegression
{
    [ModuleInitializer]
    internal static void RunPhase38Regressions()
    {
        Run("repair candidates preserve canonical input and outside-region events", PreservesCanonicalAndOutsideRegion);
        Run("melody and simplified-harmony candidates bound local polyphony", CandidatePolyphonyIsBounded);
        Run("repair candidates are deterministic across note ordering", CandidateGenerationIsOrderIndependent);
        Run("no-op monophonic region does not invent a repair", NoOpRegionProducesNoCandidate);
        Run("cross-boundary canonical notes retain both outside segments", CrossingEventsAreSplitSafely);
    }

    private static void PreservesCanonicalAndOutsideRegion()
    {
        var notes = DenseNotes();
        var before = Event(0.20, 0.20, 'x');
        var after = Event(6.00, 0.20, 'y');
        var canonical = Track(before, Event(1.00, 0.60, 'a'), Event(1.00, 0.60, 's'), Event(1.00, 0.60, 'd'), Event(1.00, 0.60, 'f'), after);
        var originalSignature = Signature(canonical);

        var candidates = Generate(canonical, notes, Region(0, 5));

        Equal(2, candidates.Count);
        Equal(originalSignature, Signature(canonical));
        foreach (var candidate in candidates)
        {
            True(candidate.Track.Events.Any(evt => SameEvent(evt, before)));
            True(candidate.Track.Events.Any(evt => SameEvent(evt, after)));
            Equal(canonical.Title, candidate.Track.Title);
            Equal(canonical.Bpm, candidate.Track.Bpm);
            Equal(canonical.Subdivision, candidate.Track.Subdivision);
            Equal(canonical.StartDelay, candidate.Track.StartDelay);
        }
    }

    private static void CandidatePolyphonyIsBounded()
    {
        var canonical = Track(
            Event(1.00, 0.80, 'a'),
            Event(1.00, 0.80, 's'),
            Event(1.00, 0.80, 'd'),
            Event(1.00, 0.80, 'f'));
        var candidates = Generate(canonical, DenseNotes(), Region(0, 5));
        var melody = candidates.Single(candidate => candidate.Kind == AudioTranscriptionReviewRepairKind.MelodyPriority);
        var harmony = candidates.Single(candidate => candidate.Kind == AudioTranscriptionReviewRepairKind.SimplifiedHarmony);

        Equal(1, melody.PeakSimultaneousNotes);
        True(harmony.PeakSimultaneousNotes <= 3);
        True(harmony.PeakSimultaneousNotes >= melody.PeakSimultaneousNotes);
        True(melody.CandidateRegionEvents < canonical.Events.Count);
        True(harmony.CandidateRegionEvents <= canonical.Events.Count);
    }

    private static void CandidateGenerationIsOrderIndependent()
    {
        var notes = DenseNotes();
        var canonical = Track(
            Event(1.00, 0.80, 'a'),
            Event(1.00, 0.80, 's'),
            Event(1.00, 0.80, 'd'),
            Event(1.00, 0.80, 'f'));
        var region = Region(0, 5);

        var forward = Generate(canonical, notes, region);
        var reverse = Generate(canonical, notes.Reverse().ToArray(), region);

        Equal(forward.Count, reverse.Count);
        for (var index = 0; index < forward.Count; index++)
        {
            Equal(forward[index].Kind, reverse[index].Kind);
            Equal(Signature(forward[index].Track), Signature(reverse[index].Track));
            Equal(forward[index].PeakSimultaneousNotes, reverse[index].PeakSimultaneousNotes);
        }
    }

    private static void NoOpRegionProducesNoCandidate()
    {
        var note = Note(1.0, 1.5, 72, 0.9f);
        var arranged = new RobloxPianoArranger().Arrange("noop", new[] { note });
        var canonical = arranged.Track;

        var candidates = Generate(canonical, new[] { note }, Region(0, 5, "LOW_ACTIVATION_REGION"));

        Equal(0, candidates.Count);
    }

    private static void CrossingEventsAreSplitSafely()
    {
        var leftCrossing = Event(0.50, 1.00, 'q');
        var rightCrossing = Event(2.80, 1.00, 'w');
        var canonical = Track(leftCrossing, Event(1.20, 0.40, 'a'), Event(1.20, 0.40, 's'), Event(1.20, 0.40, 'd'), rightCrossing);
        var notes = new[]
        {
            Note(1.2, 1.6, 60, 0.8f),
            Note(1.2, 1.6, 64, 0.85f),
            Note(1.2, 1.6, 67, 0.9f),
            Note(1.2, 1.6, 72, 0.95f)
        };
        var region = Region(1, 3);

        var candidates = Generate(canonical, notes, region);

        True(candidates.Count > 0);
        foreach (var candidate in candidates)
        {
            True(candidate.Track.Events.Any(evt => evt.Start == TimeSpan.FromSeconds(0.5) && evt.Duration == TimeSpan.FromSeconds(0.5) && evt.Keys.SequenceEqual(new[] { 'q' })));
            True(candidate.Track.Events.Any(evt => evt.Start == TimeSpan.FromSeconds(3.0) && evt.Duration == TimeSpan.FromSeconds(0.8) && evt.Keys.SequenceEqual(new[] { 'w' })));
            True(candidate.Track.Events.All(evt => evt.Duration > TimeSpan.Zero));
        }
    }

    private static IReadOnlyList<AudioTranscriptionReviewRepairCandidate> Generate(
        PerformanceTrack canonical,
        IReadOnlyList<BasicPitchTranscribedNote> notes,
        AudioTranscriptionReviewRegion region) =>
        new AudioTranscriptionReviewRepairGenerator().Generate(canonical, notes, region);

    private static BasicPitchTranscribedNote[] DenseNotes() =>
    [
        Note(1.00, 1.80, 60, 0.80f),
        Note(1.00, 1.80, 64, 0.85f),
        Note(1.00, 1.80, 67, 0.90f),
        Note(1.00, 1.80, 72, 0.95f)
    ];

    private static AudioTranscriptionReviewRegion Region(double start, double end, params string[] reasons) =>
        new(
            TimeSpan.FromSeconds(start),
            TimeSpan.FromSeconds(end),
            4,
            4,
            0.8f,
            1d,
            1d,
            4,
            reasons.Length == 0 ? new[] { "LOCAL_POLYPHONY_HIGH" } : reasons);

    private static BasicPitchTranscribedNote Note(double start, double end, int midi, float amplitude) =>
        new(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(end), midi, amplitude);

    private static PerformanceEvent Event(double start, double duration, char key) =>
        new(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(duration), new[] { key });

    private static PerformanceTrack Track(params PerformanceEvent[] events) =>
        new(
            "phase38",
            120d,
            480,
            TimeSpan.FromMilliseconds(250),
            events,
            events.Length == 0 ? TimeSpan.Zero : events.Max(evt => evt.Start + evt.Duration));

    private static bool SameEvent(PerformanceEvent left, PerformanceEvent right) =>
        left.Start == right.Start && left.Duration == right.Duration && left.Keys.SequenceEqual(right.Keys);

    private static string Signature(PerformanceTrack track) =>
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
}
