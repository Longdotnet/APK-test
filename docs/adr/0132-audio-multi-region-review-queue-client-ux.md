# ADR 0132: Audio multi-region review queue client UX

## Status
Accepted

## Context

Phase 43a introduced deterministic review-navigation state for generated Audio-to-Piano output. Create Piano Version still exposed only index-based Previous/Next navigation, so a normal client reviewing several low-confidence regions had to remember which regions were postponed and which had already received an explicit repair decision.

## Decision

Create Piano Version owns an `AudioReviewQueue` alongside the existing authoritative `AudioTranscriptionReviewRepairSession`.

- `Defer Region` records navigation state only. It never changes `PerformanceTrack`, quality, readiness, Library state, or Roblox input.
- `Resume Region` returns the selected deferred region to pending review.
- `Next Pending` skips deferred regions deterministically.
- Explicit Apply remains the only repair mutation boundary. After Apply, canonical review regions are recomputed first, queue state synchronizes/prunes against those regions, and the next pending region is selected when available.
- Revert restores the exact original generated performance through the repair session and resets queue decisions.
- A deferred region remains unresolved and therefore cannot elevate readiness.
- A NeedsReview Library commit shows an explicit final summary of applied repair decisions, deferred regions, unresolved regions, and readiness before the existing confirmation gate.

## OSS and playback boundary

This phase introduces no third-party subsystem. It reuses the existing Spotify Basic Pitch evidence, ONNX Runtime inference, NAudio local preview, deterministic arranger, repair-quality contracts, and canonical `PerformanceTrack` boundary. No library playback engine owns Roblox playback truth.

No Python, PyTorch, ffmpeg, Demucs runtime/model, or new native dependency is added. No new license or NOTICE obligation is introduced.

Runtime Input P0 is untouched and remains independently gated by field evidence.

## Consequences

Multi-region review becomes resumable and explicit without creating a second source of truth. Queue state can be discarded safely because all canonical performance and quality state remains owned by the repair session. Client release changes must still pass exact-head Audio/production gates, expected-head squash merge, exact-main gates, and immutable SemVer release verification.
