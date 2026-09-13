---
schema: 1
version: 0.40.53
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; Create Piano Version can now resume fingerprint-verified local review progress for the same owned/local audio.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Audio-to-Piano OSS Phase 44b — client autosave and Resume Review

- Create Piano Version writes a bounded local review checkpoint after a review-capable transcription and after explicit **Apply Repair**, **Defer Region**, or **Resume Region** decisions.
- Reopening/selecting the same owned/local audio surfaces **Resume Review** when managed checkpoint metadata exists.
- Resume does not rerun Basic Pitch and never trusts a serialized repaired track. It rebuilds a fresh deterministic repair session from immutable note evidence plus the original canonical PerformanceTrack, replays explicit repair decisions, and requires the rebuilt current-track SHA-256 to match the saved fingerprint.
- If source audio bytes changed in place, the stale checkpoint may still be discovered only so restore can explicitly fail closed with a regenerate-required message. Stale state is never applied silently.
- Successful Add to Library, explicit Revert Repair, or choosing regeneration discards the associated managed review checkpoint. Draft deletion is constrained to the local review-draft directory.
- Autosave failure never rolls back or silently changes the authoritative in-memory canonical PerformanceTrack.

## Audio validation and OSS boundary

- Audio UX regression locks exact-source discovery, deterministic restore/replay fingerprints, recovered immutable checkpoint context, changed-source stale discovery plus fail-closed restore, managed-path deletion boundaries, and explicit cleanup.
- Existing repair/queue/quality regressions continue to protect immutable preview, deterministic candidate generation/ranking, repair-aware global quality, stale-region rejection, cancellation atomicity, Apply/Revert ownership, deferred-region semantics, generated MIDI round-trip verification, and real-model Audio-to-Piano E2E.
- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, deterministic Roblox arranger, and generated MIDI verification remain the reused production boundaries.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator, or source-separation model is bundled by this phase, so no new license/NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This audio release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput, or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Audio review resume, repair quality, and Library commit do not claim or imply end-to-end Roblox playability.

## Audio client procedure

1. Choose owned/local audio. If a saved checkpoint is found, choose **Resume Review** to continue fingerprint-verified progress or **Create Piano Version** to discard the checkpoint and regenerate.
2. Resume reconstructs deterministic review state without rerunning transcription inference. If the source changed or replay diverges, regenerate instead of accepting stale state.
3. Use **Preview Original Region** / **Preview Repair** for local A/B listening.
4. Use **Apply Repair** only when the deterministic alternative is preferred. Apply is the repair mutation boundary and is checkpointed after success.
5. Use **Defer Region** / **Resume Region** for queue navigation; both are checkpointed but do not improve readiness by themselves.
6. Use **Next Pending** to navigate without mutating canonical playback truth.
7. Use **Revert Repair** to restore the exact original generated track, reset queue decisions, and discard the saved checkpoint.
8. Before Add to Library, read the final applied/deferred/unresolved summary. A NeedsReview result still requires explicit confirmation.
9. Successful Add to Library removes the local review checkpoint after production MIDI round-trip verification; Roblox playback remains subject to the separate Runtime Input field gate.
