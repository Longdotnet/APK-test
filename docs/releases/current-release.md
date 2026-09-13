---
schema: 1
version: 0.40.65
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

## Audio-to-Piano OSS Phase 58 — adaptive full-song density

- Dense mixed-audio clusters no longer fill every available Roblox chord slot with weak accompaniment merely because the hard cap has room.
- Phase-57 confidence-gated melody protection remains authoritative inside the arranger; adaptive density only filters non-melody accompaniment when a cluster already exceeds the configured hard cap.
- Accompaniment must pass conservative absolute and relative Basic Pitch activation floors before consuming a remaining slot. Sparse verse/arpeggio clusters at or below the hard cap are never thinned.
- Strong dense harmony can still fill the configured cap, while weak bleed/harmonic clutter is discarded before canonical `PerformanceTrack` creation.
- `AdaptiveDensityDrops` exposes removals beyond mandatory hard-cap overflow; callers may disable adaptive density for fixed-cap parity/debugging.
- Regression coverage protects sparse-section retention, weak-clutter reduction, strong-harmony retention, disabled-policy parity and invalid-threshold fail-closed behavior.

## OSS / packaging boundary

- Spotify Basic Pitch remains the transcription/model-semantics source; decoded note amplitude in the 0..1 range is reused as bounded deterministic evidence for accompaniment selection.
- Microsoft ONNX Runtime, NAudio and DryWetMIDI boundaries remain unchanged.
- Phase 58 adds no database, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime, and introduces no new third-party license or NOTICE obligation.

## Authority and quality contract

- Adaptive density may decide which already-decoded accompaniment notes survive a dense cluster, but `RobloxPiano.Core.PerformanceTrack` remains canonical playback truth.
- Generated piano targets recognizable melody, useful harmony, original timing and Roblox-playable density; it does not claim waveform-perfect equivalence to a mixed recording.
- Low-confidence/lossy arrangements continue to surface review diagnostics instead of silently claiming high confidence.
- Existing real-model Basic Pitch E2E, generated-MIDI parity, review persistence integrity and production smoke coverage remain gates.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version** and choose owned/local audio you are authorized to use.
2. Transcribe and preview normally. Sparse passages remain intact; dense mixed passages now prioritize the selected melody and strong harmony instead of using weak notes just to fill the chord cap.
3. Review any surfaced low-confidence/lossy regions and Apply / Defer / Resume repairs as needed.
4. Add the generated result to **Sheet Library** when satisfied. Roblox playback remains subject to the separate Runtime Input field gate.
