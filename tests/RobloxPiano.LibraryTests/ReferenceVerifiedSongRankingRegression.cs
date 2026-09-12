using System.Buffers.Binary;
using System.Runtime.CompilerServices;
using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.LibraryTests;

internal static class ReferenceVerifiedSongRankingRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        VerifiedEvidenceOutranksMetadataScore();
        TamperedAssessmentFailsClosed();
        RankingIsDeterministic();
    }

    private static void VerifiedEvidenceOutranksMetadataScore()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 5, 500));
        var high = Assess(reference, CreatePulseTrack(TimeSpan.FromMilliseconds(500), 9, TimeSpan.FromMilliseconds(500)));
        var review = Assess(reference, CreatePulseTrack(TimeSpan.FromMilliseconds(500), 4, TimeSpan.FromMilliseconds(500)));
        var mismatch = Assess(reference, CreatePulseTrack(TimeSpan.FromMilliseconds(100), 34, TimeSpan.FromMilliseconds(137)));

        Require(high.Verdict == ReferenceCandidateVerdict.HighConfidence, "high fixture must remain high confidence");
        Require(review.Verdict == ReferenceCandidateVerdict.Review, "short fixture must remain review");
        Require(mismatch.Verdict == ReferenceCandidateVerdict.Mismatch, "low-coverage fixture must remain mismatch");

        var ranked = ReferenceVerifiedSongRanker.Rank(
            [
                new ReferenceVerifiedSongCandidate(Candidate("metadata-perfect-but-wrong", 999), mismatch),
                new ReferenceVerifiedSongCandidate(Candidate("needs-review", 500), review),
                new ReferenceVerifiedSongCandidate(Candidate("verified-match", 1), high)
            ],
            3);

        Require(ranked[0].Candidate.Title == "verified-match",
            "verified high confidence must outrank a much larger metadata score");
        Require(ranked[1].Candidate.Title == "needs-review", "review must rank between high confidence and mismatch");
        Require(ranked[2].Candidate.Title == "metadata-perfect-but-wrong",
            "reference mismatch must stay last even when metadata score is huge");
    }

    private static void TamperedAssessmentFailsClosed()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 5, 500));
        var assessment = Assess(reference, CreatePulseTrack(TimeSpan.FromMilliseconds(500), 9, TimeSpan.FromMilliseconds(500)));
        var tampered = assessment with { Verdict = ReferenceCandidateVerdict.HighConfidence, ConfidenceScore = 100 };

        var threw = false;
        try
        {
            _ = ReferenceVerifiedSongRanker.Rank(
                [new ReferenceVerifiedSongCandidate(Candidate("tampered", 1000), tampered)],
                1);
        }
        catch (InvalidDataException)
        {
            threw = true;
        }

        Require(threw, "ranking must reject assessment fields that no longer match the evidence hash");
    }

    private static void RankingIsDeterministic()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 5, 500));
        var assessment = Assess(reference, CreatePulseTrack(TimeSpan.FromMilliseconds(500), 9, TimeSpan.FromMilliseconds(500)));
        var input = new[]
        {
            new ReferenceVerifiedSongCandidate(Candidate("Beta", 20), assessment),
            new ReferenceVerifiedSongCandidate(Candidate("Alpha", 20), assessment)
        };

        var first = ReferenceVerifiedSongRanker.Rank(input, 2).Select(item => item.Candidate.Title).ToArray();
        var second = ReferenceVerifiedSongRanker.Rank(input.Reverse(), 2).Select(item => item.Candidate.Title).ToArray();
        Require(first.SequenceEqual(second), "rank result must not depend on provider enumeration order");
        Require(first.SequenceEqual(new[] { "Alpha", "Beta" }), "stable title tie-break must be deterministic");
    }

    private static ReferenceCandidateAssessment Assess(ReferenceAudioAnalysis reference, PerformanceTrack track)
        => ReferenceCandidateConfidencePolicy.Assess(ReferenceAudioTimelineAligner.Align(reference, track, 1d));

    private static SongDiscoveryCandidate Candidate(string title, int score)
        => new(
            "test-provider",
            "Test Provider",
            title,
            null,
            DiscoveredSongFormat.Midi,
            new Uri("https://example.test/" + title + ".mid"),
            new Uri("https://example.test/" + title),
            title,
            1024,
            score);

    private static PerformanceTrack CreatePulseTrack(TimeSpan firstStart, int count, TimeSpan period)
    {
        var events = Enumerable.Range(0, count)
            .Select(index => new PerformanceEvent(
                firstStart + TimeSpan.FromTicks(period.Ticks * index),
                TimeSpan.FromMilliseconds(20),
                new[] { 't' }))
            .ToArray();
        return new PerformanceTrack(
            "reference-ranking-regression",
            120,
            4,
            TimeSpan.Zero,
            events,
            events[^1].Start + events[^1].Duration);
    }

    private static byte[] CreatePulseWav(int sampleRate, int durationSeconds, int pulsePeriodMilliseconds)
    {
        var sampleCount = sampleRate * durationSeconds;
        var pcmBytes = sampleCount * 2;
        var wav = new byte[44 + pcmBytes];
        "RIFF"u8.CopyTo(wav.AsSpan(0, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(4, 4), (uint)(36 + pcmBytes));
        "WAVE"u8.CopyTo(wav.AsSpan(8, 4));
        "fmt "u8.CopyTo(wav.AsSpan(12, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(16, 4), 16);
        BinaryPrimitives.WriteUInt16LittleEndian(wav.AsSpan(20, 2), 1);
        BinaryPrimitives.WriteUInt16LittleEndian(wav.AsSpan(22, 2), 1);
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(24, 4), (uint)sampleRate);
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(28, 4), (uint)(sampleRate * 2));
        BinaryPrimitives.WriteUInt16LittleEndian(wav.AsSpan(32, 2), 2);
        BinaryPrimitives.WriteUInt16LittleEndian(wav.AsSpan(34, 2), 16);
        "data"u8.CopyTo(wav.AsSpan(36, 4));
        BinaryPrimitives.WriteUInt32LittleEndian(wav.AsSpan(40, 4), (uint)pcmBytes);

        var periodSamples = sampleRate * pulsePeriodMilliseconds / 1000;
        var pulseSamples = sampleRate * 20 / 1000;
        for (var i = 0; i < sampleCount; i++)
        {
            var value = i % periodSamples < pulseSamples ? (short)26214 : (short)0;
            BinaryPrimitives.WriteInt16LittleEndian(wav.AsSpan(44 + i * 2, 2), value);
        }

        return wav;
    }

    private static void Require(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException($"Reference-verified song ranking regression failed: {message}");
        }
    }
}
