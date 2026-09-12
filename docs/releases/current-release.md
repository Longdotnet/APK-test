---
schema: 1
version: 0.40.29
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; **Sheet Library** remains the normal starting point.
2. Search for the song identity first. Existing local/validated online MIDI remains the fast path; if no suitable source exists, use **Create Piano Version...** directly from Sheet Library and choose owned/local audio. The searched identity is preserved through Create -> Preview -> review -> explicit Add to Library.
3. Existing Audio-to-Piano Phase 19 preview/review and Phase 18 verified Library persistence remain unchanged: low-confidence output stays visible, `Rejected` cannot persist, and generated MIDI must survive production-import parity before commit.
4. Open Roblox and run **Test Roblox Input**. Start with **Run Real-Key Baseline**, physically press/release W once on the selected Roblox surface, then run the PowerShell-oracle and synthetic matrix without intentionally changing Roblox experience/session.
5. Keep the selected Roblox surface foreground for the full physical W hold and through each synthetic probe/reaction assessment. Phase 78 invalidates a synthetic cell even when a short foreground hop occurs between polling ticks.
6. For the PowerShell-oracle cell, preserve the new `LOWLEVEL_PROVENANCE_*` lines with the rest of the probe evidence. They show whether Windows' low-level keyboard stream observed the synthetic W as injected or lower-integrity injected.
7. Preserve `INPUT_MATRIX_SESSION`, `INPUT_MATRIX_REACTION_CONTEXT`, `INPUT_MATRIX_SUMMARY`, `INPUT_MATRIX` and `INPUT_FORENSIC` lines together, or export a **Support Bundle**.

## Runtime Input P0 Phase 79 — PowerShell-oracle low-level provenance

- The physical-W baseline already observes `WH_KEYBOARD_LL` and rejects events carrying `LLKHF_INJECTED`; the PowerShell-oracle synthetic cell previously relied on injection success plus `GetAsyncKeyState` for Windows-boundary evidence.
- Phase 79 arms a bounded diagnostic-only `WH_KEYBOARD_LL` observer for the exact PowerShell-oracle W attempt after the selected Roblox surface is stable and before W-down.
- The observer filters to only the explicit probe virtual key. It records no unrelated keyboard input and never blocks, rewrites or injects input.
- `INPUT_FORENSIC stage=LOWLEVEL_PROVENANCE_ARMED` records hook activation under the same probe ID.
- `stage=LOWLEVEL_PROVENANCE_EVENT` records W down/up scan code, low-level flags and provenance classification: `NotInjected`, `Injected`, or `LowerIntegrityInjected`.
- `stage=LOWLEVEL_PROVENANCE_SUMMARY` records whether the complete injected down/up pair was observed by Windows' low-level keyboard stream.
- `LLKHF_LOWER_IL_INJECTED` is classified separately from the generic injected flag so integrity/UIPI evidence is visible from one client log.
- Existing `GetAsyncKeyState`, input desktop/session/integrity, GUI focus, window continuity and explicit human Roblox-reaction evidence remain independent. Phase 79 does not change production authorization or promote any backend.
- If Windows key state and an injected low-level W pair are both observed while Roblox stays on the trusted surface but the client reports no visible reaction, the evidence for `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION` is stronger; it is still not a field PASS.

## Runtime Input P0 Phase 78 — event-driven synthetic probe continuity

- Phase 77 closed the sub-25-ms foreground-hop blind spot for the physical-W control, but the four synthetic matrix cells still relied on 25 ms polling while W was held.
- Phase 78 arms a bounded Windows `EVENT_SYSTEM_FOREGROUND` WinEvent hook for the PowerShell-oracle `keybd_event` probe, non-zero-scan `keybd_event` diagnostic, SendInput virtual-key diagnostic and SendInput scan-code diagnostic.
- Any foreground transition outside the trusted selected Roblox window/tree during an active synthetic hold permanently invalidates that exact cell. Returning to Roblox cannot restore the same attempt.
- The event signal wakes the synthetic hold loop so key-up/release is requested without waiting for the next normal polling tick.
- Existing polling remains as fallback coverage for selected-window identity/MainWindowHandle changes that may not emit a foreground event. Stable-focus acquisition for these diagnostic cells also requires the trusted selected Roblox surface.
- `INPUT_FORENSIC stage=SYNTHETIC_CONTINUITY_ARMED` records that foreground events and polling fallback are active.
- A foreground hop records `stage=SYNTHETIC_FOREGROUND_EVENT` and `stage=SYNTHETIC_HOLD_CONTINUITY_LOST` with source, first-loss time and selected/foreground window identity.
- If the synthetic foreground hook cannot be armed, the diagnostic fails closed rather than silently producing lower-quality matrix evidence.
- This phase changes diagnostic confidence/release timing only. It does not add, promote or alter a production input backend and it does not authorize playback.

## Audio-to-Piano OSS Phase 21 — deterministic reference candidate confidence

- Phase 21 turns verified reference-audio timeline evidence into hash-bound `High confidence`, `Review`, or `Mismatch` assessments for discovery ranking.
- Verified reference evidence ranks before metadata; title/artist similarity cannot lift a known mismatch above a stronger reference match.
- The assessment is ranking/review state only and never mutates canonical `PerformanceTrack`, playback timing or Runtime Input behavior.
- Phase 21 adds no client-facing media download path and no new runtime dependency.

## Audio-to-Piano OSS Phase 20 — search-to-create Library flow

- Sheet Library exposes **Create Piano Version...** beside the main actions instead of requiring clients to discover the audio workflow elsewhere.
- The current search text is handed to Create Piano Version as suggested song identity. It is deterministic metadata only and never downloads/captures audio or bypasses source authorization.
- Song identity is normalized by trimming/collapsing whitespace/control characters and bounding the title to 120 characters; blank identity falls back to the selected local-audio basename and finally `Generated Piano`.
- The normalized identity is passed into the existing Audio-to-Piano job and canonical `PerformanceTrack`, so a local capture filename no longer silently replaces the song the client actually searched for.
- After verified Add to Library, Sheet Library refreshes and selects the exact committed path while keeping normal Library validation in force.
- Online MIDI remains a convenience fast path, not product truth. Same-title candidates are not treated as equivalent to the desired recording without the existing deterministic validation.
- No Runtime Input implementation, scheduler, focus guard, authorization, held-key/pedal ownership or playback truth changes are included in that audio phase.

## Runtime Input P0 Phase 77 — event-driven real-key hold continuity

- Phase 76 required continuous selected-Roblox ownership from physical W-down through W-up, but continuity was observed by a 25 ms sampler.
- Phase 77 adds a Windows `EVENT_SYSTEM_FOREGROUND` WinEvent hook while the bounded real-key probe is armed. A foreground hop away from the trusted selected Roblox window/tree during an active W hold invalidates that hold immediately instead of waiting for the next polling tick.
- Returning to Roblox later cannot restore the same hold. The decision is permanently fail-closed until a new baseline attempt.
- The existing 25 ms sampler remains as fallback coverage for identity/window changes that do not emit a foreground transition, and W-down/W-up endpoint checks remain unchanged.
- `INPUT_FORENSIC stage=REAL_KEY_ARMED` records `holdContinuityForegroundEvents=true`.
- A foreground hop during an active hold records `stage=REAL_KEY_FOREGROUND_EVENT`, then `stage=REAL_KEY_HOLD_CONTINUITY_LOST` with `source=WINEVENT_FOREGROUND` and the first loss time.
- If the foreground diagnostic hook cannot be armed, the baseline probe fails rather than silently reducing evidence quality.
- This phase changes diagnostic confidence only. It does not add or promote an input backend and it does not authorize playback.

## Real-vs-synthetic matrix

- `REAL_KEY_BASELINE_INVALID` covers a missing/untrusted physical-W control, including any observed foreground interruption during the active hold.
- `SYNTHETIC_VARIANT_WORKS` still requires a trusted probe/session identity plus explicit visible Roblox reaction for that exact synthetic cell.
- A synthetic cell with any event-driven or sampled foreground/window continuity loss is not eligible as clean evidence for a conclusive synthetic failure matrix.
- `REAL_KEY_WORKS_SYNTHETIC_FAILS` requires a trusted physical W with visible Roblox reaction plus confirmed Windows-boundary delivery and explicit no-reaction for all synthetic cells in the same trusted Roblox session.
- Phase 79 adds low-level injected provenance to the PowerShell-oracle evidence but does not silently change matrix truth or production authorization.
- A complete same-session synthetic failure still reports boundary `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`; Roblox Piano does not claim visibility into Roblox internals.

## Runtime Input invariants

- `keybd_event`, SendInput diagnostics, the field-proven PowerShell oracle, scheduler truth, focus authorization, emergency release-all, held-key/pedal ownership and Legacy playback remain unchanged.
- **Legacy x2** remains a protected regression/perceptual baseline alongside Legacy.
- Loss of authorized Roblox focus still stops production input.
- AI/network remain irrelevant to core Runtime Input truth.
- CI success is not a Roblox field PASS. Visible movement or the expected W-bound piano reaction inside the real Roblox client is still required.

## Audio-to-Piano production bundle

- Audio Phase 17: bundled Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement for owned/local audio.
- Audio Phase 18: explicit Library persistence after deterministic DryWetMIDI serialization and production-import round-trip validation.
- Audio Phase 19: bounded local canonical piano Preview before persistence using existing NAudio streaming/output.
- Audio Phase 20: one Sheet Library search-or-create path that preserves searched song identity into local transcription, review and verified Library persistence.
- Audio Phase 21: deterministic reference-audio candidate confidence/ranking from verified immutable alignment evidence.
- Canonical `PerformanceTrack` remains authoritative; Audio features do not replace Runtime Input or scheduler truth.

## OSS and attribution

- Spotify Basic Pitch remains the pinned AMT model/semantic reference under Apache-2.0 with upstream NOTICE attribution.
- Microsoft ONNX Runtime remains the native .NET inference engine.
- NAudio remains the Windows decode/normalization and local preview/output boundary.
- Melanchall DryWetMIDI Nativeless remains the deterministic generated-MIDI serializer under MIT.
- `RobloxPiano.exe --third-party-notices` exposes bundled third-party notices.
- Phase 79 adds no third-party dependency or license obligation.

## Current boundaries

- P0 remains `NOT YET PROVEN`: no field evidence in this release proves synthetic W is consumed by Roblox.
- Search/song identity is descriptive metadata and does not prove an online MIDI candidate matches the exact desired recording.
- Audio transcription continues to operate only on local audio the client explicitly chooses and is authorized to use; this release adds no media-downloader or access-control bypass.
- Foreground WinEvents close the sub-25-ms foreground-hop blind spot for both the physical control and all explicit synthetic matrix cells, but Windows still cannot directly attest another process's internal gameplay consumption.
- Low-level hook provenance tells us how Windows classified the explicit synthetic W event; it still does not prove Roblox consumed that event.
- PID/start-time/HWND continuity cannot prove an internal Roblox place/experience transition if Roblox reuses the same process/window; field runs must avoid intentionally changing experience/session between cells.
- `LLKHF_INJECTED` filtering and classification are useful forensic evidence, not cryptographic hardware provenance.
- `SYNTHETIC_VARIANT_WORKS` is evidence about one tested semantic path, not permission to silently change production playback.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
