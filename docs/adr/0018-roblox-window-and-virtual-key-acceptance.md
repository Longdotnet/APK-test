# ADR-0018: Real Roblox window and virtual-key acceptance

- Status: Accepted
- Date: 2026-09-09

## Context

The production client reached two distinct Windows acceptance failures during real Roblox testing.

v0.14.3 fixed the first failure: the managed Windows `INPUT` structure was undersized, so `SendInput` returned zero. After correcting the ABI, `SendInput` succeeded, but the real Roblox piano still received no notes. This proved that Windows API success is not equivalent to target-application acceptance.

The earlier PowerShell prototype is the strongest known-good real-client baseline. It:

1. discovered a Roblox process with a non-zero `MainWindowHandle`;
2. stored that exact window handle;
3. called `SetForegroundWindow(handle)` and waited 250 ms;
4. guarded playback by comparing `GetForegroundWindow()` to that exact handle;
5. resolved characters with `VkKeyScanW`;
6. sent virtual-key down/up events, with Shift/Ctrl/Alt applied only around the corresponding character key-down.

The first .NET implementation deliberately changed item 6 to scan-code `SendInput`. CI could prove the packet was structurally valid, but it could not prove Roblox accepted that semantic form.

## Decision

### 1. Treat the proven PowerShell behavior as the Roblox acceptance baseline

The desktop client keeps the modern `SendInput` API and the corrected native `INPUT` ABI, but constructs keyboard packets using **virtual-key semantics**:

- `wVk = resolved virtual key`;
- `wScan = 0`;
- key-down flags = `0`;
- key-up flags = `KEYEVENTF_KEYUP`.

This preserves the supported Windows API while matching the event semantics that already worked in the real Roblox client.

### 2. Preserve original chord order and modifier scope

Each character is processed in source order. Its Shift/Ctrl/Alt modifiers are pressed immediately before that character's key-down and released immediately afterward. Held note keys remain owned by the existing release-all state machine.

This restores mixed-chord behavior such as uppercase + lowercase notes without grouping or reordering notes by modifier state.

### 3. Bind safety to the exact Roblox window handle

Interactive playback focus is now true only when `GetForegroundWindow()` equals the selected Roblox `MainWindowHandle`.

The activation path restores the selected window, requests `SetForegroundWindow`, waits 250 ms like the known-good prototype, and confirms that exact window became foreground before reporting activation success.

A rejected activation never bypasses safety. The playback kernel continues waiting until the selected Roblox window is actually foreground.

### 4. CI distinguishes structural validity from application acceptance

The published `--input-abi-smoke` probe now validates both:

- native `INPUT` structure size;
- generated Roblox compatibility packets use virtual-key semantics (`VirtualKey != 0`, `ScanCode = 0`, expected key-up flags).

GitHub Actions still cannot prove that a real Roblox client consumed the event. Real-client field validation remains mandatory for that final boundary.

## Consequences

- Windows API success no longer causes us to assume Roblox acceptance.
- The current executable is materially closer to the proven PowerShell behavior without reverting to PowerShell or deprecated client dependencies.
- Legacy/Legacy x2, canonical scheduling, MIDI/MusicXML, pause/seek/focus-loss release-all and deterministic playback truth remain unchanged.
- If Roblox changes its input acceptance in the future, a backend change must be justified by real-client evidence rather than only a synthetic CI pass.
