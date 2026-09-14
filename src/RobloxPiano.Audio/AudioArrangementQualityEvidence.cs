using System.Collections.ObjectModel;
using RobloxPiano.Core;

namespace RobloxPiano.Audio;

public enum AudioArrangementReferenceRole
{
    Melody,
    Harmony
}

public sealed record AudioArrangementReferenceNote
{
    public AudioArrangementReferenceNote(
        string section,
        AudioArrangementReferenceRole role,
        AudioTranscriptionReferenceNote note)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(section);
        ArgumentNullException.ThrowIfNull(note);
        Section = section.Trim();
        Role = role;
        Note = note;
    }

    public string Section { get; }
    public AudioArrangementReferenceRole Role { get; }
    public AudioTranscriptionReferenceNote Note { get; }
}

public sealed record AudioArrangementSectionEvidence(
    string Section,
    int RecognizedMelodyNotes,
    int RetainedMelodyNotes,
    double MelodyRetention,
    int RecognizedHarmonyNotes,
    int RetainedHarmonyNotes,
    double HarmonyRetention);

public sealed record AudioArrangementQualityEvidence(
    int ReferenceNotes,
    int SourceNotes,
    int ArrangedNotes,
    int SourceFalsePositives,
    int ArrangedFalsePositives,
    int RecognizedMelodyNotes,
    int RetainedMelodyNotes,
    double MelodyRetention,
    int RecognizedHarmonyNotes,
    int RetainedHarmonyNotes,
    double HarmonyRetention,
    double ClutterSuppression,
    double EventRetentionRatio,
    double MinimumSectionMelodyRetention,
    IReadOnlyDictionary<string, AudioArrangementSectionEvidence> Sections)
{
    public bool ArrangementAddedFalsePositives => ArrangedFalsePositives > SourceFalsePositives;
}

/// <summary>
/// Deterministic evidence-only evaluator for decoded Basic Pitch notes versus their arranged Roblox performance.
/// It measures what the arranger retained from notes the model actually recognized, rather than grading the arranger
/// for transcription misses that happened upstream. The evaluator never mutates or authorizes canonical playback.
/// Matching delegates to <see cref="AudioTranscriptionEvaluator"/> so onset/pitch semantics stay aligned with the
/// existing mir_eval-inspired corpus contract.
/// </summary>
public sealed class AudioArrangementQualityEvidenceEvaluator
{
    private readonly AudioTranscriptionEvaluator evaluator = new();

    public AudioArrangementQualityEvidence Evaluate(
        IReadOnlyList<AudioArrangementReferenceNote> reference,
        IReadOnlyList<BasicPitchTranscribedNote> sourceNotes,
        PerformanceTrack arrangedTrack,
        MidiKeyboardProfile? keyboardProfile = null,
        AudioTranscriptionEvaluationOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(reference);
        ArgumentNullException.ThrowIfNull(sourceNotes);
        ArgumentNullException.ThrowIfNull(arrangedTrack);
        if (reference.Count == 0)
            throw new ArgumentException("Arrangement evidence requires at least one labeled reference note.", nameof(reference));
        if (sourceNotes.Count == 0)
            throw new ArgumentException("Arrangement evidence requires at least one decoded source note.", nameof(sourceNotes));
        cancellationToken.ThrowIfCancellationRequested();

        var profile = keyboardProfile ?? MidiKeyboardProfile.RobloxClassic61;
        if (profile.Keys.Distinct().Count() != profile.Keys.Length)
            throw new ArgumentException("Arrangement evidence requires an unambiguous keyboard profile with unique keys.", nameof(keyboardProfile));

        options ??= new AudioTranscriptionEvaluationOptions(
            OnsetTolerance: TimeSpan.FromMilliseconds(150),
            RequireOffsetMatch: false);

        var arrangedNotes = ConvertTrackToNotes(arrangedTrack, profile, cancellationToken);
        var allReference = reference.Select(item => item.Note).ToArray();
        var sourceAll = evaluator.Evaluate(allReference, sourceNotes, options, cancellationToken);
        var arrangedAll = evaluator.Evaluate(allReference, arrangedNotes, options, cancellationToken);

        var melody = EvaluateRole(reference, AudioArrangementReferenceRole.Melody, sourceNotes, arrangedNotes, options, cancellationToken);
        var harmony = EvaluateRole(reference, AudioArrangementReferenceRole.Harmony, sourceNotes, arrangedNotes, options, cancellationToken);

        var sections = new Dictionary<string, AudioArrangementSectionEvidence>(StringComparer.Ordinal);
        foreach (var section in reference.Select(item => item.Section).Distinct(StringComparer.Ordinal).OrderBy(value => value, StringComparer.Ordinal))
        {
            cancellationToken.ThrowIfCancellationRequested();
            var sectionReference = reference.Where(item => string.Equals(item.Section, section, StringComparison.Ordinal)).ToArray();
            var sectionMelody = EvaluateRole(sectionReference, AudioArrangementReferenceRole.Melody, sourceNotes, arrangedNotes, options, cancellationToken);
            var sectionHarmony = EvaluateRole(sectionReference, AudioArrangementReferenceRole.Harmony, sourceNotes, arrangedNotes, options, cancellationToken);
            sections.Add(section, new AudioArrangementSectionEvidence(
                section,
                sectionMelody.Recognized,
                sectionMelody.Retained,
                sectionMelody.Retention,
                sectionHarmony.Recognized,
                sectionHarmony.Retained,
                sectionHarmony.Retention));
        }

        var sectionsWithRecognizedMelody = sections.Values.Where(item => item.RecognizedMelodyNotes > 0).ToArray();
        var minimumSectionMelodyRetention = sectionsWithRecognizedMelody.Length == 0
            ? 0d
            : sectionsWithRecognizedMelody.Min(item => item.MelodyRetention);
        var clutterSuppression = sourceAll.FalsePositives == 0
            ? 1d
            : Math.Clamp((sourceAll.FalsePositives - arrangedAll.FalsePositives) / (double)sourceAll.FalsePositives, 0d, 1d);

        return new AudioArrangementQualityEvidence(
            reference.Count,
            sourceNotes.Count,
            arrangedNotes.Count,
            sourceAll.FalsePositives,
            arrangedAll.FalsePositives,
            melody.Recognized,
            melody.Retained,
            melody.Retention,
            harmony.Recognized,
            harmony.Retained,
            harmony.Retention,
            clutterSuppression,
            arrangedNotes.Count / (double)sourceNotes.Count,
            minimumSectionMelodyRetention,
            new ReadOnlyDictionary<string, AudioArrangementSectionEvidence>(sections));
    }

    private RoleEvidence EvaluateRole(
        IReadOnlyList<AudioArrangementReferenceNote> reference,
        AudioArrangementReferenceRole role,
        IReadOnlyList<BasicPitchTranscribedNote> sourceNotes,
        IReadOnlyList<BasicPitchTranscribedNote> arrangedNotes,
        AudioTranscriptionEvaluationOptions options,
        CancellationToken cancellationToken)
    {
        var roleReference = reference.Where(item => item.Role == role).Select(item => item.Note).ToArray();
        if (roleReference.Length == 0)
            return new RoleEvidence(0, 0, 0d);

        var source = evaluator.Evaluate(roleReference, sourceNotes, options, cancellationToken);
        var arranged = evaluator.Evaluate(roleReference, arrangedNotes, options, cancellationToken);
        var recognizedReferenceIndexes = source.Matches.Select(match => match.ReferenceIndex).ToHashSet();
        var retained = arranged.Matches.Count(match => recognizedReferenceIndexes.Contains(match.ReferenceIndex));
        var retention = recognizedReferenceIndexes.Count == 0 ? 0d : retained / (double)recognizedReferenceIndexes.Count;
        return new RoleEvidence(recognizedReferenceIndexes.Count, retained, retention);
    }

    private static IReadOnlyList<BasicPitchTranscribedNote> ConvertTrackToNotes(
        PerformanceTrack track,
        MidiKeyboardProfile profile,
        CancellationToken cancellationToken)
    {
        var notes = new List<BasicPitchTranscribedNote>();
        foreach (var performanceEvent in track.Events)
        {
            cancellationToken.ThrowIfCancellationRequested();
            foreach (var key in performanceEvent.Keys)
            {
                var keyIndex = profile.Keys.IndexOf(key);
                if (keyIndex < 0)
                    throw new InvalidDataException($"Arranged performance contains key '{key}' outside the evidence keyboard profile.");
                notes.Add(new BasicPitchTranscribedNote(
                    performanceEvent.Start,
                    performanceEvent.Start + performanceEvent.Duration,
                    checked(profile.LowestMidiNote + keyIndex),
                    1f));
            }
        }

        if (notes.Count == 0)
            throw new InvalidDataException("Arranged performance contains no note events to evaluate.");
        return notes;
    }

    private sealed record RoleEvidence(int Recognized, int Retained, double Retention);
}
