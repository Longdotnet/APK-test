using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class SectionAwareStemComposerRegression
{
    [ModuleInitializer]
    internal static void RunPhaseZeroRegressions()
    {
        Run("section-aware stem composition keeps vocal-led sections clean", VocalSectionsRemainAuthoritative);
        Run("section-aware stem composition recovers sustained instrumental hooks", SustainedVocalGapAdmitsAccompaniment);
        Run("section-aware stem composition rejects isolated accompaniment bursts", IsolatedBurstDoesNotLeak);
        Run("section-aware stem composition peak protection is bounded", PeakProtectionIsBounded);
        Run("section-aware stem composition honors cancellation", CancellationStopsComposition);
        Run("real Basic Pitch keeps vocal melody and recovers separated instrumental hook", RealModelRecoversHookWithoutLosingVocalMelody);
    }

    private static void VocalSectionsRemainAuthoritative()
    {
        const int sampleRate = 1000;
        var vocals = Constant(sampleRate, seconds: 2, amplitude: 0.12f);
        var accompaniment = Constant(sampleRate, seconds: 2, amplitude: 0.20f);
        var result = new SectionAwareStemComposer().Compose(vocals, accompaniment, Options());

        Equal(0, result.Diagnostics.FallbackWindows);
        True(ReferenceEquals(vocals, result.Audio), "No-fallback path should avoid allocating another full-song buffer.");
    }

    private static void SustainedVocalGapAdmitsAccompaniment()
    {
        const int sampleRate = 1000;
        var vocalSamples = new float[sampleRate * 3];
        var accompanimentSamples = new float[vocalSamples.Length];
        Fill(vocalSamples, 0, sampleRate, 0.12f);
        Fill(vocalSamples, sampleRate * 2, sampleRate * 3, 0.12f);
        Fill(accompanimentSamples, sampleRate, sampleRate * 2, 0.20f);

        var result = new SectionAwareStemComposer().Compose(
            new NormalizedAudio(vocalSamples, sampleRate),
            new NormalizedAudio(accompanimentSamples, sampleRate),
            Options());

        True(result.Diagnostics.FallbackWindows >= 2, "A sustained one-second vocal gap should admit the separated accompaniment hook.");
        True(result.Diagnostics.FallbackDuration >= TimeSpan.FromMilliseconds(800));
        True(Math.Abs(result.Audio.Samples[1500]) > 0.02f, "Fallback audio should be audible inside the sustained vocal gap.");
        True(Math.Abs(result.Audio.Samples[500] - 0.12f) < 0.01f, "Lead-vocal region must remain essentially unchanged.");
    }

    private static void IsolatedBurstDoesNotLeak()
    {
        const int sampleRate = 1000;
        var vocalSamples = new float[sampleRate * 2];
        var accompanimentSamples = new float[vocalSamples.Length];
        Fill(accompanimentSamples, 400, 800, 0.20f);

        var options = Options() with
        {
            WindowDuration = TimeSpan.FromMilliseconds(400),
            MinimumConsecutiveFallbackWindows = 2
        };
        var result = new SectionAwareStemComposer().Compose(
            new NormalizedAudio(vocalSamples, sampleRate),
            new NormalizedAudio(accompanimentSamples, sampleRate),
            options);

        Equal(0, result.Diagnostics.FallbackWindows);
        True(result.Audio.Samples.All(sample => Math.Abs(sample) < 0.0001f),
            "A single short accompaniment burst should not become melody truth.");
    }

    private static void PeakProtectionIsBounded()
    {
        const int sampleRate = 1000;
        var vocals = Constant(sampleRate, seconds: 2, amplitude: 0.015f);
        var accompaniment = Constant(sampleRate, seconds: 2, amplitude: 1.0f);
        var result = new SectionAwareStemComposer().Compose(
            vocals,
            accompaniment,
            Options() with { MaximumPeak = 0.20f, AccompanimentGain = 0.40f });

        True(result.Diagnostics.UsedAccompanimentFallback);
        True(result.Diagnostics.AppliedNormalizationGain < 1f);
        True(result.Audio.Samples.Max(sample => Math.Abs(sample)) <= 0.2001f);
    }

    private static void CancellationStopsComposition()
    {
        const int sampleRate = 1000;
        using var cancellation = new CancellationTokenSource();
        cancellation.Cancel();
        try
        {
            new SectionAwareStemComposer().Compose(
                Constant(sampleRate, 2, 0f),
                Constant(sampleRate, 2, 0.2f),
                Options(),
                cancellation.Token);
            throw new InvalidOperationException("Expected cancellation.");
        }
        catch (OperationCanceledException)
        {
        }
    }

    private static void RealModelRecoversHookWithoutLosingVocalMelody()
    {
        var modelPath = Environment.GetEnvironmentVariable("BASIC_PITCH_MODEL_PATH");
        if (string.IsNullOrWhiteSpace(modelPath))
        {
            Console.WriteLine("SKIP section-aware real-model A/B because BASIC_PITCH_MODEL_PATH is not configured.");
            return;
        }

        var sampleRate = BasicPitchInferenceService.RequiredSampleRate;
        var durationSeconds = 4.8d;
        var length = checked((int)Math.Round(durationSeconds * sampleRate));
        var vocalSamples = new float[length];
        var accompanimentSamples = new float[length];

        // Vocal-led body: three-note melodic identity.
        AddTone(vocalSamples, sampleRate, midi: 69, startSeconds: 1.25d, endSeconds: 1.85d, amplitude: 0.46f);
        AddTone(vocalSamples, sampleRate, midi: 71, startSeconds: 2.00d, endSeconds: 2.60d, amplitude: 0.46f);
        AddTone(vocalSamples, sampleRate, midi: 72, startSeconds: 2.75d, endSeconds: 3.35d, amplitude: 0.46f);

        // Instrumental identity around the vocal section. Continuous note coverage deliberately spans
        // multiple 400 ms windows so short drum-like bursts cannot satisfy the fallback contract.
        AddTone(accompanimentSamples, sampleRate, midi: 64, startSeconds: 0.05d, endSeconds: 0.62d, amplitude: 0.48f);
        AddTone(accompanimentSamples, sampleRate, midi: 67, startSeconds: 0.62d, endSeconds: 1.18d, amplitude: 0.48f);
        AddTone(accompanimentSamples, sampleRate, midi: 67, startSeconds: 3.45d, endSeconds: 4.05d, amplitude: 0.48f);
        AddTone(accompanimentSamples, sampleRate, midi: 64, startSeconds: 4.05d, endSeconds: 4.65d, amplitude: 0.48f);

        var vocals = new NormalizedAudio(vocalSamples, sampleRate);
        var accompaniment = new NormalizedAudio(accompanimentSamples, sampleRate);
        var composition = new SectionAwareStemComposer().Compose(vocals, accompaniment);
        True(composition.Diagnostics.FallbackWindows >= 4,
            $"Expected sustained intro/outro fallback windows, got {composition.Diagnostics.FallbackWindows}.");

        using var inference = new BasicPitchInferenceService(
            modelPath,
            new BasicPitchInferenceOptions(MaxChunksPerBatch: 2));
        var decoder = new BasicPitchNoteDecoder();
        var decoderOptions = new BasicPitchNoteDecoderOptions(
            OnsetThreshold: 0.45f,
            FrameThreshold: 0.25f,
            MinimumNoteLengthFrames: 5,
            IncludePitchBends: false);

        var vocalNotes = decoder.Decode(inference.Infer(vocals), decoderOptions);
        var composedNotes = decoder.Decode(inference.Infer(composition.Audio), decoderOptions);

        var leadPitches = new[] { 69, 71, 72 };
        var vocalLeadHits = leadPitches.Count(pitch => vocalNotes.Any(note => note.MidiNote == pitch));
        var composedLeadHits = leadPitches.Count(pitch => composedNotes.Any(note => note.MidiNote == pitch));
        var hookPitches = new[] { 64, 67 };
        var vocalHookHits = hookPitches.Count(pitch => vocalNotes.Any(note => note.MidiNote == pitch));
        var composedHookHits = hookPitches.Count(pitch => composedNotes.Any(note => note.MidiNote == pitch));

        True(vocalLeadHits >= 2, $"Vocals-only control should recognize the lead identity; hits={vocalLeadHits}/3.");
        True(composedLeadHits >= vocalLeadHits,
            $"Section fallback must not lose vocal melody identity: vocal={vocalLeadHits}/3 composed={composedLeadHits}/3.");
        True(composedHookHits > vocalHookHits,
            $"Section fallback should recover instrumental hook pitch evidence: vocal={vocalHookHits}/2 composed={composedHookHits}/2.");
        True(composedNotes.Count <= vocalNotes.Count + 14,
            $"Section fallback must remain bounded instead of recreating full-mix note spray: vocal={vocalNotes.Count}, composed={composedNotes.Count}.");

        Console.WriteLine(
            $"SECTION_AWARE_REAL_MODEL_AB vocalNotes={vocalNotes.Count} composedNotes={composedNotes.Count} " +
            $"leadHits={vocalLeadHits}/3->{composedLeadHits}/3 hookHits={vocalHookHits}/2->{composedHookHits}/2 " +
            $"fallbackWindows={composition.Diagnostics.FallbackWindows}/{composition.Diagnostics.Windows} " +
            $"fallbackSeconds={composition.Diagnostics.FallbackDuration.TotalSeconds:F1}");
    }

    private static SectionAwareStemCompositionOptions Options() => new(
        WindowDuration: TimeSpan.FromMilliseconds(400),
        MinimumConsecutiveFallbackWindows: 2,
        MaximumVocalRms: 0.02f,
        MinimumAccompanimentRms: 0.01f,
        MinimumAccompanimentToVocalRatio: 1.4d,
        AccompanimentGain: 0.24f,
        MaximumPeak: 0.98f,
        Attack: TimeSpan.Zero,
        Release: TimeSpan.Zero);

    private static NormalizedAudio Constant(int sampleRate, int seconds, float amplitude)
    {
        var samples = Enumerable.Repeat(amplitude, sampleRate * seconds).ToArray();
        return new NormalizedAudio(samples, sampleRate);
    }

    private static void AddTone(
        float[] samples,
        int sampleRate,
        int midi,
        double startSeconds,
        double endSeconds,
        float amplitude)
    {
        var start = Math.Max(0, checked((int)Math.Round(startSeconds * sampleRate)));
        var end = Math.Min(samples.Length, checked((int)Math.Round(endSeconds * sampleRate)));
        var frequency = 440d * Math.Pow(2d, (midi - 69) / 12d);
        var ramp = Math.Max(1, sampleRate / 100);
        for (var index = start; index < end; index++)
        {
            var local = index - start;
            var remaining = end - index - 1;
            var envelope = Math.Min(1d, Math.Min(local / (double)ramp, remaining / (double)ramp));
            samples[index] += (float)(Math.Sin(2d * Math.PI * frequency * index / sampleRate) * amplitude * Math.Max(0d, envelope));
        }
    }

    private static void Fill(float[] samples, int start, int end, float value)
    {
        for (var index = start; index < end; index++)
            samples[index] = value;
    }

    private static void Run(string name, Action action)
    {
        try
        {
            action();
            Console.WriteLine($"PASS {name}");
        }
        catch (Exception exception)
        {
            Console.Error.WriteLine($"FAIL {name}: {exception}");
            Environment.ExitCode = 1;
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, got {actual}.");
    }

    private static void True(bool value, string? message = null)
    {
        if (!value)
            throw new InvalidOperationException(message ?? "Expected condition to be true.");
    }
}
