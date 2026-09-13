---
schema: 1
version: 0.40.61
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

## Audio-to-Piano OSS Phase 54 — fail-safe maintenance change detection

- Warm Create Piano Version startup still reuses bounded `review-maintenance.json` metadata when checkpoint length/last-write identity is unchanged.
- Cheap file metadata is now explicitly non-destructive: it may accelerate index/maintenance reads, but it can no longer by itself authorize immutable evidence deletion.
- If cached metadata makes any old evidence file appear collectible, maintenance first re-parses every bounded authoritative `.review.json` checkpoint and recomputes evidence references, ambiguity and lookup-index metadata from that fresh snapshot.
- A regression fixture rewrites checkpoint bytes while preserving both file length and last-write time, changes the referenced evidence digest, and requires the newly referenced evidence to survive while only the truly orphaned evidence may be collected.
- Unchanged warm startup with no destructive GC candidate still performs zero checkpoint parses and preserves the Phase 53 read-I/O win.

## Authority and fail-closed resume contract

- The lookup index and maintenance manifest remain disposable acceleration state and never playback truth or deletion authority.
- **Resume Review** still full-hashes owned/local audio, rejects changed source bytes, validates content-addressed immutable evidence, deterministically replays explicit repairs, and requires rebuilt canonical `PerformanceTrack` SHA-256 to match the saved fingerprint.
- Missing/corrupt/stale/ambiguous acceleration state falls back to authoritative bounded checkpoint discovery/maintenance; uncertainty can retain extra evidence but must not delete evidence that may still be referenced.
- Existing schema-v1 compatibility, compact schema-v2 evidence, checkpoint write/read budgets, generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.

## OSS / packaging boundary

- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, DryWetMIDI verification and the deterministic Roblox arranger remain the reused production boundaries.
- No SQLite/database package, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime is added by this phase.
- The change uses bounded .NET BCL JSON/file primitives only and introduces no new third-party license or NOTICE obligation.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version**. Unchanged warm maintenance stays cheap; destructive evidence cleanup performs an authoritative checkpoint revalidation first whenever cached metadata alone would make deletion possible.
2. Choose owned/local audio you are authorized to use. Indexed review drafts continue to resolve through the disposable lookup fast path.
3. Choose **Resume Review** only when desired; resume still performs full source/evidence/canonical-state verification before accepting review state.
4. Continue Preview / Apply / Defer / Resume / Add to Library as before. Roblox playback remains subject to the separate Runtime Input field gate.
