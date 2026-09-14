# ADR 0155: Real-model harmony continuity calibration A/B

## Status

Accepted.

## Context

Phase 65 proved that the production cross-section harmony continuity threshold (`0.90`) was non-regressive but dormant on the pinned Spotify Basic Pitch repeated-progression corpus: it made zero continuity selections and produced the same 30/43 recognized-harmony retention as the continuity-disabled control.

A threshold should not be lowered from intuition alone. Mixed-audio Basic Pitch evidence varies by confidence, and an aggressive continuity preference can preserve a stale chord tone, reduce section retention, or trade useful clutter suppression for apparent continuity.

## Decision

Run Basic Pitch exactly once over the Phase 65 repeated Cmaj7 -> Am7 -> Fmaj7 -> G7 fixture. Reuse the exact decoded note evidence for an identical no-continuity control and four bounded candidate floors: `0.90`, `0.85`, `0.80`, and `0.75`.

For every candidate report:

- actual `HarmonyContinuitySelections`;
- recognized melody and harmony retention;
- global harmony delta versus the identical decoded-note control;
- per-section wins and losses;
- clutter-suppression delta;
- whether the candidate is admissible for future promotion.

A candidate is admissible only when it exercises continuity, improves global or section harmony, loses no melody or section harmony versus control, adds no unmatched playback event, does not expand event count, and keeps clutter suppression within 0.02 of control. Ties prefer the stricter/higher confidence floor.

This phase deliberately does **not** mutate the production default. CI prints either `PROMOTION_CANDIDATE` with the measured winning floor or `KEEP_PRODUCTION` when no bounded candidate earns promotion. A future client-facing phase may change the default only from this evidence and must repeat exact-head/exact-main production validation.

`RobloxPiano.Core.PerformanceTrack` remains authoritative. Calibration code only observes pinned-model decoded notes and canonical arranged output; it cannot authorize, schedule, or inject Roblox input.

## OSS and packaging impact

The stack remains Spotify Basic Pitch semantics/model, Microsoft ONNX Runtime, NAudio and the existing deterministic arranger. No upstream code is copied and no package, model, Python, PyTorch, ffmpeg, Demucs or native runtime is added. There is no new license or NOTICE obligation and no client package/runtime cost.

## Consequences

CI performs one pinned-model inference and four cheap deterministic arrangement passes over the same decoded notes. This converts the Phase 65 `TUNE_REQUIRED` finding into reviewable A/B evidence without risking a speculative client-facing threshold change.
