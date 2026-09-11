---
schema: 1
version: 0.40.0
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
4. Use Support Center for verified Support Bundle export, Legacy x2 A/B campaign/history diagnostics, and local reference-audio evidence attachment.

## Production capability and reliability

- The production client remains a self-contained single EXE with no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- Sheet Library remains list-first; Browse/drag-drop are import helpers.
- Legacy and Legacy x2 remain protected regression/perceptual baselines and are not silently replaced or auto-promoted.
- Canonical performance state remains independent from TXT/MIDI/MusicXML/UI/AI/Windows input backends.
- Runtime focus/input authorization, emergency release-all, held-key/pedal ownership, deterministic transport evidence and verified experiment history remain unchanged.
- AI remains optional and is not required for playback/import/validation truth.

## Phase 54 client-facing reference evidence attachment and export

- Verified Legacy A/B History now lets a normal client attach a local reference recording to a selected completed experiment without developer tooling.
- The client re-selects the original TXT/VPS source; its source type and canonical performance fingerprint must exactly match the archived experiment before audio analysis can start.
- Reference input is restricted to deterministic 16-bit PCM WAV and is capped at 64 MiB before in-memory analysis to bound accidental client memory pressure.
- Exact WAV bytes are analyzed locally; neither the WAV bytes nor the selected source path are copied into diagnostics.
- Verified reference evidence is atomically persisted in a dedicated diagnostics archive and read back before the attachment is considered successful.
- Archive identity is idempotent for the same schema/experiment/reference content and fails closed rather than overwriting conflicting evidence.
- Corrupt/unverifiable reference evidence is excluded without hiding independent valid records; retention is capped at 100 verified records.
- The archive browser shows reference content/feature identities, separate Legacy 1x and Legacy x2 coverage/P95/tempo measurements, and x2-minus-Legacy deltas.
- `Export Reference Evidence...` re-exports the exact selected verified record and verifies its evidence SHA-256 after writing.
- Regression coverage now includes atomic evidence round-trip, idempotent durable archive/re-export, and corrupt-entry isolation in addition to Phase 53 provenance/tamper cases.
- ADR 0059 defines privacy, bounded-resource, durable archive and no-auto-promotion boundaries.

## Current boundaries

- Reference-audio experiment evidence remains deterministic diagnostics evidence, not a perceptual-quality verdict and not an automatic engine-selection signal.
- Initial audio-format support remains intentionally narrow: MP3/AAC/float WAV/transcoding are unsupported rather than silently guessed.
- The current attachment flow asks for the original TXT/VPS source again because archived diagnostics intentionally do not persist private source paths.
- When multiple verified references exist for one experiment, the most recently archived evidence is surfaced for direct re-export; all records remain integrity-checked in the archive.
- Reference analysis/alignment performs no network calls, AI calls, playback mutation, Roblox authorization or keyboard dispatch.
- CI cannot observe a live Roblox client consuming synthetic input; explicit GUI input verification remains the client-side acceptance check for a real Roblox process.
- MIDI and MusicXML remain notation importers; image/PDF OMR is not silently attempted.
- The executable is currently unsigned, so Windows SmartScreen may still show a reputation warning.
