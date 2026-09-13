# ADR 0128: Client repair quality delta and authoritative readiness

## Status

Accepted.

## Context

Phase 40 made review-repair global quality canonical-aware and Phase 41a added a deterministic before/current quality delta contract. The Create Piano Version client still used the immutable pre-repair `_baseQuality` to derive readiness after Apply/Revert, which meant a real deterministic repair could not legitimately promote `NeedsReview` to `Ready` even when the authoritative current quality assessment improved.

The client also lacked a concise explanation of which quality reasons were resolved, remained persistent, or were introduced by the accepted repair.

## Decision

The Create Piano Version flow now constructs `AudioTranscriptionReviewRepairSession` with the immutable base/global quality assessment retained by transcription.

After every explicit Apply/Revert:

- `AudioTranscriptionReviewRepairSession.CurrentQuality` is the authoritative global quality assessment;
- global `Rejected` or `NeedsReview` remains fail-closed;
- global `Ready` becomes overall `Ready` only when no local review region remains;
- the client uses `AudioTranscriptionQualityDeltaEvaluator` through a deterministic presenter to show before/current retention, transform loss, timeline coverage and density;
- resolved, persistent and introduced reason codes remain visible;
- local review regions remain an independent explicit-decision gate and cannot be hidden by an improved global score;
- preview remains side-effect free and does not mutate quality or canonical playback truth.

The current `PerformanceTrack` remains authoritative for Library persistence. This change does not touch Roblox input, focus, scheduler, held-key/pedal ownership or Runtime Input field acceptance.

## Validation

Audio UX regressions cover:

- `NeedsReview -> Ready` quality presentation after a genuine improvement;
- persistent source/model evidence remaining visible;
- introduced reasons and readiness regression remaining visible.

Existing Audio quality-delta and repair-session regressions continue to own deterministic reason transitions, Apply atomicity, exact Revert, cancellation, and canonical-state mutation rules.

## OSS and packaging impact

No new OSS package, model, native binary or runtime is introduced. The client reuses the existing Spotify Basic Pitch evidence pipeline, ONNX Runtime inference, NAudio preview, deterministic Roblox arranger, and the Phase 41a quality-delta contract. No additional license or NOTICE obligation is created.
