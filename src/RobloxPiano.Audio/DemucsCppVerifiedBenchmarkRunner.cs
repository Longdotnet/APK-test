namespace RobloxPiano.Audio;

public sealed record DemucsCppVerifiedBenchmarkCase(
    string Name,
    string InputAudioPath,
    string Sha256,
    TimeSpan AudioDuration,
    IReadOnlyList<AudioTranscriptionReferenceNote> Reference);

public sealed record DemucsCppVerifiedBenchmarkRequest(
    DemucsCppSixSourcePianoBenchmarkProfile Profile,
    string UpstreamCommitSha,
    string ExecutableSha256,
    string ModelSha256,
    IReadOnlyList<DemucsCppVerifiedBenchmarkCase> Cases);

public sealed record DemucsCppVerifiedBenchmarkRun(
    DemucsCppBenchmarkVerifiedProvenance Provenance,
    AudioSourceSeparationBenchmarkRun Benchmark);

/// <summary>
/// Engineering-only execution envelope that binds a paired source-separation benchmark to the exact
/// demucs.cpp executable/model/corpus bytes verified by <see cref="DemucsCppBenchmarkProvenance"/>.
/// Verification is repeated after measurement so mutable files cannot silently drift during a run and
/// still produce adoption evidence. This type does not download tools/models/media and is not part of
/// production Roblox playback or transcription state.
/// </summary>
public sealed class DemucsCppVerifiedBenchmarkRunner
{
    private readonly AudioSourceSeparationBenchmarkRunner benchmarkRunner = new();
    private readonly NativeSeparatorProcessAdapter separatorAdapter = new();

    public Task<DemucsCppVerifiedBenchmarkRun> RunNativeAsync(
        DemucsCppVerifiedBenchmarkRequest request,
        Func<string, CancellationToken, ValueTask<IReadOnlyList<BasicPitchTranscribedNote>>> directAudioTranscriber,
        Func<string, CancellationToken, ValueTask<IReadOnlyList<BasicPitchTranscribedNote>>> separatedStemTranscriber,
        AudioSourceSeparationAdoptionOptions? adoptionOptions = null,
        AudioTranscriptionEvaluationOptions? evaluationOptions = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(separatedStemTranscriber);
        return RunMeasuredAsync(
            request,
            directAudioTranscriber,
            async (item, token) =>
            {
                var nativeRequest = request.Profile.BuildRequest(item.InputAudioPath);
                var options = request.Profile.BuildOptions();
                return await separatorAdapter.RunAsync(
                    nativeRequest,
                    options,
                    separatedStemTranscriber,
                    token).ConfigureAwait(false);
            },
            adoptionOptions,
            evaluationOptions,
            cancellationToken);
    }

    /// <summary>
    /// Runs the same provenance-bound envelope with an explicit candidate delegate. This is useful for
    /// deterministic engineering regressions and alternate native adapters while preserving the same
    /// artifact/corpus identity and resource-accounting invariants as <see cref="RunNativeAsync"/>.
    /// </summary>
    public async Task<DemucsCppVerifiedBenchmarkRun> RunMeasuredAsync(
        DemucsCppVerifiedBenchmarkRequest request,
        Func<string, CancellationToken, ValueTask<IReadOnlyList<BasicPitchTranscribedNote>>> directAudioTranscriber,
        Func<DemucsCppVerifiedBenchmarkCase, CancellationToken, ValueTask<AudioSourceSeparationCandidateRun>> candidateTranscriber,
        AudioSourceSeparationAdoptionOptions? adoptionOptions = null,
        AudioTranscriptionEvaluationOptions? evaluationOptions = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(request);
        ArgumentNullException.ThrowIfNull(request.Profile);
        ArgumentNullException.ThrowIfNull(request.Cases);
        ArgumentNullException.ThrowIfNull(directAudioTranscriber);
        ArgumentNullException.ThrowIfNull(candidateTranscriber);
        cancellationToken.ThrowIfCancellationRequested();

        ValidateCases(request.Cases);
        var pins = request.Cases
            .Select(item => new DemucsCppBenchmarkCorpusPin(item.Name, item.InputAudioPath, item.Sha256))
            .ToArray();
        var before = DemucsCppBenchmarkProvenance.Verify(
            request.Profile,
            request.UpstreamCommitSha,
            request.ExecutableSha256,
            request.ModelSha256,
            pins,
            cancellationToken);

        var expectedBundleBytes = request.Profile.BuildOptions().AddedBundleBytes;
        var casesByName = request.Cases.ToDictionary(item => item.Name, StringComparer.Ordinal);
        var benchmarkCases = request.Cases
            .Select(item => new AudioSourceSeparationBenchmarkInputCase(item.Name, item.AudioDuration, item.Reference))
            .ToArray();

        var benchmark = await benchmarkRunner.RunAsync(
            benchmarkCases,
            (item, token) => directAudioTranscriber(casesByName[item.Name].InputAudioPath, token),
            async (item, token) =>
            {
                var run = await candidateTranscriber(casesByName[item.Name], token).ConfigureAwait(false);
                ArgumentNullException.ThrowIfNull(run);
                if (run.AddedBundleBytes != expectedBundleBytes)
                {
                    throw new InvalidDataException(
                        $"Candidate bundle evidence for '{item.Name}' reported {run.AddedBundleBytes} bytes, but the verified demucs.cpp profile accounts for {expectedBundleBytes} bytes.");
                }
                return run;
            },
            adoptionOptions,
            evaluationOptions,
            cancellationToken).ConfigureAwait(false);

        cancellationToken.ThrowIfCancellationRequested();
        var after = DemucsCppBenchmarkProvenance.Verify(
            request.Profile,
            request.UpstreamCommitSha,
            request.ExecutableSha256,
            request.ModelSha256,
            pins,
            cancellationToken);

        if (!string.Equals(before.IdentitySha256, after.IdentitySha256, StringComparison.Ordinal))
            throw new InvalidDataException("Verified demucs.cpp benchmark provenance changed during measurement; benchmark evidence is rejected.");

        return new DemucsCppVerifiedBenchmarkRun(after, benchmark);
    }

    private static void ValidateCases(IReadOnlyList<DemucsCppVerifiedBenchmarkCase> cases)
    {
        if (cases.Count == 0)
            throw new ArgumentException("Verified demucs.cpp benchmark requires at least one corpus case.", nameof(cases));
        if (cases.Any(item => item is null))
            throw new ArgumentException("Verified demucs.cpp benchmark cases cannot contain null entries.", nameof(cases));
        if (cases.Any(item => string.IsNullOrWhiteSpace(item.Name)))
            throw new ArgumentException("Every verified demucs.cpp benchmark case requires a stable name.", nameof(cases));
        if (cases.Select(item => item.Name).Distinct(StringComparer.Ordinal).Count() != cases.Count)
            throw new ArgumentException("Verified demucs.cpp benchmark case names must be unique.", nameof(cases));
        if (cases.Any(item => item.Reference is null || item.Reference.Count == 0))
            throw new ArgumentException("Every verified demucs.cpp benchmark case requires ground-truth notes.", nameof(cases));
        if (cases.Any(item => item.AudioDuration <= TimeSpan.Zero || item.AudioDuration > TimeSpan.FromHours(2)))
            throw new ArgumentOutOfRangeException(nameof(cases), "Verified demucs.cpp benchmark audio duration must be positive and no more than two hours per case.");
    }
}
