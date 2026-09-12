---
schema: 1
version: 0.40.40
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Runtime Input P0 Phase 87 — physical-control-gated synthetic winner

- The real-vs-synthetic matrix now requires a trusted, visibly reacting physical `REAL_KEY` W control before any provenance-clean synthetic `ROBLOX_REACTED` cell can become the conclusive `SYNTHETIC_VARIANT_REACHES_ROBLOX` verdict.
- A synthetic Yes without a physical control stays `MATRIX_INCOMPLETE` and explicitly requests **Run Real-Key Baseline**.
- A synthetic Yes paired with a real-key Windows observation but no visible Roblox reaction stays `REAL_KEY_BASELINE` invalid; the synthetic reaction cannot outrank an invalid control surface.
- A clean synthetic Yes remains conclusive when the same matrix also contains a same-session, same-selected-HWND physical W that visibly reacted.
- This closes a false-positive field-evidence path. A selected Roblox surface must first prove that W has an observable effect before synthetic semantics are interpreted as a matrix winner.
- Phase 86 reaction-bound provenance remains immutable; Phase 84–85 single-assignment/reason-coded provenance remains in force.
- Production `keybd_event`, SendInput diagnostics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, and **Legacy x2** are unchanged.
- P0 remains `NOT YET PROVEN`. Explicit visible Roblox movement or the expected piano reaction from production `RobloxPiano.exe` remains mandatory.

## Field procedure

1. Open Roblox on the exact surface to test and open **Test Roblox Input**.
2. Run **Real-Key Baseline** first. Physically press and release W once while Roblox is foreground and confirm only what was visibly observed.
3. Without intentionally changing Roblox experience/process/window, run PowerShell Oracle, keybd_event Scan, SendInput VK, and SendInput Scan cells.
4. Do not physically press W during synthetic cells. Preserve each unique probe ID and its reaction-bound `INPUT_MATRIX_PROVENANCE` trust/reason.
5. Loss of focus, Roblox process/HWND replacement, missing provenance, duplicate probe identity, lower-integrity injection, physical-W contamination, malformed transitions, or incomplete injected pairs keep the affected evidence fail-closed.
6. Windows delivery, CI success, focus success, or a synthetic result without a passing physical control is not a field PASS.

## Runtime Input invariants

- Loss of authorized Roblox focus stops input; pause/stop/crash cleanup releases held keys and pedal state.
- Deterministic backend state owns authorization and mutation. AI/network are irrelevant to Runtime Input truth.
- The field-proven PowerShell behavior remains the comparison oracle; Legacy and Legacy x2 remain protected baselines.
- Matrix evidence never authorizes production playback by itself.
- `FIELD_CONFIRMED_PASS` is reserved for explicit client evidence that the production executable caused the expected visible Roblox/piano reaction.

## Audio-to-Piano boundary

- Existing Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement, DryWetMIDI persistence, preview/review, discovery verification, and deterministic `PerformanceTrack` ownership remain unchanged.
- Runtime Input Phase 87 does not modify Audio-to-Piano architecture or source-separation engineering work.
