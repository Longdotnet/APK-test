namespace RobloxPiano.App;

internal enum AudioFindOrCreateOutcome
{
    PreferVerifiedExistingSource,
    CreateFromOwnedAudio
}

internal sealed record AudioFindOrCreatePlan(string SongIdentity, string AudioPath, int CandidateLimit)
{
    internal const int MaxCandidateLimit = 10;

    public static AudioFindOrCreatePlan From(string? suggestedTitle, string audioPath, int candidateLimit)
    {
        if (string.IsNullOrWhiteSpace(audioPath))
            throw new ArgumentException("A local owned/audio path is required for find-or-create.", nameof(audioPath));
        if (candidateLimit is < 1 or > MaxCandidateLimit)
            throw new ArgumentOutOfRangeException(nameof(candidateLimit), $"Candidate limit must be between 1 and {MaxCandidateLimit}.");

        var fullPath = Path.GetFullPath(audioPath);
        return new AudioFindOrCreatePlan(
            AudioToPianoSongIdentity.Normalize(suggestedTitle, fullPath),
            fullPath,
            candidateLimit);
    }

    public AudioFindOrCreateOutcome Decide(int highConfidenceCount)
    {
        if (highConfidenceCount < 0)
            throw new ArgumentOutOfRangeException(nameof(highConfidenceCount));

        return highConfidenceCount > 0
            ? AudioFindOrCreateOutcome.PreferVerifiedExistingSource
            : AudioFindOrCreateOutcome.CreateFromOwnedAudio;
    }
}
