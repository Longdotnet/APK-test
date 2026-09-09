# ADR 0027 — Roblox process focus continuity and field input evidence

Status: Accepted for production client v0.17.1.

## Context

Field validation after v0.16.5 confirmed that the client can locate Roblox and visibly switch the foreground window, but no piano notes or character movement are observed. The known-good PowerShell baseline uses `VkKeyScanW` plus `keybd_event`, and the production EXE already uses the same virtual-key down/up primitive. Static API parity alone is therefore no longer enough evidence.

The client also treated one captured top-level HWND as the permanent focus identity. Roblox may restore, recreate or swap top-level windows while remaining in the same selected player process. In that case a user can visibly be in Roblox while the playback kernel sees the exact captured HWND as unfocused, repeatedly releases held keys and waits before any input dispatch.

## Decision

1. Keep the selected Roblox process ID as the authorization boundary for one playback session.
2. Treat the target as focused when either the captured HWND is foreground or the current foreground HWND belongs to that exact selected Roblox PID.
3. Do not broaden focus authorization to another Roblox process, Roblox Studio, RobloxPiano itself or an unrelated foreground application.
4. Preserve the field-proven `VkKeyScanW` + `keybd_event(vk, 0, flags, UIntPtr.Zero)` backend.
5. Add sampled production diagnostics at the input boundary. The first 20 dispatches and every 100th dispatch record DOWN/UP, resolved virtual keys/modifiers, managed thread, foreground HWND and foreground PID. Release-all records the same foreground evidence when physical keys were held.
6. Log focus-gate transitions with target PID/HWND and actual foreground PID/HWND so a field report can distinguish scheduler focus blocking from Windows input dispatch.
7. Do not log every note indefinitely; diagnostics are sampled to remain useful on long songs without producing unbounded per-note noise.

## Consequences

- Playback no longer stalls solely because Roblox changes its top-level window handle inside the already-authorized player process.
- If Roblox still does not react, the client log can now prove whether KeyDown/KeyUp reached the Windows backend and which process was foreground at that exact dispatch.
- The fix does not claim that CI can prove Roblox consumes synthetic input; real-client validation remains required.
- MIDI parsing, sustain, timing, library import, hotkeys and held-key ownership remain unchanged.

## Field acceptance

A production field run should show this sequence in Diagnostics:

1. `Roblox activation confirmed` with the selected target PID.
2. `Roblox focus gate ACTIVE` with the same foreground PID.
3. `Keyboard input backend initialized: keybd_event`.
4. `Input dispatch #1 DOWN` followed by later UP dispatches while the foreground PID remains the selected Roblox PID.

If steps 1-2 appear but step 4 does not, the scheduler path remains the blocker. If step 4 appears with the correct foreground PID but Roblox still shows no movement or piano response, investigation moves below the scheduler to Windows/Roblox input acceptance rather than changing MIDI or focus logic again.
