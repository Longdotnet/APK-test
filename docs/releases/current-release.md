---
schema: 1
version: 0.40.18
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the **Sheet Library** remains the normal client starting point.
2. Existing MIDI/MusicXML/VPS/TXT library and playback behavior remains unchanged.
3. The executable now carries the pinned Spotify Basic Pitch model plus the native ONNX Runtime dependencies needed by the upcoming local-audio **Create Piano Version** flow. No Python, Node, .NET SDK, Visual Studio, ML runtime or manual model download is required.
4. Open Roblox and run `Test Roblox Input` before trusting playback for that Roblox process. Runtime Input P0 remains an independent field gate.
5. Preserve `INPUT_MATRIX` / `INPUT_FORENSIC` lines or export a **Support Bundle** when diagnosing Roblox input.

## Audio-to-Piano production bundle gate

- The production App now references `RobloxPiano.Audio`, so the same executable that clients receive contains the NAudio decode boundary, Microsoft ONNX Runtime and deterministic Audio-to-Piano pipeline code.
- CI and release fetch the Spotify Basic Pitch `nmp.onnx` model from pinned upstream commit `fa5997af0a8210982619003269994a1be25eddf3` and require Git blob `c30e5f9438e798604b7177aa26be1fe64482f767` with exact length 230444 bytes before compilation.
- The model is embedded into `RobloxPiano.Audio`; runtime extraction re-validates the same pinned identity before use.
- Published single-EXE validation runs `--audio-model-smoke`, materializes the embedded model and constructs a real `AudioToPianoTranscriptionService`, which initializes a Microsoft ONNX Runtime `InferenceSession`. This catches missing model/native-runtime packaging on the actual release candidate rather than only in source-level Audio tests.
- Model preparation is centralized in one CI script used by `audio-oss-gate`, `production-gate` and `production-release`, avoiding provenance drift between test and release pipelines.
- This phase intentionally does not expose the local-audio creation UI yet. It establishes the clean-machine production prerequisite before allowing a normal client to click **Create Piano Version**.

## OSS and attribution

- Spotify Basic Pitch remains the pinned Automatic Music Transcription model/semantic reference.
- Microsoft ONNX Runtime remains the native .NET inference engine; NAudio remains the Windows audio decode/normalization boundary.
- Existing third-party attribution files remain authoritative. No Python/PyTorch/Demucs/ffmpeg dependency is introduced.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- **Legacy** and **Legacy x2** remain protected regression/perceptual baselines.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed and are not modified by this Audio phase.
- AI/network are not required for transcription truth or input truth.

## Current boundaries

- The Audio pipeline is now packaged and runtime-smoke-tested in the production executable, but client-facing local-audio selection/progress/review/add-to-library UX is still the next phase.
- The packaged model adds distribution size and first-use model materialization to the client; CI validates the exact release candidate rather than assuming source-level tests imply packaging correctness.
- CI cannot observe a live Roblox client consuming synthetic input. Visible Roblox reaction remains the Runtime Input P0 acceptance gate, and this release does not claim end-to-end Play-in-Roblox success from Audio-to-Piano.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
