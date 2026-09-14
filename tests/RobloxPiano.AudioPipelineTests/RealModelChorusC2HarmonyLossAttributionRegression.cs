using System.Reflection;
using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class RealModelChorusC2HarmonyLossAttributionRegression
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

        // Infer once. Attribution must inspect the exact pinned-model evidence consumed by production arrangement.
        var transcription = service.TranscribeNormalized(
            new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
            "phase-71 chorus-c2 loss attribution",
            new AudioToPianoTranscriptionOptions(
                Decoder: DecoderOptions,
                Arrangement: ProductionOptions));

        var arrangement = new RobloxPianoArranger().Arrange(
            "phase-71 chorus-c2 production",
            transcription.NoteEvidence,
            ProductionOptions);
        var quality = new AudioArrangementQualityEvidenceEvaluator().Evaluate(
            fixture.Reference,
            transcription.NoteEvidence,
            arrangement.Track,
            options: EvaluationOptions);

        Require(quality.Sections.TryGetValue(TargetSection, out var target) && target is not null,
            $"Missing {TargetSection} section evidence.");

        var targetReference = fixture.Reference
            .Where(item => string.Equals(item.Section, TargetSection, StringComparison.Ordinal) &&
                           item.Role == AudioArrangementReferenceRole.Harmony)
            .ToArray();
        var referenceNotes = targetReference.Select(item => item.Note).ToArray();
        var sourceEvaluation = new AudioTranscriptionEvaluator().Evaluate(
            referenceNotes,
            transcription.NoteEvidence,
            EvaluationOptions);
        var arrangedNotes = ConvertTrackToNotes(arrangement.Track, ProductionOptions.EffectiveKeyboardProfile);
        var arrangedEvaluation = new AudioTranscriptionEvaluator().Evaluate(
            referenceNotes,
            arrangedNotes,
            EvaluationOptions);
        var retainedReferenceIndexes = arrangedEvaluation.Matches.Select(match => match.ReferenceIndex).ToHashSet();

        var outcomes = new List<LossOutcome>();
        foreach (var sourceMatch in sourceEvaluation.Matches.OrderBy(match => match.ReferenceIndex))
        {
            var reference = referenceNotes[sourceMatch.ReferenceIndex];
            var source = transcription.NoteEvidence[sourceMatch.EstimatedIndex];
            var retained = retainedReferenceIndexes.Contains(sourceMatch.ReferenceIndex);
            var blocker = retained
                ? "retained"
                : ClassifyLostReference(reference, source, transcription.NoteEvidence, arrangedNotes);
            outcomes.Add(new LossOutcome(reference.MidiNote, source.Amplitude, retained, blocker));
            Console.WriteLine(
                $"REAL_MODEL_CHORUS_C2_NOTE midi={reference.MidiNote} sourceActivation={source.Amplitude:F3} " +
                $"retained={retained} blocker={blocker}");
        }

        var lost = outcomes.Where(item => !item.Retained).ToArray();
        var blockers = lost
            .GroupBy(item => item.Blocker, StringComparer.Ordinal)
            .Select(group => (Name: group.Key, Count: group.Count()))
            .OrderByDescending(item => item.Count)
            .ThenBy(item => item.Name, StringComparer.Ordinal)
            .ToArray();
        var dominant = blockers.FirstOrDefault();
        var decision = dominant.Count == 0 ? "NO_LOSS_TO_ATTRIBUTE" : dominant.Name switch
        {
            "adaptive-density" => "TUNE_DENSITY_EVIDENCE",
            "pitch-class-representative" => "TUNE_OCTAVE_REPRESENTATIVE",
            "hard-density/voicing" => "TUNE_VOICING_SELECTION",
            _ => "INVESTIGATE_OTHER"
        };

        Console.WriteLine(
            $"REAL_MODEL_CHORUS_C2_ATTRIBUTION recognized={sourceEvaluation.MatchedNotes}/{referenceNotes.Length} " +
            $"retained={arrangedEvaluation.MatchedNotes}/{sourceEvaluation.MatchedNotes} " +
            $"adaptive={blockers.FirstOrDefault(item => item.Name == \"adaptive-density\").Count} " +
            $"representative={blockers.FirstOrDefault(item => item.Name == \"pitch-class-representative\").Count} " +
            $"voicing={blockers.FirstOrDefault(item => item.Name == \"hard-density/voicing\").Count} " +
            $"dominant={dominant.Name ?? \"none\"} decision={decision} " +
            $"overallHarmony={quality.RetainedHarmonyNotes}/{quality.RecognizedHarmonyNotes} " +
            $"melody={quality.RetainedMelodyNotes}/{quality.RecognizedMelodyNotes} clutter={quality.ClutterSuppression:F3}");

        Require(sourceEvaluation.MatchedNotes >= 4,
            $"{TargetSection} recognized too little harmony evidence: {sourceEvaluation.MatchedNotes}.");
        Require(lost.Length > 0,
            $"{TargetSection} no longer exposes a harmony loss; retire this attribution gate or update its target.");
        Require(lost.All(item => item.Blocker is "adaptive-density" or "pitch-class-representative" or "hard-density/voicing"),
            "At least one recognized chorus harmony loss could not be attributed to a bounded arranger stage.");
        Require(quality.MelodyRetention >= 0.90,
            $"Production melody retention regressed while attributing chorus loss: {quality.MelodyRetention:F3}.");
        Require(!quality.ArrangementAddedFalsePositives,
            "Production arrangement added unmatched playback events during chorus attribution.");
    }

    private static string ClassifyLostReference(
        AudioTranscriptionReferenceNote reference,
        BasicPitchTranscribedNote matchedSource,
        IReadOnlyList<BasicPitchTranscribedNote> decoded,
        IReadOnlyList<BasicPitchTranscribedNote> arranged)
    {
        var window = ProductionOptions.OnsetClusterWindow ?? TimeSpan.FromMilliseconds(18);
        var cluster = decoded
            .Where(note => Abs(note.Start - matchedSource.Start) <= window)
            .GroupBy(note => note.MidiNote)
            .Select(group => group.OrderByDescending(note => note.Amplitude).ThenByDescending(note => note.Duration).First())
            .ToArray();

        // Mirror the production melody credibility guard closely enough to ensure accompaniment thresholding is
        // measured against accompaniment, not against a dominant melody/vocal activation.
        var maximumActivation = cluster.Max(note => note.Amplitude);
        var melodyThreshold = Math.Max(
            ProductionOptions.MelodyActivationFloor,
            maximumActivation * ProductionOptions.MelodyRelativeActivationFloor);
        var melody = cluster
            .Where(note => note.Amplitude >= melodyThreshold)
            .OrderByDescending(note => MapPitch(note.MidiNote))
            .ThenByDescending(note => note.Amplitude)
            .FirstOrDefault();

        var accompaniment = cluster.Where(note => !ReferenceEquals(note, melody)).ToArray();
        if (ProductionOptions.AdaptiveDensity && accompaniment.Length > 0)
        {
            var strongest = accompaniment.Max(note => note.Amplitude);
            var threshold = Math.Max(
                ProductionOptions.AccompanimentActivationFloor,
                strongest * ProductionOptions.AccompanimentRelativeActivationFloor);
            if (matchedSource.Amplitude < threshold)
                return "adaptive-density";
        }

        var sameOnsetArranged = arranged.Where(note => Abs(note.Start - reference.Start) <= EvaluationOptions.EffectiveOnsetTolerance).ToArray();
        if (sameOnsetArranged.Any(note =>
                note.MidiNote != reference.MidiNote &&
                PitchClass(note.MidiNote) == PitchClass(reference.MidiNote)))
            return "pitch-class-representative";

        return "hard-density/voicing";
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

    private sealed record Fixture(
        float[] Samples,
        IReadOnlyList<AudioArrangementReferenceNote> Reference);

    private sealed record LossOutcome(int MidiNote, float Activation, bool Retained, string Blocker);
}