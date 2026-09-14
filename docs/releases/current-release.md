---
schema: 1
version: 0.40.67
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

## Audio-to-Piano OSS Phase 63 — mixed-song chorus harmony retention

- Dense mixed-song clusters now reserve a credible low harmony anchor before filling scarce Roblox chord slots, so bass/root evidence is not discarded solely because an upper artifact has slightly higher Basic Pitch activation.
- Accompaniment selection now prefers pitch-class coverage before redundant octave doubles. When two octave representatives of the same pitch class have close confidence, the lower representative wins, reducing high harmonic/overtone clutter without increasing the hard simultaneous-note cap.
- Melody priority, continuity confidence, adaptive accompaniment confidence thresholds, note timing/duration, octave/range policy and same-key ownership repair remain deterministic.
- `HarmonyVoicingSelections` surfaces when the new voicing policy changes the pure activation-ranked baseline.
- Real-model mixed-instrument stress now requires at least 75% overall recognized-harmony retention, at least 75% chorus recognized-harmony retention, the existing melody floor, and at least 25% clutter suppression. Source separation remains deferred only while those measurable floors hold.

## OSS / packaging boundary

- Spotify Basic Pitch remains the transcription/model-semantics source. Its documented mixed/polyphonic behavior is handled through deterministic post-processing rather than assuming every simultaneous activation belongs in the Roblox piano voicing.
- Microsoft ONNX Runtime, NAudio and DryWetMIDI boundaries remain unchanged.
- Phase 63 adds no database, Python runtime, PyTorch, ffmpeg, Demucs model, new NuGet package or native runtime, and introduces no new third-party license or NOTICE obligation.

## Authority and quality contract

- Harmony voicing only chooses among already-decoded Basic Pitch notes under the existing hard density cap; `RobloxPiano.Core.PerformanceTrack` remains canonical playback truth.
- Generated piano targets recognizable melody, useful harmony, original timing/sections and Roblox-playable density; it does not claim waveform-perfect equivalence to a mixed recording.
- Low-confidence/lossy arrangements continue to surface review diagnostics instead of silently claiming high confidence.
- Real-model Basic Pitch mixed-song evidence, generated-MIDI parity, review persistence integrity and production smoke coverage remain gates.

## Runtime Input P0 boundary retained

- This release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.

## Client procedure

1. Open **Create Piano Version** and choose owned/local audio you are authorized to use.
2. Transcribe and preview normally. Dense chorus sections now prefer chord-tone coverage and credible low harmony over near-confidence octave clutter while preserving melody priority.
3. Review any surfaced low-confidence/lossy regions and Apply / Defer / Resume repairs as needed.
4. Add the generated result to **Sheet Library** when satisfied. Roblox playback remains subject to the separate Runtime Input field gate.
