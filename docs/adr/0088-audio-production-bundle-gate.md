# ADR 0088: Audio production bundle and clean-machine gate

## Status

Accepted.

## Context

The Audio-to-Piano pipeline already had deterministic NAudio ingest, pinned Spotify Basic Pitch ONNX inference, note decoding, harmonic suppression, Roblox arrangement, quality classification, progress/cancellation, and a pinned model bundle contract. However, the production `RobloxPiano.App` did not reference `RobloxPiano.Audio`, and the production/release workflows did not provide the pinned model while publishing `RobloxPiano.exe`.

That separation was useful while Audio was infrastructure-only, but it became a blocker for client-facing `Create Piano Version`: source-level Audio tests could pass while the actual single-EXE client lacked the model or native ONNX Runtime payload. Shipping the UI before closing that packaging gap would create a clean-machine failure for normal clients.

## Decision

1. `RobloxPiano.App` references `RobloxPiano.Audio`, preserving the existing canonical `PerformanceTrack` and playback/input ownership boundaries.
2. Model acquisition is centralized in `.github/scripts/prepare-basic-pitch-model.ps1`.
3. The script downloads Spotify Basic Pitch `nmp.onnx` only from pinned upstream commit `fa5997af0a8210982619003269994a1be25eddf3` and fails closed unless:
   - Git blob SHA-1 is `c30e5f9438e798604b7177aa26be1fe64482f767`;
   - byte length is exactly `230444`.
4. `audio-oss-gate`, `production-gate`, and `production-release` all use the same preparation contract and expose `BASIC_PITCH_MODEL_PATH` to MSBuild.
5. The production App supports a CI-only `--audio-model-smoke` command. On the published single EXE it:
   - requires the embedded model resource;
   - materializes it through `BasicPitchBundledModel`;
   - re-validates the pinned model identity;
   - constructs `AudioToPianoTranscriptionService`, forcing a real Microsoft ONNX Runtime `InferenceSession` to initialize;
   - fails non-zero on any packaging/runtime/provenance defect.
6. The production and release gates run this smoke against the exact self-contained single-file release candidate.

## Boundaries

- This ADR does not expose local-audio creation UI or mutate Sheet Library behavior.
- It does not modify Roblox scheduler, focus guard, key injection, input authorization, held-key/pedal ownership, Legacy baseline, or Runtime Input P0 evidence.
- It does not add Python, PyTorch, Demucs, ffmpeg, Node, SDK or developer-tool requirements to clients.
- `PerformanceTrack` remains the authoritative canonical representation after transcription/arrangement.
- The bundled AMT model is not a claim of waveform-perfect equivalence or Roblox end-to-end playback success.

## OSS and licensing

The redistributed model remains Spotify Basic Pitch with the existing repository attribution/provenance documentation. Microsoft ONNX Runtime and NAudio remain existing package dependencies with existing third-party attribution. No new external implementation or model is added by this phase.

## Consequences

Positive:

- A release cannot silently omit the pinned model while Audio source tests remain green.
- Native ONNX Runtime single-file packaging is exercised from the published executable before release.
- Test/release provenance cannot drift through duplicated model-fetch snippets.
- Phase 16 can build client-owned audio UX on a production runtime that is already clean-machine gated.

Tradeoffs:

- `RobloxPiano.exe` becomes larger because it now includes Audio dependencies, native ONNX Runtime and the model before the feature is exposed in the GUI.
- First use materializes the small pinned model into the per-user RobloxPiano model cache; identity is rechecked before use.
- The smoke initializes a real inference session, increasing CI/release validation work slightly in exchange for catching the packaging failure class clients would otherwise see.
