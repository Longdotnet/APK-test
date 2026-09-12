---
schema: 1
version: 0.40.48
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; Create Piano Version now turns deterministic review-region evidence into direct local preview navigation.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Audio-to-Piano OSS Phase 37 — review-region preview navigation

- `NeedsReview` results now expose **Previous Review**, **Preview Review Region**, and **Next Review** controls instead of forcing clients to replay a long generated track from the beginning to find a flagged timestamp.
- Each selected region visibly retains its deterministic time range, reason codes, activation and retention evidence.
- Review playback adds 1.5 seconds of bounded context before and after the flagged region, clamped to the canonical generated track timeline.
- The existing NAudio streaming preview provider now supports a canonical timeline start offset. Events overlapping a selected window are clipped and shifted for local synthesis without mutating `PerformanceTrack`.
- Window preview remains local audio only and never invokes Roblox focus, authorization, scheduler, held-key/pedal state or Windows input injection.
- Listening to a flagged region does not silently promote readiness. Existing `NeedsReview` Add to Library confirmation remains required, and `Rejected` results remain blocked from Library commit.

## Audio validation and OSS boundary

- Regression coverage verifies deterministic timeline-window rendering, notes overlapping the left boundary, exclusion of later events, bounded context at both track edges and fail-closed invalid offsets.
- Existing full-track preview remains streaming and bounded; no full-song waveform is eagerly rendered for region navigation.
- NAudio remains the existing playback/`ISampleProvider` boundary. Spotify Basic Pitch, ONNX Runtime, NAudio ingest, deterministic arranger and generated MIDI round-trip verification remain unchanged.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator or source-separation model is bundled by this phase.

## Runtime Input P0 Phase 93 retained

- Every explicit synthetic field probe still re-captures the selected Roblox window identity and foreground state at the exact pre-KeyDown `BeginHold` boundary.
- A focus/window transition after stable-focus confirmation but before native injection continues to fail closed with `SYNTHETIC_PRE_KEYDOWN_GATE`, `FOCUS_LOST_BEFORE_DOWN`, and `ABORT_BEFORE_DOWN` evidence.
- The PowerShell-oracle, keybd_event scan, SendInput VK, SendInput scan, production scheduler, held-key/pedal ownership, emergency release, Legacy and **Legacy x2** semantics are unchanged by this audio-focused release.

## Runtime Input P0 status

- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Audio review navigation does not claim or imply end-to-end Roblox playability.
- Loss of authorized Roblox focus stops input; pause/stop/crash cleanup releases held keys and pedal state.

## Audio client procedure

1. Choose owned/local audio and run **Create Piano Version**.
2. If readiness is `NeedsReview`, use **Previous Review** / **Next Review** to select each flagged region.
3. Use **Preview Review Region** to hear that section with bounded local context; no Roblox keys are sent.
4. Use **Preview Full** when broader musical context is useful.
5. Add to Library only after reviewing the visible warnings; generated MIDI round-trip verification still runs before commit.
6. Roblox playback remains subject to the separate Runtime Input field gate.