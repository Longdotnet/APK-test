# ADR 0058: Verified reference-audio experiment evidence

## Status

Accepted

## Context

Phases 48-50 made completed Legacy 1x / Legacy x2 campaigns immutable, verifiable and durable. Phases 51-52 added deterministic WAV analysis and reference-to-canonical-timeline alignment. Those two evidence families were still independent, so a support workflow could not prove that two alignment records belonged to the same completed A/B experiment and the same exact reference recording.

A production comparison must also avoid turning diagnostic measurements into playback truth. In particular, better coverage, lower residual error, or a closer tempo ratio must never silently make Legacy x2 the default.

## Decision

Add `PlaybackReferenceAudioExperimentEvidence` as an application diagnostics contract over the existing immutable experiment manifest and Core reference-audio alignment records.

Evidence creation MUST:

1. require the Legacy A/B experiment manifest to verify;
2. require normalized reference-audio feature evidence to verify;
3. require the exact canonical track fingerprint to equal the experiment fingerprint;
4. align that same reference/track pair at protected speeds 1.00x and 2.00x;
5. preserve each nested alignment evidence hash;
6. expose x2-minus-Legacy measurement deltas for match coverage, P95 residual timing error and absolute distance from tempo ratio 1.0;
7. hash experiment identity, reference identities, nested alignment identities and derived deltas into a separate SHA-256.

Verification MUST fail closed for malformed hashes, invalid nested alignment evidence, mixed reference identities, mixed canonical fingerprints, non-protected playback speeds, inconsistent derived deltas, or a changed outer evidence hash.

The contract MUST NOT contain a winner, preferred engine, promotion flag, playback command, Roblox authorization decision, or input-dispatch instruction.

`ReferenceAudioEvidenceVerification` reproduces the normalized feature hash from a `ReferenceAudioAnalysis` record. The original WAV content hash remains an identity of the bytes observed at analysis time; re-deriving that content hash requires the bytes themselves and is intentionally a separate concern.

## Consequences

Support tooling can now prove that Legacy and Legacy x2 reference measurements share one completed experiment, one canonical performance, and one reference-audio identity. Measurements can be archived or exported later without weakening deterministic provenance.

The first version remains an evidence API rather than a client-facing WAV attachment workflow. A later slice may add Support Center selection/export UX, but that UI must consume this contract rather than recompute its own truth.

No existing scheduler, transport, focus guard, held-key/pedal ownership, emergency release-all, importer or playback-engine selection behavior changes under this ADR.
