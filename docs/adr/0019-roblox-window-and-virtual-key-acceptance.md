# ADR 0019: Real Roblox window and virtual-key acceptance

## Status
Accepted for production client v0.15.1.

## Context
Real Roblox testing exposed a boundary that synthetic CI could not prove. v0.14.3 corrected the native Windows `INPUT` ABI so `SendInput` stopped returning zero, but the real Roblox piano still consumed no notes.

The earlier PowerShell prototype is the strongest known-good field baseline. It discovered a Roblox process with a non-zero `MainWindowHandle`, stored that exact handle, called `SetForegroundWindow(handle)`, waited 250 ms, guarded playback with `GetForegroundWindow() == handle`, resolved characters through `VkKeyScanW`, and emitted virtual-key down/up events with character-scoped modifiers.

The .NET client had changed two of those semantics: interactive focus was accepted by process ID and keyboard packets were scan-code based. Windows accepting such a packet does not prove Roblox accepts it.

## Decision

### Exact-window focus
Interactive playback is bound to the selected Roblox `MainWindowHandle`. Activation restores that window, requests `SetForegroundWindow`, waits a bounded 250 ms, and confirms the same handle became foreground. If it did not, the existing focus gate keeps playback safely paused.

### Virtual-key input semantics
Keep the corrected modern `SendInput` ABI, but construct keyboard events to match the field-proven PowerShell semantics:
- `wVk` is the `VkKeyScanW` resolved virtual key;
- `wScan` is zero;
- key-down flags are zero;
- key-up uses `KEYEVENTF_KEYUP`;
- chord characters remain in source order;
- Shift/Ctrl/Alt are pressed and released around the corresponding character key-down.

Held note ownership, emergency release-all, cancellation and focus-loss safety remain unchanged.

### Release validation
The published `--input-abi-smoke` probe validates both the native `INPUT` structure size and the generated virtual-key packet shape. This prevents an accidental regression back to scan-code mode.

GitHub Actions still cannot prove that Roblox itself consumed the event. Real-client field acceptance remains the final boundary.

## Consequences
This hotfix composes with v0.15.0 MusicXML repeat normalization rather than replacing it. Legacy/Legacy x2, canonical scheduling, MIDI/MusicXML timing and repeat handling remain unchanged.
