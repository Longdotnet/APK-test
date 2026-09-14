# ADR 0164: Bass-anchor-aware fixed-slot selector A/B

## Status

Accepted as a pinned-model calibration gate. This phase does **not** mutate production arrangement.

## Context

Phase 73 found that a fixed-slot `chorus-c2` substitution can improve recognized harmony without adding density. Phase 74 then proved exact reference identity safety: replacing the local MIDI 48 slot with recognized MIDI 60 retains the MIDI 48/root through another canonical event and changes the matched reference set from `{48,71}` to `{48,60,71}`.

The remaining risk is overfitting that single fixture/reference. A production selector cannot inspect evaluation labels or reference notes. It needs a deterministic condition derived only from decoded Basic Pitch evidence plus canonical arrangement state.

## Decision

Evaluate a narrow reference-independent rule:

1. run Spotify Basic Pitch once per corpus and reuse exactly the same decoded evidence for production and candidate;
2. consider only the lowest canonical accompaniment pitch in a dense onset neighborhood;
3. require that exact bass pitch to already have canonical coverage inside a bounded recent window;
4. require a decoded same-pitch-class higher-octave candidate at the current onset which is not already present, is inside Roblox range and remains within the existing octave-representative confidence ratio;
5. replace exactly one existing canonical event key; never add an event or increase notes-per-onset;
6. compare the candidate against production on both repeated-progression and mixed-song pinned-model corpora;
7. print every applied substitution with event, onset, source/target MIDI and activation so a non-promotable result still identifies the missing production discriminant.

A candidate is bounded only when global harmony and melody do not decrease, no section loses harmony, no false positive is added, event count stays unchanged and clutter suppression is no worse than 0.02 below production. A bounded candidate is promotable only if repeated-progression `chorus-c2` also improves to at least 3 recognized harmony notes and global harmony strictly increases.

`KEEP_PRODUCTION` is a valid calibration result, not a CI failure, when production baselines remain healthy and the candidate stays bounded but fails to create measured gain. CI fails closed if production quality regresses or the candidate violates its safety bounds.

The selector deliberately does not use reference labels when choosing substitutions; reference data is used only after arrangement to score the A/B result.

## OSS and architectural boundary

Spotify Basic Pitch remains the AMT evidence source and Microsoft ONNX Runtime remains the native .NET runtime. NAudio and DryWetMIDI boundaries are unchanged. No upstream code or additional package/model/runtime is introduced, so there is no new license or NOTICE obligation.

`RobloxPiano.Core.PerformanceTrack` remains authoritative. The test-only selector cannot schedule playback, authorize input, alter Windows injection, or claim Runtime Input P0 field proof. Production arrangement remains unchanged unless a later selector demonstrates cross-corpus gain.