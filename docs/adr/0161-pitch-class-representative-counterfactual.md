# ADR 0161: Pitch-Class Representative Counterfactual A/B

## Status

Accepted as an evidence gate. This phase does **not** change the production representative policy unless the pinned-model promotion contract is satisfied.

## Context

Phase 71 attributed the repeated-progression `chorus-c2` arranger loss after pinned Spotify Basic Pitch inference. Basic Pitch recognized all five target harmony notes, while canonical arrangement retained two. Two of the three lost recognized notes were replaced by another octave of the same pitch class; the remaining loss occurred at hard-density/voicing selection.

The production arranger deliberately prefers the lower octave representative when it remains within `HarmonyOctaveRepresentativeRelativeActivationFloor` of the strongest octave. That behavior improved dense mixed-song harmony in Phase 63, so changing it globally from one failing chord would be unsafe.

## Decision

Add a fail-closed, test-only A/B counterfactual that runs Basic Pitch once and keeps production `PerformanceTrack` timing, duration, density and event count fixed. It rewrites only accompaniment pitch-class representative identity, never the protected melody, then scores the counterfactual track against the original decoded-note evidence.

The bounded alternatives are:

- `StrongestActivation`: use the strongest decoded octave for the same pitch class.
- `RangeCenteredCredible`: among octaves that remain within the production 0.85 credibility floor, use the representative closest to the Roblox 61-key range center.

The counterfactual deliberately preserves event timing/duration and does not add notes. This isolates octave identity from AMT variance, adaptive-density changes and slot-count changes.

A policy is a promotion candidate only when all of the following hold on the pinned repeated-progression corpus:

1. `chorus-c2` retains at least 3 recognized harmony notes and improves over production.
2. Global recognized-harmony retention does not decrease.
3. Retained melody does not decrease.
4. No section loses retained harmony.
5. The evaluator reports no new unmatched playback events.
6. Event count remains identical and rewritten output creates no duplicate same-start/same-key collisions.
7. Clutter suppression does not fall by more than 0.02.

If no alternative satisfies every condition, production remains unchanged and the gate reports `KEEP_PRODUCTION`.

## OSS boundary

Spotify Basic Pitch remains the source of note/onset evidence and Microsoft ONNX Runtime remains the native .NET inference runtime. NAudio decode and DryWetMIDI import boundaries are unchanged. No upstream implementation is copied and no package/model/runtime dependency is added, so this phase creates no new license or NOTICE obligation.

## Architectural boundary

`RobloxPiano.Core.PerformanceTrack` remains authoritative. The A/B gate is engineering evidence only; it cannot schedule playback, authorize input or mutate the Roblox Input P0 subsystem. Source separation remains deferred.

## Consequences

The next production mutation, if any, is evidence-driven: promote only a representative policy that clears the gate, then validate the deterministic corpus plus pinned-model mixed-song corpus before release. If neither alternative wins, investigate the remaining hard-density/voicing loss rather than accumulating another octave heuristic.
