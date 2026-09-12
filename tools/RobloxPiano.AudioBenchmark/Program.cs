using RobloxPiano.Audio;

try
{
    if (args.Length == 0 || args.Contains("--help", StringComparer.Ordinal))
    {
        PrintUsage();
        return args.Length == 0 ? 2 : 0;
    }

    var options = ParseArguments(args);
    var manifestPath = Require(options, "--manifest");
    var reportPath = Require(options, "--report");
    var basicPitchModelPath = Require(options, "--basic-pitch-model");
    var basicPitchSha256 = Require(options, "--basic-pitch-sha256");
    var basicPitchCommit = Require(options, "--basic-pitch-commit");

    using var cts = new CancellationTokenSource();
    Console.CancelKeyPress += (_, eventArgs) =>
    {
        eventArgs.Cancel = true;
        cts.Cancel();
    };

    var runner = new DemucsCppBasicPitchBenchmarkRunner();
    var result = await runner.RunNativeAsync(
        manifestPath,
        reportPath,
        new BasicPitchBenchmarkModelPin(
            basicPitchModelPath,
            basicPitchSha256,
            basicPitchCommit),
        cancellationToken: cts.Token);

    Console.WriteLine($"decision={result.Benchmark.Run.Benchmark.Assessment.Decision}");
    Console.WriteLine($"report={result.Benchmark.ReportPath}");
    Console.WriteLine($"report_sha256={result.Benchmark.Report.ReportSha256}");
    Console.WriteLine($"evidence={result.EvidencePath}");
    Console.WriteLine($"evidence_sha256={result.EvidenceSha256}");
    return 0;
}
catch (OperationCanceledException)
{
    Console.Error.WriteLine("Audio separation benchmark cancelled.");
    return 130;
}
catch (Exception exception)
{
    Console.Error.WriteLine($"Audio separation benchmark failed: {exception.Message}");
    return 1;
}

static Dictionary<string, string> ParseArguments(string[] values)
{
    if ((values.Length & 1) != 0)
        throw new ArgumentException("Every benchmark option requires exactly one value.");

    var parsed = new Dictionary<string, string>(StringComparer.Ordinal);
    for (var index = 0; index < values.Length; index += 2)
    {
        var name = values[index];
        var value = values[index + 1];
        if (!name.StartsWith("--", StringComparison.Ordinal) || string.IsNullOrWhiteSpace(value))
            throw new ArgumentException($"Invalid benchmark argument pair at position {index}.");
        if (!IsKnownOption(name))
            throw new ArgumentException($"Unknown benchmark option '{name}'.");
        if (!parsed.TryAdd(name, value))
            throw new ArgumentException($"Benchmark option '{name}' was supplied more than once.");
    }

    return parsed;
}

static bool IsKnownOption(string name) => name is
    "--manifest" or
    "--report" or
    "--basic-pitch-model" or
    "--basic-pitch-sha256" or
    "--basic-pitch-commit";

static string Require(IReadOnlyDictionary<string, string> values, string name) =>
    values.TryGetValue(name, out var value) && !string.IsNullOrWhiteSpace(value)
        ? value
        : throw new ArgumentException($"Required benchmark option '{name}' is missing.");

static void PrintUsage()
{
    Console.WriteLine("RobloxPiano Audio separation benchmark (engineering only)");
    Console.WriteLine("Usage:");
    Console.WriteLine("  RobloxPiano.AudioBenchmark --manifest <absolute manifest.json> --report <absolute report.json> --basic-pitch-model <absolute nmp.onnx> --basic-pitch-sha256 <sha256> --basic-pitch-commit <40-char commit>");
    Console.WriteLine();
    Console.WriteLine("The command never downloads tools, models, or media and never mutates production playback state.");
}
