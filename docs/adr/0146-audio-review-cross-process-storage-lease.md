# ADR 0146: Cross-process review storage lease

## Status

Accepted for Audio-to-Piano OSS Phase 56.

## Context

Phase 55 binds destructive immutable-evidence GC to exact SHA-256 fingerprints of the complete bounded managed checkpoint set and revalidates those fingerprints immediately before each delete. That protects against external edits and most races, but two cooperating `RobloxPiano.exe` instances could still leave a tiny check-to-delete window: one instance can complete the final fingerprint check while another commits a review checkpoint before the evidence delete.

Review checkpoints and content-addressed evidence are client persistence state only. They must never become playback authority; `PerformanceTrack` remains canonical, and resume must continue to validate source bytes, immutable evidence, deterministic repair replay and canonical-track fingerprint.

## Decision

Use a root-local, OS-backed exclusive file-handle lease for cooperative review-storage mutations and destructive evidence GC.

- The sentinel is `review-storage.lease` in the managed review-draft directory.
- Ownership is an open `FileStream` created with `FileShare.None`. The sentinel contains no lock state and is intentionally left on disk.
- Client checkpoint commit and client draft deletion acquire the writer lease before mutating review storage and hold it through disposable lookup-index maintenance.
- A writer waits for at most five seconds, remains cancellation-aware for async checkpointing, and fails explicitly rather than writing concurrently after the bound expires.
- Maintenance does not take the lease during normal warm scanning. It attempts the lease only when old orphan evidence has already become eligible for destructive cleanup.
- Destructive maintenance waits at most 250 ms. If another client instance owns the lease, GC is deferred fail-safe and evidence is retained.
- After acquiring the lease, GC revalidates the Phase-55 checkpoint content-fingerprint snapshot and holds the lease through every evidence deletion. Fingerprints are still checked immediately before each delete so non-cooperating/external edits remain fail-safe.
- The OS closes the exclusive file handle when a process exits or crashes, so no PID file, timestamp expiry, stale-owner repair or database is required.

## Alternatives considered

### Named system mutex

A named mutex can coordinate processes, but mutex ownership is thread-affine and abandoned ownership has additional recovery semantics. Review checkpointing is asynchronous, so a handle-lifetime file lease is a smaller and clearer fit for this storage-scoped critical section.

### PID/timestamp lock file

Rejected. It would require stale-owner detection and clock/process-liveness policy and would create a second source of truth that can itself become corrupt.

### Database or transaction manager

Rejected. The bounded local files already provide atomic persistence and authoritative content verification. Adding SQLite or another runtime solely for this narrow coordination problem would increase packaging, migration and corruption surface without improving canonical playback truth.

## Failure behavior

Lease contention can only delay/abort a review save or defer cleanup. It cannot authorize restore, change repair decisions, or mutate canonical playback state. If destructive maintenance cannot acquire the lease, cannot revalidate checkpoint fingerprints, encounters unreadable state, or sees a bounded-scan overflow, it retains evidence.

External tools that do not honor `review-storage.lease` are still covered by the existing exact checkpoint-name/content fingerprint revalidation.

## Consequences

The tiny cooperative writer-versus-GC check-to-delete race is removed without adding steady-state startup locking. Destructive cleanup pays a bounded lease acquisition only when evidence is actually eligible for deletion. A stateless zero-byte sentinel remains in the review directory, and multiple client instances may briefly surface a storage-busy retry instead of racing persistence.

No new NuGet package, model, native runtime or third-party license/NOTICE obligation is introduced.
