---
schema: 1
version: 0.40.70
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Create Piano Version production hardening

- Long MP3 transcription now keeps Basic Pitch inference bounded to one audio window per ONNX call and disables ONNX CPU arena/memory-pattern retention for this desktop path.
- Full-song model activations are written directly into final tensors instead of accumulating duplicate `List<float>` plus array copies, reducing long-song peak memory.
- Recoverable NAudio, Windows media, ONNX and native-runtime startup failures now terminate the creation job as **Failed** without treating partial output as a generated song.
- Create Piano Version records real stage-by-stage progress so long inference no longer looks frozen while work is still advancing.

## Sendable Create Piano diagnostics

- Every creation attempt writes an append-only `.log` under `%LOCALAPPDATA%\RobloxPiano\diagnostics\create-piano`.
- Logs include stage, progress, elapsed time, client/runtime architecture, managed memory, working set and full managed exception details needed to locate ingest, ONNX, decode, arrange, review or UI failures.
- Logs do **not** copy audio bytes or write the full local source path. The filename plus a one-way path fingerprint are enough to correlate attempts.
- Run `RobloxPiano.exe --create-piano-logs` to open the diagnostics folder directly. When reporting a problem, send the newest `create-piano-*.log` file.
- WinForms UI, AppDomain and unobserved-task failures are also appended best-effort so unexpected managed failures leave evidence instead of disappearing silently.

## Release validation

- `--audio-model-smoke` now executes a real multi-window Basic Pitch ONNX inference from the published single EXE instead of only constructing an `InferenceSession`.
- Audio regression coverage verifies production-default multi-window progress, cancellation, real-model inference and privacy-safe diagnostic evidence.
- Normal playback, canonical note ownership, library persistence and Roblox input authorization remain separate from Create Piano Version transcription truth.

## Client procedure

1. Open **Create Piano Version** and choose an owned/local WAV, MP3 or AIFF file.
2. Keep the window open while the progress bar advances through ingest, Basic Pitch inference, decode, arrangement and quality review.
3. Preview the generated piano version before adding it to the Library.
4. If creation fails or the UI behaves unexpectedly, run `RobloxPiano.exe --create-piano-logs` and send the newest `.log` file with the report.
