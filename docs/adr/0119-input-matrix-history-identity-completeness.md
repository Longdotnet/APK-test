# ADR 0119: Retained matrix history requires complete Roblox session identity

## Status

Accepted for Runtime Input P0 Phase 91.

## Context

Phase 90 made retained matrix history fail closed when known PID/start-time/HWND identities crossed Roblox process or selected-window boundaries. It intentionally allowed an older incomplete attempt whose session identity was unavailable to be retried.

That recovery rule leaves a false-positive path: if the older attempt has `SessionIdentity=null`, a later confirmed retry for the same cell can become the latest cell value. Per-cell collapse then hides the earlier unattributable attempt from the existing current-cell session check. A synthetic reaction could therefore contribute to a winner even though the retained history contains an observation that cannot be bound to any Roblox process/window identity.

Unknown identity is not evidence that the session stayed stable. At the P0 field boundary it must not be treated as equivalent to same-session continuity.

## Decision

Before retained history is collapsed to the latest safe per-cell retry, assessment now requires every retained attempt to have a probe-bound Roblox PID/start-time/HWND identity.

- If any retained attempt has unavailable session identity, assessment fails closed with `MATRIX_HISTORY_SESSION_IDENTITY_UNAVAILABLE`.
- `INPUT_MATRIX_HISTORY_SESSION_IDENTITY_UNAVAILABLE` logs the affected cell names with `evidenceTrusted=false` and `authorizesPlayback=false`.
- A later retry cannot rehabilitate an earlier retained attempt whose target identity was unknown.
- Incomplete-to-first-confirmed retry remains valid when every retained attempt has a known identity and all identities belong to the same Roblox process/window.
- Known cross-session history continues to fail closed with `ROBLOX_SESSION_CHANGED_DURING_MATRIX`.

## Safety and product boundaries

This change affects field-evidence assessment only. It does not modify `keybd_event`, SendInput, the PowerShell oracle, focus activation, keyboard mapping, scan-code semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, or Legacy x2.

Matrix evidence still never authorizes production playback. `FIELD_CONFIRMED_PASS` remains reserved for explicit client evidence that production `RobloxPiano.exe` caused the expected visible Roblox movement or piano reaction.

## Regression contract

Tests must prove that:

- an incomplete attempt with unavailable session identity followed by a clean confirmed retry fails closed;
- the later confirmed retry cannot become a synthetic winner;
- same-session incomplete-to-first-confirmed retry remains valid;
- decision-eligible replay protection remains authoritative;
- known process/HWND changes continue to fail closed.
