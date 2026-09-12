# ADR 0100: Batch reference verification and evidence-first reranking

## Status

Accepted for Audio-to-Piano OSS Phase 23.

## Context

Phase 22 lets a client verify one discovered online MIDI against owned/local reference audio. The verification is deterministic and safe, but a normal search can return several plausible same-title candidates. Requiring the client to reopen the same audio file and wait for a separate analysis for every candidate creates unnecessary work and encourages trusting metadata instead of evidence.

The repository already has all required production boundaries:

- NAudio-based local reference decode/downmix/resampling through `ReferenceAudioFileAnalysisService`;
- immutable `ReferenceAudioAnalysis` and deterministic timeline alignment;
- hash-bound `ReferenceCandidateAssessment` with High confidence / Review / Mismatch verdicts;
- `ReferenceVerifiedSongRanker`, where verified evidence outranks provider metadata;
- provider allow-list validation, bounded online MIDI download, production `SongSourceLoader`, and operation-scoped temporary cleanup.

No additional inference model or media runtime is needed for the batching problem.

## Decision

1. Analyze client-selected owned/local reference audio exactly once for a batch operation.
2. Verify at most five discovery candidates from the current top search results in the client flow. The reusable library API supports a hard maximum of ten so callers cannot turn it into an unbounded downloader.
3. Verify candidates sequentially. This deliberately bounds network concurrency, temporary disk usage, parsing memory, and cancellation cleanup while reusing the same immutable reference analysis.
4. Each candidate keeps the existing five-MiB download bound, provider/redirect validation, production canonical import, timeline alignment, confidence policy, and isolated temporary directory.
5. Expected candidate-local failures are isolated and reported. One unavailable, malformed, oversized, or unsupported MIDI does not discard valid evidence already obtained for other candidates. Cancellation remains operation-wide and fail-fast.
6. Successful assessments are passed through `ReferenceVerifiedSongRanker`. High confidence / Review / Mismatch evidence is authoritative; metadata score remains only a tie-breaker after verified evidence.
7. The Sheet Library discovery surface reranks the successfully verified candidates to the top after the one-reference operation. `Add Verified Match` is exposed only for a High-confidence selected candidate. Review/Mismatch candidates remain blocked from the verified-source fast path.
8. Verification never persists a candidate into Library. Import remains a separate explicit client action.

## OSS-first comparison

This phase reuses existing NAudio audio normalization and the repository's deterministic alignment/ranking stack. Spotify Basic Pitch and ONNX Runtime remain responsible for the separate Create Piano Version transcription path; DryWetMIDI remains responsible for robust MIDI ingestion/persistence boundaries already adopted by the product.

Adding Python audio toolkits, ffmpeg, a second DTW implementation, another MIDI parser, or a parallel verification engine would duplicate solved infrastructure and enlarge the clean-machine package/runtime surface without improving this batching decision.

No new third-party package, model, native binary, copied source, or license/NOTICE obligation is introduced by Phase 23.

## Failure and resource boundaries

- Batch candidate count is bounded and validated before network work.
- Reference audio analysis is immutable and reused rather than repeated.
- Candidate downloads remain bounded and sequential.
- Candidate-specific failures are explicit and never converted to High confidence.
- Cancellation before the batch performs no HTTP work; cancellation during a batch aborts the remaining work.
- Operation-scoped candidate files are removed best-effort in the existing `finally` cleanup path.
- Verification remains onset/tempo/timeline evidence. High confidence is not a claim of waveform identity or ownership/licensing equivalence.

## Architectural boundaries

`RobloxPiano.Core.PerformanceTrack` remains canonical playback truth. This phase does not mutate transcription output, scheduler behavior, focus guard, Windows/Roblox input, held-key/pedal ownership, Legacy/Legacy x2, or Runtime Input P0 field evidence.

Online discovery remains a lawful-source fast path. The client supplies owned/local reference audio; no code is added to download copyrighted reference media or bypass platform access controls.

## Consequences

The normal client path becomes closer to `search -> choose reference once -> evidence-reranked existing source when trustworthy -> otherwise Create Piano Version`. The tradeoff is that five sequential candidate downloads can take longer than a single verification, but memory/network pressure and cleanup stay bounded and understandable. A later phase can add richer progress/candidate status without changing the deterministic decision contract.
