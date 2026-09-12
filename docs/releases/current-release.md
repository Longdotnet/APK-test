---
schema: 1
version: 0.40.45
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; this release changes only Runtime Input field-evidence replay safety.
- **Support Bundle** remains the preferred way to preserve correlated `INPUT_MATRIX_*`, `INPUT_MATRIX_PROVENANCE`, `LOWLEVEL_PROVENANCE_*`, and `INPUT_FORENSIC` evidence for a field run.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Runtime Input P0 Phase 92 — untrusted reaction replay fail-closed

- Closed a retained-history rewrite gap left after Phase 91: an older synthetic attempt that already recorded `ROBLOX_REACTED` or `ROBLOX_NO_REACTION` can no longer become retryable merely because its reaction-bound provenance was missing or contaminated.
- Replay eligibility now distinguishes a claimed human Roblox reaction verdict from trusted Windows-boundary confirmation.
- Missing/contaminated provenance still makes that individual attempt unusable as field evidence, but it no longer allows a later clean retry to erase the earlier Yes/No history.
- Such repeated cells fail closed as `MATRIX_CELL_REPLAY` and cannot manufacture a synthetic winner or contribute to `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`.
- A genuine `WINDOWS_BOUNDARY_NOT_CONFIRMED` attempt remains retryable to the first later reaction verdict when retained Roblox PID/start-time/HWND identity stays complete and stable.
- Phase 91 retained-history identity completeness, reaction-bound provenance, physical-control gating, duplicate-probe protection and lower-integrity fail-closed remain in force.
- Production `keybd_event`, SendInput diagnostics, PowerShell oracle semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, and **Legacy x2** are unchanged.
- P0 remains `NOT YET PROVEN`. Explicit visible Roblox movement or the expected piano reaction from production `RobloxPiano.exe` remains mandatory.

## Field procedure

1. Open Roblox on the exact surface to test and open **Test Roblox Input**.
2. Run **Real-Key Baseline** first. Physically press and release W once while Roblox is foreground and confirm only what was visibly observed.
3. Without intentionally changing Roblox experience/process/window, run PowerShell Oracle, keybd_event Scan, SendInput VK, and SendInput Scan cells once each.
4. Do not physically press W during synthetic cells. Preserve each unique probe ID and its reaction-bound `INPUT_MATRIX_PROVENANCE` trust/reason.
5. If any attempt cannot capture its Roblox PID/start-time/HWND identity, close/reopen Roblox Input Check after Roblox stabilizes and start a fresh matrix.
6. Retry a cell only when the prior attempt genuinely remained `WINDOWS_BOUNDARY_NOT_CONFIRMED`; once any Yes/No reaction verdict has been retained, close/reopen Roblox Input Check to start a new matrix instead of rewriting that cell.
7. Missing/contaminated provenance, loss of focus, Roblox process/HWND replacement, unavailable retained identity, duplicate probe identity, lower-integrity injection, physical-W contamination, malformed transitions, incomplete injected pairs, decision-eligible cell replay, or retained-history session change keep evidence fail-closed.
8. Windows delivery, CI success, focus success, or a synthetic result without a passing physical control is not a field PASS.

## Runtime Input invariants

- Loss of authorized Roblox focus stops input; pause/stop/crash cleanup releases held keys and pedal state.
- Deterministic backend state owns authorization and mutation. AI/network are irrelevant to Runtime Input truth.
- The field-proven PowerShell behavior remains the comparison oracle; Legacy and Legacy x2 remain protected baselines.
- Matrix evidence never authorizes production playback by itself.
- `FIELD_CONFIRMED_PASS` is reserved for explicit client evidence that the production executable caused the expected visible Roblox/piano reaction.

## Audio-to-Piano boundary

- Existing Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement, DryWetMIDI persistence, preview/review, discovery verification, deterministic `PerformanceTrack` ownership, separation benchmark tooling, and review-region analysis remain unchanged.
- Runtime Input Phase 92 does not modify Audio-to-Piano architecture or source-separation engineering work.
