---
schema: 1
version: 0.40.12
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the **Sheet Library** remains the normal client starting point.
2. Open Roblox, then run `Test Roblox Input` before trusting playback for that Roblox process.
3. Run `Run Input Check` first. It preserves the exact PowerShell-oracle W mapping: `VkKeyScanW` + `keybd_event`, scan code `0`.
4. If Roblox does not visibly move or play the W-bound note, run `Physical-Key Diagnostic`: same `keybd_event`, now with a non-zero physical scan code.
5. Next run `SendInput VK Diagnostic`: the same oracle virtual-key meaning through `SendInput` (`wVk != 0`, `wScan = 0`, no `KEYEVENTF_SCANCODE`).
6. Finally run `SendInput Scan Diagnostic`: `SendInput` with physical scan-code semantics.
7. Every probe keeps stable foreground/focus, Windows key-state, keyboard-layout, integrity, input-desktop and now Windows logon/session context under the same correlated probe ID.
8. The three diagnostic variants can never authorize or silently change production playback. Preserve the correlated `INPUT_FORENSIC` lines or export a **Support Bundle** for field review.

## Phase 65 P0 Windows session-parity forensics

- Adds supported Win32 session evidence with `ProcessIdToSessionId` for RobloxPiano and the selected Roblox process.
- Captures `WTSGetActiveConsoleSessionId` to distinguish the local active console from same-session remote/RDP-style field contexts.
- Records `appSession`, `targetSession`, `sessionParity`, `activeConsoleSession`, `appIsActiveConsole`, `targetIsActiveConsole`, and Win32 resolution errors in the normal `ENV` forensic line.
- Emits `SESSION_BLOCKER / WINDOWS_SESSION_MISMATCH` when app and Roblox are known to be in different Windows sessions.
- Emits `SESSION_CONTEXT / NON_CONSOLE_INTERACTIVE_SESSION` when both processes share a session that is not the active console. This is evidence, not an invented failure verdict.
- Adds deterministic regression coverage for same/different/unknown session classification and active-console evidence.
- No new injection backend is added and no Windows/Roblox security boundary is bypassed.
- Normal playback mapping/backend, scheduler, Legacy baselines, held-key ownership and Audio-to-Piano remain unchanged.

## Field interpretation

- `sessionParity=Different`: that attempt is not useful evidence about Roblox consumption; run Roblox and RobloxPiano in the same Windows logon/interactive session and retry.
- `sessionParity=Same` plus `appIsActiveConsole=true` and `targetIsActiveConsole=true`: a cross-session/RDP boundary becomes a weaker suspect.
- `sessionParity=Same` but active-console flags are false: preserve the probe and compare it with a local-console run before blaming mapping or the scheduler.
- `sessionParity=Unknown`: retain the Win32 error codes; do not infer session parity.
- Even with perfect session/focus/desktop/elevation parity and Windows key-down evidence, only visible Roblox movement or a W-bound piano reaction satisfies the P0 field gate.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- **Legacy** and **Legacy x2** remain protected regression/perceptual baselines and are not silently replaced or auto-promoted.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed.
- AI/network are not required for input truth.

## Current boundaries

- CI cannot observe a live Roblox client consuming synthetic input. Visible Roblox reaction remains the acceptance gate.
- A Windows API success or `GetAsyncKeyState` DOWN observation is not by itself proof that Roblox consumed the key.
- Any sampled focus loss, privilege mismatch, input-desktop mismatch or known cross-session mismatch invalidates that attempt for Roblox-consumption conclusions.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
