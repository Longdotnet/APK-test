---
schema: 1
version: 0.40.50
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client entrypoint and support contract

- **Sheet Library** remains the normal client starting point; Create Piano Version now shows authoritative before/current quality evidence after deterministic repair.
- **Support Bundle** remains the preferred way to preserve correlated Runtime Input and client diagnostic evidence when troubleshooting playback.
- Legacy and **Legacy x2** remain protected regression/perceptual baselines.

## Audio-to-Piano OSS Phase 41b — client repair quality delta

- Create Piano Version now feeds the immutable transcription base/global quality assessment into the deterministic review-repair session instead of keeping repair quality disconnected from the client.
- After explicit **Apply Repair** or **Revert Repair**, global quality comes from authoritative `CurrentQuality`; the client no longer derives repair readiness from the stale pre-repair `_baseQuality` snapshot.
- The client shows before → current retention, transform loss, timeline coverage and event density so a normal user can see whether an accepted repair improved the canonical generated performance.
- Quality reason codes are shown as **Resolved**, **Persistent**, or **Introduced**. Source/model evidence that cannot legitimately be repaired remains visible.
- Local review regions remain an independent explicit-decision gate. Even when global quality becomes `Ready`, overall readiness stays `NeedsReview` while a flagged local region remains.
- A repaired track can legitimately promote overall `NeedsReview → Ready` only when authoritative global quality is Ready and no local review region remains.
- Global `Rejected` and `NeedsReview` assessments remain fail-closed; repair cannot hide persistent source/model warnings.
- Preview remains side-effect free. Only Apply mutates canonical repair-session state, Revert restores the original generated performance, and Add to Library still persists only the current explicitly accepted canonical track after MIDI round-trip verification.

## Audio validation and OSS boundary

- Audio UX regressions cover a genuine `NeedsReview → Ready` improvement, persistent source/model evidence, and an introduced quality regression.
- Existing Phase 40/41a regressions continue to verify repair-aware quality provenance, unknown-reason fail-closed behavior, deterministic delta reason classification, Apply atomicity, cancellation, and exact Revert.
- Spotify Basic Pitch, ONNX Runtime, NAudio ingest/preview, deterministic Roblox arranger, and generated MIDI round-trip verification remain the reused production boundaries.
- No new OSS package, model, Python runtime, PyTorch, ffmpeg, native separator, or source-separation model is bundled by this phase.

## Runtime Input P0 boundary retained

- This audio release does not modify Roblox target selection, focus guards, input authorization, scheduler, held-key/pedal ownership, `keybd_event`, SendInput, or emergency release behavior.
- Runtime Input remains `NOT YET PROVEN` until explicit field evidence shows production `RobloxPiano.exe` causing the expected visible Roblox movement or piano reaction.
- Audio quality improvement, repair preview, and Library commit do not claim or imply end-to-end Roblox playability.

## Audio client procedure

1. Choose owned/local audio and run **Create Piano Version**.
2. If readiness is `NeedsReview`, select a flagged region with **Previous Review** / **Next Review**.
3. Use **Preview Original Region** and **Preview Repair** for side-effect-free A/B listening.
4. Use **Apply Repair** only when the deterministic alternative is preferred.
5. Read the visible before → current quality metrics and Resolved/Persistent/Introduced reason codes.
6. Continue reviewing while local regions remain. Overall readiness becomes Ready only when authoritative global quality is Ready and the local review gate is clear.
7. Use **Revert Repair** before Library commit whenever the exact original generated performance is preferred.
8. Add to Library only after reviewing the visible warnings; generated MIDI round-trip verification still runs before commit.
9. Roblox playback remains subject to the separate Runtime Input field gate.
