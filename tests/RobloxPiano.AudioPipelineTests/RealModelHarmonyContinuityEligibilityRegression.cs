using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class RealModelHarmonyContinuityEligibilityRegression
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

        var transcription = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "real-model continuity eligibility diagnostics",
            new AudioToPianoTranscriptionOptions(
                Decoder: DecoderOptions,
                Arrangement: ProductionOptions));

        var arranged = new RobloxPianoArranger().Arrange(
            "real-model continuity eligibility production",
            transcription.NoteEvidence,
            ProductionOptions);
        var quality = new AudioArrangementQualityEvidenceEvaluator().Evaluate(
            fixture.Reference,
            transcription.NoteEvidence,
            arranged.Track,
            options: new AudioTranscriptionEvaluationOptions(
                OnsetTolerance: TimeSpan.FromMilliseconds(160),
                RequireOffsetMatch: false));

        var diagnostics = AnalyzeEligibility(transcription.NoteEvidence, ProductionOptions);
        Console.WriteLine(
            $"REAL_MODEL_CONTINUITY_ELIGIBILITY dense={diagnostics.DenseClusters} context={diagnostics.ContextClusters} " +
            $"priorCandidates={diagnostics.PriorPitchClassCandidates} adaptiveRejected={diagnostics.AdaptiveRejected} " +
            $"coverageRejected={diagnostics.CoverageRejected} continuityFloorRejected={diagnostics.ContinuityFloorRejected} " +
            $"alreadyBaseline={diagnostics.AlreadyBaseline} opportunities={diagnostics.CounterfactualOpportunities} " +
            $"productionSelections={arranged.Diagnostics.HarmonyContinuitySelections} " +
            $"melody={quality.RetainedMelodyNotes}/{quality.RecognizedMelodyNotes} " +
            $"harmony={quality.RetainedHarmonyNotes}/{quality.RecognizedHarmonyNotes} " +
            $"harmonyRetention={quality.HarmonyRetention:F3} clutter={quality.ClutterSuppression:F3}");

        var dominantBlocker = new[]
        {
            (Name: "adaptive-density", Count: diagnostics.AdaptiveRejected),
            (Name: "coverage", Count: diagnostics.CoverageRejected),
            (Name: "continuity-floor", Count: diagnostics.ContinuityFloorRejected),
            (Name: "already-baseline", Count: diagnostics.AlreadyBaseline)
        }
        .OrderByDescending(item => item.Count)
        .ThenBy(item => item.Name, StringComparer.Ordinal)
        .First();

        var decision = diagnostics.CounterfactualOpportunities > 0
            ? "COUNTERFACTUAL_AVAILABLE"
            : "NO_ACTIONABLE_CONTINUITY_CANDIDATE";
        Console.WriteLine(
            $"REAL_MODEL_CONTINUITY_ELIGIBILITY_DECISION decision={decision} " +
            $"dominantBlocker={dominantBlocker.Name} blockerCount={dominantBlocker.Count}");

        Require(quality.RecognizedMelodyNotes >= 8,
            $"Eligibility fixture recognized too little melody evidence: {quality.RecognizedMelodyNotes}.");
        Require(quality.RecognizedHarmonyNotes >= 20,
            $"Eligibility fixture recognized too little harmony evidence: {quality.RecognizedHarmonyNotes}.");
        Require(quality.MelodyRetention >= 0.90,
            $"Production retained less than 90% recognized melody: {quality.MelodyRetention:F3}.");
        Require(quality.HarmonyRetention >= 0.69,
            $"Production retained less than Phase 65/66 harmony floor: {quality.HarmonyRetention:F3}.");
        Require(!quality.ArrangementAddedFalsePositives,
            "Production arrangement unexpectedly added unmatched playback events.");
        Require(diagnostics.DenseClusters > 0 && diagnostics.ContextClusters > 0,
            "Eligibility corpus failed to exercise dense clusters with recent harmony context.");
        Require(diagnostics.PriorPitchClassCandidates > 0,
            "Eligibility corpus exposed no prior-pitch-class candidates to diagnose.");
    }

    private static EligibilityDiagnostics AnalyzeEligibility(
        IReadOnlyList<BasicPitchTranscribedNote> notes,
        RobloxPianoArrangementOptions options)
    {
        var profile = options.EffectiveKeyboardProfile;
        var clusterWindow = options.OnsetClusterWindow ?? TimeSpan.FromMilliseconds(18);
        var harmonyWindow = options.HarmonyContinuityWindow ?? TimeSpan.FromMilliseconds(1800);
        var candidates = notes
            .Where(note => note.Duration >= (options.MinimumDuration ?? TimeSpan.FromMilliseconds(35)))
            .Select(note => ToCandidate(note, profile, options.FoldOctavesToRange))
            .Where(candidate => candidate is not null)
            .Select(candidate => candidate!)
            .OrderBy(candidate => candidate.Start)
            .ThenBy(candidate => candidate.Pitch)
            .ToList();

        var result = new EligibilityDiagnostics();
        IReadOnlyList<ShadowCandidate> previousHarmony = [];
        TimeSpan? previousHarmonyEnd = null;
        var index = 0;
        while (index < candidates.Count)
        {
            var anchor = candidates[index].Start;
            var end = index + 1;
            while (end < candidates.Count && candidates[end].Start - anchor <= clusterWindow)
                end++;

            var unique = candidates.GetRange(index, end - index)
                .GroupBy(candidate => candidate.Pitch)
                .Select(group => group
                    .OrderByDescending(candidate => candidate.Amplitude)
                    .ThenByDescending(candidate => candidate.Duration)
                    .First())
                .ToList();

            var melody = SelectShadowMelody(unique, options);
            var context = previousHarmonyEnd is { } priorEnd && anchor - priorEnd <= harmonyWindow
                ? previousHarmony
                : [];

            if (unique.Count > options.MaxSimultaneousNotes)
            {
                result.DenseClusters++;
                var accompanimentBeforeAdaptive = unique
                    .Where(candidate => !ReferenceEquals(candidate, melody))
                    .OrderByDescending(candidate => candidate.Amplitude)
                    .ThenByDescending(candidate => candidate.Duration)
                    .ThenByDescending(candidate => candidate.Pitch)
                    .ToList();
                var previousPitchClasses = context.Select(candidate => PitchClass(candidate.Pitch)).ToHashSet();
                if (previousPitchClasses.Count > 0)
                    result.ContextClusters++;

                var priorBeforeAdaptive = accompanimentBeforeAdaptive
                    .Where(candidate => previousPitchClasses.Contains(PitchClass(candidate.Pitch)))
                    .ToArray();
                result.PriorPitchClassCandidates += priorBeforeAdaptive.Length;

                var accompaniment = accompanimentBeforeAdaptive;
                if (options.AdaptiveDensity && accompaniment.Count > 0)
                {
                    var strongest = accompaniment.Max(candidate => candidate.Amplitude);
                    var threshold = Math.Max(
                        options.AccompanimentActivationFloor,
                        strongest * options.AccompanimentRelativeActivationFloor);
                    accompaniment = accompaniment.Where(candidate => candidate.Amplitude >= threshold).ToList();
                    var surviving = accompaniment.ToHashSet();
                    result.AdaptiveRejected += priorBeforeAdaptive.Count(candidate => !surviving.Contains(candidate));
                }

                var slots = options.MaxSimultaneousNotes - 1;
                var confidenceOrder = accompaniment
                    .OrderByDescending(candidate => candidate.Amplitude)
                    .ThenByDescending(candidate => candidate.Duration)
                    .ThenByDescending(candidate => candidate.Pitch)
                    .ToArray();
                var baseline = confidenceOrder.Take(slots).ToArray();
                var baselineSet = baseline.ToHashSet();

                if (slots > 0 && accompaniment.Count > slots && baseline.Length > 0)
                {
                    var coverageFloor = baseline[^1].Amplitude * options.HarmonyOctaveRepresentativeRelativeActivationFloor;
                    var rawRepresentatives = accompaniment
                        .GroupBy(candidate => PitchClass(candidate.Pitch))
                        .Select(group =>
                        {
                            var strongest = group.Max(candidate => candidate.Amplitude);
                            return group
                                .Where(candidate => candidate.Amplitude >= strongest * options.HarmonyOctaveRepresentativeRelativeActivationFloor)
                                .OrderBy(candidate => candidate.Pitch)
                                .ThenByDescending(candidate => candidate.Amplitude)
                                .ThenByDescending(candidate => candidate.Duration)
                                .First();
                        })
                        .ToArray();

                    var priorRawRepresentatives = rawRepresentatives
                        .Where(candidate => previousPitchClasses.Contains(PitchClass(candidate.Pitch)))
                        .ToArray();
                    var representatives = rawRepresentatives
                        .Where(candidate => candidate.Amplitude >= coverageFloor)
                        .ToArray();
                    var representativeSet = representatives.ToHashSet();
                    result.CoverageRejected += priorRawRepresentatives.Count(candidate => !representativeSet.Contains(candidate));

                    var strongestRepresentative = representatives.Length == 0
                        ? 0f
                        : representatives.Max(candidate => candidate.Amplitude);
                    var continuityFloor = strongestRepresentative * options.HarmonyContinuityRelativeActivationFloor;
                    foreach (var candidate in representatives.Where(candidate => previousPitchClasses.Contains(PitchClass(candidate.Pitch))))
                    {
                        if (candidate.Amplitude < continuityFloor)
                        {
                            result.ContinuityFloorRejected++;
                            continue;
                        }

                        if (baselineSet.Contains(candidate))
                            result.AlreadyBaseline++;
                        else
                            result.CounterfactualOpportunities++;
                    }
                }

                previousHarmony = ShadowSelectVoicing(accompaniment, slots, options, context);
                previousHarmonyEnd = previousHarmony.Count > 0
                    ? previousHarmony.Max(candidate => candidate.End)
                    : null;
            }
            else
            {
                previousHarmony = unique.Where(candidate => !ReferenceEquals(candidate, melody)).ToArray();
                previousHarmonyEnd = previousHarmony.Count > 0
                    ? previousHarmony.Max(candidate => candidate.End)
                    : null;
            }

            index = end;
        }

        return result;
    }

    private static ShadowCandidate? ToCandidate(
        BasicPitchTranscribedNote note,
        MidiKeyboardProfile profile,
        bool fold)
    {
        var pitch = note.MidiNote;
        if (pitch < profile.LowestMidiNote || pitch > profile.HighestMidiNote)
        {
            if (!fold)
                return null;
            while (pitch < profile.LowestMidiNote)
                pitch += 12;
            while (pitch > profile.HighestMidiNote)
                pitch -= 12;
            if (pitch < profile.LowestMidiNote || pitch > profile.HighestMidiNote)
                return null;
        }
        return new ShadowCandidate(note.Start, note.End, pitch, note.Amplitude);
    }

    private static ShadowCandidate SelectShadowMelody(
        IReadOnlyList<ShadowCandidate> candidates,
        RobloxPianoArrangementOptions options)
    {
        var maximum = candidates.Max(candidate => candidate.Amplitude);
        var threshold = Math.Max(options.MelodyActivationFloor, maximum * options.MelodyRelativeActivationFloor);
        var credible = candidates.Where(candidate => candidate.Amplitude >= threshold).ToArray();
        if (credible.Length == 0)
            credible = [candidates.OrderByDescending(candidate => candidate.Amplitude).First()];
        return credible
            .OrderByDescending(candidate => candidate.Pitch)
            .ThenByDescending(candidate => candidate.Amplitude)
            .First();
    }

    private static IReadOnlyList<ShadowCandidate> ShadowSelectVoicing(
        IReadOnlyList<ShadowCandidate> accompaniment,
        int slots,
        RobloxPianoArrangementOptions options,
        IReadOnlyList<ShadowCandidate> previousHarmony)
    {
        if (slots <= 0 || accompaniment.Count == 0)
            return [];
        var confidenceOrder = accompaniment
            .OrderByDescending(candidate => candidate.Amplitude)
            .ThenByDescending(candidate => candidate.Duration)
            .ThenByDescending(candidate => candidate.Pitch)
            .ToArray();
        var baseline = confidenceOrder.Take(slots).ToArray();
        if (!options.AdaptiveDensity || accompaniment.Count <= slots)
            return baseline;

        var selected = new List<ShadowCandidate>(slots);
        var usedPitchClasses = new HashSet<int>();
        var strongest = confidenceOrder[0].Amplitude;
        var bass = accompaniment.OrderBy(candidate => candidate.Pitch).ThenByDescending(candidate => candidate.Amplitude).First();
        if (bass.Amplitude >= strongest * options.HarmonyBassAnchorRelativeActivationFloor)
        {
            selected.Add(bass);
            usedPitchClasses.Add(PitchClass(bass.Pitch));
        }

        var coverageFloor = baseline[^1].Amplitude * options.HarmonyOctaveRepresentativeRelativeActivationFloor;
        var representatives = accompaniment
            .GroupBy(candidate => PitchClass(candidate.Pitch))
            .Select(group =>
            {
                var strongestInClass = group.Max(candidate => candidate.Amplitude);
                return group
                    .Where(candidate => candidate.Amplitude >= strongestInClass * options.HarmonyOctaveRepresentativeRelativeActivationFloor)
                    .OrderBy(candidate => candidate.Pitch)
                    .ThenByDescending(candidate => candidate.Amplitude)
                    .ThenByDescending(candidate => candidate.Duration)
                    .First();
            })
            .Where(candidate => candidate.Amplitude >= coverageFloor)
            .ToArray();
        var previousPitchClasses = previousHarmony.Select(candidate => PitchClass(candidate.Pitch)).ToHashSet();
        var strongestRepresentative = representatives.Length == 0 ? 0f : representatives.Max(candidate => candidate.Amplitude);
        var continuityFloor = strongestRepresentative * options.HarmonyContinuityRelativeActivationFloor;
        representatives = representatives
            .OrderByDescending(candidate => previousPitchClasses.Contains(PitchClass(candidate.Pitch)) && candidate.Amplitude >= continuityFloor)
            .ThenByDescending(candidate => candidate.Amplitude)
            .ThenByDescending(candidate => candidate.Duration)
            .ThenBy(candidate => candidate.Pitch)
            .ToArray();

        foreach (var candidate in representatives)
        {
            if (selected.Count >= slots)
                break;
            var pitchClass = PitchClass(candidate.Pitch);
            if (!usedPitchClasses.Add(pitchClass) || selected.Contains(candidate))
                continue;
            selected.Add(candidate);
        }
        foreach (var candidate in confidenceOrder)
        {
            if (selected.Count >= slots)
                break;
            if (!selected.Contains(candidate))
                selected.Add(candidate);
        }
        return selected;
    }

    private static int PitchClass(int midiNote) => ((midiNote % 12) + 12) % 12;

    private static readonly BasicPitchNoteDecoderOptions DecoderOptions = new(
        OnsetThreshold: 0.20f,
        FrameThreshold: 0.15f,
        MinimumNoteLengthFrames: 3,
        EnergyToleranceFrames: 8,
        UseMelodiaRecovery: true,
        IncludePitchBends: true);

    private static readonly RobloxPianoArrangementOptions ProductionOptions = new(
        MaxSimultaneousNotes: 4,
        MinimumDuration: TimeSpan.FromMilliseconds(20),
        LowActivationThreshold: 0.15f);

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
            AddTonalNote(samples, rate, new FixtureNote("clutter", AudioArrangementReferenceRole.Harmony,
                chord.Melody + 12, chord.Start, chord.Start + 0.44, 0.15 + (i % 3) * 0.01, Timbre.Lead));
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
        return new ProgressionFixture(samples, reference);
    }

    private static ProgressionChord Chord(string section, double start, int bass, int[] harmony, int melody, double[] harmonyVelocity, double melodyVelocity)
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
            var release = normalized > releaseStart ? Math.Clamp((1.0 - normalized) / (1.0 - releaseStart), 0.0, 1.0) : 1.0;
            var decay = note.Timbre switch
            {
                Timbre.Bass => 0.40 + 0.60 * Math.Exp(-local / 0.30),
                Timbre.Lead => 0.50 + 0.50 * Math.Exp(-local / 0.62),
                _ => 0.74 + 0.26 * Math.Exp(-local / 0.90)
            };
            var envelope = attack * release * decay * note.Velocity;
            var value = note.Timbre switch
            {
                Timbre.Bass => Math.Sin(2.0 * Math.PI * fundamental * local) + Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.13) * 0.20 + Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.29) * 0.07,
                Timbre.Pad => Math.Sin(2.0 * Math.PI * fundamental * local) * 0.80 + Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.37) * 0.28 + Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.51) * 0.12,
                _ => Math.Sin(2.0 * Math.PI * fundamental * local) + Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.17) * 0.34 + Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.31) * 0.17
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

    private sealed class EligibilityDiagnostics
    {
        public int DenseClusters { get; set; }
        public int ContextClusters { get; set; }
        public int PriorPitchClassCandidates { get; set; }
        public int AdaptiveRejected { get; set; }
        public int CoverageRejected { get; set; }
        public int ContinuityFloorRejected { get; set; }
        public int AlreadyBaseline { get; set; }
        public int CounterfactualOpportunities { get; set; }
    }

    private sealed record ShadowCandidate(TimeSpan Start, TimeSpan End, int Pitch, float Amplitude)
    {
        public TimeSpan Duration => End - Start;
    }

    private sealed record ProgressionFixture(float[] Samples, IReadOnlyList<AudioArrangementReferenceNote> Reference);
    private sealed record ProgressionChord(string Section, double Start, int Bass, int[] Harmony, int Melody, double[] HarmonyVelocity, double MelodyVelocity);
    private sealed record FixtureNote(string Section, AudioArrangementReferenceRole Role, int MidiNote, double StartSeconds, double EndSeconds, double Velocity, Timbre Timbre);
    private enum Timbre { Bass, Pad, Lead }
}
