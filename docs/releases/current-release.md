---
schema: 1
version: 0.40.42
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; this release changes only Runtime Input field-evidence retention.
- **Support Bundle** remains the preferred way to preserve correlated `INPUT_MATRIX_*`, `INPUT_MATRIX_PROVENANCE`, `LOWLEVEL_PROVENANCE_*`, and `INPUT_FORENSIC` evidence for a field run.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Runtime Input P0 Phase 89 — production matrix history retention

- Fixed a production-path gap in Phase 88: `RobloxInputCheckDialog` no longer overwrites earlier evidence with `_matrixCells[cell] = evidence` before replay assessment can inspect it.
- The client now retains every matrix attempt in order for the lifetime of one input-check dialog/matrix ID and passes the full history to the existing fail-closed policy.
- A confirmed No followed by Yes can no longer evade `MATRIX_CELL_REPLAY` in the real UI; Yes followed by No and repeated confirmed `REAL_KEY` are likewise preserved and rejected as unsafe replay.
- A stale/incomplete attempt that never reached the Windows boundary may still be followed by the first confirmed retry, preserving the intended recovery flow.
- Closing and reopening Roblox Input Check creates a fresh matrix ID and fresh history; evidence is not mixed across dialogs.
- A recovery regression locks the production retention field to ordered history semantics and continues to verify replay plus incomplete-to-confirmed behavior.
- Production `keybd_event`, SendInput diagnostics, PowerShell oracle semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, and **Legacy x2** are unchanged.
- P0 remains `NOT YET PROVEN`. Explicit visible Roblox movement or the expected piano reaction from production `RobloxPiano.exe` remains mandatory.

## Field procedure

1. Open Roblox on the exact surface to test and open **Test Roblox Input**.
2. Run **Real-Key Baseline** first. Physically press and release W once while Roblox is foreground and confirm only what was visibly observed.
3. Without intentionally changing Roblox experience/process/window, run PowerShell Oracle, keybd_event Scan, SendInput VK, and SendInput Scan cells once each.
4. Do not physically press W during synthetic cells. Preserve each unique probe ID and its reaction-bound `INPUT_MATRIX_PROVENANCE` trust/reason.
5. If a cell never reached the Windows boundary, a later confirmed retry may replace that incomplete attempt. If a confirmed result was already retained, do not combine another attempt into the same matrix; close/reopen Roblox Input Check and start a fresh matrix instead.
6. Loss of focus, Roblox process/HWND replacement, missing provenance, duplicate probe identity, lower-integrity injection, physical-W contamination, malformed transitions, incomplete injected pairs, or decision-eligible cell replay keep evidence fail-closed.
7. Windows delivery, CI success, focus success, or a synthetic result without a passing physical control is not a field PASS.

## Runtime Input invariants

- Loss of authorized Roblox focus stops input; pause/stop/crash cleanup releases held keys and pedal state.
- Deterministic backend state owns authorization and mutation. AI/network are irrelevant to Runtime Input truth.
- The field-proven PowerShell behavior remains the comparison oracle; Legacy and Legacy x2 remain protected baselines.
- Matrix evidence never authorizes production playback by itself.
- `FIELD_CONFIRMED_PASS` is reserved for explicit client evidence that the production executable caused the expected visible Roblox/piano reaction.

## Audio-to-Piano boundary

- Existing Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement, DryWetMIDI persistence, preview/review, discovery verification, and deterministic `PerformanceTrack` ownership remain unchanged.
- Runtime Input Phase 89 does not modify Audio-to-Piano architecture or source-separation engineering work.
