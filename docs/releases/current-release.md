---
schema: 1
version: 0.40.62
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

## Audio-to-Piano OSS Phase 55 — race-safe destructive GC snapshot

- Normal warm Create Piano Version startup still reuses bounded maintenance metadata and does not hash checkpoint contents when no destructive evidence cleanup is possible.
- When old orphan evidence is actually eligible for deletion, maintenance now rebuilds authoritative checkpoint metadata from the exact checkpoint bytes and records SHA-256 fingerprints for the complete bounded managed checkpoint set.
- Immediately before every immutable evidence deletion, the managed checkpoint-name set and checkpoint content fingerprints are re-read and compared with the authoritative destructive snapshot.
- Any concurrent checkpoint create, update, delete, unreadable file, oversized file or bounded-scan overflow aborts the destructive GC batch fail-safe; uncertain evidence is retained rather than guessed away.
- A deterministic regression mutates a same-length checkpoint in the destructive race window, restores its original timestamp, and proves both evidence objects survive that raced pass; the next stable pass then reclaims only the truly orphaned evidence.

## Authority and fail-closed resume contract

- `review-index.json` and `review-maintenance.json` remain disposable acceleration state and never playback truth or deletion authority.
- Destructive maintenance fingerprints protect evidence cleanup only; they do not replace review checkpoint/evidence validation or canonical `PerformanceTrack` state.
- **Resume Review** still full-hashes owned/local audio, rejects changed source bytes, validates content-addressed immutable evidence, deterministically replays explicit repairs, and requires rebuilt canonical `PerformanceTrack` SHA-256 to match the saved fingerprint.
- Existing schema-v1 compatibility, compact schema-v2 evidence, checkpoint write/read budgets, generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.

## OSS / packaging boundary

- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, DryWetMIDI verification and the deterministic Roblox arranger remain the reused production boundaries.
- Phase 55 uses bounded .NET BCL file/JSON/SHA-256 primitives and adds no database, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime.
- No new third-party license or NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version**. Normal warm maintenance stays cheap; destructive evidence cleanup now double-validates checkpoint bytes immediately before deletion.
2. Choose owned/local audio you are authorized to use. Indexed review drafts continue to resolve through the disposable lookup fast path.
3. Choose **Resume Review** only when desired; resume still performs full source/evidence/canonical-state verification before accepting review state.
4. Continue Preview / Apply / Defer / Resume / Add to Library as before. Roblox playback remains subject to the separate Runtime Input field gate.
