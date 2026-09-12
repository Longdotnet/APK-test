# ADR 0111: Pin native source-separation benchmark provenance

## Status

Accepted.

## Context

Audio-to-Piano OSS Phase 29 made the engineering harness compatible with the real six-source `demucs.cpp` CLI and its `target_5_piano.wav` output. That was necessary but not sufficient for a trustworthy adoption decision: a benchmark could still be described as using one demucs.cpp build, model, or lawful corpus while different bytes were actually present on disk.

Source separation remains optional. It must not enter the production client until measured quality gains justify its package, memory, and runtime cost.

## Decision

Before a demucs.cpp benchmark result is accepted as adoption evidence, engineering tooling must pin and verify:

- the full 40-character upstream demucs.cpp commit identity;
- SHA-256 of the exact separator executable;
- SHA-256 of the exact six-source model;
- a stable unique case name and SHA-256 for every locally supplied benchmark audio file.

`DemucsCppBenchmarkProvenance.Verify` hashes the actual local files and fails closed on any mismatch. The verified identity is a deterministic SHA-256 over commit, executable hash, model hash, and corpus case hashes. Local absolute paths are intentionally excluded from that identity so the same bytes produce the same benchmark identity on different machines. Corpus entries are sorted by stable case name before identity hashing so ordering cannot change the identity.

The verifier performs no downloading, PATH discovery, media acquisition, model conversion, or source redistribution. The caller remains responsible for lawful access to all benchmark audio and external artifacts.

## Consequences

A Phase 26 `Adopt`, `Review`, or `Reject` result can be tied to reproducible artifact bytes instead of mutable filenames. Replacing a binary, model, or corpus file after pins are recorded invalidates the benchmark before transcription begins.

This phase adds only engineering evaluation infrastructure. It does not add Demucs, Python, PyTorch, ffmpeg, a model, or any new production runtime dependency to `RobloxPiano.exe`, and it does not modify canonical `PerformanceTrack` or Roblox input/playback behavior.

## Next step

Run a lawful paired corpus with a verified demucs.cpp build/model identity, feed the selected piano stem through the pinned Basic Pitch path, then publish the measured F1/resource result together with this provenance identity. Source separation is eligible for production design only if the existing adoption gate returns `Adopt` from that measured run.
