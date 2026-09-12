# ADR 0112: Control-gated synthetic matrix winners

## Status

Accepted for Runtime Input P0 Phase 87.

## Context

The real-vs-synthetic matrix exists to isolate whether a selected Roblox surface reacts differently to physical W and synthetic W semantics. Prior phases made synthetic evidence exact-probe, provenance-aware, same-integrity, single-assignment, reaction-bound, and same-session.

The assessment policy still evaluated a provenance-clean synthetic `ROBLOX_REACTED` winner before requiring the `REAL_KEY` control to exist and visibly react. That meant a synthetic Yes could produce the conclusive `SYNTHETIC_VARIANT_REACHES_ROBLOX` boundary on a surface for which the physical-W control had not yet proven that W itself had an observable Roblox effect.

This is weaker than the field contract and can promote a false or misattributed winner.

## Decision

A synthetic matrix winner is conclusive only after the same retained matrix contains a trusted `REAL_KEY` baseline with explicit visible Roblox reaction on the same Roblox process lifetime and selected HWND.

Assessment order is therefore:

1. validate session/reaction-context continuity;
2. require `REAL_KEY` evidence;
3. require the physical control to have confirmed Windows delivery and explicit Roblox reaction;
4. only then accept provenance-clean synthetic `ROBLOX_REACTED` cells as `SYNTHETIC_VARIANT_REACHES_ROBLOX`.

A synthetic Yes without a physical control remains `MATRIX_INCOMPLETE`. A synthetic Yes paired with a real-key No remains `REAL_KEY_BASELINE` invalid. A clean synthetic Yes paired with a same-session real-key Yes remains a conclusive synthetic winner.

## Safety and product boundaries

This changes matrix evidence policy only. It does not alter `keybd_event`, SendInput, the production scheduler, focus authorization, held-key/pedal ownership, emergency release, Legacy, or Legacy x2.

The physical control gate does not itself establish `FIELD_CONFIRMED_PASS`. Explicit visible Roblox movement or the expected piano reaction from production `RobloxPiano.exe` remains mandatory.

## Regression contract

Tests must prove all three states:

- clean synthetic Yes without `REAL_KEY` cannot be conclusive;
- clean synthetic Yes with physical-W No cannot be conclusive;
- clean synthetic Yes with same-session physical-W Yes remains conclusive and preserves the exact winning cell.
