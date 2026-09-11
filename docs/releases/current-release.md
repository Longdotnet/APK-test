---
schema: 1
version: 0.40.7
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
5. If the PowerShell-oracle W reaches Windows but Roblox still does not react, open the same Input Check dialog and run `Physical-Key Diagnostic`. It emits the same W through `keybd_event` with the real non-zero keyboard scan code as a controlled A/B experiment.
6. The physical-key diagnostic can never authorize normal playback or silently change the production backend. If it reacts, preserve both probe IDs and open Diagnostics; that result isolates a physical-key/scan-code acceptance difference for the next production decision.
7. If neither probe reacts, open Diagnostics and share every `INPUT_FORENSIC` line with the matching `probe=...` values. Support Bundle export remains available for deeper investigation.

## Phase 60 P0 controlled physical-key A/B probe

- Normal song playback remains unchanged on the field-proven `keybd_event` virtual-key backend and foreground-layout production mapping.
- `Run Input Check` remains the only field probe that may establish process-scoped playback readiness; it continues to replay the exact Phase 59 PowerShell oracle.
- A new opt-in `Run Physical-Key Diagnostic` holds character mapping constant on the PowerShell-oracle W, derives its physical scan code through `MapVirtualKeyExW(..., MAPVK_VK_TO_VSC_EX, oracle HKL)`, and emits that same W using `keybd_event` with a non-zero scan code.
- Known Windows input-desktop mismatch still fails closed before injection. The diagnostic also requires stable Roblox foreground and records Windows key-state evidence while W is held.
- Scan code `0` is rejected by construction so the physical diagnostic cannot accidentally collapse back into the existing oracle path.
- Every diagnostic attempt has an independent correlated probe ID and logs `PHYSICAL_MAPPING`, `PHYSICAL_*` key-state stages and a final `PHYSICAL_SCAN_*` verdict.
- A human-confirmed physical-key reaction deliberately records `productionChanged=false success=false`; it is evidence for the next engineering phase, not permission to switch normal playback.
- Cancellation and failure paths issue a best-effort matching key-up, preserving the product's stuck-key safety invariant.
- ADR 0068 records the A/B evidence contract. Regression coverage protects VK/scan-code preservation, key-up symmetry, scan-zero rejection and keybd_event ABI bounds.

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
- If `semanticParity=DIFFERENT` plus the exact PowerShell oracle visibly reacts, normal playback remains unconfirmed because production mapping differs.
- If the PowerShell-oracle path does not visibly react but the non-zero scan-code diagnostic does, the remaining evidence points strongly at physical-key/scan-code acceptance. Normal playback still remains gated until a production change is separately justified and tested.
- If both paths show Windows-observed W DOWN, stable Roblox foreground and final NO reaction, character mapping and simple scan-code presence are no longer leading suspects; investigate Roblox/game capture, Raw Input semantics, overlays or another native-consumption boundary.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
