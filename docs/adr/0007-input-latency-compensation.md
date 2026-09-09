# ADR 0007: Input latency compensation stays outside canonical score truth

## Status
Accepted

## Context

Roblox input is not observed at exactly the instant the Windows client calls `SendInput`. Client scheduling, OS dispatch and game processing can make otherwise-correct canonical notes feel consistently late. Hard-coding earlier note timestamps into parsed sheets would corrupt music truth and make the same sheet behave differently by machine.

## Decision

`PerformanceTrack` and `PlaybackPlanner` remain canonical and uncalibrated. A bounded `PlaybackTimingProfile.DispatchLead` is applied only by the existing `PlaybackKernel` when converting canonical edge time into physical dispatch time.

- `0 ms` is the neutral/default profile and preserves Legacy timing.
- Client calibration is persisted locally, never in the sheet.
- Dispatch lead is bounded to 0–250 ms.
- Interactive transport carries one immutable profile for a playback session.
- Changing calibration is disabled while a session is active; the next session receives the new profile.
- Seek, focus pause, speed changes, held-key reference counting and release-all continue to use the same kernel and canonical timeline.
- Quality-plan fingerprints remain based on canonical playback plans, not local calibration values.

## Consequences

A user can compensate for a repeatable late-feeling Roblox/client path without modifying a song. The value still requires real-client calibration; CI can prove timing math, bounds, safety and baseline neutrality but cannot infer the correct latency for a particular machine/game/network session.

No second scheduler, AI dependency or network calibration service is introduced.
