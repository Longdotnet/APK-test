# ADR 0034: Persistent playback-session diagnostics

## Status

Accepted for production Phase 29.

## Context

Phase 28 introduced a typed `PlaybackSessionResult` contract so WinForms no longer used exceptions as its playback state machine. The client still wrote most field evidence as human-readable log lines, which made real Roblox failures hard to compare across sessions and difficult to consume deterministically in tests or later tooling.

A production client needs a durable, bounded, machine-readable record for each attempted playback outcome without adding a network dependency, telemetry service, account, AI requirement, or developer runtime dependency.

## Decision

Every typed playback outcome is persisted locally as one JSON object per line under the existing `%LOCALAPPDATA%/RobloxPiano/logs` diagnostics directory.

Session files use the form `sessions-YYYYMMDD.jsonl` and schema version `1`. A record contains:

- unique session id and UTC start/end timestamps;
- typed result kind and final playback position;
- authorization failure kind when applicable;
- selected source path and deterministic source type classification;
- preferred playback speed and input-latency setting;
- authorized Roblox PID plus process-start identity when available;
- exception type/message for technical diagnosis;
- client assembly version.

`PlaybackSessionResultCapture` owns persistence for completed, cancelled, authorization-lost, input-failed and runtime-failed sessions. `PlaybackSessionResult.SourceFailure` persists deterministic source-load failures before an active transport exists.

Persistence is best-effort and fail-safe: inability to write diagnostics must never fail or alter playback outcome. Session diagnostics retain at most the newest 30 daily JSONL files.

## Invariants

- Structured diagnostics are local-only and require no network, AI, account, SDK or service.
- Diagnostics never become playback truth or authorization state.
- Roblox process identity remains PID plus process start time; stale process trust is not introduced by persistence.
- A diagnostics I/O failure cannot break playback, cancellation, authorization recovery or release-all safety.
- Legacy and Legacy x2 behavior, canonical timeline semantics and importer behavior remain unchanged.
- JSONL is append-only within a daily file so a partial last record cannot corrupt earlier session evidence.

## Validation

`RobloxPiano.AppRecoveryTests` verifies schema/context mapping, MIDI/MusicXML source classification, process-lifetime evidence, exception preservation, UTC normalization, JSONL multi-record round-trip, and rejection of impossible session timestamps. Existing production gates continue to validate the typed session outcomes, transport cleanup, held-input safety, input ABI, source importers, self-contained Windows publish and release artifact contract.
