---
schema: 1
version: 0.40.55
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

## Audio-to-Piano OSS Phase 46 — compact content-addressed review drafts

- Immutable Basic Pitch note evidence, original canonical `PerformanceTrack`, source duration and base quality now live in a content-addressed evidence snapshot keyed by the deterministic evidence SHA-256.
- Repeated Apply/Defer/Resume checkpoints rewrite only the small mutable document containing source identity, evidence reference, repair/queue decisions, selected region and current canonical-track fingerprint.
- Immutable evidence is written once and reused while its content fingerprint is unchanged; successful final draft cleanup removes an evidence snapshot only when no remaining managed checkpoint references it.
- Resume still full-hashes owned/local source audio, verifies immutable evidence content against its content address, deterministically replays explicit repair decisions and requires the rebuilt canonical track fingerprint to match.
- Existing schema-v1 inline checkpoints from v0.40.54 remain readable so an upgrade does not discard in-progress review work.
- Missing, malformed, oversized or fingerprint-divergent evidence fails closed with regenerate guidance instead of becoming playback truth.

## Audio validation and OSS boundary

- Audio UX regression locks write-once immutable evidence, smaller mutable checkpoints, no evidence rewrite across repeated checkpoints or source metadata-only refresh, missing-evidence fail-closed restore, unreferenced evidence cleanup and schema-v1 restore compatibility.
- Existing source-identity regressions continue to protect cached checkpoint hashing, mandatory full source verification on Resume, stale-source rejection, deterministic repair reconstruction, queue state and canonical fingerprint replay.
- Existing generated-MIDI parity and real-model Audio-to-Piano E2E remain production gates.
- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, deterministic Roblox arranger, and generated MIDI verification remain the reused production boundaries.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator, or source-separation model is bundled by this phase, so no new license/NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This audio release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput, or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Compact review persistence does not claim or imply end-to-end Roblox playability.

## Audio client procedure

1. Choose owned/local audio. If a saved checkpoint is found, choose **Resume Review** to continue fingerprint-verified progress or **Create Piano Version** to discard the checkpoint and regenerate.
2. Resume full-verifies source bytes, validates the content-addressed immutable evidence snapshot and reconstructs deterministic review state without rerunning Basic Pitch inference.
3. Use **Preview Original Region** / **Preview Repair** for local A/B listening.
4. Use **Apply Repair** only when the deterministic alternative is preferred. The mutable checkpoint no longer rewrites the large immutable note/track evidence payload.
5. Use **Defer Region** / **Resume Region** for queue navigation; both remain checkpointed without changing readiness by themselves.
6. If source audio or immutable evidence changes, regenerate rather than accepting stale or divergent review state.
7. Use **Revert Repair** to restore the exact original generated track, reset queue decisions, and discard the saved checkpoint.
8. Before Add to Library, read the final applied/deferred/unresolved summary. A NeedsReview result still requires explicit confirmation.
9. Successful Add to Library removes the managed review checkpoint after production MIDI round-trip verification; unreferenced content-addressed review evidence is cleaned locally. Roblox playback remains subject to the separate Runtime Input field gate.