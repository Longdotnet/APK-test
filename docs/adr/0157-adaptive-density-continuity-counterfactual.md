# ADR 0157: Adaptive-density continuity counterfactual A/B

## Status

Accepted for Audio-to-Piano OSS Phase 68.

## Context

Phase 65 proved that cross-section harmony continuity was dormant on the pinned Spotify Basic Pitch repeated-progression corpus. Phase 66 showed that lowering only `HarmonyContinuityRelativeActivationFloor` from `0.90` to `0.75` still produced zero continuity selections. Phase 67 then traced the real-model candidates and found adaptive density was the dominant pre-selector blocker: prior-harmony candidates were being removed before continuity ranking could consider them.

The production adaptive-density policy is intentionally conservative: accompaniment survives only when its activation is at least `max(0.18, strongest accompaniment * 0.35)`. Weak mixed-audio clutter must not be reintroduced merely to make a continuity heuristic active.

## Decision

Run Spotify Basic Pitch exactly once over the existing redistributable repeated-progression mixed-audio fixture. Reuse the exact decoded note evidence for production (`0.35`) and bounded test-only adaptive-density relative floors `0.30`, `0.25`, and `0.20` while keeping the absolute `0.18` floor, harmony-continuity policy, playable range, density cap, and all other arranger settings unchanged.

For every candidate report:

- actual `HarmonyContinuitySelections`;
- adaptive-density drop count;
- recognized melody and harmony retention;
- global harmony delta versus production;
- per-section harmony wins and losses;
- clutter-suppression delta;
- false-positive and event-retention guards.

A candidate is a promotion candidate only when it actually exercises harmony continuity, improves global or section harmony, loses no recognized melody or section harmony, adds no unmatched playback events, does not expand the arranged event count beyond source evidence, and keeps clutter suppression within `0.02` of production. Ties prefer the stricter/higher adaptive-density floor.

This phase is an evidence gate, not an automatic production policy change. If no bounded candidate earns promotion, production remains at `0.35`. If a candidate earns promotion, a separate client-facing change must still add deterministic unit coverage, bump SemVer, pass exact-head/exact-main production gates, and publish a verified immutable release before the new policy reaches clients.

## OSS and packaging impact

Spotify Basic Pitch remains the AMT model/semantics source and Microsoft ONNX Runtime remains the native inference runtime. NAudio and DryWetMIDI boundaries are unchanged. No upstream implementation is copied and no Python, PyTorch, ffmpeg, Demucs model/runtime, NuGet package, or native dependency is added. There is no new license or NOTICE obligation and no client package/runtime cost from this evidence-only phase.

## Authority boundary

`RobloxPiano.Core.PerformanceTrack` remains authoritative. The counterfactual only observes pinned-model decoded notes and canonical arranger output. It does not modify scheduler, focus guard, input authorization, held-key/pedal ownership, Legacy baselines, or Runtime Input P0.