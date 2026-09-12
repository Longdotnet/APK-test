# ADR 0124: Deterministic review-region repair candidates

## Status

Accepted for engineering integration. Client selection UX is intentionally deferred.

## Context

Audio-to-Piano already surfaces deterministic review regions and lets the client preview those regions. A review warning is useful, but high-density or locally lossy passages still require the client to decide what to do next. Silently rewriting the canonical generated performance would violate the product rule that deterministic canonical state owns playback truth and that uncertain regions remain visible.

Spotify Basic Pitch remains the transcription source. Its output is polyphonic and instrument-agnostic, but Spotify explicitly notes that Basic Pitch works best on one instrument at a time. The repair layer therefore must treat decoded note evidence as uncertain input and must not claim waveform-perfect reconstruction.

## Decision

Add `AudioTranscriptionReviewRepairGenerator` as a deterministic, side-effect-free candidate generator over one review region.

The generator:

- consumes immutable Basic Pitch note evidence, the current canonical `PerformanceTrack`, and one existing review region;
- clips source-note evidence to the review interval so a candidate cannot rewrite adjacent sections;
- reuses `RobloxPianoArranger` rather than introducing a second arrangement engine;
- currently offers two bounded policies when they produce a real change:
  - **MelodyPriority**: one simultaneous arranged note, using the arranger's existing highest-pitch melody preservation rule;
  - **SimplifiedHarmony**: at most three simultaneous arranged notes by default;
- replaces only the review interval and preserves canonical events outside it, including safe left/right fragments of events crossing the region boundary;
- preserves canonical title, BPM, subdivision and start delay;
- deduplicates candidates and suppresses no-op alternatives;
- records candidate-local event count and peak simultaneous-note evidence for later client comparison;
- never persists, authorizes, schedules or injects a candidate automatically.

A candidate becomes playback/library truth only after a future explicit client selection step. Until then, the original `PerformanceTrack` remains authoritative.

## OSS and licensing

This phase adds no third-party package, model or copied implementation. It reuses the repository's existing Spotify Basic Pitch-derived note contract and existing deterministic Roblox arranger. Existing Basic Pitch attribution/NOTICE obligations remain unchanged; no new redistribution obligation is introduced.

## Consequences

The product now has a production-grade backend primitive for review repair without hiding uncertainty or forking playback truth. Regions that are already monophonic/no-op produce no fake alternative. Low-activation-only regions may still have no useful deterministic repair; that is preferable to fabricating a candidate.

Client-facing A/B preview, explicit apply/revert, and post-selection readiness re-analysis are separate follow-up work and must preserve this boundary.
