# ADR 0117: Retained matrix history preserves Roblox session continuity

## Status

Accepted for Runtime Input P0 Phase 90.

## Context

Phase 89 made the production Roblox Input Check retain ordered attempt history. The assessment policy still collapsed each cell to its latest attempt before session-continuity assessment. That preserved the intended incomplete-to-first-confirmed retry, but it also meant an incomplete attempt captured against an older known Roblox process lifetime or selected HWND could disappear from continuity analysis after a confirmed retry on a new Roblox surface.

A field matrix is meaningful only when its retained evidence belongs to one stable Roblox process/window identity. Crossing a known process/window boundary must not become safe merely because the earlier attempt had not yet reached the Windows delivery boundary.

## Decision

Before per-cell history is collapsed to the latest safe retry, the matrix assessment now checks every retained attempt that has a known probe-bound session identity.

- If retained history contains more than one known Roblox PID/start-time/HWND identity, assessment fails closed with `ROBLOX_SESSION_CHANGED_DURING_MATRIX`.
- An incomplete attempt followed by the first confirmed retry remains valid when all known retained attempts belong to the same Roblox session/window.
- An older incomplete attempt with unavailable identity remains recoverable; final decision-eligible evidence still has to satisfy the existing session-identity and current-reaction-context gates.
- A later retry cannot erase a known Roblox restart or selected-window replacement from matrix history.

The diagnostic `INPUT_MATRIX_HISTORY_SESSION_CHANGED` records the boundary without authorizing playback.

## Safety and product boundaries

This is field-evidence continuity only. It does not alter `keybd_event`, SendInput, the PowerShell oracle, production scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, or Legacy x2.

It cannot produce `FIELD_CONFIRMED_PASS`. Visible Roblox movement or the expected piano reaction caused by the production executable is still required.

## Regression contract

Tests must prove that:

- a known cross-session incomplete-to-confirmed retry fails closed;
- a same-session incomplete-to-confirmed retry remains valid;
- ordinary process/HWND changes still fail closed;
- replay protection, provenance binding, physical-control gating and current reaction-context checks remain authoritative.
