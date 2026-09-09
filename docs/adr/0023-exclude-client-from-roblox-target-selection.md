# ADR 0023: Exclude Roblox Piano from Roblox target selection

## Status
Accepted for production client v0.16.3.

## Context
Real-client playback could parse and schedule songs and initialize the field-proven `VkKeyScanW` + `keybd_event` backend, yet pressing Play did not switch to the actual Roblox game or make the piano consume keys.

The root cause was target discovery rather than keyboard injection. The desktop executable is named `RobloxPiano.exe`. `RobloxProcessLocator` previously accepted any foreground process whose process name contained `Roblox`. Because the user presses Play while the Roblox Piano UI is foreground, the client classified its own process as the Roblox target. It then activated its own window and sent ordinary keyboard input back to itself.

The known-good PowerShell baseline does not have this failure mode because its host process is PowerShell while it separately resolves a Roblox window.

## Decision

- Never treat `Environment.ProcessId` as a Roblox target, both in foreground fast-path discovery and full process enumeration.
- Explicitly reject process name `RobloxPiano` from Roblox player classification.
- Preserve exact-player preference for `RobloxPlayerBeta` and `RobloxPlayer` and the existing Roblox Studio exclusion.
- Keep the proven keyboard backend unchanged: `VkKeyScanW` plus `keybd_event`, scan code 0, down flags 0 and `KEYEVENTF_KEYUP` on release.
- Extend the published Windows input compatibility smoke test so `RobloxPiano` self-classification is a release-blocking regression.

## Consequences

Pressing Play can now resolve and activate the real Roblox player instead of the client itself. The exact-window focus gate still pauses safely if Windows does not grant foreground activation. CI can prevent the deterministic self-target regression, while final confirmation that Roblox consumes the generated keys still requires a real Windows + Roblox field test.
