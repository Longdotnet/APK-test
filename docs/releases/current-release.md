---
schema: 1
version: 0.40.6
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the Sheet Library remains the normal starting point.
2. Open Roblox and run `Test Roblox Input` before trusting song playback for the current Roblox process.
3. Watch Roblox during the W probe. The probe now replays the exact known-good PowerShell character-mapping contract (`VkKeyScanW` + `keybd_event`, scan code `0`) rather than silently substituting the normal playback mapper.
4. A visible movement or W-bound piano note is still the field acceptance oracle; focus or Windows API success alone is not proof.
5. If Roblox does not react, open Diagnostics and share every `INPUT_FORENSIC` line with the same `probe=...` value. The log correlates production-vs-oracle mapping, keyboard layouts, process elevation, Windows input desktop, foreground identity and native key-state evidence.
6. Support Bundle export remains available for deeper investigation.

## Phase 59 P0 exact PowerShell-oracle mapping parity probe

- Normal song playback remains unchanged on the foreground-Roblox keyboard mapping introduced earlier; this release does not silently promote a new playback backend.
- The explicit field probe now resolves W with the original field-proven `VkKeyScanW` semantics and still dispatches through `keybd_event` with scan code `0`.
- The same probe independently resolves W through normal production `VkKeyScanExW`/foreground-layout mapping and logs both VK/modifier results under `stage=MAPPING_PARITY`.
- Mapping parity compares the actual emitted virtual key and modifiers, not merely keyboard-layout handles or thread IDs.
- If the PowerShell-oracle probe visibly works but production mapping differs, the result is `PowerShellOracleConfirmedProductionMappingDiffers`; normal playback remains gated instead of falsely treating a different input path as proven.
- If the oracle probe and production mapping are equivalent and Roblox visibly reacts, the existing process-scoped input confirmation may succeed.
- If the exact oracle probe is delivered, Roblox remains foreground, and Roblox still does not react, character mapping is no longer the leading suspect; investigation moves deeper into Windows/Roblox keyboard-capture semantics.
- ADR 0066 records this fail-closed A/B evidence contract. Regression coverage protects semantic mapping comparison and prevents oracle-only success from authorizing a different production mapping.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- Sheet Library remains list-first; Browse/drag-drop are import helpers.
- Legacy and Legacy x2 remain protected regression/perceptual baselines and are not silently replaced or auto-promoted.
- Canonical performance state remains independent from TXT/MIDI/MusicXML/UI/AI/Windows input backends.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain unchanged.
- AI remains optional and is not required for playback/import/validation truth.

## Current boundaries

- CI cannot observe a live Roblox client consuming synthetic input. Explicit GUI verification plus visible Roblox reaction remains the real-machine acceptance gate.
- A log showing `keybd_event` invocation or Windows key state does not by itself prove Roblox consumed the key.
- If `elevationParity=TargetHigher`, first remove that privilege mismatch and rerun the probe before treating Roblox consumption as the remaining failure boundary.
- If `desktopParity=Different`, first return Roblox and RobloxPiano to the same normal interactive Windows desktop and rerun the probe; no test key is emitted while the known mismatch exists.
- If `desktopParity=Unknown`, the desktop API evidence is inconclusive rather than failed; use the remaining correlated mapping/elevation/key-state/foreground evidence.
- `semanticParity=DIFFERENT` plus a visible oracle reaction identifies a production mapping boundary and deliberately does not certify normal playback.
- `semanticParity=SAME`, healthy elevation/desktop evidence, Windows-observed W DOWN, stable Roblox foreground and a final `RobloxDidNotReact` verdict moves the remaining suspect boundary below character mapping toward Roblox/game keyboard capture or deeper native input semantics.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
