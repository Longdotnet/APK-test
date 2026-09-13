# ADR 0140: Cold-start rebuild for the Audio review lookup index

## Status

Accepted.

## Context

Phase 49 introduced `review-index.json` as a disposable accelerator from normalized source-path SHA-256 to managed review checkpoint filename. A missing or corrupt index remained safe because per-source discovery could fall back to bounded checkpoint scanning, but after an upgrade or index loss the first lookup for each source could still pay that scan cost independently.

Phase 47 already performs one bounded startup scan over review persistence for crash recovery and evidence GC. That scan already opens authoritative checkpoint JSON, so rebuilding the disposable lookup accelerator from the same pass avoids repeated cold-start discovery I/O without adding a second storage walk.

## Decision

During Audio review storage maintenance:

- collect source paths only from readable managed `<sha256>.review.json` checkpoints;
- after a complete bounded scan, atomically replace `review-index.json` with mappings derived from those checkpoints;
- if multiple checkpoints refer to the same normalized source path, prefer the newest checkpoint by file last-write time with deterministic filename tie-breaking;
- if the managed-directory scan is truncated, skip full index replacement rather than publish a knowingly partial rebuild;
- malformed checkpoints remain excluded from index authority and continue to make evidence GC fail safe;
- include stale `review-index.json.tmp-*` files in the existing crash-temp cleanup policy;
- keep the index bounded to the Phase 49 limits and use the same atomic write contract.

## Authority boundary

The rebuilt index is still cache only. It does not validate or authorize a review draft. `AudioReviewDraftStore.RestoreAsync` remains authoritative and must full-hash source audio, validate immutable evidence, deterministically replay explicit repair decisions, and match the rebuilt canonical `PerformanceTrack` fingerprint.

Deleting, corrupting or rebuilding the index therefore changes lookup cost only, not playback truth.

## OSS / packaging impact

No new dependency is introduced. The implementation reuses existing .NET BCL JSON/file/SHA-256 primitives and the Phase 49 index. Spotify Basic Pitch, ONNX Runtime, NAudio and the deterministic Roblox arranger remain unchanged.

No third-party license or NOTICE obligation changes.

## Consequences

Cold-start discovery after upgrades or index loss becomes one bounded rebuild instead of potentially one bounded checkpoint scan per selected source. Startup maintenance does slightly more CPU work to hash normalized source-path strings and atomically write the small index, but it performs no audio hashing, model inference, evidence deserialization, or canonical track mutation.
