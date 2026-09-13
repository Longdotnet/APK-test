# ADR 0134: Audio client review draft autosave and resume

## Status

Accepted.

## Context

Phase 44a introduced a bounded, local-only review draft format whose restore path reconstructs a fresh `AudioTranscriptionReviewRepairSession`, replays explicit repair decisions and verifies the reconstructed canonical `PerformanceTrack` fingerprint. The client still kept all review progress only in memory, so closing `Create Piano Version` could lose applied repair decisions and deferred-region navigation state.

A client-facing resume flow must not weaken the Phase 44a boundary. In particular, a serialized repaired track must never become a second playback authority, stale audio must not be resumed silently, and resuming must not require rerunning Basic Pitch inference.

## Decision

`Create Piano Version` owns a small client persistence coordinator around `AudioReviewDraftStore`.

- A generated review session records its immutable owned/local source path, source duration, retained Basic Pitch note evidence, original canonical `PerformanceTrack`, and base quality assessment as checkpoint context.
- An initial checkpoint is written after a review-capable transcription is created. Subsequent explicit `Apply Repair`, `Defer Region`, and `Resume Region` decisions checkpoint the current queue/revision state atomically.
- `Resume Review` never reruns Basic Pitch. It calls the Phase 44a restore boundary, which hashes the current owned/local source, rebuilds the repair session from immutable evidence, replays explicit repair decisions, and requires the rebuilt current-track SHA-256 to match the saved fingerprint before the client receives the session.
- Draft discovery first uses the exact current source SHA-256. If a user replaced the bytes at the same local path, a bounded scan of managed draft metadata may surface the older checkpoint only so restore can explicitly fail closed with an `audio changed — regenerate required` verdict. The stale checkpoint is never applied.
- Draft deletion is restricted to the managed local draft directory and `*.review.json` files. Regenerate, successful `Add to Library`, and explicit `Revert Repair` discard the relevant saved review checkpoint.
- Autosave errors never roll back or mutate canonical repair state. The client reports the persistence failure and keeps the already-authoritative in-memory `PerformanceTrack` unchanged.
- Checkpoint files are local client recovery state only. They never authorize Roblox input, bypass Library verification, or become playback truth.

## Performance and packaging

No model or inference pass is added. Checkpoint writes serialize bounded deterministic evidence and stream-hash the local source file, using bounded memory. Rehashing on each explicit review decision trades additional local disk reads for a simple fail-closed source-identity guarantee; future optimization may cache a verified source hash only if it preserves equivalent change detection.

The phase adds no NuGet package, native binary, Python/PyTorch runtime, ffmpeg, source-separation model, or redistributed third-party code. Existing Spotify Basic Pitch evidence, ONNX Runtime inference, NAudio ingest/preview, and canonical Roblox arrangement/playback boundaries are unchanged, so there is no new license or NOTICE obligation.

## Runtime Input boundary

This phase does not modify Roblox target selection, focus guards, input authorization, scheduler behavior, held-key/pedal ownership, `keybd_event`, SendInput, or emergency release. Runtime Input remains independently field-gated.
