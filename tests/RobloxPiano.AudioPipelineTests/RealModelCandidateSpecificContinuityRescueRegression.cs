using System.Reflection;
using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class RealModelCandidateSpecificContinuityRescueRegression
{
    private const float RescueStep = 0.01f;
    private const float RescueCeiling = 0.65f;

    [ModuleInitializer]
    internal static void Run()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            return;

        var fixture = LoadPhase68Fixture();
        using var service = new AudioToPianoTranscriptionService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));

        // Infer once. Every candidate rescue reuses this exact pinned Spotify Basic Pitch note evidence.
        var transcription = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "real-model candidate-specific continuity rescue",
            new AudioToPianoTranscriptionOptions(
                Decoder: DecoderOptions,
                Arrangement: ProductionOptions));

        var decoded = transcription.NoteEvidence;
        var arranger = new RobloxPianoArranger();
        var productionArrangement = arranger.Arrange(
            "real-model candidate-specific continuity rescue",
            decoded,
            ProductionOptions);
        var production = Evaluate(fixture.Reference, decoded, productionArrangement.Track);

        var harmonyReference = fixture.Reference
            .Where(item => item.Role == AudioArrangementReferenceRole.Harmony)
            .ToArray();
        var matchOptions = EvaluationOptions;
        var sourceHarmony = new AudioTranscriptionEvaluator().Evaluate(
            harmonyReference.Select(item => item.Note).ToArray(),
            decoded,
            matchOptions);

        var chordGroups = harmonyReference
            .GroupBy(item => item.Note.Start)
            .OrderBy(group => group.Key)
            .Select(group => new ChordGroup(
                group.Key,
                group.Select(item => PitchClass(item.Note.MidiNote)).ToHashSet()))
            .ToArray();

        var opportunities = new List<CandidateOpportunity>();
        foreach (var match in sourceHarmony.Matches)
        {
            var reference = harmonyReference[match.ReferenceIndex];
            var sourceIndex = match.EstimatedIndex;
            var source = decoded[sourceIndex];
            var chordIndex = Array.FindIndex(chordGroups, chord => chord.Start == reference.Note.Start);
            if (chordIndex <= 0)
                continue;
            if (!chordGroups[chordIndex - 1].PitchClasses.Contains(PitchClass(source.MidiNote)))
                continue;
            if (source.Amplitude >= RescueCeiling - 1e-6f)
                continue;

            opportunities.Add(new CandidateOpportunity(
                sourceIndex,
                reference.Section,
                source.MidiNote,
                source.Amplitude));
        }

        opportunities = opportunities
            .GroupBy(item => item.SourceIndex)
            .Select(group => group.First())
            .OrderBy(item => decoded[item.SourceIndex].Start)
            .ThenBy(item => item.MidiNote)
            .ToList();

        var changed = new List<RescueResult>();
        foreach (var opportunity in opportunities)
        {
            RescueResult? bestForCandidate = null;
            var firstChangedActivation = float.NaN;
            for (var activation = NextStep(opportunity.OriginalActivation);
                 activation <= RescueCeiling + 1e-6f;
                 activation = RoundStep(activation + RescueStep))
            {
                var counterfactualNotes = decoded.ToArray();
                var original = counterfactualNotes[opportunity.SourceIndex];
                counterfactualNotes[opportunity.SourceIndex] = new BasicPitchTranscribedNote(
                    original.Start,
                    original.End,
                    original.MidiNote,
                    Math.Min(1f, activation),
                    original.PitchBendsThirdSemitones);

                var arrangement = arranger.Arrange(
                    "real-model candidate-specific continuity rescue",
                    counterfactualNotes,
                    ProductionOptions);
                if (TracksEquivalent(productionArrangement.Track, arrangement.Track))
                    continue;

                if (float.IsNaN(firstChangedActivation))
                    firstChangedActivation = activation;

                // Deliberately evaluate against the original decoded evidence. The rescue is not allowed to
                // manufacture a recognition gain merely because this test changed one activation value.
                var evidence = Evaluate(fixture.Reference, decoded, arrangement.Track);
                var result = BuildResult(
                    opportunity,
                    activation,
                    firstChangedActivation,
                    arrangement.Diagnostics.HarmonyContinuitySelections,
                    evidence,
                    production);

                if (bestForCandidate is null || Better(result, bestForCandidate))
                    bestForCandidate = result;
            }

            if (bestForCandidate is not null)
                changed.Add(bestForCandidate);
        }

        Console.WriteLine(
            $"REAL_MODEL_CANDIDATE_RESCUE_PRODUCTION candidates={opportunities.Count} changed={changed.Count} " +
            $"selections={productionArrangement.Diagnostics.HarmonyContinuitySelections} " +
            $"melody={production.RetainedMelodyNotes}/{production.RecognizedMelodyNotes} " +
            $"harmony={production.RetainedHarmonyNotes}/{production.RecognizedHarmonyNotes} " +
            $"harmonyRetention={production.HarmonyRetention:F3} clutter={production.ClutterSuppression:F3}");

        foreach (var result in changed
                     .OrderByDescending(item => item.Promotable)
                     .ThenByDescending(item => item.HarmonyDelta)
                     .ThenByDescending(item => item.SectionWins)
                     .ThenBy(item => item.RequiredActivation))
        {
            Console.WriteLine(
                $"REAL_MODEL_CANDIDATE_RESCUE section={result.Opportunity.Section} midi={result.Opportunity.MidiNote} " +
                $"original={result.Opportunity.OriginalActivation:F3} firstChange={result.FirstChangedActivation:F3} " +
                $"activation={result.RequiredActivation:F3} promotable={result.Promotable} " +
                $"selections={result.ContinuitySelections} melody={result.Evidence.RetainedMelodyNotes}/{result.Evidence.RecognizedMelodyNotes} " +
                $"harmony={result.Evidence.RetainedHarmonyNotes}/{result.Evidence.RecognizedHarmonyNotes} " +
                $"harmonyDelta={result.HarmonyDelta:+0.000;-0.000;0.000} sectionWins={result.SectionWins} sectionLosses={result.SectionLosses} " +
                $"clutterDelta={result.ClutterDelta:+0.000;-0.000;0.000}");
        }

        var winner = changed
            .Where(item => item.Promotable)
            .OrderByDescending(item => item.Evidence.HarmonyRetention)
            .ThenByDescending(item => item.SectionWins)
            .ThenByDescending(item => item.Evidence.ClutterSuppression)
            .ThenBy(item => item.RequiredActivation - item.Opportunity.OriginalActivation)
            .FirstOrDefault();
        var decision = winner is null ? "KEEP_PRODUCTION" : "COUNTERFACTUAL_GAIN";
        Console.WriteLine(
            $"REAL_MODEL_CANDIDATE_RESCUE_DECISION decision={decision} " +
            $"winnerMidi={(winner?.Opportunity.MidiNote.ToString() ?? "none")} " +
            $"winnerSection={(winner?.Opportunity.Section ?? "none")} " +
            $"winnerDelta={(winner?.HarmonyDelta ?? 0):+0.000;-0.000;0.000} " +
            $"winnerSelections={winner?.ContinuitySelections ?? 0}");

        Require(production.RecognizedMelodyNotes >= 8,
            $"Candidate-rescue fixture recognized too little melody evidence: {production.RecognizedMelodyNotes}.");
        Require(production.RecognizedHarmonyNotes >= 20,
            $"Candidate-rescue fixture recognized too little harmony evidence: {production.RecognizedHarmonyNotes}.");
        Require(production.MelodyRetention >= 0.90,
            $"Production retained less than 90% recognized melody: {production.MelodyRetention:F3}.");
        Require(production.HarmonyRetention >= 0.69,
            $"Production retained less than Phase 65-68 harmony floor: {production.HarmonyRetention:F3}.");
        Require(!production.ArrangementAddedFalsePositives,
            "Production arrangement unexpectedly added unmatched playback events.");
        Require(opportunities.Count > 0,
            "Pinned-model fixture no longer exposes any prior-pitch-class harmony candidate for Phase 69 evidence.");

        foreach (var result in changed.Where(item => item.Promotable))
        {
            Require(result.Evidence.MelodyRetention + 1e-9 >= production.MelodyRetention,
                $"Promotable rescue for MIDI {result.Opportunity.MidiNote} reduced melody retention.");
            Require(result.SectionLosses == 0,
                $"Promotable rescue for MIDI {result.Opportunity.MidiNote} reduced harmony in {result.SectionLosses} section(s).");
            Require(!result.Evidence.ArrangementAddedFalsePositives,
                $"Promotable rescue for MIDI {result.Opportunity.MidiNote} added unmatched playback events.");
            Require(result.Evidence.EventRetentionRatio <= 1.000001,
                $"Promotable rescue for MIDI {result.Opportunity.MidiNote} expanded event count to {result.Evidence.EventRetentionRatio:F3}.");
            Require(result.ClutterDelta >= -0.02,
                $"Promotable rescue for MIDI {result.Opportunity.MidiNote} reduced clutter suppression by {result.ClutterDelta:F3}.");
        }
    }

    private static RescueResult BuildResult(
        CandidateOpportunity opportunity,
        float activation,
        float firstChangedActivation,
        int continuitySelections,
        AudioArrangementQualityEvidence evidence,
        AudioArrangementQualityEvidence production)
    {
        var sectionWins = 0;
        var sectionLosses = 0;
        foreach (var (sectionName, candidateSection) in evidence.Sections)
        {
            if (!production.Sections.TryGetValue(sectionName, out var productionSection))
                continue;
            if (candidateSection.HarmonyRetention > productionSection.HarmonyRetention + 1e-9)
                sectionWins++;
            else if (candidateSection.HarmonyRetention + 1e-9 < productionSection.HarmonyRetention)
                sectionLosses++;
        }

        var harmonyDelta = evidence.HarmonyRetention - production.HarmonyRetention;
        var clutterDelta = evidence.ClutterSuppression - production.ClutterSuppression;
        var promotable = evidence.MelodyRetention + 1e-9 >= production.MelodyRetention &&
            !evidence.ArrangementAddedFalsePositives &&
            evidence.EventRetentionRatio <= 1.000001 &&
            sectionLosses == 0 &&
            clutterDelta >= -0.02 &&
            (harmonyDelta > 0.000001 || sectionWins > 0);

        return new RescueResult(
            opportunity,
            activation,
            firstChangedActivation,
            continuitySelections,
            evidence,
            harmonyDelta,
            clutterDelta,
            sectionWins,
            sectionLosses,
            promotable);
    }

    private static bool Better(RescueResult candidate, RescueResult current)
    {
        if (candidate.Promotable != current.Promotable)
            return candidate.Promotable;
        if (Math.Abs(candidate.HarmonyDelta - current.HarmonyDelta) > 1e-9)
            return candidate.HarmonyDelta > current.HarmonyDelta;
        if (candidate.SectionWins != current.SectionWins)
            return candidate.SectionWins > current.SectionWins;
        if (Math.Abs(candidate.ClutterDelta - current.ClutterDelta) > 1e-9)
            return candidate.ClutterDelta > current.ClutterDelta;
        return candidate.RequiredActivation < current.RequiredActivation;
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

    private static ProgressionFixture LoadPhase68Fixture()
    {
        var method = typeof(RealModelAdaptiveDensityContinuityCounterfactualRegression)
            .GetMethod("BuildFixture", BindingFlags.NonPublic | BindingFlags.Static)
            ?? throw new InvalidOperationException("Phase 68 fixture builder was not found.");
        var source = method.Invoke(null, null)
            ?? throw new InvalidOperationException("Phase 68 fixture builder returned null.");
        var type = source.GetType();
        var samples = type.GetProperty("Samples")?.GetValue(source) as float[]
            ?? throw new InvalidOperationException("Phase 68 fixture Samples were not available.");
        var reference = type.GetProperty("Reference")?.GetValue(source) as IReadOnlyList<AudioArrangementReferenceNote>
            ?? throw new InvalidOperationException("Phase 68 fixture Reference was not available.");
        return new ProgressionFixture(samples, reference);
    }

    private static int PitchClass(int midiNote) => ((midiNote % 12) + 12) % 12;

    private static float NextStep(float original)
        => RoundStep(Math.Max(original + RescueStep, 0.18f));

    private static float RoundStep(float value)
        => MathF.Round(value * 100f, MidpointRounding.AwayFromZero) / 100f;

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

    private sealed record ProgressionFixture(
        float[] Samples,
        IReadOnlyList<AudioArrangementReferenceNote> Reference);

    private sealed record ChordGroup(TimeSpan Start, IReadOnlySet<int> PitchClasses);

    private sealed record CandidateOpportunity(
        int SourceIndex,
        string Section,
        int MidiNote,
        float OriginalActivation);

    private sealed record RescueResult(
        CandidateOpportunity Opportunity,
        float RequiredActivation,
        float FirstChangedActivation,
        int ContinuitySelections,
        AudioArrangementQualityEvidence Evidence,
        double HarmonyDelta,
        double ClutterDelta,
        int SectionWins,
        int SectionLosses,
        bool Promotable);
}