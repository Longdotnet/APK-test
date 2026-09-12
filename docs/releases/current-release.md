---
schema: 1
version: 0.40.25
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; the **Sheet Library** remains the normal client starting point.
2. For owned/local audio, open **Create Piano Version**, choose the audio, wait for deterministic transcription/arrangement, review readiness/reasons, use **Preview** to hear the canonical generated piano locally, then explicitly **Add to Library** when acceptable.
3. Preview never sends keyboard input to Roblox. It is a local diagnostic/review surface only; `Rejected` output remains non-persistable and `NeedsReview` still requires explicit confirmation before Library commit.
4. Existing MIDI/MusicXML/VPS/TXT library and playback behavior remains unchanged.
5. Open Roblox and run `Test Roblox Input`. Start with **Run Real-Key Baseline**, physically press/release W once on the selected Roblox surface, then run the PowerShell-oracle and synthetic matrix without changing Roblox experience/session.
6. Keep the selected Roblox process/window continuously foreground from real W down through real W up, and keep the same Roblox process/window active through each synthetic probe and its Yes/No reaction assessment.
7. Preserve `INPUT_MATRIX_SESSION`, `INPUT_MATRIX_REACTION_CONTEXT`, `INPUT_MATRIX_SUMMARY`, `INPUT_MATRIX` and `INPUT_FORENSIC` lines together, or export a **Support Bundle**. Matrix evidence remains diagnostic-only and never authorizes playback by itself.

## Audio-to-Piano Phase 19 — local generated-piano preview

- **Create Piano Version** now exposes **Preview** and **Stop Preview** before Library persistence, so a client can hear the generated canonical arrangement rather than decide from diagnostics alone.
- Preview reads the authoritative `PerformanceTrack`; it does not parse a second song representation and it never enters the Roblox scheduler, focus guard, held-key/pedal ownership or Windows input path.
- Existing NAudio is reused as the local Windows streaming/output boundary. Preview audio is generated on demand through the float `ISampleProvider` contract instead of allocating a full rendered waveform.
- Canonical Roblox 61-key notes are mapped deterministically to their corresponding pitches. A short attack/release envelope and active-voice normalization keep review audio bounded without changing the canonical track.
- Preview defaults to the first 60 seconds for long tracks and explicitly surfaces truncation/source duration. Source note metadata remains bounded by the generated track; full-song PCM is not buffered in memory.
- Invalid canonical keys/timelines fail closed before playback. The audio regression harness verifies deterministic output independent of consumer buffer size, finite/bounded samples, explicit long-track truncation and invalid-key rejection.
- A `Rejected` result may be previewed to understand what the transcriber produced but still cannot be added to the Library. `NeedsReview` persistence still requires an explicit client decision.
- Preview is intentionally a lightweight deterministic review synth, not a claim of waveform-perfect piano rendering or Roblox field playback.

## Runtime Input P0 Phase 76

- The trusted real-key baseline now requires continuous ownership of the selected Roblox window/tree for the entire physical W hold, not merely at W-down and W-up.
- While a candidate real W is held, Roblox Piano samples foreground/window identity every 25 ms, matching the synthetic P0 continuity sampling cadence.
- If focus leaves the selected Roblox surface, the selected root changes, or the target main HWND is replaced between down and up, that baseline attempt is permanently invalid even if Roblox becomes foreground again before key-up.
- `INPUT_FORENSIC stage=REAL_KEY_HOLD_CONTINUITY_LOST verdict=REAL_KEY_HOLD_NOT_CONTINUOUS` records the first observed loss boundary and window relation.
- `REAL_KEY_VERDICT` now records `holdContinuityPreserved` and `firstHoldContinuityLossMs`, so one client log can distinguish an endpoint-only W pair from a continuously trusted real-key hold.
- Key auto-repeat cannot reset a previously failed hold-continuity decision; only the first accepted non-injected W-down arms the hold.
- This phase does not add or promote any input backend. It hardens the evidence used to conclude `REAL_KEY_WORKS_SYNTHETIC_FAILS`.

## Runtime Input P0 Phase 75

- Phase 74 bound each probe to the exact selected Roblox PID + process-start identity + HWND before input execution, preventing post-hoc relabelling after a restart/window replacement.
- Phase 75 closes the reaction-time TOCTOU gap: Roblox identity is captured again when the human reaction answer is assessed.
- If the current Roblox identity cannot be established, the matrix fails closed with `REACTION_CONTEXT_IDENTITY_UNAVAILABLE`.
- If PID/process-start/HWND differs from the probe-bound identity, the matrix fails closed with `REACTION_CONTEXT_CHANGED`.
- A stale Yes/No answer from a prior Roblox lifetime/window cannot produce `SYNTHETIC_VARIANT_WORKS` or `REAL_KEY_WORKS_SYNTHETIC_FAILS`.
- `INPUT_MATRIX_REACTION_CONTEXT stage=ASSESS_CURRENT` records the assessment-time identity used by policy.
- No input backend is added or promoted. `keybd_event`, `SendInput`, PowerShell-oracle semantics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release and Legacy playback remain unchanged.
- CI success is not a Roblox field PASS. Visible movement or the expected W-bound piano note in the real Roblox client is still required.

## Real-vs-synthetic matrix

- `REAL_KEY_BASELINE_INVALID` identifies a missing/untrusted real-key baseline, including a real W whose selected Roblox surface was not continuously trusted from down through up, or a real W Windows observed but Roblox did not visibly consume.
- `SYNTHETIC_VARIANT_WORKS` identifies exact synthetic semantics that visibly reached Roblox only when probe-bound and reaction-time identities remain trusted and continuous.
- `REAL_KEY_WORKS_SYNTHETIC_FAILS` requires a continuously trusted real W with visible Roblox reaction plus confirmed Windows-boundary delivery and explicit no-reaction for all synthetic cells in one trusted Roblox session.
- A complete same-session failure still uses boundary `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`; the application does not pretend to observe Roblox internals.

## Trusted real-key baseline

- Stable arming and each real W down/up event require `WindowsRobloxWindowIdentity` relation `ExactTarget` or `TargetWindowTree` with no known `MainWindowHandle` replacement.
- After the first accepted W-down, the same trusted selected Roblox surface must remain continuously foreground until W-up; a sampled loss fails closed for that attempt.
- Same-PID alternate roots fail closed and cannot establish the real-key baseline.
- `LLKHF_INJECTED` events are rejected. An unmarked event remains a physical-baseline candidate, not cryptographic hardware attestation.

## Audio-to-Piano production bundle

- Audio Phase 17 adds the client-facing **Create Piano Version** flow for owned/local audio using bundled Spotify Basic Pitch + ONNX Runtime + NAudio with deterministic progress/cancellation and Ready/NeedsReview/Rejected quality policy.
- Audio Phase 18 adds explicit generated-track persistence to the Library only after deterministic DryWetMIDI serialization and production `MidiFileImporter` round-trip/parity validation.
- Audio Phase 19 adds local canonical generated-piano preview before persistence, using existing NAudio streaming/output infrastructure without adding another runtime or playback truth.
- `Rejected` generated tracks are not persisted; `NeedsReview` requires explicit client confirmation.
- Canonical `PerformanceTrack` remains authoritative; Audio import/transcription/preview does not replace Runtime Input, focus guards, scheduler truth, held-key ownership or Legacy playback.
- Audio-to-Piano does not claim end-to-end Play-in-Roblox success while Runtime Input P0 remains unproven in the field.

## OSS and attribution

- Spotify Basic Pitch remains the pinned Automatic Music Transcription model/semantic reference under Apache-2.0, including upstream NOTICE attribution.
- Microsoft ONNX Runtime remains the native .NET inference engine and NAudio remains the Windows audio decode/normalization plus local preview/output boundary.
- Melanchall DryWetMIDI Nativeless is used for deterministic generated-MIDI serialization; its MIT attribution is bundled with third-party notices.
- `RobloxPiano.exe --third-party-notices` exposes bundled third-party notices.
- Phase 19 adds no dependency or license obligation: it reuses the already bundled NAudio package and its existing attribution.
- No Python/PyTorch/Demucs/ffmpeg dependency is introduced.

## Production capability and reliability

- Self-contained Windows x64 single EXE; no manual Python, Node, .NET SDK, Visual Studio or PowerShell-module dependency.
- Generated preview is streamed and duration-bounded; it does not allocate an arbitrarily long PCM result before playback.
- **Legacy** and **Legacy x2** remain protected regression/perceptual baselines.
- Runtime focus/input authorization, emergency release-all and held-key/pedal ownership remain fail-closed.
- AI/network are irrelevant to core Runtime Input truth.

## Current boundaries

- Audio Phase 19 preview uses a deterministic synthesized review tone for the canonical pitches/timing; it is not a sampled-piano renderer and does not promise waveform identity to the source recording.
- No client field evidence in this release proves synthetic W is consumed by Roblox. P0 remains `NOT YET PROVEN` until visible Roblox reaction is explicitly confirmed.
- The 25 ms continuity sampler is intentionally aligned with the synthetic probe cadence; an interruption shorter than the sampling interval may not be observed, so endpoint identity checks remain in force as an additional guard.
- PID/start-time/HWND continuity cannot prove an internal Roblox place/experience transition if Roblox reuses the same process/window; field runs must avoid intentionally changing experience/session between cells.
- `SYNTHETIC_VARIANT_WORKS` is evidence about one tested semantic path, not permission to silently switch production playback.
- Raw/device-origin consumption inside another process remains unobservable from Roblox Piano without unsafe assumptions; diagnostics report the evidence boundary rather than inventing a PASS.
- The executable remains unsigned, so Windows SmartScreen may show a reputation warning.
