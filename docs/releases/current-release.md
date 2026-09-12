---
schema: 1
version: 0.40.31
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; **Sheet Library** remains the normal starting point.
2. Audio-to-Piano Phase 22 remains available unchanged: search first, verify an online MIDI with owned/local audio when useful, otherwise use **Create Piano Version...**.
3. Open Roblox and run **Test Roblox Input**. Start with **Run Real-Key Baseline**, physically press/release W once on the selected Roblox surface, then run the PowerShell-oracle and full synthetic matrix without intentionally changing Roblox experience/session.
4. Keep the selected Roblox surface foreground throughout each hold and reaction assessment. Preserve every `LOWLEVEL_PROVENANCE_*`, `INPUT_MATRIX_*`, and `INPUT_FORENSIC` line, or export a **Support Bundle**.
5. Answer the visible Roblox reaction prompt for every matrix cell. Windows-side delivery, low-level injected provenance, CI success, or focus success alone is not a Roblox field PASS.

## Runtime Input P0 Phase 80 — full synthetic-matrix low-level provenance

- Phase 79 added bounded `WH_KEYBOARD_LL` provenance to the PowerShell-oracle virtual-key `keybd_event` cell. Phase 80 extends the same target-key-only observer to all three remaining synthetic cells: non-zero-scan `keybd_event`, SendInput virtual-key, and SendInput scan-code.
- Every explicit synthetic W attempt now emits the same `LOWLEVEL_PROVENANCE_ARMED`, `LOWLEVEL_PROVENANCE_EVENT`, and `LOWLEVEL_PROVENANCE_SUMMARY` contract under its stable probe ID.
- Down/up evidence records the Windows low-level scan code, flags, and provenance classification: `NotInjected`, `Injected`, or `LowerIntegrityInjected`. `LLKHF_LOWER_IL_INJECTED` remains distinct from generic `LLKHF_INJECTED` so integrity/UIPI differences stay visible.
- Each diagnostic result retains its immutable low-level provenance snapshot. Regression coverage requires the non-zero-scan `keybd_event`, SendInput VK, and SendInput scan result contracts to retain that evidence.
- The observer is armed after stable trusted Roblox focus and begins immediately before synthetic W-down. It ends immediately after W-up; exception/cancellation cleanup ends observation defensively and still performs the existing best-effort key release.
- The observer filters to W only. It never records unrelated keyboard input, never blocks/re-writes input, and never injects additional input.
- Existing event-driven foreground continuity, polling fallback, input-desktop/session/integrity checks, `GetAsyncKeyState`, mapping/scan evidence, and explicit human Roblox reaction remain independent signals.
- `NativeDeliveryObserved` is intentionally unchanged. Phase 80 improves forensic comparability; it does not silently promote a diagnostic backend or redefine Windows evidence as Roblox consumption.

## Real-vs-synthetic field contract

- Physical W remains the control and must visibly react in the selected Roblox experience before a synthetic-failure matrix is considered conclusive.
- The four synthetic cells are PowerShell-oracle virtual-key `keybd_event`, non-zero-scan `keybd_event`, SendInput virtual-key, and SendInput scan-code.
- Any focus/window continuity loss invalidates that exact attempt even if focus later returns.
- A Windows-observed injected down/up pair plus stable trusted focus and explicit Roblox `NO` reaction strengthens boundary `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`; it does not prove why Roblox rejected the event.
- `FIELD_CONFIRMED_PASS` still requires explicit visible Roblox movement/piano reaction from the production executable. No CI or Windows-only signal can manufacture that verdict.

## Runtime Input invariants

- Production input semantics are unchanged: this phase does not alter or promote `keybd_event`, SendInput, scheduler truth, focus authorization, emergency release-all, held-key/pedal ownership, or the field-proven PowerShell behavioral oracle.
- Loss of authorized Roblox focus still stops production input and release cleanup remains fail-safe.
- **Legacy x2** remains a protected regression/perceptual baseline alongside Legacy.
- AI/network remain irrelevant to Runtime Input truth.
- P0 remains `NOT YET PROVEN` until explicit client field evidence confirms Roblox consumed the generated input.

## Audio-to-Piano production bundle

- Audio Phase 17 remains the bundled Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement path for owned/local audio.
- Audio Phase 18 retains verified DryWetMIDI persistence, Phase 19 bounded preview/review, Phase 20 search-to-create flow, Phase 21 deterministic reference confidence, and Phase 22 owned-audio verification of discovered MIDI candidates.
- Canonical `PerformanceTrack` remains authoritative. Runtime Input Phase 80 does not modify the audio/import/transcription subsystem.

## OSS and attribution

- Phase 80 adds no third-party dependency or license obligation.
- Existing Spotify Basic Pitch, Microsoft ONNX Runtime, NAudio, and Melanchall DryWetMIDI attribution remains unchanged and is available through `RobloxPiano.exe --third-party-notices`.

## Current boundaries

- `WH_KEYBOARD_LL`, `GetAsyncKeyState`, API return values, desktop parity and focus continuity are Windows-side forensic evidence, not visibility into Roblox's internal gameplay input pipeline.
- `LLKHF_INJECTED` classification is useful diagnostic provenance, not cryptographic hardware provenance.
- PID/start-time/HWND continuity cannot prove an internal Roblox place transition if the same process/window is reused; field runs must stay in one experience/session.
- No source code in this phase attempts to bypass Roblox, Windows UIPI, integrity boundaries, anti-cheat, or platform security.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
