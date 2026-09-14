# ADR 0151: Real-model mixed-instrument stress and source-separation decision gate

Status: Accepted

## Context

Phase 60 established an evidence boundary that measures what the deterministic Roblox arranger retains from notes the pinned Spotify Basic Pitch model actually recognized. The first real-model fixture is intentionally piano-like. That is necessary for stable attribution, but it does not exercise the product's harder case: a client-owned full-song mixture containing bass, sustained accompaniment, lead melody, octave-doubled energy and short non-pitched transients.

Spotify Basic Pitch is instrument-agnostic and polyphonic, while its own documentation notes that transcription works best on one instrument at a time. Source separation is therefore a plausible later quality tool, but shipping Demucs-class inference before measured need would add substantial model/runtime/package and memory cost.

## Decision

Add a second pinned-model production gate that synthesizes a redistributable mixed-instrument stress fixture entirely in-process. The fixture contains five song sections and deliberately different deterministic timbres for bass, pad and lead layers. Weak octave doubles and short broadband-like deterministic transients are injected as unlabeled clutter.

The gate runs the normal production path:

`normalized PCM -> pinned Basic Pitch ONNX -> decoder/post-suppression note evidence -> deterministic Roblox arranger -> canonical PerformanceTrack -> arrangement evidence evaluator`.

The gate measures recognized/retained melody and harmony, minimum per-section melody retention, source versus arranged unmatched events, clutter suppression and event-retention ratio. It never grades the arranger for reference notes that Basic Pitch failed to recognize upstream.

A source-separation decision is explicit and metric-driven. Native separation remains deferred while the mixed fixture has sufficient recognized evidence, melody retention is at least 85%, harmony retention is at least 65%, minimum section melody retention is at least two thirds, and clutter does not demonstrate a persistent unsuppressed ceiling. If future pinned-model evidence crosses that decision gate, CI directs the next phase to benchmark a portable/native separator such as `demucs.cpp` before any client dependency is added.

## OSS comparison

- Spotify `basic-pitch` remains the AMT model and semantic reference; its documented mixed-input quality boundary is why this stress gate exists.
- Microsoft ONNX Runtime remains the native .NET inference runtime and the existing reusable session path is unchanged.
- NAudio remains the Windows decode/resampling boundary for client-owned audio; this synthetic CI fixture does not add a decode dependency.
- DryWetMIDI remains the hardened MIDI verification/import reference and is unrelated to this evidence-only change.
- `adefossez/demucs` and native ports such as `sevagh/demucs.cpp` remain evaluation references only. No separator model/code/runtime is redistributed in this phase.

No upstream code is copied and no new package, model or native runtime is added, so there is no new license or NOTICE obligation.

## Consequences

CI spends one additional short Basic Pitch inference pass, reusing the already pinned model. Client runtime behavior, package size, scheduler/input ownership, canonical `PerformanceTrack` authority and release version are unchanged.

The project now has a concrete boundary for deciding whether source separation is justified by measured full-song mixture evidence rather than intuition. Passing this gate does not prove waveform equivalence and does not prove Runtime Input P0 in Roblox.
