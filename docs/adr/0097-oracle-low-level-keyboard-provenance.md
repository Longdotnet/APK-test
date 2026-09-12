# ADR 0097: PowerShell-oracle low-level keyboard provenance

## Status

Accepted for Runtime Input P0 Phase 79.

## Problem

The real-W baseline already observes `WH_KEYBOARD_LL` and rejects events marked `LLKHF_INJECTED`, while the PowerShell-oracle synthetic cell primarily proves the Windows boundary through injection success plus `GetAsyncKeyState`. That leaves an evidence asymmetry at the exact boundary now under investigation: Windows key state can become DOWN without the same field log showing how the low-level keyboard stream classified the synthetic event.

When physical W visibly works in Roblox but the PowerShell-oracle path does not, device-origin/injected provenance is a leading discriminator. We need that evidence from the same bounded attempt without changing production playback or pretending Windows can attest Roblox internal consumption.

## Decision

Add a bounded diagnostic-only `WH_KEYBOARD_LL` observer to the explicit PowerShell-oracle field probe.

The observer:

- is armed after the exact selected Roblox surface is stable and before synthetic W-down;
- observes only the exact W virtual key used by the probe and ignores unrelated keys;
- records target down/up scan code and low-level flags;
- classifies `NotInjected`, `Injected`, and `LowerIntegrityInjected`, with `LLKHF_LOWER_IL_INJECTED` taking precedence over the generic injected classification;
- logs `LOWLEVEL_PROVENANCE_ARMED`, per-event `LOWLEVEL_PROVENANCE_EVENT`, and a terminal `LOWLEVEL_PROVENANCE_SUMMARY` under the same probe ID;
- never blocks, rewrites, replays or authorizes input;
- is disposed at the end of the bounded attempt, including failure/cancellation paths.

`GetAsyncKeyState`, focus/window continuity, desktop/session/integrity evidence and explicit human Roblox reaction remain independently recorded. Phase 79 does not make low-level hook provenance a new production authorization rule because that would change field semantics before real Roblox evidence establishes the correct policy.

## Forensic interpretation

A clean oracle attempt can now distinguish:

- Windows key state observed + low-level injected down/up observed + Roblox reaction YES;
- Windows key state observed + low-level injected down/up observed + Roblox reaction NO;
- Windows key state observed but target low-level down/up missing;
- lower-integrity injected provenance, which strengthens the existing UIPI/integrity investigation.

The second case is stronger evidence for `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`, but it is still not `FIELD PASS`. Roblox Piano cannot inspect Roblox internal input consumption.

## Privacy and safety

The observer filters to the single explicit probe virtual key. It does not log unrelated keyboard input, secrets, text, clipboard data or user content. Focus loss still releases held diagnostic input through the existing probe safety path. Normal scheduler/input ownership, Legacy/Legacy x2 behavior and production key mapping are unchanged.

## Validation

Regression coverage locks:

- unmarked events classify as non-injected;
- `LLKHF_INJECTED` classifies as injected;
- `LLKHF_LOWER_IL_INJECTED` takes precedence when both Windows flags are present;
- only the configured target virtual key is accepted;
- W down/up message classification is deterministic.

CI success is not field evidence. Phase 79 remains `NOT YET PROVEN` until a client confirms visible Roblox reaction for the tested input path.
