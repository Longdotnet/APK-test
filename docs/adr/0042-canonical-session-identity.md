# ADR 0042: Canonical playback-session identity

## Status
Accepted

## Context

Phase 36 added controlled same-settings A/B comparison, but historical sessions identified a song by privacy-reduced filename plus source type. Two different files could therefore share a filename and be compared accidentally, while a harmless rename could prevent comparison. The support workflow also did not persist which production playback engine/input profile generated an observation.

A production support verdict must fail closed unless both observations prove that the same canonical performance and runtime boundary produced the measurements.

## Decision

Each new playback-session diagnostic records three privacy-safe identity fields:

1. `canonicalSourceFingerprint`: SHA-256 over a versioned deterministic serialization of the canonical `PerformanceTrack` used by playback. The fingerprint excludes file path, source bytes and title. Event ordering and chord-key ordering are normalized before hashing; timing/duration mutation changes the fingerprint.
2. `playbackEngine`: stable identifier for the production transport engine contract.
3. `inputProfile`: stable identifier for the Windows/Roblox input-dispatch profile.

The fingerprint is captured from the deterministic importer boundary at session persistence time. Fingerprint generation is diagnostics-only and best-effort: an unavailable or malformed source yields no fingerprint and must never alter playback outcome, release-all, focus safety or authorization.

Support bundles may contain the SHA-256 fingerprint and runtime identifiers because they reveal playback identity without carrying full local paths or source contents.

## Controlled A/B policy

Two sessions are comparable only when all of the following match:

- canonical performance fingerprint;
- source type;
- playback engine identity;
- input profile identity;
- preferred speed within the existing tolerance;
- input-latency compensation;
- transport-aware quality evidence is present.

A missing fingerprint or runtime identity makes the session `NotComparable`. Historical sessions created before this contract therefore cannot silently become baselines.

Filename is presentation metadata only. Renaming an otherwise identical canonical performance does not break comparison; editing a same-named song so that its canonical timing/notes change prevents comparison.

## Boundaries

- Fingerprints are support evidence, not authorization or playback truth.
- Source files are never uploaded or embedded in diagnostics/support bundles.
- AI/network/quota are not involved.
- This contract does not switch engines or automatically replay a session.
- Legacy and Legacy x2 remain separate perceptual/regression baselines and cannot be promoted or replaced by this support A/B verdict.
- Roblox process-lifetime authorization, focus guard, emergency release-all and held-key ownership remain unchanged.

## Regression requirements

Production validation must prove at least:

1. deterministic canonical fingerprint stability under title/file rename, event-list ordering and chord-key ordering;
2. a playback timing/duration mutation changes the canonical fingerprint;
3. same filename with different fingerprints is not comparable;
4. different filenames with the same fingerprint are comparable when all runtime/settings evidence matches;
5. playback-engine or input-profile mismatch prevents comparison;
6. existing focus/dispatch interference still blocks engine conclusions;
7. support output contains only privacy-safe identity, never full path/source bytes.
