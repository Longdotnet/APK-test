# ADR 0093 — Event-driven real-key hold continuity

## Status

Accepted for Runtime Input P0 Phase 77.

## Context

Phase 76 made the trusted physical-W baseline fail closed when the selected Roblox surface was not continuously foreground between W-down and W-up. The implementation sampled foreground/window identity every 25 ms. That matched the synthetic probe cadence, but left a forensic blind spot: a short foreground hop away from Roblox and back inside one polling interval could escape observation while both key endpoints still looked valid.

That matters because the real-key baseline is the control used to interpret `REAL_KEY_WORKS_SYNTHETIC_FAILS`. A false trusted control can send the investigation toward the Roblox synthetic-consumption boundary when the real control itself was not actually held on one stable surface.

## Decision

During the bounded real-key baseline probe, install an out-of-context `EVENT_SYSTEM_FOREGROUND` WinEvent hook alongside the existing low-level keyboard hook.

After the first accepted non-injected W-down and before its accepted W-up:

- every foreground-change event immediately re-captures `WindowsRobloxWindowIdentity`;
- if the foreground is not the selected trusted Roblox window/tree, hold continuity is permanently invalidated;
- returning to Roblox later cannot re-arm the same hold;
- the existing 25 ms polling remains as a fallback for window-identity changes that do not emit a foreground event;
- key-down and key-up endpoint checks remain in force.

The hook is diagnostic-only. It never injects input and never authorizes playback.

## Forensics

`REAL_KEY_ARMED` records `holdContinuityForegroundEvents=true`.

A foreground hop during an active hold emits `REAL_KEY_FOREGROUND_EVENT` followed by the existing fail-closed `REAL_KEY_HOLD_CONTINUITY_LOST`, now including `source=WINEVENT_FOREGROUND`.

This lets one client log distinguish event-driven loss from polling/final/key-up loss without collecting unrelated window titles or personal data.

## Safety and compatibility

- The production input backend is unchanged.
- `keybd_event`, SendInput diagnostics, the PowerShell oracle, scheduler truth, focus authorization and held-key/pedal ownership are unchanged.
- If either required diagnostic hook cannot be armed, the baseline probe fails instead of silently downgrading its evidence quality.
- The WinEvent hook is removed with the keyboard hook when the bounded probe is disposed.

## Acceptance

Regression policy proves that:

- foreground changes before W-down do not invalidate a nonexistent hold;
- trusted foreground events during the hold preserve continuity;
- any untrusted foreground event during the hold invalidates continuity even if it could be shorter than 25 ms;
- a stale trusted identity with `target.IsForeground == false` still fails closed;
- events after accepted W-up do not mutate the completed result.

This phase improves the confidence of the control evidence only. Runtime Input P0 remains `NOT YET PROVEN` until a real Roblox client visibly reacts to production input.
