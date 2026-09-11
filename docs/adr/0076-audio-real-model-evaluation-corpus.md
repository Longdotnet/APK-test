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

The first exact-model run showed that making note matching depend on both onset and generated note termination hides otherwise-correct pitch/onset recognition for synthetic envelopes. Basic Pitch termination is materially sensitive to timbre and release shape. The regression gate therefore treats this first corpus as a **recognition baseline**: exact MIDI pitch plus onset within 150 ms establishes a match. Offset error is still measured and printed for every case and the aggregate, but does not turn a recognized note into a false negative. A later corpus with representative piano envelopes can add an independently calibrated duration gate.

The gate records per-case precision, recall, F1, onset error and offset error, requires every fixture to retain at least one ground-truth pitch/onset match, and enforces conservative aggregate floors. These floors are regression tripwires, not a claim that the current generated piano is perceptually production-ready. Phase 07's stricter evaluator defaults remain unchanged.

## OSS and licensing

No new package, runtime or redistributed media is introduced. The corpus reuses:

- NAudio for the existing Windows audio decode boundary;
- Microsoft ONNX Runtime for the existing native .NET inference boundary;
- Spotify Basic Pitch `nmp.onnx` pinned by commit/blob identity in `audio-oss-gate`.

The synthesized waveforms and note annotations are repository-generated test data. Existing NAudio, ONNX Runtime and Basic Pitch notices remain sufficient.

## Architectural boundary

This corpus measures transcription quality only. It does not mutate canonical `PerformanceTrack`, change arrangement policy, touch Roblox input/focus/scheduler code, or establish the Runtime Input P0 field gate.

## Consequences

- A model/preprocessing/decoder regression that still compiles can now fail CI on musical recognition quality.
- CI cost increases because the pinned model is run over four additional short fixtures; all fixtures remain bounded to a few seconds and inference session reuse keeps the cost controlled.
- Duration/offset quality remains visible evidence rather than a pass/fail criterion in this first synthetic corpus.
- The baseline is intentionally synthetic. The next calibration step should add harmonic-rich generated piano envelopes and then lawful/public-domain or explicitly licensed musical recordings only when provenance and stable annotations can be committed safely.
