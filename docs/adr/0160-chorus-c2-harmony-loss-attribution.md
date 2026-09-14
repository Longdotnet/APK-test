# ADR 0160: Attribute recognized chorus harmony loss before changing arranger policy

## Status
Accepted for Audio-to-Piano OSS Phase 71.

## Context
Phase 70 proved that the Phase 64 cross-section harmony-continuity tie-break is dormant on both representative pinned Spotify Basic Pitch corpora and can be retired safely. The remaining repeated-progression weakness is not continuity: `chorus-c2` retains only a subset of harmony notes that Basic Pitch actually recognized.

Changing bass reservation, octave representative selection, adaptive density, or the hard simultaneous-note policy without knowing where recognized notes disappear risks trading one measurable regression for another.

## Decision
Add a fail-closed pinned-model attribution gate for `chorus-c2` before changing production policy.

Spotify Basic Pitch runs once on the existing repeated-progression fixture. The exact decoded note evidence is arranged with current production options. For every harmony reference note recognized by the model, the gate records whether canonical arrangement retained it and classifies a loss into one bounded downstream stage:

- `adaptive-density`: the recognized source note falls below the current accompaniment threshold;
- `pitch-class-representative`: a same-pitch-class octave representative survives at the same onset instead;
- `hard-density/voicing`: the note survives adaptive evidence filtering but loses a scarce Roblox accompaniment slot.

The gate must fail if the target no longer has enough recognized evidence, if the loss disappears (which means this diagnostic should be retired or retargeted), if a lost recognized note cannot be assigned to a bounded arranger stage, if melody retention regresses, or if arrangement introduces new unmatched playback events.

This phase is evidence-only. It does not yet change `RobloxPianoArranger`, canonical `PerformanceTrack`, scheduler/input ownership, client package, or Runtime Input P0. The dominant measured blocker determines the next production mutation; policy must not be tuned from intuition.

## OSS and packaging impact
Spotify Basic Pitch remains the AMT/model-semantics source and Microsoft ONNX Runtime remains the inference runtime. NAudio and DryWetMIDI boundaries are unchanged. No upstream code is copied, no new package/model/runtime is introduced, and no Python, PyTorch, ffmpeg or Demucs dependency is added.

The attribution pass runs only in the existing real-model CI harness over already-decoded notes, so there is no client runtime/package cost and no new license or NOTICE obligation.