# ADR 0062: Input privilege parity forensics

## Status
Accepted.

## Context
The P0 field failure class is `RobloxPiano.exe` successfully activating the Roblox window while Roblox still shows no keyboard/piano reaction. Existing correlated input forensics already prove foreground identity, keyboard layout, virtual-key mapping and Windows key state, but they could not distinguish a same-privilege run from a Windows privilege mismatch.

A common Windows boundary is an elevated target process receiving synthetic input from a non-elevated client. Focus activation alone is not sufficient evidence that this boundary is compatible with native keyboard injection, so support logs need deterministic evidence before blaming the scheduler, parser or Roblox piano mapping.

## Decision
For every explicit Roblox input probe, capture the elevation state of both the running RobloxPiano process and the exact target Roblox PID using process-token `TokenElevation` information.

The forensic `ENV` record carries `appElevation`, `targetElevation` and `elevationParity`. If Roblox is elevated while RobloxPiano is standard, emit a correlated `PRIVILEGE_BLOCKER` record with verdict `TARGET_HIGHER_INTEGRITY` and actionable guidance to run both processes at the same privilege level before judging Roblox input acceptance.

Elevation inspection is diagnostic-only. Failure to inspect either token degrades to `Unknown`; it never authorizes input, disables focus safety or changes playback truth.

## Consequences
- One field log can now separate keyboard-layout/focus/native-delivery evidence from an obvious privilege mismatch.
- The product does not automatically elevate itself or bypass Windows security boundaries.
- P0 remains `NOT YET PROVEN` until a client confirms Roblox visibly reacts to the production input path.
- The Legacy backend and `keybd_event` baseline remain unchanged.

## Regression protection
Elevation-parity classification is covered for standard/standard, elevated/elevated, target-higher, app-higher and unknown states. Existing Windows input ABI, focus, release-all and production-gate coverage remain authoritative for adjacent behavior.
