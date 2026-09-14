# ADR 0154: Real-model repeated-progression harmony continuity evidence

## Status

Accepted.

## Context

Phase 64 added a bounded cross-section harmony tie-breaker to the deterministic Roblox piano arranger. The policy only prefers a pitch class from the immediately preceding credible harmony context when the current candidate remains within a relative activation floor. That protects against weak historical voices being revived, but the original real-model mixed-song corpus contained only one principal onset per section. It could prove that Phase 64 did not regress the existing corpus, not that the pinned Spotify Basic Pitch model actually exercised the continuity policy across a realistic progression.

Spotify documents Basic Pitch as polyphonic and instrument-agnostic while also noting that it works best on one instrument at a time. A mixed-song quality gate therefore needs to grade deterministic post-processing against notes the pinned model actually recognized rather than assume all reference notes can be recovered downstream.

## Decision

Add a redistributable, deterministic repeated-progression fixture to `RobloxPiano.AudioPipelineTests`.

The fixture synthesizes two Cmaj7 -> Am7 -> Fmaj7 -> G7 cycles followed by a Cmaj7 resolution. Each onset contains bass, four harmony voices, melody, weak octave contamination and a short transient. With only three accompaniment slots, the arranger must choose a playable voicing instead of retaining every decoded pitch.

The gate runs the pinned Basic Pitch model once, then evaluates the exact same decoded note evidence through two arranger configurations:

1. normal production harmony continuity;
2. a 1 ms continuity window that effectively disables cross-onset context while preserving every other arranger policy.

This isolates downstream continuity behavior from AMT nondeterminism. The gate reports global and per-section melody/harmony retention, clutter suppression, continuity selection count and the delta against the disabled control.

The gate fails closed when:

- the pinned model recognizes too little melody or harmony evidence to grade the arranger;
- production melody/harmony retention drops below the established quality floors;
- continuity creates unmatched playback events or expands event count;
- the real-model fixture never exercises a harmony continuity selection;
- continuity reduces global or per-section recognized-harmony retention versus the disabled control;
- clutter suppression materially regresses.

`RobloxPiano.Core.PerformanceTrack` remains authoritative. The evidence layer only observes decoded notes and canonical arranged output; it cannot authorize, schedule or mutate Roblox playback.

## OSS and packaging impact

The production stack remains Spotify Basic Pitch semantics/model, Microsoft ONNX Runtime, NAudio and the existing deterministic arranger. This phase does not copy upstream implementation and does not add a runtime dependency, model, Python, PyTorch, ffmpeg or source-separation package. No new license or NOTICE obligation is introduced.

Source separation remains deferred. The repeated-progression control comparison is intended to identify remaining deterministic headroom before accepting the package-size, latency and memory cost of a portable Demucs-style separator.

## Consequences

CI spends one additional short pinned-model inference over synthetic audio. Client runtime, package size and inference count are unchanged.

A future arranger change must now preserve continuity quality over repeated chord transitions, not only a single dense chorus onset. If the production continuity policy fails to outperform or at least match the disabled control on recognized notes, maintainers receive concrete evidence to tune or remove the heuristic rather than accumulating unmeasured rules.