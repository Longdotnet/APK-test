# ADR 0107 — Native separator process adapter for engineering benchmarks

## Status

Accepted for Audio-to-Piano OSS Phase 28.

## Context

Phase 26 defined the measured adoption gate for source separation and Phase 27 added paired direct-vs-separated benchmark evaluation. The remaining gap was a safe boundary for invoking a real native separator candidate without adding that separator, its model weights, Python, PyTorch, ffmpeg or another runtime to the production RobloxPiano client.

Spotify Basic Pitch remains the production AMT reference and explicitly works best on one instrument at a time. `demucs.cpp` demonstrates that Demucs inference can be implemented as a native C++17 program, but its own design documents a deliberate speed-for-memory tradeoff. A native separator therefore still has to earn adoption with measured quality and resource evidence.

Primary references:

- Spotify Basic Pitch: https://github.com/spotify/basic-pitch
- Demucs: https://github.com/adefossez/demucs
- demucs.cpp: https://github.com/sevagh/demucs.cpp
- ONNX Runtime: https://github.com/microsoft/onnxruntime

Phase 28 does not copy or redistribute code, models or binaries from these projects.

## Decision

Add `NativeSeparatorProcessAdapter` as engineering-only infrastructure that can feed a native separator result into the existing Phase 27 benchmark runner.

The adapter:

1. requires absolute existing executable and input-audio paths;
2. launches the candidate executable directly with `UseShellExecute=false` and `ProcessStartInfo.ArgumentList`;
3. uses a unique temporary workspace and a fixed expected `separated-stem.wav` output;
4. substitutes only explicit `{input}`, `{output}` and `{workspace}` argument tokens;
5. bounds argument count/length, input size, output size and timeout;
6. tracks observed peak process working set;
7. kills the entire process tree on timeout/cancellation/failure;
8. requires exit code zero and a non-empty bounded output stem;
9. lets the pinned transcription path consume the stem before cleanup;
10. always attempts to remove the temporary workspace afterward.

The returned `AudioSourceSeparationCandidateRun` plugs directly into Phase 27, so quality is still recomputed against the same ground truth and the Phase 26 adoption policy remains authoritative.

## Fail-closed rules

No candidate evidence is produced when paths are relative/missing, input or output exceeds configured bounds, the output token is absent, argument limits are exceeded, timeout/cancellation occurs, the process exits non-zero, or the expected stem is missing/empty/oversized.

The adapter does not search PATH for a separator, download tools/models, invoke a shell on behalf of the caller, or mutate production transcription/playback state.

## Architectural boundary

This is not a production source-separation integration. `RobloxPiano.exe` keeps the existing NAudio -> Spotify Basic Pitch ONNX/ONNX Runtime -> deterministic post-processing/arrangement -> canonical `PerformanceTrack` path.

No Roblox input, focus, scheduler, Legacy or Legacy x2 behavior changes. No client SemVer bump is required for this engineering-only phase.

## Consequences

- A real native separator candidate can now be benchmarked through a bounded, cancellable process boundary.
- Process timing and peak working-set evidence come from the actual candidate run rather than hand-entered data.
- Temp-file and runaway-process failure classes are bounded before any production adoption decision.
- Production package size remains unchanged until a future corpus result explicitly satisfies the Phase 26 `Adopt` gate and a separate reviewed integration phase is approved.
