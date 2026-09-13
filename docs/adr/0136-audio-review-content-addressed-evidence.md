# ADR 0136: Content-address immutable review evidence

## Status

Accepted.

## Context

Phase 45 removed repeated full reads of unchanged owned/local source audio, but each Apply/Defer/Resume checkpoint still serialized the full immutable Basic Pitch note evidence and original canonical `PerformanceTrack`. On long songs that can turn a small queue decision into a multi-megabyte write and unnecessary SSD churn.

Persistence must remain subordinate to canonical in-memory state. A compact checkpoint must not become a second playback truth, and clients upgrading from the v0.40.54 schema-v1 inline draft format must not lose valid in-progress review work.

## Decision

Audio review persistence uses two artifacts under the managed local review directory.

1. A content-addressed immutable evidence snapshot, named by the deterministic evidence SHA-256, stores source duration, post-suppression Basic Pitch notes, original canonical `PerformanceTrack` and base quality.
2. A source-addressed mutable review checkpoint stores source identity, evidence reference, explicit repair/queue decisions, selected region, saved time and current canonical-track SHA-256.

The immutable snapshot is written atomically once. Repeated checkpoints reuse it and only atomically replace the small mutable review document. Restore full-verifies owned/local source audio, reads and re-hashes the immutable evidence content, constructs a fresh repair session, replays explicit Apply decisions and requires the rebuilt `PerformanceTrack` fingerprint to match the checkpoint.

Schema v2 never embeds immutable note/track/quality payloads. Schema v1 remains accepted as a read-only compatibility form and follows the same evidence fingerprint and deterministic replay checks.

Missing, malformed, oversized or content-divergent evidence fails closed. Cleanup removes a content-addressed snapshot only after its managed checkpoint is deleted and no remaining schema-v2 checkpoint references that evidence hash.

## Performance and packaging

For unchanged evidence, large immutable note/track serialization moves from every Apply/Defer/Resume checkpoint to one atomic snapshot write. Mutable checkpoint cost becomes proportional to review decisions rather than song transcription size.

No inference pass, model, NuGet package, native binary, Python/PyTorch runtime, ffmpeg component or separator is added. Existing Spotify Basic Pitch evidence, ONNX Runtime inference, NAudio ingest/preview and canonical Roblox arranger remain unchanged, so there is no new license or NOTICE obligation.

## Runtime Input boundary

This phase does not modify Roblox target selection, focus guards, input authorization, scheduler behavior, held-key/pedal ownership, `keybd_event`, SendInput or emergency release. Runtime Input remains independently field-gated.