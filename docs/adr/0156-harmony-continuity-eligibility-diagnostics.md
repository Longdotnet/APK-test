# ADR 0156: Diagnose harmony-continuity eligibility before changing policy

## Status

Accepted for Audio-to-Piano OSS Phase 67.

## Context

Phase 65 proved that production harmony continuity was dormant on the pinned Spotify Basic Pitch repeated-progression corpus. Phase 66 then lowered only the continuity confidence floor from `0.90` through `0.75`; every candidate still produced zero `HarmonyContinuitySelections` and identical quality. The bottleneck therefore is not proven to be that floor.

Changing more arranger thresholds without knowing which deterministic stage removes or already satisfies a continuity candidate would accumulate heuristics without evidence.

## Decision

Add a pinned-model, test-only eligibility diagnostic over the same repeated-progression style of mixed audio. The diagnostic mirrors the bounded accompaniment decision stages without mutating production playback and reports, for dense clusters with recent harmonic context:

- previous-pitch-class candidates seen before density filtering;
- candidates rejected by adaptive accompaniment confidence;
- prior-pitch-class representatives rejected by the pitch-class coverage floor;
- representatives rejected by the continuity confidence floor;
- eligible continuity representatives already present in the pure-confidence baseline;
- eligible representatives outside the baseline (true counterfactual opportunities).

The diagnostic also runs the real production arranger on the exact same decoded Basic Pitch evidence and records `HarmonyContinuitySelections`. A counterfactual opportunity is evidence for a future selector experiment, not permission to mutate `PerformanceTrack`.

The gate fails closed if the pinned model stops recognizing enough usable evidence, if melody/harmony retention falls below the Phase 65/66 floors, or if production starts adding unmatched playback events. It deliberately does not require a particular blocker count because upstream model activations can shift when the pinned model is intentionally upgraded; instead CI preserves the printed evidence artifact for review.

## OSS and packaging impact

Spotify Basic Pitch remains the model/semantics source and Microsoft ONNX Runtime remains the inference runtime. NAudio and DryWetMIDI boundaries are unchanged. No upstream implementation is copied, no Python/PyTorch/ffmpeg/Demucs runtime is introduced, and there is no new client package or NOTICE obligation.

## Authority boundary

`RobloxPiano.Core.PerformanceTrack` remains authoritative. Phase 67 adds engineering evidence only; it does not alter scheduler, focus guard, Windows input, held-key/pedal ownership, Legacy baselines, release version, or Runtime Input P0.
