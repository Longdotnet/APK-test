# ADR 0027 — Roblox field input probe

Status: Accepted for production client v0.17.2.

## Context

Field testing proved that the desktop client can now resolve and foreground the real Roblox window, but the user still observed no piano input and no visible character movement. CI can validate the keyboard ABI and scheduler deterministically, but it cannot prove that a live Roblox client consumes an injected keyboard event.

The known-good PowerShell v2 baseline uses `VkKeyScanW` and `keybd_event` directly after foregrounding Roblox and waiting 250 ms. The current desktop keyboard backend uses the same native primitives, so another scheduler or MIDI change would not isolate the remaining boundary.

## Decision

1. Add an explicit `--roblox-input-probe` client mode intended only for live Windows + Roblox field validation.
2. The probe bypasses song loading, MIDI lowering, transport, scheduler, held-key ownership and playback timing.
3. It resolves the same Roblox target as the product, confirms exact foreground activation, waits an additional 350 ms, resolves lowercase `w` through `VkKeyScanW`, emits `keybd_event` DOWN with scan code 0 and flags 0, holds for 700 ms, then emits `KEYEVENTF_KEYUP`.
4. The probe logs target PID/HWND and foreground PID/HWND before DOWN, during HOLD and after UP so a field report can distinguish focus loss from input-consumption failure.
5. Normal playback remains unchanged. Existing dispatch diagnostics continue to log early scheduler-generated key events for comparison with the probe.

## Interpretation

- If Roblox visibly moves/plays a note during the probe, the Windows-to-Roblox native delivery boundary works. Remaining failure is above that boundary, in playback scheduling/focus interaction/event timing.
- If Roblox remains completely unchanged while foreground remains the exact target HWND for the whole probe, the failure is below the scheduler and should be investigated as runtime/integrity/input-consumption context rather than MIDI or timing logic.

## Release contract

The normal `--input-abi-smoke` remains non-invasive and must continue to pass in CI without sending a real key. The live `--roblox-input-probe` is never executed in CI because it intentionally requires a real Roblox window and produces a visible key press.
