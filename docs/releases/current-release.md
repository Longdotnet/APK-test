---
schema: 1
version: 0.40.52
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; Create Piano Version now provides a deterministic multi-region review queue for generated audio.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Audio-to-Piano OSS Phase 43b — multi-region review queue client UX

- Create Piano Version now exposes **Defer Region**, **Resume Region**, and **Next Pending** controls when multiple low-confidence regions require review.
- Queue progress is shown as pending, deferred, and applied repair-decision counts. Deferred regions remain unresolved evidence and never improve readiness by themselves.
- Applying a deterministic repair records an audit decision, recomputes canonical review regions, prunes stale queue state, and advances to the next pending region when one remains.
- Revert Repair restores the exact original generated PerformanceTrack and resets all queue navigation/audit decisions.
- Before a NeedsReview result is added to Library, the client shows a deterministic final summary containing applied decisions, deferred regions, unresolved regions, and overall readiness.
- Preview Original Region, Preview Repair, Defer, Resume, and Next Pending never mutate canonical playback truth. Explicit **Apply Repair** remains the only repair mutation boundary.

## Audio validation and OSS boundary

- Audio UX regression locks progress wording, deferred-state visibility, applied-decision history, final pre-Library summary, and fail-closed stale selection behavior.
- Existing Phase 38–43a regressions continue to protect immutable preview, deterministic candidate generation/ranking, repair-aware global quality, stale-region rejection, cancellation atomicity, Apply/Revert ownership, queue semantics, generated MIDI round-trip verification, and real-model Audio-to-Piano E2E.
- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, deterministic Roblox arranger, and generated MIDI verification remain the reused production boundaries.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator, or source-separation model is bundled by this phase, so no new license/NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This audio release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput, or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Audio review completion, repair quality, and Library commit do not claim or imply end-to-end Roblox playability.

## Audio client procedure

1. Choose owned/local audio and run **Create Piano Version**.
2. If readiness is `NeedsReview`, review the selected flagged region and its deterministic candidate recommendation.
3. Use **Preview Original Region** / **Preview Repair** for local A/B listening.
4. Use **Apply Repair** only when the deterministic alternative is preferred. The queue recomputes from the new canonical track and selects the next pending region when possible.
5. Use **Defer Region** to postpone a region without changing quality/readiness; use **Resume Region** to return it to pending review.
6. Use **Next Pending** to skip already deferred regions while preserving their unresolved status.
7. Use **Revert Repair** to restore the exact original generated track and reset queue decisions.
8. Before Add to Library, read the final applied/deferred/unresolved summary. A NeedsReview result still requires explicit confirmation.
9. Generated MIDI round-trip verification still runs before commit; Roblox playback remains subject to the separate Runtime Input field gate.
