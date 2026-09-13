---
schema: 1
version: 0.40.57
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Audio-to-Piano OSS Phase 49 — rebuildable review draft lookup index

- **Create Piano Version** now keeps a bounded local lookup accelerator for resumable owned/local audio review drafts instead of repeatedly opening recent checkpoint files for the same source path.
- The index stores only `SHA-256(normalized source path) -> managed draft filename`; it does not persist the raw client audio path, Basic Pitch notes, repair decisions, quality state or a `PerformanceTrack`.
- Missing, corrupt, oversized or stale index state is disposable. Client discovery falls back to the existing authoritative bounded checkpoint scan and repopulates the requested mapping.
- Checkpoint and verified restore refresh the mapping; explicit review-draft deletion removes the corresponding entry.
- The accelerator is bounded to 4096 entries / 1 MiB and uses same-directory temp + flush-to-disk + atomic replacement.

## Authority and fail-closed resume contract

- The lookup index is never playback truth and never authorizes a draft's contents.
- **Resume Review** still full-hashes the owned/local audio, rejects changed source bytes, validates content-addressed immutable evidence, deterministically replays explicit repairs, and requires the rebuilt canonical `PerformanceTrack` SHA-256 to match the saved fingerprint.
- A stale/corrupt lookup entry can therefore cause at most a failed resume or fallback discovery; it cannot silently mutate or authorize playback state.
- Existing schema-v1 compatibility, compact schema-v2 evidence, checkpoint write-amplification budgets, storage GC/crash recovery, generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.

## OSS / packaging boundary

- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview and the deterministic Roblox arranger remain the reused production boundaries.
- No SQLite/database package, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime is added by this phase.
- The index uses .NET BCL JSON, SHA-256 and atomic file primitives because the index is deliberately disposable/rebuildable acceleration state.
- No new third-party license or NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version** and choose owned/local audio you are authorized to use.
2. If a review checkpoint was already indexed, resumable-review discovery avoids the previous recent-checkpoint scan.
3. If the index is absent or damaged, discovery falls back safely and repairs that source's lookup mapping.
4. Choose **Resume Review** only when desired; resume still performs the full deterministic source/evidence/canonical-state verification before any review state is accepted.
5. Continue Preview / Apply / Defer / Resume / Add to Library as before. Roblox playback remains subject to the separate Runtime Input field gate.
