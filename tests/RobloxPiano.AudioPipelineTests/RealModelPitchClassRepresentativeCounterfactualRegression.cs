using System.Reflection;
using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class RealModelPitchClassRepresentativeCounterfactualRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            return;

        var fixture = LoadFixture();
        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));

        // Infer exactly once. Every policy is scored against the same pinned Basic Pitch note evidence.
        var transcription = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "phase-72 pitch-class representative A/B",
            new AudioToPianoTranscriptionOptions(
                Decoder: DecoderOptions,
                Arrangement: ProductionOptions));

        var arranger = new RobloxPianoArranger();
        var evaluator = new AudioArrangementQualityEvidenceEvaluator();
        var production = arranger.Arrange(
            "phase-72 production",
            transcription.NoteEvidence,
            ProductionOptions);
        var productionQuality = evaluator.Evaluate(
            fixture.Reference,
            transcription.NoteEvidence,
            production.Track,
            options: EvaluationOptions);

        Require(productionQuality.Sections.TryGetValue(TargetSection, out var productionTarget) && productionTarget is not null,
            $"Missing {TargetSection} production evidence.");
        Require(productionTarget.RecognizedHarmonyNotes >= 4,
            $"{TargetSection} recognized too little harmony evidence: {productionTarget.RecognizedHarmonyNotes}.");

        var candidates = new[]
        {
            EvaluatePolicy(RepresentativePolicy.StrongestActivation, production.Track, productionQuality, transcription.NoteEvidence, fixture.Reference, evaluator),
            EvaluatePolicy(RepresentativePolicy.RangeCenteredCredible, production.Track, productionQuality, transcription.NoteEvidence, fixture.Reference, evaluator)
        };

        foreach (var candidate in candidates)
        {
            Console.WriteLine(
                $"REAL_MODEL_REPRESENTATIVE_AB policy={candidate.Policy} rewrites={candidate.Rewrites} collisions={candidate.Collisions} " +
                $"target={candidate.TargetRetained}/{candidate.TargetRecognized} targetDelta={candidate.TargetDelta:+0;-0;0} " +
                $"harmony={candidate.Quality.RetainedHarmonyNotes}/{candidate.Quality.RecognizedHarmonyNotes} harmonyDelta={candidate.HarmonyDelta:+0;-0;0} " +
                $"melody={candidate.Quality.RetainedMelodyNotes}/{candidate.Quality.RecognizedMelodyNotes} " +
                $"sectionWins={candidate.SectionWins} sectionLosses={candidate.SectionLosses} " +
                $"clutter={candidate.Quality.ClutterSuppression:F3} clutterDelta={candidate.ClutterDelta:+0.000;-0.000;0.000} " +
                $"events={candidate.Quality.ArrangedNotes} promotable={candidate.Promotable}");
        }

        Require(candidates.Any(candidate => candidate.Rewrites > 0),
            "Representative A/B did not exercise any octave/pitch-class counterfactual.");

        var winner = candidates
            .Where(candidate => candidate.Promotable)
            .OrderByDescending(candidate => candidate.TargetRetained)
            .ThenByDescending(candidate => candidate.Quality.RetainedHarmonyNotes)
            .ThenByDescending(candidate => candidate.Quality.ClutterSuppression)
            .FirstOrDefault();
        var decision = winner is null ? "KEEP_PRODUCTION" : $"PROMOTION_CANDIDATE:{winner.Policy}";

        Console.WriteLine(
            $"REAL_MODEL_REPRESENTATIVE_DECISION decision={decision} " +
            $"productionTarget={productionTarget.RetainedHarmonyNotes}/{productionTarget.RecognizedHarmonyNotes} " +
            $"productionHarmony={productionQuality.RetainedHarmonyNotes}/{productionQuality.RecognizedHarmonyNotes} " +
            $"productionMelody={productionQuality.RetainedMelodyNotes}/{productionQuality.RecognizedMelodyNotes} " +
            $"productionClutter={productionQuality.ClutterSuppression:F3} events={productionQuality.ArrangedNotes}");

        Require(productionQuality.MelodyRetention >= 0.90,
            $"Production melody retention regressed before representative A/B: {productionQuality.MelodyRetention:F3}.");
        Require(!productionQuality.ArrangementAddedFalsePositives,
            "Production arrangement added unmatched playback events before representative A/B.");
    }

    private static CandidateResult EvaluatePolicy(
        RepresentativePolicy policy,
        PerformanceTrack productionTrack,
        AudioArrangementQualityEvidence productionQuality,
        IReadOnlyList<BasicPitchTranscribedNote> decoded,
        IReadOnlyList<AudioArrangementReferenceNote> reference,
        AudioArrangementQualityEvidenceEvaluator evaluator)
    {
        var counterfactual = BuildCounterfactualTrack(productionTrack, decoded, policy, out var rewrites, out var collisions);
        var quality = evaluator.Evaluate(
            reference,
            decoded,
            counterfactual,
            options: EvaluationOptions);
        Require(quality.Sections.TryGetValue(TargetSection, out var target) && target is not null,
            $"Missing {TargetSection} evidence for {policy}.");
        var productionTarget = productionQuality.Sections[TargetSection];
        var sectionWins = 0;
        var sectionLosses = 0;
        foreach (var (section, baseline) in productionQuality.Sections)
        {
            var current = quality.Sections[section];
            if (current.RetainedHarmonyNotes > baseline.RetainedHarmonyNotes)
                sectionWins++;
            else if (current.RetainedHarmonyNotes < baseline.RetainedHarmonyNotes)
                sectionLosses++;
        }

        var targetDelta = target.RetainedHarmonyNotes - productionTarget.RetainedHarmonyNotes;
        var harmonyDelta = quality.RetainedHarmonyNotes - productionQuality.RetainedHarmonyNotes;
        var clutterDelta = quality.ClutterSuppression - productionQuality.ClutterSuppression;
        var promotable =
            rewrites > 0 &&
            collisions == 0 &&
            target.RecognizedHarmonyNotes >= 3 &&
            target.RetainedHarmonyNotes >= 3 &&
            targetDelta > 0 &&
            harmonyDelta >= 0 &&
            quality.RetainedMelodyNotes >= productionQuality.RetainedMelodyNotes &&
            sectionLosses == 0 &&
            !quality.ArrangementAddedFalsePositives &&
            quality.ArrangedNotes == productionQuality.ArrangedNotes &&
            clutterDelta >= -0.02;

        return new CandidateResult(
            policy,
            quality,
            rewrites,
            collisions,
            target.RecognizedHarmonyNotes,
            target.RetainedHarmonyNotes,
            targetDelta,
            harmonyDelta,
            sectionWins,
            sectionLosses,
            clutterDelta,
            promotable);
    }

    private static PerformanceTrack BuildCounterfactualTrack(
        PerformanceTrack production,
        IReadOnlyList<BasicPitchTranscribedNote> decoded,
        RepresentativePolicy policy,
        out int rewrites,
        out int collisions)
    {
        var profile = ProductionOptions.EffectiveKeyboardProfile;
        var clusterWindow = ProductionOptions.OnsetClusterWindow ?? TimeSpan.FromMilliseconds(18);
        var centerPitch = (profile.LowestMidiNote + profile.HighestMidiNote) / 2.0;
        rewrites = 0;
        var events = new List<PerformanceEvent>(production.Events.Count);

        foreach (var performanceEvent in production.Events)
        {
            var rewrittenKeys = new List<char>(performanceEvent.Keys.Count);
            foreach (var key in performanceEvent.Keys)
            {
                var index = profile.Keys.IndexOf(key);
                Require(index >= 0, $"Production key '{key}' was outside the Roblox evidence profile.");
                var productionPitch = checked(profile.LowestMidiNote + index);
                var cluster = decoded
                    .Where(note => Abs(note.Start - performanceEvent.Start) <= clusterWindow)
                    .Select(note => new MappedSource(note, MapPitch(note.MidiNote)))
                    .GroupBy(item => item.MappedPitch)
                    .Select(group => group
                        .OrderByDescending(item => item.Note.Amplitude)
                        .ThenByDescending(item => item.Note.Duration)
                        .First())
                    .ToArray();

                // Never rewrite the protected production melody. Phase 72 isolates accompaniment representative identity.
                var melody = SelectApproximateProductionMelody(cluster);
                if (melody is not null && melody.MappedPitch == productionPitch)
                {
                    rewrittenKeys.Add(key);
                    continue;
                }

                var samePitchClass = cluster
                    .Where(item => PitchClass(item.MappedPitch) == PitchClass(productionPitch))
                    .GroupBy(item => item.MappedPitch)
                    .Select(group => group.OrderByDescending(item => item.Note.Amplitude).First())
                    .ToArray();
                if (samePitchClass.Length < 2)
                {
                    rewrittenKeys.Add(key);
                    continue;
                }

                var strongest = samePitchClass.Max(item => item.Note.Amplitude);
                MappedSource desired = policy switch
                {
                    RepresentativePolicy.StrongestActivation => samePitchClass
                        .OrderByDescending(item => item.Note.Amplitude)
                        .ThenByDescending(item => item.Note.Duration)
                        .ThenBy(item => item.MappedPitch)
                        .First(),
                    RepresentativePolicy.RangeCenteredCredible => samePitchClass
                        .Where(item => item.Note.Amplitude >= strongest * ProductionOptions.HarmonyOctaveRepresentativeRelativeActivationFloor)
                        .OrderBy(item => Math.Abs(item.MappedPitch - centerPitch))
                        .ThenByDescending(item => item.Note.Amplitude)
                        .ThenBy(item => item.MappedPitch)
                        .First(),
                    _ => throw new ArgumentOutOfRangeException(nameof(policy))
                };

                if (desired.MappedPitch == productionPitch)
                {
                    rewrittenKeys.Add(key);
                    continue;
                }

                var desiredIndex = desired.MappedPitch - profile.LowestMidiNote;
                Require(desiredIndex >= 0 && desiredIndex < profile.Keys.Length,
                    $"Counterfactual pitch {desired.MappedPitch} was outside the Roblox evidence profile.");
                rewrittenKeys.Add(profile.Keys[desiredIndex]);
                rewrites++;
            }
            events.Add(performanceEvent with { Keys = rewrittenKeys.ToArray() });
        }

        collisions = events
            .SelectMany(item => item.Keys.Select(key => (item.Start, key)))
            .GroupBy(item => item)
            .Count(group => group.Count() > 1);
        return production with { Events = events.ToArray() };
    }

    private static MappedSource? SelectApproximateProductionMelody(IReadOnlyList<MappedSource> cluster)
    {
        if (cluster.Count == 0)
            return null;
        var maximumActivation = cluster.Max(item => item.Note.Amplitude);
        var threshold = Math.Max(
            ProductionOptions.MelodyActivationFloor,
            maximumActivation * ProductionOptions.MelodyRelativeActivationFloor);
        var credible = cluster.Where(item => item.Note.Amplitude >= threshold).ToArray();
        if (credible.Length == 0)
            credible = [cluster.OrderByDescending(item => item.Note.Amplitude).First()];
        return credible
            .OrderByDescending(item => item.MappedPitch)
            .ThenByDescending(item => item.Note.Amplitude)
            .First();
    }

    private static int MapPitch(int midiNote)
    {
        var profile = ProductionOptions.EffectiveKeyboardProfile;
        var pitch = midiNote;
        if (ProductionOptions.FoldOctavesToRange)
        {
            while (pitch < profile.LowestMidiNote)
                pitch += 12;
            while (pitch > profile.HighestMidiNote)
                pitch -= 12;
        }
        return pitch;
    }

    private static Fixture LoadFixture()
    {
        var method = typeof(RealModelAdaptiveDensityContinuityCounterfactualRegression)
            .GetMethod("BuildFixture", BindingFlags.NonPublic | BindingFlags.Static)
            ?? throw new InvalidOperationException("Repeated-progression fixture builder was not found.");
        var source = method.Invoke(null, null)
            ?? throw new InvalidOperationException("Repeated-progression fixture builder returned null.");
        var type = source.GetType();
        var samples = type.GetProperty("Samples")?.GetValue(source) as float[]
            ?? throw new InvalidOperationException("Repeated-progression Samples were unavailable.");
        var reference = type.GetProperty("Reference")?.GetValue(source) as IReadOnlyList<AudioArrangementReferenceNote>
            ?? throw new InvalidOperationException("Repeated-progression Reference was unavailable.");
        return new Fixture(samples, reference);
    }

    private static int PitchClass(int midiNote) => ((midiNote % 12) + 12) % 12;
    private static TimeSpan Abs(TimeSpan value) => value < TimeSpan.Zero ? -value : value;

    private static void Require(bool condition, string message)
    {
        if (condition)
            return;
        Console.Error.WriteLine($"FAIL: {message}");
        Environment.ExitCode = 1;
    }

    private const string TargetSection = "chorus-c2";

    private static readonly AudioTranscriptionEvaluationOptions EvaluationOptions = new(
        OnsetTolerance: TimeSpan.FromMilliseconds(160),
        RequireOffsetMatch: false);

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

    private enum RepresentativePolicy
    {
        StrongestActivation,
        RangeCenteredCredible
    }

    private sealed record MappedSource(BasicPitchTranscribedNote Note, int MappedPitch);
    private sealed record Fixture(float[] Samples, IReadOnlyList<AudioArrangementReferenceNote> Reference);
    private sealed record CandidateResult(
        RepresentativePolicy Policy,
        AudioArrangementQualityEvidence Quality,
        int Rewrites,
        int Collisions,
        int TargetRecognized,
        int TargetRetained,
        int TargetDelta,
        int HarmonyDelta,
        int SectionWins,
        int SectionLosses,
        double ClutterDelta,
        bool Promotable);
}
