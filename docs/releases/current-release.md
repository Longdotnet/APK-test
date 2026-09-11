---
schema: 1
version: 0.40.1
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the Sheet Library remains the normal starting point.
2. Open Roblox and run `Test Roblox Input` before trusting song playback for the current Roblox process.
3. Watch Roblox during the W probe. A visible movement or W-bound piano note is the field acceptance oracle; focus or Windows API success alone is not treated as proof.
4. If Roblox does not react, open Diagnostics and share the correlated `INPUT_FORENSIC probe=...` lines. They now identify mapping, foreground, Windows key-state and final-verdict boundaries directly.
5. Support Bundle export remains available for a bounded support package when deeper investigation is needed.

## Phase 55 P0 Roblox input forensics

- The explicit Roblox field probe now has a unique correlation id and emits an unsampled forensic sequence.
- Diagnostics record the requested character, Unicode code point, raw `VkKeyScanW` result, resolved virtual key/modifier mask and active keyboard layout.
- Target Roblox PID/HWND and foreground PID/HWND are captured at each important stage.
- The exact production `keybd_event` backend is used; no diagnostic-only injection backend was introduced.
- Windows key state is sampled before DOWN, immediately after DOWN, after 25 ms, after 50 ms, before UP and after UP.
- Elapsed physical hold and foreground continuity are recorded so a log can distinguish a mapping/focus/native-boundary failure from Roblox rejecting an otherwise observed synthetic key.
- Machine-readable verdict logging explicitly separates Windows-path evidence from human-confirmed Roblox reaction.
- General playback dispatch remains bounded/sampled; only the short field probe is unsampled.
- ADR 0060 makes real Roblox acceptance a P0 field gate and forbids treating CI/API invocation as end-to-end proof.

## Production capability and reliability

- The production client remains a self-contained Windows x64 single EXE with no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- Sheet Library remains list-first; Browse/drag-drop are import helpers.
- Legacy and Legacy x2 remain protected regression/perceptual baselines and are not silently replaced or auto-promoted.
- Canonical performance state remains independent from TXT/MIDI/MusicXML/UI/AI/Windows input backends.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain unchanged.
- AI remains optional and is not required for playback/import/validation truth.

## Current boundaries

- CI cannot observe a live Roblox client consuming synthetic input. The explicit GUI input verification and visible Roblox reaction remain the real-machine acceptance gate.
- A log showing `keybd_event` invocation or Windows key state does not by itself prove Roblox consumed the key.
- If Windows observes W DOWN while the selected Roblox process remains foreground and the user reports no visible reaction, investigation must stay on the Roblox/native acceptance boundary rather than drifting into scheduler, MIDI or unrelated feature work.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
