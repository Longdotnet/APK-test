using System.Globalization;
using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Core;

public enum ReferenceCandidateVerdict
{
    Mismatch = 0,
    Review = 1,
    HighConfidence = 2
}

public sealed record ReferenceCandidateAssessment(
    int SchemaVersion,
    ReferenceCandidateVerdict Verdict,
    int ConfidenceScore,
    string ReasonCode,
    int ReferenceOnsetCount,
    int CandidateOnsetCount,
    double MatchCoverage,
    double MeanAbsoluteErrorMilliseconds,
    double P95AbsoluteErrorMilliseconds,
    double NormalizedTempoRatio,
    string AlignmentEvidenceSha256,
    string EvidenceSha256)
{
    public const int CurrentSchemaVersion = 1;
}

/// <summary>
/// Converts immutable reference-audio timeline evidence into a deterministic candidate verdict.
/// This is a ranking/review policy only: it never changes PerformanceTrack, playback speed, timing,
/// discovery metadata, input dispatch, or Roblox runtime state.
/// </summary>
public static class ReferenceCandidateConfidencePolicy
{
    private const int MinimumHighConfidenceOnsets = 6;
    private const double HighCoverage = 0.70d;
    private const double MismatchCoverage = 0.35d;
    private const double HighMeanErrorMilliseconds = 55d;
    private const double HighP95ErrorMilliseconds = 100d;
    private const double MismatchP95ErrorMilliseconds = 115d;
    private const double HighTempoRatioMinimum = 0.90d;
    private const double HighTempoRatioMaximum = 1.12d;
    private const double MismatchTempoRatioMinimum = 0.78d;
    private const double MismatchTempoRatioMaximum = 1.28d;

    public static ReferenceCandidateAssessment Assess(ReferenceAudioTimelineAlignment alignment)
    {
        ArgumentNullException.ThrowIfNull(alignment);
        if (!ReferenceAudioTimelineAligner.Verify(alignment))
        {
            throw new InvalidDataException("Reference candidate confidence requires verified timeline-alignment evidence.");
        }

        var normalizedTempoRatio = NormalizeTempoRatio(alignment.TempoRatio);
        var confidenceScore = CalculateScore(alignment, normalizedTempoRatio);
        var minimumOnsetCount = Math.Min(alignment.ReferenceOnsetCount, alignment.CandidateOnsetCount);

        ReferenceCandidateVerdict verdict;
        string reasonCode;

        if (alignment.MatchCoverage < MismatchCoverage)
        {
            verdict = ReferenceCandidateVerdict.Mismatch;
            reasonCode = "LOW_ONSET_COVERAGE";
        }
        else if (alignment.P95AbsoluteErrorMilliseconds > MismatchP95ErrorMilliseconds)
        {
            verdict = ReferenceCandidateVerdict.Mismatch;
            reasonCode = "TIMING_MISMATCH";
        }
        else if (normalizedTempoRatio <= 0d
                 || normalizedTempoRatio < MismatchTempoRatioMinimum
                 || normalizedTempoRatio > MismatchTempoRatioMaximum)
        {
            verdict = ReferenceCandidateVerdict.Mismatch;
            reasonCode = "TEMPO_MISMATCH";
        }
        else if (minimumOnsetCount < MinimumHighConfidenceOnsets)
        {
            verdict = ReferenceCandidateVerdict.Review;
            reasonCode = "INSUFFICIENT_EVIDENCE";
        }
        else if (alignment.MatchCoverage >= HighCoverage
                 && alignment.MeanAbsoluteErrorMilliseconds <= HighMeanErrorMilliseconds
                 && alignment.P95AbsoluteErrorMilliseconds <= HighP95ErrorMilliseconds
                 && normalizedTempoRatio >= HighTempoRatioMinimum
                 && normalizedTempoRatio <= HighTempoRatioMaximum
                 && confidenceScore >= 75)
        {
            verdict = ReferenceCandidateVerdict.HighConfidence;
            reasonCode = "HIGH_CONFIDENCE";
        }
        else
        {
            verdict = ReferenceCandidateVerdict.Review;
            reasonCode = "REVIEW_REQUIRED";
        }

        var unsigned = new ReferenceCandidateAssessment(
            ReferenceCandidateAssessment.CurrentSchemaVersion,
            verdict,
            confidenceScore,
            reasonCode,
            alignment.ReferenceOnsetCount,
            alignment.CandidateOnsetCount,
            alignment.MatchCoverage,
            alignment.MeanAbsoluteErrorMilliseconds,
            alignment.P95AbsoluteErrorMilliseconds,
            normalizedTempoRatio,
            alignment.EvidenceSha256.ToLowerInvariant(),
            string.Empty);

        return unsigned with { EvidenceSha256 = ComputeEvidenceSha256(unsigned) };
    }

    public static bool Verify(ReferenceCandidateAssessment assessment)
    {
        ArgumentNullException.ThrowIfNull(assessment);
        if (assessment.SchemaVersion != ReferenceCandidateAssessment.CurrentSchemaVersion
            || !Enum.IsDefined(assessment.Verdict)
            || assessment.ConfidenceScore is < 0 or > 100
            || string.IsNullOrWhiteSpace(assessment.ReasonCode)
            || assessment.ReferenceOnsetCount <= 0
            || assessment.CandidateOnsetCount <= 0
            || !double.IsFinite(assessment.MatchCoverage)
            || assessment.MatchCoverage < 0d
            || assessment.MatchCoverage > 1d
            || !double.IsFinite(assessment.MeanAbsoluteErrorMilliseconds)
            || assessment.MeanAbsoluteErrorMilliseconds < 0d
            || !double.IsFinite(assessment.P95AbsoluteErrorMilliseconds)
            || assessment.P95AbsoluteErrorMilliseconds < 0d
            || !double.IsFinite(assessment.NormalizedTempoRatio)
            || assessment.NormalizedTempoRatio < 0d
            || !IsSha256(assessment.AlignmentEvidenceSha256)
            || !IsSha256(assessment.EvidenceSha256))
        {
            return false;
        }

        var expected = ComputeEvidenceSha256(assessment with { EvidenceSha256 = string.Empty });
        return string.Equals(expected, assessment.EvidenceSha256, StringComparison.OrdinalIgnoreCase);
    }

    private static int CalculateScore(
        ReferenceAudioTimelineAlignment alignment,
        double normalizedTempoRatio)
    {
        var coverage = alignment.MatchCoverage * 60d;
        var meanTiming = Math.Clamp(1d - alignment.MeanAbsoluteErrorMilliseconds / 120d, 0d, 1d) * 20d;
        var p95Timing = Math.Clamp(1d - alignment.P95AbsoluteErrorMilliseconds / 120d, 0d, 1d) * 10d;
        var tempo = normalizedTempoRatio <= 0d
            ? 0d
            : Math.Clamp(1d - Math.Abs(normalizedTempoRatio - 1d) / 0.25d, 0d, 1d) * 10d;

        return Math.Clamp(
            (int)Math.Round(coverage + meanTiming + p95Timing + tempo, MidpointRounding.AwayFromZero),
            0,
            100);
    }

    private static double NormalizeTempoRatio(double tempoRatio)
    {
        if (!double.IsFinite(tempoRatio) || tempoRatio <= 0d)
        {
            return 0d;
        }

        // Beat trackers commonly disagree by one metrical octave. Treat 0.5x/2x as
        // equivalent tempo hypotheses, but do not normalize arbitrarily large ratios.
        var candidates = new[] { tempoRatio, tempoRatio * 2d, tempoRatio / 2d };
        return candidates
            .Where(double.IsFinite)
            .Where(value => value > 0d)
            .OrderBy(value => Math.Abs(value - 1d))
            .ThenBy(value => value)
            .First();
    }

    private static string ComputeEvidenceSha256(ReferenceCandidateAssessment assessment)
    {
        var canonical = string.Join("\n",
            "reference-candidate-assessment-v1",
            assessment.SchemaVersion.ToString(CultureInfo.InvariantCulture),
            assessment.Verdict.ToString(),
            assessment.ConfidenceScore.ToString(CultureInfo.InvariantCulture),
            assessment.ReasonCode,
            assessment.ReferenceOnsetCount.ToString(CultureInfo.InvariantCulture),
            assessment.CandidateOnsetCount.ToString(CultureInfo.InvariantCulture),
            assessment.MatchCoverage.ToString("R", CultureInfo.InvariantCulture),
            assessment.MeanAbsoluteErrorMilliseconds.ToString("R", CultureInfo.InvariantCulture),
            assessment.P95AbsoluteErrorMilliseconds.ToString("R", CultureInfo.InvariantCulture),
            assessment.NormalizedTempoRatio.ToString("R", CultureInfo.InvariantCulture),
            assessment.AlignmentEvidenceSha256.ToLowerInvariant());
        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(canonical))).ToLowerInvariant();
    }

    private static bool IsSha256(string value)
        => value.Length == 64 && value.All(character =>
            character is >= '0' and <= '9'
            or >= 'a' and <= 'f'
            or >= 'A' and <= 'F');
}
