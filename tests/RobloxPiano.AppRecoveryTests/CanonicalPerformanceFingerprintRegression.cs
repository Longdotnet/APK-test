using System.Runtime.CompilerServices;
using RobloxPiano.Core;

namespace RobloxPiano.AppRecoveryTests;

internal static class CanonicalPerformanceFingerprintRegression
{
    [ModuleInitializer]
    internal static void VerifyCanonicalPerformanceIdentity()
    {
        var first = Track(
            "Original title",
            [
                new PerformanceEvent(TimeSpan.FromMilliseconds(100), TimeSpan.FromMilliseconds(80), ['b', 'a']),
                new PerformanceEvent(TimeSpan.FromMilliseconds(20), TimeSpan.FromMilliseconds(50), ['c'])
            ]);
        var reorderedAndRenamed = Track(
            "Renamed file/title",
            [
                new PerformanceEvent(TimeSpan.FromMilliseconds(20), TimeSpan.FromMilliseconds(50), ['c']),
                new PerformanceEvent(TimeSpan.FromMilliseconds(100), TimeSpan.FromMilliseconds(80), ['a', 'b'])
            ]);
        var changedDuration = Track(
            "Original title",
            [
                new PerformanceEvent(TimeSpan.FromMilliseconds(100), TimeSpan.FromMilliseconds(81), ['b', 'a']),
                new PerformanceEvent(TimeSpan.FromMilliseconds(20), TimeSpan.FromMilliseconds(50), ['c'])
            ]);

        var firstFingerprint = PerformanceTrackFingerprint.ComputeSha256(first);
        var equivalentFingerprint = PerformanceTrackFingerprint.ComputeSha256(reorderedAndRenamed);
        var changedFingerprint = PerformanceTrackFingerprint.ComputeSha256(changedDuration);

        Equal(firstFingerprint, equivalentFingerprint, "title/event/chord ordering must not alter canonical playback identity");
        NotEqual(firstFingerprint, changedFingerprint, "playback duration mutation must alter canonical identity");
        True(firstFingerprint.Length == 64 && firstFingerprint.All(Uri.IsHexDigit), "fingerprint must be lowercase-compatible SHA-256 hex");
        Console.WriteLine("PASS  canonical performance fingerprint stability (3 cases)");
    }

    private static PerformanceTrack Track(string title, IReadOnlyList<PerformanceEvent> events)
        => new(
            title,
            120d,
            4,
            TimeSpan.FromMilliseconds(250),
            events,
            TimeSpan.FromSeconds(1));

    private static void Equal(string expected, string actual, string message)
    {
        if (!string.Equals(expected, actual, StringComparison.Ordinal))
        {
            throw new InvalidOperationException(message);
        }
    }

    private static void NotEqual(string left, string right, string message)
    {
        if (string.Equals(left, right, StringComparison.Ordinal))
        {
            throw new InvalidOperationException(message);
        }
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }
}
