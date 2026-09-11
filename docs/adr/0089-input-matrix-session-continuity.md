# ADR 0089: Runtime Input matrix session continuity

## Status

Accepted for Runtime Input P0 Phase 73.

## Context

Phase 72 derives a deterministic verdict from one real-key baseline plus four synthetic W probes. The dialog keeps the latest evidence for each cell. That is useful only when every retained cell belongs to the same Roblox process lifetime and selected window.

A Roblox restart, process replacement, or selected HWND change between cells can otherwise combine evidence from two different game clients into one apparently conclusive matrix. A valid real-key reaction from the old process plus synthetic failures from a new process must never produce `REAL_KEY_WORKS_SYNTHETIC_FAILS`.

## Decision

Each matrix-cell result captures a privacy-safe runtime identity immediately when the result is retained:

- Roblox PID;
- process start-time ticks, using the existing `RobloxProcessIdentity` lifetime contract;
- selected Roblox HWND returned by the production process locator.

The capture is correlated to the existing probe ID through an `INPUT_MATRIX_SESSION` forensic line. It contains no keystroke text beyond the already-known W probe and no unrelated process/user data.

Before any cross-cell winner/failure assessment, the matrix policy verifies that every latest retained cell has a session identity and that all identities are equal.

- Missing identity -> `SESSION_CONTINUITY_INVALID`, boundary `MATRIX_SESSION_IDENTITY_UNAVAILABLE`.
- Different PID/start identity or selected HWND -> `SESSION_CONTINUITY_INVALID`, boundary `ROBLOX_SESSION_CHANGED`.
- Session-continuity failures are never conclusive, never authorize playback, and never count as field PASS.
- A retry still replaces stale evidence for the same cell. Once every retained cell belongs to one stable session again, normal Phase 72 assessment resumes.

The safest recovery after a Roblox restart/window replacement is to close and reopen **Roblox Input Check** and rerun the matrix from **Real-Key Baseline**.

## Boundaries

This identity proves only continuity of the observable Roblox process lifetime and selected HWND. It cannot prove an internal Roblox experience/place identifier when Roblox keeps the same process and window across a teleport or server transition. Client instructions therefore still require running all cells without intentionally changing the Roblox experience/session.

This phase does not add or promote an input injection backend. It does not modify scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy playback, or Audio-to-Piano behavior.

## Acceptance

Regression coverage must prove that:

1. one stable identity preserves Phase 72 winner/failure verdicts;
2. same PID with a new process-start identity invalidates the matrix;
3. same process lifetime with a different selected HWND invalidates the matrix;
4. unavailable identity fails closed before a synthetic winner can become conclusive;
5. latest-cell retry semantics can replace stale cross-session evidence;
6. CI success remains insufficient for P0 field PASS without explicit visible Roblox reaction.
