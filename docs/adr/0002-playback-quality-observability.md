# ADR-0002: Playback quality observability and scheduler A/B gate

- Status: Accepted
- Date: 2026-09-09

## Context

The first production slice deliberately preserved the working Legacy `x2` behavior because the experimental duration-hold player sounded less recognizable even though it appeared richer on paper. That incident established an important product rule: a newer playback implementation cannot be promoted merely because it has more features.

The next production problem is observability. Before MIDI, MusicXML, articulation inference, OMR, or AI can safely change playback semantics, the product must be able to answer deterministic questions such as:

- were all planned key-down/key-up edges dispatched?
- how far did dispatch timing drift from the canonical plan?
- what was p95 and worst-case scheduler error?
- how much time was spent inside the Windows input call?
- did Roblox lose foreground focus during the run?
- did diagnostics themselves alter playback behavior?
- are two timing reports actually comparable, or are they from different plans/speeds?

Without these measurements, A/B decisions collapse back into version-number assumptions and subjective guesses.

## Decision

### 1. Observe at the Core interface boundary, not inside Windows or UI code

`PlaybackInstrumentation` decorates `IInputSink` and `IFocusGate` while the existing deterministic `PlaybackKernel` remains the scheduler owner.

```text
canonical PerformanceTrack
        |
        v
  PlaybackKernel
        |
        +------ IFocusGate ---- PlaybackInstrumentation ---- real focus gate
        |
        +------ IInputSink ---- PlaybackInstrumentation ---- real/trace input
                                 |
                                 v
                         PlaybackQualityCollector
```

This preserves the Phase 01 kernel boundary and prevents diagnostics from becoming a second scheduler implementation.

### 2. Scheduler error is relative to the first real dispatch

Quality telemetry intentionally does not treat startup delay as scheduler jitter. The first dispatched edge establishes the run origin. Later dispatches are compared with their expected relative offsets after applying playback speed.

Foreground-focus pauses are measured separately and removed from relative scheduler timing. This makes a pause visible without falsely classifying the deliberate pause as scheduler drift.

The report therefore measures continuity/timing execution after playback begins. It does not claim to measure audio-device latency, Roblox rendering latency, network latency, or human perception.

### 3. Instrumentation must be failure-isolated

Observer callbacks are wrapped so an exception in diagnostics cannot interrupt live playback. The deterministic playback/safety path remains more important than telemetry.

Input backend failures, dispatch-plan mismatches, missing edges, and release-all failures are recorded as quality failures when observable, but the instrumentation does not silently repair or reorder playback.

### 4. Reports are machine-readable and versioned

`PlaybackQualityReport` schema version 1 includes:

- plan fingerprint;
- speed;
- planned/dispatched/missing edge counts;
- failure count;
- focus pause count and duration;
- release-all count;
- mean signed timing error;
- mean absolute timing error;
- p95 absolute timing error;
- maximum absolute timing error;
- mean/max input-call duration;
- worst timing samples.

The client can write a JSON report with:

```text
RobloxPiano.exe song.txt --speed 2 --quality-report legacy-x2.json
```

A failed/cancelled playback also attempts to persist a partial report when an output path was requested.

### 5. A/B comparison is guarded by a deterministic plan fingerprint

The fingerprint is SHA-256 over the ordered canonical playback edges plus speed. Timing A/B comparison refuses to compare reports produced from different canonical plans or speeds.

This prevents a misleading result such as declaring a new articulation model faster simply because it generated fewer/different events.

The current comparator classifies scheduler execution as:

- `Better`
- `Equivalent`
- `Worse`
- `Inconclusive`
- `Incomparable`

A run that lost foreground focus is `Inconclusive` for promotion purposes even though pause time is normalized out of the timing statistics. Promotion-quality A/B runs should be repeated without focus interruption.

### 6. The quality gate is scheduler-only

`--baseline-report` compares the current run against a prior report. `--quality-gate` returns a non-zero process exit code unless the candidate is `Better` or `Equivalent`.

This gate is deliberately named and documented as a **scheduler execution** gate. It must not be presented as proof that a song sounds more like the reference recording.

Perceptual/music similarity requires a later reference-audio/MIR layer and potentially human A/B evidence. Scheduler telemetry is a prerequisite, not a substitute.

### 7. Legacy x2 remains the product regression anchor

A practical baseline workflow is:

```text
RobloxPiano.exe song.txt --speed 2 --quality-report legacy-x2.json

# later candidate using the same canonical plan
RobloxPiano.exe song.txt --speed 2 \
  --quality-report candidate.json \
  --baseline-report legacy-x2.json \
  --quality-gate
```

When future candidate engines change the canonical plan itself, this timing comparator will intentionally say `Incomparable`. That candidate must be evaluated by the later musical/perceptual comparison layer rather than forcing unlike plans through a scheduler-only metric.

## Consequences

Positive:

- scheduler regressions become measurable;
- missing/stuck/failing dispatch paths become easier to diagnose;
- focus-loss runs cannot silently contaminate promotion decisions;
- diagnostics remain independent of AI and network availability;
- JSON reports can become CI artifacts or user support bundles later;
- the single-EXE client contract remains unchanged.

Trade-offs:

- relative telemetry cannot measure the first note's absolute startup lateness;
- successful `SendInput` dispatch does not prove Roblox audibly rendered the note;
- scheduler A/B cannot compare deliberately different musical plans;
- perceptual similarity still requires later reference-audio analysis and/or human evidence.

These limits are explicit so future phases extend the measurement model instead of overstating what current telemetry proves.
