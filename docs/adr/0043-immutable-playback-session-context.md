# ADR 0043: Immutable playback-session canonical identity

## Status
Accepted

## Context

Phase 37 introduced a privacy-safe canonical `PerformanceTrack` fingerprint for controlled support A/B comparison. The first implementation recalculated that fingerprint from the source file while persisting the final diagnostic record. That leaves a race: another process can edit or replace the source after playback has loaded it but before the session ends, causing the stored identity to describe different content from the track that actually drove Roblox input.

A production support record must identify the exact canonical performance owned by the live transport, not mutable filesystem state observed later.

## Decision

`PlaybackTransportSession` snapshots `PerformanceTrackFingerprint.ComputeSha256(track)` once at transport construction. The transport exposes that immutable identity through its quality report. Playback-session diagnostics prefer this live transport fingerprint whenever it is available.

The source-file reload path remains only as a best-effort fallback for outcomes that never created a live transport, such as source-load failures or historical/test paths without transport evidence. It is not used to override a live session identity.

The diagnostic schema advances to version 4 because the meaning/provenance of `canonicalSourceFingerprint` is strengthened even though the privacy-safe support bundle shape remains compatible.

## Invariants

- The fingerprint for a live session represents the canonical track given to that transport at construction.
- Later source-file edits, replacements, renames, seek operations, speed changes or support-bundle generation cannot rewrite that identity.
- Canonical identity remains diagnostics/support evidence only; it is not authorization or playback truth.
- The snapshot does not require AI, network access, accounts or runtime services.
- Source bytes and full local paths remain excluded from the support bundle.
- Legacy and Legacy x2 remain independent regression/perceptual baselines.
- Focus loss still stops input; cancellation, failures and disposal still release held input safely.

## Regression requirements

Production validation must prove that:

1. transport identity is computed at construction and remains unchanged even if mutable backing track data changes later;
2. the changed canonical track would produce a different fingerprint, proving the regression fixture is meaningful;
3. session diagnostics prefer the live transport fingerprint even when the configured source path is missing or mutable;
4. existing transport seek/speed/focus quality semantics remain green;
5. existing privacy-safe support bundle, A/B comparison, release-all and authorization regressions remain green.
