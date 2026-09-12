# ADR 0114: Matrix-cell replay fails closed

## Status

Accepted for Runtime Input P0 Phase 88.

## Context

Probe-level evidence is already single-assignment while retained, and Phase 86 binds provenance to the exact human reaction. The cross-cell assessment still grouped retained evidence by matrix cell and selected `Last()`. A repeated `SENDINPUT_VK`, `KEYBD_EVENT_SCAN`, `POWERSHELL_ORACLE`, `SENDINPUT_SCAN`, or `REAL_KEY` observation could therefore silently replace an earlier observation for the same logical matrix cell.

That is unsafe for a field boundary decision. A No followed by a Yes could manufacture a synthetic winner, while a Yes followed by a No could erase a winner and contribute toward `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`. Repeating `REAL_KEY` could also rewrite the physical control.

## Decision

A retained field matrix is single-assignment at the logical-cell level as well as the probe level.

Before session continuity, physical-control gating, provenance, winners, or failures are interpreted, assessment scans the retained evidence for duplicate cell names. Any duplicate causes an immediate non-conclusive `MATRIX_CELL_REPLAY` verdict.

The repeated observations remain diagnostic evidence, but none of them is selected as truth by insertion order. The client must start a fresh matrix and rerun from Real-Key Baseline rather than combining repeated attempts for one cell.

A structured `INPUT_MATRIX_CELL_REPLAY` diagnostic records the affected cell names and explicitly states that the evidence does not authorize playback.

## Safety and product boundaries

This changes field-evidence assessment only. It does not alter `keybd_event`, SendInput, PowerShell oracle semantics, the production scheduler, focus authorization, held-key/pedal ownership, emergency release, Legacy, or Legacy x2.

It cannot create `FIELD_CONFIRMED_PASS`. Explicit visible Roblox movement or the expected piano reaction from production `RobloxPiano.exe` remains mandatory.

## Regression contract

Tests must prove that:

- synthetic No followed by Yes for the same cell cannot become a synthetic winner;
- synthetic Yes followed by No cannot erase history or contribute to an all-synthetic-failure conclusion;
- repeated `REAL_KEY` evidence cannot rewrite the physical control;
- repeated-cell assessment remains non-conclusive and identifies the repeated cell.
