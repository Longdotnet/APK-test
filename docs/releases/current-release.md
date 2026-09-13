---
schema: 1
version: 0.40.54
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

## Audio-to-Piano OSS Phase 45 — long-song review checkpoint efficiency

- Repeated review checkpoints no longer re-read and SHA-256 the entire source audio when the already-verified file path, length, and last-write timestamp are unchanged.
- The first checkpoint still establishes a full SHA-256 source identity. If file metadata changes during the same review session, the source is fully rehashed before another checkpoint is accepted.
- If changed metadata also reveals changed audio bytes, checkpointing fails closed with regenerate-required guidance instead of persisting review state against a different source.
- A metadata-only change with identical bytes is accepted only after a successful full rehash, then the refreshed identity is cached for later review decisions.
- **Resume Review always performs a full source SHA-256 verification**, even when path/length/timestamp still match the in-memory cache. Deterministic repair replay and canonical track fingerprint verification remain unchanged.
- Stable-source hashing verifies file metadata before and after hashing and retries once if the file changes while being read; an unstable source then fails closed rather than producing an ambiguous identity.

## Audio validation and OSS boundary

- Audio UX regression locks one full hash for the initial checkpoint, zero additional full hashes for unchanged repeated checkpoints, one rehash after metadata change, rejection after real byte changes, and mandatory full rehash on Resume.
- Existing draft/replay regressions continue to protect deterministic repair reconstruction, evidence fingerprints, stale-source rejection, managed-path deletion, queue state, generated MIDI round-trip verification, and real-model Audio-to-Piano E2E.
- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, deterministic Roblox arranger, and generated MIDI verification remain the reused production boundaries.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator, or source-separation model is bundled by this phase, so no new license/NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This audio release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput, or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Faster review persistence does not claim or imply end-to-end Roblox playability.

## Audio client procedure

1. Choose owned/local audio. If a saved checkpoint is found, choose **Resume Review** to continue fingerprint-verified progress or **Create Piano Version** to discard the checkpoint and regenerate.
2. Resume still full-verifies source bytes and reconstructs deterministic review state without rerunning Basic Pitch inference.
3. Use **Preview Original Region** / **Preview Repair** for local A/B listening.
4. Use **Apply Repair** only when the deterministic alternative is preferred. Stable repeated checkpoints reuse the verified source identity instead of rereading the whole audio file.
5. Use **Defer Region** / **Resume Region** for queue navigation; both remain checkpointed without changing readiness by themselves.
6. If the owned/local source changes during review, regenerate rather than attempting to persist stale repair state.
7. Use **Revert Repair** to restore the exact original generated track, reset queue decisions, and discard the saved checkpoint.
8. Before Add to Library, read the final applied/deferred/unresolved summary. A NeedsReview result still requires explicit confirmation.
9. Successful Add to Library removes the local review checkpoint after production MIDI round-trip verification; Roblox playback remains subject to the separate Runtime Input field gate.