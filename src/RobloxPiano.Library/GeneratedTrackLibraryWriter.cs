using RobloxPiano.Core;

namespace RobloxPiano.Library;

public sealed record GeneratedTrackLibraryResult(
    string Path,
    PerformanceTrack RoundTrippedTrack,
    int NoteCount,
    long ByteCount);

/// <summary>
/// Commits generated canonical performances to the managed file library only after
/// the serialized SMF passes the production MIDI importer and note/timing parity checks.
/// </summary>
public sealed class GeneratedTrackLibraryWriter
{
    private readonly string _managedDirectory;

    public GeneratedTrackLibraryWriter(string managedDirectory)
    {
        ArgumentException.ThrowIfNullOrWhiteSpace(managedDirectory);
        _managedDirectory = Path.GetFullPath(managedDirectory);
    }

    public GeneratedTrackLibraryResult Add(PerformanceTrack track)
    {
        ArgumentNullException.ThrowIfNull(track);
        var bytes = PerformanceTrackMidiExporter.Export(track);
        var roundTripped = MidiFileImporter.ImportCompiled(bytes);
        ValidateRoundTrip(track, roundTripped);

        Directory.CreateDirectory(_managedDirectory);
        var destination = CreateCollisionSafeDestination(BuildFileName(track.Title));
        var temporary = Path.Combine(
            _managedDirectory,
            $".{Path.GetFileName(destination)}.{Guid.NewGuid():N}.tmp");
        try
        {
            File.WriteAllBytes(temporary, bytes);
            using (var stream = new FileStream(temporary, FileMode.Open, FileAccess.Read, FileShare.Read))
            {
                _ = MidiFileImporter.ImportCompiled(stream.ReadAllBytes());
            }
            File.Move(temporary, destination, overwrite: false);
        }
        finally
        {
            if (File.Exists(temporary))
                File.Delete(temporary);
        }

        return new GeneratedTrackLibraryResult(
            destination,
            roundTripped,
            Flatten(track).Count,
            bytes.LongLength);
    }

    internal static void ValidateRoundTrip(PerformanceTrack expected, PerformanceTrack actual)
    {
        ArgumentNullException.ThrowIfNull(expected);
        ArgumentNullException.ThrowIfNull(actual);
        var expectedNotes = Flatten(expected);
        var actualNotes = Flatten(actual);
        if (expectedNotes.Count != actualNotes.Count)
        {
            throw new InvalidDataException(
                $"Generated MIDI parity failed: expected {expectedNotes.Count} notes, production importer returned {actualNotes.Count}.");
        }

        var tolerance = PerformanceTrackMidiExporter.MaximumRoundTripTimingError(expected.Bpm)
            + TimeSpan.FromTicks(2);
        for (var index = 0; index < expectedNotes.Count; index++)
        {
            var source = expectedNotes[index];
            var imported = actualNotes[index];
            if (source.Key != imported.Key)
            {
                throw new InvalidDataException(
                    $"Generated MIDI parity failed at note {index}: expected key '{source.Key}', imported '{imported.Key}'.");
            }
            if ((source.Start - imported.Start).Duration() > tolerance
                || (source.End - imported.End).Duration() > tolerance)
            {
                throw new InvalidDataException(
                    $"Generated MIDI parity failed at note {index}: timing drift exceeded one MIDI tick.");
            }
        }
    }

    private static List<FlattenedNote> Flatten(PerformanceTrack track)
        => track.Events
            .SelectMany(item => item.Keys.Select(key => new FlattenedNote(
                key,
                checked(track.StartDelay + item.Start),
                checked(track.StartDelay + item.Start + item.Duration))))
            .OrderBy(item => item.Start)
            .ThenBy(item => item.Key)
            .ThenBy(item => item.End)
            .ToList();

    private static string BuildFileName(string? title)
    {
        var raw = string.IsNullOrWhiteSpace(title) ? "Audio transcription" : title.Trim();
        var invalid = Path.GetInvalidFileNameChars().ToHashSet();
        var safe = new string(raw.Select(character => invalid.Contains(character) ? '_' : character).ToArray()).Trim();
        if (safe.Length == 0)
            safe = "Audio transcription";
        if (safe.Length > 96)
            safe = safe[..96].TrimEnd();
        return $"{safe}.mid";
    }

    private string CreateCollisionSafeDestination(string fileName)
    {
        var candidate = Path.Combine(_managedDirectory, fileName);
        if (!File.Exists(candidate))
            return candidate;

        var stem = Path.GetFileNameWithoutExtension(fileName);
        for (var suffix = 2; suffix < 10000; suffix++)
        {
            candidate = Path.Combine(_managedDirectory, $"{stem} ({suffix}).mid");
            if (!File.Exists(candidate))
                return candidate;
        }
        throw new IOException("Could not allocate a unique filename for the generated piano version.");
    }

    private sealed record FlattenedNote(char Key, TimeSpan Start, TimeSpan End);
}

internal static class GeneratedTrackStreamExtensions
{
    public static byte[] ReadAllBytes(this Stream stream)
    {
        using var buffer = new MemoryStream();
        stream.CopyTo(buffer);
        return buffer.ToArray();
    }
}
