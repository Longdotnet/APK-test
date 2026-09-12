using System.Security.Cryptography;
using RobloxPiano.Audio;

internal static class DemucsCppBasicPitchBenchmarkRunnerRegression
{
    public static void ExactBasicPitchBytesVerify()
    {
        using var fixture = ModelFixture.Create();
        var provenance = DemucsCppBasicPitchBenchmarkRunner.VerifyBasicPitch(
            new BasicPitchBenchmarkModelPin(
                fixture.Path,
                fixture.Sha256,
                "fa5997af0a8210982619003269994a1be25eddf3"));

        Equal(fixture.Sha256, provenance.ModelSha256);
        Equal(fixture.Bytes.LongLength, provenance.ModelBytes);
        Equal("fa5997af0a8210982619003269994a1be25eddf3", provenance.UpstreamCommitSha);
    }

    public static void BasicPitchByteDriftFailsClosed()
    {
        using var fixture = ModelFixture.Create();
        var pin = new BasicPitchBenchmarkModelPin(
            fixture.Path,
            fixture.Sha256,
            "fa5997af0a8210982619003269994a1be25eddf3");

        File.AppendAllText(fixture.Path, "drift");
        Throws<InvalidDataException>(() => DemucsCppBasicPitchBenchmarkRunner.VerifyBasicPitch(pin));
    }

    public static void BasicPitchPinRequiresAbsolutePathAndFullCommit()
    {
        using var fixture = ModelFixture.Create();
        Throws<ArgumentException>(() => DemucsCppBasicPitchBenchmarkRunner.VerifyBasicPitch(
            new BasicPitchBenchmarkModelPin(
                "nmp.onnx",
                fixture.Sha256,
                "fa5997af0a8210982619003269994a1be25eddf3")));
        Throws<ArgumentException>(() => DemucsCppBasicPitchBenchmarkRunner.VerifyBasicPitch(
            new BasicPitchBenchmarkModelPin(
                fixture.Path,
                fixture.Sha256,
                "fa5997af")));
    }

    private static void Equal<T>(T expected, T actual)
    {
        if (!EqualityComparer<T>.Default.Equals(expected, actual))
            throw new InvalidOperationException($"Expected {expected}, actual {actual}.");
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

    private sealed class ModelFixture : IDisposable
    {
        private ModelFixture(string path, byte[] bytes, string sha256)
        {
            Path = path;
            Bytes = bytes;
            Sha256 = sha256;
        }

        public string Path { get; }
        public byte[] Bytes { get; }
        public string Sha256 { get; }

        public static ModelFixture Create()
        {
            var path = System.IO.Path.Combine(System.IO.Path.GetTempPath(), $"roblox-piano-basicpitch-{Guid.NewGuid():N}.onnx");
            var bytes = "pinned-basic-pitch-regression-fixture"u8.ToArray();
            File.WriteAllBytes(path, bytes);
            var sha = Convert.ToHexString(SHA256.HashData(bytes)).ToLowerInvariant();
            return new ModelFixture(path, bytes, sha);
        }

        public void Dispose()
        {
            try
            {
                if (File.Exists(Path)) File.Delete(Path);
            }
            catch
            {
                // Test cleanup only.
            }
        }
    }
}
