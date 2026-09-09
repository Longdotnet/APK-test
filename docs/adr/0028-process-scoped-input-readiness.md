# ADR 0028: Process-scoped Roblox input readiness

## Status
Accepted for Roblox Piano v0.18.1.

## Context

The v0.18.0 GUI field check correctly distinguishes Windows delivery from actual Roblox consumption, but its verdict was transient dialog text. Reopening the check provided no indication whether the currently running Roblox process had already been confirmed, and a previous success could not be represented safely without risking stale trust after Roblox restarted.

Roblox input acceptance is runtime/environment specific. A result from one Roblox process must never silently authorize another process, even when the process name or window title is identical.

## Decision

Roblox Piano maintains an in-memory input-readiness snapshot scoped to the tested Roblox PID.

- Every completed GUI input check records its deterministic verdict, timestamp, summary and next action.
- Confirmed observation becomes `Confirmed` only for that exact PID.
- Any failed observation or native-delivery failure becomes `Blocked` for that PID and replaces stale success.
- A different Roblox PID always reads as `Unknown`; readiness never persists across client launches or Roblox restarts.
- The Input Check dialog surfaces the current process-scoped state immediately when opened.
- No AI, network service or persisted account identity participates in readiness truth.
- The published executable input smoke verifies unknown -> confirmed, PID isolation, confirmed -> blocked replacement, and reset semantics.

## Consequences

This makes field evidence reusable within the current desktop session without converting a one-time observation into permanent trust. It also creates a deterministic state boundary that future playback preflight can consume without coupling playback to the diagnostic UI.

The current phase deliberately does not claim that CI can observe Roblox consumption. Human observation remains the final boundary, and a new Roblox process must be checked independently.
