# ADR 0138: Long-song review draft write-amplification budget

## Status
Accepted

## Context
Phase 46 split immutable Basic Pitch evidence from compact mutable review checkpoints, and Phase 47 added fail-safe storage maintenance. That architecture prevents repeated large evidence serialization in production, but without a long-song byte budget a future refactor could accidentally re-embed notes or the original `PerformanceTrack` into every Apply/Defer/Resume checkpoint.

## Decision
- Audio UX regression uses a deterministic long-song fixture with 12,000 Basic Pitch notes and 4,000 canonical performance events.
- The fixture performs an initial checkpoint, one repair when a deterministic candidate is available, and 24 subsequent Defer/Resume checkpoint writes.
- Immutable evidence must be written exactly once and its committed timestamp must remain unchanged across later review decisions.
- Every mutable checkpoint must remain at or below 16 KiB for this bounded fixture and at least 32x smaller than its immutable evidence snapshot.
- The sum of all mutable checkpoint payload bytes in the regression must remain smaller than one immutable snapshot and at least 8x below the equivalent inline-evidence rewrite baseline.
- The metric is committed serialized payload bytes, not filesystem-sector or SSD controller write amplification; it is deterministic across CI and directly protects the application persistence contract.
- No canonical `PerformanceTrack`, readiness, repair authority, Library state, or Runtime Input behavior is changed by this quality gate.

## Consequences
A regression that starts serializing long-song note/track evidence into every review decision fails the Audio UX gate before release. The budget deliberately avoids platform-specific physical I/O counters while still measuring the bytes the application asks persistence to commit. If the review schema legitimately grows later, the budget must be changed explicitly with evidence rather than silently drifting.
