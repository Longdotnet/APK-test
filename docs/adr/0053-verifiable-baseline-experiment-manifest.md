# ADR 0053: Verifiable completed Legacy A/B experiment manifest

## Status
Accepted — Production Phase 48.

## Context

The guided Legacy A/B campaign state machine can prove the ordered `Legacy 1.00x -> Legacy x2 2.00x` progression while the campaign is active, but support export still lacks a compact immutable artifact that identifies the exact completed pair and its runtime verdict. Reconstructing that outcome later from nearby session history risks ambiguity once more sessions are recorded.

## Decision

A completed explicit Legacy A/B campaign may emit a privacy-safe experiment manifest beside the verified support ZIP when the user exports support evidence.

The manifest records only evidence required to reproduce/verify the controlled experiment:

- explicit campaign GUID;
- campaign creation/completion UTC timestamps;
- canonical performance SHA-256 fingerprint;
- TXT/VPS source type;
- input-latency compensation, playback-engine identity and Windows input profile;
- exact Legacy and Legacy x2 session IDs from the same campaign;
- deterministic runtime verdict and measured x2-minus-Legacy deltas;
- SHA-256 of the normalized pair transport histories;
- SHA-256 over all immutable manifest evidence fields.

It deliberately excludes full source paths, source bytes, usernames, machine names, raw key samples and account identifiers.

## Fail-closed rules

A manifest is produced only when all of the following are true:

1. an explicit campaign is still valid and evaluates to `Completed`;
2. both accepted session IDs remain available in recent structured diagnostics;
3. both sessions still match the campaign canonical/runtime identity;
4. the Legacy x2 session still compares against the exact locked Legacy session;
5. the transport histories still satisfy the controlled proportional-speed/identical-seek policy;
6. the runtime comparison is not `NotComparable`.

The export is written through a temporary file, read back, verified and atomically moved into place. Verification checks campaign/session provenance and recomputes the manifest evidence hash. A stale sidecar is removed when no completed campaign exists.

## Playback boundary

Experiment-manifest generation is diagnostics-only. Failure to create, serialize, verify or copy the sidecar is logged but does not invalidate the primary verified support ZIP and cannot mutate scheduler state, Roblox authorization, focus guard, input dispatch, held-key/pedal ownership, transport controls or Legacy default behavior.

The runtime verdict remains diagnostic evidence only. It cannot auto-promote Legacy x2 or override the protected perceptual baseline.

## Client export contract

For a support bundle selected as:

`RobloxPiano-support.zip`

an available completed experiment is exported as:

`RobloxPiano-support.zip.legacy-ab.json`

This sidecar is intentionally independent from the current three-entry support ZIP schema, preserving backward compatibility of existing support-bundle verification while providing durable explicit experiment provenance.
