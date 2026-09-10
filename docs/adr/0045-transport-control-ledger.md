# ADR 0045 — Transport control ledger

## Status

Accepted for Production Phase 40.

## Context

Phase 39 froze session-start provenance, but a live user can still change speed with F6/F7 or seek during playback. A record containing only start speed plus aggregate seek count cannot prove two runs followed the same transport-control history. That makes future Legacy ↔ Legacy x2 reproduction vulnerable to false comparisons.

## Decision

The deterministic transport owns an append-only control ledger as part of its quality evidence. The ledger records only privacy-safe canonical facts:

- session start canonical position and initial playback speed when the clock is a `PlaybackSessionClock`,
- every committed runtime speed transition, captured after `PlaybackSessionClock` updates its monotonic logical anchor,
- every requested seek target in canonical timeline seconds.

Control events are sequence-numbered and immutable once observed. They live beside segment/timing evidence in `PlaybackTransportQualityReport`; schema version is raised to 2.

`PlaybackSessionClock.SpeedChanged` is observational. Subscriber failures are swallowed so diagnostics can never become playback truth or perturb scheduler/input behavior. The transport unsubscribes on dispose to prevent stale-session retention.

The existing segment model remains authoritative for seek completion/interruption and unexpected missing-edge classification. The control ledger describes user/control intent; it does not replace segment evidence.

## Consequences

- Dynamic speed history can now be distinguished from start-speed provenance.
- Seek targets can be matched against quality segment boundaries when building controlled reproduction.
- Future A/B logic can fail closed when two runs have different transport-control histories instead of silently comparing them.
- No source path, raw note content, key-by-key input sample, username, or machine identity is added.
- Playback scheduling, authorization, focus guard, release-all and canonical track identity remain unchanged.

## Regression contract

Production validation must prove that a run containing both a speed transition and seek produces ordered control events with the original start speed, changed speed, canonical seek target, no false missing-edge regression, and normal playback completion.
