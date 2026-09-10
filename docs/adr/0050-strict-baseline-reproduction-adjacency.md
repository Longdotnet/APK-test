# ADR 0050: Strict protected-baseline reproduction adjacency

- Status: Accepted
- Date: 2026-09-10

## Context

The protected Legacy ↔ Legacy x2 runtime comparison must be conservative enough that support evidence cannot be assembled by cherry-picking unrelated historical sessions.

Phase 44 bounded eligible counterparts to 30 minutes and selected the newest prior baseline after filtering to the same canonical/runtime identity. That removed stale and same-identity fallback, but left one gap: filtering identity before candidate selection could skip an intervening protected baseline for another song or runtime configuration.

For example, `Legacy song A → Legacy song B → Legacy x2 song A` could skip song B and pair the current song-A x2 run with the older song-A Legacy run. Those runs were not adjacent reproduction attempts, so treating them as one experiment overstates what the evidence proves.

## Decision

Protected Legacy reproduction evidence must be adjacent in protected-baseline session history.

For a current session classified as Legacy or Legacy x2:

1. Consider only earlier sessions within the existing 30-minute freshness window that themselves classify as protected Legacy/Legacy x2 baselines.
2. Select the newest such session globally as the sole candidate before applying song/runtime identity filters.
3. Require that candidate to have the same canonical performance fingerprint, source type, playback engine, Windows input profile, and input-latency compensation.
4. Require the opposite protected baseline variant.
5. Require equivalent transport history: identical control ordering and canonical seek positions, with speed values proportional by exactly 2x.
6. Preserve the focus/dispatch/playback interference gate before interpreting runtime quality.
7. If any requirement fails, return `NotComparable` and never search farther back for an older session that happens to fit.

## Consequences

- An intervening protected baseline for another song, engine, input profile, or latency setting intentionally breaks the reproduction sequence.
- Same-variant reruns and transport-history mismatches also break the sequence instead of allowing historical fallback.
- Clients/support get a stronger claim: a reported Legacy ↔ Legacy x2 comparison represents two adjacent protected-baseline attempts under equivalent measured conditions, not merely two compatible historical records.
- Existing 30-minute freshness remains a defensive evidence bound, not a playback timeout.

## Safety and product boundaries

This policy is diagnostics-only. It does not change deterministic playback truth, default Legacy behavior, scheduler timing, input dispatch, Roblox authorization, focus guarding, held-key/pedal ownership, or emergency release-all behavior.

Runtime comparison still cannot replace the protected perceptual/listening baseline and cannot automatically promote Legacy x2 or another playback behavior.

## Regression coverage

The comparison regression corpus now explicitly covers the cross-song adjacency gap: a newer protected baseline for another canonical performance must prevent the current session from pairing with an older same-song baseline. Existing stale, same-variant, transport-mismatch, interference, MIDI exclusion, identity, and proportional-speed cases remain in force.

## Future direction

Strict adjacency is a safe deterministic boundary while the product lacks explicit reproduction provenance. A future guided baseline reproduction workflow should persist an immutable campaign ID plus locked canonical/runtime/settings identity, then pair only sessions from that campaign. That will supersede heuristic historical association without weakening these fail-closed requirements.
