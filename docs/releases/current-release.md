---
schema: 1
version: 0.40.36
---
# Roblox Piano v{{VERSION}}

Validated commit: `{{COMMIT_SHA}}`
Distribution: self-contained Windows x64 single executable
Client dependencies: none required manually
SHA256: `{{SHA256}}`

## Client flow

1. Download `RobloxPiano.exe` and double-click it; **Sheet Library** remains the normal starting point.
2. For the shortest audio path, choose **Find or Create with my audio...** and select one owned/local WAV, MP3, AIFF, or AIF file. Search text is used as song identity when present; otherwise the local filename supplies the deterministic identity.
3. The client searches public MIDI discovery, locally analyzes the chosen audio once, and verifies/reranks up to five candidate MIDI files. If a `High confidence` existing source is found, use **Add Verified Match**. If none is trustworthy, the same local audio opens **Create Piano Version** automatically without a second picker.
4. Preview/review generated piano before **Add to Library**. Existing-source verification and generated transcription never silently mutate canonical playback truth.
5. Open Roblox and run **Test Roblox Input**. Start with **Run Real-Key Baseline**, physically press/release W once on the selected Roblox surface, then run the PowerShell-oracle and full synthetic matrix without intentionally changing Roblox experience/session.
6. During each synthetic cell, do not intentionally press W yourself. Phase 82 binds the matrix verdict to the exact probe's bounded low-level provenance. Any physical/non-injected W, malformed target-W sequence, or missing retained provenance leaves that cell pending and requires a retry.
7. Keep the selected Roblox surface foreground throughout each hold and reaction assessment. Preserve every `LOWLEVEL_PROVENANCE_*`, `INPUT_MATRIX_*`, and `INPUT_FORENSIC` line, or export a **Support Bundle**. Windows-side delivery, CI success, or focus success alone is not a Roblox field PASS.

## Audio-to-Piano Phase 25 — single-selection Find or Create

- **Find or Create with my audio...** unifies discovery, evidence verification, and deterministic create fallback behind one local-audio selection.
- `AudioFindOrCreatePlan` binds one absolute local path, normalized song identity, and bounded candidate count. The interactive flow verifies at most five candidates; the reusable plan rejects counts above ten.
- Search text wins as song identity when present. Blank search text falls back deterministically to the selected audio filename through the existing `AudioToPianoSongIdentity` contract.
- Candidate discovery remains a fast path, not truth. Up to five candidates are verified against immutable local reference analysis and evidence-reranked. Only `HighConfidence` can become the preferred existing-source route.
- If discovery yields no candidate, providers are unavailable, or verification yields no High-confidence candidate, the same local path is handed immediately into **Create Piano Version**. No second file picker is required.
- Transcription deliberately re-reads the file through the production NAudio -> pinned Spotify Basic Pitch ONNX -> deterministic arranger -> canonical `PerformanceTrack` path. Verification analysis never becomes playback truth.
- Cancellation, timeout, malformed candidates, oversized downloads, and provider failures remain bounded/fail-safe. Nothing is silently added to Library.
- No new dependency, model, native runtime, media downloader, YouTube access-control bypass, Python, PyTorch, ffmpeg, or developer SDK is introduced. Existing attribution/NOTICE remains unchanged.

## Runtime Input P0 Phase 82 — matrix provenance binding

- Phase 81 detected physical/non-injected W contamination and malformed target-W transitions, but the cross-cell matrix still consumed only the retained `ROBLOX_REACTED` / `ROBLOX_NO_REACTION` reaction verdict plus session identity. Phase 82 closes that decision-integrity gap.
- Every completed bounded synthetic low-level observation is now retained under its unique probe ID in a process-local evidence registry. The registry is capped at 256 snapshots, stores only target-W forensic metadata, and never authorizes playback.
- A synthetic cell becomes eligible for Windows-boundary matrix evidence only when the exact probe ID has `UncontaminatedInjectedPairObserved=true`.
- Missing provenance and contaminated/malformed provenance fail closed: the synthetic cell remains pending and the client must rerun that cell.
- The rule is symmetric. A contaminated `YES` cannot prove `SYNTHETIC_VARIANT_REACHES_ROBLOX`; a contaminated `NO` cannot contribute to `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`.
- Provenance trust is additional to, not a replacement for, same-process/start-time/HWND identity, current reaction-context freshness, focus/window continuity, input-desktop parity, Windows key-state evidence, and explicit visible Roblox reaction.
- Production `keybd_event`, SendInput diagnostics, scheduler truth, focus authorization, held-key/pedal ownership, emergency release, Legacy, and **Legacy x2** remain unchanged.
- P0 remains `NOT YET PROVEN`. No matrix or CI result is `FIELD_CONFIRMED_PASS` without explicit client-visible Roblox movement or piano reaction from the production executable.

## Audio-to-Piano Phase 24 — single-reference verify-or-create fallback

- Phase 23 already analyzes one owned/local reference once and evidence-reranks up to five online MIDI candidates. Phase 24 removes the remaining duplicate file-picker step when that batch has no High-confidence match.
- After successful verification with no High-confidence source, **Create Piano Version from this audio** becomes available on the same search surface.
- The handoff retains only the absolute local path for the active search UI. It does not copy, upload, cache, or persist the reference audio.
- The current search identity and reference path are normalized by the deterministic `AudioToPianoSongIdentity` / `AudioToPianoCreatePrefill` contract before the create dialog opens.
- `AudioToPianoCreateForm` rechecks that the handed-off file still exists. A deleted/moved file fails closed and leaves **Choose Audio...** available rather than silently switching source.
- Search changes, a new verification, cancellation/failure, or clearing results invalidates the old reference handoff so one query cannot reuse another query's audio accidentally.
- Transcription still uses the existing local NAudio -> Spotify Basic Pitch ONNX -> deterministic arranger -> canonical `PerformanceTrack` -> readiness/review -> verified DryWetMIDI persistence path. Verification evidence never mutates playback truth.
- This phase introduces no media downloader, YouTube access-control bypass, Python, PyTorch, ffmpeg, developer SDK requirement, second inference stack, or new third-party dependency.

## Runtime Input P0 Phase 81 — target-key provenance contamination guard

- Phase 80 made all four synthetic W cells comparable through the same bounded `WH_KEYBOARD_LL` provenance contract. Phase 81 closes a remaining evidence-integrity gap: a physical W press during a synthetic attempt can no longer hide behind the first captured injected W-down/W-up pair.
- The observer counts every target-W low-level event inside the bounded observation window and separately counts `NotInjected`, `Injected`, and `LowerIntegrityInjected` provenance.
- `PhysicalTargetContaminationObserved` becomes true when any target-W event is not injected. `UnexpectedTargetTransitionObserved` becomes true for duplicate/reordered/incomplete target-key transitions such as DOWN/DOWN/UP or UP-before-DOWN.
- `UncontaminatedInjectedPairObserved` is true only for exactly two target events in clean DOWN-then-UP order, both injected or lower-integrity injected, with no physical target-key contamination.
- Existing `InjectedPairObserved` remains backward-compatible raw evidence. Phase 81 adds a stricter forensic interpretation rather than silently rewriting historical meaning.
- The observer ignores unrelated keys, never blocks/re-writes keyboard input, never injects extra input, and never logs unrelated personal keyboard activity.

## Audio-to-Piano Phase 23 — one-reference batch verification and reranking

- Phase 22 verified one discovered MIDI at a time. Phase 23 analyzes the selected owned/local reference audio once, then reuses that immutable analysis to verify up to five current top online MIDI matches.
- Candidate verification stays sequential and bounded. Each MIDI retains provider/redirect validation, the existing five-MiB maximum download, production `SongSourceLoader` parsing into canonical `PerformanceTrack`, deterministic reference timeline alignment, and hash-bound confidence assessment.
- A malformed, unavailable, oversized, or otherwise invalid candidate fails independently and cannot discard valid evidence from the remaining candidates. Operation-wide cancellation still stops remaining work.
- Successfully verified candidates are reranked with `ReferenceVerifiedSongRanker`: High confidence / Review / Mismatch evidence outranks provider metadata, while metadata score is only a tie-breaker after verified evidence.
- Verification itself never persists a candidate into Library. Candidate temporary files remain operation-scoped and are removed best-effort after each verification.
- Reference audio remains local.

## Runtime Input P0 Phase 80 — full synthetic-matrix low-level provenance

- Phase 79 added bounded `WH_KEYBOARD_LL` provenance to the PowerShell-oracle virtual-key `keybd_event` cell. Phase 80 extends the same target-key-only observer to non-zero-scan `keybd_event`, SendInput virtual-key, and SendInput scan-code.
- Every explicit synthetic W attempt emits the same `LOWLEVEL_PROVENANCE_ARMED`, `LOWLEVEL_PROVENANCE_EVENT`, and `LOWLEVEL_PROVENANCE_SUMMARY` contract under its stable probe ID.
- Down/up evidence records low-level scan code, flags, and `NotInjected`, `Injected`, or `LowerIntegrityInjected` classification. `LLKHF_LOWER_IL_INJECTED` remains distinct so integrity/UIPI differences stay visible.
- `NativeDeliveryObserved` remains intentionally independent. Low-level provenance improves forensic comparability; it does not redefine Windows evidence as Roblox consumption.

## Real-vs-synthetic field contract

- Physical W remains the control and must visibly react in the selected Roblox experience before a synthetic-failure matrix is considered conclusive.
- The four synthetic cells are PowerShell-oracle virtual-key `keybd_event`, non-zero-scan `keybd_event`, SendInput virtual-key, and SendInput scan-code.
- Any focus/window continuity loss invalidates that exact attempt even if focus later returns.
- Any physical/non-injected W event, malformed target-W transition sequence, or missing exact-probe low-level provenance prevents that synthetic cell from participating in a conclusive matrix verdict; rerun the cell.
- Only an uncontaminated injected down/up pair plus stable trusted focus, Windows delivery, same-session identity, fresh reaction context, and explicit Roblox `NO` reaction can strengthen boundary `POST_WINDOWS_SYNTHETIC_TO_ROBLOX_CONSUMPTION`.
- `FIELD_CONFIRMED_PASS` still requires explicit visible Roblox movement/piano reaction from the production executable. No CI or Windows-only signal can manufacture that verdict.

## Runtime Input invariants

- Production input semantics are unchanged: this phase does not alter or promote `keybd_event`, SendInput, scheduler truth, focus authorization, emergency release-all, held-key/pedal ownership, or the field-proven PowerShell behavioral oracle.
- Loss of authorized Roblox focus still stops production input and release cleanup remains fail-safe.
- **Legacy x2** remains a protected regression/perceptual baseline alongside Legacy.
- AI/network remain irrelevant to Runtime Input truth.
- P0 remains `NOT YET PROVEN` until explicit client field evidence confirms Roblox consumed the generated input.

## Audio-to-Piano production bundle

- Audio Phase 17 remains the bundled Spotify Basic Pitch + ONNX Runtime + NAudio transcription/arrangement path for owned/local audio.
- Audio Phase 18 retains verified DryWetMIDI persistence, Phase 19 bounded preview/review, Phase 20 search-to-create flow, Phase 21 deterministic reference confidence, Phase 22 owned-audio candidate verification, Phase 23 one-reference bounded multi-candidate verification/reranking, Phase 24 single-reference verify-or-create handoff, and Phase 25 single-selection Find-or-Create orchestration.
- Canonical `PerformanceTrack` remains authoritative. Runtime Input Phase 82 and its field gate do not modify the Audio-to-Piano architecture.