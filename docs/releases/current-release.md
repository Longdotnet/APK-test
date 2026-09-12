---
schema: 1
version: 0.40.49
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; Create Piano Version now supports deterministic A/B repair review for flagged transcription regions before Library commit.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Audio-to-Piano OSS Phase 39b — explicit client repair review

- Flagged Audio-to-Piano regions now expose **Preview Original Region**, deterministic repair selection, **Preview Repair**, **Apply Repair**, and **Revert Repair** directly in the Create Piano Version client.
- Repair preview is side-effect free: listening to Melody Priority or Simplified Harmony never changes the canonical generated `PerformanceTrack`.
- Only **Apply Repair** mutates the current generated performance, through the Phase 39a deterministic repair-session owner. Stale regions and no-op candidates continue to fail closed.
- **Revert Repair** restores the exact original generated performance and re-runs deterministic local review evidence.
- Transcription results retain the deterministic post-suppression Basic Pitch note evidence required for repair. The client does not run Basic Pitch a second time to repair a region.
- Global transcription quality is retained separately from local review-region warnings. After Apply/Revert, readiness is recomputed fail-closed: global `Rejected` stays rejected, global `NeedsReview` stays review-required, and an otherwise `Ready` result becomes `Ready` only when no local review regions remain.
- **Add to Library** writes only the current explicitly accepted canonical track and still performs the production MIDI round-trip parity check before commit.

## Audio validation and OSS boundary

- Existing Phase 38/39a regressions continue to prove deterministic candidate generation, canonical immutability during preview, explicit apply, stale-region rejection, atomic cancellation, and exact revert.
- The real-model Audio-to-Piano gate now also verifies that retained repair evidence exactly matches post-suppression note count and that base/global quality remains free of synthetic local `REVIEW_REGION_` reasons.
- Spotify Basic Pitch, ONNX Runtime, NAudio ingest/preview, deterministic Roblox arranger, and generated MIDI round-trip verification remain the reused production boundaries.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator, or source-separation model is bundled by this phase.

## Runtime Input P0 boundary retained

- This audio release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput, or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Audio repair preview and Library commit do not claim or imply end-to-end Roblox playability.

## Audio client procedure

1. Choose owned/local audio and run **Create Piano Version**.
2. If readiness is `NeedsReview`, select a flagged region with **Previous Review** / **Next Review**.
3. Use **Preview Original Region** to hear the current canonical version locally.
4. Select **MelodyPriority** or **SimplifiedHarmony** and use **Preview Repair** for a side-effect-free A/B comparison.
5. Use **Apply Repair** only when the alternative is preferred. Readiness and remaining review regions are recomputed immediately.
6. Use **Revert Repair** before Library commit whenever the exact original generated performance is preferred.
7. Add to Library only after reviewing the visible warnings; generated MIDI round-trip verification still runs before commit.
8. Roblox playback remains subject to the separate Runtime Input field gate.
