# ADR 0118: Pin Basic Pitch provenance in the native separation benchmark CLI

## Status

Accepted

## Context

Audio-to-Piano phases 29-33 established the native `demucs.cpp` output contract, paired transcription benchmark, cryptographic separator/model/corpus provenance, post-run drift verification, deterministic benchmark report, and a manifest-driven runner. That stack still accepted transcription delegates from the caller.

For the production candidate decision this is insufficient evidence by itself: a direct-mixture baseline and a separated-piano candidate can only be compared reproducibly when the exact Basic Pitch transcriber is also pinned. A local model file could otherwise be replaced behind the same path between engineering runs, or different transcription implementations could be supplied to the two benchmark arms.

The benchmark must remain engineering-only. It must not download source-separation binaries, model weights, or media; it must not add Python/PyTorch/ffmpeg requirements to the client; and it must not alter `PerformanceTrack`, scheduler, focus/input authorization, Legacy playback, or Runtime Input P0 ownership.

## Decision

Add a dedicated `RobloxPiano.AudioBenchmark` console project and `DemucsCppBasicPitchBenchmarkRunner` boundary.

The command requires explicit values for the Phase 33 manifest/report plus an absolute Basic Pitch `nmp.onnx` path, its expected SHA-256, and the full 40-character Spotify Basic Pitch upstream commit identity. It performs no PATH discovery and no artifact acquisition.

Before measurement the runner verifies the Basic Pitch model bytes. It creates one `BasicPitchInferenceService` and reuses that single ONNX Runtime `InferenceSession` for both the direct-mixture baseline and separated-piano stem. Both paths also use the same NAudio ingest contract and the same `BasicPitchNoteDecoder`. After the paired benchmark completes, the runner verifies the model bytes again. If post-run provenance verification or cancellation fails after Phase 33 emitted its report, the report/checksum and any Phase 34 evidence files are removed so they cannot be mistaken for accepted evidence.

A successful run emits the existing deterministic benchmark JSON/checksum plus a deterministic evidence JSON/checksum binding the benchmark report hash and separation provenance identity to the Basic Pitch upstream commit, exact model SHA-256/model byte size, and final adoption decision. Machine-local paths and timestamps are intentionally excluded from that evidence envelope.

The engineering transcriber caps each decoded benchmark input at 15 minutes. This keeps its current in-memory NAudio/Basic Pitch pipeline bounded while long-song production work remains a separate streaming/chunking concern. Phase 33's generic manifest remains capable of describing longer engineering cases for future transcribers.

The audio OSS CI gate compiles the engineering CLI and runs provenance regressions, including exact-byte verification, model-byte drift rejection, absolute-path enforcement, and full-commit enforcement.

## Consequences

Source separation is still not a production dependency and this ADR does not constitute an `Adopt` decision. A lawful owned/licensed corpus and exact local `demucs.cpp`/model artifacts are still required to produce measured quality and resource evidence.

No new package is introduced and no `demucs.cpp`, Demucs model, Python, PyTorch, ffmpeg, or media is redistributed. Existing NAudio, ONNX Runtime, Basic Pitch model semantics, canonical `PerformanceTrack`, and production playback/input boundaries remain unchanged. Any future redistribution of third-party source/model artifacts must continue to satisfy their license and NOTICE obligations independently.
