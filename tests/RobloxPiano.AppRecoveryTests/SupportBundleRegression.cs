using System.IO.Compression;
using System.Runtime.CompilerServices;
using System.Security.Cryptography;
using System.Text;
using System.Text.Json;
using RobloxPiano.App;

namespace RobloxPiano.AppRecoveryTests;

internal static class SupportBundleRegression
{
    [ModuleInitializer]
    internal static void Run()
    {
        TestRecentRecordsIgnoreMalformedTailAndStayBounded();
        TestSupportDocumentRedactsLocalSourcePathAndSummarizesOutcomes();
        TestTransportQualitySurvivesSupportProjection();
        TestSupportBundleIsSendablePrivacySafeAndSelfVerifying();
        TestSupportBundleVerificationRejectsTamperedPayload();
        Console.WriteLine("PASS  support bundle regressions (5)");
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

    private static void TestSupportDocumentRedactsLocalSourcePathAndSummarizesOutcomes()
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

        Equal("3", document.SchemaVersion, "support schema version");
        Equal(1, document.SessionCount, "support session count");
        Equal(1, document.OutcomeSummary.RuntimeFailed, "runtime failure summary");
        Equal(1, document.OutcomeSummary.TotalFailures, "total failure summary");
        True(!string.IsNullOrWhiteSpace(document.Environment.OperatingSystem), "OS evidence must be present");
        True(!string.IsNullOrWhiteSpace(document.Environment.ProcessArchitecture), "process architecture evidence must be present");
        True(!string.IsNullOrWhiteSpace(document.Environment.Runtime), "runtime evidence must be present");

        var session = document.Sessions[0];
        Equal("support-song.mid", session.SourceFileName!, "support bundle keeps only source filename");
        False(
            (session.ExceptionMessage ?? string.Empty).Contains(sourcePath, StringComparison.OrdinalIgnoreCase),
            "support exception must not expose the full source path");
        False(
            (session.ExceptionMessage ?? string.Empty).Contains("private-folder", StringComparison.OrdinalIgnoreCase),
            "support exception must not expose source parent folders");
    }

    private static void TestTransportQualitySurvivesSupportProjection()
    {
        var record = CreateRecord(
            "quality",
            DateTimeOffset.UnixEpoch.AddMinutes(5),
            Path.Combine("private", "quality.mid")) with
        {
            Quality = new PlaybackSessionQualityDiagnostic(
                1,
                3,
                2,
                42,
                0,
                7,
                0,
                1,
                125.5d,
                4,
                1.25d,
                2.5d,
                4.75d,
                0.3d,
                0.9d)
        };

        var document = PlaybackSessionDiagnostics.CreateSupportDocument(
            new[] { record },
            DateTimeOffset.UnixEpoch.AddMinutes(6));
        var quality = document.Sessions.Single().Quality
            ?? throw new InvalidOperationException("transport quality was dropped from support projection");

        Equal(3, quality.SegmentCount, "quality segment count");
        Equal(2, quality.SeekCount, "quality seek count");
        Equal(0, quality.UnexpectedMissingEdgeCount, "intentional seek omissions remain distinct from playback loss");
        Equal(7, quality.InterruptedEdgeCount, "interrupted edge count");
        Equal(2.5d, quality.P95AbsoluteTimingErrorMilliseconds, "quality p95 timing");
        Equal(0.9d, quality.MaxInputCallMilliseconds, "quality max input call");
    }

    private static void TestSupportBundleIsSendablePrivacySafeAndSelfVerifying()
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
            True(
                PlaybackSessionDiagnostics.VerifySupportBundle(destination, out var verificationError),
                $"fresh support bundle must self-verify: {verificationError}");

            using var archive = ZipFile.OpenRead(destination);
            var support = archive.GetEntry("support.json")
                ?? throw new InvalidOperationException("support.json missing from bundle");
            var manifestEntry = archive.GetEntry("manifest.json")
                ?? throw new InvalidOperationException("manifest.json missing from bundle");
            _ = archive.GetEntry("README.txt")
                ?? throw new InvalidOperationException("README.txt missing from bundle");
            Equal(3, archive.Entries.Count, "bundle must contain only the bounded support payload, manifest and README");

            string json;
            using (var reader = new StreamReader(support.Open()))
            {
                json = reader.ReadToEnd();
            }

            PlaybackSupportManifest manifest;
            using (var reader = new StreamReader(manifestEntry.Open()))
            {
                manifest = JsonSerializer.Deserialize<PlaybackSupportManifest>(reader.ReadToEnd(), new JsonSerializerOptions
                {
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                }) ?? throw new InvalidOperationException("manifest.json did not deserialize");
            }

            var supportBytes = Encoding.UTF8.GetBytes(json);
            var actualHash = Convert.ToHexString(SHA256.HashData(supportBytes)).ToLowerInvariant();
            Equal(actualHash, manifest.SupportJsonSha256, "manifest SHA-256 must cover exact support.json bytes");
            Equal((long)supportBytes.Length, manifest.SupportJsonBytes, "manifest byte length must cover exact support.json bytes");
            True(json.Contains("bundle-song.musicxml", StringComparison.Ordinal), "bundle should retain source filename for support correlation");
            False(json.Contains(sourcePath, StringComparison.OrdinalIgnoreCase), "bundle JSON must not contain the full local source path");
            False(json.Contains("private-client-path", StringComparison.OrdinalIgnoreCase), "bundle JSON must not contain source parent folders");
            False(json.Contains("sessions-20260910.jsonl", StringComparison.OrdinalIgnoreCase), "bundle must not embed raw diagnostic filenames");
            False(json.Contains(Environment.MachineName, StringComparison.OrdinalIgnoreCase), "bundle must not add machine-name identity");
            False(json.Contains(Environment.UserName, StringComparison.OrdinalIgnoreCase), "bundle must not add username identity");
        }
        finally
        {
            Directory.Delete(directory, recursive: true);
        }
    }

    private static void TestSupportBundleVerificationRejectsTamperedPayload()
    {
        var directory = CreateTemporaryDirectory();
        try
        {
            var sessionPath = Path.Combine(directory, "sessions-20260910.jsonl");
            PlaybackSessionDiagnostics.AppendRecord(
                sessionPath,
                CreateRecord("tamper", DateTimeOffset.UnixEpoch.AddMinutes(8), Path.Combine(directory, "tamper.mid")));

            var original = Path.Combine(directory, "original.zip");
            PlaybackSessionDiagnostics.CreateSupportBundle(directory, original, DateTimeOffset.UnixEpoch.AddMinutes(9));
            var tampered = Path.Combine(directory, "tampered.zip");
            CreateTamperedBundle(original, tampered);

            False(
                PlaybackSessionDiagnostics.VerifySupportBundle(tampered, out var error),
                "tampered support payload must fail deterministic verification");
            True(
                (error ?? string.Empty).Contains("SHA-256", StringComparison.OrdinalIgnoreCase),
                "tamper verdict should identify integrity mismatch");
        }
        finally
        {
            Directory.Delete(directory, recursive: true);
        }
    }

    private static void CreateTamperedBundle(string originalPath, string destinationPath)
    {
        using var original = ZipFile.OpenRead(originalPath);
        using var destination = ZipFile.Open(destinationPath, ZipArchiveMode.Create);

        foreach (var entry in original.Entries)
        {
            var copy = destination.CreateEntry(entry.FullName, CompressionLevel.Optimal);
            using var input = entry.Open();
            using var output = copy.Open();
            input.CopyTo(output);
            if (entry.FullName.Equals("support.json", StringComparison.Ordinal))
            {
                var tamper = Encoding.UTF8.GetBytes(" ");
                output.Write(tamper);
            }
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
            "0.23.0");

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
