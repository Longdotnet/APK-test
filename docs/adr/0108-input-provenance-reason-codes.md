# ADR 0108 — Reason-coded synthetic matrix provenance

## Status

Accepted for Runtime Input P0 Phase 85.

## Context

Phases 81–84 made synthetic matrix evidence fail closed for physical target-key contamination, malformed target-key transitions, missing retained provenance, lower-integrity injected events, and replayed probe IDs. The matrix trust state intentionally collapsed these cases to `Missing`, `Clean`, or `Contaminated`.

That is sufficient for decision safety but weak for field support. A single client log could show that a cell stayed pending without stating whether the exact blocker was a replayed probe identity, UIPI/integrity mismatch, physical W contamination, malformed sequence, or incomplete injected pair.

## Decision

The retained probe registry now derives a deterministic provenance reason alongside trust:

- `MissingSnapshot`
- `CleanInjectedPair`
- `DuplicateProbeId`
- `LowerIntegrityInjected`
- `PhysicalTargetContamination`
- `UnexpectedTargetTransition`
- `IncompleteInjectedPair`

Every record attempt emits one `INPUT_MATRIX_PROVENANCE` line with the stable probe ID, trust, and exact reason. Duplicate record attempts emit a second line showing `DuplicateProbeId`; the first immutable snapshot is still retained.

Reason classification is diagnostic-only. Existing matrix eligibility remains fail closed and production input semantics do not change.

## Consequences

- One support log can identify the provenance failure class without inferring it from several low-level counters.
- Replay, integrity, physical contamination, sequence, and incomplete-pair failures remain distinct investigation boundaries.
- Reason codes cannot authorize playback or establish `FIELD_CONFIRMED_PASS`.
- Production `keybd_event`, diagnostic SendInput variants, focus authorization, scheduler truth, held-key/pedal ownership, emergency release, Legacy, and Legacy x2 remain unchanged.
- Explicit visible Roblox movement or piano reaction from the production executable remains mandatory for field PASS.
