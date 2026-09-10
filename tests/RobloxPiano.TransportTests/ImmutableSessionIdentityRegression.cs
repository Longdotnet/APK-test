using System.Runtime.CompilerServices;
using RobloxPiano.Core;

namespace RobloxPiano.TransportTests;

internal static class ImmutableSessionIdentityRegression
{
    [ModuleInitializer]
    internal static void VerifyTransportSnapshotsCanonicalIdentity()
    {
        var events = new[]
        {
            new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), new[] { 'a' })
        };
        var track = new PerformanceTrack(
            "identity-snapshot",
            120,
            4,
            TimeSpan.Zero,
            events,
            TimeSpan.FromMilliseconds(100));

        var expected = PerformanceTrackFingerprint.ComputeSha256(track);
        using var transport = new PlaybackTransportSession(
            track,
            new FrozenClock(),
            new NoOpInput(),
            new AlwaysFocused());

        // Simulate mutable source/import state changing after the playback transport owns its track.
        events[0] = new PerformanceEvent(TimeSpan.Zero, TimeSpan.FromMilliseconds(100), new[] { 'z' });
        var mutatedFingerprint = PerformanceTrackFingerprint.ComputeSha256(track);
        if (string.Equals(expected, mutatedFingerprint, StringComparison.Ordinal))
        {
            throw new InvalidOperationException("Regression fixture did not mutate canonical track identity.");
        }

        var observed = transport.QualityReport.CanonicalTrackFingerprint;
        if (!string.Equals(expected, observed, StringComparison.Ordinal))
        {
            throw new InvalidOperationException(
                $"Transport identity drifted after construction. expected={expected}, actual={observed ?? "<null>"}.");
        }
    }

    private sealed class FrozenClock : IMonotonicClock
    {
        public TimeSpan Elapsed => TimeSpan.Zero;
        public ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken)
            => ValueTask.CompletedTask;
    }

    private sealed class NoOpInput : IInputSink
    {
        public ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken) => ValueTask.CompletedTask;
        public ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken) => ValueTask.CompletedTask;
        public ValueTask ReleaseAllAsync(CancellationToken cancellationToken) => ValueTask.CompletedTask;
    }

    private sealed class AlwaysFocused : IFocusGate
    {
        public bool IsTargetFocused => true;
    }
}
