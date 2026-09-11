---
schema: 1
version: 0.40.17
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the **Sheet Library** remains the normal client starting point.
2. Open Roblox, then run `Test Roblox Input` before trusting playback for that Roblox process.
3. Start with **Run Real-Key Baseline**. Roblox Piano focuses Roblox, injects nothing, then waits up to 10 seconds for you to physically press and release W once.
4. Confirm whether the same Roblox surface visibly moved or played the W-bound note.
5. Without changing the Roblox experience/session, run **Run PowerShell-Oracle Check**. If needed, continue with **keybd_event Scan Diagnostic**, **SendInput VK Diagnostic**, and **SendInput Scan Diagnostic**.
6. Preserve the correlated `INPUT_MATRIX` / `INPUT_FORENSIC` lines or export a **Support Bundle** for field review.

## Phase 70 P0 real-key versus synthetic field baseline

- The client now has a bounded real-W baseline that injects no input. It observes only the W key while Roblox owns foreground and removes the keyboard hook after release, cancellation or timeout.
- Windows `LLKHF_INJECTED` is used to reject OS-marked injected W events. An unmarked event is treated only as a physical-baseline candidate; it is not claimed as cryptographic proof of hardware provenance.
- The former **Physical-Key Diagnostic** was synthetic `keybd_event` with a non-zero scan code. It is now named **keybd_event Scan Diagnostic** so the UI no longer implies it captures a real physical key.
- One stable matrix ID correlates the human Roblox observation for `REAL_KEY`, `POWERSHELL_ORACLE`, `KEYBD_EVENT_SCAN`, `SENDINPUT_VK`, and `SENDINPUT_SCAN`, while each cell retains its independent forensic probe ID.
- If real W visibly reacts on the same Roblox surface but a synthetic probe has clean Windows delivery and no Roblox reaction, the field evidence now isolates the unresolved boundary toward synthetic delivery / Roblox game-input consumption rather than basic focus or a non-responsive game surface.
- The baseline cannot authorize Play, change scheduler truth or produce `FIELD_CONFIRMED_PASS`. Production still requires an actual Roblox reaction from the executable's Test Roblox Input / Play path.
- No injection backend, normal scheduler/playback mapping, Legacy baseline, held-key/pedal ownership, Audio-to-Piano subsystem or platform-security boundary is changed by this phase.

## Field interpretation

- `REAL_KEY_ROBLOX_REACTED` means a complete non-injected-candidate W down/up pair was observed while Roblox remained foreground and the client confirmed visible Roblox movement or the W-bound note.
- `REAL_KEY_ROBLOX_NO_REACTION` means the selected Roblox surface did not provide a usable physical baseline; synthetic-vs-real conclusions should not be drawn from that matrix.
- `INPUT_MATRIX matrix=...` ties the real baseline and supported synthetic cells to one client field campaign so support evidence is not accidentally compared across unrelated sessions.
- Existing session/desktop/elevation/layout/window/GUI-focus/Raw Input context remains relevant. Any known blocker still invalidates a synthetic attempt for Roblox-consumption conclusions.
- Even perfect Windows-side evidence does not satisfy the P0 gate. Only visible Roblox reaction from the production executable's input path is `FIELD PASS`.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- **Legacy** and **Legacy x2** remain protected regression/perceptual baselines.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed.
- AI/network are not required for input truth.

## Current boundaries

- CI cannot observe a live Roblox client consuming synthetic input. Visible Roblox reaction remains the acceptance gate.
- A Windows API success or `GetAsyncKeyState` DOWN observation is not by itself proof that Roblox consumed the key.
- The low-level hook can reject Windows-marked injected events but cannot provide cryptographic hardware attestation.
- Any sampled focus loss, window-identity drift, privilege mismatch, input-desktop mismatch, known cross-session mismatch or stale/replaced target window invalidates that attempt for Roblox-consumption conclusions.
- GUI-thread and Raw Input inventory evidence narrow the consumption boundary but do not expose another process's internal registration or prove Roblox's game engine accepted the event.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.