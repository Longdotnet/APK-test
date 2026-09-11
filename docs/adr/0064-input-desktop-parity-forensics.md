# ADR 0064: Windows input-desktop parity for Roblox P0 forensics

## Status

Accepted for Production Phase 58.

## Context

The production Roblox input acceptance gate must distinguish a successful Windows-side key injection from Roblox actually consuming that input. The existing probe already records target process identity, foreground stability, keyboard-layout mapping, privilege/elevation parity, the field-proven `keybd_event` call shape, and `GetAsyncKeyState` evidence.

One Windows boundary remained unmeasured: the desktop associated with the input-sending thread versus the desktop currently receiving interactive user input. Windows supports alternate/secure desktops. A process can still have meaningful window/process state while its thread is attached to a desktop different from the current input desktop. In that state, treating a synthetic key attempt as representative of normal interactive Roblox input would produce misleading evidence.

## Decision

Before the explicit `Test Roblox Input` probe emits its W key, after Roblox has been activated and remained stably foreground, capture:

- the native thread ID running the probe;
- that thread's desktop using `GetThreadDesktop`;
- the active input desktop using `OpenInputDesktop`;
- both desktop names via `GetUserObjectInformationW(UOI_NAME)`;
- Win32 error codes when either name cannot be captured.

Classify the evidence as:

- `Same` when both known desktop names match case-insensitively;
- `Different` when both names are known and differ;
- `Unknown` when either side cannot be read safely.

A known `Different` result is fail-closed for the explicit field probe: do not emit the test key. Return `InputDesktopMismatch`, log `stage=DESKTOP_BLOCKER verdict=INPUT_DESKTOP_MISMATCH`, and tell the client to return Roblox and RobloxPiano to the same normal interactive Windows desktop before retrying.

`Unknown` is diagnostic evidence only and does not block the existing field-proven input path. This avoids creating a false blocker merely because a Windows API could not expose a desktop name.

The probe also records a second `PRE_INJECTION` desktop snapshot after stable focus, so a support log can distinguish startup/environment evidence from the exact pre-dispatch boundary.

## Preserved invariants

This phase does **not** replace or modify the field-proven input backend:

- `keybd_event` remains the production native backend;
- scan code remains zero, matching the PowerShell field baseline;
- foreground keyboard-layout mapping remains authoritative for character-to-VK resolution;
- privilege/elevation evidence remains independent;
- focus loss still stops input;
- key-up and emergency release-all semantics remain unchanged;
- Legacy and Legacy x2 playback baselines remain untouched;
- no Windows security boundary is bypassed or weakened.

## Field acceptance

Desktop parity is not proof that Roblox consumed a key. The P0 acceptance oracle remains a visible Roblox reaction or W-bound piano note confirmed by the client. `Same` only removes one Windows boundary from the suspect set; `Unknown` remains explicitly inconclusive.

## Regression protection

Deterministic tests cover same/different/unknown desktop classification and prove that a known mismatch cannot be counted as native delivery and returns the dedicated mismatch verdict.
