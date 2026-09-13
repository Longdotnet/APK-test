# ADR 0144: Audio review maintenance destructive revalidation

## Status

Accepted.

## Context

Phase 53 introduced `review-maintenance.json` so unchanged Create Piano Version startup can reuse checkpoint metadata keyed by managed filename, length and UTC last-write time. That identity is intentionally cheap and is safe for acceleration, but it is not content identity: an external tool can rewrite checkpoint bytes while preserving both length and timestamp.

If stale cached metadata were allowed to authorize immutable evidence garbage collection, a checkpoint could begin referencing a different evidence digest without maintenance noticing before deleting that evidence.

## Decision

Keep the cheap manifest identity for non-destructive warm-start acceleration, but require authoritative checkpoint revalidation before any evidence deletion that depends on reused manifest metadata.

Maintenance first performs the normal bounded scan and may reuse stable manifest entries. If that cached snapshot makes one or more evidence files older than the grace window appear collectible, and at least one checkpoint entry was reused, maintenance clears the cached-derived reference/index snapshot and re-parses every bounded `.review.json` checkpoint. Evidence references, ambiguity, manifest contents and lookup-index candidates are then rebuilt from that fresh authoritative snapshot before deletion eligibility is recomputed.

If the bounded scan is truncated or any authoritative checkpoint is ambiguous/unreadable, evidence GC remains disabled fail-safe. Uncertainty is allowed to retain extra evidence; it must never make deletion more aggressive.

## Authority boundary

- Length/mtime manifest identity is acceleration only.
- `review-maintenance.json` and `review-index.json` are disposable caches, not persistence or deletion authority.
- Review checkpoints/evidence remain persistence authority.
- Canonical `PerformanceTrack` remains playback truth.
- Resume Review still full-hashes source audio, verifies immutable evidence, replays explicit decisions deterministically and verifies the rebuilt canonical track fingerprint.

## Regression contract

A checkpoint-tamper fixture must:

1. build manifest metadata from a checkpoint that references evidence A;
2. rewrite checkpoint bytes so the same-length document references evidence B;
3. restore the original checkpoint last-write timestamp;
4. age evidence B beyond the GC grace window;
5. run warm maintenance;
6. prove maintenance re-parses the checkpoint before destructive GC;
7. prove evidence B survives and only truly orphaned evidence A may be collected.

Unchanged warm startup with no destructive candidate must continue to parse zero checkpoint JSON documents.

## OSS / packaging impact

No new dependency is introduced. The implementation uses the existing bounded .NET BCL file/JSON maintenance path. Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio, DryWetMIDI and the deterministic Roblox arranger remain unchanged. No new third-party license or NOTICE obligation is introduced.
