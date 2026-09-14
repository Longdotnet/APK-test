# ADR 0162: Chorus-C2 Fixed-Slot Substitution Matrix

## Status

Accepted as an evidence gate. This phase does **not** mutate production arrangement unless a fixed-slot substitution clears the pinned-model promotion contract.

## Context

Phase 71 proved that Spotify Basic Pitch recognizes the five target harmony notes in repeated-progression `chorus-c2`, while canonical Roblox arrangement retains only two. Phase 72 then showed that replacing the production lower-octave representative globally with either strongest-activation or range-centered representatives does not improve `chorus-c2` and causes broader melody/harmony/clutter regressions.

The remaining question is narrower: can one of the recognized lost target notes improve quality if it occupies an accompaniment slot that production already spends at the same onset? This isolates scarce-slot/voicing selection from transcription variance, global octave policy, density growth and timing changes.

## Decision

Add a fail-closed real-model substitution matrix that:

1. runs the pinned Spotify Basic Pitch model once;
2. identifies target-section harmony notes recognized by Basic Pitch but not retained by production;
3. finds the existing production event nearest each lost recognized note onset;
4. substitutes the target pitch into each existing slot one at a time;
5. preserves event timing, duration, event count and notes-per-event count;
6. evaluates every substitution against the original decoded-note evidence and section references.

The gate never adds a slot. It skips duplicate-key substitutions and records the displaced pitch, target pitch, section/global harmony delta, melody delta, clutter delta, section wins/losses and false-positive state.

A substitution is a promotion candidate only when all of the following hold:

- `chorus-c2` improves from the production retained-harmony count and retains at least three recognized harmony notes;
- global retained harmony does not decrease;
- retained melody does not decrease;
- no section loses retained harmony;
- no unmatched playback event is introduced;
- arranged note count remains identical;
- clutter suppression does not decrease by more than 0.02.

If no substitution satisfies every condition, production remains unchanged and the evidence determines whether the next investigation should focus on multi-slot voicing interactions rather than another single-note/octave heuristic.

## OSS boundary

Spotify Basic Pitch remains the AMT evidence source and Microsoft ONNX Runtime remains the native .NET inference runtime. NAudio decode and DryWetMIDI import boundaries are unchanged. No upstream implementation is copied and no package/model/runtime dependency is added, so there is no new license or NOTICE obligation.

## Architectural boundary

`RobloxPiano.Core.PerformanceTrack` remains authoritative. The matrix is CI-only engineering evidence and cannot schedule playback, authorize input, or alter the Roblox Input P0 subsystem. Source separation remains deferred.
