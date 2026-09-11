# ADR 0086: Bounded long-song Basic Pitch inference progress

## Status

Accepted — Audio-to-Piano OSS Phase 14.

## Context

The production Audio-to-Piano path already processes Spotify Basic Pitch input in overlapping bounded windows and reuses one ONNX Runtime `InferenceSession`. That keeps long inputs from becoming one arbitrarily large model tensor, but the public transcription progress contract still exposed inference as a coarse jump from 15% to 70%.

For a normal client this creates a misleading frozen-progress experience precisely during the most expensive part of `Create Piano Version`. It also makes cancellation evidence weak: the caller can request cancellation, but cannot tell which inference batch had completed before the request was observed.

Spotify Basic Pitch itself processes longer audio as overlapping windows. We keep that model/preprocessing contract and do not invent a second inference pipeline.

## Decision

`BasicPitchInferenceService` exposes an optional `IProgress<BasicPitchInferenceProgress>` overload while preserving the existing API.

`BasicPitchInferenceProgress` is deterministic and bounded:

- `TotalChunks` must be positive.
- `CompletedChunks` must stay in `[0, TotalChunks]`.
- `Fraction` is derived from those immutable counts.
- An initial `0 / TotalChunks` observation is emitted before model execution.
- One observation is emitted after every completed ONNX batch.
- The final inference observation is always `TotalChunks / TotalChunks` for successful inference.

The orchestration layer maps inference progress into its existing 15%-70% interval. Decode, harmonic suppression, arrangement, quality and completion retain their existing stage boundaries. A client can therefore render real forward progress without estimating elapsed time.

Cancellation is checked before every batch and again immediately after `InferenceSession.Run` returns, before output tensors are unwrapped. This means a cancellation request observed during a native ONNX call stops at the first safe managed boundary and cannot leak into Decode or later stages. We intentionally do not claim that .NET cancellation can interrupt an already-running native ONNX call.

## Boundedness and performance

`BasicPitchInferenceOptions.MaxChunksPerBatch` remains the memory/concurrency bound. This phase does not increase the batch size, create parallel inference sessions, or load the full song as a single model tensor.

The progress callback is invoked once before inference and once per completed batch. No callback is performed inside tensor element loops, so progress reporting is outside the hot inner-copy path.

This phase does not claim full streaming file decode; NAudio ingest and its existing duration limits remain separate concerns.

## Architecture boundary

This change is confined to `RobloxPiano.Audio` and Audio regression coverage. It does not modify:

- canonical `PerformanceTrack` ownership;
- Roblox scheduler/input/focus authorization;
- held-key or pedal ownership;
- Legacy playback semantics;
- Runtime Input P0 field acceptance.

Progress is observational only. It cannot mutate transcription output or playback truth.

## OSS and licensing

The implementation continues to use the existing pinned Spotify Basic Pitch model semantics and Microsoft ONNX Runtime session/tensor APIs. No new package, model, native binary, copied source, or redistributed asset is introduced by this phase, so existing Basic Pitch / ONNX Runtime attribution and NOTICE obligations are unchanged.

## Validation

The pinned-model regression now uses a multi-window piano-like fixture with one chunk per batch and verifies:

- multiple intermediate inference progress observations;
- exact 15%-70% orchestration mapping;
- monotonic bounded fractions;
- deterministic post-inference stage ordering;
- window-count diagnostics;
- cancellation after a completed inference batch never reaches Decode or `Completed`;
- pre-cancelled work emits no misleading progress;
- invalid inference progress values fail closed.

Production and Audio exact-head/exact-main gates remain authoritative before merge.