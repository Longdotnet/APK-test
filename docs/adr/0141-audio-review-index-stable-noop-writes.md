# ADR 0141: Stable no-op writes for the review-draft lookup index

## Context

ADR 0140 rebuilds the disposable `review-index.json` accelerator from authoritative review checkpoints during bounded startup maintenance. The rebuild intentionally scans authoritative checkpoints because storage maintenance already needs that bounded pass, but Phase 50 rewrote the index on every unchanged startup. Repeated `Upsert` calls for an already-indexed source also committed a fresh temp file and atomic replace even when the mapping was identical.

That write amplification is unnecessary for a cache and can create avoidable SSD traffic for clients who repeatedly open **Create Piano Version** while reviewing long songs.

## Decision

`AudioReviewDraftLookupIndex` now canonicalizes entries by ordinal source-path hash before serialization and compares the resulting bounded UTF-8 payload with the currently committed index bytes.

- An identical `Upsert` returns without writing.
- An unchanged `ReplaceAll` cold-start rebuild performs zero committed writes.
- A changed, missing or corrupt index still uses the existing temp + flush-to-disk + atomic replace path.
- Stale mappings still self-heal and authoritative checkpoint/evidence files remain the only persistence truth.
- The implementation exposes a test-only committed-write counter so regressions can lock the no-op write budget without treating file timestamps alone as product semantics.

The regression contract requires the first mapping to commit exactly one index write, then identical upsert and full rebuild operations to commit zero additional writes while preserving byte-identical index content. Storage-maintenance regression separately requires a second unchanged startup to preserve both index bytes and last-write time.

## Consequences

The first valid rebuild after a missing/corrupt/non-canonical index may still perform one atomic rewrite. Once canonicalized, unchanged startups stop rewriting the accelerator. Index comparison reads at most the existing 1 MiB bounded cache file and adds no source-audio hashing, model inference, evidence deserialization or canonical `PerformanceTrack` mutation.

This changes no Audio-to-Piano model semantics, review decisions, readiness, library output or Roblox input behavior. The index remains disposable and rebuildable.