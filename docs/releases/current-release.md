---
schema: 1
version: 0.40.13
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
4. If Roblox does not visibly move or play the W-bound note, run `Physical-Key Diagnostic`, `SendInput VK Diagnostic`, then `SendInput Scan Diagnostic` to isolate key semantics from injection API behavior.
5. Preserve the correlated `INPUT_FORENSIC` lines or export a **Support Bundle** for field review.

## Phase 66 P0 foreground/root-window identity forensics

- Every explicit input probe now captures the foreground HWND/PID/TID together with `GA_ROOT` and `GA_ROOTOWNER` identities, process ownership and privacy-safe window class names.
- The selected Roblox HWND is compared with the process's current `MainWindowHandle`, so a live Roblox process that replaced its top-level window is visible instead of being mistaken for the original field target.
- `WINDOW_BLOCKER / TARGET_WINDOW_REPLACED` is emitted when the selected Roblox PID is still alive but its current main HWND no longer matches the selected target HWND.
- `WINDOW_CONTEXT / SAME_PROCESS_ALTERNATE_ROOT` records cases where foreground still belongs to the Roblox PID but is a different top-level/root window, which helps separate the game surface from overlays, splash windows and replacement-window behavior.
- Key-state samples carry `windowRelation`, root/root-owner HWNDs and replacement state under the same stable probe ID, so one client log can show exactly when the window identity changed during the attempt.
- Deterministic regression coverage protects exact-target, target-tree, same-process alternate-root, unrelated-process, unknown and live-window-replacement classification.
- No injection backend, scheduler, playback mapping, focus authorization or platform-security boundary is changed by this phase.

## Field interpretation

- `targetMainReplaced=true` or `TARGET_WINDOW_REPLACED`: rerun Test Roblox Input and bind to the current Roblox window before using the attempt as Roblox-consumption evidence.
- `windowRelation=SameProcessAlternateRoot`: preserve the log; the foreground is still in the Roblox PID, but not the originally selected root surface.
- `windowRelation=ExactTarget` or `TargetWindowTree` throughout the probe, together with same-session/desktop/elevation parity, continuous focus and Windows key-down evidence, makes stale-window/root-window confusion a weaker suspect.
- Even perfect Windows-side evidence does not satisfy the P0 gate. Only visible Roblox movement or a W-bound piano reaction is `FIELD PASS`.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- **Legacy** and **Legacy x2** remain protected regression/perceptual baselines.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed.
- AI/network are not required for input truth.

## Current boundaries

- CI cannot observe a live Roblox client consuming synthetic input. Visible Roblox reaction remains the acceptance gate.
- A Windows API success or `GetAsyncKeyState` DOWN observation is not by itself proof that Roblox consumed the key.
- Any sampled focus loss, privilege mismatch, input-desktop mismatch, known cross-session mismatch or stale/replaced target window invalidates that attempt for Roblox-consumption conclusions.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
