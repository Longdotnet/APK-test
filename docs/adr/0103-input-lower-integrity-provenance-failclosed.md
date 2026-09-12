# ADR 0103 — Lower-integrity synthetic provenance fails closed

## Status

Accepted for Runtime Input P0 Phase 83.

## Context

Phase 82 bound synthetic matrix verdicts to exact-probe low-level keyboard provenance. The retained `UncontaminatedInjectedPairObserved` predicate intentionally accepted both ordinary `LLKHF_INJECTED` and `LLKHF_LOWER_IL_INJECTED` events. That made lower-integrity injected down/up pairs eligible to establish either a synthetic winner or the cross-cell `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION` boundary.

Runtime Input P0 explicitly treats integrity/UIPI boundaries as an unresolved failure class. Windows marking an event `LLKHF_LOWER_IL_INJECTED` is therefore evidence of a trust-boundary mismatch, not evidence that can safely close the Roblox-consumption boundary.

## Decision

The matrix provenance registry now fails closed whenever the exact probe snapshot contains any lower-integrity injected target-W event or either retained down/up provenance is `LowerIntegrityInjected`.

Such evidence remains fully logged for diagnostics, but matrix trust becomes `Contaminated`. The cell stays pending and must be rerun after the integrity mismatch is understood or removed. Ordinary same-integrity injected down/up pairs remain eligible when all existing contamination, transition, focus, desktop, session, Windows-delivery, and human-reaction requirements are also satisfied.

Production injection semantics are unchanged.

## Consequences

- A lower-integrity injected `YES` cannot prove that a synthetic variant reaches Roblox.
- A lower-integrity injected `NO` cannot contribute to `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`.
- `LLKHF_LOWER_IL_INJECTED` remains visible forensic evidence instead of being discarded.
- The stricter rule may require clients with elevation/integrity mismatches to rerun after correcting that environment, which is preferable to a false field conclusion.
- `FIELD_CONFIRMED_PASS` still requires explicit visible Roblox movement or piano reaction from production `RobloxPiano.exe`.
