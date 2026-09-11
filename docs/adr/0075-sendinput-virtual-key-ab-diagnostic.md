# ADR 0075: SendInput virtual-key A/B diagnostic

## Status
Accepted for P0 field diagnostics.

## Context
The production P0 investigation already had three controlled W probes:

1. PowerShell oracle: `keybd_event` with virtual-key semantics and scan code 0.
2. Physical-key diagnostic: `keybd_event` with a non-zero physical scan code.
3. SendInput scan diagnostic: `SendInput` with `KEYEVENTF_SCANCODE` and a non-zero physical scan code.

That left one matrix cell untested: `SendInput` while preserving the oracle's virtual-key semantics. Without that cell, a field PASS on SendInput scan-code input could not cleanly distinguish the injection API from scan-code semantics.

## Decision
Add a diagnostic-only `SendInput` virtual-key probe with the exact oracle virtual key, `wScan = 0`, no `KEYEVENTF_SCANCODE`, and `KEYEVENTF_KEYUP` only on release.

The probe inherits the same safety/evidence rules as the other P0 probes:

- target Roblox must be activated and stably foreground before injection;
- known input-desktop mismatch blocks injection;
- held W is sampled at the common 25 ms focus-continuity cadence;
- sampled focus loss is sticky and triggers immediate release;
- Windows-observed key-down is required for native-delivery evidence;
- matching KeyUp is attempted in `finally`;
- a field reaction is recorded separately from Windows API success;
- the diagnostic cannot authorize normal playback and cannot mutate the production backend.

The GUI exposes four explicit matrix cells in order: PowerShell oracle, physical keybd_event, SendInput virtual-key, SendInput physical scan-code.

## Field interpretation
- Oracle fails, SendInput-VK reacts: injection API is a stronger suspect while scan-code conversion is not required.
- SendInput-VK fails, SendInput-scan reacts: scan-code semantics are the stronger SendInput-side difference.
- Both SendInput paths react while both keybd_event paths fail: injection API is the stronger difference.
- All four establish safe Windows delivery with continuous Roblox focus but Roblox still does not react: basic VK/scan selection and keybd_event-vs-SendInput become weaker suspects; continue at Roblox/game consumption, environment/session/overlay/security boundaries.

## Consequences
Normal playback, scheduler, Legacy baselines, held-key ownership and Audio-to-Piano are unchanged. CI can validate ABI, event construction and fail-closed evidence semantics, but only explicit live Roblox observation can satisfy the P0 field gate.
