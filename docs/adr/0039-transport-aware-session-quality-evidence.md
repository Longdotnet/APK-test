# ADR 0039 — Transport-aware session quality evidence

## Status

Accepted for production client v0.23.0.

## Context

Roblox Piano already had deterministic playback-quality instrumentation for fixed canonical runs, plus persistent playback-session diagnostics and a privacy-safe Support Center. The live desktop player, however, uses `PlaybackTransportSession`: clients can seek, pause on focus loss, stop, and change speed while a song is running.

Applying a fixed-run quality collector directly to the whole interactive session would create false evidence. A seek intentionally cancels the current canonical slice and skips planned edges; those edges must not be reported as scheduler loss. Runtime speed changes also must not invalidate timing measurements.

## Decision

Live playback quality is measured at canonical transport-slice boundaries while retaining one aggregate session view.

1. Every transport slice is instrumented through the existing `PlaybackInstrumentation` boundary. The scheduler remains `PlaybackKernel`; no second playback engine or UI-owned timing path is introduced.
2. `PlaybackSessionClock` remains the observation clock. Because it is the monotonic logical playback-time domain, changing speed changes wall-time consumption without changing canonical timing error semantics.
3. Each seek starts a new quality segment. Missing edges from a segment ending in `Seeked`, `Cancelled`, or `Failed` are recorded as **interrupted edges**, not **unexpected missing edges**.
4. Only a segment that reaches its canonical end may contribute unexpected missing edges. This keeps intentional client transport actions distinct from true dispatch loss.
5. Aggregate session evidence includes dispatched edges, unexpected/interrupted edge counts, failures, focus pause count/duration, release-all count, mean/p95/max timing error, and mean/max input-call latency.
6. Structured session diagnostics and `support.json` persist aggregate numeric evidence. Support Center displays the evidence directly to the client.
7. Raw key-by-key timing samples and full local source paths are not added to the support bundle. The existing manifest/hash verification and privacy boundary remain mandatory.
8. Quality collection is observational only. Observer/diagnostic failure must never become playback truth, authorization state, or a reason to skip release-all.

## Consequences

- A support report can distinguish “song completed but timing was poor” from “playback failed” and from “the user intentionally sought past part of the score.”
- Dynamic speed changes remain measurable without pretending the entire session used one fixed speed.
- Focus interruption and Windows input-call latency become support-visible evidence rather than text-log guesses.
- Legacy and Legacy x2 regression baselines are unchanged. This ADR adds observability; it does not promote a new playback engine.

## Production gates

Regression coverage must prove that:

- a seek creates separate segments and does not create unexpected missing-edge regressions;
- dynamic speed changes retain finite timing/input-call evidence and complete the canonical plan;
- numeric quality evidence survives structured diagnostics → privacy-safe support projection;
- support bundles continue to exclude raw logs, full local source paths, usernames, machine names, and raw per-key timing samples.
