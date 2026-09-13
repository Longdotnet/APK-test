# ADR 0143: Audio review maintenance metadata manifest

## Status

Accepted.

## Context

Phases 49-52 made review-draft lookup bounded and cheap, but `AudioReviewDraftStorageMaintenance` still opened every managed `.review.json` checkpoint on each Create Piano Version startup. That parse was needed to rebuild the disposable lookup index, collect referenced evidence for fail-safe GC, and remember malformed/ambiguous state. On an unchanged draft directory this repeated the same checkpoint JSON reads even though file identity had not changed.

## Decision

Add a bounded, rebuildable `review-maintenance.json` accelerator. For each managed checkpoint it stores only:

- managed draft filename;
- checkpoint length and UTC last-write ticks;
- SHA-256 of normalized source path when known;
- referenced evidence SHA-256 when known;
- an ambiguity bit.

It does not store a raw client source path, Basic Pitch note evidence, repair decisions, quality state, or `PerformanceTrack` data.

During startup maintenance an entry is reusable only when managed filename, length and last-write ticks still match the checkpoint. Stable entries supply the source-path hash, evidence reference and ambiguity state without opening checkpoint JSON. New or changed checkpoint identity forces authoritative parsing and refreshes the manifest entry. Missing, malformed or oversized manifest state is discarded and rebuilt from checkpoints.

Malformed checkpoint ambiguity is cached deliberately: unchanged warm maintenance may avoid reparsing it, but the cached ambiguity continues to disable evidence GC fail-safe. A corrupt accelerator must never make GC more aggressive.

The existing lookup index gains an internal rebuild path that accepts already-computed source-path SHA-256 keys. This avoids persisting raw paths merely to reconstruct an index whose production representation already uses path hashes.

Both manifest and lookup index use canonical bounded JSON, same-directory temp files, flush-to-disk and atomic replacement, and skip committed rewrites when bytes are unchanged. Stale `review-maintenance.json.tmp-*` files use the existing crash-recovery grace.

## Authority boundary

The manifest and lookup index are acceleration only. Checkpoints/evidence remain persistence authority, and canonical `PerformanceTrack` remains playback truth. `Resume Review` still full-hashes owned/local audio, validates immutable evidence, deterministically replays explicit repair decisions, and verifies the rebuilt canonical track fingerprint. File metadata is never used to authorize a resume.

## Regression contract

- Cold maintenance parses a healthy checkpoint once and writes manifest metadata.
- A second unchanged maintenance run parses zero checkpoint JSON documents and reuses the manifest entry.
- Unchanged warm maintenance performs zero committed manifest and lookup-index rewrites.
- Checkpoint file identity change invalidates the cached entry and forces authoritative reparse.
- The manifest must not contain the raw owned/local audio path.
- Cached ambiguity must continue to disable evidence GC.
- Stale manifest temp artifacts are reclaimed under the existing safety grace.

## OSS / packaging impact

No new dependency is introduced. The implementation uses bounded .NET BCL JSON/file/SHA-256 primitives and reuses the existing review-index architecture. Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio, DryWetMIDI and the deterministic Roblox arranger are unchanged. No new third-party license or NOTICE obligation is introduced.
