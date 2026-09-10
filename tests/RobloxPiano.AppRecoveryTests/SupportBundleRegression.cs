using System.IO.Compression;
using System.Runtime.CompilerServices;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class SupportBundleRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        TestRecentRecordsIgnoreMalformedTailAndStayBounded();
        TestSupportDocumentRedactsLocalSourcePath();
        TestSupportBundleIsSendableAndPrivacySafe();
        Console.WriteLine("PASS  support bundle regressions (3)");
    }

    private static void TestRecentRecordsIgnoreMalformedTailAndStayBounded()
    {
        var directory = CreateTemporaryDirectory();
        try
        {
            var olderPath = Path.Combine(directory, "sessions-20260909.jsonl");
            var newestPath = Path.Combine(directory, "sessions-20260910.jsonl");
            PlaybackSessionDiagnostics.AppendRecord(olderPath, CreateRecord("old", DateTimeOffset.UnixEpoch.AddMinutes(1), "old.mid"));
            PlaybackSessionDiagnostics.AppendRecord(newestPath, CreateRecord("first", DateTimeOffset.UnixEpoch.AddMinutes(2), "first.mid"));
            File.AppendAllText(newestPath, "{interrupted-json" + Environment.NewLine);
            PlaybackSessionDiagnostics.AppendRecord(newestPath, CreateRecord("latest", DateTimeOffset.UnixEpoch.AddMinutes(3), "latest.mid"));

            var recent = PlaybackSessionDiagnostics.ReadRecentRecords(directory, 2);
            Equal(2, recent.Count, "bounded recent-session count");
            Equal("latest", recent[0].SessionId, "latest valid session must survive malformed JSONL line");
            Equal("first", recent[1].SessionId, "second newest valid session must be retained");
        }
        finally
        {
            Directory.Delete(directory, recursive: true);
        }
    }

    private static void TestSupportDocumentRedactsLocalSourcePath()
    {
        var sourcePath = Path.Combine(
            Environment.GetFolderPath(Environment.SpecialFolder.UserProfile),
            "Music",
            "private-folder",
            "support-song.mid");
        var record = CreateRecord(
            "privacy",
            DateTimeOffset.UnixEpoch.AddMinutes(4),
            sourcePath,
            exceptionMessage: $"Could not read {sourcePath}");

        var document = PlaybackSessionDiagnostics.CreateSupportDocument(
            new[] { record },
            DateTimeOffset.UnixEpoch.AddMinutes(5));

        Equal(1, document.SessionCount, "support session count");
        var session = document.Sessions[0];
        Equal("support-song.mid", session.SourceFileName!, "support bundle keeps only source filename");
        False(
            (session.ExceptionMessage ?? string.Empty).Contains(sourcePath, StringComparison.OrdinalIgnoreCase),
            "support exception must not expose the full source path");
        False(
            (session.ExceptionMessage ?? string.Empty).Contains("private-folder", StringComparison.OrdinalIgnoreCase),
            "support exception must not expose source parent folders");
    }

    private static void TestSupportBundleIsSendableAndPrivacySafe()
    {
        var directory = CreateTemporaryDirectory();
        try
        {
            var sourcePath = Path.Combine(directory, "private-client-path", "bundle-song.musicxml");
            var sessionPath = Path.Combine(directory, "sessions-20260910.jsonl");
            PlaybackSessionDiagnostics.AppendRecord(
                sessionPath,
                CreateRecord(
                    "bundle",
                    DateTimeOffset.UnixEpoch.AddMinutes(6),
                    sourcePath,
                    exceptionMessage: $"Parser rejected {sourcePath}"));

            var destination = Path.Combine(directory, "RobloxPiano-support-latest.zip");
            PlaybackSessionDiagnostics.CreateSupportBundle(
                directory,
                destination,
                DateTimeOffset.UnixEpoch.AddMinutes(7));

            True(File.Exists(destination), "support ZIP must be created");
            using var archive = ZipFile.OpenRead(destination);
            var support = archive.GetEntry("support.json")
                ?? throw new InvalidOperationException("support.json missing from bundle");
            _ = archive.GetEntry("README.txt")
                ?? throw new InvalidOperationException("README.txt missing from bundle");
            Equal(2, archive.Entries.Count, "bundle must not silently include raw JSONL/log files");

            using var reader = new StreamReader(support.Open());
            var json = reader.ReadToEnd();
            True(json.Contains("bundle-song.musicxml", StringComparison.Ordinal), "bundle should retain source filename for support correlation");
            False(json.Contains(sourcePath, StringComparison.OrdinalIgnoreCase), "bundle JSON must not contain the full local source path");
            False(json.Contains("private-client-path", StringComparison.OrdinalIgnoreCase), "bundle JSON must not contain source parent folders");
            False(json.Contains("sessions-20260910.jsonl", StringComparison.OrdinalIgnoreCase), "bundle must not embed raw diagnostic filenames");
        }
        finally
        {
            Directory.Delete(directory, recursive: true);
        }
    }

    private static PlaybackSessionDiagnosticRecord CreateRecord(
        string sessionId,
        DateTimeOffset endedAtUtc,
        string sourcePath,
        string? exceptionMessage = null)
        => new(
            PlaybackSessionDiagnostics.SchemaVersion,
            sessionId,
            endedAtUtc.AddSeconds(-3),
            endedAtUtc,
            PlaybackSessionResultKind.RuntimeFailed.ToString(),
            2.5d,
            null,
            sourcePath,
            Path.GetExtension(sourcePath).Equals(".musicxml", StringComparison.OrdinalIgnoreCase) ? "MusicXML" : "MIDI",
            1d,
            0,
            4242,
            638930000000000000L,
            typeof(InvalidOperationException).FullName,
            exceptionMessage,
            "0.20.0");

    private static string CreateTemporaryDirectory()
    {
        var path = Path.Combine(
            Path.GetTempPath(),
            "RobloxPiano-AppRecoveryTests",
            "support-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(path);
        return path;
    }

    private static void Equal<T>(T expected, T actual, string message) where T : notnull
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
        {
            throw new InvalidOperationException($"{message}: expected '{expected}', actual '{actual}'.");
        }
    }

    private static void True(bool condition, string message)
    {
        if (!condition)
        {
            throw new InvalidOperationException(message);
        }
    }

    private static void False(bool condition, string message) => True(!condition, message);
}
