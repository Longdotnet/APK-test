using System.Collections.ObjectModel;

namespace RobloxPiano.Audio;

public sealed record BasicPitchNoteDecoderOptions(
    float OnsetThreshold = 0.5f,
    float FrameThreshold = 0.3f,
    bool InferOnsets = true,
    int MinimumNoteLengthFrames = 11,
    int EnergyToleranceFrames = 11,
    bool UseMelodiaRecovery = true,
    bool IncludePitchBends = true,
    double? MinimumFrequencyHz = null,
    double? MaximumFrequencyHz = null)
{
    internal void Validate()
    {
        if (OnsetThreshold is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(OnsetThreshold));
        if (FrameThreshold is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(FrameThreshold));
        if (MinimumNoteLengthFrames < 0)
            throw new ArgumentOutOfRangeException(nameof(MinimumNoteLengthFrames));
        if (EnergyToleranceFrames < 1)
            throw new ArgumentOutOfRangeException(nameof(EnergyToleranceFrames));
        if (MinimumFrequencyHz is <= 0)
            throw new ArgumentOutOfRangeException(nameof(MinimumFrequencyHz));
        if (MaximumFrequencyHz is <= 0)
            throw new ArgumentOutOfRangeException(nameof(MaximumFrequencyHz));
        if (MinimumFrequencyHz is not null && MaximumFrequencyHz is not null && MinimumFrequencyHz >= MaximumFrequencyHz)
            throw new ArgumentException("Basic Pitch minimum frequency must be lower than maximum frequency.");
    }
}

/// <summary>
/// Immutable decoded Basic Pitch note event. Pitch bend values use Spotify's contour unit of one-third semitone.
/// </summary>
public sealed record BasicPitchTranscribedNote
{
    public BasicPitchTranscribedNote(
        TimeSpan start,
        TimeSpan end,
        int midiNote,
        float amplitude,
        IEnumerable<int>? pitchBendsThirdSemitones = null)
    {
        if (start < TimeSpan.Zero)
            throw new ArgumentOutOfRangeException(nameof(start));
        if (end <= start)
            throw new ArgumentOutOfRangeException(nameof(end));
        if (midiNote is < 0 or > 127)
            throw new ArgumentOutOfRangeException(nameof(midiNote));
        if (!float.IsFinite(amplitude) || amplitude is < 0f or > 1f)
            throw new ArgumentOutOfRangeException(nameof(amplitude));

        Start = start;
        End = end;
        MidiNote = midiNote;
        Amplitude = amplitude;
        PitchBendsThirdSemitones = Array.AsReadOnly((pitchBendsThirdSemitones ?? []).ToArray());
    }

    public TimeSpan Start { get; }
    public TimeSpan End { get; }
    public TimeSpan Duration => End - Start;
    public int MidiNote { get; }
    public float Amplitude { get; }
    public ReadOnlyCollection<int> PitchBendsThirdSemitones { get; }
}

/// <summary>
/// Deterministically ports Spotify Basic Pitch note_creation.py post-processing over raw model activations.
/// It does not create MIDI or own Roblox playback state.
/// </summary>
public sealed class BasicPitchNoteDecoder
{
    public const int MidiOffset = 21;
    public const int ContourBinsPerSemitone = 3;
    public const double AnnotationBaseFrequencyHz = 27.5;
    public const double MagicAlignmentOffsetSeconds = 0.0018;

    private const int PitchBendToleranceBins = 25;
    private const double PitchBendGaussianStandardDeviation = 5.0;

    public IReadOnlyList<BasicPitchTranscribedNote> Decode(
        BasicPitchRawOutput output,
        BasicPitchNoteDecoderOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(output);
        options ??= new BasicPitchNoteDecoderOptions();
        options.Validate();
        ValidateTensorContract(output);

        var frames = (float[])output.Notes.Values.Clone();
        var onsets = (float[])output.Onsets.Values.Clone();
        ApplyFrequencyConstraint(frames, onsets, output.Notes.Frames, options);

        if (options.InferOnsets)
            InferAdditionalOnsets(onsets, frames, output.Notes.Frames, cancellationToken);

        var frameNotes = DecodeFrameNotes(frames, onsets, output.Notes.Frames, options, cancellationToken);
        var result = new List<BasicPitchTranscribedNote>(frameNotes.Count);
        foreach (var note in frameNotes.OrderBy(note => note.StartFrame).ThenBy(note => note.MidiNote))
        {
            cancellationToken.ThrowIfCancellationRequested();
            var startSeconds = ModelFrameToSeconds(note.StartFrame);
            var endSeconds = ModelFrameToSeconds(note.EndFrame);
            if (startSeconds < 0)
                startSeconds = 0;
            if (endSeconds <= startSeconds)
                continue;

            var bends = options.IncludePitchBends
                ? GetPitchBends(output.Contours, note, cancellationToken)
                : Array.Empty<int>();
            result.Add(new BasicPitchTranscribedNote(
                TimeSpan.FromSeconds(startSeconds),
                TimeSpan.FromSeconds(endSeconds),
                note.MidiNote,
                Math.Clamp(note.Amplitude, 0f, 1f),
                bends));
        }

        return result.AsReadOnly();
    }

    public static double ModelFrameToSeconds(int frame)
    {
        if (frame < 0)
            throw new ArgumentOutOfRangeException(nameof(frame));

        var annotationFramesPerWindow = BasicPitchInferenceService.AnnotationFramesPerSecond * BasicPitchInferenceService.AudioWindowSeconds;
        var originalTime = frame * (BasicPitchInferenceService.FftHop / (double)BasicPitchInferenceService.RequiredSampleRate);
        var windowNumber = Math.Floor(frame / (double)annotationFramesPerWindow);
        var windowOffset = (BasicPitchInferenceService.FftHop / (double)BasicPitchInferenceService.RequiredSampleRate)
            * (annotationFramesPerWindow - (BasicPitchInferenceService.AudioWindowSamples / (double)BasicPitchInferenceService.FftHop))
            + MagicAlignmentOffsetSeconds;
        return originalTime - (windowOffset * windowNumber);
    }

    private static void ValidateTensorContract(BasicPitchRawOutput output)
    {
        if (output.Notes.Frames <= 0 || output.Notes.Bins != BasicPitchInferenceService.NoteBins)
            throw new InvalidDataException("Basic Pitch note tensor has an invalid shape.");
        if (output.Onsets.Frames != output.Notes.Frames || output.Onsets.Bins != BasicPitchInferenceService.NoteBins)
            throw new InvalidDataException("Basic Pitch onset tensor must match note tensor time/pitch dimensions.");
        if (output.Contours.Frames != output.Notes.Frames || output.Contours.Bins != BasicPitchInferenceService.ContourBins)
            throw new InvalidDataException("Basic Pitch contour tensor must match note tensor time dimension and contain 264 bins.");

        ValidateProbabilities(output.Notes, "note");
        ValidateProbabilities(output.Onsets, "onset");
        ValidateProbabilities(output.Contours, "contour");
    }

    private static void ValidateProbabilities(BasicPitchTensor tensor, string name)
    {
        if (tensor.Values.Length != checked(tensor.Frames * tensor.Bins))
            throw new InvalidDataException($"Basic Pitch {name} tensor value count does not match its declared shape.");
        if (tensor.Values.Any(value => !float.IsFinite(value) || value is < 0f or > 1f))
            throw new InvalidDataException($"Basic Pitch {name} tensor contains a non-probability activation.");
    }

    private static void ApplyFrequencyConstraint(
        float[] frames,
        float[] onsets,
        int frameCount,
        BasicPitchNoteDecoderOptions options)
    {
        var minimumBin = options.MinimumFrequencyHz is null
            ? 0
            : Math.Clamp((int)Math.Round(HertzToMidi(options.MinimumFrequencyHz.Value) - MidiOffset), 0, BasicPitchInferenceService.NoteBins);
        var maximumBin = options.MaximumFrequencyHz is null
            ? BasicPitchInferenceService.NoteBins
            : Math.Clamp((int)Math.Round(HertzToMidi(options.MaximumFrequencyHz.Value) - MidiOffset), 0, BasicPitchInferenceService.NoteBins);

        for (var frame = 0; frame < frameCount; frame++)
        {
            var offset = frame * BasicPitchInferenceService.NoteBins;
            for (var bin = 0; bin < minimumBin; bin++)
                frames[offset + bin] = onsets[offset + bin] = 0f;
            for (var bin = maximumBin; bin < BasicPitchInferenceService.NoteBins; bin++)
                frames[offset + bin] = onsets[offset + bin] = 0f;
        }
    }

    private static double HertzToMidi(double hz) => 69.0 + (12.0 * Math.Log2(hz / 440.0));

    private static void InferAdditionalOnsets(float[] onsets, float[] frames, int frameCount, CancellationToken cancellationToken)
    {
        var inferred = new float[onsets.Length];
        var maxOnset = onsets.Max();
        var maxDifference = 0f;

        for (var frame = 2; frame < frameCount; frame++)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var current = frame * BasicPitchInferenceService.NoteBins;
            var previous1 = (frame - 1) * BasicPitchInferenceService.NoteBins;
            var previous2 = (frame - 2) * BasicPitchInferenceService.NoteBins;
            for (var bin = 0; bin < BasicPitchInferenceService.NoteBins; bin++)
            {
                var diff1 = frames[current + bin] - frames[previous1 + bin];
                var diff2 = frames[current + bin] - frames[previous2 + bin];
                var difference = Math.Max(0f, Math.Min(diff1, diff2));
                inferred[current + bin] = difference;
                if (difference > maxDifference)
                    maxDifference = difference;
            }
        }

        if (maxDifference <= 0f || maxOnset <= 0f)
            return;

        var scale = maxOnset / maxDifference;
        for (var i = 0; i < onsets.Length; i++)
            onsets[i] = Math.Max(onsets[i], inferred[i] * scale);
    }

    private static List<FrameNote> DecodeFrameNotes(
        float[] frames,
        float[] onsets,
        int frameCount,
        BasicPitchNoteDecoderOptions options,
        CancellationToken cancellationToken)
    {
        var remainingEnergy = (float[])frames.Clone();
        var peaks = FindOnsetPeaks(onsets, frameCount, options.OnsetThreshold);
        var notes = new List<FrameNote>();

        for (var peakIndex = peaks.Count - 1; peakIndex >= 0; peakIndex--)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var (startFrame, bin) = peaks[peakIndex];
            if (startFrame >= frameCount - 1)
                continue;

            var endFrame = FindForwardEnd(remainingEnergy, frameCount, bin, startFrame + 1, options.FrameThreshold, options.EnergyToleranceFrames);
            if (endFrame - startFrame <= options.MinimumNoteLengthFrames)
                continue;

            ClearEnergy(remainingEnergy, startFrame, endFrame, bin);
            notes.Add(new FrameNote(startFrame, endFrame, bin + MidiOffset, Mean(frames, startFrame, endFrame, bin)));
        }

        if (options.UseMelodiaRecovery)
            RecoverMelodiaNotes(remainingEnergy, frames, frameCount, options, notes, cancellationToken);

        return notes;
    }

    private static List<(int Frame, int Bin)> FindOnsetPeaks(float[] onsets, int frameCount, float threshold)
    {
        var peaks = new List<(int Frame, int Bin)>();
        for (var frame = 1; frame < frameCount - 1; frame++)
        {
            var previous = (frame - 1) * BasicPitchInferenceService.NoteBins;
            var current = frame * BasicPitchInferenceService.NoteBins;
            var next = (frame + 1) * BasicPitchInferenceService.NoteBins;
            for (var bin = 0; bin < BasicPitchInferenceService.NoteBins; bin++)
            {
                var value = onsets[current + bin];
                if (value >= threshold && value > onsets[previous + bin] && value > onsets[next + bin])
                    peaks.Add((frame, bin));
            }
        }
        return peaks;
    }

    private static int FindForwardEnd(
        float[] energy,
        int frameCount,
        int bin,
        int startFrame,
        float frameThreshold,
        int energyTolerance)
    {
        var frame = startFrame;
        var below = 0;
        while (frame < frameCount - 1 && below < energyTolerance)
        {
            if (energy[(frame * BasicPitchInferenceService.NoteBins) + bin] < frameThreshold)
                below++;
            else
                below = 0;
            frame++;
        }
        return frame - below;
    }

    private static void RecoverMelodiaNotes(
        float[] remainingEnergy,
        float[] frames,
        int frameCount,
        BasicPitchNoteDecoderOptions options,
        List<FrameNote> notes,
        CancellationToken cancellationToken)
    {
        while (TryFindMaximum(remainingEnergy, options.FrameThreshold, out var middleFrame, out var bin))
        {
            cancellationToken.ThrowIfCancellationRequested();
            remainingEnergy[(middleFrame * BasicPitchInferenceService.NoteBins) + bin] = 0f;

            var forward = middleFrame + 1;
            var below = 0;
            while (forward < frameCount - 1 && below < options.EnergyToleranceFrames)
            {
                if (remainingEnergy[(forward * BasicPitchInferenceService.NoteBins) + bin] < options.FrameThreshold)
                    below++;
                else
                    below = 0;
                ClearEnergyAtFrame(remainingEnergy, forward, bin);
                forward++;
            }
            var endFrame = forward - 1 - below;

            var backward = middleFrame - 1;
            below = 0;
            while (backward > 0 && below < options.EnergyToleranceFrames)
            {
                if (remainingEnergy[(backward * BasicPitchInferenceService.NoteBins) + bin] < options.FrameThreshold)
                    below++;
                else
                    below = 0;
                ClearEnergyAtFrame(remainingEnergy, backward, bin);
                backward--;
            }
            var startFrame = backward + 1 + below;

            if (endFrame - startFrame <= options.MinimumNoteLengthFrames)
                continue;
            notes.Add(new FrameNote(startFrame, endFrame, bin + MidiOffset, Mean(frames, startFrame, endFrame, bin)));
        }
    }

    private static bool TryFindMaximum(float[] energy, float threshold, out int frame, out int bin)
    {
        var maximum = threshold;
        var maximumIndex = -1;
        for (var i = 0; i < energy.Length; i++)
        {
            if (energy[i] > maximum)
            {
                maximum = energy[i];
                maximumIndex = i;
            }
        }

        if (maximumIndex < 0)
        {
            frame = bin = -1;
            return false;
        }

        frame = maximumIndex / BasicPitchInferenceService.NoteBins;
        bin = maximumIndex % BasicPitchInferenceService.NoteBins;
        return true;
    }

    private static void ClearEnergy(float[] energy, int startFrame, int endFrame, int bin)
    {
        for (var frame = startFrame; frame < endFrame; frame++)
            ClearEnergyAtFrame(energy, frame, bin);
    }

    private static void ClearEnergyAtFrame(float[] energy, int frame, int bin)
    {
        var offset = frame * BasicPitchInferenceService.NoteBins;
        energy[offset + bin] = 0f;
        if (bin > 0)
            energy[offset + bin - 1] = 0f;
        if (bin < BasicPitchInferenceService.NoteBins - 1)
            energy[offset + bin + 1] = 0f;
    }

    private static float Mean(float[] frames, int startFrame, int endFrame, int bin)
    {
        var sum = 0d;
        for (var frame = startFrame; frame < endFrame; frame++)
            sum += frames[(frame * BasicPitchInferenceService.NoteBins) + bin];
        return (float)(sum / (endFrame - startFrame));
    }

    private static int[] GetPitchBends(BasicPitchTensor contours, FrameNote note, CancellationToken cancellationToken)
    {
        var centerBin = (int)Math.Round(MidiPitchToContourBin(note.MidiNote));
        var startBin = Math.Max(centerBin - PitchBendToleranceBins, 0);
        var endBin = Math.Min(contours.Bins, centerBin + PitchBendToleranceBins + 1);
        var gaussianStart = Math.Max(0, PitchBendToleranceBins - centerBin);
        var shift = PitchBendToleranceBins - Math.Max(0, PitchBendToleranceBins - centerBin);
        var bends = new int[note.EndFrame - note.StartFrame];

        for (var frame = note.StartFrame; frame < note.EndFrame; frame++)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var bestValue = float.NegativeInfinity;
            var bestRelative = 0;
            for (var contourBin = startBin; contourBin < endBin; contourBin++)
            {
                var gaussianIndex = gaussianStart + (contourBin - startBin);
                var x = gaussianIndex - PitchBendToleranceBins;
                var gaussian = Math.Exp(-(x * x) / (2.0 * PitchBendGaussianStandardDeviation * PitchBendGaussianStandardDeviation));
                var weighted = contours[frame, contourBin] * gaussian;
                if (weighted > bestValue)
                {
                    bestValue = (float)weighted;
                    bestRelative = contourBin - startBin;
                }
            }
            bends[frame - note.StartFrame] = bestRelative - shift;
        }
        return bends;
    }

    private static double MidiPitchToContourBin(int midiNote)
    {
        var hz = 440.0 * Math.Pow(2.0, (midiNote - 69.0) / 12.0);
        return 12.0 * ContourBinsPerSemitone * Math.Log2(hz / AnnotationBaseFrequencyHz);
    }

    private sealed record FrameNote(int StartFrame, int EndFrame, int MidiNote, float Amplitude);
}
