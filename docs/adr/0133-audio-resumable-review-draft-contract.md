# ADR 0133: Audio resumable review draft contract

## Status
Accepted

## Context

Phase 43 introduced deterministic multi-region review state, but all repair and queue progress lived only in memory. Closing Create Piano Version midway through a long review discarded explicit repair decisions and deferred-region navigation. Persisting the current repaired `PerformanceTrack` directly would create a second playback truth and could silently restore stale output after source audio, model evidence, or deterministic repair behavior changed.

## Decision

Audio review drafts are local-only checkpoints whose authority is constrained by deterministic replay.

- The draft stores the owned/local source path plus a streamed SHA-256 of the exact source bytes.
- The draft stores immutable post-suppression Basic Pitch note evidence, original canonical `PerformanceTrack`, base quality assessment, queue decisions, selected review-region identity, and the SHA-256 fingerprint of the current canonical repaired track.
- An evidence SHA-256 binds source duration, normalized Basic Pitch note evidence, original canonical track fingerprint, and base quality provenance.
- Restore never trusts a serialized repaired track as playback truth. It creates a fresh `AudioTranscriptionReviewRepairSession`, replays saved explicit Apply decisions in order, and requires the rebuilt `PerformanceTrackFingerprint` to equal the saved current-track fingerprint.
- Source-byte mismatch, evidence mismatch, stale repair-region identity, stale deferred-region identity, malformed revision history, unsupported schema, oversized draft, or replay divergence all fail closed and require regeneration.
- Draft writes use same-directory temporary files, explicit flush, and atomic replacement so an interrupted write cannot expose a partially serialized checkpoint as valid state.
- Draft parsing is bounded to 32 MiB, 250,000 retained Basic Pitch notes, and 500,000 original performance events.

## Architecture boundary

A review draft is recovery evidence, not a second canonical playback model. `AudioTranscriptionReviewRepairSession.CurrentTrack` remains authoritative after deterministic restore, and `PerformanceTrackFingerprint` verifies exact replay parity before restored state is exposed. Queue state remains navigation/audit state only; deferred regions continue to count as unresolved.

The checkpoint does not persist Roblox input authorization, scheduler state, held keys, pedal ownership, focus state, or playback progress. Runtime Input P0 remains outside this subsystem.

## OSS and licensing

This phase reuses the existing Spotify Basic Pitch note-evidence semantics and the repository's existing deterministic arranger/review contracts. It adds no package, model, native binary, Python runtime, PyTorch, ffmpeg, or source-separation dependency, and therefore introduces no new license or NOTICE obligation.

## Consequences

Long review sessions now have a production-grade recovery primitive without trusting stale serialized playback truth. A later client-facing phase can autosave and offer Resume Review using this contract; that UI must still surface restore rejection clearly rather than silently falling back to stale state.
