# ADR 0145: Audio review race-safe destructive GC

## Status

Accepted.

## Context

Phase 54 prevents cheap `length + mtime` maintenance metadata from authorizing evidence deletion. Before destructive GC, maintenance re-parses bounded authoritative review checkpoints and recomputes the evidence reference set.

A smaller TOCTOU window still remained: another process could create, update or delete a review checkpoint after that authoritative parse but before an immutable `.evidence.json` file was deleted. A new checkpoint could therefore begin referencing evidence that the just-computed snapshot considered orphaned.

## Decision

Keep warm startup cheap and add content-bound validation only on the destructive path.

When evidence is old enough and appears orphaned, maintenance re-parses the complete bounded managed checkpoint set from exact bytes and computes SHA-256 for those same bytes. This produces a destructive checkpoint snapshot keyed by managed checkpoint filename.

Immediately before every evidence deletion, maintenance re-enumerates the managed `.review.json` set and recomputes each checkpoint SHA-256. Deletion proceeds only if:

- the managed checkpoint-name set is identical;
- every checkpoint remains readable and within the bounded size policy;
- every checkpoint fingerprint is identical;
- the bounded file scan remains complete.

Any concurrent create/update/delete, unreadable checkpoint, oversized checkpoint or bounded-scan overflow aborts the remaining GC batch. No authoritative review checkpoint is ever deleted by storage maintenance.

The final revalidation deliberately occurs for each destructive delete. Evidence cleanup is rare and already gated by a 24-hour orphan grace period, so safety is preferred over optimizing this path.

## Race regression

The deterministic regression establishes checkpoint A -> evidence A plus an old orphan evidence B. After maintenance has parsed and fingerprinted checkpoint A but before final destructive revalidation, the fixture rewrites the checkpoint to reference evidence B while preserving both byte length and last-write time.

The raced maintenance pass must:

1. detect the checkpoint content fingerprint change;
2. abort evidence GC;
3. skip publishing stale rebuilt acceleration state;
4. preserve both evidence A and evidence B.

The following stable maintenance pass must retain evidence B and may reclaim evidence A as the now-authoritatively orphaned object.

## Authority boundary

- Content fingerprints are destructive-GC validation only, not playback truth.
- `review-maintenance.json` and `review-index.json` remain disposable caches.
- Review checkpoint/evidence documents remain persistence authority.
- Canonical `PerformanceTrack` remains playback truth.
- Resume Review still full-hashes source audio, validates immutable evidence, replays deterministic repair decisions and verifies the rebuilt canonical track fingerprint.

## Performance and packaging

Warm startup without a destructive candidate performs no new checkpoint hashing. SHA-256 work occurs only when old orphan evidence is about to be deleted.

The implementation uses .NET BCL file, JSON and SHA-256 primitives. No new package, native runtime, model, Python/PyTorch/ffmpeg/Demucs dependency, license or NOTICE obligation is introduced.
