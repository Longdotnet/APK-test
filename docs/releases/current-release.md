---
schema: 1
version: 0.40.5
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the Sheet Library remains the normal starting point.
2. Open Roblox and run `Test Roblox Input` before trusting song playback for the current Roblox process.
3. Watch Roblox during the W probe. A visible movement or W-bound piano note is still the field acceptance oracle; focus or Windows API success alone is not proof.
4. If Roblox does not react, open Diagnostics and share every `INPUT_FORENSIC` line with the same `probe=...` value. The log now shows keyboard-layout, process-elevation and Windows input-desktop parity together with native key-state evidence.
5. Support Bundle export remains available for deeper investigation.

## Phase 58 P0 input-desktop parity forensics

- The explicit Roblox input probe now records the desktop attached to the native probe thread and the Windows desktop currently receiving interactive input.
- After Roblox is activated and stable foreground is established, the probe captures a second `PRE_INJECTION` desktop snapshot immediately before any test key could be emitted.
- When both desktop names are known and differ, the probe fails closed before injection with `InputDesktopMismatch` and logs `stage=DESKTOP_BLOCKER verdict=INPUT_DESKTOP_MISMATCH`.
- If Windows cannot safely expose either desktop name, parity remains `Unknown`; the existing field-proven input path is preserved instead of manufacturing a blocker from incomplete evidence.
- This phase does not attach to, switch, or bypass Windows desktops. It only observes the boundary and gives deterministic client guidance.
- The field-proven `keybd_event` backend, scan-code-zero shape, foreground keyboard-layout mapping, elevation diagnostics, key-up behavior, minimum physical hold, focus guard and emergency release-all remain unchanged.
- ADR 0064 records the input-desktop evidence contract. Regression coverage protects same, different and unknown classification plus fail-closed mismatch behavior.

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
- If `desktopParity=Unknown`, the desktop API evidence is inconclusive rather than failed; use the remaining correlated layout/elevation/key-state/foreground evidence.
- If elevation and desktop parity are healthy, the foreground keyboard mapping is correct, Windows observes W DOWN, the selected Roblox process stays foreground, and the correlated final verdict is `RobloxDidNotReact`, investigation stays on the deeper Windows/Roblox native acceptance boundary rather than scheduler, MIDI or unrelated product work.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
