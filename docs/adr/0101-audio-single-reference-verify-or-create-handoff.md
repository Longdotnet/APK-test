# ADR 0101: Single-reference verify-or-create handoff

## Status
Accepted

## Context

Audio Phase 23 lets a client select one owned/local audio file and reuse one immutable reference analysis across the top online MIDI candidates. When no candidate reaches `HighConfidence`, however, the client still has to leave the verification result, click **Create Piano Version...**, and choose the same file a second time. That is unnecessary friction in the target `search -> find trustworthy source or create` workflow.

The online fast path remains evidence-only: title similarity is not recording proof, `Review`/`Mismatch` may not be promoted to a verified source, and verification itself must not persist a candidate. The transcription path must still end in canonical `PerformanceTrack` and retain its existing readiness/review and verified MIDI round-trip boundaries.

## Decision

1. After a successful bounded batch verification, retain only the absolute path of the client-selected local reference for the lifetime of the current search surface. Do not copy, upload, persist, or cache the audio bytes.
2. If the batch contains no `HighConfidence` candidate, expose **Create Piano Version from this audio**. The action passes the already-selected local path plus the current search identity into `AudioToPianoCreateForm`.
3. `AudioToPianoCreatePrefill` canonicalizes the handoff path with `Path.GetFullPath` and derives the deterministic song identity through the existing `AudioToPianoSongIdentity` policy. A blank path is rejected.
4. `AudioToPianoCreateForm` rechecks that the file still exists before enabling creation. If the client moved/deleted the file, the handoff fails closed and the normal **Choose Audio...** path remains available.
5. Search text changes, a new verification, cancellation/failure, or clearing results invalidates the previous handoff. A reference selected for one query must not silently bleed into another query.
6. Transcription still runs through the existing local NAudio -> Spotify Basic Pitch ONNX -> deterministic arranger -> canonical `PerformanceTrack` -> readiness/review -> verified DryWetMIDI persistence path. No online candidate or reference analysis mutates playback truth.
7. Runtime Input P0 code, focus/input authorization, scheduler truth, held-key/pedal ownership, Legacy and Legacy x2 remain outside this phase.

## OSS comparison

This phase adds orchestration rather than a new decoder/transcriber subsystem. NAudio already provides the Windows audio-reader/sample-provider boundary used by the production ingest path, while Spotify Basic Pitch remains the mature AMT semantic/model reference. Re-decoding through a second library, adding ffmpeg/Python, or introducing another inference stack would increase packaging and clean-machine risk without solving the client friction addressed here.

## Consequences

- The normal fallback becomes `search -> choose owned audio once -> verify candidates -> no trusted source -> create from the same file`, eliminating the second file picker.
- Reference audio remains local and path-scoped to the active search UI. No new media-download behavior is introduced.
- The file can still change between verification and transcription. The create path intentionally treats transcription as a new deterministic read of the local file; verification evidence is not reused as transcription truth.
- No new third-party dependency, redistributed code/model, license, or NOTICE obligation is introduced.
