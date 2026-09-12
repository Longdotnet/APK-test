# ADR 0123: Audio Review-Region Preview Navigation

## Status
Accepted

## Context

Audio-to-Piano Phase 35 made low-confidence/local-loss regions deterministic evidence and Phase 36 promoted those regions into client readiness. The production Create Piano Version screen could show that a result needed review, but the only audible review action still started from the beginning of the generated track. For a long song, a client had to manually infer where a flagged `00:45-00:50` region was without timeline navigation.

The review action must remain separate from Roblox Runtime Input. It may help a client decide whether to keep a generated arrangement, but it must not mutate canonical performance truth or inject keys.

## Decision

1. The existing NAudio-backed `GeneratedPianoPreviewSampleProvider` remains the only local generated-piano preview renderer.
2. Preview options may select a bounded `StartOffset` inside the canonical `PerformanceTrack` timeline. Events overlapping the selected window are clipped and shifted into the local preview window; the canonical track is never copied or mutated.
3. A deterministic `GeneratedPianoReviewPreviewPlan` expands each flagged review region with 1.5 seconds of context on each side and clamps that context to the canonical track boundaries.
4. The Create Piano Version screen retains the ordered immutable review regions produced by transcription and exposes `Previous Review`, `Preview Review Region`, and `Next Review` controls.
5. The selected region remains visibly identified by index, flagged timestamp, reason codes, activation, and retention evidence. Preview logs include the flagged and actual preview time range but never unrelated file contents or personal data.
6. Review playback is local audio only. It does not call the Roblox scheduler, focus guard, authorization, held-key/pedal ownership, native input backends, or network services.
7. `NeedsReview` and Add to Library confirmation semantics remain unchanged. Listening to a region does not silently upgrade readiness or mark evidence repaired.

## OSS reuse

NAudio remains the playback boundary through its `ISampleProvider` and `WaveOut` model. The phase adapts the existing streaming sample provider instead of introducing a second playback engine or eagerly rendering an entire song. Spotify Basic Pitch, ONNX Runtime and the canonical arranger are unchanged.

No new third-party package, model, native binary, Python runtime, PyTorch runtime, ffmpeg binary or source-separation model is added by this decision.

## Safety and performance

- Window playback is bounded by the existing five-minute preview limit; review plans are normally approximately eight seconds for a five-second review region.
- Rendering remains streaming and mono; it does not allocate a full-song waveform.
- A window outside the canonical timeline fails closed.
- A selected window with no audible arranged voices fails visibly rather than fabricating notes.
- Closing/cancelling/stopping the form disposes the same local preview device as before.

## Validation contract

Regression coverage must prove that:

- overlapping events that began before the requested window remain audible after clipping;
- later unrelated events are excluded;
- preview start/end metadata reflects the selected canonical timeline range;
- context is clamped at both beginning and end of a track;
- invalid negative/out-of-range window starts fail closed;
- existing deterministic full-preview and bounded-streaming behavior still passes.

The Windows production gate must continue proving that the self-contained client builds cleanly and that Runtime Input regression suites remain unchanged.