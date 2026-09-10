# ADR 0046: Persist transport history and fail closed for controlled A/B

## Status

Accepted for Production Phase 41.

## Context

Phase 40 made live playback transport controls observable through an append-only `PlaybackTransportControlEvent` ledger. The transport-owned quality report records the session-start position/speed, runtime speed transitions, and seek targets in canonical timeline space.

That evidence previously stopped at the Core quality report. Persistent session diagnostics and the privacy-safe Support Bundle retained aggregate quality metrics but dropped the control ledger. As a result, two runs with the same canonical track fingerprint, engine/profile, start speed and latency compensation could still be selected as a controlled A/B pair even when one run sought or changed speed during playback and the other did not.

Such a comparison is not controlled evidence and could falsely promote or condemn runtime quality.

## Decision

1. `PlaybackSessionQualityDiagnostic` persists the ordered transport-control ledger from the live `PlaybackTransportQualityReport`.
2. The session JSONL and Support Bundle schema advance to version 5. Existing schema versions remain readable through optional ledger fields, but sessions without a persisted ledger are not eligible as controlled A/B baselines.
3. Support projection carries only the existing privacy-safe control fields: sequence, control kind, canonical position in seconds, and optional speed. It does not include source paths, source bytes, raw key-by-key timing, usernames, machine names, account identifiers, or UI state.
4. Controlled same-engine A/B requires equivalent ordered transport histories in addition to canonical track fingerprint, source type, playback engine, input profile, start speed and input-latency compensation.
5. Event count, order and kind must match. Canonical positions and speeds use tight numeric tolerances only to tolerate harmless serialization/representation differences. Missing or empty ledger data fails closed.
6. Transport history is observational evidence only. It cannot authorize playback, mutate transport state, schedule input, alter focus handling, suppress release-all, or change playback truth.
7. Legacy and Legacy x2 remain separate regression/perceptual baselines. This support comparison policy does not promote a new engine by itself.

## Consequences

- A run that seeks or changes speed can no longer be silently compared with a straight-through run.
- Older diagnostics remain viewable and sendable but deliberately cannot become controlled A/B baselines without transport evidence.
- Support bundles now contain enough privacy-safe evidence to explain why two otherwise similar runs are not comparable.
- The next engine-variant reproduction workflow can build on canonical track identity plus immutable start provenance plus equivalent transport histories rather than filename/settings guesses.

## Validation

Production gates must cover at least:

- speed-history mismatch => `NotComparable`;
- seek-history mismatch => `NotComparable`;
- missing legacy ledger => `NotComparable`;
- identical ordered ledger remains comparable;
- ledger survives diagnostic and support projection;
- support bundle still excludes full source paths and machine/user identity;
- existing Legacy/Legacy x2, focus safety, held-input ownership, release-all, transport, timing, import, clean-machine and self-contained-release gates remain green.
