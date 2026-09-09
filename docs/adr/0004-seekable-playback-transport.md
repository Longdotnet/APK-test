# ADR-0004: Safe seekable playback transport

- Status: Accepted
- Date: 2026-09-09

## Context

The production kernel already owns deterministic edge scheduling, focus-loss safety and final release-all behavior. The desktop client added live speed and pause, but it still behaved like a fire-and-forget player: once playback started, a client could not choose a starting point or seek without stopping and restarting the application flow manually.

A naive seek implementation is dangerous. Jumping the UI clock without rebuilding canonical note state can leave an old key held, omit the NoteOn for a note that crosses the seek boundary, or send a future NoteOff for a NoteOn that never occurred. UI-owned note state would also violate the architecture boundary that keeps playback truth in Core.

## Decision

### 1. Seek is a canonical transport operation

`PlaybackTransport.Slice` converts a source `PerformanceTrack` plus a canonical start position into another valid `PerformanceTrack`.

- events entirely before the seek point are removed;
- future events are shifted by the seek offset;
- an event already active at the seek point is re-entered at slice time zero with only its remaining duration;
- source metadata and canonical semantics are preserved;
- the slice has no start delay because countdown is a client concern.

The playback kernel therefore continues to consume only canonical tracks and remains importer/UI independent.

### 2. Runtime seek reuses the one PlaybackKernel scheduler

`PlaybackTransportSession` does not implement another scheduler. A runtime seek:

1. records the requested canonical position;
2. cancels the currently running kernel slice;
3. relies on the kernel `finally` path to `ReleaseAll` held input;
4. builds a new canonical slice;
5. starts the same `PlaybackKernel` from slice time zero.

This ordering guarantees that old held-key state is cleared before any note is re-entered after the seek.

### 3. Position tracking excludes focus-loss downtime

The transport observes the same focus gate passed to the kernel and subtracts inactive time from its public position. The UI therefore does not appear to consume song time while Roblox is unfocused or playback is user-paused.

The focus observer is transport telemetry/state only; it does not authorize input. The kernel remains the component that decides when edge dispatch may occur.

### 4. Desktop client exposes seek without owning music state

The product shell adds:

- a timeline slider;
- `-10s` and `+10s` controls;
- pre-play start-position selection;
- live seek during playback;
- current/total position display.

Dragging or jumping the timeline delegates to `PlaybackTransportSession.Seek`. The form never decides which notes should be held at the destination.

### 5. Legacy baseline remains unchanged

The fixed-speed diagnostic CLI and its quality/A-B instrumentation still run the original full canonical track through `PlaybackKernel`. Seek transport is an interactive product feature and does not redefine the `Legacy x2` quality baseline.

## Regression policy

Automated transport tests must prove at minimum:

- seek into an active note clips/re-enters it deterministically;
- impossible seek positions fail explicitly;
- runtime seek releases old held state before re-entry;
- a clipped re-entered note still receives a matching key-up;
- public position does not consume target-focus downtime;
- all legacy parser, x2, quality, Windows build, single-file publish and clean-machine smoke gates remain green.

## Consequences

The desktop client becomes a real transport rather than a one-shot launcher while the architecture remains layered:

```text
UI seek intent
    |
    v
PlaybackTransportSession
    |
    +-- cancel current slice -> PlaybackKernel finally -> ReleaseAll
    |
    +-- PlaybackTransport.Slice(canonical track, position)
    |
    v
same PlaybackKernel
```

This also establishes the deterministic transport boundary needed before richer MIDI/MusicXML import, piano-roll navigation and future latency calibration are added.
