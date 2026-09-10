# ADR 0056: Deterministic reference-audio analysis boundary

## Status

Accepted for Production Phase 51.

## Context

Runtime timing and Legacy/Legacy x2 experiment evidence can prove scheduler/input behavior, but they cannot prove whether a performance aligns with a reference recording. Adding reference audio directly into playback or relying on cloud/AI analysis would violate the product invariant that deterministic local state owns playback truth.

## Decision

Introduce a dependency-free `ReferenceAudioAnalyzer` in `RobloxPiano.Core` as an evidence-only boundary.

The first production contract deliberately supports uncompressed 16-bit PCM RIFF/WAVE only. Malformed RIFF/WAVE structure, unsupported encodings, unsupported bit depths, invalid block alignment, impossible sample rates, and incomplete sample frames fail closed with explicit exceptions. The analyzer never guesses, transcodes, downloads codecs, calls a network service, or invokes AI.

For accepted WAV input the analyzer:

- hashes the exact input bytes with SHA-256;
- decodes channels deterministically to a mono analysis stream;
- measures duration, RMS and peak level;
- builds a fixed 10 ms RMS envelope;
- derives positive spectral-free energy novelty from that envelope;
- detects deterministic local-maximum onsets using a fixed adaptive threshold and 50 ms refractory period;
- estimates tempo by autocorrelation within the bounded 60-200 BPM range;
- emits a second SHA-256 over the normalized feature record.

`ReferenceAudioAnalysis.SchemaVersion` is explicit. Any future change to feature semantics must increment the schema rather than silently reinterpret old evidence.

## Safety and ownership boundaries

Reference-audio analysis is diagnostics/evidence only. It MUST NOT:

- start, pause, seek or stop playback;
- authorize Roblox or dispatch keyboard input;
- mutate canonical performance events;
- alter Legacy/Legacy x2 defaults;
- auto-promote a playback engine or speed variant;
- call AI, network services, external codecs or developer runtimes.

A reference-audio result may later be attached to a verified experiment manifest only through a separate, explicit provenance contract. Content identity and feature identity must remain visible so a different reference file cannot be substituted silently.

## Consequences

The production codebase now has a deterministic local MIR foundation suitable for later onset/beat/alignment comparison without coupling audio parsing to playback. Initial format support is intentionally narrow; MP3/AAC/float WAV and full perceptual equivalence are future work and must remain explicit unsupported states until deterministic handling and regression coverage exist.
