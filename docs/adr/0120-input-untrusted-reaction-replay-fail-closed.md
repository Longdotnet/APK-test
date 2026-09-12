# ADR 0120: Untrusted reaction history is not retryable

## Status

Accepted for Runtime Input P0 Phase 92.

## Context

Phase 88 made a retained matrix cell single-assignment once it became decision-eligible, while preserving retry for an attempt that never reached the Windows boundary. Phase 86 and later provenance work also require a clean reaction-bound low-level provenance assessment before a synthetic Yes/No can become trusted field evidence.

Those two rules interacted unsafely. `IsUnsafeReplay` used `WindowsBoundaryConfirmed`, which includes the provenance trust gate, to decide whether an older attempt was retryable. An older synthetic attempt could therefore already contain `ROBLOX_REACTED` or `ROBLOX_NO_REACTION`, but if its provenance was missing or contaminated it was treated like an ordinary incomplete attempt. A later clean retry for the same logical cell could then replace it during per-cell collapse.

That lets later evidence erase the fact that a human Roblox reaction verdict had already been attached to an untrusted probe. Missing or contaminated provenance must make that observation unusable, not make it safely rewriteable.

## Decision

Replay eligibility now distinguishes a claimed field reaction verdict from trusted Windows-boundary confirmation.

- `ClaimsWindowsBoundaryVerdict` is true whenever a retained attempt has `ROBLOX_REACTED` or `ROBLOX_NO_REACTION`, independently of provenance trust.
- A repeated logical cell is retryable only when every earlier retained attempt has **not** claimed either field reaction verdict and exactly the latest attempt is the first such verdict.
- An earlier Yes/No with missing provenance cannot be replaced by a later clean Yes/No.
- An earlier Yes/No with contaminated provenance cannot be replaced by a later clean Yes/No.
- A genuine `WINDOWS_BOUNDARY_NOT_CONFIRMED` attempt with stable known Roblox session identity remains retryable once to the first later reaction verdict.
- Unsafe history continues to fail closed as `MATRIX_CELL_REPLAY`; it never creates a synthetic winner or an all-synthetic failure conclusion.

## Safety and product boundaries

This change affects retained field-evidence assessment only. It does not modify `keybd_event`, SendInput, the PowerShell oracle, focus activation, keyboard mapping, scan-code semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, or Legacy x2.

Matrix evidence still does not authorize production playback. `FIELD_CONFIRMED_PASS` remains reserved for explicit client evidence that production `RobloxPiano.exe` caused visible Roblox movement or the expected piano reaction.

## Regression contract

Tests must prove that:

- missing-provenance Yes/No followed by a clean retry fails closed as `MATRIX_CELL_REPLAY`;
- contaminated-provenance Yes/No followed by a clean retry fails closed as `MATRIX_CELL_REPLAY`;
- neither sequence can manufacture a winner or erase a failure;
- same-session `WINDOWS_BOUNDARY_NOT_CONFIRMED` to first clean Yes/No retry still works;
- Phase 91 retained-session identity completeness remains authoritative.
