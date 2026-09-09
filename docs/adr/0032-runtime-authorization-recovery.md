# ADR 0032: Runtime authorization failures return to the Sheet Library

## Status

Accepted for production client v0.18.5.

## Context

Process-lifetime input authorization already fails closed when the verified Roblox process ends, is replaced, or loses the readiness state that authorized playback. The runtime classified those cases as `ProcessEnded`, `ProcessReplaced`, or `VerificationRequired`, but the desktop player still handled them through the same generic `InvalidOperationException` path as unrelated playback failures.

That behavior was safe for input dispatch, but poor client recovery. A normal client could be left inside the player with a generic “try Play again” message even though retrying the same player session could never restore the required process-lifetime verification. The correct recovery surface is the list-first Sheet Library, where Roblox discovery and `Verify Input & Play` already own readiness.

## Decision

Runtime authorization failure is a first-class recoverable desktop condition.

1. `RobloxPlaybackAuthorizationException` remains the typed boundary emitted before unverified input dispatch.
2. The player catches that typed exception before the generic playback error handler.
3. A deterministic recovery policy maps every authorization failure to client-facing guidance:
   - `VerificationRequired`: return to Library and run `Verify Input & Play` again.
   - `ProcessEnded`: return to Library, reopen Roblox, then verify the new process.
   - `ProcessReplaced`: return to Library and verify the replacement process lifetime.
4. Playback cleanup remains authoritative. The transport is disposed and held input is released through the existing safety path before the player closes.
5. The modal player then closes automatically. The existing Library `finally` path becomes visible again, refreshes Roblox discovery and rescans the selected song.
6. No readiness is invented during recovery. The Library independently reevaluates the current process lifetime and exposes `Open Roblox to Play`, `Verify Input & Play`, `Retest Input to Play`, or `Play` from deterministic state.
7. Recovery wording is centralized in `RobloxPlaybackAuthorizationRecoveryPolicy` and covered by a dedicated regression harness required by both production-gate and production-release.

## Consequences

- A Roblox restart during playback no longer looks like a generic engine failure.
- Clients are guided to the only state transition that can safely restore input authorization.
- Player closure cannot bypass release-all or transport disposal.
- The Library remains the owner of verification workflow and launch readiness; the runtime does not mutate truth to make recovery convenient.
- AI, network access and external services remain irrelevant to authorization and recovery.

## Non-goals

- Automatically trusting or automatically verifying a newly started Roblox process.
- Persisting input readiness across application or Roblox restarts.
- Claiming CI can observe live Roblox consumption of synthetic keyboard input.
