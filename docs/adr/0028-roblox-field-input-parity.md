# ADR 0028 — Roblox field input parity

Status: Accepted for production client v0.17.2.

## Context

Field validation proved that the desktop client can now visibly switch to Roblox, yet the user still observed no piano notes and no character movement. The known-good PowerShell baseline does produce visible Roblox keyboard behavior.

Production v0.17.1 already improves one major focus failure mode by authorizing foreground continuity by the selected Roblox PID instead of freezing the session to one captured top-level HWND. It also records sampled DOWN/UP dispatch diagnostics. This phase builds on that fix rather than replacing it.

The remaining parity differences are timing and field observability. PowerShell does not immediately emit and release a zero-duration pulse: it resolves the key, emits key-down, holds the physical key for a visible interval, and only then emits key-up. It also gives Roblox time after focus before real playback begins.

## Decision

1. Preserve the selected-Roblox-PID authorization boundary and HWND-change tolerance introduced in v0.17.1.
2. Preserve `VkKeyScanW + keybd_event(vk, 0, flags, UIntPtr.Zero)` as the production input backend.
3. Require the selected Roblox PID to remain foreground continuously for 750 ms before the playback focus gate becomes ACTIVE. Losing foreground resets this settle timer.
4. Apply a 50 ms minimum physical hold to normal scheduled note pulses. Holds already longer than 50 ms are unchanged. Emergency release-all remains immediate.
5. Keep the sampled v0.17.1 dispatch diagnostics and add the minimum-hold policy to the backend initialization log.
6. Add a real-machine diagnostic command:

   `RobloxPiano.exe --roblox-input-field-test`

   It bypasses MIDI and the playback scheduler, activates the selected Roblox process, waits for stable foreground, and holds `W` for 650 ms through the exact production input sink.
7. During the field probe, record target PID/HWND, virtual key, managed thread, foreground continuity, hold duration and Windows `GetAsyncKeyState` observation. The user-visible Roblox reaction remains the final oracle.
8. Extend the published EXE input ABI smoke contract so CI verifies the timing policy without generating a real key on the CI runner.

## Field interpretation

- If the field probe visibly moves the character or triggers the W-bound piano note, Windows-to-Roblox input delivery works and any remaining song failure is above the native boundary.
- If `windowsKeyDownObserved=true` and the selected Roblox PID stays foreground but Roblox still shows no reaction, the next investigation is specifically Roblox/Windows synthetic-input acceptance or process trust/integrity.
- If the field probe never observes Windows key-down, the native backend remains the blocker.
- If the selected Roblox PID does not stay foreground, focus continuity remains the blocker.

## Consequences

- Playback waits roughly one deliberate input-arm interval after programmatic focus rather than racing the first note into a newly activated Roblox window.
- Sub-50-ms MIDI pulses become physically observable for at least several typical game frames, at the cost of a small timing extension only for those extremely short pulses.
- MIDI parsing, sustain, library import, transport ownership and the v0.17.1 process-focus fix remain intact.
