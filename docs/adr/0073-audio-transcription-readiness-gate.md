# ADR 0073: deterministic Audio-to-Piano readiness gate

## Status
Accepted.

## Context
Phase 05 can now produce a canonical `PerformanceTrack` from authorized/local audio, but a technically valid transcription is not automatically good enough to present as a trustworthy piano version. Basic Pitch may return sparse, low-activation or excessively dense output, and the Roblox arranger may drop or fold a significant fraction of decoded material.

The product quality contract requires low-confidence output to be surfaced for review rather than silently treated as ready. This decision must remain deterministic and must not mutate canonical playback truth.

## Decision
Add `AudioTranscriptionQualityEvaluator` after arrangement and before any future Library/UI promotion.

The evaluator records bounded, explainable metrics from data already owned by the deterministic pipeline:

- arranged-event retention relative to decoded notes;
- hard arrangement-loss ratio (density, range, duration and same-key drops);
- low-activation ratio and mean activation;
- octave-fold ratio as an informational transformation metric;
- arranged timeline coverage relative to source duration;
- arranged event rate per source second.

It emits one of three explicit states:

- `Ready`: all ready thresholds are met;
- `NeedsReview`: the result is playable but one or more quality thresholds are weak;
- `Rejected`: a critical retention/activation/coverage/density boundary is crossed.

Reason codes are stable strings so later UI and quality corpus tooling can explain why a candidate is not ready without asking AI to infer the reason.

The assessment is attached to `AudioToPianoTranscriptionDiagnostics`. It does not edit notes, change the arranger, change scheduler/input behavior, or authorize playback. Future Library/UI work must treat `Ready` as the automatic-promotion state and surface `NeedsReview`/`Rejected` explicitly.

## Threshold policy
Defaults are intentionally conservative and configurable through immutable `AudioTranscriptionQualityOptions`. Invalid or internally inconsistent thresholds fail closed. Thresholds are expected to be recalibrated from an evaluation corpus rather than silently changed to make tests pass.

## OSS impact
No new third-party package or model is introduced. Existing NAudio, ONNX Runtime and Spotify Basic Pitch attribution remains unchanged.

## Consequences
A generated track can no longer be described merely as "successful" because inference returned events. The pipeline now has a deterministic readiness contract suitable for corpus calibration and client review UX.

This does not yet prove musical equivalence to a mixed commercial recording. The next quality phase should build a licensed/synthetic evaluation corpus with ground-truth notes/timing and use it to calibrate readiness thresholds before client-facing `Create Piano Version` promotion.
