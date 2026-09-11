# ADR 0076: Redistributable real-model Audio-to-Piano evaluation corpus

## Status
Accepted

## Context

Phase 07 introduced deterministic note-level evaluation semantics, but it evaluated supplied note events. That is necessary for evaluator parity, yet it does not detect regressions across the actual audio path: decode -> Basic Pitch ONNX -> post-processing.

The Audio-to-Piano readiness thresholds must not be calibrated from intuition or from model-output-only fixtures. We need a small, reproducible corpus whose audio and note truth are both owned by the repository and whose results are produced by the exact pinned production model.

## Decision

The `RobloxPiano.AudioPipelineTests` harness now synthesizes four deterministic PCM wave fixtures at runtime:

- single A4;
- a C-major melody fragment;
- repeated G4 articulations;
- a wide-register C3/C6 pair.

The fixtures are generated mathematically and written to ordinary mono PCM16 WAV streams, so there are no third-party recordings or binary fixture provenance concerns. They pass through the public NAudio ingest boundary, the pinned Spotify Basic Pitch ONNX model, the production note decoder, and the Phase 07 corpus evaluator.

The gate records per-case precision, recall, F1, onset error and offset error and enforces conservative corpus floors. Every fixture must retain at least one ground-truth match. These floors are regression tripwires, not a claim that the current generated piano is perceptually production-ready.

Evaluation tolerances are deliberately explicit for this real-model regression corpus: 120 ms onset tolerance and offset tolerance of max(150 ms, 25% of reference duration). Phase 07's evaluator defaults remain unchanged and continue to mirror the stricter mir_eval-inspired contract.

## OSS and licensing

No new package, runtime or redistributed media is introduced. The corpus reuses:

- NAudio for the existing Windows audio decode boundary;
- Microsoft ONNX Runtime for the existing native .NET inference boundary;
- Spotify Basic Pitch `nmp.onnx` pinned by commit/blob identity in `audio-oss-gate`.

The synthesized waveforms and note annotations are repository-generated test data. Existing NAudio, ONNX Runtime and Basic Pitch notices remain sufficient.

## Architectural boundary

This corpus measures transcription quality only. It does not mutate canonical `PerformanceTrack`, change arrangement policy, touch Roblox input/focus/scheduler code, or establish the Runtime Input P0 field gate.

## Consequences

- A model/preprocessing/decoder regression that still compiles can now fail CI on musical output quality.
- CI cost increases because the pinned model is run over four additional short fixtures; all fixtures remain bounded to a few seconds and inference session reuse keeps the cost controlled.
- The baseline is intentionally synthetic. The next calibration step should add lawful/public-domain or explicitly licensed musical recordings only when their provenance and stable annotations can be committed safely.
