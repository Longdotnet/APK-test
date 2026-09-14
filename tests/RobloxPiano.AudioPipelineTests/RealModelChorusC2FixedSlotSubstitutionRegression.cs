using System.Reflection;
using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class RealModelChorusC2FixedSlotSubstitutionRegression
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

        // Infer exactly once. Every substitution is evaluated against the same decoded-note evidence.
        var transcription = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "phase-73 chorus-c2 fixed-slot substitution",
            new AudioToPianoTranscriptionOptions(
                Decoder: DecoderOptions,
                Arrangement: ProductionOptions));

        var arranger = new RobloxPianoArranger();
        var evaluator = new AudioArrangementQualityEvidenceEvaluator();
        var production = arranger.Arrange(
            "phase-73 production",
            transcription.NoteEvidence,
            ProductionOptions);
        var productionQuality = evaluator.Evaluate(
            fixture.Reference,
            transcription.NoteEvidence,
            production.Track,
            options: EvaluationOptions);

        if (!productionQuality.Sections.TryGetValue(TargetSection, out var productionTarget) || productionTarget is null)
            throw new InvalidOperationException($"Missing {TargetSection} section evidence.");

        var targetReferences = fixture.Reference
            .Where(item => string.Equals(item.Section, TargetSection, StringComparison.Ordinal) &&
                           item.Role == AudioArrangementReferenceRole.Harmony)
            .Select(item => item.Note)
            .ToArray();
        var sourceEvaluation = new AudioTranscriptionEvaluator().Evaluate(
            targetReferences,
            transcription.NoteEvidence,
            EvaluationOptions);
        var arrangedNotes = ConvertTrackToNotes(production.Track, ProductionOptions.EffectiveKeyboardProfile);
        var arrangedEvaluation = new AudioTranscriptionEvaluator().Evaluate(
            targetReferences,
            arrangedNotes,
            EvaluationOptions);
        var retainedReferences = arrangedEvaluation.Matches
            .Select(match => match.ReferenceIndex)
            .ToHashSet();

        var lostRecognized = sourceEvaluation.Matches
            .Where(match => !retainedReferences.Contains(match.ReferenceIndex))
            .Select(match => new LostRecognizedNote(
                match.ReferenceIndex,
                targetReferences[match.ReferenceIndex],
                transcription.NoteEvidence[match.EstimatedIndex]))
            .OrderBy(item => item.Reference.Start)
            .ThenBy(item => item.Reference.MidiNote)
            .ToArray();

        Require(sourceEvaluation.MatchedNotes >= 4,
            $"{TargetSection} recognized too little harmony evidence: {sourceEvaluation.MatchedNotes}.");
        Require(lostRecognized.Length > 0,
            $"{TargetSection} no longer exposes a recognized harmony loss; retire this substitution gate or update its target.");

        var candidates = new List<CandidateResult>();
        foreach (var lost in lostRecognized)
        {
            var eventIndex = FindNearestEventIndex(production.Track, lost.Source.Start);
            Require(eventIndex >= 0,
                $"No production event was found near lost target MIDI {lost.Reference.MidiNote} at {lost.Source.Start}.");
            var productionEvent = production.Track.Events[eventIndex];
            Require(Abs(productionEvent.Start - lost.Source.Start) <= EvaluationOptions.EffectiveOnsetTolerance,
                $"Nearest production event for MIDI {lost.Reference.MidiNote} was outside evaluation tolerance.");

            for (var slotIndex = 0; slotIndex < productionEvent.Keys.Count; slotIndex++)
            {
                var candidate = EvaluateSubstitution(
                    production.Track,
                    productionQuality,
                    fixture.Reference,
                    transcription.NoteEvidence,
                    evaluator,
                    lost,
                    eventIndex,
                    slotIndex);
                if (candidate is not null)
                    candidates.Add(candidate);
            }
        }

        Require(candidates.Count > 0,
            "Fixed-slot matrix produced no legal substitutions for recognized lost chorus harmony notes.");

        foreach (var candidate in candidates
                     .OrderBy(item => item.TargetMidi)
                     .ThenBy(item => item.EventIndex)
                     .ThenBy(item => item.SlotIndex))
        {
            Console.WriteLine(
                $"REAL_MODEL_FIXED_SLOT targetMidi={candidate.TargetMidi} displacedMidi={candidate.DisplacedMidi} " +
                $"event={candidate.EventIndex} slot={candidate.SlotIndex} target={candidate.TargetRetained}/{candidate.TargetRecognized} " +
                $"targetDelta={candidate.TargetDelta:+0;-0;0} harmony={candidate.Quality.RetainedHarmonyNotes}/{candidate.Quality.RecognizedHarmonyNotes} " +
                $"harmonyDelta={candidate.HarmonyDelta:+0;-0;0} melody={candidate.Quality.RetainedMelodyNotes}/{candidate.Quality.RecognizedMelodyNotes} " +
                $"melodyDelta={candidate.MelodyDelta:+0;-0;0} sectionWins={candidate.SectionWins} sectionLosses={candidate.SectionLosses} " +
                $"clutter={candidate.Quality.ClutterSuppression:F3} clutterDelta={candidate.ClutterDelta:+0.000;-0.000;0.000} " +
                $"events={candidate.Quality.ArrangedNotes} falsePositives={candidate.Quality.ArrangementAddedFalsePositives} promotable={candidate.Promotable}");
        }

        var winner = candidates
            .Where(item => item.Promotable)
            .OrderByDescending(item => item.TargetRetained)
            .ThenByDescending(item => item.Quality.RetainedHarmonyNotes)
            .ThenByDescending(item => item.Quality.ClutterSuppression)
            .ThenByDescending(item => item.Quality.RetainedMelodyNotes)
            .FirstOrDefault();
        var improving = candidates.Count(item => item.TargetDelta > 0);
        var decision = winner is not null
            ? $"PROMOTION_CANDIDATE:{winner.TargetMidi}:event{winner.EventIndex}:slot{winner.SlotIndex}"
            : improving > 0
                ? "MULTI_CONSTRAINT_BLOCKED"
                : "TUNE_MULTI_SLOT_VOICING";

        Console.WriteLine(
            $"REAL_MODEL_FIXED_SLOT_DECISION decision={decision} candidates={candidates.Count} improving={improving} " +
            $"productionTarget={productionTarget.RetainedHarmonyNotes}/{productionTarget.RecognizedHarmonyNotes} " +
            $"productionHarmony={productionQuality.RetainedHarmonyNotes}/{productionQuality.RecognizedHarmonyNotes} " +
            $"productionMelody={productionQuality.RetainedMelodyNotes}/{productionQuality.RecognizedMelodyNotes} " +
            $"productionClutter={productionQuality.ClutterSuppression:F3} events={productionQuality.ArrangedNotes}");

        Require(productionQuality.MelodyRetention >= 0.90,
            $"Production melody retention regressed before fixed-slot matrix: {productionQuality.MelodyRetention:F3}.");
        Require(!productionQuality.ArrangementAddedFalsePositives,
            "Production arrangement added unmatched playback events before fixed-slot matrix.");
    }

    private static CandidateResult? EvaluateSubstitution(
        PerformanceTrack production,
        AudioArrangementQualityEvidence productionQuality,
        IReadOnlyList<AudioArrangementReferenceNote> reference,
        IReadOnlyList<BasicPitchTranscribedNote> decoded,
        AudioArrangementQualityEvidenceEvaluator evaluator,
        LostRecognizedNote lost,
        int eventIndex,
        int slotIndex)
    {
        var profile = ProductionOptions.EffectiveKeyboardProfile;
        var targetPitch = MapPitch(lost.Reference.MidiNote);
        var targetKeyIndex = targetPitch - profile.LowestMidiNote;
        Require(targetKeyIndex >= 0 && targetKeyIndex < profile.Keys.Length,
            $"Target pitch {targetPitch} was outside the Roblox evidence profile.");
        var targetKey = profile.Keys[targetKeyIndex];

        var sourceEvent = production.Events[eventIndex];
        if (sourceEvent.Keys.Contains(targetKey))
            return null;

        var displacedKey = sourceEvent.Keys[slotIndex];
        var displacedIndex = profile.Keys.IndexOf(displacedKey);
        Require(displacedIndex >= 0, $"Production key '{displacedKey}' was outside the Roblox evidence profile.");
        var displacedPitch = checked(profile.LowestMidiNote + displacedIndex);

        var replacementKeys = sourceEvent.Keys.ToArray();
        replacementKeys[slotIndex] = targetKey;
        if (replacementKeys.Distinct().Count() != replacementKeys.Length)
            return null;

        var events = production.Events.ToArray();
        events[eventIndex] = sourceEvent with { Keys = replacementKeys };
        var counterfactual = production with { Events = events };
        var quality = evaluator.Evaluate(reference, decoded, counterfactual, options: EvaluationOptions);
        var target = quality.Sections[TargetSection];
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
        var melodyDelta = quality.RetainedMelodyNotes - productionQuality.RetainedMelodyNotes;
        var clutterDelta = quality.ClutterSuppression - productionQuality.ClutterSuppression;
        var promotable =
            target.RetainedHarmonyNotes >= 3 &&
            targetDelta > 0 &&
            harmonyDelta >= 0 &&
            melodyDelta >= 0 &&
            sectionLosses == 0 &&
            !quality.ArrangementAddedFalsePositives &&
            quality.ArrangedNotes == productionQuality.ArrangedNotes &&
            clutterDelta >= -0.02;

        return new CandidateResult(
            lost.Reference.MidiNote,
            displacedPitch,
            eventIndex,
            slotIndex,
            quality,
            target.RecognizedHarmonyNotes,
            target.RetainedHarmonyNotes,
            targetDelta,
            harmonyDelta,
            melodyDelta,
            sectionWins,
            sectionLosses,
            clutterDelta,
            promotable);
    }

    private static int FindNearestEventIndex(PerformanceTrack track, TimeSpan start)
    {
        if (track.Events.Count == 0)
            return -1;
        return track.Events
            .Select((item, index) => (item, index))
            .OrderBy(pair => Abs(pair.item.Start - start))
            .ThenBy(pair => pair.index)
            .First().index;
    }

    private static IReadOnlyList<BasicPitchTranscribedNote> ConvertTrackToNotes(
        PerformanceTrack track,
        MidiKeyboardProfile profile)
    {
        var notes = new List<BasicPitchTranscribedNote>();
        foreach (var performanceEvent in track.Events)
        {
            foreach (var key in performanceEvent.Keys)
            {
                var keyIndex = profile.Keys.IndexOf(key);
                Require(keyIndex >= 0, $"Arranged key '{key}' was outside the Roblox evidence profile.");
                notes.Add(new BasicPitchTranscribedNote(
                    performanceEvent.Start,
                    performanceEvent.Start + performanceEvent.Duration,
                    checked(profile.LowestMidiNote + keyIndex),
                    1f));
            }
        }
        return notes;
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

    private sealed record Fixture(float[] Samples, IReadOnlyList<AudioArrangementReferenceNote> Reference);
    private sealed record LostRecognizedNote(
        int ReferenceIndex,
        AudioTranscriptionReferenceNote Reference,
        BasicPitchTranscribedNote Source);
    private sealed record CandidateResult(
        int TargetMidi,
        int DisplacedMidi,
        int EventIndex,
        int SlotIndex,
        AudioArrangementQualityEvidence Quality,
        int TargetRecognized,
        int TargetRetained,
        int TargetDelta,
        int HarmonyDelta,
        int MelodyDelta,
        int SectionWins,
        int SectionLosses,
        double ClutterDelta,
        bool Promotable);
}
