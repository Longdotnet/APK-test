---
schema: 1
version: 0.40.16
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

## Phase 69 P0 Raw Input consumption boundary

- Every explicit field probe now inventories Windows Raw Input device classes with `GetRawInputDeviceList` under the same stable probe ID.
- Logs expose keyboard, mouse and HID device counts plus capture errors, without logging device names or machine-specific device paths.
- `targetRawRegistration=UNOBSERVABLE_CROSS_PROCESS` is explicit: public `GetRegisteredRawInputDevices` state is process-local, so RobloxPiano does not pretend it can read Roblox's Raw Input registration.
- When keyboard-class Raw Input devices exist, `RAW_INPUT_CONSUMPTION_UNOBSERVABLE` records the remaining boundary: a synthetic `keybd_event`/`SendInput` transition observed through Windows is not proof of a hardware-originated `WM_INPUT` packet reaching Roblox.
- This evidence is contextual only. It does not claim Roblox uses Raw Input and it does not turn a missing Roblox reaction into a PASS or a platform-security bypass.
- Deterministic regressions lock zero/one/multiple keyboard-device assessment and the cross-process visibility contract.
- No normal scheduler/playback mapping, Legacy baseline, injection backend, held-key/pedal ownership, Audio-to-Piano subsystem or authorization truth is changed by this phase.

## Field interpretation

- `rawInputAssessment=PhysicalKeyboardDeviceObserved` means Windows exposes at least one keyboard-class Raw Input device on the machine; it does not identify the device and does not prove Roblox registered for it.
- `RAW_INPUT_DEVICE_INVENTORY_UNAVAILABLE` means this attempt lacks Raw Input inventory context and should not be used to infer the game's consumption path.
- `targetRawRegistration=UNOBSERVABLE_CROSS_PROCESS` is expected and deliberate, not an error.
- If window/session/desktop/elevation/layout/GUI-focus evidence is clean and Windows sees W DOWN while Roblox does not react, Raw Input or another game-engine/device-specific consumption path remains plausible rather than disproven.
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
- GUI-thread and Raw Input inventory evidence narrow the consumption boundary but do not expose another process's internal registration or prove Roblox's game engine accepted the event.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.