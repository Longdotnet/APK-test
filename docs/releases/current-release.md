---
schema: 1
version: 0.40.8
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the Sheet Library remains the normal starting point.
2. Open Roblox and run `Test Roblox Input` before trusting song playback for the current Roblox process.
3. Watch Roblox during the W probe. The normal check still replays the exact known-good PowerShell character-mapping contract (`VkKeyScanW` + `keybd_event`, scan code `0`).
4. A visible movement or W-bound piano note is still the field acceptance oracle; focus or Windows API success alone is not proof.
5. If the PowerShell-oracle W reaches Windows but Roblox still does not react, run `Physical-Key Diagnostic`. It keeps `keybd_event` but adds the real non-zero scan code.
6. If the physical-key diagnostic also reaches Windows but Roblox still does not react, run `SendInput Diagnostic`. It keeps the same physical scan-code meaning but emits through the supported Windows `SendInput` API.
7. Neither diagnostic can authorize normal playback or silently change the production backend. Preserve the oracle, `PHYSICAL_*` and `SENDINPUT_*` probe IDs and open Diagnostics for comparison.
8. Support Bundle export remains available for deeper investigation.

## Phase 61 P0 SendInput scan-code A/B diagnostic

- Normal song playback remains unchanged on the existing `keybd_event` virtual-key backend and foreground-layout production mapping.
- `Run Input Check` remains the only path that may establish process-scoped playback readiness; it continues to replay the exact PowerShell oracle.
- `Run Physical-Key Diagnostic` remains the controlled non-zero-scan-code `keybd_event` variant from Phase 60.
- A new `Run SendInput Diagnostic` uses the same PowerShell-oracle W and the same physical scan-code mapping, but emits scan-code-only keyboard input through Windows `SendInput`.
- The SendInput path uses `KEYEVENTF_SCANCODE`; extended scan codes additionally receive `KEYEVENTF_EXTENDEDKEY`, and KeyUp preserves the exact scan-code semantics with `KEYEVENTF_KEYUP`.
- The probe requires stable Roblox foreground and known-compatible Windows input desktop before emission. `SendInput` must report exactly one inserted event; otherwise the path fails closed and records the Win32 boundary.
- Every attempt has a correlated probe ID and logs `SENDINPUT_MAPPING`, `SENDINPUT_*` key-state stages and a final `SENDINPUT_SCAN_*` verdict.
- A human-confirmed SendInput reaction deliberately records `productionChanged=false success=false`; it is evidence for a future separately-reviewed production decision, not permission to switch playback automatically.
- Cancellation/failure paths issue best-effort matching KeyUp, preserving the stuck-key safety invariant.
- ADR 0070 records the A/B contract. Regression coverage protects normal/extended scan-code flags, KeyUp symmetry and scan-zero rejection.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- Sheet Library remains list-first; Browse/drag-drop are import helpers.
- Legacy and Legacy x2 remain protected regression/perceptual baselines and are not silently replaced or auto-promoted.
- Canonical performance state remains independent from TXT/MIDI/MusicXML/UI/AI/Windows input backends.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain unchanged.
- AI remains optional and is not required for playback/import/validation truth.

## Current boundaries

- CI cannot observe a live Roblox client consuming synthetic input. Explicit GUI verification plus visible Roblox reaction remains the real-machine acceptance gate.
- A log showing `keybd_event`/`SendInput` invocation or Windows key state does not by itself prove Roblox consumed the key.
- If `elevationParity=TargetHigher`, first remove that privilege mismatch and rerun the probe before treating Roblox consumption as the remaining failure boundary.
- If `desktopParity=Different`, first return Roblox and RobloxPiano to the same normal interactive Windows desktop and rerun the probe; no test key is emitted while the known mismatch exists.
- If `semanticParity=DIFFERENT` plus the exact PowerShell oracle visibly reacts, normal playback remains unconfirmed because production mapping differs.
- If the PowerShell oracle fails but physical-scan `keybd_event` reacts, scan-code acceptance is the leading candidate; normal playback remains unchanged until a separate production change is justified.
- If both `keybd_event` paths fail but the SendInput scan-code path reacts, the injection API semantic becomes the leading candidate; normal playback still remains unchanged until separately reviewed and regression-protected.
- If all three paths show safe Windows delivery, stable Roblox foreground and final NO reaction, character mapping, simple scan-code presence and the `keybd_event` versus `SendInput` distinction are weaker suspects. Investigate Roblox/game input consumption, environment/session/overlay/security policy or a requirement not represented by supported Windows synthetic-input APIs.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
