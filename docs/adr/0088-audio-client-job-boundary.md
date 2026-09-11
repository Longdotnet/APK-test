# ADR 0088: Audio-to-Piano client job boundary

## Status

Accepted.

## Context

The Audio-to-Piano pipeline already owns deterministic ingest, Basic Pitch ONNX inference, note decoding, harmonic suppression, Roblox arrangement, readiness classification, bounded progress and cancellation. Production packaging now embeds the pinned model/runtime. The next client-facing step needs a safe long-running job contract before WinForms controls are allowed to orchestrate the pipeline directly.

A UI must not duplicate transcription truth, silently add a failed/low-confidence result to the library, or leave an inference task running after the client presses Cancel. It also must not cross into Roblox Runtime Input ownership.

## Decision

Add `AudioToPianoClientJob` as the production execution boundary for `Create Piano Version`.

The job:

- permits only one active creation per instance;
- validates and canonicalizes the selected local file path;
- materializes the pinned Basic Pitch model from the production bundle;
- runs the existing `AudioToPianoTranscriptionService` off the UI thread;
- forwards only monotonic progress from the deterministic transcription contract;
- exposes explicit `Idle`, `Running`, `Completed`, `Cancelled`, and `Failed` state;
- returns the canonical transcription result unchanged on success;
- makes cancellation/failure terminal and never treats either as a generated track;
- does not preview, persist, schedule, focus Roblox, or inject input.

`PerformanceTrack` inside the transcription result remains authoritative. A later WinForms slice may preview and explicitly add a completed result to the library, but it must not mutate note truth based on UI state.

## Consequences

The client can wire progress/cancel without inventing timing estimates or duplicating model lifecycle code. Cancellation remains cooperative at the managed boundaries already exposed by Audio-to-Piano/ONNX Runtime. The UI still needs a separate explicit review/persist step, and this ADR does not claim Roblox playback works end-to-end while Runtime Input P0 remains field-unproven.
