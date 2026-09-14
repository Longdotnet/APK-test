using System.Reflection;
using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class RealModelHarmonyContinuityRetirementGateRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            return;

        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));

        var cases = new[]
        {
            LoadFixture(
                typeof(RealModelMixedInstrumentStressRegression),
                "BuildStressFixture",
                "mixed-song"),
            LoadFixture(
                typeof(RealModelAdaptiveDensityContinuityCounterfactualRegression),
                "BuildFixture",
                "repeated-progression")
        };

        var allEquivalent = true;
        foreach (var fixture in cases)
        {
            var transcription = service.TranscribeNormalized(
                new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
                $"phase-70 {fixture.Name} production",
                new AudioToPianoTranscriptionOptions(
                    Decoder: DecoderOptions,
                    Arrangement: ProductionOptions));

            // Infer once per corpus. Both A/B arranger passes consume the exact same pinned-model note evidence.
            var decoded = transcription.NoteEvidence;
            var productionArrangement = new RobloxPianoArranger().Arrange(
                $"phase-70 {fixture.Name} production",
                decoded,
                ProductionOptions);
            var disabledArrangement = new RobloxPianoArranger().Arrange(
                $"phase-70 {fixture.Name} continuity-disabled",
                decoded,
                ContinuityDisabledOptions);

            var production = Evaluate(fixture.Reference, decoded, productionArrangement.Track);
            var disabled = Evaluate(fixture.Reference, decoded, disabledArrangement.Track);
            var tracksEquivalent = TracksEquivalent(productionArrangement.Track, disabledArrangement.Track);
            var metricsEquivalent = EvidenceEquivalent(production, disabled);
            var caseEquivalent = tracksEquivalent && metricsEquivalent;
            allEquivalent &= caseEquivalent;

            Console.WriteLine(
                $"REAL_MODEL_CONTINUITY_RETIREMENT corpus={fixture.Name} equivalent={caseEquivalent} " +
                $"tracksEquivalent={tracksEquivalent} metricsEquivalent={metricsEquivalent} " +
                $"productionSelections={productionArrangement.Diagnostics.HarmonyContinuitySelections} " +
                $"disabledSelections={disabledArrangement.Diagnostics.HarmonyContinuitySelections} " +
                $"melody={production.RetainedMelodyNotes}/{production.RecognizedMelodyNotes} " +
                $"harmony={production.RetainedHarmonyNotes}/{production.RecognizedHarmonyNotes} " +
                $"harmonyRetention={production.HarmonyRetention:F3} disabledHarmony={disabled.HarmonyRetention:F3} " +
                $"clutter={production.ClutterSuppression:F3} disabledClutter={disabled.ClutterSuppression:F3} " +
                $"events={production.ArrangedNotes}/{disabled.ArrangedNotes}");

            Require(production.RecognizedMelodyNotes >= (fixture.Name == "mixed-song" ? 3 : 8),
                $"{fixture.Name} recognized too little melody evidence: {production.RecognizedMelodyNotes}.");
            Require(production.RecognizedHarmonyNotes >= (fixture.Name == "mixed-song" ? 5 : 20),
                $"{fixture.Name} recognized too little harmony evidence: {production.RecognizedHarmonyNotes}.");
            Require(production.MelodyRetention >= 0.85,
                $"{fixture.Name} production melody retention regressed: {production.MelodyRetention:F3}.");
            Require(production.HarmonyRetention >= 0.65,
                $"{fixture.Name} production harmony retention regressed: {production.HarmonyRetention:F3}.");
            Require(!production.ArrangementAddedFalsePositives && !disabled.ArrangementAddedFalsePositives,
                $"{fixture.Name} A/B added unmatched playback events.");
            Require(caseEquivalent,
                $"{fixture.Name} still depends on harmony continuity; retirement is not safe on this corpus.");
        }

        var decision = allEquivalent ? "RETIRE_SAFE" : "KEEP_CONTINUITY";
        Console.WriteLine($"REAL_MODEL_CONTINUITY_RETIREMENT_DECISION decision={decision} corpora={cases.Length}");
        Require(allEquivalent,
            "Harmony continuity changed at least one pinned-model canonical output; do not retire it.");
    }

    private static Fixture LoadFixture(Type owner, string methodName, string name)
    {
        var method = owner.GetMethod(methodName, BindingFlags.NonPublic | BindingFlags.Static)
            ?? throw new InvalidOperationException($"Fixture builder {owner.Name}.{methodName} was not found.");
        var source = method.Invoke(null, null)
            ?? throw new InvalidOperationException($"Fixture builder {owner.Name}.{methodName} returned null.");
        var type = source.GetType();
        var samples = type.GetProperty("Samples")?.GetValue(source) as float[]
            ?? throw new InvalidOperationException($"{name} fixture Samples were not available.");
        var reference = type.GetProperty("Reference")?.GetValue(source) as IReadOnlyList<AudioArrangementReferenceNote>
            ?? throw new InvalidOperationException($"{name} fixture Reference was not available.");
        return new Fixture(name, samples, reference);
    }

    private static AudioArrangementQualityEvidence Evaluate(
        IReadOnlyList<AudioArrangementReferenceNote> reference,
        IReadOnlyList<BasicPitchTranscribedNote> decoded,
        PerformanceTrack track)
        => new AudioArrangementQualityEvidenceEvaluator().Evaluate(
            reference,
            decoded,
            track,
            options: EvaluationOptions);

    private static bool TracksEquivalent(PerformanceTrack left, PerformanceTrack right)
    {
        if (left.Events.Count != right.Events.Count)
            return false;
        for (var i = 0; i < left.Events.Count; i++)
        {
            var a = left.Events[i];
            var b = right.Events[i];
            if (a.Start != b.Start || a.Duration != b.Duration || !a.Keys.SequenceEqual(b.Keys))
                return false;
        }
        return true;
    }

    private static bool EvidenceEquivalent(
        AudioArrangementQualityEvidence left,
        AudioArrangementQualityEvidence right)
    {
        if (left.RetainedMelodyNotes != right.RetainedMelodyNotes ||
            left.RecognizedMelodyNotes != right.RecognizedMelodyNotes ||
            left.RetainedHarmonyNotes != right.RetainedHarmonyNotes ||
            left.RecognizedHarmonyNotes != right.RecognizedHarmonyNotes ||
            left.ArrangedFalsePositives != right.ArrangedFalsePositives ||
            left.ArrangedNotes != right.ArrangedNotes ||
            Math.Abs(left.MelodyRetention - right.MelodyRetention) > 1e-9 ||
            Math.Abs(left.HarmonyRetention - right.HarmonyRetention) > 1e-9 ||
            Math.Abs(left.ClutterSuppression - right.ClutterSuppression) > 1e-9)
            return false;

        if (left.Sections.Count != right.Sections.Count)
            return false;
        foreach (var (name, section) in left.Sections)
        {
            if (!right.Sections.TryGetValue(name, out var other) ||
                section.RetainedMelodyNotes != other.RetainedMelodyNotes ||
                section.RecognizedMelodyNotes != other.RecognizedMelodyNotes ||
                section.RetainedHarmonyNotes != other.RetainedHarmonyNotes ||
                section.RecognizedHarmonyNotes != other.RecognizedHarmonyNotes)
                return false;
        }
        return true;
    }

    private static void Require(bool condition, string message)
    {
        if (condition)
            return;
        Console.Error.WriteLine($"FAIL: {message}");
        Environment.ExitCode = 1;
    }

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

    private static readonly RobloxPianoArrangementOptions ContinuityDisabledOptions = ProductionOptions with
    {
        HarmonyContinuityWindow = TimeSpan.FromMilliseconds(1)
    };

    private sealed record Fixture(
        string Name,
        float[] Samples,
        IReadOnlyList<AudioArrangementReferenceNote> Reference);
}
