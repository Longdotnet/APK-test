---
schema: 1
version: 0.40.51
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; Create Piano Version now shows deterministic repair-candidate quality evidence before Apply.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Audio-to-Piano OSS Phase 42b — client candidate quality preview

- When a generated piano version contains a flagged review region, Create Piano Version now surfaces a bounded deterministic recommendation for the next region before the client applies anything.
- The recommendation compares the available Melody Priority and Simplified Harmony candidates using the authoritative Phase 42 candidate-quality contract.
- The client shows predicted readiness, event density, note retention, transform loss, reasons resolved/introduced, whether the selected region would be cleared, and how many review regions would remain.
- The recommended candidate is presentation-only. It never changes the ComboBox selection, never calls Apply, never writes to Library, and never schedules Roblox playback.
- Preview Original Region and Preview Repair remain side-effect free; explicit **Apply Repair** remains the only canonical repair mutation boundary.
- Candidate quality is evaluated from retained Basic Pitch note evidence and the current canonical PerformanceTrack. Basic Pitch inference is not repeated just to make a recommendation.

## Audio validation and OSS boundary

- Audio UX regression now locks deterministic candidate recommendation text, recommendation ordering, predicted density/retention evidence, selected-region resolution status, and the explicit-Apply wording.
- Existing Phase 38–42 regressions continue to protect immutable preview, deterministic candidate generation/ranking, repair-aware global quality, stale-region rejection, cancellation atomicity, Apply/Revert state ownership, generated MIDI round-trip verification, and real-model Audio-to-Piano E2E.
- Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio ingest/preview, deterministic Roblox arranger, and generated MIDI verification remain the reused production boundaries.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator, or source-separation model is bundled by this phase, so no new license/NOTICE obligation is introduced.

## Runtime Input P0 boundary retained

- This audio release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput, or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Audio quality improvement, candidate recommendation, repair preview, and Library commit do not claim or imply end-to-end Roblox playability.

## Audio client procedure

1. Choose owned/local audio and run **Create Piano Version**.
2. If readiness is `NeedsReview`, read the visible candidate recommendation for the next flagged region.
3. Compare predicted density, retention, loss, readiness, resolved/introduced warnings, and remaining-region count for the available deterministic repair candidates.
4. Use **Preview Original Region** and **Preview Repair** for local A/B listening. Recommendation does not auto-select or auto-apply anything.
5. Use **Apply Repair** only when the deterministic alternative is preferred.
6. Continue reviewing while local regions remain; the next bounded recommendation is recalculated from the current canonical repair-session state.
7. Use **Revert Repair** before Library commit whenever the exact original generated performance is preferred.
8. Add to Library only after reviewing the visible warnings; generated MIDI round-trip verification still runs before commit.
9. Roblox playback remains subject to the separate Runtime Input field gate.
