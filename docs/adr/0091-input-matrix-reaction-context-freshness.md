# ADR 0091: Input matrix reaction-context freshness

## Status

Accepted for Runtime Input P0 Phase 75.

## Context

Phase 74 bound every matrix cell to the selected Roblox PID, process-start identity, and HWND **before** the probe began. That closed the post-hoc identity race at result retention, but one attribution gap remained.

The production dialog restores RobloxPiano after a probe and then asks the client whether Roblox visibly reacted. That human Yes/No answer can arrive seconds later. Roblox can restart, replace its selected window, or otherwise lose the probe-bound process/window identity during that interval. Retaining the answer against the old probe identity would make a stale observation eligible for a cross-cell verdict such as `SYNTHETIC_VARIANT_WORKS` or `REAL_KEY_WORKS_SYNTHETIC_FAILS`.

A field reaction is evidence only when the current Roblox identity at matrix assessment still matches the probe-bound matrix identity.

## Decision

Before a non-empty matrix can produce any trusted assessment, `RobloxInputMatrixAssessmentPolicy` re-captures the current preferred Roblox PID/process-start/HWND identity and compares it with the retained probe-bound identity.

The policy fails closed when:

- current Roblox identity cannot be established: `REACTION_CONTEXT_IDENTITY_UNAVAILABLE`;
- current Roblox identity differs from the single retained probe session: `REACTION_CONTEXT_CHANGED`;
- retained cells already contain missing or mixed probe-bound identities: the existing Phase 73/74 continuity verdicts remain authoritative.

The production assessment path logs `INPUT_MATRIX_REACTION_CONTEXT stage=ASSESS_CURRENT` with the current identity or `UNAVAILABLE`. Existing `INPUT_MATRIX_SESSION`, `INPUT_MATRIX`, and `INPUT_MATRIX_SUMMARY` lines retain the matrix/probe correlation and expose the resulting boundary.

The field answer remains diagnostic-only: this change does not authorize playback, does not convert any synthetic result into `FIELD_CONFIRMED_PASS`, and does not change input injection semantics.

## Safety invariants

- No new input backend is introduced.
- Loss of focus and held-key release behavior is unchanged.
- `keybd_event`, PowerShell-oracle, SendInput VK, and SendInput scan semantics are unchanged.
- A stale human reaction cannot become a conclusive cross-session matrix verdict.
- Retry remains valid: once Roblox is stable, rerunning the affected cell replaces stale evidence for that cell.

## Regression contract

AppRecovery regressions must prove that:

1. an otherwise valid synthetic winner is rejected when the current Roblox identity is unavailable;
2. an otherwise valid synthetic winner is rejected when current PID/start/HWND differs from the retained probe session;
3. stable current identity preserves existing conclusive matrix behavior;
4. existing process-restart, HWND-replacement, missing-identity, and latest-retry semantics remain intact.

## Remaining boundary

PID/process-start/HWND continuity cannot prove that Roblox remained in the same internal experience when the process and selected HWND do not change. Explicit client observation is still required for the final Roblox-consumption field gate.
