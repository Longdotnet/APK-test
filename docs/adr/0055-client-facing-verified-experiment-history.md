# ADR 0055 — Client-facing verified Legacy A/B experiment history

## Status
Accepted

## Context
Phase 49 made completed Legacy A/B experiment manifests durable, bounded, privacy-safe and independently verifiable. The remaining product gap was client access: a normal Windows user could not inspect older verified experiments or re-export one exact historical manifest from Support Center without navigating diagnostics files manually.

A production support workflow must make durable evidence usable without reconstructing an old experiment from recent sessions, widening playback authority, or exposing unverified archive files.

## Decision

Support Center exposes a dedicated **Verified A/B History** browser over `PlaybackBaselineExperimentArchive.ReadVerified`.

The history surface:

- displays only manifests that pass the existing immutable manifest verifier;
- orders experiments newest-first using the archive contract;
- shows completion time, runtime verdict, measured Legacy x2 deltas, campaign id, source type and canonical fingerprint;
- exposes the exact immutable campaign/session/runtime/transport/evidence hashes in read-only details;
- lets the client export the selected verified manifest directly from the durable archive, without consulting active campaign state or recent session history;
- verifies the exported file again and requires the read-back evidence hash to equal the selected archived evidence hash;
- excludes corrupt or unverifiable archive files while preserving access to other valid experiments;
- keeps archive browsing/export failures isolated to diagnostics UX.

Support Center also surfaces the current count of verified archived experiments so the durable evidence path is discoverable.

## Playback and safety boundary

Archive browsing and export never start playback, change speed, seek, authorize Roblox, dispatch input, mutate campaign state, change engine selection, or promote Legacy x2. Playback remains deterministic and usable even when the archive is unreadable or export fails.

The archive still contains only privacy-safe support evidence. This UX does not add local sheet paths, source bytes, usernames, machine names, account identifiers or raw key-by-key timing samples.

## Verification and regression boundary

Archive regression coverage requires exact selected-manifest export to preserve campaign identity and evidence SHA-256. Export of a manifest whose evidence no longer verifies must fail closed. Existing corrupt-entry isolation and conflict/idempotency tests remain mandatory.

## Consequences

A normal client can now review historical verified Legacy A/B outcomes and share one exact completed experiment long after recent session history or the active campaign has expired. Support no longer needs to infer which historical sessions belonged to the experiment being shared.

This still does not establish perceptual equivalence. Runtime evidence remains advisory diagnostics and cannot automatically replace the protected Legacy listening baseline.
