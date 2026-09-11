using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class PianoLikeCorpusRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
            return; // Program.cs owns the explicit missing-model failure contract.

        using var inference = new BasicPitchInferenceService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));
        var decoder = new BasicPitchNoteDecoder();
        var suppressor = new BasicPitchHarmonicSuppressor();
        var ingest = new AudioIngestService();
        var evaluator = new AudioTranscriptionCorpusEvaluator();
        var baselineCases = new List<AudioTranscriptionEvaluationCase>();
        var suppressedCases = new List<AudioTranscriptionEvaluationCase>();
        var suppressedTotal = 0;

        foreach (var fixture in BuildPianoLikeCorpus())
        {
            using var wave = BuildMonoPcm16Wave(fixture.Samples, BasicPitchInferenceService.RequiredSampleRate);
            var normalized = ingest.DecodeStream(
                wave,
                new AudioIngestOptions(
                    TargetSampleRate: BasicPitchInferenceService.RequiredSampleRate,
                    MaxDuration: TimeSpan.FromSeconds(10)));
            var raw = inference.Infer(normalized);
            var estimated = decoder.Decode(raw, DecoderOptions());
            if (estimated.Count == 0)
                throw new InvalidOperationException($"Piano-like corpus fixture '{fixture.Name}' produced no decoded notes.");

            var suppression = suppressor.Suppress(estimated, SuppressionOptions());
            if (suppression.Notes.Count == 0)
                throw new InvalidOperationException($"Piano-like corpus fixture '{fixture.Name}' lost every decoded note during harmonic suppression.");

            suppressedTotal += suppression.Diagnostics.SuppressedNotes;
            Console.WriteLine(
                $"PIANO_SUPPRESSION {fixture.Name} decoded={estimated.Count} retained={suppression.Notes.Count} suppressed={suppression.Diagnostics.SuppressedNotes}");
            foreach (var decision in suppression.Diagnostics.Suppressed)
            {
                Console.WriteLine(
                    $"PIANO_SUPPRESSION_DECISION {fixture.Name} candidate={decision.Candidate.MidiNote} anchor={decision.Anchor.MidiNote} " +
                    $"harmonic={decision.Harmonic} pitchError={decision.HarmonicPitchErrorSemitones:F3} " +
                    $"overlap={decision.CandidateOverlapRatio:F3} amplitudeRatio={decision.CandidateToAnchorAmplitudeRatio:F3}");
            }

            baselineCases.Add(new AudioTranscriptionEvaluationCase(fixture.Name, fixture.Reference, estimated));
            suppressedCases.Add(new AudioTranscriptionEvaluationCase(fixture.Name, fixture.Reference, suppression.Notes));
        }

        var evaluationOptions = new AudioTranscriptionEvaluationOptions(
            OnsetTolerance: TimeSpan.FromMilliseconds(150),
            RequireOffsetMatch: false);
        var baseline = evaluator.Evaluate(baselineCases, evaluationOptions);
        var corpus = evaluator.Evaluate(suppressedCases, evaluationOptions);

        foreach (var (name, result) in corpus.Results)
        {
            var baselineResult = baseline.Results[name];
            Console.WriteLine(
                $"PIANO_CORPUS {name} baselineEstimated={baselineResult.EstimatedNotes} estimated={result.EstimatedNotes} " +
                $"reference={result.ReferenceNotes} matched={result.MatchedNotes} precision={result.Precision:F3} recall={result.Recall:F3} f1={result.F1:F3} " +
                $"onsetMs={result.MeanAbsoluteOnsetErrorMilliseconds:F1} offsetMs={result.MeanAbsoluteOffsetErrorMilliseconds:F1}");

            if (result.MatchedNotes == 0)
                throw new InvalidOperationException($"Piano-like corpus fixture '{name}' lost every ground-truth pitch/onset note.");
            if (result.MatchedNotes < baselineResult.MatchedNotes)
                throw new InvalidOperationException(
                    $"Harmonic suppression lost a ground-truth match in '{name}': baseline={baselineResult.MatchedNotes}, suppressed={result.MatchedNotes}.");
        }

        Console.WriteLine(
            $"PIANO_CORPUS BASELINE cases={baseline.Cases} reference={baseline.ReferenceNotes} estimated={baseline.EstimatedNotes} matched={baseline.MatchedNotes} " +
            $"microPrecision={baseline.MicroPrecision:F3} microRecall={baseline.MicroRecall:F3} microF1={baseline.MicroF1:F3} macroF1={baseline.MacroF1:F3}");
        Console.WriteLine(
            $"PIANO_CORPUS SUMMARY cases={corpus.Cases} reference={corpus.ReferenceNotes} estimated={corpus.EstimatedNotes} matched={corpus.MatchedNotes} suppressed={suppressedTotal} " +
            $"microPrecision={corpus.MicroPrecision:F3} microRecall={corpus.MicroRecall:F3} microF1={corpus.MicroF1:F3} macroF1={corpus.MacroF1:F3} " +
            $"onsetMs={corpus.MeanAbsoluteOnsetErrorMilliseconds:F1} offsetMs={corpus.MeanAbsoluteOffsetErrorMilliseconds:F1}");

        // Phase 09 pinned fa5997a baseline: 12/12 references matched, precision=.162, recall=1.000,
        // micro-F1=.279, macro-F1=.341 and mean onset=12.3 ms. Phase 10 additionally requires
        // suppression never to lose a matched ground-truth note and never to reduce corpus precision/F1.
        if (corpus.Cases != 4)
            throw new InvalidOperationException($"Expected 4 piano-like corpus cases, got {corpus.Cases}.");
        if (corpus.MatchedNotes < baseline.MatchedNotes)
            throw new InvalidOperationException(
                $"Harmonic suppression reduced matched notes: baseline={baseline.MatchedNotes}, suppressed={corpus.MatchedNotes}.");
        if (corpus.MicroPrecision + 1e-9 < baseline.MicroPrecision)
            throw new InvalidOperationException(
                $"Harmonic suppression reduced precision: baseline={baseline.MicroPrecision:F3}, suppressed={corpus.MicroPrecision:F3}.");
        if (corpus.MicroF1 + 1e-9 < baseline.MicroF1)
            throw new InvalidOperationException(
                $"Harmonic suppression reduced micro F1: baseline={baseline.MicroF1:F3}, suppressed={corpus.MicroF1:F3}.");
        if (corpus.MicroPrecision < 0.14)
            throw new InvalidOperationException($"Piano-like corpus precision regressed below 0.14: {corpus.MicroPrecision:F3}.");
        if (corpus.MicroRecall < 0.90)
            throw new InvalidOperationException($"Piano-like corpus recall regressed below 0.90: {corpus.MicroRecall:F3}.");
        if (corpus.MicroF1 < 0.25)
            throw new InvalidOperationException($"Piano-like corpus micro F1 regressed below 0.25: {corpus.MicroF1:F3}.");
        if (corpus.MacroF1 < 0.30)
            throw new InvalidOperationException($"Piano-like corpus macro F1 regressed below 0.30: {corpus.MacroF1:F3}.");
        if (corpus.MeanAbsoluteOnsetErrorMilliseconds > 40.0)
            throw new InvalidOperationException($"Piano-like corpus mean onset error exceeded 40 ms: {corpus.MeanAbsoluteOnsetErrorMilliseconds:F1} ms.");
    }

    private static BasicPitchNoteDecoderOptions DecoderOptions() => new(
        OnsetThreshold: 0.20f,
        FrameThreshold: 0.15f,
        MinimumNoteLengthFrames: 3,
        EnergyToleranceFrames: 8,
        UseMelodiaRecovery: true,
        IncludePitchBends: true);

    private static BasicPitchHarmonicSuppressionOptions SuppressionOptions() => new(
        MinimumHarmonic: 3,
        MaximumHarmonic: 6,
        OnsetTolerance: TimeSpan.FromMilliseconds(45),
        MinimumCandidateOverlapRatio: 0.80,
        MaximumCandidateToAnchorAmplitudeRatio: 0.50f,
        MaximumHarmonicPitchErrorSemitones: 0.20,
        ProtectPowerOfTwoHarmonics: true);

    private static IReadOnlyList<CorpusFixture> BuildPianoLikeCorpus() =>
    [
        BuildFixture("piano-a4-dynamic", 2.10,
            new NoteSpec(69, 0.30, 1.55, 0.88)),
        BuildFixture("piano-c-major-chord", 2.15,
            new NoteSpec(60, 0.35, 1.60, 0.82),
            new NoteSpec(64, 0.35, 1.60, 0.72),
            new NoteSpec(67, 0.35, 1.60, 0.78)),
        BuildFixture("piano-arpeggio", 2.60,
            new NoteSpec(60, 0.25, 0.90, 0.82),
            new NoteSpec(64, 0.72, 1.37, 0.74),
            new NoteSpec(67, 1.19, 1.84, 0.86),
            new NoteSpec(72, 1.66, 2.31, 0.68)),
        BuildFixture("piano-overlap-dynamics", 2.50,
            new NoteSpec(55, 0.25, 1.45, 0.88),
            new NoteSpec(62, 0.60, 1.65, 0.54),
            new NoteSpec(67, 0.95, 2.05, 0.76),
            new NoteSpec(71, 1.30, 2.20, 0.46))
    ];

    private static CorpusFixture BuildFixture(string name, double durationSeconds, params NoteSpec[] notes)
    {
        var rate = BasicPitchInferenceService.RequiredSampleRate;
        var samples = new float[checked((int)Math.Round(durationSeconds * rate))];

        foreach (var note in notes)
        {
            var startSample = Math.Max(0, (int)Math.Round(note.StartSeconds * rate));
            var endSample = Math.Min(samples.Length, (int)Math.Round(note.EndSeconds * rate));
            var fundamental = 440.0 * Math.Pow(2.0, (note.MidiNote - 69) / 12.0);

            for (var i = startSample; i < endSample; i++)
            {
                var local = (i - startSample) / (double)rate;
                var duration = note.EndSeconds - note.StartSeconds;
                var normalized = Math.Clamp(local / Math.Max(duration, 1e-6), 0.0, 1.0);

                // Piano-like shape: fast hammer attack, short initial decay, then a low sustain tail.
                var attack = 1.0 - Math.Exp(-local / 0.006);
                var decay = 0.30 + 0.70 * Math.Exp(-local / 0.42);
                var release = normalized > 0.82
                    ? Math.Clamp((1.0 - normalized) / 0.18, 0.0, 1.0)
                    : 1.0;
                var envelope = attack * decay * release * note.Velocity;

                // Deterministic harmonic series approximates piano brightness without redistributing samples.
                var value =
                    Math.Sin(2.0 * Math.PI * fundamental * local) * 1.00 +
                    Math.Sin(2.0 * Math.PI * fundamental * 2.0 * local + 0.17) * 0.42 +
                    Math.Sin(2.0 * Math.PI * fundamental * 3.0 * local + 0.31) * 0.22 +
                    Math.Sin(2.0 * Math.PI * fundamental * 4.0 * local + 0.47) * 0.12 +
                    Math.Sin(2.0 * Math.PI * fundamental * 5.0 * local + 0.61) * 0.07;

                // Very short deterministic hammer transient adds broadband onset energy while remaining reproducible.
                if (local < 0.012)
                {
                    var transient = Math.Sin(2.0 * Math.PI * (fundamental * 7.3) * local) * (1.0 - local / 0.012);
                    value += transient * 0.10;
                }

                samples[i] += (float)(value * envelope * 0.30);
            }
        }

        // Soft normalization preserves chord ratios instead of hard clipping dense fixtures.
        var peak = samples.Select(Math.Abs).DefaultIfEmpty(0f).Max();
        if (peak > 0.92f)
        {
            var scale = 0.92f / peak;
            for (var i = 0; i < samples.Length; i++)
                samples[i] *= scale;
        }

        var reference = notes
            .Select(note => new AudioTranscriptionReferenceNote(
                TimeSpan.FromSeconds(note.StartSeconds),
                TimeSpan.FromSeconds(note.EndSeconds),
                note.MidiNote))
            .ToArray();
        return new CorpusFixture(name, samples, reference);
    }

    private static MemoryStream BuildMonoPcm16Wave(IReadOnlyList<float> samples, int sampleRate)
    {
        var stream = new MemoryStream(44 + samples.Count * 2);
        using (var writer = new BinaryWriter(stream, System.Text.Encoding.ASCII, leaveOpen: true))
        {
            var dataBytes = checked(samples.Count * 2);
            writer.Write(System.Text.Encoding.ASCII.GetBytes("RIFF"));
            writer.Write(36 + dataBytes);
            writer.Write(System.Text.Encoding.ASCII.GetBytes("WAVE"));
            writer.Write(System.Text.Encoding.ASCII.GetBytes("fmt "));
            writer.Write(16);
            writer.Write((short)1);
            writer.Write((short)1);
            writer.Write(sampleRate);
            writer.Write(sampleRate * 2);
            writer.Write((short)2);
            writer.Write((short)16);
            writer.Write(System.Text.Encoding.ASCII.GetBytes("data"));
            writer.Write(dataBytes);
            foreach (var sample in samples)
                writer.Write((short)Math.Round(Math.Clamp(sample, -1f, 1f) * short.MaxValue));
        }
        stream.Position = 0;
        return stream;
    }

    private sealed record NoteSpec(int MidiNote, double StartSeconds, double EndSeconds, double Velocity);
    private sealed record CorpusFixture(string Name, float[] Samples, IReadOnlyList<AudioTranscriptionReferenceNote> Reference);
}
