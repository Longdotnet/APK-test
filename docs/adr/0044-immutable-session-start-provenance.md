# ADR 0044 — Immutable playback session-start provenance

## Status

Accepted for Production Phase 39.

## Context

Phase 38 made the canonical `PerformanceTrack` fingerprint immutable by snapshotting it inside the live transport. Other support/A-B fields were still read from mutable/global client state when the result was persisted at the end of a run. A user can change playback speed during a session, client state can be rewritten, and Roblox process authorization can change. End-of-run reads can therefore describe a different configuration from the one that launched the session.

That is dangerous for controlled comparisons because a diagnostic record may appear comparable even though its settings/process provenance drifted during playback.

## Decision

A live playback session captures a `PlaybackSessionProvenanceSnapshot` immediately when `PlaybackSessionResultCapture.RunAsync` begins. The snapshot contains:

- the current `ClientState` (selected source, preferred speed, input-latency compensation),
- authorized Roblox PID,
- authorized Roblox process-start identity,
- playback engine identity,
- Windows input-profile identity.

The snapshot is immutable and diagnostics-only. Result persistence uses this snapshot together with the transport-owned final quality report. The canonical fingerprint remains owned by the live transport quality report from Phase 38.

If provenance capture fails, playback must continue. Diagnostics fall back to the previous best-effort persistence path rather than becoming a runtime dependency.

Support bundle refresh, hash verification and bounded session-file retention remain part of the captured persistence path.

## Consequences

- End-of-run preference/process changes can no longer rewrite the provenance of a session that already started.
- Future selectable playback engines/input profiles have an explicit session-start boundary instead of relying on mutable global identity.
- Support/A-B evidence remains observational and cannot authorize input, schedule notes or mutate playback truth.
- Dynamic speed changes inside a session still need explicit transport-segment identity before cross-engine promotion can treat such sessions as controlled; this ADR does not claim otherwise.

## Regression contract

Production validation must prove that a record created from a start snapshot preserves its speed, latency, Roblox process lifetime, engine/profile identity and canonical transport fingerprint exactly.
