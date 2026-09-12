using RobloxPiano.Core;

namespace RobloxPiano.Library;

public sealed record ReferenceVerifiedSongCandidate(
    SongDiscoveryCandidate Candidate,
    ReferenceCandidateAssessment Assessment)
{
    public string ConfidenceLabel => Assessment.Verdict switch
    {
        ReferenceCandidateVerdict.HighConfidence => "High confidence",
        ReferenceCandidateVerdict.Review => "Review",
        ReferenceCandidateVerdict.Mismatch => "Mismatch",
        _ => "Unknown"
    };
}

/// <summary>
/// Orders candidates only after each candidate has immutable reference-audio evidence.
/// Metadata score is deliberately a tie-breaker; it can never override a reference mismatch.
/// </summary>
public static class ReferenceVerifiedSongRanker
{
    public static IReadOnlyList<ReferenceVerifiedSongCandidate> Rank(
        IEnumerable<ReferenceVerifiedSongCandidate> candidates,
        int maxResults)
    {
        ArgumentNullException.ThrowIfNull(candidates);
        if (maxResults <= 0)
        {
            throw new ArgumentOutOfRangeException(nameof(maxResults));
        }

        return candidates
            .Select(Validate)
            .OrderByDescending(item => item.Assessment.Verdict)
            .ThenByDescending(item => item.Assessment.ConfidenceScore)
            .ThenByDescending(item => item.Assessment.MatchCoverage)
            .ThenBy(item => item.Assessment.MeanAbsoluteErrorMilliseconds)
            .ThenByDescending(item => item.Candidate.Score)
            .ThenBy(item => item.Candidate.Title, StringComparer.CurrentCultureIgnoreCase)
            .Take(maxResults)
            .ToArray();
    }

    private static ReferenceVerifiedSongCandidate Validate(ReferenceVerifiedSongCandidate candidate)
    {
        ArgumentNullException.ThrowIfNull(candidate);
        ArgumentNullException.ThrowIfNull(candidate.Candidate);
        ArgumentNullException.ThrowIfNull(candidate.Assessment);
        if (!ReferenceCandidateConfidencePolicy.Verify(candidate.Assessment))
        {
            throw new InvalidDataException("Reference-verified ranking requires valid candidate assessment evidence.");
        }

        return candidate;
    }
}
