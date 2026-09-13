---
schema: 1
version: 0.40.64
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

## Audio-to-Piano OSS Phase 57 — full-song melody-priority arrangement

- Dense Basic Pitch onset clusters no longer protect the absolute highest pitch unconditionally. A very weak upper harmonic/competing voice must first pass bounded confidence gates before it can become the protected melody note.
- Melody selection uses both an absolute activation floor and a relative-to-cluster activation floor, then tracks a bounded melodic contour across adjacent clusters.
- Inside the continuity window, a credible near-contour pitch is protected ahead of an unrelated skyline jump; remaining slots still go to the strongest accompaniment candidates.
- New deterministic diagnostics expose weak-skyline rejection and continuity-driven melody selections so review/quality tooling can see when the stronger policy changed the old behavior.
- Regression fixtures protect two full-mixture cases: a weak high overtone above a strong chord, and a 72->74 melodic contour competing against a higher MIDI-84 voice.
- Range folding, note timing/duration, density bounds, duplicate merging, same-key ownership repair and canonical `PerformanceTrack` output remain deterministic.

## OSS / packaging boundary

- Spotify Basic Pitch remains the transcription/model-semantics source; its decoded note activation is used as deterministic evidence rather than treating skyline pitch as truth.
- The design was compared with mature polyphonic melody-extraction practice (including Melodia semantics), but no melody ML runtime or copied upstream implementation is shipped.
- Microsoft ONNX Runtime, NAudio and DryWetMIDI boundaries remain unchanged.
- Phase 57 adds no database, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime, and introduces no new third-party license or NOTICE obligation.

## Authority and quality contract

- The arranger may decide which decoded notes survive density reduction, but `RobloxPiano.Core.PerformanceTrack` remains the canonical playback truth.
- Generated piano targets recognizable melody, useful harmony, original note timing and Roblox-playable density; it does not claim waveform-perfect equivalence to a mixed recording.
- Low-confidence/lossy arrangements continue to surface review diagnostics instead of silently claiming high confidence.
- Existing real-model Basic Pitch E2E, generated-MIDI parity, review persistence integrity and production smoke coverage remain gates.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version** and choose owned/local audio you are authorized to use.
2. Transcribe and preview normally. Dense mixed passages now reject weak skyline artifacts and preserve a credible continuous melody more reliably before Roblox density reduction.
3. Review any surfaced low-confidence/lossy regions and Apply / Defer / Resume repairs as needed.
4. Add the generated result to **Sheet Library** when satisfied. Roblox playback remains subject to the separate Runtime Input field gate.
