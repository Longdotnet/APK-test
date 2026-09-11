# ADR 0071: End-to-end Audio-to-Piano transcription orchestration

## Status
Accepted.

## Context
Audio-to-Piano OSS Phases 01-04 established four production-grade boundaries: NAudio decoding/resampling, Spotify Basic Pitch ONNX inference through ONNX Runtime, deterministic Basic Pitch note decoding, and deterministic adaptation into the canonical Roblox 61-key `PerformanceTrack`. Until now callers still had to wire those components manually, which made it easy for future UI/library code to choose inconsistent sample rates, forget cancellation, skip quality diagnostics, or accidentally treat an intermediate tensor/note list as playback truth.

## Decision
Introduce `AudioToPianoTranscriptionService` in `RobloxPiano.Audio` as the single orchestration boundary for client-owned audio transcription. It composes the existing boundaries without duplicating their algorithms:

`audio file/stream -> AudioIngestService -> BasicPitchInferenceService -> BasicPitchNoteDecoder -> RobloxPianoArranger -> canonical PerformanceTrack`.

The service:

- owns one reusable Basic Pitch `InferenceSession` through the existing inference service;
- forces ingest to the Basic Pitch 22,050 Hz mono contract;
- supports file, seekable stream, and already-normalized audio inputs;
- propagates cancellation before and between every expensive boundary;
- fails closed when Basic Pitch produces no playable decoded notes;
- returns arrangement output plus deterministic diagnostics for source duration/sample count, inference frames, decoded note count, arrangement quality signals, and per-stage elapsed time;
- does not schedule keys, authorize Windows input, mutate the playback kernel, or change the P0 Roblox input path.

A dedicated real-model CI harness synthesizes a bounded A4 reference tone, executes the pinned Spotify `nmp.onnx` model, decodes and arranges the result, and requires non-empty canonical arranged events. It also covers wrong-rate rejection and pre-cancellation. This supplements the lower-level regression harness rather than replacing it.

## OSS / licensing impact
No new third-party dependency or copied source is introduced. The service composes existing NAudio (MIT), ONNX Runtime (MIT), and Spotify Basic Pitch (Apache-2.0 model/behavior reference) integrations and keeps their existing attribution requirements.

## Release impact
This phase remains internal infrastructure. The model is not yet bundled into `RobloxPiano.exe` and no client UI invokes the service, so it does not bump the client version or publish a new GitHub Release. A later client-impacting slice must explicitly solve model packaging/provenance, UI cancellation/progress, library persistence, and release-size implications before exposing `Create Piano Version`.
