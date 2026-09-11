# ADR 0061: Foreground keyboard-layout parity for Roblox input

## Status
Accepted

## Context

The field-proven production backend is `VkKeyScan*` plus `keybd_event`, matching the PowerShell baseline that has worked on real Roblox clients. Phase 55 made the input path observable, but production character mapping still used `VkKeyScanW`, which resolves against the calling thread's active keyboard layout. The Roblox foreground thread can use a different layout from the RobloxPiano WinForms thread on multilingual Windows systems. That creates an avoidable parity gap: the requested Roblox piano character can resolve to a different virtual key/modifier tuple before the otherwise-correct `keybd_event` call.

## Decision

1. Resolve playback characters against the keyboard layout owned by the current foreground window thread.
2. Use `GetWindowThreadProcessId` + `GetKeyboardLayout(foregroundThreadId)` + `VkKeyScanExW` for the mapping used by the production `WindowsKeyboardInputSink`.
3. If no usable foreground layout can be obtained, fall back to the calling thread layout and `VkKeyScanW`; unmappable characters still fail closed.
4. Keep the native injection backend unchanged: virtual-key `keybd_event`, scan code 0, `KEYEVENTF_KEYUP` on release, and the existing minimum physical key-hold policy.
5. Phase 55 forensic evidence must expose application, foreground and actually-used mapping layouts plus foreground thread identity, so a client log can prove whether layout divergence existed.
6. This does not weaken focus, Roblox-process authorization, release-all, held-key/pedal ownership, or the requirement for a visible live Roblox reaction before input is considered accepted.

## Consequences

- The EXE follows the keyboard interpretation of the Roblox foreground thread instead of assuming its own UI thread layout.
- Multilingual/layout-switched Windows clients get deterministic evidence showing whether the app and Roblox layouts differ.
- CI can validate build/ABI contracts but still cannot prove that a live Roblox game consumes synthetic input; the GUI W probe and visible reaction remain the P0 field acceptance oracle.
- No AI, network service, Python, PowerShell module or additional runtime dependency is introduced.
