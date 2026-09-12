---
schema: 1
version: 0.40.26
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; **Sheet Library** remains the normal starting point.
2. Existing Audio-to-Piano Phase 19 remains available: owned/local audio -> Create Piano Version -> Preview -> review -> explicit Add to Library.
3. Open Roblox and run **Test Roblox Input**. Start with **Run Real-Key Baseline**, physically press/release W once on the selected Roblox surface, then run the PowerShell-oracle and synthetic matrix without intentionally changing Roblox experience/session.
4. Keep the selected Roblox surface foreground for the full physical W hold and through each synthetic probe/reaction assessment.
5. Preserve `INPUT_MATRIX_SESSION`, `INPUT_MATRIX_REACTION_CONTEXT`, `INPUT_MATRIX_SUMMARY`, `INPUT_MATRIX` and `INPUT_FORENSIC` lines together, or export a Support Bundle.

## Runtime Input P0 Phase 77 — event-driven real-key hold continuity

- Phase 76 required continuous selected-Roblox ownership from physical W-down through W-up, but continuity was observed by a 25 ms sampler.
- Phase 77 adds a Windows `EVENT_SYSTEM_FOREGROUND` WinEvent hook while the bounded real-key probe is armed. A foreground hop away from the trusted selected Roblox window/tree during an active W hold now invalidates that hold immediately instead of waiting for the next polling tick.
- Returning to Roblox later cannot restore the same hold. The decision is permanently fail-closed until a new baseline attempt.
- The existing 25 ms sampler remains as fallback coverage for identity/window changes that do not emit a foreground transition, and W-down/W-up endpoint checks remain unchanged.
- `INPUT_FORENSIC stage=REAL_KEY_ARMED` now records `holdContinuityForegroundEvents=true`.
- A foreground hop during an active hold records `stage=REAL_KEY_FOREGROUND_EVENT`, then `stage=REAL_KEY_HOLD_CONTINUITY_LOST` with `source=WINEVENT_FOREGROUND` and the first loss time.
- If the foreground diagnostic hook cannot be armed, the baseline probe fails rather than silently reducing evidence quality.
- This phase changes diagnostic confidence only. It does not add or promote an input backend and it does not authorize playback.

## Real-vs-synthetic matrix

- `REAL_KEY_BASELINE_INVALID` covers a missing/untrusted physical-W control, including any observed foreground interruption during the active hold.
- `SYNTHETIC_VARIANT_WORKS` still requires a trusted probe/session identity plus explicit visible Roblox reaction for that exact synthetic cell.
- `REAL_KEY_WORKS_SYNTHETIC_FAILS` requires a trusted physical W with visible Roblox reaction plus confirmed Windows-boundary delivery and explicit no-reaction for all synthetic cells in the same trusted Roblox session.
- A complete same-session synthetic failure still reports boundary `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`; Roblox Piano does not claim visibility into Roblox internals.

## Runtime Input invariants

- `keybd_event`, SendInput diagnostics, the field-proven PowerShell oracle, scheduler truth, focus authorization, emergency release-all, held-key/pedal ownership and Legacy playback remain unchanged.
- Loss of authorized Roblox focus still stops production input.
- AI/network remain irrelevant to core Runtime Input truth.
- CI success is not a Roblox field PASS. Visible movement or the expected W-bound piano reaction inside the real Roblox client is still required.

## Audio-to-Piano production bundle

- Audio Phase 17: bundled Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement for owned/local audio.
- Audio Phase 18: explicit Library persistence after deterministic DryWetMIDI serialization and production-import round-trip validation.
- Audio Phase 19: bounded local canonical piano Preview before persistence using existing NAudio streaming/output.
- Canonical `PerformanceTrack` remains authoritative; Audio features do not replace Runtime Input or scheduler truth.

## OSS and attribution

- Spotify Basic Pitch remains the pinned AMT model/semantic reference under Apache-2.0 with upstream NOTICE attribution.
- Microsoft ONNX Runtime remains the native .NET inference engine.
- NAudio remains the Windows decode/normalization and local preview/output boundary.
- Melanchall DryWetMIDI Nativeless remains the deterministic generated-MIDI serializer under MIT.
- `RobloxPiano.exe --third-party-notices` exposes bundled third-party notices.
- Phase 77 adds no third-party dependency or license obligation.

## Current boundaries

- P0 remains `NOT YET PROVEN`: no field evidence in this release proves synthetic W is consumed by Roblox.
- Foreground WinEvents close the sub-25-ms foreground-hop blind spot, but Windows still cannot directly attest another process's internal gameplay consumption.
- PID/start-time/HWND continuity cannot prove an internal Roblox place/experience transition if Roblox reuses the same process/window; field runs must avoid intentionally changing experience/session between cells.
- `LLKHF_INJECTED` filtering is useful forensic evidence, not cryptographic hardware provenance.
- `SYNTHETIC_VARIANT_WORKS` is evidence about one tested semantic path, not permission to silently change production playback.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
