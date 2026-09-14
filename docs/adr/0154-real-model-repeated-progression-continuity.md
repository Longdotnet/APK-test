# ADR 0154: Real-model repeated-progression harmony continuity evidence

## Status

Accepted.

## Context

Phase 64 added a bounded cross-section harmony tie-breaker to the deterministic Roblox piano arranger. The policy prefers a pitch class from the immediately preceding credible harmony context only when the current candidate remains within a relative activation floor. The original real-model mixed-song corpus had one principal onset per section, so it could prove non-regression but not whether pinned Spotify Basic Pitch output actually exercised continuity across repeated chord transitions.

Spotify documents Basic Pitch as polyphonic and instrument-agnostic while also noting that it works best on one instrument at a time. Mixed-song quality evidence therefore grades deterministic post-processing against notes the pinned model actually recognized rather than blaming the arranger for upstream AMT misses.

## Decision

Add a redistributable deterministic repeated-progression fixture to `RobloxPiano.AudioPipelineTests` and retain the real-model console evidence as a short-lived CI artifact.

The fixture synthesizes two Cmaj7 -> Am7 -> Fmaj7 -> G7 cycles followed by a Cmaj7 resolution. Each onset contains bass, four harmony voices, melody, weak octave contamination and a short transient. With only three accompaniment slots, the arranger must choose a playable voicing instead of retaining every decoded pitch.

The pinned Basic Pitch model runs once. The exact same decoded note evidence is then evaluated through:

1. the normal production harmony-continuity policy;
2. a 1 ms continuity window that effectively disables cross-onset context while preserving every other arranger policy.

This isolates downstream continuity behavior from AMT variation. The gate reports global/per-section melody and harmony retention, clutter suppression, continuity-selection count and deltas versus the disabled control.

The first exact-head evidence run measured:

- 9/9 recognized melody notes retained;
- 30/43 recognized harmony notes retained (0.698);
- identical 0.698 harmony retention with continuity disabled;
- identical 0.135 clutter suppression;
- zero production harmony-continuity selections across the repeated progression.

That is an important negative result: Phase 64 is non-regressive on this realistic repeated-progression fixture, but the current 0.90 confidence floor/selection interaction is dormant for the pinned-model evidence. Phase 65 must not rewrite that negative result into a false claim of quality gain.

The gate fails closed when:

- the pinned model recognizes too little melody or harmony evidence to grade the arranger;
- melody retention drops below 0.90 or recognized-harmony retention drops below the measured 0.69 floor;
- continuity creates unmatched playback events or expands event count;
- continuity reduces global or per-section recognized-harmony retention versus the identical decoded-note control;
- clutter suppression materially regresses.

A zero selection count is reported explicitly as `TUNE_REQUIRED`; a future proven improvement can move the evidence to `PROVEN_GAIN` without weakening the gate. The CI workflow also uploads the real-model log for seven days so failures and calibration decisions are reviewable without relying on opaque job-console access.

`RobloxPiano.Core.PerformanceTrack` remains authoritative. The evidence layer only observes decoded notes and canonical arranged output; it cannot authorize, schedule or mutate Roblox playback.

## OSS and packaging impact

The production stack remains Spotify Basic Pitch semantics/model, Microsoft ONNX Runtime, NAudio and the existing deterministic arranger. This phase does not copy upstream implementation and does not add a runtime dependency, model, Python, PyTorch, ffmpeg or source-separation package. No new license or NOTICE obligation is introduced.

Source separation remains deferred. The repeated-progression control comparison exposes deterministic arranger headroom before accepting the package-size, latency and memory cost of a portable Demucs-style separator.

## Consequences

CI spends one additional short pinned-model inference over synthetic audio and stores a small text artifact for seven days. Client runtime, package size and inference count are unchanged.

A future calibration phase should tune or replace the dormant continuity selection using this exact control comparison. It must demonstrate a non-negative global/per-section retention delta and no material clutter regression before any client-facing threshold change is shipped.