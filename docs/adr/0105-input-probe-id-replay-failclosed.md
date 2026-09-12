# ADR 0105 — Synthetic probe IDs are single-assignment evidence identities

## Status

Accepted for Runtime Input P0 Phase 84.

## Context

Phase 82 bound matrix decisions to retained low-level keyboard provenance by probe ID. The registry contract says probe IDs are unique, but the implementation previously replaced an existing snapshot when the same ID was recorded again.

That overwrite made evidence mutable after capture. A duplicated/replayed ID could replace an earlier contaminated snapshot with a later clean snapshot, or replace a clean snapshot with different evidence, while the human reaction and other matrix state still referred to the same textual probe identity.

## Decision

Probe evidence is now single-assignment. The first snapshot retained for a probe ID is immutable. Any second record attempt for the same retained probe ID marks that identity contaminated and matrix trust fails closed.

The duplicate marker is removed only when the bounded registry entry itself is evicted or when diagnostics state is explicitly reset. The registry remains capped at 256 snapshots.

Production injection semantics are unchanged.

## Consequences

- A replayed probe ID can never upgrade contaminated evidence to clean evidence.
- A replayed probe ID can never remain trusted merely because the first snapshot happened to be clean.
- The original snapshot remains available for forensic inspection instead of being silently replaced.
- Matrix cells using a duplicated ID remain pending and require a fresh probe with a new ID.
- No Windows-only evidence establishes `FIELD_CONFIRMED_PASS`; explicit visible Roblox reaction remains mandatory.
