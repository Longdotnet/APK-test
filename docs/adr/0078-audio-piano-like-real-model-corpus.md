# ADR 0078: Piano-like real-model Audio-to-Piano corpus

## Status
Accepted

## Context

Phase 08 added a deterministic redistributable corpus that runs generated PCM through NAudio, the pinned Spotify Basic Pitch `nmp.onnx` model, the production decoder and the Phase 07 evaluator. That corpus intentionally used pure sine notes because they are simple and reproducible, but sine tones under-represent the spectral and temporal conditions of piano audio: hammer transients, harmonic partials, decay, simultaneous notes and dynamics.

Calibrating `Ready / NeedsReview / Rejected` using only pure sine fixtures would create false confidence. At the same time, committing third-party recordings solely to improve CI would add provenance, licensing and repository-size costs before the synthetic quality boundary is mature.

## Decision

Add a second, independent real-model corpus whose audio is generated deterministically at runtime with piano-like characteristics:

- fast attack and exponential decay;
- deterministic harmonic partials through the fifth harmonic;
- a short reproducible hammer-like transient;
- per-note velocity differences;
- polyphonic chords, overlapping voices and arpeggios;
- soft peak normalization that preserves relative chord dynamics.

The fixtures remain source-generated and redistributable; no audio binary is committed. They run through the same production ingest, pinned ONNX inference, Basic Pitch decoder and corpus evaluator as Phase 08.

The existing sine corpus remains the stable recognition baseline. The piano-like corpus is a stricter adjacent gate with deliberately conservative initial floors. It must recover at least one ground-truth pitch/onset in every fixture and must maintain aggregate recall, F1 and onset timing floors. Its metrics are printed in CI so later runs can tighten the thresholds from observed pinned-model evidence rather than guesses.

## OSS comparison

This phase does not add another synthesis or ML framework. Spotify Basic Pitch remains the transcription semantic/model reference, Microsoft ONNX Runtime remains the native .NET inference runtime, and NAudio remains the audio ingest boundary. The runtime generator is test-only and intentionally small because its purpose is controlled fixture construction, not production audio synthesis.

## Consequences

### Positive

- The real-model gate now covers harmonic-rich timbre, polyphony, overlap and dynamics instead of only pure tones.
- Corpus provenance remains trivial: every sample is generated from repository source code.
- No Python, PyTorch, ffmpeg, sample library, runtime dependency or client package size is added.
- The established `PerformanceTrack`, scheduler and Roblox input boundaries remain untouched.

### Tradeoffs

- The generated timbre is only piano-like, not a physical piano recording.
- Basic Pitch can produce extra partial-related notes, so precision may remain lower than recall.
- CI performs four additional short inference cases.

## Follow-up

Use the pinned-model metrics from this corpus to calibrate stricter thresholds, especially polyphonic precision and duration error. After that baseline is stable, add a small public-domain/CC0 real-piano corpus only when provenance and redistribution terms are explicit, then use the combined evidence to calibrate the client-facing transcription readiness gate.
