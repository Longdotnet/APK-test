---
schema: 1
version: 0.40.46
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; this release makes Audio-to-Piano review regions visible in production readiness while preserving the Runtime Input P0 field gate.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Audio-to-Piano OSS Phase 36 — review regions reach client readiness

- The deterministic Phase 35 review-region analyzer now runs inside the production Audio-to-Piano transcription orchestration after canonical arrangement.
- Review diagnostics retain the immutable flagged regions and review-analysis duration instead of dropping that local evidence after arrangement.
- A result that passes global quality checks but contains local low-activation, low-retention, excessive-density, or excessive-polyphony evidence is promoted from `Ready` to `NeedsReview`; `Rejected` is never weakened.
- Existing Create Piano Version output now receives timestamped `REVIEW_REGION_mm:ss-mm:ss_...` reasons, so clients can see where deterministic review is required instead of only receiving a generic warning.
- The client job also summarizes up to three flagged time ranges before Library review.
- Preview remains local and does not send Roblox keys. A `NeedsReview` result continues to use the existing explicit confirmation path before being added to the Sheet Library.
- The canonical `PerformanceTrack` remains authoritative; review analysis never edits generated notes or playback truth.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, or separator is bundled by this phase.

## Audio validation

- The pinned real Spotify Basic Pitch / ONNX pipeline regression now forces a deterministic local review condition and requires retained review regions, aggregate review readiness, non-Ready client status, and a timestamped review reason.
- Existing review-region regressions continue to cover low activation, local arrangement loss, clean regions, deterministic ordering, and silence handling.
- Existing NAudio ingest, ONNX inference, Basic Pitch decoding, harmonic suppression, arranger, generated MIDI persistence, preview, discovery verification, and source-separation benchmark boundaries remain unchanged.

## Runtime Input P0 status

- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Phase 92 retained-history replay safety remains unchanged: a prior Yes/No reaction observation cannot be erased by a later clean retry merely because the older provenance was missing or contaminated.
- Loss of authorized Roblox focus stops input; pause/stop/crash cleanup releases held keys and pedal state.
- Production `keybd_event`, SendInput diagnostics, PowerShell oracle semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, and **Legacy x2** are unchanged.

## Field procedure

1. Open Roblox on the exact surface to test and open **Test Roblox Input**.
2. Run **Real-Key Baseline** first and confirm only what was visibly observed.
3. Run the PowerShell Oracle, keybd_event Scan, SendInput VK, and SendInput Scan cells without intentionally changing Roblox process/window.
4. Retry only a genuine `WINDOWS_BOUNDARY_NOT_CONFIRMED` cell; once a Yes/No verdict exists, start a fresh matrix instead of rewriting the cell.
5. Windows delivery, CI success, focus success, or synthetic evidence without a passing physical control is not a field PASS.
