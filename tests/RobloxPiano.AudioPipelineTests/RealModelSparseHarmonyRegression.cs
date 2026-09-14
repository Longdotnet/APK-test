using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class RealModelSparseHarmonyRegression
{
    [ModuleInitializer]
    internal static void RunRealModelSparseHarmonyRegression()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath) || !File.Exists(modelPath))
            return;

        try
        {
            const int rate = BasicPitchInferenceService.RequiredSampleRate;
            var lead = BuildFixture(2.4,
                new NoteSpec(69, 0.25, 0.85),
                new NoteSpec(71, 0.95, 1.55),
                new NoteSpec(72, 1.65, 2.20));
            var accompaniment = BuildFixture(2.4,
                new NoteSpec(60, 0.25, 0.85),
                new NoteSpec(64, 0.95, 1.55),
                new NoteSpec(67, 1.65, 2.20));

            using var inference = new BasicPitchInferenceService(
                modelPath,
                new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));
            var decoder = new BasicPitchNoteDecoder();
            var suppressor = new BasicPitchHarmonicSuppressor();

            var leadDecoded = decoder.Decode(
                inference.Infer(new NormalizedAudio(lead, rate)),
                LeadDecoderOptions());
            var harmonyDecoded = decoder.Decode(
                inference.Infer(new NormalizedAudio(accompaniment, rate)),
                HarmonyDecoderOptions());

            var leadSuppressed = suppressor.Suppress(leadDecoded).Notes;
            var harmonySuppressed = suppressor.Suppress(harmonyDecoded).Notes;
            var selection = new SparseHarmonySelector().Select(leadSuppressed, harmonySuppressed);

            var expectedLead = new[] { 69, 71, 72 };
            var leadHits = expectedLead.Count(pitch => leadSuppressed.Any(note => note.MidiNote == pitch));
            True(leadHits == expectedLead.Length,
                $"Real-model lead regression: expected 3/3 protected lead pitches, got {leadHits}/3.");

            var expectedHarmony = new[] { 60, 64, 67 };
            var harmonyHits = expectedHarmony.Count(pitch => selection.Notes.Any(note => note.MidiNote == pitch));
            True(harmonyHits >= 2,
                $"Real-model sparse harmony should recover at least 2/3 reference support tones, got {harmonyHits}/3; selected={selection.Notes.Count}.");
            True(selection.Notes.Count <= leadSuppressed.Count * 2,
                $"Sparse harmony exceeded the two-notes-per-lead density contract: lead={leadSuppressed.Count}, harmony={selection.Notes.Count}.");
            True(selection.Notes.All(harmony => leadSuppressed.Any(leadNote =>
                Math.Abs((leadNote.Start - harmony.Start).TotalMilliseconds) <= 1 &&
                harmony.MidiNote <= leadNote.MidiNote - 3)),
                "Every selected real-model harmony note must remain onset-anchored below a protected lead note.");

            var merged = leadSuppressed
                .Concat(selection.Notes)
                .OrderBy(note => note.Start)
                .ThenBy(note => note.MidiNote)
                .ToArray();
            var arranged = new RobloxPianoArranger().Arrange(
                "real sparse harmony A/B",
                merged,
                new RobloxPianoArrangementOptions(
                    MaxSimultaneousNotes: 4,
                    MinimumDuration: TimeSpan.FromMilliseconds(20),
                    LowActivationThreshold: 0.15f));
            True(arranged.Track.Events.Count > 0);
            True(arranged.Diagnostics.ArrangedEvents <= leadSuppressed.Count + selection.Notes.Count,
                "Roblox arranger must not invent events beyond protected lead plus sparse harmony evidence.");

            Console.WriteLine(
                $"SPARSE_HARMONY_REAL_MODEL leadDecoded={leadDecoded.Count} leadProtected={leadSuppressed.Count} leadHits={leadHits}/3 " +
                $"harmonyDecoded={harmonyDecoded.Count} harmonySelected={selection.Notes.Count} harmonyHits={harmonyHits}/3 " +
                $"arranged={arranged.Diagnostics.ArrangedEvents}");
        }
        catch (Exception exception)
        {
            Environment.ExitCode = 1;
            Console.Error.WriteLine($"FAIL real-model separated sparse harmony A/B: {exception}");
        }
    }

    private static BasicPitchNoteDecoderOptions LeadDecoderOptions() => new(
        OnsetThreshold: 0.20f,
        FrameThreshold: 0.15f,
        MinimumNoteLengthFrames: 3,
        EnergyToleranceFrames: 8,
        UseMelodiaRecovery: true,
        IncludePitchBends: false);

    private static BasicPitchNoteDecoderOptions HarmonyDecoderOptions() => new(
        OnsetThreshold: 0.56f,
        FrameThreshold: 0.36f,
        MinimumNoteLengthFrames: 7,
        EnergyToleranceFrames: 8,
        UseMelodiaRecovery: false,
        IncludePitchBends: false,
        MinimumFrequencyHz: 65.41d,
        MaximumFrequencyHz: 1046.50d);

    private static float[] BuildFixture(double durationSeconds, params NoteSpec[] notes)
    {
        var rate = BasicPitchInferenceService.RequiredSampleRate;
        var samples = new float[checked((int)Math.Round(durationSeconds * rate))];
        const double attackSeconds = 0.015;
        const double releaseSeconds = 0.025;

        foreach (var note in notes)
        {
            var startSample = Math.Max(0, (int)Math.Round(note.StartSeconds * rate));
            var endSample = Math.Min(samples.Length, (int)Math.Round(note.EndSeconds * rate));
            var frequency = 440.0 * Math.Pow(2.0, (note.MidiNote - 69) / 12.0);
            for (var i = startSample; i < endSample; i++)
            {
                var localSeconds = (i - startSample) / (double)rate;
                var remainingSeconds = (endSample - i) / (double)rate;
                var envelope = Math.Min(
                    Math.Min(1.0, localSeconds / attackSeconds),
                    Math.Min(1.0, remainingSeconds / releaseSeconds));
                samples[i] += (float)(Math.Sin(2.0 * Math.PI * frequency * localSeconds) * 0.42 * envelope);
            }
        }

        for (var i = 0; i < samples.Length; i++)
            samples[i] = Math.Clamp(samples[i], -0.95f, 0.95f);
        return samples;
    }

    private sealed record NoteSpec(int MidiNote, double StartSeconds, double EndSeconds);

    private static void True(bool condition, string? message = null)
    {
        if (!condition)
            throw new InvalidOperationException(message ?? "Expected condition to be true.");
    }
}
