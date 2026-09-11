---
schema: 1
version: 0.40.9
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
5. The W hold now samples the exact Roblox foreground continuously at a bounded 25 ms cadence. If focus is sampled lost at any point, W is released immediately and that probe cannot authorize playback even if Roblox regains focus before the dialog returns.
6. If the PowerShell-oracle W reaches Windows but Roblox still does not react, run `Physical-Key Diagnostic`. It keeps `keybd_event` but adds the real non-zero scan code.
7. If the physical-key diagnostic also reaches Windows but Roblox still does not react, run `SendInput Diagnostic`. It keeps the same physical scan-code meaning but emits through the supported Windows `SendInput` API.
8. Neither diagnostic can authorize normal playback or silently change the production backend. Preserve the oracle, `PHYSICAL_*` and `SENDINPUT_*` probe IDs and open Diagnostics for comparison.
9. Support Bundle export remains available for deeper investigation.

## Phase 62 P0 field-probe focus continuity

- Closes a forensic and safety gap in the authorizing PowerShell-oracle probe: foreground was previously checked before injection and at the end of the 650 ms hold, leaving a blind interval where a transient overlay/focus switch could be missed.
- The held-key interval is now sampled at 25 ms cadence under the same stable probe ID using `HOLD_SAMPLE_NNN` stages.
- Focus continuity is sticky. Once any sample reports that the exact Roblox target is no longer foreground, later focus recovery cannot rewrite the probe as healthy.
- The first sampled loss time is retained and logged as `FOCUS_LOST_DURING_HOLD` with `action=RELEASE_IMMEDIATELY`.
- On sampled focus loss the hold loop ends immediately, KeyUp is issued, release-all remains in the `finally` path, and `NativeDeliveryObserved` cannot become true for that attempt.
- Windows key-down observation is accumulated across the same full hold sequence instead of relying only on the first 50 ms.
- Normal playback mapping/backend, physical-key diagnostic, SendInput diagnostic, scheduler, Legacy baselines and Audio-to-Piano are unchanged.
- ADR 0072 records the contract and regression coverage protects sticky transient-loss behavior.

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
- If `FOCUS_LOST_DURING_HOLD` appears, that attempt is invalid for Roblox-consumption conclusions; keep the exact Roblox window foreground for the complete probe and retry.
- If `elevationParity=TargetHigher`, first remove that privilege mismatch and rerun the probe before treating Roblox consumption as the remaining failure boundary.
- If `desktopParity=Different`, first return Roblox and RobloxPiano to the same normal interactive Windows desktop and rerun the probe; no test key is emitted while the known mismatch exists.
- If `semanticParity=DIFFERENT` plus the exact PowerShell oracle visibly reacts, normal playback remains unconfirmed because production mapping differs.
- If the PowerShell oracle fails but physical-scan `keybd_event` reacts, scan-code acceptance is the leading candidate; normal playback remains unchanged until a separate production change is justified.
- If both `keybd_event` paths fail but the SendInput scan-code path reacts, the injection API semantic becomes the leading candidate; normal playback still remains unchanged until separately reviewed and regression-protected.
- If all three paths show safe Windows delivery, uninterrupted Roblox foreground and final NO reaction, character mapping, simple scan-code presence and the `keybd_event` versus `SendInput` distinction are weaker suspects. Investigate Roblox/game input consumption, environment/session/overlay/security policy or a requirement not represented by supported Windows synthetic-input APIs.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
