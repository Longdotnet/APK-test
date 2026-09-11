---
schema: 1
version: 0.40.23
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the **Sheet Library** remains the normal client starting point.
2. Existing MIDI/MusicXML/VPS/TXT library and playback behavior remains unchanged.
3. Open Roblox and run `Test Roblox Input`. Start with **Run Real-Key Baseline**, physically press/release W once on the selected Roblox surface, then run the PowerShell-oracle and synthetic matrix without changing Roblox experience/session.
4. Keep the same Roblox process/window active through each probe and through the Yes/No reaction assessment that follows it.
5. Preserve `INPUT_MATRIX_SESSION`, `INPUT_MATRIX_REACTION_CONTEXT`, `INPUT_MATRIX_SUMMARY`, `INPUT_MATRIX` and `INPUT_FORENSIC` lines together, or export a **Support Bundle**. Matrix evidence remains diagnostic-only and never authorizes playback by itself.

## Runtime Input P0 Phase 75

- Phase 74 bound each probe to the exact selected Roblox PID + process-start identity + HWND before input execution, preventing post-hoc relabelling after a restart/window replacement.
- Phase 75 closes the remaining reaction-time TOCTOU gap: Roblox identity is captured again when the human reaction answer is assessed.
- If the current Roblox identity cannot be established, the matrix fails closed with `REACTION_CONTEXT_IDENTITY_UNAVAILABLE`.
- If PID/process-start/HWND differs from the probe-bound identity, the matrix fails closed with `REACTION_CONTEXT_CHANGED`.
- A stale Yes/No answer from a prior Roblox lifetime/window can no longer produce `SYNTHETIC_VARIANT_WORKS` or `REAL_KEY_WORKS_SYNTHETIC_FAILS`.
- `INPUT_MATRIX_REACTION_CONTEXT stage=ASSESS_CURRENT` records the assessment-time identity used by policy.
- No input backend is added or promoted. `keybd_event`, `SendInput`, PowerShell-oracle semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release and Legacy playback remain unchanged.
- CI success is not a Roblox field PASS. Visible movement or the expected W-bound piano note in the real Roblox client is still required.

## Real-vs-synthetic matrix

- `REAL_KEY_BASELINE_INVALID` identifies a missing/untrusted real-key baseline or a real W Windows observed but Roblox did not visibly consume.
- `SYNTHETIC_VARIANT_WORKS` identifies exact synthetic semantics that visibly reached Roblox only when probe-bound and reaction-time identities remain trusted and continuous.
- `REAL_KEY_WORKS_SYNTHETIC_FAILS` requires a trusted real W with visible Roblox reaction plus confirmed Windows-boundary delivery and explicit no-reaction for all synthetic cells in one trusted Roblox session.
- A complete same-session failure still uses boundary `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`; the application does not pretend to observe Roblox internals.

## Trusted real-key baseline

- Stable arming and each real W down/up event require `WindowsRobloxWindowIdentity` relation `ExactTarget` or `TargetWindowTree` with no known `MainWindowHandle` replacement.
- Same-PID alternate roots fail closed and cannot establish the real-key baseline.
- `LLKHF_INJECTED` events are rejected. An unmarked event remains a physical-baseline candidate, not cryptographic hardware attestation.

## Audio-to-Piano production bundle

- Audio Phase 17 adds the client-facing **Create Piano Version** flow for owned/local audio using bundled Spotify Basic Pitch + ONNX Runtime + NAudio with deterministic progress/cancellation and Ready/NeedsReview/Rejected quality policy.
- Audio Phase 18 adds explicit generated-track persistence to the Library only after deterministic DryWetMIDI serialization and production `MidiFileImporter` round-trip/parity validation.
- `Rejected` generated tracks are not persisted; `NeedsReview` requires explicit client confirmation.
- Canonical `PerformanceTrack` remains authoritative; Audio import/transcription does not replace Runtime Input, focus guards, scheduler truth, held-key ownership or Legacy playback.
- Audio-to-Piano does not claim end-to-end Play-in-Roblox success while Runtime Input P0 remains unproven in the field.

## OSS and attribution

- Spotify Basic Pitch remains the pinned Automatic Music Transcription model/semantic reference under Apache-2.0, including upstream NOTICE attribution.
- Microsoft ONNX Runtime remains the native .NET inference engine and NAudio remains the Windows audio decode/normalization boundary.
- Melanchall DryWetMIDI Nativeless is used for deterministic generated-MIDI serialization; its MIT attribution is bundled with third-party notices.
- `RobloxPiano.exe --third-party-notices` exposes bundled third-party notices.
- No Python/PyTorch/Demucs/ffmpeg dependency is introduced.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- **Legacy** and **Legacy x2** remain protected regression/perceptual baselines.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed.
- AI/network are irrelevant to core Runtime Input truth.

## Current boundaries

- No client field evidence in this release proves synthetic W is consumed by Roblox. P0 remains `NOT YET PROVEN` until visible Roblox reaction is explicitly confirmed.
- PID/start-time/HWND continuity cannot prove an internal Roblox place/experience transition if Roblox reuses the same process/window; field runs must avoid intentionally changing experience/session between cells.
- `SYNTHETIC_VARIANT_WORKS` is evidence about one tested semantic path, not permission to silently switch production playback.
- Raw/device-origin consumption inside another process remains unobservable from Roblox Piano without unsafe assumptions; diagnostics report the evidence boundary rather than inventing a PASS.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
