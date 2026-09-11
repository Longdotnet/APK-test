---
schema: 1
version: 0.40.14
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

## Phase 67 P0 fail-closed Roblox window continuity

- The authorizing PowerShell-oracle probe now requires the exact selected Roblox window or its selected root/owner tree before injection and throughout the W hold; same PID alone is no longer sufficient.
- Stable-focus acquisition resets when the foreground is a same-process alternate root, an unknown/different surface, or the selected Roblox process has replaced its `MainWindowHandle`.
- Window identity is sampled at the same 25 ms cadence as focus/key-state continuity while W is held.
- `WINDOW_IDENTITY_LOST_DURING_HOLD / WINDOW_IDENTITY_LOST_BEFORE_UP` is sticky for the attempt and releases W immediately instead of waiting for the nominal 650 ms hold.
- `NativeDeliveryObserved` now requires trusted window identity to have remained continuous, so an alternate/splash/replaced Roblox surface cannot authorize Play even if the original game window later regains foreground.
- The blocker log preserves first-loss time, target/current-main/foreground/root HWNDs and `windowRelation` under the same stable probe ID.
- Deterministic regressions protect exact target/tree acceptance, same-PID alternate-root rejection, unknown rejection, live main-window replacement rejection, immediate authorization invalidation, and the rule that Windows-side evidence still requires explicit Roblox field observation.
- No normal scheduler/playback mapping, Legacy baseline, injection backend, held-key/pedal ownership, platform-security boundary, or Audio-to-Piano subsystem is changed by this phase.

## Field interpretation

- `WINDOW_IDENTITY_LOST_BEFORE_UP`, `windowRelation=SameProcessAlternateRoot`, or `targetMainReplaced=true`: the attempt is invalid for Roblox-consumption conclusions; rerun Test Roblox Input so it binds to the current game surface.
- `windowRelation=ExactTarget` or `TargetWindowTree` throughout the full probe, together with same session/desktop/elevation parity, continuous focus and Windows key-down evidence, makes stale/replaced/alternate Roblox surface confusion a weaker suspect.
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
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
