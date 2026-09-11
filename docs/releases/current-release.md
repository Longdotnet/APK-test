---
schema: 1
version: 0.40.20
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
4. The dialog now continuously derives one deterministic cross-cell matrix verdict from the latest result for each cell. Preserve `INPUT_MATRIX_SUMMARY` together with the underlying `INPUT_MATRIX` / `INPUT_FORENSIC` lines or export a **Support Bundle**.
5. A matrix summary is diagnostic-only. It never authorizes playback and never upgrades the P0 field gate by itself.

## Runtime Input P0 Phase 72

- The real-vs-synthetic field matrix now owns deterministic cross-cell assessment instead of requiring support/devs to compare five probe results by eye.
- `REAL_KEY_BASELINE_INVALID` identifies a missing/untrusted real-key baseline or a real W that Windows observed but Roblox did not visibly consume.
- `SYNTHETIC_VARIANT_WORKS` identifies exact synthetic cell semantics that visibly reached Roblox so the winning path can be preserved and regression-protected before any production-backend decision.
- `REAL_KEY_WORKS_SYNTHETIC_FAILS` requires a trusted real W with visible Roblox reaction plus confirmed Windows-boundary delivery and explicit no-reaction for every synthetic cell: PowerShell oracle, keybd_event scan, SendInput VK and SendInput scan.
- That complete matrix is logged with failure boundary `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`; it narrows investigation beyond basic focus/target selection without pretending to observe Roblox internals.
- Missing/unrun cells and Windows-boundary failures remain `INSUFFICIENT_EVIDENCE`. Retrying a cell replaces its stale result within the same matrix.
- Every summary logs winning/failing/pending cells, `fieldPass=false`, and `authorizesPlayback=false`.
- This phase does not change `keybd_event`, `SendInput`, the production scheduler, focus guard, input authorization, held-key/pedal ownership, or emergency release behavior.
- CI success is not a Roblox field PASS. Visible movement or the expected piano note in the real Roblox client remains required.

## Trusted real-key baseline

- Stable arming and each real W down/up event continue to require `WindowsRobloxWindowIdentity` relation `ExactTarget` or `TargetWindowTree` with no known `MainWindowHandle` replacement.
- Same-PID alternate roots fail closed and cannot establish the real-key baseline.
- `LLKHF_INJECTED` events are rejected. An unmarked event remains a physical-baseline candidate, not cryptographic hardware attestation.

## Audio-to-Piano production bundle

- The executable continues to carry the pinned Spotify Basic Pitch model plus Microsoft ONNX Runtime/NAudio production dependencies introduced in v0.40.18.
- The same model provenance, `--audio-model-smoke`, single-file packaging and clean-machine runtime checks remain release-gated.
- This Runtime Input phase does not modify Audio-to-Piano architecture or claim end-to-end Play-in-Roblox success.

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
- `SYNTHETIC_VARIANT_WORKS` is evidence about one tested semantic path, not permission to silently switch production playback.
- `REAL_KEY_WORKS_SYNTHETIC_FAILS` is only emitted when all four synthetic cells established their Windows boundary and the client explicitly observed no Roblox reaction while the trusted real-key baseline did react.
- Raw/device-origin consumption inside another process remains unobservable from Roblox Piano without unsafe assumptions; the matrix describes the evidence boundary rather than inventing a PASS.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
