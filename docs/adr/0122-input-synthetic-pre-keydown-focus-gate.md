# ADR 0122: Synthetic probes fail closed at the pre-keydown focus boundary

## Status

Accepted for Runtime Input P0 Phase 93.

## Context

Explicit synthetic probes already arm an event-driven foreground hook before injection and retain a polling fallback while the key is held. However, the WinEvent callback intentionally ignores foreground changes while `holdActive` is false.

That left a narrow but important safety gap: after the earlier stable-focus check and after the WinEvent hook was armed, Roblox could lose the selected foreground surface before `BeginHold`. The foreground event could therefore be observed while the hold was not active and be ignored. `BeginHold` previously set only the timestamp/active flag, so native KeyDown could then run once against a no-longer-trusted foreground before the first polling sample invalidated continuity.

For a field probe this is both a safety defect and a forensic defect. A probe intended to compare Roblox input semantics must not inject one diagnostic W into some other foreground surface, and downstream evidence must distinguish “aborted before down” from “focus lost after down.”

## Decision

`RobloxSyntheticProbeForegroundContinuity.BeginHold` now performs an atomic pre-keydown gate under the continuity state lock.

- Re-capture `WindowsRobloxWindowIdentity` immediately before hold activation.
- Re-read `target.IsForeground` at the same boundary.
- Permit the hold only when continuity is still preserved, the selected Roblox surface is trusted, and that target is foreground.
- Otherwise mark continuity terminal, signal the loss task, log `SYNTHETIC_PRE_KEYDOWN_GATE` with `FOCUS_LOST_BEFORE_DOWN` / `ABORT_BEFORE_DOWN`, and throw before the caller can invoke native KeyDown.
- After a successful gate, the existing WinEvent hook and polling fallback retain ownership of continuity during the hold.

The pure `CanBeginHold` predicate is regression tested for trusted foreground, untrusted same-process surface, foreground loss, and already-invalid continuity.

## Safety and product boundaries

This change does not alter key mapping, scan-code semantics, `keybd_event`, SendInput payloads, the PowerShell-oracle mapping contract, production scheduler truth, playback authorization, held-key/pedal ownership, emergency release, Legacy, or Legacy x2.

It adds no security bypass. It makes the explicit field probes more conservative: when the intended Roblox surface cannot be proven at the last safe point before injection, no synthetic KeyDown is sent.

This phase does not establish `FIELD_CONFIRMED_PASS`. The final Windows synthetic input -> Roblox consumption boundary remains unproven until a client visibly observes production `RobloxPiano.exe` moving Roblox or producing the expected piano note.
