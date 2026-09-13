# ADR 0137: Fail-safe review draft storage maintenance

## Status
Accepted

## Context
Phase 46 split mutable review checkpoints from content-addressed immutable evidence. A crash between the evidence write and checkpoint commit can leave an orphan evidence snapshot, and a process crash can leave atomic-write temp artifacts. Review storage therefore needs bounded cleanup without risking active client work.

## Decision
- Production maintenance runs before the Create Piano Version surface opens.
- `.review.json` checkpoints are authoritative recovery metadata and are never deleted by maintenance.
- Evidence GC is permitted only after a complete bounded checkpoint scan with no malformed/unsupported/unreadable checkpoint, no reference to the evidence digest, and a 24-hour orphan grace window.
- If the scan is truncated or ambiguous, evidence GC is skipped fail-safe.
- Managed atomic-write temp artifacts may be deleted after a 6-hour grace window because they are not authoritative destination paths.
- A 512 MiB budget is monitored and reported, but active/recent/ambiguous state is preserved even when it keeps storage above budget.
- Cleanup remains local-only and does not alter canonical `PerformanceTrack`, repair state, Library state, readiness or Runtime Input.

## Consequences
Crash debris and proven orphan evidence are reclaimed without turning storage pressure into implicit review-state loss. A pathological directory containing ambiguous checkpoints can remain above the budget until the client explicitly resolves/discards review work; that is preferred over guessing and deleting evidence still needed for deterministic restore.
