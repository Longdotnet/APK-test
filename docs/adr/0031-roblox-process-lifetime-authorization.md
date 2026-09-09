# ADR 0031: Bind Roblox input authorization to process lifetime, not PID alone

## Status

Accepted for production v0.18.4.

## Context

The v0.18.1-v0.18.3 input-readiness chain correctly scoped trust to a Roblox PID and carried that authorization from the Sheet Library into the runtime focus/input boundary. A Windows PID, however, is not a permanent process identity. After a process exits, Windows may later reuse the same numeric PID for a different process instance.

A stale `Confirmed` verdict keyed only by PID could therefore become ambiguous across a sufficiently unlucky Roblox restart/PID-reuse sequence. The normal UI already re-evaluates readiness when Roblox changes, but the runtime input boundary must fail closed independently of UI timing.

## Decision

1. Input readiness stores both the Roblox PID and the process start time in UTC ticks.
2. A health snapshot applies only when the currently running process has the same PID **and** the same start-time identity.
3. Playback launch authorization carries that exact process-lifetime identity into runtime dispatch.
4. Immediately before the runtime focus gate can authorize keyboard dispatch, the current process identity is captured again.
5. Missing authorization, a vanished process, and a same-PID/different-start-time process are distinct deterministic failure classes.
6. PID reuse with a different process start identity fails closed before input dispatch and requires a fresh `Test Roblox Input` confirmation.
7. Readiness remains in-memory only. No process identity or confirmation is persisted across application restarts.
8. No AI or network service participates in identity, readiness, or authorization decisions.

## Safety and compatibility

- Legacy and Legacy x2 playback semantics are unchanged.
- Canonical timeline, MIDI/MusicXML import, sustain, timing, seek/pause/cancellation and release-all ownership are unchanged.
- HWND recreation inside the same Roblox process remains allowed because authorization is process-lifetime scoped, not HWND scoped.
- Roblox Studio and the RobloxPiano client remain excluded from Roblox target discovery.
- If Windows cannot establish the process start identity, readiness cannot become production-confirmed; the client fails closed instead of guessing.

## Regression contract

The published `--input-abi-smoke` must prove:

- a confirmed health snapshot records the current process start identity;
- the same PID with a different start identity does not inherit health;
- exact PID + start identity may authorize playback;
- same-PID process replacement returns `ProcessReplaced`;
- an ended process returns `ProcessEnded`;
- missing/different authorization returns `VerificationRequired`.

This contract protects the final Library -> runtime dispatch boundary against Windows PID reuse without weakening the existing process-scoped focus policy.
