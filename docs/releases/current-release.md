---
schema: 1
version: 0.40.41
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; this release changes only Runtime Input field-evidence policy.
- **Support Bundle** remains the preferred way to preserve correlated `INPUT_MATRIX_*`, `INPUT_MATRIX_PROVENANCE`, `LOWLEVEL_PROVENANCE_*`, and `INPUT_FORENSIC` evidence for a field run.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Runtime Input P0 Phase 88 — matrix-cell replay fail-closed

- The real-vs-synthetic matrix no longer uses last-write-wins semantics when the same logical cell is retained more than once.
- Any repeated `REAL_KEY`, `POWERSHELL_ORACLE`, `KEYBD_EVENT_SCAN`, `SENDINPUT_VK`, or `SENDINPUT_SCAN` observation makes the matrix non-conclusive with `MATRIX_CELL_REPLAY`.
- A synthetic No followed by Yes can no longer manufacture a winner, and a Yes followed by No cannot erase a prior reaction or contribute to a false all-synthetic-failure boundary.
- Repeated physical `REAL_KEY` evidence cannot rewrite the control baseline either.
- `INPUT_MATRIX_CELL_REPLAY` logs the affected cells and explicitly remains diagnostic-only; the client must start a fresh matrix from Real-Key Baseline.
- Phase 87 physical-control gating and Phase 84–86 single-assignment/reaction-bound provenance remain in force.
- Production `keybd_event`, SendInput diagnostics, PowerShell oracle semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, and **Legacy x2** are unchanged.
- P0 remains `NOT YET PROVEN`. Explicit visible Roblox movement or the expected piano reaction from production `RobloxPiano.exe` remains mandatory.

## Field procedure

1. Open Roblox on the exact surface to test and open **Test Roblox Input**.
2. Run **Real-Key Baseline** first. Physically press and release W once while Roblox is foreground and confirm only what was visibly observed.
3. Without intentionally changing Roblox experience/process/window, run PowerShell Oracle, keybd_event Scan, SendInput VK, and SendInput Scan cells once each.
4. Do not physically press W during synthetic cells. Preserve each unique probe ID and its reaction-bound `INPUT_MATRIX_PROVENANCE` trust/reason.
5. If a matrix cell must be retried, start a fresh matrix instead of combining repeated attempts. A retained duplicate fails closed as `MATRIX_CELL_REPLAY`.
6. Loss of focus, Roblox process/HWND replacement, missing provenance, duplicate probe identity, lower-integrity injection, physical-W contamination, malformed transitions, incomplete injected pairs, or repeated logical cells keep evidence fail-closed.
7. Windows delivery, CI success, focus success, or a synthetic result without a passing physical control is not a field PASS.

## Runtime Input invariants

- Loss of authorized Roblox focus stops input; pause/stop/crash cleanup releases held keys and pedal state.
- Deterministic backend state owns authorization and mutation. AI/network are irrelevant to Runtime Input truth.
- The field-proven PowerShell behavior remains the comparison oracle; Legacy and Legacy x2 remain protected baselines.
- Matrix evidence never authorizes production playback by itself.
- `FIELD_CONFIRMED_PASS` is reserved for explicit client evidence that the production executable caused the expected visible Roblox/piano reaction.

## Audio-to-Piano boundary

- Existing Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement, DryWetMIDI persistence, preview/review, discovery verification, and deterministic `PerformanceTrack` ownership remain unchanged.
- Runtime Input Phase 88 does not modify Audio-to-Piano architecture or source-separation engineering work.
