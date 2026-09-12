---
schema: 1
version: 0.40.47
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; this release hardens the Runtime Input P0 synthetic-probe boundary while retaining Audio-to-Piano Phase 36 review readiness.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Runtime Input P0 Phase 93 — pre-keydown trusted-surface gate

- Every explicit synthetic field probe now re-captures the selected Roblox window identity and foreground state at the exact `BeginHold` boundary immediately before native KeyDown is allowed.
- A focus/window transition that occurs after the earlier stable-focus check but before the hold becomes active can no longer slip through the WinEvent-hook arming gap and receive one synthetic KeyDown before polling catches it.
- If the selected Roblox surface is no longer trusted or is not foreground at that boundary, the probe fails closed before injection with `SYNTHETIC_PRE_KEYDOWN_GATE`, `FOCUS_LOST_BEFORE_DOWN`, and `ABORT_BEFORE_DOWN` forensic evidence.
- Once the pre-keydown gate passes, the existing event-driven WinEvent continuity hook plus polling fallback remain responsible for any later focus/window loss during the held key.
- The guard is shared by the PowerShell-oracle, keybd_event scan, SendInput VK, and SendInput scan diagnostic paths through their existing synthetic continuity contract; no new injection backend is introduced.
- This phase does not promote any synthetic path to production playback and does not claim Roblox consumption is fixed.

## Runtime Input validation

- Recovery regressions now require the pre-keydown gate to allow only a continuity-clean, trusted selected Roblox surface that is currently foreground.
- A same-process but untrusted surface, a trusted HWND that is no longer foreground, or a continuity object already marked lost must all be rejected before KeyDown.
- Existing sticky WinEvent/polling continuity regressions remain unchanged and continue proving that focus recovery cannot rewrite a loss observed during a held synthetic key.
- Production scheduler truth, focus authorization, held-key/pedal ownership, emergency release, mapping strategies, Legacy, and **Legacy x2** remain unchanged.

## Audio-to-Piano OSS Phase 36 retained

- Deterministic review regions remain part of production transcription readiness and continue to promote locally suspicious output from `Ready` to `NeedsReview` without mutating canonical `PerformanceTrack` playback truth.
- Timestamped review reasons, local preview behavior, Basic Pitch/ONNX inference, NAudio ingest, arranger behavior, generated MIDI persistence, and existing audio regressions are unchanged by this input-focused release.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, or separator is bundled by this phase.

## Runtime Input P0 status

- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Phase 92 retained-history replay safety remains unchanged: a prior Yes/No reaction observation cannot be erased by a later clean retry merely because the older provenance was missing or contaminated.
- Phase 93 closes a pre-injection focus race; it does not itself prove the final Windows-synthetic-input to Roblox-consumption step.
- Loss of authorized Roblox focus stops input; pause/stop/crash cleanup releases held keys and pedal state.

## Field procedure

1. Open Roblox on the exact surface to test and open **Test Roblox Input**.
2. Run **Real-Key Baseline** first and confirm only what was visibly observed.
3. Run the PowerShell Oracle, keybd_event Scan, SendInput VK, and SendInput Scan cells without intentionally changing Roblox process/window.
4. If a probe reports `FOCUS_LOST_BEFORE_DOWN`, restore the selected Roblox surface and rerun only when the previous cell never reached a reaction verdict.
5. Retry only a genuine `WINDOWS_BOUNDARY_NOT_CONFIRMED` cell; once a Yes/No verdict exists, start a fresh matrix instead of rewriting the cell.
6. Windows delivery, CI success, focus success, or synthetic evidence without a passing physical control is not a field PASS.