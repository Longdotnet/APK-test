---
schema: 1
version: 0.39.0
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

## Phase 53 verified reference-audio experiment evidence

- Adds a deterministic evidence contract that binds one already-verified Legacy A/B experiment to one exact analyzed WAV reference.
- Re-verifies normalized reference features before evidence creation so modified tempo/onset/level records fail closed.
- Requires the completed experiment canonical fingerprint to match the exact canonical `PerformanceTrack` being aligned.
- Produces separate protected `Legacy 1.00x` and `Legacy x2 2.00x` alignment records against the same reference content/feature identities.
- Reports x2-minus-Legacy deltas for onset coverage, P95 residual timing error and distance from the reference tempo ratio.
- Hashes the completed experiment evidence identity, exact reference identities, both nested alignment evidence hashes and derived deltas into a separate evidence SHA-256.
- Verification rejects nested alignment tampering, reference/canonical identity mixing, non-1x/2x protected speeds and inconsistent derived deltas.
- The contract deliberately exposes measurements only; it contains no winner/preferred-engine field and cannot promote Legacy x2.
- Regression coverage includes valid binding, delta tampering, wrong canonical track and modified reference-feature rejection.
- ADR 0058 defines the provenance and no-auto-promotion boundary.

## Current boundaries

- Reference-audio experiment evidence is deterministic diagnostics evidence, not a perceptual-quality verdict and not an automatic engine-selection signal.
- The initial contract is programmatic evidence; client selection/export UX for attaching a WAV to an archived experiment remains a later UI boundary.
- Initial audio-format support remains intentionally narrow: MP3/AAC/float WAV/transcoding are unsupported rather than silently guessed.
- Reference analysis/alignment performs no network calls, AI calls, playback mutation, Roblox authorization or keyboard dispatch.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML remain notation importers; image/PDF OMR is not silently attempted.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
