# ADR 0116: Client matrix UI retains attempt history

## Status

Accepted for Runtime Input P0 Phase 89.

## Context

Phase 88 made matrix assessment fail closed when a logical cell already has decision-eligible evidence and a later attempt could rewrite it. The production `RobloxInputCheckDialog` still stored retained matrix state in a dictionary keyed by cell and assigned `_matrixCells[cell] = evidence` before assessment.

That meant the client UI discarded the earlier observation before `RobloxInputMatrixAssessmentPolicy` could inspect it. The Phase 88 policy and regressions were correct in isolation, but the production collection path could still behave as last-write-wins. A No followed by Yes could therefore evade `MATRIX_CELL_REPLAY`; a Yes followed by No could erase the earlier winner; repeated confirmed `REAL_KEY` could rewrite the physical control.

## Decision

The production input-check dialog retains an ordered list of every matrix-cell attempt for the lifetime of that dialog/matrix ID. Every result is appended and the full retained history is passed into `RobloxInputMatrixAssessmentPolicy`.

The existing Phase 88 policy remains authoritative:

- incomplete attempts may be followed by the first Windows-confirmed retry;
- once a cell has decision-eligible evidence, another retained attempt for that cell fails closed as `MATRIX_CELL_REPLAY`;
- closing/reopening the dialog creates a fresh matrix ID and therefore a fresh history.

A regression reflects the actual private retention field type so a future refactor cannot silently restore keyed overwrite semantics without breaking the recovery gate. The regression also keeps incomplete-to-first-confirmed retry valid.

## Safety and product boundaries

This is field-evidence retention only. It does not alter `keybd_event`, SendInput, the PowerShell oracle, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, or Legacy x2.

It cannot produce `FIELD_CONFIRMED_PASS`. Explicit visible Roblox movement or the expected piano reaction caused by production `RobloxPiano.exe` remains required.

## Regression contract

Tests must prove that:

- the production dialog retains a list of attempts instead of a cell-keyed overwrite dictionary;
- synthetic No -> Yes replay remains non-conclusive;
- synthetic Yes -> No replay remains non-conclusive;
- repeated confirmed physical `REAL_KEY` remains non-conclusive;
- incomplete -> first confirmed retry remains valid.
