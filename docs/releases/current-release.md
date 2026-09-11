---
schema: 1
version: 0.40.2
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
4. If Roblox does not react, open Diagnostics and share every `INPUT_FORENSIC` line with the same `probe=...` value. Mapping, foreground, Windows key-state and the final human Yes/No reaction verdict are now correlated end-to-end.
5. Support Bundle export remains available for deeper investigation.

## Phase 55 P0 Roblox input forensics

- The explicit Roblox field probe has a unique correlation id and emits an unsampled forensic sequence.
- Diagnostics record requested character, Unicode, raw `VkKeyScanW`, resolved virtual key/modifier mask and active keyboard layout.
- Target Roblox PID/HWND and foreground PID/HWND are captured at important stages.
- The exact production `keybd_event` backend is used; no diagnostic-only injection backend exists.
- Windows key state is sampled before DOWN, immediately after DOWN, after 25 ms, after 50 ms, before UP and after UP.
- Elapsed physical hold and foreground continuity distinguish mapping/focus/native failures from Roblox rejection.
- v0.40.2 closes the final correlation gap: the user's Roblox reaction Yes/No verdict is emitted through `INPUT_FORENSIC stage=VERDICT` with the exact same probe id.
- ADR 0060 makes live Roblox reaction the P0 acceptance gate; CI/API invocation is not end-to-end proof.

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
- If Windows observes W DOWN while the selected Roblox process remains foreground and the correlated final verdict is `RobloxDidNotReact`, investigation stays on Roblox/native acceptance rather than scheduler, MIDI or unrelated feature work.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
