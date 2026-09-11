---
schema: 1
version: 0.40.3
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
4. If Roblox does not react, open Diagnostics and share every `INPUT_FORENSIC` line with the same `probe=...` value. The log now shows app/foreground/mapping keyboard layouts in addition to native key-state evidence.
5. Support Bundle export remains available for deeper investigation.

## Phase 56 P0 foreground keyboard-layout parity

- Production character mapping now follows the current foreground Roblox window thread with `GetKeyboardLayout(foregroundThreadId)` + `VkKeyScanExW` instead of assuming the RobloxPiano UI thread layout.
- The field-proven `keybd_event` backend, scan-code-zero shape, key-up flags and minimum physical key hold remain unchanged.
- Mapping falls back to the calling-thread layout only when a usable foreground layout cannot be obtained; unmappable characters still fail closed.
- `INPUT_FORENSIC stage=ENV` now records `appKeyboardLayout`, `foregroundKeyboardLayout`, `mappingLayout`, mapping/foreground thread IDs and an explicit `layoutParity=SAME|DIFFERENT` marker.
- Normal sampled playback dispatch diagnostics include the keyboard layout and thread used to resolve each logged stroke.
- ADR 0061 locks the target-layout mapping contract while preserving the live Roblox reaction acceptance gate from ADR 0060.

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
- If `layoutParity=DIFFERENT`, v0.40.3 maps using `mappingLayout=foregroundKeyboardLayout`; this removes app-thread keyboard-layout divergence as a cause before investigating Roblox/native acceptance.
- If Windows observes W DOWN while the selected Roblox process remains foreground and the correlated final verdict is `RobloxDidNotReact`, investigation stays on Roblox/native acceptance rather than scheduler, MIDI or unrelated feature work.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
