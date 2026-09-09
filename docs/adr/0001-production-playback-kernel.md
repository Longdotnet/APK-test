# ADR-0001: Canonical timeline and deterministic playback kernel

- Status: Accepted
- Date: 2026-09-09

## Context

The PowerShell prototype proved that Roblox virtual-piano playback is viable, but it also exposed a production risk: a newer duration-aware experiment sounded worse than the older player running the same recognizable song at `x2` speed.

That failure was useful. It showed that version number, feature count, and apparently richer note semantics are not sufficient evidence that playback quality improved. The product needs a stable baseline, deterministic timing ownership, explicit safety behavior, and measurable regression gates before more import/AI/OMR features are added.

The repository previously contained only a placeholder on `main`, so this slice can establish the production boundaries without preserving accidental coupling.

## Decision

### 1. Canonical performance model owns playback truth

Playback consumes `PerformanceTrack` / `PerformanceEvent`, not raw TXT tokens.

Importers are adapters:

```text
legacy TXT ----+
MIDI (future) -+--> canonical timeline --> playback
XML (future) --+
OMR (future) --+
```

The playback engine must not know which importer produced an event.

### 2. Scheduling is absolute and monotonic

The kernel plans key-down/key-up edges at absolute offsets and schedules them against a monotonic clock. It does not implement the song as a chain of relative sleeps.

Speed is applied as a timeline transform. `--speed 2` therefore preserves the old `x2` behavior as a deliberate regression baseline rather than a manual workaround hidden outside the engine.

### 3. Key release is a safety invariant

Injected keys must be released on:

- normal completion;
- cancellation;
- input backend failure;
- detected focus loss.

The core owns the `finally` release path. The Windows backend also keeps its own held-key set so release-all is idempotent and best effort.

### 4. Roblox focus is a hard gate

Live input does not intentionally begin while Roblox is not the foreground process. During timeline waits, focus is polled frequently. Focus loss triggers release-all and pauses logical playback time until focus returns.

This prevents a deterministic music feature from turning into uncontrolled typing in another application.

### 5. Legacy semantics are frozen until a candidate proves better

The stable legacy importer supports the established one-token-per-step semantics, chords, rests, headers, loops, case-sensitive keys, and separator compatibility.

The experimental `{duration}` syntax is intentionally rejected by the stable importer. The previous V5 experiment demonstrated that silently changing duration semantics can reduce perceptual quality. Duration-aware playback is valid only through the canonical model and must pass an A/B/regression quality gate before becoming the default behavior.

### 6. AI is optional and cannot own mutation truth

AI may later advise on low-confidence OMR, voicing, articulation, repair, or explanations. It must not be required for deterministic import, validation, playback, safety, or client startup.

No network/API/model dependency is introduced in the playback kernel.

### 7. Shipping is part of the phase, not a later tutorial step

The same phase establishes CI that:

- builds with warnings as errors;
- runs deterministic regressions;
- builds the Windows adapter;
- publishes self-contained `win-x64`;
- verifies the distribution contains exactly one `RobloxPiano.exe`;
- starts that published EXE in a smoke test;
- uploads the EXE as the client artifact.

A production phase is not complete when code merely compiles on a developer machine.

## Regression baseline

`PLAYBACK-001`:

```text
Scenario: Chắc Ai Đó Sẽ Về legacy sheet
Baseline: legacy semantics at 2.0x
Observed: more recognizable than the duration-hold V5 experiment
Rule: a candidate playback mode cannot replace legacy default solely because it is newer.
```

The current automated suite measures deterministic semantics (timeline, edge order, speed transform, validation, release safety). A later playback-quality phase will add candidate-vs-baseline timing/jitter/overlap metrics and structured A/B evidence before changing defaults.

## Consequences

Positive:

- importer and UI growth no longer contaminates the playback engine;
- timing regressions can be tested without Windows or Roblox;
- focus/input safety has one clear owner;
- legacy x2 remains reproducible;
- a single client EXE is enforced from the first production slice;
- AI can be added without becoming an availability dependency.

Trade-offs:

- the first release host is intentionally small and CLI-oriented; a desktop product shell will sit on top of the same core later;
- perceptual similarity is not yet automatically measured, so legacy remains the protected default;
- actual Roblox acceptance of injected scan-code events still requires a Windows/Roblox client test because CI cannot launch the game.

## Next production pressure

The next highest-value slice is playback-quality observability and A/B comparison around the protected legacy baseline: deterministic telemetry for scheduled/actual onset, release timing, jitter, overlap, focus pauses, missed/stuck-key detection, and a regression report that can compare candidate engines before promotion.
