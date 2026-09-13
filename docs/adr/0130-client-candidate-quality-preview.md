# ADR 0130 — Client candidate quality preview remains presentation-only

## Context

Phase 42 added side-effect-free deterministic quality assessment and ranking for repair candidates. The production client already shows current repair quality and supports explicit Preview/Apply/Revert, but the ranking evidence was not visible to a normal client before Apply.

## Decision

Create Piano Version surfaces a bounded recommendation for the next flagged region through the existing quality presentation. It reports predicted readiness, density, retention, transform loss, resolved/introduced warning counts, selected-region resolution and remaining review-region count for each deterministic candidate.

The recommendation is derived from `AudioTranscriptionReviewRepairSession.RecommendCandidate`. It is presentation evidence only: it does not change the selected repair kind, call Apply, persist to Library, authorize input, or schedule playback. Explicit Apply remains the sole canonical repair mutation boundary.

Only the next current review region is evaluated for client presentation. This keeps UI refresh cost bounded to at most the available deterministic candidates instead of evaluating every remaining region. After explicit Apply or Revert, the session state changes and the next presentation is recomputed from the new canonical state.

## Consequences

- Clients can see likely repair quality trade-offs before committing a mutation.
- Basic Pitch inference is not repeated; retained note evidence and the canonical `PerformanceTrack` remain authoritative inputs.
- Recommendation ordering remains deterministic and revision-bound.
- Source/model warnings remain visible through the repair-aware quality contract.
- No Runtime Input behavior changes and no end-to-end Roblox playability claim is implied.
