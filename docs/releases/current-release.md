---
schema: 1
version: 0.40.56
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

## Audio-to-Piano OSS Phase 47 — review draft storage GC and crash recovery

- Create Piano Version now performs bounded, best-effort maintenance of local review-draft storage before opening the client surface.
- Review checkpoints are never deleted by maintenance. Immutable evidence becomes eligible for cleanup only when every bounded checkpoint is readable, no schema-v2 checkpoint references that evidence digest, and the snapshot has aged past a 24-hour safety window.
- If checkpoint discovery is truncated, malformed, oversized, unsupported or unreadable, evidence GC fails safe and preserves evidence rather than guessing whether it is still active.
- Crash-left `.review.json.tmp-*` / `.evidence.json.tmp-*` artifacts are removed only after a 6-hour grace window; authoritative `.review.json` checkpoints are untouched.
- A 512 MiB managed-storage budget is monitored. If active/recent/ambiguous state remains above the budget, the app logs the condition and preserves that state instead of deleting client review work to satisfy quota.
- Storage maintenance reports deterministic counts/bytes to local diagnostics so support can distinguish reclaimed orphan data from preserved active state.

## Audio validation and OSS boundary

- Audio UX regression locks referenced-evidence preservation, old-orphan cleanup, recent-orphan grace, stale-temp crash recovery and malformed-checkpoint fail-safe behavior.
- Existing schema-v1 compatibility, source-identity checks, immutable evidence fingerprinting, deterministic repair replay, generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.
- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, deterministic Roblox arranger and generated MIDI verification remain the reused production boundaries.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator or source-separation model is bundled by this phase, so no new license/NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This audio release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Review-draft storage maintenance does not claim or imply end-to-end Roblox playability.

## Audio client procedure

1. Open **Create Piano Version**. Local review storage maintenance runs before the form opens; active checkpoints are preserved.
2. Choose owned/local audio. If a saved checkpoint is found, choose **Resume Review** to continue fingerprint-verified progress or **Create Piano Version** to discard the checkpoint and regenerate.
3. Resume full-verifies source bytes, validates content-addressed immutable evidence and reconstructs deterministic review state without rerunning Basic Pitch inference.
4. Use **Preview Original Region** / **Preview Repair** for local A/B listening, and Apply/Defer/Resume explicitly as before.
5. Old unreferenced evidence is reclaimed only after the safety window; recent or ambiguous evidence remains local until a future safe maintenance pass.
6. If diagnostics report storage above budget, client review state is still preserved; finish/discard old reviews normally instead of having maintenance delete them implicitly.
7. Successful Add to Library continues to remove the managed checkpoint after production MIDI round-trip verification. Roblox playback remains subject to the separate Runtime Input field gate.
