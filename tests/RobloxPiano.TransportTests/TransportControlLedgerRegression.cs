using System.Runtime.CompilerServices;
using RobloxPiano.Core;

namespace RobloxPiano.TransportTests;

internal static class TransportControlLedgerRegression
{
    [ModuleInitializer]
    internal static void VerifyTransportControlLedger()
    {
        RunAsync().GetAwaiter().GetResult();
    }

    private static async Task RunAsync()
    {
        var wallClock = new HookClock();
        var sessionClock = new PlaybackSessionClock(wallClock, 1d);
        var input = new RecordingInput(sessionClock);
        using var session = new PlaybackTransportSession(CreateTrack(), sessionClock, input, new AlwaysFocused());

        var step = 0;
        wallClock.BeforeDelay = () =>
        {
            step++;
            if (step == 1)
            {
                sessionClock.SetSpeed(1.5d);
            }
            else if (step == 2)
            {
                session.Seek(TimeSpan.FromMilliseconds(250));
            }
        };

        await session.PlayAsync(TimeSpan.Zero).ConfigureAwait(false);
        var report = session.QualityReport;
        var events = report.TransportControlEvents;

        if (report.SchemaVersion != PlaybackTransportQualityReport.CurrentSchemaVersion
            || events.Count < 3
            || events[0].Kind != PlaybackTransportControlKind.SessionStarted
            || Math.Abs((events[0].Speed ?? 0d) - 1d) > 0.000001d
            || !events.Any(e => e.Kind == PlaybackTransportControlKind.SpeedChanged && Math.Abs((e.Speed ?? 0d) - 1.5d) < 0.000001d)
            || !events.Any(e => e.Kind == PlaybackTransportControlKind.SeekRequested && Math.Abs(e.PositionSeconds - 0.25d) < 0.000001d))
        {
            throw new InvalidOperationException("Transport control ledger did not preserve start/speed/seek evidence.");
        }

        for (var i = 0; i < events.Count; i++)
        {
            if (events[i].Sequence != i || events[i].PositionSeconds < 0d)
            {
                throw new InvalidOperationException("Transport control ledger ordering/position contract regressed.");
            }
        }
    }

    private static PerformanceTrack CreateTrack() => new(
        "ledger",
        120,
        4,
        TimeSpan.Zero,
        new[]
        {
            new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), new[] { 'a' }),
            new PerformanceEvent(TimeSpan.FromMilliseconds(200), TimeSpan.FromMilliseconds(100), new[] { 'b' }),
            new PerformanceEvent(TimeSpan.FromMilliseconds(350), TimeSpan.FromMilliseconds(40), new[] { 'c' })
        },
        TimeSpan.FromMilliseconds(400));

    private sealed class AlwaysFocused : IFocusGate
    {
        public bool IsTargetFocused => true;
    }

    private sealed class RecordingInput(IMonotonicClock clock) : IInputSink
    {
        public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            _ = clock.Elapsed;
            return ValueTask.CompletedTask;
        }

        public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            _ = clock.Elapsed;
            return ValueTask.CompletedTask;
        }

        public ValueTask ReleaseAllAsync(CancellationToken cancellationToken)
        {
            _ = clock.Elapsed;
            return ValueTask.CompletedTask;
        }
    }

    private sealed class HookClock : IMonotonicClock
    {
        public TimeSpan Elapsed { get; private set; }
        public Action? BeforeDelay { get; set; }

        public ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken)
        {
            BeforeDelay?.Invoke();
            cancellationToken.ThrowIfCancellationRequested();
            if (target > Elapsed)
            {
                Elapsed = target;
            }

            return ValueTask.CompletedTask;
        }
    }
}
