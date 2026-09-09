using RobloxPiano.Core;

namespace RobloxPiano.ExpressiveTests;

internal static class Program
{
    public static int Main()
    {
        var tests = new (string Name, Action Run)[]
        {
            ("no controls preserve exact legacy track representation", TestNoControlsPreserveTrack),
            ("sustain extends note release until pedal up", TestSustainExtendsNote),
            ("repeated pitch under sustain remains physically retriggerable", TestRepeatedPitchRetrigger),
            ("unterminated sustain is repaired at timeline end", TestUnterminatedSustainRelease),
            ("seek through compiled sustain re-enters active note safely", TestSeekThroughSustain),
            ("ambiguous or impossible sustain transitions are rejected", TestMalformedControls)
        };

        var failures = new List<string>();
        foreach (var test in tests)
        {
            try
            {
                test.Run();
                Console.WriteLine($"PASS  {test.Name}");
            }
            catch (Exception exception)
            {
                failures.Add($"{test.Name}: {exception.Message}");
                Console.Error.WriteLine($"FAIL  {test.Name}\n      {exception}");
            }
        }

        Console.WriteLine();
        Console.WriteLine($"Expressive tests: {tests.Length - failures.Count} passed, {failures.Count} failed.");
        return failures.Count == 0 ? 0 : 1;
    }

    private static void TestNoControlsPreserveTrack()
    {
        var source = Track(
            TimeSpan.FromSeconds(2),
            new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(250), new[] { 'a', 'b' }));

        var compiled = ExpressivePerformanceCompiler.Compile(new ExpressivePerformanceTrack(source, Array.Empty<PerformanceControlEvent>()));
        if (!ReferenceEquals(source, compiled))
        {
            throw new InvalidOperationException("No-control compilation must return the original track to preserve Legacy representation/fingerprint.");
        }
    }

    private static void TestSustainExtendsNote()
    {
        var source = Track(
            TimeSpan.FromSeconds(2),
            new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(400), new[] { 'a' }));
        var controls = new[]
        {
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(100), PerformanceControlKind.SustainDown),
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(900), PerformanceControlKind.SustainUp)
        };

        var compiled = ExpressivePerformanceCompiler.Compile(new ExpressivePerformanceTrack(source, controls));
        Equal(TimeSpan.FromMilliseconds(900), compiled.Events.Single().Duration, "sustained duration");
    }

    private static void TestRepeatedPitchRetrigger()
    {
        var source = Track(
            TimeSpan.FromSeconds(2),
            new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(300), new[] { 'a' }),
            new PerformanceEvent(TimeSpan.FromMilliseconds(600), TimeSpan.FromMilliseconds(200), new[] { 'a' }));
        var controls = new[]
        {
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(100), PerformanceControlKind.SustainDown),
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(1200), PerformanceControlKind.SustainUp)
        };

        var compiled = ExpressivePerformanceCompiler.Compile(new ExpressivePerformanceTrack(source, controls));
        Equal(2, compiled.Events.Count, "compiled note count");
        Equal(TimeSpan.FromMilliseconds(600), compiled.Events[0].Duration, "first pitch must release at retrigger boundary");
        Equal(TimeSpan.FromMilliseconds(600), compiled.Events[1].Duration, "second pitch sustains until pedal-up");

        var edges = PlaybackPlanner.BuildEdges(compiled);
        var atRetrigger = edges.Where(edge => edge.At == TimeSpan.FromMilliseconds(600)).ToArray();
        Equal(2, atRetrigger.Length, "retrigger edge count");
        Equal(PlaybackEdgeKind.KeyUp, atRetrigger[0].Kind, "KeyUp must precede KeyDown for physical retrigger");
        Equal(PlaybackEdgeKind.KeyDown, atRetrigger[1].Kind, "new NoteOn follows release");
    }

    private static void TestUnterminatedSustainRelease()
    {
        var source = Track(
            TimeSpan.FromSeconds(1),
            new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(200), new[] { 'x' }));
        var controls = new[]
        {
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(50), PerformanceControlKind.SustainDown)
        };

        var compiled = ExpressivePerformanceCompiler.Compile(new ExpressivePerformanceTrack(source, controls));
        Equal(TimeSpan.FromSeconds(1), compiled.Events.Single().Duration, "unclosed sustain must end at canonical timeline safety boundary");
    }

    private static void TestSeekThroughSustain()
    {
        var source = Track(
            TimeSpan.FromSeconds(2),
            new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(200), new[] { 'q' }));
        var controls = new[]
        {
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(50), PerformanceControlKind.SustainDown),
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(1200), PerformanceControlKind.SustainUp)
        };

        var compiled = ExpressivePerformanceCompiler.Compile(new ExpressivePerformanceTrack(source, controls));
        var slice = PlaybackTransport.Slice(compiled, TimeSpan.FromMilliseconds(700));
        var active = slice.Events.Single();
        Equal(TimeSpan.Zero, active.Start, "seek must re-enter active sustained note at slice zero");
        Equal(TimeSpan.FromMilliseconds(500), active.Duration, "seek must preserve only remaining sustained duration");
    }

    private static void TestMalformedControls()
    {
        var source = Track(
            TimeSpan.FromSeconds(1),
            new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), new[] { 'a' }));

        Throws<FormatException>(() => ExpressivePerformanceCompiler.Compile(new ExpressivePerformanceTrack(source, new[]
        {
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(100), PerformanceControlKind.SustainUp)
        })), "pedal-up without pedal-down");

        Throws<FormatException>(() => ExpressivePerformanceCompiler.Compile(new ExpressivePerformanceTrack(source, new[]
        {
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(100), PerformanceControlKind.SustainDown),
            new PerformanceControlEvent(TimeSpan.FromMilliseconds(100), PerformanceControlKind.SustainUp)
        })), "same-timestamp control ambiguity");

        Throws<FormatException>(() => ExpressivePerformanceCompiler.Compile(new ExpressivePerformanceTrack(source, new[]
        {
            new PerformanceControlEvent(TimeSpan.FromSeconds(2), PerformanceControlKind.SustainDown)
        })), "control outside timeline");
    }

    private static PerformanceTrack Track(TimeSpan duration, params PerformanceEvent[] events)
    {
        return new PerformanceTrack("expressive-test", 120d, 4, TimeSpan.Zero, events, duration);
    }

    private static void Equal<T>(T expected, T actual, string message)
        where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void Throws<TException>(Action action, string message)
        where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }

        throw new InvalidOperationException($"{message}: expected {typeof(TException).Name}.");
    }
}
