---
schema: 1
version: 0.40.68
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

## Audio-to-Piano OSS Phase 64 — cross-section harmony continuity

- Dense accompaniment can now use recent sparse/dense harmony as a bounded tie-break, reducing avoidable chord-tone or octave jumps when a verse, pre-chorus or outro flows into a denser section.
- Continuity never creates notes and cannot rescue evidence already rejected by adaptive-density or weak-note confidence policy. A prior pitch class is eligible only while its current Basic Pitch activation remains within the configured confidence floor.
- Harmony context expires after a bounded window, so later unrelated sections return to current-section evidence instead of carrying stale chord bias indefinitely.
- Phase 63 bass/root reservation, pitch-class coverage, melody priority, timing/duration, octave/range policy and same-key ownership remain deterministic.
- `HarmonyContinuitySelections` surfaces when recent harmony context changes the pure-confidence survivor set.
- Real-model mixed-instrument stress, generated-MIDI parity and production smoke remain release gates; source separation stays deferred while those measurable quality floors hold.

## OSS / packaging boundary

- Spotify Basic Pitch remains the transcription/model-semantics source. Its documented mixed/polyphonic behavior is handled through deterministic post-processing rather than assuming every simultaneous activation belongs in the Roblox piano voicing.
- Microsoft ONNX Runtime, NAudio and DryWetMIDI boundaries remain unchanged.
- Phase 64 adds no database, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime, and introduces no new third-party license or NOTICE obligation.

## Authority and quality contract

- Harmony continuity only chooses among already-decoded, currently credible Basic Pitch notes under the existing hard density cap; `RobloxPiano.Core.PerformanceTrack` remains canonical playback truth.
- Generated piano targets recognizable melody, useful and stable harmony, original timing/sections and Roblox-playable density; it does not claim waveform-perfect equivalence to a mixed recording.
- Low-confidence/lossy arrangements continue to surface review diagnostics instead of silently claiming high confidence.
- Real-model Basic Pitch mixed-song evidence, generated-MIDI parity, review persistence integrity and production smoke coverage remain gates.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version** and choose owned/local audio you are authorized to use.
2. Transcribe and preview normally. Closely connected sections can now keep credible harmonic continuity instead of switching chord-tone/octave representatives solely on tiny confidence differences.
3. Review any surfaced low-confidence/lossy regions and Apply / Defer / Resume repairs as needed.
4. Add the generated result to **Sheet Library** when satisfied. Roblox playback remains subject to the separate Runtime Input field gate.
