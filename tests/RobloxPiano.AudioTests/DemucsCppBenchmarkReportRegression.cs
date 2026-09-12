using System.Runtime.CompilerServices;
using RobloxPiano.Audio;

internal static class DemucsCppBenchmarkReportRegression
{
    [ModuleInitializer]
    internal static void RunPhase32Regressions()
    {
        Run("demucs benchmark report is deterministic across corpus and case ordering", OrderingDoesNotChangeReportIdentity);
        Run("demucs benchmark report excludes machine-local paths", ReportExcludesLocalPaths);
        Run("demucs benchmark report hash changes when measured evidence changes", MeasuredEvidenceChangesReportHash);
        Run("demucs benchmark report rejects provenance/measurement identity mismatch", ProvenanceCaseMismatchFailsClosed);
    }

    private static void OrderingDoesNotChangeReportIdentity()
    {
        var first = DemucsCppBenchmarkReportWriter.Create(BuildRun(reverse: false));
        var second = DemucsCppBenchmarkReportWriter.Create(BuildRun(reverse: true));
        Equal(first.Json, second.Json);
        Equal(first.ReportSha256, second.ReportSha256);
        Equal(DemucsCppBenchmarkReportWriter.CurrentSchemaVersion, first.SchemaVersion);
        True(first.ReportSha256.Length == 64, "Report SHA-256 must be full lowercase hex.");
    }

    private static void ReportExcludesLocalPaths()
    {
        var report = DemucsCppBenchmarkReportWriter.Create(BuildRun(reverse: false));
        True(!report.Json.Contains("C:\\\\bench", StringComparison.OrdinalIgnoreCase), "Report must not leak machine-local corpus paths.");
        True(report.Json.Contains("corpus-a", StringComparison.Ordinal), "Report should retain stable corpus identity.");
        True(report.Json.Contains("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", StringComparison.Ordinal), "Report should retain corpus content hash.");
    }

    private static void MeasuredEvidenceChangesReportHash()
    {
        var baseline = DemucsCppBenchmarkReportWriter.Create(BuildRun(reverse: false));
        var changed = DemucsCppBenchmarkReportWriter.Create(BuildRun(reverse: false, candidateF1Override: 0.75));
        True(!string.Equals(baseline.ReportSha256, changed.ReportSha256, StringComparison.Ordinal), "Changed measured evidence must change report hash.");
    }

    private static void ProvenanceCaseMismatchFailsClosed()
    {
        var run = BuildRun(reverse: false);
        var mismatched = run with
        {
            Provenance = run.Provenance with
            {
                Corpus = new[]
                {
                    new DemucsCppBenchmarkCorpusPin("other", @"C:\\bench\\other.wav", new string('c', 64))
                }
            }
        };
        Throws<InvalidDataException>(() => DemucsCppBenchmarkReportWriter.Create(mismatched));
    }

    private static DemucsCppVerifiedBenchmarkRun BuildRun(bool reverse, double? candidateF1Override = null)
    {
        var resources = new AudioSourceSeparationResourceMeasurement(
            120L * 1024 * 1024,
            800L * 1024 * 1024,
            1.25);
        var cases = new[]
        {
            Case("corpus-a", 10, 4, 5, 4, candidateF1Override),
            Case("corpus-b", 20, 3, 5, 4, null)
        };
        if (reverse)
            Array.Reverse(cases);

        var deltas = cases.ToDictionary(item => item.Name, item => item.Candidate.F1 - item.Direct.F1, StringComparer.Ordinal);
        var assessment = new AudioSourceSeparationAdoptionAssessment(
            AudioSourceSeparationAdoptionDecision.Adopt,
            cases.Length,
            0.70,
            0.85,
            0.15,
            0.15,
            0.10,
            1.0,
            resources,
            deltas,
            Array.Empty<string>());
        var benchmark = new AudioSourceSeparationBenchmarkRun(cases, resources, assessment);

        IReadOnlyList<DemucsCppBenchmarkCorpusPin> corpus = new[]
        {
            new DemucsCppBenchmarkCorpusPin("corpus-a", @"C:\\bench\\a.wav", new string('a', 64)),
            new DemucsCppBenchmarkCorpusPin("corpus-b", @"D:\\owned\\b.wav", new string('b', 64))
        };
        if (reverse)
            corpus = corpus.Reverse().ToArray();

        var provenance = new DemucsCppBenchmarkVerifiedProvenance(
            "0123456789abcdef0123456789abcdef01234567",
            new string('d', 64),
            new string('e', 64),
            corpus,
            new string('f', 64));
        return new DemucsCppVerifiedBenchmarkRun(provenance, benchmark);
    }

    private static AudioSourceSeparationBenchmarkCaseResult Case(
        string name,
        int seconds,
        int directMatched,
        int referenceNotes,
        int candidateMatched,
        double? candidateF1Override)
    {
        var direct = Evaluation(referenceNotes, 5, directMatched);
        var candidate = Evaluation(referenceNotes, 5, candidateMatched);
        if (candidateF1Override.HasValue)
            candidate = candidate with { F1 = candidateF1Override.Value };
        return new AudioSourceSeparationBenchmarkCaseResult(
            name,
            TimeSpan.FromSeconds(seconds),
            direct,
            candidate,
            TimeSpan.FromSeconds(seconds * 1.25),
            800L * 1024 * 1024,
            120L * 1024 * 1024);
    }

    private static AudioTranscriptionEvaluationResult Evaluation(int reference, int estimated, int matched)
    {
        var precision = matched / (double)estimated;
        var recall = matched / (double)reference;
        var f1 = precision + recall == 0d ? 0d : 2d * precision * recall / (precision + recall);
        return new AudioTranscriptionEvaluationResult(reference, estimated, matched, precision, recall, f1, 12.5, 24.0, Array.Empty<AudioTranscriptionNoteMatch>());
    }

    private static void Run(string name, Action action)
    {
        try { action(); }
        catch (Exception ex) { throw new InvalidOperationException($"Phase 32 regression failed: {name}", ex); }
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected '{expected}', actual '{actual}'.");
    }

    private static void True(bool condition, string message)
    {
        if (!condition) throw new InvalidOperationException(message);
    }

    private static void Throws<T>(Action action) where T : Exception
    {
        try { action(); }
        catch (T) { return; }
        throw new InvalidOperationException($"Expected {typeof(T).Name}.");
    }
}
