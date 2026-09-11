using RobloxPiano.Audio;

internal static class BasicPitchDecoderRegression
{
    public static void OnsetEnergyParityFixture()
    {
        const int frames = 32;
        const int midi = 60;
        var bin = midi - BasicPitchNoteDecoder.MidiOffset;
        var raw = EmptyRaw(frames);
        raw.Onsets.Values[(2 * BasicPitchInferenceService.NoteBins) + bin] = 0.9f;
        for (var frame = 2; frame <= 20; frame++)
            raw.Notes.Values[(frame * BasicPitchInferenceService.NoteBins) + bin] = 0.8f;

        var notes = new BasicPitchNoteDecoder().Decode(raw, new BasicPitchNoteDecoderOptions(
            InferOnsets: false,
            MinimumNoteLengthFrames: 3,
            EnergyToleranceFrames: 2,
            UseMelodiaRecovery: false,
            IncludePitchBends: false));

        Equal(1, notes.Count);
        Equal(midi, notes[0].MidiNote);
        Nearly(0.8f, notes[0].Amplitude, 0.0001f);
        Nearly(BasicPitchNoteDecoder.ModelFrameToSeconds(2), notes[0].Start.TotalSeconds, 0.000001);
        Nearly(BasicPitchNoteDecoder.ModelFrameToSeconds(21), notes[0].End.TotalSeconds, 0.000001);
        Equal(0, notes[0].PitchBendsThirdSemitones.Count);
    }

    public static void InferredOnsetRecoversSharpAttack()
    {
        const int frames = 32;
        const int midi = 64;
        var bin = midi - BasicPitchNoteDecoder.MidiOffset;
        var raw = EmptyRaw(frames);
        raw.Onsets.Values[(1 * BasicPitchInferenceService.NoteBins) + bin] = 0.8f; // establishes Spotify rescale maximum.
        for (var frame = 6; frame <= 22; frame++)
            raw.Notes.Values[(frame * BasicPitchInferenceService.NoteBins) + bin] = 0.75f;

        var withoutInference = new BasicPitchNoteDecoder().Decode(raw, new BasicPitchNoteDecoderOptions(
            InferOnsets: false,
            MinimumNoteLengthFrames: 3,
            EnergyToleranceFrames: 2,
            UseMelodiaRecovery: false,
            IncludePitchBends: false));
        Equal(0, withoutInference.Count);

        var withInference = new BasicPitchNoteDecoder().Decode(raw, new BasicPitchNoteDecoderOptions(
            InferOnsets: true,
            MinimumNoteLengthFrames: 3,
            EnergyToleranceFrames: 2,
            UseMelodiaRecovery: false,
            IncludePitchBends: false));

        Equal(1, withInference.Count);
        Equal(midi, withInference[0].MidiNote);
        Nearly(BasicPitchNoteDecoder.ModelFrameToSeconds(6), withInference[0].Start.TotalSeconds, 0.000001);
    }

    public static void MelodiaRecoversSustainedEnergyWithoutOnset()
    {
        const int frames = 36;
        const int midi = 67;
        var bin = midi - BasicPitchNoteDecoder.MidiOffset;
        var raw = EmptyRaw(frames);
        for (var frame = 5; frame <= 25; frame++)
            raw.Notes.Values[(frame * BasicPitchInferenceService.NoteBins) + bin] = 0.7f;

        var notes = new BasicPitchNoteDecoder().Decode(raw, new BasicPitchNoteDecoderOptions(
            InferOnsets: false,
            MinimumNoteLengthFrames: 3,
            EnergyToleranceFrames: 2,
            UseMelodiaRecovery: true,
            IncludePitchBends: false));

        Equal(1, notes.Count);
        Equal(midi, notes[0].MidiNote);
        Nearly(0.7f, notes[0].Amplitude, 0.0001f);
        True(notes[0].Duration > TimeSpan.Zero, "Melodia recovery must create a positive note duration.");
    }

    public static void PitchBendUsesSpotifyThirdSemitoneBins()
    {
        const int frames = 30;
        const int midi = 69;
        var noteBin = midi - BasicPitchNoteDecoder.MidiOffset;
        var contourCenter = (midi - BasicPitchNoteDecoder.MidiOffset) * BasicPitchNoteDecoder.ContourBinsPerSemitone;
        var raw = EmptyRaw(frames);
        raw.Onsets.Values[(3 * BasicPitchInferenceService.NoteBins) + noteBin] = 0.9f;
        for (var frame = 3; frame <= 18; frame++)
        {
            raw.Notes.Values[(frame * BasicPitchInferenceService.NoteBins) + noteBin] = 0.8f;
            raw.Contours.Values[(frame * BasicPitchInferenceService.ContourBins) + contourCenter + 1] = 1.0f;
        }

        var notes = new BasicPitchNoteDecoder().Decode(raw, new BasicPitchNoteDecoderOptions(
            InferOnsets: false,
            MinimumNoteLengthFrames: 3,
            EnergyToleranceFrames: 2,
            UseMelodiaRecovery: false,
            IncludePitchBends: true));

        Equal(1, notes.Count);
        True(notes[0].PitchBendsThirdSemitones.Count > 0, "Pitch bend trace must cover the decoded note.");
        True(notes[0].PitchBendsThirdSemitones.All(value => value == 1), "A contour one bin sharp must decode as +1 third-semitone unit.");
    }

    public static void FrequencyConstraintFailsClosedOutsideRequestedBand()
    {
        const int frames = 30;
        const int midi = 48;
        var bin = midi - BasicPitchNoteDecoder.MidiOffset;
        var raw = EmptyRaw(frames);
        raw.Onsets.Values[(3 * BasicPitchInferenceService.NoteBins) + bin] = 0.95f;
        for (var frame = 3; frame <= 18; frame++)
            raw.Notes.Values[(frame * BasicPitchInferenceService.NoteBins) + bin] = 0.8f;

        var notes = new BasicPitchNoteDecoder().Decode(raw, new BasicPitchNoteDecoderOptions(
            InferOnsets: false,
            MinimumNoteLengthFrames: 3,
            EnergyToleranceFrames: 2,
            UseMelodiaRecovery: true,
            IncludePitchBends: false,
            MinimumFrequencyHz: 440.0));

        Equal(0, notes.Count);
    }

    public static void InvalidTensorProbabilityIsRejected()
    {
        var raw = EmptyRaw(8);
        raw.Notes.Values[0] = float.NaN;
        Throws<InvalidDataException>(() => new BasicPitchNoteDecoder().Decode(raw));
    }

    private static BasicPitchRawOutput EmptyRaw(int frames) => new(
        new BasicPitchTensor(new float[frames * BasicPitchInferenceService.NoteBins], frames, BasicPitchInferenceService.NoteBins),
        new BasicPitchTensor(new float[frames * BasicPitchInferenceService.NoteBins], frames, BasicPitchInferenceService.NoteBins),
        new BasicPitchTensor(new float[frames * BasicPitchInferenceService.ContourBins], frames, BasicPitchInferenceService.ContourBins));

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
    }

    private static void Nearly(float expected, float actual, float tolerance)
    {
        if (Math.Abs(expected - actual) > tolerance)
            throw new InvalidOperationException($"Expected approximately {expected}, actual {actual}.");
    }

    private static void Nearly(double expected, double actual, double tolerance)
    {
        if (Math.Abs(expected - actual) > tolerance)
            throw new InvalidOperationException($"Expected approximately {expected}, actual {actual}.");
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
            throw new InvalidOperationException(message);
    }

    private static void Throws<TException>(Action action) where TException : Exception
    {
        try
        {
            action();
        }
        catch (TException)
        {
            return;
        }

        throw new InvalidOperationException($"Expected {typeof(TException).Name}.");
    }
}
