using RobloxPiano.Audio;

namespace RobloxPiano.App;

internal sealed record AudioRepairQualityPresentation(
    string Summary,
    AudioTranscriptionReadiness Readiness,
    bool Improved,
    bool Regressed);

internal static class AudioRepairQualityPresenter
{
    public static AudioRepairQualityPresentation From(AudioTranscriptionReviewRepairSession session)
    {
        ArgumentNullException.ThrowIfNull(session);
        var current = session.CurrentQuality
            ?? throw new InvalidOperationException("Repair quality presentation requires authoritative current quality.");
        var delta = session.CompareCurrent()
            ?? throw new InvalidOperationException("Repair quality presentation requires an immutable base quality assessment.");

        var transition = delta.ReadinessChanged
            ? $"{delta.Before.Readiness} → {delta.Current.Readiness}"
            : delta.Current.Readiness.ToString();
        var resolved = FormatReasons(delta.ResolvedReasons, "none");
        var persistent = FormatReasons(delta.PersistentReasons, "none");
        var introduced = FormatReasons(delta.IntroducedReasons, "none");

        var summary =
            $"Quality: {transition} • retention {delta.Before.RetentionRatio:P0} → {delta.Current.RetentionRatio:P0} • " +
            $"loss {delta.Before.TransformLossRatio:P0} → {delta.Current.TransformLossRatio:P0} • " +
            $"coverage {delta.Before.TimelineCoverage:P0} → {delta.Current.TimelineCoverage:P0} • " +
            $"density {delta.Before.EventsPerSecond:0.0} → {delta.Current.EventsPerSecond:0.0} events/s{Environment.NewLine}" +
            $"Resolved: {resolved} • Persistent: {persistent} • Introduced: {introduced}";

        return new AudioRepairQualityPresentation(
            summary,
            current.Readiness,
            delta.ImprovedReadiness,
            delta.RegressedReadiness);
    }

    private static string FormatReasons(IReadOnlyList<string> reasons, string empty)
        => reasons.Count == 0 ? empty : string.Join(", ", reasons);
}
