# ADR 0102 — Input matrix provenance binding

## Status

Accepted for Runtime Input P0 Phase 82.

## Context

Phase 81 made physical/non-injected target-W contamination and malformed target-key transitions observable through bounded `WH_KEYBOARD_LL` evidence. The field matrix still classified a synthetic cell only from its retained reaction verdict (`ROBLOX_REACTED` / `ROBLOX_NO_REACTION`) and session identity. A contaminated synthetic attempt could therefore remain eligible for a conclusive cross-cell matrix result even though its low-level evidence was explicitly untrustworthy.

That creates two false-attribution risks: a physical W pressed during a synthetic cell can make Roblox appear to react to the synthetic backend, or a contaminated `NO` can contribute to `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION` even though the attempted sequence was not clean.

## Decision

Each completed bounded synthetic low-level observation is retained under its unique probe ID in a process-local, bounded evidence registry. The registry keeps at most 256 target-key-only snapshots and never authorizes playback.

A synthetic matrix cell is Windows-boundary-confirmed for cross-cell assessment only when the same probe ID has a retained snapshot with `UncontaminatedInjectedPairObserved=true`. Missing provenance and contaminated/malformed provenance both fail closed and leave that cell pending.

This trust requirement applies symmetrically to positive and negative human reactions. A contaminated `YES` cannot prove `SYNTHETIC_VARIANT_REACHES_ROBLOX`; a contaminated `NO` cannot contribute to `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`.

Session identity, current reaction-context freshness, focus/window continuity, Windows key-state evidence, input-desktop checks, and explicit visible Roblox reaction remain independent mandatory evidence. Production injection semantics are unchanged.

## Consequences

- Phase 81 contamination detection now controls the matrix decision that consumes it rather than remaining log-only evidence.
- Old or incomplete synthetic evidence without a matching low-level snapshot cannot silently become conclusive.
- A retry uses a new probe ID and can replace the stale matrix cell only after its own provenance is clean.
- The registry is bounded and stores only W-target forensic metadata; it records no unrelated keyboard activity.
- `FIELD_CONFIRMED_PASS` still requires explicit visible Roblox consumption. Windows provenance is not a substitute for Roblox field evidence.
