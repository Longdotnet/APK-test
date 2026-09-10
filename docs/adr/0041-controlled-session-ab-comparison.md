# ADR 0041: Controlled session A/B comparison

## Status
Accepted

## Context

Phase 34 made live transport quality measurable and Phase 35 converted those metrics into deterministic client guidance. A support operator could identify timing degradation, input latency, focus interruption or dispatch loss, but a single degraded run still could not answer whether the problem was a durable runtime regression or a one-off environment condition.

The CLI already has engineering A/B gates, while normal Windows clients need a safe in-app comparison workflow that does not silently change playback engines, bypass Roblox authorization, or infer causality from incomparable sessions.

## Decision

Support Center compares a selected session only with the most recent older session that has the same privacy-reduced song filename, source type, preferred speed and input-latency compensation, and transport-aware quality evidence.

Comparison outcomes are deterministic:

- `NotComparable`: no older run has equivalent settings.
- `StableHealthy`: both controlled runs are healthy.
- `Improved`: current evidence is healthy while the baseline was degraded.
- `Regressed`: current evidence degraded from a healthy baseline, or both are degraded with a material timing/input delta.
- `StableDegraded`: both runs reproduce degradation without a material delta.
- `Interfered`: either run contains focus interruption, unexpected missing dispatches or playback failures.

Interfered runs are explicitly forbidden from being used to promote or condemn a playback engine. Focus safety and dispatch completeness outrank timing comparisons.

Initial material-delta thresholds are 3 ms for p95 scheduler timing and 3 ms for maximum input-call duration. These thresholds classify support evidence only; they are not engine-promotion thresholds.

## Client behavior

Support Center adds an `A/B` column. Selecting a session shows:

- the deterministic comparison verdict;
- the baseline session ID;
- p95 scheduler timing delta;
- maximum Windows input-call delta;
- guidance that separates scheduler regression from environment/input regression;
- a controlled reproduction recipe when no compatible baseline exists.

A normal client can therefore play the same song/settings twice and obtain a repeatability signal without command-line tooling.

## Boundaries

- No comparison action starts playback, changes speed, changes input latency or switches engines.
- Roblox verification and process-lifetime authorization remain mandatory for every actual playback.
- Raw transport metrics remain the evidence source of truth; comparison is derived support interpretation.
- AI, network availability and quota do not participate.
- Legacy and Legacy x2 remain separate perceptual/regression baselines. This session comparison must never automatically promote a newer engine.
- Privacy-safe support bundles still exclude full source paths and raw key-by-key timing samples.

## Known limitation

Current privacy-reduced sessions identify the song by filename plus source type, not a historical content fingerprint. Therefore the policy describes the pair as a same-settings support comparison rather than proof that two differently edited files with the same name are byte-identical. A future diagnostic schema may add a privacy-safe content fingerprint to strengthen cross-run identity.

## Regression requirements

Production validation must prove at least:

1. a session without an equivalent older run is `NotComparable` and receives a reproduction recipe;
2. healthy-to-timing-degraded evidence is `Regressed` and points to scheduler investigation;
3. Windows input-call regression is distinguished from scheduler regression;
4. focus/dispatch interference blocks engine conclusions;
5. speed or input-latency setting changes prevent accidental comparison.
