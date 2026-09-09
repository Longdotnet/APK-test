using System.Diagnostics;
using System.Globalization;
using System.Text;

namespace RobloxPiano.Core;

public sealed record PerformanceEvent(
    TimeSpan Start,
    TimeSpan Duration,
    IReadOnlyList<char> Keys);

public sealed record PerformanceTrack(
    string Title,
    double Bpm,
    int Subdivision,
    TimeSpan StartDelay,
    IReadOnlyList<PerformanceEvent> Events,
    TimeSpan TimelineDuration);

public enum PlaybackEdgeKind
{
    KeyUp = 0,
    KeyDown = 1
}

public sealed record PlaybackEdge(
    TimeSpan At,
    PlaybackEdgeKind Kind,
    IReadOnlyList<char> Keys);

public static class PlaybackPlanner
{
    public static IReadOnlyList<PlaybackEdge> BuildEdges(PerformanceTrack track)
    {
        ArgumentNullException.ThrowIfNull(track);

        var edges = new List<PlaybackEdge>(track.Events.Count * 2);
        foreach (var performanceEvent in track.Events)
        {
            if (performanceEvent.Duration <= TimeSpan.Zero)
            {
                throw new InvalidOperationException("Performance events must have a positive duration.");
            }

            if (performanceEvent.Keys.Count == 0)
            {
                throw new InvalidOperationException("Performance events must contain at least one key.");
            }

            edges.Add(new PlaybackEdge(performanceEvent.Start, PlaybackEdgeKind.KeyDown, performanceEvent.Keys));
            edges.Add(new PlaybackEdge(performanceEvent.Start + performanceEvent.Duration, PlaybackEdgeKind.KeyUp, performanceEvent.Keys));
        }

        return edges
            .OrderBy(edge => edge.At)
            .ThenBy(edge => edge.Kind)
            .ToArray();
    }
}

public interface IMonotonicClock
{
    TimeSpan Elapsed { get; }

    ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken);
}

public sealed class StopwatchClock : IMonotonicClock
{
    private readonly Stopwatch _stopwatch = Stopwatch.StartNew();

    public TimeSpan Elapsed => _stopwatch.Elapsed;

    public async ValueTask DelayUntilAsync(TimeSpan target, CancellationToken cancellationToken)
    {
        while (true)
        {
            cancellationToken.ThrowIfCancellationRequested();
            var remaining = target - _stopwatch.Elapsed;
            if (remaining <= TimeSpan.Zero)
            {
                return;
            }

            if (remaining > TimeSpan.FromMilliseconds(3))
            {
                await Task.Delay(remaining - TimeSpan.FromMilliseconds(1), cancellationToken).ConfigureAwait(false);
                continue;
            }

            Thread.SpinWait(64);
            await Task.Yield();
        }
    }
}

public interface IInputSink
{
    ValueTask KeyDownAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken);

    ValueTask KeyUpAsync(IReadOnlyList<char> keys, CancellationToken cancellationToken);

    ValueTask ReleaseAllAsync(CancellationToken cancellationToken);
}

public interface IFocusGate
{
    bool IsTargetFocused { get; }
}

public sealed record PlaybackOptions(
    double Speed = 1d,
    TimeSpan? InitialDelay = null,
    TimeSpan? FocusPollInterval = null);

public sealed class PlaybackKernel
{
    private readonly IMonotonicClock _clock;
    private readonly IInputSink _input;
    private readonly IFocusGate _focus;

    public PlaybackKernel(IMonotonicClock clock, IInputSink input, IFocusGate focus)
    {
        _clock = clock ?? throw new ArgumentNullException(nameof(clock));
        _input = input ?? throw new ArgumentNullException(nameof(input));
        _focus = focus ?? throw new ArgumentNullException(nameof(focus));
    }

    public async Task PlayAsync(
        PerformanceTrack track,
        PlaybackOptions? options = null,
        CancellationToken cancellationToken = default)
    {
        ArgumentNullException.ThrowIfNull(track);
        options ??= new PlaybackOptions();

        if (!double.IsFinite(options.Speed) || options.Speed <= 0d)
        {
            throw new ArgumentOutOfRangeException(nameof(options), "Playback speed must be a finite value greater than zero.");
        }

        var pollInterval = options.FocusPollInterval ?? TimeSpan.FromMilliseconds(10);
        if (pollInterval <= TimeSpan.Zero)
        {
            throw new ArgumentOutOfRangeException(nameof(options), "Focus poll interval must be positive.");
        }

        var edges = PlaybackPlanner.BuildEdges(track);
        var initialDelay = options.InitialDelay ?? track.StartDelay;
        if (initialDelay < TimeSpan.Zero)
        {
            throw new ArgumentOutOfRangeException(nameof(options), "Initial delay cannot be negative.");
        }

        var origin = _clock.Elapsed + initialDelay;
        var pausedDuration = TimeSpan.Zero;

        try
        {
            foreach (var edge in edges)
            {
                cancellationToken.ThrowIfCancellationRequested();

                while (true)
                {
                    cancellationToken.ThrowIfCancellationRequested();

                    if (!_focus.IsTargetFocused)
                    {
                        await _input.ReleaseAllAsync(CancellationToken.None).ConfigureAwait(false);
                        var lostFocusAt = _clock.Elapsed;

                        while (!_focus.IsTargetFocused)
                        {
                            cancellationToken.ThrowIfCancellationRequested();
                            await _clock.DelayUntilAsync(_clock.Elapsed + pollInterval, cancellationToken).ConfigureAwait(false);
                        }

                        pausedDuration += _clock.Elapsed - lostFocusAt;
                        continue;
                    }

                    var target = origin + Scale(edge.At, options.Speed) + pausedDuration;
                    var now = _clock.Elapsed;
                    if (now >= target)
                    {
                        break;
                    }

                    var nextFocusCheck = now + pollInterval;
                    if (nextFocusCheck > target)
                    {
                        nextFocusCheck = target;
                    }

                    await _clock.DelayUntilAsync(nextFocusCheck, cancellationToken).ConfigureAwait(false);
                }

                if (edge.Kind == PlaybackEdgeKind.KeyDown)
                {
                    await _input.KeyDownAsync(edge.Keys, cancellationToken).ConfigureAwait(false);
                }
                else
                {
                    await _input.KeyUpAsync(edge.Keys, cancellationToken).ConfigureAwait(false);
                }
            }
        }
        finally
        {
            await _input.ReleaseAllAsync(CancellationToken.None).ConfigureAwait(false);
        }
    }

    private static TimeSpan Scale(TimeSpan value, double speed)
    {
        var ticks = value.Ticks / speed;
        if (ticks > long.MaxValue || ticks < long.MinValue)
        {
            throw new OverflowException("Scaled playback time exceeded TimeSpan range.");
        }

        return TimeSpan.FromTicks((long)Math.Round(ticks, MidpointRounding.AwayFromZero));
    }
}

public static class LegacySheetParser
{
    private static readonly HashSet<string> KnownMetadata = new(StringComparer.OrdinalIgnoreCase)
    {
        "TITLE",
        "AUTHOR",
        "BPM",
        "SUBDIV",
        "START_DELAY",
        "CHORD_HOLD",
        "PRINT_MODE",
        "LOOPS"
    };

    public static PerformanceTrack Parse(string text)
    {
        ArgumentNullException.ThrowIfNull(text);

        var metadata = new Dictionary<string, string>(StringComparer.OrdinalIgnoreCase);
        var body = new StringBuilder();

        foreach (var rawLine in NormalizeNewLines(text).Split('\n'))
        {
            var trimmed = rawLine.Trim();
            if (trimmed.Length == 0)
            {
                continue;
            }

            if (IsCommentLine(trimmed))
            {
                continue;
            }

            if (TryReadMetadata(trimmed, out var key, out var value))
            {
                metadata[key] = value;
                continue;
            }

            var line = StripInlineComment(rawLine);
            if (!string.IsNullOrWhiteSpace(line))
            {
                body.AppendLine(line);
            }
        }

        var title = GetString(metadata, "TITLE", "Untitled");
        var bpm = GetDouble(metadata, "BPM", 100d);
        var subdivision = GetInt(metadata, "SUBDIV", 4);
        var startDelaySeconds = GetDouble(metadata, "START_DELAY", 5d);
        var chordHold = GetDouble(metadata, "CHORD_HOLD", 0.75d);
        var loops = GetInt(metadata, "LOOPS", 1);

        if (!double.IsFinite(bpm) || bpm <= 0d)
        {
            throw new FormatException("BPM must be a finite value greater than zero.");
        }

        if (subdivision <= 0)
        {
            throw new FormatException("SUBDIV must be greater than zero.");
        }

        if (!double.IsFinite(startDelaySeconds) || startDelaySeconds < 0d)
        {
            throw new FormatException("START_DELAY must be a finite value greater than or equal to zero.");
        }

        if (!double.IsFinite(chordHold) || chordHold <= 0d || chordHold > 1d)
        {
            throw new FormatException("CHORD_HOLD must be greater than zero and less than or equal to one.");
        }

        if (loops <= 0 || loops > 1000)
        {
            throw new FormatException("LOOPS must be between 1 and 1000.");
        }

        var step = TimeSpan.FromSeconds(60d / (bpm * subdivision));
        var oneLoopEvents = ParseBody(body.ToString(), step, chordHold, out var oneLoopDuration);
        var events = ExpandLoops(oneLoopEvents, oneLoopDuration, loops);
        var totalDuration = Multiply(oneLoopDuration, loops);

        return new PerformanceTrack(
            title,
            bpm,
            subdivision,
            TimeSpan.FromSeconds(startDelaySeconds),
            events,
            totalDuration);
    }

    private static IReadOnlyList<PerformanceEvent> ParseBody(
        string body,
        TimeSpan step,
        double chordHold,
        out TimeSpan timelineDuration)
    {
        var events = new List<PerformanceEvent>();
        var cursor = TimeSpan.Zero;

        for (var index = 0; index < body.Length; index++)
        {
            var current = body[index];

            if (char.IsWhiteSpace(current))
            {
                continue;
            }

            if (current == '.')
            {
                cursor += step;
                continue;
            }

            if (current is '|' or '-')
            {
                continue;
            }

            if (current == '[')
            {
                var close = body.IndexOf(']', index + 1);
                if (close < 0)
                {
                    throw new FormatException($"Unclosed chord starting at character {index}.");
                }

                var keys = body[(index + 1)..close]
                    .Where(character => !char.IsWhiteSpace(character) && character != ',')
                    .ToArray();

                if (keys.Length == 0)
                {
                    throw new FormatException($"Empty chord at character {index}.");
                }

                EnsureNoUnsupportedDuration(body, close + 1);
                events.Add(new PerformanceEvent(cursor, ScaleDuration(step, chordHold), keys));
                cursor += step;
                index = close;
                continue;
            }

            if (current == ']')
            {
                throw new FormatException($"Unexpected closing chord bracket at character {index}.");
            }

            if (current is '{' or '}')
            {
                throw new FormatException(
                    "Explicit {duration} syntax is intentionally not part of the stable legacy baseline. " +
                    "Use the canonical performance model for duration-aware playback.");
            }

            var code = (int)current;
            if (code is >= 33 and <= 126)
            {
                EnsureNoUnsupportedDuration(body, index + 1);
                events.Add(new PerformanceEvent(cursor, ScaleDuration(step, chordHold), new[] { current }));
                cursor += step;
            }
        }

        timelineDuration = cursor;
        return events;
    }

    private static void EnsureNoUnsupportedDuration(string body, int nextIndex)
    {
        if (nextIndex < body.Length && body[nextIndex] == '{')
        {
            throw new FormatException(
                "Explicit {duration} syntax is intentionally not part of the stable legacy baseline. " +
                "This prevents the V5 hold-duration experiment from silently changing legacy playback semantics.");
        }
    }

    private static IReadOnlyList<PerformanceEvent> ExpandLoops(
        IReadOnlyList<PerformanceEvent> source,
        TimeSpan oneLoopDuration,
        int loops)
    {
        if (loops == 1)
        {
            return source;
        }

        var expanded = new List<PerformanceEvent>(checked(source.Count * loops));
        for (var loop = 0; loop < loops; loop++)
        {
            var offset = Multiply(oneLoopDuration, loop);
            foreach (var performanceEvent in source)
            {
                expanded.Add(performanceEvent with { Start = performanceEvent.Start + offset });
            }
        }

        return expanded;
    }

    private static TimeSpan Multiply(TimeSpan value, int multiplier)
    {
        return TimeSpan.FromTicks(checked(value.Ticks * multiplier));
    }

    private static TimeSpan ScaleDuration(TimeSpan step, double chordHold)
    {
        var ticks = step.Ticks * chordHold;
        return TimeSpan.FromTicks(Math.Max(1L, (long)Math.Round(ticks, MidpointRounding.AwayFromZero)));
    }

    private static bool TryReadMetadata(string line, out string key, out string value)
    {
        var separator = line.IndexOf('=');
        if (separator <= 0)
        {
            key = string.Empty;
            value = string.Empty;
            return false;
        }

        key = line[..separator].Trim();
        if (!KnownMetadata.Contains(key))
        {
            value = string.Empty;
            return false;
        }

        value = line[(separator + 1)..].Trim();
        return true;
    }

    private static string StripInlineComment(string line)
    {
        var separator = line.IndexOf(" //", StringComparison.Ordinal);
        return separator < 0 ? line : line[..separator];
    }

    private static bool IsCommentLine(string line)
    {
        return line.StartsWith("//", StringComparison.Ordinal)
            || line.StartsWith("# ", StringComparison.Ordinal)
            || line.StartsWith("##", StringComparison.Ordinal)
            || line.StartsWith("#=", StringComparison.Ordinal);
    }

    private static string NormalizeNewLines(string value)
    {
        return value.Replace("\r\n", "\n", StringComparison.Ordinal)
            .Replace('\r', '\n');
    }

    private static string GetString(IReadOnlyDictionary<string, string> metadata, string key, string fallback)
    {
        return metadata.TryGetValue(key, out var value) && value.Length > 0 ? value : fallback;
    }

    private static double GetDouble(IReadOnlyDictionary<string, string> metadata, string key, double fallback)
    {
        if (!metadata.TryGetValue(key, out var value))
        {
            return fallback;
        }

        if (!double.TryParse(value, NumberStyles.Float, CultureInfo.InvariantCulture, out var parsed))
        {
            throw new FormatException($"{key} must be a valid invariant-culture number.");
        }

        return parsed;
    }

    private static int GetInt(IReadOnlyDictionary<string, string> metadata, string key, int fallback)
    {
        if (!metadata.TryGetValue(key, out var value))
        {
            return fallback;
        }

        if (!int.TryParse(value, NumberStyles.Integer, CultureInfo.InvariantCulture, out var parsed))
        {
            throw new FormatException($"{key} must be a valid integer.");
        }

        return parsed;
    }
}
