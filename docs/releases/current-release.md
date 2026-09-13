---
schema: 1
version: 0.40.59
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; Create Piano Version keeps fingerprint-verified local review progress for owned/local audio.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Audio-to-Piano OSS Phase 51 — stable no-op review-index writes

- The disposable `review-index.json` accelerator is now serialized canonically by ordinal source-path hash before commit.
- Repeated `Upsert` of an unchanged source-to-draft mapping performs zero committed index rewrites.
- The bounded cold-start `ReplaceAll` rebuild now compares canonical bytes with the existing index and skips the temp-file/flush/atomic-replace path when mappings are unchanged.
- Regression gates require the first mapping to commit exactly once, then require identical upsert and full-rebuild operations to preserve byte-identical index content with no additional committed write.
- Storage-maintenance regression separately requires a second unchanged startup to preserve both index bytes and its last-write time.

## Authority and fail-closed resume contract

- The review index remains disposable acceleration state and never playback truth.
- **Resume Review** still full-hashes owned/local audio, rejects changed source bytes, validates content-addressed immutable evidence, deterministically replays explicit repairs, and requires rebuilt canonical `PerformanceTrack` SHA-256 to match the saved fingerprint.
- Missing/corrupt/stale index state still falls back to authoritative bounded draft discovery and self-heals only acceleration metadata.
- Existing schema-v1 compatibility, compact schema-v2 evidence, checkpoint write-amplification budgets, generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.

## OSS / packaging boundary

- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview and the deterministic Roblox arranger remain the reused production boundaries.
- No SQLite/database package, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime is added by this phase.
- Stable index comparison uses bounded .NET BCL JSON/file primitives only; the cache remains capped at 1 MiB and 4096 entries.
- No new third-party license or NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version**. Bounded storage maintenance performs its safety scan and refreshes the review lookup accelerator only if its canonical mapping set changed.
2. Choose owned/local audio you are authorized to use. Indexed review drafts continue to resolve without parsing checkpoint content on the lookup fast path.
3. Choose **Resume Review** only when desired; resume still performs full source/evidence/canonical-state verification before accepting review state.
4. Continue Preview / Apply / Defer / Resume / Add to Library as before. Roblox playback remains subject to the separate Runtime Input field gate.
