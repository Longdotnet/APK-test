# ADR 0114: Bind source-separation measurements to verified artifacts

## Status

Accepted.

## Context

Audio-to-Piano OSS Phase 30 pinned the exact demucs.cpp commit, executable hash, six-source model hash, and lawful corpus hashes before engineering source-separation evidence could be trusted. That closes accidental attribution to mutable filenames, but a remaining time-of-check/time-of-use gap exists if an executable, model, or corpus file changes after the initial verification while the benchmark is still running.

A source-separation adoption decision must describe the exact bytes that actually participated in the paired measurement. Source separation remains optional and must not enter the production client without measured quality gains that justify package, memory, and runtime cost.

## Decision

Add `DemucsCppVerifiedBenchmarkRunner` as the engineering execution envelope around the existing Phase 27 paired benchmark runner and Phase 30 provenance verifier.

The envelope:

1. validates stable case identities, durations, and ground-truth notes;
2. verifies the full demucs.cpp commit identity plus exact executable/model/corpus SHA-256 pins before transcription starts;
3. binds each direct-transcription delegate to the same pinned corpus path used by the separation candidate;
4. requires candidate `AddedBundleBytes` to equal the deterministic executable + model + explicitly declared runtime-byte accounting from the verified profile;
5. runs the existing direct-vs-candidate quality/resource evaluator and adoption gate without changing their thresholds;
6. repeats full provenance verification after all measurement work and rejects the entire benchmark if any pinned artifact or corpus file drifted during execution.

`RunNativeAsync` connects the envelope to the existing bounded `NativeSeparatorProcessAdapter`; `RunMeasuredAsync` preserves the same provenance/resource invariants for deterministic regression fixtures and other engineering adapters.

The post-run hash check is intentionally a fail-closed drift detector rather than a security boundary against a malicious actor capable of replacing and restoring bytes between checks. The benchmark tooling is engineering infrastructure, not an adversarial sandbox.

## Consequences

An `Adopt`, `Review`, or `Reject` assessment can now be returned together with a provenance identity whose pinned files were valid both before and after the measured run. Corpus/model/executable drift invalidates the measurement instead of silently producing stale evidence. Bundle accounting also cannot be supplied by a candidate delegate independently of the verified demucs.cpp profile.

This phase does not download or redistribute demucs.cpp, Demucs models, media, Python, PyTorch, or ffmpeg. It does not alter `PerformanceTrack`, Basic Pitch production semantics, Roblox scheduling, focus/input authorization, Legacy playback, or the Runtime Input P0 field gate.

## Next step

Supply an owned/licensed multi-song corpus and an exact locally built/pinned demucs.cpp six-source executable/model, then run `RunNativeAsync` with the pinned Basic Pitch direct/stem transcribers. Publish the measured F1 deltas, per-song regressions, peak working set, processing factor, bundle delta, and provenance identity. Production source-separation design remains blocked unless the existing adoption gate returns `Adopt` from that real measured corpus.
