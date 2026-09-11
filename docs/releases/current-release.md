---
schema: 1
version: 0.40.15
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

## Phase 68 P0 foreground GUI-thread input context

- Explicit field probes now capture Windows `GetGUIThreadInfo` evidence for the current foreground thread under the same stable probe ID.
- Logs include GUI active, focus, capture, menu-owner, move/size and caret HWNDs plus their relation to the selected Roblox window tree.
- Focus is classified as `TrustedTargetSurface`, `SameProcessAlternateRoot`, `DifferentProcess`, `NoFocusedWindow` or `Unknown` instead of assuming foreground HWND alone proves keyboard focus context.
- `GUI_FOCUS_SAME_PROCESS_ALTERNATE_ROOT`, `GUI_FOCUS_OUTSIDE_ROBLOX`, `GUI_FOCUS_NONE` and `GUI_THREAD_INFO_UNAVAILABLE` are fail-visible forensic context. They do not invent a Roblox PASS or bypass platform security.
- The same focus/capture snapshot is attached to explicit key-state samples during the W hold, so one client log can show whether GUI focus context changed before/down/during/up.
- Win32 capture failure preserves `GetLastWin32Error`; foreground-thread replacement/races therefore remain observable instead of silently becoming trusted evidence.
- Deterministic regressions protect exact-target/tree focus acceptance and preserve alternate-root/foreign/unknown/zero-focus distinctions.
- No normal scheduler/playback mapping, Legacy baseline, injection backend, held-key/pedal ownership, Audio-to-Piano subsystem or authorization truth is changed by this phase.

## Field interpretation

- `guiFocusAssessment=TrustedTargetSurface` throughout the probe strengthens the case that input was directed while the foreground GUI thread itself was focused inside the selected Roblox window tree.
- `GUI_FOCUS_SAME_PROCESS_ALTERNATE_ROOT` means the Roblox process owns foreground activity but GUI focus is on another root; preserve it when comparing splash/overlay/alternate-surface behavior.
- `GUI_FOCUS_OUTSIDE_ROBLOX` means foreground/root evidence and GUI focus disagree; that attempt is poor evidence for Roblox consumption even if Windows reports W down.
- `GUI_FOCUS_NONE` can be legitimate for some rendering/input models and is evidence, not an automatic field failure.
- `hwndCapture` is Windows GUI capture state, not proof of keyboard capture. It is logged only as context.
- Even perfect Windows-side evidence does not satisfy the P0 gate. Only visible Roblox movement or a W-bound piano reaction is `FIELD PASS`.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- **Legacy** and **Legacy x2** remain protected regression/perceptual baselines.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed.
- AI/network are not required for input truth.

## Current boundaries

- CI cannot observe a live Roblox client consuming synthetic input. Visible Roblox reaction remains the acceptance gate.
- A Windows API success or `GetAsyncKeyState` DOWN observation is not by itself proof that Roblox consumed the key.
- Any sampled focus loss, window-identity drift, privilege mismatch, input-desktop mismatch, known cross-session mismatch or stale/replaced target window invalidates that attempt for Roblox-consumption conclusions.
- GUI-thread focus/capture evidence narrows the consumption boundary but is not itself proof that Roblox's game engine accepted the input event.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.