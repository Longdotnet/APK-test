using System.Security.Cryptography;
using System.Text;

namespace RobloxPiano.Audio;

public sealed record DemucsCppBenchmarkCorpusPin(
    string Name,
    string InputAudioPath,
    string Sha256);

public sealed record DemucsCppBenchmarkVerifiedProvenance(
    string UpstreamCommitSha,
    string ExecutableSha256,
    string ModelSha256,
    IReadOnlyList<DemucsCppBenchmarkCorpusPin> Corpus,
    string IdentitySha256);

/// <summary>
/// Engineering-only provenance verifier for native demucs.cpp source-separation benchmarks.
/// It prevents a benchmark result from being attributed to one tool/model/corpus identity while
/// actually running different bytes. It does not download, discover, or redistribute any artifact.
/// </summary>
public static class DemucsCppBenchmarkProvenance
{
    public static DemucsCppBenchmarkVerifiedProvenance Verify(
        DemucsCppSixSourcePianoBenchmarkProfile profile,
        string upstreamCommitSha,
        string executableSha256,
        string modelSha256,
        IReadOnlyList<DemucsCppBenchmarkCorpusPin> corpus,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(profile);
        ArgumentNullException.ThrowIfNull(corpus);
        cancellationToken.ThrowIfCancellationRequested();

        var normalizedCommit = NormalizeCommitSha(upstreamCommitSha);
        var normalizedExecutableHash = NormalizeSha256(executableSha256, nameof(executableSha256));
        var normalizedModelHash = NormalizeSha256(modelSha256, nameof(modelSha256));

        VerifyFile(profile.ExecutablePath, normalizedExecutableHash, nameof(profile.ExecutablePath), cancellationToken);
        VerifyFile(profile.ModelPath, normalizedModelHash, nameof(profile.ModelPath), cancellationToken);

        if (corpus.Count == 0)
            throw new ArgumentException("Pinned demucs.cpp benchmark corpus cannot be empty.", nameof(corpus));
        if (corpus.Any(item => item is null))
            throw new ArgumentException("Pinned demucs.cpp benchmark corpus cannot contain null entries.", nameof(corpus));
        if (corpus.Any(item => string.IsNullOrWhiteSpace(item.Name)))
            throw new ArgumentException("Every pinned benchmark corpus case requires a stable name.", nameof(corpus));
        if (corpus.Select(item => item.Name).Distinct(StringComparer.Ordinal).Count() != corpus.Count)
            throw new ArgumentException("Pinned benchmark corpus case names must be unique.", nameof(corpus));

        var verifiedCorpus = new List<DemucsCppBenchmarkCorpusPin>(corpus.Count);
        var seenPaths = new HashSet<string>(StringComparer.OrdinalIgnoreCase);
        foreach (var item in corpus)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var fullPath = RequireExistingAbsoluteFile(item.InputAudioPath, nameof(item.InputAudioPath));
            if (!seenPaths.Add(fullPath))
                throw new ArgumentException("Pinned benchmark corpus input paths must be unique.", nameof(corpus));

            var normalizedHash = NormalizeSha256(item.Sha256, nameof(item.Sha256));
            VerifyFile(fullPath, normalizedHash, nameof(item.InputAudioPath), cancellationToken);
            verifiedCorpus.Add(new DemucsCppBenchmarkCorpusPin(item.Name.Trim(), fullPath, normalizedHash));
        }

        var identity = ComputeIdentity(
            normalizedCommit,
            normalizedExecutableHash,
            normalizedModelHash,
            verifiedCorpus);

        return new DemucsCppBenchmarkVerifiedProvenance(
            normalizedCommit,
            normalizedExecutableHash,
            normalizedModelHash,
            verifiedCorpus.AsReadOnly(),
            identity);
    }

    public static string ComputeFileSha256(string path, CancellationToken cancellationToken = default)
    {
        var fullPath = RequireExistingAbsoluteFile(path, nameof(path));
        cancellationToken.ThrowIfCancellationRequested();
        using var stream = new FileStream(
            fullPath,
            FileMode.Open,
            FileAccess.Read,
            FileShare.Read,
            bufferSize: 128 * 1024,
            options: FileOptions.SequentialScan);

        using var sha256 = SHA256.Create();
        var hash = sha256.ComputeHash(stream);
        cancellationToken.ThrowIfCancellationRequested();
        return Convert.ToHexString(hash).ToLowerInvariant();
    }

    private static void VerifyFile(
        string path,
        string expectedSha256,
        string parameterName,
        CancellationToken cancellationToken)
    {
        var fullPath = RequireExistingAbsoluteFile(path, parameterName);
        var actual = ComputeFileSha256(fullPath, cancellationToken);
        if (!string.Equals(actual, expectedSha256, StringComparison.Ordinal))
        {
            throw new InvalidDataException(
                $"Pinned benchmark artifact hash mismatch for '{Path.GetFileName(fullPath)}'. Expected {expectedSha256}, actual {actual}.");
        }
    }

    private static string ComputeIdentity(
        string upstreamCommitSha,
        string executableSha256,
        string modelSha256,
        IReadOnlyList<DemucsCppBenchmarkCorpusPin> corpus)
    {
        var builder = new StringBuilder();
        builder.Append("demucs.cpp.commit=").Append(upstreamCommitSha).Append('\n');
        builder.Append("demucs.cpp.executable.sha256=").Append(executableSha256).Append('\n');
        builder.Append("demucs.cpp.model.sha256=").Append(modelSha256).Append('\n');
        foreach (var item in corpus.OrderBy(item => item.Name, StringComparer.Ordinal))
        {
            builder.Append("corpus.")
                .Append(item.Name)
                .Append(".sha256=")
                .Append(item.Sha256)
                .Append('\n');
        }

        return Convert.ToHexString(SHA256.HashData(Encoding.UTF8.GetBytes(builder.ToString())))
            .ToLowerInvariant();
    }

    private static string NormalizeCommitSha(string value)
    {
        if (string.IsNullOrWhiteSpace(value))
            throw new ArgumentException("Pinned demucs.cpp upstream commit SHA is required.", nameof(value));

        var normalized = value.Trim().ToLowerInvariant();
        if (normalized.Length != 40 || normalized.Any(character => !IsHex(character)))
            throw new ArgumentException("Pinned demucs.cpp upstream commit must be a full 40-character Git SHA.", nameof(value));
        return normalized;
    }

    private static string NormalizeSha256(string value, string parameterName)
    {
        if (string.IsNullOrWhiteSpace(value))
            throw new ArgumentException("Pinned SHA-256 is required.", parameterName);

        var normalized = value.Trim().ToLowerInvariant();
        if (normalized.Length != 64 || normalized.Any(character => !IsHex(character)))
            throw new ArgumentException("Pinned SHA-256 must contain exactly 64 hexadecimal characters.", parameterName);
        return normalized;
    }

    private static bool IsHex(char character) =>
        character is >= '0' and <= '9' or >= 'a' and <= 'f';

    private static string RequireExistingAbsoluteFile(string path, string parameterName)
    {
        if (string.IsNullOrWhiteSpace(path) || !Path.IsPathFullyQualified(path))
            throw new ArgumentException("Path must be absolute.", parameterName);

        var fullPath = Path.GetFullPath(path);
        if (!File.Exists(fullPath))
            throw new FileNotFoundException("Pinned demucs.cpp benchmark file does not exist.", fullPath);
        return fullPath;
    }
}
