# ADR 0049: Bounded Legacy baseline reproduction pairing

- Status: Accepted
- Date: 2026-09-10

## Context

Phase 43 made Legacy 1x and Legacy x2 runtime evidence comparable only when canonical performance identity, runtime/input identity, latency compensation, source type and proportional transport history agree. That removed most false comparisons, but counterpart selection could still search arbitrarily far back through session history until it found any technically compatible opposite-variant run.

That behavior is unsafe for production diagnosis. A weeks-old or otherwise stale run can have the same persisted identity fields while belonging to a different client circumstance. Worse, if the user just attempted a fresh reproduction but changed seek/speed history, silently skipping that failed attempt and pairing against an older clean run cherry-picks evidence instead of reporting that the new experiment was not controlled.

## Decision

Legacy/Legacy x2 comparison remains diagnostics-only, but counterpart selection is now intentionally bounded and adjacency-oriented.

For a protected baseline session, support first considers only prior protected-baseline sessions that:

1. ended before the current session;
2. ended no more than 30 minutes before the current session; and
3. share immutable campaign identity: canonical performance fingerprint, source type, playback engine, Windows input profile and input-latency compensation.

Among those sessions, the most recent one is the only eligible reproduction counterpart. The comparator does not search farther back when that newest run is unsuitable.

The newest run must then be the opposite protected variant and satisfy the existing complete proportional transport-history contract. If it is the same variant, has different seek targets, has non-proportional speed transitions, or otherwise fails controlled-counterpart validation, the result is `NotComparable` with guidance to run a fresh back-to-back pair.

## Why 30 minutes

The window is long enough for a normal user to complete the same short/medium song at Legacy 1x and Legacy x2, inspect the result, and repeat once if needed. It is intentionally short enough that Support Center will not silently reuse old evidence from a materially different troubleshooting session. This is an evidence-validity bound, not a playback timeout and not an authorization lifetime.

## Fail-closed behavior

The policy must never cherry-pick older evidence to produce a favorable verdict. In particular:

- a stale technically matching session is rejected;
- a newer same-variant run blocks reuse of an older opposite variant;
- a newer opposite variant with mismatched transport history blocks reuse of an older clean counterpart;
- interference handling remains unchanged and still yields `Interfered` when the actual bounded pair contains focus, dispatch or playback failures.

## Boundaries

This phase does not add a campaign identifier, modify playback state, start playback automatically, promote Legacy x2, or replace the protected perceptual/listening baseline. It is a hardening step toward an explicit guided reproduction campaign while keeping deterministic runtime evidence truthful today.

No new support-bundle schema fields are required. The bounded policy uses existing immutable timestamps and already-persisted privacy-safe identity/transport evidence.

## Consequences

- Support evidence now represents a fresh reproduction attempt instead of an arbitrary historical match.
- Failed fresh reproduction attempts stay visible as failures instead of being hidden by older compatible sessions.
- Existing production playback, authorization, focus guard, release-all and canonical timeline behavior are unchanged.
- A future explicit comparison campaign ID can build on this bounded pairing model without weakening current fail-closed behavior.
