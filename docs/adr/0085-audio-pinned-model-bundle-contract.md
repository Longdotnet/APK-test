# ADR 0085: Pinned Basic Pitch model bundle contract

## Status
Accepted

## Context

Audio-to-Piano already runs Spotify Basic Pitch through Microsoft ONNX Runtime without a Python runtime, but production-quality client UX cannot depend on a developer or client manually locating `nmp.onnx`. The pinned model used by CI is small enough to package intentionally, while ONNX Runtime's C# API supports loading a model from a normal file path and reusing an `InferenceSession` for inference.

The source model is Spotify Basic Pitch commit `fa5997af0a8210982619003269994a1be25eddf3`, path `basic_pitch/saved_models/icassp_2022/nmp.onnx`. CI has already established the immutable Git blob identity `c30e5f9438e798604b7177aa26be1fe64482f767` and byte length `230444`.

## Decision

1. `RobloxPiano.Audio` embeds the pinned ONNX model only when build property/environment variable `BASIC_PITCH_MODEL_PATH` points to a verified model file.
2. The embedded logical resource name is stable: `RobloxPiano.Audio.Models.nmp.onnx`.
3. Runtime materialization is deterministic and client-owned: the resource is extracted to a bounded application model cache, not downloaded at runtime.
4. Extraction re-validates the exact Git blob SHA-1 and byte length before returning a usable model path. Existing cached content is reused only after the same validation.
5. Materialization writes to a unique temporary file and atomically replaces the final cache file; partial/corrupt files never become authoritative.
6. The existing `BasicPitchInferenceService(string modelPath)` remains authoritative for ONNX Runtime session creation and model input/output contract validation.
7. `audio-oss-gate` must prove the exact pinned model embeds, extracts, passes provenance verification, and performs real ONNX inference without Python/Node/.NET tooling beyond the self-contained product build/runtime dependencies.
8. This phase deliberately does not add the Audio project to `RobloxPiano.App`; production client packaging and UX activation remain a subsequent release slice so existing `RobloxPiano.exe` releases are not silently enlarged or changed.

## OSS rationale

Spotify Basic Pitch is retained as the transcription model and semantic reference rather than replacing it with a custom model. Microsoft ONNX Runtime remains the native .NET inference runtime; its C# API supports `InferenceSession` from an on-disk model path, matching the existing production boundary. No Python Basic Pitch runtime is shipped.

## License and attribution

No new third-party dependency is introduced. Existing Basic Pitch/ONNX Runtime attribution remains applicable. Any future production client that embeds the model must retain the current Basic Pitch third-party notice and model provenance documentation.

## Consequences

- The next client UX phase can make `Create Piano Version` truly zero-install: the model can be compiled into the application distribution and materialized locally on first use.
- Release builds must explicitly supply and verify the pinned model before compiling the Audio assembly; absence remains fail-visible instead of triggering a network download.
- A small extraction/cache write is accepted because it preserves the proven file-path `InferenceSession` boundary and keeps model provenance independently inspectable.
- Runtime networking is not added to transcription truth.
