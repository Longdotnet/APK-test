# ADR 0106 — Paired source-separation benchmark runner

## Status

Accepted for Audio-to-Piano OSS Phase 27.

## Context

Phase 26 introduced a fail-closed adoption gate for source separation, but that gate intentionally accepted already-computed transcription and resource measurements. That was sufficient to define policy, not sufficient to prevent a benchmark harness from accidentally comparing different ground truth, averaging package cost incorrectly, or hand-entering quality metrics.

The production Audio-to-Piano path remains NAudio -> Spotify Basic Pitch ONNX through ONNX Runtime -> deterministic post-processing/arrangement -> canonical `PerformanceTrack`. Source separation is still optional and must earn its production cost with measured evidence.

Mature OSS references remain:

- Spotify Basic Pitch: https://github.com/spotify/basic-pitch
- Demucs: https://github.com/adefossez/demucs
- demucs.cpp: https://github.com/sevagh/demucs.cpp
- ONNX Runtime: https://github.com/microsoft/onnxruntime

Phase 27 does not copy or redistribute code, models, or binaries from these projects.

## Decision

Add `AudioSourceSeparationBenchmarkRunner` as engineering evaluation infrastructure between a concrete candidate separator/transcriber and the Phase 26 adoption gate.

For every corpus case, the runner requires one stable identity, a positive bounded audio duration, and non-empty ground-truth notes. It invokes:

1. the direct transcription path;
2. the candidate separated transcription path;
3. the existing deterministic `AudioTranscriptionEvaluator` against the exact same reference notes.

The candidate path returns its observed elapsed time, peak working set and added production bundle bytes together with estimated notes. The runner derives:

- per-case direct/candidate precision, recall and F1 from note matching;
- maximum observed candidate peak working set across the corpus;
- total candidate processing seconds divided by total audio seconds;
- one stable added-bundle measurement that must not drift between cases.

It then feeds those measured paired results directly into `AudioSourceSeparationAdoptionEvaluator`.

## Fail-closed rules

The benchmark refuses to produce adoption evidence when:

- the corpus is empty;
- identities are blank or duplicated;
- audio duration is non-positive or unreasonably large;
- ground truth is empty;
- candidate elapsed/memory/package measurements are invalid;
- added-bundle measurement changes between cases;
- cancellation is requested.

A candidate cannot improve its adoption result by manually supplying precision/recall/F1 values; those metrics are recomputed by the existing evaluator from actual estimated notes and shared ground truth.

## Architectural boundary

This phase does not bundle Demucs, `demucs.cpp`, Python, PyTorch, ffmpeg, a model, or another inference runtime. It also does not change production Basic Pitch inference, arranger policy, canonical `PerformanceTrack`, Library persistence, Roblox input/focus/scheduler behavior, Legacy, or Legacy x2.

A future native separator adapter may feed this runner from an engineering harness. Only measured `Adopt` evidence under ADR 0104 permits a separate reviewed production-integration decision.

## Consequences

- Phase 26 policy now has an executable paired-measurement path instead of relying on hand-entered metrics.
- Direct and separated paths are evaluated against identical ground truth by construction.
- Runtime factor is weighted by actual corpus audio duration rather than averaging per-song ratios.
- Peak memory is conservatively the maximum observed candidate value.
- Package size is treated as a candidate property and must remain stable across cases.
- No production release/version bump is required because client behavior and packaged dependencies are unchanged.
