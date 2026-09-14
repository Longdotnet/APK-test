using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class RealModelHarmonyContinuityCalibrationRegression
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

        // Infer exactly once. Every candidate below sees the same pinned Basic Pitch note evidence,
        // so the A/B result isolates deterministic arranger policy from AMT variation.
        var decoded = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "real-model harmony continuity calibration",
            new AudioToPianoTranscriptionOptions(
                Decoder: DecoderOptions,
                Arrangement: ControlOptions));

        var controlArrangement = new RobloxPianoArranger().Arrange(
            "real-model continuity calibration control",
            decoded.NoteEvidence,
            ControlOptions);
        var control = Evaluate(fixture.Reference, decoded.NoteEvidence, controlArrangement.Track);

        var candidates = CandidateFloors
            .Select(floor => EvaluateCandidate(floor, fixture, decoded.NoteEvidence, control))
            .ToArray();

        foreach (var candidate in candidates)
        {
            Console.WriteLine(
                $"REAL_MODEL_CONTINUITY_CALIBRATION floor={candidate.Floor:F2} admissible={candidate.Admissible} " +
                $"selections={candidate.Selections} melody={candidate.Evidence.RetainedMelodyNotes}/{candidate.Evidence.RecognizedMelodyNotes} " +
                $"harmony={candidate.Evidence.RetainedHarmonyNotes}/{candidate.Evidence.RecognizedHarmonyNotes} " +
                $"harmonyRetention={candidate.Evidence.HarmonyRetention:F3} harmonyDelta={candidate.HarmonyDelta:+0.000;-0.000;0.000} " +
                $"clutter={candidate.Evidence.ClutterSuppression:F3} clutterDelta={candidate.ClutterDelta:+0.000;-0.000;0.000} " +
                $"sectionWins={candidate.SectionWins} sectionLosses={candidate.SectionLosses}");
        }

        var winner = candidates
            .Where(candidate => candidate.Admissible)
            .OrderByDescending(candidate => candidate.Evidence.HarmonyRetention)
            .ThenByDescending(candidate => candidate.SectionWins)
            .ThenByDescending(candidate => candidate.Evidence.ClutterSuppression)
            // Prefer the stricter threshold when quality is otherwise tied.
            .ThenByDescending(candidate => candidate.Floor)
            .FirstOrDefault();

        var decision = winner is null ? "KEEP_PRODUCTION" : "PROMOTION_CANDIDATE";
        Console.WriteLine(
            $"REAL_MODEL_CONTINUITY_CALIBRATION_DECISION decision={decision} " +
            $"controlHarmony={control.RetainedHarmonyNotes}/{control.RecognizedHarmonyNotes} " +
            $"controlRetention={control.HarmonyRetention:F3} controlClutter={control.ClutterSuppression:F3} " +
            $"winnerFloor={(winner?.Floor.ToString("F2") ?? "none")} winnerSelections={winner?.Selections ?? 0} " +
            $"winnerDelta={(winner?.HarmonyDelta ?? 0):+0.000;-0.000;0.000}");

        Require(control.RecognizedMelodyNotes >= 8,
            $"Calibration fixture recognized too little melody evidence: {control.RecognizedMelodyNotes}.");
        Require(control.RecognizedHarmonyNotes >= 20,
            $"Calibration fixture recognized too little harmony evidence: {control.RecognizedHarmonyNotes}.");
        Require(control.MelodyRetention >= 0.90,
            $"Control retained less than 90% recognized melody: {control.MelodyRetention:F3}.");
        Require(control.HarmonyRetention >= 0.69,
            $"Control retained less than Phase 65's 69% harmony floor: {control.HarmonyRetention:F3}.");
        Require(!control.ArrangementAddedFalsePositives,
            "Control arrangement unexpectedly added unmatched playback events.");

        // This phase is a calibration gate, not an automatic threshold change. A candidate is promotable only when it
        // actually exercises continuity, improves global or section harmony, loses no section/melody evidence, and does
        // not buy retention by adding false positives or materially reducing clutter suppression.
        foreach (var candidate in candidates)
        {
            Require(candidate.Evidence.MelodyRetention + 1e-9 >= control.MelodyRetention,
                $"Continuity floor {candidate.Floor:F2} reduced melody retention.");
            Require(!candidate.Evidence.ArrangementAddedFalsePositives,
                $"Continuity floor {candidate.Floor:F2} added unmatched playback events.");
            Require(candidate.Evidence.EventRetentionRatio <= 1.000001,
                $"Continuity floor {candidate.Floor:F2} expanded event count to {candidate.Evidence.EventRetentionRatio:F3}.");
            Require(candidate.SectionLosses == 0,
                $"Continuity floor {candidate.Floor:F2} reduced harmony in {candidate.SectionLosses} section(s).");
            Require(candidate.ClutterDelta >= -0.02,
                $"Continuity floor {candidate.Floor:F2} reduced clutter suppression by {candidate.ClutterDelta:F3}.");
        }
    }

    private static CandidateResult EvaluateCandidate(
        float floor,
        ProgressionFixture fixture,
        IReadOnlyList<BasicPitchTranscribedNote> decoded,
        AudioArrangementQualityEvidence control)
    {
        var options = BaseOptions with
        {
            HarmonyContinuityRelativeActivationFloor = floor
        };
        var arrangement = new RobloxPianoArranger().Arrange(
            $"real-model continuity calibration {floor:F2}",
            decoded,
            options);
        var evidence = Evaluate(fixture.Reference, decoded, arrangement.Track);
        var sectionWins = 0;
        var sectionLosses = 0;

        foreach (var sectionName in fixture.SectionNames)
        {
            if (!evidence.Sections.TryGetValue(sectionName, out var candidateSection) || candidateSection is null)
                continue;
            if (!control.Sections.TryGetValue(sectionName, out var controlSection) || controlSection is null)
                continue;

            if (candidateSection.HarmonyRetention > controlSection.HarmonyRetention + 1e-9)
                sectionWins++;
            else if (candidateSection.HarmonyRetention + 1e-9 < controlSection.HarmonyRetention)
                sectionLosses++;
        }

        var harmonyDelta = evidence.HarmonyRetention - control.HarmonyRetention;
        var clutterDelta = evidence.ClutterSuppression - control.ClutterSuppression;
        var selections = arrangement.Diagnostics.HarmonyContinuitySelections;
        var admissible = selections > 0 &&
            evidence.MelodyRetention + 1e-9 >= control.MelodyRetention &&
            !evidence.ArrangementAddedFalsePositives &&
            evidence.EventRetentionRatio <= 1.000001 &&
            sectionLosses == 0 &&
            clutterDelta >= -0.02 &&
            (harmonyDelta > 0.000001 || sectionWins > 0);

        return new CandidateResult(
            floor,
            evidence,
            selections,
            harmonyDelta,
            clutterDelta,
            sectionWins,
            sectionLosses,
            admissible);
    }

    private static readonly float[] CandidateFloors = [0.90f, 0.85f, 0.80f, 0.75f];

    private static readonly BasicPitchNoteDecoderOptions DecoderOptions = new(
        OnsetThreshold: 0.20f,
        FrameThreshold: 0.15f,
        MinimumNoteLengthFrames: 3,
        EnergyToleranceFrames: 8,
        UseMelodiaRecovery: true,
        IncludePitchBends: true);

    private static readonly RobloxPianoArrangementOptions BaseOptions = new(
        MaxSimultaneousNotes: 4,
        MinimumDuration: TimeSpan.FromMilliseconds(20),
        LowActivationThreshold: 0.15f);

    private static readonly RobloxPianoArrangementOptions ControlOptions = BaseOptions with
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

    private sealed record CandidateResult(
        float Floor,
        AudioArrangementQualityEvidence Evidence,
        int Selections,
        double HarmonyDelta,
        double ClutterDelta,
        int SectionWins,
        int SectionLosses,
        bool Admissible);

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
