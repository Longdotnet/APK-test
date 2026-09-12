---
schema: 1
version: 0.40.43
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; this release changes only Runtime Input field-evidence continuity.
- **Support Bundle** remains the preferred way to preserve correlated `INPUT_MATRIX_*`, `INPUT_MATRIX_PROVENANCE`, `LOWLEVEL_PROVENANCE_*`, and `INPUT_FORENSIC` evidence for a field run.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Runtime Input P0 Phase 90 — retained-history session continuity

- Fixed a matrix continuity gap left after Phase 89: an incomplete attempt from an older known Roblox process/window can no longer disappear when the same cell is retried successfully on a new Roblox surface.
- Matrix assessment now checks every retained attempt with a known probe-bound PID/start-time/HWND identity before collapsing a safe retry to the latest cell result.
- If retained history crosses a known Roblox process lifetime or selected HWND, assessment fails closed with `ROBLOX_SESSION_CHANGED_DURING_MATRIX` and logs `INPUT_MATRIX_HISTORY_SESSION_CHANGED`.
- Incomplete-to-first-confirmed retry remains supported when every known retained attempt stays on the same Roblox process/window identity.
- An older incomplete attempt whose session identity was genuinely unavailable remains recoverable; final decision-eligible evidence still must pass the existing session/current-reaction-context gates.
- Phase 88 replay fail-closed, Phase 89 ordered history, provenance binding and physical-control gating remain in force.
- Production `keybd_event`, SendInput diagnostics, PowerShell oracle semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, and **Legacy x2** are unchanged.
- P0 remains `NOT YET PROVEN`. Explicit visible Roblox movement or the expected piano reaction from production `RobloxPiano.exe` remains mandatory.

## Field procedure

1. Open Roblox on the exact surface to test and open **Test Roblox Input**.
2. Run **Real-Key Baseline** first. Physically press and release W once while Roblox is foreground and confirm only what was visibly observed.
3. Without intentionally changing Roblox experience/process/window, run PowerShell Oracle, keybd_event Scan, SendInput VK, and SendInput Scan cells once each.
4. Do not physically press W during synthetic cells. Preserve each unique probe ID and its reaction-bound `INPUT_MATRIX_PROVENANCE` trust/reason.
5. If a cell never reached the Windows boundary, a later confirmed retry is valid only while Roblox remains the same known PID/start-time/HWND identity. If Roblox restarts or the selected HWND changes, close/reopen Roblox Input Check and start a fresh matrix.
6. Loss of focus, Roblox process/HWND replacement, missing provenance, duplicate probe identity, lower-integrity injection, physical-W contamination, malformed transitions, incomplete injected pairs, decision-eligible cell replay, or retained-history session change keep evidence fail-closed.
7. Windows delivery, CI success, focus success, or a synthetic result without a passing physical control is not a field PASS.

## Runtime Input invariants

- Loss of authorized Roblox focus stops input; pause/stop/crash cleanup releases held keys and pedal state.
- Deterministic backend state owns authorization and mutation. AI/network are irrelevant to Runtime Input truth.
- The field-proven PowerShell behavior remains the comparison oracle; Legacy and Legacy x2 remain protected baselines.
- Matrix evidence never authorizes production playback by itself.
- `FIELD_CONFIRMED_PASS` is reserved for explicit client evidence that the production executable caused the expected visible Roblox/piano reaction.

## Audio-to-Piano boundary

- Existing Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement, DryWetMIDI persistence, preview/review, discovery verification, and deterministic `PerformanceTrack` ownership remain unchanged.
- Runtime Input Phase 90 does not modify Audio-to-Piano architecture or source-separation engineering work.
