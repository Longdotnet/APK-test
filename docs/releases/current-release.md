---
schema: 1
version: 0.37.0
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

## Phase 51 deterministic reference-audio foundation

- Adds dependency-free `ReferenceAudioAnalyzer` to the deterministic Core layer as evidence-only infrastructure.
- Accepts explicitly supported uncompressed 16-bit PCM RIFF/WAVE input and fails closed on malformed chunks, unsupported encodings/bit depths, impossible sample rates, invalid block alignment or incomplete sample frames.
- Binds analysis to the exact reference bytes with SHA-256 and emits a separate SHA-256 over the normalized feature record.
- Deterministically measures duration, RMS/peak level, a fixed 10 ms energy envelope, onset positions with a fixed refractory rule, and bounded 60-200 BPM autocorrelation tempo evidence.
- Reference analysis performs no network calls, AI calls, codec downloads, playback mutation, Roblox authorization, keyboard dispatch, engine promotion or Legacy/Legacy x2 default change.
- Quality regression coverage includes deterministic repeated analysis, expected 120 BPM pulse-train evidence, exact-byte identity changes, malformed WAV rejection and unsupported-format rejection.
- ADR 0056 fixes the evidence boundary and requires a schema bump for any future semantic change to reference-audio features.

## Current boundaries

- Reference-audio analysis is not yet attached to a Legacy A/B experiment manifest and does not claim perceptual equivalence.
- Initial format support is intentionally narrow: MP3/AAC/float WAV/transcoding remain unsupported rather than silently guessed.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML remain notation importers; image/PDF OMR is not silently attempted.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
