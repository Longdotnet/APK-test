# ADR 0104 — Evidence-gated source-separation adoption

## Status

Accepted for Audio-to-Piano OSS Phase 26.

## Context

The production Audio-to-Piano path already decodes owned/local audio with NAudio, runs the pinned Spotify Basic Pitch ONNX model through ONNX Runtime, post-processes deterministic note events, arranges them for Roblox piano, and keeps canonical `PerformanceTrack` as playback truth.

Spotify documents that Basic Pitch is instrument-agnostic and polyphonic but works best when the input contains one instrument at a time. That makes source separation a plausible way to improve newly popular full-song mixtures, but it does not prove that adding a separator improves the generated Roblox piano enough to justify client cost.

Mature native work also exposes an important trade-off. `sevagh/demucs.cpp` demonstrates that Demucs-family separation can be run without shipping Python/PyTorch, while explicitly trading speed for lower memory. Native/ONNX separation therefore remains an engineering option, not an automatic production dependency.

References reviewed before this decision:

- Spotify Basic Pitch: https://github.com/spotify/basic-pitch
- Demucs: https://github.com/adefossez/demucs
- demucs.cpp: https://github.com/sevagh/demucs.cpp
- ONNX Runtime: https://github.com/microsoft/onnxruntime

No source/model from those repositories is copied or redistributed by Phase 26.

## Decision

Add a deterministic **source-separation adoption benchmark gate** before any separator can enter the production client.

A benchmark case is paired evidence over the **same ground-truth transcription**:

1. direct Basic Pitch transcription of the mixture;
2. transcription after the candidate separation path.

The gate recomputes aggregate micro-F1 from note counts and validates that supplied precision/recall/F1 values are internally consistent. Paired cases must have stable unique identities and equal ground-truth reference-note counts. Malformed or incomparable evidence fails closed.

Automatic `Adopt` requires all of the following default thresholds:

- micro-F1 gain of at least `0.05`;
- median per-case F1 gain of at least `0.03`;
- at least `60%` of benchmark cases improve;
- no case regresses by more than `0.05` F1;
- added production bundle size at most `256 MiB`;
- peak working set at most `1.5 GiB`;
- processing time at most `4.0x` audio duration.

Decision semantics:

- `Adopt`: quality improvement is broad/material and all resource budgets pass.
- `Review`: aggregate quality improves and no critical case regression occurs, but the improvement is too weak/narrow or a package/RAM/runtime budget is exceeded.
- `Reject`: there is no aggregate micro-F1 gain or any case crosses the allowed regression bound.

Thresholds are explicit policy inputs so future benchmark evidence can justify a reviewed policy change instead of silently changing production behavior.

## Architectural boundary

The gate is evaluation infrastructure only. It does not:

- add Demucs, demucs.cpp, another model, Python, PyTorch, ffmpeg, or a media downloader to the client;
- mutate Basic Pitch outputs, arranger decisions, canonical `PerformanceTrack`, scheduler/input behavior, or Library persistence;
- claim waveform equivalence or silently mark uncertain transcription as production-ready.

Runtime Input P0 ownership is untouched.

## Consequences

- Source separation now has a measurable go/no-go contract instead of an intuition-based roadmap item.
- A large gain on a subset of songs cannot hide a material regression on another benchmark case.
- A quality win cannot automatically ship if it makes the clean-machine executable/model footprint, memory, or processing latency unacceptable.
- The next separation experiment can benchmark a portable native candidate outside the client and feed measured paired results into this gate.
- Because Phase 26 adds no third-party dependency, model, or copied implementation, there is no new license/NOTICE obligation and no client release/version bump is required.
