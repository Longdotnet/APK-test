# ADR 0159: Harmony-continuity retirement requires pinned-model equivalence

## Status

Accepted for Audio-to-Piano OSS Phase 70.

## Context

Phase 64 introduced bounded cross-section harmony continuity. Phases 65 through 69 then tested the policy against pinned Spotify Basic Pitch repeated-progression evidence, threshold calibration, eligibility diagnostics, adaptive-density relaxation, and candidate-specific activation rescue.

Across that evidence chain production reported zero harmony-continuity selections on the real-model corpus. Lowering the continuity floor did not exercise the selector; globally relaxing adaptive density did not change output; candidate-specific rescue found no harmony gain and produced regressions for two candidates. Keeping dormant policy forever adds configuration, state tracking, diagnostics and future regression surface without measured client benefit.

A synthetic unit fixture intentionally created in Phase 64 can force continuity to change a chord choice, so removal must not be justified merely by code inspection. Before mutating production behavior, the project needs a direct A/B over representative pinned-model corpora using identical decoded evidence.

## Decision

Add a fail-closed retirement gate covering both:

1. the mixed-instrument full-song stress corpus; and
2. the repeated Cmaj7 -> Am7 -> Fmaj7 -> G7 progression corpus used by Phases 65-69.

For each corpus Spotify Basic Pitch runs once. The exact decoded notes are then arranged twice:

- current production defaults; and
- an otherwise identical control with a 1 ms harmony-continuity window, effectively removing cross-onset harmony context while retaining every other deterministic arranger policy.

Retirement is safe only when both A/B tracks are canonically identical event-for-event and their arrangement evidence is identical for melody retention, harmony retention, per-section counts, clutter suppression, false positives and event count. Existing minimum recognition and quality floors remain fail-closed.

The gate prints `RETIRE_SAFE` only after every corpus proves equivalence. A non-equivalent corpus prints/fails as `KEEP_CONTINUITY`; production code must not be removed in that case.

This phase intentionally separates evidence from mutation. Once exact-head CI proves `RETIRE_SAFE`, the same branch may remove the dormant production tie-break while preserving canonical `PerformanceTrack`, melody continuity, bass-anchor/pitch-class voicing, adaptive density, scheduler/input ownership and Runtime Input P0 boundaries.

## OSS and packaging impact

Spotify Basic Pitch remains the AMT model and semantics source; Microsoft ONNX Runtime remains the native inference runtime. NAudio and DryWetMIDI boundaries are unchanged. No upstream code is copied and no Python, PyTorch, ffmpeg, Demucs model/runtime, NuGet package or native dependency is added.

The gate adds only CI-time deterministic arranger passes over already-decoded notes. It creates no client package/runtime cost and no new license or NOTICE obligation.
