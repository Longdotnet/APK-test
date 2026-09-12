# ADR 0109: demucs.cpp output-directory benchmark contract

## Status

Accepted for engineering benchmark infrastructure only.

## Context

Phase 28 introduced `NativeSeparatorProcessAdapter` so a portable/native separator can be measured without adding Python, PyTorch, ffmpeg, or separator binaries to the production client. Its first contract treated `{output}` as one exact output WAV path.

The upstream `sevagh/demucs.cpp` CLI instead accepts an output **directory** and writes deterministic target files into it. Its documented four-source output contains `target_0_drums.wav` through `target_3_vocals.wav`; the six-source mapping additionally exposes guitar at target 4 and piano at target 5. Therefore the Phase 28 exact-file contract cannot directly exercise the upstream CLI for the piano-stem benchmark we need before any production adoption decision.

## Decision

`NativeSeparatorProcessRequest` may now specify `ExpectedOutputRelativePath`.

- Without it, Phase 28 behavior remains unchanged: `{output}` expands to the exact isolated `separated-stem.wav` path.
- With it, `{output}` expands to the isolated per-run workspace directory and the adapter consumes only the explicitly selected relative WAV stem after the process exits.
- The selected path must be relative, bounded, end in `.wav`, and resolve inside the isolated workspace. Absolute paths and traversal outside the workspace fail before a process is launched.
- Other files emitted by a multi-stem separator are ignored and removed with the workspace; they are never allowed to become canonical transcription truth by discovery or filename guessing.

`DemucsCppSixSourcePianoBenchmarkProfile` is the concrete engineering profile for upstream demucs.cpp semantics. It invokes the locally supplied executable with exactly:

1. explicit local model path,
2. `{input}` owned/local audio path,
3. `{output}` isolated directory,

and selects `target_5_piano.wav` as the six-source piano stem.

The profile computes candidate bundle evidence from the executable size + model size + an explicit additional-runtime byte count. This is adoption evidence only; no demucs.cpp binary, Demucs model, download mechanism, or PATH search is added to `RobloxPiano.exe`.

## Consequences

The Phase 27 paired benchmark can now drive the real demucs.cpp CLI shape while retaining Phase 28 process isolation, cancellation/timeout, process-tree termination, bounded input/output, and cleanup. Phase 26 still owns `Adopt / Review / Reject`; this ADR does not assert that separation improves transcription quality.

There is no production package or license/NOTICE change in this phase because the repository does not redistribute demucs.cpp or a Demucs model. If a future measured corpus reaches `Adopt`, production integration must separately review upstream/model licenses, bundle size, RAM, processing factor, clean-machine behavior, and attribution before any client release.
