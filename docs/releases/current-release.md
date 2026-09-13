---
schema: 1
version: 0.40.60
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

## Audio-to-Piano OSS Phase 53 — startup maintenance read-I/O separation

- Create Piano Version review-storage maintenance now keeps a bounded, rebuildable `review-maintenance.json` metadata accelerator for stable checkpoint files.
- The manifest stores only managed draft filename, file length/last-write identity, source-path SHA-256, evidence SHA-256 and an ambiguity bit; it never stores raw client audio paths, Basic Pitch notes, repair decisions or canonical `PerformanceTrack` state.
- First/cold maintenance parses authoritative checkpoint JSON and writes the manifest. An unchanged subsequent startup reuses stable metadata without reopening checkpoint JSON and performs zero manifest/index rewrites.
- A changed checkpoint length/timestamp invalidates its cached metadata and forces authoritative reparse. Missing/corrupt/oversized manifest state simply rebuilds from checkpoints.
- Malformed checkpoint ambiguity is preserved in the manifest so warm maintenance may avoid repeated parse while still disabling evidence GC fail-safe.
- Crash-left `review-maintenance.json.tmp-*` artifacts use the existing stale-temp recovery policy.

## Authority and fail-closed resume contract

- The lookup index and maintenance manifest remain disposable acceleration state and never playback truth.
- **Resume Review** still full-hashes owned/local audio, rejects changed source bytes, validates content-addressed immutable evidence, deterministically replays explicit repairs, and requires rebuilt canonical `PerformanceTrack` SHA-256 to match the saved fingerprint.
- Missing/corrupt/stale acceleration state falls back to authoritative bounded checkpoint discovery/maintenance.
- Existing schema-v1 compatibility, compact schema-v2 evidence, checkpoint write/read budgets, generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.

## OSS / packaging boundary

- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, DryWetMIDI verification and the deterministic Roblox arranger remain the reused production boundaries.
- No SQLite/database package, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime is added by this phase.
- The manifest uses bounded .NET BCL JSON/file primitives and SHA-256 only.
- No new third-party license or NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version**. Cold storage maintenance validates checkpoints and builds bounded acceleration metadata; unchanged warm startup reuses it without reopening stable checkpoint JSON.
2. Choose owned/local audio you are authorized to use. Indexed review drafts continue to resolve through the disposable lookup fast path.
3. Choose **Resume Review** only when desired; resume still performs full source/evidence/canonical-state verification before accepting review state.
4. Continue Preview / Apply / Defer / Resume / Add to Library as before. Roblox playback remains subject to the separate Runtime Input field gate.
