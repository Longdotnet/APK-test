using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class RealModelRepeatedProgressionContinuityRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            return;

        var fixture = BuildFixture();
        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));

        // Decode exactly once so the control and production arranger see identical pinned-model evidence.
        var decoded = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "real-model repeated progression continuity",
            new AudioToPianoTranscriptionOptions(
                Decoder: DecoderOptions,
                Arrangement: ContinuityOptions));

        var continuityEvidence = Evaluate(fixture.Reference, decoded.NoteEvidence, decoded.Arrangement.Track);
        var noContinuityArrangement = new RobloxPianoArranger().Arrange(
            "real-model repeated progression no continuity",
            decoded.NoteEvidence,
            NoContinuityOptions);
        var noContinuityEvidence = Evaluate(
            fixture.Reference,
            decoded.NoteEvidence,
            noContinuityArrangement.Track);

        var continuitySelections = decoded.Arrangement.Diagnostics.HarmonyContinuitySelections;
        var harmonyDelta = continuityEvidence.HarmonyRetention - noContinuityEvidence.HarmonyRetention;
        var clutterDelta = continuityEvidence.ClutterSuppression - noContinuityEvidence.ClutterSuppression;
        var sectionWins = 0;
        var sectionLosses = 0;

        foreach (var sectionName in fixture.SectionNames)
        {
            if (!continuityEvidence.Sections.TryGetValue(sectionName, out var withContinuity) || withContinuity is null)
                continue;
            if (!noContinuityEvidence.Sections.TryGetValue(sectionName, out var withoutContinuity) || withoutContinuity is null)
                continue;

            if (withContinuity.HarmonyRetention > withoutContinuity.HarmonyRetention + 1e-9)
                sectionWins++;
            else if (withContinuity.HarmonyRetention + 1e-9 < withoutContinuity.HarmonyRetention)
                sectionLosses++;
        }

        var continuityDecision = continuitySelections == 0
            ? "TUNE_REQUIRED"
            : harmonyDelta > 0.000001 || sectionWins > 0
                ? "PROVEN_GAIN"
                : "NEUTRAL";

        Console.WriteLine(
            $"REAL_MODEL_PROGRESSION_CONTINUITY decision={continuityDecision} selections={continuitySelections} " +
            $"melody={continuityEvidence.RetainedMelodyNotes}/{continuityEvidence.RecognizedMelodyNotes} " +
            $"harmony={continuityEvidence.RetainedHarmonyNotes}/{continuityEvidence.RecognizedHarmonyNotes} " +
            $"harmonyRetention={continuityEvidence.HarmonyRetention:F3} baselineHarmony={noContinuityEvidence.HarmonyRetention:F3} " +
            $"harmonyDelta={harmonyDelta:+0.000;-0.000;0.000} clutter={continuityEvidence.ClutterSuppression:F3} " +
            $"baselineClutter={noContinuityEvidence.ClutterSuppression:F3} clutterDelta={clutterDelta:+0.000;-0.000;0.000} " +
            $"sectionWins={sectionWins} sectionLosses={sectionLosses}");

        foreach (var sectionName in fixture.SectionNames)
        {
            continuityEvidence.Sections.TryGetValue(sectionName, out var withContinuity);
            noContinuityEvidence.Sections.TryGetValue(sectionName, out var withoutContinuity);
            Console.WriteLine(
                $"REAL_MODEL_PROGRESSION_SECTION {sectionName} " +
                $"continuityHarmony={withContinuity?.RetainedHarmonyNotes ?? 0}/{withContinuity?.RecognizedHarmonyNotes ?? 0} " +
                $"continuityRetention={withContinuity?.HarmonyRetention ?? 1.0:F3} " +
                $"baselineHarmony={withoutContinuity?.RetainedHarmonyNotes ?? 0}/{withoutContinuity?.RecognizedHarmonyNotes ?? 0} " +
                $"baselineRetention={withoutContinuity?.HarmonyRetention ?? 1.0:F3}");
        }

        // Grade only recognized notes. Phase 65's first exact-head run established 30/43 = 0.698 harmony retention;
        // the 0.69 floor catches degradation while avoiding a rounded 0.70 threshold that rejects the measured baseline.
        Require(continuityEvidence.RecognizedMelodyNotes >= 8,
            $"Repeated progression fixture recognized too little melody evidence: {continuityEvidence.RecognizedMelodyNotes}.");
        Require(continuityEvidence.RecognizedHarmonyNotes >= 20,
            $"Repeated progression fixture recognized too little harmony evidence: {continuityEvidence.RecognizedHarmonyNotes}.");
        Require(continuityEvidence.MelodyRetention >= 0.90,
            $"Repeated progression retained less than 90% recognized melody: {continuityEvidence.MelodyRetention:F3}.");
        Require(continuityEvidence.HarmonyRetention >= 0.69,
            $"Repeated progression retained less than the measured 69% recognized-harmony floor: {continuityEvidence.HarmonyRetention:F3}.");
        Require(continuityEvidence.MinimumSectionMelodyRetention >= 0.80,
            $"Repeated progression section melody floor regressed: {continuityEvidence.MinimumSectionMelodyRetention:F3}.");
        Require(!continuityEvidence.ArrangementAddedFalsePositives,
            "Harmony continuity must never synthesize unmatched playback events.");
        Require(continuityEvidence.EventRetentionRatio <= 1.000001,
            $"Continuity unexpectedly increased event count: {continuityEvidence.EventRetentionRatio:F3}.");

        // A zero selection count is an engineering finding, not a green claim that continuity helped. Keep it explicit as
        // TUNE_REQUIRED while still failing closed on any quality regression versus the exact same decoded-note control.
        Require(harmonyDelta >= -0.000001,
            $"Harmony continuity reduced global recognized-harmony retention versus disabled control: {harmonyDelta:F3}.");
        Require(sectionLosses == 0,
            $"Harmony continuity reduced recognized-harmony retention in {sectionLosses} progression section(s).");
        Require(clutterDelta >= -0.05,
            $"Harmony continuity materially reduced clutter suppression versus disabled control: {clutterDelta:F3}.");
    }

    private static readonly BasicPitchNoteDecoderOptions DecoderOptions = new(
        OnsetThreshold: 0.20f,
        FrameThreshold: 0.15f,
        MinimumNoteLengthFrames: 3,
        EnergyToleranceFrames: 8,
        UseMelodiaRecovery: true,
        IncludePitchBends: true);

    private static readonly RobloxPianoArrangementOptions ContinuityOptions = new(
        MaxSimultaneousNotes: 4,
        MinimumDuration: TimeSpan.FromMilliseconds(20),
        LowActivationThreshold: 0.15f);

    private static readonly RobloxPianoArrangementOptions NoContinuityOptions = ContinuityOptions with
    {
        HarmonyContinuityWindow = TimeSpan.FromMilliseconds(1)
    };

    private static AudioArrangementQualityEvidence Evaluate(
        IReadOnlyList<AudioArrangementReferenceNote> reference,
        IReadOnlyList<BasicPitchTranscribedNote> decoded,
        RobloxPiano.Core.PerformanceTrack track)
        => new AudioArrangementQualityEvidenceEvaluator().Evaluate(
            reference,
            decoded,
            track,
            options: new AudioTranscriptionEvaluationOptions(
                OnsetTolerance: TimeSpan.FromMilliseconds(160),
                RequireOffsetMatch: false));

    private static ProgressionFixture BuildFixture()
    {
        var chords = new[]
        {
            Chord("verse-c1", 0.35, 48, new[] { 60, 64, 67, 71 }, 72, new[] { .62, .58, .57, .55 }, .90),
            Chord("verse-am1", 1.05, 45, new[] { 57, 60, 64, 67 }, 76, new[] { .61, .55, .58, .56 }, .91),
            Chord("verse-f1", 1.75, 41, new[] { 53, 57, 60, 64 }, 77, new[] { .60, .57, .55, .58 }, .90),
            Chord("verse-g1", 2.45, 43, new[] { 55, 59, 62, 65 }, 79, new[] { .61, .58, .57, .55 }, .92),
            Chord("chorus-c2", 3.15, 48, new[] { 60, 64, 67, 71 }, 76, new[] { .60, .56, .59, .58 }, .95),
            Chord("chorus-am2", 3.85, 45, new[] { 57, 60, 64, 67 }, 81, new[] { .59, .58, .55, .60 }, .94),
            Chord("chorus-f2", 4.55, 41, new[] { 53, 57, 60, 64 }, 81, new[] { .58, .60, .56, .57 }, .95),
            Chord("chorus-g2", 5.25, 43, new[] { 55, 59, 62, 65 }, 83, new[] { .60, .56, .59, .58 }, .96),
            Chord("outro-c3", 5.95, 48, new[] { 60, 64, 67, 71 }, 72, new[] { .58, .60, .56, .57 }, .88)
        };

        var notes = new List<FixtureNote>();
        foreach (var chord in chords)
        {
            notes.Add(new FixtureNote(chord.Section, AudioArrangementReferenceRole.Harmony, chord.Bass, chord.Start, chord.Start + 0.58, 0.57, Timbre.Bass));
            for (var i = 0; i < chord.Harmony.Length; i++)
                notes.Add(new FixtureNote(chord.Section, AudioArrangementReferenceRole.Harmony, chord.Harmony[i], chord.Start, chord.Start + 0.58, chord.HarmonyVelocity[i], Timbre.Pad));
            notes.Add(new FixtureNote(chord.Section, AudioArrangementReferenceRole.Melody, chord.Melody, chord.Start, chord.Start + 0.58, chord.MelodyVelocity, Timbre.Lead));
        }

        var rate = BasicPitchInferenceService.RequiredSampleRate;
        var samples = new float[checked((int)Math.Round(6.85 * rate))];
        foreach (var note in notes)
            AddTonalNote(samples, rate, note);

        for (var i = 0; i < chords.Length; i++)
        {
            var chord = chords[i];
            AddTonalNote(samples, rate, new FixtureNote(
                "clutter",
                AudioArrangementReferenceRole.Harmony,
                chord.Melody + 12,
                chord.Start,
                chord.Start + 0.44,
                0.15 + (i % 3) * 0.01,
                Timbre.Lead));
            AddTransient(samples, rate, chord.Start - 0.01, 0.075);
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
        return new ProgressionFixture(samples, reference, chords.Select(chord => chord.Section).ToArray());
    }

    private static ProgressionChord Chord(
        string section,
        double start,
        int bass,
        int[] harmony,
        int melody,
        double[] harmonyVelocity,
        double melodyVelocity)
        => new(section, start, bass, harmony, melody, harmonyVelocity, melodyVelocity);

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
            var attackSeconds = note.Timbre == Timbre.Pad ? 0.045 : 0.006;
            var attack = 1.0 - Math.Exp(-local / attackSeconds);
            var releaseStart = note.Timbre == Timbre.Pad ? 0.72 : 0.84;
            var release = normalized > releaseStart
                ? Math.Clamp((1.0 - normalized) / (1.0 - releaseStart), 0.0, 1.0)
                : 1.0;
            var decay = note.Timbre switch
            {
                Timbre.Bass => 0.40 + 0.60 * Math.Exp(-local / 0.30),
                Timbre.Lead => 0.50 + 0.50 * Math.Exp(-local / 0.62),
                _ => 0.74 + 0.26 * Math.Exp(-local / 0.90)
            };
            var envelope = attack * release * decay * note.Velocity;
            var value = note.Timbre switch
            {
                Timbre.Bass =>
                    Math.Sin(2.0 * Math.PI * fundamental * local) * 1.00 +
                    Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.13) * 0.20 +
                    Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.29) * 0.07,
                Timbre.Pad =>
                    Math.Sin(2.0 * Math.PI * fundamental * local) * 0.80 +
                    Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.37) * 0.28 +
                    Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.51) * 0.12,
                _ =>
                    Math.Sin(2.0 * Math.PI * fundamental * local) * 1.00 +
                    Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.17) * 0.34 +
                    Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.31) * 0.17
            };
            samples[i] += (float)(value * envelope * 0.18);
        }
    }

    private static void AddTransient(float[] samples, int rate, double seconds, double amplitude)
    {
        var start = Math.Max(0, (int)Math.Round(seconds * rate));
        var length = Math.Min(samples.Length - start, Math.Max(1, (int)Math.Round(0.016 * rate)));
        for (var i = 0; i < length; i++)
        {
            var t = i / (double)rate;
            var envelope = Math.Exp(-t / 0.0045);
            var deterministicNoise = Math.Sin(i * 12.9898 + 78.233) * Math.Sin(i * 4.1414 + 19.19);
            samples[start + i] += (float)(deterministicNoise * envelope * amplitude);
        }
    }

    private static void Require(bool condition, string message)
    {
        if (condition)
            return;
        Environment.ExitCode = 1;
        throw new InvalidOperationException(message);
    }

    private sealed record ProgressionFixture(
        float[] Samples,
        IReadOnlyList<AudioArrangementReferenceNote> Reference,
        IReadOnlyList<string> SectionNames);

    private sealed record ProgressionChord(
        string Section,
        double Start,
        int Bass,
        int[] Harmony,
        int Melody,
        double[] HarmonyVelocity,
        double MelodyVelocity);

    private sealed record FixtureNote(
        string Section,
        AudioArrangementReferenceRole Role,
        int MidiNote,
        double StartSeconds,
        double EndSeconds,
        double Velocity,
        Timbre Timbre);

    private enum Timbre
    {
        Bass,
        Pad,
        Lead
    }
}