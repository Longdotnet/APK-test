# ADR 0066: Exact PowerShell oracle mapping parity probe

## Status
Accepted for the next production client release.

## Context
The strongest field evidence for Roblox keyboard acceptance remains the original PowerShell prototype. That prototype resolved characters with `VkKeyScanW` and emitted `keybd_event` with scan code `0`. Production playback later improved layout handling by resolving characters with `VkKeyScanExW` against the foreground Roblox thread layout.

That foreground-layout change is reasonable for general playback, but it means the explicit field probe was no longer replaying the exact known-good mapping boundary. When Roblox focused successfully but did not react, support could not tell whether the regression lived in Roblox/native acceptance or in the mapping difference between the historical PowerShell oracle and current production playback.

## Decision
Keep normal playback unchanged on the foreground-layout mapping strategy. Change only the explicit `Test Roblox Input` probe so it can replay the exact PowerShell mapping contract:

- resolve the W probe with `VkKeyScanW` on the calling thread;
- emit the same `keybd_event` virtual-key down/up events with scan code `0`;
- preserve the 650 ms field-probe hold, stable-focus gate, desktop parity check, key-state sampling, key-up and release-all safety;
- independently resolve W through the normal production foreground-layout strategy;
- compare the emitted virtual-key/modifier semantics from both strategies and log them under the same probe ID.

Keyboard-layout handles and thread IDs are evidence, but mapping equivalence is defined by emitted virtual key plus modifiers. Two mappings can therefore be semantically equivalent even if their HKL/thread provenance differs.

A visible Roblox reaction to the PowerShell-oracle probe authorizes normal playback only when the production mapping is semantically equivalent. If Roblox reacts but the mappings differ, the probe returns `PowerShellOracleConfirmedProductionMappingDiffers` and keeps playback gated. This prevents a successful diagnostic path from falsely certifying a different production path.

## Diagnostics
Each probe now records:

- production strategy, VK, modifiers, HKL and foreground thread;
- PowerShell-oracle strategy, VK, modifiers and calling-thread HKL;
- `semanticParity=SAME|DIFFERENT`;
- the existing elevation, input-desktop, foreground and `GetAsyncKeyState` evidence.

The actual test-key dispatch logs `mappingStrategy=PowerShellOracle`, while ordinary song playback continues to log `mappingStrategy=ForegroundLayout`.

## Consequences
This phase narrows the remaining P0 boundary without prematurely changing the production playback backend. It can prove one of two valuable outcomes on a real client:

1. the exact PowerShell-compatible path also fails inside the EXE, moving investigation below character mapping toward Windows/Roblox capture semantics; or
2. the oracle path works while production mapping differs, isolating a mapping regression that can be fixed and field-retested before promotion.

CI protects the fail-closed authorization rule, but only a visible reaction in a live Roblox client can satisfy the field acceptance gate.
