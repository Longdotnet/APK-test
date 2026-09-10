# ADR 0054 — Durable Legacy A/B experiment archive

## Status
Accepted

## Context
Phase 48 produced a verified completed Legacy A/B experiment manifest, but that manifest was derived from the active 30-minute campaign and recent-session window. Once active campaign state expired or recent JSONL evidence rolled out, a previously completed experiment could no longer be recovered without an exported sidecar retained elsewhere.

A production support workflow needs completed experiments to survive later campaigns and recent-session rotation without widening playback authority or retaining private source data.

## Decision

Completed explicit Legacy A/B campaigns are archived automatically after the completing session has been persisted and the latest support bundle has been verified.

The archive stores only already-verified `PlaybackBaselineExperimentManifest` documents under the client diagnostics directory. Archive evidence remains diagnostics-only and never owns playback, Roblox authorization, input dispatch, transport mutation, engine selection, or Legacy x2 promotion.

Archive requirements:

- verification is mandatory before first write and again when reading;
- archive identity is the immutable completion timestamp plus campaign id;
- writing the same verified campaign evidence is idempotent;
- an existing archive entry for the same identity may never be overwritten by different evidence;
- unreadable or unverifiable entries fail closed and are ignored by normal archive reads while being retained for manual inspection;
- valid archive reads are ordered newest-first;
- retention is bounded to the newest 50 verified completed experiments;
- retention never deletes an entry that cannot itself be verified;
- archive persistence failures are logged but cannot turn a completed playback session into a playback failure.

## Privacy boundary

The archive contains the same privacy-safe fields as the Phase 48 manifest: opaque campaign/session ids, canonical fingerprint, source type, runtime/input identity, latency compensation, aggregate verdict/deltas, transport-equivalence hash, and evidence hash. It does not add local source paths, source bytes, usernames, machine names, account ids, or raw key-by-key samples.

## Consequences

Completed reproduction evidence now survives active-campaign expiry, cancellation of later campaigns, and recent session-file rotation. Support/UI work can enumerate or re-export verified historical experiments without reconstructing them from current campaign state.

The archive is not a perceptual-quality decision store. Runtime evidence still cannot automatically promote Legacy x2 or replace the protected listening baseline.
