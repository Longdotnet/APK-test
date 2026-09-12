# ADR 0110: Reaction-bound synthetic provenance

## Status

Accepted for Runtime Input P0 Phase 86.

## Context

Phases 82–85 bind synthetic matrix decisions to exact probe IDs, fail closed on contaminated/lower-integrity evidence, make probe IDs single-assignment while retained, and expose deterministic rejection reasons.

The process-local probe registry is intentionally bounded to 256 snapshots and can also be reset for diagnostics. Matrix cells previously looked up provenance from that mutable registry every time the matrix was assessed. A human Yes/No reaction that was clean when retained could therefore become `MissingSnapshot` after unrelated later probes evicted its snapshot or diagnostics reset the registry. Conversely, provenance appearing later under the same textual ID could change the meaning of an older reaction.

That makes historical field evidence depend on future process-local cache state instead of the exact observation available when the reaction was retained.

## Decision

`RobloxInputMatrixCellEvidence` captures the synthetic provenance assessment at construction time, alongside the probe ID, verdict, human Roblox reaction, and probe-start Roblox session identity.

For synthetic cells:

- clean provenance remains clean for that retained reaction even if the bounded registry is later evicted/reset;
- contaminated provenance remains contaminated and cannot be upgraded by later registry state;
- missing provenance remains missing and cannot be backfilled after the human reaction was retained;
- the captured reason (`CleanInjectedPair`, `DuplicateProbeId`, `LowerIntegrityInjected`, `PhysicalTargetContamination`, `UnexpectedTargetTransition`, `IncompleteInjectedPair`, or `MissingSnapshot`) travels with the retained matrix cell;
- matrix policy consumes only the reaction-bound assessment, never a later lookup by probe ID.

Real-key baseline behavior is unchanged and does not require synthetic provenance.

## Safety and product boundaries

This is evidence-integrity hardening only. It does not change `keybd_event`, SendInput diagnostics, production scheduler semantics, focus authorization, held-key/pedal ownership, emergency release, Legacy, or Legacy x2.

A clean reaction-bound synthetic cell proves only that the exact attempt satisfied the Windows-side provenance contract. It does not prove Roblox consumed the input. `FIELD_CONFIRMED_PASS` still requires explicit visible Roblox movement or the expected piano reaction from production `RobloxPiano.exe`.

## Regression contract

Tests must prove that:

1. a clean retained reaction survives registry reset/eviction;
2. a contaminated retained reaction cannot be upgraded by a later clean record using the same textual ID;
3. a reaction retained with missing provenance cannot be upgraded by provenance recorded afterward.
