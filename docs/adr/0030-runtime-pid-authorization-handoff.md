# ADR 0030: Carry confirmed Roblox PID authorization into runtime playback

## Status
Accepted

## Context
The Sheet Library already requires process-scoped Roblox input verification before launching playback. It also re-resolves the Roblox target immediately before opening the player. A remaining handoff race existed after that final Library check: `ClientMainForm` independently called `RobloxProcessLocator.FindPreferred()` when playback actually started. If Roblox restarted in that narrow interval, the player could bind to a new PID whose input path had never been confirmed.

Focus safety alone is insufficient for this boundary. A newly discovered Roblox process can be alive and foreground while still having `Unknown` input readiness. The production contract requires the human-confirmed input result to authorize only the exact tested process.

## Decision
Maintain an in-memory playback launch authorization synchronized from deterministic preflight state.

- Only `Confirmed` input health for the exact Roblox PID arms launch authorization.
- Unknown, blocked or absent Roblox state revokes authorization for the affected session.
- `RobloxTargetFocusGate` checks that authorization before every focus/input dispatch decision.
- If the runtime target PID does not match the authorized confirmed PID, the gate fails closed by throwing before keyboard input can be dispatched.
- The existing playback safety/error path then releases owned input and returns control to the Library, where the new PID must pass the existing input check.
- Authorization remains in memory only. It is never persisted and does not depend on AI or network state.

This deliberately keeps the authorization check at the final runtime boundary as defense in depth; Library preflight remains the primary user-facing workflow.

## Consequences
A Roblox restart between Library confirmation and actual playback can no longer inherit stale trust. Replays against the same still-confirmed PID remain allowed. Losing focus still pauses/releases input as before, and Legacy/Legacy x2, MIDI/MusicXML import semantics, canonical timing and held-key ownership are unchanged.
