# ADR 0129: Audio repair candidate quality preview and deterministic recommendation

## Status

Accepted for Audio-to-Piano OSS Phase 42.

## Context

Phase 38 introduced deterministic Melody Priority and Simplified Harmony repair candidates. Phases 39-41 made Apply/Revert explicit and repair-aware global quality authoritative. The remaining client pain is that a user must still choose a repair kind before seeing how that candidate is expected to affect quality and remaining review work.

Spotify Basic Pitch is polyphonic and instrument-agnostic, but upstream explicitly notes that it works best on one instrument at a time. Candidate quality therefore remains review evidence rather than a claim that transcription or arrangement is waveform-perfect.

## Decision

`AudioTranscriptionReviewRepairSession` may evaluate every currently available deterministic repair candidate without mutating canonical state.

For each candidate the session derives:

- repair-aware global quality using the same evaluator used by explicit Apply;
- quality delta relative to the current authoritative quality, not a stale original snapshot;
- remaining deterministic review regions;
- whether the selected review interval is clear after the candidate;
- the session revision that produced the evidence.

A presentation-only deterministic recommendation orders candidates by:

1. better readiness (`Ready`, then `NeedsReview`, then `Rejected`);
2. resolving the selected review interval;
3. fewer remaining review regions;
4. fewer introduced quality reasons;
5. more resolved reasons;
6. higher retention;
7. lower transform loss;
8. higher timeline coverage;
9. lower peak simultaneous-note pressure;
10. repair kind as a stable final tie-break.

The recommendation never calls `Apply`. Only explicit client action may mutate the canonical `PerformanceTrack`.

## Safety and provenance

- `PerformanceTrack` remains authoritative playback truth.
- Candidate preview/recommendation does not persist to Library or schedule Roblox playback.
- Source/model warnings from Basic Pitch evidence remain governed by the repair-aware quality evaluator and cannot be silently cleared by candidate ranking.
- Candidate evidence is revision-bound; stale evidence is rejected.
- Cancellation is checked throughout evaluation and leaves canonical session state unchanged.
- Roblox Runtime Input is outside this boundary and remains independently field-gated.

## OSS and packaging impact

This phase reuses the existing Spotify Basic Pitch evidence contract, ONNX Runtime inference output, NAudio ingest/preview path, and deterministic Roblox arranger. It adds no package, model, native binary, Python/PyTorch/ffmpeg dependency, or source-separation runtime. Existing third-party attribution remains sufficient.
