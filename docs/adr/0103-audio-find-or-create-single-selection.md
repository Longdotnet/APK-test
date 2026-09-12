# ADR 0103 — Audio Find-or-Create single-selection flow

## Status

Accepted for Audio-to-Piano OSS Phase 25.

## Context

Phase 24 preserved one owned/local reference after batch MIDI verification so the client did not need to choose the same audio twice. The remaining product friction was that the client still had to understand and manually sequence separate Search, Verify, and Create actions.

The target client experience is one decision flow: choose authorized local audio once, prefer a trustworthy existing source when evidence proves it matches, otherwise create a deterministic piano version from that same audio.

## Decision

The online discovery surface exposes **Find or Create with my audio...**.

1. The client chooses one local WAV/MP3/AIFF/AIF file.
2. `AudioFindOrCreatePlan` binds one absolute local path, one normalized song identity, and a bounded candidate limit. Search text wins when present; otherwise the deterministic audio-filename fallback is used.
3. Discovery runs for that identity. Up to five candidates are considered; the reusable plan rejects limits above ten.
4. When candidates exist, the selected audio is analyzed locally once for reference evidence and the existing bounded `OnlineSongReferenceVerificationService` verifies/reranks candidates.
5. If at least one candidate is `HighConfidence`, the best evidence-backed result is surfaced first and the client may **Add Verified Match**. Review/Mismatch evidence cannot become the preferred existing-source path.
6. If discovery returns no candidates, provider discovery is unavailable, or verification yields no High-confidence candidate, the same local audio path opens **Create Piano Version** automatically. There is no second file picker.
7. Transcription deliberately re-reads the local file through the production NAudio -> pinned Spotify Basic Pitch ONNX -> deterministic arranger pipeline. Reference-analysis buffers/evidence never become transcription or playback truth.

## Safety and boundedness

- Audio remains local; this flow does not upload the reference.
- Public MIDI discovery remains a fast path only. Same-title metadata is not recording-equivalence proof.
- Candidate verification keeps existing provider/redirect validation, bounded download size, temporary-file cleanup, canonical `PerformanceTrack` parsing, evidence hashing, and sequential bounded work.
- Cancellation/timeout fails without silently adding a candidate or generated track.
- Search identity and file path are normalized deterministically before discovery/create handoff.
- No YouTube downloader, access-control bypass, Python, PyTorch, ffmpeg, or developer-tool runtime is introduced.

## OSS impact

No new dependency, copied implementation, model, or native binary is introduced. The flow reuses the existing NAudio ingest boundary, Spotify Basic Pitch model semantics through ONNX Runtime, DryWetMIDI persistence, and canonical `PerformanceTrack` authority. Existing license/NOTICE obligations are unchanged.

## Runtime Input boundary

This phase does not alter Roblox input, focus authorization, scheduler truth, held-key/pedal ownership, emergency release, Legacy, or Legacy x2. Runtime Input P0 remains independently gated by explicit client-visible Roblox reaction.
