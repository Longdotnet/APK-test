using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class AudioTranscriptionRepairEvidenceRegression
{
    [ModuleInitializer]
    internal static void RunPhase39bRegression()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            throw new InvalidOperationException("BASIC_PITCH_MODEL_PATH is required for Phase 39b regression coverage.");

        var rate = BasicPitchInferenceService.RequiredSampleRate;
        var samples = BuildTone(rate, seconds: 1.4, frequencyHz: 440.0);
        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));

        var options = new AudioToPianoTranscriptionOptions(
            Decoder: new BasicPitchNoteDecoderOptions(
                OnsetThreshold: 0.20f,
                FrameThreshold: 0.15f,
                MinimumNoteLengthFrames: 3,
                EnergyToleranceFrames: 8,
                UseMelodiaRecovery: true,
                IncludePitchBends: true),
            Arrangement: new RobloxPianoArrangementOptions(
                MaxSimultaneousNotes: 4,
                MinimumDuration: TimeSpan.FromMilliseconds(20),
                LowActivationThreshold: 0.15f),
            ReviewRegions: new AudioTranscriptionReviewRegionOptions(
                WindowDuration: TimeSpan.FromSeconds(1),
                LowActivationThreshold: 1.0f,
                LowRetentionRatio: 0d,
                HighEventsPerSecond: 1000d,
                HighSimultaneousNotes: 16));

        var result = service.TranscribeNormalized(
            new NormalizedAudio(samples, rate),
            "phase39b-repair-evidence",
            options);

        if (result.NoteEvidence.Count == 0)
            throw new InvalidOperationException("Phase 39b must retain deterministic post-suppression note evidence for repair.");
        if (result.NoteEvidence.Count != result.Diagnostics.NotesAfterSuppression)
            throw new InvalidOperationException(
                $"Repair evidence count {result.NoteEvidence.Count} must equal post-suppression note count {result.Diagnostics.NotesAfterSuppression}.");
        if (result.Diagnostics.ReviewRegions.Count == 0)
            throw new InvalidOperationException("Forced Phase 39b fixture must retain a local review region.");
        if (result.Diagnostics.BaseQuality.Reasons.Any(reason => reason.StartsWith("REVIEW_REGION_", StringComparison.Ordinal)))
            throw new InvalidOperationException("Base/global quality must not contain synthetic local review-region reasons.");
        if (!result.Diagnostics.Quality.Reasons.Any(reason => reason.StartsWith("REVIEW_REGION_", StringComparison.Ordinal)))
            throw new InvalidOperationException("Client-visible quality must still expose local review-region reasons before repair.");

        var session = new AudioTranscriptionReviewRepairSession(
            result.Diagnostics.SourceDuration,
            result.NoteEvidence,
            result.Arrangement.Track);
        if (session.ReviewRegions.Count == 0)
            throw new InvalidOperationException("Retained evidence must be sufficient to recreate deterministic repair review state without a second inference pass.");

        Console.WriteLine(
            $"PASS Phase 39b retained repair evidence: notes={result.NoteEvidence.Count}, reviewRegions={session.ReviewRegions.Count}, baseReadiness={result.Diagnostics.BaseQuality.Readiness}, visibleReadiness={result.Diagnostics.Quality.Readiness}.");
    }

    private static float[] BuildTone(int sampleRate, double seconds, double frequencyHz)
    {
        var length = checked((int)Math.Round(seconds * sampleRate));
        var samples = new float[length];
        var attackSamples = Math.Max(1, sampleRate / 50);
        var releaseSamples = Math.Max(1, sampleRate / 25);
        for (var index = 0; index < samples.Length; index++)
        {
            var attack = Math.Min(1.0, index / (double)attackSamples);
            var release = Math.Min(1.0, (samples.Length - 1 - index) / (double)releaseSamples);
            var envelope = Math.Min(attack, release);
            samples[index] = (float)(Math.Sin(2 * Math.PI * frequencyHz * index / sampleRate) * 0.45 * envelope);
        }
        return samples;
    }
}
