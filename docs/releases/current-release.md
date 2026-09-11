---
schema: 1
version: 0.40.11
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe`, open Roblox, then run `Test Roblox Input` before trusting playback for that Roblox process.
2. Run `Run Input Check` first. It preserves the exact PowerShell-oracle W mapping: `VkKeyScanW` + `keybd_event`, scan code `0`.
3. If Roblox does not visibly move or play the W-bound note, run `Physical-Key Diagnostic`: same `keybd_event`, now with a non-zero physical scan code.
4. Next run `SendInput VK Diagnostic`: the same oracle virtual-key meaning through `SendInput` (`wVk != 0`, `wScan = 0`, no `KEYEVENTF_SCANCODE`).
5. Finally run `SendInput Scan Diagnostic`: `SendInput` with physical scan-code semantics.
6. Every probe requires stable Roblox foreground, same input desktop, Windows-observed key-down evidence, and continuous 25 ms sampled focus. Focus loss releases W immediately and invalidates the attempt.
7. The three diagnostic variants can never authorize or silently change production playback. Preserve all correlated probe IDs in Diagnostics.

## Phase 64 P0 SendInput virtual-key matrix completion

- Adds the missing A/B matrix cell: `SendInput` with virtual-key semantics matching the PowerShell oracle.
- Separates injection-API effects from scan-code effects instead of changing both at once.
- Adds `SENDINPUT_VK_*` structured forensic stages, stable probe IDs, VK/scan/flags semantics, foreground PID/HWND/TID, elapsed hold samples, Windows key state, focus-loss evidence and a final verdict.
- Uses the same exact Win32 `INPUT` ABI guard as the scan-code diagnostic (40 bytes x64 / 28 bytes x86).
- Uses `wScan = 0`, omits `KEYEVENTF_SCANCODE`, and adds only `KEYEVENTF_KEYUP` on release.
- Matching KeyUp is attempted in `finally`; sampled focus loss triggers immediate release and can never produce native-delivery evidence.
- Normal playback mapping/backend, scheduler, Legacy baselines and Audio-to-Piano remain unchanged.

## Field interpretation

- Oracle FAIL + SendInput-VK PASS: injection API is a stronger candidate; physical scan-code conversion is not required for that PASS.
- SendInput-VK FAIL + SendInput-Scan PASS: physical scan-code semantics are the stronger SendInput-side difference.
- Both SendInput probes PASS while both keybd_event probes FAIL: `SendInput` itself is the strongest tested difference.
- All four show safe Windows delivery and continuous Roblox focus but Roblox still shows no reaction: basic VK/scan choice and keybd_event-vs-SendInput are weaker suspects; continue at Roblox/game input consumption, environment/session/overlay/security boundaries.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- Legacy and Legacy x2 remain protected baselines.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed.
- AI/network are not required for input truth.

## Current boundaries

- CI cannot observe a live Roblox client consuming synthetic input. Visible Roblox reaction remains the acceptance gate.
- A Windows API success or `GetAsyncKeyState` DOWN observation is not by itself proof that Roblox consumed the key.
- Any sampled focus loss, privilege mismatch or input-desktop mismatch invalidates that attempt for Roblox-consumption conclusions.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
