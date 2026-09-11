# ADR 0090: Bind matrix session identity at probe start

## Status

Accepted for Runtime Input P0 Phase 74.

## Context

Phase 73 prevented a matrix from combining cells whose retained Roblox PID/process-start/HWND identities differ. Its first implementation captured that identity when the matrix result was retained, after the input probe had completed and often after Roblox Piano had reactivated its own window to ask the client whether Roblox visibly reacted.

That creates a time-of-check/time-of-use forensic race. If Roblox exits, restarts, changes its selected window, or another Roblox target becomes preferred after the probe but before result retention, the old probe result can be labelled with the newer target identity. Cross-cell continuity must describe the target that the probe actually attempted, not whichever Roblox target is preferred later.

## Decision

Each GUI matrix cell now captures its session identity from the exact `RobloxWindowTarget` selected for that cell **before the probe starts**:

- target PID;
- target process start-time ticks;
- the selected target HWND.

That immutable nullable identity is carried across the asynchronous probe and human-reaction prompt into `RobloxInputMatrixCellEvidence`.

`RobloxInputMatrixCellEvidence` no longer performs a post-hoc `FindPreferred()` capture. Its four-argument compatibility constructor deliberately leaves session identity unavailable; unbound evidence therefore fails closed under the existing `MATRIX_SESSION_IDENTITY_UNAVAILABLE` policy instead of silently attaching itself to a later Roblox target.

Forensics emit `INPUT_MATRIX_SESSION` twice for a retained cell:

1. `stage=PROBE_START`, correlated to the matrix cell and exact selected target before input/observation begins;
2. `stage=RESULT_RETAINED`, correlated to the resulting probe ID while preserving the same immutable identity and `source=PROBE_START`.

No additional keystrokes, process names, user data, secrets, or unrelated window data are logged.

## Safety and ownership

This phase does not add or promote an injection backend. It does not change `keybd_event`, `SendInput`, PowerShell-oracle semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy playback, or Audio-to-Piano behavior.

If the process identity cannot be captured at probe start, the probe may still produce local diagnostic evidence, but that cell cannot participate in a conclusive cross-cell matrix verdict.

## Acceptance

Regression and production gates must prove that:

1. evidence without an explicitly supplied probe-start identity fails closed and cannot become a synthetic winner;
2. stable explicitly supplied identities preserve the Phase 72/73 winner and real-vs-synthetic-failure verdicts;
3. process-lifetime and selected-HWND changes still invalidate cross-cell comparison;
4. retry/latest-cell semantics still replace stale evidence;
5. the Windows client and input ABI continue to build/run cleanly;
6. CI success remains insufficient for `FIELD PASS`; explicit visible Roblox reaction is still required.
