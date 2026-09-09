# ADR 0027 — Roblox field input parity

Status: Accepted for production client v0.17.1.

## Context

Real-client validation proved that the desktop EXE can now select and activate the correct Roblox player window, but Roblox still showed no visible keyboard behavior: no piano notes and no character movement. The older PowerShell baseline does produce visible Roblox keyboard behavior.

The native packet shape is already aligned with the known-good PowerShell implementation: `VkKeyScanW` resolves the active-layout virtual key, `keybd_event` sends key-down with scan code 0 and flags 0, modifiers are applied around the main key-down, and key-up uses `KEYEVENTF_KEYUP`.

The remaining production gap is therefore field delivery and timing around the native packet rather than MIDI parsing or target discovery.

## Decision

1. Keep `VkKeyScanW + keybd_event` as the production backend. Do not switch back to the later SendInput experiment.
2. Require the exact Roblox HWND to remain foreground continuously for 750 ms before the playback focus gate reports input-ready. Focus loss resets the settle timer, so playback resumes only after Roblox is stable again.
3. Enforce a 50 ms minimum physical hold for normal scheduled key pulses. Emergency release-all remains immediate. This prevents very short MIDI pulses from becoming effectively invisible to a frame-driven Roblox client while preserving longer canonical holds unchanged.
4. Add a real field diagnostic command:

   `RobloxPiano.exe --roblox-input-field-test`

   The command resolves the same Roblox target as production playback, activates it, waits for stable foreground, then holds `W` for 650 ms using the exact production keyboard backend. Outside a piano this should visibly move/act like W; inside a piano it should trigger the W-bound note.
5. The field diagnostic logs target PID/HWND, virtual key, managed thread, exact foreground status, key hold duration and Windows `GetAsyncKeyState` observation. It does not claim Roblox consumption automatically; the real client remains the final oracle.
6. Extend the published EXE input ABI smoke contract so release CI verifies the field timing policy without emitting a real keyboard event on the CI runner.

## Consequences

- Production playback no longer begins immediately after `SetForegroundWindow`; Roblox receives a deliberate input-arm interval first.
- Extremely short note events gain a small physical hold floor. This may slightly lengthen sub-50-ms physical pulses, but avoids the worse failure mode where Roblox observes no key-down frame at all.
- The field-test command separates three layers that were previously conflated: target activation, Windows native key state, and visible Roblox consumption.
- If the field test reports Windows key-down while Roblox still does not react, the next investigation can focus specifically on OS/Roblox trust or input acceptance rather than MIDI, scheduler, focus targeting or packet shape.
