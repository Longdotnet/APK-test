# ADR 0008: Canonical expressive sustain compiles before playback

## Status
Accepted

## Context

MIDI and other richer notation formats carry sustain/pedal state that cannot be represented safely by simply stretching every note or by teaching the Windows input backend about MIDI semantics. Playback truth must remain independent of import format, UI, AI and platform input.

Roblox keyboard playback also needs repeated pitches to remain re-triggerable. Naively holding a key for the entire pedal window can suppress the next NoteOn of the same pitch when reference-counted key ownership is active.

## Decision

Introduce a canonical expressive layer consisting of `ExpressivePerformanceTrack`, `PerformanceControlEvent`, and `PerformanceControlKind`. Sustain is lowered deterministically by `ExpressivePerformanceCompiler` into the existing duration-aware `PerformanceTrack` before playback.

The compiler contract is:

- no controls returns the original `PerformanceTrack` instance so Legacy x2 representation and quality fingerprints remain unchanged;
- NoteOffs that occur while sustain is down are extended to the next SustainUp;
- a repeated same-key NoteOn truncates the earlier sustained hold at the retrigger boundary so the existing KeyUp-before-KeyDown ordering can re-articulate the pitch;
- sustain left down at end-of-track is repaired deterministically to the canonical timeline boundary;
- invalid transitions (`SustainUp` without a prior down, duplicate down, ambiguous multiple transitions at one timestamp, out-of-range controls) are rejected before playback;
- compiled sustained notes are ordinary canonical duration events, so existing seek slicing naturally re-enters notes that are still sounding across a seek boundary;
- `PlaybackKernel`, `ReferenceCountedInputSink`, Windows input, Sheet Library, AI and UI remain unaware of source-format sustain semantics.

## Consequences

Future MIDI/MusicXML importers can target a deterministic expressive model without coupling import logic to Windows or Roblox. Transport, release-all, stuck-key prevention, timing calibration and quality tooling continue to operate on one canonical playback path.

The current legacy TXT/VPS importer does not create sustain controls, so shipped legacy playback is intentionally unchanged. This phase establishes the production semantics and regression gate before MIDI import is allowed to depend on them.
