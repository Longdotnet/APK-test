# ADR 0139: Rebuildable Audio Review Draft Lookup Index

## Status

Accepted.

## Context

Audio review draft schema v2 stores mutable checkpoints as `<source-sha256>.review.json` and immutable Basic Pitch evidence as content-addressed snapshots. Exact-source lookup is already cheap when the current owned/local audio bytes still match the saved source hash. When the same file path changes bytes in-place, however, the client intentionally still surfaces the older review draft so `RestoreAsync` can issue an explicit stale-source/regenerate verdict. Before this ADR that fallback required opening up to 256 recent review checkpoints and comparing their persisted source paths.

That bounded scan is safe but becomes unnecessary repeated I/O when clients accumulate many long-song review drafts. It also makes a common `choose audio -> check for resumable review` operation scale with the number of checkpoints rather than the selected source.

## Decision

Add a local `review-index.json` accelerator beside managed audio review drafts.

The index:

- maps a SHA-256 of the normalized, case-folded local source path to a managed `<sha256>.review.json` filename;
- never stores the raw client source path;
- never stores Basic Pitch notes, evidence, repair decisions, quality state or a `PerformanceTrack`;
- is bounded to 4096 entries and 1 MiB;
- is written through same-directory temporary-file + flush-to-disk + atomic replace semantics;
- rejects draft paths outside the managed audio-review directory;
- removes stale entries when the referenced managed checkpoint no longer exists;
- is updated after successful checkpoint/restore and cleaned after explicit draft deletion.

`AudioReviewDraftClientSession.FindAsync` consults the index first. Missing, malformed, oversized, stale or unsupported index state is treated as a cache miss. The client then falls back to the existing authoritative `AudioReviewDraftStore.FindForSourceAsync` discovery path and repopulates only the discovered source mapping. This makes repair lazy and fail-safe: index loss can cost one bounded scan but can never lose or invent review state.

## Authority boundary

The lookup index is not playback truth and is not restore evidence. Returning a draft path does not authorize its content.

`AudioReviewDraftStore.RestoreAsync` remains unchanged and must still:

1. full-hash the owned/local source audio;
2. reject changed source bytes;
3. validate immutable content-addressed evidence;
4. deterministically replay explicit repair decisions;
5. require the rebuilt canonical `PerformanceTrack` SHA-256 to match the saved fingerprint.

A corrupt index therefore cannot bypass source identity, evidence, repair replay or canonical playback validation.

## OSS / packaging impact

No new package or runtime is introduced. A database dependency such as SQLite would add packaging, migration and corruption-recovery surface for data that is deliberately disposable. The implementation uses .NET BCL JSON, SHA-256 and atomic file primitives while retaining the existing Spotify Basic Pitch / ONNX Runtime / NAudio audio boundary.

No third-party license or NOTICE obligation changes.

## Consequences

Normal repeat discovery for a previously checkpointed source becomes a direct bounded index lookup instead of a review-checkpoint scan. A missing/corrupt index still works through the existing bounded scan and self-heals the requested mapping. Multiple open client sessions coordinate in-process index writes by managed draft root; cross-process races remain safe at the authoritative layer because atomic index replacement can only lose acceleration entries, never review checkpoints or playback truth.
