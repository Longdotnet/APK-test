---
schema: 1
version: 0.40.10
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
5. All three explicit W probes now sample the exact Roblox foreground continuously at a bounded 25 ms cadence. If focus is sampled lost at any point, the held W is released immediately and that attempt cannot be treated as native-delivery evidence even if Roblox regains focus before the dialog returns.
6. If the PowerShell-oracle W reaches Windows but Roblox still does not react, run `Physical-Key Diagnostic`. It keeps `keybd_event` but adds the real non-zero scan code.
7. If the physical-key diagnostic also reaches Windows but Roblox still does not react, run `SendInput Diagnostic`. It keeps the same physical scan-code meaning but emits through the supported Windows `SendInput` API.
8. Neither diagnostic can authorize normal playback or silently change the production backend. Preserve the oracle, `PHYSICAL_*` and `SENDINPUT_*` probe IDs and open Diagnostics for comparison.
9. Support Bundle export remains available for deeper investigation.

## Phase 63 P0 diagnostic focus continuity

- Extends the sticky 25 ms focus-continuity contract from the authorizing PowerShell-oracle probe to both diagnostic A/B paths.
- Physical scan-code `keybd_event` attempts now emit `PHYSICAL_HOLD_SAMPLE_NNN`; SendInput scan-code attempts emit `SENDINPUT_HOLD_SAMPLE_NNN` under their stable probe IDs.
- If either diagnostic observes the exact Roblox target lose foreground while W is held, it logs the first sampled loss time, stops the hold immediately, sends the matching KeyUp, and remains fail-closed even if foreground later returns.
- Windows key-down observation is accumulated across the full held interval instead of relying on only the first 50 ms.
- `NativeDeliveryObserved` for both diagnostics now requires uninterrupted sampled foreground for the complete hold.
- Verdict logs include `continuousFocus` so one field log can distinguish native input evidence from an invalid transient-focus attempt.
- Normal playback mapping/backend, scheduler, Legacy baselines and Audio-to-Piano are unchanged.

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
- Any `FOCUS_LOST_DURING_HOLD`, `PHYSICAL_FOCUS_LOST_DURING_HOLD`, or `SENDINPUT_FOCUS_LOST_DURING_HOLD` marker invalidates that attempt for Roblox-consumption conclusions; keep the exact Roblox window foreground for the complete probe and retry.
- If `elevationParity=TargetHigher`, first remove that privilege mismatch and rerun the probe before treating Roblox consumption as the remaining failure boundary.
- If `desktopParity=Different`, first return Roblox and RobloxPiano to the same normal interactive Windows desktop and rerun the probe; no test key is emitted while the known mismatch exists.
- If `semanticParity=DIFFERENT` plus the exact PowerShell oracle visibly reacts, normal playback remains unconfirmed because production mapping differs.
- If the PowerShell oracle fails but physical-scan `keybd_event` reacts, scan-code acceptance is the leading candidate; normal playback remains unchanged until a separate production change is justified.
- If both `keybd_event` paths fail but the SendInput scan-code path reacts, the injection API semantic becomes the leading candidate; normal playback still remains unchanged until separately reviewed and regression-protected.
- If all three paths show safe Windows delivery, uninterrupted sampled Roblox foreground and final NO reaction, character mapping, simple scan-code presence and the `keybd_event` versus `SendInput` distinction are weaker suspects. Investigate Roblox/game input consumption, environment/session/overlay/security policy or a requirement not represented by supported Windows synthetic-input APIs.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
