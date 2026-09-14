# ADR 0163: Fixed-Slot Reference Identity Validation

## Status

Accepted as an evidence gate. This phase does **not** mutate production arrangement or playback.

## Context

Phase 73 found a bounded `chorus-c2` counterfactual where replacing production MIDI 48 with recognized lost MIDI 60 in the same accompaniment slot improved retained section harmony from 2/5 to 3/5 while preserving event count, melody, global harmony and clutter. Aggregate retention alone is not sufficient evidence for production promotion because MIDI 48 is also a recognized harmony/root reference. Before changing voicing policy we must prove that the apparent gain does not silently trade away that reference identity.

`AudioTranscriptionEvaluator` uses exact MIDI pitch, onset tolerance and one-to-one maximum-cardinality matching. Therefore identity safety can be checked deterministically by comparing matched reference indices before and after the fixed-slot substitution.

## Decision

Add a fail-closed pinned-model identity gate that:

1. runs Spotify Basic Pitch exactly once on the repeated-progression fixture;
2. rebuilds current production arrangement from the same decoded note evidence;
3. reproduces the Phase 73 MIDI `48 -> 60` fixed-slot substitution at the `chorus-c2` onset without adding density;
4. compares exact matched reference indices rather than aggregate counts;
5. requires the MIDI 60 reference to be newly matched;
6. requires **no previously matched harmony reference to be lost**;
7. specifically requires the displaced MIDI 48/root reference to remain matched by another canonical event within the evaluator tolerance;
8. preserves global/section harmony, melody, event count and false-positive contracts from the Phase 73 promotion gate.

The gate prints the canonical event/slot that still covers MIDI 48 after substitution so a later production selector can preserve bass/root identity explicitly instead of assuming aggregate retention is sufficient.

## Promotion boundary

This phase may emit `IDENTITY_SAFE_PROMOTION_CANDIDATE:60` only when reference-index identity is a strict superset of production and all quality constraints remain satisfied. That result is permission to design a minimal production selector A/B; it is **not** permission to mutate runtime playback in this phase.

## OSS and architectural boundary

Spotify Basic Pitch remains the AMT evidence source and Microsoft ONNX Runtime remains the native .NET inference runtime. NAudio decode and DryWetMIDI import boundaries are unchanged. No upstream implementation is copied and no package/model/runtime dependency is added, so there is no new license or NOTICE obligation.

`RobloxPiano.Core.PerformanceTrack` remains authoritative. The regression is CI-only evidence and cannot schedule playback, authorize input, change the Windows input backend, or alter Runtime Input P0. Source separation remains deferred.
