using System.Buffers.Binary;
using System.Runtime.CompilerServices;
using RobloxPiano.Core;

namespace RobloxPiano.QualityTests;

internal static class ReferenceAudioTimelineAlignmentRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        PerfectPulseAlignmentIsDeterministic();
        GlobalOffsetIsRecoveredWithoutMutatingTimeline();
        PlaybackSpeedParticipatesInEvidence();
        TamperedEvidenceFailsClosed();
        StrongReferenceMatchIsHighConfidence();
        SparseEvidenceRequiresReview();
        LowCoverageIsMismatch();
        HalfDoubleTempoAmbiguityIsNormalized();
        TamperedAssessmentFailsClosed();
    }

    private static void PerfectPulseAlignmentIsDeterministic()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 4, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(500), 7, TimeSpan.FromMilliseconds(500));
        var first = ReferenceAudioTimelineAligner.Align(reference, track, 1d);
        var second = ReferenceAudioTimelineAligner.Align(reference, track, 1d);

        Require(ReferenceAudioTimelineAligner.Verify(first), "valid alignment evidence must verify");
        Require(first.EvidenceSha256 == second.EvidenceSha256, "alignment evidence must be deterministic");
        Require(first.MatchedOnsetCount >= 6, "pulse timeline should match repeated reference onsets");
        Require(first.MeanAbsoluteErrorMilliseconds < 0.01d, "matching pulse train should have near-zero timing error");
        Require(Math.Abs(first.TempoRatio - 1d) < 0.001d, "120 BPM canonical timeline should match 120 BPM reference tempo");
    }

    private static void GlobalOffsetIsRecoveredWithoutMutatingTimeline()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 4, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(250), 7, TimeSpan.FromMilliseconds(500));
        var evidence = ReferenceAudioTimelineAligner.Align(reference, track, 1d);

        Require(Math.Abs(evidence.AlignmentOffsetMilliseconds - 250d) < 0.01d,
            "aligner should recover deterministic global offset");
        Require(evidence.MeanAbsoluteErrorMilliseconds < 0.01d,
            "global offset should be separated from residual timing error");
        Require(track.Events[0].Start == TimeSpan.FromMilliseconds(250),
            "evidence analysis must not mutate canonical event timing");
    }

    private static void PlaybackSpeedParticipatesInEvidence()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 4, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(500), 7, TimeSpan.FromMilliseconds(500));
        var legacy = ReferenceAudioTimelineAligner.Align(reference, track, 1d);
        var legacyX2 = ReferenceAudioTimelineAligner.Align(reference, track, 2d);

        Require(legacy.EvidenceSha256 != legacyX2.EvidenceSha256,
            "playback speed must participate in immutable alignment evidence");
        Require(legacy.MatchCoverage > legacyX2.MatchCoverage,
            "2x timing against a 1x reference must not be misreported as equally aligned");
        Require(Math.Abs(legacyX2.TempoRatio - 2d) < 0.001d,
            "tempo evidence must expose the 2x candidate/reference ratio");
    }

    private static void TamperedEvidenceFailsClosed()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 3, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(500), 5, TimeSpan.FromMilliseconds(500));
        var evidence = ReferenceAudioTimelineAligner.Align(reference, track, 1d);
        var tampered = evidence with { MeanAbsoluteErrorMilliseconds = evidence.MeanAbsoluteErrorMilliseconds + 1d };

        Require(!ReferenceAudioTimelineAligner.Verify(tampered),
            "changed metrics with the old evidence hash must fail closed");
    }

    private static void StrongReferenceMatchIsHighConfidence()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 5, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(500), 9, TimeSpan.FromMilliseconds(500));
        var alignment = ReferenceAudioTimelineAligner.Align(reference, track, 1d);
        var first = ReferenceCandidateConfidencePolicy.Assess(alignment);
        var second = ReferenceCandidateConfidencePolicy.Assess(alignment);

        Require(first.Verdict == ReferenceCandidateVerdict.HighConfidence,
            "strong repeated onset alignment should be high confidence");
        Require(first.ConfidenceScore >= 75, "high-confidence match should meet score floor");
        Require(first.ReasonCode == "HIGH_CONFIDENCE", "high-confidence reason code must be stable");
        Require(first.EvidenceSha256 == second.EvidenceSha256, "assessment evidence must be deterministic");
        Require(ReferenceCandidateConfidencePolicy.Verify(first), "generated assessment evidence must verify");
    }

    private static void SparseEvidenceRequiresReview()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 2, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(500), 3, TimeSpan.FromMilliseconds(500));
        var alignment = ReferenceAudioTimelineAligner.Align(reference, track, 1d);
        var assessment = ReferenceCandidateConfidencePolicy.Assess(alignment);

        Require(assessment.Verdict == ReferenceCandidateVerdict.Review,
            "a short candidate should not be promoted from only a few matching events");
        Require(assessment.ReasonCode == "INSUFFICIENT_EVIDENCE",
            "sparse evidence should explain why review is required");
    }

    private static void LowCoverageIsMismatch()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 5, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(100), 34, TimeSpan.FromMilliseconds(137));
        var alignment = ReferenceAudioTimelineAligner.Align(reference, track, 1d);
        var assessment = ReferenceCandidateConfidencePolicy.Assess(alignment);

        Require(alignment.MatchCoverage < 0.35d, "regression fixture must remain a low-coverage timeline");
        Require(assessment.Verdict == ReferenceCandidateVerdict.Mismatch,
            "low onset coverage must reject same-title-style false positives");
        Require(assessment.ReasonCode == "LOW_ONSET_COVERAGE", "coverage mismatch reason must be explicit");
    }

    private static void HalfDoubleTempoAmbiguityIsNormalized()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 5, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(500), 9, TimeSpan.FromMilliseconds(500));
        var alignment = ReferenceAudioTimelineAligner.Align(reference, track, 2d);
        var assessment = ReferenceCandidateConfidencePolicy.Assess(alignment);

        Require(Math.Abs(alignment.TempoRatio - 2d) < 0.001d, "fixture must expose raw 2x tempo ratio");
        Require(Math.Abs(assessment.NormalizedTempoRatio - 1d) < 0.001d,
            "one metrical octave should normalize before confidence scoring");
        Require(assessment.Verdict != ReferenceCandidateVerdict.Mismatch || assessment.ReasonCode != "TEMPO_MISMATCH",
            "half/double tempo ambiguity alone must not cause a tempo mismatch");
    }

    private static void TamperedAssessmentFailsClosed()
    {
        var reference = ReferenceAudioAnalyzer.AnalyzeWav(CreatePulseWav(8000, 4, 500));
        var track = CreatePulseTrack(TimeSpan.FromMilliseconds(500), 7, TimeSpan.FromMilliseconds(500));
        var assessment = ReferenceCandidateConfidencePolicy.Assess(
            ReferenceAudioTimelineAligner.Align(reference, track, 1d));
        var tampered = assessment with { ConfidenceScore = Math.Max(0, assessment.ConfidenceScore - 1) };

        Require(!ReferenceCandidateConfidencePolicy.Verify(tampered),
            "changed assessment metrics with old evidence hash must fail closed");
    }

    private static PerformanceTrack CreatePulseTrack(TimeSpan firstStart, int count, TimeSpan period)
    {
        var events = Enumerable.Range(0, count)
            .Select(index => new PerformanceEvent(
                firstStart + TimeSpan.FromTicks(period.Ticks * index),
                TimeSpan.FromMilliseconds(20),
                new[] { 't' }))
            .ToArray();
        return new PerformanceTrack(
            "reference-alignment-regression",
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
            throw new InvalidOperationException($"Reference-audio alignment regression failed: {message}");
        }
    }
}
