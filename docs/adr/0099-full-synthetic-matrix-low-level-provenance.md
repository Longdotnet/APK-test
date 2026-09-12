# ADR 0099: Full synthetic-matrix low-level keyboard provenance

## Status

Accepted.

## Context

Runtime Input P0 Phase 79 attached a bounded diagnostic-only `WH_KEYBOARD_LL` observer to the PowerShell-oracle `keybd_event` cell. The remaining synthetic matrix cells — non-zero-scan `keybd_event`, SendInput virtual-key, and SendInput scan-code — still lacked the same OS-level provenance evidence.

That asymmetry weakens a same-session physical-vs-synthetic comparison. `GetAsyncKeyState` and injection API success can establish useful Windows-boundary evidence, but they do not show whether the low-level keyboard stream classified each explicit W down/up pair as injected or lower-integrity injected.

## Decision

Phase 80 reuses `WindowsLowLevelKeyboardProvenance` for all three remaining synthetic cells.

For every explicit synthetic W attempt:

- arm the existing target-key-only `WH_KEYBOARD_LL` observer only after the selected Roblox surface is stable;
- start observation immediately before synthetic W-down;
- stop observation immediately after W-up;
- retain the immutable provenance snapshot on the corresponding probe result;
- emit the existing `LOWLEVEL_PROVENANCE_ARMED`, `LOWLEVEL_PROVENANCE_EVENT`, and `LOWLEVEL_PROVENANCE_SUMMARY` records under the same probe ID;
- retain event-driven foreground continuity, polling fallback, `GetAsyncKeyState`, desktop/session/integrity evidence and explicit human Roblox reaction as independent signals;
- defensively end observation during exception/cancellation cleanup while continuing best-effort key release.

The observer still filters to the explicit probe virtual key only. It never blocks, rewrites or injects input and records no unrelated keyboard activity.

## Consequences

The field matrix now has one comparable low-level provenance contract across the PowerShell-oracle, non-zero-scan `keybd_event`, SendInput virtual-key and SendInput scan-code paths. A client log can therefore distinguish API/scan semantics from Windows injected/lower-integrity classification without guessing from API return values alone.

This phase does not change `NativeDeliveryObserved`, production authorization, scheduler truth, Legacy/Legacy x2, focus guard, held-key/pedal ownership, or promote any synthetic backend. A complete injected down/up pair observed by Windows is still not proof that Roblox consumed it. P0 remains `NOT YET PROVEN` until explicit real-Roblox reaction evidence confirms the field gate.