# ADR 0153: Cross-section harmony continuity stays confidence-bounded

## Status
Accepted for Audio-to-Piano OSS Phase 64.

## Context
Phase 63 improved dense mixed-song chord voicing by reserving credible low harmony and preferring pitch-class coverage over near-confidence octave clutter. That policy still treated every onset cluster independently. In a song with a sparse verse followed by a dense transition/chorus, two similarly credible accompaniment candidates can therefore cause avoidable chord-tone or octave jumping even though the immediately preceding section supplies useful harmonic context.

Spotify Basic Pitch is polyphonic and instrument-agnostic, but upstream documentation states that it works best on one instrument at a time. Full-song mixtures can therefore contain competing simultaneous activations that deterministic Roblox arrangement must bound rather than treat as equally authoritative.

## Decision
The arranger may use recent accompaniment context only as a bounded tie-break among current decoded Basic Pitch candidates.

- Sparse clusters capture their non-melody accompaniment as context even when no density reduction is needed.
- Dense clusters may prefer a pitch class present in recent context only when its current activation is at least `HarmonyContinuityRelativeActivationFloor` of the strongest current representative.
- Context expires after `HarmonyContinuityWindow`; the default is 1.8 seconds and callers may configure a validated bounded value.
- Existing adaptive-density, bass-anchor, octave-representative and weak-note confidence guards remain authoritative. Continuity cannot synthesize a note or bring back a candidate already filtered by current evidence.
- `HarmonyContinuitySelections` reports when recent harmonic context changed a pure-confidence baseline survivor.
- `RobloxPiano.Core.PerformanceTrack` remains canonical playback truth. Continuity is arrangement policy only and does not change scheduler, target focus, key injection, held-key/pedal ownership or Runtime Input P0.

## OSS and packaging impact
No new implementation is copied and no new runtime is introduced. Spotify Basic Pitch remains the AMT/model-semantics source; Microsoft ONNX Runtime, NAudio and DryWetMIDI boundaries remain unchanged. Demucs/native separation remains deferred while deterministic mixed-song quality gates hold.

Phase 64 adds no Python, PyTorch, ffmpeg, source-separation model, NuGet package or native runtime, so it introduces no new third-party license or NOTICE obligation.

## Validation
Regression coverage must prove both directions:

1. a sparse-to-dense transition retains a credible prior harmony pitch class while preserving melody, bass/root evidence and weak-note rejection; and
2. the same dense evidence after a long gap ignores stale harmony context and returns to current-section confidence ordering.

Existing real-model Basic Pitch mixed-instrument stress, generated-MIDI parity and production smoke gates remain mandatory so continuity cannot improve a synthetic fixture while regressing the production audio path.
