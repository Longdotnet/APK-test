# ADR 0135: Cache verified source identity between review checkpoints

## Status

Accepted.

## Context

Phase 44b made Apply/Defer/Resume durable, but every explicit review decision streamed the entire owned/local audio through SHA-256 again. For long songs that disk work is disproportionate because the review mutation changes only canonical repair/queue state, not the source audio.

The optimization must not weaken fail-closed resume. A stale cached hash must never allow changed source bytes to become valid review evidence, and a restored draft must still verify the current source independently before deterministic replay is trusted.

## Decision

`AudioReviewDraftStore` keeps an in-memory verified source identity keyed by normalized path. The identity contains file length, UTC last-write ticks and the SHA-256 that was established by a full read.

- Initial checkpoint performs a full SHA-256 and caches the resulting identity.
- Later checkpoints reuse that SHA-256 only while normalized path, length and last-write timestamp remain unchanged.
- Metadata change forces a full rehash. During an active review session, if the new digest differs from the cached digest, checkpointing fails closed and requires regeneration.
- Metadata-only changes with identical bytes refresh the cache after successful full re-verification.
- Hashing compares length/timestamp before and after the read and retries once when the source moves during hashing. A second unstable observation fails with an I/O error rather than accepting an ambiguous identity.
- Draft discovery may refresh the cache, but draft restore always ignores the shortcut and performs a full SHA-256 before source digest comparison, deterministic repair replay and canonical track fingerprint verification.
- The cache is process-local performance state only. It is not persisted, does not authorize input, and never becomes playback truth.

## Performance and packaging

For an unchanged long-song review session, full source reads drop from one per Apply/Defer/Resume checkpoint to one initial verification plus the mandatory full verification on Resume. Checkpoint JSON serialization and atomic replace remain unchanged and bounded.

No OSS package, native binary, model, Python/PyTorch runtime, ffmpeg component or source-separation dependency is added. Existing Spotify Basic Pitch, ONNX Runtime, NAudio and canonical `PerformanceTrack` boundaries remain unchanged, so there is no new license or NOTICE obligation.

## Runtime Input boundary

This phase does not modify Roblox target selection, focus guards, input authorization, scheduler behavior, held-key/pedal ownership, `keybd_event`, SendInput or emergency release. Runtime Input remains independently field-gated.