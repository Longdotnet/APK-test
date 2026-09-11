using RobloxPiano.Audio;

internal static class BasicPitchHarmonicSuppressionRegression
{
    public static void WeakThirdHarmonicIsSuppressed()
    {
        var anchor = Note(60, 0.10, 1.10, 0.80f);
        var weakThirdHarmonic = Note(79, 0.11, 1.08, 0.30f); // 3x fundamental ~= +19.02 semitones.

        var result = new BasicPitchHarmonicSuppressor().Suppress([anchor, weakThirdHarmonic]);

        Equal(1, result.Notes.Count);
        Equal(60, result.Notes[0].MidiNote);
        Equal(1, result.Diagnostics.SuppressedNotes);
        Equal(3, result.Diagnostics.Suppressed[0].Harmonic);
        Equal(79, result.Diagnostics.Suppressed[0].Candidate.MidiNote);
        Equal(60, result.Diagnostics.Suppressed[0].Anchor.MidiNote);
    }

    public static void MusicalOctaveDoublingIsProtected()
    {
        var low = Note(60, 0.10, 1.10, 0.80f);
        var octave = Note(72, 0.10, 1.10, 0.25f);

        var result = new BasicPitchHarmonicSuppressor().Suppress([low, octave]);

        Equal(2, result.Notes.Count);
        Equal(0, result.Diagnostics.SuppressedNotes);
    }

    public static void StrongHarmonicIntervalIsPreservedAsIntentionalHarmony()
    {
        var low = Note(60, 0.10, 1.10, 0.70f);
        var strongNineteenth = Note(79, 0.10, 1.10, 0.50f);

        var result = new BasicPitchHarmonicSuppressor().Suppress([low, strongNineteenth]);

        Equal(2, result.Notes.Count);
        Equal(0, result.Diagnostics.SuppressedNotes);
    }

    public static void OffsetHarmonyIsPreserved()
    {
        var low = Note(60, 0.10, 1.20, 0.80f);
        var later = Note(79, 0.22, 1.20, 0.25f);

        var result = new BasicPitchHarmonicSuppressor().Suppress([low, later]);

        Equal(2, result.Notes.Count);
        Equal(0, result.Diagnostics.SuppressedNotes);
    }

    public static void ShortOverlapIsPreserved()
    {
        var low = Note(60, 0.10, 0.55, 0.80f);
        var candidate = Note(79, 0.11, 1.20, 0.25f);

        var result = new BasicPitchHarmonicSuppressor().Suppress([low, candidate]);

        Equal(2, result.Notes.Count);
        Equal(0, result.Diagnostics.SuppressedNotes);
    }

    public static void SuppressedCandidateCannotBecomeAnchor()
    {
        var fundamental = Note(40, 0.10, 1.10, 0.90f);
        var thirdHarmonic = Note(59, 0.10, 1.10, 0.35f);
        var ninthRelativeToFundamental = Note(78, 0.10, 1.10, 0.12f);

        var result = new BasicPitchHarmonicSuppressor().Suppress([fundamental, thirdHarmonic, ninthRelativeToFundamental]);

        True(result.Diagnostics.Suppressed.Any(item => item.Candidate.MidiNote == 59), "Weak third harmonic must be suppressed.");
        True(result.Diagnostics.Suppressed.All(item => item.Anchor.MidiNote != 59), "A suppressed candidate must never become a suppression anchor.");
    }

    public static void DisabledPolicyIsIdentity()
    {
        var notes = new[] { Note(60, 0.10, 1.10, 0.80f), Note(79, 0.10, 1.10, 0.20f) };
        var result = new BasicPitchHarmonicSuppressor().Suppress(
            notes,
            new BasicPitchHarmonicSuppressionOptions(Enabled: false));

        Equal(2, result.Notes.Count);
        Equal(0, result.Diagnostics.SuppressedNotes);
        Equal(60, result.Notes[0].MidiNote);
        Equal(79, result.Notes[1].MidiNote);
    }

    public static void PreCancellationStopsBeforeSuppression()
    {
        using var cts = new CancellationTokenSource();
        cts.Cancel();
        Throws<OperationCanceledException>(() => new BasicPitchHarmonicSuppressor().Suppress(
            [Note(60, 0.10, 1.10, 0.80f)],
            cancellationToken: cts.Token));
    }

    public static void InvalidPolicyFailsClosed()
    {
        Throws<ArgumentOutOfRangeException>(() => new BasicPitchHarmonicSuppressor().Suppress(
            [Note(60, 0.10, 1.10, 0.80f)],
            new BasicPitchHarmonicSuppressionOptions(MaximumCandidateToAnchorAmplitudeRatio: 1.1f)));
    }

    private static BasicPitchTranscribedNote Note(int midi, double start, double end, float amplitude) =>
        new(TimeSpan.FromSeconds(start), TimeSpan.FromSeconds(end), midi, amplitude);

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
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
