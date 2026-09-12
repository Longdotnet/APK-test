# ADR 0092: Real-key hold continuity

## Status

Accepted.

## Context

The real-vs-synthetic P0 matrix uses a human physical W press as its control. Before this change, the low-level keyboard baseline required the selected Roblox surface to be trusted at W-down and again at W-up, but did not observe the interval between those endpoints. A client could press W on Roblox, temporarily lose focus or move to another same-process surface, return to Roblox, then release W. Both endpoints could look valid even though the physical hold was not continuously attributable to one selected Roblox surface.

That can contaminate the strongest negative matrix verdict: `REAL_KEY_WORKS_SYNTHETIC_FAILS` must compare a genuinely trusted real-key control against synthetic attempts, not two trusted endpoint snapshots separated by an unknown interval.

## Decision

After the first accepted non-injected W-down, the real-key baseline samples the selected Roblox foreground/window identity every 25 ms until W-up or timeout.

The hold starts trusted only when the first accepted down occurs on the selected trusted Roblox window/tree. Once any sample observes focus/window trust loss, `HoldContinuityPreserved` becomes false for the remainder of that attempt. Returning to Roblox cannot restore trust. Key auto-repeat cannot re-arm or reset the decision.

The baseline result is valid only when all existing conditions are true and the hold continuity remained trusted from down through up.

Diagnostics emit the first observed loss as `REAL_KEY_HOLD_CONTINUITY_LOST` with `REAL_KEY_HOLD_NOT_CONTINUOUS`, and the final real-key verdict includes the continuity flag and first-loss elapsed time.

## Consequences

- A real-key control used by the P0 matrix now has continuity semantics comparable to the synthetic probes rather than endpoint-only semantics.
- A focus/window interruption between W-down and W-up fails closed even if the client returns to the same Roblox surface before releasing W.
- The 25 ms sampling cadence intentionally matches the existing synthetic probe continuity cadence. Extremely brief interruptions below the sampling interval may remain unobserved; endpoint window-identity checks still apply.
- No synthetic input backend, production playback mapping, scheduler, held-key ownership, or authorization behavior changes.
- This change improves evidence quality only. It is not field evidence that Roblox consumes synthetic input and cannot produce `FIELD_CONFIRMED_PASS` by itself.
