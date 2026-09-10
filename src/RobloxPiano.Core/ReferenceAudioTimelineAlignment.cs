using System.Globalization;
using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Core;

public sealed record ReferenceAudioTimelineAlignment(
    int SchemaVersion,
    string ReferenceContentSha256,
    string ReferenceFeatureSha256,
    string CanonicalTrackSha256,
    double PlaybackSpeed,
    int ReferenceOnsetCount,
    int CandidateOnsetCount,
    int MatchedOnsetCount,
    double MatchCoverage,
    double AlignmentOffsetMilliseconds,
    double MeanAbsoluteErrorMilliseconds,
    double P95AbsoluteErrorMilliseconds,
    double TempoRatio,
    string EvidenceSha256)
{
    public const int CurrentSchemaVersion = 1;
}

/// <summary>
/// Deterministically aligns canonical performance-event starts against analyzed reference-audio onsets.
/// This produces evidence only. It does not mutate a track, transport, playback speed, input dispatch,
/// Roblox authorization, or Legacy/Legacy x2 selection.
/// </summary>
public static class ReferenceAudioTimelineAligner
{
    private const int OffsetSearchMilliseconds = 2000;
    private const int OffsetStepMilliseconds = 10;
    private const int MatchToleranceMilliseconds = 120;

    public static ReferenceAudioTimelineAlignment Align(
        ReferenceAudioAnalysis reference,
        PerformanceTrack track,
        double playbackSpeed)
    {
        ArgumentNullException.ThrowIfNull(reference);
        ArgumentNullException.ThrowIfNull(track);

        if (reference.SchemaVersion != ReferenceAudioAnalysis.CurrentSchemaVersion)
        {
            throw new NotSupportedException("Reference-audio analysis schema is not supported by the timeline aligner.");
        }

        if (!double.IsFinite(playbackSpeed) || playbackSpeed <= 0d || playbackSpeed > 8d)
        {
            throw new ArgumentOutOfRangeException(nameof(playbackSpeed), "Playback speed must be finite and within (0, 8].");
        }

        if (reference.Onsets.Count == 0)
        {
            throw new InvalidDataException("Reference audio has no detected onsets to align.");
        }

        var candidateOnsets = track.Events
            .Select(item => TimeSpan.FromTicks((long)Math.Round(
                item.Start.Ticks / playbackSpeed,
                MidpointRounding.AwayFromZero)))
            .Distinct()
            .OrderBy(item => item)
            .ToArray();
        if (candidateOnsets.Length == 0)
        {
            throw new InvalidDataException("Canonical performance has no event starts to align.");
        }

        AlignmentCandidate? best = null;
        for (var offsetMs = -OffsetSearchMilliseconds; offsetMs <= OffsetSearchMilliseconds; offsetMs += OffsetStepMilliseconds)
        {
            var candidate = Evaluate(reference.Onsets, candidateOnsets, offsetMs);
            if (best is null || IsBetter(candidate, best.Value))
            {
                best = candidate;
            }
        }

        var chosen = best!.Value;
        var coverage = chosen.MatchCount / (double)Math.Max(reference.Onsets.Count, candidateOnsets.Length);
        var candidateTempo = track.Bpm * playbackSpeed;
        var tempoRatio = reference.EstimatedTempoBpm > 0d
            ? candidateTempo / reference.EstimatedTempoBpm
            : 0d;
        var canonicalSha = PerformanceTrackFingerprint.ComputeSha256(track);

        var unsigned = new ReferenceAudioTimelineAlignment(
            ReferenceAudioTimelineAlignment.CurrentSchemaVersion,
            reference.ContentSha256.ToLowerInvariant(),
            reference.FeatureSha256.ToLowerInvariant(),
            canonicalSha,
            playbackSpeed,
            reference.Onsets.Count,
            candidateOnsets.Length,
            chosen.MatchCount,
            coverage,
            chosen.OffsetMilliseconds,
            chosen.MeanAbsoluteErrorMilliseconds,
            chosen.P95AbsoluteErrorMilliseconds,
            tempoRatio,
            string.Empty);

        return unsigned with { EvidenceSha256 = ComputeEvidenceSha256(unsigned) };
    }

    public static bool Verify(ReferenceAudioTimelineAlignment evidence)
    {
        ArgumentNullException.ThrowIfNull(evidence);
        if (evidence.SchemaVersion != ReferenceAudioTimelineAlignment.CurrentSchemaVersion
            || !IsSha256(evidence.ReferenceContentSha256)
            || !IsSha256(evidence.ReferenceFeatureSha256)
            || !IsSha256(evidence.CanonicalTrackSha256)
            || !IsSha256(evidence.EvidenceSha256)
            || !double.IsFinite(evidence.PlaybackSpeed)
            || evidence.PlaybackSpeed <= 0d
            || evidence.PlaybackSpeed > 8d
            || evidence.ReferenceOnsetCount <= 0
            || evidence.CandidateOnsetCount <= 0
            || evidence.MatchedOnsetCount < 0
            || evidence.MatchedOnsetCount > Math.Min(evidence.ReferenceOnsetCount, evidence.CandidateOnsetCount)
            || !double.IsFinite(evidence.MatchCoverage)
            || evidence.MatchCoverage < 0d
            || evidence.MatchCoverage > 1d
            || !double.IsFinite(evidence.AlignmentOffsetMilliseconds)
            || Math.Abs(evidence.AlignmentOffsetMilliseconds) > OffsetSearchMilliseconds
            || !double.IsFinite(evidence.MeanAbsoluteErrorMilliseconds)
            || evidence.MeanAbsoluteErrorMilliseconds < 0d
            || !double.IsFinite(evidence.P95AbsoluteErrorMilliseconds)
            || evidence.P95AbsoluteErrorMilliseconds < 0d
            || !double.IsFinite(evidence.TempoRatio)
            || evidence.TempoRatio < 0d)
        {
            return false;
        }

        var expectedCoverage = evidence.MatchedOnsetCount
            / (double)Math.Max(evidence.ReferenceOnsetCount, evidence.CandidateOnsetCount);
        if (Math.Abs(expectedCoverage - evidence.MatchCoverage) > 1e-12)
        {
            return false;
        }

        var expected = ComputeEvidenceSha256(evidence with { EvidenceSha256 = string.Empty });
        return string.Equals(expected, evidence.EvidenceSha256, StringComparison.OrdinalIgnoreCase);
    }

    private static AlignmentCandidate Evaluate(
        IReadOnlyList<TimeSpan> referenceOnsets,
        IReadOnlyList<TimeSpan> candidateOnsets,
        int offsetMilliseconds)
    {
        var errors = new List<double>();
        var referenceIndex = 0;

        foreach (var candidate in candidateOnsets)
        {
            var shiftedMs = candidate.TotalMilliseconds + offsetMilliseconds;
            while (referenceIndex < referenceOnsets.Count
                   && referenceOnsets[referenceIndex].TotalMilliseconds < shiftedMs - MatchToleranceMilliseconds)
            {
                referenceIndex++;
            }

            var bestIndex = -1;
            var bestError = double.PositiveInfinity;
            for (var index = referenceIndex; index < referenceOnsets.Count; index++)
            {
                var referenceMs = referenceOnsets[index].TotalMilliseconds;
                if (referenceMs > shiftedMs + MatchToleranceMilliseconds)
                {
                    break;
                }

                var error = Math.Abs(referenceMs - shiftedMs);
                if (error < bestError)
                {
                    bestError = error;
                    bestIndex = index;
                }
            }

            if (bestIndex >= 0)
            {
                errors.Add(bestError);
                referenceIndex = bestIndex + 1;
            }
        }

        if (errors.Count == 0)
        {
            return new AlignmentCandidate(offsetMilliseconds, 0, MatchToleranceMilliseconds, MatchToleranceMilliseconds);
        }

        errors.Sort();
        var p95Index = Math.Clamp((int)Math.Ceiling(errors.Count * 0.95d) - 1, 0, errors.Count - 1);
        return new AlignmentCandidate(
            offsetMilliseconds,
            errors.Count,
            errors.Average(),
            errors[p95Index]);
    }

    private static bool IsBetter(AlignmentCandidate candidate, AlignmentCandidate current)
    {
        if (candidate.MatchCount != current.MatchCount)
        {
            return candidate.MatchCount > current.MatchCount;
        }

        var mean = candidate.MeanAbsoluteErrorMilliseconds.CompareTo(current.MeanAbsoluteErrorMilliseconds);
        if (mean != 0)
        {
            return mean < 0;
        }

        var magnitude = Math.Abs(candidate.OffsetMilliseconds).CompareTo(Math.Abs(current.OffsetMilliseconds));
        if (magnitude != 0)
        {
            return magnitude < 0;
        }

        return candidate.OffsetMilliseconds < current.OffsetMilliseconds;
    }

    private static string ComputeEvidenceSha256(ReferenceAudioTimelineAlignment evidence)
    {
        var canonical = string.Join("\n",
            "reference-audio-timeline-alignment-v1",
            evidence.SchemaVersion.ToString(CultureInfo.InvariantCulture),
            evidence.ReferenceContentSha256.ToLowerInvariant(),
            evidence.ReferenceFeatureSha256.ToLowerInvariant(),
            evidence.CanonicalTrackSha256.ToLowerInvariant(),
            evidence.PlaybackSpeed.ToString("R", CultureInfo.InvariantCulture),
            evidence.ReferenceOnsetCount.ToString(CultureInfo.InvariantCulture),
            evidence.CandidateOnsetCount.ToString(CultureInfo.InvariantCulture),
            evidence.MatchedOnsetCount.ToString(CultureInfo.InvariantCulture),
            evidence.MatchCoverage.ToString("R", CultureInfo.InvariantCulture),
            evidence.AlignmentOffsetMilliseconds.ToString("R", CultureInfo.InvariantCulture),
            evidence.MeanAbsoluteErrorMilliseconds.ToString("R", CultureInfo.InvariantCulture),
            evidence.P95AbsoluteErrorMilliseconds.ToString("R", CultureInfo.InvariantCulture),
            evidence.TempoRatio.ToString("R", CultureInfo.InvariantCulture));
        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(canonical))).ToLowerInvariant();
    }

    private static bool IsSha256(string value)
        => value.Length == 64 && value.All(character =>
            character is >= '0' and <= '9'
            or >= 'a' and <= 'f'
            or >= 'A' and <= 'F');

    private readonly record struct AlignmentCandidate(
        double OffsetMilliseconds,
        int MatchCount,
        double MeanAbsoluteErrorMilliseconds,
        double P95AbsoluteErrorMilliseconds);
}
