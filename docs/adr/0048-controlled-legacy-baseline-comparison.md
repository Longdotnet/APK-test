# ADR 0048: Controlled Legacy / Legacy x2 baseline comparison

- Status: Accepted
- Date: 2026-09-10

## Context

Roblox Piano deliberately preserves the working Legacy playback behavior and the `Legacy x2` Chắc Ai Đó Sẽ Về experiment as regression/perceptual baselines. Existing Support Center A/B evidence is intentionally same-settings and same-engine, so it rejects sessions whose start speed differs. That protects ordinary regression evidence, but it also means support cannot make a controlled runtime comparison between the protected 1x and x2 baseline configurations.

Treating `Legacy x2` as a new playback engine would be misleading: the current production engine remains `production-transport-v1`; x2 is a playback configuration over the same deterministic canonical transport. Conversely, comparing any 1x and 2x sessions merely because their filenames match would be unsafe because source contents, input profile, latency compensation, seeks, focus loss or runtime speed changes can all invalidate the experiment.

## Decision

Add a separate deterministic `PlaybackLegacyBaselineComparisonPolicy` beside the existing same-settings comparison policy. It is diagnostics-only and never participates in playback truth, input authorization, scheduling, focus safety, release-all or engine promotion.

A session is classified as a protected baseline variant only when all of these conditions hold:

1. source type is legacy `TXT` or `VPS`;
2. transport-quality evidence and a non-empty persisted control ledger exist;
3. control event zero is `SessionStarted` at canonical position zero;
4. immutable session-start `PreferredSpeed` and the first ledger speed agree;
5. both values are exactly 1.0x (Legacy) or exactly 2.0x (Legacy x2), within the existing narrow numeric tolerance.

MIDI, MusicXML, arbitrary start speeds and older/incomplete evidence classify as `None` and fail closed.

A Legacy and Legacy x2 session become controlled counterparts only when they also have:

- identical canonical `PerformanceTrack` SHA-256 fingerprints;
- identical source type;
- identical playback-engine identity;
- identical Windows input-profile identity;
- identical input-latency compensation;
- equal ordered transport-event count, sequence, kind and canonical positions;
- equal seek targets; and
- speed-bearing transport events whose x2 speed is exactly twice the corresponding Legacy speed within the existing speed tolerance.

This proportional-speed rule allows a deliberate controlled pair such as `1.0 -> 1.2` versus `2.0 -> 2.4`, while rejecting `1.0 -> 1.2` versus `2.0 -> 2.2`. It also prevents a seeked run from becoming the counterpart of an unseeked run.

The comparison reports Legacy-x2-minus-Legacy deltas for P95 absolute scheduler timing error and maximum Windows input-call latency. The deterministic verdict can be `StableHealthy`, `LegacyX2Improved`, `LegacyX2Regressed`, `StableDegraded`, `Interfered` or `NotComparable`.

Any focus pause, unexpected dispatch loss or playback failure in either side yields `Interfered`; such evidence must not promote or condemn Legacy x2.

## Perceptual boundary

This policy measures production runtime execution quality only. It does not measure whether the piano sounds better, preserves phrasing, or perceptually matches Chắc Ai Đó Sẽ Về. A healthy or improved runtime verdict can never by itself promote a new engine, parser behavior, duration model or default playback configuration.

Legacy and Legacy x2 remain protected listening/regression baselines. Perceptual acceptance is a separate gate.

## Persistence and privacy

No new sensitive session field is required. The comparison derives its variant identity from already-immutable session-start speed and the persisted privacy-safe transport ledger. Existing support evidence already contains canonical fingerprint, source type, engine/input profile, latency compensation and aggregate quality metrics.

The policy does not add full local paths, source bytes, usernames, machine identifiers or raw key-by-key timing samples to Support Bundles. Therefore support schema v5 remains valid for this phase.

## Client behavior

Support Center exposes a dedicated `Legacy A/B` verdict and detailed controlled-baseline section while retaining the existing same-settings `A/B` verdict. This separation prevents support staff from confusing a same-engine repeatability check with a protected cross-speed baseline experiment.

## Consequences

- A real Legacy ↔ Legacy x2 runtime comparison is now measurable instead of informal.
- Incomplete/old sessions fail closed rather than becoming questionable baseline evidence.
- Runtime speed changes remain comparable only when the entire history preserves the 2x relationship.
- The production engine identity remains truthful; x2 is not mislabeled as an engine.
- Playback behavior and safety paths are unchanged.
