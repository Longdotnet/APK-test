# ADR 0059: Client-facing verified reference evidence attachment

## Status

Accepted — Production Phase 54.

## Context

Phase 53 introduced a deterministic contract that can bind a verified Legacy 1.00x / Legacy x2 2.00x experiment to one exact analyzed reference WAV. That contract was programmatic only. A normal client could not attach a reference recording from Support Center, persist the resulting evidence, or re-export the exact verified record later.

The durable Legacy A/B manifest intentionally does not retain the original source path. Reintroducing full source paths into diagnostics would weaken the existing privacy boundary and could also cause a later file at the same path to be mistaken for the original experiment input.

## Decision

The Verified Legacy A/B History surface owns an explicit diagnostics-only attachment flow:

1. the client selects a previously verified archived experiment;
2. the client selects the original `.txt` or `.vps` sheet again;
3. the source type and canonical `PerformanceTrackFingerprint` must exactly match the selected immutable experiment manifest;
4. the client selects a local 16-bit PCM WAV reference;
5. WAV input is size-bounded before loading and then analyzed by the deterministic Phase 51 analyzer;
6. Phase 53 creates and verifies separate 1.00x and 2.00x alignment evidence against that same exact reference identity;
7. the evidence is atomically written, read back, verified, and placed in a diagnostics-only durable archive;
8. re-export writes the exact archived evidence and verifies its immutable evidence SHA-256 after the write.

The reference WAV bytes and selected source path are **not** copied into diagnostics. The archive stores only the already-defined privacy-safe hashes, normalized alignment measurements, and their cryptographic evidence identity.

A single `(schema version, experiment evidence SHA-256, reference content SHA-256)` archive identity is idempotent. A file with that identity but different verified contents fails closed rather than being overwritten. Corrupt/unverifiable files are ignored for normal browsing and retained for manual inspection; they must not hide independently verified evidence.

The archive is capped at 100 verified evidence records. Retention is diagnostics housekeeping only and never affects playback state.

## Safety and production boundaries

- Reference attachment does not call Play, Pause, Stop, Seek, change speed, or mutate the canonical performance.
- It never authorizes a Roblox process and never dispatches keyboard or pedal input.
- It does not declare a perceptual winner and contains no automatic engine-promotion path.
- Legacy remains the protected baseline; Legacy x2 remains comparison evidence only.
- AI and network access are not required for analysis, verification, archive, or export.
- Unsupported/malformed WAVs and mismatched source tracks fail closed as diagnostics operations while normal playback remains available.
- A 64 MiB WAV input limit bounds the current in-memory PCM16 analysis path; larger recordings must be trimmed/exported to a smaller PCM16 WAV rather than risking client memory pressure.

## Consequences

Support can now obtain reproducible reference-audio evidence from a normal self-contained client without developer tooling or external runtimes. Evidence remains separable from playback truth and can be re-exported after recent playback history has rotated.

Future phases may improve multi-reference browsing, deterministic section-level alignment, and additional locally decoded audio formats, but any format expansion must preserve exact content identity, bounded resource use, deterministic feature semantics, and the no-auto-promotion invariant.
