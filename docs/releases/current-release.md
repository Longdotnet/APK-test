---
schema: 1
version: 0.40.63
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

## Audio-to-Piano OSS Phase 56 — cross-process review storage lease

- Review checkpoint commits and client draft deletes now take a root-local OS-backed exclusive file lease before mutating managed review storage.
- Destructive evidence GC takes that same lease only when old orphan evidence is actually eligible for deletion; if another client instance owns it, cleanup is deferred and evidence is retained fail-safe.
- After acquiring the lease, maintenance revalidates the Phase-55 exact checkpoint-name/content fingerprint snapshot and holds the lease through every immutable evidence delete.
- The lease is an exclusive `FileStream` handle over a stateless `review-storage.lease` sentinel. Process exit or crash releases ownership automatically through the OS; no PID/timestamp stale-lock protocol is required.
- Async checkpoint writers wait for at most five seconds and remain cancellation-aware. Destructive maintenance waits only 250 ms before deferring cleanup, so another client instance cannot turn background cleanup into a long UI stall.
- Normal warm Create Piano Version startup does not acquire this lease when no destructive evidence candidate exists, preserving the bounded metadata/index fast path from earlier phases.

## Authority and fail-closed resume contract

- `review-storage.lease`, `review-index.json` and `review-maintenance.json` are coordination/acceleration artifacts only; none is playback truth or restore authorization.
- **Resume Review** still full-hashes owned/local audio, rejects changed source bytes, validates content-addressed immutable evidence, deterministically replays explicit repairs, and requires rebuilt canonical `PerformanceTrack` SHA-256 to match the saved fingerprint.
- External tools that ignore the cooperative lease remain protected by exact checkpoint-name/content fingerprint revalidation before destructive evidence deletion.
- Existing schema-v1 compatibility, compact schema-v2 evidence, checkpoint write/read budgets, generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.

## OSS / packaging boundary

- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, DryWetMIDI verification and the deterministic Roblox arranger remain the reused production boundaries.
- Phase 56 uses bounded .NET BCL `FileStream`/file-system primitives and adds no database, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime.
- No new third-party license or NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version** and choose owned/local audio you are authorized to use. Normal warm maintenance remains cheap and does not lock review storage unless destructive cleanup is actually needed.
2. Continue Preview / Apply / Defer / Resume normally. Autosave/checkpoint writes coordinate across multiple app instances; a rare bounded storage-busy condition asks the client to retry instead of racing cleanup.
3. Choose **Resume Review** only when desired; resume still performs full source/evidence/canonical-state verification before accepting review state.
4. Add the generated result to **Sheet Library** when satisfied. Roblox playback remains subject to the separate Runtime Input field gate.
