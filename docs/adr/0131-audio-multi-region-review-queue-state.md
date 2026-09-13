# ADR 0131: Multi-region audio review queue state

## Status

Accepted.

## Context

The transcription review flow can surface several deterministic review regions. Candidate quality preview and explicit repair apply/revert are already safe, but a client reviewing a long song still has to remember which flagged regions were intentionally deferred and which were repaired. Recomputed review regions after an Apply can also make a simple positional `region 2/5` cursor misleading.

## Decision

Add a deterministic client review-queue state boundary that is separate from canonical audio state.

- `AudioTranscriptionReviewRepairSession` remains the sole owner of canonical `PerformanceTrack`, repair revision, recomputed quality and current review regions.
- `AudioReviewQueue` owns only review-navigation state: current exact-region deferrals and an append-only applied-decision history for the active generated result.
- Region identity is deterministic from start/end ticks plus normalized reason codes. Reason ordering does not change identity.
- Deferral never changes quality, readiness, `PerformanceTrack`, Library state or playback authorization. Deferred regions remain unresolved review evidence.
- Synchronization prunes deferrals for regions that no longer exist after canonical repair recomputation, while preserving an applied decision audit count.
- A stale region cannot be deferred; the operation fails closed.
- Explicit Revert/reset clears queue decisions because canonical state has returned to the original generated performance.
- The queue can produce a final pre-Library summary containing applied, deferred and unresolved region counts. It must never present a deferred region as repaired or Ready.

## Why this boundary

Keeping review workflow state outside the repair session avoids mixing a client navigation concern with canonical mutation truth. It also allows later UI work to expose `pending / deferred / applied` progress without weakening explicit Apply semantics or creating a second playback state owner.

## OSS impact

None. This slice reuses the existing Basic Pitch evidence, deterministic review-region analyzer, repair session and quality contracts. No third-party implementation, package, model or native binary is added, so existing license/NOTICE obligations are unchanged.

## Follow-up

Wire this queue state into `Create Piano Version` with explicit **Defer Region / Resume Region / Next Pending** controls and a pre-Library summary. That client-facing follow-up must preserve the same canonical boundary and go through SemVer, exact-main production gates and release verification.
