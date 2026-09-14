---
schema: 1
version: 0.40.66
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

## Audio-to-Piano OSS Phase 59 — section-aware quality calibration

- Melody continuity across adjacent onset clusters now has a relative confidence guard: a nearby but materially weaker voice cannot capture the protected melody solely because it is closer in pitch to the previous section.
- The continuity guard remains permissive enough for credible melodic motion and exposes `MelodyContinuityConfidenceRejects` when a nearby credible continuity candidate is rejected by the confidence floor.
- Adaptive accompaniment density is now calibrated against the strongest non-melody accompaniment rather than the protected melody. A dominant vocal/melody activation can no longer raise the relative threshold so high that moderate but coherent harmony is discarded.
- A deterministic full-song section corpus covers sparse verse, arpeggio/transition, dense chorus, dominant-melody harmony and weak mixed-audio clutter. The gate requires complete labeled melody retention, complete labeled strong-harmony retention and complete labeled clutter suppression for the fixture.
- Existing hard density caps, sparse-section no-thinning behavior, octave/range policy, note timing/duration, same-key ownership repair and canonical `PerformanceTrack` output remain deterministic.

## OSS / packaging boundary

- Spotify Basic Pitch remains the transcription/model-semantics source. Its documented mixed/polyphonic limitations are handled with deterministic confidence policy rather than pretending every simultaneous activation is piano truth.
- Microsoft ONNX Runtime, NAudio and DryWetMIDI boundaries remain unchanged.
- Phase 59 adds no database, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime, and introduces no new third-party license or NOTICE obligation.

## Authority and quality contract

- Section-aware confidence calibration only decides which already-decoded notes survive deterministic arrangement; `RobloxPiano.Core.PerformanceTrack` remains canonical playback truth.
- Generated piano targets recognizable melody, useful harmony, original timing/sections and Roblox-playable density; it does not claim waveform-perfect equivalence to a mixed recording.
- Low-confidence/lossy arrangements continue to surface review diagnostics instead of silently claiming high confidence.
- Existing real-model Basic Pitch E2E, generated-MIDI parity, review persistence integrity and production smoke coverage remain gates.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version** and choose owned/local audio you are authorized to use.
2. Transcribe and preview normally. Section transitions now resist weak continuity capture, while dominant melodies no longer starve moderate accompaniment under dense mixed-audio conditions.
3. Review any surfaced low-confidence/lossy regions and Apply / Defer / Resume repairs as needed.
4. Add the generated result to **Sheet Library** when satisfied. Roblox playback remains subject to the separate Runtime Input field gate.
