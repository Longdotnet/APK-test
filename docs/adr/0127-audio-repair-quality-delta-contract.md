# ADR 0127: Repair-aware client quality delta contract

## Status

Accepted.

## Context

Phase 40 made review repair quality state canonical-aware: track-derived retention, transform loss, timeline coverage and density are recomputed after explicit Apply while source/model evidence remains immutable. The client still needs a safe way to explain what changed without re-implementing readiness semantics or comparing unordered reason lists itself.

A UI-specific calculation would risk drifting from the deterministic audio boundary, hiding persistent source/model warnings, or treating a change in list ordering as a quality change.

## Decision

`RobloxPiano.Audio` owns `AudioTranscriptionQualityDelta` and `AudioTranscriptionQualityDeltaEvaluator`.

The delta:

- compares an immutable before assessment with the authoritative current assessment;
- exposes retention, transform-loss, timeline-coverage and events-per-second numeric deltas;
- classifies readiness movement as improved, regressed or unchanged;
- reports resolved, persistent and introduced reason codes;
- normalizes reason sets with ordinal distinct/sort semantics so presentation is deterministic;
- rejects blank reason values instead of silently dropping malformed evidence;
- can compare `AudioTranscriptionReviewRepairSession.BaseQuality` directly with `CurrentQuality` without mutating the session.

The delta is evidence for client presentation only. It cannot change `PerformanceTrack`, readiness, repair state, Library persistence or Roblox playback/input authorization.

## Consequences

A later client slice can show truthful before/current quality and reason transitions without duplicating evaluator policy. A repair may visibly resolve mutable track-derived warnings while immutable Basic Pitch/source evidence remains persistent. Unknown/new reason codes remain visible because the delta treats them as ordinary evidence rather than filtering them.

No new OSS dependency, model, native binary or runtime is introduced. Existing Basic Pitch/ONNX Runtime/NAudio behavior and Runtime Input remain unchanged.

## Validation

The audio OSS gate runs a dedicated regression harness covering:

- NeedsReview to Ready improvement with resolved mutable reasons;
- persistent source/model warnings;
- newly introduced regression reasons;
- deterministic ordering and duplicate normalization;
- fail-closed malformed blank reason evidence.
