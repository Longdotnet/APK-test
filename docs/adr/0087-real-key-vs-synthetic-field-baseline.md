# ADR 0087: Real-key versus synthetic Roblox field baseline

## Status

Accepted — Roblox Runtime Input P0 Phase 70.

## Context

The P0 acceptance gate remains visible reaction inside real Roblox. Windows-side key state, API success, focus, session, desktop, privilege, window identity, GUI-thread context and Raw Input inventory are necessary evidence but are not proof that Roblox consumed a synthetic input event.

The existing button named `Physical-Key Diagnostic` did not observe a physical user key. It still emitted synthetic input through `keybd_event`; the only difference from the PowerShell-oracle path was a non-zero scan code. That made the label misleading and left an important field question unanswered: does the same Roblox surface react to a real W key while rejecting all supported synthetic W paths?

## Decision

Add a bounded, diagnostic-only **Real-Key Baseline** before the synthetic matrix.

The baseline:

- activates the selected Roblox window and requires stable foreground first;
- installs a `WH_KEYBOARD_LL` hook only for the bounded observation interval;
- waits up to 10 seconds for the user to physically press and release W once;
- records only W events; unrelated keys are neither retained nor logged;
- rejects events carrying Windows `LLKHF_INJECTED`;
- requires Roblox to own foreground at accepted W down and W up;
- injects no key, mutates no scheduler state and cannot authorize playback;
- removes the hook immediately after the accepted W release, cancellation or timeout.

An event without `LLKHF_INJECTED` is called a **physical-baseline candidate**. This is intentionally not described as cryptographic proof of hardware provenance; the flag is used only to reject events Windows explicitly marks as injected.

The previous `Physical-Key Diagnostic` is renamed in the client to **keybd_event Scan Diagnostic** so its actual synthetic semantics are visible.

## Correlated field matrix

One input-check dialog now owns a stable matrix ID. Every client-observed cell records its independent probe ID under that matrix:

1. `REAL_KEY` — no injection; user presses W.
2. `POWERSHELL_ORACLE` — field-proven PowerShell-parity virtual-key `keybd_event` semantics.
3. `KEYBD_EVENT_SCAN` — synthetic `keybd_event` with a non-zero physical scan code.
4. `SENDINPUT_VK` — synthetic `SendInput` virtual-key semantics.
5. `SENDINPUT_SCAN` — synthetic `SendInput` scan-code semantics.

This avoids comparing unrelated sessions or losing which human Roblox observation belongs to which Windows-side probe.

## Interpretation

`REAL_KEY=ROBLOX_REACTED` plus clean Windows evidence for a synthetic cell that reports `ROBLOX_NO_REACTION` is strong evidence that the unresolved boundary lies in synthetic delivery / Roblox game-input consumption rather than basic focus or whether the selected Roblox surface responds to W at all.

`REAL_KEY=ROBLOX_NO_REACTION` does not prove a synthetic-input defect. The selected experience/surface must first respond visibly to real W for the A/B comparison to be meaningful.

Even when real W reacts and every synthetic cell fails, the P0 gate is still **NOT YET PROVEN**. Production `RobloxPiano.exe` is `FIELD PASS` only after its actual Test Roblox Input / Play path visibly moves Roblox or produces the expected W-bound piano note.

## Safety and privacy

The baseline does not bypass UIPI, Roblox security, Raw Input, driver boundaries or platform controls. It does not inspect Roblox process memory and does not emulate hardware. It observes only W for a short client-initiated interval.

Normal playback remains fail-closed on focus loss. Existing held-key/pedal ownership, emergency release, Legacy baseline and deterministic authorization remain authoritative. Audio-to-Piano is untouched.

## Validation

Regression coverage locks:

- unmarked W on the trusted Roblox foreground is eligible as a baseline candidate;
- `LLKHF_INJECTED` W is rejected;
- unrelated keys are rejected;
- W outside the Roblox foreground is rejected;
- complete down/up plus stable foreground is required;
- missing release, lost foreground or incomplete activation fails closed.

Exact-head and exact-main production gates remain authoritative before release.