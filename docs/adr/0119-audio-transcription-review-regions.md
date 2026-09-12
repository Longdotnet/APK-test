# ADR 0119: Surface deterministic Audio-to-Piano review regions

## Status

Accepted

## Context

The production Audio-to-Piano path already reports global readiness (`Ready`, `NeedsReview`, `Rejected`) from deterministic arrangement and Basic Pitch diagnostics. That global verdict is useful for gating, but it does not tell a client which part of a newly generated piano version deserves attention. A message such as “review flagged regions” is not actionable unless the backend can produce stable time ranges and reasons.

The quality contract requires low-confidence regions to remain visible rather than silently guessed or repaired. Region analysis must therefore be advisory evidence only: it must never mutate decoded notes, canonical `PerformanceTrack` events, scheduler/input behavior, or library/playback truth.

## Decision

Add `AudioTranscriptionReviewRegionAnalyzer` in `RobloxPiano.Audio`.

The analyzer consumes the source-audio duration, immutable decoded/suppressed Basic Pitch notes, and the already-produced canonical `PerformanceTrack`. It partitions the source timeline into deterministic fixed windows (five seconds by default) and emits only windows that cross an explicit review threshold. Each emitted region contains start/end time, source-note count, arranged-event count, mean Basic Pitch activation, local retention ratio, event rate, peak simultaneous notes, and stable reason codes.

Initial reason codes are:

- `LOW_ACTIVATION_REGION`
- `LOCAL_RETENTION_LOW`
- `LOCAL_EVENT_DENSITY_HIGH`
- `LOCAL_POLYPHONY_HIGH`

Windows containing no decoded source notes are not flagged merely because the canonical track is silent; legitimate musical silence must not become a false warning. The analyzer is deterministic with respect to input ordering and supports cancellation for long inputs.

This phase establishes the trustworthy region-evidence primitive and regression coverage. A following client integration may attach these regions to transcription diagnostics and UI review controls without changing the canonical track.

## OSS and architecture impact

This uses the already-integrated Spotify Basic Pitch activation semantics and canonical `PerformanceTrack`; no new third-party package or model is introduced. No code is copied from Spotify Basic Pitch, ONNX Runtime, NAudio, DryWetMIDI, Demucs, basicpitch.cpp, or demucs.cpp.

There is no new redistribution or NOTICE obligation. Runtime Input P0, Windows key injection, focus authorization, held-key/pedal ownership, Legacy playback, and source-separation benchmark infrastructure are unchanged.

## Consequences

Clients can receive deterministic, explainable local review evidence instead of a global warning only. These regions are not claims of waveform identity and are not permission to auto-correct playback truth. Thresholds remain explicit policy and should be tuned only with measured fixtures/corpus evidence.
