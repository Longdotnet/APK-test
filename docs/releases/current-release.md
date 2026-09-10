---
schema: 1
version: 0.38.0
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the Sheet Library remains the normal starting point.
2. Open Roblox, select/import a playable song, verify input for the current Roblox process, and keep the target focused while playback is active.
3. Play/Pause/Stop/Seek and speed controls continue to use deterministic transport state; focus loss and cancellation release held keys/pedal state safely.
4. Use Support Center for verified Support Bundle export and Legacy x2 A/B campaign/history diagnostics.

## Production capability and reliability

- The production client remains a self-contained single EXE with no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- Sheet Library remains list-first; Browse/drag-drop are import helpers.
- Legacy and Legacy x2 remain protected regression/perceptual baselines and are not silently replaced or auto-promoted.
- Canonical performance state remains independent from TXT/MIDI/MusicXML/UI/AI/Windows input backends.
- Runtime focus/input authorization, emergency release-all, held-key/pedal ownership, deterministic transport evidence and verified experiment history remain unchanged.
- AI remains optional and is not required for playback/import/validation truth.

## Phase 52 deterministic reference-to-timeline alignment

- Adds dependency-free `ReferenceAudioTimelineAligner` to the deterministic Core evidence layer.
- Aligns analyzed reference-audio onsets with canonical performance event starts at an explicit playback speed without mutating the track.
- Uses a bounded ±2000 ms global-offset search, fixed 10 ms grid and monotonic one-to-one onset matching with a 120 ms tolerance.
- Reports match coverage, recovered recording offset, mean/P95 residual timing error and candidate/reference tempo ratio.
- Binds evidence to exact reference content hash, reference feature hash, canonical performance fingerprint and playback speed, then emits a separate SHA-256 over the normalized alignment evidence.
- Verification fails closed on malformed identity/count/range fields, inconsistent coverage or tampered metrics/evidence hash.
- Regression coverage proves deterministic evidence, known-offset recovery without timeline mutation, speed-sensitive comparison and tamper rejection.
- ADR 0057 fixes the evidence/matching boundary and requires a schema boundary for future semantic changes.

## Current boundaries

- Reference alignment is deterministic diagnostics evidence, not a perceptual-quality verdict and not yet an automatic Legacy-vs-Legacy-x2 promotion signal.
- Reference evidence is not yet embedded into the durable Legacy A/B experiment manifest; that remains the next integration boundary.
- Initial audio-format support remains intentionally narrow: MP3/AAC/float WAV/transcoding are unsupported rather than silently guessed.
- Reference analysis/alignment performs no network calls, AI calls, playback mutation, Roblox authorization or keyboard dispatch.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML remain notation importers; image/PDF OMR is not silently attempted.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
