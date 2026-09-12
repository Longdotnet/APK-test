# ADR 0095: Event-driven synthetic probe continuity

## Status

Accepted for Runtime Input P0 Phase 78.

## Problem

Phase 77 made the physical-W control event-driven with `EVENT_SYSTEM_FOREGROUND`, but the synthetic matrix cells still decided hold continuity from 25 ms polling. A foreground hop away from the selected Roblox surface and back between two samples could therefore be invisible to a synthetic probe. That could contaminate a same-session matrix by treating a focus-interrupted synthetic attempt as clean evidence for `REAL_KEY_WORKS_SYNTHETIC_FAILS` / `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`.

## Decision

All explicit synthetic field probes arm a bounded `EVENT_SYSTEM_FOREGROUND` WinEvent hook before key down:

- PowerShell-oracle virtual-key `keybd_event` probe;
- non-zero scan-code `keybd_event` diagnostic;
- SendInput virtual-key diagnostic;
- SendInput scan-code diagnostic.

During the active key hold, any foreground transition outside the trusted selected Roblox window/tree permanently invalidates that probe. Focus recovery cannot restore the same attempt. The event signal wakes the hold loop so key-up/release is requested without waiting for the next 25 ms sampling tick.

The existing polling path remains active as fallback coverage for selected-window identity/MainWindowHandle changes that may not emit a foreground transition. Stable-focus acquisition also requires the trusted selected Roblox surface.

If the WinEvent hook cannot be armed, the synthetic probe fails closed rather than silently reducing evidence quality.

## Forensics

Each synthetic attempt logs:

- `SYNTHETIC_CONTINUITY_ARMED` with `foregroundEvents=true` and polling fallback;
- `SYNTHETIC_FOREGROUND_EVENT` when an active hold receives an out-of-surface foreground event;
- `SYNTHETIC_HOLD_CONTINUITY_LOST` with source, first-loss time, target/foreground HWND identity and relation;
- the existing backend-specific key-state and final-verdict records.

A continuity loss prevents that cell from being treated as confirmed Windows-boundary delivery for a conclusive Roblox-consumption failure matrix.

## Safety and ownership

This phase changes diagnostic evidence only. It does not promote or alter `keybd_event`, SendInput, scheduler truth, focus authorization, held-key/pedal ownership, Legacy/Legacy x2 behavior, or normal playback mapping. Loss of trusted Roblox focus still causes held diagnostic input to be released. AI/network remain irrelevant to Runtime Input truth.

## Field gate

CI success is not `FIELD PASS`. Phase 78 only removes a forensic blind spot. A client must still confirm visible movement or the expected piano note inside real Roblox for the tested input path.
