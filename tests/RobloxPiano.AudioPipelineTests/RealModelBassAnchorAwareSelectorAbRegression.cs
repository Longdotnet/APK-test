using System.Reflection;
using System.Runtime.CompilerServices;
using RobloxPiano.Audio;
using RobloxPiano.Core;

internal static class RealModelBassAnchorAwareSelectorAbRegression
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

        var promotionSafe = true;
        foreach (var fixture in cases)
        {
            // One pinned-model inference per corpus; production and candidate consume identical decoded notes.
            var transcription = service.TranscribeNormalized(
                new NormalizedAudio(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate),
                $"phase-75 {fixture.Name}",
                new AudioToPianoTranscriptionOptions(
                    Decoder: DecoderOptions,
                    Arrangement: ProductionOptions));

            var decoded = transcription.NoteEvidence;
            var productionArrangement = new RobloxPianoArranger().Arrange(
                $"phase-75 {fixture.Name} production",
                decoded,
                ProductionOptions);
            var candidateTrack = ApplyBassAnchorAwareSelector(
                productionArrangement.Track,
                decoded,
                ProductionOptions.EffectiveKeyboardProfile,
                out var substitutions);

            var production = Evaluate(fixture.Reference, decoded, productionArrangement.Track);
            var candidate = Evaluate(fixture.Reference, decoded, candidateTrack);
            var sectionLosses = production.Sections.Count(pair =>
                candidate.Sections.TryGetValue(pair.Key, out var other) &&
                other.RetainedHarmonyNotes < pair.Value.RetainedHarmonyNotes);

            Require(production.MelodyRetention >= 0.85,
                $"{fixture.Name} production melody baseline regressed: {production.MelodyRetention:F3}.");
            Require(production.HarmonyRetention >= 0.65,
                $"{fixture.Name} production harmony baseline regressed: {production.HarmonyRetention:F3}.");
            Require(!production.ArrangementAddedFalsePositives,
                $"{fixture.Name} production added false-positive canonical events.");

            // A calibration candidate may legitimately fail to improve quality. It may not silently make the
            // production evidence worse; that would indicate the proposed rule is unsafe rather than merely ineffective.
            var candidateBounded =
                candidate.RetainedHarmonyNotes >= production.RetainedHarmonyNotes &&
                candidate.RetainedMelodyNotes >= production.RetainedMelodyNotes &&
                sectionLosses == 0 &&
                !candidate.ArrangementAddedFalsePositives &&
                candidate.ArrangedNotes == production.ArrangedNotes &&
                candidate.ClutterSuppression >= production.ClutterSuppression - 0.02;
            Require(candidateBounded,
                $"{fixture.Name} candidate selector regressed bounded production quality; reject the rule.");

            var casePromotable = candidateBounded;
            if (fixture.Name == "repeated-progression")
            {
                var productionTarget = production.Sections[TargetSection];
                var candidateTarget = candidate.Sections[TargetSection];
                casePromotable &=
                    substitutions.Count > 0 &&
                    candidateTarget.RetainedHarmonyNotes >= 3 &&
                    candidateTarget.RetainedHarmonyNotes > productionTarget.RetainedHarmonyNotes &&
                    candidate.RetainedHarmonyNotes > production.RetainedHarmonyNotes;
            }

            promotionSafe &= casePromotable;
            Console.WriteLine(
                $"REAL_MODEL_BASS_ANCHOR_SELECTOR corpus={fixture.Name} bounded={candidateBounded} promotable={casePromotable} substitutions={substitutions.Count} " +
                $"melody={production.RetainedMelodyNotes}/{production.RecognizedMelodyNotes}->{candidate.RetainedMelodyNotes}/{candidate.RecognizedMelodyNotes} " +
                $"harmony={production.RetainedHarmonyNotes}/{production.RecognizedHarmonyNotes}->{candidate.RetainedHarmonyNotes}/{candidate.RecognizedHarmonyNotes} " +
                $"clutter={production.ClutterSuppression:F3}->{candidate.ClutterSuppression:F3} " +
                $"sectionLosses={sectionLosses} events={production.ArrangedNotes}/{candidate.ArrangedNotes}");

            foreach (var substitution in substitutions)
            {
                Console.WriteLine(
                    $"REAL_MODEL_BASS_ANCHOR_SELECTOR_SUBSTITUTION corpus={fixture.Name} event={substitution.EventIndex} " +
                    $"startMs={substitution.Start.TotalMilliseconds:F0} from={substitution.FromMidi} to={substitution.ToMidi} " +
                    $"sourceActivation={substitution.FromActivation:F3} candidateActivation={substitution.ToActivation:F3}");
            }

            if (fixture.Name == "repeated-progression")
            {
                var productionTarget = production.Sections[TargetSection];
                var candidateTarget = candidate.Sections[TargetSection];
                Console.WriteLine(
                    $"REAL_MODEL_BASS_ANCHOR_SELECTOR_TARGET section={TargetSection} " +
                    $"harmony={productionTarget.RetainedHarmonyNotes}/{productionTarget.RecognizedHarmonyNotes}->" +
                    $"{candidateTarget.RetainedHarmonyNotes}/{candidateTarget.RecognizedHarmonyNotes}");
            }
        }

        Console.WriteLine(
            $"REAL_MODEL_BASS_ANCHOR_SELECTOR_DECISION decision={(promotionSafe ? "PROMOTION_SAFE" : "KEEP_PRODUCTION")} corpora={cases.Length}");
    }

    private static PerformanceTrack ApplyBassAnchorAwareSelector(
        PerformanceTrack production,
        IReadOnlyList<BasicPitchTranscribedNote> decoded,
        MidiKeyboardProfile profile,
        out IReadOnlyList<Substitution> substitutions)
    {
        var events = production.Events.ToArray();
        var applied = new List<Substitution>();

        for (var eventIndex = 0; eventIndex < events.Length; eventIndex++)
        {
            var current = events[eventIndex];
            if (current.Keys.Count != 1)
                continue;

            var currentMidi = KeyToMidi(current.Keys[0], profile);
            var onsetPeers = events
                .Select((item, index) => (item, index))
                .Where(pair => Abs(pair.item.Start - current.Start) <= OnsetClusterWindow)
                .ToArray();
            if (onsetPeers.Length < ProductionOptions.MaxSimultaneousNotes)
                continue;

            var peerMidis = onsetPeers
                .Select(pair => KeyToMidi(pair.item.Keys[0], profile))
                .ToArray();
            if (currentMidi != peerMidis.Min())
                continue;

            var recentlyCovered = events
                .Take(eventIndex)
                .Any(item =>
                    item.Keys.Count == 1 &&
                    KeyToMidi(item.Keys[0], profile) == currentMidi &&
                    current.Start > item.Start &&
                    current.Start - item.Start <= BassRedundancyWindow);
            if (!recentlyCovered)
                continue;

            var currentEvidence = decoded
                .Where(note => note.MidiNote == currentMidi && Abs(note.Start - current.Start) <= OnsetClusterWindow)
                .OrderByDescending(note => note.Amplitude)
                .FirstOrDefault();
            if (currentEvidence is null)
                continue;

            var alternate = decoded
                .Where(note =>
                    note.MidiNote > currentMidi &&
                    PitchClass(note.MidiNote) == PitchClass(currentMidi) &&
                    note.MidiNote >= profile.LowestMidiNote &&
                    note.MidiNote <= profile.HighestMidiNote &&
                    Abs(note.Start - current.Start) <= OnsetClusterWindow &&
                    note.Amplitude >= currentEvidence.Amplitude * ProductionOptions.HarmonyOctaveRepresentativeRelativeActivationFloor &&
                    !peerMidis.Contains(note.MidiNote))
                .OrderByDescending(note => note.Amplitude)
                .ThenBy(note => note.MidiNote)
                .FirstOrDefault();
            if (alternate is null)
                continue;

            var replacementKey = profile.Map(alternate.MidiNote);
            if (onsetPeers.Any(pair => pair.item.Keys.Contains(replacementKey)))
                continue;

            events[eventIndex] = current with { Keys = new[] { replacementKey } };
            applied.Add(new Substitution(
                eventIndex,
                current.Start,
                currentMidi,
                alternate.MidiNote,
                currentEvidence.Amplitude,
                alternate.Amplitude));
        }

        substitutions = applied;
        return production with { Events = events };
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

    private static Fixture LoadFixture(Type owner, string methodName, string name)
    {
        var method = owner.GetMethod(methodName, BindingFlags.NonPublic | BindingFlags.Static)
            ?? throw new InvalidOperationException($"Fixture builder {owner.Name}.{methodName} was not found.");
        var source = method.Invoke(null, null)
            ?? throw new InvalidOperationException($"Fixture builder {owner.Name}.{methodName} returned null.");
        var type = source.GetType();
        var samples = type.GetProperty("Samples")?.GetValue(source) as float[]
            ?? throw new InvalidOperationException($"{name} fixture Samples were unavailable.");
        var reference = type.GetProperty("Reference")?.GetValue(source) as IReadOnlyList<AudioArrangementReferenceNote>
            ?? throw new InvalidOperationException($"{name} fixture Reference was unavailable.");
        return new Fixture(name, samples, reference);
    }

    private static int KeyToMidi(char key, MidiKeyboardProfile profile)
    {
        var index = profile.Keys.IndexOf(key);
        Require(index >= 0, $"Key '{key}' was outside the Roblox evidence profile.");
        return checked(profile.LowestMidiNote + index);
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
    private static readonly TimeSpan OnsetClusterWindow = TimeSpan.FromMilliseconds(18);
    private static readonly TimeSpan BassRedundancyWindow = TimeSpan.FromMilliseconds(180);

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
        string Name,
        float[] Samples,
        IReadOnlyList<AudioArrangementReferenceNote> Reference);

    private sealed record Substitution(
        int EventIndex,
        TimeSpan Start,
        int FromMidi,
        int ToMidi,
        float FromActivation,
        float ToActivation);
}
