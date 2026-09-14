# ADR 0150: Real-model arrangement quality evidence

Status: Accepted

## Context

Audio-to-Piano phases 57-59 improved deterministic melody priority, adaptive accompaniment density and section-transition confidence. Those policies were protected by deterministic arranger fixtures, while the real-model gate measured Basic Pitch transcription separately. That left an evidence gap: a threshold could pass synthetic arranger fixtures yet lose notes that the pinned Basic Pitch model actually recognized.

Spotify Basic Pitch is polyphonic and instrument-agnostic but documents that it works best on one instrument at a time. Full-song mixtures therefore need explicit measurement of what survives deterministic arrangement rather than an assumption that every decoded simultaneous activation is equally useful. The repository already uses mir_eval-inspired one-to-one pitch/onset matching for transcription corpus calibration.

## Decision

Add `AudioArrangementQualityEvidenceEvaluator` as an evidence-only production boundary. It receives labeled reference notes, the post-suppression Basic Pitch note evidence and the canonical arranged `PerformanceTrack` and reports:

- recognized versus retained melody notes;
- recognized versus retained harmony notes;
- per-section retention and minimum section melody retention;
- unmatched source versus arranged events and clutter-suppression ratio;
- arranged/source event-retention ratio.

A reference note contributes to arranger retention only after the upstream model actually recognized it. This deliberately separates transcription recall from deterministic arranger loss. Arranged keyboard events are mapped back through the active `MidiKeyboardProfile` only for measurement; the evaluator never mutates, authorizes or replaces `PerformanceTrack`.

The real-model Audio-to-Piano gate now synthesizes a redistributable multi-section piano-like fixture, runs the pinned Spotify Basic Pitch ONNX model through the production suppression and arrangement pipeline, and enforces meaningful melody/harmony recognition before enforcing retention floors. The fixture covers verse, transition, dense chorus and outro sections.

## OSS comparison

- Spotify `basic-pitch` remains the model/post-processing semantic source and explicitly documents the mixed/polyphonic quality boundary that motivates this evidence layer.
- `mir_eval.transcription` remains the comparison reference for maximum one-to-one note matching and onset-tolerance semantics. The repository keeps its existing native .NET evaluator instead of adding Python to production or CI.
- ONNX Runtime, NAudio and DryWetMIDI boundaries are unchanged.
- Demucs/source separation is still deferred until measured real-model arrangement evidence shows deterministic post-processing has reached a quality ceiling.

No upstream source code is copied by this phase and no new package, model or native runtime is added, so there is no new license or NOTICE obligation.

## Consequences

The audio gate becomes slightly more expensive because it evaluates one additional short real-model fixture, but it reuses the already prepared pinned model and performs no extra inference in client production. Production package size and runtime behavior are unchanged.

Threshold calibration can now be based on real pinned-model evidence. A future change that improves synthetic policy while materially losing recognized melody/harmony, increasing unmatched arranged events, or destabilizing a section will fail before merge.

Runtime Input P0 remains outside this boundary. Passing these quality gates is not field evidence that Roblox accepted synthetic input.
