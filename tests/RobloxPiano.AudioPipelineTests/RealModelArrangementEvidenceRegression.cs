using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class RealModelArrangementEvidenceRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            return; // Program.cs owns the explicit missing-model failure contract.

        var fixture = BuildSectionFixture();
        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));
        var result = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "real-model section evidence",
            new AudioToPianoTranscriptionOptions(
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
                    LowActivationThreshold: 0.15f)));

        var evidence = new AudioArrangementQualityEvidenceEvaluator().Evaluate(
            fixture.Reference,
            result.NoteEvidence,
            result.Arrangement.Track,
            options: new AudioTranscriptionEvaluationOptions(
                OnsetTolerance: TimeSpan.FromMilliseconds(150),
                RequireOffsetMatch: false));

        Console.WriteLine(
            $"REAL_MODEL_ARRANGEMENT source={evidence.SourceNotes} arranged={evidence.ArrangedNotes} " +
            $"sourceFP={evidence.SourceFalsePositives} arrangedFP={evidence.ArrangedFalsePositives} " +
            $"melody={evidence.RetainedMelodyNotes}/{evidence.RecognizedMelodyNotes} melodyRetention={evidence.MelodyRetention:F3} " +
            $"harmony={evidence.RetainedHarmonyNotes}/{evidence.RecognizedHarmonyNotes} harmonyRetention={evidence.HarmonyRetention:F3} " +
            $"clutterSuppression={evidence.ClutterSuppression:F3} eventRetention={evidence.EventRetentionRatio:F3} " +
            $"minSectionMelody={evidence.MinimumSectionMelodyRetention:F3}");

        foreach (var section in evidence.Sections.Values.OrderBy(item => item.Section, StringComparer.Ordinal))
        {
            Console.WriteLine(
                $"REAL_MODEL_SECTION {section.Section} melody={section.RetainedMelodyNotes}/{section.RecognizedMelodyNotes} " +
                $"melodyRetention={section.MelodyRetention:F3} harmony={section.RetainedHarmonyNotes}/{section.RecognizedHarmonyNotes} " +
                $"harmonyRetention={section.HarmonyRetention:F3}");
        }

        // These are arrangement-retention gates, not transcription-recall gates. A reference note must first be
        // recognized by the pinned real Basic Pitch model before it contributes to retention. That keeps upstream
        // model misses separate from deterministic arranger loss while still requiring meaningful real-model evidence.
        Require(evidence.RecognizedMelodyNotes >= 3,
            $"Real-model fixture recognized too little melody evidence: {evidence.RecognizedMelodyNotes}.");
        Require(evidence.RecognizedHarmonyNotes >= 5,
            $"Real-model fixture recognized too little harmony evidence: {evidence.RecognizedHarmonyNotes}.");
        Require(evidence.MelodyRetention >= 0.90,
            $"Arranger retained less than 90% of recognized melody: {evidence.MelodyRetention:F3}.");
        Require(evidence.HarmonyRetention >= 0.75,
            $"Arranger retained less than 75% of recognized harmony: {evidence.HarmonyRetention:F3}.");
        Require(evidence.MinimumSectionMelodyRetention >= 0.75,
            $"A section retained less than 75% of its recognized melody: {evidence.MinimumSectionMelodyRetention:F3}.");
        Require(!evidence.ArrangementAddedFalsePositives,
            $"Arrangement increased unmatched events: source={evidence.SourceFalsePositives}, arranged={evidence.ArrangedFalsePositives}.");
        Require(evidence.EventRetentionRatio <= 1.000001,
            $"Arrangement unexpectedly increased event count: {evidence.EventRetentionRatio:F3}.");
    }

    private static SectionFixture BuildSectionFixture()
    {
        var notes = new[]
        {
            new FixtureNote("verse", AudioArrangementReferenceRole.Harmony, 60, 0.30, 0.95, 0.72),
            new FixtureNote("verse", AudioArrangementReferenceRole.Harmony, 64, 0.30, 0.95, 0.62),
            new FixtureNote("verse", AudioArrangementReferenceRole.Melody, 72, 0.30, 0.95, 0.88),

            new FixtureNote("transition", AudioArrangementReferenceRole.Harmony, 62, 1.15, 1.75, 0.68),
            new FixtureNote("transition", AudioArrangementReferenceRole.Harmony, 65, 1.15, 1.75, 0.60),
            new FixtureNote("transition", AudioArrangementReferenceRole.Melody, 74, 1.15, 1.75, 0.86),

            new FixtureNote("chorus", AudioArrangementReferenceRole.Harmony, 60, 2.00, 2.75, 0.75),
            new FixtureNote("chorus", AudioArrangementReferenceRole.Harmony, 64, 2.00, 2.75, 0.70),
            new FixtureNote("chorus", AudioArrangementReferenceRole.Harmony, 67, 2.00, 2.75, 0.78),
            new FixtureNote("chorus", AudioArrangementReferenceRole.Melody, 76, 2.00, 2.75, 0.92),

            new FixtureNote("outro", AudioArrangementReferenceRole.Harmony, 62, 3.00, 3.55, 0.66),
            new FixtureNote("outro", AudioArrangementReferenceRole.Harmony, 65, 3.00, 3.55, 0.60),
            new FixtureNote("outro", AudioArrangementReferenceRole.Melody, 74, 3.00, 3.55, 0.82)
        };
        var rate = BasicPitchInferenceService.RequiredSampleRate;
        var samples = new float[checked((int)Math.Round(3.90 * rate))];

        foreach (var note in notes)
        {
            var startSample = Math.Max(0, (int)Math.Round(note.StartSeconds * rate));
            var endSample = Math.Min(samples.Length, (int)Math.Round(note.EndSeconds * rate));
            var fundamental = 440.0 * Math.Pow(2.0, (note.MidiNote - 69) / 12.0);
            for (var i = startSample; i < endSample; i++)
            {
                var local = (i - startSample) / (double)rate;
                var duration = note.EndSeconds - note.StartSeconds;
                var normalized = Math.Clamp(local / Math.Max(duration, 1e-6), 0.0, 1.0);
                var attack = 1.0 - Math.Exp(-local / 0.006);
                var decay = 0.30 + 0.70 * Math.Exp(-local / 0.42);
                var release = normalized > 0.82
                    ? Math.Clamp((1.0 - normalized) / 0.18, 0.0, 1.0)
                    : 1.0;
                var envelope = attack * decay * release * note.Velocity;
                var value =
                    Math.Sin(2.0 * Math.PI * fundamental * local) * 1.00 +
                    Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.17) * 0.42 +
                    Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.31) * 0.22 +
                    Math.Sin(2.0 * Math.PI * fundamental * 4.0 * local + 0.47) * 0.12 +
                    Math.Sin(2.0 * Math.PI * fundamental * 5.0 * local + 0.61) * 0.07;
                if (local < 0.012)
                    value += Math.Sin(2.0 * Math.PI * (fundamental * 7.3) * local) * (1.0 - local / 0.012) * 0.10;
                samples[i] += (float)(value * envelope * 0.27);
            }
        }

        var peak = samples.Select(Math.Abs).DefaultIfEmpty(0f).Max();
        if (peak > 0.92f)
        {
            var scale = 0.92f / peak;
            for (var i = 0; i < samples.Length; i++)
                samples[i] *= scale;
        }

        var reference = notes.Select(note => new AudioArrangementReferenceNote(
            note.Section,
            note.Role,
            new AudioTranscriptionReferenceNote(
                TimeSpan.FromSeconds(note.StartSeconds),
                TimeSpan.FromSeconds(note.EndSeconds),
                note.MidiNote))).ToArray();
        return new SectionFixture(samples, reference);
    }

    private static void Require(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
    }

    private sealed record FixtureNote(
        string Section,
        AudioArrangementReferenceRole Role,
        int MidiNote,
        double StartSeconds,
        double EndSeconds,
        double Velocity);

    private sealed record SectionFixture(
        float[] Samples,
        IReadOnlyList<AudioArrangementReferenceNote> Reference);
}
