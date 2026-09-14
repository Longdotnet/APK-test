using System.Reflection;
using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class RealModelFixedSlotIdentityValidationRegression
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

        // Infer exactly once. Production and counterfactual consume identical decoded evidence.
        var transcription = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "phase-74 fixed-slot identity validation",
            new AudioToPianoTranscriptionOptions(
                Decoder: DecoderOptions,
                Arrangement: ProductionOptions));

        var arranger = new RobloxPianoArranger();
        var evaluator = new AudioArrangementQualityEvidenceEvaluator();
        var production = arranger.Arrange(
            "phase-74 production",
            transcription.NoteEvidence,
            ProductionOptions);
        var productionQuality = evaluator.Evaluate(
            fixture.Reference,
            transcription.NoteEvidence,
            production.Track,
            options: EvaluationOptions);

        var targetReferences = fixture.Reference
            .Where(item => string.Equals(item.Section, TargetSection, StringComparison.Ordinal) &&
                           item.Role == AudioArrangementReferenceRole.Harmony)
            .Select(item => item.Note)
            .ToArray();
        var transcriptionEvaluator = new AudioTranscriptionEvaluator();
        var sourceEvaluation = transcriptionEvaluator.Evaluate(
            targetReferences,
            transcription.NoteEvidence,
            EvaluationOptions);
        var sourceTargetMatch = sourceEvaluation.Matches
            .Single(match => targetReferences[match.ReferenceIndex].MidiNote == TargetMidi);
        var sourceTarget = transcription.NoteEvidence[sourceTargetMatch.EstimatedIndex];

        var productionOrigins = ConvertTrackToOrigins(production.Track, ProductionOptions.EffectiveKeyboardProfile);
        var productionEvaluation = transcriptionEvaluator.Evaluate(
            targetReferences,
            productionOrigins.Select(item => item.Note).ToArray(),
            EvaluationOptions);
        var productionReferences = productionEvaluation.Matches
            .Select(match => match.ReferenceIndex)
            .ToHashSet();

        var targetReferenceIndex = sourceTargetMatch.ReferenceIndex;
        var rootReferenceIndex = Array.FindIndex(targetReferences, item => item.MidiNote == RootMidi);
        Require(rootReferenceIndex >= 0, $"{TargetSection} root reference MIDI {RootMidi} was not found.");
        Require(!productionReferences.Contains(targetReferenceIndex),
            $"Target MIDI {TargetMidi} is already retained; retire or update the identity gate.");
        Require(productionReferences.Contains(rootReferenceIndex),
            $"Production no longer retains root MIDI {RootMidi}; fixed-slot identity premise changed.");

        var eventIndex = FindNearestEventIndex(production.Track, sourceTarget.Start);
        Require(eventIndex >= 0, $"No production event exists near target MIDI {TargetMidi}.");
        var sourceEvent = production.Track.Events[eventIndex];
        Require(Abs(sourceEvent.Start - sourceTarget.Start) <= EvaluationOptions.EffectiveOnsetTolerance,
            $"Nearest production event for target MIDI {TargetMidi} was outside evaluation tolerance.");

        var profile = ProductionOptions.EffectiveKeyboardProfile;
        var rootKey = MapPitchToKey(RootMidi, profile);
        var targetKey = MapPitchToKey(TargetMidi, profile);
        var rootSlot = sourceEvent.Keys.IndexOf(rootKey);
        Require(rootSlot >= 0,
            $"Expected Phase 73 displaced MIDI {RootMidi} was not present in event {eventIndex}.");
        Require(!sourceEvent.Keys.Contains(targetKey),
            $"Target MIDI {TargetMidi} already occupies event {eventIndex}; identity gate is stale.");

        var replacementKeys = sourceEvent.Keys.ToArray();
        replacementKeys[rootSlot] = targetKey;
        Require(replacementKeys.Distinct().Count() == replacementKeys.Length,
            "Identity counterfactual would create duplicate keys.");

        var events = production.Track.Events.ToArray();
        events[eventIndex] = sourceEvent with { Keys = replacementKeys };
        var counterfactual = production.Track with { Events = events };
        var counterfactualOrigins = ConvertTrackToOrigins(counterfactual, profile);
        var counterfactualEvaluation = transcriptionEvaluator.Evaluate(
            targetReferences,
            counterfactualOrigins.Select(item => item.Note).ToArray(),
            EvaluationOptions);
        var counterfactualReferences = counterfactualEvaluation.Matches
            .Select(match => match.ReferenceIndex)
            .ToHashSet();

        var addedReferences = counterfactualReferences.Except(productionReferences).Order().ToArray();
        var removedReferences = productionReferences.Except(counterfactualReferences).Order().ToArray();
        Require(addedReferences.Contains(targetReferenceIndex),
            $"MIDI {TargetMidi} substitution did not add its exact target reference identity.");
        Require(removedReferences.Length == 0,
            $"MIDI {TargetMidi} substitution removed retained reference identities: {string.Join(',', removedReferences)}.");
        Require(counterfactualReferences.Contains(rootReferenceIndex),
            $"MIDI {RootMidi} root identity was lost after occupying its original slot with MIDI {TargetMidi}.");
        Require(counterfactualReferences.IsSupersetOf(productionReferences) &&
                counterfactualReferences.Count > productionReferences.Count,
            "Counterfactual reference identity must be a strict superset of production.");

        var rootMatch = counterfactualEvaluation.Matches.Single(match => match.ReferenceIndex == rootReferenceIndex);
        var rootOrigin = counterfactualOrigins[rootMatch.EstimatedIndex];
        Require(rootOrigin.Note.MidiNote == RootMidi,
            $"Root identity was matched by unexpected pitch {rootOrigin.Note.MidiNote}.");
        Require(rootOrigin.EventIndex != eventIndex || rootOrigin.SlotIndex != rootSlot,
            "Root identity still points at the displaced slot; counterfactual construction did not take effect.");

        var counterfactualQuality = evaluator.Evaluate(
            fixture.Reference,
            transcription.NoteEvidence,
            counterfactual,
            options: EvaluationOptions);
        var productionTarget = productionQuality.Sections[TargetSection];
        var counterfactualTarget = counterfactualQuality.Sections[TargetSection];
        var sectionLosses = productionQuality.Sections.Count(pair =>
            counterfactualQuality.Sections[pair.Key].RetainedHarmonyNotes < pair.Value.RetainedHarmonyNotes);

        var identitySafe =
            counterfactualTarget.RetainedHarmonyNotes >= 3 &&
            counterfactualTarget.RetainedHarmonyNotes > productionTarget.RetainedHarmonyNotes &&
            counterfactualQuality.RetainedHarmonyNotes >= productionQuality.RetainedHarmonyNotes &&
            counterfactualQuality.RetainedMelodyNotes >= productionQuality.RetainedMelodyNotes &&
            sectionLosses == 0 &&
            !counterfactualQuality.ArrangementAddedFalsePositives &&
            counterfactualQuality.ArrangedNotes == productionQuality.ArrangedNotes &&
            counterfactualQuality.ClutterSuppression >= productionQuality.ClutterSuppression - 0.02;

        Console.WriteLine(
            $"REAL_MODEL_FIXED_SLOT_IDENTITY target={TargetMidi} displaced={RootMidi} event={eventIndex} slot={rootSlot} " +
            $"productionRefs={FormatReferences(productionReferences, targetReferences)} " +
            $"candidateRefs={FormatReferences(counterfactualReferences, targetReferences)} " +
            $"addedRefs={FormatReferences(addedReferences, targetReferences)} removedRefs={FormatReferences(removedReferences, targetReferences)} " +
            $"rootCoveredBy=event{rootOrigin.EventIndex}:slot{rootOrigin.SlotIndex}:start{rootOrigin.Note.Start.TotalMilliseconds:F0}ms " +
            $"targetHarmony={counterfactualTarget.RetainedHarmonyNotes}/{counterfactualTarget.RecognizedHarmonyNotes} " +
            $"globalHarmony={counterfactualQuality.RetainedHarmonyNotes}/{counterfactualQuality.RecognizedHarmonyNotes} " +
            $"melody={counterfactualQuality.RetainedMelodyNotes}/{counterfactualQuality.RecognizedMelodyNotes} " +
            $"clutter={counterfactualQuality.ClutterSuppression:F3} events={counterfactualQuality.ArrangedNotes} identitySafe={identitySafe}");
        Console.WriteLine(
            $"REAL_MODEL_FIXED_SLOT_IDENTITY_DECISION decision={(identitySafe ? $"IDENTITY_SAFE_PROMOTION_CANDIDATE:{TargetMidi}" : "KEEP_PRODUCTION")} ");

        Require(identitySafe,
            "Phase 73 promotion candidate failed exact reference-identity or quality preservation checks.");
    }

    private static Origin[] ConvertTrackToOrigins(PerformanceTrack track, MidiKeyboardProfile profile)
    {
        var result = new List<Origin>();
        for (var eventIndex = 0; eventIndex < track.Events.Count; eventIndex++)
        {
            var item = track.Events[eventIndex];
            for (var slotIndex = 0; slotIndex < item.Keys.Count; slotIndex++)
            {
                var keyIndex = profile.Keys.IndexOf(item.Keys[slotIndex]);
                Require(keyIndex >= 0, $"Arranged key '{item.Keys[slotIndex]}' was outside the Roblox evidence profile.");
                result.Add(new Origin(
                    new BasicPitchTranscribedNote(
                        item.Start,
                        item.Start + item.Duration,
                        checked(profile.LowestMidiNote + keyIndex),
                        1f),
                    eventIndex,
                    slotIndex));
            }
        }
        return result.ToArray();
    }

    private static string MapPitchToKey(int midiNote, MidiKeyboardProfile profile)
    {
        var pitch = midiNote;
        if (ProductionOptions.FoldOctavesToRange)
        {
            while (pitch < profile.LowestMidiNote)
                pitch += 12;
            while (pitch > profile.HighestMidiNote)
                pitch -= 12;
        }
        var index = pitch - profile.LowestMidiNote;
        Require(index >= 0 && index < profile.Keys.Length, $"MIDI {midiNote} maps outside Roblox range.");
        return profile.Keys[index];
    }

    private static int FindNearestEventIndex(PerformanceTrack track, TimeSpan start) => track.Events
        .Select((item, index) => (item, index))
        .OrderBy(pair => Abs(pair.item.Start - start))
        .ThenBy(pair => pair.index)
        .Select(pair => pair.index)
        .DefaultIfEmpty(-1)
        .First();

    private static string FormatReferences(IEnumerable<int> indices, IReadOnlyList<AudioTranscriptionReferenceNote> references) =>
        string.Join(',', indices.Order().Select(index => $"{index}:{references[index].MidiNote}"));

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

    private static TimeSpan Abs(TimeSpan value) => value < TimeSpan.Zero ? -value : value;

    private static void Require(bool condition, string message)
    {
        if (condition)
            return;
        Console.Error.WriteLine($"FAIL: {message}");
        Environment.ExitCode = 1;
    }

    private const string TargetSection = "chorus-c2";
    private const int RootMidi = 48;
    private const int TargetMidi = 60;

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

    private sealed record Fixture(float[] Samples, IReadOnlyList<AudioArrangementReferenceNote> Reference);
    private sealed record Origin(BasicPitchTranscribedNote Note, int EventIndex, int SlotIndex);
}
