# ADR 0096: Deterministic reference-audio candidate confidence

## Status

Accepted for Audio-to-Piano OSS Phase 21.

## Context

Online MIDI discovery is a convenience fast path. A strong title/artist match does not prove that a discovered MIDI corresponds to the recording a client has in mind. The repository already has deterministic reference-audio analysis and immutable timeline-alignment evidence, but discovery ranking previously had no production policy for turning that evidence into a confidence/review decision.

Mature audio/MIDI alignment implementations commonly use temporal alignment (for example DTW/onset/chroma-style evidence) rather than filename equality. Pulling a Python/ffmpeg/librosa/Essentia stack into the Windows client would duplicate infrastructure and violate the self-contained production direction. The repository already measures onset coverage, residual timing error and tempo ratio without changing canonical playback truth.

## Decision

Add `ReferenceCandidateConfidencePolicy` in `RobloxPiano.Core` and `ReferenceVerifiedSongRanker` in `RobloxPiano.Library`.

The policy consumes only a verified `ReferenceAudioTimelineAlignment`. It produces immutable, hash-bound assessment evidence with one of three verdicts:

- `HighConfidence`: enough onset evidence with strong coverage, residual timing and tempo agreement.
- `Review`: plausible evidence that is sparse or not strong enough for automatic recommendation.
- `Mismatch`: strong deterministic evidence against equivalence, including low onset coverage or severe timing/tempo disagreement.

Confidence uses bounded onset coverage, mean/P95 residual timing error and tempo agreement. A single half/double-tempo ambiguity is normalized because beat trackers commonly disagree by one metrical octave; arbitrary tempo ratios are not normalized away.

The verified discovery ranker orders by reference verdict and confidence before existing metadata score. Metadata can break ties but can never lift a reference `Mismatch` above `Review` or `HighConfidence`.

Assessment evidence is diagnostic/ranking state only. It must not mutate a `PerformanceTrack`, adjust playback speed, rewrite timing, alter the existing online source, or touch Roblox input/focus/scheduler state.

## OSS comparison

Audio/MIDI alignment projects such as DTW-based score aligners reinforce that temporal/audio evidence is the correct class of signal for recording equivalence. For this phase we deliberately reuse the repository's deterministic reference-audio analyzer and timeline aligner rather than introducing Python, MATLAB, ffmpeg, librosa, Essentia, a synthesizer, or a new native runtime.

No third-party source code or model is copied or redistributed by this phase, so there is no new license or NOTICE obligation.

## Validation

Regression coverage must prove:

- strong repeated alignment becomes `HighConfidence`;
- sparse but plausible evidence remains `Review`;
- low-coverage false positives become `Mismatch`;
- one half/double-tempo ambiguity does not alone create a tempo mismatch;
- tampered assessment evidence fails closed;
- a huge metadata score cannot outrank stronger verified reference evidence;
- ranking is deterministic regardless of provider enumeration order.

The audio OSS gate runs both reference-audio quality regressions and Library ranking regressions before the existing Basic Pitch real-model end-to-end harness.

## Consequences

This phase creates the deterministic decision layer needed for a later client-facing “verify against my authorized reference audio” workflow. It does not yet claim an online candidate is recording-equivalent unless reference evidence has actually been supplied and assessed. Search/title metadata remains discovery metadata, not product truth.
