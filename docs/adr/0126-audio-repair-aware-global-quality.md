# ADR 0126: Repair-aware global Audio-to-Piano quality

## Status

Accepted for Audio-to-Piano OSS Phase 40.

## Context

Phase 39b made review repair explicit and safe, but client readiness still treated the transcription-time global quality assessment as permanently authoritative. That was intentionally conservative, yet it also meant a successful explicit repair could remove a density problem from the canonical `PerformanceTrack` while the old `EVENT_DENSITY_HIGH`, retention, loss, or coverage snapshot remained unchanged.

Not every quality signal is allowed to move after repair. Basic Pitch activation confidence and harmonic-suppression pressure describe source/model evidence and must not be erased merely because a later arrangement sounds cleaner. Unknown future rejection reasons also cannot be silently promoted by an older repair evaluator.

## Decision

Add a repair-aware deterministic quality evaluator with a strict provenance split.

The following evidence is recomputed from the **current canonical `PerformanceTrack`** after an explicit Apply:

- note-voice retention relative to the retained post-suppression Basic Pitch evidence;
- canonical transform-loss ratio (`1 - retention`);
- actual timeline coverage derived from event ends rather than stale metadata;
- note-voice density per source second.

The following evidence remains immutable from the transcription-time base assessment:

- low-activation ratio;
- mean activation;
- harmonic-suppression ratio;
- source/model warning and critical reason codes.

Known mutable reason codes are removed and regenerated against the configured quality thresholds. Unknown reasons are retained. If the base assessment was `Rejected` for a reason the repair evaluator does not understand, rejection remains sticky and fail-closed.

`AudioTranscriptionReviewRepairSession` owns the current repair-aware global assessment when a base assessment is supplied. Preview never recomputes or mutates quality. Apply computes candidate regions and candidate quality before committing session state, preserving cancellation atomicity. Revert restores the exact base assessment together with the exact original generated performance.

## Consequences

- An explicit repair can legitimately improve global readiness when it actually fixes track-derived density/retention/coverage evidence.
- A cleaner arrangement cannot erase weak Basic Pitch activation, harmonic-artifact pressure, or unknown future source-level failures.
- `PerformanceTrack` remains canonical playback truth; quality only classifies it.
- No additional Basic Pitch/ONNX inference is required and no new OSS/runtime dependency is introduced.
- Client UI integration can consume `CurrentQuality` in a later client-facing slice without inventing a second quality policy.

## Non-goals

This ADR does not alter Basic Pitch decoding, harmonic suppression, Roblox arrangement policy, Library persistence, Roblox scheduling, focus/input authorization, or Runtime Input P0 semantics.
