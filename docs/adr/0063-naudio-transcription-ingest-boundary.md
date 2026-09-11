# ADR 0063: NAudio transcription ingest boundary

## Status
Accepted.

## Context
Audio-to-Piano needs a stable input contract before Basic Pitch/ONNX inference is introduced. Decoding WAV/MP3/AAC and resampling are mature audio infrastructure and should not be reimplemented inside RobloxPiano.Core or the future transcription model wrapper.

The production client must remain self-contained for normal Windows users and must not require Python, Node, a .NET SDK, FFmpeg installation, or developer tooling. The canonical `PerformanceTrack` and Roblox playback kernel must also remain independent from audio libraries and ML runtimes.

## Decision
Introduce `RobloxPiano.Audio` as a separate Windows audio-ingest boundary using the MIT-licensed NAudio 3.1.0 package.

The first normalized transcription contract is:

- IEEE float samples;
- mono;
- 22,050 Hz by default, matching Spotify Basic Pitch;
- finite samples clamped to [-1, 1];
- bounded duration with fail-closed behavior instead of silent truncation;
- cancellation-aware streaming reads.

Multi-channel input is deterministically averaged to mono and NAudio's maintained WDL resampler is used when the source sample rate differs from the transcription rate. Decoder/model concerns remain outside `RobloxPiano.Core`.

## Consequences
- Future Basic Pitch inference receives one stable PCM contract and does not own codec/resampling logic.
- Mature Windows codec behavior and resampling are reused rather than rewritten.
- Audio ingest can evolve independently from canonical performance state and Roblox input.
- Source separation and ML inference remain optional later layers; no Python/PyTorch runtime is introduced.
- The client UI does not expose this boundary yet, so this phase has no client release/version impact.

## Safety and resource bounds
The ingest service rejects empty audio and audio exceeding the configured maximum duration. Cancellation is checked between bounded reads. Long inputs are not silently truncated into a misleading transcription.

## Regression protection
`RobloxPiano.AudioTests` covers deterministic stereo downmix, 44.1 kHz to 22.05 kHz resampling, maximum-duration failure, empty audio and pre-cancelled ingest. `audio-oss-gate` runs the project build and harness on Windows for every PR and main push.
