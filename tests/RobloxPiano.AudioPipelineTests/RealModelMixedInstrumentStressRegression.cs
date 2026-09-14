using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class RealModelMixedInstrumentStressRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            return; // Program.cs owns the explicit missing-model failure contract.

        var fixture = BuildStressFixture();
        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));

        var result = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "real-model mixed-instrument stress evidence",
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
                OnsetTolerance: TimeSpan.FromMilliseconds(160),
                RequireOffsetMatch: false));

        var sourceSeparationDecision = DecideSourceSeparation(evidence);
        Console.WriteLine(
            $"REAL_MODEL_MIXED_STRESS source={evidence.SourceNotes} arranged={evidence.ArrangedNotes} " +
            $"sourceFP={evidence.SourceFalsePositives} arrangedFP={evidence.ArrangedFalsePositives} " +
            $"melody={evidence.RetainedMelodyNotes}/{evidence.RecognizedMelodyNotes} melodyRetention={evidence.MelodyRetention:F3} " +
            $"harmony={evidence.RetainedHarmonyNotes}/{evidence.RecognizedHarmonyNotes} harmonyRetention={evidence.HarmonyRetention:F3} " +
            $"clutterSuppression={evidence.ClutterSuppression:F3} eventRetention={evidence.EventRetentionRatio:F3} " +
            $"minSectionMelody={evidence.MinimumSectionMelodyRetention:F3} separationDecision={sourceSeparationDecision}");

        foreach (var section in evidence.Sections.Values.OrderBy(item => item.Section, StringComparer.Ordinal))
        {
            Console.WriteLine(
                $"REAL_MODEL_MIXED_SECTION {section.Section} melody={section.RetainedMelodyNotes}/{section.RecognizedMelodyNotes} " +
                $"melodyRetention={section.MelodyRetention:F3} harmony={section.RetainedHarmonyNotes}/{section.RecognizedHarmonyNotes} " +
                $"harmonyRetention={section.HarmonyRetention:F3}");
        }

        // These floors intentionally grade only notes the pinned Basic Pitch model recognized. The stress fixture
        // adds bass/pad energy, octave doubles and short non-pitched transients so this gate catches arranger quality
        // regressions without pretending that deterministic post-processing can repair upstream AMT misses.
        Require(evidence.RecognizedMelodyNotes >= 3,
            $"Mixed stress fixture recognized too little melody evidence: {evidence.RecognizedMelodyNotes}.");
        Require(evidence.RecognizedHarmonyNotes >= 5,
            $"Mixed stress fixture recognized too little harmony evidence: {evidence.RecognizedHarmonyNotes}.");
        Require(evidence.MelodyRetention >= 0.85,
            $"Mixed stress arranger retained less than 85% of recognized melody: {evidence.MelodyRetention:F3}.");
        Require(evidence.HarmonyRetention >= 0.75,
            $"Mixed stress arranger retained less than 75% of recognized harmony: {evidence.HarmonyRetention:F3}.");
        Require(evidence.MinimumSectionMelodyRetention >= 0.66,
            $"A mixed stress section retained less than two thirds of recognized melody: {evidence.MinimumSectionMelodyRetention:F3}.");
        Require(evidence.ClutterSuppression >= 0.25,
            $"Mixed stress arranger suppressed less than the Phase 61 clutter floor: {evidence.ClutterSuppression:F3}.");
        Require(!evidence.ArrangementAddedFalsePositives,
            $"Mixed stress arrangement increased unmatched events: source={evidence.SourceFalsePositives}, arranged={evidence.ArrangedFalsePositives}.");
        Require(evidence.EventRetentionRatio <= 1.000001,
            $"Mixed stress arrangement unexpectedly increased event count: {evidence.EventRetentionRatio:F3}.");

        Require(evidence.Sections.TryGetValue("chorus", out var chorus),
            "Mixed stress fixture must report chorus quality evidence.");
        Require(chorus.RecognizedHarmonyNotes >= 4,
            $"Mixed stress chorus recognized too little harmony evidence: {chorus.RecognizedHarmonyNotes}.");
        Require(chorus.HarmonyRetention >= 0.75,
            $"Dense chorus retained less than three quarters of recognized harmony: {chorus.RetainedHarmonyNotes}/{chorus.RecognizedHarmonyNotes} ({chorus.HarmonyRetention:F3}).");

        // A deterministic pass keeps source separation deferred. If future pinned-model evidence drops beneath the
        // stricter quality ceiling, CI prints BENCHMARK_NATIVE_SEPARATION before the ordinary hard regression floors
        // are crossed, giving maintainers a measurable reason to benchmark demucs.cpp rather than adding it by instinct.
        Require(sourceSeparationDecision is "DEFER",
            $"Mixed-instrument evidence crossed the native separation decision gate: {sourceSeparationDecision}.");
    }

    private static string DecideSourceSeparation(AudioArrangementQualityEvidence evidence)
    {
        var enoughEvidence = evidence.RecognizedMelodyNotes >= 3 && evidence.RecognizedHarmonyNotes >= 5;
        if (!enoughEvidence)
            return "INSUFFICIENT_EVIDENCE";

        var clutterCeiling = evidence.SourceFalsePositives >= 3 && evidence.ClutterSuppression < 0.10;
        var chorusCeiling = evidence.Sections.TryGetValue("chorus", out var chorus)
            && chorus.RecognizedHarmonyNotes >= 4
            && chorus.HarmonyRetention < 0.75;
        var retentionCeiling = evidence.MelodyRetention < 0.85
            || evidence.HarmonyRetention < 0.75
            || evidence.MinimumSectionMelodyRetention < 0.66
            || chorusCeiling;
        return clutterCeiling || retentionCeiling ? "BENCHMARK_NATIVE_SEPARATION" : "DEFER";
    }

    private static StressFixture BuildStressFixture()
    {
        var notes = new[]
        {
            new FixtureNote("verse", AudioArrangementReferenceRole.Harmony, 48, 0.35, 1.10, 0.48, Timbre.Bass),
            new FixtureNote("verse", AudioArrangementReferenceRole.Harmony, 60, 0.35, 1.10, 0.58, Timbre.Pad),
            new FixtureNote("verse", AudioArrangementReferenceRole.Harmony, 64, 0.35, 1.10, 0.52, Timbre.Pad),
            new FixtureNote("verse", AudioArrangementReferenceRole.Melody, 72, 0.35, 1.10, 0.88, Timbre.Lead),

            new FixtureNote("prechorus", AudioArrangementReferenceRole.Harmony, 50, 1.45, 2.20, 0.52, Timbre.Bass),
            new FixtureNote("prechorus", AudioArrangementReferenceRole.Harmony, 62, 1.45, 2.20, 0.60, Timbre.Pad),
            new FixtureNote("prechorus", AudioArrangementReferenceRole.Harmony, 65, 1.45, 2.20, 0.55, Timbre.Pad),
            new FixtureNote("prechorus", AudioArrangementReferenceRole.Melody, 74, 1.45, 2.20, 0.90, Timbre.Lead),

            new FixtureNote("chorus", AudioArrangementReferenceRole.Harmony, 48, 2.55, 3.45, 0.56, Timbre.Bass),
            new FixtureNote("chorus", AudioArrangementReferenceRole.Harmony, 60, 2.55, 3.45, 0.66, Timbre.Pad),
            new FixtureNote("chorus", AudioArrangementReferenceRole.Harmony, 64, 2.55, 3.45, 0.62, Timbre.Pad),
            new FixtureNote("chorus", AudioArrangementReferenceRole.Harmony, 67, 2.55, 3.45, 0.68, Timbre.Pad),
            new FixtureNote("chorus", AudioArrangementReferenceRole.Melody, 76, 2.55, 3.45, 0.95, Timbre.Lead),

            new FixtureNote("bridge", AudioArrangementReferenceRole.Harmony, 53, 3.80, 4.55, 0.50, Timbre.Bass),
            new FixtureNote("bridge", AudioArrangementReferenceRole.Harmony, 65, 3.80, 4.55, 0.56, Timbre.Pad),
            new FixtureNote("bridge", AudioArrangementReferenceRole.Harmony, 69, 3.80, 4.55, 0.52, Timbre.Pad),
            new FixtureNote("bridge", AudioArrangementReferenceRole.Melody, 77, 3.80, 4.55, 0.91, Timbre.Lead),

            new FixtureNote("outro", AudioArrangementReferenceRole.Harmony, 50, 4.90, 5.55, 0.46, Timbre.Bass),
            new FixtureNote("outro", AudioArrangementReferenceRole.Harmony, 62, 4.90, 5.55, 0.52, Timbre.Pad),
            new FixtureNote("outro", AudioArrangementReferenceRole.Harmony, 65, 4.90, 5.55, 0.48, Timbre.Pad),
            new FixtureNote("outro", AudioArrangementReferenceRole.Melody, 74, 4.90, 5.55, 0.84, Timbre.Lead)
        };

        var rate = BasicPitchInferenceService.RequiredSampleRate;
        var samples = new float[checked((int)Math.Round(5.90 * rate))];
        foreach (var note in notes)
            AddTonalNote(samples, rate, note);

        // Weak octave doubles imitate a common mixed-song failure mode where vocal/lead harmonics are decoded as
        // a second melody voice. They are deliberately not reference notes: useful deterministic arrangement should
        // not be rewarded for retaining them merely because they are above the real melody.
        AddTonalNote(samples, rate, new FixtureNote("clutter", AudioArrangementReferenceRole.Melody, 84, 0.35, 1.10, 0.17, Timbre.Lead));
        AddTonalNote(samples, rate, new FixtureNote("clutter", AudioArrangementReferenceRole.Melody, 86, 1.45, 2.20, 0.16, Timbre.Lead));
        AddTonalNote(samples, rate, new FixtureNote("clutter", AudioArrangementReferenceRole.Melody, 88, 2.55, 3.45, 0.18, Timbre.Lead));
        AddTonalNote(samples, rate, new FixtureNote("clutter", AudioArrangementReferenceRole.Melody, 89, 3.80, 4.55, 0.16, Timbre.Lead));

        // Deterministic broadband-ish transients model kick/snare/click contamination without distributing any
        // third-party recording. Basic Pitch may ignore these entirely; if it does decode them, they count as source
        // false positives and allow the arranger's clutter suppression to be measured.
        foreach (var transient in new[] { 0.34, 1.44, 2.54, 2.96, 3.79, 4.89 })
            AddTransient(samples, rate, transient, amplitude: 0.09);

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
        return new StressFixture(samples, reference);
    }

    private static void AddTonalNote(float[] samples, int rate, FixtureNote note)
    {
        var startSample = Math.Max(0, (int)Math.Round(note.StartSeconds * rate));
        var endSample = Math.Min(samples.Length, (int)Math.Round(note.EndSeconds * rate));
        var fundamental = 440.0 * Math.Pow(2.0, (note.MidiNote - 69) / 12.0);
        for (var i = startSample; i < endSample; i++)
        {
            var local = (i - startSample) / (double)rate;
            var duration = Math.Max(note.EndSeconds - note.StartSeconds, 1e-6);
            var normalized = Math.Clamp(local / duration, 0.0, 1.0);
            var attackSeconds = note.Timbre == Timbre.Pad ? 0.055 : 0.007;
            var attack = 1.0 - Math.Exp(-local / attackSeconds);
            var releaseStart = note.Timbre == Timbre.Pad ? 0.72 : 0.84;
            var release = normalized > releaseStart
                ? Math.Clamp((1.0 - normalized) / (1.0 - releaseStart), 0.0, 1.0)
                : 1.0;
            var decay = note.Timbre switch
            {
                Timbre.Bass => 0.38 + 0.62 * Math.Exp(-local / 0.34),
                Timbre.Lead => 0.48 + 0.52 * Math.Exp(-local / 0.72),
                _ => 0.72 + 0.28 * Math.Exp(-local / 1.10)
            };
            var envelope = attack * release * decay * note.Velocity;
            var value = note.Timbre switch
            {
                Timbre.Bass =>
                    Math.Sin(2.0 * Math.PI * fundamental * local) * 1.00 +
                    Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.13) * 0.23 +
                    Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.29) * 0.09,
                Timbre.Pad =>
                    Math.Sin(2.0 * Math.PI * fundamental * local) * 0.78 +
                    Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.37) * 0.31 +
                    Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.51) * 0.14,
                _ =>
                    Math.Sin(2.0 * Math.PI * fundamental * local) * 1.00 +
                    Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.17) * 0.36 +
                    Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.31) * 0.19 +
                    Math.Sin(2.0 * Math.PI * fundamental * 4.0 * local + 0.47) * 0.08
            };
            samples[i] += (float)(value * envelope * 0.20);
        }
    }

    private static void AddTransient(float[] samples, int rate, double seconds, double amplitude)
    {
        var start = Math.Max(0, (int)Math.Round(seconds * rate));
        var length = Math.Min(samples.Length - start, Math.Max(1, (int)Math.Round(0.018 * rate)));
        for (var i = 0; i < length; i++)
        {
            var t = i / (double)rate;
            var envelope = Math.Exp(-t / 0.0045);
            // Sum incommensurate high frequencies instead of random noise so the fixture is bit-deterministic.
            var value = Math.Sin(2.0 * Math.PI * 1733.0 * t)
                + 0.73 * Math.Sin(2.0 * Math.PI * 2381.0 * t + 0.41)
                + 0.51 * Math.Sin(2.0 * Math.PI * 3197.0 * t + 0.77);
            samples[start + i] += (float)(value * envelope * amplitude / 2.24);
        }
    }

    private static void Require(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
    }

    private enum Timbre
    {
        Bass,
        Pad,
        Lead
    }

    private sealed record FixtureNote(
        string Section,
        AudioArrangementReferenceRole Role,
        int MidiNote,
        double StartSeconds,
        double EndSeconds,
        double Velocity,
        Timbre Timbre);

    private sealed record StressFixture(
        float[] Samples,
        IReadOnlyList<AudioArrangementReferenceNote> Reference);
}
