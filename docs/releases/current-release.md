---
schema: 1
version: 0.40.19
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
4. The real-key baseline now requires the same trusted selected Roblox HWND/window-tree identity used by the synthetic probe authorization path. A same-PID alternate root or live Roblox main-window replacement invalidates the baseline instead of being accepted as equivalent focus.
5. Preserve `INPUT_MATRIX` / `INPUT_FORENSIC` lines or export a **Support Bundle** when diagnosing Roblox input.

## Runtime Input P0 Phase 71

- Phase 70 introduced an observation-only real W baseline, but its acceptance path still relied on PID-level `IsForeground`; that could accept a different top-level Roblox surface owned by the same process.
- Stable arming and each real W down/up event now capture `WindowsRobloxWindowIdentity` and require `ExactTarget` or `TargetWindowTree` with no known `MainWindowHandle` replacement.
- Forensic `REAL_KEY_EVENT` lines now include trusted-surface state, window relation, replacement state and foreground HWND under the same stable probe/matrix correlation.
- The final real-key verdict requires trusted selected-window identity at both key-down and key-up. Same-PID alternate roots fail closed and cannot establish the physical baseline.
- This change does not modify `keybd_event`, `SendInput`, the production scheduler, focus guard, input authorization, held-key/pedal ownership, or emergency release behavior.
- CI success is not a Roblox field PASS. Visible movement or the expected piano note in the real Roblox client remains required.

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
- The real-vs-synthetic matrix now compares input attempts against one consistent selected Roblox window identity boundary.
- AI/network are irrelevant to core Runtime Input truth.

## Current boundaries

- No client field evidence in this release proves that synthetic W is consumed by Roblox. P0 remains `NOT YET PROVEN` until visible Roblox reaction is explicitly confirmed.
- A non-`LLKHF_INJECTED` real-key event is still a physical-baseline candidate, not cryptographic hardware attestation.
- If real W visibly reacts on the trusted selected surface while PowerShell-oracle/synthetic cells show clean Windows delivery but no Roblox reaction, the remaining failure boundary is after Windows synthetic injection and before/inside Roblox game-input consumption.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
