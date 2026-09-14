---
schema: 1
version: 0.40.70
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Create Piano Version stability and diagnostics

- Long MP3 transcription now uses bounded one-window Basic Pitch inference by default instead of coarse multi-window production batching, reducing peak native ONNX Runtime memory pressure.
- The production CPU ONNX session keeps graph optimization while disabling CPU memory arena and memory-pattern allocation for more predictable desktop memory usage.
- Recoverable ONNX Runtime, NAudio and native-runtime startup failures are contained inside the Create Piano client job and return a visible Failed state instead of escaping the workflow.
- Unexpected managed failures at the Create Piano job boundary are logged and contained so the rest of the client can continue whenever the process itself is still alive.
- Create Piano writes durable phase diagnostics to `%LOCALAPPDATA%\RobloxPiano\diagnostics\create-piano.log`, including operation id, phase/progress checkpoints, elapsed time and memory observations. The log is flushed at each checkpoint and rotated at 4 MiB.
- Diagnostic source evidence records the file name and size rather than the user's full selected-audio path.

## Validation

- Audio OSS gate covers pinned Basic Pitch model readiness, audio ingest, ONNX inference, decoding, arranging, generated MIDI parity and real-model Audio-to-Piano end-to-end execution.
- Production gate validates the Windows client build, self-contained single-EXE publish, STA UI startup, Windows input ABI and packaged audio model/ONNX runtime smoke tests.

## Troubleshooting

If Create Piano Version does not complete, send `%LOCALAPPDATA%\RobloxPiano\diagnostics\create-piano.log`.
The final checkpoint and memory values are designed to remain useful even when a native failure terminates the process before WinForms can display an error.
