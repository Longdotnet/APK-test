---
schema: 1
version: 0.40.4
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
4. If Roblox does not react, open Diagnostics and share every `INPUT_FORENSIC` line with the same `probe=...` value. The log now shows keyboard-layout and process-elevation parity together with native key-state evidence.
5. Support Bundle export remains available for deeper investigation.

## Phase 57 P0 privilege-parity forensics

- The explicit Roblox input probe now inspects Windows `TokenElevation` for both `RobloxPiano.exe` and the exact target Roblox process.
- `INPUT_FORENSIC stage=ENV` records `appElevation`, `targetElevation` and `elevationParity` next to the existing mapping-layout, foreground and virtual-key evidence.
- If Roblox is elevated while RobloxPiano is not, the same probe emits `stage=PRIVILEGE_BLOCKER verdict=TARGET_HIGHER_INTEGRITY` with deterministic guidance to run both at the same privilege level before judging native input acceptance.
- Token inspection is diagnostic-only and fails safely to `Unknown`. The app does not auto-elevate and does not bypass Windows privilege boundaries.
- The field-proven `keybd_event` backend, scan-code-zero shape, key-up behavior, minimum physical hold, focus guard and emergency release-all remain unchanged.
- ADR 0062 records the privilege-parity evidence contract. Deterministic regression coverage protects all same/higher/unknown classification cases.

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
- If `elevationParity=Same`, the foreground keyboard mapping is correct, Windows observes W DOWN, the selected Roblox process stays foreground, and the correlated final verdict is `RobloxDidNotReact`, investigation stays on the deeper Windows/Roblox native acceptance boundary rather than scheduler, MIDI or unrelated product work.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
