---
schema: 1
version: 0.40.21
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the **Sheet Library** remains the normal client starting point.
2. Existing MIDI/MusicXML/VPS/TXT library and playback behavior remains unchanged.
3. Open Roblox and run `Test Roblox Input`. Start with **Run Real-Key Baseline**, physically press/release W once on the selected Roblox surface, then run the PowerShell-oracle and synthetic matrix without changing the Roblox experience/session.
4. Every retained matrix cell now carries the Roblox PID/process-start identity and selected HWND. If Roblox restarts or the selected window changes, the matrix fails closed instead of combining old and new evidence.
5. Preserve `INPUT_MATRIX_SESSION`, `INPUT_MATRIX_SUMMARY`, `INPUT_MATRIX` and `INPUT_FORENSIC` lines together, or export a **Support Bundle**. Matrix evidence remains diagnostic-only and never authorizes playback by itself.

## Runtime Input P0 Phase 73

- Phase 72 could retain the latest result for each probe cell even if Roblox restarted between cells. That allowed evidence from different Roblox lifetimes to look like one complete matrix.
- Each retained cell now captures the existing `RobloxProcessIdentity` PID + process-start ticks plus the selected Roblox HWND and emits an `INPUT_MATRIX_SESSION` forensic line correlated by probe ID.
- Before any cross-cell winner/failure verdict, all latest cells must have one identical session identity.
- Missing identity produces `SessionContinuityInvalid` with boundary `MATRIX_SESSION_IDENTITY_UNAVAILABLE`.
- A process restart, PID/start-time change, or selected-HWND change produces `SessionContinuityInvalid` with boundary `ROBLOX_SESSION_CHANGED`.
- A continuity-invalid matrix is never conclusive, never field PASS, and never playback authorization. Close/reopen **Roblox Input Check** after Roblox stabilizes and rerun from Real-Key Baseline.
- Retrying a cell still replaces stale evidence for that cell, so a fully refreshed same-session matrix can become comparable again.
- This phase does not add or promote an injection backend and does not modify `keybd_event`, `SendInput`, scheduler truth, focus authorization, held-key/pedal ownership, emergency release behavior, Legacy playback, or Audio-to-Piano behavior.
- CI success is not a Roblox field PASS. Visible movement or the expected piano note in the real Roblox client remains required.

## Real-vs-synthetic matrix

- `REAL_KEY_BASELINE_INVALID` continues to identify a missing/untrusted real-key baseline or a real W that Windows observed but Roblox did not visibly consume.
- `SYNTHETIC_VARIANT_WORKS` continues to identify exact synthetic semantics that visibly reached Roblox, but only inside one trusted matrix session.
- `REAL_KEY_WORKS_SYNTHETIC_FAILS` still requires a trusted real W with visible Roblox reaction plus confirmed Windows-boundary delivery and explicit no-reaction for all four synthetic cells in the same Roblox process/window identity.
- That complete same-session matrix uses failure boundary `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION` without pretending to observe Roblox internals.

## Trusted real-key baseline

- Stable arming and each real W down/up event continue to require `WindowsRobloxWindowIdentity` relation `ExactTarget` or `TargetWindowTree` with no known `MainWindowHandle` replacement.
- Same-PID alternate roots fail closed and cannot establish the real-key baseline.
- `LLKHF_INJECTED` events are rejected. An unmarked event remains a physical-baseline candidate, not cryptographic hardware attestation.

## Audio-to-Piano production bundle

- The executable continues to carry the pinned Spotify Basic Pitch model plus Microsoft ONNX Runtime/NAudio production dependencies introduced in v0.40.18.
- The Audio Phase 16 client-job boundary now present on `main` remains isolated from Runtime Input and does not modify Roblox keyboard dispatch.
- The same model provenance, `--audio-model-smoke`, single-file packaging and clean-machine runtime checks remain release-gated.
- This Runtime Input phase does not claim end-to-end Play-in-Roblox success.

## OSS and attribution

- Spotify Basic Pitch remains the pinned Automatic Music Transcription model/semantic reference under Apache-2.0, including its upstream NOTICE attribution.
- Microsoft ONNX Runtime remains the native .NET inference engine; NAudio remains the Windows audio decode/normalization boundary under their upstream redistribution terms.
- `RobloxPiano.exe --third-party-notices` continues to expose bundled third-party notices.
- No Python/PyTorch/Demucs/ffmpeg dependency is introduced.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- **Legacy** and **Legacy x2** remain protected regression/perceptual baselines.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed.
- AI/network are irrelevant to core Runtime Input truth.

## Current boundaries

- No client field evidence in this release proves that synthetic W is consumed by Roblox. P0 remains `NOT YET PROVEN` until visible Roblox reaction is explicitly confirmed.
- PID/start-time/HWND continuity cannot prove an internal Roblox place/experience transition when Roblox reuses the same process and window. Client field runs must still avoid intentionally changing experience/session between cells.
- `SYNTHETIC_VARIANT_WORKS` is evidence about one tested semantic path, not permission to silently switch production playback.
- Raw/device-origin consumption inside another process remains unobservable from Roblox Piano without unsafe assumptions; the matrix describes the evidence boundary rather than inventing a PASS.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
