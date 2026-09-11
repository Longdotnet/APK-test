# ADR 0083: Audio-to-Piano transcription progress and cancellation contract

## Status

Accepted for Audio-to-Piano OSS Phase 12, subject to exact-head and exact-main validation.

## Context

The production Audio-to-Piano pipeline already performs bounded local ingest, Spotify Basic Pitch ONNX inference, deterministic decoding, conservative harmonic suppression, Roblox-range arrangement and readiness classification. The next client boundary needs to run that work from `RobloxPiano.exe` without freezing the UI and must be able to show truthful progress and cancellation state.

A UI must not infer progress from elapsed wall-clock time or invent completion while deterministic work is still running. Inference dominates runtime, while later deterministic stages are shorter but still important for diagnostics and cancellation. Existing synchronous APIs are used by tests and pipeline code and must remain source-compatible.

## Decision

Expose a stable `AudioToPianoTranscriptionStage` and immutable `AudioToPianoTranscriptionProgress` value. Add progress-aware overloads for file, stream and already-normalized inputs while preserving all existing overloads unchanged.

Progress is monotonic and stage-based:

- ingest starts at 0% and finishes at 15% for file/stream inputs;
- Basic Pitch inference begins at 15%;
- decode begins at 70%;
- harmonic suppression begins at 78%;
- Roblox arrangement begins at 84%;
- readiness/quality evaluation begins at 94%;
- `Completed` is emitted exactly once at 100% only after canonical arrangement and quality assessment both succeed.

Normalized-audio callers intentionally start at `Inference` because ingest has already happened outside the service. Cancellation is checked before each deterministic stage. A pre-cancelled request emits no progress and can never emit `Completed`.

The percentages are UX weights, not claims about exact wall-clock duration. They preserve monotonicity and keep the expensive inference stage visually dominant without allowing the UI to treat model completion as product completion.

## Invariants

- `PerformanceTrack` remains canonical playback truth.
- Progress callbacks cannot mutate notes, quality classification, scheduler/input state or authorization.
- `Completed` never reports before quality evaluation succeeds.
- Failed/cancelled work never reports a false successful terminal state.
- Existing callers that do not request progress behave exactly as before.
- Runtime Input P0 remains a separate field gate; this phase does not claim Roblox consumes generated input.

## OSS and license impact

No new dependency, model, binary or copied implementation is introduced. Existing NAudio, Microsoft ONNX Runtime and Spotify Basic Pitch attribution remains unchanged. This is repository-specific orchestration/UX infrastructure around the existing OSS-backed pipeline.

## Validation contract

Regression coverage uses the pinned Basic Pitch real model to prove the production stage order, bounded/monotonic fractions, exactly-one terminal completion and cancellation semantics. Invalid progress values fail closed. Existing Audio OSS and production gates must remain green.
