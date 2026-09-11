# ADR 0067: Basic Pitch note-decoding boundary

## Status

Accepted.

## Context

Audio-to-Piano OSS Phase 02 established a bounded native .NET inference boundary around Spotify Basic Pitch's ICASSP 2022 ONNX model. That boundary intentionally returns only raw `note`, `onset`, and `contour` probability tensors. The next production boundary must turn those tensors into stable musical note events without introducing Python, NumPy, SciPy, PrettyMIDI, or playback ownership into the Windows client.

Spotify's Apache-2.0 `basic_pitch/note_creation.py` defines the post-processing semantics we need to preserve: onset thresholding, inferred onsets from frame differences, reverse-time onset consumption, frame-energy note termination, Melodia-style recovery for notes without a strong onset, model-frame time correction, optional frequency constraints, and contour-derived pitch bends. The MIT `sevagh/basicpitch.cpp` native port is an additional implementation reference for translating the same behavior away from Python dependencies.

## Decision

`RobloxPiano.Audio` owns a deterministic `BasicPitchNoteDecoder` that consumes `BasicPitchRawOutput` and produces immutable `BasicPitchTranscribedNote` values.

The decoder:

- validates tensor shape and probability ranges before decoding;
- clones note/onset activations before applying frequency constraints or inferred-onset processing, so inference output remains immutable evidence;
- preserves Spotify's default thresholds (`0.5` onset, `0.3` frame), minimum note length (`11` frames), energy tolerance (`11` frames), and Melodia recovery by default;
- preserves Spotify's MIDI offset of 21 and 88-note piano range;
- preserves Spotify's model-frame-to-time alignment correction rather than assuming a uniform frame clock across inference windows;
- exposes contour pitch bends in the model's native one-third-semitone units instead of prematurely converting them into MIDI controller values;
- checks cancellation during expensive decoding loops;
- keeps frequency filtering explicit and deterministic;
- returns note data only. It does not create MIDI, mutate `PerformanceTrack`, choose Roblox voicings, schedule keys, authorize input, or own playback state.

Synthetic parity fixtures cover onset/energy termination, inferred onsets, Melodia recovery, contour pitch bends, frequency constraints, and invalid activation rejection. The existing real-model inference test remains responsible for the ONNX boundary itself.

## Consequences

The production pipeline is now structurally:

`client-owned audio -> NAudio normalize/resample -> ONNX Runtime Basic Pitch inference -> deterministic Basic Pitch note decoding -> future Roblox piano arranger -> canonical PerformanceTrack`.

This avoids a Python runtime and avoids reimplementing the neural network. The remaining work is domain-specific: adapt decoded notes into a playable Roblox 61-key arrangement, measure quality/confidence, and expose the workflow to the client only after those boundaries are production-ready.

This phase is internal infrastructure and does not change the current `RobloxPiano.exe` artifact or version.

## Upstream provenance

Behavior is intentionally compatible with Spotify Basic Pitch `basic_pitch/note_creation.py` (Apache License 2.0). `sevagh/basicpitch.cpp` (MIT) is used as a native-port reference. Existing repository third-party attribution for Basic Pitch/ONNX Runtime remains applicable; copied source is not vendored wholesale.
