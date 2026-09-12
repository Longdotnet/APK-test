# ADR 0121: Audio review regions participate in client readiness

## Status
Accepted

## Context

Phase 35 introduced deterministic five-second review regions that identify local low-activation, low-retention, excessive-density, and excessive-polyphony evidence without changing the canonical `PerformanceTrack`. The production transcription orchestration did not consume that evidence, so a globally `Ready` result could still contain locally suspicious regions and the client had no deterministic timestamps to review.

## Decision

`AudioToPianoTranscriptionService` runs `AudioTranscriptionReviewRegionAnalyzer` after arrangement and global quality evaluation, using the post-suppression Basic Pitch notes as source evidence and the canonical arranged `PerformanceTrack` as the output evidence.

The immutable diagnostics result retains the complete ordered review-region list and the measured review-analysis duration. If one or more local review regions exist, a globally `Ready` quality result is promoted to `NeedsReview`; `Rejected` is never weakened. Timestamped region reasons are appended to the existing quality reasons so the current Create Piano Version UI surfaces concrete ranges without inventing another playback truth.

`AudioToPianoClientJob` also uses the aggregate diagnostics review decision and summarizes up to three flagged ranges in its terminal message. Review evidence never mutates notes, scheduler state, Roblox input state, or library contents.

## Invariants

- `PerformanceTrack` remains authoritative and is never modified by review analysis.
- Review-region ordering and timestamps are deterministic for the same source notes, track, and options.
- Local review evidence may make `Ready` become `NeedsReview`, but it cannot make `Rejected` less severe.
- A client can still preview a review-required result. Adding a `NeedsReview` result continues to require the existing explicit confirmation path.
- Runtime Input, focus authorization, held-key/pedal ownership, Legacy, and Legacy x2 are outside this change.

## Validation

The real pinned Basic Pitch pipeline regression forces a deterministic low-activation review condition and requires: at least one retained review region, aggregate diagnostics requiring review, client-visible readiness no longer being `Ready`, and a timestamped `REVIEW_REGION_...` quality reason. Existing Phase 35 region-level regressions continue to cover clean regions, local loss, low activation, ordering, and silence behavior.

## OSS / licensing

This phase reuses the already-integrated Spotify Basic Pitch model semantics and existing ONNX Runtime/NAudio production path. It adds no dependency, model, copied OSS implementation, or redistribution obligation.