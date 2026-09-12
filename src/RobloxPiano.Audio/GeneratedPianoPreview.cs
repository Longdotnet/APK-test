using NAudio.Wave;
using RobloxPiano.Core;

namespace RobloxPiano.Audio;

public sealed record GeneratedPianoPreviewOptions(
    int SampleRate = 44_100,
    TimeSpan? MaximumPreviewDuration = null,
    float MasterGain = 0.22f,
    TimeSpan? Attack = null,
    TimeSpan? Release = null)
{
    public TimeSpan EffectiveMaximumPreviewDuration => MaximumPreviewDuration ?? TimeSpan.FromSeconds(60);
    public TimeSpan EffectiveAttack => Attack ?? TimeSpan.FromMilliseconds(5);
    public TimeSpan EffectiveRelease => Release ?? TimeSpan.FromMilliseconds(20);

    internal void Validate()
    {
        if (SampleRate is < 8_000 or > 192_000)
            throw new ArgumentOutOfRangeException(nameof(SampleRate));
        if (EffectiveMaximumPreviewDuration <= TimeSpan.Zero || EffectiveMaximumPreviewDuration > TimeSpan.FromMinutes(5))
            throw new ArgumentOutOfRangeException(nameof(MaximumPreviewDuration));
        if (!float.IsFinite(MasterGain) || MasterGain <= 0f || MasterGain > 1f)
            throw new ArgumentOutOfRangeException(nameof(MasterGain));
        if (EffectiveAttack < TimeSpan.Zero || EffectiveAttack > TimeSpan.FromMilliseconds(100))
            throw new ArgumentOutOfRangeException(nameof(Attack));
        if (EffectiveRelease < TimeSpan.Zero || EffectiveRelease > TimeSpan.FromMilliseconds(250))
            throw new ArgumentOutOfRangeException(nameof(Release));
    }
}

public sealed record GeneratedPianoPreviewInfo(
    TimeSpan SourceDuration,
    TimeSpan PreviewDuration,
    int NoteVoices,
    bool IsTruncated);

/// <summary>
/// Streams an audible local review of a canonical PerformanceTrack. This is intentionally
/// separate from Roblox playback/input: preview audio never schedules or injects keyboard input.
/// </summary>
public sealed class GeneratedPianoPreviewSampleProvider : ISampleProvider
{
    private readonly PreviewVoice[] _voices;
    private readonly List<PreviewVoice> _active = [];
    private readonly long _totalSamples;
    private readonly float _masterGain;
    private readonly long _attackSamples;
    private readonly long _releaseSamples;
    private long _samplePosition;
    private int _nextVoice;

    public GeneratedPianoPreviewSampleProvider(
        PerformanceTrack track,
        GeneratedPianoPreviewOptions? options = null)
    {
        ArgumentNullException.ThrowIfNull(track);
        options ??= new GeneratedPianoPreviewOptions();
        options.Validate();

        WaveFormat = WaveFormat.CreateIeeeFloatWaveFormat(options.SampleRate, 1);
        _masterGain = options.MasterGain;
        _attackSamples = ToSamples(options.EffectiveAttack, options.SampleRate);
        _releaseSamples = ToSamples(options.EffectiveRelease, options.SampleRate);

        var sourceDuration = track.TimelineDuration;
        if (sourceDuration <= TimeSpan.Zero)
            throw new InvalidDataException("Generated piano preview requires a positive canonical timeline duration.");

        var previewDuration = sourceDuration <= options.EffectiveMaximumPreviewDuration
            ? sourceDuration
            : options.EffectiveMaximumPreviewDuration;
        _totalSamples = Math.Max(1, ToSamples(previewDuration, options.SampleRate));

        var profile = MidiKeyboardProfile.RobloxClassic61;
        var voices = new List<PreviewVoice>();
        foreach (var performanceEvent in track.Events)
        {
            if (performanceEvent.Start < TimeSpan.Zero || performanceEvent.Duration <= TimeSpan.Zero)
                throw new InvalidDataException("Generated piano preview received an invalid canonical event timeline.");

            var startSample = ToSamples(performanceEvent.Start, options.SampleRate);
            if (startSample >= _totalSamples)
                continue;

            var endSample = Math.Min(
                _totalSamples,
                Math.Max(startSample + 1, ToSamples(performanceEvent.Start + performanceEvent.Duration, options.SampleRate)));

            foreach (var key in performanceEvent.Keys.Distinct())
            {
                var keyIndex = profile.Keys.IndexOf(key);
                if (keyIndex < 0)
                    throw new InvalidDataException($"Generated piano preview cannot map Roblox key '{key}' to the canonical 61-key profile.");

                var midi = checked(profile.LowestMidiNote + keyIndex);
                var frequency = 440d * Math.Pow(2d, (midi - 69) / 12d);
                voices.Add(new PreviewVoice(startSample, endSample, frequency));
            }
        }

        if (voices.Count == 0)
            throw new InvalidDataException("Generated piano preview contains no audible note voices.");

        _voices = voices
            .OrderBy(voice => voice.StartSample)
            .ThenBy(voice => voice.Frequency)
            .ToArray();
        Info = new GeneratedPianoPreviewInfo(
            sourceDuration,
            previewDuration,
            _voices.Length,
            previewDuration < sourceDuration);
    }

    public WaveFormat WaveFormat { get; }

    public GeneratedPianoPreviewInfo Info { get; }

    public int Read(Span<float> buffer)
    {
        if (_samplePosition >= _totalSamples || buffer.Length == 0)
            return 0;

        var samplesToWrite = (int)Math.Min(buffer.Length, _totalSamples - _samplePosition);
        for (var index = 0; index < samplesToWrite; index++)
        {
            var sample = _samplePosition;
            while (_nextVoice < _voices.Length && _voices[_nextVoice].StartSample <= sample)
            {
                if (_voices[_nextVoice].EndSample > sample)
                    _active.Add(_voices[_nextVoice]);
                _nextVoice++;
            }

            _active.RemoveAll(voice => voice.EndSample <= sample);
            double mixed = 0d;
            foreach (var voice in _active)
            {
                var age = sample - voice.StartSample;
                var remaining = voice.EndSample - sample;
                var envelope = 1d;
                if (_attackSamples > 0 && age < _attackSamples)
                    envelope = Math.Min(envelope, age / (double)_attackSamples);
                if (_releaseSamples > 0 && remaining < _releaseSamples)
                    envelope = Math.Min(envelope, remaining / (double)_releaseSamples);

                var seconds = age / (double)WaveFormat.SampleRate;
                mixed += Math.Sin(2d * Math.PI * voice.Frequency * seconds) * envelope;
            }

            var normalization = _active.Count <= 1 ? 1d : 1d / Math.Sqrt(_active.Count);
            buffer[index] = (float)Math.Clamp(mixed * normalization * _masterGain, -1d, 1d);
            _samplePosition++;
        }

        return samplesToWrite;
    }

    private static long ToSamples(TimeSpan value, int sampleRate)
    {
        var samples = value.TotalSeconds * sampleRate;
        if (!double.IsFinite(samples) || samples < 0d || samples > long.MaxValue)
            throw new OverflowException("Preview timeline exceeds the supported sample range.");
        return (long)Math.Round(samples, MidpointRounding.AwayFromZero);
    }

    private sealed record PreviewVoice(long StartSample, long EndSample, double Frequency);
}

public sealed class GeneratedPianoPreviewPlayer : IDisposable
{
    private WaveOut? _output;

    public bool IsPlaying => _output?.PlaybackState == PlaybackState.Playing;

    public GeneratedPianoPreviewInfo Play(
        PerformanceTrack track,
        GeneratedPianoPreviewOptions? options = null)
    {
        Stop();
        var provider = new GeneratedPianoPreviewSampleProvider(track, options);
        var output = new WaveOut { BufferMilliseconds = 50 };
        try
        {
            output.Init(provider);
            output.Play();
            _output = output;
            return provider.Info;
        }
        catch
        {
            output.Dispose();
            throw;
        }
    }

    public void Stop()
    {
        var output = Interlocked.Exchange(ref _output, null);
        if (output is null)
            return;

        try
        {
            output.Stop();
        }
        finally
        {
            output.Dispose();
        }
    }

    public void Dispose() => Stop();
}
