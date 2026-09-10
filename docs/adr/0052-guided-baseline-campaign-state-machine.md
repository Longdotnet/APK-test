# ADR 0052: Guided Legacy baseline reproduction campaign state machine

## Status
Accepted

## Context

Phase 46 introduced explicit Legacy A/B campaign provenance so Support Center no longer had to infer a deliberate Legacy ↔ Legacy x2 experiment solely from historical adjacency. The campaign snapshot binds a reproduction to one canonical TXT/VPS performance, engine identity, Windows input profile and input-latency compensation.

That provenance alone did not enforce experiment order. A client could start a campaign at 2.00x, run duplicate 1.00x sessions, or continue adding tagged sessions after a valid pair had already been produced. The comparator remained fail-closed when evidence was incompatible, but the campaign UX still allowed ambiguous experiment membership and did not tell the client exactly which controlled step was expected next.

## Decision

An explicit campaign now has a deterministic derived state machine based only on persisted privacy-safe session evidence carrying the same campaign ID:

1. `AwaitLegacy` — no admitted session exists. The only admissible protected start speed is Legacy 1.00x.
2. `AwaitLegacyX2` — one valid Legacy 1.00x session exists and is locked as Step 1 evidence. The only admissible protected start speed is Legacy x2 2.00x.
3. `Completed` — exactly one valid Legacy session followed by one controlled Legacy x2 session exists. The campaign no longer admits additional evidence.
4. `Invalidated` — persisted campaign evidence violates canonical/runtime identity, order, variant, controlled transport equivalence, lifetime, or contains ambiguous extra admitted sessions. The campaign no longer admits additional evidence.

Campaign state is derived from persisted session records rather than becoming playback truth. It does not alter scheduler state, seek state, speed state, Roblox authorization, input dispatch, held-key ownership, pedal ownership, or emergency release-all behavior.

At playback-session creation, campaign membership is fail-closed. The client first validates the immutable campaign snapshot, then reconstructs campaign progress from existing persisted support sessions. If history cannot be read or progress cannot be proven, playback continues with an ordinary unscoped session ID. Diagnostics failure therefore cannot block normal deterministic playback.

Support Center surfaces the current step and exact next action. While a campaign is waiting for Step 1 or Step 2, the Start button is disabled to avoid accidentally replacing an in-progress experiment. Completed or invalid campaigns may be replaced with a new campaign, while Cancel remains available whenever campaign state exists.

## Controlled evidence rules

A campaign can advance only when:

- Step 1 is a protected TXT/VPS Legacy run starting at exactly 1.00x;
- Step 2 is a protected Legacy x2 run starting at exactly 2.00x;
- both sessions match the campaign's canonical performance fingerprint, source type, engine identity, Windows input profile and input-latency compensation;
- both runs retain equivalent seek targets and speed-transition history scaled exactly by 2x under the existing Legacy baseline comparison contract.

A wrong-order, duplicate, changed-condition or ambiguous campaign is never repaired by cherry-picking older evidence. The client starts a fresh campaign instead.

## Consequences

- Explicit reproduction is now a two-step experiment rather than a bag of same-campaign sessions.
- The first accepted Legacy session is stable Step 1 provenance; later duplicate 1.00x attempts do not silently replace it.
- A completed campaign cannot absorb later playback and change its conclusion.
- Campaign evidence remains privacy-safe because state is reconstructed from the existing opaque campaign/session IDs and existing support-safe runtime fields.
- Older unscoped sessions continue to use the strict-adjacency/30-minute compatibility path and are not retroactively promoted into explicit campaigns.
- Legacy and Legacy x2 remain regression/perceptual baselines; guided runtime evidence still cannot auto-promote another playback behavior.

## Validation

The AppRecovery regression corpus covers new-campaign state, Legacy→x2 progression, controlled completion, wrong-order x2, duplicate Legacy Step 2, and changed transport history. Production release gates continue to exercise deterministic core, transport, held-input ownership, importers, Windows client, self-contained publication and published-EXE smoke tests.
