using System.Net;
using System.Net.Http;
using RobloxPiano.Audio;
using RobloxPiano.Core;
using RobloxPiano.Library;

namespace RobloxPiano.ReferenceVerificationTests;

internal static class Program
{
    public static async Task<int> Main()
    {
        var failures = new List<string>();
        await RunAsync("NAudio reference normalization is deterministic and bounded", ReferenceNormalizationAsync, failures);
        await RunAsync("online MIDI verifies against owned reference without persistence", CandidateVerificationAsync, failures);
        await RunAsync("one reference verifies a bounded candidate batch and isolates failures", BatchVerificationAsync, failures);
        await RunAsync("oversized candidate fails before download", OversizedCandidateFailsAsync, failures);
        await RunAsync("cancelled verification performs no work", CancellationFailsClosedAsync, failures);

        Console.WriteLine($"Reference verification regressions: {5 - failures.Count} passed, {failures.Count} failed.");
        foreach (var failure in failures)
            Console.Error.WriteLine(failure);
        return failures.Count == 0 ? 0 : 1;
    }

    private static Task ReferenceNormalizationAsync()
    {
        var root = Path.Combine(Path.GetTempPath(), "RobloxPiano-reference-test-" + Guid.NewGuid().ToString("N"));
        Directory.CreateDirectory(root);
        var path = Path.Combine(root, "reference.wav");
        try
        {
            File.WriteAllBytes(path, BuildImpulseWave(sampleRate: 44_100, seconds: 4));
            var service = new ReferenceAudioFileAnalysisService();
            var first = service.AnalyzeFile(path);
            var second = service.AnalyzeFile(path);

            Equal(ReferenceAudioFileAnalysisService.ReferenceSampleRate, first.SampleRate);
            Equal(1, first.ChannelCount);
            Equal(16, first.BitsPerSample);
            True(first.Onsets.Count >= 5, $"expected >=5 onsets, got {first.Onsets.Count}");
            Equal(first.ContentSha256, second.ContentSha256);
            Equal(first.FeatureSha256, second.FeatureSha256);

            using var cancelled = new CancellationTokenSource();
            cancelled.Cancel();
            Throws<OperationCanceledException>(() => service.AnalyzeFile(path, cancelled.Token));
        }
        finally
        {
            Directory.Delete(root, recursive: true);
        }
        return Task.CompletedTask;
    }

    private static async Task CandidateVerificationAsync()
    {
        var track = BuildTrack();
        var midi = PerformanceTrackMidiExporter.Export(track);
        using var http = new HttpClient(new StaticHandler(_ => new HttpResponseMessage(HttpStatusCode.OK)
        {
            Content = new ByteArrayContent(midi)
        }));
        var temp = Path.Combine(Path.GetTempPath(), "RobloxPiano-verify-test-" + Guid.NewGuid().ToString("N"));
        var service = new OnlineSongReferenceVerificationService(http, temp);
        var candidate = Candidate();
        var reference = BuildReference(track);

        var result = await service.VerifyAsync(candidate, reference);
        Equal(ReferenceCandidateVerdict.HighConfidence, result.Assessment.Verdict);
        True(ReferenceCandidateConfidencePolicy.Verify(result.Assessment), "assessment hash verification failed");
        True(ReferenceAudioTimelineAligner.Verify(result.Alignment), "alignment hash verification failed");
        True(!Directory.Exists(temp) || !Directory.EnumerateFileSystemEntries(temp).Any(), "verification left candidate data behind");
    }

    private static async Task BatchVerificationAsync()
    {
        var track = BuildTrack();
        var midi = PerformanceTrackMidiExporter.Export(track);
        var requests = 0;
        using var http = new HttpClient(new StaticHandler(request =>
        {
            requests++;
            if (request.RequestUri?.AbsolutePath.Contains("broken", StringComparison.OrdinalIgnoreCase) == true)
            {
                return new HttpResponseMessage(HttpStatusCode.InternalServerError)
                {
                    Content = new ByteArrayContent([0x00])
                };
            }

            return new HttpResponseMessage(HttpStatusCode.OK)
            {
                Content = new ByteArrayContent(midi)
            };
        }));
        var temp = Path.Combine(Path.GetTempPath(), "RobloxPiano-batch-verify-test-" + Guid.NewGuid().ToString("N"));
        var service = new OnlineSongReferenceVerificationService(http, temp);
        var reference = BuildReference(track);
        var candidates = new[]
        {
            Candidate("Lower metadata", "lower.mid", 50),
            Candidate("Broken candidate", "broken.mid", 999),
            Candidate("Higher metadata", "higher.mid", 200),
            Candidate("Outside bound", "outside.mid", 500)
        };

        var result = await service.VerifyBatchAsync(candidates, reference, maxCandidates: 3);

        Equal(3, result.AttemptedCount);
        Equal(3, requests);
        Equal(1, result.Failures.Count);
        Equal("Broken candidate", result.Failures[0].Candidate.Title);
        Equal(2, result.RankedVerifiedCandidates.Count);
        Equal("Higher metadata", result.RankedVerifiedCandidates[0].Candidate.Title);
        Equal("Lower metadata", result.RankedVerifiedCandidates[1].Candidate.Title);
        True(result.RankedVerifiedCandidates.All(item => item.Assessment.Verdict == ReferenceCandidateVerdict.HighConfidence), "valid batch candidates should be high confidence");
        True(result.RankedVerifiedCandidates.All(item => ReferenceCandidateConfidencePolicy.Verify(item.Assessment)), "ranked assessments must retain verified immutable evidence");
        True(!Directory.Exists(temp) || !Directory.EnumerateFileSystemEntries(temp).Any(), "batch verification left candidate data behind");
    }

    private static async Task OversizedCandidateFailsAsync()
    {
        using var http = new HttpClient(new StaticHandler(_ =>
        {
            var response = new HttpResponseMessage(HttpStatusCode.OK) { Content = new ByteArrayContent([0x00]) };
            response.Content.Headers.ContentLength = OnlineSongImportService.MaximumDownloadBytes + 1;
            return response;
        }));
        var service = new OnlineSongReferenceVerificationService(http);
        await ThrowsAsync<FormatException>(() => service.VerifyAsync(Candidate(), BuildReference(BuildTrack())));
    }

    private static async Task CancellationFailsClosedAsync()
    {
        var requests = 0;
        using var http = new HttpClient(new StaticHandler(_ =>
        {
            requests++;
            return new HttpResponseMessage(HttpStatusCode.OK) { Content = new ByteArrayContent([0x00]) };
        }));
        var service = new OnlineSongReferenceVerificationService(http);
        using var cancelled = new CancellationTokenSource();
        cancelled.Cancel();
        await ThrowsAsync<OperationCanceledException>(() => service.VerifyAsync(Candidate(), BuildReference(BuildTrack()), cancelled.Token));
        await ThrowsAsync<OperationCanceledException>(() => service.VerifyBatchAsync([Candidate()], BuildReference(BuildTrack()), cancellationToken: cancelled.Token));
        Equal(0, requests);
    }

    private static SongDiscoveryCandidate Candidate()
        => Candidate("Reference Candidate", "reference.mid", 120);

    private static SongDiscoveryCandidate Candidate(string title, string fileName, int score) => new(
        "wikimedia-commons",
        "Wikimedia Commons",
        title,
        "Test Artist",
        DiscoveredSongFormat.Midi,
        new Uri("https://upload.wikimedia.org/" + fileName),
        new Uri("https://commons.wikimedia.org/wiki/File:" + fileName),
        fileName,
        1024,
        Score: score);

    private static PerformanceTrack BuildTrack()
    {
        var events = Enumerable.Range(0, 8)
            .Select(index => new PerformanceEvent(
                TimeSpan.FromMilliseconds(index * 500),
                TimeSpan.FromMilliseconds(180),
                new[] { 'a' }))
            .ToArray();
        return new PerformanceTrack(
            "Reference Candidate",
            120d,
            4,
            TimeSpan.Zero,
            events,
            TimeSpan.FromMilliseconds(3_680));
    }

    private static ReferenceAudioAnalysis BuildReference(PerformanceTrack track)
    {
        var onsets = track.Events.Select(item => item.Start).ToArray();
        return new ReferenceAudioAnalysis(
            ReferenceAudioAnalysis.CurrentSchemaVersion,
            22_050,
            1,
            16,
            track.TimelineDuration,
            0.25d,
            0.8d,
            120d,
            onsets,
            new string('a', 64),
            new string('b', 64));
    }

    private static byte[] BuildImpulseWave(int sampleRate, int seconds)
    {
        var sampleCount = checked(sampleRate * seconds);
        var pcm = new short[sampleCount];
        var pulseLength = sampleRate / 50;
        for (var start = sampleRate / 4; start < sampleCount; start += sampleRate / 2)
        {
            for (var index = start; index < Math.Min(sampleCount, start + pulseLength); index++)
                pcm[index] = 26_000;
        }

        var dataBytes = checked(pcm.Length * 2);
        using var stream = new MemoryStream(44 + dataBytes);
        using var writer = new BinaryWriter(stream, System.Text.Encoding.ASCII, leaveOpen: true);
        writer.Write(System.Text.Encoding.ASCII.GetBytes("RIFF"));
        writer.Write(36 + dataBytes);
        writer.Write(System.Text.Encoding.ASCII.GetBytes("WAVEfmt "));
        writer.Write(16);
        writer.Write((short)1);
        writer.Write((short)1);
        writer.Write(sampleRate);
        writer.Write(sampleRate * 2);
        writer.Write((short)2);
        writer.Write((short)16);
        writer.Write(System.Text.Encoding.ASCII.GetBytes("data"));
        writer.Write(dataBytes);
        foreach (var sample in pcm)
            writer.Write(sample);
        writer.Flush();
        return stream.ToArray();
    }

    private static async Task RunAsync(string name, Func<Task> test, ICollection<string> failures)
    {
        try
        {
            await test();
        }
        catch (Exception exception)
        {
            failures.Add($"FAIL {name}: {exception}");
        }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"expected '{expected}', got '{actual}'");
    }

    private static void True(bool value, string message)
    {
        if (!value)
            throw new InvalidOperationException(message);
    }

    private static void Throws<T>(Action action) where T : Exception
    {
        try
        {
            action();
        }
        catch (T)
        {
            return;
        }
        throw new InvalidOperationException($"expected {typeof(T).Name}");
    }

    private static async Task ThrowsAsync<T>(Func<Task> action) where T : Exception
    {
        try
        {
            await action();
        }
        catch (T)
        {
            return;
        }
        throw new InvalidOperationException($"expected {typeof(T).Name}");
    }

    private sealed class StaticHandler(Func<HttpRequestMessage, HttpResponseMessage> responder) : HttpMessageHandler
    {
        protected override Task<HttpResponseMessage> SendAsync(HttpRequestMessage request, CancellationToken cancellationToken)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var response = responder(request);
            response.RequestMessage = request;
            return Task.FromResult(response);
        }
    }
}
