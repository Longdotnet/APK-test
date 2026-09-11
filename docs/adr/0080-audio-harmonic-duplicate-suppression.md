# ADR 0080: Conservative Basic Pitch harmonic-duplicate suppression

## Status

Accepted for Audio-to-Piano OSS Phase 10, subject to exact-model corpus validation before merge.

## Context

The Phase 09 piano-like corpus intentionally added attack/decay envelopes and harmonic partials instead of evaluating only pure sine tones. The pinned Spotify Basic Pitch model retained all 12/12 ground-truth pitch/onset notes, but produced a larger number of additional notes around harmonic-rich material. That evidence points to a precision problem after otherwise successful recognition.

A comparison against Spotify `basic_pitch/note_creation.py` showed the existing .NET decoder already preserves the important upstream post-processing contract: inferred onsets, strict local onset maxima, frame-energy termination, adjacent-bin clearing and Melodia recovery. Raising the global onset/frame thresholds would be simpler, but it would also risk deleting quiet melody notes and reducing the recall that the corpus currently demonstrates.

## Decision

Add a small deterministic adapter after Basic Pitch note decoding and before the Roblox arranger. It may suppress a decoded note only when all of these conservative conditions hold:

- a stronger lower-pitched decoded note is already retained;
- their onsets are nearly simultaneous;
- the candidate overlaps most of its own duration with the stronger anchor;
- the candidate is materially weaker than the anchor;
- the pitch interval is within a small tolerance of a configured integer harmonic ratio;
- power-of-two harmonics are protected by default so normal octave doubling remains musical intent rather than an assumed artifact.

The default policy considers non-octave harmonics 3 through 6, uses a 45 ms onset window, requires at least 80% candidate overlap, and requires candidate amplitude to be no more than half the anchor amplitude. Every suppressed note records its anchor, harmonic number, pitch error, overlap ratio and amplitude ratio in immutable diagnostics.

Suppression is cancellation-aware, can be disabled, never creates notes, and never mutates `PerformanceTrack` after canonical arrangement. A suppressed candidate is never allowed to become an anchor for another decision.

## OSS comparison and attribution

This phase continues to use Spotify Basic Pitch as the model/post-processing semantic reference. The harmonic-duplicate policy is RobloxPiano-specific adaptation driven by the repository's Phase 09 evaluation evidence; it is not copied from Spotify Basic Pitch or another OSS implementation. No new library, model, binary or redistributed source is introduced, so the existing NAudio, ONNX Runtime and Basic Pitch attribution remains unchanged.

## Validation contract

Unit regressions must protect weak-harmonic suppression as well as octave doubling, strong harmony, delayed harmony, short overlap, cancellation, disabled mode and invalid configuration.

The pinned real-model piano-like corpus must evaluate the raw decoded notes and the suppressed notes side-by-side. A merge is forbidden if suppression loses any ground-truth match, reduces corpus precision, or reduces micro-F1. Existing absolute Phase 09 recall/precision/F1/onset floors remain in force.

This quality slice does not change the Roblox scheduler, focus/input authorization, held-key ownership, Legacy playback baseline or Runtime Input P0 field gate. It does not prove Audio-to-Roblox end-to-end playback.
