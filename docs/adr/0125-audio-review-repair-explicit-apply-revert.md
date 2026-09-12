# ADR 0125: Explicit review-repair apply and revert boundary

## Status

Accepted for backend integration. Client A/B controls are a follow-up.

## Context

Phase 38 introduced deterministic Melody Priority and Simplified Harmony alternatives for a flagged Audio-to-Piano review region. Those candidates are intentionally derived artifacts, but the product still needs a state owner that prevents preview from becoming canonical truth accidentally and that can safely recompute review evidence after an explicit repair.

A candidate object alone is not sufficient for this boundary: a UI can retain stale candidates while the current generated track changes, or can accidentally persist the candidate it just previewed. Repair state therefore needs deterministic revision semantics and stale-region rejection before client-facing Apply/Revert controls are wired.

## Decision

Add `AudioTranscriptionReviewRepairSession` as an in-memory deterministic state owner for one generated piano result.

The session:

- snapshots the original canonical `PerformanceTrack` and keeps it immutable for exact revert;
- retains ordered Basic Pitch note evidence and reuses `AudioTranscriptionReviewRepairGenerator` plus `AudioTranscriptionReviewRegionAnalyzer`;
- exposes candidate generation/preview as side-effect-free operations;
- changes session canonical state only through explicit `Apply(region, kind)`;
- regenerates a candidate at apply time instead of trusting an old candidate object;
- rejects a review region that is stale or no longer present in current deterministic review evidence;
- re-runs review-region analysis after apply so repaired regions can disappear while remaining warnings stay visible;
- supports exact `Revert()` to the original generated track and re-runs review analysis;
- advances a monotonic revision only on successful state changes;
- leaves state unchanged on cancellation, no-op repair, stale-region rejection, or missing candidate;
- never writes the Library, schedules playback, talks to Roblox, or authorizes Windows input.

The session deliberately does not change global transcription quality/readiness yet. Client integration must combine the session's post-apply review evidence with the existing quality contract before allowing Add to Library.

## OSS and licensing

This phase adds no package, model, binary or copied third-party implementation. It composes the repository's existing Spotify Basic Pitch-derived note evidence, deterministic Roblox arranger repair generator, and review-region analyzer. Existing Basic Pitch/ONNX Runtime/NAudio attribution and redistribution obligations are unchanged.

## Validation contract

Regression coverage proves that candidate preview cannot mutate canonical session state, explicit apply re-analyzes review evidence, stale regions fail closed, revert restores the exact original performance/evidence, cancellation is atomic, and revision changes only after successful apply/revert.

## Consequences

The client can now add A/B preview and explicit Apply/Revert controls without inventing its own mutable repair semantics. Phase 39 client UI should bind to this state owner and must continue to keep local preview separate from Roblox Runtime Input.
