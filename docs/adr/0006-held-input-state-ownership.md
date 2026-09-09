# ADR 0006: Held input state belongs above the platform backend

## Status

Accepted for Roblox Piano v0.6.1.

## Context

The canonical timeline can contain overlapping events that address the same physical Roblox piano key. This becomes common with duration-aware importers such as MIDI and can also appear after transport slicing/re-entry.

A raw `KeyDown`/`KeyUp` stream is insufficient when two logical notes overlap on the same key. If both logical notes send `KeyDown(a)` and the first note later sends `KeyUp(a)`, the physical key is released even though the second note still owns a hold. Focus loss, seek, stop, cancellation and input failure add another stale-edge class: after an emergency release-all, a later `KeyUp` from the old slice must not be treated as authoritative state.

## Decision

Introduce `ReferenceCountedInputSink` in deterministic Core and make the interactive `PlaybackTransportSession` wrap its platform input sink with this ownership layer.

Rules:

- first logical hold for a key emits the physical KeyDown;
- additional overlapping logical holds increment ownership without repeating physical KeyDown;
- KeyUp decrements one logical hold;
- physical KeyUp is emitted only when the final logical owner releases;
- `ReleaseAllAsync` delegates to the physical safety path and clears every logical hold only after that path succeeds;
- KeyUp edges for keys no longer owned after release-all are ignored as stale rather than resurrecting or corrupting state;
- failed physical KeyDown does not commit logical ownership;
- the Windows backend remains responsible only for mapping characters to scan codes and actually sending/releasing keys;
- UI, TXT/VPS parsing, future MIDI/MusicXML importers and AI do not own held-key truth.

The existing `PlaybackKernel` remains the single scheduler. This change does not alter canonical event timing, Legacy x2 parsing semantics, speed, seek positions or quality-plan fingerprints.

## Consequences

Interactive playback becomes safe for overlapping same-key durations and for stale KeyUp edges after seek/focus-loss/stop release paths. Future expressive/MIDI work can rely on explicit held-state ownership instead of encoding accidental assumptions in the Windows adapter.

A dedicated deterministic regression harness covers same-key overlap, mixed chord overlap, emergency release invalidation and physical input failure atomicity. Production CI must run that harness before building/releasing the client.
