---
schema: 1
version: 0.40.58
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

## Audio-to-Piano OSS Phase 50 — cold-start review index rebuild and crash recovery

- **Create Piano Version** storage maintenance now rebuilds the disposable review lookup index from all valid managed review checkpoints in the same bounded startup scan used for review-storage safety maintenance.
- Existing valid checkpoints therefore repopulate `SHA-256(normalized source path) -> managed draft filename` before the first source is selected, avoiding one fallback checkpoint scan per source after upgrades or index loss.
- When more than one checkpoint references the same normalized source path, the rebuild deterministically keeps the newest managed checkpoint, matching authoritative fallback discovery preference.
- Crash-left `review-index.json.tmp-*` artifacts are now covered by the existing stale-temp recovery grace and are never treated as authoritative state.
- Truncated directory scans skip full index replacement rather than publishing a knowingly partial index as if it were complete.

## Authority and fail-closed resume contract

- The rebuilt index is still only disposable acceleration state and never playback truth.
- **Resume Review** still full-hashes owned/local audio, rejects changed source bytes, validates content-addressed immutable evidence, deterministically replays explicit repairs, and requires rebuilt canonical `PerformanceTrack` SHA-256 to match the saved fingerprint.
- Malformed checkpoints continue to disable evidence GC fail-safe; they do not authorize index entries or playback state.
- Existing schema-v1 compatibility, compact schema-v2 evidence, checkpoint write-amplification budgets, generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.

## OSS / packaging boundary

- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview and the deterministic Roblox arranger remain the reused production boundaries.
- No SQLite/database package, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime is added by this phase.
- Index rebuild uses .NET BCL JSON, SHA-256 and atomic file primitives because the index remains deliberately disposable/rebuildable acceleration state.
- No new third-party license or NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version**. Bounded storage maintenance cleans stale temp artifacts and rebuilds the review lookup accelerator from valid checkpoints before the form opens.
2. Choose owned/local audio you are authorized to use. Previously saved valid review drafts can now resolve directly even after an index file was lost or corrupted.
3. Choose **Resume Review** only when desired; resume still performs full source/evidence/canonical-state verification before accepting review state.
4. Continue Preview / Apply / Defer / Resume / Add to Library as before. Roblox playback remains subject to the separate Runtime Input field gate.
